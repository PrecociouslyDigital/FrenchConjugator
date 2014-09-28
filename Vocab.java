
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//import org.apache.commons.lang3.text.WordUtils;

public class Vocab {
	public static BufferedReader reader;
	public static void main(String[] args) {
		System.out.println("1 for e accent rising, 2 for e accent falling\n3 for cedille on c, 4 for circomflex on e");
		System.out.println("Manifest?\n");
		String read = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			read = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test(init(read));
		
	}
	public static ArrayList<String[]> init(String arg){
		ArrayList<String[]> list = new ArrayList<String[]>();
		try {
			reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\" + arg + ".txt"));
			String line;
			while ((line = reader.readLine()) != null) {
			    /*String[] placeholder = line.split(";", 2);
				placeholder[1] = WordUtils.wrap(placeholder[1], 20);
				list.add(placeholder);*/
				list.add(line.split(";",2));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static void test(ArrayList<String[]> input){
		String read = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();
		ArrayList<String> wrongs = new ArrayList<String>();
		try{
			while(!input.isEmpty()){
				int which = rand.nextInt(input.size());
				System.out.println("Definition of " + input.get(which)[0]);
				read = br.readLine();
				if(input.get(which)[1].compareToIgnoreCase(read) == 0){
					input.remove(which);
					System.out.println("Correct!\n");
				}else{
					System.out.println("Wrong!\nCorrect answer: "+ input.get(which)[1]);
					System.out.println("Was your answer actually correct? y/n");
					if (br.readLine().compareTo("y") == 0){
						input.remove(which);
						System.out.println("Correct!\n");
					}
					
				}
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done!\nGood Job!");
		System.out.println("Words missed:" + wrongs.toString());
		
	}
}
