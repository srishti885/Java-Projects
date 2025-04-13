package com.booking.gui;

import com.booking.model.Booking;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HistoryFrame extends JFrame {
    JTextArea taHistory;

    public HistoryFrame(ArrayList<Booking> bookings) {
        setLayout(new FlowLayout());

        taHistory = new JTextArea(10, 40);
        taHistory.setEditable(false);

        add(new JScrollPane(taHistory));

        setTitle("Booking History");
        setSize(500, 300);
        setVisible(true);

        taHistory.setText("Booking History:\n");
        for (Booking b : bookings) {
            taHistory.append(b.toString() + "\n");
        }
    }
}