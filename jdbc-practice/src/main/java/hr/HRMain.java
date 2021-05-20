package hr;

import java.util.List;
import java.util.Scanner;

public class HRMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름>");
		String name = sc.nextLine();
		
		EmployeesDao dao = new EmployeesDao();
		List<EmployeeVo> list = dao.findbyName(name);
		for(EmployeeVo vo : list) {
			System.out.println(vo);
		}
		
		sc.close();
	}

}
