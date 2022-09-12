package xx;

import lombok.Data;
import org.microxt.blog.common.enums.StatusCodeEnum;

import static org.microxt.blog.common.enums.StatusCodeEnum.*;

@Data
public class CommonResult<T> {
    /**
     * 返回状态
     */
    private Boolean flag;
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    public static <T> CommonResult<T> ok() {
        return restResult(true, null, SUCCESS.getCode(), SUCCESS.getDesc());
    }

    public static <T> CommonResult<T> ok(T data) {
        return restResult(true, data, SUCCESS.getCode(), SUCCESS.getDesc());
    }

    public static <T> CommonResult<T> ok(T data, String message) {
        return restResult(true, data, SUCCESS.getCode(), message);
    }

    public static <T> CommonResult<T> fail() {
        return restResult(false, null, FAIL.getCode(), FAIL.getDesc());
    }

    public static <T> CommonResult<T> fail(StatusCodeEnum statusCodeEnum) {
        return restResult(false, null, statusCodeEnum.getCode(), statusCodeEnum.getDesc());
    }

    public static <T> CommonResult<T> fail(String message) {
        return restResult(false, message);
    }

    public static <T> CommonResult<T> fail(T data) {
        return restResult(false, data, FAIL.getCode(), FAIL.getDesc());
    }

    public static <T> CommonResult<T> fail(T data, String message) {
        return restResult(false, data, FAIL.getCode(), message);
    }

    public static <T> CommonResult<T> fail(Integer code, String message) {
        return restResult(false, null, code, message);
    }

    private static <T> CommonResult<T> restResult(Boolean flag, String message) {
        CommonResult<T> apiResult = new CommonResult<>();
        apiResult.setFlag(flag);
        apiResult.setCode(flag ? SUCCESS.getCode() : FAIL.getCode());
        apiResult.setMessage(message);
        return apiResult;
    }

    private static <T> CommonResult<T> restResult(Boolean flag, T data, Integer code, String message) {
        CommonResult<T> apiResult = new CommonResult<>();
        apiResult.setFlag(flag);
        apiResult.setData(data);
        apiResult.setCode(code);
        apiResult.setMessage(message);
        return apiResult;
    }
}
