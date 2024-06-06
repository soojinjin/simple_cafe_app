package com.cookandroid.project_99;

public class GridViewItem {
    private int icon_menu;
    private String title_menu;
    private String price_menu;
    public void setIcon(int icon) {
        icon_menu = icon;
    }
    public void setPrice(String price) {
        price_menu = price;
    }
    public void setTitle(String title) {
        title_menu = title;
    }
    public int getIcon() { return this.icon_menu; }
    public String getTitle() {
        return this.title_menu;
    }
    public String getPrice() {
        return this.price_menu;
    }
}