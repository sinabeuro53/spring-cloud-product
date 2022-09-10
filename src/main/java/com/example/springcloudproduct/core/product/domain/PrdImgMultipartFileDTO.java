package com.example.springcloudproduct.core.product.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * packageName  :   com.example.backend.core.product.domain
 * fileName     :   PrdImgMultipartFileDTO
 * author       :   sinabeuro53
 * date         :   2022-03-20
 * description  :
 */
@Data
public class PrdImgMultipartFileDTO {

    /* 대표파일이미지 */
    private MultipartFile fileMainImg;

    /* 가로파일이미지 */
    private MultipartFile fileHztlImg;

    /* 세로파일이미지 */
    private MultipartFile fileVtclImg;

    /* 추가파일이미지 목록 */
    private List<MultipartFile> fileAddImgList;

}
