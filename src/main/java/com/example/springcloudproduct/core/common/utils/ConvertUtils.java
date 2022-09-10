package com.example.springcloudproduct.core.common.utils;

public class ConvertUtils {

    public static Long[] StringArrayToLongArray(String[] stringArray) {

        Long[] result = new Long[stringArray.length];
        int idx = 0;
        for(String item : stringArray) {
            Long convertValue = 0L;
            try {
                convertValue = Long.valueOf(item);
            } catch (Exception e) {

            }
            result[idx++] = convertValue;
        }

        return result;
    }
}
