import com.epam.main.Parser;
import org.testng.annotations.Test;
import static org.mockito.Mockito.*;

import javax.swing.text.Document;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by stycz0007 on 21.03.16.
 */
public class ParserTest {
    @Test
    public void testIfParserObjectCanBeCreated(){
        assertThat(new Parser("vitalio.pl")).isNotNull();
    }

    @Test
    public void testIfConnectionToFirstWebsiteIsEstablished(){


    }



}
