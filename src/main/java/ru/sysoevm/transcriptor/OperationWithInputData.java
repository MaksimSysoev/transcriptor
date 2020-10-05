package ru.sysoevm.transcriptor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationWithInputData {

    /**
     * Изначальный ввод данных.
     */
    private String input;

    /**
     * Объект класса заменителя.
     */
    private Replacer replacer;

    public OperationWithInputData(String input) {
        this.input = input;
        replacer = new Replacer(input);
    }

    /**
     * Создаёт регулярное выражение и применяет его к тексту.
     * @param regExp регулярное выражение.
     * @param input строка к которой оно применяется.
     * @return объект типа Matcher.
     */
    public Matcher createMatcher(String regExp, String input) {
        Pattern pattern = Pattern.compile(regExp);
        return pattern.matcher(input);
    }

    /**
     * Меняет сначала простые слова в единственном числе на числа.
     */
    public void setSingleNumber() {
        Matcher matcher = createMatcher("([а-яА-ЯёЁ^\\d]+)", input);
        replacer.replaceSingle(matcher);
    }


    /**
     * Меняет парные слова во множественном числе на числа
     */
    public void setMultipleNumberString() {
       Matcher matcher = createMatcher("(\\d\\s[а-яА-ЯёЁ]+)|(две+\\s[а-яА-ЯёЁ]+)", replacer.getOutput());
       replacer.replaceMultipleNumberString(matcher);

    }

}
