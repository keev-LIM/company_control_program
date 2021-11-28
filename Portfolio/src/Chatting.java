

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
public class Chatting extends JFrame implements WindowListener{
    //자유롭게 사용하려면 여기에 필드로 선언해야 한다
    //채팅창 프레임을 구성하는 컴포넌트
    //textarea 한줄 이상의 문자 입력 보여주기
    private boolean stopped = false;
    private JTextArea textarea;
    private JTextArea textarea2;
    private JTextField sendMsgTf;
    private JScrollPane scrollPane;
    private JScrollPane scrollPane2;
    private BufferedWriter bw;
    private Socket socket;
    //////////////
    private OutputStream os2;
    private BufferedWriter bw2;
    ////////////
    TcpClientReceiveThread th1;
    private JPanel jp = new JPanel(new FlowLayout());
    Box box = Box.createVerticalBox();
    JPanel init = new JPanel(new BorderLayout());
    int count=0;
    public Chatting() {
 	   Container cp = getContentPane();
    	textarea = new JTextArea();
    	textarea2 = new JTextArea();
    	textarea2.setEditable(false);
        sendMsgTf = new JTextField();
        JButton btn = new JButton();
        btn.setText("나가기");
        textarea.setEditable(false);//쓰기를 금지함 edit 할 수 없는 상태
        try {
            //서버 아이피 , 포트번호 -> 소켓 생성 -> 연결 요청
            socket = new Socket("localhost", 5000);
            //소켓 객체 생성
            setSocket(socket);//메인에서 프레임 생성
            TcpClientReceiveThread th1 =new TcpClientReceiveThread(socket);
            //TcpClientReceiveThread가 내부 클래스로 선언되어 있기 때문에
            //cf로 접근해서 socket을 전달한다
            
            ////
            bw.write("<br1>"+"\n");
            bw.flush();
            bw.write(LoginFrame.getNumber()+"\n");
            bw.flush();
            bw.write(LoginFrame.getID()+"\n");
            bw.flush();
            
            bw.write("<br3>"+"\n");
            bw.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                br.readLine();//메세지 한줄 읽어오기
                count = Integer.parseInt(br.readLine());
                StringBuffer msg = new StringBuffer();
                System.out.println("count : " + count);
				for(int i = 0;i<count;i++) {
               	 msg.append(br.readLine()+"\n");
                }
                textarea2.setText(msg.toString());
            ///
                
            bw.write("["+LoginFrame.getID()+"]님이 입장하셨습니다.\n");
            bw.flush();
            
            new Thread(th1).start();
        } catch (Exception e) {
            e.printStackTrace();
            try {
            	System.out.println("소켓 메인 종료");
            	if(socket!=null)
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        scrollPane = new JScrollPane(textarea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //As needed 즉 필요에의해서 내용이 많아지면 스크롤 바가 생긴다
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //가로 스크롤은 안만든다
        scrollPane2 = new JScrollPane(textarea2);
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane2.setPreferredSize(new Dimension(150, 400));
        
        sendMsgTf.setBackground(Color.black);
        sendMsgTf.setForeground(Color.white);
        sendMsgTf.addKeyListener(new MsgSendListener());
        //텍스트 필드에 키 리스너를 등록
        //텍스트 필드를 지켜보고 있다가 특정 상황이 오면
        //이벤트 리스너에 정의된 내용 실행
        btn.addActionListener(e->{
        	try {
        		////
        		
                bw.write("<br4>"+"\n");
                bw.flush();
                bw.write(LoginFrame.getNumber()+"\n");
                bw.flush();
                ///////////////////
                bw.write("<br5>"+"\n");
                bw.flush();
                bw.write("["+LoginFrame.getID()+"]님이 연결을 종료하셨습니다.\n");
				bw.flush();
                
				
				stop();
                ///
				socket.close();
				dispose();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        
        init.add(scrollPane,BorderLayout.CENTER);//프레임에 붙이기
        //add(textarea,BorderLayout.CENTER);//프레임에 붙이기
        init.add(sendMsgTf,BorderLayout.SOUTH);//프레임에 붙이기
        JLabel GOGO = new JLabel("방 참여 인원");
        GOGO.setForeground(Color.white);
        GOGO.setBackground(Color.black);
		GOGO.setFont(new Font("맑은고딕", Font.BOLD, 15));
        scrollPane.setBackground(Color.black);
        init.setBackground(Color.black);
        textarea.setBackground(Color.black);
        textarea.setForeground(Color.white);
        textarea2.setBackground(Color.black);
        textarea2.setForeground(Color.white);
        box.add(GOGO);
        box.add(scrollPane2);
        box.setBackground(Color.black);
        box.add(btn);
        init.add(box, BorderLayout.EAST);
        cp.add(init);
        setLocationRelativeTo(null);
        //setResizable(false);
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        setTitle("chatting");
        
        
        
        
        
    }
    //소켓 설정을 위한 세터
    //이제 프레임도 소켓의 정보를 가지게 되었다
    public void setSocket(Socket socket) {
        try {
            OutputStream out = socket.getOutputStream();
            bw = new BufferedWriter(new OutputStreamWriter(out));
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
 public void stop() {
	 stopped=true;
 }
 
    //내부 클래스로 이벤트 리스너 만들기
    
    class MsgSendListener implements KeyListener {
 
        @Override
        public void keyTyped(KeyEvent e) {
            
        }
        @Override
        public void keyPressed(KeyEvent e) {
            
        }
 
        @Override
        public void keyReleased(KeyEvent e) {//키가 눌렸다가 떼어졌을때
            //엔터키가 눌렸다가 떼어지면 텍스트 필드에 있는 내용이 텍스트 에어리어에 나타나게
            if (e.getKeyCode()==KeyEvent.VK_ENTER) {//각각의 키들이 가지고 있는 코드 값이 나타난다
                //VK_ENTER = 상수 , 엔터 키에 대한 키값을 의미한다
                String msg = sendMsgTf.getText();
                System.out.println(msg);
                textarea.append("[ 나 ]: "+msg+"\n");
                sendMsgTf.setText("");
                try {
                	if(!msg.equals("<br1>")&&!msg.equals("<br3>")) {
                    bw.write("["+LoginFrame.getID()+"]:"+msg+"\n");
                    bw.flush();
                	}
                	else{
                		 JOptionPane.showMessageDialog(null, "<br1>, <br5>는 금지단어입니다.");
                	}
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    /*
                    try {
						//bw.close();
						//socket.close();//다 쓴 소켓 닫기  
						System.out.println("소켓을 닫습니다.");
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					*/
                }//한문장이 끝났다는 것을 알리기 위해서 bufferedWriter에 "\n"을 붙인다
                
            }
            
        }
    }
    //내부 클래스로 수신 스레드 작성
    
    class TcpClientReceiveThread implements Runnable {
        private Socket socket;
        public TcpClientReceiveThread(Socket socket) {
            this.socket = socket;
        }
        @Override
        public synchronized void run() {
            //서버로부터 오는 메세지를 읽어서
            //텍스트 에어리어에 추가하기
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while(!stopped) {
                    String msg = br.readLine();//메세지 한줄 읽어오기
                   //System.out.println(msg.equals("<br3>"));
                   System.out.println("<br3>여야 하는데 맞니? "+msg);
                    if(msg.equals("<br3>")) {
                        count = Integer.parseInt(br.readLine());
                        StringBuffer msg2 = new StringBuffer();
                        System.out.println("count : " + count);
        				for(int i = 0;i<count;i++) 
                       	 msg2.append(br.readLine()+"\n");
                        
                        textarea2.setText(msg2.toString());
                        System.out.println("이거는 동작");
                    }
                    else if(msg.equals("<br5>")) {
                        count = Integer.parseInt(br.readLine());
                        StringBuffer msg2 = new StringBuffer();
                        System.out.println("count : " + count);
        				for(int i = 0;i<count;i++) 
                       	 msg2.append(br.readLine()+"\n");
                        textarea2.setText(msg2.toString());
                        System.out.println("이거는 동작");
                    }
                    else if(!msg.equals("<br1>")) { 
                    	textarea.append(msg + "\n");
                    	System.out.println("이게 동작 안하나?");
                    	System.out.println("msg(추측되는 거)"+msg);
                    }
                }
                
            } catch (IOException e) {
                textarea.append("연결이 종료되었습니다.");
                
                //System.out.println("연결이 종료되었습니다.");
            } 
            finally {                
                try {
                    if (socket!=null&&!socket.isClosed()) {
                    socket.close();//다 쓴 소켓 닫기            
                    }
                } catch (IOException e2) {
                    
                }
            }
            
            System.out.println("종료!");
        }
    }
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}