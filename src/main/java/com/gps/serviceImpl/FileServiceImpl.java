package com.gps.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gps.dao.FileDao;
import com.gps.dao.FileTypeDao;
import com.gps.entity.File;
import com.gps.entity.FileType;
import com.gps.service.FileService;

@Service
public class FileServiceImpl implements FileService{

	@Autowired
	private FileDao fileDao;
	
	@Autowired
	private FileTypeDao fileTypeDao;

	public List<File> getFiles() {
		// TODO Auto-generated method stub
		return fileDao.getFiles();
	}

	public List<FileType> getFileTypes() {
		// TODO Auto-generated method stub
		return fileTypeDao.getFileTypes();
	}

	public void saveFile(File file) {
		// TODO Auto-generated method stub
		fileDao.saveFile(file);
	}

	public void deleteFile(String fileId) {
		// TODO Auto-generated method stub
		fileDao.deleteFileById(fileId);
	}

	public void deleteFileType(String fileTypeId) {
		// TODO Auto-generated method stub
		fileTypeDao.deleteFileTypeById(fileTypeId);
	}
	
	

}
