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
import model.bean.PedidoDTO;

/**
 *
 * @author Senai
 */
public class PedidoDAO {

    public List<PedidoDTO> ler() {
        List<PedidoDTO> pedidos = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("");
            rs = stmt.executeQuery();

            while (rs.next()) {
                PedidoDTO pedido = new PedidoDTO();
                pedido.setId_pedido(rs.getInt("id_pedido"));
                pedido.setUsuario_id2(rs.getInt("usuario_id2")); 
                pedido.setStatus_pagamento(rs.getString("status_pagamento"));
                pedido.setMetodo_pagamento(rs.getString("metodo_pagamento"));
                pedido.setValor_total(rs.getFloat("valor_total"));
                pedido.setData_hora(rs.getString("data_hora"));             
                pedidos.add(pedido);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return pedidos;
    }

    public void inserir(PedidoDTO pedido) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO pedidos (usuario_id2, status_pagamento, metodo_pagamento, valor_total, data_hora) VALUES (?, ?, ?, ?, NOW())");
            stmt.setInt(1, pedido.getUsuario_id2());        
            stmt.setString(2, pedido.getStatus_pagamento());
            stmt.setString(3, pedido.getMetodo_pagamento());
            stmt.setFloat(4, pedido.getValor_total());
            stmt.setString(5, pedido.getData_hora());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();        
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
}
