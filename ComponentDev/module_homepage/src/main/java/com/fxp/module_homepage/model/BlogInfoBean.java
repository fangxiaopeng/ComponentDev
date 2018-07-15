package com.fxp.module_homepage.model;

import java.util.List;

/**
 * Title:       BlogInfoBean
 * <p>
 * Package:     com.fxp.module_homepage.model
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/15 下午6:07
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/7/15    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class BlogInfoBean {

    /*
    {
        "blog_address":"http://blog.csdn.net/fxp850899969",
            "article_list":[
            {
                "title":"海康摄像头监控视频播放详解",
                    "link":"http://blog.csdn.net/fxp850899969/article/details/79165941",
                    "desc":"本篇文章讲述的是基于海康SDK播放监控视频，包含以下几个方面：1，播放海康视频用到的API详解；2，播放海康视频实践过程详解；3，播放海康视频Cordova插件封装；"
            }
        ]
    }
    */

    private String blog_address;

    private List<BlogBean> article_list;

    public String getBlog_address() {
        return blog_address;
    }

    public void setBlog_address(String blog_address) {
        this.blog_address = blog_address;
    }

    public List<BlogBean> getArticle_list() {
        return article_list;
    }

    public void setArticle_list(List<BlogBean> article_list) {
        this.article_list = article_list;
    }

    public class BlogBean{

        private String title;

        private String link;

        private String desc;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

    }

}
