package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class InterfazServlets extends HttpServlet {
    
    /*
        InterfazServlets también definen dos métodos de utilidad para redirigir una petición a un
Servlet (gotoNamedResource) o a una página HTML o JSP (gotoURL). Estos métodos
de utilidad, que van a heredar sus hijos, permiten redirigir la petición en una única
sentencia, sin necesidad de crear el RequestDispatcher adecuado para cada caso.
MyCoolServlet define un método abstracto (processRequest) y sobre escribe los
métodos doGet y doPost de tal modo que redirigen las peticiones que les llegan al
método abstracto. De este modo evitaremos sobrescribir estos dos métodos en todos los
Servlets de la aplicación (como hemos hecho a lo largo de todo este tutorial en cada uno
de los Servlets... copiar y pegar es malo pero hasta ahora quería que cada ejemplo fuese
autocontenido). Este es el código de MyCoolServlet:
    */

    protected String errorForm = null;
    protected String displayForm = null;
    protected String successForm = null;
    protected String crearCliente = null;
    protected String deleteServlet = null;
    protected String updateServlet = null;
    protected String readServlet = null;
    protected String persistenceMechanism = null;

    protected abstract void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected void gotoNamedResource(String address, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getNamedDispatcher(address);
        dispatcher.forward(request, response);
    }

    protected void gotoURL(String address, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    public void init() {
        ServletConfig config = getServletConfig();
        ServletContext context = config.getServletContext();
        displayForm = context.getInitParameter("displayForm");
        errorForm = context.getInitParameter("errorForm");
        successForm = context.getInitParameter("successForm");
        crearCliente = context.getInitParameter("crearCliente");
        deleteServlet = context.getInitParameter("deleteServlet");
        readServlet = context.getInitParameter("readServlet");
        updateServlet = context.getInitParameter("updateServlet");
        persistenceMechanism = context.getInitParameter("persistenceMechanism");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
