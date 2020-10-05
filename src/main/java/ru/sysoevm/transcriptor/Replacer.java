package ru.sysoevm.transcriptor;

import java.util.regex.Matcher;

/**
 * Осуществляет поиск и замену необходимых слов ан символы.
 */
public class Replacer {

    /**
     * Строка после обработки.
     */
    private String output;

    public Replacer(String output) {
        this.output = output;
    }

    /**
     * Дублирует символы
     * @param n количество повторений
     * @param s символ, который необходимо повторять
     * @return newStr - строка с повторными символами.
     */
    public String merger(int n, String s) {
        String newStr = "";
        for (int i = 0; i < n; i++) {
            newStr = newStr + s;
        }
        return newStr;
    }

    /**
     * Меняет слова в единственном числе на числа.
     * @param matcher регулярное выражения для поиска соответсвия нужного числового значения.
     */
    public void replaceSingle(Matcher matcher) {
        while(matcher.find()) {
            switch(matcher.group()) {
                case "ноль":
                case "нуль":
                    output = output.replace(matcher.group(), "0");
                    break;
                case "один":
                case "единица":
                    output = output.replace(matcher.group(), "1");
                    break;
                case "два":
                case "двойка":
                    output = output.replace(matcher.group(), "2");
                    break;
                case "три":
                case "тройка":
                    output = output.replace(matcher.group(), "3");
                    break;
                case "четыре":
                case "четвёрка":
                    output = output.replace(matcher.group(), "4");
                    break;
                case "пять":
                case "пятёрка":
                    output = output.replace(matcher.group(), "5");
                    break;
                case "шесть":
                case "шестёрка":
                    output = output.replace(matcher.group(), "6");
                    break;
                case "семь":
                case "семёрка":
                    output = output.replace(matcher.group(), "7");
                    break;
                case "восемь":
                case "восьмёрка":
                    output = output.replace(matcher.group(), "8");
                    break;
                case "девять":
                case "девятка":
                    output = output.replace(matcher.group(), "9");
                    break;
                default:
                    break;
            }
        }
    }

    public String getMultiplicand(int n, String word) {
        String multiplicand = "";
        String value = "";
        word.trim();
        if (n > 1 && n < 5) {
            if (word.matches("нуля") || word.matches("единицы")
                    || word.matches("двойки")
                    || word.matches("тройки")
                    || word.matches("четвёрки")
                    || word.matches("пятёрки")
                    || word.matches("шестёрки")
                    || word.matches("семёрки")
                    || word.matches("восьмёрки")
                    || word.matches("девятки")) {
                value = word;
            }
        }
        if (n > 4 && n < 10) {
            if (word.matches("нулей") || word.matches("единиц")
                    || word.matches("двоек")
                    || word.matches("троек")
                    || word.matches("четвёрок")
                    || word.matches("пятёрок")
                    || word.matches("шестёрок")
                    || word.matches("семёрок")
                    || word.matches("восьмёрок")
                    || word.matches("девяток")) {
                value = word;
            }
        }

        switch (value) {
            case "нуля":
            case "ноля":
            case "нулей":
                multiplicand = "0";
                break;
            case "единицы":
            case "единиц":
                multiplicand = "1";
                break;
            case "двойки":
            case "двоек":
                multiplicand = "2";
                break;
            case "тройки":
            case "троек":
                multiplicand = "3";
                break;
            case "четвёрки":
            case "четвёрок":
                multiplicand = "4";
                break;
            case "пятёрки":
            case "пятёрок":
                multiplicand = "5";
                break;
            case "шестёрки":
            case "шестёрок":
                multiplicand = "6";
                break;
            case "семёрки":
            case "семёрок":
                multiplicand = "7";
                break;
            case "восьмёрки":
            case "восьмёрок":
                multiplicand = "8";
                break;
            case "девятки":
            case "девяток":
                multiplicand = "9";
                break;
        }
        return multiplicand;
    }

    /**
     * Определяет множимое значение на правильный множитель.
     * @param group Стрококве значение в виде числа и строки для правильного составления дублирования цифр.
     * @return строку с дублирующими цифроами.
     */
    private String multipleNumberString(String group) {
        String result = "";
        int n = 0;
        String[] num = group.split("[а-яА-ЯёЁ]+");
        String[] word = group.split("\\d\\s");
        n = Integer.parseInt(num[0].trim());
        String multiplicand = getMultiplicand(n, word[1].trim());
        if (multiplicand!="") {
            result = merger(n, multiplicand);
        }
        return result;
    }

    /**
     * Определяет к какой группе относится найденная строка.
     * @param matcher Для поиска необходимых строк для дальнейшей обработки.
     */
    public void replaceMultipleNumberString(Matcher matcher) {
        while (matcher.find()) {
            String group = matcher.group();
            if ((group.matches("(\\d\\s[а-яА-ЯёЁ]+)")) || (group.matches("(две+\\s[а-яА-ЯёЁ]+)")) ){
                if (multipleNumberString(group)!="") {
                    output = output.replace(group, multipleNumberString(group));
                }
            }
        }
        System.out.println("output: " + output.replace(" ", ""));
    }


    /**
     * Возвращает обработанную строку.
     * @return
     */
    public String getOutput() {
        return output;
    }
}
