$(function () {
    $("#reg").validate({
        rules: {
            fullname: {
                required: true,
                minlength: 3
            },
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 3
            },
            password2: {
                required: true,
                equalTo: "#password",
                minlength: 3
            }
        },
            messages: {
                fullname: {
                    required: "Поле обязательно для заполнения",
                    minlength: "Поле должно содержать не менее трех символов"
                },
                email: {
                    required: "Поле обязательно для заполнения",
                    email: "Введенный e-mail некорректен",
                    minlength: "Поле должно содержать не менее трех символов"
                },
                password: {
                    required: "Поле обязательно для заполнения",
                    minlength: "Поле должно содержать не менее трех символов"
                },
                password2:{
                    required: "Поле обязательно для заполнения",
                    equalTo: "Пароли должны совпадать",
                    minlength: "Поле должно содержать не менее трех символов"
                }

        },
        focusCleanup: true,
        focusInvalid: false

    });
});
