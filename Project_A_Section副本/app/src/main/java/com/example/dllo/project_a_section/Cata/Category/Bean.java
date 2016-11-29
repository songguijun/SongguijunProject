package com.example.dllo.project_a_section.Cata.Category;

/**
 * Created by dllo on 16/11/28.
 */

public class Bean {
    private String content;
    private int type ;

    public Bean(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public Bean setContent(String content) {
        this.content = content;
        return this;
    }

    public int getType() {
        return type;
    }

    public Bean setType(int type) {
        this.type = type;
        return this;
    }
}
