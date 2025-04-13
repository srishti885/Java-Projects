package com.booking.gui;

import com.booking.model.Booking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SeatSelectionFrame extends JFrame implements ActionListener {
    JLabel lblSeats, lblScreen;
    JButton btnConfirm, btnSelectTiming;
    JCheckBox[] rubySeats, emeraldSeats, diamondSeats, premiumSeats;
    String name, movie;
    int seats;
    ArrayList<Booking> bookings;
    JTextArea taOutput;
    String selectedTiming;

    public SeatSelectionFrame(String name, String movie, int seats, ArrayList<Booking> bookings, JTextArea taOutput) {
        this.name = name;
        this.movie = movie;
        this.seats = seats;
        this.bookings = bookings;
        this.taOutput = taOutput;

        setLayout(new BorderLayout());

        JPanel seatPanel = new JPanel(new GridLayout(4, 1));
        JPanel rubyPanel = new JPanel(new GridLayout(1, 6));
        JPanel emeraldPanel = new JPanel(new GridLayout(1, 6));
        JPanel diamondPanel = new JPanel(new GridLayout(1, 6));
        JPanel premiumPanel = new JPanel(new GridLayout(3, 6));

        rubySeats = new JCheckBox[6];
        emeraldSeats = new JCheckBox[6];
        diamondSeats = new JCheckBox[6];
        premiumSeats = new JCheckBox[18];

        // Adding labels for each category
        JLabel lblRuby = new JLabel("Ruby Seats (Rs 150)", SwingConstants.CENTER);
        lblRuby.setOpaque(true);
        lblRuby.setBackground(Color.RED);
        lblRuby.setForeground(Color.WHITE);
        rubyPanel.add(lblRuby);
        for (int i = 0; i < 6; i++) {
            rubySeats[i] = new JCheckBox("Ruby: Rs 150");
            rubySeats[i].setBackground(Color.RED);
            rubyPanel.add(rubySeats[i]);
        }

        JLabel lblEmerald = new JLabel("Emerald Seats (Rs 250)", SwingConstants.CENTER);
        lblEmerald.setOpaque(true);
        lblEmerald.setBackground(Color.GREEN);
        lblEmerald.setForeground(Color.WHITE);
        emeraldPanel.add(lblEmerald);
        for (int i = 0; i < 6; i++) {
            emeraldSeats[i] = new JCheckBox("Emerald: Rs 250");
            emeraldSeats[i].setBackground(Color.GREEN);
            emeraldPanel.add(emeraldSeats[i]);
        }

        JLabel lblDiamond = new JLabel("Diamond Seats (Rs 400)", SwingConstants.CENTER);
        lblDiamond.setOpaque(true);
        lblDiamond.setBackground(Color.BLUE);
        lblDiamond.setForeground(Color.WHITE);
        diamondPanel.add(lblDiamond);
        for (int i = 0; i < 6; i++) {
            diamondSeats[i] = new JCheckBox("Diamond: Rs 400");
            diamondSeats[i].setBackground(Color.BLUE);
            diamondPanel.add(diamondSeats[i]);
        }

        JLabel lblPremium = new JLabel("Premium Seats (Rs 500)", SwingConstants.CENTER);
        lblPremium.setOpaque(true);
        lblPremium.setBackground(Color.YELLOW);
        lblPremium.setForeground(Color.BLACK);
        premiumPanel.add(lblPremium);
        for (int i = 0; i < 18; i++) {
            premiumSeats[i] = new JCheckBox("Premium: Rs 500");
            premiumSeats[i].setBackground(Color.YELLOW);
            premiumPanel.add(premiumSeats[i]);
        }

        seatPanel.add(rubyPanel);
        seatPanel.add(emeraldPanel);
        seatPanel.add(diamondPanel);
        seatPanel.add(premiumPanel);

        lblScreen = new JLabel("Screen this way", SwingConstants.CENTER);
        lblScreen.setFont(new Font("Arial", Font.BOLD, 16));
        lblScreen.setForeground(Color.MAGENTA);

        btnSelectTiming = new JButton("Select Timing");
        btnSelectTiming.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] timings = {"---","10:00 AM", "1:00 PM", "4:00 PM","6:00 PM", "7:00 PM", "10:00 PM","11:00 PM"};
                selectedTiming = (String) JOptionPane.showInputDialog(
                        SeatSelectionFrame.this,
                        "Select Movie Timing:",
                        "Movie Timings",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        timings,
                        timings[0]
                );
            }
        });

        btnConfirm = new JButton("Confirm Seats");
        btnConfirm.addActionListener(this);

        add(lblScreen, BorderLayout.NORTH);
        add(seatPanel, BorderLayout.CENTER);
        add(btnSelectTiming, BorderLayout.EAST);
        add(btnConfirm, BorderLayout.SOUTH);

        setTitle("Select Seats");
        setSize(800, 600); // Increased frame size
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int selectedSeats = 0;
        for (JCheckBox checkBox : rubySeats) {
            if (checkBox.isSelected()) {
                selectedSeats++;
            }
        }
        for (JCheckBox checkBox : emeraldSeats) {
            if (checkBox.isSelected()) {
                selectedSeats++;
            }
        }
        for (JCheckBox checkBox : diamondSeats) {
            if (checkBox.isSelected()) {
                selectedSeats++;
            }
        }
        for (JCheckBox checkBox : premiumSeats) {
            if (checkBox.isSelected()) {
                selectedSeats++;
            }
        }

        if (selectedSeats == seats) {
            if (selectedTiming != null) {
                new PaymentFrame(name, movie, seats, bookings, taOutput);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a movie timing.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select exactly " + seats + " seats.");
        }
    }
}
