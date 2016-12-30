package com.example.dllo.project_a_section.Gift;

import java.util.List;

/**
 * Created by dllo on 16/12/9.
 */

public class HeadBean {

    /**
     * code : 200
     * data : {"cover_image":"http://img02.liwushuo.com/image/160909/3gnib47x3.png-w720","cover_url":"","cover_webp":"http://img02.liwushuo.com/image/160909/3gnib47x3.png?imageView2/2/w/720/q/85/format/webp","items":[],"paging":{"next_url":null},"share_url":"http://hawaii.liwushuo.com/ranks_v2/ranks/1"}
     * message : OK
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * cover_image : http://img02.liwushuo.com/image/160909/3gnib47x3.png-w720
         * cover_url :
         * cover_webp : http://img02.liwushuo.com/image/160909/3gnib47x3.png?imageView2/2/w/720/q/85/format/webp
         * items : []
         * paging : {"next_url":null}
         * share_url : http://hawaii.liwushuo.com/ranks_v2/ranks/1
         */

        private String cover_image;
        private String cover_url;
        private String cover_webp;
        private PagingBean paging;
        private String share_url;
        private List<?> items;

        public String getCover_image() {
            return cover_image;
        }

        public void setCover_image(String cover_image) {
            this.cover_image = cover_image;
        }

        public String getCover_url() {
            return cover_url;
        }

        public void setCover_url(String cover_url) {
            this.cover_url = cover_url;
        }

        public String getCover_webp() {
            return cover_webp;
        }

        public void setCover_webp(String cover_webp) {
            this.cover_webp = cover_webp;
        }

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public List<?> getItems() {
            return items;
        }

        public void setItems(List<?> items) {
            this.items = items;
        }

        public static class PagingBean {
            /**
             * next_url : null
             */

            private Object next_url;

            public Object getNext_url() {
                return next_url;
            }

            public void setNext_url(Object next_url) {
                this.next_url = next_url;
            }
        }
    }
}
