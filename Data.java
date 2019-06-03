package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Data {
    private StringProperty c1;
    private StringProperty c2;
    private StringProperty c3;
    private StringProperty c4;

    public Data(String t1, String t2, String  t3,String t4){
        this.c1=new SimpleStringProperty(t1);
        this.c2=new SimpleStringProperty(t2);
        this.c3=new SimpleStringProperty(t3);
        this.c4=new SimpleStringProperty(t4);
    }

    public String getC1() {
        return c1.get();
    }

    public StringProperty c1Property() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1.set(c1);
    }

    public String getC2() {
        return c2.get();
    }

    public StringProperty c2Property() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2.set(c2);
    }

    public String getC3() {
        return c3.get();
    }

    public StringProperty c3Property() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3.set(c3);
    }

    public String getC4() {
        return c4.get();
    }

    public StringProperty c4Property() {
        return c4;
    }

    public void setC4(String c4) {
        this.c4.set(c4);
    }
}