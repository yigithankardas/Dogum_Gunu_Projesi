package dates;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class AbstractCalendar {
	
	private static final String OCAK = "Ocak";
	private static final String SUBAT = "Þubat";
	private static final String MART = "Mart";
	private static final String NISAN = "Nisan";
	private static final String MAYIS = "Mayýs";
	private static final String HAZIRAN = "Haziran";
	private static final String TEMMUZ = "Temmuz";
	private static final String AGUSTOS = "Aðustos";
	private static final String EYLUL = "Eylül";
	private static final String EKIM = "Ekim";
	private static final String KASIM = "Kasým";
	private static final String ARALIK = "Aralýk";
	private static final String[] monthArray = {OCAK, SUBAT, MART, NISAN, MAYIS, HAZIRAN, TEMMUZ, AGUSTOS, EYLUL, EKIM, KASIM, ARALIK};
	
	
	public static int compare(String date1, String date2) {
		int data1 = correspondingInt(date1);
		int data2 = correspondingInt(date2);
		if (data1 > data2)
			return 1;
		else if (data1 < data2)
			return -1;
		else
			return 0;
	}
	
	
	private static int correspondingInt(String date) {
		int spaceIndex = date.indexOf(" ");
		String month = date.substring(spaceIndex + 1);
		int day = Integer.parseInt(date.substring(0, spaceIndex));
		int length = month.length();
		char first = month.charAt(0);
		if (length == 4) {
			if (first == 'O')
				return day;
			else if (first == 'M')
				return day + 62;
			else
				return day + 279;
		}
		else if (length == 5) {
			if (first == 'Þ')
				return day + 31;
			else if (first == 'N')
				return day + 93;
			else if (first == 'M')
				return day + 124;
			else if (first == 'E')
				return day + 248;
			else
				return day + 310;
		}
		else if (length == 6) {
			if (first == 'T')
				return day + 186;
			else
				return day + 341;
		}
		else {
			if (first == 'H')
				return day + 155;
			else
				return day + 217;
		}
	}
	
	
	public static String findDate(String line) {
		int spaceIndex = line.indexOf(" ");
		String day = line.substring(0, spaceIndex);
		line = line.substring(spaceIndex + 1);
		String month = line.substring(0, line.indexOf(" "));
		return day + " " + month;
	}
	
	
	public static String findName(String line) {
		int arrowIndex = line.indexOf("==> ");
		String name = line.substring(arrowIndex + 4);
		return name;
	}
	
	
	public static String getCurrentDate() {
		return DateTimeFormatter.ofPattern("dd/MM").format(LocalDateTime.now());
	}
	
	
	public static String arrangeDate(String date) {
		int index = date.indexOf("/");
		String day = date.substring(0, index);
		String month = date.substring(index + 1);
		if (month.equals("01")) {
			return day + " " + OCAK;
		}
		else if (month.equals("02")) {
			return day + " " + SUBAT;
		}
		else if (month.equals("03")) {
			return day + " " + MART;
		}
		else if (month.equals("04")) {
			return day + " " + NISAN;
		}
		else if (month.equals("05")) {
			return day + " " + MAYIS;
		}
		else if (month.equals("06")) {
			return day + " " + HAZIRAN;
		}
		else if (month.equals("07")) {
			return day + " " + TEMMUZ;
		}
		else if (month.equals("08")) {
			return day + " " + AGUSTOS;
		}
		else if (month.equals("09")) {
			return day + " " + EYLUL;
		}
		else if (month.equals("10")) {
			return day + " " + EKIM;
		}
		else if (month.equals("11")) {
			return day + " " + KASIM;
		}
		else {
			return day + " " + ARALIK;
		}
	}
	
	
	public static int distanceBetween(String date1, String date2) {
		int date1Index = 0;
		int date2Index = 0;
		String month1 = date1.substring(date1.indexOf(" ") + 1);
		String month2 = date2.substring(date2.indexOf(" ") + 1);
		int day1 = Integer.parseInt(date1.substring(0, date1.indexOf(" ")));
		int day2 = Integer.parseInt(date2.substring(0, date2.indexOf(" ")));
		if (month1.equals(month2)) {
			if (day2 < day1) { 
				return 360 - (day1 - day2);
			}
			else {
				return day2 - day1;
			}
		}
		else {
			for (int i = 0; i < 12; i++) {
				if (monthArray[i].equals(month1))
					date1Index = i + 1;
				if (monthArray[i].equals(month2))
					date2Index = i + 13;
			}
			
			int monthDistance = date1Index - date2Index;
			if (monthDistance < 0)
				return day1 + day2 + (-monthDistance * 30);
			return Integer.MIN_VALUE;
		}
	}
}