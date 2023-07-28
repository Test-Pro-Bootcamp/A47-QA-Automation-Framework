import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@CucumberOptions(
            features= { "src/test/resources/features/Login.features"}

    )
   public class CucumberRunner extends AbstractTestNGCucumberTests {
    private TestNGCucmberRunner testNGCucmberRunner;
    @BeforeClass(alwaysRun = true)
    public void setUpCucumber(){
        testNGCucmberRunner=new TestNGCucumberRunner(this.getClass());
    }
    @DataProvider
    public Object[][] feature(){ return testNGCucmberRunner.provideScenarios();}
    @AfterClass
    public void tearDownClass(){ testNGCucmberRunner.finish();}


    }
