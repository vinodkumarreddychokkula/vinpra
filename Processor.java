
import java.io.File;
//import java.io.FileNotFoundException;
import java.util.*;
public class Processor {

	public static void main(String[] args) throws Exception {
		
		File inputFile = new File("C:/Users/prash/workspace/cache architecture/src/input.txt");
		
		Scanner sc;
		sc = new Scanner(inputFile);
		L1Controller l1c=new L1Controller();
		//L1Controller l2c=new L1Controller();
		
		while (sc.hasNextLine())
		{
			String line = sc.nextLine();
			l1c.instructionSplit(line);
			//l2c.instructionSplit(line);
		}
		l1c.ProcessData();
			sc.close();
		
	} 
	}
	