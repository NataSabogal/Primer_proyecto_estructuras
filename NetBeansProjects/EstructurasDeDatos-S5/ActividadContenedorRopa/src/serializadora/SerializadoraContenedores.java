/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serializadora;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelo.Contenedor;

/**
 *
 * @author nataliasabogalrada
 */
public class SerializadoraContenedores {
    
    private static final SerializadoraContenedores instance = new SerializadoraContenedores();
    
    Contenedor [][] contenedor;

    public SerializadoraContenedores() {
        this.contenedor = leerContenedor();
    }

    public static SerializadoraContenedores getInstance() {
        return instance;
    }

    public Contenedor[][] getContenedor() {
        return contenedor;
    }
    
    public void escribirContenedor() {
        try {
            FileOutputStream archivo = new FileOutputStream("src/serializadora/contenedores.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(contenedor);
            escritor.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Contenedor[][] leerContenedor() {

        try {
            FileInputStream archivo = new FileInputStream("src/serializadora/contenedores.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            Contenedor[][] cont = (Contenedor[][]) lector.readObject();
            lector.close();
            return cont;
        } catch (IOException | ClassNotFoundException ex) {
            //ex.printStackTrace();
            contenedor = new Contenedor[3][6];
            for (int i = 0; i < contenedor.length; i++) {
                for (int j = 0; j < contenedor[i].length; j++) {
                    contenedor[i][j] = new Contenedor();
                }
            }

            return contenedor;
        }
    }
    
    
}
