import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.*;
import java.util.ArrayList;
import javax.imageio.ImageIO; 
import javax.imageio.ImageReader; 

class SwingEx2 extends JFrame implements ActionListener//,WindowListener
{

//frame1 swingex2 login
//frame2 buttons welcome
//frame3 vamshi  instructions
//frame4 Examvd   exam


JTextField userText;
	 JPasswordField passwordText;
	 JPanel panel,panelregis;
	 JCheckBox passwordCheckbox;

	ButtonGroup bg=null;
	JRadioButton choice1,choice2,choice3,choice4;
	JButton NEXT,PREVIOUS,SUBMIT;
	JLabel cd,error,quest;
	JTextArea qarea;
	JTextField name,password,rollno;
	StringTokenizer str;
	int k=0,i,num,correct,value;
	ArrayList<String> arrqpaper,anspaper;
	 ArrayList<String> user = new ArrayList<String>();
	 ArrayList<String> pwd = new ArrayList<String>();
	  ArrayList<String> namelist =new ArrayList<String>();
int input[] = new int[20];
 
//String vd="vd",deva="deva",DEVAM="DEVAM";
//			user.add("vd");
//pwd.add("deva");
//namelist.add("DEVAM");
//all frames declaration
JFrame frame,v,vamshi,jf,result,regist;
 void ExamVD()
		{
				
		 jf=new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		jf.setBounds(125,60,700,600);
		jf.setVisible(true);
		jf.setResizable(false);
//panels	
		JPanel jp=new JPanel();
		jp.setBounds(0,0,450,600);
		jp.setLayout(null);

		JPanel ap=new JPanel();
		ap.setBounds(450,0,250,600);
		ap.setLayout(null);

		JPanel qa=new JPanel();
		qa.setBounds(10,50,430,430);
		qa.setLayout(null);
// components on qa panel
		JLabel q = new JLabel("Question no.");
		q.setBounds(20,20,130,25);
		qa.add(q);
		qa.setBackground(Color.LIGHT_GRAY);
		q.setFont(new Font("SansSerif Plain", Font.PLAIN,20));
			
		  quest = new JLabel();
		 quest.setBounds(135,20,25,25);
		 quest.setFont(new Font("SansSerif Plain", Font.PLAIN,20));
		// quest.setBackground(Color.WHITE);
		qa.add(quest);
		//quest.setEditable(false);

		qarea = new JTextArea();
		qarea.setBounds(10,60,410,150);
		qarea.setBackground(Color.WHITE);
		qa.add(qarea);
		qarea.setBorder(BorderFactory.createTitledBorder(""));
		qarea.setEditable(false);
		qarea.setLineWrap(true);
		qarea.setWrapStyleWord(true);
		qarea.setFont(new Font("Serif", Font.PLAIN,23));
// components on ap panel
		JRadioButton att=new JRadioButton("ATTEMPTED ",true);
		att.setBounds(480,10,185,30);
		att.setFont(new Font("SansSerif Plain", Font.BOLD,15));
		att.setBackground(Color.CYAN);
		ap.add(att);
		att.setEnabled(false);

		JRadioButton at1=new JRadioButton("UNATTEMPTED ",false);
		at1.setBounds(480,45,185,30);
		at1.setFont(new Font("SansSerif Plain", Font.BOLD,15));
		at1.setBackground(Color.CYAN);
		at1.setEnabled(false);
        ap.add(at1);
	
//Ading 20  buttons for ap		 
JButton jbut1,jbut2,jbut3,jbut4,jbut5,jbut6,jbut7,jbut8,jbut9,jbut10,jbut11,jbut12,jbut13,jbut14,jbut15,jbut16,jbut17,jbut18,jbut19,jbut20;		 
	
		jbut1=new JButton("1");
      jbut1.setBounds(485,50,20,10) ;
	  ap.add(jbut1);	
		 

	
jbut2=new JButton("2");
		jbut2.setBounds(485,10,30,30);
		jbut2.setFont(new Font("SansSerif Plain", Font.BOLD,15));
	
		ap.add(jbut2);
		
 // components on jp panel
		JLabel timer=new JLabel("TIME LEFT");
		timer.setBounds(30,15,150,40);
		timer.setFont(new Font("Snell Roundhand", Font.PLAIN,25));
		jp.add(timer);

		cd=new JLabel();
		cd.setFont(new Font("Snell Roundhand", Font.PLAIN,25));

		JPanel tp=new JPanel();
		tp.setBounds(162,15,100,40)	;
		tp.setBorder(BorderFactory.createTitledBorder(""));
		tp.add(cd);

		Inner t=new Inner();
		t.start(); 
//  panel colours
		jp.setBackground(Color.PINK);
		//tp.setBackground(Color.WHITE);
		ap.setBackground(Color.GRAY);
		qa.setBackground(Color.LIGHT_GRAY);
// radio buttons
		  bg=new ButtonGroup();
                  choice1=new JRadioButton("",false);
		  choice1.setBounds(25,220,380,30);
		  choice1.setBackground(Color.WHITE);
		  choice1.setFont(new Font("Lucida", Font.PLAIN,16));
                  choice2=new JRadioButton("",false);
		  choice2.setBounds(25,260,380,30);
		  choice2.setBackground(Color.WHITE);
		  choice2.setFont(new Font("Lucida", Font.PLAIN,16));
                  choice3=new JRadioButton("",false);
		  choice3 .setBounds(25,300,380,30);
		  choice3.setBackground(Color.WHITE);
		  choice3.setFont(new Font("Lucida", Font.PLAIN,16));
                  choice4=new JRadioButton("",false);
		  choice4.setBounds(25,340,380,30);
		  choice4.setBackground(Color.WHITE);
		  choice4.setFont(new Font("Lucida", Font.PLAIN,16));
		  
		  
		  //adding actoin listeners to radio buttons
		    choice1.addActionListener(this);
			choice2.addActionListener(this);
			choice3.addActionListener(this);
			choice4.addActionListener(this);
                

   				  bg.add(choice1);
                  bg.add(choice2);
                  bg.add(choice3);
                  bg.add(choice4);
		 qa.add(choice1);
		 qa.add(choice2);
		 qa.add(choice3);
		 qa.add(choice4);
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
// buttons

		NEXT=new JButton("NEXT");
		NEXT.setBounds(243,385,130,30);
		//NEXT.setBackground(Color.LIGHT_GRAY);
	        PREVIOUS=new JButton("PREVIOUS");
		PREVIOUS.setBounds(50,385,130,30);
	//	PREVIOUS.setBackground(Color.LIGHT_GRAY);
		SUBMIT=new JButton("SUBMIT");
	        SUBMIT.setBounds(315,510,105,30);
		//SUBMIT.setBackground(Color.GRAY);
	        qa.add(NEXT);
		qa.add(PREVIOUS);
		 jp.add(SUBMIT);
		NEXT.addActionListener(this);
	        PREVIOUS.addActionListener(this);
	        SUBMIT.addActionListener(this);
		NEXT.setFont(new Font("SansSerif", Font.PLAIN, 18));
		PREVIOUS.setFont(new Font("SansSerif", Font.PLAIN, 18));
		SUBMIT.setFont(new Font("SansSerif", Font.PLAIN, 18));
//adding panels to frame
		jf.add(jp); 
		jf.add(ap); 
		jp.add(tp);
		jp.add(qa);
jf.setVisible(true);
		tp.setVisible(true);
		ap.setVisible(true);
		jp.setVisible(true);
vamshi.setVisible(false);
		freshFinalExam();
		}// frame3

   SwingEx2()
		{String users[]={"vd","15311A05I1","15311A05I2","15311A05I3","15311A05I4","15311A05I5","15311A05I6"};
		String pass[]={"deva","v","n","c","r","a","s"};
		String naam[]={"DEVAM","VAMSHI","NITYA","CHARITH","RAHUL","ANI TEJA","SOHITH"};
           for(i=0;i<6;i++){
		   user.add(users[i]);
				 pwd.add(pass[i]);
		   namelist.add(naam[i]);}
      frame = new JFrame("LOGIN PAGE");
		frame.setBounds(165,60,350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();    
        
        frame.add(panel);
		frame.setResizable(false);
      
                
panel.setLayout(null);
        
        JLabel userLabel = new JLabel("User");
       
         userLabel.setBounds(10,20,80,25);
		panel.add(userLabel);                        
        
        userText = new JTextField(10);
		userText.setBounds(100,20,165,25);
		panel.add(userText);
      
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10,50,80,25);
		panel.add(passwordLabel);
		passwordText = new JPasswordField(10);
		passwordText.setBounds(100,50,165,25);
		panel.add(passwordText);
		passwordCheckbox=new JCheckBox("Show Password");
		passwordCheckbox.setBounds(20,100,165,25);
		panel.add(passwordCheckbox);
	
        JButton loginButton = new JButton("login");
		loginButton.setBounds(200, 100, 80, 25);
		panel.add(loginButton);
		panel.setVisible(true);
		frame.setVisible(true);
		loginButton.addActionListener(this);
	passwordCheckbox.addItemListener(new ItemListener() 
				{
				public void itemStateChanged(ItemEvent e) 
					{
					if (e.getStateChange() == ItemEvent.SELECTED) 
						{
						passwordText.setEchoChar((char) 0);
						} 
					else 
						{
						passwordText.setEchoChar('*');
												}
					}
				});
		}

	void	 BUTTONS(int i)
{

 v=new JFrame();
v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
v.setBounds(125,60,800,600);
v.setVisible(true);
//setLayout(null);
//setResizable(false);
JPanel jp=new JPanel();
v.getContentPane().add(jp);
//jp.setBounds(10,10,800,500);
//add(jp);
jp.setLayout(null);
JLabel background=new JLabel(new ImageIcon("finallogo2.jpg"));
	background.setBounds(150,120,450,300);
	background.setVisible(true);
	jp.setBackground(Color.WHITE);
	jp.add(background);

     JLabel titleLabel=new JLabel("                               WELCOME "+namelist.get(i));

titleLabel.setFont(new Font("Snell Roundhand", Font.BOLD,30));
titleLabel.setBorder(BorderFactory.createTitledBorder(""));
 
titleLabel.setBounds(0,50,1200,50);
titleLabel.setVisible(true);
jp.add(titleLabel);


JButton b=new JButton("Next");
b.addActionListener(this);
b.setLocation(340,450);
b.setSize(80,30);
b.setVisible(true);
jp.add(b);
jp.setVisible(true);
v.add(jp);
		frame.setVisible(false);
//setResizable(false);
}

void Question() 
{
	
	 vamshi=new JFrame();

vamshi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
vamshi.setBounds(125,60,800,600);
vamshi.setVisible(true);
//setLayout(null);
vamshi.setResizable(false);
JPanel j=new JPanel();
//j.setBackground(Color.WHITE);
getContentPane().add(j);
//j.setBounds(10,10,800,500);
//add(j);

j.setLayout(null);

JLabel background=new JLabel(new ImageIcon("mylogo.png"));
	background.setBounds(150,120,450,300);
	background.setVisible(true);
	j.setBackground(Color.WHITE);
	j.add(background);
//  
     JLabel titleLabel1=new JLabel("                                     INSTRUCTIONS                         ");

titleLabel1.setFont(new Font("Snell Roundhand", Font.BOLD,30));
titleLabel1.setBorder(BorderFactory.createTitledBorder(""));
 
titleLabel1.setBounds(0,50,1200,50);
titleLabel1.setVisible(true);
j.add(titleLabel1);

JTextArea ins=new JTextArea();
ins.setText(">THIS TEST CONSISTS OF 20 QUESTIONS\n>EACH QUESTIONS CARRIES ONE MARK\n>FOR EVERY CORRECT ANSWER YOU WILL BEAWARDED ONE MARK\n>FOR EACH WRONG RESPONSE YOU WILL BE AWARDED -0.5 MARKS\n>NO MARKS WILL BE DEDUCED IF NOT ATTEMPTED\n >YOU WILL BE PROVIDED 10 MINUTES TO WRITE THE TEST\n >CLICK GO TO TAKE THE TEST");
ins.setFont(new Font("Snell Roundhand", Font.ITALIC,20));
ins.setBounds(100,150,1000,300);
ins.setEditable(false);
	//j.setBackground(Color.WHITE);
	j.add(ins);


JButton b1=new JButton("GO");
b1.addActionListener(this);
b1.setLocation(340,450);
b1.setSize(80,30);
b1.setVisible(true);
j.add(b1);
j.setVisible(true);
vamshi.add(j);
v.setVisible(false);

	
}



//inner class starts
 class Inner extends Thread
	{
	public void run()
		{
		String mm,ss;
		int m=10,s=0;
		while(true)
			{
			 if( s<10)
				 {
				 ss="0"+(s);
				 } 
			else 
				{
				ss=""+s;
				}
			if(m<10)mm="0"+m;
			else{mm=""+m;}
			cd.setText(mm+":"+ss)  ;
			try
				{
				Thread.sleep(1000);
				} 
			catch(InterruptedException e){}
				 if(s==0)
					 {
					 m--;
					 s=60;
					 }
				if(m>=0)
					{
					s--;
					}
				 else
					 {
					 cd.setText("TIME UP");
					 resultframe();
					 break;
					 }
			    }//while
		  }//run
			 
	 }// inner
//freshfinalexam	
 void freshFinalExam() 
		{             
		ArrayList<String> queDataBase = new ArrayList<String>();
		ArrayList<String> ansDataBase = new ArrayList<String>();        
		int num=0;
		String fileName1 ="dataforexamnew.txt";
		String fileName2 ="ansfileforexam.txt";
		 String line;                
		try
			{
			BufferedReader br1 = new BufferedReader(new FileReader(fileName1));
			while((line=br1.readLine())!=null) 
				{
				queDataBase.add(line);
				num++; 
				}
			
			 }
		 catch (IOException e) 
			{
			 e.printStackTrace();
			 }
		 try
			 {
			 BufferedReader br1 = new BufferedReader(new FileReader(fileName2));	                        
			 while((line=br1.readLine())!=null) 
				 {                       
				 ansDataBase.add(line);
				 }
			
			 } 
		catch (IOException e) 
			 {
			 e.printStackTrace();
			 }
		int no,j,count=0;  
		arrqpaper = new ArrayList<String>();
	 anspaper = new ArrayList<String>();
		int qno[]=new int[20];
		ArrayList<Integer> list = new ArrayList<Integer>();
	        for ( i=0; i<num; i++)
			{
			list.add(i);
			}
			value=num;
		Collections.shuffle(list);
		for ( i=0; i<20; i++) 
			{
			 qno[i]=list.get(i);    
			}
		int a;                  
		for(i=0;i<20;i++)
			{
	       	        a=qno[i];
			arrqpaper.add(queDataBase.get(a));
			anspaper.add(ansDataBase.get(a));
			System.out.println(a+"  "+anspaper.get(i));
			input[i]=0;
			}
 		//ArrayList<Integer> input = new ArrayList<Integer>();     count=0;
		//System.out.print("                     GET READY!!!!\n\n");
		
		
		
		
		
		
		
		i=0;
			quest.setText((i+1)+"");
			str=new StringTokenizer((arrqpaper.get(i)),";");      
			while(str.hasMoreTokens())
				 {
				 if(k==0){qarea.setText(str.nextToken());}
				 if(k==1){choice1.setText(str.nextToken());}
				 if(k==2){choice2.setText(str.nextToken());}
				 if(k==3){choice3.setText(str.nextToken());}
				 if(k==4){choice4.setText(str.nextToken());}
				 k++;
				
       if(k==5){k=0;break;}
		// System.out.print("\n                           YOUR ANSWER:");
		 //input.add(s.nextInt());
          
			}
		}


		/*		
		
			
	 
			if((input.get(i)==(((anspaper.get(i)).charAt(0))-48)))count++;

			}
			//System.out.println("Your Score is : "+count+"\n                          THANK YOU FOR TAKING THE TEST");


		}*/
		
//actionperformed
	public void actionPerformed(ActionEvent e)
		{
		if( e.getActionCommand().equals("login") )
			        {             
                     	 int x=  namelist.size();
				String s= userText.getText();
				for(int i=0;i<x;i++)
					{
					if(s.equals(user.get(i)))
						{
						if(passwordText.getText().equals(pwd.get(i)))
							{
							if(i==0){regis();}	
								else{
								BUTTONS(i);}
							}else{JOptionPane.showMessageDialog(frame,"Invalid User ID or Password","Inane error",JOptionPane.WARNING_MESSAGE);}
						
						}else {if(i==x-1){JOptionPane.showMessageDialog(frame,"Invalid User ID or Password","Inane error",JOptionPane.WARNING_MESSAGE);}}
						
					}
						
							
														
							
							
							
						/*	
						error = new JLabel("Invalid userId or password");
						error.setBounds(50,10,80,25);
						panel.add(error);
						error.setVisible(true);*/
						}
					
				 
				else if(e.getActionCommand().equals("Next"))
					{
			Question();
				}
				else if(e.getActionCommand().equals("GO"))
					{
			ExamVD();
				}
		else if( e.getActionCommand().equals("PREVIOUS") )
			{  k=0;        
			if(i>0)
				{
				
			bg.clearSelection();
			
	 i--;  			quest.setText((i+1)+"");
                 if(input[i]==1){choice1.setSelected(true);}
				 if(input[i]==2){choice2.setSelected(true);}
				 if(input[i]==3){choice3.setSelected(true);}
				 if(input[i]==4){choice4.setSelected(true);}
          			str=new StringTokenizer((arrqpaper.get(i)),";");      
				while(str.hasMoreTokens())
					{
					if(k==0){qarea.setText(str.nextToken());}
					if(k==1){choice1.setText(str.nextToken());}
					if(k==2){choice2.setText(str.nextToken());}
					if(k==3){choice3.setText(str.nextToken());}
					if(k==4){choice4.setText(str.nextToken());}
					k++;
					if(k==5)break;}
				}
			}
		else if(e.getActionCommand().equals("NEXT"))
			 {k=0;
			if(i<19){
			bg.clearSelection();
	 i++;			quest.setText((i+1)+"");
	             if(input[i]==1){choice1.setSelected(true);}
				 if(input[i]==2){choice2.setSelected(true);}
				 if(input[i]==3){choice3.setSelected(true);}
				 if(input[i]==4){choice4.setSelected(true);}
			 str=new StringTokenizer((arrqpaper.get(i)),";");      
			while(str.hasMoreTokens())
				{
				if(k==0){qarea.setText(str.nextToken());}
				if(k==1){choice1.setText(str.nextToken());}
				if(k==2){choice2.setText(str.nextToken());}
				if(k==3){choice3.setText(str.nextToken());}
				if(k==4){choice4.setText(str.nextToken());}
				k++;
				if(k==5)break;} 
			}}
			
		else if(e.getActionCommand().equals("SUBMIT")){resultframe();}
		else if(e.getActionCommand().equals("REGISTER")){namelist.add(name.getText());
	                                                  	user.add(rollno.getText());
	                                                  	pwd.add(password.getText());}
				
                         if(e.getSource() instanceof JRadioButton ){
		
						                JRadioButton radioButton = (JRadioButton) e.getSource();
															if(radioButton.isSelected()){  
																	
																	input[i]=Integer.parseInt(radioButton.getText().substring(0,1));
																
																System.out.println((i+1)+ " "+input[i]);
																	
																	}
																	
																		
																	
			 }
								}
	/*	
		public void windowClosing(WindowEvent e){
       int result=JOptionPane.showConfirmDialog(null, "Are you sure you want to Submit?,"Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

       if(result==JOptionPane.YES_OPTION){
               resultframe();
		}}*/
  void regis()
  { regist = new JFrame("REGISTRATION");
		regist.setBounds(165,60,400,400);
		regist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelregis = new JPanel();    
        
        regist.add(panelregis);
		regist.setResizable(false);
		
		regist.setVisible(true);
    
                
panelregis.setLayout(null);
        
        JLabel username = new JLabel("FIRST NAME*");
       
         username.setBounds(50,40,100,25);
		panelregis.add(username);                        
        
     name = new JTextField(10);
		name.setBounds(160,40,200,25);
		panelregis.add(name);
		
		
		  JLabel rno = new JLabel("ROLL NUMBER*");
       
         rno.setBounds(50,110,100,25);
		panelregis.add(rno);                        
        
       rollno = new JTextField(10);
		rollno.setBounds(160,110,200,25);
		panelregis.add(rollno);
      
	  
		  JLabel pw = new JLabel("PASSWORD*");
       
         pw.setBounds(50,180,100,25);
		panelregis.add(pw);                        
        
       password = new JTextField(10);
		password.setBounds(160,180,200,25);
		panelregis.add(password);
		
		  JButton regisButton = new JButton("REGISTER");
		regisButton.setBounds(200,300,150, 25);
		panelregis.add(regisButton);
		
		
		
      
	/*	JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10,50,80,25);
		panel.add(passwordLabel);
		passwordText = new JPasswordField(10);
		passwordText.setBounds(100,50,165,25);
		panel.add(passwordText);
		passwordCheckbox=new JCheckBox("Show Password");
		passwordCheckbox.setBounds(20,100,165,25);
		panel.add(passwordCheckbox);
	
        JButton loginButton = new JButton("login");
		loginButton.setBounds(200, 100, 80, 25);
		panel.add(loginButton);
		panel.setVisible(true);
		frame.setVisible(true);
		loginButton.addActionListener(this);
	passwordCheckbox.addItemListener(new ItemListener() 
				{
				public void itemStateChanged(ItemEvent e) 
					{
					if (e.getStateChange() == ItemEvent.SELECTED) 
						{
						passwordText.setEchoChar((char) 0);
						} 
					else 
						{
						passwordText.setEchoChar('*');
												}
					}
				});*/
	}

  
		
void resultframe()	
{int p=0;
	correct=0;
			for(i=0;i<20;i++)
			{
				System.out.println(input[i]);
				if(input[i]==0){p++;continue;}
				if(input[i]==Integer.parseInt(anspaper.get(i)))
					
			{correct++;
			}
		}
				
//System.out.println(p+" "+correct);



	result=new JFrame();
	 result.setLayout(null);
		result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		result.setBounds(125,60,700,600);
		result.setVisible(true);
		result.setResizable(false);
//panels	
		JPanel r1=new JPanel();
		r1.setBounds(0,0,450,600);
		r1.setLayout(null);
        r1.setBackground(Color.LIGHT_GRAY);
		

		JPanel r2=new JPanel();
		r2.setBounds(450,0,250,600);
		r2.setLayout(null);
		r2.setBackground(Color.WHITE);
	/*	 JLabel l10 = new JLabel("DEVELOPED BY");
		l10.setBounds(460,100,40,25);
		l10.setFont(new Font("SansSerif Plain", Font.PLAIN,22));
		r2.add(l10);
		l10.setVisible(true);
        l10.setForeground (Color.GRAY);
		*/
		
		
		result.add(r1); 
		result.add(r2); 
	
	JLabel background=new JLabel(new ImageIcon("mylogo.png"));
	background.setBounds(460,200,200,50);
	background.setVisible(true);
	//r2.setBackground(Color.WHITE);
	r2.add(background);
	result.setVisible(true);
	r1.setVisible(true);
	r2.setVisible(true);
	   JLabel l1 = new JLabel("No. of questions attempted        "+(20-p));
		l1.setBounds(20,100,400,25);
		l1.setFont(new Font("SansSerif Plain", Font.PLAIN,22));
		r1.add(l1);
        l1.setForeground (Color.RED);
		
		JLabel l2 = new JLabel("No. of correct answers               "+correct  );
		l2.setBounds(20,150,400,25);
		l2.setFont(new Font("SansSerif Plain", Font.PLAIN,22));
        r1.add(l2);
		l2.setForeground (Color.RED);
		
	    JLabel l3 = new JLabel("No. of wrong answers                 "+(20-p-correct));
		l3.setBounds(20,200,400,25);
		l3.setFont(new Font("SansSerif Plain", Font.PLAIN,22));
		r1.add(l3);
		l3.setForeground (Color.RED);
		
		JLabel l4 = new JLabel("FINAL SCORE   "+((correct*1)-(20-p-correct)*0.5));
		l4.setBounds(100,270,300,25);
		l4.setFont(new Font("SansSerif Plain", Font.PLAIN,23));
		r1.add(l4);
		l4.setForeground (Color.WHITE);
		
		JLabel l5 = new JLabel("    QUOTE OF THE MOMENT");
		l5.setBounds(100,370,300,25);
		l5.setFont(new Font("SansSerif Plain", Font.PLAIN,18));
		r1.add(l5);
		l5.setForeground (Color.CYAN);
		
		JTextArea quote = new JTextArea();
		quote.setBounds(20,400,410,150);
		quote.setBackground(Color.WHITE);
		
			//quotes
		int g=0;
		
	String fileName ="quotefile.txt";
	ArrayList<String> quotedatabase =new ArrayList<String>();
		 String line2;                
		try
			{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while((line2=br.readLine())!=null) 
				{
				quotedatabase.add(line2);
				g++;
				}
			
			 }
		 catch (IOException e) 
			{
			 e.printStackTrace();
			 }
			
		ArrayList<Integer> list2 = new ArrayList<Integer>();
	        for ( i=0; i<g; i++)
			{
			list2.add(i);
			}
		
		Collections.shuffle(list2);
		String d="",f="";
		StringTokenizer str2=new StringTokenizer((quotedatabase.get(list2.get(0))), ".");      
		int h=0;	while(str2.hasMoreTokens())
				 {
				if(h==0) d=	str2.nextToken();
					if(h==1) f=str2.nextToken();
			h++;
				 }
		
	quote.setText(" "+d+"\n\n         "+f);

	//
		
		
		
		 JLabel l6 = new JLabel("RESULT");
		l6.setBounds(170,20,300,25);
		l6.setFont(new Font("SansSerif Plain", Font.BOLD,30));
		r1.add(l6);

		
		quote.setBorder(BorderFactory.createTitledBorder(""));
		quote.setEditable(false);
		quote.setLineWrap(true);
	    quote.setWrapStyleWord(true);
		quote.setFont(new Font("SansSerif Plain", Font.PLAIN,23));
        r1.add(quote);
        jf.setVisible(false);
		
		
		
		
		
}	
		

//main
	public static void main(String args[]) throws Exception
		{
		new SwingEx2();
		}
}
