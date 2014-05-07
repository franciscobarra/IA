/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;

/**
 *
 * @author Alumno
 */
import java.awt.Point;

public class Main {
    

public static void main(String args[]){
    Estado inicial,fin;
    Point posicionInicial,posicionFinal;
    Busqueda b;
    
    String [][] matrizInicial={{"#","#","#","#","#"},
                               {"C","C","#","C","C"},
                               {"#","C","#","C","#"},
                               {"#","C","#","C","#"},
                               {"#","C","#","C","#"}, 
                               {"#","C","C","C","#"}, 
                               {"#","M","#","M","#"}, 
                        
    };
    
    String [][] matrizFinal=  {{"#","#","#","#","#"},
                               {"C","C","#","C","C"},
                               {"#","C","#","C","#"},
                               {"#","C","#","C","#"},
                               {"#","C","#","C","#"}, 
                               {"#","C","C","C","#"}, 
                               {"#","M","#","M","#"}, 
                        
    };
    
    //matriz[6][4]
    
    for(int i=0;i<=6;i++){
        for(int j=0;j<=4;j++){
            System.out.print(matrizInicial[i][j]+" ");
        }
        System.out.print("\n");
    }
    
    posicionInicial= new Point(1,0);
    posicionFinal= new Point(1,4);
    
    inicial = new Estado(matrizInicial,posicionInicial, null ,null);
    fin = new Estado(matrizFinal,posicionFinal, null ,null);
    b= new Busqueda(inicial, fin);
    
    System.out.println(b.obtenerResultado());
    
   }

}
