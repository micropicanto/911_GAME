import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Image airplaneImage, background, building;
    private Timer timer;
    private int airplaneY = 250, score = 0, highScore = 0;
    private int buildingX = 800, buildingGap = 200, buildingY = 300;
    private boolean gameRunning = false;
    private boolean gameOver = false;
    private boolean showStartMessage = true;

    public GamePanel() {
        loadImages();
        timer = new Timer(20, this); // 50 FPS
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setBackground(Color.CYAN); // Set background color for the panel
    }

    private void loadImages() {
        try {
            airplaneImage = ImageIO.read(getClass().getResource("/Images/airplane.png"));
            background = ImageIO.read(getClass().getResource("/Images/background.png"));
            building = ImageIO.read(getClass().getResource("/Images/building.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw background
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

        // Draw airplane
        g.drawImage(airplaneImage, 100, airplaneY, this);

        // Draw building
        g.drawImage(building, buildingX, buildingY, 80, getHeight() - buildingY, this);
        g.drawImage(building, buildingX, 0, 80, buildingY - buildingGap, this);

        // Draw score and high score
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 20)); // Adjusted font size
        g.drawString("Score: " + score, 10, 20);
        g.drawString("High Score: " + highScore, 10, 50);

        // Start message at the bottom
        if (showStartMessage) {
            g.setFont(new Font("Arial", Font.PLAIN, 16));
            g.drawString("Press SPACE to Start", getWidth() / 2 - 80, getHeight() - 20); // Positioned at bottom center
        }

        // Game Over message at the center
        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30)); // Larger font for game over
            g.drawString("Game Over!", getWidth() / 2 - 100, getHeight() / 2 - 20); // Positioned at the center
            g.setFont(new Font("Arial", Font.PLAIN, 20)); // Smaller font for restart instruction
            g.drawString("Press R to Restart", getWidth() / 2 - 90, getHeight() - 20); // Positioned at the bottom
        }
    }

    private void resetGame() {
        airplaneY = 250;
        buildingX = 800;
        score = 0;
        gameOver = false;
        gameRunning = true;
        showStartMessage = false; // Hide start message after starting the game
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameRunning) {
            // Move building to the left
            buildingX -= 5;
            if (buildingX < -80) {
                buildingX = 800;
                buildingY = 200 + (int)(Math.random() * 200);
                score++;
                if (score > highScore) highScore = score;
            }

            // Check collision
            if ((100 + airplaneImage.getWidth(null) > buildingX && 100 < buildingX + 80) &&
                    (airplaneY < buildingY - buildingGap || airplaneY + airplaneImage.getHeight(null) > buildingY)) {
                gameOver = true;
                gameRunning = false;
            }

            // Gravity effect
            airplaneY += 3;
            if (airplaneY > getHeight() - airplaneImage.getHeight(null)) {
                airplaneY = getHeight() - airplaneImage.getHeight(null);
                gameOver = true;
                gameRunning = false;
            }

            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE && !gameRunning && !gameOver) {
            resetGame();
        } else if (key == KeyEvent.VK_SPACE && gameRunning) {
            airplaneY -= 20; // Flap upwards
        }

        if (key == KeyEvent.VK_R && gameOver) {
            resetGame();
        }

        if (key == KeyEvent.VK_UP) {
            airplaneY -= 15;
        }

        if (key == KeyEvent.VK_DOWN) {
            airplaneY += 15;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}