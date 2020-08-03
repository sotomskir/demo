package pl.sotomski.demo.rest.requests;

import lombok.Data;

@Data
public class GenerateIntegersParams {
    private String apiKey;
    private Integer n = 10;
    private Integer base = 10;
    private Integer min = 1;
    private Integer max = 10;
    private Boolean replacement = true;
}
