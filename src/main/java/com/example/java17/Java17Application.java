package com.example.java17;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.random.RandomGenerator;

@Slf4j
@SpringBootApplication
public class Java17Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Java17Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("My application started");

        //localVariable();
        //numberFormat();
        //textBlocks();
        //record();
        //pseudoRandom();

        log.info("My application finished");
    }

    /**
     * https://openjdk.org/projects/amber/guides/lvti-faq
     */
    private void localVariable() {
        int i = 0;
        log.info("i = {}", i);

        var j = 0;
        log.info("j = {}", j);

        //var k = null;
        //var k
    }

    private void numberFormat() {
        NumberFormat numberFormat = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
        log.info("formatted number = {}", numberFormat.format(1000));

        numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        log.info("formatted number = {}", numberFormat.format(1000));
    }

    /**
     * https://www.baeldung.com/java-text-blocks
     */
    private void textBlocks() {
        String textBlock = """
                With Spring Boot in your app, just a few lines of code is all you need to start building services like a boss.
                            
                            New to Spring? Try our simple quickstart guide.""";
        log.info(textBlock);
    }

    /**
     * https://www.baeldung.com/java-record-keyword
     */
    private void record() {
        Client client = new Client("Stefan", "Bertos", "stefan.bertos@gmail.com");
        log.info(client.toString());
    }

    private void pseudoRandom() {
        Random random = new Random();
        log.info("Random number = {}, {}, {}", random.nextInt(100), random.nextInt(100), random.nextInt(100));

        RandomGenerator randomGenerator = RandomGenerator.of("Xoroshiro128PlusPlus");
        log.info("Random number = {}, {}, {}", randomGenerator.nextInt(100), randomGenerator.nextInt(100), randomGenerator.nextInt(100));
    }

    public record Client(String firstname, String lastname, String email) {
    }
}
