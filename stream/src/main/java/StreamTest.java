import java.io.*;
import java.nio.charset.Charset;

public class StreamTest {
    public static void main(String[] args) throws IOException {
        //按字节
        inputStreamTest();
        outputStreamTest();

        //按字符
        readerTest();
        writerTest();

        //按字符，带缓存
        bufferedTest();
    }

    private static void bufferedTest() throws IOException {
        System.out.println("bufferedTest");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\testInput.txt"));) {
            char tmp[] = new char[12];
            int readNum = bufferedReader.read(tmp);
            System.out.println(readNum);
            System.out.println(new String(tmp));
            System.out.println(tmp.length);
        }
    }

    private static void readerTest() throws IOException {
        System.out.println("readerTest");

        try (FileReader fileReader = new FileReader("D:\\testInput.txt");) {
            char tmp[] = new char[12];
            int readNum = fileReader.read(tmp);
            System.out.println(readNum);
            System.out.println(new String(tmp));
            System.out.println(tmp.length);
        }
    }

    private static void inputStreamTest() throws IOException {
        System.out.println("inputStreamTest");

        try(FileInputStream inputStream = new FileInputStream("D:\\testInput.txt");) {
            byte[] tmp = new byte[8];
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
        }
    }

    private static void writerTest() throws IOException {
        System.out.println("outputStreamtest");

        String aa = "abc哈哈";
        System.out.println(Charset.defaultCharset());
        try (FileWriter writer = new FileWriter("D:\\testWriterOutput.txt")) {
            writer.write("尝试一下11");
        }
    }
}
