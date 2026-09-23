package demoapp.controller;

import demoapp.service.ParService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ParController {

    @Autowired
    private ParService parService;

    @GetMapping("/comprobar-par")
    public String mostrarFormulario(NumeroData numeroData) {
        return "comprobar-par";
    }

    @PostMapping("/comprobar-par")
    public String procesarFormulario(@Valid NumeroData numeroData, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "comprobar-par";
        }
        boolean esPar = parService.esPar(numeroData.getNumero());
        model.addAttribute("numero", numeroData.getNumero());
        model.addAttribute("esPar", esPar);
        return "resultado-par";
    }
}