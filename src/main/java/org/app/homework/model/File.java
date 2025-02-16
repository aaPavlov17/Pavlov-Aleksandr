package org.app.homework.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class File {

    private String fileName;
    private String filePath;
    private String fileType;

}
