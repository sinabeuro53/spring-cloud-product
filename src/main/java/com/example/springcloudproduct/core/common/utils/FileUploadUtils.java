package com.example.springcloudproduct.core.common.utils;

import com.example.springcloudproduct.core.common.domain.UploadFile;
import com.example.springcloudproduct.core.common.exception.StorageException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * packageName  :   com.example.backend.core.common.utils
 * fileName     :   FileUploadUtils
 * author       :   sinabeuro53
 * date         :   2022-03-21
 * description  :
 */
@Service
@Slf4j
public class FileUploadUtils {
    @Value("${upload.web.url}")    // https://cdn.halfclub.com/
    private String webUrl;

    @Value("${upload.web.prefix}") // /uploads

    private String webDirPrefix;

    @Value("${upload.dirs.document}")
    private String document;

    @Value("${upload.dirs.images}")
    private String images;

    public UploadFile store(MultipartFile file, String oldDir, String oldFileNm, String uploadType) throws IOException {

        UploadFile uploadFile = null;
        FileOutputStream fos = null;
        if(Objects.isNull(uploadType) || StringUtils.isBlank(uploadType)) {
            uploadType = "files";
        }

        // 기존에 존재하는지 여부
        boolean isExist = true;
        if((Objects.isNull(oldDir) || StringUtils.isBlank(oldDir)) && (Objects.isNull(oldFileNm) || StringUtils.isBlank(oldFileNm))) {
            // 신규 등록
            isExist = false;
        }

        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
            }

            // step1. directory creation
            if(Objects.isNull(webUrl) || StringUtils.isBlank(webUrl)) {     // todo: 클라우드를 사용하면 저장경로를 바꿔야함
                webUrl = System.getProperty("user.dir");
            }

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM");    // yyyy/MM/dd
            String uploadDir = webDirPrefix + "/" + uploadType + "/" + formatter.format(new Date());
            String fullUploadDir = webUrl + uploadDir;
            FileUtils.mkdir("", fullUploadDir);


            // step2 file handling
            String newFileName = FileUtils.uniqueFileName(file.getOriginalFilename());
            uploadFile = new UploadFile(
                    file.getOriginalFilename(),
                    newFileName,
                    fullUploadDir + "/" + newFileName,  // fullPath
                    uploadDir + "/" + newFileName,        // fileUrl
                    file.getBytes()
            );


            // step3. save file
            // file local repository 에 저장
            // Files.copy(file.getInputStream(), Paths.get(fullUploadDir).resolve(uploadFile.getNewName()));
            fos = new FileOutputStream(uploadFile.getFullPath());
            fos.write(file.getBytes());

            // 기존에 파일이 존재하는 경우 로컬 디렉토리에서 삭제
            if(isExist) {
                this.deleteLocalFile(oldFileNm, oldDir);
            }

            return uploadFile;
        } catch (Exception e) {
            throw new StorageException("Failed to store file " + file.toString(), e);
        } finally {
            fos.close();
        }

    }

    public void deleteLocalFile(String fileNm, String fullPath) {
        try {
            File deleteFile = new File(fullPath);
            if(deleteFile.exists()) {
                deleteFile.delete();
            }
        } catch (Exception e) {
            throw new StorageException("Failed to delete file " + fileNm, e);
        }
    }
}
