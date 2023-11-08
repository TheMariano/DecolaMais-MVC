package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionMySQL;
import modelos.Compras;

public class ComprasDao {

    public void create(Compras compra) {
        String sql = "INSERT INTO compra (data_compra, id_usuario, id_destino) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionMySQL.createConnectionMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, compra.getData_compra());
            pstm.setInt(2, compra.getUsuarios().getId());
            pstm.setInt(3, compra.getDestinos().getId());

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Compras> read() {
        List<Compras> compras = new ArrayList<>();
        String sql = "SELECT * FROM compra";
        try (Connection conn = ConnectionMySQL.createConnectionMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_compra");
                String dataCompra = rs.getString("data_compra");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return compras;
    }

    public void update(Compras compra) {
        String sql = "UPDATE compra SET data_compra=?, id_usuario=?, id_destino=? WHERE id_compra=?";
        try (Connection conn = ConnectionMySQL.createConnectionMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, compra.getData_compra());
            pstm.setInt(2, compra.getUsuarios().getId());
            pstm.setInt(3, compra.getDestinos().getId());
            pstm.setInt(4, compra.getId());

            pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM compra WHERE id_compra=?";
        try (Connection conn = ConnectionMySQL.createConnectionMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, id);
            pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Compras readById(int id) {
        Compras compra = null;
        String sql = "SELECT * FROM compra WHERE id_compra=?";
        try (Connection conn = ConnectionMySQL.createConnectionMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String dataCompra = rs.getString("data_compra");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return compra;
    }
}
