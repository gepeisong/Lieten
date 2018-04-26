package com.gps.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

public class GPSUtil {
	
	/**
	 * ��ȡmd5���ܺ���ַ���
	 * @author gepeisong
	 * @param passWord  ����Ҫmd5���ܵ�����
	 * @return ����md5���ܺ���ַ���
	 */
	public static String getMd5(String passWord)
	{
		String encodeStr=DigestUtils.md5Hex(passWord);
        System.out.println("MD5���ܺ���ַ���Ϊ:encodeStr="+encodeStr);
        return encodeStr;
	}
	
	/**
	 * ��ȡΨһ��id
	 * @return ����Ψһuuid
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
			  //�ж�·���Ƿ���ڣ���������ھʹ���һ��
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