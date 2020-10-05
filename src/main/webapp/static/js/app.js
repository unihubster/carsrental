function emailCheck() {
    if ($("#email").val() === "") {
        $("#email").addClass("is-invalid");
        return false;
    } else {
        var regMail = /^([_a-zA-Z0-9-]+)(\.[_a-zA-Z0-9-]+)*@([a-zA-Z0-9-]+\.)+([a-zA-Z]{2,3})$/;
        if (regMail.test($("#email").val()) === false) {
            $("#email").addClass("is-invalid");
            return false;
        } else {
            $("#email").removeClass("is-invalid");
            $("#next-form").collapse("show");
        }
    }
}

function validation() {
    let p = document.getElementById('cp');
    if ($("#password").val() !== $("#cpassword").val()) {
        p.style.visibility = "visible";
        return false;
    } else {
        p.style.visibility = 'hidden';
        return true;
    }
}

(function () {
    'use strict'

    window.addEventListener('load', function () {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        const forms = document.getElementsByClassName('needs-validation');

        // Loop over them and prevent submission
        Array.prototype.filter.call(forms, function (form) {
            form.addEventListener('submit', function (event) {
                if (form.checkValidity() === false || validation() === false) {
                    event.preventDefault()
                    event.stopPropagation()
                }
                form.classList.add('was-validated')
            }, false)
        })
    }, false)
}())