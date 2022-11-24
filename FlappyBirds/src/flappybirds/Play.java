
package flappybirds;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Play {
    
    private BufferedImage playgame;
    
    public Play(){
        try {
            playgame = ImageIO.read(new File("Assets/play.png"));
        } catch (IOException ex) {}
    }
    public void Paint4(Graphics2D g2){
        g2.drawImage(playgame, 250, 100, null);
    }   
}