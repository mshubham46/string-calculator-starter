package calculator;

import java.util.Scanner;

class StringCalculator {
	
	public int add(String input) {
		if (input.isEmpty()) {
			return 0;
		} 
		
		else if (input.contains(",")) {
			
			String[] str = input.split("[\n,]");
			return doAddition(str);
		}
		
		else if(input.startsWith("//")) {
			Scanner scan = new Scanner(input);
			char delimiter = input.charAt(2);
			scan.nextLine();
			String string = scan.nextLine();
			
			System.out.println(string);
			String[] str = string.split(Character.toString(delimiter));

			scan.close();
			return doAddition(str);
		}
		
		else {
			return toInt(input);
		}
	}
	
	private int toInt(String string) {
		return Integer.parseInt(string);
	}
	
	private int doAddition(String[] string) {
		int sum = 0;
		for(String s: string) {
			int number = toInt(s);
			sum = sum + number;
		}
		return sum;
	}

}