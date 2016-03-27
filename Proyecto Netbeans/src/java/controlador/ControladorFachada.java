package controlador;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
//con esto le decimos la url para acceder al servlet, tambien se puede hacer con el descriptor de despliegue
@WebServlet(name="ControladorFachada", urlPatterns={"/ControladorFachada"})
public class ControladorFachada extends InterfazServlets {
    /*
        Todas las peticiones que llegan a la aplicación llegan a través de un único Servlet con
nombre FrontController. El nombre viene de otro patrón de diseño: el Front Controller.
De un modo muy simple, este patrón consiste en hacer que todas las peticiones de la
aplicación pasen por un controlador frontal. Esto tiene la ventaja de que es muy simple
introducir en este controlador frontal requerimientos de la aplicación transversales a la
lógica de negocio, como autorización, a autenticación, logging... así como cambiar el
flujo de navegación de la aplicación.
    */

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ControladorFachada.class.getName()).log(Level.SEVERE,
                    "No se pudo establecer el encoding", ex);
        }
        String form = request.getParameter("form");
        if (form == null || (persistenceMechanism != null
                && persistenceMechanism.equals("none"))) {
            gotoURL(errorForm, request, response);
        } else if (form.equals("errorForm")) {
            gotoNamedResource(errorForm, request, response);
        } else if (form.equals("crearCliente")) {
            gotoNamedResource(crearCliente, request, response);
        } else if (form.equals("updateServlet")) {
            gotoNamedResource(updateServlet, request, response);
        } else if (form.equals("deleteServlet")) {
            gotoNamedResource(deleteServlet, request, response);
        } else if (form.equals("readServlet")) {
            gotoNamedResource(readServlet, request, response);
        } else {
            gotoURL(errorForm, request, response);
        }
    }
}
