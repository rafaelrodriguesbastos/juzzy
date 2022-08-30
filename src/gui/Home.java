/*
 * Home.java - Simple GUI for Juzzy
 * 2022-08-29
 * Rafael Bastos
*/
package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import examples.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class Home {

	private JFrame frmGuiForJuzzy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmGuiForJuzzy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGuiForJuzzy = new JFrame();
		frmGuiForJuzzy.setTitle("Simple GUI for Juzzy");
		frmGuiForJuzzy.setBounds(100, 100, 689, 396);
		frmGuiForJuzzy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuiForJuzzy.getContentPane().setLayout(null);
		
		JLabel lblExemplo = new JLabel("Exemplo");
		lblExemplo.setAlignmentY(Component.TOP_ALIGNMENT);
		lblExemplo.setBounds(12, 12, 70, 15);
		frmGuiForJuzzy.getContentPane().add(lblExemplo);

		JTextArea txtLegenda = new JTextArea();
		txtLegenda.setBackground(SystemColor.window);
		txtLegenda.setText("launches a Type-1 Fuzzy Logic System");
		txtLegenda.setLineWrap(true);
		txtLegenda.setBounds(12, 310, 536, 37);
		frmGuiForJuzzy.getContentPane().add(txtLegenda);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				String example = comboBox.getSelectedItem().toString();
				
		        if(example.equals("type1"))
		        	txtLegenda.setText("launches a Type-1 Fuzzy Logic System");
		        else if(example.equals("NStype1"))
		        	txtLegenda.setText("launches a Non Singleton Type-1 Fuzzy Logic System");
		        else if(example.equals("type1-2outputs"))
		        	txtLegenda.setText("launches a Type-1 Fuzzy Logic System with 2 outputs");
		        else if(example.equals("intervalT2"))
		        	txtLegenda.setText("launches a Interval Type-2 Fuzzy Logic System");
		        else if(example.equals("type1NSintervalT2"))
		        	txtLegenda.setText("launches a type-1 Non Singleton Interval Type-2 Fuzzy Logic System");
		        else if(example.equals("IT2NSintervalT2"))
		        	txtLegenda.setText("launches a Interval Type-2 Non Singleton Interval Type-2 Fuzzy Logic System");
		        else if(example.equals("intervalT2-2outputs"))
		        	txtLegenda.setText("launches a Interval Type-2 Fuzzy Logic System with 2 output");
		        else if(example.equals("zSlicesGT2"))
		        	txtLegenda.setText("launches a zSlices based General Type-2 Fuzzy Logic System");
		        else if(example.equals("type1NSzSlicesGT2"))
		        	txtLegenda.setText("launches a zSlices based type-1 Non Singleton General Type-2 Fuzzy Logic System");
		        else if(example.equals("IT2NSzSlicesGT2"))
		        	txtLegenda.setText("launches a zSlices based IT2 Non Singleton General Type-2 Fuzzy Logic System");
		        else if(example.equals("GT2NSzSlicesGT2"))
		        	txtLegenda.setText("launches a zSlices based GT2 Non Singleton General Type-2 Fuzzy Logic System");
		        else if(example.equals("zSlicesGT2MC"))
		        	txtLegenda.setText("launches a zSlices based General Type-2 Fuzzy Logic System in MultiCore Mode");
		        else if(example.equals("zSlicesGT2MC-2outputs"))
		        	txtLegenda.setText("launches a zSlices based General Type-2 Fuzzy Logic System with 2 outputs in MultiCore Mode");

			}
		});
		comboBox.setAlignmentY(Component.TOP_ALIGNMENT);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"type1", "NStype1", "type1-2outputs", "intervalT2", "type1NSintervalT2", "IT2NSintervalT2", "intervalT2-2outputs", "zSlicesGT2", "type1NSzSlicesGT2", "IT2NSzSlicesGT2", "GT2NSzSlicesGT2", "zSlicesGT2MC", "zSlicesGT2MC-2outputs"}));
		comboBox.setBounds(100, 12, 199, 24);
		frmGuiForJuzzy.getContentPane().add(comboBox);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 43, 665, 255);
		frmGuiForJuzzy.getContentPane().add(textArea);
		
		PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
		System.setOut(printStream);
		System.setErr(printStream);
		
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String example = comboBox.getSelectedItem().toString();
				
		        if(example.equals("type1"))
		            new SimpleT1FLS();
		        else if(example.equals("NStype1"))
		            new SimpleNST1FLS();
		        else if(example.equals("type1-2outputs"))
		            new SimpleT1FLS_twoOutputs();        
		        else if(example.equals("intervalT2"))
		            new SimpleIT2FLS();
		        else if(example.equals("type1NSintervalT2"))
		            new SimpleNST1IT2FLS();
		        else if(example.equals("IT2NSintervalT2"))
		            new SimpleNSIT2_IT2FLS();
		        else if(example.equals("intervalT2-2outputs"))
		            new SimpleIT2FLS_twoOutputs();        
		        else if(example.equals("zSlicesGT2"))
		            new SimplezGT2FLS();
		        else if(example.equals("type1NSzSlicesGT2"))
		            new SimplezGT2FLSNST1();
		        else if(example.equals("IT2NSzSlicesGT2"))
		            new SimplezGT2FLSNSIT2();
		        else if(example.equals("GT2NSzSlicesGT2"))
		            new SimplezGT2FLSNSGT2();
		        else if(example.equals("zSlicesGT2MC"))
		            new SimplezGT2FLS_Multicore();    
		        else if(example.equals("zSlicesGT2MC-2outputs"))
		            new SimplezGT2FLS_Multicore_twoOutputs();          
			}
		});
		btnRun.setAlignmentY(Component.TOP_ALIGNMENT);
		btnRun.setBounds(321, 12, 117, 25);
		frmGuiForJuzzy.getContentPane().add(btnRun);
	
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnClear.setBounds(560, 322, 117, 25);
		frmGuiForJuzzy.getContentPane().add(btnClear);
		
	}
}
