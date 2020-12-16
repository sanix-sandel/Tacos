package com.Tacos.Tacos.api;

import com.Tacos.Tacos.data.OrderRepository;
import com.Tacos.Tacos.data.TacoRepository;
import com.Tacos.Tacos.models.Order;
import com.Tacos.Tacos.models.Taco;
import com.Tacos.Tacos.services.TacoService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/rest/design", produces="application/json")
@CrossOrigin
public class DesignTacoRestController {
    private final TacoRepository tacorepository;
    private final OrderRepository orderRepository;
    EntityLinks entityLinks;

    public DesignTacoRestController(TacoRepository tacorepository, EntityLinks entityLinks,
                                    OrderRepository orderRepository) {
        this.tacorepository = tacorepository;
        this.entityLinks = entityLinks;
        this.orderRepository=orderRepository;
    }

    @GetMapping("/recent")
    public Iterable<Taco> recentTacos(){
        PageRequest page=PageRequest.of(
                0, 12, Sort.by("createdAt").descending()
        );

        return tacorepository.findAll(page).getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id){
        Optional<Taco> optTaco=tacorepository.findById(id);
        if(optTaco.isPresent()){
            return new ResponseEntity<Taco>(optTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco){
        return tacorepository.save(taco);
    }

    @PatchMapping(path="/{orderId}", consumes="application/json")
    public Order patchOrder(@PathVariable("orderId") Long orderId, @RequestBody Order patch){

        Order order = orderRepository.findById(orderId).get();

        if (patch.getCcNumber() != null) {
            order.setCcNumber(patch.getCcNumber());
        }
        if (patch.getCcExpiration() != null) {
            order.setCcExpiration(patch.getCcExpiration());
        }
        if (patch.getCcCVV() != null) {
            order.setCcCVV(patch.getCcCVV());
        }
        return orderRepository.save(order);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId){
        try{
            orderRepository.deleteById(orderId);

        }catch(EmptyResultDataAccessException e){}
    }
}
