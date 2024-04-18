/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.ProdutoPedidoDTO;

/**
 *
 * @author Senai
 */
public class ProdutoPedidoDAO {

    public List<ProdutoPedidoDTO> ler() {
        List<ProdutoPedidoDTO> produtoPedido = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutoPedidoDTO produtopedido = new ProdutoPedidoDTO();
                produtopedido.setId_produto_pedido(rs.getInt("id_produto_pedido"));
                produtopedido.setPedido_id(rs.getInt("pedido_id"));
                produtopedido.setProduto_id(rs.getInt("produto_id"));
                produtopedido.setQuantidade(rs.getInt("quantidade"));
                produtopedido.setPreco_unitario(rs.getFloat("preco_unitario"));
                produtoPedido.add(produtopedido);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return produtoPedido;
    }

    public void inserir(ProdutoPedidoDTO produtopedido) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO pedidos_produtos (pedido_id, produto_id, quantidade, preco_unitario) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, produtopedido.getPedido_id());
            stmt.setInt(2, produtopedido.getProduto_id());
            stmt.setInt(3, produtopedido.getQuantidade());
            stmt.setFloat(4, produtopedido.getPreco_unitario());
            

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
}
