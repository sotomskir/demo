package pl.sotomski.demo.rest.requests;

import lombok.Data;

@Data
public class GenerateIntegersRequest {
    private Long id = 13607L;
    private final String method = "generateIntegers";
    private final String jsonrpc = "2.0";
    private GenerateIntegersParams params = new GenerateIntegersParams();
}
