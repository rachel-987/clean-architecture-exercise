package clean_architecture.example.clearn_archi.interfaceadapter.controller;

import clean_architecture.example.clearn_archi.application.dto.PlaceOrderInput;
import clean_architecture.example.clearn_archi.application.dto.PlaceOrderOutput;
import clean_architecture.example.clearn_archi.application.usecase.PlaceOrderUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final PlaceOrderUseCase placeOrderUseCase;

    public OrderController(
            PlaceOrderUseCase placeOrderUseCase
    ) {
        this.placeOrderUseCase = placeOrderUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlaceOrderOutput create(
            @RequestBody PlaceOrderInput input
    ) {
        return placeOrderUseCase.execute(input);
    }
}