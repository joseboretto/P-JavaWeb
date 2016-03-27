/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jose
 */
public class Cliente {
    private String nombre;
    private long numeroTelefono ;

    public Cliente(String nombre, long numeroTelefono) {
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public long getNumeroTelefono() {
        return numeroTelefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", numeroTelefono=" + numeroTelefono + '}';
    }

    
     
}
