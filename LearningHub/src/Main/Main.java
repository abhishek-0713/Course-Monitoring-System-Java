package Main;

import java.util.Scanner;

import com.learninghub.adminnistrator.AdminLogin;
import com.learninghub.extrafeatures.Style;
import com.learninghub.main.facultyrights.FacultyLogin;

public class Main {
	
	public static void main(String[] args) {
		
//		System.out.println(Style.ORANGE_BACKGROUND+"\n    Learning Hub - Course Monitoring System    "+"      "+Style.RESET);
//		System.out.println(Style.RED_BOLD_BRIGHT +"\r\n"
//				+ "██╗░░░░░███████╗░█████╗░██████╗░███╗░░██╗██╗███╗░░██╗░██████╗░  ██╗░░██╗██╗░░░██╗██████╗░\r\n"
//				+ "██║░░░░░██╔════╝██╔══██╗██╔══██╗████╗░██║██║████╗░██║██╔════╝░  ██║░░██║██║░░░██║██╔══██╗\r\n"
//				+ "██║░░░░░█████╗░░███████║██████╔╝██╔██╗██║██║██╔██╗██║██║░░██╗░  ███████║██║░░░██║██████╦╝\r\n"
//				+ "██║░░░░░██╔══╝░░██╔══██║██╔══██╗██║╚████║██║██║╚████║██║░░╚██╗  ██╔══██║██║░░░██║██╔══██╗\r\n"
//				+ "███████╗███████╗██║░░██║██║░░██║██║░╚███║██║██║░╚███║╚██████╔╝  ██║░░██║╚██████╔╝██████╦╝\r\n"
//				+ "╚══════╝╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚══╝╚═╝╚═╝░░╚══╝░╚═════╝░  ╚═╝░░╚═╝░╚═════╝░╚═════╝░");

		
		System.out.println(Style.RED_BOLD_BRIGHT + "\r\n"
				+ "    __                                   _                             __  __            __  \r\n"
				+ "   / /   ___   ____ _   _____   ____    (_)   ____    ____ _          / / / /  __  __   / /_ \r\n"
				+ "  / /   / _ \\ / __ `/  / ___/  / __ \\  / /   / __ \\  / __ `/         / /_/ /  / / / /  / __ \\\r\n"
				+ " / /___/  __// /_/ /  / /     / / / / / /   / / / / / /_/ /         / __  /  / /_/ /  / /_/ /\r\n"
				+ "/_____/\\___/ \\__,_/  /_/     /_/ /_/ /_/   /_/ /_/  \\__, /         /_/ /_/   \\__,_/  /_.___/ \r\n"
				+ "                                                   /____/                                    \r\n"
				+ "" +Style.RESET );
		
		System.out.println(Style.CYAN+"\r\n"
				+ "   ______                              __  ___            _ __             _                _____            __               \r\n"
				+ "  / ____/___  __  _______________     /  |/  /___  ____  (_) /_____  _____(_)___  ____ _   / ___/__  _______/ /____  ____ ___ \r\n"
				+ " / /   / __ \\/ / / / ___/ ___/ _ \\   / /|_/ / __ \\/ __ \\/ / __/ __ \\/ ___/ / __ \\/ __ `/   \\__ \\/ / / / ___/ __/ _ \\/ __ `__ \\\r\n"
				+ "/ /___/ /_/ / /_/ / /  (__  )  __/  / /  / / /_/ / / / / / /_/ /_/ / /  / / / / / /_/ /   ___/ / /_/ (__  ) /_/  __/ / / / / /\r\n"
				+ "\\____/\\____/\\__,_/_/  /____/\\___/  /_/  /_/\\____/_/ /_/_/\\__/\\____/_/  /_/_/ /_/\\__, /   /____/\\__, /____/\\__/\\___/_/ /_/ /_/ \r\n"
				+ "                                                                               /____/         /____/                          \r\n"
				+ "" + Style.RESET);
		
		
		Scanner sc = new Scanner(System.in);
			
		while(true) {
			System.out.println(Style.TEAL+"+--------------------------------------------------+");
			System.out.println("|   1    |      Admin Login                        |");
			System.out.println("|--------------------------------------------------|");

			System.out.println("|   2    |      Faculty Login                      |");
			System.out.println("|--------------------------------------------------|");

			System.out.println("|   3    |      Exit                               |");
			System.out.println("+--------------------------------------------------+\n"+Style.RESET);

			
			System.out.print(Style.GREEN_BOLD_BRIGHT+"Enter Your Choise : ");	
			String ch = sc.next();
				
			if(ch.equals("1")) {			
				AdminLogin.LoginAdmin();
					
			}else if(ch.equals("2")) {		
				FacultyLogin.login();
				
			}else if(ch.equals("3")) {
				System.out.println(Style.GREEN_BACKGROUND_BRIGHT+"\n                   Come Back Again.                   "+Style.RESET);
				break;
					
			}else {
				System.out.println(Style.RED_UNDERLINED+"\n               Invalid Input Try Again!               \n"+Style.RESET);	
			}
			
		}
		sc.close();
		
	}
	
}
