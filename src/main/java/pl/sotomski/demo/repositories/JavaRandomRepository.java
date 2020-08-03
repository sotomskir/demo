package pl.sotomski.demo.repositories;

import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public class JavaRandomRepository implements RandomRepository<Integer> {
    private final Random random = new Random();

    @Override
    public Integer getOne() {
        return random.nextInt(10);
    }

    @Override
    public String getName() {
        return "java-random";
    }
}
