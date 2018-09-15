package com.eden.exception;

public class IllegalParameterException extends Exception {

    private String parameterName;

    public IllegalParameterException(String message) {
        super(message);
    }

    public IllegalParameterException(String message, String parameterName) {
        super(message);
        this.parameterName = parameterName;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public static void main(String[] args) {
        try {
            throw new IllegalParameterException("参数异常！", "非接口类型");
        } catch (IllegalParameterException e) {
            System.out.println(e.getParameterName());
        } finally {

        }
    }
}
