public class FinalAndVariableDifference {
    public static void main(String[] args) {
        String a = "helloWorlds2";
        final String b = getHello();
        String c = b + 2;
        System.out.println((a.equals(c)));
    }

    public static String getHello() {
        return "helloWorlds";
    }
}