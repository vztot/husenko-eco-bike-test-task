import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class SpeedelecDaoImplTest {
    @Test
    public void getAll_UsualCase() {
        Assert.assertEquals(List.of(Init.speedelec1, Init.speedelec2), Init.speedelecDao.getAll());
    }
}
