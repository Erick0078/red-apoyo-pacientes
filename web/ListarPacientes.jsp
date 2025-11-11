<%@ page import="java.util.*, persistencia.Paciente" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <head>
        <title>Lista de Pacientes</title>
    </head>
    <body>

        <h2>Lista de Pacientes Registrados</h2>

        <%
            List<Paciente> lista = (List<Paciente>) request.getAttribute("pacientes");
            if (lista != null && !lista.isEmpty()) {
        %>
        <table border="1" cellpadding="5" cellspacing="0">
            <tr>
                <th>Nombre</th>
                <th>Edad</th>
                <th>Historia Clínica</th>
                <th>Estado</th>
            </tr>
            <%
                for (Paciente p : lista) {
            %>
            <tr>
                <td><%= p.getNombre()%></td>
                <td><%= p.getEdad()%></td>
                <td><%= p.getHistoriaClinica()%></td>
                <td><%= p.getEstado()%></td>
            </tr>
            <%
                }
            %>
        </table>
        <%
        } else {
        %>
        <p style="text-align:center;">No hay pacientes registrados.</p>
        <%
            }
        %>

        <br>
        <a href="paciente.jsp">← Volver al registro</a>

    </body>
</html>
