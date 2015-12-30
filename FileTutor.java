import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileTutor {

    private File targetFile = new File("test/test.txt");
    /**
     * The method must create a folder and file test.txt inside it
     * - the file test/test.txt
     * Also, output in the full path to the log file you created
     */
    public void createFile() throws IOException {
        File parent = targetFile.getParentFile();
        if(!parent.exists() && !parent.mkdirs()){
            throw new IllegalStateException("Couldn't create dir: " + parent);
        }
        targetFile.createNewFile();


    }

    /**
     * This method should remove the folder and test file test / test.txt
     */


    public void deleteFile() throws IOException {

        File parent = targetFile.getParentFile();
        if(!parent.exists() && !parent.mkdirs()){
            throw new IllegalStateException("Couldn't create dir: " + parent);
        }
        boolean success = targetFile.createNewFile();
        success = targetFile.delete();
        success = parent.delete();

    }

    @Test
    public void testCreateFile() throws IOException  {
        createFile();
        File f = new File("test/test.txt");
        assertTrue(f.exists());
    }

    @Test
    public void testDeleteFile() throws IOException {
        deleteFile();
        File f = new File("test/test.txt");
        assertFalse(f.exists());
        assertFalse(new File("test").exists());
    }


}
