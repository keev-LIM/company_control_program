import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client implements Runnable{
 
 private String ip;
 private int port;
 private static String msg;//입력받을 메세지
 private BufferedReader br;//메세지 입력받기위한 BufferedReader
 private static BufferedReader bufferR;//socket에서 사용할 IO
 private static BufferedWriter bufferW;
 private String msg1="Hi server";//입력받을 메세지
 public Client(String ip, int port) throws IOException{
  this.ip = ip;
  this.port = port;
  Socket socket = getSocket();
  boolean isStop = false;
  OutputStream os = socket.getOutputStream();
  InputStream is = socket.getInputStream();
  bufferW = new BufferedWriter(new OutputStreamWriter(os));
  bufferR = new BufferedReader(new InputStreamReader(is));
  
 }
   
  
 public static void Client_send(String msg) throws IOException {
	 msg += System.getProperty("line.separator");//enter를 먹어버리기에 받는 쪽에서 못찾기에 붙여줌
	 System.out.println("Send: " + msg);
	  bufferW.write(msg);//메세지 송신
	  bufferW.flush();
	  //bufferW.close();
	  
 }
 public static String Client_receive() throws IOException {
	  msg = bufferR.readLine();//메세지 수신
	  System.out.println("Receive: " + msg);
	  return msg;
 }
 
 public Socket getSocket(){
  Socket socket = null;
  try {
   socket = new Socket(ip, port);
   
  } catch (Exception e) {
   e.printStackTrace();
   System.out.println("Socket 생성 실패");
  }
  return socket;
 }
 /*
 public static void main(String[] args) throws IOException {
	//new LoginFrame();
  new Client("localhost", 3000);//서버의 ip와 포트
  
 }
*/


@Override
public void run() {
	// TODO Auto-generated method stub
	
}
}

