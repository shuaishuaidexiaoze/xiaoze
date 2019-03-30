package com.yychat.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class FriendList extends JFrame implements ActionListener,MouseListener{//容器
	//成员变量
	CardLayout cardLayout;
	//第一张卡片
	JPanel myFriendPanel;
	
	JButton myFriendButton;//北部
	
	JScrollPane myFriendListJScrollPane;
	JPanel myFriendListJPanel;
	public static final int MYFRIENDCOUNT=51;
	JLabel[] myFriendJLabel=new JLabel[MYFRIENDCOUNT];//50好友数组，对象数组
	
	JPanel myStrangerBlackListPanel;
	JButton myStrangerButton;
	JButton blackListButton;
	
	
	//第二个卡片
	//北部
	JPanel myStrangerPanel;
	JPanel myFriendStrangerListPanel;
	JButton myFriendButton1;
	JButton myStrangerButton1;
	
	
	//中部
	JScrollPane myStrangerListJScrollPane;
	JPanel myStrangerListJPanel;
	
	public static final int STRANGERCOUNT=51;
	JLabel[] myStrangerJLabel=new JLabel[STRANGERCOUNT];//50好友数组，对象数组
	
	
	
	
	//南部
	JPanel myBlackListJPanel;
	JButton myBlackListButton;
	
	
	
	
	
	
	String usename;
	
	public FriendList(String usename){
		
		this.usename=usename;
		myFriendPanel=new JPanel(new BorderLayout());//布局问题,边界布局
		//第一张卡片
		//北部
		myFriendButton=new JButton("我的好友");
		myFriendPanel.add(myFriendButton,"North");
		
		//中部
		myFriendListJPanel=new JPanel(new GridLayout(MYFRIENDCOUNT-1,1));//网格布局
		for(int i=1;i<MYFRIENDCOUNT;i++){
			myFriendJLabel[i]=new JLabel(i+"",new ImageIcon("images/yy0.gif"),JLabel.LEFT);
			myFriendJLabel[i].addMouseListener(this);
			myFriendListJPanel.add(myFriendJLabel[i]);
		}
		/*myFriendListJScrollPane=new JScrollPane();
		myFriendListJScrollPane.add(myFriendListJPanel);*/
		myFriendListJScrollPane=new JScrollPane(myFriendListJPanel);
		myFriendPanel.add(myFriendListJScrollPane);
		
		//南部
		myStrangerBlackListPanel=new JPanel(new GridLayout(2,1));
		myStrangerButton=new JButton("我的陌生人");
		myStrangerButton.addActionListener(this);
		blackListButton=new JButton("黑名单");
		myStrangerBlackListPanel.add(myStrangerButton);
		myStrangerBlackListPanel.add(blackListButton);
		myFriendPanel.add(myStrangerBlackListPanel,"South");
		//第一张卡片
		
		//第二张卡片
		//北部
		myStrangerPanel=new JPanel(new BorderLayout(1,1));
		myFriendStrangerListPanel=new JPanel(new GridLayout(2,1));
		myFriendButton1=new JButton("我的好友");
		myFriendButton1.addActionListener(this);
		myStrangerButton1=new JButton("我的陌生人");
		myFriendStrangerListPanel.add(myFriendButton1);
		myFriendStrangerListPanel.add(myStrangerButton1);
		myStrangerPanel.add(myFriendStrangerListPanel,"North");
				
				//中部
	myStrangerListJPanel=new JPanel(new GridLayout(STRANGERCOUNT-1,1));//网格布局
	for(int i=1;i<STRANGERCOUNT;i++){
	myStrangerJLabel[i]=new JLabel(i+"",new ImageIcon("images/yy0.gif"),JLabel.LEFT);
	myStrangerJLabel[i].addMouseListener(this);
	myStrangerListJPanel.add(myStrangerJLabel[i]);
	myStrangerListJScrollPane=new JScrollPane(myStrangerListJPanel);
		myStrangerPanel.add(myStrangerListJScrollPane);
	}
					
					
		//南部
	    myBlackListJPanel=new JPanel(new GridLayout(1,1)) ;		
	    myBlackListButton=new JButton("黑名单");
	    myBlackListJPanel.add(myBlackListButton);
		myStrangerPanel.add( myBlackListJPanel,"South");
		
		
		cardLayout=new CardLayout();
		this.setLayout(cardLayout);
		this.add(myFriendPanel,"1");
 		this.add(myStrangerPanel,"2");
		this.setSize(240,500);
		this.setTitle(usename+"的好友列表");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		}
	
	public static void main(String[] args) {
		//FriendList friednList=new FriendList();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==myStrangerButton) cardLayout.show(this.getContentPane(),"2");
		if(e.getSource()==myFriendButton1) cardLayout.show(this.getContentPane(),"1");
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getClickCount()==2){
			JLabel jlb1=(JLabel)arg0.getSource();
			String receiver=jlb1.getText();
			new Thread(new Friendchat(this.usename,receiver)).start();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		JLabel jlbl1=(JLabel)(arg0.getSource());
		jlbl1.setForeground(Color.red);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		JLabel jlbl1=(JLabel)(arg0.getSource());
		jlbl1.setForeground(Color.BLACK);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

