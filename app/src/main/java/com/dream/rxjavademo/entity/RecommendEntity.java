package com.dream.rxjavademo.entity;

/**
 * Created by Administrator on 2018/3/25.
 */

public class RecommendEntity {

    /**
     * entity_id : 79
     * name : Baby Hat Cartoon Style Ear Knitted Caps for infant Boys Girls Children Winter Pink
     * price : 8.99
     * regular_price : 8.99
     * final_price : 8.99
     * off_percent : 0.00%
     * image_url : http://test.bigbuy.win/media/catalog/product/cache/1/small_image/150x/9df78eab33525d08d6e5fb8d27136e95/b/b/bb00560-03-1.jpg
     * wishlist_num : 0
     */

    private String entity_id;
    private String name;
    private String price;
    private String regular_price;
    private String final_price;
    private String off_percent;
    private String image_url;
    private int wishlist_num;

    public String getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(String entity_id) {
        this.entity_id = entity_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRegular_price() {
        return regular_price;
    }

    public void setRegular_price(String regular_price) {
        this.regular_price = regular_price;
    }

    public String getFinal_price() {
        return final_price;
    }

    public void setFinal_price(String final_price) {
        this.final_price = final_price;
    }

    public String getOff_percent() {
        return off_percent;
    }

    public void setOff_percent(String off_percent) {
        this.off_percent = off_percent;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getWishlist_num() {
        return wishlist_num;
    }

    public void setWishlist_num(int wishlist_num) {


        this.wishlist_num = wishlist_num;
    }

    @Override
    public String toString() {
        return "RecommendEntity{" +
                "entity_id='" + entity_id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", regular_price='" + regular_price + '\'' +
                ", final_price='" + final_price + '\'' +
                ", off_percent='" + off_percent + '\'' +
                ", image_url='" + image_url + '\'' +
                ", wishlist_num=" + wishlist_num +
                '}';
    }
}
