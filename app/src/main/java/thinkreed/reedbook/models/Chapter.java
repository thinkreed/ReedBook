package thinkreed.reedbook.models;

/**
 * Created by thinkreed on 2018/1/10.
 */

public class Chapter {

    /**
     * index : 3
     * url : https://www.biqu.la/book/MTAwMDM=/MTIxOTY1.html
     * title : 第四章 踏平部落
     */

    private int index;
    private String url;
    private String title;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
