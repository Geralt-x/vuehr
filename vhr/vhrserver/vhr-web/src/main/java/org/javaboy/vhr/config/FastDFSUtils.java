package org.javaboy.vhr.config;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * FastDFS是一个开源的轻量级分布式文件系统，
 * 它对文件进行管理，功能包括：文件存储、文件同步、文件访问（文件上传、文件下载）等，
 * 解决了大容量存储和负载均衡的问题。特别适合以文件为载体的在线服务，如相册网站、视频网站等等。
 */
public class FastDFSUtils {
    private static StorageClient1 client1;

    static {
        try {
            ClientGlobal.initByProperties("fastdfs-client.properties");
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            client1 = new StorageClient1(trackerServer, null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static String upload(MultipartFile file) {
        String oldName = file.getOriginalFilename();
        try {
            return client1.upload_file1(file.getBytes(), oldName.substring(oldName.lastIndexOf(".") + 1), null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }

}
