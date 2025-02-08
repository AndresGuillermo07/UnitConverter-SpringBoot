package com.unitConverter.service.temperatureService;

import com.unitConverter.unityEnums.TemperatureUnits;

public interface ITemperatureService {
    public String convert(double value, TemperatureUnits fromUnit, TemperatureUnits toUnit);

}
