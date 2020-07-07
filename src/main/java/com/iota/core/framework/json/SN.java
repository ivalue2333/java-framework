package com.iota.core.framework.json;

import com.alibaba.fastjson.JSONObject;

public class SN {

    public static void main(String[] args) {
        String data = "{\"actionTime\":\"2020-07-03 16:47:21 246\",\"messageVer\":\"\",\"bizCode\":\"0040\",\"messageId\":\"cbe4632a-cb77-4e2b-bf55-c26eb0d36a2a\",\"messageOwner\":\"0e731793-ab02-4b9f-8e04-20d5895414e9\",\"content\":\"https://productpre.cnsuning.com/0070057494/761109409.html\"}";
        System.out.println(data);

        PublisherModel publisherModel = JSONObject.parseObject(data, PublisherModel.class);

        System.out.println(publisherModel);

        System.out.println(JSONObject.toJSONString(publisherModel));

    }

    public static class PublisherModel {
        private String messageID;
        private String actionTime;
        private String messageOwner;
        private String messageVer;
        private String BizCode;
        private String Content;
        private String platUserID;

        public String getMessageID() {
            return messageID;
        }

        public void setMessageID(String messageID) {
            this.messageID = messageID;
        }

        public String getActionTime() {
            return actionTime;
        }

        public void setActionTime(String actionTime) {
            this.actionTime = actionTime;
        }

        public String getMessageOwner() {
            return messageOwner;
        }

        public void setMessageOwner(String messageOwner) {
            this.messageOwner = messageOwner;
        }

        public String getMessageVer() {
            return messageVer;
        }

        public void setMessageVer(String messageVer) {
            this.messageVer = messageVer;
        }

        public String getBizCode() {
            return BizCode;
        }

        public void setBizCode(String bizCode) {
            BizCode = bizCode;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String content) {
            Content = content;
        }

        public String getPlatUserID() {
            return platUserID;
        }

        public void setPlatUserID(String platUserID) {
            this.platUserID = platUserID;
        }
    }
}
