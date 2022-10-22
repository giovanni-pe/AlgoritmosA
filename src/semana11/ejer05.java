
package semana11;


class mcdR{
    int mcd(int a,int b){
        return a==0||b==0?0:a==b?b:a>=b?mcd(a-b,b):mcd(a,b-a);
    }
}
public class ejer05 {
    public static void main(String[] args) {
        mcdR mcd=new mcdR();
        System.out.println(mcd.mcd(20,60));
    }
}
