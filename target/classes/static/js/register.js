if (document.querySelector('.alert-info')) {
    document.getElementById('redirectAlert').style.display = 'block';
    setTimeout(function () {
        window.location.href = '/login';
    }, 3000);
}