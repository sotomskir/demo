package pl.sotomski.demo.repositories;

public interface RandomRepository<T> {
    T getOne();

    String getName();
}
