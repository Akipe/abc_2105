package poo.introduction;

public class App {
    public static void main(String[] args) {
        String animalSpecie;

        Animal bee = new Animal();

        animalSpecie = bee.getSpecie();
        System.out.println(animalSpecie);

        bee.setSpecie("Abeille");

        animalSpecie = bee.getSpecie();
        System.out.println(animalSpecie);
    }
}