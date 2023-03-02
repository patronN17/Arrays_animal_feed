package org.example;
class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate p) {
        if (p.getFood() >= appetite) {
            p.decreaseFood(appetite);
            satiety = true;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isSatiety() {
        return satiety;
    }
}

class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
        }
    }

    public void addFood(int amount) {
        food += amount;
    }

    public int getFood() {
        return food;
    }
}

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Барсик", 5);
        cats[1] = new Cat("Мурзик", 10);
        cats[2] = new Cat("Пушок", 15);

        Plate plate = new Plate(30);

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat.getName() + " сытость : " + cat.isSatiety());
        }

        plate.addFood(20);

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat.getName() + " сытость : " + cat.isSatiety());
        }
    }
}
