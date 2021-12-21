package br.com.techdive.ex10;

import br.com.techdive.ex7.Animal;
import br.com.techdive.ex7.Cachorro;
import br.com.techdive.ex7.Cavalo;
import br.com.techdive.ex7.Preguica;

import java.util.ArrayList;
import java.util.List;

public class Zoologico {

    public static void main(String[] args) {

        List<Animal> animais = new ArrayList<>();
        Preguica preguicinha = new Preguica();
        animais.add(preguicinha);

        for(int i = 0; i < 3; i++) {
            Cachorro cachorro = new Cachorro();
            Cavalo cavalo = new Cavalo();
            Preguica preguica = new Preguica();
            animais.add(cachorro);
            animais.add(cavalo);
            animais.add(preguica);
        }


        for (Animal animal: animais) {
            animal.emitirSom();
            if(animal.getClass().equals(Cavalo.class) || animal.getClass().equals(Cachorro.class)) {
                animal.locomover();
            }
        }



    }
}
