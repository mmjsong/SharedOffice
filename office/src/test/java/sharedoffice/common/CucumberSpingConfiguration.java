package sharedoffice.common;


import sharedoffice.OfficeApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { OfficeApplication.class })
public class CucumberSpingConfiguration {
    
}
