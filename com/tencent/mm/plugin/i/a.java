package com.tencent.mm.plugin.i;

import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.kernel.b.e;

public final class a extends c {
    public final void execute(e eVar) {
        k.b("FFmpeg", getClass().getClassLoader());
        k.b("wechatpack", getClass().getClassLoader());
    }

    public final String name() {
        return "boot-load-FFmpeg-and-wechatpack-libraries";
    }
}
