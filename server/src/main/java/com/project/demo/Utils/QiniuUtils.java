package com.project.demo.Utils;

/**
 * @Dexcription TODO
 * @Author：overthinker
 * @Package：com.project.demo.Utils
 * @Project：springboot流浪动物救助系统v2
 * @name：QiniuUtils
 * @Date：2024/1/24 17:11
 * @Filename：QiniuUtils
 */


import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.UUID;




public class QiniuUtils {
//    配置参数信息
    /**
     * AccessKey
     */
//    @Value("${oss.qiniu.accessKey}")
    private String accessKey = "WVDHmXtR_hMnQh-IgxYhXQ4kfVKlaARpPwsuIuKP";

    /**
     * SecretKey
     */
//    @Value("${oss.qiniu.secretKey}")
    private String secretKey = "xJ12yLgWHweBFkSUG0SV0YLaLcum-FeyQgV-508p";
    /**
     * 图片存储空间名
     */
//    @Value("${oss.qiniu.bucket}")
    private String bucket = "animal-escue-v2";

    /**
     * 文件外链
     */
//    @Value("${oss.qiniu.domain}")
    private String domain = "s7ra0both.hn-bkt.clouddn.com";




    //    实现将文件上传到oss
//    public Map<String, Object> upload(MultipartFile file) throws IOException {
    public String  uploadFile(MultipartFile file) throws IOException {
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        Configuration cfg = new Configuration(Region.huanan());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
//        读取配置文件的内容
//        获取上传的文件的输入流
        InputStream inputStream = file.getInputStream();
//        避免文件覆盖
        String originalFilename = file.getOriginalFilename();
//        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
//        String fileName = originalFilename;
        try {
            Response response = uploadManager.put(inputStream, null, upToken, null, null);
            if (response.isOK()) {
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                String fileUrl = domain + "/" + putRet.key;
                String fileQnName = putRet.key;
                return fileQnName;
            } else {
                throw new IOException("File upload failed: " + response.bodyString());
            }
        } catch (QiniuException e) {
            throw new IOException("File upload failed: " + e.getMessage(), e);
        }

    }



}