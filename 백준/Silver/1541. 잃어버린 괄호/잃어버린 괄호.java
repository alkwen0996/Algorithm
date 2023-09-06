import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	private static final char MINUS = '-';
	private static final char PLUS = '+';

	public static void main(String[] args) throws IOException {
		final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		final String inputLine = bufferedReader.readLine();

		int startIndex = 0;

		final Deque<Integer> operands = new ArrayDeque<>();
		final Deque<Character> operators = new ArrayDeque<>();

		for (int i = 0; i < inputLine.length(); i++) {
			startIndex = splitOperandOperator(inputLine, startIndex, operands, operators, i);
		}

		System.out.println(createMinimumValue(operands, operators));
	}

	private static int createMinimumValue(Deque<Integer> operands, Deque<Character> operators) {
		final Deque<Integer> minusValues = new ArrayDeque<>();

		int sum = 0;

		while (!operands.isEmpty()) {
			final Integer operand = operands.pop(); // 피연산자
			Character operator = null;

			if (!operators.isEmpty()) {
				operator = operators.pop(); // 연산자

				if (operator == PLUS) {
					sum += operand;
				} else {
					minusValues.push(sum + operand);
					sum = 0;
				}
			} else {
				sum += operand - minusValues.stream().mapToInt(a -> a).sum();
			}
		}

		return sum;

	}

	private static int splitOperandOperator(final String inputLine, int startIndex, final Deque<Integer> operands,
			final Deque<Character> operators, int index) {
		if (inputLine.charAt(index) == PLUS || inputLine.charAt(index) == MINUS) {
			operands.push(Integer.parseInt(inputLine.substring(startIndex, index)));
			operators.push(inputLine.charAt(index));
			startIndex = index + 1;
		}

		if (index == inputLine.length() - 1) {
			operands.push(Integer.parseInt(inputLine.substring(startIndex, inputLine.length())));
		}

		return startIndex;
	}

}
