package br.com.alura.threads.bathroom;

public class BathroomMain {

    public static void main(String[] args) {
        final Bathroom bathroom = new Bathroom();

        final Thread guest1 = new Thread(new TaskNumberOne(bathroom), "John");
        final Thread guest2 = new Thread(new TaskNumberTwo(bathroom), "Michael");
        final Thread guest3 = new Thread(new TaskNumberOne(bathroom), "Katy");
        final Thread guest4 = new Thread(new TaskNumberTwo(bathroom), "Miley");
        final Thread cleaner = new Thread(new TaskCleaning(bathroom), "Cleaner");
        cleaner.setDaemon(true);

        guest1.start();
        guest2.start();
        cleaner.start();
//        guest3.start();
//        guest4.start();
    }

}
