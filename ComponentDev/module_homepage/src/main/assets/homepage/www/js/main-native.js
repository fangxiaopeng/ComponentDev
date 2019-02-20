/**
 * Author: fxp
 * Desc：使用原生js渲染页面
 * GitHub: https://github.com/fangxiaopeng
 */

var native = {
    init: function () {

        this.rendPage();

        this.bindEvent("on");
    },
    rendPage: function () {

        this.rendHead();

        this.rendUserInfo();

        this.rendProjectInfo();

        this.rendBlogInfo();

        this.rendMsgBoardInfo();

        this.rendAsideInfo();

        this.rendFooter();
    },
    bindEvent: function (method) {
        if (method == "on" || method == "off") {

        }
    },
    rendHead: function () {

    },
    rendUserInfo: function () {
        utils.get("../data/userInfo.json", function (res) {
            var html = native.buildUserBox(JSON.parse(res));
            document.getElementsByClassName("body-header")[0].innerHTML = html;
        }, function (error) {
            console.log(error);
        });
    },
    rendProjectInfo: function () {
        utils.get("../data/projectInfo.json", function (res) {
            var html = native.buildProjectBox(JSON.parse(res));
            document.getElementsByClassName("main-project")[0].innerHTML = html;
        }, function (error) {
            console.log(error);
        });
    },
    rendBlogInfo: function () {
        utils.get("../data/blogInfo.json", function (res) {
            var html = native.buildBlogBox(JSON.parse(res));
            document.getElementsByClassName("main-blog")[0].innerHTML = html;
        }, function (error) {
            console.log(error);
        });
    },
    rendMsgBoardInfo: function () {
        utils.get("../data/msgBoardInfo.json", function (res) {
            var html = native.buildMsgBoardBox(JSON.parse(res));
            document.getElementsByClassName("main-message")[0].innerHTML = html;
        }, function (error) {
            console.log(error);
        });
    },
    rendAsideInfo: function () {
        utils.get("../data/asideInfo.json", function (res) {
            var html = native.buildAsideBox(JSON.parse(res));
            document.getElementsByClassName("body-aside")[0].innerHTML = html;
        }, function (error) {
            console.log(error);
        });
    },
    rendFooter: function () {
        utils.get("../data/footerInfo.json", function (res) {
            var html = native.buildFooterBox(JSON.parse(res));
            document.getElementsByClassName("body-footer")[0].innerHTML = html;
        }, function (error) {
            console.log(error);
        });
    },
    buildUserBox: function (data) {
        var userPhotoHtml = "<img class='header-user_photo' src= '" + data.user_photo + "' alt='photo'/>";
        var userDescHtml = "<div class='header-user_info'>" +
            "<hgroup>" +
            "<h1 class='header-user_name'>" + data.user_name + "</h1>" +
            "<h5 class='header-user_desc'>" + data.user_desc + "</h5>" +
            "</hgroup>" +
            "</div>";
        var userNavHtml = "<nav class='header-nav'><ul class='nav-ul'>";
        for (var i = 0, len = data.user_nav.length; i < len; i++) {
            userNavHtml += "<li class='nav-li'><a href='" + data.user_nav[i].link + "'>" + data.user_nav[i].name + "</a></li>";
        }
        userNavHtml += "</ul></nav>";
        return userPhotoHtml + userDescHtml + userNavHtml;
    },
    buildAsideBox: function (data) {
        var asideHtml = "<div class='aside-code'>" +
            "<img class='aside-code-img' src='" + data.code_img + "'/>" +
            "<p class='aside-code-lable'>" + data.lable + "</p>" +
            "</div>"
        return asideHtml;
    },
    buildProjectBox: function (data) {
        var projectHtml = "<div class='module'>"+
        "<img class='module-icon' src='../images/icon_github.png'>"+
        "<span class='module-title'>开源项目</span></div><ul>";
        for (var i = 0, len = data.project_list.length; i < len; i++) {
            projectHtml += "<li>" +
                "<section>" +
                "<a href='" + data.project_list[i].link + "'>" +
                "<h2 class='overflow_omit'>" + data.project_list[i].title + "</h2>" +
                "<div class='overflow_omit'>" + data.project_list[i].desc + "</div>" +
                "</a>" +
                "</section>" +
                "</li>"
        }
        projectHtml += "</ul>";
        return projectHtml;
    },
    buildBlogBox: function (data) {
        var blogHtml = "<div class='module'>"+
        "<img class='module-icon' src='../images/icon_blog.png'>"+
        "<span class='module-title'>博客文章</span></div><ul>";
        for (var i = 0, len = data.article_list.length; i < len; i++) {
            blogHtml += "<li>" +
                "<section>" +
                "<a href='" + data.article_list[i].link + "'>" +
                "<h2 class='overflow_omit'>" + data.article_list[i].title + "</h2>" +
                "<div class='overflow_omit'>" + data.article_list[i].desc + " </div>" +
                "</a>" +
                "</section>" +
                "</li>"
        }
        blogHtml += "</ul><h3 class='main-view_more'><a href='" + data.blog_address + "'>查看更多</a></h3>";
        return blogHtml;
    },
    buildMsgBoardBox: function (data) {
        var msgBoardHtml = "<div class='module'>"+
        "<img class='module-icon' src='../images/icon_msg_board.png'>"+
        "<span class='module-title'>留言板</span></div>";

        msgBoardHtml += "<div class='msg-head'><div class='msg-title'><div class='line-v'></div><label>热门留言</label></div>" +
                "<div class='msg-desc'>" + 
                    "<label class='desc-num'>" + data.joinNum + "</label><label>人参与，</label>" +
                    "<label class='desc-num'>" + data.msgNum + "</label><label>人留言</label>" +
                "</div></div>" +
            "<div class='line-h'></div><ul class='msg-ul-outer'>";
            for(var i=0; i<data.msgInfos.length; i++){
                msgBoardHtml += "<li class='msg-li-outer'>" +
                    "<div>" +
                        "<img class='msg-user-photo' src='../images/photo_default_man.png'>"+
                        "<div class='msg-user-info'>"+
                            "<div>"+
                                "<span>" + data.msgInfos[i].msgUser.userName + "</span>"+
                                "<div class='f_r'>"+
                                    "<img src='../images/icon_like.png'><label>" + data.msgInfos[i].msgThumbNum + "</label>"+
                                    "<img src='../images/icon_comment.png'><label>" + data.msgInfos[i].msgCommentNum + "</label>"+
                                "</div>"+
                            "</div><div>"+
                                "<label>"+ data.msgInfos[i].msgCreateTime + "</label><label>" + data.msgInfos[i].msgCreateAddress + "</label>" +
                            "</div></div>" +
                    "</div>" +
                    "<div class='msg-content'>" + data.msgInfos[i].msgContent + "</div><ul class='msg-ul-inner'>";
                for(var j=0; j<data.msgInfos[i].commentInfos.length; j++){
                    msgBoardHtml += "<li class='msg-li-inner'><div>"+
                                "<div class='line-inner-v'></div>"+
                                "<label>" + data.msgInfos[i].commentInfos[j].commentUser.userName + "</label><span>回复</span><label>"
                                 + data.msgInfos[i].commentInfos[j].targetUser.userName + "</label>：<span>" + data.msgInfos[i].commentInfos[j].commentContent + "</span>"+
                            "</div></li>";
                }
                msgBoardHtml += "</ul>";
            }
            msgBoardHtml += "</ul>";
            
        msgBoardHtml += "<div class='main-message_input'><textarea placeholder='来说两句吧...' maxLength='60'></textarea></div>" +
            "<div class='main-message_publish'><label>发表留言</label></div>";
        return msgBoardHtml;
    },
    buildFooterBox: function (data) {
        var friendLinksHtml = "<aside class='footer-aside_link'><a>友情链接：</a>";
        for (var i = 0, len = data.friend_links.length; i < len; i++) {
            friendLinksHtml += "<a href='" + data.friend_links[i].link + "'>" + data.friend_links[i].name + "</a>";
            if (i != len - 1) {
                friendLinksHtml += "<span>|</span>";
            }
        }
        friendLinksHtml += "</aside>";
        var copyrightHtml = "<footer><p class='footer-copyright'>Copyright &copy; " + data.copyright + "</p></footer>";
        return friendLinksHtml + copyrightHtml;
    },
    rend: function (data) {

    }
}

window.onload = function () {
    native.init();
}