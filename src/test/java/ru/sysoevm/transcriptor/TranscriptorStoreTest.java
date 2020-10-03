package ru.sysoevm.transcriptor;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.junit.Assert.assertEquals;

public class TranscriptorStoreTest {

    OperationWithInputData td;
    ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp () {
        td = new OperationWithInputData();
    }

   @Test
    public void whenEnterCorrectData() throws InputErrorException, OutputException {
        String input = "один два три восемь девять три";
        String output = td.transcriptionData(input);
        assertEquals(output, "123893");
   }

    @Test
    public void whenEnteringDuplicateValues1() throws InputErrorException, OutputException {
        String input = "пять пятёрок пять восьмёрок";
        String output = td.transcriptionData(input);
        assertEquals(output, "5555588888");
    }

    @Test
    public void whenEnteringDuplicateValues2() throws InputErrorException, OutputException {
        String input = "три пятёрки шесть двоек один";
        String output = td.transcriptionData(input);
        assertEquals(output, "5552222221");
    }

    @Test
    public void whenRandomInput() throws InputErrorException, OutputException {
        String input = "одна двойка четыре четыре единицы три семёрки тройка";
        String output = td.transcriptionData(input);
        assertEquals(output, "2411117773");
    }

    @Test(expected = InputErrorException.class)
    public void whenEnteringNotCorrectData() throws InputErrorException, OutputException {
        String input = "пятёрка двоек";
        assertEquals("Ошибка ввода «двоек»", td.transcriptionData(input));
    }

    @Test(expected = OutputException.class)
    public void whenOutputMoreThanTenValues() throws InputErrorException, OutputException {
        String input = "три тройки пять восьмёрок семь семёрок";
        assertEquals("Длина более 10 символов", td.transcriptionData(input));
    }

}
