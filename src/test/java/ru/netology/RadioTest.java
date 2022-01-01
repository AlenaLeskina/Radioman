package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {
    Radio radio = new Radio();

    @Test
    public void shouldSetMaxNewStation() {
        Radio radio = new Radio(10);
        assertEquals(10, radio.getMaxStation());
    }

    @Test
    public void shouldIncreaseWithNewMaxStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(9);
        radio.nextCurrentStation();
        assertEquals(10, radio.getCurrentStation());
    }

    @Test
    public void shouldSetRequiredStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(4);
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseCurrentStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        radio.nextCurrentStation();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseCurrentStationIfLimit() {
        radio.setCurrentStation(10);
        radio.nextCurrentStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseCurrentStationIfOverLimit() {
        Radio radio = new Radio();
        radio.setCurrentStation(11);
        radio.nextCurrentStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldDecreaseCurrentStation() {
        radio.setCurrentStation(9);
        radio.prevCurrentStation();
        assertEquals(8, radio.getCurrentStation());

    }


    @Test
    public void shouldDecreaseCurrentStationIfLimit() {
        radio.setCurrentStation(0);
        radio.prevCurrentStation();
        assertEquals(10, radio.getCurrentStation());
    }

    @Test
    public void shouldDecreaseCurrentStationIfUnderLimit() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        radio.prevCurrentStation();
        assertEquals(10, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseCurrentVolume() {
        radio.setCurrentVolume(49);
        radio.increaseCurrentVolume();
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseCurrentVolumeIfOverLimit() {
        radio.setCurrentVolume(101);
        radio.increaseCurrentVolume();
        assertEquals(100, radio.getCurrentVolume());
    }


    @Test
    public void shouldDecreaseCurrentVolume() {
        radio.setCurrentVolume(55);
        radio.decreaseCurrentVolume();
        assertEquals(54, radio.getCurrentVolume());
    }


    @Test
    public void shouldDecreaseCurrentVolumeIfUnderLimit() {
        radio.setCurrentVolume(-1);
        radio.decreaseCurrentVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
}