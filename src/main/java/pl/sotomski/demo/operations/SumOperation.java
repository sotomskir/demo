package pl.sotomski.demo.operations;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SumOperation implements Operation {
    @Override
    public Integer combine(List<Integer> data) {
        return data.stream().reduce(Integer::sum).orElse(0);
    }

    @Override
    public boolean supports(String operator) {
        return getOperator().equals(operator);
    }

    @Override
    public String getOperator() {
        return "sum";
    }
}
