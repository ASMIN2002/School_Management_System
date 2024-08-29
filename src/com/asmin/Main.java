package com.asmin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Main extends JFrame implements ActionListener{

	JButton addstu,searchstu,updatestu,deletedtu,exit;
	
	Main(){
		
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/class.jpeg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel title = new JLabel("SARASWATA GURUKULA SIKSHYA KENDRA");
		title.setFont(new Font("Raleway", Font.BOLD, 32));
		title.setBounds(100, 50, 700, 30);
		title.setForeground(Color.BLUE);
		image.add(title);
		
		addstu = new JButton("ADD STUDENT");
		addstu.setBounds(80, 130, 150, 30);
		addstu.setForeground(Color.WHITE);
		addstu.setBackground(Color.BLACK);
		addstu.setFocusable(false);
	    addstu.addActionListener(this);
		image.add(addstu);
		
		searchstu = new JButton("SEARCH STUDENT");
		searchstu.setBounds(600, 130, 150, 30);
		searchstu.setForeground(Color.WHITE);
		searchstu.setBackground(Color.BLACK);
		searchstu.setFocusable(false);
	    searchstu.addActionListener(this);
		image.add(searchstu);
		
		updatestu = new JButton("UPDATE STUDENT");
		updatestu.setBounds(80, 180, 150, 30);
		updatestu.setForeground(Color.WHITE);
		updatestu.setBackground(Color.BLACK);
		updatestu.setFocusable(false);
	    updatestu.addActionListener(this);
		image.add(updatestu);
		
		deletedtu = new JButton("DELETE STUDENT");
		deletedtu.setBounds(600, 180, 150, 30);
		deletedtu.setForeground(Color.WHITE);
		deletedtu.setBackground(Color.BLACK);
		deletedtu.setFocusable(false);
	    deletedtu.addActionListener(this);
		image.add(deletedtu);
		
		exit = new JButton("EXIT");
		exit.setBounds(80, 230, 150, 30);
		exit.setForeground(Color.WHITE);
		exit.setBackground(Color.BLACK);
		exit.setFocusable(false);
	    exit.addActionListener(this);
		image.add(exit);
		
		
		setSize(900,900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exit) {
			//JOptionPane.showMessageDialog(null, "Thank You");
			System.exit(0);
		}else if(e.getSource()==addstu) {
			setVisible(false);
			new AddStudent().setVisible(true);
		}else if(e.getSource()==searchstu) {
			setVisible(false);
			new SearchStudent().setVisible(true);
		}else if(e.getSource()==updatestu) {
			setVisible(false);
			new UpdateStudent().setVisible(true);
		}else if(e.getSource()==deletedtu) {
			setVisible(false);
			new DeleteStudent().setVisible(true);
		}
		
	}
	public static void main(String[] args) {
		new Main();
	}
}
