package calculator;

class StringCalculator {

	public int add(String input) {
		if (input.isEmpty()) {
			return 0;
		} 
		else if (input.contains(",")) {
			String[] str = input.split(",");
			return Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
		}
		else {
			return Integer.parseInt(input);
		}
	}

}