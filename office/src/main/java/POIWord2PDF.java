import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

/**
 * @author: bq
 * @create: 2021-03-03 16:28
 */
public class POIWord2PDF implements Word2PDF{
    @Override
    public void convert(String inPath, String outPath) {
        try (InputStream is = new FileInputStream(new File(inPath));
             OutputStream out = new FileOutputStream(new File(outPath));) {
            XWPFDocument document = new XWPFDocument(is);
            PdfOptions options = PdfOptions.create();
            PdfConverter.getInstance().convert(document, out, options);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
