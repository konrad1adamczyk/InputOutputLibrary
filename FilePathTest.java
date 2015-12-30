import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FilePathTest extends Tutor {

    @Test
    public void testPath() throws IOException {

        File targetFile = new File("test/phleem.txt");
        File parent = targetFile.getParentFile();
        if(!parent.exists() && !parent.mkdirs()){
            throw new IllegalStateException("Couldn't create dir: " + parent);
        }
        targetFile.createNewFile();

        System.out.println("Name: "+targetFile.getName());
        System.out.println("Path: "+targetFile.getPath());
        System.out.println("Absolute Path: "+targetFile.getAbsolutePath());
        try {

            System.out.println("Canonical Path: "+targetFile.getCanonicalPath());
        }
        catch(Exception e) {}

    }

}
	