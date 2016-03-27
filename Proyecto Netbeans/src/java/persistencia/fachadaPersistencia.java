/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author Jose
 */
public interface fachadaPersistencia {
    
    public boolean crear (Object objeto);
    
    public boolean eliminar (Object objeto);
    
    public Object leer (Object clavePrimaria);
    
    public Object listar ();
    
    public boolean Actualizar (Object objeto, int clavePrimaria);


}
