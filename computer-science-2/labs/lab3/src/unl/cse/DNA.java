package unl.cse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DNA {

	public static void main(String args[]) {
		if(args.length != 1){
			System.out.print("Invalid arguments. Enter arguments in form of: java DNA String");
			System.exit(0);
		}
		String fileName = "data/H1N1nucleotide.txt";
		Scanner s = null;
		try {
			s = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String dna = "";

		while(s.hasNext()) {
			dna += s.next().trim();
		}
		s.close();

		String subsequence = args[0];

		int count = 0;
		//write code to count the number of times subsequence appears in the dna string
        for(int i = 0; i <= dna.length() - subsequence.length(); i++){
        	if(dna.substring(i, i + subsequence.length()).equalsIgnoreCase(subsequence))
        		count++;
		}

		System.out.println(subsequence + " appears " + count + " times");
		
	}
	
}
