package com.booking.gui;

import com.booking.model.Booking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PaymentFrame extends JFrame implements ActionListener {
    JLabel lblCardNumber, lblExpiry, lblCVV, lblUPI, lblUPIPin;
    JTextField tfCardNumber, tfExpiry, tfCVV, tfUPI;
    JPasswordField pfUPIPin;
    JButton btnPay, btnPayUPI;
    JComboBox<String> cbUPIOptions;
    String name, movie;
    int seats;
    ArrayList<Booking> bookings;
    JTextArea taOutput;

    public PaymentFrame(String name, String movie, int seats, ArrayList<Booking> bookings, JTextArea taOutput) {
        this.name = name;
        this.movie = movie;
        this.seats = seats;
        this.bookings = bookings;
        this.taOutput = taOutput;

        setLayout(new GridLayout(7, 2, 10, 10));

        lblCardNumber = new JLabel("Card Number:");
        tfCardNumber = new JTextField(20);

        lblExpiry = new JLabel("Expiry Date:");
        tfExpiry = new JTextField(5);

        lblCVV = new JLabel("CVV:");
        tfCVV = new JTextField(3);

        lblUPI = new JLabel("UPI ID:");
        tfUPI = new JTextField(20);

        lblUPIPin = new JLabel("UPI PIN:");
        pfUPIPin = new JPasswordField(6);

        String[] upiOptions = {"--","Google Pay", "PhonePe", "Paytm", "BHIM"};
        cbUPIOptions = new JComboBox<>(upiOptions);

        btnPay = new JButton("Pay with Card");
        btnPay.addActionListener(this);

        btnPayUPI = new JButton("Pay with UPI");
        btnPayUPI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedUPI = (String) cbUPIOptions.getSelectedItem();
                String upiID = tfUPI.getText();
                String upiPin = new String(pfUPIPin.getPassword());

                if (upiID.isEmpty() || upiPin.isEmpty()) {
                    JOptionPane.showMessageDialog(PaymentFrame.this, "Please enter your UPI ID and PIN.");
                    return;
                }

                // Simulate UPI payment processing
                Booking booking = new Booking(name, movie, seats);
                bookings.add(booking);

                taOutput.setText("Booking Details:\n");
                for (Booking b : bookings) {
                    taOutput.append(b.toString() + "\n");
                }

                JOptionPane.showMessageDialog(PaymentFrame.this, selectedUPI + " Payment Successful! Booking Confirmed.");
                dispose();
            }
        });

        // Adding components with color customization
        lblCardNumber.setForeground(Color.BLUE);
        lblExpiry.setForeground(Color.BLUE);
        lblCVV.setForeground(Color.BLUE);
        lblUPI.setForeground(Color.GREEN);
        lblUPIPin.setForeground(Color.GREEN);

        tfCardNumber.setBackground(Color.LIGHT_GRAY);
        tfExpiry.setBackground(Color.LIGHT_GRAY);
        tfCVV.setBackground(Color.LIGHT_GRAY);
        tfUPI.setBackground(Color.LIGHT_GRAY);
        pfUPIPin.setBackground(Color.LIGHT_GRAY);

        btnPay.setBackground(Color.ORANGE);
        btnPayUPI.setBackground(Color.ORANGE);

        add(lblCardNumber);
        add(tfCardNumber);
        add(lblExpiry);
        add(tfExpiry);
        add(lblCVV);
        add(tfCVV);
        add(btnPay);

        add(lblUPI);
        add(tfUPI);
        add(lblUPIPin);
        add(pfUPIPin);
        add(cbUPIOptions);
        add(btnPayUPI);

        setTitle("Payment");
        setSize(400, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Simulate card payment processing
        Booking booking = new Booking(name, movie, seats);
        bookings.add(booking);

        taOutput.setText("Booking Details:\n");
        for (Booking b : bookings) {
            taOutput.append(b.toString() + "\n");
        }

        JOptionPane.showMessageDialog(this, "Card Payment Successful! Booking Confirmed.");
        dispose();
    }
}
