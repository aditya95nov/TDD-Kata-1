import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    public int add(String numbers) {
        if (StringUtils.isEmpty(numbers)) {
            return 0;
        }
        else if (numbers.length() == 1) {
            return Integer.parseInt(numbers);
        }
        return -1;
    }
}
