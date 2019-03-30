package com.yychat.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class FriendList extends JFrame implements ActionListener,MouseListener{//����
	//��Ա����
	CardLayout cardLayout;
	//��һ�ſ�Ƭ
	JPanel myFriendPanel;
	
	JButton myFriendButton;//����
	
	JScrollPane myFriendListJScrollPane;
	JPanel myFriendListJPanel;
	public static final int MYFRIENDCOUNT=51;
	JLabel[] myFriendJLabel=new JLabel[MYFRIENDCOUNT];//50�������飬��������
	
	JPanel myStrangerBlackListPanel;
	JButton myStrangerButton;
	JButton blackListButton;
	
	
	//�ڶ�����Ƭ
	//����
	JPanel myStrangerPanel;
	JPanel myFriendStrangerListPanel;
	JButton myFriendButton1;
	JButton myStrangerButton1;
	
	
	//�в�
	JScrollPane myStrangerListJScrollPane;
	JPanel myStrangerListJPanel;
	
	public static final int STRANGERCOUNT=51;
	JLabel[] myStrangerJLabel=new JLabel[STRANGERCOUNT];//50�������飬��������
	
	
	
	
	//�ϲ�
	JPanel myBlackListJPanel;
	JButton myBlackListButton;
	
	
	
	
	
	
	String usename;
	
	public FriendList(String usename){
		
		this.usename=usename;
		myFriendPanel=new JPanel(new BorderLayout());//��������,�߽粼��
		//��һ�ſ�Ƭ
		//����
		myFriendButton=new JButton("�ҵĺ���");
		myFriendPanel.add(myFriendButton,"North");
		
		//�в�
		myFriendListJPanel=new JPanel(new GridLayout(MYFRIENDCOUNT-1,1));//���񲼾�
		for(int i=1;i<MYFRIENDCOUNT;i++){
			myFriendJLabel[i]=new JLabel(i+"",new ImageIcon("images/yy0.gif"),JLabel.LEFT);
			myFriendJLabel[i].addMouseListener(this);
			myFriendListJPanel.add(myFriendJLabel[i]);
		}
		/*myFriendListJScrollPane=new JScrollPane();
		myFriendListJScrollPane.add(myFriendListJPanel);*/
		myFriendListJScrollPane=new JScrollPane(myFriendListJPanel);
		myFriendPanel.add(myFriendListJScrollPane);
		
		//�ϲ�
		myStrangerBlackListPanel=new JPanel(new GridLayout(2,1));
		myStrangerButton=new JButton("�ҵ�İ����");
		myStrangerButton.addActionListener(this);
		blackListButton=new JButton("������");
		myStrangerBlackListPanel.add(myStrangerButton);
		myStrangerBlackListPanel.add(blackListButton);
		myFriendPanel.add(myStrangerBlackListPanel,"South");
		//��һ�ſ�Ƭ
		
		//�ڶ��ſ�Ƭ
		//����
		myStrangerPanel=new JPanel(new BorderLayout(1,1));
		myFriendStrangerListPanel=new JPanel(new GridLayout(2,1));
		myFriendButton1=new JButton("�ҵĺ���");
		myFriendButton1.addActionListener(this);
		myStrangerButton1=new JButton("�ҵ�İ����");
		myFriendStrangerListPanel.add(myFriendButton1);
		myFriendStrangerListPanel.add(myStrangerButton1);
		myStrangerPanel.add(myFriendStrangerListPanel,"North");
				
				//�в�
	myStrangerListJPanel=new JPanel(new GridLayout(STRANGERCOUNT-1,1));//���񲼾�
	for(int i=1;i<STRANGERCOUNT;i++){
	myStrangerJLabel[i]=new JLabel(i+"",new ImageIcon("images/yy0.gif"),JLabel.LEFT);
	myStrangerJLabel[i].addMouseListener(this);
	myStrangerListJPanel.add(myStrangerJLabel[i]);
	myStrangerListJScrollPane=new JScrollPane(myStrangerListJPanel);
		myStrangerPanel.add(myStrangerListJScrollPane);
	}
					
					
		//�ϲ�
	    myBlackListJPanel=new JPanel(new GridLayout(1,1)) ;		
	    myBlackListButton=new JButton("������");
	    myBlackListJPanel.add(myBlackListButton);
		myStrangerPanel.add( myBlackListJPanel,"South");
		
		
		cardLayout=new CardLayout();
		this.setLayout(cardLayout);
		this.add(myFriendPanel,"1");
 		this.add(myStrangerPanel,"2");
		this.setSize(240,500);
		this.setTitle(usename+"�ĺ����б�");
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

