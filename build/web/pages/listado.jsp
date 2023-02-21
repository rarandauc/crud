<%--
    Document   : listado
    Created on : 25-nov-2014, 21:27:07
    Author     : admin
--%>

<%@page import="Dtos.ProfesorDTO"%>
<%@page import="java.util.LinkedList"%>
<%@page import="modelo.daos.ProfesorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de profesores</title>
    </head>
    <body>
        <h1>Muestra el listado de profesores</h1>

        <%
            ProfesorDAO pdao = new ProfesorDAO();
            LinkedList<ProfesorDTO> lista = new LinkedList<ProfesorDTO>();
            lista = (LinkedList<ProfesorDTO>) pdao.getAll();

        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nombre docente</th>
                    <th>Email</th>
                    <th>user</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (ProfesorDTO p : lista) {

                %>
                <tr>
                    <td><%=p.getClaveProfesor()%></td>
                    <td><%=p.getNombreCompleto()%></td>
                    <td><%=p.getCorreoElectronico()%></td>
                    <td><%=p.getUserName()%></td>
                </tr>
                <%
                        }%>

            </tbody>
        </table>

                        <br> Actividades:

<ol type="a">
    <li>Colocar estilo a la tabla</li>
 <li>adicionar las acciones eliminar y modificar a la tabla</li>
 <li> Si un rol solo tiene permiso para modificar, como evitamos la otra columna?</li>
 <li> Realizar una función en la BD que saque el username partiendo de las iniciales de los nombres apellidos</li>

</ol>

    </body>
</html>
