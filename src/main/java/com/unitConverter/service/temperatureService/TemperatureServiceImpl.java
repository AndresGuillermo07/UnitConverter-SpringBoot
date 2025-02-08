package com.unitConverter.service.temperatureService;

import com.unitConverter.unityEnums.TemperatureUnits;
import org.springframework.stereotype.Service;

@Service
public class TemperatureServiceImpl implements ITemperatureService{

    @Override
    public String convert(double value, TemperatureUnits fromUnit, TemperatureUnits toUnit) {

        double convertedValue = convertToCelsius(value, fromUnit);
        convertedValue = convertFromCelsius(convertedValue, toUnit);

        return String.valueOf(convertedValue);
    }

    private double convertToCelsius(double value, TemperatureUnits fromUnit) {
        return switch (fromUnit) {
            case CELSIUS -> value;
            case FAHRENHEIT -> (value - 32) * 5 / 9;
            case KELVIN -> value - 273.15;
        };
    }

    private double convertFromCelsius(double value, TemperatureUnits toUnit) {
        return switch (toUnit) {
            case CELSIUS -> value;
            case FAHRENHEIT -> (value * 9 / 5) + 32;
            case KELVIN -> value + 273.15;
        };
    }

}
