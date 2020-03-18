package gpnu.sw.gra.ticket.dto.base;

/**
 * @Auther:S
 * @Date:20/3/18
 */
public class AppResult  {
    private  int status=404;
    private Object obj;
    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
