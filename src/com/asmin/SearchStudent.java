package com.asmin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SearchStudent extends JFrame implements ActionListener{
	
	JTextField id;
	JButton search,back;
	JLabel image;
	Image i2;
	ImageIcon i1,i3;
	SearchStudent(){
		
		setLayout(null);

		i1 = new ImageIcon(ClassLoader.getSystemResource("icon/seach.jpeg"));
		i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		i3 = new ImageIcon(i2);
		image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel title = new JLabel("SARASWATA GURUKULA SIKSHYA KENDRA");
		title.setFont(new Font("Raleway", Font.BOLD, 32));
		title.setBounds(100, 50, 700, 30);
		title.setForeground(Color.WHITE);
		image.add(title);
		
		JLabel stitle = new JLabel("(SEARCH STUDENT HERE)");
		stitle.setFont(new Font("Raleway", Font.BOLD, 32));
		stitle.setBounds(250, 100, 700, 30);
		stitle.setForeground(Color.YELLOW);
		image.add(stitle);
		
		JLabel sid = new JLabel("Enter Your Id :");
		sid.setFont(new Font("Raleway", Font.BOLD, 22));
		sid.setBounds(200, 180, 200, 30);
		sid.setForeground(Color.WHITE);
		image.add(sid);
		
		id = new JTextField();
		id.setFont(new Font("Raleway", Font.BOLD, 18));
		id.setBounds(380, 180, 150, 30);
		id.setBackground(Color.WHITE);
		id.setForeground(Color.BLACK);
		image.add(id);
		
		search = new JButton("Search");
		search.setFont(new Font("Raleway", Font.BOLD, 16));
		search.setBounds(550, 180, 150, 30);
		search.setBackground(Color.GREEN);
		search.setForeground(Color.BLACK);
		search.setFocusable(false);
		search.addActionListener(this);
		image.add(search);
		
		back = new JButton("Back");
		back.setFont(new Font("Raleway", Font.BOLD, 16));
		back.setBounds(150, 700, 150, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.GREEN);
		back.setFocusable(false);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900,900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			setVisible(false);
			new Main().setVisible(true);
		}else if(e.getSource()==search) {
		
			String sid = id.getText();
			
			Conn c = new Conn();
			String query = "select * from sara where sid=?";
			try{
				PreparedStatement ps = c.connection.prepareStatement(query);
				ps.setString(1, sid);
				
				ResultSet resultSet = ps.executeQuery();
				if(resultSet.next()){
					JTextField tid = new JTextField();
					tid.setFont(new Font("Raleway", Font.BOLD, 22));
					tid.setBounds(180, 300, 550, 30);
					tid.setForeground(Color.WHITE);
					tid.setBackground(Color.BLACK);
					tid.setText("STUDENT ID : "+resultSet.getString("sid"));
					image.add(tid);
					
					JTextField tname = new JTextField();
					tname.setFont(new Font("Raleway", Font.BOLD, 22));
					tname.setBounds(180, 350, 550, 30);
					tname.setForeground(Color.WHITE);
					tname.setBackground(Color.BLACK);
					tname.setText("STUDENT NAME : "+resultSet.getString("sname"));
					image.add(tname);
					
					JTextField temail = new JTextField();
					temail.setFont(new Font("Raleway", Font.BOLD, 22));
					temail.setBounds(180, 400, 550, 34);
					temail.setForeground(Color.WHITE);
					temail.setBackground(Color.BLACK);
					temail.setText("STUDENT EMAIL : "+resultSet.getString("semail"));
					image.add(temail);
					
					JTextField tage = new JTextField();
					tage.setFont(new Font("Raleway", Font.BOLD, 22));
					tage.setBounds(180, 450, 550, 30);
					tage.setForeground(Color.WHITE);
					tage.setBackground(Color.BLACK);
					tage.setText("STUDENT AGE  : "+resultSet.getString("sage"));
					image.add(tage);
					
					JTextField tphone = new JTextField();
					tphone.setFont(new Font("Raleway", Font.BOLD, 22));
					tphone.setBounds(180, 500, 550, 30);
					tphone.setForeground(Color.WHITE);
					tphone.setBackground(Color.BLACK);
					tphone.setText("STUDENT PHONE : "+resultSet.getString("sphone"));
					image.add(tphone);
					
					JTextField taddr = new JTextField();
					taddr.setFont(new Font("Raleway", Font.BOLD, 22));
					taddr.setBounds(180, 550, 550, 30);
					taddr.setForeground(Color.WHITE);
					taddr.setBackground(Color.BLACK);
					taddr.setText("STUDENT ADDRESS : "+resultSet.getString("saddr"));
					image.add(taddr);
				}else {
					JOptionPane.showMessageDialog(null, "Student Does Not Exist. Please Enter Valid id");
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		//mini.setBounds(20, 140, 400, 200);
	}
	public static void main(String[] args) {
		new SearchStudent();
	}
	
}
