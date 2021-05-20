package hr;

import java.util.List;
import java.util.Scanner;

public class HRMain2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Salary[min max]>");
		int minSalary = sc.nextInt();
		int maxSalary = sc.nextInt();
		
		System.out.println(minSalary + ":" + maxSalary);
		
		EmployeesDao dao = new EmployeesDao();
		List<EmployeeVo> list = dao.findbySalary(minSalary, maxSalary);
		for(EmployeeVo vo : list) {
			System.out.println(vo);
		}
		
		sc.close();
	}
}
