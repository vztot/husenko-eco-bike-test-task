import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class EbikeDaoImplTest {
    @Test
    public void getAll_UsualCase() {
        Assert.assertEquals(List.of(Init.ebike1, Init.ebike2), Init.ebikeDao.getAll());
    }
}
