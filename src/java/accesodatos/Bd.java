package accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bd {

    private Connection conn;

    public Bd() {
    }

    public Bd(String DB_URL, String DB_USER, String DB_PASSWORD) throws SQLException {
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public Connection getConn() {
        return conn;
    }

    public static void main(String[] args) {
        String DB_URL = "jdbc:postgresql://localhost:5432/hospcapas";
        String DB_USER = "postgres";
        String DB_PASSWORD = "123456";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Conexión exitosa a la base de datos HospCapas");
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Error");
        } catch (SQLException e) {
            System.out.println("Error al conectar");
        }
    }
}
