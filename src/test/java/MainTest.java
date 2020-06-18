import com.ecobike.Main;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    @Test
    public void getGreetings_ConfirmThatDobkinSaid_True() {
        String expected = "Мы будем трудиться на благо города и всех харьковчан!";
        Assert.assertEquals("Мы не будем...", expected, new Main().getGreetings());
    }
}
