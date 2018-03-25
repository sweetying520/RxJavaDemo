package com.dream.rxjavademo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/3/9.
 */

public class ShopCartEntity  implements Serializable{

    /**
     * is_virtual : false
     * cart_items : [{"cart_item_id":"306","sku":"10WDS80100","currency":"USD","product_type":"simple","item_id":"175","item_title":"Tablet PCI Motherboard Analyzer Diagnostic Tester Post Test Card for PC Laptop Desktop PTI8","qty":7,"thumbnail_pic_url":"http://test.bigbuy.win/media/catalog/product/cache/1/thumbnail/250x/9df78eab33525d08d6e5fb8d27136e95/1/0/10wds80100-1.jpg","custom_option":[],"item_price":18.82}]
     * cart_items_count : 7
     * payment_methods : ["paypalec"]
     * allow_guest_checkout : true
     * symbol : $
     */

    private boolean is_virtual;
    private int cart_items_count;
    private boolean allow_guest_checkout;
    private String symbol;
    private List<CartItemsBean> cart_items;
    private List<String> payment_methods;

    public boolean isIs_virtual() {
        return is_virtual;
    }

    public void setIs_virtual(boolean is_virtual) {
        this.is_virtual = is_virtual;
    }

    public int getCart_items_count() {
        return cart_items_count;
    }

    public void setCart_items_count(int cart_items_count) {
        this.cart_items_count = cart_items_count;
    }

    public boolean isAllow_guest_checkout() {
        return allow_guest_checkout;
    }

    public void setAllow_guest_checkout(boolean allow_guest_checkout) {
        this.allow_guest_checkout = allow_guest_checkout;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<CartItemsBean> getCart_items() {
        return cart_items;
    }

    public void setCart_items(List<CartItemsBean> cart_items) {
        this.cart_items = cart_items;
    }

    public List<String> getPayment_methods() {
        return payment_methods;
    }

    public void setPayment_methods(List<String> payment_methods) {
        this.payment_methods = payment_methods;
    }

    public static class CartItemsBean {
        /**
         * cart_item_id : 306
         * sku : 10WDS80100
         * currency : USD
         * product_type : simple
         * item_id : 175
         * item_title : Tablet PCI Motherboard Analyzer Diagnostic Tester Post Test Card for PC Laptop Desktop PTI8
         * qty : 7
         * thumbnail_pic_url : http://test.bigbuy.win/media/catalog/product/cache/1/thumbnail/250x/9df78eab33525d08d6e5fb8d27136e95/1/0/10wds80100-1.jpg
         * custom_option : []
         * item_price : 18.82
         */

        private String cart_item_id;
        private String sku;
        private String currency;
        private String product_type;
        private String item_id;
        private String item_title;
        private int qty;
        private String thumbnail_pic_url;
        private double item_price;
        private List<?> custom_option;

        public String getCart_item_id() {
            return cart_item_id;
        }

        public void setCart_item_id(String cart_item_id) {
            this.cart_item_id = cart_item_id;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getProduct_type() {
            return product_type;
        }

        public void setProduct_type(String product_type) {
            this.product_type = product_type;
        }

        public String getItem_id() {
            return item_id;
        }

        public void setItem_id(String item_id) {
            this.item_id = item_id;
        }

        public String getItem_title() {
            return item_title;
        }

        public void setItem_title(String item_title) {
            this.item_title = item_title;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public String getThumbnail_pic_url() {
            return thumbnail_pic_url;
        }

        public void setThumbnail_pic_url(String thumbnail_pic_url) {
            this.thumbnail_pic_url = thumbnail_pic_url;
        }

        public double getItem_price() {
            return item_price;
        }

        public void setItem_price(double item_price) {
            this.item_price = item_price;
        }

        public List<?> getCustom_option() {
            return custom_option;
        }

        public void setCustom_option(List<?> custom_option) {
            this.custom_option = custom_option;
        }
    }
}
