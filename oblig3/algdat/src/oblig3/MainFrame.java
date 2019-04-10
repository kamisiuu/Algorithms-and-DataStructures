package oblig3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class MainFrame extends JFrame {
	private static int [] a;
	private JPanel contentPane;
	private JTextField textField_0;
	private JTextField textField_1;
	private TextArea textArea;
	private JButton btnSort;
	private JRadioButton rdbtnInsertionSort;
	private JRadioButton rdbtnQuickSort;
	private JRadioButton rdbtnMergeSort;
	private JRadioButton rdbtnRadixSort;
	private JButton btnClear;
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

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Make an array");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String size=textField_0.getText();
				String maxR=textField_1.getText();
				
				int s=0;
				int max=0;
			
				try {
					s=Integer.parseInt(size);
					max=Integer.parseInt(maxR);

					
				} catch (Exception e2) {
				
				}
				Main.FillArray(s, max);
				textArea.setText(Arrays.toString(Main.getA()));
			}
		});
		btnNewButton.setBounds(184, 101, 123, 25);
		contentPane.add(btnNewButton);
		
		textField_0 = new JTextField();
		textField_0.setBounds(184, 48, 43, 22);
		contentPane.add(textField_0);
		textField_0.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(258, 48, 43, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSize = new JLabel("size");
		lblSize.setBounds(184, 23, 56, 16);
		contentPane.add(lblSize);
		
		JLabel lblMaxRange = new JLabel("Max Range");
		lblMaxRange.setBounds(258, 23, 63, 16);
		contentPane.add(lblMaxRange);
		
		textArea = new TextArea();
		textArea.setBounds(28, 274, 698, 180);
		contentPane.add(textArea);
		
		btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message="mesage";
				try {
					
				
			
				if(rdbtnInsertionSort.isSelected()){
					double startTime= System.nanoTime();
					InsertionSort.InsertionSort(Main.a);
					
					double endTime= System.nanoTime();
					double TotalTime= ( endTime - startTime )/1000000;
					//textArea.append("\n"+Arrays.toString(Main.getA())+" InsertionSort used "+TotalTime+" ms");
					double C= TotalTime / Main.a.length;
					textArea.append("\n"+"InsertionSort used "+TotalTime+" ms , konstanten C for best case er = "+C);
				}else if(rdbtnMergeSort.isSelected()){
					double startTime= System.nanoTime();
					MerginSort.MergingOfSort(Main.a, 0, Main.a.length);
					double endTime= System.nanoTime();
					double TotalTime= ( endTime - startTime )/1000000;
					double C= TotalTime /(Main.a.length* Math.log(Main.a.length));
					textArea.append("\n"+" MergeSort used "+TotalTime+" ms , konstanten C for best case er = "+C);
					
					
				}else if(rdbtnQuickSort.isSelected()){
					double startTime= System.nanoTime();
					QuickSort.randomizedSort(Main.a, 0, Main.a.length);
					double endTime= System.nanoTime();
					double TotalTime= ( endTime - startTime )/1000000;
					double C= TotalTime /(Main.a.length* Math.log(Main.a.length));
					textArea.append("\n"+" QuickSort used "+TotalTime+" ms , konstanten C for best case er = "+C);
				}else if(rdbtnRadixSort.isSelected()){
					double startTime= System.nanoTime();
					RadixSort.sort(Main.a, 3);
					double endTime= System.nanoTime();
					double TotalTime= ( endTime - startTime )/1000000;
					double C= TotalTime /(Main.a.length* Math.log(Main.a.length));
					textArea.append("\n"+" RadixSort used "+TotalTime+" ms , konstanten C for best case er = "+C);
				
				}} catch (Exception e2) {
					textArea.setText("u have to make an array");
				}
			}
		});
		btnSort.setBounds(184, 217, 97, 25);
		contentPane.add(btnSort);
		
		rdbtnInsertionSort = new JRadioButton("Insertion Sort");
		rdbtnInsertionSort.setBounds(112, 148, 127, 25);
		contentPane.add(rdbtnInsertionSort);
		
		rdbtnQuickSort = new JRadioButton("Quick Sort");
		rdbtnQuickSort.setBounds(258, 148, 127, 25);
		contentPane.add(rdbtnQuickSort);
		
		rdbtnMergeSort = new JRadioButton("Merge Sort");
		rdbtnMergeSort.setBounds(113, 178, 127, 25);
		contentPane.add(rdbtnMergeSort);
		
		 rdbtnRadixSort = new JRadioButton("Radix Sort");
		rdbtnRadixSort.setBounds(258, 178, 127, 25);
		contentPane.add(rdbtnRadixSort);
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnInsertionSort);
		btnGroup.add(rdbtnMergeSort);
		btnGroup.add(rdbtnQuickSort);
		btnGroup.add(rdbtnRadixSort);
		
		btnClear = new JButton("clear ");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				Main.setA(null);
			}
		});
		btnClear.setBounds(325, 217, 97, 25);
		contentPane.add(btnClear);
	}
}
