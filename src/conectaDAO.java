
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Adm
 */
public class conectaDAO {

    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;

    String url = "jdbc:mysql://localhost:3306/uc11?useSSL=false";
    String user = "root";
    String password = "99228688";

    public Connection connectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("conectado");
            return conn;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao conectar");
            return null;
        }
    }

}
