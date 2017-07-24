
import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import unittesting.UnitTestClassBase;

@RunWith(OctaneCucumber.class)
//@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"}/*, features="classpath:advantageStore.feature"*/)
public class GherkinTest extends UnitTestClassBase {

    public GherkinTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        //instance = new GherkinTest();
        globalSetup(GherkinTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws Exception {
    }
}
