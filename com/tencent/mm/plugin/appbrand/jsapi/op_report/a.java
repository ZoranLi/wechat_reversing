package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.mm.plugin.appbrand.jsapi.e;

final class a extends e {
    private static final int CTRL_INDEX = 246;
    private static final String NAME = "onStartReportPageData";
    private static final a iTU = new a();

    a() {
    }

    static synchronized void pd(String str) {
        synchronized (a.class) {
            iTU.ad(str, 0).SR();
        }
    }
}
