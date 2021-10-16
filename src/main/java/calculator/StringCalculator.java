package calculator;

class StringCalculator {

	public int add(String input) {
		if (input.isEmpty()) {
			return 0;
		} 
		
		else if (input.contains(",")) {
			String[] str = input.split(",");
			return toInt(str[0]) + toInt(str[1]);
		}
		
		else {
			return toInt(input);
		}
	}
	
	private int toInt(String string) {
		return Integer.parseInt(string);
	}

}