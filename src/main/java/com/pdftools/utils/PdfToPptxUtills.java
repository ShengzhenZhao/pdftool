package com.pdftools.utils;
/**
 * @author zhaoshengzhen
 * @date 2023-12-2913:47
 * @desc:
 **/

import com.aspose.pdf.PptxSaveOptions;
import com.aspose.pdf.SaveFormat;
import com.aspose.pdf.Document;
import java.io.FileOutputStream;

/**
 *@author zhaoshengzhen
 *@date 2023-12-2913:47
 *@desc:
 **/
public class PdfToPptxUtills {
    //转ppt
    public static void pdf2ppt(String pdfPath) {
        long old = System.currentTimeMillis();
        try {
            String wordPath = pdfPath.substring(0, pdfPath.lastIndexOf(".")) + ".ppt";
            FileOutputStream os = new FileOutputStream(wordPath);
            Document doc = new Document(pdfPath);
            doc.save(os, SaveFormat.Pptx);
            os.close();
            long now = System.currentTimeMillis();
            System.out.println("Pdf 转 PPT 共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            System.out.println("Pdf 转 PPT 失败...");
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {
        String path = "D:\\360MoveData\\Users\\Administrator\\Desktop\\测试票据\\财政电子票据.pdf";
        pdf2ppt(path);
    }
}


