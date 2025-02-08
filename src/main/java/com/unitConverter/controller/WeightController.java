package com.unitConverter.controller;

import com.unitConverter.service.weightService.IWeightService;
import com.unitConverter.unityEnums.WeightUnits;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeightController {

    private final IWeightService weightConversions;

    public WeightController(IWeightService weightConversions) {
        this.weightConversions = weightConversions;
    }

    @GetMapping("/weight")
    public String weight() {
        return "weight";
    }

    @PostMapping("/weight")
    public String lengthResult(@RequestParam double value,
                               @RequestParam String fromUnit,
                               @RequestParam String toUnit,
                               Model model){

        String result = String.valueOf(weightConversions.convert(
                value,
                WeightUnits.valueOf(fromUnit.toUpperCase()),
                WeightUnits.valueOf(toUnit.toUpperCase())));

        model.addAttribute("result", result);

        return "weight";
    }



}
