package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {
    Radio radio = new Radio();

    @Test
    public void shouldRadioChannelNumber() {

        radio.setCurrentRadioChannel(6);
        assertEquals(6, radio.getCurrentRadioChannel());
    }

    @Test   // Тест переключения следующего радиоканала
    public void shouldNextRadioChannel() {

        radio.setCurrentRadioChannel(8);
        radio.nextCurrentRadioChannel();
        assertEquals(9, radio.getCurrentRadioChannel());
    }

    @Test // Тест переключения предыдущего радиоканала
    public void shouldPrevRadioChannel() {

        radio.setCurrentRadioChannel(3);
        radio.prevCurrentRadioChannel();
        assertEquals(2, radio.getCurrentRadioChannel());
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

    @Test // Тест граничных значеий
    public void shouldRemoteMaxRadioChannel() {

        radio.setCurrentRadioChannel(10);
        assertEquals(0, radio.getCurrentRadioChannel());
    }

    @Test // Тест граничных значений
    public void shouldBoundaryMinRadioChannel() {

        radio.setCurrentRadioChannel(-1);
        assertEquals(9, radio.getCurrentRadioChannel());
    }

    @Test // Тест увеличения громкости звука (+)
    public void shouldNextVolume() {

        radio.setCurrentVolume(7);
        radio.plusVolume();
        assertEquals(8, radio.getCurrentVolume());
    }

    @Test // Тест уменьшения громкости звука (-)
    public void shouldPrevVolume() {

        radio.setCurrentVolume(6);
        radio.minusVolume();
        assertEquals(5, radio.getCurrentVolume());
    }

    @Test // Тест max громкость звука
    public void shouldMaxVolume() {

        radio.setCurrentVolume(10);
        radio.plusVolume();
        assertEquals(10, radio.getCurrentVolume());
    }

    @Test // Тест min громкость звука
    public void shouldMinVolume() {

        radio.setCurrentVolume(0);
        radio.minusVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test // Тест граничных значений
    public void shouldBoundaryMaxValue() {

        radio.setCurrentVolume(11);
        assertEquals(10, radio.getCurrentVolume());
    }

    @Test // Тест граничных значений
    public void shouldBoundaryMinValue() {

        radio.setCurrentVolume(-1);
        assertEquals(0, radio.getCurrentVolume());
    }
}