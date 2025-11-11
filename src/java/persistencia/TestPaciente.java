package persistencia;


import java.util.List;

public class TestPaciente {
    public static void main(String[] args) {
        PacienteRepositorio repo = new PacienteRepositorio();

        Paciente p1 = new Paciente("Erick Arrieta", 20, "Historia", "Estable");
        repo.savePaciente(p1);

        List<Paciente> pacientes = repo.findAllPacientes();
        for (Paciente p : pacientes) {
            System.out.println(p);
        }
    }
}
