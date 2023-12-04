import java.util.*;
import java.sql.*;

public class Insert{
	public void excute() {
	
		try{ 
			Scanner sc = new Scanner(System.in);
			System.out.print("원하는 쿼리를 입력하세요: ");
			String pstmt =sc.nextLine(); //String형 입력 및 반환 (개행을 기준으로 한 줄을 읽음)

			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://192.168.56.101:4567/centerDB",
			"seongmin","minminseong!!"); 
			
			//사용자로부터 입력받기
			Statement stmt=con.createStatement(); 
			
			int rs=stmt.executeUpdate(pstmt); 
			
		
			PreparedStatement pstm = null;
			
			try {
				if(rs>0) {
					System.out.println("입력 성공");
					
				}else {
					System.out.println("완전한 삽입문이 아닙니다.");
				}
			}catch (Exception e) {
                System.out.println(e);
            } finally {
            	if (pstm != null) {
                    pstm.close();
                }
                
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println();
			System.out.print("사유 : " + e.getMessage());
        }
    }
}
