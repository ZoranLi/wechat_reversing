package com.tencent.wcdb.support;

import android.util.Printer;

public class PrefixPrinter implements Printer {
    private final String mPrefix;
    private final Printer mPrinter;

    public static Printer create(Printer printer, String str) {
        return (str == null || str.equals("")) ? printer : new PrefixPrinter(printer, str);
    }

    private PrefixPrinter(Printer printer, String str) {
        this.mPrinter = printer;
        this.mPrefix = str;
    }

    public void println(String str) {
        this.mPrinter.println(this.mPrefix + str);
    }
}
