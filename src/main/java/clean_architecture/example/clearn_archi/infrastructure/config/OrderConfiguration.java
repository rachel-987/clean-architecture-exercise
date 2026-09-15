package clean_architecture.example.clearn_archi.infrastructure.config;

import clean_architecture.example.clearn_archi.application.gateway.OrderGateway;
import clean_architecture.example.clearn_archi.application.usecase.PlaceOrderUseCase;
import clean_architecture.example.clearn_archi.interfaceadapter.repository.InMemoryOrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfiguration {

    @Bean
    public OrderGateway orderGateway() {
        return new InMemoryOrderRepository();
    }

    @Bean
    public PlaceOrderUseCase placeOrderUseCase(
            OrderGateway orderGateway
    ) {
        return new PlaceOrderUseCase(orderGateway);
    }
}
