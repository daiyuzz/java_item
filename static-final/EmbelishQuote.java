class AA {
    int i = 1;
}

public class EmbelishQuote {
    public static void main(String[] args) {
        final AA a = new AA();

        System.out.println(++a.i);
    }
}
