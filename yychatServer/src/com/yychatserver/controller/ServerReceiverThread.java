package com.yychatserver.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

import com.yychat.model.Message;

public class ServerReceiverThread extends Thread{
	Socket s;
	HashMap hmSocket;
	ObjectInputStream ois;
	public ServerReceiverThread(Socket s,HashMap hmSocket){
		this.s=s;
		this.hmSocket=hmSocket;
		
	}
    
	public void run(){
		ObjectInputStream ois;
		while(true){
try {
				
				ois=new ObjectInputStream(s.getInputStream());
				Message mess=(Message)ois.readObject();
				System.out.println(mess.getSender()+"��"+mess.getReceiver()+"˵:"+mess.getContent());
				
				if(mess.getMessagetype().equals(Message.message_Common)){
					Socket s1=(Socket)hmSocket.get(mess.getReceiver());
					ObjectOutputStream oos=new ObjectOutputStream(s1.getOutputStream());
					oos.writeObject(mess);
					System.out.println("��������ת����Ϣ");
				}
			} catch (IOException | ClassNotFoundException e) {
				
				e.printStackTrace();
			}
	}
		}
			
}