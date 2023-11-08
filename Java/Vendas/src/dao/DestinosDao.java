package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionMySQL;
import modelos.Destinos;

public class DestinosDao {

    public void create(Destinos destino) {
        String sql = "INSERT INTO destinos (cidade_destino, hotel_destino, dias_hotel_destino) VALUES (?,?,?)";

        try (Connection conn = ConnectionMySQL.createConnectionMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, destino.getCidade_destino());
            pstm.setString(2, destino.getHotel_destino());
            pstm.setString(3, destino.getDias_hotel_destino());

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Destinos> read() {
        List<Destinos> destinos = new ArrayList<>();
        String sql = "SELECT * FROM Destinos";

        try (Connection conn = ConnectionMySQL.createConnectionMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_destino");
                String cidade_destino = rs.getString("cidade_destino");
                String hotel_destino = rs.getString("hotel_destino");
                String dias_hotel_destino = rs.getString("dias_hotel_destino");

                Destinos destino = new Destinos(id, cidade_destino, hotel_destino, dias_hotel_destino);
                destinos.add(destino);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return destinos;
    }
}
