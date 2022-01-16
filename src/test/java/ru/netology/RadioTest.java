package ru.netology;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {
    Radio radio = new Radio(1, 10, 10, 0, 100, 0);

    @ParameterizedTest
    @CsvSource({
            "станция < max, 9, 10",
            "станция = max, 10, 0",
            "станция > max, 11, 0"
    })
    public void shouldNextRadioStation(String name, int stationNumber, int expected) {
        radio.setStationNumber(stationNumber);
        radio.nextRadioStation();
        assertEquals(expected, radio.getStationNumber());
    }

    @ParameterizedTest
    @CsvSource({
            "станция > min, 5, 4",
            "станция = min, 0, 10",
            "станция < min, -1, 10"
    })
    public void shouldPrevRadioStation(String name, int stationNumber, int expected) {
        radio.setStationNumber(stationNumber);
        radio.prevRadioStation();
        assertEquals(expected, radio.getStationNumber());
    }

    @ParameterizedTest
    @CsvSource({
            "громкость < max, 5, 6",
            "громкость = max, 100, 100",
            "громкость > max, 101, 100"
    })
    public void shouldUpVolumeLevel(String name, int volumeLevel, int expected) {
        radio.setVolumeLevel(volumeLevel);
        radio.upVolumeLevel();
        assertEquals(expected, radio.getVolumeLevel());
    }

    @ParameterizedTest
    @CsvSource({
            "громкость > min, 5, 4",
            "громкость = min , 0, 0",
            "громкость < min, -1, 0"
    })
    public void shouldDownVolumeLevel(String name, int volumeLevel, int expected) {
        radio.setVolumeLevel(volumeLevel);
        radio.downVolumeLevel();
        assertEquals(expected, radio.getVolumeLevel());
    }

}