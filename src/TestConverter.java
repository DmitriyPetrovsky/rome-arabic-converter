public class TestConverter {
    public static void main(String[] args) {
        /*
        Данный класс позволяет проверить правильность
        конвертации числа в римские цифры (работу класса RomeCalc)
        и конвертации римских цифр в число (работу класса ArabicCalc)
        путем их поочередной конвертации и сравнением с заранее
        известными числами.
         */

        int errCounter = 0;
        for (int i = 1; i <= 5000; i++) {
            if (i != ArabicCalc.Calculate(RomeCalc.Calculate(i))) {

                System.out.println("Ошибка на " + i);
                System.out.println(i + " в римские будет " + RomeCalc.Calculate(i));
                System.out.println(RomeCalc.Calculate(i) + " в арабские будет " + ArabicCalc.Calculate(RomeCalc.Calculate(i)));
                System.out.println("--------------------------------------------------");
                errCounter++;
            }
        }
        System.out.println("Программа завершена, ошибок: " + errCounter);
    }
}