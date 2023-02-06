package sharedoffice.common;


import sharedoffice.MessageApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { MessageApplication.class })
public class CucumberSpingConfiguration {
    
}
