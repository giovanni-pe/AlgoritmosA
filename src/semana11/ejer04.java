/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana11;

/**
 *calculo potencia recursiva
 * @author GIOVANNI
 */
class PowR{
 long potencia(long b,long e){
     return e==0?1:b*potencia(b,e-1);
 }
}

public class ejer04 {

    public static void main(String[] args) {
        PowR p1=new PowR();
        System.out.println(p1.potencia(2,4 ));
        }
}
