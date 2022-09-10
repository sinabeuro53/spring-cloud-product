package com.example.springcloudproduct.core.common.utils;

import com.example.springcloudproduct.core.common.exception.StorageException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Slf4j
public class FileUtils {

    public static void createDir(String dir) {
        Path path = Paths.get(dir);
        if (!Files.exists(path)) {
            try {
                //Files.createDirectory(path);
                Files.createDirectories(path);
            } catch (IOException e) {
                throw new StorageException("Could not initialize storage", e);
            }
        }
    }

    public static void mkdir(String rootDir, String dir) {
        createDir(rootDir + dir);
    }

    public static String uniqueFileName(String fileName) {
        String fileBaseName = FilenameUtils.getBaseName(fileName);
        String fileExt = FilenameUtils.getExtension(fileName);
        StringBuffer name = new StringBuffer();
        int hashCode = (new Date()).hashCode();
        name.append(fileBaseName);
        name.append("_").append(Math.abs(hashCode));
        name.append(".").append(fileExt);
        return name.toString();
    }

    /**
     * 폴더 삭제
     * @param dir
     */
    public static void deleteFolder(String dir) {
        File folder = new File(Paths.get(dir).toString());

        if (folder.isDirectory()) {
            File[] fileList = folder.listFiles();

            for (File fileRow : fileList) {
                fileRow.delete();
            }

            folder.delete();
        }
    }

    /**
     * 파일 사이즈 구하기
     * @param filePath
     * @param fileNm
     * @return
     */
    public static long getFileSize(String filePath, String fileNm) {
        long fileSize = 0;

        if (StringUtils.isNotBlank(fileNm)) {
            File file = new File(Paths.get(filePath).resolve(fileNm).toString());

            if (file.exists() && file.isFile()) {
                fileSize = file.length();
            }
        }

        return fileSize;
    }
}
