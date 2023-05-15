package com.practice;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;  

public class Window extends JFrame {
    JLabel heading = new JLabel();    
    JLabel Clocktext;
    private Font font;   
    public Window(){
        String name= "Digital Clock";
        super.setTitle(name);
        super.setSize(500, 500);
        super.setLocation(700, 50);
        this.Gui();
        super.setVisible(true);
        
        
    }
    public void Gui(){
        heading.setFont(getFont());
    }
    public Font getFont(){
        font= new Font("", Font.BOLD, 20);
        return font;
    }
    
}
