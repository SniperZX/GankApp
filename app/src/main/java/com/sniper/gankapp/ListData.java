package com.sniper.gankapp;

import java.util.List;

/**
 * Created by zhaohongru on 2017-08-03.
 * PackageName: com.sniper.gankapp.ListData
 * Description：
 */
public class ListData {


    /**
     * error : false
     * results : [{"_id":"598029be421aa90c9203d448","createdAt":"2017-08-01T15:11:58.619Z","desc":"Storybook 3.2 引入 Vue.js 支持","publishedAt":"2017-08-03T12:08:07.258Z","source":"chrome","type":"Android","url":"https://zhuanlan.zhihu.com/p/28239408","used":true,"who":"王下邀月熊"},{"_id":"59815d0b421aa90c9203d45c","createdAt":"2017-08-02T13:03:07.497Z","desc":"从零开始打造一个VR视频播放器","images":["http://img.gank.io/5feda1ac-7412-4d8c-bc33-dd8102d24c6a"],"publishedAt":"2017-08-03T12:08:07.258Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/c7a3b1acb8b1","used":true,"who":"麦田哥"},{"_id":"598176ac421aa90ca3bb6bd7","createdAt":"2017-08-02T14:52:28.638Z","desc":"Android 插件：统计资源文件中每个标签被引用的次数","publishedAt":"2017-08-03T12:08:07.258Z","source":"web","type":"Android","url":"https://github.com/niorgai/Android-Resource-Usage-Count","used":true,"who":"drakeet"},{"_id":"59826b11421aa97de5c7ca13","createdAt":"2017-08-03T08:15:13.671Z","desc":"Java 实现的 DHT 协议，其实就是  BitTorrent，可以轻松在 Android 上实现一个 P2P 下载了。","images":["http://img.gank.io/7f51af04-cf74-448e-ab85-1ddbcf70d22b"],"publishedAt":"2017-08-03T12:08:07.258Z","source":"chrome","type":"Android","url":"https://github.com/atomashpolskiy/bt","used":true,"who":"代码家"},{"_id":"59826c71421aa90ca209c54e","createdAt":"2017-08-03T08:21:05.222Z","desc":"一款实现的很漂亮的卡片式搜索效果","images":["http://img.gank.io/fd930531-4606-49b0-9130-b390e1436f9e"],"publishedAt":"2017-08-03T12:08:07.258Z","source":"chrome","type":"Android","url":"https://github.com/limuyang2/CardSearchView","used":true,"who":"Jude"},{"_id":"59827788421aa97de5c7ca18","createdAt":"2017-08-03T09:08:24.14Z","desc":"拆 JakeWharton 系列之 Picasso","publishedAt":"2017-08-03T12:08:07.258Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247486163&idx=1&sn=8449c537e5bc0238e0425966c48740d9&chksm=96cdab9ea1ba2288d9f6a860e054518f62555d31072d0a6a4d2ca551c45c20d2b60ff6e6028c&mpshare=1&scene=23&srcid=0803l0Vij7ZBI4UVKuscBHa7#rd","used":true,"who":"陈宇明"},{"_id":"59800ca7421aa90c9203d446","createdAt":"2017-08-01T13:07:51.118Z","desc":"Android高效安全的本地广播LocalBroadcast完全解析","publishedAt":"2017-08-02T12:21:45.220Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/6f1ea19a17ed","used":true,"who":"罗占伟"},{"_id":"59801646421aa90ca209c52f","createdAt":"2017-08-01T13:48:54.43Z","desc":"Rxjava2 做状态管理实现的redux库","publishedAt":"2017-08-02T12:21:45.220Z","source":"web","type":"Android","url":"https://github.com/Zeyad-37/RxRedux","used":true,"who":"瘦纸好过夏"},{"_id":"5980ad2d421aa90ca3bb6bcb","createdAt":"2017-08-02T00:32:45.223Z","desc":"三个优秀的Android图表开源控件","images":["http://img.gank.io/c47351d0-7a13-4168-8504-0888482f786e"],"publishedAt":"2017-08-02T12:21:45.220Z","source":"web","type":"Android","url":"http://blog.coderclock.com/2017/08/01/android/open-source-android-chart-library/","used":true,"who":"D_clock"},{"_id":"59811832421aa90ca209c53d","createdAt":"2017-08-02T08:09:22.422Z","desc":"在 React Native 环境下，运行一个 Node Server Http 服务。","images":["http://img.gank.io/e0273ca9-fef5-4fef-ba03-86d0e3b390d2"],"publishedAt":"2017-08-02T12:21:45.220Z","source":"chrome","type":"Android","url":"https://github.com/staltz/react-native-node","used":true,"who":"代码家"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 598029be421aa90c9203d448
         * createdAt : 2017-08-01T15:11:58.619Z
         * desc : Storybook 3.2 引入 Vue.js 支持
         * publishedAt : 2017-08-03T12:08:07.258Z
         * source : chrome
         * type : Android
         * url : https://zhuanlan.zhihu.com/p/28239408
         * used : true
         * who : 王下邀月熊
         * images : ["http://img.gank.io/5feda1ac-7412-4d8c-bc33-dd8102d24c6a"]
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
}
