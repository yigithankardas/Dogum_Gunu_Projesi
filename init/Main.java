package init;

import java.io.*;
import fileio.*;
import gui.*;

public class Main {
	
	public static void main(String[] args) {
		File file = new File(System.getenv("USERPROFILE") + "/OneDrive - TOBB Ekonomi ve Teknoloji Üniversitesi/DogumGunleri.txt");
		boolean exist = false;
		try {
			exist = file.createNewFile();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		FileHandler handler = new FileHandler(file);
		GUI frame = new GUI(handler);
		frame.initiate();
		
		if (exist == true) {	// dosya oluþturuldu
			GUI.firstTime();
		}
	}
}
