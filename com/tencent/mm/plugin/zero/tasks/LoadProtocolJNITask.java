package com.tencent.mm.plugin.zero.tasks;

import com.tencent.mars.xlog.Xlog;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;

public class LoadProtocolJNITask extends c {
    public void execute(e eVar) {
        k.b("MMProtocalJni", getClass().getClassLoader());
        MMProtocalJni.setClientPackVersion(d.sYN);
        MMProtocalJni.setProtocalJniLogLevel(new Xlog().getLogLevel());
        MMProtocalJni.setIsLite(false);
    }

    public String name() {
        return "boot-load-MMProtocalJni-library";
    }
}
