package ru.sysoevm.transcriptor;

public class InputErrorException extends Exception {

    public InputErrorException(String message) {
        System.out.println("Ошибка ввода " + "«" + message + "»");
    }

}
