package ru.sysoevm.transcriptor.storage;

import java.util.HashMap;

public class TranscriptionStore {

    /**
     * Используется для хранения простых названий. Например: один, два, три
     *
     */
    private HashMap<String, Integer> storeWord = new HashMap<>();

    /**
     * Используется для хранения парных названия. Например: тройки, пятёрок, одна
     */
    private HashMap<String, Integer> storePair = new HashMap<>();


    public TranscriptionStore() {
        this.storeWord = setStoreWord();
        this.storePair = setStorePair();
    }

    public HashMap<String, Integer> getStoreWord() {
        return storeWord;
    }

    public HashMap<String, Integer> setStoreWord() {
        storeWord.put("один", 1);
        storeWord.put("единица", 1);
        storeWord.put("два", 2);
        storeWord.put("двойка", 2);
        storeWord.put("три", 3);
        storeWord.put("тройка", 3);
        storeWord.put("четыре", 4);
        storeWord.put("четвёрка", 4);
        storeWord.put("пять", 5);
        storeWord.put("пятёрка", 5);
        storeWord.put("шесть", 6);
        storeWord.put("шестёрка", 6);
        storeWord.put("семь", 7);
        storeWord.put("семёрка", 7);
        storeWord.put("восемь", 8);
        storeWord.put("восьмёрка", 8);
        storeWord.put("девять", 9);
        storeWord.put("девятка", 9);
        return storeWord;
    }

    public HashMap<String, Integer> getStorePair() {
        return storePair;
    }

    public HashMap<String, Integer> setStorePair() {

        storePair.put("одна", 111);
        storePair.put("единицы", 11);
        storePair.put("единиц", 1);

        storePair.put("двойки", 22);
        storePair.put("двоек", 2);

        storePair.put("тройки", 33);
        storePair.put("троек", 3);

        storePair.put("четвёрки", 44);
        storePair.put("четвёрок", 4);

        storePair.put("пятёрки", 55);
        storePair.put("пятёрок", 5);

        storePair.put("шестёрки", 66);
        storePair.put("шестёрок", 6);

        storePair.put("семёрки", 77);
        storePair.put("семёрок", 7);

        storePair.put("восьмёрки", 88);
        storePair.put("восьмёрок", 8);

        storePair.put("девятки", 99);
        storePair.put("девяток", 9);

        return storePair;
    }
}
