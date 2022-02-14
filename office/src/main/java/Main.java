import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import org.apache.poi.xslf.usermodel.XMLSlideShow;

import javax.xml.crypto.Data;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: bq
 * @create: 2021-03-03 14:06
 */
public class Main {
    public static class MyTask extends TimerTask {
        @Override
        public void run() {
            Date dNow = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
            System.out.println(Thread.currentThread().getName() + ":" + dateFormat.format(dNow));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
//        Word2PDF word2PDF = new AsposeWord2PDF();
//        //Word2PDF word2PDF = new POIWord2PDF();
//        //word2PDF.convert("D:/1.doc", "D:/2.doc");
//
//        Timer timer = new Timer();
//        timer.schedule(new MyTask(), 0, 3000);
//        Thread.sleep(1000);
//        timer.schedule(new MyTask(), 0, 3000);
       // timer.schedule(new MyTask(), 0, 1000);

        XMLSlideShow ppt = new XMLSlideShow(new FileInputStream("D:\\令牌系统.pptx"));
        ppt.getSlides();
        System.out.println("haha");
    }
}
