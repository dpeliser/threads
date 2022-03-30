package br.com.alura.threads.textualsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextualSearchTask implements Runnable {

    private final String fileName;
    private final String nameToSearch;

    public TextualSearchTask(final String fileName, final String nameToSearch) {
        this.fileName = fileName;
        this.nameToSearch = nameToSearch;
    }

    @Override
    public void run() {
        try {
            final Scanner scanner = new Scanner(new File(fileName));
            int lineNumber = 1;

            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();

                if (line.matches(nameToSearch)) {
                    System.out.println(fileName + " - " + lineNumber + " - " + line);
                }

                lineNumber++;
            }

            scanner.close();
        } catch (final FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
