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

// Username and bio counter

document.getElementById('name').addEventListener('input', function () {
    document.getElementById('nameCount').textContent = this.value.length + "/20";
});

document.getElementById('bio').addEventListener('input', function () {
    document.getElementById('bioCount').textContent = this.value.length + "/100";
});

