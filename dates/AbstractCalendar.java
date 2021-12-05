package dates;

@SuppressWarnings("unused")
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
}
