package ru.netology.domain;

public class Radio {
    private int currentRadioChannel; //Текущее положение радиоканала
    private final int minRadioChannel = 0; //Минимальный радиоканал
    private final int maxRadioChannel = 9; //Максимальный радиоканал

    private int currentVolume; //Текущее положение звука
    private final int minVolume = 0; //Минимальный звук
    private final int maxVolume = 10;  //Максимальный звук


    public int getCurrentRadioChannel() {

        return currentRadioChannel;
    }

    public void setCurrentRadioChannel(int currentRadioChannel) {
        if (currentRadioChannel > maxRadioChannel) {
            this.currentRadioChannel = minRadioChannel;
            return;
        }
        if (currentRadioChannel < minRadioChannel) {
            this.currentRadioChannel = maxRadioChannel;
            return;
        }
        this.currentRadioChannel = currentRadioChannel;
    }

    public void nextCurrentRadioChannel() {
        if (currentRadioChannel >= maxRadioChannel) {
            currentRadioChannel = minRadioChannel;
            return;
        }
        currentRadioChannel++;
    }

    public void prevCurrentRadioChannel() {
        if (currentRadioChannel <= minRadioChannel) {
            currentRadioChannel = maxRadioChannel;
            return;
        }
        currentRadioChannel--;
    }

    public int getCurrentVolume() {

        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume > maxVolume) {
            this.currentVolume = maxVolume;
            return;
        }
        if (currentVolume < minVolume) {
            this.currentVolume = minVolume;
            return;
        }
        this.currentVolume = currentVolume;
    }

    public void minusVolume() {
        if (currentVolume <= minVolume) {
            currentVolume = minVolume;
            return;
        }
        currentVolume--;
    }


    public void plusVolume() {
        if (currentVolume >= maxVolume) {
            currentVolume = maxVolume;
            return;
        }
        currentVolume++;
    }
}