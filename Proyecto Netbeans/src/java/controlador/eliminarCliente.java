/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import persistencia.ClientePersistencia;

/**
 *
 * @author Jose
 */
@WebServlet(name = "eliminarCliente", urlPatterns = {"/eliminarCliente"})
public class eliminarCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idCliente = request.getParameter("idCliente");
        int id = Integer.parseInt(idCliente);
        //le digo al esquema de persistencia que lo guarde en la BD
        ClientePersistencia clientePersistencia = new ClientePersistencia();
        Cliente clienteLeido = (Cliente) clientePersistencia.leer(id);
        
        clientePersistencia.eliminar(id);
        //ahora que tengo todos los atributos en un objeto, agrego ese objeto al request, almaceno el bean con un id.
        //que despues lo recupero en el jsp
        request.setAttribute("datosCliente", clienteLeido);
        request.setAttribute("mensaje", "Se ha creado una nueva persona con exito");
        //Una vez procesada la infromacion del request redirecciono a otra pagina que muestre los datos, ya que ese solo procesa
        request.getRequestDispatcher("soporte/cliente/exito.jsp").forward(request, response);
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
