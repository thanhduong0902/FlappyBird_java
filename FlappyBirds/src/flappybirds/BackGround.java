
package flappybirds;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class BackGround {
    
    private BufferedImage background;
    
    public BackGround(){
        try {
            background = ImageIO.read(new File("Assets/background.png"));
        } catch (IOException ex) {}
    }
    public void Paint2(Graphics2D g2){
        g2.drawImage(background, 0, 0, null);
    }   
}