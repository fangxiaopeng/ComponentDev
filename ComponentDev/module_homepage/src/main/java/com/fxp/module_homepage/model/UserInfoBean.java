package com.fxp.module_homepage.model;

import java.util.List;

/**
 * Title:       UserInfoBean
 * <p>
 * Package:     com.fxp.module_homepage.model
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/11 下午7:15
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/7/11    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class UserInfoBean {

/*    {
        "user_name":"方晓鹏",
            "user_photo":"../images/img_user.jpg",
            "user_desc":"Android or Web? Of course all!",
            "user_nav":[
            {
                "name":"我的博客",
                    "link":"http://blog.csdn.net/fxp850899969"
            },
            {
                "name":"我的Github",
                    "link":"https://github.com/fangxiaopeng"
            },
            {
                "name":"我的微博",
                    "link":"#"
            }
        ]
    }*/

    private String user_name;

    private String user_photo;

    private String user_desc;

    private List<NavBean> user_nav;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public String getUser_desc() {
        return user_desc;
    }

    public void setUser_desc(String user_desc) {
        this.user_desc = user_desc;
    }

    public List<NavBean> getUser_nav() {
        return user_nav;
    }

    public void setUser_nav(List<NavBean> user_nav) {
        this.user_nav = user_nav;
    }

    public class NavBean{

        private String name;

        private String link;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

    }

}
