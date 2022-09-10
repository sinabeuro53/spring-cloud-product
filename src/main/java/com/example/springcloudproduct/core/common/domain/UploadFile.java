package com.example.springcloudproduct.core.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadFile {

	private String originalName;
	private String newName;
	private String fullPath;
	private String fileUrl;
	private byte[] fileSource;
	
}
