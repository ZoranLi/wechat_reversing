package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.f.b;

public final class a extends e {
    private static a jLl;
    private e jLm;
    private c jLn;
    private b jLo;

    public static a acg() {
        if (jLl == null) {
            com.tencent.mm.plugin.backup.a.a aVar = new a();
            jLl = aVar;
            a(aVar);
        }
        return jLl;
    }

    public final void ZY() {
        jLl = null;
    }

    public final void i(Object... objArr) {
        Context context = (Context) objArr[0];
        acg().acj().ack();
        b.clear();
        context.stopService(new Intent().setClassName(context, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService"));
    }

    public final e ach() {
        if (this.jLm == null) {
            this.jLm = new e();
        }
        return this.jLm;
    }

    public final c aci() {
        if (this.jLn == null) {
            this.jLn = new c();
        }
        return this.jLn;
    }

    public final b acj() {
        if (this.jLo == null) {
            this.jLo = new b();
        }
        return this.jLo;
    }

    public final void aaf() {
    }

    public final void aag() {
    }
}
