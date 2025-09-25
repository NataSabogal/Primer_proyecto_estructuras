/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.DAOContenedor;
import modelo.Contenedor;
import serializadora.SerializadoraContenedores;

/**
 *
 * @author nataliasabogalrada
 */
public class ControladorPrincipal {

    DAOContenedor dao;

    public ControladorPrincipal() {
        this.dao = new DAOContenedor(0, 0);
        
    }

    public Contenedor entregarContenedor(int fila, int columna) {
        return dao.entregarContenedor(fila, columna);
    }

    public boolean contenedorOcupada(int fila, int columna) {
        return dao.contenedorOcupada(fila, columna);
    }

    public boolean estaHabilitado(int fila, int columna) {
        return dao.estaHabilitado(fila, columna);
    }

    public boolean estaAlquilada(int fila, int columna) {
        return dao.estaAlquilada(fila, columna);
    }
    
    
}
