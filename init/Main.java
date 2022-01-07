package init;
import java.io.*;

import fileio.*;
import gui.*;

public class Main {
	
	public static void main(String[] args) {
		File file = new File(System.getenv("USERPROFILE") + "/DogumGunleri.txt");
		boolean exist = false;
		try {
			exist = file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileHandler handler = new FileHandler(file);
		AllGui frame = new AllGui(handler);
		frame.initiate();
		
		if (exist == true) {	// dosya oluşturuldu
			AllGui.firstTime();
		}
	}
}
