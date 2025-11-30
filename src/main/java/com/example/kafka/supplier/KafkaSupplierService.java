package com.example.kafka.supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.function.Supplier;
import java.util.Random;

@Service
public class KafkaSupplierService {

    private Random random = new Random();

    @Bean
    public Supplier<String> produceRandom() {
        return () -> "Random-" + random.nextInt(1000);
    }
}
