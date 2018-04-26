package com.gps.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gps.entity.File;
@Repository
public interface FileDao {
	List<File> getFiles();
	void saveFile(File file);
	void deleteFileById(String fileId);
}
