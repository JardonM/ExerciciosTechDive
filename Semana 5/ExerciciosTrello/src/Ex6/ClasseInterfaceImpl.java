package Ex6;

public class ClasseInterfaceImpl implements ClasseInterface{

    @Override
    public void imprimir(String string) {
        System.out.println(string);
    }


    public static void main(String[] args) {

        ClasseInterfaceImpl teste = new ClasseInterfaceImpl();
        teste.imprimir("Teste.");

    }
}
