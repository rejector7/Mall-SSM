package cn.jtruan.mallssm.common.api;



public enum ResultCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "服务器内部操作失败"),
    FORBIDDEN(403, "没有相关权限"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    VALIDATE_FAILED(404, "参数检验失败");

    private long code;
    private String message;

    private ResultCode(long code, String message){
        this.code = code;
        this.message = message;
    }

    public long getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }
}
