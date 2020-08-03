package pl.sotomski.demo.rest.responses;

import lombok.Data;

import java.util.List;

@Data
public class Random {
    private List<Integer> data;
    private String completionTime;
}
