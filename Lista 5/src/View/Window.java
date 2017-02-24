package View;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * Interfejs graficzny gry Labirynt
 * @author Kamil
 */
public class Window extends Frame{
    Canvas panel;
    
    public Window(int size) {
        super("Maze");
        define(size);
        add();
        settings();
   }
    
    private void define(int size){
        panel=new Panel(this,size);
    }
    
    private void add(){
        add(panel);
    }
    
    private void settings(){
            setSize(500,500);
            setLocation(100,100);
            setVisible(true);
            setResizable(false);
            addWindowListener(new Close());
    } 
    
    private class Close extends WindowAdapter{
        @Override
        public void windowClosing (WindowEvent ev)
        {
            Window.this.dispose();
        }
    };
    
    public Canvas getPanel() {
        return panel;
    }
}
