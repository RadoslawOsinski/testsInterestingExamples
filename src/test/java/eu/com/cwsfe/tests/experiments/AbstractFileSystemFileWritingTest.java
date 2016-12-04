package eu.com.cwsfe.tests.experiments;

import com.google.common.collect.ImmutableList;
import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by Radoslaw Osinski.
 */
@RunWith(JUnit4.class)
public class AbstractFileSystemFileWritingTest {

    @Test
    public void testWrittenFile() throws IOException {
        //given
        FileSystem fs = Jimfs.newFileSystem(Configuration.unix());
        Path foo = fs.getPath("/foo");
        Files.createDirectory(foo);
        Path hello = foo.resolve("hello.txt"); // /foo/hello.txt
        String text = "hello world";

        //when
        Files.write(hello, ImmutableList.of(text), StandardCharsets.UTF_8);

        //then
        String fileContent = Files.lines(hello, StandardCharsets.UTF_8).collect(Collectors.joining(""));
        assertEquals(text, fileContent);
    }
}
