package com.fxp.module_homepage.model;

import java.util.List;

/**
 * Title:       ProjectInfoBean
 * <p>
 * Package:     com.fxp.module_homepage.model
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/15 上午11:47
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
public class ProjectInfoBean {

    /*
    {
        "github_address":"",
            "project_list":[
            {
                "title":"fxp-plugin-video",
                    "link":"https://github.com/fangxiaopeng/fxp-plugin-video",
                    "desc":"一款基于海康威视视频SDK的Cordova插件，用于播放海康监控视频，支持Android和IOS两个平台。功能如下：1，播放单路视频（支持指定通道）；2，播放单路/多路视频（自动适配单路/多路）；该插件已发布到npm。"
            }
        ]
    }
   */

    private String github_address;

    private List<ProjectBean> project_list;

    public String getGithub_address() {
        return github_address;
    }

    public void setGithub_address(String github_address) {
        this.github_address = github_address;
    }

    public List<ProjectBean> getProject_list() {
        return project_list;
    }

    public void setProject_list(List<ProjectBean> project_list) {
        this.project_list = project_list;
    }

    public class ProjectBean{

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
