package View;


import Model.Maze;
import Model.Room;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 * Klasa aktualizująca widok przemieszczania się odkrywacza w labiryncie
 * @author kamil
 */
public class Panel extends Canvas {
    private int size;
    private int roomSize;
    private Room[][] rooms;
    private Window window;
    
    private int x_cord; 
    private int y_cord;
    private int x_Finder;
    private int y_Finder;//Ustawienie badacza
    
    private BufferedImage img_win = null;

    Random generator = new Random(); 
    private BufferedImage img_o = null;
    private  boolean start=true;
    
    {
        try { img_o = ImageIO.read(new File("odkrywca.png")); }
        catch (IOException e) { }
    }
    
    public Panel(Window window,int size){
            this.size=size;
            this.window=window;
            addKeyListener(KeyList);
            rooms=new Room[size][size];
            new Maze(size,rooms);
    }
    
    
    @Override
    public void paint(Graphics g) {            
        roomSize= getWidth()/(size+2);
        int x = x_cord= roomSize;
        int y = y_cord= roomSize;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size ; j++) {
                if (!(rooms[i][j].getNorth().isIsGone())) {
                    g.drawLine(x, y, x + roomSize, y);
                }

                if (rooms[i][j].getWest().isIsGone() == false) {
                    g.drawLine(x, y, x, y + roomSize);
                }
                if ((i == size - 1) && rooms[i][j].getSouth().isIsGone() == false) {
                    g.drawLine(x, y + roomSize, x + roomSize,y + roomSize);
                }
                if ((j == size - 1) && rooms[i][j].getEast().isIsGone() == false) {
                    g.drawLine(x + roomSize, y, x + roomSize,y + roomSize);
                }
                x += roomSize;
            }
            x = x_cord;
            y += roomSize;
        }
       if (start) random(g);
       else if (img_o != null) g.drawImage(img_o, y_Finder, x_Finder,roomSize,roomSize, this);
       if (img_win != null) g.drawImage(img_win, roomSize*size/4, roomSize*size/4,roomSize*size/2,roomSize*size/2, this);
    }
    
    
    /**
     * Klasa wewnetrzna nasłuchująca poruszanie się odkrywacza 
     */
    public KeyAdapter KeyList= new KeyAdapter(){
        @Override
        public void keyPressed (KeyEvent ev)
        {
            int x=(x_Finder-x_cord)/roomSize;
            int y=(y_Finder-y_cord)/roomSize;
            switch (ev.getKeyCode()){
            case KeyEvent.VK_UP:   
                if(rooms[x][y].getNorth().isIsGone()&& !rooms[x][y].isEnd()) x_Finder-=roomSize;
                break;
            case KeyEvent.VK_DOWN: 
                if(rooms[x][y].getSouth().isIsGone()&& !rooms[x][y].isEnd()) x_Finder+=roomSize;
                break;
            case KeyEvent.VK_RIGHT: 
                if(rooms[x][y].getEast().isIsGone()&& !rooms[x][y].isEnd()) y_Finder+=roomSize;
                break;
            case KeyEvent.VK_LEFT: 
                if(rooms[x][y].getWest().isIsGone()&& !rooms[x][y].isEnd()) y_Finder-=roomSize;
                break;
            }
            y=(x_Finder-x_cord)/roomSize;
            x=(y_Finder-y_cord)/roomSize;
            if (rooms[x][y].isEnd()) {
                try { img_win = ImageIO.read(new File("win.png")); }
                catch (IOException e) { }
            }
            window.getPanel().repaint();
        }
    };
       
     /**
     * Wysolowanie pozycji odkrywacza
     * @param g 
    */
    private void random(Graphics g){
        y_Finder=generator.nextInt(roomSize*size);
        x_Finder=generator.nextInt(roomSize*size);
        x_Finder=x_Finder-(x_Finder%roomSize);
        y_Finder=y_Finder-(y_Finder%roomSize);
        x_Finder=x_Finder+x_cord;
        y_Finder=y_Finder+y_cord;
        if (img_o != null) g.drawImage(img_o, y_Finder, x_Finder,roomSize,roomSize, window);
        start=false;
    }
    
    
    
}
