/**
 * Author: fxp
 * Desc：使用art-template模板引擎渲染页面 
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
        var data = {
            dataSrc: "../data/userInfo.json",
            tplId: "art-header",
            containerId: "header"
        };
        this.rend(data);
    },
    rendProjectInfo: function () {
        var data = {
            dataSrc: "../data/projectInfo.json",
            tplId: "art-main_project",
            containerId: "main_project"
        };
        this.rend(data);
    },
    rendBlogInfo: function () {
        var data = {
            dataSrc: "../data/blogInfo.json",
            tplId: "art-main_blog",
            containerId: "main_blog"
        };
        this.rend(data);
    },
    rendAsideInfo: function () {
        var data = {
            dataSrc: "../data/asideInfo.json",
            tplId: "art-aside",
            containerId: "aside"
        };
        this.rend(data);
    },
    rendFooter: function () {
        var data = {
            dataSrc: "../data/footerInfo.json",
            tplId: "art-footer",
            containerId: "footer"
        };
        this.rend(data);
    },
    rend: function (data) {
        utils.get(data.dataSrc, function (res) {
            // console.log(res);
            var html = template(data.tplId, JSON.parse(res));
            document.getElementById(data.containerId).innerHTML = html;
        }, function (error) {
            console.log(error);
        });
    }
}

window.onload = function () {
    native.init();
}