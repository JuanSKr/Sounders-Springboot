/* /login alert */

if (document.querySelector('.alert-info')) {
    document.getElementById('redirectAlert').style.display = 'block';
    setTimeout(function () {
        window.location.href = '/login';
    }, 3000);
}

/* Show/Toggle password */

function togglePasswordVisibility(id) {
    var passwordInput = document.getElementById(id);
    var passwordIcon = document.querySelector('.' + id + '-icon');
    if (passwordInput.type === 'password') {
        passwordInput.type = 'text';
        passwordIcon.classList.remove('fas', 'fa-eye');
        passwordIcon.classList.add('fas', 'fa-eye-slash');
    } else {
        passwordInput.type = 'password';
        passwordIcon.classList.remove('fas', 'fa-eye-slash');
        passwordIcon.classList.add('fas', 'fa-eye');
    }
}