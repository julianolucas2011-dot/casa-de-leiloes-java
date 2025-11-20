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

    public int cadastrarProduto(ProdutosDTO p, Connection conn) {
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

    public ArrayList<ProdutosDTO> listarProdutos(Connection conn) {
        ArrayList<ProdutosDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try ( PreparedStatement stmt = conn.prepareStatement(sql)) {

            try ( ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    ProdutosDTO produto = new ProdutosDTO();

                    produto.setId(rs.getInt("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setValor(rs.getInt("valor"));
                    produto.setStatus(rs.getString("status"));

                    lista.add(produto);
                }
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
            return null;
        }

        return lista;
    }

}
