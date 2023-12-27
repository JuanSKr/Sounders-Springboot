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

document.querySelectorAll('.like-button').forEach(button => {
    button.addEventListener('click', function () {
        const img = this.querySelector('img');
        if (img.src.endsWith('/img/like.png')) {
            img.src = '/img/like_hover.png';
        } else {
            img.src = '/img/like.png';
        }
    });
});