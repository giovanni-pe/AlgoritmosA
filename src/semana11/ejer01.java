/*https://www.youtube.com/watch?v=RETaKJwnfYE&list=PLCLpAU8VN0j4RGemFfybZrWoSX57NbEq9
 https://github.com/ubuntox84/Algoritmos2022_1
* */
//
package semana11;

import javax.swing.ButtonGroup;

/**
 *
 * @author GIOVANNI
 */
class cuadrado{
    int lado;
    public ButtonGroup buttonGroup3;
    public ButtonGroup buttonGroup5;
    public ButtonGroup buttonGroup2;
    public ButtonGroup buttonGroup4;

    public cuadrado(int lado) {
        this.lado = lado;
    }
    
    int area(){
      return this.lado*this.lado;  
    }
    public int perimetro(){
        return this.lado*4;
    }
}
public class ejer01 {
    
}
