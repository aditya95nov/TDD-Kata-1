import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static int calledCount = 0;

    public int add(String numbers) {
        calledCount++;
        if (StringUtils.isEmpty(numbers)) {
            return 0;
        } else if (numbers.length() == 1) {
            return Integer.parseInt(numbers);
        }
        String delimeter = ",";
        int substringIndex = 0;
        if (numbers.startsWith("//")) {
            delimeter = numbers.charAt(2) + "";
            substringIndex = 4;
            Pattern p = Pattern.compile("\\[(.*?)\\]");
            Matcher m = p.matcher(numbers);
            while (m.find()) {
                delimeter = m.group(1);
                substringIndex = numbers.indexOf("\n") + 1;
            }
        }
        String[] digits = numbers.substring(substringIndex).split("[" + delimeter + "|,|\n]");
        int sum = 0, number;
        List<Integer> illegalNumbers = new ArrayList<>();
        boolean hasNegatives = false;
        for (String d : digits) {
            if(StringUtils.isBlank(d)) {
                continue;
            }
            number = Integer.parseInt(d);
            if (number < 0) {
                illegalNumbers.add(number);
                hasNegatives = true;
            } else if (number > 1000) {
                continue;
            }
            sum += number;
        }
        if (hasNegatives) {
            throw new IllegalArgumentException("negatives not allowed - " + illegalNumbers);
        }
        return sum;
    }

    public int getCalledCount() {
        return calledCount;
    }
}
