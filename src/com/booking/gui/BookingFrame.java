package com.booking.gui;

import com.booking.model.Booking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BookingFrame extends JFrame implements ActionListener {
    JLabel lblName, lblMovie, lblSeats;
    JTextField tfName, tfSeats;
    JComboBox<String> cbMovie;
    JButton btnBook, btnHistory;
    JTextArea taOutput;

    ArrayList<Booking> bookings;

    public BookingFrame() {
        setLayout(new FlowLayout());

        // Set background color for the frame
        getContentPane().setBackground(new Color(240, 248, 255));

        lblName = new JLabel("Name:");
        lblName.setForeground(new Color(0, 102, 204));

        tfName = new JTextField(30);
        tfName.setBackground(new Color(224, 255, 255));

        lblMovie = new JLabel("Select Movie:");
        lblMovie.setForeground(new Color(0, 102, 204));

        cbMovie = new JComboBox<>(new String[]{"---", "Fast and Furious", "12th Fail", "Stree2:Sarkate ka Ataank", "Munjya", "Avengers: Endgame", "Khel Khel Mein", "VEDDA", "Kalki", "Satyabhama", "Indian2"});
        cbMovie.setBackground(new Color(224, 255, 255));

        lblSeats = new JLabel("Number of Seats:");
        lblSeats.setForeground(new Color(0, 102, 204));

        tfSeats = new JTextField(20);
        tfSeats.setBackground(new Color(224, 255, 255));

        btnBook = new JButton("Book Tickets");
        btnBook.setBackground(new Color(0, 204, 102));
        btnBook.setForeground(Color.WHITE);
        btnBook.addActionListener(this);

        btnHistory = new JButton("View Booking History");
        btnHistory.setBackground(new Color(0, 204, 102));
        btnHistory.setForeground(Color.WHITE);
        btnHistory.addActionListener(e -> new HistoryFrame(bookings));

        taOutput = new JTextArea(5, 40);
        taOutput.setEditable(false);
        taOutput.setBackground(new Color(255, 255, 224));

        add(lblName);
        add(tfName);
        add(lblMovie);
        add(cbMovie);
        add(lblSeats);
        add(tfSeats);
        add(btnBook);
        add(btnHistory);
        add(new JScrollPane(taOutput));

        setTitle("Movie Ticket Booking System");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        bookings = new ArrayList<>();
    }

    public void actionPerformed(ActionEvent e) {
        String name = tfName.getText();
        String movie = (String) cbMovie.getSelectedItem();
        int seats = Integer.parseInt(tfSeats.getText());

        new SeatSelectionFrame(name, movie, seats, bookings, taOutput);
    }
}
