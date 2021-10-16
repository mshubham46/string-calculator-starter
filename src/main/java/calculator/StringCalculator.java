package calculator;

class StringCalculator {

	public int add(String input) {
		if (input.isEmpty()) {
			return 0;
		} 
		
		else if (input.contains(",")) {
			
			String[] str = input.split("[\n,]");
			int sum = 0;
			for(String s: str) {
				int number = toInt(s);
				sum = sum + number;
			}
			
			return sum;
		}
		
		else {
			return toInt(input);
		}
	}
	
	private int toInt(String string) {
		return Integer.parseInt(string);
	}

}