package com.Tacos.Tacos.data;

import com.Tacos.Tacos.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {

}
