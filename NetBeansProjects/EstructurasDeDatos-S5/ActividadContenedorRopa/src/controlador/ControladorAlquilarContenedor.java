/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.DAOPrenda;
import IDAO.IDaoPrenda;

/**
 *
 * @author nataliasabogalrada
 */
public class ControladorAlquilarContenedor {

    IDaoPrenda dao;
    int fila;
    int columna;

    public ControladorAlquilarContenedor(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.dao = new DAOPrenda(fila, columna);
    }

    public boolean alquilarContenedor(int fila, int columna, String encargado, String fecha, double valor, String pregunta, String respuesta) {
        return dao.alquilarContenedor(fila, columna, encargado, fecha, valor, pregunta, respuesta);
    }

    public boolean respuestaCorrecta(int fila, int columna, String respuesta) {
        return dao.respuestaCorrecta(fila, columna, respuesta);
    }

    public String preguntaSecreta(int fila, int columna) {
        return dao.preguntaSecreta(fila, columna);
    }

    public boolean entregarContenedor(int fila, int columna, String respuesta) throws RuntimeException {
        if (!dao.getListaPrendas(fila, columna).isEmpty()) {
            throw new RuntimeException("La lista del contenedor debe de estar vacia antes de entregarlo");
        }
        return dao.entregarContenedor(fila, columna, respuesta);
    }

}
