package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    @Test
    void shouldRadioChannelNumber() {
        Radio radio = new Radio();
        radio.setCurrentRadioChannel(1);
        assertEquals(1, radio.getCurrentRadioChannel());
    }

    @Test   // Тест переключения следующего радиоканала
    public void shouldNextRadioChannel() {
        Radio radio = new Radio();
        radio.setCurrentRadioChannel(5);
        radio.nextCurrentRadioChannel();
        assertEquals(6, radio.getCurrentRadioChannel());
    }

    @Test // Тест переключения предыдущего радиоканала
    public void shouldPrevRadioChannel() {
        Radio radio = new Radio();
        radio.setCurrentRadioChannel(4);
        radio.prevCurrentRadioChannel();
        assertEquals(3, radio.getCurrentRadioChannel());
    }

    @Test // Тест переключения радиоканала с 9 на 0
    public void shouldNextMaxRadioChannel() {
        Radio radio = new Radio();
        radio.setCurrentRadioChannel(9);
        radio.nextCurrentRadioChannel();
        assertEquals(0, radio.getCurrentRadioChannel());
    }

    @Test // Тест переключения радиоканала с 0 на 9
    public void shouldPrevMinRadioChannel() {
        Radio radio = new Radio();
        radio.setCurrentRadioChannel(0);
        radio.prevCurrentRadioChannel();
        assertEquals(9, radio.getCurrentRadioChannel());
    }

    @Test // Тест граничных значений
    public void shouldBoundaryMaxRadioChannel() {
        Radio radio = new Radio();
        radio.setCurrentRadioChannel(10);
        assertEquals(0, radio.getCurrentRadioChannel());
    }

    @Test // Тест граничных значений
    public void shouldBoundaryMinRadioChannel() {
        Radio radio = new Radio();
        radio.setCurrentRadioChannel(-1);
        assertEquals(9, radio.getCurrentRadioChannel());
    }

    @Test
    void shouldVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test // Тест увеличения громкости звука (+)
    public void shouldNextVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(7);
        radio.nextCurrentVolume();
        assertEquals(8, radio.getCurrentVolume());
    }

    @Test // Тест уменьшения громкости звука (-)
    public void shouldPrevVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(6);
        radio.prevCurrentVolume();
        assertEquals(5, radio.getCurrentVolume());
    }

    @Test // Тест max громкость звука
    public void shouldMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.nextCurrentVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test // Тест min громкость звука
    public void shouldMinVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.prevCurrentVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test // Тест граничных значений
    public void shouldBoundaryMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(101);
        radio.nextCurrentVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test // Тест граничных значений
    public void shouldBoundaryMinVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);
        radio.prevCurrentVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test // Тест для радио с 10 станциями (с 0 по 9)
    public void setImpossibleRadioChannel() {
        Radio radio = new Radio();
        int expectedRadioChannel = 0;
        radio.setCurrentRadioChannel(15);
        assertEquals(expectedRadioChannel, radio.getCurrentRadioChannel());
    }

    @Test // Тест для радио с 20 станциями
    public void setNewRadioChannel() {
        int numRadioChannel = 20;
        Radio radio = new Radio(numRadioChannel);
        int expectedRadioChannel = 15;
        radio.setCurrentRadioChannel(15);
        assertEquals(expectedRadioChannel, radio.getCurrentRadioChannel());
    }



}