package test.bwie.com.date20170512;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/12
 */

public class Bean {
    private String name;
    private boolean check;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public Bean(String name, boolean check) {

        this.name = name;
        this.check = check;
    }
}
