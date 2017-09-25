package com.tencent.smtt.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.c;
import java.util.Map;

final class w {
    private Context wWq = null;
    private Context wWr = null;
    private String wWs = null;
    private String[] wWt = null;
    DexLoader wWu = null;
    private String wWv = "TbsDexOpt";
    private String wWw = null;

    public w(Context context, Context context2, String str, String str2, String[] strArr, String str3, o oVar) {
        TbsLog.i("TbsWizard", "construction start...");
        if (context == null || ((context2 == null && t.ceK() == null) || TextUtils.isEmpty(str) || strArr == null || strArr.length == 0)) {
            throw new Exception("TbsWizard paramter error:-1callerContext:" + context + "hostcontext" + context2 + "isEmpty" + TextUtils.isEmpty(str) + "dexfileList" + strArr);
        }
        Object invokeStaticMethod;
        int i;
        this.wWq = context.getApplicationContext();
        this.wWr = context2;
        this.wWs = str;
        this.wWt = strArr;
        this.wWv = str2;
        if (oVar != null) {
            oVar.a("load_tbs_dex", (byte) 1);
        }
        this.wWu = new DexLoader(str3, this.wWq, this.wWt, str2, QbSdk.wTA);
        if (oVar != null) {
            oVar.a("load_tbs_dex", (byte) 2);
        }
        libwebp.loadWepLibraryIfNeed(context2, this.wWs);
        if ("com.nd.android.pandahome2".equals(this.wWq.getApplicationInfo().packageName)) {
            this.wWu.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new Class[]{Context.class}, this.wWq);
        }
        if (QbSdk.wTA != null) {
            this.wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, QbSdk.wTA);
        }
        if (oVar != null) {
            oVar.a("init_tbs", (byte) 1);
        }
        this.wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "putInfo", new Class[]{Context.class, String.class, String.class, String.class, String.class}, context, c.aMq, c.wXy, c.wXz, c.aQl);
        if (this.wWr != null || t.ceK() == null) {
            invokeStaticMethod = this.wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class}, context, this.wWr, this.wWu, this.wWs, this.wWv, "3.5.0.1016", Integer.valueOf(43501), QbSdk.cdQ());
        } else {
            invokeStaticMethod = this.wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class, String.class}, context, this.wWr, this.wWu, this.wWs, this.wWv, "3.5.0.1016", Integer.valueOf(43501), QbSdk.cdQ(), t.ceK());
        }
        if (invokeStaticMethod == null) {
            this.wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[]{String.class}, "3.5.0.1016");
            this.wWu.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", Integer.valueOf(43501));
            invokeStaticMethod = this.wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class}, context, this.wWr, this.wWu, this.wWs, this.wWv);
        }
        if (invokeStaticMethod == null) {
            i = -3;
        } else if (invokeStaticMethod instanceof Integer) {
            i = ((Integer) invokeStaticMethod).intValue();
        } else if (invokeStaticMethod instanceof Throwable) {
            i.cec().a(this.wWq, 328, (Throwable) invokeStaticMethod);
            i = -5;
        } else {
            i = -4;
        }
        if (i < 0) {
            Object invokeStaticMethod2 = this.wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
            if (invokeStaticMethod2 instanceof Throwable) {
                Throwable th = (Throwable) invokeStaticMethod2;
                this.wWw = "#" + th.getMessage() + "; cause: " + th.getCause() + "; th: " + th;
            }
            if (invokeStaticMethod2 instanceof String) {
                this.wWw = (String) invokeStaticMethod2;
            }
        } else {
            this.wWw = null;
        }
        if (oVar != null) {
            oVar.a("init_tbs", (byte) 2);
        }
        if (i < 0) {
            throw new Exception("TbsWizard init error: " + i + "; msg: " + this.wWw);
        }
        TbsLog.i("TbsWizard", "construction end...");
    }
}
