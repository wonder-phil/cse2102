public class LiskovMain {
    public static void main(String[] args) {
    
        Animal animal_0 = new Animal();
        animal_0.print();

        Animal animal_1 = new Mammal();
        animal_1.print();

        Animal animal_2 = new Dog();
        animal_2.print();

        /*
        Dog dog = new Animal(); // will not compile
        */
        
    }
}