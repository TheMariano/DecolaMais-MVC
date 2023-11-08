package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
    private static String URL = "jdbc:mysql://localhost:3306/decolamais";
    private static String USUARIO = "root";
    private static String SENHA = "root";

    public static Connection createConnectionMySQL() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
        return connection;
    }

    public static void main(String[] args) {
        Connection con = null;
        try {
            con = createConnectionMySQL();

            if (con != null) {
                System.out.println(con + "\n\n *** Conexão obtida com sucesso! ***");
                con.close();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver do MySQL não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        } finally {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
