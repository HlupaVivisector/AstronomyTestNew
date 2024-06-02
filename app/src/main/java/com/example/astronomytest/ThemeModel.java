package com.example.astronomytest;

class ThemeModel {
    String themeNames, themeDescription;

    int image;

    public ThemeModel(String themeNames, String themeDescription, int image) {
        this.themeNames = themeNames;
        this.image = image;
        this.themeDescription = themeDescription;
    }


    public String getThemeNames() {
        return themeNames;
    }

    public int getImage() {
        return image;
    }

    public String getThemeDescription(){
        return themeDescription;
    }

}
