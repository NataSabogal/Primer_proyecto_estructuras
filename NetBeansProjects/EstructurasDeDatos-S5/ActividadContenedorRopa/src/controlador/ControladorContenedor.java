/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.DAOPrenda;
import IDAO.IDaoPrenda;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Contenedor;
import modelo.Prenda;
import util.Lista;

/**
 *
 * @author nataliasabogalrada
 */
public class ControladorContenedor {

    IDaoPrenda dao;
    int fila;
    int columna;

    public ControladorContenedor(int fila, int columna) {
        this.dao = new DAOPrenda(fila, columna);
    }

    public Lista getListaPrendas(int fila, int columna) {
        return dao.getListaPrendas(fila, columna);
    }

    public Prenda buscarPrenda(int fila, int columna, String ref) {
        return dao.buscarPrenda(fila, columna, ref);
    }

    public void guardarPrenda(Prenda prenda, int fila, int columna) throws RuntimeException {
        Prenda aux = buscarPrenda(fila, columna, prenda.getRef());
        if (aux != null) {
            throw new RuntimeException("Referencia en uso en estae contenedor");
        }
        dao.guardarPrenda(prenda, fila, columna);
    }

    public boolean eliminarPrenda(int fila, int columna, String ref) throws RuntimeException {
        Prenda aux = buscarPrenda(fila, columna, ref);
        if (aux == null) {
            throw new RuntimeException("No se encuentra la prenda que desea eliminar");
        }
        return dao.eliminarPrenda(fila, columna, ref);
    }

    public boolean editarPrenda(int fila, int columna, Prenda pren) throws RuntimeException {
        Prenda aux = buscarPrenda(fila, columna, pren.getRef());
        if (aux == null) {
            throw new RuntimeException("No se encuentra la prenda que desea editar");
        }
        return dao.editarPrenda(fila, columna, pren);
    }

    public DefaultTableModel tabla(int fila, int columna) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Referencia", "Tipo", "Color", "Talla"});
        for (int i = 0; i < dao.getListaPrendas(fila, columna).size(); i++) {
            if (dao.getListaPrendas(fila, columna) != null) {
                model.addRow(new Object[]{dao.getListaPrendas(fila, columna).get(i).getRef(),
                    dao.getListaPrendas(fila, columna).get(i).getTipo(),
                    dao.getListaPrendas(fila, columna).get(i).getColor(),
                    dao.getListaPrendas(fila, columna).get(i).getTalla()
                });
            }
        }
        return model;
    }

    public void vaciarContenedor(int fila, int columna) {
        dao.vaciarContenedor(fila, columna);
    }
}
