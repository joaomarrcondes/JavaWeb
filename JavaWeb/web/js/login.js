function validacao() {
    let usuario = formlogin.user.value;
    let senha = formlogin.password.value;

    if (usuario.trim() === "") {
        alert("Preencha o Campo Usuário");
        formlogin.user.focus();
        return false;
    }
    else if (senha.trim() === "") {
        alert("Preencha o Campo Senha");
        formlogin.password.focus();
        return false;
    }
}