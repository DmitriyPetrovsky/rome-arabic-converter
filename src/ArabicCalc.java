
public class ArabicCalc {

    public static int Calculate(String num){
        int result = 0;
        int size = num.length() - 1;
        //char firstLetter = num.charAt(0);
        //char secondLetter = num.charAt(1);
        if (size >= 0) {
            for (int i = 0; i <= size; i++) {
                if (num.charAt(i) != 'M' && num.charAt(i) != 'D' && num.charAt(i) != 'C' &&
                        num.charAt(i) != 'L' && num.charAt(i) != 'X' && num.charAt(i) != 'V' && num.charAt(i) != 'I' ) {
                    return 0;
                }
            }
        }

        while (size >= 0 && num.charAt(0) == 'M') {
            result = result + 1000;
            num = num.substring(1);
            size = size - 1;
        }
        if (size > 0 && num.charAt(0) == 'C' &&  num.charAt(1) == 'M'){
            result = result + 900;
            num = num.substring(2);
            size = size - 2;
        }
        if (size >= 0 && num.charAt(0) == 'D') {
            result = result + 500;
            num = num.substring(1);
            size = size - 1;
        }
        if (size > 0 && num.charAt(0) == 'C' && num.charAt(1) == 'D'){
            result = result + 400;
            num = num.substring(2);
            size = size -  2;
        }
        while (size >= 0 && num.charAt(0) == 'C') {
            result = result + 100;
            num = num.substring(1);
            size = size - 1;
        }
        if (size > 0 && num.charAt(0) == 'X' && num.charAt(1) == 'C') {
            result = result + 90;
            num = num.substring(2);
            size = size -  2;
        }
        if (size >= 0 && num.charAt(0) == 'L'){
            result = result + 50;
            num = num.substring(1);
            size = size -  1;
        }
        if (size > 0 && num.charAt(0) == 'X' && num.charAt(1) == 'L'){
            result = result + 40;
            num = num.substring(2);
            size = size -  2;
        }
        while (size >= 0 && num.charAt(0) == 'X') {
            result = result + 10;
            num = num.substring(1);
            size = size - 1;
        }
        if (size > 0 && num.charAt(0) == 'I' && num.charAt(1) == 'X'){
            result = result + 9;
            num = num.substring(2);
            size = size -  2;
        }
        if (size >= 0 && num.charAt(0) == 'V'){
            result = result + 5;
            num = num.substring(1);
            size = size -  1;
        }
        if (size > 0 && num.charAt(0) == 'I' && num.charAt(1) == 'V'){
            result = result + 4;
            num = num.substring(2);
            size = size -  2;
        }
        while (size >= 0 && num.charAt(0) == 'I') {
            result = result + 1;
            num = num.substring(1);
            size = size - 1;
        }

        return result;
    }
}
