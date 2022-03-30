package br.com.alura.threads.textualsearch;

public class TextualSearchMain {

    public static void main(String[] args) {
        String nome = "(Dan|Chad)(\\s|\\w)*";

        final Thread threadAssinaturas1 = new Thread(new TextualSearchTask("signatures1.txt", nome));
        final Thread threadAssinaturas2 = new Thread(new TextualSearchTask("signatures2.txt", nome));
        final Thread threadAutores = new Thread(new TextualSearchTask("authors.txt", nome));

        threadAssinaturas1.start();
        threadAssinaturas2.start();
        threadAutores.start();
    }

}
