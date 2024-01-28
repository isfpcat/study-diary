package lesson;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Lesson3 {

	private JFrame frame;
	private JTextField textFieldTitle;
	private JTextField textFieldContent;
	private JTextField textFieldUsage;
	private JLabel lbTitle;
	private JLabel lbContent;
	private JLabel lbUsage;
	private final String fileName = "./data.csv";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lesson3 window = new Lesson3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Lesson3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		
		JButton btnNewButton = new JButton("저장");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter fw = new FileWriter(fileName, true);
					boolean fileExists = new File(fileName).exists();
					if (!fileExists) {
						fw.append("Title, Content, Usage\n");
					}
					String title = textFieldTitle.getText();
					String content = textFieldContent.getText();
					String usage = textFieldUsage.getText();
					fw.append(title + "," + content + "," + usage + "\n");
					fw.close();
					
					textFieldTitle.setText("");
					textFieldContent.setText("");
					textFieldUsage.setText("");
					JOptionPane.showMessageDialog(null, "Data Saved Successfully.");
	
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "There was an error while writing the data.");
				}
			}
		});
		
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton.setBounds(351, 233, 73, 39);
		frame.getContentPane().add(btnNewButton);
		
		lbTitle = new JLabel("제목");
		lbTitle.setBounds(6, 16, 73, 25);
		frame.getContentPane().add(lbTitle);
		
		lbContent = new JLabel("내용");
		lbContent.setBounds(6, 72, 73, 25);
		frame.getContentPane().add(lbContent);
		
		lbUsage = new JLabel("활용처");
		lbUsage.setBounds(6, 128, 73, 25);
		frame.getContentPane().add(lbUsage);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setBounds(78, 6, 220, 44);
		frame.getContentPane().add(textFieldTitle);
		textFieldTitle.setColumns(10);
		
		textFieldContent = new JTextField();
		textFieldContent.setColumns(10);
		textFieldContent.setBounds(78, 62, 220, 44);
		frame.getContentPane().add(textFieldContent);
		
		textFieldUsage = new JTextField();
		textFieldUsage.setColumns(10);
		textFieldUsage.setBounds(78, 118, 220, 44);
		frame.getContentPane().add(textFieldUsage);
	}
}
