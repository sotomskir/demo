package pl.sotomski.demo.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sotomski.demo.config.ApplicationProperties;
import pl.sotomski.demo.rest.RandomOrgClient;
import pl.sotomski.demo.rest.requests.GenerateIntegersRequest;
import pl.sotomski.demo.rest.responses.GenerateIntegersResponse;

@Service
@AllArgsConstructor
public class RandomOrgService {
    private final RandomOrgClient client;
    private final ApplicationProperties applicationProperties;

    public Integer getInteger() {
        GenerateIntegersRequest request = new GenerateIntegersRequest();
        request.getParams().setApiKey(applicationProperties.getRandomOrg().getApiKey());
        request.getParams().setN(1);
        GenerateIntegersResponse response = client.generateIntegers(request);
        return response.getResult().getRandom().getData().get(0);
    }
}
