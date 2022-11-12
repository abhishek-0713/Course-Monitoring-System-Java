package Main;

import java.util.Scanner;

import com.learninghub.adminnistrator.AdminLogin;
import com.learninghub.extrafeatures.Style;
import com.learninghub.main.facultyrights.FacultyLogin;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println(Style.DARK_RED_BACKGROUND+" Course Monitoring System"+" "+Style.RESET);
		System.out.println();

		Scanner sc = new Scanner(System.in);
			
		while(true) {
				
			System.out.println(Style.CYAN+"1. Admin Login");
			System.out.println("2. Faculty Login");
			System.out.println("3. Close"+Style.RESET);
				
			String ch = sc.next();
				
			if(ch.equals("1")) {			
				AdminLogin.LoginAdmin();
					
			}else if(ch.equals("2")) {		
				FacultyLogin.login();
				
			}else if(ch.equals("3")) {
				System.out.println();
				System.out.println(Style.GREEN_BOLD_BRIGHT+"See You Soon..."+Style.RESET);
				break;
					
			}else {
				System.out.println();
				System.out.println(Style.RED+"Wrong Input Try Again!"+Style.RESET);
				System.out.println();
				
			}
			
		}
		sc.close();
		
	}
	
}
