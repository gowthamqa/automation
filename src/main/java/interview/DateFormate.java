package interview;

public class DateFormate {
	
	public static void main(String[] args) {
		String date = "2019-09-09T04:00:00Z";
		System.out.println(convertDate(date));
	}
	
	public static String convertDate(String date) {
		return date.substring(0,4)+date.substring(5, 7)+date.substring(8, 10);
	}

}
