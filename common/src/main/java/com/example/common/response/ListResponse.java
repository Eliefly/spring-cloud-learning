package com.example.common.response;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class ListResponse<T> extends BaseResponse {
    private static final long serialVersionUID = -4862030606070066914L;
    private List<T> rows;
    //总记录数
    private long total;

    public List<T> getRows() {
        if (rows == null) {
            rows = new ArrayList<T>(0);
        }
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        if (rows != null) {
            total = rows.size();
        } else {
            total = 0L;
        }
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}