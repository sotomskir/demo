package pl.sotomski.demo.rest.responses;

import lombok.Data;

@Data
public class GenerateIntegersResponse {
    private Long id;
    private String jsonrpc;
    private Result result;
}
