import java.awt.*;
import java.awt.event.*;

public class ScientificCalculator extends Frame implements ActionListener {
    TextField display;
    double num1, num2, result;
    int operator;
    boolean isOn = true;

    public ScientificCalculator() {
        setLayout(new BorderLayout());

        display = new TextField();
        add(display, BorderLayout.NORTH);

        Panel panel = new Panel();
        panel.setLayout(new GridLayout(7, 4)); // Adjusted grid layout to accommodate more buttons

        String[] buttons = {
                "sin", "cos", "tan", "on",
                "log", "hyp", "del", "sqrt",
                "eng", "nCr", "^", "C",
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "+", "="
        };

        for (String text : buttons) {
            Button button = new Button(text);
            button.setBackground(Color.lightGray); // Set button color
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);

        setTitle("Scientific Calculator");
        setSize(400, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("on")) {
            isOn = true;
            display.setEnabled(true);
        }

        if (isOn) {
            if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
                display.setText(display.getText() + command);
            } else if (command.equals("C")) {
                display.setText("");
            } else if (command.equals("del")) {
                String currentText = display.getText();
                if (!currentText.isEmpty()) {
                    display.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else if (command.equals("=")) {
                num2 = Double.parseDouble(display.getText());
                switch (operator) {
                    case 1:
                        result = num1 + num2;
                        break;
                    case 2:
                        result = num1 - num2;
                        break;
                    case 3:
                        result = num1 * num2;
                        break;
                    case 4:
                        result = num1 / num2;
                        break;
                    case 5:
                        result = Math.pow(num1, num2);
                        break;
                }
                display.setText(String.valueOf(result));
            } else if (command.equals("sin")) {
                display.setText(String.valueOf(Math.sin(Double.parseDouble(display.getText()))));
            } else if (command.equals("cos")) {
                display.setText(String.valueOf(Math.cos(Double.parseDouble(display.getText()))));
            } else if (command.equals("tan")) {
                display.setText(String.valueOf(Math.tan(Double.parseDouble(display.getText()))));
            } else if (command.equals("sqrt")) {
                display.setText(String.valueOf(Math.sqrt(Double.parseDouble(display.getText()))));
            } else if (command.equals("log")) {
                display.setText(String.valueOf(Math.log(Double.parseDouble(display.getText()))));
            } else if (command.equals("hyp")) {
                String[] nums = display.getText().split(",");
                if (nums.length == 2) {
                    double a = Double.parseDouble(nums[0]);
                    double b = Double.parseDouble(nums[1]);
                    display.setText(String.valueOf(Math.hypot(a, b)));
                }
            } else if (command.equals("eng")) {
                display.setText(String.format("%e", Double.parseDouble(display.getText())));
            } else if (command.equals("nCr")) {
                String[] nums = display.getText().split(",");
                if (nums.length == 2) {
                    int n = Integer.parseInt(nums[0]);
                    int r = Integer.parseInt(nums[1]);
                    display.setText(String.valueOf(combination(n, r)));
                }
            } else if (command.equals("^")) {
                num1 = Double.parseDouble(display.getText());
                display.setText("");
                operator = 5;
            } else {
                num1 = Double.parseDouble(display.getText());
                display.setText("");
                switch (command) {
                    case "+":
                        operator = 1;
                        break;
                    case "-":
                        operator = 2;
                        break;
                    case "*":
                        operator = 3;
                        break;
                    case "/":
                        operator = 4;
                        break;
                }
            }
        }
    }

    private int factorial(int n) {
        if (n == 0) return 1;
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    private int combination(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }
}