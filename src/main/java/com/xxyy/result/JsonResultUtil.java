package com.xxyy.result;


/**
 * @author dangzhizheng
 */
public final class JsonResultUtil {

    private JsonResultUtil() {
        throw new Error("Utility classes should not instantiated!");
    }

    public static JsonResult getJsonResult(Code code) {
        return getJsonResult(code, code.message);
    }

    public static JsonResult getJsonResult(Code code, String message) {
        return new JsonResult(code.code, message);
    }

    public static JsonResult getJsonResult(Code code, Object object, String message) {
        return new JsonResult(code.code, object, message);
    }


    public enum Code {
        SUCCESS(200, "操作成功！"),
        ERROR(500, "对不起，操作出错！"),
        NOTFOUND(404, "对不起，您请求的资源不存在！"),
        DUPLICATE(302, "重复操作！"),
        NOPERM(403, "对不起，您没有进行此项操作的权限"),
        CONFLICT(409, "资源状态冲突"),
        PRECONDITION_FAILED(412, "前置验证条件异常"),
        ILLEGA(422, "请求服务参数异常"),
        UNLOGIN(407, "未登录，请先登录！");

        public final int code;
        public final String message;

        private Code(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }

        public int getCode() {
            return this.code;
        }
    }


}
