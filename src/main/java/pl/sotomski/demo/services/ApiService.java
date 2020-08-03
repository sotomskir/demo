package pl.sotomski.demo.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sotomski.demo.dto.RandomDTO;
import pl.sotomski.demo.exception.UnsupportedException;
import pl.sotomski.demo.operations.Operation;
import pl.sotomski.demo.repositories.RandomRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApiService {
    private final List<Operation> operations;
    private final List<RandomRepository<Integer>> repositories;

    public RandomDTO next(String operator, List<String> repositoriesFilter) {
        Operation operation = operations.stream()
            .filter(o -> o.supports(operator))
            .findFirst()
            .orElseThrow(() -> {
                List<String> supportedOperators = operations.stream().map(Operation::getOperator).collect(Collectors.toList());
                return new UnsupportedException("unsupported operator: " + operator + "; supported operators: " + supportedOperators);
            });

        List<Integer> data = repositoriesFilter.stream()
            .map(filter -> this.repositories.stream()
                .filter(repository -> filter.equals(repository.getName()))
                .findFirst()
                .orElseThrow(() -> {
                    List<String> supportedRepositories = repositories.stream().map(RandomRepository::getName).collect(Collectors.toList());
                    return new UnsupportedException("unsupported repository: " + filter + "; supported repositories: " + supportedRepositories);
                }))
            .parallel()
            .map(RandomRepository::getOne)
            .collect(Collectors.toList());
        return new RandomDTO(data, operation.combine(data));
    }
}
