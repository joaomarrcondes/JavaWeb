function validacao() {
    let user = formlogin.user.value;
    let password = formlogin.password.value;

    if (user.trim() === "") {
        alert("Preencha o Campo Usuário");
        formlogin.user.focus();
        return false;
    } else if (password.trim() === "") {
        alert("Preencha o Campo Senha");
        formlogin.password.focus();
        return false;
    } else if (users && users.some(item => item.user !== user) || users && users.some(item => item.password !== password)) {
        alert("Usuario ou Senha Incorretos!");
        formlogin.user.focus();
        formlogin.password.focus();
        return false;
    }
    document.forms["formlogin"].submit();
}
let users;
fetch('./users')
        .then(response => {
            if (!response.ok) {
                throw new Error('erro ao obter dados do usuario');
            }
            return response.json();
        })
        .then(data => {
            users = data;
            console.log(users);
        })
        .catch(error => {
            console.error(error);
        });