
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    public Connection conectar(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11?useSSL=false","root","@Kaua1415");
            return conn;
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Impossivel se conectar ao Banco de Dados");
            return null;
        }
    }
    
}
