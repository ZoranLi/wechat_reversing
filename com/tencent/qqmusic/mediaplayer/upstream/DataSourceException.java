package com.tencent.qqmusic.mediaplayer.upstream;

public class DataSourceException extends Exception {
    private final int errorCode;

    public DataSourceException(int i, String str) {
        super(str);
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String toString() {
        return "DataSourceException{errorCode=" + this.errorCode + "\nmessage=" + getMessage() + '}';
    }
}
