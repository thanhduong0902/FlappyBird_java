/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flappybirds;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import pkg2dgamesframework.QueueList;

/**
 *
 * @author DUONG THANH
 */
public class ChimneyGroup {
    
    private QueueList<Chimney> chimneys;
    private QueueList<Plant>plants;
    private BufferedImage chimneyImage,chimneyImage2,plantImage,plantImage2;
    public static int SIZE = 6;
    
    public Chimney getChimney(int i){
        return chimneys.get(i);
    }
    public Plant getPlant(int i){
        return plants.get(i);
    }
    private int distance = 300;
    private int topChimneyY = -300;
    private int bottomChimneyY = 300;
    
    
    public int getRandomY(){
        Random random = new Random();
        int a;
        a = random.nextInt(10)+1;
        
        return a*20;
    }
    public int getRandomX(){
        Random random = new Random();
        int z;
        z = random.nextInt(6);
        
        return z;
    }
    
    public ChimneyGroup(){
        
        try{
            chimneyImage = ImageIO.read(new File("Assets/chimney.png"));
            chimneyImage2 = ImageIO.read(new File("Assets/chimney2.png"));
            plantImage = ImageIO.read(new File("Assets/plant.png"));
            plantImage2 = ImageIO.read(new File("Assets/plant_.png"));

        } catch (IOException ex){}
        chimneys = new QueueList<Chimney>();
        Chimney cn;
        plants = new QueueList<Plant>();
        
        Plant pl;
        for (int i=0;i<SIZE/2;i++){
            int deltaY = getRandomY();
            cn = new Chimney(830+i*distance,bottomChimneyY +deltaY,74,400);
            chimneys.push(cn);
            pl = new Plant(830+i*distance-10,bottomChimneyY+deltaY,74,100);
            plants.push(pl);
            
            
            cn = new Chimney(830+i*distance,topChimneyY +deltaY,74,400);
            chimneys.push(cn);
            pl = new Plant(830+i*distance, topChimneyY+deltaY, 74, 100);
            plants.push(pl);
            
        }
        
    }
    public void resetChimneys(){
        chimneys = new QueueList<Chimney>();
        Chimney cn;
        plants = new QueueList<Plant>();
        
        Plant pl;
        for (int i=0;i<SIZE/2;i++){
            int deltaY = getRandomY();
            cn = new Chimney(830+i*distance,bottomChimneyY +deltaY,74,400);
            chimneys.push(cn);
            pl = new Plant(830+i*distance-10,bottomChimneyY+deltaY,74,100);
            plants.push(pl);
            
            
            cn = new Chimney(830+i*distance,topChimneyY +deltaY,74,400);
            chimneys.push(cn);
            pl = new Plant(830+i*distance, topChimneyY+deltaY, 74, 100);
            plants.push(pl);
        }
    }
    
    public void update(){
        for(int i=0;i<SIZE;i++){
            System.out.printf("%d %d", (int)plants.get(i).getPosY(), (int)chimneys.get(i).getPosY());
            chimneys.get(i).update();
            plants.get(i).update();
            if((int)plants.get(i).getPosY()+100==(int)chimneys.get(i).getPosY()) plants.get(i).setGrow(false);
            if(i%2==0 && plants.get(i).getGrow())
                plants.get(i).update2();
            
        }
        
        
//            int a = getRandomX();
//            if(a%2==0)
//                plants.get(a).update2();
//            else plants.get(a).update();
        
        
        
            if(chimneys.get(0).getPosX()<-74){
            int deltaY = getRandomY();
            
            Chimney cn;
            cn = chimneys.pop();
            cn.setPosX(chimneys.get(4).getPosX() + distance);
            cn.setPosY(bottomChimneyY + deltaY);
            cn.setIsBehindBird(false);
            chimneys.push(cn);
            
            Plant pl;
            pl = plants.pop();
            pl.setPosX(chimneys.get(4).getPosX()+distance-10);
            pl.setPosY(bottomChimneyY+deltaY);
            pl.setGrow(false);
            plants.push(pl);
            
            cn = chimneys.pop();
            cn.setPosX(chimneys.get(4).getPosX());
            cn.setPosY(topChimneyY + deltaY);
            cn.setIsBehindBird(false);
            chimneys.push(cn);
            
            
            pl = plants.pop();
            pl.setPosX(plants.get(4).getPosX());
            pl.setPosY(topChimneyY+deltaY);
            pl.setGrow(false);
            plants.push(pl);
                

            
        }
    }
    
    public void paint (Graphics2D g2){
        for(int i=0;i<SIZE;i++){
            if(i%2==0){
                g2.drawImage(plantImage, (int)plants.get(i).getPosX(), (int)plants.get(i).getPosY(),null);
            g2.drawImage(chimneyImage, (int )chimneys.get(i).getPosX(), (int)chimneys.get(i).getPosY(), null);
            }
            else{
                g2.drawImage(plantImage2, (int)plants.get(i).getPosX(), (int)plants.get(i).getPosY(),null);
                g2.drawImage(chimneyImage2, (int )chimneys.get(i).getPosX(), (int)chimneys.get(i).getPosY(), null);
            }
        }
    }
}
