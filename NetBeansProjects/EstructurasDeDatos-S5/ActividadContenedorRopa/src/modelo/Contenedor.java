/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author nataliasabogalrada
 */
public class Contenedor implements Serializable {

    private Estado estado;
    private String encargado;
    private String fechaAlquiler;
    private double valorAlquiler;
    private String preguntaSecreta;
    private String respuestaSecreta;
    private String motivoDeshabilitacion;
    private ArrayList<Prenda> prendas;

    public Contenedor() {
        this.estado = Estado.DISPONIBLE;
        this.prendas = new ArrayList<>();
    }

    public Contenedor(Estado estado, String encargado, String fechaAlquiler, double valorAlquiler, String preguntaSecreta, String respuestaSecreta, String motivoDeshabilitacion) {
        this.estado = estado;
        this.encargado = encargado;
        this.fechaAlquiler = fechaAlquiler;
        this.valorAlquiler = valorAlquiler;
        this.preguntaSecreta = preguntaSecreta;
        this.respuestaSecreta = respuestaSecreta;
        this.motivoDeshabilitacion = motivoDeshabilitacion;
        this.prendas = new ArrayList<>();
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(String fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public double getValorAlquiler() {
        return valorAlquiler;
    }

    public void setValorAlquiler(double valorAlquiler) {
        this.valorAlquiler = valorAlquiler;
    }

    public String getPreguntaSecreta() {
        return preguntaSecreta;
    }

    public void setPreguntaSecreta(String preguntaSecreta) {
        this.preguntaSecreta = preguntaSecreta;
    }

    public String getRespuestaSecreta() {
        return respuestaSecreta;
    }

    public void setRespuestaSecreta(String respuestaSecreta) {
        this.respuestaSecreta = respuestaSecreta;
    }

    public String getMotivoDeshabilitacion() {
        return motivoDeshabilitacion;
    }

    public void setMotivoDeshabilitacion(String motivoDeshabilitacion) {
        this.motivoDeshabilitacion = motivoDeshabilitacion;
    }

    public ArrayList<Prenda> getPrendas() {
        return prendas;
    }

    public boolean validarOcupada() {
        return !prendas.isEmpty();
    }

    public boolean estaDisponible() {
        return estado == Estado.DISPONIBLE;
    }

    public boolean estaOcupado() {
        return estado == Estado.ALQUILADO;
    }

    public boolean estaDeshabilitado() {
        return estado == Estado.DESHABILITADO;
    }

}
