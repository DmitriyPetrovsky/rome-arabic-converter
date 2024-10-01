public class RomeCalc{

    public static String Calculate(int num) {
        String result = "";
        int thousands;
        int fivehundreds;
        int hundreds;
        int fifty;
        int decs;
        thousands = (int) (num / 1000);
        for (int i = 0; i < thousands; i++){
            result = result + "M";
        }
        if (thousands !=0)  num = num % (1000 * thousands);
        fivehundreds = (int) (num / 500);
        if (fivehundreds == 1 && (num % 500 <400)){
            result = result + "D";
        } else if (fivehundreds == 0 && num % 500 >= 400) {
            result = result + "CD";
        } else if (fivehundreds == 1 && (num % 500 >= 400)) {
            result = result + "CM";
        }
        num = num % 500;
        hundreds = (int) (num / 100);
        if (hundreds < 4) {
            for (int i = 0; i < hundreds; i++){
                result = result + "C";
            }
        }
        num = num % 100;
        fifty = (int) (num / 50);
        if (fifty == 1 && (num % 50 < 40)) {
            result = result + "L";
        } else if (fifty == 1 && (num % 50 >= 40)){
            result = result + "XC";
        } else if (fifty == 0 && (num % 50 >= 40)){
            result = result + "XL";
        }

        num = num % 50;
        decs = (int) (num / 10);
        if (decs < 4) { //////////////////
            for (int i = 0; i < decs; i++){
                result = result + "X";
            }
        } //else if (decs >= 4 && (num % 50 != 1)) {
//            result = result + "XL";
//        }
        num = num % 10;
        switch (num) {
            case 1:
                result = result + "I";
                break;
            case 2:
                result = result + "II";
                break;
            case 3:
                result = result + "III";
                break;
            case 4:
                result = result + "IV";
                break;
            case 5:
                result = result + "V";
                break;
            case 6:
                result = result + "VI";
                break;
            case 7:
                result = result + "VII";
                break;
            case 8:
                result = result + "VIII";
                break;
            case 9:
                result = result + "IX";
                break;
        }
        return result;
    }
}
