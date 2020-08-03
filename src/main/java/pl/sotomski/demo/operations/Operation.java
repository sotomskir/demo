package pl.sotomski.demo.operations;

import java.util.List;

public interface Operation {
    Integer combine(List<Integer> data);

    boolean supports(String operator);

    String getOperator();
}
