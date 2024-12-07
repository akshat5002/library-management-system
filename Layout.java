package library;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Layout {
    public Component Layout() {

        JFrame frame = new JFrame();
		frame.setSize(700, 700);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.decode("#FF7722"));

        JLabel library = new JLabel("LIBRARY");
		library.setBounds(0, 30, 700, 40);
		library.setHorizontalAlignment(JLabel.CENTER);
		library.setFont(new Font("Monospaced", Font.BOLD, 40));
		JLabel man = new JLabel("MANAGEMENT SYSTEM");
		man.setBounds(0, 80, 700, 20);
		man.setHorizontalAlignment(JLabel.CENTER);
		man.setFont(new Font("Monospaced", Font.BOLD, 20));
		frame.add(man);
		frame.add(library);

        return frame;
    }
}
