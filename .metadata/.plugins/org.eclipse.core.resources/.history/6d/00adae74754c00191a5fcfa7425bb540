package com.yychat.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FriendList extends JFrame implements ActionListener,MouseListener{
    
	CardLayout cardLayout;
	JPanel myFriendPanel;
	
	JButton myFriendButton;
	
	JScrollPane myFriendListJScrollPane;
	JPanel myFriendListJpanel;
	static final int MYFRIENDCUNT=51;
	JLabel[] myFriendJLabel=new JLabel[MYFRIENDCUNT];
	
	JPanel myStrangerBlackListPanel;
	JButton myStrangerButton;
	JButton myBlackListButton;
	
	JPanel myStrangerPanel;
	
	
	JPanel myFriendStrangerPanel;
	JButton myFriendButton1;
	JButton myStrangerButton1;
	
	
	JScrollPane myStangerJScrollPane;
	JPanel myStangerJpanel1;
	static final int MYSTANGERDCUNT=21;
	JLabel[] myStangerJLabel=new JLabel[MYSTANGERDCUNT];
	
	
	JButton myBlackListButton1;
	
	
	String userName;
	public FriendList(String userName){
		this.userName=userName;
		myFriendPanel=new JPanel(new BorderLayout());
		System.out.println(myFriendPanel.getLayout());
		
		myFriendButton=new JButton("我的好友");
		myFriendPanel.add(myFriendButton,"North");
		
		
		myFriendListJpanel=new JPanel(new GridLayout(50,1));
		for(int i=1;i<=MYFRIENDCUNT-1;i++){
			myFriendJLabel[i]=new JLabel(i+"",new ImageIcon("images/yy0.gif"),JLabel.LEFT);
			myFriendJLabel[i].addMouseListener(this);
			myFriendListJpanel.add(myFriendJLabel[i]);
		}
		
			
			myStrangerBlackListPanel=new JPanel(new GridLayout(2,1));
			myStrangerButton=new JButton("陌生人");
			myStrangerButton.addActionListener(this);
			myBlackListButton=new JButton("黑名单");
			myStrangerBlackListPanel.add(myStrangerButton);
			myStrangerBlackListPanel.add(myBlackListButton);	
			myFriendPanel.add(myStrangerBlackListPanel,"South");
			
			myStrangerPanel=new JPanel(new BorderLayout());
			
			myFriendStrangerPanel=new JPanel(new GridLayout(2,1));
			myFriendButton1=new JButton("我的好友");
			myFriendButton1.addActionListener(this);
			myStrangerButton1=new JButton("我的陌生人");
			myFriendStrangerPanel.add(myFriendButton1);
			myFriendStrangerPanel.add(myStrangerButton1);
			myStrangerPanel.add(myFriendStrangerPanel,"North");
			
			myStangerJpanel1=new JPanel(new GridLayout(20,1));
			for(int j=1;j<=MYSTANGERDCUNT-1;j++){
				myStangerJLabel[j]=new JLabel(j+"",new ImageIcon("images/yy1.gif"),JLabel.LEFT);
				myStangerJLabel[j].addMouseListener(this);
				myStangerJpanel1.add(myStangerJLabel[j]);
			}
			
			myBlackListButton1=new JButton("黑名单");
			myStrangerPanel.add(myBlackListButton1,"South");
			
			
			
			cardLayout=new CardLayout();
			this.setLayout(cardLayout);
			this.add(myFriendPanel,"1");
			this.add(myStrangerPanel,"2");
			
		myFriendListJScrollPane=new JScrollPane(myFriendListJpanel);
		myFriendPanel.add(myFriendListJScrollPane);
		
		myStangerJScrollPane=new JScrollPane(myStangerJpanel1);
		myStrangerPanel.add(myStangerJScrollPane);
		
		this.setSize(350,550);
		this.setTitle(userName+"的好友列表");
		this.setIconImage(new ImageIcon("images/yy2.gif").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	
		
	}
	public static void main(String[] args) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== myStrangerButton) cardLayout.show(this.getContentPane(),"2");
		if(e.getSource()== myFriendButton1) cardLayout.show(this.getContentPane(),"1");
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getClickCount()==2){
			JLabel jlbl=(JLabel)arg0.getSource();
			String receiver=jlbl.getText();
			new FriendChat(this.userName,receiver, receiver);
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		JLabel jlbl1=(JLabel)arg0.getSource();
		jlbl1.setForeground(Color.red);
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		JLabel jlbl1=(JLabel)arg0.getSource();
		jlbl1.setForeground(Color.black);
		
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




