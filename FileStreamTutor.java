import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class FileStreamTutor {
    private static final String FILES_TEST_PATH = "files/test.txt";
    private static final String TEST_LINE = "test line";

    /**
     * Writes a string TEST_LINE to the file FILES_TEST_PATH ,
     * converting the string into array of bytes.
     * For the writing, use the class FileOutputStream.
     */
    public void writeToFile() {
        try (FileOutputStream outputStream = new FileOutputStream(FILES_TEST_PATH)){
            outputStream.write(TEST_LINE.getBytes());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Reads a line from a file and returns it using FileInputStream.
     * @return
     */
    public String readFromFile() {
        byte[] readArray = new byte[TEST_LINE.getBytes().length];
        try (FileInputStream outputStream = new FileInputStream(FILES_TEST_PATH)) {
            outputStream.read(readArray);
            String returning = new String(readArray);
            return returning;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void testFileStream() {
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
