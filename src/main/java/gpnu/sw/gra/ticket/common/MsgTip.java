package gpnu.sw.gra.ticket.common;

/**
 * @Auther:S
 * @Date:20/3/18
 */
public enum MsgTip {
    ECHECK(404,"验证失败"),
    ELOGIN(404,"登陆失败"),
    LOGIN(200,"登陆成功"),
    GETPSGER(200,"获取成功"),
    EGETPSGER(404,"获取失败，稍后重试"),
    CECKED(200,"验证正确");

    private int code;
    private String msg;

    private MsgTip(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
