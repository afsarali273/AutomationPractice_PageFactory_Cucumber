package zuhlke;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.util.stream.Stream;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "classpath:zuhlke",
        plugin = {"pretty", "html:target/cucumber-html-report","json:cucumber.json"},
        tags = {},
        glue = "/zuhlke/stepDefinations")
public class RunTest {

    private static String[] defaultOptions = {
            "--plugin",
            "html:test_results/cucumber-reports",
            "--plugin",
            "junit:test_results/cucumber-reports/cucumber.xml",
            "--plugin",
            "pretty",
            "classpath:zuhlke",
            "--glue",
            "zuhlke.stepDefinations"
    };

    public static void main(String[] args) {

        String[] cucumberOptions =
                Stream.concat(Stream.of(defaultOptions), Stream.of(args)).toArray(String[]::new);

        io.cucumber.core.cli.Main.main(cucumberOptions);
    }

}
