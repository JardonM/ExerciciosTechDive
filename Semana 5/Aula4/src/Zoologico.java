import java.util.ArrayList;
import java.util.List;

public class Zoologico {

    private List<Pato> patos = new ArrayList<>();
    private List<Elefante> elefantes = new ArrayList<>();
    private List<Leao> leoes = new ArrayList<>();
    public static int totalAnimais;

    public void setTotalAnimais() {
        totalAnimais = patos.size() + elefantes.size() + leoes.size();
    }

    public static void main(String[] args) {
        Zoologico zoologico = new Zoologico();

        Elefante elefante1 = new Elefante("Gordo");
        zoologico.elefantes.add(elefante1);
        Leao leao1 = new Leao("Faminto");
        zoologico.leoes.add(leao1);
        Pato pato1 = new Pato("Quack");
        zoologico.patos.add(pato1);

        zoologico.setTotalAnimais();

        System.out.println(Zoologico.totalAnimais);
        System.out.println(Pato.totalPatos);
        elefante1.fazerBarulho();



    }


//    {
//        for (int i = 0; i < 10; i++) {
//            patos.add(new Pato("Pato" + i+1));
//            elefantes.add(new Elefante("Elefante" + i+1));
//            leoes.add(new Leao("Leao" + i+1));
//        }
//
//        totalAnimais =  patos.size() + elefantes.size() + leoes.size();
//
//    }


}
