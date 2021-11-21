package com.zaripov.boot.joke;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@ShellComponent
public class ShellCommands {

    private final JokeRetriever jokeRetriever;
    private final JokeDataService jokeDataService;

    public ShellCommands(JokeRetriever jokeRetriever, JokeDataService jokeDataService) {
        this.jokeRetriever = jokeRetriever;
        this.jokeDataService = jokeDataService;
    }

    private String lastJoke;

    @ShellMethod("Say joke")
    public String joke(){
        lastJoke = jokeRetriever.getJoke().value.joke;
        return lastJoke;
    }

    @ShellMethod("Save last joke")
    public String save(){
        if (lastJoke!=null){
            jokeDataService.save(lastJoke);
            return "Save";
        }
        else return "You must download joke";
    }

    @ShellMethod("Show all jokes")
    public String show(){
        return jokeDataService.getAll().stream().collect(Collectors.joining(System.lineSeparator()));
    }

}