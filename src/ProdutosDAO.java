/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement stmt;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    /*public ProdutosDAO(Connection conn){
    this.conn = conexao;    
    }*/
    
    public int cadastrarProduto (ProdutosDTO p, Connection conn){
        int status;
        String statusProduto = "a venda";
        try {
        stmt = conn.prepareStatement("INSERT INTO produtos (nome, valor, status) VALUES (?,?,?)");
        stmt.setString(1, p.getNome());
        stmt.setInt(2, p.getValor());
        stmt.setString(3, statusProduto);
        status = stmt.executeUpdate();
        return status;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar.");
            return e.getErrorCode();
        }     
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

