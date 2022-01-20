package ru.netology;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    Radio radio = new Radio();

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "10, 0",
            "-1, 0",
            "11, 1"
    })
    public void shouldPressNextStation(int stationNumber, int expected) {
        radio.setCurrentStation(stationNumber);
        radio.pressNextStation();
        assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 9",
            "0, 10"
    })
    public void shouldPressPrevStation(int stationNumber, int expected) {
        radio.setCurrentStation(stationNumber);
        radio.pressPrevStation();
        assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource({
            "101, 0",
            "-1, 100",
            "50, 50"
    })
    public void shouldSetCurrentVolume(int volumeLevel, int expected) {
        radio.setCurrentVolume(volumeLevel);
        assertEquals(expected, radio.getCurrentVolume());
    }


    @ParameterizedTest
    @CsvSource({
            "5, 6",
            "100, 0"
    })
    public void shouldPressVolumeUp(int volumeLevel, int expected) {
        radio.setCurrentVolume(volumeLevel);
        radio.pressVolumeUp();
        assertEquals(expected, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource({
            "5, 4",
            "0, 100"
    })
    public void shouldPressVolumeDown(int volumeLevel, int expected) {
        radio.setCurrentVolume(volumeLevel);
        radio.pressVolumeDown();
        assertEquals(expected, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "100, 99",
            "10, 9"
    })
    public void shouldCreateStationsWithLimits(int stationsLimit, int expected) {
        Radio radio = new Radio(stationsLimit);
        assertEquals(expected, radio.getMaxRadioStation());
    }
}