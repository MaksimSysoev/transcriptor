package ru.sysoevm.transcriptor;

import ru.sysoevm.transcriptor.storage.TranscriptionStore;



public class OperationWithInputData {

    private TranscriptionStore store = new TranscriptionStore();
    private String output = "";

    /**
     * Конвертирует введённую в консоли строку в массив слов.
     * @param s - строка, введённая с консоли.
     * @return массив слов.
     */
    private String[] convertToArray(String s) {
        return s.split(" ");
    }

    /**
     * Метод возвращает строку из дублирующихся элементов.
     * @param val занчение, которое необходимо дублировать.
     * @param count количество дубликатов, которое необходимо сделать.
     * @return
     */
    private String setNumberNextValue(int val, int count) {
        String next = "";
        for (int i = 0; i < count; i++) {
            next = next + val;
        }
        return next;
    }

    /**
     * Метод делает транскрипцию введенной текстовой строки через пробелы в строку из символов.
     * @param s введенная строка
     * @return
     * @throws InputErrorException исключение ввода данных
     * @throws OutputException исключение, если строка более 10 символов.
     */
    public String transcriptionData(String s) throws InputErrorException, OutputException {
        String[] input = convertToArray(s);
        int indexNext = 0;
        for (int index = 0; index < input.length; index++) {

            if (index+1 < input.length) {
                indexNext = index + 1;
            } else if (index+1 == input.length) {
                indexNext = input.length - 1;
            }

            boolean keyWord = store.getStoreWord().containsKey(input[index]);
            boolean keyWordNext = store.getStoreWord().containsKey(input[indexNext]);

            boolean keyPair = store.getStorePair().containsKey(input[index]);
            boolean keyPairNext = store.setStorePair().containsKey(input[indexNext]);

            // Если ввод полностью верный.
            if (keyWord && keyWordNext) {
                output = output + store.getStoreWord().get(input[index]);
            }

            //Если первое значение из storeWord а второе из storePair
            if (keyWord && keyPairNext) {

                int wordValue = store.getStoreWord().get(input[index]);
                int pairValue = store.getStorePair().get(input[indexNext]);

                if (wordValue < 3 && index == 0) {
                    throw new InputErrorException(input[index]);
                }

                String word = input[index];


                if (word.equals("три") || word.equals("четыре") || word.equals("пять")||
                        word.equals("шесть") || word.equals("семь") ||
                        word.equals("восемь") || word.equals("девять")) {
                    if (wordValue == 3 || wordValue == 4) {
                        if (pairValue < 10) {
                            throw new InputErrorException(input[index]);
                        } else {

                                    output = output + setNumberNextValue(pairValue / 10, wordValue);

                            index += 1;
                        }
                    }
                } else {
                    throw new InputErrorException(input[indexNext]);
                }

                if (wordValue > 4 ) {
                    if (pairValue > 10) {
                        throw new InputErrorException(input[indexNext]);
                    } else {
                        output = output + setNumberNextValue(pairValue, wordValue);
                        index+=1;
                    }
                }
            }

            // если первое значение из storePair, а второе значение из storeWord
            if (keyPair && keyWordNext) {
                    int keyValue = store.getStorePair().get("одна");
                    int wordValue = store.getStoreWord().get(input[indexNext]);
                    String word = input[indexNext];
                    if (keyValue==111) {
                        if (word.equals("единица") || word.equals("двойка")
                                || word.equals("тройка") || word.equals("четвёрка") || word.equals("пятёрка")
                                || word.equals("шестёрка") || word.equals("семёрка") || word.equals("восьмёрка") || word.equals("девятка")) {
                            output = output + wordValue;
                        } else {
                            throw new InputErrorException(input[index]);
                        }
                        index+=1;
                    }


            }

            // если первое и второе значение из storePair
            if (keyPair && keyPairNext) {
                throw new InputErrorException(input[index]);
            }

            // Если введённого значения нет везде
            if (!keyWord && !keyPair) {
                throw new InputErrorException(input[index]);
            }

            if (!keyWordNext && !keyPairNext) {
                throw new InputErrorException(input[indexNext]);
            }
        }

        if (output.length() > 10) {
            throw new OutputException("Длина номера более 10 символов");
        }

        return output;
    }
}
