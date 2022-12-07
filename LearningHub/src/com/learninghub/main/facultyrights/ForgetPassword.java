package com.learninghub.main.facultyrights;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.learninghub.dao.FacultyRightsDao;
import com.learninghub.dao.FacultyRightsDaoImpl;
import com.learninghub.exceptions.FacultyRightsException;
import com.learninghub.extrafeatures.Style;
import com.learninghub.utility.DBUtil;

public class ForgetPassword {
	
	public static boolean forgetPass() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		try(Connection conn = DBUtil.provideConnection()){
			
			System.out.print(Style.BLUE_BOLD_BRIGHT+"Enter Mobile    : "+Style.RESET);
			String mobile = sc.next();
			
			System.out.print(Style.BLUE_BOLD_BRIGHT+"Enter Email     : "+Style.RESET);
			String email = sc.next();
			
			
			
			PreparedStatement ps = conn .prepareStatement("select * from faculty where mobile = ? and email = ?");
			ps.setString(1, mobile);
			ps.setString(2, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				FacultyRightsDao dao = new FacultyRightsDaoImpl();
					
				System.out.print(Style.RED_BOLD_BRIGHT+"Enter New Password    : "+Style.RESET);
				String newPass = sc.next();
				
				
				System.out.print(Style.RED_BOLD_BRIGHT+"Enter New Password Again   : "+Style.RESET);
				String newPass2 = sc.next();
				

				if(newPass.equals(newPass2)) {
					
					
					try {
						String res = dao.forgetPassword(mobile, email, newPass2);
						System.out.println("\n" + res + "\n");
						
					} catch (FacultyRightsException e) {
						System.out.println("\n           " + Style.RED_BACKGROUND+e.getMessage() + "          \n" + Style.RESET);
						return false;
					}
					
				}else {
					System.out.println(Style.RED_BOLD_BRIGHT+" Check Both Passwords & Try Again"+Style.RESET);
					return false;
				}
				
				
			}else {
				System.out.println(Style.RED_BOLD_BRIGHT+"\n           Mobile Number / Email Not Found             \n"+Style.RESET);
				return false;
				
			}
			
		} catch (SQLException e) {
			System.out.println("\n           " + Style.RED_BACKGROUND+e.getMessage() + "          \n" + Style.RESET);
			return false;
			
		}
		return true;
		
	}
	
}
