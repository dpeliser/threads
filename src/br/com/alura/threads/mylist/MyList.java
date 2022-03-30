package br.com.alura.threads.mylist;

public class MyList {

    private final String[] elements = new String[1000];
    private int index = 0;

    public int size() {
        return this.elements.length;
    }

    public synchronized void addElement(final String element) {
        this.elements[index] = element;
        this.index++;

        try {
            Thread.sleep(10);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }

        if (index == elements.length) {
            System.out.println("List is full, notifying...");
            this.notify();
        }
    }

    public String getElement(int index) {
        return this.elements[index];
    }

    public boolean isFull() {
        return this.index == this.size();
    }

}