package semana11;

class sumVec {
    void cargarV(int vec[]) {
        for (int i = 0; i < vec.length; i++) vec[i] = (int) (Math.random() * 900)+100;
    }
    int suma(int vec[], int n) {
        return n == 0 ? vec[n] : vec[n] + suma(vec, n - 1);
    }
    String numerosGenerados(int vec[]) {
        String acu = "";
        int col=0;
        for (int i : vec){
            if(col%20==0) acu+="\n";
            acu += " [" + i + "] ";
            col++;}
        return acu;
    }
}
public class ejer06 {

    public static void main(String[] args) {
        int vec[] = new int[100];
        sumVec s1 = new sumVec();
        s1.cargarV(vec);
        System.out.println(s1.numerosGenerados(vec));
        System.out.println(s1.suma(vec, vec.length - 1));
    }
}
