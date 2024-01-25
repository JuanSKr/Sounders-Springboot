package com.sk.sounders.storage;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.stream.Stream;

@Service
public class FileSystemStorageService implements StorageService {

    private final Path rootLocation;

    @Autowired
    public FileSystemStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public String store(MultipartFile file, String nameFile) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("An error has been occurred while uploading this file: " + file.getOriginalFilename());
            }
            //Le he añadido la fecha y hora actual al archivo subido
            nameFile=LocalDateTime.now().toString().replaceAll(":", "_") + "." + FilenameUtils.getExtension(file.getOriginalFilename());
            // Check if the directory exists, if not, create it
            if (!Files.exists(this.rootLocation)) {
                Files.createDirectories(this.rootLocation);
            }
            Files.copy(file.getInputStream(), this.rootLocation.resolve(nameFile), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new StorageException("An error has been occurred while uploading this file: " + file.getOriginalFilename(), e);
        }

        //voy a añadir que devuelva el nombre que le da al archivo
        return nameFile;
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
        } catch (IOException e) {
            throw new StorageException("An error has been ocurred while reading the files", e);
        }

    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException("The file cannot be read: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("The file cannot be read: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void init() {
        try {
            if(!Files.exists(rootLocation)) {
                Files.createDirectory(rootLocation);
            }
        } catch (IOException e) {
            throw new StorageException("Storage cannot be initialised", e);
        }
    }
}
