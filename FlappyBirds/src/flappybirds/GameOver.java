
package flappybirds;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameOver {

    private BufferedImage gameover;

    public GameOver() {
        try {
            gameover = ImageIO.read(new File("Assets/gameover.png"));
        } catch (IOException ex) {
        }
    }

    public void Paint3(Graphics2D g2) {
        g2.drawImage(gameover, 250, 100, null);
        ;
    }
}