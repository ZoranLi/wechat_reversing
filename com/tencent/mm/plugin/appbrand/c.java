package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.bb.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appcache.m;
import com.tencent.mm.plugin.appbrand.b.g;
import com.tencent.mm.plugin.appbrand.b.k;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.i.e;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;

public final class c implements a {
    public final boolean a(Context context, String[] strArr) {
        boolean z = true;
        boolean z2 = false;
        if (b.bIu()) {
            String toLowerCase;
            if (!"//localwxalibrary".equals(strArr[0])) {
                if (!"//getsearchshowoutwxaapp".equals(strArr[0])) {
                    if (!"//callsearchshowoutwxaapp".equals(strArr[0])) {
                        toLowerCase = strArr[1].toLowerCase();
                        switch (toLowerCase.hashCode()) {
                            case -2086708598:
                                if (toLowerCase.equals("deletebetalib")) {
                                    z = false;
                                    break;
                                }
                                break;
                            case -1958532869:
                                if (toLowerCase.equals("historycount")) {
                                    z = true;
                                    break;
                                }
                                break;
                            case -1897191982:
                                if (toLowerCase.equals("starmax")) {
                                    z = true;
                                    break;
                                }
                                break;
                            case -917899243:
                                if (toLowerCase.equals("deletecontact")) {
                                    z = true;
                                    break;
                                }
                                break;
                            case -823215646:
                                if (toLowerCase.equals("prunepkg")) {
                                    z = true;
                                    break;
                                }
                                break;
                            case -725390129:
                                if (toLowerCase.equals("clearguide")) {
                                    z = true;
                                    break;
                                }
                                break;
                            case -501183631:
                                if (toLowerCase.equals("releasepkghighversion")) {
                                    z = true;
                                    break;
                                }
                                break;
                            case -358696710:
                                if (toLowerCase.equals("deletelib")) {
                                    z = true;
                                    break;
                                }
                                break;
                            case 3545755:
                                if (toLowerCase.equals("sync")) {
                                    z = true;
                                    break;
                                }
                                break;
                            case 98712316:
                                if (toLowerCase.equals("guide")) {
                                    z = true;
                                    break;
                                }
                                break;
                            case 1127987502:
                                if (toLowerCase.equals("resetsyncversion")) {
                                    z = true;
                                    break;
                                }
                                break;
                        }
                        switch (z) {
                            case false:
                                m PY = com.tencent.mm.plugin.appbrand.app.c.PY();
                                com.tencent.mm.sdk.e.c iVar = new i();
                                iVar.field_appId = "@LibraryAppId";
                                iVar.field_debugType = 999;
                                iVar.field_version = 1;
                                PY.izI.a(iVar, i.izo);
                                break;
                            case true:
                                com.tencent.mm.plugin.appbrand.app.c.PY().Q("@LibraryAppId", 0);
                                break;
                            case true:
                                j.Qx();
                                break;
                            case true:
                                p.or(strArr[2]);
                                break;
                            case true:
                                if (bg.getInt(strArr[2].trim(), 0) > 0) {
                                    z2 = true;
                                }
                                h.vI().vr().a(w.a.uEh, Boolean.valueOf(z2));
                                break;
                            case true:
                                p.oq(strArr[2]);
                                break;
                            case true:
                                q.G(strArr[2], false);
                                break;
                            case true:
                                g.iCp = Integer.valueOf(Math.max(0, bg.getInt(strArr[2], 10)));
                                break;
                            case true:
                                d.w(ab.getContext(), "appbrand", ".ui.AppBrandGuideUI");
                                break;
                            case true:
                                h.vI().vr().a(w.a.uEg, Boolean.valueOf(false));
                                break;
                            case true:
                                try {
                                    String str = strArr[2];
                                    com.tencent.mm.plugin.appbrand.config.WxaAttributes.c cVar = new com.tencent.mm.plugin.appbrand.config.WxaAttributes.c();
                                    cVar.fWF = 1000;
                                    cVar.iyA = "fake";
                                    com.tencent.mm.plugin.appbrand.app.c.PY().a(str, cVar);
                                    break;
                                } catch (Exception e) {
                                    break;
                                }
                            default:
                                break;
                        }
                    }
                    ((e) h.h(e.class)).Ro();
                } else if (strArr.length <= 1 || !strArr[1].contains("daily")) {
                    k.hC(k.a.iCz);
                } else {
                    k.hC(k.a.iCA);
                }
            } else {
                SharedPreferences bIY = ab.bIY();
                toLowerCase = strArr[1];
                switch (toLowerCase.hashCode()) {
                    case 3569038:
                        if (toLowerCase.equals("true")) {
                            z = true;
                            break;
                        }
                        break;
                    case 94746189:
                        if (toLowerCase.equals("clear")) {
                            z = false;
                            break;
                        }
                        break;
                    case 97196323:
                        if (toLowerCase.equals("false")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        bIY.edit().remove("localwxalibrary").commit();
                        break;
                    case true:
                        bIY.edit().putBoolean("localwxalibrary", true).commit();
                        break;
                    case true:
                        bIY.edit().putBoolean("localwxalibrary", false).commit();
                        break;
                    default:
                        break;
                }
            }
        }
        return true;
    }
}
