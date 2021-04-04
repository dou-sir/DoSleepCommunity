package jit.dyy.dosleep.bean;

import jit.dyy.dosleep.dao.PostDAO;

import java.util.ArrayList;
import java.util.List;

public class PostPageBean {
    // 每页显示记录数
    private int pageSize = 10;
    // 当前页码
    private int pageNo = 1;
    // 总页数
    private int totalPages;
    // 每页数据记录集合
    private List<Post> pageData = new ArrayList<Post>();
    // 是否有下一页
    private boolean hasNextPage;
    // 是否有上一页
    private boolean hasPreviousPage;

    public PostPageBean() {
    }

    public PostPageBean(int pageSize, int pageNo) {
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalPages() {
        // 获取总记录数
        PostDAO dao = new PostDAO();
        int recordCount = dao.getRecordCount();
        // 获取并返回总页数
        return (recordCount + pageSize - 1) / pageSize;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Post> getPageData() {
        // 查询当页记录
        PostDAO dao = new PostDAO();
        List<Post> list = dao.getPostsByTime(pageNo, pageSize);
        return list;
    }
    public List<Post> getPageData2() {
        // 查询当页记录
        PostDAO dao = new PostDAO();
        List<Post> list = dao.getPostsByClout(pageNo, pageSize);
        return list;
    }

    public void setPageData(List<Post> pageData) {
        this.pageData = pageData;
    }

    public boolean isHasNextPage() {
        return (this.getPageNo() < this.getTotalPages());
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public boolean isHasPreviousPage() {
        return (this.getPageNo() > 1);
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }


}
