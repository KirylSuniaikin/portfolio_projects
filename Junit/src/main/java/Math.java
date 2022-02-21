import java.sql.Array;

public class Math  {

    public int summ(int a, int b){
        return a+b;
    }


    public int[] setArray(int ... a){ //значит что параметров может быт сколько угодно и запишутся они в а
        int[] newArray = new int[a.length];
    for(short i=0; i<a.length; i++){
            newArray[i]= a[i];
        }
return  newArray;
    }

    public int divide( int a, int b) throws ArithmeticException{
        return a/b;
    }

}
