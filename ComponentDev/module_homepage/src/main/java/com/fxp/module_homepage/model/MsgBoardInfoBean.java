package com.fxp.module_homepage.model;

import java.util.List;

/**
 * Title:       MsgBoardInfoBean
 * <p>
 * Package:     com.fxp.module_homepage.model
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/16 下午3:23
 * <p>
 * Description: 留言板实体类
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/7/16    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class MsgBoardInfoBean {

    private int pageIndex;

    private int pageSize;

    private int msgNum;

    private int joinNum;

    private List<MsgInfo> msgInfos;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getMsgNum() {
        return msgNum;
    }

    public void setMsgNum(int msgNum) {
        this.msgNum = msgNum;
    }

    public int getJoinNum() {
        return joinNum;
    }

    public void setJoinNum(int joinNum) {
        this.joinNum = joinNum;
    }

    public List<MsgInfo> getMsgInfos() {
        return msgInfos;
    }

    public void setMsgInfos(List<MsgInfo> msgInfos) {
        this.msgInfos = msgInfos;
    }

    public class MsgInfo{

        private String msgId;

        private int msgIndex;

        private String msgCreateTime;

        private String msgCreateAddress;

        private String msgContent;

        private UserInfo msgUser;

        private int msgThumbNum;

        private int msgCommentNum;

        private List<ThumbInfo> thumbInfos;

        private List<CommentInfo> commentInfos;

        public String getMsgId() {
            return msgId;
        }

        public void setMsgId(String msgId) {
            this.msgId = msgId;
        }

        public int getMsgIndex() {
            return msgIndex;
        }

        public void setMsgIndex(int msgIndex) {
            this.msgIndex = msgIndex;
        }

        public String getMsgCreateTime() {
            return msgCreateTime;
        }

        public void setMsgCreateTime(String msgCreateTime) {
            this.msgCreateTime = msgCreateTime;
        }

        public String getMsgCreateAddress() {
            return msgCreateAddress;
        }

        public void setMsgCreateAddress(String msgCreateAddress) {
            this.msgCreateAddress = msgCreateAddress;
        }

        public String getMsgContent() {
            return msgContent;
        }

        public void setMsgContent(String msgContent) {
            this.msgContent = msgContent;
        }

        public UserInfo getMsgUser() {
            return msgUser;
        }

        public void setMsgUser(UserInfo msgUser) {
            this.msgUser = msgUser;
        }

        public int getMsgThumbNum() {
            return msgThumbNum;
        }

        public void setMsgThumbNum(int msgThumbNum) {
            this.msgThumbNum = msgThumbNum;
        }

        public int getMsgCommentNum() {
            return msgCommentNum;
        }

        public void setMsgCommentNum(int msgCommentNum) {
            this.msgCommentNum = msgCommentNum;
        }

        public List<ThumbInfo> getThumbInfos() {
            return thumbInfos;
        }

        public void setThumbInfos(List<ThumbInfo> thumbInfos) {
            this.thumbInfos = thumbInfos;
        }

        public List<CommentInfo> getCommentInfos() {
            return commentInfos;
        }

        public void setCommentInfos(List<CommentInfo> commentInfos) {
            this.commentInfos = commentInfos;
        }

        public class ThumbInfo{

            private String thumbId;

            private String thumbTime;

            private UserInfo thumbUser;

            public String getThumbId() {
                return thumbId;
            }

            public void setThumbId(String thumbId) {
                this.thumbId = thumbId;
            }

            public String getThumbTime() {
                return thumbTime;
            }

            public void setThumbTime(String thumbTime) {
                this.thumbTime = thumbTime;
            }

            public UserInfo getThumbUser() {
                return thumbUser;
            }

            public void setThumbUser(UserInfo thumbUser) {
                this.thumbUser = thumbUser;
            }
        }

        public class CommentInfo{

            private String commentId;

            private String commentTime;

            private String commentContent;

            private UserInfo commentUser;

            private UserInfo targetUser;

            public String getCommentId() {
                return commentId;
            }

            public void setCommentId(String commentId) {
                this.commentId = commentId;
            }

            public String getCommentTime() {
                return commentTime;
            }

            public void setCommentTime(String commentTime) {
                this.commentTime = commentTime;
            }

            public String getCommentContent() {
                return commentContent;
            }

            public void setCommentContent(String commentContent) {
                this.commentContent = commentContent;
            }

            public UserInfo getCommentUser() {
                return commentUser;
            }

            public void setCommentUser(UserInfo commentUser) {
                this.commentUser = commentUser;
            }

            public UserInfo getTargetUser() {
                return targetUser;
            }

            public void setTargetUser(UserInfo targetUser) {
                this.targetUser = targetUser;
            }
        }

        public class UserInfo{

            private String userId;

            private String userSex;

            private String userName;

            private String userPhoto;

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getUserSex() {
                return userSex;
            }

            public void setUserSex(String userSex) {
                this.userSex = userSex;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUserPhoto() {
                return userPhoto;
            }

            public void setUserPhoto(String userPhoto) {
                this.userPhoto = userPhoto;
            }
        }
    }

}
