package com.Tacos.Tacos.data;

import com.Tacos.Tacos.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
