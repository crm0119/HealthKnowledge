package cn.edu.gdpt.healthknowledge;


import java.io.Serializable;

public class NewsBean implements Serializable {

    public String title;
    public String  name;
    public String  image;
    public String url;


    public NewsBean(String title, String name, String image, String url) {
        this.title = title;
        this.name = name;
        this.image = image;
        this.url=url;
    }

    public String getTitle() {
        return title;
    }



    public String getName() {
        return name;
    }



    public String getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }
}
