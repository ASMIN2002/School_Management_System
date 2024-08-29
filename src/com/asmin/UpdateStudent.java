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

public class UpdateStudent extends JFrame implements ActionListener {

	JButton back, update, find;
	JTextField id, nname, nemail, nage, nphone, naddr;
	JLabel image;

	UpdateStudent() {

		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		JLabel title = new JLabel("SARASWATA GURUKULA SIKSHYA KENDRA");
		title.setFont(new Font("Raleway", Font.BOLD, 32));
		title.setBounds(100, 0, 700, 30);
		title.setForeground(Color.BLUE);
		image.add(title);

		JLabel stitle = new JLabel("(UPDATE STUDENT HERE)");
		stitle.setFont(new Font("Raleway", Font.BOLD, 32));
		stitle.setBounds(230, 50, 700, 30);
		stitle.setForeground(Color.YELLOW);
		image.add(stitle);

		JLabel sid = new JLabel("Enter Your Id :");
		sid.setFont(new Font("Raleway", Font.BOLD, 22));
		sid.setBounds(260, 100, 200, 30);
		sid.setForeground(Color.WHITE);
		image.add(sid);

		id = new JTextField();
		id.setFont(new Font("Raleway", Font.BOLD, 18));
		id.setBounds(430, 100, 170, 30);
		id.setBackground(Color.WHITE);
		id.setForeground(Color.BLACK);
		image.add(id);

		find = new JButton("FIND");
		find.setFont(new Font("Raleway", Font.BOLD, 16));
		find.setBounds(620, 100, 100, 30);
		find.setBackground(Color.black);
		find.setForeground(Color.GREEN);
		find.setFocusable(false);
		find.addActionListener(this);
		image.add(find);

		back = new JButton("BACK");
		back.setFont(new Font("Raleway", Font.BOLD, 16));
		back.setBounds(150, 750, 150, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.GREEN);
		back.setFocusable(false);
		back.addActionListener(this);
		image.add(back);

		update = new JButton("UPDATE");
		update.setFont(new Font("Raleway", Font.BOLD, 16));
		update.setBounds(550, 750, 150, 30);
		update.setBackground(Color.black);
		update.setForeground(Color.GREEN);
		update.setFocusable(false);
		update.addActionListener(this);
		image.add(update);

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
		} else if (e.getSource() == find) {
			String sid = id.getText();
			Conn c = new Conn();
				String query = "select * from sara where sid=?";
				try {
					PreparedStatement ps = c.connection.prepareStatement(query);
					ps.setString(1, sid);

					ResultSet resultSet = ps.executeQuery();
					if (resultSet.next()) {

						JTextField warn = new JTextField();
						warn.setFont(new Font("Raleway", Font.BOLD, 22));
						warn.setBounds(40, 150, 500, 30);
						warn.setForeground(Color.WHITE);
						warn.setBackground(Color.BLUE);
						warn.setText("NOTE !* You Can't Change Your Id");
						image.add(warn);

						JTextField tid = new JTextField();
						tid.setFont(new Font("Raleway", Font.BOLD, 22));
						tid.setBounds(550, 150, 210, 30);
						tid.setForeground(Color.WHITE);
						tid.setBackground(Color.BLACK);
						tid.setText("OLD ID : " + resultSet.getString("sid"));
						image.add(tid);

						JTextField tname = new JTextField();
						tname.setFont(new Font("Raleway", Font.BOLD, 22));
						tname.setBounds(40, 220, 720, 30);
						tname.setForeground(Color.WHITE);
						tname.setBackground(Color.BLACK);
						tname.setText("OLD NAME : \t" + resultSet.getString("sname"));
						image.add(tname);

						JTextField nt = new JTextField();
						nt.setFont(new Font("Raleway", Font.BOLD, 22));
						nt.setBounds(40, 260, 220, 30);
						nt.setForeground(Color.RED);
						nt.setBackground(Color.YELLOW);
						nt.setText("Enter New Name :");
						image.add(nt);

						nname = new JTextField();
						nname.setFont(new Font("Raleway", Font.BOLD, 22));
						nname.setBounds(262, 260, 500, 30);
						nname.setForeground(Color.BLACK);
						nname.setBackground(Color.WHITE);
						nname.setText(" ");
						image.add(nname);

						JTextField temail = new JTextField();
						temail.setFont(new Font("Raleway", Font.BOLD, 22));
						temail.setBounds(40, 330, 720, 34);
						temail.setForeground(Color.WHITE);
						temail.setBackground(Color.BLACK);
						temail.setText("OLD EMAIL :\t" + resultSet.getString("semail"));
						image.add(temail);

						JTextField et = new JTextField();
						et.setFont(new Font("Raleway", Font.BOLD, 22));
						et.setBounds(40, 370, 220, 30);
						et.setForeground(Color.RED);
						et.setBackground(Color.YELLOW);
						et.setText("Enter New Email :");
						image.add(et);

						nemail = new JTextField();
						nemail.setFont(new Font("Raleway", Font.BOLD, 22));
						nemail.setBounds(262, 370, 500, 30);
						nemail.setForeground(Color.BLACK);
						nemail.setBackground(Color.WHITE);
						nemail.setText(" ");
						image.add(nemail);

						JTextField tage = new JTextField();
						tage.setFont(new Font("Raleway", Font.BOLD, 22));
						tage.setBounds(40, 440, 720, 30);
						tage.setForeground(Color.WHITE);
						tage.setBackground(Color.BLACK);
						tage.setText("OLD AGE  :\t" + resultSet.getString("sage"));
						image.add(tage);

						JTextField at = new JTextField();
						at.setFont(new Font("Raleway", Font.BOLD, 22));
						at.setBounds(40, 480, 220, 30);
						at.setForeground(Color.RED);
						at.setBackground(Color.YELLOW);
						at.setText("Enter New Age :");
						image.add(at);

						nage = new JTextField();
						nage.setFont(new Font("Raleway", Font.BOLD, 22));
						nage.setBounds(262, 480, 500, 30);
						nage.setForeground(Color.BLACK);
						nage.setBackground(Color.WHITE);
						nage.setText(" ");
						image.add(nage);

						JTextField tphone = new JTextField();
						tphone.setFont(new Font("Raleway", Font.BOLD, 22));
						tphone.setBounds(40, 550, 720, 30);
						tphone.setForeground(Color.WHITE);
						tphone.setBackground(Color.BLACK);
						tphone.setText("OLD PHONE :\t" + resultSet.getString("sphone"));
						image.add(tphone);

						JTextField pt = new JTextField();
						pt.setFont(new Font("Raleway", Font.BOLD, 22));
						pt.setBounds(40, 590, 220, 30);
						pt.setForeground(Color.RED);
						pt.setBackground(Color.YELLOW);
						pt.setText("Enter New Phone :");
						image.add(pt);

						nphone = new JTextField();
						nphone.setFont(new Font("Raleway", Font.BOLD, 22));
						nphone.setBounds(262, 590, 500, 30);
						nphone.setForeground(Color.BLACK);
						nphone.setBackground(Color.WHITE);
						nphone.setText(" ");
						image.add(nphone);

						JTextField taddr = new JTextField();
						taddr.setFont(new Font("Raleway", Font.BOLD, 22));
						taddr.setBounds(40, 660, 500, 30);
						taddr.setForeground(Color.WHITE);
						taddr.setBackground(Color.BLACK);
						taddr.setText("OLD ADDRESS :" + resultSet.getString("saddr"));
						image.add(taddr);

						JTextField adt = new JTextField();
						adt.setFont(new Font("Raleway", Font.BOLD, 22));
						adt.setBounds(40, 700, 220, 30);
						adt.setForeground(Color.RED);
						adt.setBackground(Color.YELLOW);
						adt.setText("Enter New Address :");
						image.add(adt);

						naddr = new JTextField();
						naddr.setFont(new Font("Raleway", Font.BOLD, 22));
						naddr.setBounds(262, 700, 500, 30);
						naddr.setForeground(Color.BLACK);
						naddr.setBackground(Color.WHITE);
						naddr.setText(" ");
						image.add(naddr);
					}else {
						JOptionPane.showMessageDialog(null, "ID not Found.Please Enter Valid Id");
					}
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
		} else if (e.getSource() == update) {
			try {
				String uname = nname.getText();
				String uemail = nemail.getText();
				String uage = nage.getText();
				String uphone = nphone.getText();
				String uaddr = naddr.getText();
				String uid = id.getText();

				Conn c1 = new Conn();
				String query1 = "update sara set sname=?,semail=?,sage=?,sphone=?,saddr=? where sid=?";

				try {
					PreparedStatement ps1 = c1.connection.prepareStatement(query1);
					ps1.setString(1, uname);
					ps1.setString(2, uemail);
					ps1.setString(3, uage);
					ps1.setString(4, uphone);
					ps1.setString(5, uaddr);
					ps1.setString(6, uid);

					int count = ps1.executeUpdate();

					if (count > 0) {
						JOptionPane.showMessageDialog(null, "Your Data Updation Successfully");
					} else {
						System.out.println("not");
						JOptionPane.showMessageDialog(null, "Your Data Updation Failed");
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} catch (Exception r) {
				JOptionPane.showMessageDialog(null, "Please Find Your Id First");
			}
		}
	}

	public static void main(String[] args) {
		new UpdateStudent();
	}
}
