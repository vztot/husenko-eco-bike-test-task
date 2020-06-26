import com.ecobike.util.FileUtil;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileUtilTest {

    @Test
    public void read_Correctness() {
        List<String> expected = List.of("the", "quick", "brown", "fox", "jumps", "over", "the",
                "lazy", "dog");
        List<String> actual = FileUtil.read("src/test/resources/read_test.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void write_Correctness() {

    }

    @Test
    public void writeAppend_Correctness() {

    }
}
