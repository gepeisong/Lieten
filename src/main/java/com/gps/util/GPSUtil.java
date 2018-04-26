package com.gps.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

public class GPSUtil {
	
	/**
	 * 获取md5加密后的字符串
	 * @author gepeisong
	 * @param passWord  传入要md5加密的密码
	 * @return 返回md5加密后的字符串
	 */
	public static String getMd5(String passWord)
	{
		String encodeStr=DigestUtils.md5Hex(passWord);
        System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        return encodeStr;
	}
	
	/**
	 * 获取唯一的id
	 * @return 返回唯一uuid
	 */
	public static String getId()
	{
		 String s = UUID.randomUUID().toString();
		 return s;
	}
	/**
	 * 
	 * @return
	 */
	public static String saveFile(String path,MultipartFile file)
	{
		System.out.println(path);
		String fileName=file.getOriginalFilename();
		File filepath = new File(path,fileName);
		if(file!=null)
		{
			  //判断路径是否存在，如果不存在就创建一个
	        if (!filepath.getParentFile().exists()) { 
	            filepath.getParentFile().mkdirs();
	        }
		        try {
					file.transferTo(new File(path + File.separator + fileName));
					return "success";
		        } catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					return "error";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					return "error";
				}
		}else
		{
			return "error";
		}
		
	}
	
	
	
	
	
	
}