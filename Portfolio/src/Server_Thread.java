import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Server_Thread implements Runnable{
 //////////////////////
	/////////////////////
 private Socket socket;
 private InputStream is;
 private OutputStream os;
 private BufferedReader br;
 private BufferedWriter bw;
 private String msg;
 private int DB = 0;
 private int[] count = new int[100];
 private String[] db_join_info = new String[8];
 private String db_confirm_info = null;
 private String[] db_login_info = new String[2];
 private String[] db_work_info = new String[6];
 private String[] db_plan_info = new String[5];
 private String[] db_plan_info2 = new String[4];
 private String[] db_plan_info3 = new String[4];
 private String[] db_project_info = new String[8];
 private String[] db_project2_info = new String[5];
 private String[] db_ad_info = new String[2];
 private String[] db_report_info = new String[4];
 private String[] db_report_info2 = new String[5];
 private String[] db_block_info = new String[2];
 private String[] db_block_info2 = new String[2];
 private String[] db_block_info3 = new String[2];
 private String[] db_block_info4 = new String[2];
 private String Summon = "0";
 private String db_login_check = ""; 
 private String db_confirm_check = ""; 
 private String id = "";
 private String name = "";
 private String number2 = "";
 
 /////////////////////////////////Map
 private HashMap hm;
 
 ///////////////////////////////////
 //DB
 //1 : 회원가입 시 사용
 //2 : 중복확인
 //3 : 로그인 시 사용
 
 ///////////////////////////////////

 
 // 생성자 : TCSM 객체를 생성하면 소켓리스트 하나 만듬
 
 // 소켓 추가 메소드

 
 //////////////////////////////////////////////////////////////////////////////////////

 
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 @Override
 public void run() {
	 boolean root = false;
  boolean isStop = false;
  String count_num = "";
  String count_num2 = "";
  String count_num3 = "";
  try {
   is = socket.getInputStream();
   br = new BufferedReader(new InputStreamReader(is));
   os = socket.getOutputStream();
   bw = new BufferedWriter(new OutputStreamWriter(os));
  } catch (Exception e) {
   e.printStackTrace();
   isStop = true;
  }
  try {
   while(!isStop){//반복해서 메세지를 송수신
	DBConnect db = new DBConnect();
    msg = br.readLine();//메세지 수신
    if(DB == 1) {
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	db_join_info[count[0]]=msg;
    	count[0]++;
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(DB == 2) {
    	if(!msg.equals("2")) {
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	db_confirm_info = msg;
    	db_confirm_check = db.select_confirm(db_confirm_info);
    	db_confirm_check += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
    	System.out.println("db_CheckConfirm:"+db_confirm_check);
        bw.write(db_confirm_check);//메세지 재전송
        bw.flush();
        DB=0;
    	}
    }
    if(DB == 3) {
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	db_login_info[count[2]]=msg;
    	count[2]++;
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(DB == 4) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_number(msg);
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 5) {
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	db_work_info[count[4]]=msg;
    	count[4]++;
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(DB == 6) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_work_count(msg);
    	count_num = number;
    	number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 7) {
    	String number = "";
    	String number2 = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_work_data(msg);
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
    	System.out.print(number);
    	number2 = DBConnect.select_work_count(msg);
    	count_num = number2;
    	int count2 = Integer.parseInt(count_num);
    	System.out.println("count는 ? " + count2);
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
    	//for(int i = 0;i<count2;i++) {
            bw.write(number);//메세지 재전송
            bw.flush();
    	//}
        DB=0;
    }
    if(DB == 8) {
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	db_plan_info[count[7]]=msg;
    	count[7]++;
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(DB == 9) {
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	db_plan_info2[count[8]]=msg;
    	count[8]++;
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
            bw.write(msg);//메세지 재전송
            bw.flush();
    }
    if(DB == 10) {
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	db_plan_info2[count[9]]=msg;
    	count[9]++;
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
            bw.write(msg);//메세지 재전송
            bw.flush();
    }
    if(DB == 11) {
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	db_plan_info3[count[10]]=msg;
    	count[10]++;
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
            bw.write(msg);//메세지 재전송
            bw.flush();
    }
    if(DB == 12) {
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	db.delete_work_data(msg);
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
            bw.write(msg);//메세지 재전송
            bw.flush();
            DB=0;
    }
    if(DB == 13) {
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	db_project_info[count[12]]=msg;
    	count[12]++;
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
            bw.write(msg);//메세지 재전송
            bw.flush();
    }
    if(DB == 14) {
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	db_project2_info[count[13]]=msg;
    	count[13]++;
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
            bw.write(msg);//메세지 재전송
            bw.flush();
    }
    if(DB == 15) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_project_count();
    	count_num3 = number;
    	number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 16) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//get Project Data
    	number = DBConnect.select_project();
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 17) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//get Project Data
    	number = DBConnect.select_project_contents();
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 18) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_proceed_count();
    	count_num3 = number;
    	number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 19) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//get Project Data
    	number = DBConnect.select_proceed();
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 20) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//get Project Data
    	number = DBConnect.select_proceed_contents();
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 21) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_finish_count();
    	count_num3 = number;
    	number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 22) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//get Project Data
    	number = DBConnect.select_finish();
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 23) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//get Project Data
    	number = DBConnect.select_finish_contents();
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 24) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_ad_count();
    	count_num3 = number;
    	number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 25) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//get Project Data
    	number = DBConnect.select_ad();
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 26) {
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력	//레벨변경
    	db_ad_info[count[25]]=msg;
    	count[25]++;
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
            bw.write(msg);//메세지 재전송
            bw.flush();
    }
    if(DB == 27) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_ta_count();
    	count_num3 = number;
    	number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 28) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//get Project Data
    	number = DBConnect.select_ta();
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 29) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//get Project Data
    	number = DBConnect.select_ta_contents();
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 30) {
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	db_report_info[count[29]]=msg;
    	count[29]++;
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
            bw.write(msg);//메세지 재전송
            bw.flush();
    }
    if(DB == 31) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_st_count();//출퇴근 목록 개수(오늘의 출퇴근 목록)
    	count_num3 = number;
    	number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 32) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_st_data();//출퇴근 목록 모두 주기(오늘의 출퇴근 목록)
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 33) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	DBConnect.insert_announce(msg);//공지사항 입력
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 34) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//get Project Data
    	number = DBConnect.select_an(); //공지사항 받아오기
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 35) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_ac_count();
    	
    	number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 36) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_money_count();
    	number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 37) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_money();
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 38) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_money_count2();
    	number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 39) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_money2();
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 43) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_block_count();
    	number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 44) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_block();
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 45) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_block_contents();
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 46) {
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	db_block_info[count[45]]=msg;
    	count[45]++;
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
            bw.write(msg);//메세지 재전송
            bw.flush();
    }
    if(DB == 47) {
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	db_block_info2[count[46]]=msg;
    	count[46]++;
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
            bw.write(msg);//메세지 재전송
            bw.flush();
    }
    if(DB == 48) {//자기꺼
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_block_count2(id);
    	number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 49) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_block2(id);
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 50) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	number = DBConnect.select_block_contents2(id);
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 51) {
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	db_block_info3[count[50]]=msg;
    	count[50]++;
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
            bw.write(msg);//메세지 재전송
            bw.flush();
    }
    if(DB == 52) {
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	db_block_info4[count[51]]=msg;
    	count[51]++;
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
            bw.write(msg);//메세지 재전송
            bw.flush();
    }
    if(DB == 53) {
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	db_report_info2[count[52]]=msg;
    	count[52]++;
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
            bw.write(msg);//메세지 재전송
            bw.flush();
    }
    //////////////////////////////////////////////////////////////////
    if(DB == 54) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_ta_count2(number2);
    	count_num3 = number;
    	number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 55) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//get Project Data
    	number = DBConnect.select_ta2(number2);
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 56) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//get Project Data
    	number = DBConnect.select_ta_contents2(number2);
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 57) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//get Project Data
    	number = DBConnect.select_ta_contents3(number2);
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    /////////////////////////////////////////////////////////////////////
    if(DB == 58) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_money_count3(id);
    	number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 59) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_money3(id);
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 60) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_money_count4(id);
    	number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 61) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_money4(id);
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 62) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_money5(id);
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    if(DB == 63) {
    	String number = "";
    	System.out.println("Receive Message : " + msg);//받은 메세지 출력
    	//getNumber
    	number = DBConnect.select_money6(id);
    	//number += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(number);//메세지 재전송
        bw.flush();
        DB=0;
    }
    
    
    
  ////////////////////////////////////////////////////////////////////////
    if(msg.equals("1")) {
    	System.out.println("JoinDB : " + msg);//받은 메세지 출력
    	DB=1; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("2")) {
    	System.out.println("LoginDB : " + msg);
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
    	bw.write(msg);//메세지 재전송
        bw.flush();
    	DB=2;
    }
    if(msg.equals("3")) {
    	System.out.println("LoginDB : " + msg);
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
    	bw.write(msg);//메세지 재전송
        bw.flush();
    	DB=3;
    }
    if(msg.equals("4")) {
    	System.out.println("GetNumberDB:"+msg);
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
    	bw.write(msg);//메세지 재전송
        bw.flush();
        DB=4;
    }
    if(msg.equals("5")) {
    	System.out.println("출퇴근 기록부 DB:"+msg);
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
    	bw.write(msg);//메세지 재전송
        bw.flush();
        DB=5;
    }
    if(msg.equals("6")) {
    	System.out.println("출퇴근 기록부 Count 가져오기:"+msg);
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
    	bw.write(msg);//메세지 재전송
        bw.flush();
        DB=6;
    }//select_work_count(String number)
    if(msg.equals("7")) {
    	System.out.println("출퇴근 기록부 데이터 전체 가져오기:"+msg);
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
    	bw.write(msg);//메세지 재전송
        bw.flush();
        DB=7;
    }
    if(msg.equals("8")) {
    	System.out.println("오늘의 일정 DB에 등록하기"+msg);
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
    	bw.write(msg);//메세지 재전송
        bw.flush();
        DB=8;
    }
    if(msg.equals("9")) {
    	System.out.println("오늘의 일정 데이터 전체 가져오기: "+msg);
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
    	bw.write(msg);//메세지 재전송
        bw.flush();
        DB=9;
    }
    if(msg.equals("10")) {
    	System.out.println("오늘의 일정 카운트 가져오기: "+msg);
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
    	bw.write(msg);//메세지 재전송
        bw.flush();
        DB=10;
}
    if(msg.equals("11")) {
    	System.out.println("오늘의 일정 삭제 : "+msg);
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
    	bw.write(msg);//메세지 재전송
        bw.flush();
        DB=11;
}
    if(msg.equals("12")) {
    	System.out.println("출퇴근기록 삭제 : "+msg);
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
    	bw.write(msg);//메세지 재전송
        bw.flush();
        DB=12;
}
    if(msg.equals("13")) {
    	System.out.println("프로젝트 생성하기 : " + msg);//받은 메세지 출력
    	DB=13; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("14")) {
    	System.out.println("블록 생성하기 : " + msg);//받은 메세지 출력
    	DB=14; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("15")) {
    	System.out.println("프로젝트 개수 받아오기 : " + msg);//받은 메세지 출력
    	DB=15; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("16")) {
    	System.out.println("프로젝트 받아오기 : " + msg);//받은 메세지 출력
    	DB=16; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("17")) {
    	System.out.println("프로젝트 본문 받아오기 : " + msg);//받은 메세지 출력
    	DB=17; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    //프로젝트 진행, 완료 개수 받아오기
    if(msg.equals("18")) {
    	System.out.println("프로젝트 진행 개수 받아오기 : " + msg);//받은 메세지 출력
    	DB=18; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("19")) {
    	System.out.println("프로젝트 진행 받아오기 : " + msg);//받은 메세지 출력
    	DB=19; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("20")) {
    	System.out.println("프로젝트 진행 본문 받아오기 : " + msg);//받은 메세지 출력
    	DB=20; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    
    if(msg.equals("21")) {
    	System.out.println("프로젝트 완료 개수 받아오기 : " + msg);//받은 메세지 출력
    	DB=21; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("22")) {
    	System.out.println("프로젝트 완료 받아오기 : " + msg);//받은 메세지 출력
    	DB=22; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("23")) {
    	System.out.println("프로젝트 완료 본문 받아오기 : " + msg);//받은 메세지 출력
    	DB=23; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("24")) {
    	System.out.println("사원 인원 수 받아오기(사장포함) : " + msg);//받은 메세지 출력
    	DB=24; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("25")) {
    	System.out.println("사원  받아오기(사장포함) : " + msg);//받은 메세지 출력
    	DB=25; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("26")) {
    	System.out.println("사원 레벨변경 : " + msg);//받은 메세지 출력
    	DB=26; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("27")) {
    	System.out.println("보고서 수 받아오기(사장포함) : " + msg);//받은 메세지 출력
    	DB=27; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("28")) {
    	System.out.println("보고서 본문 제외 전체 받아오기(사장포함) : " + msg);//받은 메세지 출력
    	DB=28; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("29")) {
    	System.out.println("사원 본문 받아오기(사장포함) : " + msg);//받은 메세지 출력
    	DB=29; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("30")) {
    	System.out.println("보고서 첨삭해서 결재하는 거 : " + msg);//받은 메세지 출력
    	DB=30; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("31")) {
    	System.out.println("사원(출근으로 안바뀐 사람 수만 가져오기) : " + msg);//받은 메세지 출력
    	DB=31; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("32")) {
    	System.out.println("사원 데이터 받아오기 " + msg);//받은 메세지 출력
    	DB=32; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("33")) {
    	System.out.println("사원 공지사항 입력하기 to DB : " + msg);//받은 메세지 출력
    	DB=33; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("34")) {
    	System.out.println("사원 공지사항 받아오기 from DB : " + msg);//받은 메세지 출력
    	DB=34; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("35")) {
    	System.out.println("사원 count 받아오기 from DB : " + msg);//받은 메세지 출력
    	DB=35; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("36")) {
    	System.out.println("매출 count 받아오기 from DB : " + msg);//받은 메세지 출력
    	DB=36; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("37")) {
    	System.out.println("매출 받아오기 from DB : " + msg);//받은 메세지 출력
    	DB=37; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("38")) {
    	System.out.println("매출 받아오기 진행까지 Count from DB : " + msg);//받은 메세지 출력
    	DB=38; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("39")) {
    	System.out.println("매출 받아오기 진행 + 완료 from DB : " + msg);//받은 메세지 출력
    	DB=39; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("40")) {
    	
    	if(root==false) {
        bw.write(Server.Summon);//메세지 재전송
        bw.flush();
    	}
    	else {
    	bw.write("0"+"\n");//메세지 재전송
        bw.flush();
    	}
        System.out.println("Summon:" + Server.Summon);
    	
    }
    if(msg.equals("41")) {
    	System.out.println("직원소집하기 버튼 " + msg);//받은 메세지 출력
    	//Summon="1";
        	Server.Summon="1\n";
    	
    }
    if(msg.equals("42")) {
    	System.out.println("직원소집취소 버튼 " + msg);//받은 메세지 출력
    	Server.Summon="0\n";
    }
    if(msg.equals("43")) {
    	System.out.println("TempleFrame->블록 받아오기. 카운트 미진행만 " + msg);//받은 메세지 출력
    	DB=43; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("44")) {
    	System.out.println("TempleFrame->블록 받아오기. 미진행만 " + msg);//받은 메세지 출력
    	DB=44; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("45")) {
    	System.out.println("TempleFrame->블록 받아오기. 미진행만 본문" + msg);//받은 메세지 출력
    	DB=45; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("46")) {
    	System.out.println("블록 진행으로 바꾸기" + msg);//받은 메세지 출력
    	DB=46; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("47")) {
    	System.out.println("블록 진행으로 바꾸기" + msg);//받은 메세지 출력
    	DB=47; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("48")) {
    	System.out.println("TempleFrame->블록 받아오기. 진행중인 자기꺼 " + msg);//받은 메세지 출력
    	DB=48; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("49")) {
    	System.out.println("TempleFrame->블록 받아오기. 진행중인 자기꺼 " + msg);//받은 메세지 출력
    	DB=49; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("50")) {
    	System.out.println("TempleFrame->블록 받아오기. 진행중인 자기꺼 " + msg);//받은 메세지 출력
    	DB=50; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("51")) {
    	System.out.println("블록제거하기 " + msg);//받은 메세지 출력
    	DB=51; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("52")) {
    	System.out.println("블록완료하기 " + msg);//받은 메세지 출력
    	DB=52; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("53")) {
    	System.out.println("보고서 보내기 " + msg);//받은 메세지 출력
    	DB=53; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    ////////////////////////////////////////////////////////////////////////
    if(msg.equals("54")) {
    	System.out.println("보고서 수 받아오기(사장포함) : " + msg);//받은 메세지 출력
    	DB=54; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("55")) {
    	System.out.println("보고서 본문 제외 전체 받아오기(사장포함) : " + msg);//받은 메세지 출력
    	DB=55; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("56")) {
    	System.out.println("사원 본문 받아오기(사장포함) : " + msg);//받은 메세지 출력
    	DB=56; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("57")) {
    	System.out.println("보고서 본문 두번째꺼 받아오기 : " + msg);//받은 메세지 출력
    	DB=57; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("58")) {
    	System.out.println("블록 월급 카운트 받아오기 " + msg);//받은 메세지 출력
    	DB=58; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("59")) {
    	System.out.println("블록 월급 얼마인지 나오게 하기 : " + msg);//받은 메세지 출력
    	DB=59; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    ///////////////////////////
    if(msg.equals("60")) {
    	System.out.println("예상 월급 카운트 : " + msg);//받은 메세지 출력
    	DB=60; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("61")) {
    	System.out.println("예상 월급 얼마인지? : " + msg);//받은 메세지 출력
    	DB=61; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("62")) {
    	System.out.println("블록 월급 기타 정보 출력 : " + msg);//받은 메세지 출력
    	DB=62; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    if(msg.equals("63")) {
    	System.out.println("블록 월급 예상 기타 정보 출력 : " + msg);//받은 메세지 출력
    	DB=63; //JoinDB
    	msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
        bw.write(msg);//메세지 재전송
        bw.flush();
    }
    /*
    if(msg.equals("4")) {
    SimpleDateFormat format = new SimpleDateFormat ( "yyyy년 MM월dd일 HH시mm분ss초");
	   Calendar time = Calendar.getInstance();
	   String format_time = format.format(time.getTime());
	   format_time+= System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
   	bw.write(format_time);//메세지 재전송
       bw.flush();
       Thread.sleep(1000);
    }
    */
    //System.out.println("Receive Message : " + msg);//받은 메세지 출력
    //db.insert_join(number, name, id, password, age, gender, email, phone);
    //msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
    //shark = msg;
    //System.out.print(shark);
    //////////////////////////////////////DB전송
    if(count[0]==8) {
    	db.insert_join(db_join_info[0],db_join_info[1],db_join_info[2],db_join_info[3],db_join_info[4],db_join_info[5],db_join_info[6],db_join_info[7]);
    	count[0]=0;
    	DB=0;
    }
    if(count[2]==2) {
    	db_login_check = DBConnect.select_login(db_login_info[0], db_login_info[1]);
    	if(db_login_info[0].equals("dlagudwh4"))
    		root = true;
    	else root = false;
    	id=db_login_info[0];
    	name=DBConnect.select_login2(db_login_info[0]);
    	number2=DBConnect.select_login3(db_login_info[0]);
    	System.out.println("ROOT?"+root);
    	System.out.println(id);
    	db_login_check += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
    	System.out.println("db_LoginCheck:"+db_login_check);
        bw.write(db_login_check);//메세지 재전송
        bw.flush();
        //db_confirm_check="";
    	count[2]=0;
    	DB=0;
    }
    if(count[4]==6) {
    	db.insert_work(db_work_info[0],db_work_info[1],db_work_info[2],db_work_info[3],db_work_info[4],db_work_info[5]);
    	count[4]=0;
    	DB=0;
    }
    if(count[7]==5) {
    	db.insert_plan(db_plan_info[0],db_plan_info[1],db_plan_info[2],db_plan_info[3],db_plan_info[4]);
    	count[7]=0;
    	DB=0;
    }
    if(count[8]==4) {
    	String number = "";
    	String number2 = "";
    	count_num2=db.select_plan_count(db_plan_info2[0],db_plan_info2[1],db_plan_info2[2],db_plan_info2[3]);
    	number = db.select_plan_data(db_plan_info2[0],db_plan_info2[1],db_plan_info2[2],db_plan_info2[3]);
    	System.out.println("count는 ? " + count_num2);
    	 bw.write(number);//메세지 재전송
         bw.flush();
    	count[8]=0;
    	DB=0;
    }
    if(count[9]==4) {
    	String number = "";
    	String number2 = "";
    	count_num2=db.select_plan_count(db_plan_info2[0],db_plan_info2[1],db_plan_info2[2],db_plan_info2[3]);    	
    	//System.out.println("count는 ? " + count_num2);
    	count_num2 += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
    	 bw.write(count_num2);//메세지 재전송
         bw.flush();
    	count[9]=0;
    	DB=0;
    }
    if(count[10]==4) {
    	db.delete_plan_data(db_plan_info3[0],db_plan_info3[1],db_plan_info3[2],db_plan_info3[3]);
    	//db.delete_work_data(db_plan_info3[0]);
    	//System.out.println("count는 ? " + count_num2);
    	count[10]=0;
    	DB=0;
    }
    if(count[12]==8) {	//프로젝트 생성
    	db.insert_project(db_project_info[0],db_project_info[1],db_project_info[2],db_project_info[3],db_project_info[4],db_project_info[5],db_project_info[6],db_project_info[7]);
    	count[12]=0;
    	DB=0;
    }
    if(count[13]==5) {	//프로젝트 생성
    	db.insert_block(db_project2_info[0],db_project2_info[1],db_project2_info[2],db_project2_info[3], db_project2_info[4]);
    	count[13]=0;
    	DB=0;
    }
    if(count[25]==2) {	//프로젝트 생성
    	db.alter_level(db_ad_info[0],db_ad_info[1]);
    	count[25]=0;
    	DB=0;
    }
    if(count[29]==4) {	//프로젝트 생성
    	db.alter_report(db_report_info[0],db_report_info[1],db_report_info[2],db_report_info[3]);
    	count[29]=0;
    	DB=0;
    }
    if(count[45]==2) {	//프로젝트 생성
    	System.out.println("ROOT"+id);
    	db.alter_block(db_block_info[0],db_block_info[1], id);
    	String a = db.block_count(db_block_info[0],db_block_info[1]);
    	String b = db.block_count2(db_block_info[0],db_block_info[1]);
    	if(a.equals(b)) {
    		db.alter_project_status(db_block_info[0]);//진행으로 바꾸기
    	}
    	count[45]=0;
    	DB=0;
    }
    if(count[46]==2) {	//프로젝트 생성
    	System.out.println("ROOT"+id);
    	String num="";
    	num = db.select_block_level(db_block_info2[0],db_block_info2[1]);
    	num += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
   	 bw.write(num);//메세지 재전송
        bw.flush();
    	count[46]=0;
    	DB=0;
    }
    if(count[50]==2) {	//블록 포기하기.
    	db.alter_block_(db_block_info3[0],db_block_info3[1],id);
    	//프로젝트 넘버가 뭐인거를 미진행으로 바꾸고
    	//프, 블 넘버가 뭐인거를 미진행으로 바꾼다.
    	db.alter_project_status2(db_block_info3[0]);	//미진행으로 바꾸기
    	db.alter_block_status(db_block_info3[0],db_block_info3[1]);
    	
    	count[50]=0;
    	DB=0;
    }
    if(count[51]==2) {	//컴플리트
    	db.alter_block_complete(db_block_info4[0],db_block_info4[1],id);
    	String a = db.block_count(db_block_info4[0],db_block_info4[1]);
    	String b = db.block_count3(db_block_info4[0],db_block_info4[1]);//완료로 바꾸기
    	if(a.equals(b)) {
    		db.alter_project_status3(db_block_info4[0]);//완료로 바꾸기
    	}
    	count[51]=0;
    	DB=0;
    }
    if(count[52]==4) {	//프로젝트 생성
    	db.insert_report(number2,db_report_info2[1],db_report_info2[2],db_report_info2[3],name);
    	count[52]=0;//사원번호, 레포트번호, (단순질문,결재원함), context
    	DB=0;
    }
    //////////////////////////////////////
    //msg += System.getProperty("line.separator");//다시 전송하기위해 enter값 넣어주기
    //bw.write(msg);//메세지 재전송
    //bw.flush();
    ////////////////////////////
    /////////////////////////////
   }
  } catch (Exception e) {
	  /*
   System.out.println("클라이언트를 강제로 종료했습니다. ");
   isStop = true;
   */
  }finally{
	  
   try {
    if(br != null)br.close();
    if(bw != null)bw.close();
    if(socket != null)socket.close();
    System.out.print("연결종료");
   } catch (Exception e2) {
      }
  }
  
  //////////////////////////////////
  

  
  
  //////////////////////////////////
 }

 public Server_Thread(Socket socket) throws IOException{
  this.socket = socket;
      // -> 연결요청오면? 소켓을 반환
          // 멀티 클라이언트 -> 소켓이 여러개 -> 리스트로 관리
          // -> 서버 매니져 클래스로 관리
 }
}