package com.unitConverter.service.lengthService;

import com.unitConverter.unityEnums.LengthUnits;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LengthServiceImpl implements ILengthService {

    private static final Map<LengthUnits, Double> conversionsFactors = Map.of(
            LengthUnits.METER, 1.0,
            LengthUnits.KILOMETER, 1000.0,
            LengthUnits.CENTIMETER, 0.01,
            LengthUnits.MILLIMETER, 0.001,
            LengthUnits.YARD, 0.9144,
            LengthUnits.INCH, 0.0254,
            LengthUnits.MILE, 1609.34,
            LengthUnits.FOOT, 0.30480
    );


    @Override
    public String convert(double value, LengthUnits fromUnit, LengthUnits toUnit) {

        double baseValue = value * conversionsFactors.get(fromUnit);

        return baseValue / conversionsFactors.get(toUnit) + " " + toUnit.name();
    }
}
