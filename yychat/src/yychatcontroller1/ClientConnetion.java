package yychatcontroller1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.yychat.model.Message;
import com.yychat.model.User;

public class ClientConnetion {
	
	public static Socket s;
	
	public ClientConnetion(){
		try {
			s=new Socket("127.0.0.1",3456);
			System.out.println("¿Í»§¶ËSocket"+s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Message loginValidate(User user){
		ObjectOutputStream oos;
		Message mess=null;
		try {
			oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(user);
			
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			mess=(Message)ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return mess;
		
	}

}
