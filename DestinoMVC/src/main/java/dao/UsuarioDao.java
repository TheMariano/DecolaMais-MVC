package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Usuarios;

public class UsuarioDao {
	public void create(Usuarios usuario){
		String sql = "insert into Usuarios (nome_usuario, email_usuario, senha_usuario) values (?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getSenha());
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Usuarios> read() {
	    List<Usuarios> usuarios = new ArrayList<Usuarios>();
	    Connection conn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;

	    try {
	        conn = ConnectionMySQL.createConnectionMySQL();
	        String sql = "SELECT * FROM Usuarios";
	        pstm = conn.prepareStatement(sql);
	        rs = pstm.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("id_usuario");
	            String nome = rs.getString("nome_usuario");
	            String email = rs.getString("email_usuario");
	            String senha = rs.getString("senha_usuario");
	            String telefone = rs.getString("telefone_usuario"); 
	            String endereco = rs.getString("endereco_usuario"); 

	            Usuarios usuario = new Usuarios(id, nome, email, senha, telefone, endereco);
	            usuarios.add(usuario);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pstm != null) {
	                pstm.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return usuarios;
	}
	
	public void update(Usuarios usuario) {
	    String sql = "UPDATE Usuarios SET nome_usuario=?, email_usuario=?, senha_usuario=?, telefone_usuario=?, endereco_usuario=? WHERE id_usuario=?";
	    Connection conn = null;
	    PreparedStatement pstm = null;

	    try {
	        conn = ConnectionMySQL.createConnectionMySQL();
	        pstm = conn.prepareStatement(sql);
	        pstm.setString(1, usuario.getNome());
	        pstm.setString(2, usuario.getEmail());
	        pstm.setString(3, usuario.getSenha());
	        pstm.setString(4, usuario.getTelefone());
	        pstm.setString(5, usuario.getEndereco());
	        pstm.setInt(6, usuario.getId());

	        pstm.executeUpdate();
	        System.out.println("Usuário atualizado com sucesso!");
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	    }
	}

	
	public void delete(int id) {
	    String sql = "DELETE FROM Usuarios WHERE id_usuario=?";
	    Connection conn = null;
	    PreparedStatement pstm = null;

	    try {
	        conn = ConnectionMySQL.createConnectionMySQL();
	        pstm = conn.prepareStatement(sql);
	        pstm.setInt(1, id);
	        pstm.executeUpdate();
	        System.out.println("Usuário excluído com sucesso!");
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	    }
	}

	public Usuarios readById(int id) {
	    Usuarios usuario = null;
	    String sql = "SELECT * FROM Usuarios WHERE id_usuario=?";
	    Connection conn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;

	    try {
	        conn = ConnectionMySQL.createConnectionMySQL();
	        pstm = conn.prepareStatement(sql);
	        pstm.setInt(1, id);
	        rs = pstm.executeQuery();

	        if (rs.next()) {
	            String nome = rs.getString("nome_usuario");
	            String email = rs.getString("email_usuario");
	            String senha = rs.getString("senha_usuario");
	            String telefone = rs.getString("telefone_usuario");
	            String endereco = rs.getString("endereco_usuario");

	            usuario = new Usuarios(id, nome, email, senha, telefone, endereco);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	    }

	    return usuario;
	}
}
