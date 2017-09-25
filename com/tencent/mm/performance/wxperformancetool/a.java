package com.tencent.mm.performance.wxperformancetool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;

public final class a extends com.tencent.mm.performance.a.a.a {
    private HashMap<Integer, Long> igM = new HashMap();
    private HashMap<Integer, Long> igN = new HashMap();
    private HashMap<Integer, Long> igO = new HashMap();
    private HashMap<Integer, Long> igP = new HashMap();
    private HashMap<Integer, Long> igQ = new HashMap();
    private HashMap<Integer, Long> igR = new HashMap();
    private HashMap<Integer, Long> igS = new HashMap();

    private static void a(HashMap<Integer, Long> hashMap, Activity activity) {
        if (activity != null) {
            hashMap.put(Integer.valueOf(activity.hashCode()), Long.valueOf(System.currentTimeMillis()));
        }
    }

    private static void a(HashMap<Integer, Long> hashMap, Activity activity, String str) {
        if (activity != null) {
            int hashCode = activity.hashCode();
            Long l = (Long) hashMap.get(Integer.valueOf(hashCode));
            if (l != null) {
                w.i("MicroMsg.WxPerformace", str + "  activity: " + hashCode + " classname:" + activity.getComponentName().getShortClassName() + " use time: " + (System.currentTimeMillis() - l.longValue()) + " taskid:" + activity.getTaskId());
            }
        }
    }

    public final void a(Activity activity, Bundle bundle) {
        super.a(activity, bundle);
        a(this.igM, activity);
    }

    public final void b(Activity activity, Bundle bundle) {
        super.b(activity, bundle);
        a(this.igM, activity, "onActivityCreate");
    }

    public final void p(Activity activity) {
        super.p(activity);
        a(this.igN, activity);
    }

    public final void q(Activity activity) {
        super.q(activity);
        a(this.igN, activity, "onActivityDestroy");
    }

    public final void c(Activity activity, Intent intent) {
        super.c(activity, intent);
        a(this.igO, activity);
    }

    public final void d(Activity activity, Intent intent) {
        super.d(activity, intent);
        a(this.igO, activity, "onActivityNewIntent");
    }

    public final void j(Activity activity) {
        super.j(activity);
        a(this.igP, activity);
    }

    public final void k(Activity activity) {
        super.k(activity);
        a(this.igP, activity, "onActivityPause");
    }

    public final void h(Activity activity) {
        super.h(activity);
        a(this.igQ, activity);
    }

    public final void i(Activity activity) {
        super.i(activity);
        a(this.igQ, activity, "onActivityResume");
    }

    public final void l(Activity activity) {
        super.l(activity);
        a(this.igR, activity);
    }

    public final void m(Activity activity) {
        super.m(activity);
        a(this.igR, activity, "onActivityStart");
    }

    public final void n(Activity activity) {
        super.n(activity);
        a(this.igS, activity);
    }

    public final void o(Activity activity) {
        super.o(activity);
        a(this.igS, activity, "onActivityStop");
    }
}
