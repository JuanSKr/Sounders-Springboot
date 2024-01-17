/* /login alert */

if (document.querySelector('.alert-info')) {
    document.getElementById('redirectAlert').style.display = 'block';
    setTimeout(function () {
        window.location.href = '/login';
    }, 2000);
}

/* Show/Toggle password */

function togglePasswordVisibility(fieldId) {
    var passwordField = document.getElementById(fieldId);
    var passwordIcon = passwordField.nextElementSibling;

    if (passwordField.type === "password") {
        passwordField.type = "text";
        passwordIcon.classList.remove('fa-eye');
        passwordIcon.classList.add('fa-eye-slash');
    } else {
        passwordField.type = "password";
        passwordIcon.classList.remove('fa-eye-slash');
        passwordIcon.classList.add('fa-eye');
    }
}