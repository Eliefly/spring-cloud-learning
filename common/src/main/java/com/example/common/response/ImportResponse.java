package com.example.common.response;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

public class ImportResponse extends BaseResponse {
    private static final long serialVersionUID = -2874158069909233660L;
    private Long totalLines = Long.valueOf(0L);
    private Long errorLines = Long.valueOf(0L);
    private Map<String, Object> data = new HashMap();

    public Long getTotalLines() {
        return this.totalLines;
    }

    public void setTotalLines(Long totalLines) {
        this.totalLines = totalLines;
    }

    public void addTotalLines(Long lines) {
        this.totalLines = Long.valueOf(this.totalLines.longValue() + lines.longValue());
    }

    public Long getErrorLines() {
        return this.errorLines;
    }

    public void setErrorLines(Long errorLines) {
        this.errorLines = errorLines;
    }

    public void addErrorLines(Long lines) {
        this.errorLines = Long.valueOf(this.errorLines.longValue() + lines.longValue());
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}