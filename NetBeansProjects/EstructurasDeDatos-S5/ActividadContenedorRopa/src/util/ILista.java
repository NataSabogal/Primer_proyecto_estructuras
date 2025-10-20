/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package util;


/**
 *
 * @author nataliasabogalrada
 */
public interface ILista <T> {
    
    public void add(T dato);
    
    public boolean isEmpty();
    
    public T get(int index);
    
    public void remove(int index);
    
    public void add(T prenda, int pocision);
    
    public int size();
    
    public void removeObject(T prenda);
    
    public void clear();
}
