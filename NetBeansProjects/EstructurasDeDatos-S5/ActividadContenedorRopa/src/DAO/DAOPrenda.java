/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import IDAO.IDaoPrenda;
import java.util.ArrayList;
import modelo.Contenedor;
import modelo.Estado;
import modelo.Prenda;
import serializadora.SerializadoraContenedores;

/**
 *
 * @author nataliasabogalrada
 */
public class DAOPrenda implements IDaoPrenda{

    private Contenedor[][] contenedores;

    public DAOPrenda(int fila, int columna) {
        this.contenedores = SerializadoraContenedores.getInstance().getContenedor();
    }

    public ArrayList<Prenda> getListaPrendas(int fila, int columna) {
        return contenedores[fila][columna].getPrendas();
    }

    public Prenda buscarPrenda(int fila, int columna, String ref) {
        for (int i = 0; i < contenedores[fila][columna].getPrendas().size(); i++) {
            if (contenedores[fila][columna].getPrendas().get(i).getRef().equals(ref)) {
                return contenedores[fila][columna].getPrendas().get(i);
            }
        }
        return null;
    }

    public void guardarPrenda(Prenda prenda, int fila, int columna) {
        Prenda aux = buscarPrenda(fila, columna, prenda.getRef());
        if (aux == null) {
            contenedores[fila][columna].getPrendas().add(prenda);
            SerializadoraContenedores.getInstance().escribirContenedor();
            return;
        }

    }

    public boolean eliminarPrenda(int fila, int columna, String ref) {
        Prenda aux = buscarPrenda(fila, columna, ref);
        if (aux != null) {
            contenedores[fila][columna].getPrendas().remove(aux);
            SerializadoraContenedores.getInstance().escribirContenedor();
            return true;
        }
        return false;
    }

    public boolean editarPrenda(int fila, int columna, Prenda pren) {
        Prenda aux = buscarPrenda(fila, columna, pren.getRef());
        if (aux != null) {
            aux.setColor(pren.getColor());
            aux.setTalla(pren.getTalla());
            aux.setTipo(pren.getTipo());
            SerializadoraContenedores.getInstance().escribirContenedor();
            return true;
        }
        return false;
    }

    public boolean alquilarContenedor(int fila, int columna, String encargado, String fecha, double valor, String pregunta, String respuesta) {
        if (contenedores[fila][columna].getEstado().equals(Estado.DISPONIBLE)) {
            contenedores[fila][columna].setEncargado(encargado);
            contenedores[fila][columna].setFechaAlquiler(fecha);
            contenedores[fila][columna].setValorAlquiler(valor);
            contenedores[fila][columna].setPreguntaSecreta(pregunta);
            contenedores[fila][columna].setRespuestaSecreta(respuesta);
            contenedores[fila][columna].setEstado(Estado.ALQUILADO);

            SerializadoraContenedores.getInstance().escribirContenedor();
            return true;
        }
        return false;
    }

    public String preguntaSecreta(int fila, int columna) {
        Contenedor aux = contenedores[fila][columna];
        if (aux.getEstado().ALQUILADO.equals(Estado.ALQUILADO)) {
            return aux.getPreguntaSecreta();
        }
        return null;
    }

    public boolean respuestaCorrecta(int fila, int columna, String respuesta) {
        String guardada = contenedores[fila][columna].getRespuestaSecreta();
        if (guardada.equals(respuesta)) {
            return true;
        }
        return false;
    }

    public void vaciarContenedor(int fila, int columna) {
        Contenedor aux = contenedores[fila][columna];
        if (aux.getEstado().equals(Estado.ALQUILADO) && aux != null) {
            aux.getPrendas().clear();
            SerializadoraContenedores.getInstance().escribirContenedor();
        }
    }

    public boolean entregarContenedor(int fila, int columna, String respuesta) {
        Contenedor aux = contenedores[fila][columna];

        if (aux != null && aux.getEstado().equals(Estado.ALQUILADO) && aux.getPrendas().isEmpty() && aux.getRespuestaSecreta() != null && aux.getRespuestaSecreta().equals(respuesta)) {

            aux.setEstado(Estado.DISPONIBLE);
            aux.setEncargado(null);
            aux.setFechaAlquiler(null);
            aux.setValorAlquiler(0);
            aux.setPreguntaSecreta(null);
            aux.setRespuestaSecreta(null);

            SerializadoraContenedores.getInstance().escribirContenedor();
            return true;
        } else {
            return false;
        }
    }

}
