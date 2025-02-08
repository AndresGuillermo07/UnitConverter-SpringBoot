package com.unitConverter.controller;

import com.unitConverter.service.temperatureService.ITemperatureService;
import com.unitConverter.unityEnums.TemperatureUnits;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TemperatureController {

    private final ITemperatureService temperatureService;

    public TemperatureController(ITemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping("/temperature")
    public String temperature(){
        return "temperature";
    }

    @PostMapping("/temperature")
    public String lengthResult(@RequestParam double value,
                               @RequestParam String fromUnit,
                               @RequestParam String toUnit,
                               Model model){


        String result = String.valueOf(temperatureService.convert(
                value,
                TemperatureUnits.valueOf(fromUnit.toUpperCase()),
                TemperatureUnits.valueOf(toUnit.toUpperCase())));

        model.addAttribute("result", result);
        model.addAttribute("toUnit", toUnit.toUpperCase());

        return "temperature";
    }

}
