package com.sniper.gankapp.data;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by zhaohongru on 2017-08-04.
 * PackageName: com.sniper.gankapp.data.Result
 * Description：
 */
public class Result {


    /**
     * _id : 59826b11421aa97de5c7ca13
     * createdAt : 2017-08-03T08:15:13.671Z
     * desc : Java 实现的 DHT 协议，其实就是  BitTorrent，可以轻松在 Android 上实现一个 P2P 下载了。
     * images : ["http://img.gank.io/7f51af04-cf74-448e-ab85-1ddbcf70d22b"]
     * publishedAt : 2017-08-03T12:08:07.258Z
     * source : chrome
     * type : Android
     * url : https://github.com/atomashpolskiy/bt
     * used : true
     * who : 代码家
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

    public static Result objectFromData(String str) {

        return new Gson().fromJson(str, Result.class);
    }

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
