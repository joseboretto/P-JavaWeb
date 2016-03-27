/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;

/**
 *
 * @author Jose
 */
public class ClientePersistencia implements fachadaPersistencia{
    private AccesoDatos accesoDatos;

    public ClientePersistencia() {
        accesoDatos = new AccesoDatos();
    }
    

    @Override
    public boolean crear(Object objeto) {
        //el objeto debe ser un cliente en este caso, como lo cambio en el parametro
        Cliente cliente = (Cliente) objeto;
        //se encarga de armar la consulta
        String consulta = "INSERT INTO CLIENTE VALUES (default,'"+cliente.getNombre()+"',"+cliente.getNumeroTelefono()+")";        
        try {
            accesoDatos.ejecutarUpdate(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(ClientePersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
        
    }

    @Override
    public boolean eliminar(Object clavePrimaria) {
        String consulta = "DELETE FROM CLIENTE WHERE cliente_id="+clavePrimaria;
        try {
            accesoDatos.ejecutarUpdate(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(ClientePersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public Object leer(Object clavePrimaria) {
        String consulta = "SELECT * FROM CLIENTE WHERE cliente_id="+clavePrimaria;
        ResultSet resultado = accesoDatos.ejecutarConsulta(consulta);
        try {
            if (!resultado.next()){}
            //No user found.     
            else {
                Cliente cliente = new Cliente(resultado.getString(2), resultado.getInt(3));
                return cliente;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientePersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Cliente("nulo", 5);
    }
    @Override
    public boolean Actualizar (Object objeto, int clavePrimaria) {
        //el objeto debe ser un cliente en este caso, como lo cambio en el parametro
        Cliente cliente = (Cliente) objeto;
        //se encarga de armar la consulta     
        String consulta = "UPDATE CLIENTE SET nombre='"+ cliente.getNombre()+"',numeroTelefono="+cliente.getNumeroTelefono();    
        consulta += " WHERE cliente_id=" + clavePrimaria;
        
        try {
            accesoDatos.ejecutarUpdate(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(ClientePersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    
    }

    @Override
    public Object listar() {
        //se encarga de armar la consulta
        String consulta = "SELECT * FROM CLIENTE";        
        return accesoDatos.ejecutarConsulta(consulta);
        
    }
    
}
