package presentacion;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import persistencia.Paciente;
import servicio.PacienteServicio;

@WebServlet(name = "PacienteControl", urlPatterns = {"/PacienteControl"})
public class PacienteControl extends HttpServlet {

    private final PacienteServicio servicio = new PacienteServicio();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("registrar".equals(accion)) {
            String nombre = request.getParameter("nombre");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String historia = request.getParameter("historia_clinica");
            String estado = request.getParameter("estado");

            Paciente p = new Paciente(nombre, edad, historia, estado);
            servicio.registrarPaciente(p);

            List<Paciente> pacientes = servicio.obtenerPacientes();
            request.setAttribute("pacientes", pacientes);
            request.getRequestDispatcher("ListarPacientes.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("listar".equals(accion)) {
            List<Paciente> pacientes = servicio.obtenerPacientes();
            request.setAttribute("pacientes", pacientes);
            request.getRequestDispatcher("ListarPacientes.jsp").forward(request, response);
        }
    }
}