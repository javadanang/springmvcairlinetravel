package javacommunity.airlinetravel.form;

import java.io.Serializable;

public class LabelValueBean implements Serializable {

    private static final long serialVersionUID = -7084726320314919316L;

    public LabelValueBean(String code, String value) {
        this.code = code;
        this.value = value;
    }
    private String code;
    private String value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
