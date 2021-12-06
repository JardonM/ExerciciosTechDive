package Ex1;



public class Main {

    public static void main(String[] args) {

        System.out.println(System.getProperty("os.name"));

        System.out.println("Memoria total: " + Runtime.getRuntime().totalMemory());
        System.out.println("Memoria livre: " + Runtime.getRuntime().freeMemory());
        System.out.println("Memoria utilizada: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }


}
