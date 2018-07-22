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
        var projectHtml = "<h2>开源项目</h2><ul>";
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
        var blogHtml = "<h2>博客文章</h2><ul>";
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