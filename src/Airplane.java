import java.awt.*;

public class Airplane {
    private int x, y;
    private int width = 60, height = 30;
    private int speedY = 0;
    private int gravity = 1;

    public Airplane(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void update() {
        speedY += gravity;
        y += speedY;
    }

    public void jump() {
        speedY = -10; // Makes airplane go up when called
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }
}
