/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana11;

/**
 *una funciion se llama a si misma una y otra ves 
 * lo recursivo se usa para hacer maso cortos y eleganyes
 * la recursividad usa la pila
 * hace uso de la pila
 * super computadora manati
 *factoria y sumatoria
 * motod de busqueda quiikshort nlogn
 * @author GIOVANNI
 */
//class metodo{
//  int factorial(int n){
//      return n==0?1:n*factorial(n-1);
//  }
//}
class metodo{
    int factorial(int n){
     return n==0?1:n*factorial(n-1);
    }
}
public class ejer02 {
    public static void main(String[] args) {
         metodo f1=new metodo();
         System.out.println(f1.factorial(4));
    }
    
}
