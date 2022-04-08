package exam2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {

	public static void main(String[] args) {
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		Scanner sc = new Scanner(System.in);
		
		String answer;
		String name;
		String phone;
		String address;
		
		do {
			System.out.print("회원가입을 진행하시겠습니까? (Y/N)");
			answer = sc.next();
			
			if (answer.equalsIgnoreCase("n")) {
				break;
			} else if (answer.equalsIgnoreCase("y")) {
				System.out.print("이름 : ");
				name = sc.next();
				
				System.out.print("전화번호 : ");
				phone = sc.next();
				sc.nextLine();
				
				System.out.print("주소 : ");
				address = sc.nextLine();
				
				customers.add(new Customer(name, phone, address));
			}
			
		} while (true);
		
		sc.close();
		
		OutputStream os = null;
		
		try {
			
			os = new FileOutputStream("src/exam2/customer.txt");
			
			if (customers.isEmpty()) {
				System.out.println("회원가입 정보가 없습니다.");
			} else {
				for (Customer c : customers) {
					System.out.print(c);
					os.write(c.toString().getBytes());
				}
				
				String msg = "\t . . . . .";
				System.out.println(msg);
				os.write(msg.getBytes());
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				
				if (os != null) {
					os.close();
				}
			} catch (IOException ignore) {
				System.out.println(ignore.getMessage());
			}
		}
	}
}
