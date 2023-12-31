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

document.getElementById('postImage').addEventListener('change', function (e) {
    var file = e.target.files[0];
    var reader = new FileReader();

    reader.onloadend = function () {
        document.getElementById('imagePreview').src = reader.result;
        document.getElementById('imagePreview').style.display = 'block';
    }

    if (file) {
        reader.readAsDataURL(file);
    } else {
        document.getElementById('imagePreview').src = "";
    }
});

// Select all like buttons and like counts
var likeIcons = document.querySelectorAll('.like-icon');
var likeCounts = document.querySelectorAll('#likeCount');

// Add event listener to each like button
likeIcons.forEach((likeIcon, index) => {
    var likeCount = likeCounts[index];

    // Load the like status from local storage
    var postId = likeIcon.getAttribute('data-post-id');
    var hasLiked = localStorage.getItem('likeStatus' + postId);
    if (hasLiked === 'true') {
        likeIcon.style.backgroundImage = 'url("../img/liked.png")';
    } else {
        likeIcon.style.backgroundImage = 'url("../img/like.png")';
    }

    likeIcon.addEventListener('click', function () {
        var action;
        if (likeIcon.style.backgroundImage.includes('like.png')) {
            likeIcon.style.backgroundImage = 'url("../img/liked.png")';
            action = 'add';
            likeCount.textContent = parseInt(likeCount.textContent) + 1;
            // Save the like status to local storage
            localStorage.setItem('likeStatus' + postId, 'true');
        } else {
            likeIcon.style.backgroundImage = 'url("../img/like.png")';
            action = 'subtract';
            likeCount.textContent = parseInt(likeCount.textContent) - 1;
            // Save the like status to local storage
            localStorage.setItem('likeStatus' + postId, 'false');
        }

        // Update using AJAX
        var xhr = new XMLHttpRequest();
        xhr.open('POST', '/post/like/' + postId + '?action=' + action, true);
        xhr.send();
    });
});