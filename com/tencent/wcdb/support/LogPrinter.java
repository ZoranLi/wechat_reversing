package com.tencent.wcdb.support;

import android.util.Printer;

public class LogPrinter implements Printer {
    private final int mPriority;
    private final String mTag;

    public LogPrinter(int i, String str) {
        this.mPriority = i;
        this.mTag = str;
    }

    public void println(String str) {
        Log.println(this.mPriority, this.mTag, str);
    }
}
