package com.gennakersystems.linkedhub;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserQuery {
        private String mLogin;
        private String mName;
        private int mId;
        private String mAvatarUrl;
        private String mUrl;
        private String mHtmlUrl;
        private String mFollowersUrl;
        private String mFollowingUrl;
        private int mFollowers;
        private int mFollowing;
        private String mReposUrl;
        private String mDateAcctCreated;
        private String mDateAcctModified;

        public String getLogin() {
            return mLogin;
        }

        public void setLogin(String login) {
            mLogin = login;
        }

        public String getName() {
            return mName;
        }

        public void setName(String name) {
            mName = name;
        }

        public int getId() {
            return mId;
        }

        public void setId(int id) {
            mId = id;
        }

        public String getAvatarUrl() {
            return mAvatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            mAvatarUrl = avatarUrl;
        }

        public String getUrl() {
            return mUrl;
        }

        public void setUrl(String url) {
            mUrl = url;
        }

        public String getHtmlUrl() {
            return mHtmlUrl;
        }

        public void setHtmlUrl(String htmlUrl) {
            mHtmlUrl = htmlUrl;
        }

        public String getFollowersUrl() {
            return mFollowersUrl;
        }

        public void setFollowersUrl(String followersUrl) {
            mFollowersUrl = followersUrl;
        }

        public String getFollowingUrl() {
            return mFollowingUrl;
        }

        public void setFollowingUrl(String followingUrl) {
            mFollowingUrl = followingUrl;
        }

        public int getFollowers() {
            return mFollowers;
        }

        public void setFollowers(int followers) {
            mFollowers = followers;
        }

        public int getFollowing() {
            return mFollowing;
        }

        public void setFollowing(int following) {
            mFollowing = following;
        }

        public String getReposUrl() {
            return mReposUrl;
        }

        public void setReposUrl(String reposUrl) {
            mReposUrl = reposUrl;
        }

        public String getDateAcctCreated() {
            return mDateAcctCreated;
        }

// Causes a runtime error with OKHttp Dispatcher

//        public String getFormattedDateAcctCreated() {
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            Date dateCreated = new Date(getDateAcctCreated());
//            String dateString = formatter.format(dateCreated);
//
//            return dateString;
//        }

        public void setDateAcctCreated(String dateAcctCreated) {
            mDateAcctCreated = dateAcctCreated;
        }

        public String getDateAcctModified() {
            return mDateAcctModified;
        }

        public void setDateAcctModified(String dateAcctModified) {
            mDateAcctModified = dateAcctModified;
        }
    }