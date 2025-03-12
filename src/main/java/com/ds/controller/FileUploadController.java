package com.ds.controller;/**
 * @author zhaoshengzhen
 * @date 2023-12-2915:42
 * @desc:
 **/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *@author zhaoshengzhen
 *@date 2023-12-2915:42
 *@desc:
 **/
@Controller
public class FileUploadController {
    @RequestMapping("/uploadfile")
    @ResponseBody
    public String uploadFile() {

        return "helloworld";
    }
}

