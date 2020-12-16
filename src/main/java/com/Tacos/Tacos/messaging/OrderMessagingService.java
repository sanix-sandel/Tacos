package com.Tacos.Tacos.messaging;

import com.Tacos.Tacos.DTO.OrderDto;
import com.Tacos.Tacos.models.Order;

public interface OrderMessagingService {

    void sendOrder(OrderDto order);
}
