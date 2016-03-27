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
@WebServlet(name = "actualizarCliente", urlPatterns = {"/actualizarCliente"})
public class actualizarCliente extends HttpServlet {

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
        //creo el modelo a partir de la soliciud
        Cliente cliente = generarClienteDesdeSolicitud(request);
        //obtengo el id 
        String idCliente = request.getParameter("idCliente");
        int id = Integer.parseInt(idCliente);
        //le digo al esquema de persistencia que lo guarde en la BD
        ClientePersistencia clientePersistencia = new ClientePersistencia();
        clientePersistencia.Actualizar(cliente, id);
        //ahora que tengo todos los atributos en un objeto, agrego ese objeto al request, almaceno el bean con un id.
        //que despues lo recupero en el jsp
        request.setAttribute("datosCliente", cliente);
        request.setAttribute("mensaje", "Se ha actualizado los datos persona con exito");
        //Una vez procesada la infromacion del request redirecciono a otra pagina que muestre los datos, ya que ese solo procesa
        request.getRequestDispatcher("soporte/cliente/exito.jsp").forward(request, response);
    }
    
    //COMO ABSTRAER PARA NO COPIAR EL CODIGO 2 VECES?
    private  Cliente generarClienteDesdeSolicitud (HttpServletRequest request){
        //tomo los atributos de request y se los asigno al modelo
        String nombreCliente = request.getParameter("nombreCliente");
        String telefonoCliente = request.getParameter("telefonoCliente");
        //valido los datos que sean correctos
        if (valiadarNombre(nombreCliente)) {
            //como le aviso a la vista que hay un error en el nombre?
            return null;
        }
        if (valiarNumeroTelefono(telefonoCliente)) {
            //como le aviso a la vista que hay un error en el telefono?
            return null;
        }
        int numeroTelefono = Integer.parseInt(telefonoCliente);
        return new Cliente(nombreCliente, numeroTelefono);      
    }
    
    //nose si esto es logica de negocio y donde deberia ir aca o en el modelo
    private boolean valiadarNombre(String name) {
        String namePattern = "[A-Z]([a-zA-ZñÑáéíóúÁÉÍÓÚ ])*";
        return name.matches(namePattern);
    }
    
    private boolean valiarNumeroTelefono(String phone) {
        boolean isGoodLength = checkLength(phone, 9, 15);
        return phone.matches("([0-9  +])*") && isGoodLength;
    }
    
    private boolean checkLength(String data, int minAceptable, int maxAceptable) {
        int length = data.length();
        boolean isGoodLength = length >= minAceptable && length <= maxAceptable;
        return isGoodLength;
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
