import com.testasync.TestProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestProviderTest {

    @Before
    public void se11tUp() throws Exception {
        System.out.println("before");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("after");
    }

    @Test
    public void t1() {
        TestProvider testProvider = new TestProvider();
//        assertEquals(testProvider.t1(), 1);
    }

    @Test
    public void t2() {
    }
}