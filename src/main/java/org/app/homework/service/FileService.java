package org.app.homework.service;

import org.app.homework.model.File;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FileService {

  List<File> searchFilesByName(String fileName);

  List<File> getAllFiles();

  void addFile(File file);

}
