package com.yychat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

import com.yychat.model.Message;

import yychatcontroller1.ClientConnetion;

public class Friendchat extends JFrame implements ActionListener,Runnable{
	JScrollPane jsp;
	JTextArea jta;
	
	JPanel jp;
	JTextField jtf1;
	JButton jb;
	
	String sender;
	String receiver;
	
    public Friendchat(String sender,String receiver){
    	this.sender=sender;
    	this.receiver=receiver;
    	jta=new JTextArea();
    	jta.setEditable(false);
    	jta.setForeground(Color.red);
    	jsp=new JScrollPane(jta);
    	this.add(jsp,"Center");
    	
    	jp=new JPanel();
    	jtf1=new JTextField(15);
    	jb=new JButton("发送");
    	jb.addActionListener(this);
    	jp.add(jtf1);jp.add(jb);
    	this.add(jp,"South");
    	this.setSize(350,240);
    	this.setTitle(sender+"正在和"+receiver+"聊天");
    	this.setLocationRelativeTo(null);
    	this.setVisible(true);
    }
	public static void main(String[] args) {
		//Friendchat friendChat=new Friendchat();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jb){
			String content=jtf1.getText();
			jta.append(content+"\r\n");
		Message mess=new Message();
		mess.setSender(sender);
		mess.setReceiver(receiver);
		mess.setContent(content);
		//mess.setMessagetype("2");
		mess.setMessagetype(Message.message_Common);
		ObjectOutputStream oos;
		try {
			oos=new ObjectOutputStream(ClientConnetion.s.getOutputStream());
			oos.writeObject(mess);
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
	@Override
	public void run() {
		Message mess;
		ObjectInputStream ois;
		while(true){
			try {
				ois = new ObjectInputStream(ClientConnetion.s.getInputStream());
				mess=(Message)ois.readObject();
				jta.append(mess.getSender()+"对"+mess.getReceiver()+"说："+mess.getContent()+"\r\n");
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		}
		}
