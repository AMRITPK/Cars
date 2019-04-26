package TestJunit;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestingParkingLotDS.class, TestingRegNumLotDS.class })
public class AllTests {

}
