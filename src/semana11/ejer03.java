/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana11;

/**
 *producto recursivo
 * @author GIOVANNI
 */

class Mult{
    long producto(long a,long b){
        return b==0?0:a+ producto(a, b-1);
    }
}
public class ejer03{
    public static void main(String[] args) {
        Mult m1=new Mult();
        long inicio=System.nanoTime();
        System.out.println(m1.producto(20000, 10));
        long fin = System.nanoTime();
        System.out.println("tiempo de ejecucion: " +( fin -inicio));
    }
    //350100
    //1019600
}
