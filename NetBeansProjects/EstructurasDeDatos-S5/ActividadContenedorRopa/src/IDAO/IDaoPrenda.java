/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IDAO;

import java.util.ArrayList;
import modelo.Prenda;

/**
 *
 * @author nataliasabogalrada
 */
public interface IDaoPrenda {

    public ArrayList<Prenda> getListaPrendas(int fila, int columna);

    public Prenda buscarPrenda(int fila, int columna, String ref);

    public void guardarPrenda(Prenda prenda, int fila, int columna);

    public boolean eliminarPrenda(int fila, int columna, String ref);

    public boolean editarPrenda(int fila, int columna, Prenda pren);

    public boolean alquilarContenedor(int fila, int columna, String encargado, String fecha, double valor, String pregunta, String respuesta);

    public String preguntaSecreta(int fila, int columna);

    public boolean respuestaCorrecta(int fila, int columna, String respuesta);

    public void vaciarContenedor(int fila, int columna);

    public boolean entregarContenedor(int fila, int columna, String respuesta);

}
