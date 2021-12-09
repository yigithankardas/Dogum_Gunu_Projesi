package fileio;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import dates.AbstractCalendar;

@SuppressWarnings("unused")
public class FileHandler {
	
	private String text;
	private StringBuilder builder;
	private Scanner scan;
	private File file;
	public static final String PATH = "BURAYA BİR PATH GİRİN";
	private boolean scannerFlag;	// true for File, false for String.
	private ArrayList<String> lineList;
	
	public FileHandler() {
		builder = new StringBuilder("");
		file = new File(PATH);
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
	}
	
	public void remove(String name) {
		for (int i = 0; i < lineList.size(); i++) {
			if (AbstractCalendar.findName(lineList.get(i)).equals(name))
				lineList.remove(i);
		}
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
}
