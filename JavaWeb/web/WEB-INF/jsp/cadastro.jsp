<%-- Document : cadastro Created on : 15/04/2024, 14:28:33 Author : Senai --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Tela de Cadastro</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">
        </head>

        <body>
            <main>
                <form name="formcadastro" action="cadastro">
                    <h1>TELA DE CADASTRO</h1>
                    <h3>Usuário</h3>
                    <input type="text" class="form-control" placeholder="">
                    <h3>Senha</h3>
                    <input type="password" id="inputPassword6" class="form-control">
                    <h3>Nome</h3>
                    <input type="text" class="form-control" placeholder="">
                    <h3>Telefone</h3>
                    <input type="tel" class="form-control" placeholder="">
                    <h3>Data Nascimento</h3>
                    <input type="date" class="form-control" placeholder="">
                    <h3>Cpf</h3>
                    <input type="text" class="form-control" placeholder=""> <br>
                    <input class="btn btn-primary" type="submit" value="Enviar">
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
        </body>

        </html>