package plane;



import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;




public class guint {
	CardLayout carta=new CardLayout();
	JPanel majplane= new JPanel();
	JPanel container = new JPanel();
	JFrame kk =new JFrame();

	static Vector<buttons> vect = new Vector<buttons>();
	static Vector<person> customers = new Vector<person>();

	static protected String tempuse;
	static protected String temppass;
	static protected int tempchair;
	static String path = "sauvgarde.csv"; // default its plane 1
	JButton back = new JButton("back");
	JTextField Txt = new JTextField();
	JPasswordField pwd = new JPasswordField();
	Border border = BorderFactory.createLineBorder(new Color(30,69,70), 6);
	guint(){
		kk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//kk.setExtendedState(JFrame.MAXIMIZED_BOTH);
		kk.setBounds(20,50,300,250);
		majplane.setVisible(true);
		majplane.setName("plane.exe");
		majplane.setLayout(null);
		majplane.add(Firstclass());
		majplane.add(premium());
		majplane.add(normal());
		//majplane.setBounds(100, 100, 690, 255);
		container.setLayout(carta);
		container.add(log_reg(),"log");
		container.add(majplane,"all_classes");
	
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kk.setBounds(20,50,300,250);
				pwd.setText("");
				Txt.setText("");
				reset();
				customers.clear();
				carta.show(container, "log");
			}});
		back.setBounds(775,320,80,25);
	
		majplane.add(back);
		carta.show(container, "log");
		kk.add(container);
		kk.setVisible(true);
	}


	JPanel Firstclass() {
		int j=1;
		JPanel firsclass_pnl = new JPanel();
		firsclass_pnl.setSize(700,350);
		firsclass_pnl.setBounds(100,50,200,255);
		firsclass_pnl.setLayout(new FlowLayout(FlowLayout.LEADING , 22,30));
		firsclass_pnl.setBackground(Color.LIGHT_GRAY);
		for ( int i =0 ; i<=8;i++) {
			vect.add(new buttons(vect.size()));
		}
		for(buttons x :vect){ 
			(x.chair).setSize(60,60);
			(x.chair).setBackground(new Color(212,175,55)); // gold
			(x.chair).setText("  "+j+ "  ");
			(x.chair).setOpaque(true);
			(x.chair).setBorder(border);
			firsclass_pnl.add((x.chair));
			j++;
		}
		return firsclass_pnl;
	}
	JPanel premium() { 
		int c=1;
		JPanel premium= new JPanel();
		premium.setSize(700,350);
		premium.setBounds(300,50,250,255);
		premium.setLayout(new FlowLayout(FlowLayout.LEADING , 15,15));
		premium.setBackground(Color.LIGHT_GRAY);
		for (int i =9 ; i<=24;i++) {
			vect.add(new buttons(vect.size()));
		}
		for(buttons x :vect){ 
			if(c>9) {
				(x.chair).setSize(60,60);
				(x.chair).setBackground(new Color(103,99,153)); 
				if (c==9) {(x.chair).setText("   "+c+ "   ");}
				else {(x.chair).setText("  "+c+ "  ");}
				(x.chair).setOpaque(true);
				(x.chair).setBorder(border);
				premium.add((x.chair));
				c++;
			}else {
				c++;
			}
		}
		return premium;
	}
	JPanel normal() {
		int c=1;
		JPanel normal= new JPanel();
		normal.setSize(700,350);
		normal.setBounds(550,50,300,255);
		normal.setLayout(new FlowLayout(FlowLayout.LEADING , 15,15));
		normal.setBackground(Color.LIGHT_GRAY);
		for (int i =25;i <= 49;i++) {
			vect.add(new buttons(vect.size()));
		}
		for(buttons x :vect){ 
			if(c>25) {
				(x.chair).setSize(60,60);
				(x.chair).setBackground(new Color(66,99,69)); 
				(x.chair).setText("  "+c+ "  ");
				(x.chair).setOpaque(true);
				(x.chair).setBorder(border);
				c++;
				normal.add((x.chair));
			}else {
				c++;
			}
		}
		return normal;
	}

	static void render_useless() {
		try {
			for(buttons x : vect) {
				(x.chair).setEnabled(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  
	public void retrieve() { // gets the info from the file (.scv) then onto  the vector  so that its used to verify later on the integrity of login/register system
		try {
			File file = new File(path);
			Scanner read = new Scanner(file);
			while(read.hasNextLine()) {
				String ligne = read.nextLine();
				String []coll = ligne.split(",");
				int chaise = Integer.parseInt(coll[2]);
				customers.add(new person(coll[0],coll[1],chaise));
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}	   
	}  
 
	void reset() {
	 for (person x :customers ) {
		 vect.elementAt(x.id).chair.setEnabled(true);
		 if(x.id >= 0 & x.id < 9)
			{
			 vect.elementAt(x.id).chair.setBackground(new Color(212,175,55));
			}
			if(x.id >= 9 & x.id < 25)
			{
				 vect.elementAt(x.id).chair.setBackground(new Color(103,99,153));
			}
			if(x.id>= 25 & x.id < 50)
			{
				vect.elementAt(x.id).chair.setBackground(new Color(66,99,69));
			}
		
	 } 
 }
 
	JPanel log_reg() {
		
	   JPanel front = new  JPanel();
	   front.setLayout(null);
	   String [] plx = {"plane 1", "plane 2", "plane 3"};
	   JComboBox <String> plane = new JComboBox<String>(plx);
	   plane.setBounds(100,100,150,30);
	   plane.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			switch ((String)plane.getSelectedItem()) {
			case "plane 1" : path = "sauvgarde.csv";
			reset();
			customers.clear();
			break;
			case "plane 2" : path = "save 2.csv";
			reset();
			customers.clear(); //  clears the vector so that when you click on login /register it fills the vect with fresh info from the file selected 
			break;
			case "plane 3" : path = "save 3.csv";
			reset();
			customers.clear();
			break;
			}   
		   }
	   });
	      
	   JLabel msg = new JLabel("Username or password are incorrect !");
	   msg.setBounds(40, 90, 135, 30);
	   JButton log =  new JButton("login");
	   
	   log.setBounds(10, 145, 100, 25);
	   log.setFocusable(false);
	   
	   JButton reg = new JButton("register");
	   reg.setBounds(120, 145, 100, 25);
	   reg.setFocusable(false);
	   
	   JLabel userlabel = new JLabel("User          :");
	   userlabel.setBounds(10,20,100,30);
	  
	   JLabel pwdlabel = new JLabel("Password :");
	   pwdlabel.setBounds(10,60,100,30);
	  
	   Txt.setBounds(100,20,165,25);
	   pwd.setBounds(100,60,165,25);

	   log.addActionListener(new ActionListener() { // LOGIN BUTTON
		
		   public void actionPerformed(ActionEvent e) {
			   
			   retrieve();
			   
			   if(Txt.getText().isBlank() || pwd.getText().isBlank()) {
				  JOptionPane.showMessageDialog(null, "Login info false ");
				   
			   }else {
				   for(person x: customers) {
						   vect.elementAt(x.id).chair.setEnabled(false);
						   vect.elementAt(x.id).chair.setBackground(Color.gray);
					   }//verify old ppl
				   
				   for (person c  : customers) { // see if name exists in ppl vector
					   if(c.getUser().equals(Txt.getText())){
						   if (c.getPwd().equals(pwd.getText())) {
							   tempuse = Txt.getText();
							   temppass = pwd.getText();	
							   tempchair = c.getId();
							   tempchair++;
						   
						   for(buttons s : vect) {
							   s.chair.setEnabled(false);
							   if (s.chair.getBackground().equals(Color.red)^s.chair.getBackground().equals(Color.gray)) {
								   s.chair.setBackground(Color.gray);
							   }
						   }  
						   vect.elementAt(c.getId()).chair.setEnabled(true);
						   vect.elementAt(c.getId()).chair.setBackground(Color.red);
						   kk.setBounds(20,50,950,450);
						   carta.show(container, "all_classes");
						 }else{
							 pwd.setText("");
						 }   
					   }
				   }
			   	}}});
	   reg.addActionListener(new ActionListener() { // REGISTER BUTTON
	   public void actionPerformed(ActionEvent e) {	  
		   
			retrieve();
			
			boolean exists = false;
			if(Txt.getText().isBlank() || pwd.getText().isBlank())  {
				  JOptionPane.showMessageDialog(null, "please enter correct info ");
			}else {
				for(person x: customers) {
					if(x.getUser().equals(Txt.getText())) {
						exists = true;
						pwd.setText("");
						  JOptionPane.showMessageDialog(null, "Name already taken ");
					}
					vect.elementAt(x.id).chair.setEnabled(false);
					vect.elementAt(x.id).chair.setBackground(Color.gray);
				} 
				if (exists== false) {
					tempuse = Txt.getText();
					temppass = pwd.getText();
			
					for(buttons s : vect) {
						s.chair.setEnabled(true);
						if (s.chair.getBackground().equals(Color.red)^s.chair.getBackground().equals(Color.gray)) {
							s.chair.setBackground(Color.gray);
							s.chair.setEnabled(false);
						}  
					}
					kk.setBounds(20,50,950,450);
					carta.show(container, "all_classes");	
				}
			   
	   }}});
	  
	   front.add(plane);
	   front.add(log);
	   front.add(reg);
	   front.add(userlabel);
	   front.add(pwdlabel);
	   front.add(pwd);
	   front.add(Txt);
	  
	  return front ;
   
   }


}