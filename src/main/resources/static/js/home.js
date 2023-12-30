const toggler = document.querySelector(".btn");
const brand = document.querySelector(".navbar-brand-collapsed");
const navbarItems = document.querySelector(".navbar-items");
const soundersNavbarCenter = document.querySelector("#sounders-navbar-center");

if (sidebar.classList.contains("collapsed")) {
    brand.style.display = "inline";
    navbarItems.style.display = "flex";
    soundersNavbarCenter.style.display = "none";
} else {
    brand.style.display = "none";
    navbarItems.style.display = "none";
    soundersNavbarCenter.style.display = "inline";
}

toggler.addEventListener("click", function () {
    const sidebar = document.querySelector("#sidebar");
    sidebar.classList.toggle("collapsed");
    if (sidebar.classList.contains("collapsed")) {
        brand.style.display = "inline";
        navbarItems.style.display = "flex";
        soundersNavbarCenter.style.display = "none";
    } else {
        brand.style.display = "none";
        navbarItems.style.display = "none";
        soundersNavbarCenter.style.display = "inline";
    }
});

document.querySelector('.publish').addEventListener('click', function () {
    var postModal = new bootstrap.Modal(document.getElementById('postModal'));
    postModal.show();
});

document.querySelector('.publish-sidebar').addEventListener('click', function () {
    var postModal = new bootstrap.Modal(document.getElementById('postModal'));
    postModal.show();
});

document.getElementById('postImage').addEventListener('change', function(e) {
    var file = e.target.files[0];
    var reader = new FileReader();

    reader.onloadend = function() {
        document.getElementById('imagePreview').src = reader.result;
        document.getElementById('imagePreview').style.display = 'block';
    }

    if (file) {
        reader.readAsDataURL(file);
    } else {
        document.getElementById('imagePreview').src = "";
    }
});