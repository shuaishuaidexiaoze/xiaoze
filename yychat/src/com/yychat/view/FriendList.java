package com.yychat.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.*;

public class FriendList  extends JFrame implements ActionListener{//容器
	//成员变量
	CardLayout cardLayout;
	
	
	//第一个卡片
	//北部
	JPanel myFriendPanel;
	
	
	JButton myFriendButton;
	
	//中部
	JScrollPane myFriendListJScrollPane;//滚动条
	JPanel myFriendListJPanel;
	public static final int MYFRIENDCOUNT=51;


	private static final String LEFT = null;


	JLabel[] myFriendJLabel=new JLabel[MYFRIENDCOUNT];
	
	//南部
	JPanel myStrangerBlackListPanel;
	JButton myStrangerButton;
	JButton blackListButton;
	
	
	//第二个卡片
			JPanel myStrangerPanel;
			//北部
			JPanel myFriendStrangerPanel;
			JButton myStrangerButton1;
			JButton myFriendButton1;
			
			//中部
			JScrollPane myStrangerListJScrollPane;
			JPanel myStrangerListJPanel;
			public static final int MYCOUNT=51;


			public static final String LEFT1 = null;
			JLabel[] myStrangerJLabel=new JLabel[MYCOUNT];
			
			JPanel myStrangerBlackListPanel1;
			
			//南部
			JButton blackListButton1;
			
	
	public FriendList(){
		//创建第一张卡片
		myFriendPanel =new JPanel(new BorderLayout());
  		System.out.println(myFriendPanel.getLayout());
  		 
  		
  		//北部
  		myFriendButton=new JButton("我的好友");
  		myFriendPanel.add(myFriendButton,"North");
  		
  		
  	    //中部
  		myFriendListJPanel=new JPanel(new GridLayout(MYFRIENDCOUNT-1,1));
		for(int i=1;i<MYFRIENDCOUNT;i++){
			myFriendJLabel[i]=new JLabel(i+"",new ImageIcon("images/yy2.gif"),JLabel.LEFT);
			myFriendListJPanel.add(myFriendJLabel[i]);
		}
		
		
		myFriendListJScrollPane=new JScrollPane(myFriendListJPanel);
		myFriendPanel.add(myFriendListJScrollPane);
		
		
		
		//南部
		myStrangerBlackListPanel=new JPanel(new GridLayout(2,1));
		myStrangerButton=new JButton("我的陌生人");
		myStrangerButton.addActionListener(this);//事件监听
		blackListButton=new JButton("黑名单");
		myStrangerBlackListPanel.add(myStrangerButton);
		myStrangerBlackListPanel.add(blackListButton);
		myFriendPanel.add(myStrangerBlackListPanel,"South");
		
		
		
		//创建第二个卡片
		myStrangerPanel=new JPanel(new BorderLayout());//布局，边界布局
		//北部
		myFriendStrangerPanel=new JPanel(new GridLayout(2,1));
	    myFriendButton1=new JButton("我的好友");
	    myFriendButton1.addActionListener(this);//事件监听
	    myStrangerButton1=new JButton("我的陌生人");
	    myFriendStrangerPanel.add(myFriendButton1);
	    myFriendStrangerPanel.add(myStrangerButton1);
	    myStrangerPanel.add(myFriendStrangerPanel, "North");
	    
	    
	    
		//中部
		myStrangerListJPanel=new JPanel(new GridLayout(MYCOUNT-1,1));
		for(int i=1;i<MYCOUNT;i++){
			myStrangerJLabel[i]=new JLabel(i+"",new ImageIcon("images/YY1.gif"),JLabel.LEFT);
			myStrangerListJPanel.add(myStrangerJLabel[i]);
		}
		
		
		myStrangerListJScrollPane=new JScrollPane(myStrangerListJPanel);
		myStrangerPanel.add(myStrangerListJScrollPane);
		
		
		//南部
		blackListButton1=new JButton("黑名单");
		myStrangerPanel.add(blackListButton1,"South");
		
		
		//添加两个卡片
		cardLayout=new CardLayout();
		this.setLayout(cardLayout);
		this.add(myFriendPanel,"1");
		this.add(myStrangerPanel,"2");
		this.setSize(150,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		this.setVisible(true);
	}

	public static void main(String[] args) {
		FriendList friendList=new FriendList();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==myStrangerButton) cardLayout.show(this.getContentPane(), "2");
		if(e.getSource()==myFriendButton1) cardLayout.show(this.getContentPane(), "1");
	}

}