import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author: bq
 * @create: 2021-03-03 14:06
 */
public class Main {
    public static void main(String[] args) {
        Word2PDF word2PDF = new AsposeWord2PDF();
        //Word2PDF word2PDF = new POIWord2PDF();
        word2PDF.convert("D:/1.doc", "D:/2.doc");


    }
}
