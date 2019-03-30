package com.yychatServerview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.yychatserver.controller.StartServer;

public class ChatServer extends JFrame implements ActionListener{
	JButton jb1;
	JButton jb2;
	JPanel jp1;
	
	public ChatServer(){
		jb1=new JButton("启动服务器");
		jb2=new JButton("关闭服务器");
		jb1.addActionListener(this);
		jp1=new JPanel();
		jp1.add(jb1);
		jp1.add(jb2);
		
		this.add(jp1);
		this.setTitle("YYChat服务器");
		this.setSize(240, 240);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	

	public static void main(String[] args) {
		ChatServer chatServer=new ChatServer();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		new StartServer();
		
	}

}
