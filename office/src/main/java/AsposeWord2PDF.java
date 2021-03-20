import com.aspose.words.*;
import com.aspose.words.Font;

import java.awt.*;
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
            //DocumentBuilder builder = new DocumentBuilder(doc);
            PageSetup pageSetup = doc.getSections().get(0).getPageSetup();
//            pageSetup.setBorderAlwaysInFront(false);
            //pageSetup.setBorderDistanceFrom(PageBorderDistanceFrom.PAGE_EDGE);
//            pageSetup.setBorderAppliesTo(PageBorderAppliesTo.FIRST_PAGE);


            double oldHMarginSum = pageSetup.getLeftMargin() + pageSetup.getRightMargin();
            double oldVMarginSum = pageSetup.getTopMargin() + pageSetup.getBottomMargin();



            double newVMargin = pageSetup.getTopMargin();
            double newVMarginSum = newVMargin * 2;
            pageSetup.setLeftMargin(0);
            pageSetup.setRightMargin(0);
            pageSetup.setTopMargin(newVMargin);
            pageSetup.setBottomMargin(newVMargin);

            pageSetup.setPageWidth(pageSetup.getPageWidth() - oldHMarginSum);
            pageSetup.setPageHeight(pageSetup.getPageHeight() - oldVMarginSum + newVMarginSum);

//            pageSetup.setPageWidth();
//            pageSetup.setPageHeight();

//            Border border = pageSetup.getBorders().getByBorderType(BorderType.TOP);
//            border.setLineStyle(LineStyle.SINGLE);
//            border.setLineWidth(30.0);
//            border.setColor(Color.BLUE);
//            border.setDistanceFromText(0.0);
            doc.save(os, SaveFormat.DOC);// 全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF,EPUB, XPS, SWF 相互转换
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean getLicense() throws Exception {
        boolean result = false;
        try {
            InputStream is = new FileInputStream("D:\\project\\demo\\office\\word-license.xml");
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

