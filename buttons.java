package plane;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import javax.swing.*;

public class buttons implements ActionListener {
	protected JButton chair;
	private int id;

	
	
	
	public buttons(int id) {
		
		this.id = id;
		chair = new JButton();
		chair.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) { 
		
		if(chair.getBackground().equals(Color.red)) { // seat red ==  seat taken hence when clicked shows frame containing info for that person 
			clntinfo().setVisible(true);
		
	}else{
		try {
			File fil= new File(guint.path);
			FileWriter myObj = new FileWriter(guint.path,true);
			BufferedWriter out = new BufferedWriter(myObj);
		
		chair.setBackground(Color.red);
		guint.render_useless();
		person p = new person(guint.tempuse,guint.temppass,id);
		guint.customers.add(p);
	//vect full 
	String newentry  = guint.tempuse +","+guint.temppass+","+id;
	out.write(newentry);
	out.newLine();
	out.close();
	
	
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}}

	
JFrame clntinfo () {
	String niveau = null;
	if(guint.tempchair > 0 & guint.tempchair <= 9)
	{
		niveau = "first-class";
	}
	if(guint.tempchair > 9 & guint.tempchair <= 25)
	{
		niveau = "premium";
	}
	if(guint.tempchair > 25 & guint.tempchair <= 50)
	{
		niveau = "Economie";
	}

	JFrame inf = new JFrame("info :");
	inf.setLayout(null);
	inf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	inf.setSize(320,450);
	JLabel user=new JLabel("user \t:"+guint.tempuse);
	JLabel pass=new JLabel("password \t:"+guint.temppass);
	JLabel chse =new JLabel("chaise n�   \t: " + guint.tempchair);
	JLabel nn =new JLabel("class   \t: " +niveau);
	user.setBounds(10, 20, 300, 25);
	pass.setBounds(10, 50, 300, 25);
	chse.setBounds(10, 80, 300, 25);
	nn.setBounds(10,110,300,25);
	inf.add(user);
	inf.add(chse);
	inf.add(pass);
	inf.add(nn);
	
	
	
	return inf;
}
	
	
}
