package servicio;

import persistencia.Paciente;
import persistencia.PacienteRepositorio;
import java.util.List;

public class PacienteServicio {

    private PacienteRepositorio repo;

    public PacienteServicio() {
        repo = new PacienteRepositorio();
    }

    public void registrarPaciente(Paciente paciente) {
        if (paciente != null && 
            paciente.getNombre() != null && 
            paciente.getEdad() > 0 && 
            paciente.getHistoriaClinica() != null) {

            repo.savePaciente(paciente);
        } else {
            throw new IllegalArgumentException("Datos del paciente inválidos");
        }
    }

    public List<Paciente> obtenerPacientes() {
        return repo.findAllPacientes();
    }
}

