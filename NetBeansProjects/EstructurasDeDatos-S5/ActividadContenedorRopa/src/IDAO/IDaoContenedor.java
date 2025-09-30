/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IDAO;

import modelo.Contenedor;

/**
 *
 * @author nataliasabogalrada
 */
public interface IDaoContenedor {

    public Contenedor entregarContenedor(int fila, int columna);

    public boolean contenedorOcupada(int fila, int columna);

    public void deshabilitarContenedor(int fila, int columna, String motivo);

    public void volverDisponibleContenedor(int fila, int columna);

    public String mostrarMotivo(int fila, int columna);

    public boolean estaHabilitado(int fila, int columna);

    public boolean estaAlquilada(int fila, int columna);

}
