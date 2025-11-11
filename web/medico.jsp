<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <title>Registro de Médico</title>
    </head>
    <body>
        <h2>Registrar Médico</h2>

        <form action="MedicoControl" method="post">
            <input type="hidden" name="accion" value="registrar">

            <label>Nombre:</label><br>
            <input type="text" name="nombre" required><br><br>

            <label>Especialidad:</label><br>
            <input type="text" name="especialidad" required><br><br>

            <label>Experiencia (años):</label><br>
            <input type="number" name="experiencia" required><br><br>

            <input type="submit" value="Guardar Médico">
        </form>

        <br>
        <a href="MedicoControl?accion=listar">Ver lista de médicos</a>
    </body>
</html>

