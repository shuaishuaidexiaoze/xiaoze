package com.yychat.view;//包名，作用管理类

		import java.awt.Color;
import java.awt.GridLayout;


// TODO Auto-generated method stub
import javax.swing.*;

		public class ClientLogin extends JFrame{//类名：ClientLogin,继承

			//定义北部组件
			JLabel jlbl1;
			
			//定义南部组件
			JButton jb1,jb2,jb3;
			JPanel jp1;
			
			//定义中部组件
			JTabbedPane jtp1;
			JPanel jp2,jp3,jp4;
			JLabel jlbl2,jlbl3,jlbl4,jlbl5;
			JButton jb4;
			JTextField jtf1;
			JPasswordField jpf1;
			JCheckBox jcb1,jcb2;

			
			//创建北部组件
			public  ClientLogin(){//构造方法
				jlbl1=new JLabel(new ImageIcon("images/tou.gif"));//标签对象
				this.add(jlbl1,"North");//this表示对象本身
				
				
				//创建中部组件
				jtp1=new JTabbedPane();
				jp2=new JPanel(new GridLayout(3,3));
				jp3=new JPanel();jp4=new JPanel();
				jlbl2=new JLabel("YY号码",JLabel.CENTER);
				jlbl3=new JLabel("YY密码",JLabel.CENTER);
				jlbl4=new JLabel("忘记密码",JLabel.CENTER);
				jlbl4.setForeground(Color.blue);
				jlbl5=new JLabel("申请密码保护",JLabel.CENTER);
				jtf1=new JTextField();
				jpf1=new JPasswordField();
				jb4=new JButton(new ImageIcon("images/clear.gif"));
				jcb1=new JCheckBox("隐身登录");
				jcb2=new JCheckBox("记住密码");
				jp2.add(jlbl2);jp2.add(jtf1);jp2.add(jb4);
				jp2.add(jlbl3);jp2.add(jpf1);jp2.add(jlbl4);
				jp2.add(jcb1);jp2.add(jcb2);jp2.add(jlbl5);
				jtp1.add(jp2,"YY号码");jtp1.add(jp3,"手机号码");jtp1.add(jp4,"电子邮箱");
				this.add(jtp1);
				
				//创建南部组件
				jb1=new JButton(new ImageIcon("images/denglu.gif"));
				jb2=new JButton(new ImageIcon("images/zhuce.gif"));
				jb3=new JButton(new ImageIcon("images/quxiao.gif"));
				jp1=new JPanel();
				jp1.add(jb1);jp1.add(jb2);jp1.add(jb3);
				this.add(jp1,"South");
				
				
				
				
				this.setSize(350,240);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用途？
				this.setVisible(true);	
				
			}
			public static void main(String[] args) {
				ClientLogin clientLogin=new ClientLogin();//新创建对象，引用变量
				//clientLogin=null;//对象就会被垃圾回收器回收

			}

}
