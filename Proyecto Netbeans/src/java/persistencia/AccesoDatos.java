/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose
 */
public class AccesoDatos {
    private Statement statment;
    private Connection conexion;
    private int seleccionBaseDatos;
    private static final int derby = 1;
    private static final int MySQL_local = 2;
    private static final int MySQL_OpenShift = 3;
    private static final int MySQL_OpenShift2 = 4;
    
    
    private final String nombreBD_Derby = "jdbc:derby://localhost:1527/CRUD2";
    private final String usuarioBD_Derby = "jose";
    private final String contrasenaBD_Derby = "jose";
    
    private final String nombreBD_MySQL = "jdbc:mysql://localhost:3306/crud2";
    private final String usuarioBD_MySQL = "pepe";
    private final String contrasenaBD_MySQL = "pepe";
    
    private final String nombreBD_MySQL_OpenShift = "xxxx";
    private final String usuarioBD_MySQL_OpenShift = "xxxx";
    private final String contrasenaBD_MySQL_OpenShift = "xxx";
    
    //No anda de forma local pero si en el servidor
    private final String nombreBD_MySQL_OpenShift2 = "jdbc:mysql://127.2.193.130:3306/mytomcatapp2";
    private final String usuarioBD_MySQL_OpenShift2 = "adminZnZfhNW";
    private final String contrasenaBD_MySQL_OpenShift2 = "RD_Ez69-pqI_";
    
    
 


    public AccesoDatos() {
        seleccionBaseDatos = MySQL_local;
    }
    
    
    private void conectarBD(){
        switch (seleccionBaseDatos){
            case derby:
                try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    conexion = DriverManager.getConnection(nombreBD_Derby, usuarioBD_Derby, contrasenaBD_Derby);
                    statment = conexion.createStatement();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE,
                            "No se pudo cargar el driver de la base de datos", ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE,
                            "No se pudo obtener la conexión a la base de datos", ex);
                }
            case MySQL_local:
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conexion = DriverManager.getConnection(nombreBD_MySQL, usuarioBD_MySQL, contrasenaBD_MySQL);
                    statment = conexion.createStatement();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE,
                            "No se pudo cargar el driver de la base de datos", ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE,
                            "No se pudo obtener la conexión a la base de datos", ex);
                }
            case MySQL_OpenShift:
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conexion = DriverManager.getConnection(nombreBD_MySQL_OpenShift, usuarioBD_MySQL_OpenShift, contrasenaBD_MySQL_OpenShift);
                    statment = conexion.createStatement();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE,
                            "No se pudo cargar el driver de la base de datos", ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE,
                            "No se pudo obtener la conexión a la base de datos", ex);
                }
            case MySQL_OpenShift2:
                
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conexion = DriverManager.getConnection(nombreBD_MySQL_OpenShift2, usuarioBD_MySQL_OpenShift2, contrasenaBD_MySQL_OpenShift2);
                    statment = conexion.createStatement();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE,
                            "No se pudo cargar el driver de la base de datos", ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE,
                            "No se pudo obtener la conexión a la base de datos", ex);
                }
        }
                
    }
    
    private  void DesconectarBD() {
        try {
            if (conexion != null) {
                if (statment != null) {
                    statment.close();
                }
                conexion.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE,
                    "No se pudo CERRAR la conexión a la base de datos", ex);
        }
    }
    
    public void ejecutarUpdate (String consulta) throws SQLException{
        try {
            conectarBD();
            statment.executeUpdate(consulta);
            DesconectarBD();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, "Error al ejecutar Update", ex);
            throw ex;
            
        }
        DesconectarBD();
    }
    
     public ResultSet ejecutarConsulta (String consulta){
         try {
            conectarBD();
            ResultSet rs = statment.executeQuery(consulta);
            return rs;
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, "Error al ejecutar Consulta", ex);
        }
        return null;
        
    }
}
