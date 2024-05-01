<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="pt-br">

    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/glider-js@1/glider.min.css">
        <script src="https://kit.fontawesome.com/52a6b206fa.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./style/header.css">
        <title>Home</title>
    </head>

    <body>
        <header>
            <div class="menu">
                <div class="conteudo">
                    <img src="./assets/logo.png" alt="logo-mercado">
                    <input type="text" id="pesquisar" placeholder="Digite o que deseja encontrar...">
                    <i id="lupa" class="fa-solid fa-magnifying-glass"></i>
                    <a class="btn btn-secondary dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                        Minha Conta
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="./usuario-login">Login</a></li>
                        <li><a href="./usuario-cadastro">Cadastro</a></li>
                    </ul>
                </div>
            </div>
            <div class="categoria">
                <a href="#">Destaques</a>
                <a href="#">Bebidas</a>
                <a href="#">Padaria</a>
                <a href="#">Congelados</a>
                <a href="#">Frutas</a>
                <a href="#">Carnes</a>
            </div>
        </header>
        <main>
            <div class="section-best-day">
                <h2>Produtos em Destaque</h2>
                <div class="c-carousel c-carousel--simple">
                    <div class="c-carousel__slides js-carousel--simple d-flex">
                    </div>
                    <div class="carousel-buttons d-flex justify-content-center">
                        <button class="js-carousel--simple-prev btn btn-outline-dark m-2"
                            aria-label="Anterior">«</button>
                        <button class="js-carousel--simple-next btn btn-outline-dark m-2"
                            aria-label="Próximo">»</button>
                    </div>
                </div>
            </div>
            <a href="./ProdutosController">Produtos</a> <br>
            <a href="./CategoriasController">Categorias</a>
        </main>
    </body>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/glider-js@1/glider.min.js"></script>
    <script src="./js/produtos.js"></script>
    <script src="./js/card.js"></script>

    </html>