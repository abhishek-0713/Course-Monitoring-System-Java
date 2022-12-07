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

public class UpdatePassword {
	
	public static void chnagePass(int facultyId) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		try(Connection conn = DBUtil.provideConnection()){
			
			System.out.print(Style.BLUE_BOLD_BRIGHT+"Enter Old Password     : "+Style.RESET);
			String oldPass = sc.next();
			
			System.out.print(Style.BLUE_BOLD_BRIGHT+"Enter New Password     : "+Style.RESET);
			String newPass = sc.next();
			
			System.out.print(Style.BLUE_BOLD_BRIGHT+"Enter New Password     : "+Style.RESET);
			String newPass2 = sc.next();
			
			
			PreparedStatement ps = conn .prepareStatement("select * from faculty where facultyId = ? And password = ?");
			ps.setInt(1, facultyId);
			ps.setString(2, oldPass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				if(newPass.equals(newPass2)) {
					
					FacultyRightsDao dao = new FacultyRightsDaoImpl();
					
					try {
						String res = dao.changePassword(facultyId, newPass2);
						System.out.println("\n" + res + "\n");
					} 
					catch (FacultyRightsException e) {
						System.out.println("\n           " + Style.RED_BACKGROUND+e.getMessage() + "          \n" + Style.RESET);
					}
					
				}else {
					System.out.println(Style.RED_BOLD_BRIGHT+" Check Both Passwords & Try Again"+Style.RESET);
				}
				
			}else {
				System.out.println(Style.BLACK_BOLD_BRIGHT+"         Check Old Password & Try Again          "+Style.RESET);				
			}
			
		} catch (SQLException e) {
			System.out.println("\n           " + Style.RED_BACKGROUND+e.getMessage() + "          \n" + Style.RESET);
		}
		
	}
	
}
