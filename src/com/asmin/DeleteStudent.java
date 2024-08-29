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

public class DeleteStudent extends JFrame implements ActionListener {
	JTextField id;
	JButton delete, back;

	DeleteStudent() {
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		JLabel title = new JLabel("SARASWATA GURUKULA SIKSHYA KENDRA");
		title.setFont(new Font("Raleway", Font.BOLD, 32));
		title.setBounds(100, 50, 700, 30);
		title.setForeground(Color.WHITE);
		image.add(title);

		JLabel stitle = new JLabel("(DELETE STUDENT HERE)");
		stitle.setFont(new Font("Raleway", Font.BOLD, 32));
		stitle.setBounds(250, 100, 700, 30);
		stitle.setForeground(Color.RED);
		image.add(stitle);

		JLabel sid = new JLabel("Enter Id :");
		sid.setFont(new Font("Raleway", Font.BOLD, 22));
		sid.setBounds(250, 180, 200, 30);
		sid.setForeground(Color.WHITE);
		image.add(sid);

		id = new JTextField();
		id.setFont(new Font("Raleway", Font.BOLD, 18));
		id.setBounds(380, 180, 150, 30);
		id.setBackground(Color.WHITE);
		id.setForeground(Color.BLACK);
		image.add(id);

		delete = new JButton("DELETE");
		delete.setFont(new Font("Raleway", Font.BOLD, 16));
		delete.setBounds(540, 180, 100, 30);
		delete.setBackground(Color.RED);
		delete.setForeground(Color.BLACK);
		delete.setFocusable(false);
		delete.addActionListener(this);
		image.add(delete);

		back = new JButton("Back");
		back.setFont(new Font("Raleway", Font.BOLD, 16));
		back.setBounds(150, 700, 150, 30);
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
		} else if (e.getSource() == delete) {
			String sid = id.getText();
			Conn c = new Conn();
			String query = "delete from sara where sid=?";
			try {
				PreparedStatement ps = c.connection.prepareStatement(query);
				ps.setString(1, sid);
				try {
					int count = ps.executeUpdate();
					if (count > 0) {
						JOptionPane.showMessageDialog(null, "Student Has Deleted Successfully");
					}else {
						JOptionPane.showMessageDialog(null, "Student Does Not Exist");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Student Does Not Exist");
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new DeleteStudent();
	}
}
