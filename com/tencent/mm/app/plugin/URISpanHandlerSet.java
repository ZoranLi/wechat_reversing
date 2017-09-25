package com.tencent.mm.app.plugin;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.bl;
import com.tencent.mm.e.a.bm;
import com.tencent.mm.e.a.gr;
import com.tencent.mm.e.a.mh;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.pluginsdk.ui.applet.i;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.protocal.c.bfs;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.q;
import com.tencent.mm.u.t;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.bindmobile.MobileFriendUI;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.y.k;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

class URISpanHandlerSet {
    public Context mContext = null;

    abstract class BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        abstract boolean a(i iVar, e eVar);

        abstract boolean a(String str, boolean z, o oVar, Bundle bundle);

        abstract i bv(String str);

        abstract int[] oN();

        public BaseUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
        }
    }

    enum PRIORITY {
        LOW,
        NORMAL,
        HIGH
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface a {
        PRIORITY oO() default PRIORITY.NORMAL;
    }

    @a
    class AAUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        AAUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().toLowerCase().startsWith("weixin://weixinnewaa/opendetail")) {
                return new i(str, 35, null);
            }
            if (str.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeurgenotify")) {
                return new i(str, 36, null);
            }
            return str.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeaa") ? new i(str, 37, null) : null;
        }

        final int[] oN() {
            return new int[]{35, 36, 37};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type == 35) {
                try {
                    String queryParameter = Uri.parse(iVar.url).getQueryParameter("billno");
                    if (bg.mA(queryParameter)) {
                        w.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                        return true;
                    }
                    String string;
                    if (iVar.data instanceof Bundle) {
                        string = ((Bundle) iVar.data).getString("chatroom_name");
                    } else if (iVar.data instanceof String) {
                        string = iVar.data.toString();
                    } else {
                        w.e("MicroMsg.URISpanHandlerSet", "illegal data type, %s", iVar);
                        return true;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("bill_no", queryParameter);
                    intent.putExtra("enter_scene", 3);
                    intent.putExtra("chatroom", string);
                    d.b(this.fyb.mContext, "aa", ".ui.PaylistAAUI", intent);
                    return true;
                } catch (Exception e) {
                    w.e("MicroMsg.URISpanHandlerSet", "handle click new aa open detail link error: %s, url: %s", e.getMessage(), iVar.url);
                }
            } else {
                final String queryParameter2;
                Bundle bundle;
                final String string2;
                final long j;
                if (iVar.type == 37) {
                    try {
                        queryParameter2 = Uri.parse(iVar.url).getQueryParameter("billno");
                        if (bg.mA(queryParameter2)) {
                            w.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                            return true;
                        } else if (iVar.data instanceof Bundle) {
                            bundle = (Bundle) iVar.data;
                            string2 = bundle.getString("chatroom_name");
                            if (bg.mA(string2)) {
                                w.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
                                return true;
                            }
                            j = bundle.getLong("msg_id", -1);
                            if (j < 0) {
                                w.e("MicroMsg.URISpanHandlerSet", "msgId is null");
                                return true;
                            }
                            g.a(this.fyb.mContext, R.l.dAS, -1, R.l.dAW, R.l.cancel, (OnClickListener) new OnClickListener(this) {
                                final /* synthetic */ AAUriSpanHandler fyf;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    b blVar = new bl();
                                    blVar.fER.fES = queryParameter2;
                                    blVar.fER.fET = string2;
                                    blVar.fER.fEU = j;
                                    com.tencent.mm.sdk.b.a.urY.m(blVar);
                                }
                            }, null);
                        } else {
                            w.e("MicroMsg.URISpanHandlerSet", "error data!");
                            return true;
                        }
                    } catch (Exception e2) {
                        w.e("MicroMsg.URISpanHandlerSet", "handle click new aa close link error: %s, url: %s", e2.getMessage(), iVar.url);
                    }
                } else if (iVar.type == 36) {
                    try {
                        queryParameter2 = Uri.parse(iVar.url).getQueryParameter("billno");
                        if (bg.mA(queryParameter2)) {
                            w.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                            return true;
                        }
                        bundle = null;
                        if (iVar.data instanceof Bundle) {
                            bundle = (Bundle) iVar.data;
                        }
                        if (bundle == null || bg.mA(bundle.getString("chatroom_name"))) {
                            w.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
                            return true;
                        }
                        string2 = bundle.getString("chatroom_name");
                        j = bundle.getLong("msg_id", -1);
                        g.a(this.fyb.mContext, R.l.dAU, -1, R.l.dAV, R.l.cancel, (OnClickListener) new OnClickListener(this) {
                            final /* synthetic */ AAUriSpanHandler fyf;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                b bmVar = new bm();
                                bmVar.fEV.fES = queryParameter2;
                                bmVar.fEV.fET = string2;
                                bmVar.fEV.fEU = j;
                                com.tencent.mm.sdk.b.a.urY.m(bmVar);
                            }
                        }, null);
                    } catch (Exception e22) {
                        w.e("MicroMsg.URISpanHandlerSet", "handle click new aa urge notify link error: %s, url: %s", e22.getMessage(), iVar.url);
                    }
                }
                return false;
            }
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class AddressUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        AddressUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            return null;
        }

        final int[] oN() {
            return new int[]{44};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 44) {
                return false;
            }
            Uri parse = Uri.parse(new StringBuilder(WebView.SCHEME_GEO).append(Uri.encode(iVar.url)).toString());
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (intent.resolveActivity(ab.getContext().getPackageManager()) != null) {
                ab.getContext().startActivity(intent);
                com.tencent.mm.plugin.report.service.g.oUh.i(12809, Integer.valueOf(9), "");
            } else {
                w.w("MicroMsg.URISpanHandlerSet", "Cannot find map app");
            }
            com.tencent.mm.plugin.report.service.g.oUh.i(12809, Integer.valueOf(8), "");
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class AlphaInstallUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        AlphaInstallUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().toLowerCase().startsWith("weixin://alphainstall?")) {
                return new i(str, 32, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{32};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 32) {
                return false;
            }
            String replace = iVar.url.replace("weixin://alphainstall?", "");
            String str = com.tencent.mm.compatible.util.e.hgu + Uri.parse(replace).getQueryParameter("md5") + ".apk";
            if (com.tencent.mm.a.e.aO(str)) {
                bg.i(str, ab.getContext());
            } else {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", replace.toString());
                d.b(this.fyb.mContext, "webview", ".ui.tools.WebViewUI", intent);
            }
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class BindMobileUrilSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        BindMobileUrilSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://setting/bindphone")) {
                return new i(str, 5, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{5};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 5) {
                return false;
            }
            if (eVar != null) {
                eVar.a(iVar);
            }
            MMWizardActivity.z(this.fyb.mContext, new Intent(this.fyb.mContext, BindMContactIntroUI.class));
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            if (!str.equals("weixin://setting/bindphone")) {
                return false;
            }
            Intent intent = new Intent(this.fyb.mContext, BindMContactIntroUI.class);
            if (this.fyb.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            MMWizardActivity.z(this.fyb.mContext, intent);
            return true;
        }
    }

    @a
    class BizMsgMenuUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        BizMsgMenuUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://bizmsgmenu")) {
                return new i(str, 43, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{43};
        }

        final boolean a(i iVar, e eVar) {
            if (43 != iVar.type) {
                return false;
            }
            if (bg.mA(iVar.username)) {
                w.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler Username is null.");
                return true;
            }
            w.d("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler, url:%s", iVar.url);
            Uri parse = Uri.parse(iVar.url.trim());
            String queryParameter = parse.getQueryParameter("msgmenuid");
            String queryParameter2 = parse.getQueryParameter("msgmenucontent");
            com.tencent.mm.plugin.report.service.g.oUh.i(14522, bg.mz(queryParameter), iVar.username);
            if (bg.mA(queryParameter) || bg.mA(queryParameter2)) {
                w.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler id or msgContent is null.");
                return true;
            }
            try {
                String decode = URLDecoder.decode(queryParameter2, "UTF-8");
                HashMap hashMap = new HashMap();
                hashMap.put("bizmsgmenuid", queryParameter);
                ap.vd().a(new j(iVar.username, decode, com.tencent.mm.u.o.fG(iVar.username), 291, hashMap), 0);
            } catch (UnsupportedEncodingException e) {
                w.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler exp, msg = %s", e.getMessage());
            }
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class CardUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        CardUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            return null;
        }

        final int[] oN() {
            return new int[0];
        }

        final boolean a(i iVar, e eVar) {
            return false;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            if (!str.startsWith("wxcard://cardjumptype=1")) {
                return false;
            }
            String str2 = null;
            if (oVar != null) {
                str2 = oVar.bCv().toString();
            }
            Intent intent = new Intent();
            intent.putExtra("user_name", str2);
            intent.putExtra("view_type", 1);
            d.b(this.fyb.mContext, "card", ".ui.CardViewUI", intent);
            return true;
        }
    }

    @a
    class ContactUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        ContactUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().equals("weixin://contacts/all/")) {
                return new i(str, 23, new aq("@all.android", null, this.fyb.mContext.getString(R.l.eqE), null, true, true));
            } else if (str.trim().equals("weixin://contacts/microblog/")) {
                return new i(str, 22, t.fU(this.fyb.mContext.getString(R.l.eqH)));
            } else {
                if (str.trim().equals("weixin://contacts/micromessenger/")) {
                    return new i(str, 2, new aq("@micromsg.qq.com", null, this.fyb.mContext.getString(R.l.eqI), null, true, true));
                } else if (!str.trim().startsWith("weixin://contacts/")) {
                    return null;
                } else {
                    String substring = str.trim().substring(0, str.trim().length() - 1);
                    int lastIndexOf = substring.lastIndexOf("/");
                    if (lastIndexOf == -1) {
                        return null;
                    }
                    return new i(str, 21, t.I("@" + substring.substring(lastIndexOf + 1), this.fyb.mContext.getString(R.l.eqG)));
                }
            }
        }

        final int[] oN() {
            return new int[]{23, 21, 22, 2};
        }

        final boolean a(i iVar, e eVar) {
            boolean z = false;
            int i = iVar.type;
            if (i != 23 && i != 21 && i != 22 && i != 2) {
                return false;
            }
            aq aqVar = (aq) iVar.r(aq.class);
            if (eVar != null) {
                eVar.a(iVar);
            }
            if (aqVar == null) {
                g.b(this.fyb.mContext, this.fyb.mContext.getString(R.l.ewl), this.fyb.mContext.getString(R.l.dIO), true);
                return false;
            }
            if (aqVar.getType().equals("@t.qq.com")) {
                ap.yY();
                if (!(c.wZ().AH("@t.qq.com") != null)) {
                    g.b(this.fyb.mContext, this.fyb.mContext.getString(R.l.ewl), this.fyb.mContext.getString(R.l.dIO), true);
                }
            }
            if (aqVar.getType().equals("@domain.android")) {
                ap.yY();
                List aKk = c.wZ().aKk();
                if (aKk.size() > 0) {
                    for (int i2 = 0; i2 < aKk.size(); i2++) {
                        if (((ay) aKk.get(i2)).isEnable()) {
                            z = true;
                            break;
                        }
                    }
                }
                if (!z) {
                    g.b(this.fyb.mContext, this.fyb.mContext.getString(R.l.ewl), this.fyb.mContext.getString(R.l.dIO), true);
                }
            }
            Intent intent = new Intent();
            intent.setClass(this.fyb.mContext, SelectContactUI.class);
            intent.putExtra("Contact_GroupFilter_Type", aqVar.getType()).putExtra("Contact_GroupFilter_Str", aqVar.bLW()).putExtra("Contact_GroupFilter_DisplayName", aqVar.tK());
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            this.fyb.mContext.startActivity(intent);
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            if (!str.equals("weixin://contacts/microblog/") && !str.equals("weixin://contacts/micromessenger/") && !str.equals("weixin://contacts/all/")) {
                return false;
            }
            aq fU = t.fU(this.fyb.mContext.getString(R.l.eqI));
            if (str.equals("weixin://contacts/microblog/")) {
                fU = t.fU(this.fyb.mContext.getString(R.l.eqH));
            }
            if (str.equals("weixin://contacts/micromessenger/")) {
                fU = t.fU(this.fyb.mContext.getString(R.l.eqI));
            }
            if (str.equals("weixin://contacts/all/")) {
                fU = t.fU(this.fyb.mContext.getString(R.l.eqE));
            }
            Intent intent = new Intent();
            intent.setClass(this.fyb.mContext, SelectContactUI.class);
            intent.putExtra("Contact_GroupFilter_Type", fU.getType()).putExtra("Contact_GroupFilter_Str", fU.bLW()).putExtra("Contact_GroupFilter_DisplayName", fU.tK());
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            return true;
        }
    }

    @a(oO = PRIORITY.LOW)
    class DeeplinkUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        DeeplinkUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            w.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler getHrefFromUrl %s", str);
            if (str.trim().toLowerCase().startsWith("weixin://")) {
                return new i(str, 30, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{30};
        }

        final boolean a(i iVar, e eVar) {
            String str;
            w.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler handleSpanClick %d, %s", Integer.valueOf(iVar.type), iVar.url);
            if (eVar != null) {
                str = (String) eVar.a(iVar);
            } else {
                str = null;
            }
            if (iVar.type != 30) {
                return false;
            }
            final String mz = bg.mz(iVar.url);
            if (mz.startsWith("weixin://shieldBrandMsg/") || mz.startsWith("weixin://receiveBrandMsg/")) {
                if (bg.mA(str)) {
                    w.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null");
                    return true;
                }
                final BizInfo hW = com.tencent.mm.modelbiz.e.hW(str);
                if (hW == null) {
                    w.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler BizInfo is null");
                    return true;
                } else if (mz.startsWith("weixin://shieldBrandMsg/")) {
                    g.a(this.fyb.mContext, R.l.eYb, R.l.dIO, R.l.eYa, R.l.cancel, new OnClickListener(this) {
                        final /* synthetic */ DeeplinkUriSpanHandler fyj;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            int i2 = hW.field_brandFlag;
                            hW.field_brandFlag |= 1;
                            w.i("MicroMsg.URISpanHandlerSet", "shield biz msg %s, %s, old = %d, new = %d", mz, str, Integer.valueOf(i2), Integer.valueOf(hW.field_brandFlag));
                            com.tencent.mm.modelbiz.e.f(hW);
                        }
                    }, null);
                } else if (mz.startsWith("weixin://receiveBrandMsg/")) {
                    g.a(this.fyb.mContext, R.l.eXZ, R.l.dIO, R.l.eXY, R.l.cancel, new OnClickListener(this) {
                        final /* synthetic */ DeeplinkUriSpanHandler fyj;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            int i2 = hW.field_brandFlag;
                            hW.field_brandFlag &= -2;
                            w.i("MicroMsg.URISpanHandlerSet", "receive biz msg %s, %s, old = %d, new = %d", mz, str, Integer.valueOf(i2), Integer.valueOf(hW.field_brandFlag));
                            com.tencent.mm.modelbiz.e.f(hW);
                        }
                    }, null);
                }
            } else if (com.tencent.mm.pluginsdk.d.i(Uri.parse(mz))) {
                com.tencent.mm.pluginsdk.d.s(this.fyb.mContext, str, mz);
            } else if (!mz.startsWith("weixin://receiveWeAppKFMsg")) {
                com.tencent.mm.pluginsdk.d.a(this.fyb.mContext, mz, str, 1, mz, null);
            } else if (bg.mA(str)) {
                w.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null, handle the BUILTIN_RECEIVE_WEAPP_KFMSG ,  the herfUrl is %s", mz);
                return true;
            } else {
                g.a(this.fyb.mContext, R.l.dFP, R.l.dIO, R.l.dFO, R.l.cancel, new OnClickListener(this) {
                    final /* synthetic */ DeeplinkUriSpanHandler fyj;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        w.i("MicroMsg.URISpanHandlerSet", "AppBrandServiceHelper switchTo to receive msg for username %s", str);
                        com.tencent.mm.ui.d.b.j(this.fyj.fyb.mContext, str, true);
                    }
                }, null);
            }
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            if (bg.mA(str) || bundle == null) {
                boolean z2;
                String str2 = "MicroMsg.URISpanHandlerSet";
                String str3 = "url is null ? %b, paramsBundle is null ? %b";
                Object[] objArr = new Object[2];
                if (str == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                if (bundle == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[1] = Boolean.valueOf(z2);
                w.e(str2, str3, objArr);
                return false;
            } else if (!com.tencent.mm.pluginsdk.d.i(Uri.parse(str))) {
                return false;
            } else {
                int i = bundle.getInt("key_scene", -1);
                w.d("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler jump, %d, %s", Integer.valueOf(i), str);
                if (i == -1) {
                    i = 5;
                }
                final p a = g.a(this.fyb.mContext, "", true, null);
                com.tencent.mm.pluginsdk.d.a(this.fyb.mContext, str, i, new com.tencent.mm.pluginsdk.d.a(this) {
                    final /* synthetic */ DeeplinkUriSpanHandler fyj;

                    public final void a(int i, int i2, String str, k kVar, boolean z) {
                        if (a != null && a.isShowing()) {
                            a.dismiss();
                        }
                        if (kVar != null && i != 0 && i2 != 0 && (kVar instanceof ah)) {
                            bfs Jz = ((ah) kVar).Jz();
                            if (Jz != null && this.fyj.fyb.mContext != null) {
                                s.makeText(this.fyj.fyb.mContext, this.fyj.fyb.mContext.getString(R.l.dIO) + " : " + bg.mz(Jz.ugf), 0).show();
                            }
                        }
                    }
                });
                return true;
            }
        }
    }

    @a
    class EmotionStoreUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        EmotionStoreUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (!str.trim().startsWith("weixin://emoticonstore/")) {
                return null;
            }
            int lastIndexOf = str.lastIndexOf("/");
            Object obj = "";
            if (lastIndexOf != -1) {
                obj = str.substring(lastIndexOf + 1);
            }
            return new i(str, 29, obj);
        }

        final int[] oN() {
            return new int[]{29};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 29) {
                return false;
            }
            if (eVar != null) {
                eVar.a(iVar);
            }
            Intent intent = new Intent();
            intent.putExtra("download_entrance_scene", 21);
            intent.putExtra("extra_id", (String) iVar.r(String.class));
            intent.putExtra("preceding_scence", 3);
            d.b(this.fyb.mContext, "emoji", ".ui.EmojiStoreDetailUI", intent);
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class EnterRoomUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        EnterRoomUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            return null;
        }

        final int[] oN() {
            return new int[0];
        }

        final boolean a(i iVar, e eVar) {
            return false;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            if (str.startsWith("weixin://jump/mainframe/")) {
                int lastIndexOf = str.trim().lastIndexOf("/");
                if (lastIndexOf >= 0 && lastIndexOf < str.trim().length() - 1) {
                    String substring = str.trim().substring(lastIndexOf + 1);
                    if (com.tencent.mm.u.o.dH(substring)) {
                        ap.yY();
                        com.tencent.mm.j.a Rc = c.wR().Rc(substring);
                        if (Rc == null || ((int) Rc.gTQ) == 0) {
                            x xVar = new x();
                            xVar.setUsername(substring);
                            ap.yY();
                            c.wR().R(xVar);
                        }
                    }
                    Intent putExtra = new Intent(this.fyb.mContext, En_5b8fbb1e.class).putExtra("Chat_User", substring).putExtra("Chat_Mode", 1);
                    if (this.fyb.mContext instanceof Service) {
                        putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    }
                    this.fyb.mContext.startActivity(putExtra);
                    return true;
                }
            }
            return false;
        }
    }

    @a
    class ExposeUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        ExposeUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().toLowerCase().equals("weixin://expose/")) {
                return new i(str, 31, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{31};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 31) {
                return false;
            }
            int i;
            Intent intent = new Intent();
            String str = (String) eVar.a(iVar);
            intent.putExtra("k_username", str);
            if (bg.mA(str) || !str.endsWith("@chatroom")) {
                i = 39;
            } else {
                i = 36;
            }
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
            d.b(this.fyb.mContext, "webview", ".ui.tools.WebViewUI", intent);
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class FeedbackUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        FeedbackUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://feedback/next/")) {
                return new i(str, 34, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{34};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 34) {
                return false;
            }
            w.d("MicroMsg.URISpanHandlerSet", "FeedbackUriSpanHandler, url:%s, content:%s", iVar.url, iVar.url.trim().replace("weixin://feedback/next/", ""));
            ap.vd().a(new m(com.tencent.mm.compatible.d.p.rP(), r2, 8), 0);
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class FlowStatUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        FlowStatUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://flowstat")) {
                return new i(str, 16, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{16};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 16) {
                return false;
            }
            if (eVar != null) {
                eVar.a(iVar);
            }
            LauncherUI bPI = LauncherUI.bPI();
            if (bPI != null) {
                bPI.uRM.SD("tab_settings");
            }
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            if (!str.equals("weixin://flowstat")) {
                return false;
            }
            LauncherUI bPI = LauncherUI.bPI();
            if (bPI != null) {
                bPI.uRM.SD("tab_settings");
            }
            return true;
        }
    }

    @a
    class FriendMobileUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        FriendMobileUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://findfriend/mobile")) {
                return new i(str, 20, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{20};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 20) {
                return false;
            }
            if (eVar != null) {
                eVar.a(iVar);
            }
            this.fyb.mContext.startActivity(new Intent(this.fyb.mContext, MobileFriendUI.class));
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            if (!str.equals("weixin://findfriend/mobile")) {
                return false;
            }
            Intent intent = new Intent(this.fyb.mContext, MobileFriendUI.class);
            if (this.fyb.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            this.fyb.mContext.startActivity(intent);
            return true;
        }
    }

    @a
    class FriendSearchUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        FriendSearchUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://findfriend/search")) {
                return new i(str, 17, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{17};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 17) {
                return false;
            }
            if (eVar != null) {
                eVar.a(iVar);
            }
            d.w(this.fyb.mContext, "subapp", ".ui.pluginapp.ContactSearchUI");
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            if (!str.equals("weixin://findfriend/search")) {
                return false;
            }
            Intent intent = new Intent();
            if (this.fyb.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            d.b(this.fyb.mContext, "subapp", ".ui.pluginapp.ContactSearchUI", intent);
            return true;
        }
    }

    @a
    class FriendShareUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        FriendShareUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://findfriend/share")) {
                return new i(str, 18, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{18};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 18) {
                return false;
            }
            if (eVar != null) {
                eVar.a(iVar);
            }
            d.w(this.fyb.mContext, "setting", ".ui.qrcode.ShareMicroMsgChoiceUI");
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            if (!str.equals("weixin://findfriend/share")) {
                return false;
            }
            Intent intent = new Intent();
            if (this.fyb.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            d.b(this.fyb.mContext, "setting", ".ui.qrcode.ShareMicroMsgChoiceUI", intent);
            return true;
        }
    }

    @a
    class HttpUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        HttpUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().toLowerCase().startsWith("http")) {
                return new i(str, 1, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{1};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 1) {
                return false;
            }
            String str;
            iVar.r(aq.class);
            aq I = t.I("@" + iVar.url, this.fyb.mContext.getString(R.l.eqG));
            if (eVar != null) {
                str = (String) eVar.a(iVar);
            } else {
                str = null;
            }
            if (I == null || !I.fFU) {
                String str2 = iVar.url;
                if (!str2.toLowerCase().startsWith("http")) {
                    str2 = "http://" + str2;
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                if (iVar.data != null && (iVar.data instanceof Integer)) {
                    intent.putExtra("geta8key_scene", ((Integer) iVar.data).intValue());
                }
                str2 = iVar.iCS;
                if (!bg.mA(str2)) {
                    q.b fP = q.yC().fP(str2);
                    if (fP != null) {
                        String string = fP.getString("prePublishId", null);
                        String string2 = fP.getString("preUsername", null);
                        String string3 = fP.getString("preChatName", null);
                        intent.putExtra("reportSessionId", str2);
                        intent.putExtra("KPublisherId", string);
                        intent.putExtra("geta8key_username", string3);
                        intent.putExtra("pre_username", string2);
                        intent.putExtra("prePublishId", string);
                        intent.putExtra("preUsername", string2);
                        intent.putExtra("preChatName", string3);
                        intent.putExtra("preChatTYPE", com.tencent.mm.u.p.G(string2, string3));
                    }
                }
                intent.putExtra("geta8key_username", bg.mA(str) ? null : str);
                d.b(this.fyb.mContext, "webview", ".ui.tools.WebViewUI", intent);
            }
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class JumpActivityUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        JumpActivityUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            return null;
        }

        final int[] oN() {
            return new int[0];
        }

        final boolean a(i iVar, e eVar) {
            return false;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            if (!str.toLowerCase().startsWith("weixin://jump/")) {
                return false;
            }
            String[] split = str.split("/");
            String str2 = split[split.length - 1];
            Intent intent;
            if ("mainframe".equalsIgnoreCase(str2)) {
                intent = new Intent(this.fyb.mContext, LauncherUI.class);
                if (this.fyb.mContext instanceof Service) {
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                intent.addFlags(67108864);
                this.fyb.mContext.startActivity(intent);
            } else if ("shake".equalsIgnoreCase(str2)) {
                com.tencent.mm.plugin.report.service.g.oUh.A(10221, "1");
                intent = new Intent();
                intent.addFlags(67108864);
                if (this.fyb.mContext instanceof Service) {
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                d.b(this.fyb.mContext, "shake", ".ui.ShakeReportUI", intent);
                if (this.fyb.mContext != null && (this.fyb.mContext instanceof Activity)) {
                    ((Activity) this.fyb.mContext).finish();
                }
            } else if ("scanqrcode".equalsIgnoreCase(str2)) {
                intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
                intent.setFlags(65536);
                intent.addFlags(67108864);
                if (this.fyb.mContext instanceof Service) {
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                d.b(this.fyb.mContext, "scanner", ".ui.BaseScanUI", intent);
            }
            return true;
        }
    }

    @a
    class LuckyMoneyUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        LuckyMoneyUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().toLowerCase().startsWith("weixin://weixinhongbao/")) {
                return new i(str, 33, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{33};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 33) {
                return false;
            }
            Intent intent = new Intent();
            intent.putExtra("key_native_url", iVar.url);
            d.b(this.fyb.mContext, "luckymoney", ".ui.LuckyMoneyDetailUI", intent);
            com.tencent.mm.plugin.report.service.g.oUh.i(12097, Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
            com.tencent.mm.plugin.report.service.g.oUh.i(11850, Integer.valueOf(4), Integer.valueOf(1));
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class PayTransferUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        PayTransferUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            return null;
        }

        final int[] oN() {
            return new int[0];
        }

        final boolean a(i iVar, e eVar) {
            return false;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            String str2 = null;
            if (!str.startsWith("wxpay://")) {
                return false;
            }
            String obj;
            com.tencent.mm.plugin.wallet.a aVar;
            if (oVar != null) {
                obj = oVar.bCv().toString();
                Object bCw = oVar.bCw();
                if (bCw instanceof com.tencent.mm.plugin.wallet.a) {
                    aVar = (com.tencent.mm.plugin.wallet.a) bCw;
                    str2 = obj;
                } else {
                    aVar = null;
                    str2 = obj;
                }
            } else {
                aVar = null;
            }
            if (bg.mA(str2)) {
                w.e("MicroMsg.URISpanHandlerSet", "SERVICE_JUMP_TO_PAY fail, null username");
                return false;
            }
            obj = str.substring(8);
            String str3 = "";
            if (obj.indexOf("&") > 0) {
                obj = obj.split("&")[0];
            }
            int indexOf = obj.indexOf("=");
            if (indexOf >= 0) {
                obj = obj.substring(indexOf + 1);
            } else {
                obj = str3;
            }
            if (bg.getInt(obj, 0) == 1) {
                if (com.tencent.mm.u.m.xZ() || com.tencent.mm.u.m.ya()) {
                    com.tencent.mm.pluginsdk.wallet.e.a(this.fyb.mContext, 5, str2, 11, aVar);
                } else {
                    com.tencent.mm.pluginsdk.wallet.e.a(this.fyb.mContext, 2, str2, 11, aVar);
                }
                return true;
            }
            Toast.makeText(this.fyb.mContext, this.fyb.mContext.getString(R.l.eRp), 0).show();
            return false;
        }
    }

    @a
    class PayUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        PayUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            return null;
        }

        final int[] oN() {
            return new int[]{28};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 28) {
                return false;
            }
            if (eVar != null) {
                eVar.a(iVar);
            }
            b grVar = new gr();
            grVar.fLZ.actionCode = 11;
            grVar.fLZ.result = iVar.url;
            grVar.fLZ.context = this.fyb.mContext;
            grVar.fLZ.fMb = new Bundle();
            grVar.fLZ.fMb.putInt("pay_channel", 6);
            com.tencent.mm.sdk.b.a.urY.a(grVar, Looper.myLooper());
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class PhoneEmailUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        PhoneEmailUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            return null;
        }

        final int[] oN() {
            return new int[]{25, 24};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type == 25) {
                String str = iVar.username;
                Bundle bundle = new Bundle();
                if (!(str == null || str.equals(com.tencent.mm.u.m.xL()))) {
                    bundle.putString("Contact_User", str);
                    com.tencent.mm.modelfriend.b iZ = af.FY().iZ(str);
                    if (iZ == null || bg.mA(iZ.EP())) {
                        str = null;
                    } else {
                        str = bg.mz(iZ.EX()).replace(" ", "");
                    }
                    bundle.putString("Contact_Mobile_MD5", str);
                }
                bundle.putInt("fromScene", 1);
                com.tencent.mm.pluginsdk.ui.d.j.a(this.fyb.mContext, iVar.url, null, bundle);
                return true;
            }
            if (iVar.type == 24) {
                com.tencent.mm.pluginsdk.ui.d.j.b(this.fyb.mContext, iVar.url, null);
            }
            return false;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class PluginUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        PluginUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://plugin")) {
                return new i(str, 26, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{26};
        }

        final boolean a(i iVar, e eVar) {
            return false;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            if (!str.equals("weixin://plugin")) {
                return false;
            }
            Intent intent = new Intent();
            if (this.fyb.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            d.b(this.fyb.mContext, "setting", ".ui.setting.SettingsPluginsUI", intent);
            return true;
        }
    }

    @a
    class ProfileUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        ProfileUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://contacts/profile/")) {
                return new i(str, 3, str.trim().replace("weixin://contacts/profile/", "").replace("/", ""));
            }
            return null;
        }

        final int[] oN() {
            return new int[]{3};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 3) {
                return false;
            }
            if (eVar != null) {
                eVar.a(iVar);
            }
            String str = (String) iVar.r(String.class);
            Intent intent = new Intent();
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("Contact_User", str);
            ap.yY();
            com.tencent.mm.e.b.af Rc = c.wR().Rc(str);
            if (Rc != null && ((int) Rc.gTQ) > 0 && com.tencent.mm.j.a.ez(Rc.field_type)) {
                com.tencent.mm.ui.contact.e.a(intent, str);
            }
            if (bg.mz(str).length() > 0) {
                d.b(this.fyb.mContext, "profile", ".ui.ContactInfoUI", intent);
            }
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            if (!str.startsWith("weixin://contacts/profile/")) {
                return false;
            }
            String replace = str.trim().replace("weixin://contacts/profile/", "").replace("/", "");
            if (bg.mA(replace)) {
                w.e("MicroMsg.URISpanHandlerSet", "jumpToActivity fail, user is null");
                return true;
            }
            Intent intent = new Intent();
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("Contact_User", replace);
            ap.yY();
            com.tencent.mm.e.b.af Rc = c.wR().Rc(replace);
            if (Rc != null && ((int) Rc.gTQ) > 0 && com.tencent.mm.j.a.ez(Rc.field_type)) {
                com.tencent.mm.ui.contact.e.a(intent, replace);
            }
            d.b(this.fyb.mContext, "profile", ".ui.ContactInfoUI", intent);
            return true;
        }
    }

    @a
    class ScanQrCodeUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        ScanQrCodeUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            return null;
        }

        final int[] oN() {
            return new int[0];
        }

        final boolean a(i iVar, e eVar) {
            return false;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            boolean z2 = false;
            if (!str.equals("weixin://scanqrcode/")) {
                return false;
            }
            if (z) {
                Intent intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                if (bundle != null && bundle.getInt("fromScene") == 100) {
                    z2 = true;
                }
                if (!z2) {
                    intent.addFlags(67108864);
                }
                if (this.fyb.mContext instanceof Service) {
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                if (z2) {
                    d.b(this.fyb.mContext, "scanner", ".ui.SingleTopScanUI", intent);
                    return true;
                }
                d.b(this.fyb.mContext, "scanner", ".ui.BaseScanUI", intent);
                return true;
            }
            w.e("MicroMsg.URISpanHandlerSet", "jumpToActivity, scan qrcode permission fail");
            return true;
        }
    }

    @a
    class SetSafeDeviceUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        SetSafeDeviceUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            return null;
        }

        final int[] oN() {
            return new int[0];
        }

        final boolean a(i iVar, e eVar) {
            return false;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            if (!str.equals("weixin://setting/account/safedevice")) {
                return false;
            }
            ap.yY();
            String str2 = (String) c.vr().get(6, (Object) "");
            ap.yY();
            String str3 = (String) c.vr().get(4097, (Object) "");
            Intent intent;
            if (!bg.mA(str2)) {
                intent = new Intent();
                if (this.fyb.mContext instanceof Service) {
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                d.w(this.fyb.mContext, "safedevice", ".ui.MySafeDeviceListUI");
            } else if (bg.mA(str3)) {
                intent = new Intent();
                if (this.fyb.mContext instanceof Service) {
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                d.a(this.fyb.mContext, "safedevice", ".ui.BindSafeDeviceUI", intent);
            } else {
                intent = new Intent(this.fyb.mContext, BindMContactIntroUI.class);
                intent.putExtra("is_bind_for_safe_device", true);
                if (this.fyb.mContext instanceof Service) {
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                MMWizardActivity.z(this.fyb.mContext, intent);
            }
            return true;
        }
    }

    @a
    class SettingBindEmailUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        SettingBindEmailUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://setting/bindemail")) {
                return new i(str, 7, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{7};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 7) {
                return false;
            }
            if (eVar != null) {
                eVar.a(iVar);
            }
            LauncherUI bPI = LauncherUI.bPI();
            if (bPI != null) {
                bPI.uRM.SD("tab_settings");
            }
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class SettingBlacklistUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        SettingBlacklistUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://setting/blacklist")) {
                return new i(str, 14, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{14};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 14) {
                return false;
            }
            if (eVar != null) {
                eVar.a(iVar);
            }
            aq fT = t.fT(this.fyb.mContext.getString(R.l.eqF));
            Intent intent = new Intent();
            intent.setClass(this.fyb.mContext, SelectContactUI.class);
            intent.putExtra("Contact_GroupFilter_Type", fT.getType());
            intent.putExtra("Contact_GroupFilter_DisplayName", fT.tK());
            intent.addFlags(67108864);
            LauncherUI bPI = LauncherUI.bPI();
            if (bPI != null) {
                bPI.uRM.SD("tab_settings");
            }
            this.fyb.mContext.startActivity(intent);
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            if (!str.equals("weixin://setting/blacklist")) {
                return false;
            }
            aq fT = t.fT(this.fyb.mContext.getString(R.l.eqF));
            Intent intent = new Intent();
            intent.setClass(this.fyb.mContext, AddressUI.class);
            intent.putExtra("Contact_GroupFilter_Type", fT.getType());
            intent.putExtra("Contact_GroupFilter_DisplayName", fT.tK());
            intent.addFlags(67108864);
            if (this.fyb.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            LauncherUI bPI = LauncherUI.bPI();
            if (bPI != null) {
                bPI.uRM.SD("tab_settings");
            }
            this.fyb.mContext.startActivity(intent);
            return true;
        }
    }

    @a
    class SettingHeadImgUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        SettingHeadImgUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://setting/setheadimage")) {
                return new i(str, 6, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{6};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 6) {
                return false;
            }
            if (eVar != null) {
                eVar.a(iVar);
            }
            LauncherUI bPI = LauncherUI.bPI();
            if (bPI != null) {
                bPI.uRM.SD("tab_settings");
            }
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            if (!str.equals("weixin://setting/setheadimage")) {
                return false;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", com.tencent.mm.u.m.xL());
            intent.putExtra("Contact_Nick", com.tencent.mm.u.m.xN());
            intent.putExtra("User_Avatar", true);
            if (this.fyb.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            d.b(this.fyb.mContext, "profile", ".ui.ContactInfoUI", intent);
            return true;
        }
    }

    @a
    class SettingNotifyUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        SettingNotifyUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://setting/notify")) {
                return new i(str, 9, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{9};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 9) {
                return false;
            }
            if (eVar != null) {
                eVar.a(iVar);
            }
            LauncherUI bPI = LauncherUI.bPI();
            if (bPI != null) {
                bPI.uRM.SD("tab_settings");
            }
            d.w(this.fyb.mContext, "setting", ".ui.setting.SettingsNotificationUI");
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            if (!str.equals("weixin://setting/notify")) {
                return false;
            }
            LauncherUI bPI = LauncherUI.bPI();
            if (bPI != null) {
                bPI.uRM.SD("tab_settings");
            }
            Intent intent = new Intent();
            intent.addFlags(67108864);
            if (this.fyb.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            d.b(this.fyb.mContext, "setting", ".ui.setting.SettingsNotificationUI", intent);
            return true;
        }
    }

    @a
    class SettingPluginLomoUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        SettingPluginLomoUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://setting/plugin/lomo")) {
                return new i(str, 12, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{12};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 12) {
                return false;
            }
            if (eVar != null) {
                eVar.a(iVar);
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", "weibo");
            d.b(this.fyb.mContext, "profile", ".ui.ContactInfoUI", intent);
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            if (!str.equals("weixin://setting/plugin/lomo")) {
                return false;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", "weibo");
            if (this.fyb.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            d.b(this.fyb.mContext, "profile", ".ui.ContactInfoUI", intent);
            return true;
        }
    }

    @a
    class SettingPluginQQMailUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        SettingPluginQQMailUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://setting/plugin/qqmail")) {
                return new i(str, 10, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{10};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 10) {
                return false;
            }
            if (eVar != null) {
                eVar.a(iVar);
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", "qqmail");
            d.b(this.fyb.mContext, "profile", ".ui.ContactInfoUI", intent);
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            if (!str.equals("weixin://setting/plugin/qqmail")) {
                return false;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", "qqmail");
            if (this.fyb.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            d.b(this.fyb.mContext, "profile", ".ui.ContactInfoUI", intent);
            return true;
        }
    }

    @a
    class SettingPluginQQMsgUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        SettingPluginQQMsgUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://setting/plugin/qqmsg")) {
                return new i(str, 13, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{13};
        }

        final boolean a(i iVar, e eVar) {
            return false;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class SettingPluginSxMsgUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        SettingPluginSxMsgUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://setting/plugin/sxmsg")) {
                return new i(str, 11, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{11};
        }

        final boolean a(i iVar, e eVar) {
            return false;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class SettingPrivacyUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        SettingPrivacyUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://setting/privacy")) {
                return new i(str, 15, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{15};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 15) {
                return false;
            }
            if (eVar != null) {
                eVar.a(iVar);
            }
            LauncherUI bPI = LauncherUI.bPI();
            if (bPI != null) {
                bPI.uRM.SD("tab_settings");
            }
            d.w(this.fyb.mContext, "setting", ".ui.setting.SettingsPrivacyUI");
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            if (!str.equals("weixin://setting/privacy")) {
                return false;
            }
            LauncherUI bPI = LauncherUI.bPI();
            if (bPI != null) {
                bPI.uRM.SD("tab_settings");
            }
            Intent intent = new Intent();
            if (this.fyb.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            d.b(this.fyb.mContext, "setting", ".ui.setting.SettingsPrivacyUI", intent);
            return true;
        }
    }

    @a
    class TransferUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        TransferUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/retrysendmsg")) {
                return new i(str, 39, null);
            }
            if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/rebacksendmsg")) {
                return new i(str, 40, null);
            }
            if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchbalance")) {
                return new i(str, 41, null);
            }
            return str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchlqt") ? new i(str, 42, null) : null;
        }

        final int[] oN() {
            return new int[]{39, 40, 41, 42};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar != null) {
                if (iVar.type == 42) {
                    d.w(this.fyb.mContext, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                    return true;
                } else if (iVar.type == 41) {
                    d.w(this.fyb.mContext, "wallet", ".balance.ui.WalletBalanceManagerUI");
                    return true;
                } else if (iVar.type == 39) {
                    if (iVar.data != null && (iVar.data instanceof Bundle)) {
                        final Bundle bundle = (Bundle) iVar.data;
                        g.a(this.fyb.mContext, this.fyb.mContext.getString(R.l.eKx), this.fyb.mContext.getString(R.l.dIs), this.fyb.mContext.getString(R.l.eLt), this.fyb.mContext.getString(R.l.dGs), new OnClickListener(this) {
                            final /* synthetic */ TransferUriSpanHandler fyn;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                String string = bundle.getString("transaction_id");
                                String string2 = bundle.getString("receiver_name");
                                Intent intent = new Intent();
                                intent.putExtra("transaction_id", string);
                                intent.putExtra("receiver_name", string2);
                                d.b(ab.getContext(), "remittance", ".ui.RemittanceResendMsgUI", intent);
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ TransferUriSpanHandler fyn;

                            {
                                this.fyn = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                    return true;
                } else if (iVar.type == 40) {
                    if (iVar.data != null && (iVar.data instanceof Bundle)) {
                        Bundle bundle2 = (Bundle) iVar.data;
                        b mhVar = new mh();
                        mhVar.fTz.fTA = bundle2.getString("transaction_id");
                        mhVar.fTz.fST = bundle2.getString("transfer_id");
                        mhVar.fTz.fTB = bundle2.getInt("total_fee");
                        mhVar.fTz.fTC = bundle2.getString("sender_name");
                        com.tencent.mm.sdk.b.a.urY.m(mhVar);
                    }
                    return true;
                }
            }
            return false;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class VerifyContactUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        VerifyContactUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://findfriend/verifycontact")) {
                return new i(str, 4, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{4};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type != 4) {
                return false;
            }
            if (eVar != null) {
                eVar.a(iVar);
            }
            return true;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class VoipCallAgainUrilSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet fyb;

        VoipCallAgainUrilSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.fyb = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final i bv(String str) {
            if (str.trim().startsWith("weixin://voip/callagain/")) {
                return new i(str, 38, null);
            }
            return null;
        }

        final int[] oN() {
            return new int[]{38};
        }

        final boolean a(i iVar, e eVar) {
            if (iVar.type == 38) {
                Uri parse = Uri.parse(iVar.url);
                String queryParameter = parse.getQueryParameter("username");
                String queryParameter2 = parse.getQueryParameter("isvideocall");
                b rrVar = new rr();
                rrVar.fYI.fJK = 5;
                rrVar.fYI.fJL = queryParameter;
                rrVar.fYI.context = this.fyb.mContext;
                if (!(queryParameter == null || queryParameter.equals(""))) {
                    if (queryParameter2 == null || !queryParameter2.equals("true")) {
                        rrVar.fYI.fYD = 4;
                    } else {
                        rrVar.fYI.fYD = 2;
                    }
                    com.tencent.mm.sdk.b.a.urY.m(rrVar);
                    return true;
                }
            }
            return false;
        }

        final boolean a(String str, boolean z, o oVar, Bundle bundle) {
            return false;
        }
    }

    public URISpanHandlerSet(Context context) {
        this.mContext = context == null ? ab.getContext() : this.mContext;
    }
}
