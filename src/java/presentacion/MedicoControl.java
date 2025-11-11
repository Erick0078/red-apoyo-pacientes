package presentacion;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

import persistencia.Medico;
import servicio.MedicoServicio;

@WebServlet(name = "MedicoControl", urlPatterns = {"/MedicoControl"})
public class MedicoControl extends HttpServlet {

    private MedicoServicio servicio = new MedicoServicio();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("registrar".equals(accion)) {
            String nombre = request.getParameter("nombre");
            String especialidad = request.getParameter("especialidad");
            int experiencia = Integer.parseInt(request.getParameter("experiencia"));

            Medico medico = new Medico(nombre, especialidad, experiencia);
            servicio.registrarMedico(medico);

            response.sendRedirect("MedicoControl?accion=listar");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("listar".equals(accion)) {
            List<Medico> medicos = servicio.obtenerMedicos();
            request.setAttribute("medicos", medicos);
            request.getRequestDispatcher("ListarMedico.jsp").forward(request, response);
        } else {
            response.sendRedirect("medico.jsp");
        }
    }
}

