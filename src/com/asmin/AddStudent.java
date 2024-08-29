package com.asmin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddStudent extends JFrame implements ActionListener {

	JTextField id, name, email, age, phone, address;
	JButton submit, back;

	AddStudent() {

		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ground.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		JLabel title = new JLabel("SARASWATA GURUKULA SIKSHYA KENDRA");
		title.setFont(new Font("Raleway", Font.BOLD, 32));
		title.setBounds(140, 50, 700, 30);
		title.setForeground(Color.GREEN);
		image.add(title);

		JLabel stitle = new JLabel("(ADD STUDENT HERE)");
		stitle.setFont(new Font("Raleway", Font.BOLD, 32));
		stitle.setBounds(280, 180, 700, 30);
		stitle.setForeground(Color.YELLOW);
		image.add(stitle);

		JLabel sid = new JLabel("ID :");
		sid.setFont(new Font("Raleway", Font.BOLD, 22));
		sid.setBounds(200, 250, 100, 30);
		sid.setForeground(Color.WHITE);
		image.add(sid);

		id = new JTextField();
		id.setFont(new Font("Raleway", Font.BOLD, 16));
		id.setBounds(350, 250, 300, 30);
		image.add(id);

		JLabel sname = new JLabel("NAME :");
		sname.setFont(new Font("Raleway", Font.BOLD, 22));
		sname.setBounds(200, 300, 100, 30);
		sname.setForeground(Color.WHITE);
		image.add(sname);

		name = new JTextField();
		name.setFont(new Font("Raleway", Font.BOLD, 16));
		name.setBounds(350, 300, 300, 30);
		image.add(name);

		JLabel semail = new JLabel("EMAIL :");
		semail.setFont(new Font("Raleway", Font.BOLD, 22));
		semail.setBounds(200, 350, 100, 30);
		semail.setForeground(Color.WHITE);
		image.add(semail);

		email = new JTextField();
		email.setFont(new Font("Raleway", Font.BOLD, 16));
		email.setBounds(350, 350, 300, 30);
		image.add(email);

		JLabel sage = new JLabel("AGE :");
		sage.setFont(new Font("Raleway", Font.BOLD, 22));
		sage.setBounds(200, 400, 100, 30);
		sage.setForeground(Color.WHITE);
		image.add(sage);

		age = new JTextField();
		age.setFont(new Font("Raleway", Font.BOLD, 16));
		age.setBounds(350, 400, 300, 30);
		image.add(age);

		JLabel sphone = new JLabel("PHONE :");
		sphone.setFont(new Font("Raleway", Font.BOLD, 22));
		sphone.setBounds(200, 450, 100, 30);
		sphone.setForeground(Color.WHITE);
		image.add(sphone);

		phone = new JTextField();
		phone.setFont(new Font("Raleway", Font.BOLD, 16));
		phone.setBounds(350, 450, 300, 30);
		image.add(phone);

		JLabel saddress = new JLabel("ADDRESS :");
		saddress.setFont(new Font("Raleway", Font.BOLD, 22));
		saddress.setBounds(200, 500, 150, 30);
		saddress.setForeground(Color.WHITE);
		image.add(saddress);

		address = new JTextField();
		address.setFont(new Font("Raleway", Font.BOLD, 16));
		address.setBounds(350, 500, 300, 30);
		image.add(address);

		submit = new JButton("SUBMIT");
		submit.setFont(new Font("Raleway", Font.BOLD, 16));
		submit.setBounds(500, 600, 150, 30);
		submit.setBackground(Color.black);
		submit.setForeground(Color.GREEN);
		submit.setFocusable(false);
		submit.addActionListener(this);
		image.add(submit);

		back = new JButton("BACK");
		back.setFont(new Font("Raleway", Font.BOLD, 16));
		back.setBounds(200, 600, 150, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.GREEN);
		back.setFocusable(false);
		back.addActionListener(this);
		image.add(back);

		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			setVisible(false);
			new Main().setVisible(true);
		}
		if (e.getSource() == submit) {
			String sid = id.getText();
			String sname = name.getText();
			String semail = email.getText();
			String sage = age.getText();
			String sphone = phone.getText();
			String saddr = address.getText();
			if (sid.equals("")) {
				JOptionPane.showMessageDialog(null, "Id is Required");
			} else if (sname.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			} else if (semail.equals("")) {
				JOptionPane.showMessageDialog(null, "Email is Required");
			} else if (!semail.endsWith("@gmail.com")) {
				JOptionPane.showMessageDialog(null, "Please! Enter valid mail");
			} else if (sage.equals("")) {
				JOptionPane.showMessageDialog(null, "Age is Required");
			} else if (sphone.equals("")) {
				JOptionPane.showMessageDialog(null, "Phone Number is Required");
			} else if (saddr.equals("")) {
				JOptionPane.showMessageDialog(null, "This Field is Required");
			} else {
				Conn c = new Conn();
				String query = "insert into sara values(?,?,?,?,?,?)";
				try {
					PreparedStatement ps = c.connection.prepareStatement(query);
					ps.setString(1, sid);
					ps.setString(2, sname);
					ps.setString(3, semail);
					ps.setString(4, sage);
					ps.setString(5, sphone);
					ps.setString(6, saddr);

					try {
						int count = ps.executeUpdate();
						if (count > 0) {
							JOptionPane.showMessageDialog(null, "Student Added Successfully");
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Student Already Exist");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new AddStudent();
	}

}
