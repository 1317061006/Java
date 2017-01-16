package com.Test.entity;

/**
 * 分页参数的工具类,接收页面传来的分页参数
 */
public class PageUtil {

    private int limit = 2;
    private int offset = 1;
    private String order = "asc";
    private String ordername;
    private String search;
    private int stage = 0;//对应的阶段,作用于目录时,则为对应的目录id,用作用户时则为用户的id

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        if (search != null){
            search = "%"+search+"%";
        }
        this.search = search;
    }
}
