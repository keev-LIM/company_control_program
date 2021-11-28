import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JOptionPane;

import java.sql.*;
public class DBConnect {
    public static void main(String args[]){
        //insert_join("2015301065", "임형조", "dlagudwh4", "@@aa1016007", "24", "남","dlagudwh4@naver.com", "01050317353");
        //delete("20191121");
        select_standard();
        //insert(number, name, id,password, age, gender, email, phone);
       
    }
    ///////////////////////////////////select
    
    public static void select_standard(){
    	Connection conn = null;
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from standard";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        
        while(rs.next()){
        	int number = rs.getInt("number");
        	String name = rs.getString("name");
        	String id = rs.getString("id");
        	String password = rs.getString("password");
        	int age = rs.getInt("age");
        	String gender = rs.getString("gender");
        	String email = rs.getString("email");
        	String phone = rs.getString("phone");
        	
        System.out.format("%s,%s,%s,%s,%s,%s,%s,%s\n", number, name, id, password, age, gender, email, phone);
        }
        System.out.println("Successfully Connection!");
        
    st.close();
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }

    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
    }
    public static String select_login(String id_login, String pw_login) {
    	Connection conn = null;
    	String id = null;
    	String password = null;
    	//String pw_login_temp = null ;
    	//pw_login_temp = new String(pw_login);
        try{
            //1. 드라이버 로딩 : mysql 드라이버 로딩
           Class.forName("com.mysql.cj.jdbc.Driver"); 
            String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
            conn = DriverManager.getConnection(url, "root", "root");
            String qu  = "select id, password from standard where id = "+"'"+id_login+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(qu);
            
            while(rs.next()){
            	id = rs.getString("id");
            	password = rs.getString("password");
            }
            System.out.println("Successfully Connection!");
            //if(id_login == id && pw_login_temp == password) {
            if(id_login.equals(id)&&pw_login.equals(password)) {
            	System.out.println("id, pw가 데이터베이스 상에 존재합니다.");
            	st.close();
            	return "1";
            }
            else if(id_login.equals(id)&&!pw_login.equals(password)) {
            	System.out.println("id_login1 " + id_login + pw_login + " " + pw_login.length());
            	System.out.println("id_login2 " + id + password + " " + password.length());
            	st.close();
            	return "2";
            }
            else if(!id_login.equals(id)&&pw_login.equals(password)) {
            	System.out.println("잘못된 아이디입니다.");
            	System.out.println("id_login1 " + id_login + pw_login + " " + pw_login.length());
            	System.out.println("id_login2 " + id + password + " " + password.length());
            	st.close();
            	return "3";
            }
            else {
            	System.out.println("아이디, 패스워드가 모두 틀립니다.");
            	return "4";
            }
            
        
        }
        catch(ClassNotFoundException e){
            System.out.println("Failed because of not loading driver");
        }
        catch(SQLException e){
            System.out.println("error : " + e);
        }

        finally{
            try{
                if(conn != null && !conn.isClosed()){
                    conn.close();
                }
            }

            catch(SQLException e){
                e.printStackTrace();
            }
        }
        
		return "0";
        }
    /////////////////////////////////
    
    /////////////////////////////////////////////////////////////////////////
    public static String select_number(String id_login) {
    	Connection conn = null;
    	int number = 0;
    	int level;
    	String count = "";
        try{
            //1. 드라이버 로딩 : mysql 드라이버 로딩
           Class.forName("com.mysql.cj.jdbc.Driver"); 
            String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
            conn = DriverManager.getConnection(url, "root", "root");
            String qu  = "select * from standard where id = "+"'"+id_login+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(qu);
            
            while(rs.next()){
            	if(rs.getString("id").equals(id_login)) {
            		number = rs.getInt("number");
            		level = rs.getInt("level");
            		count = number +"\n" + level + "\n";
            	}
            }
            System.out.println(number);
            System.out.println("Successfully Connection!");
    		return count;
        }
        catch(ClassNotFoundException e){
            System.out.println("Failed because of not loading driver");
        }
        catch(SQLException e){
            System.out.println("error : " + e);
        }
        finally{
            try{
                if(conn != null && !conn.isClosed()){
                    conn.close();
                }
            }

            catch(SQLException e){
                e.printStackTrace();
            }
        }
		return count;
        }
    ////////////////////////////////////////////////////////////////////////
    public static String select_confirm(String id_login) {
    	Connection conn = null;
    	String id = null;
        try{
            //1. 드라이버 로딩 : mysql 드라이버 로딩
           Class.forName("com.mysql.cj.jdbc.Driver"); 
            String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
            conn = DriverManager.getConnection(url, "root", "root");
            String qu  = "select * from standard";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(qu);
            while(rs.next()){
            	if(rs.getString("id").equals(id_login)) {
            		id = rs.getString("id");
            	}
            }
            System.out.println("Successfully Connection!");
            System.out.println(id_login);
            if(id_login.equals(id)) {
            	st.close();
            	return "0";
            }
            else  {
            	st.close();
            	return "1";
            }
        }
        catch(ClassNotFoundException e){
            System.out.println("Failed because of not loading driver");
        }
        catch(SQLException e){
            System.out.println("error : " + e);
        }

        finally{
            try{
                if(conn != null && !conn.isClosed()){
                    conn.close();
                }
            }

            catch(SQLException e){
                e.printStackTrace();
            }
        }
        
		return "0";
        }
    //////////////////////////////////////
//////////////////////////////Insert

//////////////////////////////////////////////
////////////////////////////Delete
public static void delete(String number){
Connection conn = null;
PreparedStatement pstmt = null;

try{
// 1. 드라이버 로딩
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. 연결하기
String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
conn = DriverManager.getConnection(url, "root", "root");

String sql = "delete from standard where number=?";
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, number); // 5. SQL 문장을 실행하고 결과를 리턴 - SQL 문장 실행 후, 변경된 row 수 int type 리턴 
int r = pstmt.executeUpdate();
System.out.println("변경된 row : " + r); }
catch (SQLException e) { System.out.println("[SQL Error : " + e.getMessage() + "]"); } 
catch (ClassNotFoundException e1) { System.out.println("[JDBC Connector Driver 오류 : " + e1.getMessage() + "]"); } 
finally { //사용순서와 반대로 close 함
	if (pstmt != null) { try { pstmt.close(); } 
	catch (SQLException e) { e.printStackTrace(); } }
	if (conn != null) {
		try { conn.close(); } 
		catch (SQLException e) { e.printStackTrace(); } 
		} }
}

public static void insert_join(String number, String name, String id,
        String password, String age, String gender, String email, String phone){
Connection conn = null;
PreparedStatement pstmt = null;
try{
// 1. 드라이버 로딩
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. 연결하기
String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
conn = DriverManager.getConnection(url, "root", "root");

// 3. SQL 쿼리 준비
// 추가하려는 데이터의 값은 전달된 인자를 통해 동적으로 할당되는 값이다.
// 즉 어떤 값이 전달될지 모르므로 Select 할 때와 달리
// stmt = conn.createStatement(); 를 작성하지 않고
// pstmt = conn.prepareStatement(sql); 로 작성하여 데이터를 추가할 것임을 알립니다.
// 물론 sql 쿼리 내에서 + 연산자로 한 줄로 작성할 수 있지만 가독성이 너무 떨어지게 되므로
// 이 방법을 권합니다.
String sql = "INSERT INTO standard VALUES (?,?,?,?,?,?,?,?,?)";
pstmt = conn.prepareStatement(sql);


// 4. 데이터 binding
pstmt.setString(1, number);
pstmt.setString(2, name);
pstmt.setString(3, id);
pstmt.setString(4, password);
pstmt.setString(5, age);
pstmt.setString(6, gender);
pstmt.setString(7, email);
pstmt.setString(8, phone);
pstmt.setString(9, "0");


// 5. 쿼리 실행 및 결과 처리
// SELECT와 달리 INSERT는 반환되는 데이터들이 없으므로
// ResultSet 객체가 필요 없고, 바로 pstmt.executeUpdate()메서드를 호출하면 됩니다.
// INSERT, UPDATE, DELETE 쿼리는 이와 같이 메서드를 호출하며
// SELECT에서는 stmt.executeQuery(sql); 메서드를 사용했었습니다.
// @return     int - 몇 개의 row가 영향을 미쳤는지를 반환
int count = pstmt.executeUpdate();
if( count == 0 ){
System.out.println("데이터 입력 실패");
}
else{
System.out.println("데이터 입력 성공");
}
}
catch( ClassNotFoundException e){
System.out.println("드라이버 로딩 실패");
}
catch( SQLException e){
System.out.println("에러 " + e);
}
finally{
try{
if( conn != null && !conn.isClosed()){
  conn.close();
}
if( pstmt != null && !pstmt.isClosed()){
  pstmt.close();
}
}
catch( SQLException e){
e.printStackTrace();
}
}
}
//insert_project
public static void insert_project(String projectNum, String year, String month,
        String day, String level, String contents, String money, String status){
Connection conn = null;
PreparedStatement pstmt = null;
try{
// 1. 드라이버 로딩
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. 연결하기
String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
conn = DriverManager.getConnection(url, "root", "root");
String sql = "INSERT INTO project VALUES (?,?,?,?,?,?,?,?)";
pstmt = conn.prepareStatement(sql);
// 4. 데이터 binding
pstmt.setString(1, projectNum);
pstmt.setString(2, year);
pstmt.setString(3, month);
pstmt.setString(4, day);
pstmt.setString(5, level);
pstmt.setString(6, contents);
pstmt.setString(7, money);
pstmt.setString(8, status);
int count = pstmt.executeUpdate();
if( count == 0 ){
System.out.println("데이터 입력 실패");
}
else{
System.out.println("데이터 입력 성공");
}
}
catch( ClassNotFoundException e){
System.out.println("드라이버 로딩 실패");
}
catch( SQLException e){
System.out.println("에러 " + e);
}
finally{
try{
if( conn != null && !conn.isClosed()){
  conn.close();
}
if( pstmt != null && !pstmt.isClosed()){
  pstmt.close();
}
}
catch( SQLException e){
e.printStackTrace();
}
}
}
///
//insert_block
public static void insert_block(String projectNum, String blockNum, String money,
      String level, String contents){
Connection conn = null;
PreparedStatement pstmt = null;
try{
//1. 드라이버 로딩
Class.forName("com.mysql.cj.jdbc.Driver");

//2. 연결하기
String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
conn = DriverManager.getConnection(url, "root", "root");
String sql = "INSERT INTO block VALUES (?,?,?,?,?,?,?)";
pstmt = conn.prepareStatement(sql);
//4. 데이터 binding
pstmt.setString(1, projectNum);
pstmt.setString(2, blockNum);
pstmt.setString(3, money);
pstmt.setString(4, contents);
pstmt.setString(5, "미진행");
pstmt.setString(6, "x");
pstmt.setString(7, level);
int count = pstmt.executeUpdate();
if( count == 0 ){
System.out.println("데이터 입력 실패");
}
else{
System.out.println("데이터 입력 성공");
}
}
catch( ClassNotFoundException e){
System.out.println("드라이버 로딩 실패");
}
catch( SQLException e){
System.out.println("에러 " + e);
}
finally{
try{
if( conn != null && !conn.isClosed()){
conn.close();
}
if( pstmt != null && !pstmt.isClosed()){
pstmt.close();
}
}
catch( SQLException e){
e.printStackTrace();
}
}
}
///
public static void insert_work(String number, String year, String month, String day, String time, String work){
Connection conn = null;
PreparedStatement pstmt = null;
try{
// 1. 드라이버 로딩
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. 연결하기
String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
conn = DriverManager.getConnection(url, "root", "root");

// 3. SQL 쿼리 준비
// 추가하려는 데이터의 값은 전달된 인자를 통해 동적으로 할당되는 값이다.
// 즉 어떤 값이 전달될지 모르므로 Select 할 때와 달리
// stmt = conn.createStatement(); 를 작성하지 않고
// pstmt = conn.prepareStatement(sql); 로 작성하여 데이터를 추가할 것임을 알립니다.
// 물론 sql 쿼리 내에서 + 연산자로 한 줄로 작성할 수 있지만 가독성이 너무 떨어지게 되므로
// 이 방법을 권합니다.
String sql = "INSERT INTO work VALUES (?,?,?,?,?,?)";
pstmt = conn.prepareStatement(sql);


// 4. 데이터 binding
pstmt.setString(1, number);
pstmt.setString(2, year);
pstmt.setString(3, month);
pstmt.setString(4, day);
pstmt.setString(5, time);
pstmt.setString(6, work);
int count = pstmt.executeUpdate();
if( count == 0 ){
System.out.println("데이터 입력 실패");
}
else{
System.out.println("데이터 입력 성공");
}
}
catch( ClassNotFoundException e){
System.out.println("드라이버 로딩 실패");
}
catch( SQLException e){
System.out.println("에러 " + e);
}
finally{
try{
if( conn != null && !conn.isClosed()){
  conn.close();
}
if( pstmt != null && !pstmt.isClosed()){
  pstmt.close();
}
}
catch( SQLException e){
e.printStackTrace();
}
}
}
/////
public static void insert_plan(String number, String year, String month, String day, String plan){
Connection conn = null;
PreparedStatement pstmt = null;
try{
Class.forName("com.mysql.cj.jdbc.Driver");
String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
conn = DriverManager.getConnection(url, "root", "root");
String sql = "INSERT INTO plan VALUES (?,?,?,?,?)";
pstmt = conn.prepareStatement(sql);


// 4. 데이터 binding
pstmt.setString(1, number);
pstmt.setString(2, year);
pstmt.setString(3, month);
pstmt.setString(4, day);
pstmt.setString(5, plan);
int count = pstmt.executeUpdate();
if( count == 0 ){
System.out.println("데이터 입력 실패");
}
else{
System.out.println("데이터 입력 성공");
}
}
catch( ClassNotFoundException e){
System.out.println("드라이버 로딩 실패");
}
catch( SQLException e){
System.out.println("에러 " + e);
}
finally{
try{
if( conn != null && !conn.isClosed()){
  conn.close();
}
if( pstmt != null && !pstmt.isClosed()){
  pstmt.close();
}
}
catch( SQLException e){
e.printStackTrace();
}
}
}
/////
public static String select_work_count(String number) {
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from work where number = "+"'"+number+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }
///////////////
public static String select_project_count() {
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from project";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }
/////////////
public static String select_proceed_count() {
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from project where status = " + "'"+"진행"+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }
public static String select_finish_count() {
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from project where status = " + "'"+"완료"+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }
/////////////
////////////////
public static String select_plan_count(String number, String year, String month, String day) {
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from plan where number = "+"'"+number+"' and year = '"+year+"' and month = '"+month + "' and day = '"+ day + "'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println("오늘의 일정 카운트는? "+ count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }
//////////////////
public static String select_plan_data(String number, String year, String month, String day) {
	Connection conn = null;
	String count = new String("");
	String result = new String("");
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from plan where number = "+"'"+number+"' and year = '"+year+"' and month = '"+month + "' and day = '"+ day + "'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        System.out.println("동작한다~~");
        while(rs.next()){
        	count=rs.getString("plan");
        	result += count+"\n";
        	
        }
        
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return result;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return result;
    }
public static void delete_plan_data(String number, String year, String month, String day) {
	Connection conn = null;
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "delete from plan where number = "+"'"+number+"' and year = '"+year+"' and month = '"+month + "' and day = '"+ day + "'";
        Statement st = conn.createStatement();
        st.executeUpdate(qu);
        System.out.println("Successfully Connection!");
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    }
public static void delete_work_data(String number) {
	Connection conn = null;
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "delete from work where number = "+"'"+number+"'";
        Statement st = conn.createStatement();
        st.executeUpdate(qu);
        System.out.println("Successfully Connection!");
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    }
///////////////////
public static String select_work_data(String number) {
	Connection conn = null;
	String[] count = new String[6];
	count[5]="";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from work where number = "+"'"+number+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        
        while(rs.next()){
        	
        	count[0]=rs.getString("year");
        	count[1]=rs.getString("month");
        	count[2]=rs.getString("day");
        	count[3]=rs.getString("time");
        	count[4]=rs.getString("work");
        	count[5] += count[0] +"년 "+ count[1]+"월 "+count[2]+"일 " + count[3] + " " + count[4]+"\n";
        }
        
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count[5];
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count[5];
    }
//////////////
public static String select_project() {
	Connection conn = null;
	String[] count=new String[8];
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from project";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        count[7]="";
        while(rs.next()){
        	count[0]=rs.getString("projectNum");
        	count[1]=rs.getString("year");
        	count[2]=rs.getString("month");
        	count[3]=rs.getString("day");
        	count[4]=rs.getString("level");
        	count[5]=rs.getString("money");
        	count[6]=rs.getString("status");
        	count[7] += count[0] +"번 "+ count[1]+"년 "+count[2]+"월 " + count[3] + "일 까지 " + count[4] + "level부터 가능 총 프로젝트 금액 :"+count[5] + "원 "+count[6] + "상태"+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count[7];
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count[7];
    }
/////////////
public static String select_proceed() {
	Connection conn = null;
	String[] count=new String[8];
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from project where status = " + "'"+ "진행"+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        count[7]="";
        while(rs.next()){
        	count[0]=rs.getString("projectNum");
        	count[1]=rs.getString("year");
        	count[2]=rs.getString("month");
        	count[3]=rs.getString("day");
        	count[4]=rs.getString("level");
        	count[5]=rs.getString("money");
        	count[6]=rs.getString("status");
        	count[7] += count[0] +"번 "+ count[1]+"년 "+count[2]+"월 " + count[3] + "일 까지 " + count[4] + "level까지 가능 총 프로젝트 금액 :"+count[5] + "원 "+count[6] + "상태"+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count[7];
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count[7];
    }
/////
public static String select_finish() {
	Connection conn = null;
	String[] count=new String[8];
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from project where status = " + "'"+ "완료"+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        count[7]="";
        while(rs.next()){
        	count[0]=rs.getString("projectNum");
        	count[1]=rs.getString("year");
        	count[2]=rs.getString("month");
        	count[3]=rs.getString("day");
        	count[4]=rs.getString("level");
        	count[5]=rs.getString("money");
        	count[6]=rs.getString("status");
        	count[7] += count[0] +"번 "+ count[1]+"년 "+count[2]+"월 " + count[3] + "일 까지 " + count[4] + "level까지 가능 총 프로젝트 금액 :"+count[5] + "원 "+count[6] + "상태"+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count[7];
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count[7];
    }
/////////////
public static String select_project_contents() {
	Connection conn = null;
	String count="";
	String count2="";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from project";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        while(rs.next()){
        	count=rs.getString("contents");
        	count2 += count+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count2;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count2;
    }
////////////////
public static String select_proceed_contents() {
	Connection conn = null;
	String count="";
	String count2="";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from project where status = "+"'"+"진행"+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        while(rs.next()){
        	count=rs.getString("contents");
        	count2 += count+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count2;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count2;
    }
/////////////////
public static String select_finish_contents() {
	Connection conn = null;
	String count="";
	String count2="";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from project where status = "+"'"+"완료"+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        while(rs.next()){
        	count=rs.getString("contents");
        	count2 += count+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count2;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count2;
    }
////////////////////////
public static String select_ad_count() {
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from standard";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }
///////////////////////////////
public static String select_ad() {
	Connection conn = null;
	String[] count=new String[9];
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from standard";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        count[8]="";
        while(rs.next()){
        	count[0]=rs.getString("number");
        	count[1]=rs.getString("name");
        	count[2]=rs.getString("id");
        	count[3]=rs.getString("age");
        	count[4]=rs.getString("gender");
        	count[5]=rs.getString("email");
        	count[6]=rs.getString("phone");
        	count[7]=rs.getString("level");
        	count[8] += "사번 : "+count[0] +" 이름 "+ count[1]+" 아이디 : "+count[2]+" 나이 : " + count[3] + " 성별 : " + count[4] + " 이메일 주소 : "+count[5] + " 핸드폰번호 : "+count[6] + " 레벨 : "+count[7]+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count[8];
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count[8];
    }
///////////////////////////////
public static void alter_level(String number, String level){
Connection conn = null;
PreparedStatement pstmt = null;
try{
// 1. 드라이버 로딩
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. 연결하기
String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
conn = DriverManager.getConnection(url, "root", "root");
String sql = "UPDATE standard set level = "+ "'"+level+"' where number = "+"'"+number+"'";
pstmt = conn.prepareStatement(sql);
// 4. 데이터 binding
int count = pstmt.executeUpdate();
if( count == 0 ){
System.out.println("데이터 입력 실패");
}
else{
System.out.println("데이터 입력 성공");
}
}
catch( ClassNotFoundException e){
System.out.println("드라이버 로딩 실패");
}
catch( SQLException e){
System.out.println("에러 " + e);
}
finally{
try{
if( conn != null && !conn.isClosed()){
  conn.close();
}
if( pstmt != null && !pstmt.isClosed()){
  pstmt.close();
}
}
catch( SQLException e){
e.printStackTrace();
}
}
}
////////////
public static String select_ta_count() {
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from report";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }
//////////////
public static String select_ta() {	//task본문 전체 받아오기(컨텐츠 제외)
	Connection conn = null;
	String[] count=new String[6];
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from report";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        count[5]="";
        while(rs.next()){
        	count[0]=rs.getString("number");
        	count[1]=rs.getString("name");
        	count[2]=rs.getString("what");
        	count[3]=rs.getString("status");
        	count[4]=rs.getString("reportNum");
        	count[5] += "사번 : "+ count[0]+ " 이름 : "+count[1]+" 제출이유 : "+count[2] + " 결재통과 : "+count[3]+" 레포트번호"+count[4]+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count[5];
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count[5];
    }
///////////////
//select_ta_contents
public static String select_ta_contents() {
	Connection conn = null;
	String count="";
	String count2="";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from report";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        while(rs.next()){
        	count=rs.getString("contents1");
        	count2 += count+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count2;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count2;
    }
///////////////////////
public static void alter_report(String number, String reportNum, String what, String contents2){
Connection conn = null;
PreparedStatement pstmt = null;
try{
// 1. 드라이버 로딩
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. 연결하기
String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
conn = DriverManager.getConnection(url, "root", "root");
String sql = "UPDATE report set contents2 = "+ "'"+contents2+"', status = "+"'"+what+"' where number = "+"'"+number+"' and reportNum = "+"'"+reportNum+"'";
pstmt = conn.prepareStatement(sql);
// 4. 데이터 binding
int count = pstmt.executeUpdate();
if( count == 0 ){
System.out.println("데이터 입력 실패");
}
else{
System.out.println("데이터 입력 성공");
}
}
catch( ClassNotFoundException e){
System.out.println("드라이버 로딩 실패");
}
catch( SQLException e){
System.out.println("에러 " + e);
}
finally{
try{
if( conn != null && !conn.isClosed()){
  conn.close();
}
if( pstmt != null && !pstmt.isClosed()){
  pstmt.close();
}
}
catch( SQLException e){
e.printStackTrace();
}
}
}
////////////////////////
public static String select_st_count() {
	Connection conn = null;
	String count = "";
	java.util.Calendar cal = java.util.Calendar.getInstance();
    String today_year = cal.get(Calendar.YEAR)+"";
    String today_month = (cal.get(Calendar.MONTH)+1+"");
    String today_day = cal.get(Calendar.DAY_OF_MONTH)+"";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from work where year = "+"'"+today_year+"' and month = "+"'"+today_month+"' and day = "+"'"+today_day+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }
////////////////
public static String select_st_data() {
	Connection conn = null;
	String count[] = new String[7];
	String result = new String("");
	java.util.Calendar cal = java.util.Calendar.getInstance();
    String today_year = cal.get(Calendar.YEAR)+"";
    String today_month = (cal.get(Calendar.MONTH)+1+"");
    String today_day = cal.get(Calendar.DAY_OF_MONTH)+"";
    count[6]="";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from work where year = "+"'"+today_year+"' and month = "+"'"+today_month+"' and day = "+"'"+today_day+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        while(rs.next()){
        	count[0]=rs.getString("number");
        	count[1]=rs.getString("year");
        	count[2]=rs.getString("month");
        	count[3]=rs.getString("day");
        	count[4]=rs.getString("time");
        	count[5]=rs.getString("work");
        	count[6] += "사번 : "+ count[0] + "  "+count[1]+"년 "+count[2] + "월 "+count[3]+"일 "+count[4]+" "+count[5]+"\n";
        	
        }
        
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count[6];
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count[6];
    }
/////////////////////////
public static void insert_chat(String number, String name){
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
	//1. 드라이버 로딩
	Class.forName("com.mysql.cj.jdbc.Driver");
	//2. 연결하기
	String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
	conn = DriverManager.getConnection(url, "root", "root");
	String sql = "INSERT INTO chatting VALUES (?,?)";
	pstmt = conn.prepareStatement(sql);
	//4. 데이터 binding
	pstmt.setString(1, number);
	pstmt.setString(2, name);
	int count = pstmt.executeUpdate();
	if( count == 0 ){
	System.out.println("데이터 입력 실패");
	}
	else{
	System.out.println("데이터 입력 성공");
	}
	}
	catch( ClassNotFoundException e){
	System.out.println("드라이버 로딩 실패");
	}
	catch( SQLException e){
	System.out.println("에러 " + e);
	}
	finally{
	try{
	if( conn != null && !conn.isClosed()){
	conn.close();
	}
	if( pstmt != null && !pstmt.isClosed()){
	pstmt.close();
	}
	}
	catch( SQLException e){
	e.printStackTrace();
	}
	}
	}

///////////
public static String select_chat_count() {
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from chatting";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }
///////////
public static String select_chat() {
	Connection conn = null;
	String count1="";
	String count2="";
	String count3="";
	
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from chatting";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        while(rs.next()){
        	count1=rs.getString("number");
        	count2=rs.getString("id");
        	count3 += count1+" "+count2+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count3;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count3;
    }
///////////
public static void delete_chat(String number){
Connection conn = null;
PreparedStatement pstmt = null;

try{
// 1. 드라이버 로딩
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. 연결하기
String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
conn = DriverManager.getConnection(url, "root", "root");

String sql = "delete from chatting where number=?";
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, number); // 5. SQL 문장을 실행하고 결과를 리턴 - SQL 문장 실행 후, 변경된 row 수 int type 리턴 
int r = pstmt.executeUpdate();
System.out.println("변경된 row : " + r); }
catch (SQLException e) { System.out.println("[SQL Error : " + e.getMessage() + "]"); } 
catch (ClassNotFoundException e1) { System.out.println("[JDBC Connector Driver 오류 : " + e1.getMessage() + "]"); } 
finally { //사용순서와 반대로 close 함
	if (pstmt != null) { try { pstmt.close(); } 
	catch (SQLException e) { e.printStackTrace(); } }
	if (conn != null) {
		try { conn.close(); } 
		catch (SQLException e) { e.printStackTrace(); } 
		} }
}

/////////////////////
public static void insert_announce(String context){
Connection conn = null;
PreparedStatement pstmt = null;
try{
// 1. 드라이버 로딩
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. 연결하기
String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
conn = DriverManager.getConnection(url, "root", "root");
String sql = "INSERT INTO ac VALUES (?)";
pstmt = conn.prepareStatement(sql);
// 4. 데이터 binding
pstmt.setString(1, context);
int count = pstmt.executeUpdate();
if( count == 0 ){
System.out.println("데이터 입력 실패");
}
else{
System.out.println("데이터 입력 성공");
}
}
catch( ClassNotFoundException e){
System.out.println("드라이버 로딩 실패");
}
catch( SQLException e){
System.out.println("에러 " + e);
}
finally{
try{
if( conn != null && !conn.isClosed()){
  conn.close();
}
if( pstmt != null && !pstmt.isClosed()){
  pstmt.close();
}
}
catch( SQLException e){
e.printStackTrace();
}
}
}
//////////////////////////////////////////////
public static String select_an() {	//task본문 전체 받아오기(컨텐츠 제외)
	Connection conn = null;
	String[] count=new String[2];
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from ac";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        count[1]="";
        while(rs.next()){
        	count[0]=rs.getString("context");
        	count[1] +=count[0]+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count[1];
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count[1];
    }
///////////////////////////////////////////////
public static String select_ac_count() {
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from ac";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }
////////////////////////////////////////////////
public static String select_money_count() {
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from project where status = '"+"완료"+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }
///////////////////////////////////////////////

public static String select_money() {	//task본문 전체 받아오기(컨텐츠 제외)
	Connection conn = null;
	String[] count=new String[2];
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from project where status = '"+"완료"+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        count[1]="";
        while(rs.next()){
        	count[0]=rs.getString("money");
        	count[1] +=count[0]+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count[1];
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count[1];
    }
///////////////////////////////////////////////
public static String select_money2() {	//task본문 전체 받아오기(컨텐츠 제외)
	Connection conn = null;
	String[] count=new String[2];
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from project where status = '"+"완료"+"' or status = '"+"진행"+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        count[1]="";
        while(rs.next()){
        	count[0]=rs.getString("money");
        	count[1] +=count[0]+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count[1];
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count[1];
    }
//////////////////////////////////////////////

public static String select_money_count2() {
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from project where status = '"+"완료"+"' or status = '"+"진행"+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }

/////////////////////////////////////////////
public static String select_block_count() { // 미진행 카운트
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from block where status = '"+"미진행" + "'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }

///////////////////////////////////////////
public static String select_block() {	//task본문 전체 받아오기(컨텐츠 제외)
	Connection conn = null;
	String[] count=new String[6];
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from block where status = '"+"미진행"+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        count[5]="";
        while(rs.next()){
        	count[0]=rs.getString("projectNum");
        	count[1]=rs.getString("blockNum");
        	count[2]=rs.getString("money");
        	count[3]=rs.getString("status");
        	count[4]=rs.getString("level");
        	count[5] += "프로젝트번호 : " + count[0]+" 블록번호 : "+ count[1] + " 들어올 돈 : " + count[2] + " 진행상태 : " + count[3] + " 제한레벨 : "+count[4]+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count[5];
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count[5];
    }
/////////////////////////////////////////////
public static String select_block_contents() {	//task본문 전체 받아오기(컨텐츠 제외)
	Connection conn = null;
	String[] count=new String[2];
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from block where status = '"+"미진행"+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        count[1]="";
        while(rs.next()){
        	count[0]=rs.getString("contents");
        	count[1] +=count[0]+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count[1];
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count[1];
    }

////////////////////////////////////////////
public static void alter_block(String projectNum, String blockNum, String id){
Connection conn = null;
PreparedStatement pstmt = null;
try{
// 1. 드라이버 로딩
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. 연결하기
String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
conn = DriverManager.getConnection(url, "root", "root");
String sql = "UPDATE block set id = "+ "'"+id+"', status = '진행' where projectNum = "+"'"+projectNum+"' and blockNum = "+"'"+blockNum+"'";
pstmt = conn.prepareStatement(sql);
// 4. 데이터 binding
int count = pstmt.executeUpdate();
if( count == 0 ){
System.out.println("데이터 입력 실패");
}
else{
System.out.println("데이터 입력 성공");
}
}
catch( ClassNotFoundException e){
System.out.println("드라이버 로딩 실패");
}
catch( SQLException e){
System.out.println("에러 " + e);
}
finally{
try{
if( conn != null && !conn.isClosed()){
  conn.close();
}
if( pstmt != null && !pstmt.isClosed()){
  pstmt.close();
}
}
catch( SQLException e){
e.printStackTrace();
}
}
}
/////////////////////////////////////////////
public static String select_block_level(String projectNum, String blockNum) { // 미진행 카운트
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select level from block where projectNum = '"+projectNum + "' and blockNum = '"+blockNum+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        
        while(rs.next()){
        	count=rs.getString("level");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }
//////////////////////////////////////////////
public static String select_block_count2(String id) { // 미진행 카운트
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from block where id = '"+ id + "' and status = '진행'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }

///////////////////////////////////////////
public static String select_block2(String id) {	//task본문 전체 받아오기(컨텐츠 제외)
	Connection conn = null;
	String[] count=new String[6];
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from block where id = '"+id+"' and status = '진행'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        count[5]="";
        while(rs.next()){
        	count[0]=rs.getString("projectNum");
        	count[1]=rs.getString("blockNum");
        	count[2]=rs.getString("money");
        	count[3]=rs.getString("status");
        	count[4]=rs.getString("level");
        	count[5] += "프로젝트번호 : " + count[0]+" 블록번호 : "+ count[1] + " 들어올 돈 : " + count[2] + " 진행상태 : " + count[3] + " 제한레벨 : "+count[4]+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count[5];
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count[5];
    }
/////////////////////////////////////////////
public static String select_block_contents2(String id) {	//task본문 전체 받아오기(컨텐츠 제외)
	Connection conn = null;
	String[] count=new String[2];
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from block where id = '"+id+"' and status = '진행'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        count[1]="";
        while(rs.next()){
        	count[0]=rs.getString("contents");
        	count[1] +=count[0]+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count[1];
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count[1];
    }

/////////////////////////////////////////////
public static void delete_block(String a, String b, String id) {
	Connection conn = null;
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "delete from block where projectNum = "+"'"+a+"' and blockNum = '"+b+"' and id = '"+id+"'";
        Statement st = conn.createStatement();
        st.executeUpdate(qu);
        System.out.println("Successfully Connection!");
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    }

//////////////////////////////////////////
public static void alter_block_(String a, String b, String c){
Connection conn = null;
PreparedStatement pstmt = null;
try{
// 1. 드라이버 로딩
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. 연결하기
String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
conn = DriverManager.getConnection(url, "root", "root");
String sql = "UPDATE block set status = '미진행', id = 'x' where projectNum = "+"'"+a+"' and blockNum = '"+b+"' and id = '"+c+"'";
pstmt = conn.prepareStatement(sql);
// 4. 데이터 binding
int count = pstmt.executeUpdate();
if( count == 0 ){
System.out.println("데이터 입력 실패");
}
else{
System.out.println("데이터 입력 성공");
}
}
catch( ClassNotFoundException e){
System.out.println("드라이버 로딩 실패");
}
catch( SQLException e){
System.out.println("에러 " + e);
}
finally{
try{
if( conn != null && !conn.isClosed()){
  conn.close();
}
if( pstmt != null && !pstmt.isClosed()){
  pstmt.close();
}
}
catch( SQLException e){
e.printStackTrace();
}
}
}
//////////////////////////////////
public static void alter_block_complete(String a, String b, String c){
Connection conn = null;
PreparedStatement pstmt = null;
try{
// 1. 드라이버 로딩
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. 연결하기
String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
conn = DriverManager.getConnection(url, "root", "root");
String sql = "UPDATE block set status = '완료' where projectNum = "+"'"+a+"' and blockNum = '"+b+"' and id = '"+c+"'";
pstmt = conn.prepareStatement(sql);
// 4. 데이터 binding
int count = pstmt.executeUpdate();
if( count == 0 ){
System.out.println("데이터 입력 실패");
}
else{
System.out.println("데이터 입력 성공");
}
}
catch( ClassNotFoundException e){
System.out.println("드라이버 로딩 실패");
}
catch( SQLException e){
System.out.println("에러 " + e);
}
finally{
try{
if( conn != null && !conn.isClosed()){
  conn.close();
}
if( pstmt != null && !pstmt.isClosed()){
  pstmt.close();
}
}
catch( SQLException e){
e.printStackTrace();
}
}
}
//////////////////////////////////
public static void insert_report(String number, String reportNum, String what, String contents1,String name){
Connection conn = null;
PreparedStatement pstmt = null;
try{
// 1. 드라이버 로딩
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. 연결하기
String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
conn = DriverManager.getConnection(url, "root", "root");
String sql = "INSERT INTO report VALUES (?,?,?,?,?,?,?)";
pstmt = conn.prepareStatement(sql);
// 4. 데이터 binding
pstmt.setString(1, number);
pstmt.setString(2, name);
pstmt.setString(3, what);
pstmt.setString(4, "X");
pstmt.setString(5, contents1);
pstmt.setString(6, "아직 피드백이 없습니다.");
pstmt.setString(7, reportNum);
int count = pstmt.executeUpdate();
if( count == 0 ){
System.out.println("데이터 입력 실패");
}
else{
System.out.println("데이터 입력 성공");
}
}
catch( ClassNotFoundException e){
System.out.println("드라이버 로딩 실패");
}
catch( SQLException e){
System.out.println("에러 " + e);
}
finally{
try{
if( conn != null && !conn.isClosed()){
  conn.close();
}
if( pstmt != null && !pstmt.isClosed()){
  pstmt.close();
}
}
catch( SQLException e){
e.printStackTrace();
}
}
}
//////////////////////////////////
public static String select_login2(String id_login) {//이름 가져오기
	Connection conn = null;
	String name = "";
	//String pw_login_temp = null ;
	//pw_login_temp = new String(pw_login);
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select name from standard where id = "+"'"+id_login+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        
        while(rs.next()){
        	name = rs.getString("name");
        }
        System.out.println("Successfully Connection!");
        return name;
        //if(id_login == id && pw_login_temp == password) {
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }

    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
	return name;
    }

//////////////////////////////////
public static String select_login3(String id_login) {//이름 가져오기
	Connection conn = null;
	String number = "";
	//String pw_login_temp = null ;
	//pw_login_temp = new String(pw_login);
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select number from standard where id = "+"'"+id_login+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        
        while(rs.next()){
        	number = rs.getString("number");
        }
        System.out.println("Successfully Connection!");
        return number;
        //if(id_login == id && pw_login_temp == password) {
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }

    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
	return number;
    }
//////////////////////////////////
public static String select_ta_count2(String number) {
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from report where number = '"+number+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }
//////////////
public static String select_ta2(String number) {	//task본문 전체 받아오기(컨텐츠 제외)
	Connection conn = null;
	String[] count=new String[6];
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from report where number = '"+number+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        count[5]="";
        while(rs.next()){
        	count[0]=rs.getString("number");
        	count[1]=rs.getString("name");
        	count[2]=rs.getString("what");
        	count[3]=rs.getString("status");
        	count[4]=rs.getString("reportNum");
        	count[5] += "사번 : "+ count[0]+ " 이름 : "+count[1]+" 제출이유 : "+count[2] + " 결재통과 : "+count[3]+" 레포트번호"+count[4]+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count[5];
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count[5];
    }
///////////////
//select_ta_contents
public static String select_ta_contents2(String number) {
	Connection conn = null;
	String count="";
	String count2="";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from report where number = '"+number+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        while(rs.next()){
        	count=rs.getString("contents1");
        	count2 += count+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count2;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count2;
    }
///////////////////////////////////
public static String select_ta_contents3(String number) {
	Connection conn = null;
	String count="";
	String count2="";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from report where number = '"+number+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        while(rs.next()){
        	count=rs.getString("contents2");
        	count2 += count+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count2;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count2;
    }
///////////////////////////
public static String block_count(String projectNum, String blockNum) {
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from block where projectNum = "+"'"+projectNum+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }
///////////////////////////
public static String block_count2(String projectNum, String blockNum) {
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from block where projectNum = "+"'"+projectNum+"' and status = '진행' or status = '완료'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }
//////////////////////////
public static void alter_project_status(String projectNum){
Connection conn = null;
PreparedStatement pstmt = null;
try{
// 1. 드라이버 로딩
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. 연결하기
String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
conn = DriverManager.getConnection(url, "root", "root");
String sql = "UPDATE project set status = '진행' where projectNum = "+"'"+projectNum+"'";
pstmt = conn.prepareStatement(sql);
// 4. 데이터 binding
int count = pstmt.executeUpdate();
if( count == 0 ){
System.out.println("데이터 입력 실패");
}
else{
System.out.println("데이터 입력 성공");
}
}
catch( ClassNotFoundException e){
System.out.println("드라이버 로딩 실패");
}
catch( SQLException e){
System.out.println("에러 " + e);
}
finally{
try{
if( conn != null && !conn.isClosed()){
  conn.close();
}
if( pstmt != null && !pstmt.isClosed()){
  pstmt.close();
}
}
catch( SQLException e){
e.printStackTrace();
}
}
}
///////////////////
public static void alter_project_status2(String projectNum){
Connection conn = null;
PreparedStatement pstmt = null;
try{
// 1. 드라이버 로딩
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. 연결하기
String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
conn = DriverManager.getConnection(url, "root", "root");
String sql = "UPDATE project set status = '미진행' where projectNum = "+"'"+projectNum+"'";
pstmt = conn.prepareStatement(sql);
// 4. 데이터 binding
int count = pstmt.executeUpdate();
if( count == 0 ){
System.out.println("데이터 입력 실패");
}
else{
System.out.println("데이터 입력 성공");
}
}
catch( ClassNotFoundException e){
System.out.println("드라이버 로딩 실패");
}
catch( SQLException e){
System.out.println("에러 " + e);
}
finally{
try{
if( conn != null && !conn.isClosed()){
  conn.close();
}
if( pstmt != null && !pstmt.isClosed()){
  pstmt.close();
}
}
catch( SQLException e){
e.printStackTrace();
}
}
}
///////////////
public static void alter_block_status(String projectNum,String blockNum){
Connection conn = null;
PreparedStatement pstmt = null;
try{
// 1. 드라이버 로딩
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. 연결하기
String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
conn = DriverManager.getConnection(url, "root", "root");
String sql = "UPDATE project set status = '미진행' where projectNum = "+"'"+projectNum+"' and blockNum = '"+blockNum+"'";
pstmt = conn.prepareStatement(sql);
// 4. 데이터 binding
int count = pstmt.executeUpdate();
if( count == 0 ){
System.out.println("데이터 입력 실패");
}
else{
System.out.println("데이터 입력 성공");
}
}
catch( ClassNotFoundException e){
System.out.println("드라이버 로딩 실패");
}
catch( SQLException e){
System.out.println("에러 " + e);
}
finally{
try{
if( conn != null && !conn.isClosed()){
  conn.close();
}
if( pstmt != null && !pstmt.isClosed()){
  pstmt.close();
}
}
catch( SQLException e){
e.printStackTrace();
}
}
}
//////////////////////////
public static String block_count3(String projectNum, String blockNum) {
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from block where projectNum = "+"'"+projectNum+"' and status = '완료'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }
/////////////////////////////
public static void alter_project_status3(String projectNum){
Connection conn = null;
PreparedStatement pstmt = null;
try{
// 1. 드라이버 로딩
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. 연결하기
String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
conn = DriverManager.getConnection(url, "root", "root");
String sql = "UPDATE project set status = '완료' where projectNum = "+"'"+projectNum+"'";
pstmt = conn.prepareStatement(sql);
// 4. 데이터 binding
int count = pstmt.executeUpdate();
if( count == 0 ){
System.out.println("데이터 입력 실패");
}
else{
System.out.println("데이터 입력 성공");
}
}
catch( ClassNotFoundException e){
System.out.println("드라이버 로딩 실패");
}
catch( SQLException e){
System.out.println("에러 " + e);
}
finally{
try{
if( conn != null && !conn.isClosed()){
  conn.close();
}
if( pstmt != null && !pstmt.isClosed()){
  pstmt.close();
}
}
catch( SQLException e){
e.printStackTrace();
}
}
}
//////////////////////////
public static String select_money_count3(String id) {
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from block where status = '"+"완료"+"' and id = '"+id+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }

///////////////////////////
public static String select_money3(String id) {	//task본문 전체 받아오기(컨텐츠 제외)
	Connection conn = null;
	String[] count=new String[2];
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from block where status = '"+"완료"+"' and id = '"+id+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        count[1]="";
        while(rs.next()){
        	count[0]=rs.getString("money");
        	count[1] +=count[0]+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count[1];
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count[1];
    }
//////////////////////////

public static String select_money_count4(String id) {
	Connection conn = null;
	String count = "";
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select count(*) from block where status = '"+"완료"+"' or status = '"+"진행"+"' and id = '"+id+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        
        while(rs.next()){
        	count=rs.getString("count(*)");
        }
        System.out.println(count);
        System.out.println("Successfully Connection!");
		return count;
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count;
    }
//////////////////////////
public static String select_money4(String id) {	//task본문 전체 받아오기(컨텐츠 제외)
	Connection conn = null;
	String[] count=new String[2];
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from block where status = '"+"완료"+"' or status = '"+"진행"+"' and id = '"+id+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        count[1]="";
        while(rs.next()){
        	count[0]=rs.getString("money");
        	count[1] +=count[0]+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count[1];
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count[1];
    }
//////////////////////////
public static String select_money5(String id) {	//task본문 전체 받아오기(컨텐츠 제외)
	Connection conn = null;
	String[] count=new String[7];
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from block where status = '"+"완료"+"' and id = '"+id+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        count[6]="";
        while(rs.next()){
        	count[0]=rs.getString("projectNum");
        	count[1]=rs.getString("blockNum");
        	count[2]=rs.getString("contents");
        	count[3]=rs.getString("level");
        	count[4]=rs.getString("id");
        	count[5]=rs.getString("status");
        	count[6] +="프로젝트 번호 : " + count[0]+" 블록번호 : "+count[1] +" 제한레벨 "+count[3]+" 아이디 : "+count[4]+" 상태 : "+count[5]+ " <br>블록 내용<br>"+count[2]+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count[6];
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count[6];
    }
///////////////////////////
public static String select_money6(String id) {	//task본문 전체 받아오기(컨텐츠 제외)
	Connection conn = null;
	String[] count=new String[7];
    try{
        //1. 드라이버 로딩 : mysql 드라이버 로딩
       Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost/standard_db?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, "root", "root");
        String qu  = "select * from block where status = '"+"완료"+"' or status = '"+"진행"+"' and id = '"+id+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qu);
        count[6]="";
        while(rs.next()){
        	count[0]=rs.getString("projectNum");
        	count[1]=rs.getString("blockNum");
        	count[2]=rs.getString("contents");
        	count[3]=rs.getString("level");
        	count[4]=rs.getString("id");
        	count[5]=rs.getString("status");
        	count[6] +="프로젝트 번호 : " + count[0]+" 블록번호 : "+count[1] +" 제한레벨 "+count[3]+" 아이디 : "+count[4]+" 상태 : "+count[5]+ " <br>내용 : "+count[2]+"\n";
        }
        //count[5]=rs.getString("contents");
        //System.out.println(count[5]);
        System.out.println("Successfully Connection!");
		return count[6];
    }
    catch(ClassNotFoundException e){
        System.out.println("Failed because of not loading driver");
    }
    catch(SQLException e){
        System.out.println("error : " + e);
    }
    finally{
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
	return count[6];
    }
//////////////////////////
}