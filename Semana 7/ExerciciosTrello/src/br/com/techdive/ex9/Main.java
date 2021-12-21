package br.com.techdive.ex9;

import br.com.techdive.ex7.Animal;
import br.com.techdive.ex7.Cachorro;
import br.com.techdive.ex7.Cavalo;
import br.com.techdive.ex7.Preguica;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Veterinario veterinario = new Veterinario("Veterinario");
        List<Animal> animais = new ArrayList<>();
        Cachorro cachorro = new Cachorro("Doginho", 2);
        animais.add(cachorro);
        Cavalo cavalo = new Cavalo("Alazao", 5);
        animais.add(cavalo);
        Preguica preguica = new Preguica("Soninho", 3);
        animais.add(preguica);

        for (Animal animal: animais) {
            veterinario.examinar(animal);
        }



    }
}
