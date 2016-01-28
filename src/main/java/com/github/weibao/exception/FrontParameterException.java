package com.github.weibao.exception;

/**
 * @Create 16/1/27,下午12:17
 * @Author dongzhukai
 */
public class FrontParameterException extends Exception {
    protected FrontParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public FrontParameterException(String message) {
        super(message);
    }

    public FrontParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public FrontParameterException(Throwable cause) {
        super(cause);
    }

    public FrontParameterException() {
        super();
    }
}
