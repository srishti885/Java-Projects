import java.awt.*;
import java.awt.event.*;
public class TicTacToe extends Frame implements ActionListener {
    private static final long serialVersionUID = 1L;
    Button[] buttons = new Button[9];
    int player = 1;

    public TicTacToe() {
        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new Button("");
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 60));
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }
        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button buttonClicked = (Button) e.getSource();
        if (buttonClicked.getLabel().equals("")) {
            if (player == 1) {
                buttonClicked.setLabel("X");
                player = 2;
            } else {
                buttonClicked.setLabel("O");
                player = 1;
            }
            checkWinner();
        }
    }

    public void checkWinner() {
        for (int i = 0; i < 8; i++) {
            String line = null;
            switch (i) {
                case 0:
                    line = buttons[0].getLabel() + buttons[1].getLabel() + buttons[2].getLabel();
                    break;
                case 1:
                    line = buttons[3].getLabel() + buttons[4].getLabel() + buttons[5].getLabel();
                    break;
                case 2:
                    line = buttons[6].getLabel() + buttons[7].getLabel() + buttons[8].getLabel();
                    break;
                case 3:
                    line = buttons[0].getLabel() + buttons[3].getLabel() + buttons[6].getLabel();
                    break;
                case 4:
                    line = buttons[1].getLabel() + buttons[4].getLabel() + buttons[7].getLabel();
                    break;
                case 5:
                    line = buttons[2].getLabel() + buttons[5].getLabel() + buttons[8].getLabel();
                    break;
                case 6:
                    line = buttons[0].getLabel() + buttons[4].getLabel() + buttons[8].getLabel();
                    break;
                case 7:
                    line = buttons[2].getLabel() + buttons[4].getLabel() + buttons[6].getLabel();
                    break;
            }
            if (line.equals("XXX")) {
                System.out.println("Player 1 wins!");
                System.exit(0);
            } else if (line.equals("OOO")) {
                System.out.println("Player 2 wins!");
                System.exit(0);
            }
        }
        boolean draw = true;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getLabel().equals("")) {
                draw = false;
                break;
            }
        }
        if (draw) {
            System.out.println("It's a draw!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}