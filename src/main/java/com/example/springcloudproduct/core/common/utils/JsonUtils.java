package com.example.springcloudproduct.core.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;

public class JsonUtils {

	private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
	
	private final ObjectMapper objectMapper;

	private JsonUtils() {
		objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(MapperFeature.AUTO_DETECT_GETTERS, true);
		objectMapper.configure(MapperFeature.AUTO_DETECT_IS_GETTERS, true);
		objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
	}

	public static JsonUtils getInstance() {
		return new JsonUtils();
	}

	private static ObjectMapper getMapper() {
		return getInstance().objectMapper.registerModule(new JavaTimeModule());		// LocalDateTime 작렬화/역직렬화 해결;
	}

	public static String toJson(Object value) {
		try {
			return getMapper().writeValueAsString(value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static byte[] toJsonAsByte(Object value) {
		try {
			return getMapper().writeValueAsBytes(value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T fromJson(byte[] json, Class<T> cls) {
		try {
			return getMapper().readValue(json, cls);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T> T fromJson(String json, Class<T> cls) {
		try {
			// Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling...
			// Java 8에서 추가된 LocalDateTime 항목을 제대로 직렬화 또는 역직렬화를 못하는 현상
			// Jackson Datatype: JSR310 의존성을 추가해서 해결!
			return getMapper().readValue(json, cls);
		} catch (Exception e) {
			logger.warn("Json parsing is failed. origin_json={}", json);
			throw new RuntimeException(e);
		}
	}
	public static <T> T fromJson(BufferedReader json, TypeReference<T> typeReference) {
		try {
			return getMapper().readValue(json, typeReference);
		} catch (Exception e) {
			logger.warn("Json parsing is failed. origin_json={}", json);
			throw new RuntimeException(e);
		}
	}

	public static <T> T fromJson(String json, TypeReference<T> typeReference) {
		try {
			return getMapper().readValue(json, typeReference);
		} catch (Exception e) {
			logger.warn("Json parsing is failed. origin_json={}", json);
			throw new RuntimeException(e);
		}
	}

	public static String toPrettyJson(String value) {
		Object jsonObject = JsonUtils.fromJson(value, Object.class);
		try {
			return getMapper().writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}

}
