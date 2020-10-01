package com.Tacos.Tacos.data;

import com.Tacos.Tacos.models.Taco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends JpaRepository<Taco, Long> {

}
