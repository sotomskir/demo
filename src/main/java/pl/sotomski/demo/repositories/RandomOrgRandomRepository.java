package pl.sotomski.demo.repositories;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.sotomski.demo.services.RandomOrgService;

@AllArgsConstructor
@Repository
public class RandomOrgRandomRepository implements RandomRepository<Integer> {
    private final RandomOrgService client;

    @Override
    public Integer getOne() {
        return client.getInteger();
    }

    @Override
    public String getName() {
        return "random.org";
    }
}
