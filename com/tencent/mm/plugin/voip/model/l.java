package com.tencent.mm.plugin.voip.model;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bc.d.a;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.ui.InviteRemindDialog;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class l {
    private static boolean riC = false;
    private static OnClickListener riD = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            l.bqe();
        }
    };

    public static long a(String str, String str2, int i, int i2, String str3) {
        return a(str, str2, i, i2, str3, false);
    }

    public static long a(String str, String str2, int i, int i2, String str3, boolean z) {
        ce auVar = new au();
        auVar.z(ay.gk(str));
        auVar.dw(i);
        auVar.setType(50);
        auVar.cH(str);
        auVar.cN(str3);
        auVar.setContent(str2);
        auVar.dv(i2);
        if (z) {
            auVar.dG(auVar.gxE | 8);
        }
        ap.yY();
        long L = c.wT().L(auVar);
        if (L < 0) {
            w.e("MicroMsg.VoipPluginManager", "inset voip  failed!");
        }
        w.d("MicroMsg.VoipPluginManager", "inset voip  msgId " + L);
        return L;
    }

    public static void bqc() {
        ap.yY();
        c.vr().set(20480, Long.valueOf(System.currentTimeMillis()));
    }

    public static boolean bqd() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            ap.yY();
            long longValue = ((Long) c.vr().get(20480, Integer.valueOf(-1))).longValue();
            if (longValue < 0) {
                return false;
            }
            currentTimeMillis -= longValue;
            w.d("MicroMsg.VoipPluginManager", "diff is" + currentTimeMillis);
            if (currentTimeMillis < 21600000) {
                return true;
            }
            return false;
        } catch (Exception e) {
        }
    }

    public static void aA(final Context context, final String str) {
        new String[1][0] = context.getResources().getString(R.l.fbe);
        riC = false;
        try {
            ap.yY();
            ce Aj = c.wT().Aj(str);
            if (Aj != null) {
                long j = Aj.field_createTime;
                riC = d.brg();
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
        }
        if (bg.mA(str)) {
            w.e("MicroMsg.VoipPluginManager", "talker is null");
            return;
        }
        int BR = ap.vd().BR();
        w.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus " + BR);
        if (BR != 4 && BR != 6) {
            g.oUh.a(11518, true, true, new Object[]{Integer.valueOf(d.bpd().riE.rew.rfQ.mNL), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(4), Integer.valueOf(0)});
            com.tencent.mm.ui.base.g.a(context, R.l.fco, R.l.fcs, riD);
        } else if (!riC) {
            try {
                ap.yY();
                Map NF = a.NF((String) c.vr().get(77829, null));
                if (NF != null) {
                    a aVar;
                    if (NF != null && NF.size() > 0) {
                        if (NF.containsKey(str)) {
                            aVar = (a) NF.get(str);
                            aVar.hitCount++;
                            NF.put(str, aVar);
                        } else {
                            aVar = new a();
                            aVar.hitCount++;
                            NF.put(str, aVar);
                        }
                    }
                    ap.yY();
                    c.vr().set(77829, a.ad(NF));
                    for (Entry entry : NF.entrySet()) {
                        aVar = (a) entry.getValue();
                        w.d("MicroMsg.VoipPluginManager", "val1 " + aVar.hitCount + " " + aVar.hOg + "name " + ((String) entry.getKey()));
                    }
                } else {
                    Map hashMap = new HashMap();
                    a aVar2 = new a();
                    aVar2.hitCount++;
                    hashMap.put(str, aVar2);
                    ap.yY();
                    c.vr().set(77829, a.ad(hashMap));
                    for (Entry entry2 : hashMap.entrySet()) {
                        aVar2 = (a) entry2.getValue();
                        w.d("MicroMsg.VoipPluginManager", "val2 " + aVar2.hitCount + " " + aVar2.hOg + "  name " + ((String) entry2.getKey()));
                    }
                }
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.VoipPluginManager", e2, "", new Object[0]);
            }
            InviteRemindDialog.h(context, str, 0);
            bqe();
        } else if (am.isWap(context)) {
            com.tencent.mm.ui.base.g.a(context, R.l.fcE, 0, R.l.fcF, R.l.dGs, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    l.cT(context);
                    l.bqe();
                }
            }, riD);
        } else if (am.isWifi(context) || bqd()) {
            d.bpd().aF(context, str);
        } else {
            com.tencent.mm.ui.base.g.a(context, R.l.fcr, R.l.fcs, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    l.bqc();
                    d.bpd().aF(context, str);
                }
            }, riD);
        }
    }

    public static void bqe() {
        b rrVar = new rr();
        rrVar.fYI.fJK = 8;
        com.tencent.mm.sdk.b.a.urY.m(rrVar);
    }

    public static void cT(Context context) {
        try {
            Intent intent = new Intent("/");
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.ApnSettings"));
            intent.setAction("android.intent.action.VIEW");
            context.startActivity(intent);
        } catch (Exception e) {
            searchIntentByClass(context, "ApnSettings");
        }
    }

    private static Intent searchIntentByClass(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            List installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages != null && installedPackages.size() > 0) {
                w.e("MicroMsg.VoipPluginManager", "package  size" + installedPackages.size());
                for (int i = 0; i < installedPackages.size(); i++) {
                    try {
                        w.e("MicroMsg.VoipPluginManager", "package " + ((PackageInfo) installedPackages.get(i)).packageName);
                        Intent intent = new Intent();
                        intent.setPackage(((PackageInfo) installedPackages.get(i)).packageName);
                        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                        int size = queryIntentActivities != null ? queryIntentActivities.size() : 0;
                        if (size > 0) {
                            try {
                                w.e("MicroMsg.VoipPluginManager", "activityName count " + size);
                                for (int i2 = 0; i2 < size; i2++) {
                                    ActivityInfo activityInfo = ((ResolveInfo) queryIntentActivities.get(i2)).activityInfo;
                                    if (activityInfo.name.contains(str)) {
                                        Intent intent2 = new Intent("/");
                                        intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                                        intent2.setAction("android.intent.action.VIEW");
                                        context.startActivity(intent2);
                                        return intent2;
                                    }
                                }
                                continue;
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
                            }
                        } else {
                            continue;
                        }
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.VoipPluginManager", e2, "", new Object[0]);
                    }
                }
            }
        } catch (Throwable e22) {
            w.printErrStackTrace("MicroMsg.VoipPluginManager", e22, "", new Object[0]);
        }
        return null;
    }

    public static void aB(Context context, String str) {
        com.tencent.mm.i.g.sW();
        if (com.tencent.mm.i.c.sF() == 2) {
            int i = 1;
        } else {
            boolean z = false;
        }
        com.tencent.mm.bb.d.bGP();
        if (i == 0) {
            Toast.makeText(context, context.getString(R.l.fcQ), 0).show();
            w.d("MicroMsg.VoipPluginManager", "showDouble %b, isLiteVersion: %b", new Object[]{Boolean.valueOf(false), Boolean.valueOf(false)});
            return;
        }
        riC = false;
        try {
            ap.yY();
            ce Aj = c.wT().Aj(str);
            if (Aj != null) {
                long j = Aj.field_createTime;
                riC = d.brg();
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
        }
        aD(context, str);
    }

    public static void aC(Context context, String str) {
        riC = false;
        try {
            ap.yY();
            ce Aj = c.wT().Aj(str);
            if (Aj != null) {
                long j = Aj.field_createTime;
                riC = d.brg();
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
        }
        aD(context, str);
    }

    private static void aD(final Context context, final String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.VoipPluginManager", "talker is null");
            return;
        }
        int BR = ap.vd().BR();
        w.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus " + BR);
        if (BR != 4 && BR != 6) {
            g.oUh.a(11518, true, true, new Object[]{Integer.valueOf(d.bpd().riE.rew.rfQ.mNL), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(4), Integer.valueOf(0)});
            com.tencent.mm.ui.base.g.a(context, R.l.fco, R.l.fcs, riD);
        } else if (!riC) {
            try {
                ap.yY();
                Map NF = a.NF((String) c.vr().get(77829, null));
                if (NF != null) {
                    a aVar;
                    if (NF != null && NF.size() > 0) {
                        if (NF.containsKey(str)) {
                            aVar = (a) NF.get(str);
                            aVar.hitCount++;
                            NF.put(str, aVar);
                        } else {
                            aVar = new a();
                            aVar.hitCount++;
                            NF.put(str, aVar);
                        }
                    }
                    ap.yY();
                    c.vr().set(77829, a.ad(NF));
                    for (Entry entry : NF.entrySet()) {
                        aVar = (a) entry.getValue();
                        w.d("MicroMsg.VoipPluginManager", "val1 " + aVar.hitCount + " " + aVar.hOg + "name " + ((String) entry.getKey()));
                    }
                } else {
                    Map hashMap = new HashMap();
                    a aVar2 = new a();
                    aVar2.hitCount++;
                    hashMap.put(str, aVar2);
                    ap.yY();
                    c.vr().set(77829, a.ad(hashMap));
                    for (Entry entry2 : hashMap.entrySet()) {
                        aVar2 = (a) entry2.getValue();
                        w.d("MicroMsg.VoipPluginManager", "val2 " + aVar2.hitCount + " " + aVar2.hOg + "  name " + ((String) entry2.getKey()));
                    }
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
            }
            InviteRemindDialog.h(context, str, 1);
            bqe();
        } else if (am.isWap(context)) {
            com.tencent.mm.ui.base.g.a(context, R.l.fcE, 0, R.l.fcF, R.l.dGs, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    l.cT(context);
                }
            }, riD);
        } else if (am.isWifi(context) || bqd()) {
            d.bpd().aE(context, str);
        } else {
            com.tencent.mm.ui.base.g.a(context, R.l.fcr, R.l.fcs, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    l.bqc();
                    d.bpd().aE(context, str);
                }
            }, riD);
        }
    }
}
