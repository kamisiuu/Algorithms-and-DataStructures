package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.awt.TexturePaint;

import Main.MainClass;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import javax.swing.JTextPane;
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextPane textPane;
	static int [] a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private static int[] ChooseArray(int a, int b){
		int []array=new int [a];
		
		for(int i=0;i<array.length;i++){
		array[i]=new Random().nextInt(b);
		
		}
		return array;
	}
	/**
	 * Create the frame.
	 */
	
	public MainFrame() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseArray = new JLabel("Choose array");
		lblChooseArray.setBounds(26, 47, 86, 16);
		contentPane.add(lblChooseArray);
		
		JLabel lblArraySize = new JLabel("array size");
		lblArraySize.setBounds(188, 47, 56, 16);
		contentPane.add(lblArraySize);
		
		textField_1 = new JTextField();
		textField_1.setBounds(256, 44, 56, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("number range");
		lblNewLabel.setBounds(324, 47, 81, 16);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(417, 44, 56, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblChooseSortingAlgorithm = new JLabel("Choose sorting algorithm");
		lblChooseSortingAlgorithm.setBounds(40, 122, 155, 16);
		contentPane.add(lblChooseSortingAlgorithm);
		
		JButton btnNewButton = new JButton("Make an array with numbers");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String size=textField_1.getText();
				String range=textField_2.getText();
				int s = 0;
				int r = 0;
				try {
					s=Integer.parseInt(size);
					r=Integer.parseInt(range);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				a=ChooseArray(s, r);
				String b=Arrays.toString(a);
				textPane.setText(b);
			}
		});
		btnNewButton.setBounds(103, 79, 206, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sort");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(191, 180, 97, 25);
		contentPane.add(btnNewButton_1);
		
	 textPane = new JTextPane();
		textPane.setBounds(80, 292, 346, 85);
		contentPane.add(textPane);
	}
}
