package com.gps.dao;

import java.util.List;

import com.gps.entity.FileType;

public interface FileTypeDao {
	List<FileType> getFileTypes();
	void deleteFileTypeById(String fileTypeId);
}
