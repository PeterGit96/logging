package co.develhope.logging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BasicService {

    private static final Logger logger = LoggerFactory.getLogger(BasicService.class);

    public int calculatePow(int n1, int n2) {
        try{
            logger.debug("Starting pow calculation of {}^{}", n1, n2);
            int pow = (int) Math.pow(n1, n2);
            logger.debug("The result is {}", pow);
            return pow;
        } finally {
            logger.debug("Finished pow calculation");
        }
    }

}