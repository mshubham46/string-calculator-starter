package calculator;

import java.util.Scanner;

class StringCalculator {
	private static int counter = 0;
	public int add(String input) {
		counter++;
		boolean flag = false;
		if (input.isEmpty()) {
			return 0;
		} 
		
		else if (input.contains(",")) {
			if(input.startsWith("+")) {
				flag = true;
			}
			String[] str = input.split("[\n,]");
			return doAddition(str, flag);
		}
		
		else if(input.contains("//")) {
			String delimiter = "";
			if(input.startsWith("+")) {
				flag = true;
				delimiter = Character.toString(input.charAt(4));
			}
			
			if(input.contains("[")) {

					int lastIndex = input.indexOf("]");
					int firstIndex = input.indexOf("[");
					delimiter = input.substring(firstIndex+1, lastIndex);
				
			}else {
				delimiter = Character.toString(input.charAt(2));
			}
				
			Scanner scan = new Scanner(input);
			String string;
				scan.nextLine();
				string = scan.nextLine();
			
			String[] str = string.split(delimiter);
			scan.close();
			return doAddition(str, flag);
		}
		
		else {
			return toInt(input);
		}
	}
	
	private int toInt(String string) {
		
		return Integer.parseInt(string);
	}
	
	private int doAddition(String[] string, boolean flag) {
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		
		for(String s: string) {
			int number = toInt(s);
			if(number > 0) {
				if(number > 1000) {
					continue;}
				sum = sum + number;
			}else
				sb.append(number);
		}
		
		if(sb.length() == 0) {
			
			if(flag) {
				return sum + string.length;
			}else
				return sum;
		}else {
			System.out.println(sb);
			throw new RuntimeException("negatives not allowed "+sb);
			}
	}
	
	public int GetCalledCount() {
		return counter;
	}

}