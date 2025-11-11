<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <title>Registro de Paciente</title>
    </head>
    <body>
        <h2>Registrar Paciente</h2>

        <form action="PacienteControl" method="post">
            <input type="hidden" name="accion" value="registrar">

            <label>Nombre:</label><br>
            <input type="text" name="nombre" required><br><br>

            <label>Edad:</label><br>
            <input type="number" name="edad" required><br><br>

            <label>Historia Clínica:</label><br>
            <input type="text" name="historia_clinica" required><br><br>

            <label>Estado:</label><br>
            <input type="text" name="estado" required><br><br>

            <input type="submit" value="Guardar Paciente">
        </form>

        <br>
        <a href="PacienteControl?accion=listar">Ver lista de pacientes</a>
    </body>
</html>


