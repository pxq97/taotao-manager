package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;
import org.springframework.core.type.classreading.MethodMetadataReadingVisitor;

import com.taotao.common.utils.FtpUtil;

public class FTPTest {

	@Test
	public void tedtFtpClient() throws Exception {
		//创建一个FtpClient对象
		FTPClient ftpClient = new FTPClient();
		//创建一个ftp链接,默认是21
		ftpClient.connect("192.168.182.129",21);
		//登录ftp服务器，使用用户名和密码
		ftpClient.login("ftpuser", "ftpuser");
		//上传文件
		//读取本地文件
		FileInputStream inputStream = new FileInputStream(new File("D:\\tt.jpg"));
		//设置上传的路径
		ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
		//修改上传文件的格式
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		//第一个参数：服务器端文档名
		//第二个参数：上传文档的inputStreamc
		ftpClient.storeFile("Hello1.jpg",inputStream);
		//关闭连接
		ftpClient.logout();
	}
	@Test
	public void testFtpUtil() throws Exception{
		FileInputStream inputStream = new FileInputStream(new File("D:\\tt.jpg"));
		FtpUtil.uploadFile("192.168.182.129", 21, "ftpuser", "ftpuser", "/home/ftpuser/www/images", "/2018/12/18", "Hello.jpg", inputStream);
	}
	
}

