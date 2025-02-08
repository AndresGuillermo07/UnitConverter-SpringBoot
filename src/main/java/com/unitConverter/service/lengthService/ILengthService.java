package com.unitConverter.service.lengthService;

import com.unitConverter.unityEnums.LengthUnits;

public interface ILengthService {


    public String convert(double value, LengthUnits fromUnit, LengthUnits toUnit);

}
