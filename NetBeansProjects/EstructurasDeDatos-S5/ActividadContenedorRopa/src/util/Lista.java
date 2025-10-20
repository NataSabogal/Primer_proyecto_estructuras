/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;

/**
 *
 * @author nataliasabogalrada
 */
public class Lista<S> implements ILista<S>, Serializable {

    private Nodo<S> primero;
    private int size;

    public Lista() {
        this.primero = null;
        this.size = 0;
    }

    @Override
    public void add(S dato) {
        Nodo<S> nuevo = new Nodo<>(dato);
        if (isEmpty()) {
            primero = nuevo;
        } else {
            Nodo<S> observador = primero;
            while (observador.getSiguiente() != null) {
                observador = observador.getSiguiente();
            }
            observador.setSiguiente(nuevo);
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return primero == null;
    }

    @Override
    public S get(int index) {
        if (index < 0 || index >= this.size) {
            return null;
        }
        Nodo<S> observador = primero;
        int contador = 0;

        while (contador < index) {
            observador = observador.getSiguiente();
            contador++;
        }
        return observador.getDato();
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            return;
        }

        Nodo<S> observador = primero;
        if (index == 0) {
            primero = primero.getSiguiente();
        } else {
            for (int i = 0; i < index - 1; i++) {
                observador = observador.getSiguiente();
            }

            observador.setSiguiente(observador.getSiguiente().getSiguiente());
        }
        size--;

    }

    @Override
    public void add(S dato, int indice) {
        if (indice < 0 || indice > this.size) {
            return;
        }
        Nodo<S> nuevo = new Nodo<>(dato);
        if (indice == 0) {
            nuevo.setSiguiente(primero);
            primero = nuevo;

        } else {
            Nodo<S> observador = primero;
            for (int i = 0; i < indice - 1; i++) {
                observador = observador.getSiguiente();

            }
            nuevo.setSiguiente(observador.getSiguiente());
            observador.setSiguiente(nuevo);
        }
        size++;

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void removeObject(S dato) {
        if (isEmpty() || dato == null) {
            return;
        }

        if (primero.getDato().equals(dato)) {
            primero = primero.getSiguiente();
            size--;
            return;
        } else {

            Nodo<S> observador = primero;

            while (observador.getSiguiente() != null) {
                if (observador.getSiguiente().getDato().equals(dato)) {
                    observador.setSiguiente(observador.getSiguiente().getSiguiente());
                    size--;
                    return;
                }
                observador = observador.getSiguiente();
            }
        }

    }

    @Override
    public void clear() {
        primero = null;
        size = 0;
    }

}
