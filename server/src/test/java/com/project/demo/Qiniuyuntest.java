package com.project.demo;

import com.project.demo.Utils.QiniuUtils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.mock.web.MockMultipartFile;



/**
 * @Dexcription TODO
 * @Author：overthinker
 * @Package：com.project.demo
 * @Project：springboot流浪动物救助系统v2
 * @name：Qiniuyuntest
 * @Date：2024/1/28 15:57
 * @Filename：Qiniuyuntest
 */

@SpringBootTest
public class Qiniuyuntest {

    @Test
    @DisplayName("测试七牛云上传文件")
    public void test1() throws IOException {
        String filePath = "J:/admin/OneDrive - MSFT/Desktop/wallhaven-0qo2r4_1920x1080.png";
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        String fileName = file.getName();
        MultipartFile multipartFile =  new MockMultipartFile(fileName, inputStream);
        QiniuUtils qiniuUtils = new QiniuUtils();
        String fileUrl = qiniuUtils.uploadFile(multipartFile);
        System.out.println(fileUrl);
    }


}
