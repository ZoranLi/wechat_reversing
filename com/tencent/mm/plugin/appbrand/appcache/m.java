package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.protocal.c.bpu;
import com.tencent.mm.protocal.c.bqg;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class m {
    public static final String[] izG = new String[]{i.a(i.izp, "AppBrandWxaPkgManifestRecord")};
    public final g izH;
    public final a izI;

    private static final class a extends i<i> {
        a(e eVar) {
            super(eVar, i.izp, "AppBrandWxaPkgManifestRecord", i.gaK);
        }
    }

    public m(g gVar) {
        this.izH = gVar;
        this.izI = new a(gVar);
    }

    public final int[] nF(String str) {
        int[] iArr = null;
        if (!bg.mA(str) && com.tencent.mm.plugin.appbrand.appcache.c.a.hv(0)) {
            Cursor a = this.izH.a("AppBrandWxaPkgManifestRecord", new String[]{"version"}, String.format(Locale.US, "%s=? and %s=? ", new Object[]{"appId", "debugType"}), new String[]{str, "0"}, null, null, "version desc", 2);
            if (a != null) {
                if (a.moveToFirst()) {
                    iArr = new int[a.getCount()];
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        iArr[i] = a.getInt(0);
                        if (!a.moveToNext()) {
                            break;
                        }
                        i = i2;
                    }
                }
                a.close();
            }
        }
        return iArr;
    }

    public final i a(String str, int i, String... strArr) {
        i iVar = null;
        if (!bg.mA(str)) {
            String str2;
            String[] strArr2;
            if (com.tencent.mm.plugin.appbrand.appcache.c.a.hv(i)) {
                str2 = "version desc";
            } else if (com.tencent.mm.plugin.appbrand.appcache.c.a.fp(i)) {
                str2 = "createTime desc";
            } else {
                throw new RuntimeException("Illegal pkgType " + i);
            }
            g gVar = this.izH;
            String str3 = "AppBrandWxaPkgManifestRecord";
            if (bg.D(strArr)) {
                strArr2 = null;
            } else {
                strArr2 = strArr;
            }
            Cursor query = gVar.query(str3, strArr2, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, str2);
            if (query != null) {
                if (query.moveToFirst()) {
                    iVar = new i();
                    iVar.b(query);
                    iVar.field_appId = str;
                    iVar.field_debugType = i;
                }
                query.close();
            }
        }
        return iVar;
    }

    final boolean a(bpu com_tencent_mm_protocal_c_bpu) {
        if (com_tencent_mm_protocal_c_bpu.version < 0 || bg.mA(com_tencent_mm_protocal_c_bpu.url) || bg.mA(com_tencent_mm_protocal_c_bpu.fFW)) {
            w.e("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, invalid resp: version( %d ), url( %s ), md5( %s )", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bpu.version), com_tencent_mm_protocal_c_bpu.url, com_tencent_mm_protocal_c_bpu.fFW});
            return false;
        }
        if (com_tencent_mm_protocal_c_bpu.tWA > 0) {
            int delete = this.izH.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s>?", new Object[]{"appId", "debugType", "version"}), new String[]{"@LibraryAppId", "0", String.valueOf(com_tencent_mm_protocal_c_bpu.version)});
            w.i("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, delete manifest.version > %d, ret = %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bpu.version), Integer.valueOf(delete)});
        }
        return a("@LibraryAppId", 0, com_tencent_mm_protocal_c_bpu.version, com_tencent_mm_protocal_c_bpu.fFW, com_tencent_mm_protocal_c_bpu.url);
    }

    final int O(String str, int i) {
        int i2 = 0;
        String format = String.format(Locale.US, "select count(%s) from %s where %s=? and %s=?", new Object[]{"version", "AppBrandWxaPkgManifestRecord", "appId", "debugType"});
        Cursor a = this.izH.a(format, new String[]{str, String.valueOf(i)}, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i2 = a.getInt(0);
            }
            a.close();
        }
        return i2;
    }

    @SuppressLint({"DefaultLocale"})
    final List<i> q(String str, int i, int i2) {
        List<i> list = null;
        if (!bg.mA(str)) {
            Object format;
            if (com.tencent.mm.plugin.appbrand.appcache.c.a.hv(0)) {
                format = String.format("order by %s desc", new Object[]{"version"});
            } else {
                String format2 = String.format("order by %s desc", new Object[]{"createTime"});
            }
            String format3 = String.format("limit %d offset %d", new Object[]{Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(2)});
            Cursor a = this.izH.a("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath", "version"}, String.format("%s=? and %s=? %s %s", new Object[]{"appId", "debugType", format, format3}), new String[]{str, "0"}, null, null, null, 2);
            if (a != null) {
                list = new ArrayList();
                if (a.moveToFirst()) {
                    do {
                        i iVar = new i();
                        iVar.field_appId = str;
                        iVar.field_debugType = 0;
                        iVar.b(a);
                        list.add(iVar);
                    } while (a.moveToNext());
                }
                a.close();
            }
        }
        return list;
    }

    public final boolean a(String str, int i, String str2, String str3, long j, long j2) {
        if (bg.mA(str) || bg.mA(str2)) {
            w.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, null or nil appId = %s, url = %s", new Object[]{str, str2});
            return false;
        }
        if (i == 999) {
            str = "@LibraryAppId";
        }
        i a = a(str, 1, i, new String[0]);
        if (a == null) {
            i iVar = new i();
            iVar.field_appId = str;
            iVar.field_version = 1;
            iVar.field_debugType = i;
            iVar.field_downloadURL = str2;
            iVar.field_versionMd5 = str3;
            iVar.field_versionState = 0;
            iVar.field_startTime = j;
            iVar.field_endTime = j2;
            iVar.field_createTime = d.XH();
            b(iVar);
            return true;
        }
        if (bg.mA(str3) || bg.mA(a.field_versionMd5) || str3.equals(a.field_versionMd5)) {
            boolean z = false;
        } else {
            int i2 = 1;
        }
        if (str2.equals(a.field_downloadURL)) {
            boolean z2 = false;
        } else {
            int i3 = 1;
        }
        if (i2 != 0) {
            a.field_downloadURL = str2;
            b.deleteFile(a.field_pkgPath);
            a.field_pkgPath = null;
            a.field_createTime = d.XH();
            a.field_versionMd5 = str3;
            a.field_startTime = j;
            a.field_endTime = j2;
            c(a);
            return true;
        } else if (i3 == 0) {
            return false;
        } else {
            a.field_downloadURL = str2;
            a.field_startTime = j;
            a.field_endTime = j2;
            c(a);
            return false;
        }
    }

    final boolean a(i iVar) {
        return !bg.mA(iVar.field_appId) && this.izI.a(iVar, i.izo);
    }

    public final String P(String str, int i) {
        i a = a(str, i, "downloadURL");
        return a == null ? "" : a.field_downloadURL;
    }

    private boolean a(String str, int i, int i2, String str2, String str3) {
        if (!com.tencent.mm.plugin.appbrand.appcache.c.a.hv(i)) {
            return false;
        }
        i a = a(str, i, "version");
        int i3 = a == null ? 0 : a.field_version;
        if (i2 < i3) {
            w.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, newVersion( %d ) < curMaxVersion( %d ), skip", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
            return false;
        } else if ("@LibraryAppId".equals(str) && i2 == 48) {
            w.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, given version == local library version %d, skip", new Object[]{Integer.valueOf(48)});
            return false;
        } else {
            i a2 = a(str, i2, i, new String[0]);
            boolean z = false;
            if (a2 == null) {
                i iVar = new i();
                iVar.field_appId = str;
                iVar.field_version = i2;
                iVar.field_versionMd5 = str2;
                iVar.field_downloadURL = str3;
                iVar.field_debugType = i;
                w.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, insert record %b, version %d, url %s, md5 %s", new Object[]{Boolean.valueOf(b(iVar)), Integer.valueOf(iVar.field_version), iVar.field_downloadURL, iVar.field_versionMd5});
                return b(iVar);
            }
            Object obj;
            String str4 = a2.field_downloadURL;
            String str5 = a2.field_versionMd5;
            if (!bg.mz(a2.field_versionMd5).equals(str2)) {
                a2.field_versionMd5 = str2;
                a2.field_version = i2;
                a2.field_downloadURL = str3;
                obj = 1;
            } else if (bg.mA(str3) || str3.equals(a2.field_downloadURL)) {
                obj = null;
            } else {
                a2.field_downloadURL = str3;
                int i4 = 1;
            }
            if (obj != null) {
                z = c(a2);
            }
            String str6 = "MicroMsg.AppBrandWxaPkgStorage";
            String str7 = "flushWxaPkgVersionInfo, update record %b, oldVersion %d, newVersion %d, oldURL %s, newURL %s, oldMd5 %s, newMd5 %s";
            Object[] objArr = new Object[7];
            boolean z2 = obj != null && z;
            objArr[0] = Boolean.valueOf(z2);
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = str4;
            objArr[4] = str3;
            objArr[5] = str5;
            objArr[6] = str2;
            w.i(str6, str7, objArr);
            if (obj == null || !z) {
                return false;
            }
            return true;
        }
    }

    public final boolean a(String str, bqg com_tencent_mm_protocal_c_bqg, int i) {
        if (bg.mA(str)) {
            w.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfo, args invalid appId = %s, vInfo = %s", new Object[]{str, com_tencent_mm_protocal_c_bqg});
            return false;
        }
        return a(str, i, com_tencent_mm_protocal_c_bqg.tkv, com_tencent_mm_protocal_c_bqg.uox, com_tencent_mm_protocal_c_bqg.uoy);
    }

    public final boolean a(String str, c cVar) {
        if (bg.mA(str) || cVar == null) {
            w.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfoV2, args invalid appId = %s, vInfo = %s", new Object[]{str, cVar});
            return false;
        }
        return a(str, 0, cVar.fWF, cVar.iyA, null);
    }

    final i a(String str, int i, int i2, String... strArr) {
        i iVar = null;
        String str2 = "";
        for (String str3 : i.izo) {
            str2 = str2 + str3 + "=? and ";
        }
        Cursor a = this.izH.a("AppBrandWxaPkgManifestRecord", bg.D(strArr) ? null : strArr, str2 + "1=1", new String[]{str, String.valueOf(i), String.valueOf(i2)}, null, null, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                iVar = new i();
                iVar.b(a);
            }
            a.close();
        }
        return iVar;
    }

    private boolean b(i iVar) {
        return this.izI.b(iVar);
    }

    final boolean c(i iVar) {
        return this.izI.c(iVar, i.izo);
    }

    public final void d(List<String> list, List<Integer> list2) {
        if (list.size() > 0 && list2.size() > 0 && list.size() == list2.size()) {
            long cs = this.izH.cs(Thread.currentThread().getId());
            for (int i = 0; i < list.size(); i++) {
                Q((String) list.get(i), ((Integer) list2.get(i)).intValue());
            }
            this.izH.aD(cs);
        }
    }

    public final void Q(String str, int i) {
        if (!bg.mA(str)) {
            String format = String.format("%s=? and %s=?", new Object[]{"appId", "debugType"});
            String[] strArr = new String[]{str, String.valueOf(i)};
            Cursor a = this.izH.a("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath"}, format, strArr, null, null, null, 2);
            if (a == null) {
                return;
            }
            if (a.moveToFirst()) {
                List<String> linkedList = new LinkedList();
                do {
                    linkedList.add(a.getString(0));
                } while (a.moveToNext());
                a.close();
                for (String deleteFile : linkedList) {
                    b.deleteFile(deleteFile);
                }
                this.izH.delete("AppBrandWxaPkgManifestRecord", format, strArr);
                return;
            }
            a.close();
        }
    }
}
