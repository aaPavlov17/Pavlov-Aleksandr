package org.app.homework.repository;

import org.app.homework.model.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FileRepository {

  Logger logger = LoggerFactory.getLogger(FileRepository.class);
  private final List<File> files = new ArrayList<>();

  public List<File> getAllFiles() {
    logger.info("getAllFiles called");
    return files;
  }

  public List<File> serchFileByName(String fileName) {
    List<File> foundedeFiles = new ArrayList<>();
    for (File file : files) {
      if (file.getFileName().contains(fileName)) {
        foundedeFiles.add(file);
        logger.info("foundedeFile: " + file);
        logger.info("file " + file + " has added to the list");
      }
    }
    return foundedeFiles;
  }

  public void addFile(File file) {
    files.add(file);
    logger.info("File: " + file.getFileName() + " added");
  }
}
