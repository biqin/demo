import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author: bq
 * @create: 2021-03-03 14:12
 */
public class AsposeWord2PDF implements Word2PDF{

    @Override
    public void convert(String inPath, String outPath) {
        try {
            if (!getLicense()) {
                throw new Exception("com.aspose.words lic ERROR!");
            }
            File file = new File(outPath);
            FileOutputStream os = new FileOutputStream(file);
            Document doc = new Document(inPath);
            doc.save(os, SaveFormat.PDF);// 全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF,EPUB, XPS, SWF 相互转换
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean getLicense() throws Exception {
        boolean result = false;
        try {
            InputStream is = new FileInputStream("D:\\Projects\\remote\\demo\\office\\word-license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }
}
