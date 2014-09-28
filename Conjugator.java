
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Conjugator {
	public static BufferedReader reader;
	public static String[] pronouns = {
		"Je", "Tu", "Il", "Nous", "Vous", "Ils"
	};
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
			    list.add(line.split(" ", 7));
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
				int noun = rand.nextInt(6);
				System.out.println("Conjugate " + input.get(which)[0] + " for " + pronouns[noun] +"\n" );
				read = br.readLine();
				if(read.compareToIgnoreCase(input.get(which)[noun+1]) == 0){
					input.remove(which);
					System.out.println("Correct!\n");
				}else{
					System.out.println("Wrong!\nCorrect conjugation: "+ input.get(which)[noun+1]);
					if(wrongs.indexOf(input.get(which)[noun+1]) == -1){
						wrongs.add(input.get(which)[0]);
					}
				}
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done!\nGood Job!");
		System.out.println("Verbs missed:" + wrongs.toString());
		
	}
}
