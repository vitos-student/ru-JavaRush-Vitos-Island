package entity.Animal;

public abstract class Animal {
    protected boolean isAlive = true;
    protected  String nameAnimal;


    public void initAnimal(String name){
        System.out.println("Создаем животное:" + name);
    }

    public void moveAnimal(){}

    public void eatAnimal(){}

    public boolean isAlive() { return isAlive; }

}
