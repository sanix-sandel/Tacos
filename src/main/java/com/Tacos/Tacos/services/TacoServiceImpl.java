package com.Tacos.Tacos.services;

import com.Tacos.Tacos.data.TacoRepository;
import com.Tacos.Tacos.models.Taco;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TacoServiceImpl implements TacoService{

    private final TacoRepository tacoRepository;

    public TacoServiceImpl(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @Override
    public List<Taco> findAll(){
        List<Taco> tacos=new ArrayList<>();
        tacoRepository.findAll().iterator().forEachRemaining(tacos::add);
        return tacos;
    }

    @Override
    public Taco save(Taco taco){
        tacoRepository.save(taco);
        return taco;
    }
}
