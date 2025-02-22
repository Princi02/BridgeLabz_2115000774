import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;

public class FileProcessorTest {

    private final FileProcessor fileProcessor = new FileProcessor();
    private final String filename = "testFile.txt";
    private final String content = "Hello, JUnit File Testing!";

    @BeforeEach
    public void setup() {
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testWriteToFile() throws IOException {
        fileProcessor.writeToFile(filename, content);
        File file = new File(filename);
        assertTrue(file.exists(), "File should exist after writing");
    }

    @Test
    public void testReadFromFile() throws IOException {
        fileProcessor.writeToFile(filename, content);
        String readContent = fileProcessor.readFromFile(filename);
        assertEquals(content, readContent, "Content read should match content written");
    }

    @Test
    public void testFileNotFound() {
        assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistentFile.txt"));
    }

    @AfterEach
    public void cleanup() {
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
    }
}
