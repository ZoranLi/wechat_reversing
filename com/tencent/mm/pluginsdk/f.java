package com.tencent.mm.pluginsdk;

import android.app.Activity;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.storage.x;

public interface f extends a {
    void a(BizInfo bizInfo, Activity activity, x xVar);

    void a(BizInfo bizInfo, Activity activity, x xVar, boolean z, Runnable runnable);
}
