package org.app.homework.Controller;

import lombok.RequiredArgsConstructor;
import org.app.homework.model.File;
import org.app.homework.service.impl.FileServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
public class FileController {

  private final FileServiceImpl fileServiceImpl;
  Logger logger = LoggerFactory.getLogger(FileController.class);

  @GetMapping("search_files/{fileName}")
  public List<File> searchFilesByName(@PathVariable String fileName) {
    logger.info("search files by name " + fileName);
    return fileServiceImpl.searchFilesByName(fileName);
  }

  @PostMapping("add_file")
  public void addFile(@RequestBody File file) {
    logger.info("file " + file + " has succesfully added");
    fileServiceImpl.addFile(file);
  }

  @GetMapping("all_files")
  public List<File> getAllFiles() {
    return fileServiceImpl.getAllFiles();
  }
}
