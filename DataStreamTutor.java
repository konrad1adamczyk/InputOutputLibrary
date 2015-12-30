import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class DataStreamTutor extends Tutor {
    private static final String FILES_TEST_PATH = "files/test.txt";
    private static final String TEST_LINE = "test line";

    /**
     * Writes a string TEST_LINE to the file FILES_TEST_PATH, using
     * method writeUTF of class DataOutputStream.
     * Also use BufferedOutputStream for buffering.
     * Then close the stream.
     */
    public void writeToFile() {
    }

    /**
     * Reads a line from a file using the method readUTF and returns it.
     * @return
     */
    public String readFromFile() {
        return null;
    }

    @Test
    public void testStream() {
        writeToFile();
        String s = readFromFile();
        assertEquals(TEST_LINE, s);
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

}
