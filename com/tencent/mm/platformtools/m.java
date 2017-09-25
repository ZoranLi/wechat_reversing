package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.BioHelperUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.g;
import java.util.Map;

public final class m {
    public static void a(final Activity activity, final Runnable runnable, boolean z, final int i) {
        if (com.tencent.mm.modelfriend.m.Fl() == a.SUCC || com.tencent.mm.modelfriend.m.Fl() == a.SUCC_UNLOAD) {
            ap.yY();
            if (bg.f((Boolean) c.vr().get(12322, null))) {
                w.d("MicroMsg.PostLoginUtil", "addrbook upload confirmed");
            } else {
                if (!z) {
                    ap.yY();
                    if (bg.f((Boolean) c.vr().get(12323, null))) {
                        w.d("MicroMsg.PostLoginUtil", "addrbook upload login confirmed showed");
                    }
                }
                ap.yY();
                c.vr().set(12322, Boolean.valueOf(false));
                String mz = bg.mz(bg.eo(activity));
                if (mz.length() > 0) {
                    ap.yY();
                    if (mz.equals(c.vr().get(6, null))) {
                        ap.yY();
                        c.vr().set(12322, Boolean.valueOf(true));
                        w.i("MicroMsg.PostLoginUtil", "same none-nil phone number, leave it");
                    }
                }
                g.a((Context) activity, R.l.dNj, R.l.dIO, R.l.dJe, R.l.dHQ, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        w.i("MicroMsg.PostLoginUtil", "[cpan] kv report logid:%d scene:%d", Integer.valueOf(11438), Integer.valueOf(i));
                        com.tencent.mm.plugin.report.service.g.oUh.i(11438, Integer.valueOf(i));
                        ap.yY();
                        c.vr().set(12322, Boolean.valueOf(true));
                        m.f(true, false);
                        com.tencent.mm.modelfriend.a.EL();
                        if (runnable != null) {
                            runnable.run();
                        }
                        activity.getSharedPreferences(ab.bIX(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ap.yY();
                        c.vr().set(12322, Boolean.valueOf(false));
                        m.f(false, false);
                        if (runnable != null) {
                            runnable.run();
                        }
                        activity.getSharedPreferences(ab.bIX(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
                    }
                });
                ap.yY();
                c.vr().set(12323, Boolean.valueOf(true));
                return;
            }
        }
        w.e("MicroMsg.PostLoginUtil", "not successfully binded, skip addrbook confirm");
        if (runnable != null) {
            runnable.run();
        }
    }

    public static void f(boolean z, boolean z2) {
        int xP = com.tencent.mm.u.m.xP();
        if (z) {
            xP &= -131073;
        } else {
            xP |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        }
        w.d("MicroMsg.PostLoginUtil", "Reg By mobile update = " + xP);
        ap.yY();
        c.vr().set(7, Integer.valueOf(xP));
        xP = !z ? 1 : 2;
        ap.yY();
        c.wQ().b(new com.tencent.mm.ao.g(17, xP));
        if (z2) {
            com.tencent.mm.plugin.c.a.imw.ou();
        }
    }

    public static void mv(String str) {
        ao.hlW.L("login_user_name", str);
    }

    public static void bo(final Context context) {
        String string = context.getString(R.l.dDe);
        final String string2 = context.getString(R.l.dDd);
        String string3 = context.getString(R.l.dXk);
        String string4 = context.getString(R.l.dXi);
        OnClickListener anonymousClass3 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string2);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                com.tencent.mm.plugin.c.a.imv.j(intent, context);
            }
        };
        g.a(context, string, "", string3, string4, anonymousClass3, null);
    }

    public static void j(final Context context, String str, final String str2) {
        com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
        if (dn != null) {
            dn.a(context, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                    com.tencent.mm.plugin.c.a.imv.j(intent, context);
                }
            }, null);
        }
    }

    public static void a(Context context, u.a aVar, int i) {
        Intent intent = new Intent(context, BioHelperUI.class);
        intent.putExtra("k_type", aVar.type);
        intent.putExtra("KVoiceHelpCode", i);
        intent.putExtra("Kvertify_key", aVar.fGV);
        intent.putExtra("KVoiceHelpUrl", aVar.hSD);
        intent.putExtra("KVoiceHelpWording", aVar.fNG);
        intent.putExtra("Kusername", aVar.username);
        if (aVar.hSE != null) {
            intent.getExtras().putAll(aVar.hSE);
        }
        context.startActivity(intent);
    }

    public static void E(final Context context, String str) {
        final com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
        if (dn != null) {
            String string = context.getString(R.l.dHT);
            String string2 = context.getString(R.l.dGs);
            OnClickListener anonymousClass5 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", dn.url);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                    com.tencent.mm.plugin.c.a.imv.j(intent, context);
                }
            };
            OnClickListener anonymousClass6 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            };
            if (dn.showType != 1 && dn.showType != 4) {
                return;
            }
            if (bg.mA(dn.url)) {
                g.b(context, dn.desc, dn.fDC, true);
                return;
            }
            g.a(context, dn.desc, dn.fDC, string, string2, anonymousClass5, anonymousClass6);
            return;
        }
        Map q = bh.q(str, "e");
        if (q == null) {
            w.d("MicroMsg.PostLoginUtil", "this is not errmsg");
            return;
        }
        if (!bg.mA((String) q.get(".e.Url"))) {
            w.w("MicroMsg.PostLoginUtil", "url %s", (String) q.get(".e.Url"));
        }
    }
}
