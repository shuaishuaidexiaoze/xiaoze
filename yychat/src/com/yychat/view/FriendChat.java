package com.yychat.view;

import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.*;

import com.yychat.controller.ClientConnetion;
import com.yychat.model.Message;

public class FriendChat extends JFrame implements ActionListener{
	
	JScrollPane jsp;
	JTextArea jta;
	
	JPanel jp;
	JTextField jtf;
	JButton jb;
	
	String sender;
	String reciver;
	
	public FriendChat(String sender,String receiver, String reciver){
		this.sender=sender;
		this.reciver=reciver;
		
		jta=new JTextArea();
		jta.setEditable(false);
		jta.setForeground(Color.red);
		jsp=new JScrollPane(jta);
		this.add(jsp,"Center");
		
		jp=new JPanel();
		jtf=new JTextField(15);
		jb=new JButton("发送");
		jb.addActionListener(this);
		jp.add(jtf);jp.add(jb);
		this.add(jp,"South");
		
		this.setSize(350, 240);
		this.setTitle(sender+"正在和"+receiver+"聊天");
		this.setLocationRelativeTo(null);
		this.setVisible(true);		
	}

	public static void main(String[] args) {
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jb){
			String content=jtf.getText();
			jta.append(jtf.getText()+"\r\n");
			
			//发送Message对象到服务器
			Message mess=new Message();
			mess.setSender(sender);
			mess.setReceiver(reciver);
			mess.setContent(content);
			//mess.setMessageType();//common聊天的普通信息
			mess.setMessageType(Message.message_Common);
			ObjectOutputStream oos;
			try {
				oos=new ObjectOutputStream(ClientConnetion.s.getOutputStream());
				oos.writeObject(mess);
				
			} catch (IOException e) {				
				e.printStackTrace();
			}			
		}		
	}

}
