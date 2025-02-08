package com.unitConverter.controller;

import com.unitConverter.service.lengthService.ILengthService;
import com.unitConverter.unityEnums.LengthUnits;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LengthController {

    private final ILengthService lengthConversions;

    public LengthController(ILengthService lengthConversions) {
        this.lengthConversions = lengthConversions;
    }

    @GetMapping("/length")
    public String length() {

        return "length";
    }

    @PostMapping("/convert")
    public String lengthResult(@RequestParam double value,
                               @RequestParam String fromUnit,
                               @RequestParam String toUnit,
                               Model model){


        String result = String.valueOf(lengthConversions.convert(
                value,
                LengthUnits.valueOf(fromUnit.toUpperCase()),
                LengthUnits.valueOf(toUnit.toUpperCase())));

        model.addAttribute("result", result);

        return "length";
    }


    @GetMapping("/")
    public String index() {
        return "redirect:/length";
    }

}
