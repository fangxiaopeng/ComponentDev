package com.fxp.module_homepage.model;

import java.util.List;

/**
 * Title:       FooterInfo
 * <p>
 * Package:     com.fxp.module_homepage.model
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/15 下午8:06
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
public class FooterInfoBean {

    /*
    {
        "copyright":"2018 fxp",
            "friend_links":[
            {
                "name":"CSDN",
                    "link":"https://www.csdn.net/"
            }
        ]
    }
   */

    private String copyright;

    private List<FriendLink> friend_links;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<FriendLink> getFriend_links() {
        return friend_links;
    }

    public void setFriend_links(List<FriendLink> friend_links) {
        this.friend_links = friend_links;
    }

    public class FriendLink{


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
