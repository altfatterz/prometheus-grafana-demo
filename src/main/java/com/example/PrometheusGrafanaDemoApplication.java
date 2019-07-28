package com.example;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class PrometheusGrafanaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrometheusGrafanaDemoApplication.class, args);
    }
}


@RestController
class CustomerController {

    Random random = new Random();

    @GetMapping("/customers")
    public List<Customer> getCustomer() {
        if (random.nextBoolean()) {
            throw new IllegalStateException("something went wrong, opss!");
        }
        return Arrays.asList(Customer.builder().firstName("John").lastName("Doe").build());
    }

}

@Data
@Builder
class Customer {

    String firstName;
    String lastName;
}