package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.DexLoader;
import dalvik.system.DexClassLoader;

final class z {
    protected DexLoader wWu = null;

    public z(DexLoader dexLoader) {
        this.wWu = dexLoader;
    }

    public final void a(Object obj, Activity activity, int i) {
        Object obj2 = obj;
        this.wWu.invokeMethod(obj2, "com.tencent.tbs.player.TbsPlayerProxy", "onActivity", new Class[]{Activity.class, Integer.TYPE}, activity, Integer.valueOf(i));
    }

    public final boolean a(Object obj, Bundle bundle, FrameLayout frameLayout, Object obj2) {
        Object invokeMethod = this.wWu.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[]{Bundle.class, FrameLayout.class}, bundle, frameLayout);
        return invokeMethod instanceof Boolean ? ((Boolean) invokeMethod).booleanValue() : false;
    }

    public final Object gz(Context context) {
        return this.wWu.newInstance("com.tencent.tbs.player.TbsPlayerProxy", new Class[]{Context.class, DexClassLoader.class}, context, this.wWu.getClassLoader());
    }
}
