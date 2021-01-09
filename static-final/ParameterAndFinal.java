import sun.java2d.cmm.PCMM;

class Parameter {
    public void method(final int a) {
        // a++; 编译失败
        // a = 1; 编译失败
        System.out.println(a);
    }
}

public class ParameterAndFinal {
    public static void main(String[] args) {
        Parameter par = new Parameter();
        int a = 2;
        par.method(a);
        int b = 4;
        par.method(b);
    }
}
