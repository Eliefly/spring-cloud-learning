package com.example.common.response;

import java.util.HashMap;
import java.util.Map;

public class DataResponse extends BaseResponse {
    private static final long serialVersionUID = 3041502940706093596L;
    private Map<String, Object> data = new HashMap();

    public Map<String, Object> getData() {
        return this.data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}