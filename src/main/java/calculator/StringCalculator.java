package calculator;

import java.util.Scanner;

class StringCalculator {
	private static int counter = 0;
	public int add(String input) {
		counter++;
		if (input.isEmpty()) {
			return 0;
		} 
		
		else if (input.contains(",")) {
			
			String[] str = input.split("[\n,]");
			return doAddition(str);
		}
		
		else if(input.startsWith("//")) {
			String delimiter = "";
			if(input.charAt(2) == '[') {
				int lastIndex = input.indexOf("]");
				delimiter = input.substring(3, lastIndex);
			}else {
				delimiter = Character.toString(input.charAt(2));
			}
				
			Scanner scan = new Scanner(input);
			scan.nextLine();
			String string = scan.nextLine();
			
			String[] str = string.split(delimiter);
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
		StringBuilder sb = new StringBuilder();
		for(String s: string) {
			int number = toInt(s);
			if(number > 0) {
				if(number > 1000)
					continue;
				sum = sum + number;
			}else
				sb.append(number);
		}
		
		if(sb.length() == 0)
			return sum;
		else
			System.out.println(sb);
			throw new RuntimeException("negatives not allowed "+sb);
	}
	
	public int GetCalledCount() {
		return counter;
	}

}