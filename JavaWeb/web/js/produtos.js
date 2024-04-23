let produtos;
let cardProdutos;
//função que cria os cards dos produtos
function criarCardProduto(produtos) {
    const card = document.createElement('div');
    card.classList.add('card-produtos');

    // Converter os bytes da imagem para uma string Base64
    const base64Image = arrayBufferToBase64(produtos.image);
    card.innerHTML = `
        <div class="card rounded border-0 m-2">
            <a class="product-item" id="${produtos.id_produto}" href="#">
                <div class="card-body p-4">
                    <img src="data:image/png;base64,${base64Image}" alt="${produtos.nome}" class="img-fluid d-block mx-auto mb-3">
                    <h5 class="name-product">${produtos.nome}</h5>
                    <div class="price d-flex justify-content-center">
                        <span class="value">R$ ${produtos.valor}</span>
                    </div>
                    <div class="btn-container d-flex justify-content-center m-3">
                        <a href="#" class="btn btn-success" onclick="addToCart(${produtos.id_produto}, '${produtos.nome}', ${produtos.valor},'${base64Image}')">Adicionar ao carrinho</a>
                    </div>
                </div>
            </a>
        </div>
    `;
    return card;
}

// Envia uma solicitação para o backend com os dados do produto
function addToCart(produtosId, produtosNome, produtosValor, produtosImage) {
    const data = {
        produtosId: produtosId,
        produtosNome: produtosNome,
        produtosValor: produtosValor,
        produtosImage: produtosImage,
        produtosQtd: 1
    };
    fetch('./add-product-cart', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro na solicitação: ' + response.status);
            }
            return response.json();
        })
        .then(data => {
            console.log('Resposta do backend:', data);
            return fetch('./cart-itens');
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao obter dados dos produtos');
            }
            return response.json();
        })
        .then(data => {
            loadCartProduct(data);
        })
        .catch(error => {
            console.error('Erro:', error);
        });
}


// Função para converter um array de bytes em uma string Base64
function arrayBufferToBase64(buffer) {
    let binary = '';
    const bytes = new Uint8Array(buffer);
    const len = bytes.byteLength;
    for (let i = 0; i < len; i++) {
        binary += String.fromCharCode(bytes[i]);
    }
    return window.btoa(binary);
}

//função que carregar os cards no carrosel
function loadProductsIntoCarousel(products) {
    const carousel = document.querySelector('.js-carousel--simple');

    carousel.innerHTML = '';

    products.forEach(product => {
        const card = createProductCard(product);
        carousel.appendChild(card);
    });
}

//Acesso aos dados da api
fetch('./list-products')
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao obter dados dos produtos');
        }
        return response.json();
    })
    .then(data => {
        products = data;
        loadProductsIntoCarousel(products);
    })
    .catch(error => {
        console.error(error);
    });