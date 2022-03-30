package br.com.alura.threads.bathroom;

public class Bathroom {

    private boolean dirty = true;

    public void doNumberOne() {
        final String name = Thread.currentThread().getName();

        System.out.println(name + " is knocking on the door");

        synchronized (this) {
            System.out.println(name + " entering the bathroom");

            while (dirty) {
                waitOutside(name);
            }
//            if (dirty) {
//                waitOutside(name);
//            }
//            After wait outside, when the thread is notified, it will continue to execute the code after this if.

            System.out.println(name + " using the bathroom, it will be quickly");

            sleep(2000);

            this.dirty = true;

            System.out.println(name + " flushing");
            System.out.println(name + " hand washing");
            System.out.println(name + " leaving the bathroom");
        }
    }

    public void doNumberTwo() {
        final String name = Thread.currentThread().getName();

        System.out.println(name + " is knocking on the door");

        synchronized (this) {
            System.out.println(name + " entering the bathroom");

            while (dirty) {
                waitOutside(name);
            }

//            if (dirty) {
//                waitOutside(name);
//            }
//            After wait outside, when the thread is notified, it will continue to execute the code after this if.

            System.out.println(name + " using the bathroom, it will take some time");

            sleep(10000);

            this.dirty = true;

            System.out.println(name + " flushing");
            System.out.println(name + " hand washing");
            System.out.println(name + " leaving the bathroom");
        }
    }

    public void clear() {

        final String name = Thread.currentThread().getName();

        System.out.println(name + " is knocking on the door");

        synchronized (this) {
            System.out.println(name + " entering the bathroom");

            if (!dirty) {
                System.out.println(name + ", the bathroom is not dirty, leaving");
                return;
            }

            System.out.println(name + " cleaning the bathroom");

            this.dirty = false;

            sleep(5000);

            this.notifyAll();

            System.out.println(name + " leaving the bathroom");
        }
    }

    private void sleep(final int millis) {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void waitOutside(final String name) {
        System.out.println(name + ", the bathroom is dirty");

        try {
            this.wait();
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }

}
