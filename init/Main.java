package init;
import fileio.*;
import gui.*;

@SuppressWarnings("unused")
public class Main {
	
	public static void main(String[] args) {
		FileHandler handler = new FileHandler();
		AllGui frame = new AllGui(handler);
	}
}