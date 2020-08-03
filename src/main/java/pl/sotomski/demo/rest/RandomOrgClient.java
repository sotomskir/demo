package pl.sotomski.demo.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sotomski.demo.rest.requests.GenerateIntegersRequest;
import pl.sotomski.demo.rest.responses.GenerateIntegersResponse;

@FeignClient(url = "${application.random_org.url}/json-rpc/2/invoke", name = "random.org")
public interface RandomOrgClient {
    @RequestMapping(method = RequestMethod.POST)
    GenerateIntegersResponse generateIntegers(GenerateIntegersRequest request);
}
