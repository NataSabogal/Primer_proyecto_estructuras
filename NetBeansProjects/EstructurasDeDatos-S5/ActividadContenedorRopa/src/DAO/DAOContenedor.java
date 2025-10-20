  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import IDAO.IDaoContenedor;
import modelo.Contenedor;
import modelo.Estado;
import serializadora.SerializadoraContenedores;

/**
 *
 * @author nataliasabogalrada
 */
public class DAOContenedor implements IDaoContenedor {

    private Contenedor[][] contenedores;
    private int fila;
    private int columna;

    public DAOContenedor(int fila, int columna) {
        this.contenedores = SerializadoraContenedores.getInstance().getContenedor();
        this.fila = fila;
        this.columna = columna;
    }

//    public DAOContenedor() {
//        this.contenedores = SerializadoraContenedores.getInstance().getContenedor();
//    }

    @Override
    public Contenedor entregarContenedor(int fila, int columna) {
        return this.contenedores[fila][columna];
    }

    @Override
    public boolean contenedorOcupada(int fila, int columna) {
        return entregarContenedor(fila, columna).validarOcupada();
    }

    @Override
    public void deshabilitarContenedor(int fila, int columna, String motivo) {
        entregarContenedor(fila, columna).setEstado(Estado.DESHABILITADO);
        entregarContenedor(fila, columna).setMotivoDeshabilitacion(motivo);
        SerializadoraContenedores.getInstance().escribirContenedor();
    }

    @Override
    public void volverDisponibleContenedor(int fila, int columna) {
        contenedores[fila][columna].setEstado(Estado.DISPONIBLE);
        contenedores[fila][columna].setMotivoDeshabilitacion(null);
        SerializadoraContenedores.getInstance().escribirContenedor();
    }

    @Override
    public String mostrarMotivo(int fila, int columna) {
        Estado estado = contenedores[fila][columna].getEstado();
        if (estado.equals(estado.DESHABILITADO)) {
            String mot = contenedores[fila][columna].getMotivoDeshabilitacion();
            return mot;
        }
        return null;
    }

    @Override
    public boolean estaHabilitado(int fila, int columna) {
        Estado aux = contenedores[fila][columna].getEstado();
        if (aux.equals(Estado.DISPONIBLE)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean estaAlquilada(int fila, int columna) {
        Estado aux = contenedores[fila][columna].getEstado();
        if (aux.equals(Estado.ALQUILADO)) {
            return true;
        }
        return false;
    }

}
