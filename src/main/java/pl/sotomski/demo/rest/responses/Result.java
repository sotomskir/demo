package pl.sotomski.demo.rest.responses;

import lombok.Data;

@Data
public class Result {
    private Random random;
    private Long bitsUsed;
    private Long bitsLeft;
    private Long requestsLeft;
    private Long advisoryDelay;
}
