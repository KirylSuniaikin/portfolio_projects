public class Calculator {
    ICalculator iCalculator;

    public Calculator(ICalculator iCalculator){
        this.iCalculator=iCalculator;
    }

    public int mult(int i, int b){
return iCalculator.add(i,b)*2;
    }
}
