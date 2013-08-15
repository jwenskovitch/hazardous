import java.awt.*;
import javax.swing.*;

class main {

    public static void main(String[] args) {

        try {
			JFrame frame = new JFrame("Potentially Hazardous Asteroids");
            GUI theProject = new GUI();
			frame.add(theProject);
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(frame);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setBackground(new Color(233, 233, 233));
            frame.setLocation(50, 50);
            frame.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
            frame.setResizable(false);
			frame.setVisible(true);
        } catch (Exception e) {
            System.out.println("An error occured...");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } //try-catch

    } //main

} //FinalProject