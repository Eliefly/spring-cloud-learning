/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.example.common.response;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Map;

public class MapResponse<K, V> extends BaseResponse {
    private static final long serialVersionUID = 5163794999339423159L;
    private Map<K, V> data;

    public Map<K, V> getData() {
        return this.data;
    }

    public void setData(Map<K, V> data) {
        this.data = data;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}