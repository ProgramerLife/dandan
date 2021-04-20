package com.dandan.selfAnnotation;

/**
 * 枚举类练习
 */
public enum CityName {
    BeiJIng("110000","北京","京"),
    ShanDong("370000","山东","鲁"),
    ShangHai("310000","上海","沪"),
    HaiNan("460000","海南","琼");

    private String code;
    private String value;
    private String title;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    CityName(String code, String value, String title) {
        this.code = code;
        this.value = value;
        this.title = title;
    }

    CityName() {
    }

    public static String getValueByCode(String code){
        for(CityName cityName : CityName.values()){
            if(cityName.getCode().equals(code)){
                return cityName.value;
            }
        }
        return "";
    }

    public static String getTitleByCode(String code){
        for(CityName cityName : CityName.values()){
            if(cityName.getCode().equals(code)){
                return cityName.title;
            }
        }
        return "";
    }

}
