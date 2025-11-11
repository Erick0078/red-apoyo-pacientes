package persistencia;

import accesodatos.Bd;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PacienteRepositorio {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/hospcapas";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "123456";

    public PacienteRepositorio() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void savePaciente(Paciente paciente) {
        String sql = "INSERT INTO pacientes (nombre, edad, historia_clinica, estado) VALUES (?, ?, ?, ?)";
        try {
            Bd conexion = new Bd(DB_URL, DB_USER, DB_PASSWORD);
            Connection conn = conexion.getConn();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, paciente.getNombre());
            stmt.setInt(2, paciente.getEdad());
            stmt.setString(3, paciente.getHistoriaClinica());
            stmt.setString(4, paciente.getEstado());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al guardar paciente: ");
        }
    }

    public List<Paciente> findAllPacientes() {
        List<Paciente> lista = new LinkedList<>();
        String sql = "SELECT * FROM pacientes";

        try {
            Bd conexion = new Bd(DB_URL, DB_USER, DB_PASSWORD);
            Connection conn = conexion.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                String historiaClinica = rs.getString("historia_clinica");
                String estado = rs.getString("estado");
                lista.add(new Paciente(nombre, edad, historiaClinica, estado));
            }

            rs.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al listar pacientes");
        }
        return lista;
    }
}
