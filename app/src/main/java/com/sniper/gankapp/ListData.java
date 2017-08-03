package com.sniper.gankapp;

import java.util.List;

/**
 * Created by zhaohongru on 2017-08-03.
 * PackageName: com.sniper.gankapp.ListData
 * Description：
 */
public class ListData {


    /**
     * _id : 5980ad2d421aa90ca3bb6bcb
     * createdAt : 2017-08-02T00:32:45.223Z
     * desc : 三个优秀的Android图表开源控件
     * images : ["http://img.gank.io/c47351d0-7a13-4168-8504-0888482f786e"]
     * publishedAt : 2017-08-02T12:21:45.220Z
     * source : web
     * type : Android
     * url : http://blog.coderclock.com/2017/08/01/android/open-source-android-chart-library/
     * used : true
     * who : D_clock
     */

    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;
    private List<String> images;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
