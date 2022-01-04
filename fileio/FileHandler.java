package fileio;
import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

import dates.AbstractCalendar;

@SuppressWarnings("unused")
public class FileHandler {
	
	private String text;
	private StringBuilder builder;
	private Scanner scan;
	private File file;
	private boolean scannerFlag;	// true for File, false for String.
	private ArrayList<String> lineList;
	
	public FileHandler(File file) {
		builder = new StringBuilder("");
		this.file = file;
		lineList = new ArrayList<>();
		setScannerToFile();
		initializeText();
		sort();
	}
	
	private void initializeText() {
		String currentLine = "";
		while (scan.hasNextLine()) {
			currentLine = scan.nextLine();
			if ( ! currentLine.equals("")) {
				lineList.add(currentLine);
				builder.append(currentLine);
			}
			if (scan.hasNextLine())
				builder.append("\n");
		}
		text = builder.toString();
	}
	
	public String text() {
		return text;
	}
	
	private void sort() {
		int size = lineList.size();
		for (int i = 0; i < size - 1; i++) {
			String currentLine = lineList.get(i);
			String nextLine = lineList.get(i + 1);
			int result = AbstractCalendar.compare(AbstractCalendar.findDate(currentLine), AbstractCalendar.findDate(nextLine));
			if (result == 1) {
				String temp = lineList.get(i);
				lineList.set(i, lineList.get(i + 1));
				lineList.set(i + 1, temp);
				if (i != 0)
					i = i - 2;
			}
		}
	}
	
	public void add(String name, String birthday) {
		lineList.add(birthday + " ==> " + name);
		sort();
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(file);
		}
		catch (FileNotFoundException e) {
			System.out.println("Exception in \"FileHandler\" class.");
			System.exit(0);
		}
		for (String s : lineList)
			writer.write(s + "\n\n");
		writer.close();
	}
	
	public void remove(String name) {
		for (int i = 0; i < lineList.size(); i++) {
			if (AbstractCalendar.findName(lineList.get(i)).equals(name))
				lineList.remove(i);
		}
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(file);
		}
		catch (FileNotFoundException e) {
			System.out.println("Exception in \"FileHandler\" class.");
			System.exit(0);
		}
		for (String s : lineList)
			writer.write(s + "\n\n");
		writer.close();
	}
	
	private void setScannerToFile() {
		try {
			scan = new Scanner(file);
		} 
		catch (FileNotFoundException e) {
			System.out.println("An exception inside \"FileHandler\" class.");
			System.exit(0);
		}
		scannerFlag = true;
	}
	
	private void setScannerToString(String str) {
		scan = new Scanner(str);
		scannerFlag = false;
	}
	
	public void printText() {
		for (int i = 0; i < lineList.size(); i++) {
			System.out.println(lineList.get(i));
		}
	}
	
	public ArrayList<String> getBirthdayList() {
		return lineList;
	}
	
	public ArrayList<String> find(String date) {
		if (lineList.isEmpty())
			return null;
		ArrayList<String> list = new ArrayList<>();
		date = AbstractCalendar.arrangeDate(date);
		for (String s : lineList)
			if (s.contains(date))
				list.add(s);
		if (list.isEmpty()) {
			ArrayList<Integer> compareList = new ArrayList<>();
			for (int i = 0; i < lineList.size(); i++) {
				String line = lineList.get(i);
				String date2 = AbstractCalendar.findDate(line);
				compareList.add(AbstractCalendar.distanceBetween(date, date2));
			}
			
			int min = compareList.get(0);
			for (int i = 1; i < compareList.size(); i++) {
				int current = compareList.get(i);
				if (min > current)
					min = current;
			}
			for (int i = 0; i < compareList.size(); i++) {
				if (min == compareList.get(i))
					list.add(lineList.get(i));
			}
		}
		return list;
	}
}