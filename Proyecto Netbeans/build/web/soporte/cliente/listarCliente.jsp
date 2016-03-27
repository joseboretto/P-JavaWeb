<%-- 
    Document   : listarCliente
    Created on : Jan 11, 2016, 7:33:12 PM
    Author     : Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="/menuBootstrap.jspf" %>

        <jsp:useBean id="resultado" scope="request"  type="java.sql.ResultSet" />
        <h1>Lista de Clientes</h1>
        
        <table  class="table" border="1" style="width:100% ; text-align: center">
            <thead style="background-color: #D8D8D8" >
            <th>ID cliente</th>
                <th>Nombre</th> 
                <th>Numero</th>
            </thead>    
        <%
            if (resultado != null) {

                    while (resultado.next()) {
        %>
        <tbody>
                                <td> <%= resultado.getInt(1)%> </td>
                                <td> <%= resultado.getString(2)%> </td>
                                <td> <%= resultado.getInt(3)%> </td>
        </tbody>                        
        <%          }
            }
        %>
        </table>
    </body>
</html>
