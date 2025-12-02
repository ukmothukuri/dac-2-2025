package in.com.entity;

public class Test {
	
	public static void main(String[] args) {
		
		Student std = new Student();
		std.setName("Rahul");
		std.setCourse("DAC");
		std.setBranch("CSE");
		std.setYearofPassing(2025);

		
		DBoperations dbops = new DBoperations();
		dbops.insertStudentDetails(std);
	}
}
