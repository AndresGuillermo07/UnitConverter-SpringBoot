package com.unitConverter.service.weightService;

import com.unitConverter.unityEnums.WeightUnits;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WeightServiceImpl implements IWeightService {

    private static final Map<WeightUnits, Double> conversionsFactors = Map.of(
            WeightUnits.GRAM, 1.0,
            WeightUnits.MILLIGRAM, 1000.0,
            WeightUnits.KILOGRAM, 0.001,
            WeightUnits.OUNCE, 0.035274,
            WeightUnits.POUND, 0.00220462
    );


    @Override
    public String convert(double value, WeightUnits fromUnit, WeightUnits toUnit) {
        // Convertimos a gramos (unidad base)
        double baseValue = value / conversionsFactors.get(fromUnit);

        // Convertimos de gramos a la unidad deseada
        double result = baseValue * conversionsFactors.get(toUnit);

        return String.format("%.6f %s", result, toUnit.name()); // Formato con 6 decimales
    }
}
