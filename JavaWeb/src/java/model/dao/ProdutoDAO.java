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
import model.bean.ProdutoDTO;

/**
 *
 * @author Senai
 */
public class ProdutoDAO {

    public List<ProdutoDTO> ler() {
        List<ProdutoDTO> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutoDTO produto = new ProdutoDTO();
                produto.setId_produto(rs.getInt("id_produto"));
                produto.setCategoria_id(rs.getInt("categoria_id"));
                produto.setNome(rs.getString("nome"));
                produto.setImgBlob(rs.getBytes("imgblob"));
                produto.setValor(rs.getFloat("valor"));
                produtos.add(produto);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return produtos;
    }
    
     public List<ProdutoDTO> lerProdutos(int id) {
        List<ProdutoDTO> produto = new ArrayList<>();
        String sql = "SELECT * FROM produtos WHERE id_produto = ?";
        try {
            Connection connection = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ProdutoDTO objProduto = new ProdutoDTO();
                objProduto.setId_produto(rs.getInt("id_produto"));
                objProduto.setNome(rs.getString("nome"));
                objProduto.setValor(rs.getFloat("valor"));
                objProduto.setCategoria_id(rs.getInt("categoria_id"));
                objProduto.setImgBlob(rs.getBytes("imgBlob"));
                produto.add(objProduto);
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Leitura do Produto: " + e);
        }
        return produto;
    }
    
    public void inserir(ProdutoDTO produto) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO produtos (categoria_id, nome, imgBlob, valor) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, produto.getCategoria_id());        
            stmt.setString(2, produto.getNome());
            stmt.setBytes(3, produto.getImgBlob());
            stmt.setFloat(4, produto.getValor());         

            stmt.executeUpdate();

            stmt.close();
            conexao.close();      

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
}
