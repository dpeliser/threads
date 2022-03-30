package br.com.alura.threads.mylist;

public class MyListMain {

    public static void main(String[] args) throws InterruptedException {
//        final List<String> myList = new Vector<>();
//
//        for (int i = 0; i < 10; i++) {
//            new Thread(new AddElementTask(myList, i)).start();
//        }
//
//        Thread.sleep(2000);
//
//        for (int i = 0; i < myList.size(); i++) {
//            System.out.println(i + " - " + myList.get(i));
//        }

        final MyList myList = new MyList();

        for (int i = 0; i < 10; i++) {
            new Thread(new AddElementTask(myList, i)).start();
        }

        new Thread(new PrintTask(myList)).start();
    }

}
