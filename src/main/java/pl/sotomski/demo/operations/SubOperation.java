package pl.sotomski.demo.operations;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubOperation implements Operation {
    @Override
    public Integer combine(List<Integer> data) {
        return data.stream().reduce((integer, integer2) -> integer - integer2).orElse(0);
    }

    @Override
    public boolean supports(String operator) {
        return getOperator().equals(operator);
    }

    @Override
    public String getOperator() {
        return "sub";
    }
}
