package com.Tacos.Tacos.api;

import com.Tacos.Tacos.models.Taco;
import com.Tacos.Tacos.services.TacoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tacos")
public class TacoApi {

    private final TacoService tacoService;

    public TacoApi(TacoService tacoService) {
        this.tacoService = tacoService;
    }

    @GetMapping
    public List<Taco> getTacos(){
        List<Taco> tacos=tacoService.findAll();
        return tacos;
    }
}
