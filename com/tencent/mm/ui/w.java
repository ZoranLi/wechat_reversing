package com.tencent.mm.ui;

import com.tencent.mm.e.a.qn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

public final class w {
    public static void aC(int i, String str) {
        if (a.urY != null) {
            b qnVar = new qn();
            qnVar.fXE.className = str;
            qnVar.fXE.fXF = i;
            a.urY.m(qnVar);
        }
    }
}
