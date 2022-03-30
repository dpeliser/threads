package br.com.alura.threads.multiplier;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiplierAction implements ActionListener {

    private final JTextField firstField;
    private final JTextField secondField;
    private final JLabel result;

    public MultiplierAction(final JTextField firstField, final JTextField secondField, final JLabel result) {
        this.firstField = firstField;
        this.secondField = secondField;
        this.result = result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final MultiplierTask multiplierTask = new MultiplierTask(firstField, secondField, result);
        final Thread threadCalculation = new Thread(multiplierTask, "Thread Calculation");
        threadCalculation.start();
    }

}