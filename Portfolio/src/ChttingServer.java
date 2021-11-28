//192.168.219.141
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
 
class TcpChatServerManager {
    private List<Socket> socketList;
    private int count = 0;
    boolean isstop = false;
    boolean isbr = false;
	int number = 0;
    // 생성자 : TCSM 객체를 생성하면 소켓리스트 하나 만듬
    public TcpChatServerManager() {
        socketList = new ArrayList<Socket>();
    }
 
    // 소켓 추가 메소드
    public void addSocket(Socket socket) {
        this.socketList.add(socket);
        new Thread(new ReceiverThread(socket)).start();
    }
 
    // 멀티클라이언트와 연결을 동시에 유지하기 위한 스레드 구성
    // 각각의 소켓정보를 가지고 있어야함.
    class ReceiverThread implements Runnable {
        private Socket socket; // 소켓
 
        public ReceiverThread(Socket socket) {
            this.socket = socket;
        }
 
        @Override
        public synchronized  void run() {
            // TODO Auto-generated method stub
 
            try {
            	isstop=false;
                // 클라이언트가 보낸 메시지 읽기 위한 작업
                
                while (!isstop) {
                	BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String msg = br.readLine(); // 클라이언트가 보낸 메시지 읽기
                    String msg5="";
                    System.out.println("클라이언트로부터 온 메세지는 이거 : "+msg);
                    if(msg==null) {
                    	System.out.println("It's null");
                    	break;
                    }
                    if(msg.equals("<br1>")) {
                    	String msg2 = br.readLine();
                    	String msg3 = br.readLine();
                    	DBConnect.insert_chat(msg2, msg3);//number, id
                    	count = Integer.parseInt(DBConnect.select_chat_count());
                    	System.out.println("Count는 서버의"+count);
                    	msg = br.readLine();
                    }
                    
                    if(msg.equals("<br4>")) {
                    	String msg2 = br.readLine();
                    	System.out.println("number 받아야해 "+msg2);
                    	DBConnect.delete_chat(msg2);//number, id
                    	count = Integer.parseInt(DBConnect.select_chat_count());
                    	System.out.println("Count는 서버의"+count);
                    	msg = br.readLine();
                    	number=0;
                    }
                    //System.out.println(msg);
                    
                    Socket tmpSocket = null;
                    try {   
                        for (int i = 0; i < socketList.size(); i++) { // 소켓리스트를 순회하면서
                            tmpSocket = socketList.get(i);
                        	BufferedWriter bw = new BufferedWriter(
                                    new OutputStreamWriter(tmpSocket.getOutputStream()));
                            if(msg.equals("<br3>")) {
                            	bw.write(msg+"\n");
                                bw.flush();
                                System.out.println("bw4보냄 "+msg+" "+i);
                            	bw.write(count+"\n");
                                bw.flush();
                                System.out.println("count보냄 "+count);
                            	String msg4=DBConnect.select_chat();
                            		bw.write(msg4);
                                    bw.flush();
                                    System.out.println("MSG::" + msg4);
                                    msg = "<br3>";
                            }
                            else {
                            if (socket.equals(tmpSocket)) {System.out.println("건너뜁니다 " +i); continue;}
                            // 메시지를 보낸 클라이언트라면 반복을 한번 건너뛰기
                            	if(msg.equals("<br5>")) {
                            	
                            	bw.write(msg+"\n");
                                bw.flush();
                                System.out.println("bw4보냄 "+msg+" "+i);
                            	bw.write(count+"\n");
                                bw.flush();
                                System.out.println("count보냄 "+count);
                            	String msg4=DBConnect.select_chat();
                            		bw.write(msg4);
                                    bw.flush();
                                    System.out.println("MSG::" + msg4);
                                    if(number==0) {
                                    msg5 = br.readLine();
                                    number=1;
                                    }
                                    System.out.println("클라이언트에게 보낼 연결 종료 메세지 : "+msg5);
                                    bw.write(msg5 + "\n");
                                    bw.flush();
                                    msg = "<br5>";
                            }
                            	else {
                            // 서버가 받은 메시지를 클라이언트에 송신하기
                            		
                            System.out.println("이게 동작했다. server");
                            bw.write(msg + "\n");
                            bw.flush();
                            	}
                            }
                            
                            
                        }
                    }catch(Exception e) {
                        System.out.println(tmpSocket.getRemoteSocketAddress() + "연결 종료");
                        //tmpSocket.close();
						socketList.remove(tmpSocket); 
						tmpSocket.close();
                        //연결을 끊은 클라이언트를 위한 소켓 제거
                        System.out.println("===============현재참여자=================");
                        for(Socket s : socketList) {
                            System.out.println(s.getRemoteSocketAddress()+"");
                        }
    						
                        System.out.println("=======================================");
                        
                    }
                }
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
//                e.printStackTrace();
            }
            finally {
                if(socket != null) {
                	System.out.println(socket.getRemoteSocketAddress() + "연결 종료");
                    //tmpSocket.close();
					socketList.remove(socket); 
					try {
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    //연결을 끊은 클라이언트를 위한 소켓 제거
                    System.out.println("===============현재참여자=================");
                    for(Socket s : socketList) {
                        System.out.println(s.getRemoteSocketAddress()+"");
                    }
						
                    System.out.println("=======================================");
                    //socketList.remove(socket);
                    //연결을 끊은 클라이언트를 위한 소켓 제거
                    
                }
            }
 
        }
 
    }
}
 
public class ChttingServer {
    public static void main(String[] args) {
 
        // 서버소켓
 
        TcpChatServerManager tcsm = new TcpChatServerManager();
 
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            while (true) {
                Socket socket = serverSocket.accept(); // 클라이언트 연결요청 대기(연결요청 오기전엔 멈춤)
                // -> 연결요청오면? 소켓을 반환
                // 멀티 클라이언트 -> 소켓이 여러개 -> 리스트로 관리
                // -> 서버 매니져 클래스로 관리
                System.out.println(socket.getRemoteSocketAddress() + " : 연결");
                tcsm.addSocket(socket); // 얻은 소켓 서버매니져의 소켓목록에 추가
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
}