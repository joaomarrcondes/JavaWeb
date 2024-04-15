<%-- Document : login Created on : 15/04/2024, 14:04:40 Author : Senai --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <script src="https://kit.fontawesome.com/2283da70d2.js" crossorigin="anonymous"></script>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Tela de Login</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">
            <link rel="stylesheet" href="./../style/login.css">
        </head>

        <body>
            <main>
                <form name="formlogin" action="login">
                    <div class="caixa-login">
                        <h1>TELA DE LOGIN</h1>
                        <h2>Usuário</h2>
                        <div class="input-group flex-nowrap">
                            <span class="input-group-text" id="addon-wrapping"><i
                                    class="fa-solid fa-user-large"></i></span>
                            <input name="user" type="text" class="form-control" placeholder="Username">
                        </div>

                        <h2>Senha</h2>
                        <div class="input-group flex-nowrap">
                            <span class="input-group-text" id="addon-wrapping"><i class="fa-solid fa-lock"></i></span>
                            <input name="password" type="password" id="inputPassword5" class="form-control" placeholder="Password">
                        </div>
                        <input type="button" class="btn btn-dark" value="Entrar" onclick="validacao()">
                    </div>
                </form>
            </main>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
                integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
                crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
                integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
                crossorigin="anonymous"></script>
            <script src="./js/login.js"></script>
        </body>

        </html>