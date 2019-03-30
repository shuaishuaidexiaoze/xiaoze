package com.yychatserver.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import com.yychat.model.Message;
import com.yychat.model.User;

public class StartServer {
	Socket s;
	ServerSocket ss;
	
	public HashMap hmSocket=new HashMap<String,Socket>();
	String userName;
	public StartServer(){
		try {
			ss=new ServerSocket(3456);
			System.out.println("服务器已经启动，正在监听3456端口");
			while(true){s=ss.accept();
			System.out.println(s);
			
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			User user=(User)ois.readObject();
			this.userName=user.getUserName();
			System.out.println(user.getUserName());
			System.out.println(user.getPassword());
			
			Message mess=new Message();
			mess.setSender("Server");
			mess.setReceiver(user.getUserName());
			if(user.getPassword().equals("123456")){
				
				mess.setMessagetype(Message.message_LoginSucess);
				hmSocket.put(userName,s);
				
				
				new ServerReceiverThread(s,hmSocket).start();
			}
			else{
				
				mess.setMessagetype(Message.message_LoginFailure);
				
			}
			
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(mess);
			
			
			
				
			}
				
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new StartServer();

	}

}
