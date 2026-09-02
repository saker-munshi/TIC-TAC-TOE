// Import necessary packages... 
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

// Main class implementing ActionListener for handling button events. 
public class TicTacToe implements ActionListener {

    Random random = new Random(); // For randomly selecting which player starts
    JFrame frame = new JFrame("Tic Tac Toe"); // Main window
    JPanel title_panel = new JPanel(); // Panel to hold the title label
    JPanel button_panel = new JPanel(); // Panel to hold the game buttons
    JLabel textFiled = new JLabel(); // Displays current turn or result
    JButton[] buttons = new JButton[9]; // Array of buttons representing the game grid
    boolean player1_turn; // True if it's player 1's turn, otherwise false

    // Constructor
    TicTacToe() {
        // Setup the main frame.. 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        // Setup the title label 
        textFiled.setBackground(Color.CYAN);
        textFiled.setForeground(Color.BLACK);
        textFiled.setFont(new Font("Ink Free", Font.BOLD, 70));
        textFiled.setHorizontalAlignment(SwingConstants.CENTER);
        textFiled.setText("TIC-TAC-TOE");
        textFiled.setOpaque(true);

        // Setup title panel layout
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        // Setup grid for buttons (3x3)
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(Color.GRAY);

        // Create buttons and add to panel
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this); // Add action listener
        }

        // Add components to frame
        title_panel.add(textFiled);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        // Decide who plays first
        firstTurn();
    }

    // Handle button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("O"); // Player 1 is "O"
                        player1_turn = false;
                        textFiled.setText("X turn");
                        check(); // Check for a winner
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X"); // Player 2 is "X"
                        player1_turn = true;
                        textFiled.setText("O turn");
                        check(); // Check for a winner
                    }
                }
            }
        }
    }

    // Randomly determine who starts the game
    public void firstTurn() {
        try {
            Thread.sleep(2000); // Wait 2 seconds before starting
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textFiled.setText("X Turn");
        } else {
            player1_turn = false;
            textFiled.setText("O Turn");
        }
    }

    // Check all winning conditions
    public void check() { 
        // NOTE: The '==' operator is incorrect for string comparison.
        // Use `.equals()` instead, or it may not work reliably.

        // Check all winning combinations for X
        if (buttons[0].getText().equals("X") &&
            buttons[1].getText().equals("X") &&
            buttons[2].getText().equals("X")) {
            XWins(0, 1, 2);
        }
        if (buttons[3].getText().equals("X") &&
            buttons[4].getText().equals("X") &&
            buttons[5].getText().equals("X")) {
            XWins(3, 4, 5);
        }
        if (buttons[6].getText().equals("X") &&
            buttons[7].getText().equals("X") &&
            buttons[8].getText().equals("X")) {
            XWins(6, 7, 8);
        }
        if (buttons[0].getText().equals("X") &&
            buttons[3].getText().equals("X") &&
            buttons[6].getText().equals("X")) {
            XWins(0, 3, 6);
        }
        if (buttons[1].getText().equals("X") &&
            buttons[4].getText().equals("X") &&
            buttons[7].getText().equals("X")) {
            XWins(1, 4, 7);
        }
        if (buttons[2].getText().equals("X") &&
            buttons[5].getText().equals("X") &&
            buttons[8].getText().equals("X")) {
            XWins(2, 5, 8); // Fix index error here
        }
        if (buttons[0].getText().equals("X") &&
            buttons[4].getText().equals("X") &&
            buttons[8].getText().equals("X")) {
            XWins(0, 4, 8); // Fix index error here
        }
        if (buttons[2].getText().equals("X") &&
            buttons[4].getText().equals("X") &&
            buttons[6].getText().equals("X")) {
            XWins(2, 4, 6);
        }

        // Check all winning combinations for O
        if (buttons[0].getText().equals("O") &&
            buttons[1].getText().equals("O") &&
            buttons[2].getText().equals("O")) {
            OWins(0, 1, 2);
        }
        if (buttons[3].getText().equals("O") &&
            buttons[4].getText().equals("O") &&
            buttons[5].getText().equals("O")) {
            OWins(3, 4, 5);
        }
        if (buttons[6].getText().equals("O") &&
            buttons[7].getText().equals("O") &&
            buttons[8].getText().equals("O")) {
            OWins(6, 7, 8);
        }
        if (buttons[0].getText().equals("O") &&
            buttons[3].getText().equals("O") &&
            buttons[6].getText().equals("O")) {
            OWins(0, 3, 6);
        }
        if (buttons[1].getText().equals("O") &&
            buttons[4].getText().equals("O") &&
            buttons[7].getText().equals("O")) {
            OWins(1, 4, 7);
        }
        if (buttons[2].getText().equals("O") &&
            buttons[5].getText().equals("O") &&
            buttons[8].getText().equals("O")) {
            OWins(2, 5, 8); // Fix index error here
        }
        if (buttons[0].getText().equals("O") &&
            buttons[4].getText().equals("O") &&
            buttons[8].getText().equals("O")) {
            OWins(0, 4, 8); // Fix index error here
        }
        if (buttons[2].getText().equals("O") &&
            buttons[4].getText().equals("O") &&
            buttons[6].getText().equals("O")) {
            OWins(2, 4, 6);
        }
    }

    // Handle X win: highlight and disable buttons.
    public void XWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textFiled.setText("X wins");
    }

    // Handle O win: highlight and disable buttons.
    public void OWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textFiled.setText("O wins");
    }
}
