package cucumber.options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/LibraryBookValidations.feature", glue = { "stepDefinations" })
public class LibraryTestRunner {
//,tags = "@DeletePlaceAPI"
}
