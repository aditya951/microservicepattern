package ad20084567.microsrvices.cart.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

public class TimeDemo {

	public static String pattern1 = "EEE MMM dd HH:mm:ss zzz yyyy";
	private static String UTCDATE = "yyyy-MM-dd'T'HH:mm:ss.SSS";
	private static DateTimeFormatter timezoneformatter = DateTimeFormatter.ofPattern(UTCDATE);

	public static String convertTimeZone(String date) {

		if (date != null) {
			return timezoneformatter.format(LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern1)));
		}
		return null;
	}

	public static int solution(int[] A, String[] D) {

		int count[] = new int[12];
		int sum[] = new int[12];
		int sumn[] = new int[12];
		try {
			for (int i = 0; i < D.length; i++) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat formatter1 = new SimpleDateFormat("MM");
				Date date1;

				date1 = sdf.parse(D[i]);

				String str = formatter1.format(date1);
				System.out.println(str + "    ++++++++++++++++");
				if (str.equalsIgnoreCase("01")) {
					sum[0] += A[i];
					if (A[i] < 0) {
						sumn[0] += A[i];
						count[0]++;

					}
				} else if (str.equalsIgnoreCase("02")) {
					sum[1] += A[i];
					if (A[i] < 0) {
						count[1]++;
						sumn[1] += A[i];
					}

				} else if (str.equalsIgnoreCase("03")) {
					sum[2] += A[i];
					if (A[i] < 0) {
						count[2]++;
						sumn[2] += A[i];
					}

				} else if (str.equalsIgnoreCase("04")) {
					sum[3] += A[i];
					if (A[i] < 0) {
						count[3]++;
						sumn[3] += A[i];
					}
				} else if (str.equalsIgnoreCase("05")) {
					sum[4] += A[i];
					if (A[i] < 0) {
						count[4]++;
						sumn[4] += A[i];
					}
				} else if (str.equalsIgnoreCase("06")) {
					sum[5] += A[i];
					if (A[i] < 0) {
						count[5]++;
						sumn[5] += A[i];
					}
				} else if (str.equalsIgnoreCase("07")) {
					sum[6] += A[i];
					if (A[i] < 0) {
						count[6]++;
						sumn[6] += A[i];
					}
				} else if (str.equalsIgnoreCase("08")) {
					sum[7] += A[i];
					if (A[i] < 0) {
						count[7]++;
						sumn[7] += A[i];
					}
				} else if (str.equalsIgnoreCase("09")) {
					sum[8] += A[i];
					if (A[i] < 0) {
						count[8]++;
						sumn[8] += A[i];
					}
				} else if (str.equalsIgnoreCase("10")) {
					sum[9] += A[i];
					if (A[i] < 0) {
						count[9]++;
						sumn[9] += A[i];
					}
				} else if (str.equalsIgnoreCase("11")) {
					sum[10] += A[i];
					if (A[i] < 0) {
						count[10]++;
						sumn[10] += A[i];
					}
				} else if (str.equalsIgnoreCase("12")) {
					sum[11] += A[i];
					if (A[i] < 0) {
						count[11]++;
						sumn[11] += A[i];
					}

				}

			}
			System.out.println(Arrays.toString(sumn));
			System.out.println(Arrays.toString(sum));
			System.out.println(Arrays.toString(count));
			int sump = 0;
			int sumf = 0;
			for (int j = 0; j < sum.length; j++) {
				if (count[j] >= 3 && sumn[j] <= -100) {
					sumf += sum[j];
					sump += 5;
				} else {
					sumf += sum[j];
				}
			}
			sumf = sumf + sump - (5 * 12);
			System.out.println(sumf);
			return 0;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

	public static void main(String[] args) throws ParseException {
		int[] trans = { 100, 100, -10, -20, -30 };
		String[] date = { "2020-01-31", "2020-02-22", "2020-02-03", "2020-02-29", "2020-02-29" };
		solution(trans, date);

//		
//		

	}

}
