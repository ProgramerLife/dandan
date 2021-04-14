package com.dandan.selfAnnotation;


@GoAway(value = "起开")
public class DemoAnnotation {

    @GoAway(value = "起开呀")
    public String value;

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    @GoAway(value = "你好！")
    public void returnString( ){}

    @GoAway()
    public void defaultMethod(){}

}
