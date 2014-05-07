/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class Busqueda {
    private Estado actual,meta;
    private ArrayList<Estado> abierto,cerrado;
    
    public Busqueda(Estado actual, Estado meta){
        this.actual = actual;
        this.meta = meta;
        abierto = new ArrayList<Estado>();
        cerrado = new ArrayList<Estado>();
    }
    
    
     public String obtenerResultado(){
        StringBuilder str;
        ArrayList<String> resultado = iniciarBusqueda();
        int tam;
        
        if(resultado ==null)return null;
        
        str = new StringBuilder();
        tam = resultado.size();
        
        for(int contador =0; contador<tam;contador++){
            str.append("Paso ").append(contador +1).append(", ")
                    .append(resultado.get(contador)).append("\n");
        }
        
        return str.toString();
    }
 
    
    public ArrayList iniciarBusqueda(){
        boolean esMeta = false;
        ArrayList<String> resultado;
        
        abierto.add(actual);
        System.out.println("ACTUAL = "+abierto.get(0).getPosicion());
        while(!abierto.isEmpty() && !esMeta ){
            
            actual = abierto.get(0);
            // actual = abierto.remove(0);
           if(!cerrado.contains(actual)){
               System.out.println("cerrado.contains");
               cerrado.add(actual);
               expandir(actual);
            } 
        if(actual.getPosicion().equals(meta.getPosicion())) esMeta=true;
          System.out.println("DESPUES DE EXPANDIR"+abierto.get(0).getPosicion());
          abierto.remove(0);
            
    }
     if(!esMeta)return null;
     
     resultado = new ArrayList<>();
     
     while(actual.getAntecesor()!=null){
         resultado.add(0,actual.toString());
         actual = actual.getAntecesor();
     }
     
        return resultado;
    }
    
    public void expandir(Estado actual){
       String[][] laberinto;
       Point posicion;
       Estado opcion;
        System.out.println("entra");
       laberinto = actual.getLaberinto();
        
        if(actual.moverArriba()){
           posicion = actual.getPosicion(); 
           posicion.x-=1;
           opcion = new Estado(laberinto, posicion, actual,"Se movio arriba:" );
           abierto.add(opcion);
        }
        if(actual.moverAbajo()){
           posicion = actual.getPosicion(); 
           posicion.x+=1;
           System.out.println("posicion = "+posicion);
           opcion = new Estado(laberinto, posicion, actual,"Se movio Abajo:" );
           abierto.add(opcion);
        }
        if(actual.moverIzquierda()){
           posicion = actual.getPosicion(); 
           posicion.y-=1;
            System.out.println("posicion = "+posicion);
           opcion = new Estado(laberinto, posicion, actual,"Se movio izquierda:" );
           abierto.add(opcion);
        }
        if(actual.moverDerecha()){
           posicion = actual.getPosicion(); 
           posicion.y+=1;
           opcion = new Estado(laberinto, posicion, actual,"Se movio derecha:" );
           abierto.add(opcion);
        }
        
        
        
    }
}
