package com.zaripov.boot.joke;

import java.util.List;

public interface JokeDataService {

    void save(String joke);

    List<String> getAll();
}
