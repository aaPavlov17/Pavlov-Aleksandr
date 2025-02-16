package org.app.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.app.homework.model.File;
import org.app.homework.repository.FileRepository;
import org.app.homework.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

  Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);
  private final FileRepository fileRepository;

  @Override
  public List<File> getAllFiles() {
    if (fileRepository.getAllFiles().isEmpty()) {
      logger.info("There are no files in in your storage");
    } else {
      logger.info("found {} files", fileRepository.getAllFiles().size());
    }
    return fileRepository.getAllFiles();
  }

  @Override
  public List<File> searchFilesByName(String fileName) {
    if (fileRepository.serchFileByName("name").isEmpty()) {
      logger.info("There are no such files in in your storage");
    } else {
      logger.info("found {} file(s)", fileRepository.serchFileByName("name").size());
    }
    return fileRepository.serchFileByName(fileName);
  }

  @Override
  public void addFile(File file) {
    logger.info("file added successfully");
    fileRepository.addFile(file);
  }
}
