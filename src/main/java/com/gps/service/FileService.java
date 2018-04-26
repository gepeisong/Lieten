package com.gps.service;

import java.util.List;

import com.gps.entity.File;
import com.gps.entity.FileType;

public interface FileService {
	public List<File> getFiles();
	public List<FileType> getFileTypes();
	public void saveFile(File file);
	public void deleteFile(String fileId);
	public void deleteFileType(String fileTypeId);
}
