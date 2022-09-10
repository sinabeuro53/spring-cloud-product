package com.example.springcloudproduct.core.common.controller;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

/**
 * packageName  :   com.example.backend.core.common
 * fileName     :   ImageController
 * author       :   sinabeuro53
 * date         :   2022-03-21
 * description  :
 */
@RestController
@RequestMapping("")
public class ImageController {
//    cdn/product
//    produces = MediaType.IMAGE_JPEG_VALUE

    @Value("${upload.web.url}")
    private String webUrl;

    @ResponseBody
    @GetMapping(value = "/file/{uploads}/{images}/{year}/{month}/{fileNm}",
            produces = {
            "image/bmp",
            "image/gif",
            "image/jpeg",
            "image/jpg",
            "image/png",
            "image/svg+xml",
            "image/tiff",
            "image/webp"
        }
    )
    public ResponseEntity<Resource>  getImageWithMediaType(
            @PathVariable("uploads") String uploads,
            @PathVariable("images") String images,
            @PathVariable("year") String year,
            @PathVariable("month") String month,
            @PathVariable("fileNm") String fileNm
    ) throws IOException {
        if(Objects.isNull(webUrl) || StringUtils.isBlank(webUrl)) {     // todo: 클라우드를 사용하면 저장경로를 바꿔야함
            webUrl = System.getProperty("user.dir");
        }

        StringBuffer sb = new StringBuffer();
        sb.append("/");
        sb.append(uploads);
        sb.append("/");
        sb.append(images);
        sb.append("/");
        sb.append(year);
        sb.append("/");
        sb.append(month);
        sb.append("/");
        sb.append(fileNm);
        String pathParam = sb.toString();
        String filePath = webUrl + pathParam;
        Path path = new File(filePath).toPath();
        FileSystemResource resource = new FileSystemResource(path);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(Files.probeContentType(path)))
                .body(resource);
    }

}
