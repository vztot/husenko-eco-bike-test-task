import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class FoldingBikeDaoImplTest {
    @Test
    public void getAll_UsualCase() {
        Assert.assertEquals(List.of(Init.foldingBike1, Init.foldingBike2), Init.foldingBikeDao.getAll());
    }
}
