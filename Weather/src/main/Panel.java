package main;

import APIStuff.RunAPI;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener {
    public BufferedImage cloud;
    public BufferedImage pin;
    Class<?> global;
    String temperature = "0";
    JComboBox box1 = new JComboBox();
    RunAPI runAPI = new RunAPI();
    String[] temperatures = new String[6];
    public Panel(Class<?> global) {
        this.global=global;
        setLayout(null);
        setBackground(new Color(55, 109, 173));
        
        Thread cool6 = new Thread(() -> {
            runAPI.setAPI(runAPI.LosAngeles);
            runAPI.call();
            temperature = runAPI.finalRes;
            temperature = "0";
            repaint();
        });
        cool6.start();
       
        
        box1.addItem("Los Angeles");
        box1.addItem("New York");
        box1.addItem("Zurich");
        box1.addItem("Paris");
        box1.addItem("Miami");
        box1.addItem("Dallas");

        add(box1);
        box1.addActionListener(this);
        box1.setBounds(125, 275, 150, 100);
        box1.setFocusable(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //draw the ...

        try {
            cloud=ImageIO.read(global.getResourceAsStream("res/afuckingcloud.png"));
            g.drawImage(cloud, 50, 130, 50, 50, null);
        } catch (IOException e) {
            System.out.println("unable to read image");
        }

        try {
            pin=ImageIO.read(global.getResourceAsStream("res/pin.png"));
            g.drawImage(pin, 50, 275, 50, 50, null);
        } catch (IOException e) {
        }
        
        try {
            
        } catch (Exception e) {
        }

        g.setFont(new Font("Comic Sans", 1, 75));
        g.drawString(""+temperature, 160, 180);

    }

    public void initTemperatures() {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==box1) {
            switch(box1.getSelectedIndex()) {
                case 0 -> {
                    Thread cool = new Thread(() -> {
                        runAPI.setAPI(runAPI.LosAngeles);
                        runAPI.call();
                        temperature = runAPI.finalRes;
                        repaint();
                    });
                    cool.start();
                    
                  
                }
                case 1 -> {
                    Thread cool1 = new Thread(() -> {
                        runAPI.setAPI(runAPI.NewYork);
                        runAPI.call();
                        temperature = runAPI.finalRes;
                        repaint();
                    });
                    cool1.start();
                    
                 
                }
                case 2 -> {
                    Thread cool2 = new Thread(() -> {
                        runAPI.setAPI(runAPI.Zurich);
                        runAPI.call();
                        temperature = runAPI.finalRes;
                        repaint();
                    });
                    cool2.start();
                   
                    
                }
                case 3 -> {
                    Thread cool3 = new Thread(() -> {
                        runAPI.setAPI(runAPI.Paris);
                        runAPI.call();
                        temperature = runAPI.finalRes;
                        repaint();
                    });
                    cool3.start();
                    
                }
                case 4 -> {
                    Thread cool4 = new Thread(() -> {
                        runAPI.setAPI(runAPI.Miami);
                        runAPI.call();
                        temperature = runAPI.finalRes;
                        repaint();
                    });
                    cool4.start();
                    
                }
                case 5 -> {
                    Thread cool5 = new Thread(() -> {
                        runAPI.setAPI(runAPI.Dallas);
                        runAPI.call();
                        temperature = runAPI.finalRes;
                        repaint();
                    });
                    cool5.start();
                   
                }
                default -> {
                }
            }
        }
    }
    
}
