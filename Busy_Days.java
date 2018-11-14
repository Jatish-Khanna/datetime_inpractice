import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException, ParseException {
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter sf = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		LocalDateTime first = LocalDate.parse("2018-01-01").atStartOfDay();

		int properties = scanner.nextInt();
		for (int index = 0; index < properties; index++) {

			int reservations = scanner.nextInt();
			LocalDate startDate;
			LocalDate endDate;

			long days;
			int startIndex;

			int max = -1;
			int smallIndex = Integer.MAX_VALUE;
			int[] store = new int[1100];

			for (int reservation = 0; reservation < reservations; reservation++) {
				String start = scanner.next();
				String end = scanner.next();
				startDate = LocalDate.parse(start);
				endDate = LocalDate.parse(end);

				startIndex = (int) Duration.between(first, startDate.atStartOfDay()).toDays();
				days = Duration.between(startDate.atStartOfDay(), endDate.atStartOfDay()).toDays() + startIndex;

				while (startIndex <= days) {
					store[startIndex]++;
					if (max <= store[startIndex]) {
						max = store[index];
						if (max == store[startIndex]) {
							smallIndex = Math.min(smallIndex, startIndex);
						} else {
							smallIndex = startIndex;
						}
					}
					startIndex++;
				}

			}
			System.out.println(first.plusDays(smallIndex).format(sf));
		}

		scanner.close();
	}
}
