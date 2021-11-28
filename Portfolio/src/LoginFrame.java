
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class LoginFrame extends JFrame implements ActionListener{
    BufferedImage img = null;
    JTextField loginTextField;
    JPasswordField passwordField;
    JButton bt;
    JButton join_bt;
    Container cp;
    JPanel Center = new JPanel(new FlowLayout()); 
	 JPanel Idpass = new JPanel(new GridLayout(3,2,5,5)); 
	 JLabel Message = new JLabel("잘못된 ID입니다.");
	 JLabel Message2 = new JLabel("");
	 private static String IDuse = "";
	 private static String number = "";
	 private static String count = "";
	 private static String level = "";
	 private static String Test = "";
	 private CardLayout cards = new CardLayout();
    // 메인
	 
    public static void main(String[] args) throws IOException {
        new LoginFrame();
        Client ct = new Client("localhost", 3000);//서버의 ip와 포트
        //Date_Client dc = new Date_Client("localhost",3000);
        //ct.Client_send("Hello");
        //ct.Client_receive();
        //ct.Getinfo("gg", "hh");
    }
    // 생성자
    @SuppressWarnings("deprecation")
	public LoginFrame() {
    	
    	//DBConnect db = new DBConnect();
    	//db.insert_join("2015301066", "임형조", "dlagudwh4", "@@aa1016007", "24", "남","dlagudwh4@naver.com", "01050317353");
    	cp = this.getContentPane();
    	 //cp.setLayout(new BorderLayout(5,5));
    	 cp.setLayout(cards);
        // 패널1
        // 이미지 받아오기
        //panel.setBounds(0, 0, 600, 800);
        Label hjcompany = new Label("HJCompany");
        hjcompany.setForeground(Color.YELLOW);
        hjcompany.setFont(new Font("맑은고딕", Font.BOLD, 30));
        Center.add(hjcompany);
        // 로그인 필드
        Label ID = new Label("ID");
        ID.setForeground(Color.white);
        ID.setFont(new Font("맑은고딕", Font.BOLD, 15));
        Idpass.add(ID);
        loginTextField = new JTextField(10);
        loginTextField.setForeground(Color.green);
        loginTextField.setOpaque(false);
        Idpass.add(loginTextField);
        // 패스워드
        
        Label pass = new Label("Password");
        pass.setForeground(Color.white);
        pass.setFont(new Font("맑은고딕", Font.BOLD, 15));
        passwordField = new JPasswordField(10);
        passwordField.setOpaque(false);
        passwordField.setForeground(Color.green);
        Idpass.add(pass);
        Idpass.add(passwordField);
        Idpass.add(Message2);
        Message.setForeground(Color.red);
        Message.setVisible(false);
        Idpass.add(Message);
        Idpass.setBackground(Color.BLACK);
        Center.add(Idpass);
     // 로그인버튼 추가
        bt = new JButton("로그인");
        bt.setForeground(Color.white);
        bt.setFont(new Font("맑은고딕", Font.BOLD, 15));
        bt.addActionListener(e->{
        	String pw_login_temp = null;
        	//System.out.print(loginTextField.getText());
        	//System.out.print(loginTextField.getText().length()==0);
        	if(loginTextField.getText().length()==0&&passwordField.getPassword().length==0) {
        		JOptionPane.showMessageDialog(null, "아이디, 패스워드를 입력하세요.");
        	}
        	else if(loginTextField.getText().length()==0&&passwordField.getPassword().length!=0) { 
        		JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
        	}
        	else if(loginTextField.getText().length()!=0&&passwordField.getPassword().length==0) { 
        		JOptionPane.showMessageDialog(null, "패스워드를 입력하세요.");
        	}
        	else {
        		try {
        			Client.Client_send("3");
        			Client.Client_receive();
        			pw_login_temp = new String(passwordField.getPassword());
        			Client.Client_send(loginTextField.getText());
        			Client.Client_receive();
					Client.Client_send(pw_login_temp);
					Client.Client_receive();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	//System.out.println("Login");
        	//dispose();
        		
        	try {
        		String login = Client.Client_receive();
				if(login.equals("1")) {
					System.out.println("로그인성공");
					IDuse=loginTextField.getText();
					Client.Client_send("4");
					Client.Client_receive();
					Client.Client_send(IDuse);
				   number = Client.Client_receive();
				   level = Client.Client_receive();
				   System.out.println("level이다 : "+level);
				   //보여줄 개수 받아오기
				   Client.Client_send("6");
					Client.Client_receive();
					Client.Client_send(number);
					count = Client.Client_receive();
					dispose();
					if(IDuse.equals("dlagudwh4"))
					new SuperFrame();
					else
					new TempleFrame();
				}
				else if(login.equals("2")) {
	            	System.out.println("패스워드가 틀립니다.");
	            	JOptionPane.showMessageDialog(null, "패스워드가 틀립니다.");
	            }
	            else if(login.equals("3")) {
	            	System.out.println("잘못된 아이디입니다.");
	            	JOptionPane.showMessageDialog(null, "잘못된 아이디입니다.");
	            }
	            else if(login.equals("4")){
	            	System.out.println("아이디, 패스워드가 모두 틀립니다.");
	            	JOptionPane.showMessageDialog(null, "아이디, 패스워드 두개 다 틀립니다.");
	            }
				
				
				}
			 catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        	}
        	
        });
     // 회원가입 버튼
        join_bt = new JButton("회원가입");
        join_bt.setForeground(Color.white);
        join_bt.setFont(new Font("맑은고딕", Font.BOLD, 15));
        join_bt.addActionListener(e->{
        	System.out.println("Join");
        	try {
				new JoinFrame();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        
        Center.add(join_bt);
        join_bt.setBorderPainted(false);
        join_bt.setFocusPainted(false);
        join_bt.setContentAreaFilled(false);
        //// 버튼 투명처리
        bt.setBorderPainted(false);
        bt.setFocusPainted(false);
        bt.setContentAreaFilled(false);
        Center.add(bt);
        
        cp.add(Center);
        //cp.add("two", new SuperFrame());
        Center.setBackground(Color.black);
        setTitle("로그인");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
    }
    static String getID() {
    	return IDuse;
    }
    static String getNumber() {
    	return number;
    }
    static String getCount() {
    	return count;
    }
    static String getLevel() {
    	return level;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static String getTest() {
		return Test;
	}
	public static void setTest(String test) {
		Test = test;
	}
}