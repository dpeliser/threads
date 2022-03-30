package br.com.alura.threads.multiplier;

import javax.swing.*;
import java.math.BigInteger;

public class MultiplierTask implements Runnable {

    private final JTextField firstField;
    private final JTextField secondField;
    private final JLabel result;

    public MultiplierTask(final JTextField firstField, final JTextField secondField, final JLabel result) {
        this.firstField = firstField;
        this.secondField = secondField;
        this.result = result;
    }

    @Override
    public void run() {
        final long firstValue = Long.parseLong(firstField.getText());
        final long secondValue = Long.parseLong(secondField.getText());
        BigInteger resultValue = new BigInteger("0");

        for (int i = 0; i < firstValue; i++) {
            for (int j = 0; j < secondValue; j++) {
                resultValue = resultValue.add(new BigInteger("1"));
            }
        }

        result.setText(resultValue.toString());
    }

}
