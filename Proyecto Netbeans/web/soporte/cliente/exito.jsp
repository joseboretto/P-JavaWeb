<%-- 
    Document   : exitoCrearPersona
    Created on : Jan 10, 2016, 1:23:19 AM
    Author     : Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="/menuBootstrap.jspf" %>

        <!-- En tomcat para usar el bean es type-->
        <!-- En Glassfish para usar el bean es class-->
        <jsp:useBean id="datosCliente" scope="request" type="modelo.Cliente" />
        <jsp:useBean id="mensaje" scope="request" type="String" />
        <h1>Exito</h1>
        <hr style="width: 100%; color: black; height: 1px; background-color:black;" /> 
        <p>  <%= mensaje %> </p>
        <ul>
            
            <li>  <%= datosCliente.toString() %> </li>
            
            
        </ul>
    
    </body>
</html>
