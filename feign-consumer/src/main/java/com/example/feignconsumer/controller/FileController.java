package com.example.feignconsumer.controller;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileController
 *
 * @author huangfl
 * @since 2018/5/16
 */
@Controller
public class FileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    /**
     * spring boot 下载文件
     *
     * @return
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> download() {

        String filename = "target.xlsx";
        String filePath = ResourceUtils.CLASSPATH_URL_PREFIX + "files" + File.separator + filename;
        LOGGER.debug("filePath: {}", filePath);
        File file = null;
        try {
            file = ResourceUtils.getFile(filePath);
        } catch (FileNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        //下载显示的文件名，解决中文名称乱码问题
//        String downloadFielName = null;
//        try {
//            downloadFielName = new String(filename.getBytes("UTF-8"), "iso-8859-1");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        LOGGER.debug("download file {}", file.getName());

        HttpHeaders headers = new HttpHeaders();
        //通知浏览器以attachment（下载方式）
        headers.setContentDispositionFormData("attachment", file.getName());
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        byte[] bytes = null;
        try {
            bytes = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
    }

}
