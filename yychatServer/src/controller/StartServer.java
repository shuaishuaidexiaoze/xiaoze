package controller;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.yychat.model.User;

public class StartServer {
	
	ServerSocket ss;
	Socket s;
	public StartServer(){

			try {
				ss=new ServerSocket(3456);
				System.out.println("服务器已经启动，监听3456端口");
				s=ss.accept();
				System.out.println(s);
				
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				User user=(User)ois.readObject();
				System.out.println(user.getUserName());
				System.out.println(user.getPassWord());
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
