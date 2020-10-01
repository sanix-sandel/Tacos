package com.Tacos.Tacos.services;

import com.Tacos.Tacos.models.Taco;

import java.util.List;

public interface TacoService {

    List<Taco> findAll();
    Taco save(Taco taco);
}
