/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import modelo.Prenda;

/**
 *
 * @author nataliasabogalrada
 */
public class Nodo {

    private Nodo siguiente;
    private Prenda prenda;

    public Nodo(Prenda prenda) {
        this.prenda = prenda;
        this.siguiente = null;

    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Prenda getPrenda() {
        return prenda;
    }

    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

}
