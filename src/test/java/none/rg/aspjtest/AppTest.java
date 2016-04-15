package none.rg.aspjtest;

import org.junit.*;

public class AppTest {

    @Test
    public void test() {
        Assert.assertEquals(25, new App().sqr(5));
    }

}
