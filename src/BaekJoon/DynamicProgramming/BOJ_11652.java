import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11652 {
	private static final String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		final int numberCount = Integer.parseInt(stringTokenizer.nextToken());
		final int sumCount = Integer.parseInt(stringTokenizer.nextToken());

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		final int[] numbers = new int[numberCount + 1];

		for (int i = 1; i < numbers.length; i++) {
			numbers[i] = numbers[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
		}

		List<Range> Ranges = new ArrayList<>();

		for (int i = 0; i < sumCount; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			final int startIndex = Integer.parseInt(stringTokenizer.nextToken());
			final int endIndex = Integer.parseInt(stringTokenizer.nextToken());

			Ranges.add(new Range(startIndex, endIndex));
		}

		System.out.println(sumNumbers(numbers, Ranges));
	}

	private static StringBuilder sumNumbers(int[] numbers, List<Range> ranges) {
		final StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < ranges.size(); i++) {
			int sum = 0;
			Range range = ranges.get(i);

			sum = numbers[range.endIndex] - numbers[range.startIndex - 1];
			stringBuilder.append(sum).append(NEW_LINE);
		}

		return stringBuilder;
	}

	static class Range {
		private int startIndex;
		private int endIndex;

		public Range(int startIndex, int endIndex) {
			super();
			this.startIndex = startIndex;
			this.endIndex = endIndex;
		}

	}

}
