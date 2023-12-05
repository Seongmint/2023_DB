import java.util.*;
import java.sql.*;
public class Insert_program{
	public void excute() {
	
		try{ 
			Scanner sc =new Scanner(System.in);			
			System.out.println("bookid 입력 : ");
			String bookid = sc.next();
			System.out.println("bookname 입력 : ");
			String deptno = sc.next();
			System.out.println("출판사 이름 입력:");
			String dname = sc.next();
			System.out.println("책 가격 입력:");
			String loc = sc.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://192.168.56.101:4567/centerDB",
			"seongmin","minminseong!!"); 
			
			
			String sql ="INSERT INTO program VALUES (?,?,?,?,?,?)";
			
			PreparedStatement pstm =null;
			
			try {
				pstm = con.prepareStatement(sql);
				pstm.setString(1,bookid);
				pstm.setString(2,deptno);
				pstm.setString(3,dname);
				pstm.setString(4,loc);
				
				int res = pstm.executeUpdate(); //sql문이 수행되었는지 실패했는지 확인하기 위한 변수, res이다. 
				if(res>0) {
					System.out.println("입력 성공");
					
				}else {
					System.out.println("입력 실패");
				}
			}catch (Exception e) {
                System.out.println(e);
            } finally {
            	if (pstm !=null) {
                    pstm.close();
                }
                
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
