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
import model.bean.EstoqueDTO;

/**
 *
 * @author Senai
 */
public class EstoqueDAO {
    public List<EstoqueDTO> ler() {
        List<EstoqueDTO> estoque = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("");
            rs = stmt.executeQuery();

            while (rs.next()) {
                EstoqueDTO objestoque = new EstoqueDTO();
                objestoque.setId_estoque(rs.getInt("id_estoque"));
                objestoque.setProduto_id2(rs.getInt("Produto_id2")); 
                objestoque.setQuantidade_estoque(rs.getInt("quantidade_estoque"));                          
                estoque.add(objestoque);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return estoque;
    }
    
    public void update(EstoqueDTO estoque) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("UPDATE estoque SET quantidade_estoque, produto_id2 WHERE id_estoque = ?");
            stmt.setInt(1, estoque.getQuantidade_estoque());
            stmt.setInt(2, estoque.getProduto_id2());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
}
