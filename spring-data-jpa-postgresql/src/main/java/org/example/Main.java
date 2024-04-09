package org.example;

import org.example.model.Book;
import org.example.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    BookRepository bookRepository;

    @Bean
    @ConditionalOnProperty(prefix = "app", name = "db.init.enabled", havingValue = "true")
    public CommandLineRunner demoCommandLineRunner() {
        return args -> {
            LOGGER.info("Running.....");

            bookRepository.saveAll(List.of(
                new Book("Book A", BigDecimal.valueOf(9.99), LocalDate.of(2023, 8, 31)),
                new Book("Book B", BigDecimal.valueOf(19.99), LocalDate.of(2023, 7, 31)),
                new Book("Book C", BigDecimal.valueOf(29.99), LocalDate.of(2023, 6, 10)),
                new Book("Book D", BigDecimal.valueOf(39.99), LocalDate.of(2023, 5, 5))
            ));
        };
    }
}