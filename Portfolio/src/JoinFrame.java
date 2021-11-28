import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinFrame extends JFrame implements ActionListener{
	JTextField id_tx;
	JTextField name_tx;
	JTextField number_tx;
	JTextField pass_tx;
	JTextField pass_Check_tx;
	JTextField age_tx;
	JTextField gender_tx;
	JTextField email_tx;
	JTextField phone_tx;
	//////////////////////////////////
	JLabel id = new JLabel("ID");
	JLabel number = new JLabel("사번");
	JLabel name = new JLabel("name");
	 JLabel password = new JLabel("Password");
	 JLabel password_Check = new JLabel("PasswordCheck");
	 JLabel age = new JLabel("Age");
	 JLabel gender= new JLabel("Gender");
	 JLabel email= new JLabel("E-mail");
	 JLabel phone= new JLabel("Phone");
	 JLabel Blank= new JLabel("HJCompany");
	 JLabel golbangi= new JLabel("@");
	 String[] mail = {"naver.com", "gmail.com", "hjcompany.com"};
	 String[] Cosmos = {"사번", "이름", "아이디", "비밀번호", "나이", "성별", "이메일", "전화번호"};
	 String result="";
	 int[] Cs = {0,0,0,0,0,0,0,0,0};
	 
	 final JComboBox<String> Email_Combo = new JComboBox<String>(mail);
	 ///////////////////////////////
	 ///////////////////////////////
	 ///////////////////////////////
	 JLabel id_label= new JLabel("ID관련");
		JLabel number_label = new JLabel("사번");
		JLabel name_label = new JLabel("name");
		JLabel password_label = new JLabel("Gender");
		JLabel password_Check_label = new JLabel("Gender");
		 JLabel age_label = new JLabel("Age");
		 JLabel gender_label= new JLabel("Gender");
		 JLabel email_label= new JLabel("E-mail");
		 JLabel phone_label= new JLabel("Phone");
		 
		 JLabel id_label2= new JLabel("ID관련");
			JLabel number_label2 = new JLabel("사번");
			JLabel name_label2 = new JLabel("name");
			JLabel password_label2 = new JLabel("Gender");
			JLabel password_Check_label2 = new JLabel("Gender");
			 JLabel age_label2 = new JLabel("Age");
			 JLabel gender_label2= new JLabel("Gender");
			 JLabel email_label2= new JLabel("E-mail");
			 JLabel phone_label2= new JLabel("Phone");
	 ///////////////////////////////
	 ///////////////////////////////
	 ///////////////////////////////
	 JLabel On= new JLabel("HJCompony");
	 JPanel init = new JPanel(new FlowLayout());
	 JPanel Information = new JPanel(new GridLayout(10,2,0,20));
	 JPanel ForID = new JPanel(new FlowLayout(0,0,0));
	 JPanel ForA = new JPanel(new FlowLayout(0,0,0));
	 JPanel ForEmail = new JPanel(new FlowLayout(0,0,0));
	 JButton join;
	 JButton cancel;
	 JButton Confirm;
	 Container cp;
	JoinFrame() throws IOException {
		DBConnect db = new DBConnect();
		cp = this.getContentPane();
		init.setBackground(Color.black);
		Information.setBackground(Color.black);
		On.setForeground(Color.yellow);
		On.setFont(new Font("맑은고딕", Font.BOLD, 30));
		init.add(On);
		////////////////////////////////////////////////
		id.setForeground(Color.white);
        id.setFont(new Font("맑은고딕", Font.BOLD, 15));
        number.setForeground(Color.white);
        number.setFont(new Font("맑은고딕", Font.BOLD, 15));
        name.setForeground(Color.white);
        name.setFont(new Font("맑은고딕", Font.BOLD, 15));
        password.setForeground(Color.white);
        password.setFont(new Font("맑은고딕", Font.BOLD, 15));
        password_Check.setForeground(Color.white);
        password_Check.setFont(new Font("맑은고딕", Font.BOLD, 15));
        age.setForeground(Color.white);
        age.setFont(new Font("맑은고딕", Font.BOLD, 15));
        gender.setForeground(Color.white);
        gender.setFont(new Font("맑은고딕", Font.BOLD, 15));
        email.setForeground(Color.white);
        email.setFont(new Font("맑은고딕", Font.BOLD, 15));
        phone.setForeground(Color.white);
        phone.setFont(new Font("맑은고딕", Font.BOLD, 15));
        golbangi.setForeground(Color.white);
        golbangi.setFont(new Font("맑은고딕", Font.BOLD, 15));
        ///////////////////////////////////////////////
        number_tx = new JTextField(10);
        number_tx.setForeground(Color.green);
        number_tx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        number_tx.setOpaque(false);
        id_tx = new JTextField(10);
        id_tx.setForeground(Color.green);
        id_tx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        id_tx.setOpaque(false);
        name_tx = new JTextField(10);
        name_tx.setForeground(Color.green);
        name_tx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        name_tx.setOpaque(false);
        pass_tx = new JPasswordField(10);
        pass_tx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        pass_tx.setForeground(Color.green);
        pass_tx.setOpaque(false);
        pass_Check_tx = new JPasswordField(10);
        pass_Check_tx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        pass_Check_tx.setForeground(Color.green);
        pass_Check_tx.setOpaque(false);
        age_tx = new JTextField(5);
        age_tx.setForeground(Color.green);
        age_tx.setOpaque(false);
        age_tx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        gender_tx = new JTextField(10);
        gender_tx.setForeground(Color.green);
        gender_tx.setOpaque(false);
        gender_tx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        email_tx = new JTextField(10);
        email_tx.setForeground(Color.green);
        email_tx.setOpaque(false);
        email_tx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        phone_tx = new JTextField(10);
        phone_tx.setForeground(Color.green);
        phone_tx.setOpaque(false);
        phone_tx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        //////Button //
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("맑은고딕", Font.BOLD, 30));
        cancel.addActionListener(e->{
        	dispose();
        });
        cancel.setBorderPainted(false);
        cancel.setFocusPainted(false);
        cancel.setContentAreaFilled(false);
        //////////////////////////////////////////////////////
        join = new JButton("Join");
        join.setForeground(Color.white);
        join.setFont(new Font("맑은고딕", Font.BOLD, 30));
        join.addActionListener(e->{
        	String email_Adder = null;
        	for(int i =0;i<9;i++) {
        		if(Cs[i]==0) {
        			result += Cosmos[i] + " ";
        			
        		}
        	}
        	if(Cs[0]==1 && Cs[1]==1 && Cs[2]==1 && Cs[3]==1 && Cs[4] == 1 && Cs[5]==1 && Cs[6]==1 && Cs[7]==1 && Cs[8]==1) {
        	email_Adder = email_tx.getText() + "@" + mail[Email_Combo.getSelectedIndex()];
        	//db.insert_join(number_tx.getText(), name_tx.getText(), id_tx.getText(), pass_tx.getText(), age_tx.getText(), gender_tx.getText(), email_Adder, phone_tx.getText());
        	try {
        		Client.Client_send("1");
        		Client.Client_receive();
        		Client.Client_send(number_tx.getText());
        		Client.Client_receive();
        		Client.Client_send(name_tx.getText());
        		Client.Client_receive();
        		Client.Client_send(id_tx.getText());
        		Client.Client_receive();
        		Client.Client_send(pass_tx.getText());
        		Client.Client_receive();
        		Client.Client_send(age_tx.getText());
        		Client.Client_receive();
        		Client.Client_send(gender_tx.getText());
        		Client.Client_receive();
        		Client.Client_send(email_Adder);
        		Client.Client_receive();
        		Client.Client_send(phone_tx.getText());
        		Client.Client_receive();
        		
        		JOptionPane.showMessageDialog(null, "회원가입이 성공적으로 이루어졌습니다.");
        		dispose();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	}
        	else {
        		JOptionPane.showMessageDialog(null, result + "을(를) 잘 입력하세요.");
        		result="";
        	}
        	
        });
        join.setBorderPainted(false);
        join.setFocusPainted(false);
        join.setContentAreaFilled(false);
        //////////////////////////////////////////////////////
        Confirm = new JButton("중복확인");
        Confirm.setForeground(Color.white);
        Confirm.setFont(new Font("맑은고딕", Font.BOLD, 15));
        Confirm.addActionListener(e->{//중복확인
        	try {
        		if(id_tx.getText().length()<4) {
	        		System.out.println("길이가 너무 짧습니다." + id_tx.getText());
	        		JOptionPane.setRootFrame(null);
	        		id_label.setForeground(Color.red);
					id_label.setText("X");
					Cs[2]=0;
	        		JOptionPane.showMessageDialog(null, "길이가 너무 짧습니다."+id_tx.getText());
	        	}
	            else if(id_tx.getText().length()>12) {
	        		System.out.println("길이가 너무 깁니다." + id_tx.getText());
	        		JOptionPane.setRootFrame(null);
	        		JOptionPane.showMessageDialog(null, "길이가 너무 깁니다."+id_tx.getText());
	        		id_label.setForeground(Color.red);
					id_label.setText("X");
					Cs[2]=0;
	        	}
	            else {
	            	Client.Client_send("2");
					Client.Client_receive();
					Client.Client_send(id_tx.getText());
	            if(Client.Client_receive().equals("1")) {
					//TODO
	            	
					System.out.println("사용 가능한 아이디 입니다. " + id_tx.getText());
	            	JOptionPane.setRootFrame(null);
	            	JOptionPane.showMessageDialog(null, "사용 가능한 아이디 입니다."+id_tx.getText());
					id_label.setForeground(Color.blue);
					id_label.setText("O");
					Cs[2]=1;
				}
				else {
					System.out.println("이미 존재하는 아이디입니다. 다시 입력해 주세요.");
	            	JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다. 다시 입력해 주세요." +id_tx.getText());
					id_label.setForeground(Color.red);
					id_label.setText("X");
					Cs[2]=0;
				}
			}
        	}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        	//dispose();
        });
        Confirm.setBorderPainted(false);
        Confirm.setFocusPainted(false);
        Confirm.setContentAreaFilled(false);
/////////////////////////////////////////////////
        
ForID.setBackground(Color.black);
ForID.add(id_tx);
ForID.add(Confirm);
Information.add(number);
Information.add(number_tx);
Information.add(name);
Information.add(name_tx);
Information.add(id);
Information.add(ForID);
Information.add(password);
Information.add(pass_tx);
Information.add(password_Check);
Information.add(pass_Check_tx);
Information.add(age);
Information.add(age_tx);
Information.add(gender);
Information.add(gender_tx);
Information.add(email);
ForEmail.setBackground(Color.black);
ForEmail.add(email_tx);
ForEmail.add(golbangi);
ForEmail.add(Email_Combo);
Information.add(ForEmail);
Information.add(phone);
Information.add(phone_tx);
//////////////////////////////////////
id_label.setText("X");
id_label.setForeground(Color.red);
password_label.setText("X");
password_label.setForeground(Color.red);
password_Check_label.setText("X");
password_Check_label.setForeground(Color.red);
name_label.setText("X");
name_label.setForeground(Color.red);
number_label.setText("X");
number_label.setForeground(Color.red);
age_label.setText("X");
age_label.setForeground(Color.red);
gender_label.setText("X");
gender_label.setForeground(Color.red);
email_label.setText("X");
email_label.setForeground(Color.red);
phone_label.setText("X");
phone_label.setForeground(Color.red);

id_label2.setText("len:4~8");
password_label2.setText("len:6~12");
password_Check_label2.setText("len:6~12");
name_label2.setText("2~3");
number_label2.setText("len:10");
age_label2.setText("10~99");
gender_label2.setText("m or f");
email_label2.setText("len:4~12");
phone_label2.setText("len:11");
name_tx.addActionListener(this);
number_tx.addActionListener(this);
age_tx.addActionListener(this);
gender_tx.addActionListener(this);
email_tx.addActionListener(this);
phone_tx.addActionListener(this);
//////////////////////////////////////
cp.add(number_label);
number_label.setBounds(241,79,50,10);
cp.add(name_label);
name_label.setBounds(241,130,50,10);
cp.add(id_label);
id_label.setBounds(241,180,50,10);
cp.add(password_label);
password_label.setBounds(241,237,50,10);
cp.add(password_Check_label);
password_Check_label.setBounds(241,280,50,10);
cp.add(age_label);
age_label.setBounds(241,330,50,10);
cp.add(gender_label);
gender_label.setBounds(241,380,50,10);
cp.add(email_label);
email_label.setBounds(241,430,50,10);
cp.add(phone_label);
phone_label.setBounds(241,480,50,10);

cp.add(number_label2);
number_label2.setBounds(10,79,50,10);
cp.add(name_label2);
name_label2.setBounds(10,130,50,10);
cp.add(id_label2);
id_label2.setBounds(10,180,50,10);
cp.add(password_label2);
password_label2.setBounds(10,215,50,40);
cp.add(password_Check_label2);
password_Check_label2.setBounds(10,265,50,40);
cp.add(age_label2);
age_label2.setBounds(10,330,50,10);
cp.add(gender_label2);
gender_label2.setBounds(10,380,50,10);
cp.add(email_label2);
email_label2.setBounds(10,430,50,10);
cp.add(phone_label2);
phone_label2.setBounds(10,480,50,10);
/////////////////////////////////////////////////
        //
		cp.add(init);
		init.add(Information);
		init.add(cancel);
		init.add(join);
		setTitle("회원가입");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        //setResizable(false);
        setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//String from = "123";
		//int to = Integer.parseInt(from);
		//System.out.println(Integer.parseInt(number_tx.getText()));
		if(number_tx.getText().length()!=10) {
			//System.out.println(Integer.parseInt(number_tx.getText()));
			number_label.setText("X");
			number_label.setForeground(Color.red);
			Cs[0]=0;
		}
		else {
			number_label.setText("O");
			number_label.setForeground(Color.blue);
			Cs[0]=1;
		}
		if(name_tx.getText().length()<=1 || name_tx.getText().length()>=4) {
			name_label.setText("X");
			name_label.setForeground(Color.red);
			Cs[1]=0;
		}
		else {
			name_label.setText("O");
			name_label.setForeground(Color.blue);
			Cs[1]=1;
		}
		if(pass_tx.getText().length()<6 || pass_tx.getText().length()>10) {
			password_label.setText("X");
			password_label.setForeground(Color.red);
			Cs[3]=0;
		}
		else {
			password_label.setText("O");
			password_label.setForeground(Color.blue);
			Cs[3]=1;
		}
		if((!pass_Check_tx.getText().equals(pass_tx.getText()) && Cs[3]==1)) {
			password_Check_label.setText("X");
			password_Check_label.setForeground(Color.red);
			Cs[8]=0;
		}
		else {
			password_Check_label.setText("O");
			password_Check_label.setForeground(Color.blue);
			Cs[8]=1;
		}
		if(age_tx.getText().length()!=2){
			age_label.setText("X");
			age_label.setForeground(Color.red);
			Cs[4]=0;
		}
		else {
			age_label.setText("O");
			age_label.setForeground(Color.blue);
			Cs[4]=1;
		}
		if((!gender_tx.getText().equals("m")) && (!gender_tx.getText().equals("f"))) {
			gender_label.setText("X");
			gender_label.setForeground(Color.red);
			Cs[5]=0;
		}
		else {
			gender_label.setText("O");
			gender_label.setForeground(Color.blue);
			Cs[5]=1;
		}
		if(email_tx.getText().length()<4 || email_tx.getText().length()>12) {
			email_label.setText("X");
			email_label.setForeground(Color.red);
			Cs[6]=0;
		}
		else {
			email_label.setText("O");
			email_label.setForeground(Color.blue);
			Cs[6]=1;
		}
		if(phone_tx.getText().length()!=11) {
			phone_label.setText("X");
			phone_label.setForeground(Color.red);
			Cs[7]=0;
		}
		else {
			phone_label.setText("O");
			phone_label.setForeground(Color.blue);
			Cs[7]=1;
		}
	}
}
