import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
 
 private ServerSocket serverS;
 static String Summon = "0\n";

 
 
 public Server(int port){
	  
	 
  try {
   serverS = new ServerSocket(port);
   
  } catch (IOException e) {
   e.printStackTrace();
   System.out.println("접속 실패!! 프로그램 종료");
   System.exit(0);
  }
  
  Server_Thread ust = null;//서버 스레드
  //Date_Thread dat = null;
  while(true){//반복
   System.out.println("Server Ready......Client waiting....");
   Socket sk = null;
   try {
    sk = serverS.accept();//접속 대기 
   } catch (IOException e) {
    e.printStackTrace();
   }
   System.out.println("Client IP : " + sk.getInetAddress().getHostAddress());//클라이언트 IP
   System.out.println("Client Port : " + sk.getPort());
   try {
	ust = new Server_Thread(sk);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   Thread t = new Thread(ust);//스레드 생성
   t.start();//스레드 시작
   //t2.start();
  }//반복
 }
 
 public static void main(String[] args) {
  new Server(3000);//서버 포트번호 3000
  
 }
}