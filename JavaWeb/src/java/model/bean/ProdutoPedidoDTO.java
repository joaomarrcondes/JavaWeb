/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Senai
 */
public class ProdutoPedidoDTO {

    private int id_produto_pedido;
    private int pedido_id;
    private int produto_id;
    private int quantidade;
    private float preco_unitario;

    public ProdutoPedidoDTO() {
    }

    public ProdutoPedidoDTO(int id_produto_pedido, int pedido_id, int produto_id, int quantidade, float preco_unitario) {
        this.id_produto_pedido = id_produto_pedido;
        this.pedido_id = pedido_id;
        this.produto_id = produto_id;
        this.quantidade = quantidade;
        this.preco_unitario = preco_unitario;
    }

    public int getId_produto_pedido() {
        return id_produto_pedido;
    }

    public void setId_produto_pedido(int id_produto_pedido) {
        this.id_produto_pedido = id_produto_pedido;
    }

    public int getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(int pedido_id) {
        this.pedido_id = pedido_id;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(float preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

   

}
