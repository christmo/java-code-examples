package compress.objects;

import java.io.Serializable;

/**
 * Created by soporte on 3/28/17.
 */
public class MyObjectHeavy implements Serializable {

    public MyObjectHeavy(StringBuilder txt){
        this.field1 = txt;
        this.field2 = txt;
        this.field3 = txt;
    }

    private StringBuilder field1;
    private StringBuilder field2;
    private StringBuilder field3;

    public StringBuilder getField1() {
        return field1;
    }

    public void setField1(StringBuilder field1) {
        this.field1 = field1;
    }

    public StringBuilder getField2() {
        return field2;
    }

    public void setField2(StringBuilder field2) {
        this.field2 = field2;
    }

    public StringBuilder getField3() {
        return field3;
    }

    public void setField3(StringBuilder field3) {
        this.field3 = field3;
    }
}
