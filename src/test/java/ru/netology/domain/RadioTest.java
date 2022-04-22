package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {
    Radio radio = new Radio(10);

    @Test
    void shouldRadioChannelNumber() {
        radio.setCurrentRadioChannel(1);
        assertEquals(1, radio.getCurrentRadioChannel());
    }

    @Test   // Тест переключения следующего радиоканала
    public void shouldNextRadioChannel() {
        radio.setCurrentRadioChannel(5);
        radio.nextCurrentRadioChannel();
        assertEquals(6, radio.getCurrentRadioChannel());
    }

    @Test // Тест переключения предыдущего радиоканала
    public void shouldPrevRadioChannel() {
        radio.setCurrentRadioChannel(4);
        radio.prevCurrentRadioChannel();
        assertEquals(3, radio.getCurrentRadioChannel());
    }

    @Test // Тест переключения радиоканала с 9 на 0
    public void shouldNextMaxRadioChannel() {
        radio.setCurrentRadioChannel(9);
        radio.nextCurrentRadioChannel();
        assertEquals(0, radio.getCurrentRadioChannel());
    }

    @Test // Тест переключения радиоканала с 0 на 9
    public void shouldPrevMinRadioChannel() {
        radio.setCurrentRadioChannel(0);
        radio.prevCurrentRadioChannel();
        assertEquals(9, radio.getCurrentRadioChannel());
    }

    @Test // Тест граничных значений
    public void shouldBoundaryMaxRadioChannel() {
        radio.setCurrentRadioChannel(10);
        assertEquals(0, radio.getCurrentRadioChannel());
    }

    @Test // Тест граничных значений
    public void shouldBoundaryMinRadioChannel() {
        radio.setCurrentRadioChannel(-1);
        assertEquals(9, radio.getCurrentRadioChannel());
    }

    @Test
    void shouldVolume() {
        radio.setCurrentVolume(0);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test // Тест увеличения громкости звука (+)
    public void shouldNextVolume() {
        radio.setCurrentVolume(7);
        radio.nextCurrentVolume();
        assertEquals(8, radio.getCurrentVolume());
    }

    @Test // Тест уменьшения громкости звука (-)
    public void shouldPrevVolume() {
        radio.setCurrentVolume(6);
        radio.prevCurrentVolume();
        assertEquals(5, radio.getCurrentVolume());
    }

    @Test // Тест max громкость звука
    public void shouldMaxVolume() {
        radio.setCurrentVolume(100);
        radio.nextCurrentVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test // Тест min громкость звука
    public void shouldMinVolume() {
        radio.setCurrentVolume(0);
        radio.prevCurrentVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test // Тест граничных значений
    public void shouldBoundaryMaxVolume() {
        radio.setCurrentVolume(101);
        radio.nextCurrentVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test // Тест граничных значений
    public void shouldBoundaryMinVolume() {
        radio.setCurrentVolume(-1);
        radio.prevCurrentVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test // Тест для радио с 10 станциями (с 0 по 9)
    public void setImpossibleRadioChannel() {
        int expectedRadioChannel = 0;
        radio.setCurrentRadioChannel(15);
        assertEquals(expectedRadioChannel, radio.getCurrentRadioChannel());
    }
}