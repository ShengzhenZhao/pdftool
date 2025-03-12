package com.ds.utils;
/**
 * @author zhaoshengzhen
 * @date 2023-12-2913:47
 * @desc:
 **/

import com.aspose.pdf.SaveFormat;
import com.aspose.pdf.Document;
import com.ds.domain.DsMessage;
import okhttp3.Response;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public static void main(String[] args) throws IOException {
        DsMessage dsMessage = new DsMessage();
        dsMessage.setContent("今天天气如何");
        dsMessage.setRole("user");
        List<DsMessage> list = new ArrayList<>();
        list.add(dsMessage);
        Response response = DeepSeekUtils.sendToDS(DeepSeekUtils.dsInit(list),"https://api.deepseek.com/chat/completions","Bearer sk-5f4e77c3ca4b45c1b23406a060439c1d");
        System.out.println(response.message());
    }
}


