import javax.swing.*;
import java.awt.*;

public class AirplaneGame {
    public static void main(String[] args) {
        // Create the frame for the game window
        JFrame frame = new JFrame("Airplane Game");

        // Set the game panel and add it to the frame
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);

        // Set the frame size and make it visible
        frame.setSize(800, 600); // Adjust as per your preference
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setResizable(false); // Prevent window resizing
        frame.setBackground(Color.CYAN); // Set background color (optional)

        // Set the frame visibility
        frame.setVisible(true);
    }
}
