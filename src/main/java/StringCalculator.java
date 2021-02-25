import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    public int add(String numbers) {
        if (StringUtils.isEmpty(numbers)) {
            return 0;
        } else if (numbers.length() == 1) {
            return Integer.parseInt(numbers);
        }
        char delimeter = ',';
        int substringIndex = 0;
        if (numbers.startsWith("//")) {
            delimeter = numbers.charAt(2);
            substringIndex = 4;
        }
        String[] digits = numbers.substring(substringIndex).split(delimeter + "|,|\n");
        int sum = 0;
        for (String d : digits) {
            sum += Integer.parseInt(d);
        }
        return sum;
    }
}
