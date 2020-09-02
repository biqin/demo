import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class StreamTest {
    public static void main(String[] args) throws IOException {
        inputStreamTest();
        outputStreamTest();
    }

    private static void inputStreamTest() throws IOException {
        System.out.println("inputStreamTest");

        try(FileInputStream inputStream = new FileInputStream("D:\\testInput.txt");) {
            byte[] tmp = new byte[2];
            int readNum = inputStream.read(tmp);
            System.out.println(readNum);
            System.out.println(new String(tmp));
        }

    }

    private static void outputStreamTest() throws IOException {
        System.out.println("outputStreamtest");

        String aa = "abc哈哈";
        System.out.println(Charset.defaultCharset());
        try (FileOutputStream outputStream = new FileOutputStream("D:\\testOutput.txt")) {
            outputStream.write(aa.getBytes());
            outputStream.close();
        }
    }
}
