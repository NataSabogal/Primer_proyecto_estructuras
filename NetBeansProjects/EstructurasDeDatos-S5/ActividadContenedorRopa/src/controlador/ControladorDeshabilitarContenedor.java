/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.DAOContenedor;
import modelo.Contenedor;

/**
 *
 * @author nataliasabogalrada
 */
public class ControladorDeshabilitarContenedor {

    DAOContenedor dao;
    int fila;
    int columna;

    public ControladorDeshabilitarContenedor(int fila, int columna) {
        this.dao = new DAOContenedor(fila, columna);
        this.fila = fila;
        this.columna = columna;
    }

    public Contenedor entregarContenedor(int fila, int columna) {
        return dao.entregarContenedor(fila, columna);
    }

    public void deshabilitarContenedor(Contenedor contenedor, String motivo) {
        dao.deshabilitarContenedor(fila, columna, motivo);
    }

    public void volverDisponibleContenedor(int fila, int columna) {
        dao.volverDisponibleContenedor(fila, columna);
    }

    public String mostrarMotivo(int fila, int columna) {
        return dao.mostrarMotivo(fila, columna);
    }
    

}
