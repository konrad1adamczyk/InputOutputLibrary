import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;

public class RandomAccessUTFTutor {

    private static final String FILES_TEST_PATH = "files/test.txt";

    /**
     * Write to the file FILES_TEST_PATH by path  2 lines UTF:
     * "Test line" and "test line 2"
     */
    public void randomAccessWriteUTF() {


    }

    /**
     * Jump to the second line of the UTF, using seek,
     * read and return its value
     * * @return
     */
    public String randomAccessReadUTF() {

        return null;

    }

    @Before
    public void createFile() {
        File f1 = new File(FILES_TEST_PATH);
        try {
            f1.delete();
            f1.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Test
    public void testRandomAccessUTF() throws UnsupportedEncodingException  {
        randomAccessWriteUTF();
        String s1 = null, s2 = null;
        try {
            RandomAccessFile f = new RandomAccessFile(FILES_TEST_PATH, "r");
            s1 = f.readUTF();
            s2 = f.readUTF();
            f.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        assertEquals("test line", s1);
        assertEquals("test line 2", s2);
        String read = randomAccessReadUTF();
        assertEquals("test line 2", read);
    }
}
