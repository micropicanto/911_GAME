import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Building {
    private int x, y; // Position coordinates for the building
    private Image image;

    public Building(int x, int y) {
        this.x = x;
        this.y = y;
        loadBuildingImage();
    }

    private void loadBuildingImage() {
        try {
            image = ImageIO.read(getClass().getResource("/Images/building.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
