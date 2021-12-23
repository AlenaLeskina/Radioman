package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    @Test
    public void shouldSetTheDesiredStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(7);

        assertEquals(7, radio.getCurrentStation());
    }

    @Test
    public void shouldEnlargeStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.nextCurrentStation();

        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    public void shouldReduceStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(3);
        radio.prevCurrentStation();

        assertEquals(2, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseStationIfLimit() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.nextCurrentStation();

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldReduceStationIfLimit() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prevCurrentStation();

        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseTheStationOverTheLimit() {
        Radio radio = new Radio();
        radio.setCurrentStation(25);
        radio.nextCurrentStation();

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldReduceTheStationOverTheLimit() {
        Radio radio = new Radio();
        radio.setCurrentStation(-25);
        radio.prevCurrentStation();

        assertEquals(9, radio.getCurrentStation());
    }


    @Test
    public void shouldIncreaseSound() {
        Radio radio = new Radio();
        radio.setCurrentVolume(4);
        radio.increaseCurrentVolume();

        assertEquals(5, radio.getCurrentVolume());
    }

    @Test
    public void shouldReduceSound() {
        Radio radio = new Radio();
        radio.setCurrentVolume(7);
        radio.decreaseCurrentVolume();

        assertEquals(6, radio.getCurrentVolume());
    }

    @Test
    public void shouldSoundIncreaseOverTheLimit() {
        Radio radio = new Radio();
        radio.setCurrentVolume(11);
        radio.increaseCurrentVolume();

        assertEquals(10, radio.getCurrentVolume());
    }

    @Test
    public void shouldSoundReductionOverTheLimit() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);
        radio.decreaseCurrentVolume();

        assertEquals(0, radio.getCurrentVolume());
    }


}