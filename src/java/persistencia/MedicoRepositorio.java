package persistencia;

import accesodatos.Bd;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MedicoRepositorio {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/hospcapas";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "123456";

    public MedicoRepositorio() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveMedico(Medico medico) {
        String sql = "INSERT INTO medicos (nombre, especialidad, experiencia) VALUES (?, ?, ?)";
        try {
            Bd conexion = new Bd(DB_URL, DB_USER, DB_PASSWORD);
            Connection conn = conexion.getConn();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, medico.getNombre());
            stmt.setString(2, medico.getEspecialidad());
            stmt.setInt(3, medico.getExperiencia());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al guardar médico: " + e.getMessage());
        }
    }

    public List<Medico> findAllMedicos() {
        List<Medico> lista = new LinkedList<>();
        String sql = "SELECT * FROM medicos";

        try {
            Bd conexion = new Bd(DB_URL, DB_USER, DB_PASSWORD);
            Connection conn = conexion.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String especialidad = rs.getString("especialidad");
                int experiencia = rs.getInt("experiencia");
                lista.add(new Medico(nombre, especialidad, experiencia));
            }

            rs.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al listar médicos: " + e.getMessage());
        }
        return lista;
    }
}
