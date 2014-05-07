/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;
import java.awt.Point;
import java.util.Objects;

public class Estado {
    private String[][] laberinto;
    private Estado antecesor;
    private String movimiento;
    private Point posicion;
    
   public Estado(String[][] laberinto, Point posicion, Estado antecesor,String movimiento) {
        this.laberinto=laberinto;
        this.antecesor=antecesor;
        this.movimiento=movimiento;
        this.posicion=posicion;
    }

    public String[][] getLaberinto() {
        return laberinto;
    }

    public Estado getAntecesor() {
        return antecesor;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public Point getPosicion() {
        Point punto;
        punto=new Point(posicion);
        return punto;
    }

    @Override
    public String toString() {
        return posicion.toString();
    }
    
    
    //Matriz [6][4];
    
    public boolean moverArriba(){
        if(posicion.x-1>=0){
            if(laberinto[posicion.x-1][posicion.y]=="C"){
                System.out.println("se movio arriba: "+posicion); 
                return true;
            }
        }
        return false;
    }
     public boolean moverAbajo(){
         if(posicion.x+1<=6){
            if(laberinto[posicion.x+1][posicion.y]=="C"){
                System.out.println("se movio abajo: "+posicion); 
               return true;
            }
         }
        return false;
    }
      public boolean moverIzquierda(){
          if(posicion.y-1>=0){
            if(laberinto[posicion.x][posicion.y-1]=="C"){
                System.out.println("se movio izquierda: "+posicion); 
               return true;
            }
          }
        return false;
      }
       public boolean moverDerecha(){
           if(posicion.y+1<=4){
            if(laberinto[posicion.x][posicion.y+1]=="C"){
                System.out.println("se movio derecha: "+posicion); 
               return true;
            }
           }
        return false;
    }
     
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Estado))return false;
        return ((Estado)obj).getPosicion().equals(this.getPosicion());
    }
      @Override
    public int hashCode() {
        //Hashcode generado por IDE
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.laberinto);
        hash = 89 * hash + Objects.hashCode(this.posicion);
        hash = 89 * hash + Objects.hashCode(this.antecesor);
        hash = 89 * hash + Objects.hashCode(this.movimiento);
        return hash;
    }
}
