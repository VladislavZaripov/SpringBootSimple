package com.zaripov.boot.joke;

import com.zaripov.boot.JokeApplication;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = JokeApplication.class,
        properties = {
                InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
                ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
        }
)
class RestJokeRetrieverTest {

    @Autowired
    JokeRetriever jokeRetriever;

    @Test
    public void getJoke(){
        JokeImportDTO result = jokeRetriever.getJoke();
        Assert.assertTrue(result.value.joke.contains("Chuck Norris"));
    }
}