package com.dream.rxjavademo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/3/9.
 */

public class ShopCartEntity implements Serializable{
    private boolean isSelect;
    /**
     * code : 0
     * msg : null
     * model : {"is_virtual":false,"cart_items":[{"cart_item_id":"275","sku":"QC03964","currency":"USD","product_type":"simple","item_id":"265","item_title":"Pair of T10 5050 W5w 501 Remote Control Car LED Bulb 6 SMD Multicolor Side Light Bulbs","qty":1,"thumbnail_pic_url":"http://test.bigbuy.win/media/catalog/product/cache/1/thumbnail/250x/9df78eab33525d08d6e5fb8d27136e95/q/c/qc03964-13.jpg","custom_option":[],"item_price":9.99},{"cart_item_id":"276","sku":"JM00339-01","currency":"USD","product_type":"simple","item_id":"109","item_title":"Lady Eyeliner Pencil Waterproof Long Lasting Eye Liner Pen Make Up Beauty Tool (Black)      ","qty":1,"thumbnail_pic_url":"http://test.bigbuy.win/media/catalog/product/cache/1/thumbnail/250x/9df78eab33525d08d6e5fb8d27136e95/j/m/jm00339-3_1024x1024.jpg","custom_option":[],"item_price":11.69}],"cart_items_count":2,"payment_methods":[],"allow_guest_checkout":true,"symbol":"$"}
     */

    private int code;
    private Object msg;
    private ModelBean model;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public ModelBean getModel() {
        return model;
    }

    public void setModel(ModelBean model) {
        this.model = model;
    }


    public static class ModelBean {
        /**
         * is_virtual : false
         * cart_items : [{"cart_item_id":"275","sku":"QC03964","currency":"USD","product_type":"simple","item_id":"265","item_title":"Pair of T10 5050 W5w 501 Remote Control Car LED Bulb 6 SMD Multicolor Side Light Bulbs","qty":1,"thumbnail_pic_url":"http://test.bigbuy.win/media/catalog/product/cache/1/thumbnail/250x/9df78eab33525d08d6e5fb8d27136e95/q/c/qc03964-13.jpg","custom_option":[],"item_price":9.99},{"cart_item_id":"276","sku":"JM00339-01","currency":"USD","product_type":"simple","item_id":"109","item_title":"Lady Eyeliner Pencil Waterproof Long Lasting Eye Liner Pen Make Up Beauty Tool (Black)      ","qty":1,"thumbnail_pic_url":"http://test.bigbuy.win/media/catalog/product/cache/1/thumbnail/250x/9df78eab33525d08d6e5fb8d27136e95/j/m/jm00339-3_1024x1024.jpg","custom_option":[],"item_price":11.69}]
         * cart_items_count : 2
         * payment_methods : []
         * allow_guest_checkout : true
         * symbol : $
         */

        private boolean is_virtual;
        private int cart_items_count;
        private boolean allow_guest_checkout;
        private String symbol;
        private List<CartItemsBean> cart_items;
        private List<?> payment_methods;

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

        public List<?> getPayment_methods() {
            return payment_methods;
        }

        public void setPayment_methods(List<?> payment_methods) {
            this.payment_methods = payment_methods;
        }

        public static class CartItemsBean {
            /**
             * cart_item_id : 275
             * sku : QC03964
             * currency : USD
             * product_type : simple
             * item_id : 265
             * item_title : Pair of T10 5050 W5w 501 Remote Control Car LED Bulb 6 SMD Multicolor Side Light Bulbs
             * qty : 1
             * thumbnail_pic_url : http://test.bigbuy.win/media/catalog/product/cache/1/thumbnail/250x/9df78eab33525d08d6e5fb8d27136e95/q/c/qc03964-13.jpg
             * custom_option : []
             * item_price : 9.99
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
            private List<CustomOptionBean> custom_option;

            public static class CustomOptionBean{
                private String label;
                private String value;

                public String getLabel() {
                    return label;
                }

                public void setLabel(String label) {
                    this.label = label;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

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

            public List<CustomOptionBean> getCustom_option() {
                return custom_option;
            }

            public void setCustom_option(List<CustomOptionBean> custom_option) {
                this.custom_option = custom_option;
            }
        }
    }
}
