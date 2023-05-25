package com.practice;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;  

public class Window extends JFrame {
    JLabel heading;    
    JLabel clocktext;
    private Font font;   
    public Window(){
        String name= "Digital Clock";
        super.setTitle(name);
        super.setSize(500, 500);
        super.setLocation(700, 50);
        this.Gui();//Loading gui() method befor loading JFrame window
        //this.StartClock();
        this.StartClockByThread();
        super.setVisible(true);
        
        
    }
    public void Gui(){
        heading=new JLabel("Saikat's Clock");//Give heading using JLable
        heading.setFont(getFont());
        this.setLayout(new GridLayout(2,1));
        this.add(heading);
        clocktext=new JLabel("CLOCK--");
        clocktext.setFont(getFont());
        this.add(clocktext);
    }
    public Font getFont(){
        font= new Font("", Font.BOLD, 20);//making the font for text
        return font;
    }
    public void StartClock(){
        //Note:-import javax.swing.Timer not java.util.Timer
        Timer timmer = new Timer(1000,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               //String datetime = new Date().toString();
              // String datetime = new Date().toLocaleString();
              Date d = new Date();
              String pattern = "EEEEE MMMMM yyyy HH:mm:ss";
              SimpleDateFormat sdf = new SimpleDateFormat(pattern);
              String datetime =sdf.format(d);
               clocktext.setText(datetime);
            }
            
        });
        timmer.start();

    }
    public void StartClockByThread(){
        Thread t = new Thread(){
            public void run(){
                try{
                    while(true){
                        Date d = new Date();
                        String pattern = "EEEEE MMMMM yyyy HH:mm:ss";
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        String datetime =sdf.format(d);
                        clocktext.setText(datetime);
                        Thread.sleep(1000);

                    }

                }catch(Exception e){
                    e.printStackTrace();
    
                }

            }
            
            

        };
        t.start();
    }
}
