package entity.Animal.HerbAnimal;

import entity.Animal.Animal;

public class Cow extends Animal{

        private  final String nameAnimal = "Корова";


    public Cow() {
        initAnimal(getNameAnimal());
    }

    public String getNameAnimal() {
        return nameAnimal;
    }
}


