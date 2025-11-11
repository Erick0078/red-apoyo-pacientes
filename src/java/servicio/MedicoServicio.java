package servicio;

import persistencia.Medico;
import persistencia.MedicoRepositorio;
import java.util.List;

public class MedicoServicio {

    private MedicoRepositorio repo;

    public MedicoServicio() {
        repo = new MedicoRepositorio();
    }

    public void registrarMedico(Medico medico) {
        if (medico != null && 
            medico.getNombre() != null && 
            medico.getEspecialidad() != null &&
            medico.getExperiencia() >= 0) {

            repo.saveMedico(medico);
        } else {
            throw new IllegalArgumentException("Datos del médico inválidos");
        }
    }

    public List<Medico> obtenerMedicos() {
        return repo.findAllMedicos();
    }
}
