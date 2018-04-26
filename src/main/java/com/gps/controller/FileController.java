package com.gps.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gps.dao.FileDao;
import com.gps.entity.File;
import com.gps.entity.FileType;
import com.gps.entity.User;
import com.gps.service.FileService;
import com.gps.util.GPSUtil;

@Controller
@RequestMapping(value="/user")
public class FileController {
	
	@Autowired
	private FileService fileService; 
	
	
	@RequestMapping(value="/fileList")
	public ModelAndView getFileList(HttpServletRequest request){
		List<File> fileList=fileService.getFiles();
		
		System.out.println(fileList.get(0).getFileName());
		request.setAttribute("fileList", fileList);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("fileList");
		return mv;
	}
	 
	@RequestMapping(value="/fileTypeList")
	public ModelAndView getFileTypeList(HttpServletRequest request){
		List<FileType> fileTypeList=fileService.getFileTypes();
		
		System.out.println(fileTypeList.get(0).getFileTypeName());
		request.setAttribute("fileTypeList", fileTypeList);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("fileTypeList");
		return mv;
	}
	//
	@RequestMapping(value="/showUpLoadFile")
	public ModelAndView showUpLoadFile(HttpServletRequest request)
	{
		List<FileType> fileTypeList=fileService.getFileTypes();
		System.out.println(fileTypeList.get(0).getFileTypeId());
		request.setAttribute("fileTypeList", fileTypeList);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("upLoadFile");
		return mv;
	}
	
	
	@RequestMapping(value="/uploadFile",method=RequestMethod.POST)
	public ModelAndView upLoadFile(HttpServletRequest request,@RequestParam("uploadfile")MultipartFile file,HttpSession session)
	{
		String fileName=request.getParameter("fileName");
		String description=request.getParameter("description");
		String fileTypeId=request.getParameter("fileTypeId");
		System.out.println(fileName);
		System.out.println(file);
		String path=request.getServletContext().getRealPath("/file/");
		String saveInfo=GPSUtil.saveFile(path,file);
		if("success".equals(saveInfo))
		{
			
			String fileUrl="/file/"+file.getOriginalFilename();
			File fileInfo=new File();
			fileInfo.setFileId(GPSUtil.getId());
			fileInfo.setFileName(fileName);
			fileInfo.setFileUrl(fileUrl);
			fileInfo.setFileType(fileTypeId);
			fileInfo.setCreateDate(new Date());
			User u=(User)session.getAttribute("user");
			fileInfo.setOperator(u.getUserId());
			fileInfo.setDescription(description);
			fileInfo.setSort(1);
			fileInfo.setStatus(1);
			fileService.saveFile(fileInfo);
			ModelAndView mv=new ModelAndView();
			mv.setViewName("upLoadFile");
			return mv;
		}else
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("upLoadFile");
			return mv;
		}
		
	}
	
	@RequestMapping(value="deleteFile")
	public String deleteFile(@RequestParam("fileId")String fileId)
	{
		fileService.deleteFile(fileId);
		return "forward:fileList";
	}
	
	@RequestMapping(value="deleteFileType")
	public String deleteFileType(@RequestParam("fileTypeId")String fileTypeId)
	{
		fileService.deleteFileType(fileTypeId);
		return "forward:fileTypeList";
	}
	
}
