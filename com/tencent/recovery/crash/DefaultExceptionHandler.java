package com.tencent.recovery.crash;

import java.lang.Thread.UncaughtExceptionHandler;

public class DefaultExceptionHandler extends RecoveryExceptionHandler {
    private UncaughtExceptionHandler wQh;

    public DefaultExceptionHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.wQh = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        super.uncaughtException(thread, th);
        if (this.wQh != null) {
            this.wQh.uncaughtException(thread, th);
        }
    }
}
