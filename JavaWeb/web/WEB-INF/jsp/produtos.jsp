<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">      
        <title>Produtos</title>
    </head>

    <body>
        <h1>Produto</h1>
        <form action="CadastroController" enctype="multipart/form-data" method="post">
            <span>Imagem</span>
            <input type="file" name="imagem" class="form-control" placeholder="Carregue a imagem" aria-label="Username"
                aria-describedby="basic-addon1">
            <span>Nome</span>
            <input type="text" name="nome" class="form-control" placeholder="Nome do produto" aria-label="Username"
                aria-describedby="basic-addon1">
            <span>Valor</span>
            <input type="text" name="valor" class="form-control" placeholder="Valor do produto" aria-label="Username"
                aria-describedby="basic-addon1">
            <span>Categoria</span>
            <input type="text" name="categoria" class="form-control" placeholder="Categoria do produto"
                aria-label="Username" aria-describedby="basic-addon1">
            <input type="submit" value="ENVIAR">
        </form>
    </body>

    </html>