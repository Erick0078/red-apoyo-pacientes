<%@ page import="java.util.*, persistencia.Medico" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <head>
        <title>Lista de Médicos</title>
    </head>
    <body>

        <h2>Lista de Médicos Registrados</h2>

        <%
            List<Medico> lista = (List<Medico>) request.getAttribute("medicos");
            if (lista != null && !lista.isEmpty()) {
        %>
        <table border="1" cellpadding="5" cellspacing="0">
            <tr>
                <th>Nombre</th>
                <th>Especialidad</th>
                <th>Experiencia (años)</th>
            </tr>
            <%
                for (Medico m : lista) {
            %>
            <tr>
                <td><%= m.getNombre()%></td>
                <td><%= m.getEspecialidad()%></td>
                <td><%= m.getExperiencia()%></td>
            </tr>
            <%
                }
            %>
        </table>
        <%
        } else {
        %>
        <p style="text-align:center;">No hay médicos registrados.</p>
        <%
            }
        %>

        <br>
        <a href="medico.jsp">← Volver al registro</a>

    </body>
</html>

