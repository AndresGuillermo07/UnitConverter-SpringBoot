package com.unitConverter.service.weightService;

import com.unitConverter.unityEnums.WeightUnits;

public interface IWeightService {
    public String convert(double value, WeightUnits fromUnit, WeightUnits toUnit);
}
