package co.develhope.logging.controllers;

import co.develhope.logging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping
public class BasicController {

    @Autowired
    private BasicService basicService;

    @Autowired
    private Environment environment;

    private static final Logger logger = LoggerFactory.getLogger(BasicController.class);

    @GetMapping("/")
    public String welcome() {
        String welcomeMsg = "Hello, thanks for visiting us!";
        logger.info(welcomeMsg);
        return welcomeMsg;
    }

    @GetMapping("/exp")
    public Integer getPow() {
        int n1 = Integer.parseInt((Objects.requireNonNull(environment.getProperty("customEnvs.n1"))));
        int n2 = Integer.parseInt((Objects.requireNonNull(environment.getProperty("customEnvs.n2"))));
        return basicService.calculatePow(n1, n2);
    }

    @GetMapping("/get-errors")
    public void getError() {
        Error error = new Error("custom error");
        logger.error(error.getMessage());
        throw error;
    }

}