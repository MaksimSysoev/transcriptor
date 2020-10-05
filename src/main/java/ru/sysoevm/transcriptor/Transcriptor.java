package ru.sysoevm.transcriptor;

public class Transcriptor {
    public static void main(String[] args) {
        String text = "пять девяток семь два НУль единица четыре четвёрки";
        OperationWithInputData operationWithInputData = new OperationWithInputData(text.toLowerCase());
        operationWithInputData.setSingleNumber();
        operationWithInputData.setMultipleNumberString();
    }
}
