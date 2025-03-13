package main;

public class Main {
    Class<?> global;
    public Panel panel;
    public Main(Class<?> global) { 
       this.global = global;
       panel = new Panel(global);
       Frame frame = new Frame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 400, 400);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
    }
}