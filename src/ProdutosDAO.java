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
import java.util.ArrayList;
import java.sql.SQLException;


public class ProdutosDAO {
    Connection conn;
    conectaDAO conect;
    PreparedStatement stmt;
    ResultSet rs;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public ProdutosDAO() {
        this.conect = new conectaDAO();
        conn = this.conect.conectar();
    }
    
    
    
    public void cadastrarProduto (ProdutosDTO produto){
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getValor());
            stmt.setString(3, produto.getStatus());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar produto");
        }

    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        String sql = "SELECT * FROM produtos";
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                ProdutosDTO p = new ProdutosDTO();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getInt("valor"));
                p.setStatus(rs.getString("status"));
                listagem.add(p);
            }
            
        }catch(SQLException sqle){
            System.out.println("erro na listagem");
        }
       
        return listagem;
    }
    
    public void venderProduto(int id){
        String sql = "UPDATE produtos SET status = ? WHERE id = ?";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "Vendido");
            stmt.setInt(2, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Venda concluída");
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Erro ao concluir venda");
        }
    }
    
    public ArrayList listarProdutosVendidos(){
        
    }
    
    
    
        
}

