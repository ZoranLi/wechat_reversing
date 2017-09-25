package com.tencent.mm.permission;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.Base64;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.kw;
import com.tencent.mm.e.a.kx;
import com.tencent.mm.i.g;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.s;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class b {
    static final String fwJ;
    static final String fwK;
    static Map<Integer, a> ihn;
    c iho = new c<kw>(this) {
        final /* synthetic */ b ihq;

        {
            this.ihq = r2;
            this.usg = kw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            kw kwVar = (kw) bVar;
            if (true == kwVar.fRy.fRA) {
                if (!b.gZ(kwVar.fRy.type)) {
                    if (com.tencent.mm.compatible.e.a.gSe == null) {
                        List<b> arrayList = new ArrayList();
                        List<a> arrayList2 = new ArrayList();
                        com.tencent.mm.compatible.e.a.a(e.hgq + "permissioncfg.cfg", arrayList, arrayList2);
                        PInt pInt = new PInt(0);
                        PBool pBool = new PBool();
                        for (b bVar2 : arrayList) {
                            pInt.value = 0;
                            pBool.value = true;
                            if (com.tencent.mm.compatible.e.a.a(Build.MANUFACTURER, bVar2.gSj, pInt, pBool) && com.tencent.mm.compatible.e.a.a(Build.MODEL, bVar2.model, pInt, pBool)) {
                                com.tencent.mm.compatible.e.a.a(VERSION.RELEASE, bVar2.version, pInt, pBool);
                            }
                            if (pBool.value && pInt.value > 0) {
                                com.tencent.mm.compatible.e.a.gSe = Boolean.valueOf(1 == bVar2.gSh);
                            }
                        }
                        if (com.tencent.mm.compatible.e.a.gSe == null || true != com.tencent.mm.compatible.e.a.gSe.booleanValue()) {
                            for (PackageInfo packageInfo : com.tencent.mm.compatible.e.a.aD(false)) {
                                for (a aVar : arrayList2) {
                                    pInt.value = 0;
                                    pBool.value = true;
                                    if (com.tencent.mm.compatible.e.a.a(packageInfo.packageName, aVar.fwP, pInt, pBool)) {
                                        if (aVar.gSf == 0 && aVar.gSg == 0) {
                                            pBool.value = true;
                                        } else if (aVar.gSf > packageInfo.versionCode || aVar.gSg < packageInfo.versionCode) {
                                            pBool.value = false;
                                        } else {
                                            pInt.value++;
                                            pBool.value = true;
                                        }
                                    }
                                    if (pBool.value && pInt.value > 0) {
                                        com.tencent.mm.compatible.e.a.gSe = Boolean.valueOf(1 == aVar.gSh);
                                    }
                                }
                                if (com.tencent.mm.compatible.e.a.gSe != null && true == com.tencent.mm.compatible.e.a.gSe.booleanValue()) {
                                    break;
                                }
                            }
                            if (com.tencent.mm.compatible.e.a.gSe == null) {
                                com.tencent.mm.compatible.e.a.gSe = Boolean.valueOf(false);
                            }
                        }
                    }
                    if (com.tencent.mm.compatible.e.a.gSe.booleanValue()) {
                        kwVar.fRz.fRC = b.x(kwVar.fRy.type, true);
                        b.b(kwVar.fRy.type, false, true);
                    }
                }
                kwVar.fRz.fRC = false;
                b.b(kwVar.fRy.type, true, false);
            } else {
                kwVar.fRz.fRC = false;
                b.b(kwVar.fRy.type, false, kwVar.fRy.fRB);
            }
            return false;
        }
    };
    private c ihp = new c<kx>(this) {
        final /* synthetic */ b ihq;

        {
            this.ihq = r2;
            this.usg = kx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            kx kxVar = (kx) bVar;
            kxVar.fRE.fRC = b.x(kxVar.fRD.type, false);
            return false;
        }
    };

    private static class a {
        public int ihr;
        public int ihs;
        public int iht;
        public int ihu;
        public int ihv;

        public a(int i, int i2, int i3, int i4, int i5) {
            this.ihr = i;
            this.ihs = i2;
            this.iht = i3;
            this.ihu = i4;
            this.ihv = i5;
        }
    }

    static {
        String rB = p.rB();
        fwJ = rB;
        fwK = o.getString(rB.hashCode());
        Map hashMap = new HashMap();
        ihn = hashMap;
        hashMap.put(Integer.valueOf(1), new a(38, 40, 41, R.l.dIf, R.l.dHX));
        ihn.put(Integer.valueOf(2), new a(43, 44, 45, R.l.dIe, R.l.dHY));
    }

    public b() {
        com.tencent.mm.sdk.b.a.urY.b(this.iho);
        com.tencent.mm.sdk.b.a.urY.b(this.ihp);
    }

    public static void b(int i, boolean z, boolean z2) {
        int i2;
        w.i("MicroMsg.PermissionMgr", "makeMark, setOrClear: " + z);
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        ap.yW().setInt(((a) ihn.get(Integer.valueOf(i))).ihr, i2);
        if (true == z) {
            a.Nh().Ni();
        }
        if (!z && true == z2) {
            long j = ap.yW().getLong(((a) ihn.get(Integer.valueOf(i))).ihs, 0);
            if (0 != j && System.currentTimeMillis() - j >= 86400000) {
                L("LastTick: " + j + ", CurrentTtick: " + System.currentTimeMillis() + "\n", ap.yW().yA(((a) ihn.get(Integer.valueOf(i))).iht) == 1 ? 6 : 5);
                ap.yW().setLong(((a) ihn.get(Integer.valueOf(i))).ihs, 0);
            }
        }
    }

    public static boolean gZ(int i) {
        int yA = ap.yW().yA(((a) ihn.get(Integer.valueOf(i))).ihr);
        w.i("MicroMsg.PermissionMgr", "current mark status: " + yA);
        return yA == 0;
    }

    private static int mo(String str) {
        int i = 0;
        try {
            i = bg.getInt(g.sV().getValue(str), 0);
        } catch (Exception e) {
            w.e("MicroMsg.PermissionMgr", "getIntValFromDynamicConfig parseInt failed, val: " + str);
        }
        return i;
    }

    public static boolean x(int i, boolean z) {
        int mo;
        int mo2;
        int mo3;
        boolean z2;
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        if (ap.zb()) {
            mo = mo("ShowPermissionDialog");
            mo2 = mo("OnlyScanRunningService");
            mo3 = mo("Interval4ShowPmsDialog");
        } else {
            mo = 1;
            mo2 = 1;
            mo3 = 3600000;
        }
        w.i("MicroMsg.PermissionMgr", "showDlg: %d, filter: %d, interval: %d", Integer.valueOf(mo), Integer.valueOf(mo2), Integer.valueOf(mo3));
        long j = 0;
        for (a aVar2 : ihn.values()) {
            long j2 = ap.yW().getLong(aVar2.ihs, 0);
            if (j < j2) {
                j = j2;
            }
        }
        boolean z3 = 1 == mo && System.currentTimeMillis() - j >= ((long) mo3);
        if (z3) {
            String str;
            z2 = 1 == mo2;
            List arrayList = new ArrayList();
            List<b> arrayList2 = new ArrayList();
            List<a> arrayList3 = new ArrayList();
            com.tencent.mm.compatible.e.a.a(e.hgq + "permissioncfg.cfg", arrayList2, arrayList3);
            String str2 = null;
            PInt pInt = new PInt(0);
            PBool pBool = new PBool();
            for (b bVar : arrayList2) {
                pInt.value = 0;
                pBool.value = true;
                if (com.tencent.mm.compatible.e.a.a(Build.MANUFACTURER, bVar.gSj, pInt, pBool) && com.tencent.mm.compatible.e.a.a(Build.MODEL, bVar.model, pInt, pBool)) {
                    com.tencent.mm.compatible.e.a.a(VERSION.RELEASE, bVar.version, pInt, pBool);
                }
                if (!pBool.value || pInt.value <= 0) {
                    str = str2;
                } else {
                    str = (String) bVar.gSi.get(i);
                }
                str2 = str;
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            List<PackageInfo> aD = com.tencent.mm.compatible.e.a.aD(z2);
            if (aD != null) {
                for (PackageInfo packageInfo : aD) {
                    str2 = null;
                    for (a aVar3 : arrayList3) {
                        pInt.value = 0;
                        pBool.value = true;
                        if (com.tencent.mm.compatible.e.a.a(packageInfo.packageName, aVar3.fwP, pInt, pBool)) {
                            if (aVar3.gSf == 0 && aVar3.gSg == 0) {
                                pBool.value = true;
                            } else if (aVar3.gSf > packageInfo.versionCode || aVar3.gSg < packageInfo.versionCode) {
                                pBool.value = false;
                            } else {
                                pInt.value++;
                                pBool.value = true;
                            }
                        }
                        if (!pBool.value || pInt.value <= 0) {
                            str = str2;
                        } else {
                            str = (String) aVar3.gSi.get(i);
                        }
                        str2 = str;
                    }
                    if (str2 != null) {
                        arrayList.add(str2);
                    }
                }
            }
            w.i("MicroMsg.PermissionMgr", "len of tips list: " + Integer.valueOf(arrayList.size()));
            if (arrayList.size() != 0) {
                a(i, arrayList, z);
                c(arrayList, z);
                z2 = true;
            } else {
                if (System.currentTimeMillis() - ap.yW().getLong(42, 0) < 2592000000L) {
                    bB(z);
                } else if (1 == i) {
                    ap.yW().setLong(42, System.currentTimeMillis());
                    PermissionWarningDialog.a(ab.getContext(), 1 == mo2, z);
                }
                z2 = false;
            }
            ap.yW().setLong(((a) ihn.get(Integer.valueOf(i))).ihs, System.currentTimeMillis());
        } else {
            z2 = false;
        }
        w.i("MicroMsg.PermissionMgr", "showPermissionDialog cost: " + aVar.se() + ", needShowDlg: " + z3);
        return z2;
    }

    public static void bB(boolean z) {
        L("App_List:\n", z ? 4 : 3);
    }

    public static void e(boolean z, boolean z2) {
        StringBuilder stringBuilder = new StringBuilder();
        PackageManager packageManager = ab.getContext().getPackageManager();
        List<PackageInfo> aD = com.tencent.mm.compatible.e.a.aD(z);
        if (aD != null) {
            stringBuilder.append("App_List:\n");
            for (PackageInfo packageInfo : aD) {
                if (packageInfo != null) {
                    String str = "";
                    if (!(packageInfo.applicationInfo == null || packageManager == null)) {
                        str = packageInfo.applicationInfo.loadLabel(packageManager).toString();
                    }
                    stringBuilder.append(str + ":" + packageInfo.packageName + ":" + packageInfo.versionCode + "\n");
                }
            }
        }
        L(stringBuilder.toString(), z2 ? 4 : 3);
    }

    private static void c(List<String> list, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Match_Tips:\n");
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append((String) list.get(i));
            stringBuilder.append("\n");
        }
        L(stringBuilder.toString(), z ? 2 : 1);
    }

    private static void a(int i, List<String> list, boolean z) {
        int i2;
        int i3;
        int size = list.size() > 5 ? 5 : list.size();
        int[] iArr = new int[]{R.l.dIb, R.l.dIg, R.l.dId, R.l.dIa, R.l.dHZ};
        Context context = ab.getContext();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getString(((a) ihn.get(Integer.valueOf(i))).ihv));
        for (i2 = 0; i2 < size; i2++) {
            stringBuilder.append(context.getString(iArr[i2]));
            stringBuilder.append((String) list.get(i2));
            stringBuilder.append('\n');
        }
        s yW = ap.yW();
        i2 = ((a) ihn.get(Integer.valueOf(i))).iht;
        if (z) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        yW.setInt(i2, i3);
        PermissionWarningDialog.i(context, context.getString(((a) ihn.get(Integer.valueOf(i))).ihu), stringBuilder.toString());
    }

    private static void L(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n#client.version=").append(d.sYN).append("\n");
        stringBuilder.append("#accinfo.revision=").append(com.tencent.mm.sdk.platformtools.e.REV).append("\n");
        stringBuilder.append("#accinfo.uin=").append(ao.hlW.A("last_login_uin", fwK)).append("\n");
        stringBuilder.append("#accinfo.dev=").append(fwJ).append("\n");
        stringBuilder.append("#accinfo.build=").append(com.tencent.mm.sdk.platformtools.e.TIME).append(":").append(com.tencent.mm.sdk.platformtools.e.HOSTNAME).append(":").append(f.fuV).append("\n");
        Date date = new Date();
        stringBuilder.append("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date)).append("\n");
        stringBuilder.append("#permission.type=").append(String.valueOf(i)).append('\n');
        stringBuilder.append("#permission.content:\n");
        Intent intent = new Intent();
        intent.setClassName(ab.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
        intent.setAction("uncatch_exception");
        intent.putExtra("exceptionWriteSdcard", false);
        intent.putExtra("exceptionPid", Process.myPid());
        String str2 = "userName";
        String A = ao.hlW.A("login_weixin_username", "");
        if (bg.mA(A)) {
            A = ao.hlW.A("login_user_name", "never_login_crash");
        }
        intent.putExtra(str2, A);
        intent.putExtra("tag", "permission");
        w.d("MicroMsg.PermissionMgr", "report type: %d, len: %d", Integer.valueOf(i), Integer.valueOf((stringBuilder.toString() + str).length()));
        intent.putExtra("exceptionMsg", Base64.encodeToString(A.getBytes(), 2));
        ab.getContext().startService(intent);
    }
}
