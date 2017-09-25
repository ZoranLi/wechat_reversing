package com.tencent.qqmusic.mediaplayer.upstream;

public interface DataSourceErrors {
    public static final int CREATE_NATIVE_DATASOURCE_GENERAL = -1;
    public static final int CREATE_NATIVE_DATASOURCE_ILLEAGAL_ARUMENTS = -5;
    public static final int CREATE_NATIVE_DATASOURCE_NULL_NATIVE_INSTANCE = -4;
    public static final int CREATE_NATIVE_DATASOURCE_SO_LOAD_FAILED = -3;
    public static final int CREATE_NATIVE_DATASOURCE_UNSATISFIED_LINK = -2;
}
