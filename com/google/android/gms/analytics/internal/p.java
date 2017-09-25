package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.b;

public final class p {
    public static final String VERSION = String.valueOf(b.amc / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    public static final String aip = ("ma" + VERSION);
}
