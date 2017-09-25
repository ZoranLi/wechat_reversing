package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.e.a.ct;
import com.tencent.mm.e.a.mj;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo.WxaEntryInfo;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.m;
import com.tencent.mm.modelbiz.s;
import com.tencent.mm.modelbiz.v;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.protocal.c.alx;
import com.tencent.mm.protocal.c.ayu;
import com.tencent.mm.protocal.c.ayv;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.protocal.c.bed;
import com.tencent.mm.protocal.c.bpl;
import com.tencent.mm.protocal.c.my;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class c implements com.tencent.mm.modelbiz.g.a, m, com.tencent.mm.pluginsdk.d.a, e {
    public MMActivity fCi;
    private SharedPreferences hgx;
    private boolean huA;
    private String huC;
    private List<com.tencent.mm.modelbiz.BizInfo.a> hus;
    private ExtInfo hut;
    public p irJ;
    public f isJ;
    public boolean jWp;
    public BizInfo jZc;
    public x jiL;
    private boolean kmK;
    private CheckBoxPreference kti;
    private boolean osM;
    private int osO;
    String osP;
    private String osT;
    private j otS;
    private List<WxaEntryInfo> otT;
    private my otU;
    private boolean otV;
    private boolean otW;
    public boolean otX;
    private int otY;
    private String otZ;
    private boolean oua;
    h oub;
    private Bundle ouc;
    public SnsAdClick oud;
    private String oue;

    private static class a extends BitmapDrawable implements com.tencent.mm.platformtools.j.a {
        private String url;

        public a(Resources resources, String str) {
            boolean z = true;
            Bitmap c = com.tencent.mm.u.ag.a.hlU != null ? b.c(com.tencent.mm.u.ag.a.hlU.eY(16), 2.0f) : null;
            String str2 = "MicroMsg.ContactWidgetBizInfo";
            String str3 = "verify bmp is null ? %B";
            Object[] objArr = new Object[1];
            if (c != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            w.i(str2, str3, objArr);
            super(resources, c);
            this.url = str;
            com.tencent.mm.platformtools.j.a(this);
        }

        public final void draw(Canvas canvas) {
            Bitmap a = com.tencent.mm.platformtools.j.a(new i(this) {
                final /* synthetic */ a ouk;

                {
                    this.ouk = r1;
                }

                public final boolean Nr() {
                    return false;
                }

                public final boolean Nq() {
                    return false;
                }

                public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.i.a aVar, String str) {
                    if (com.tencent.mm.platformtools.i.a.ihH == aVar) {
                        try {
                            d.a(bitmap, 100, CompressFormat.PNG, Nm(), false);
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.ContactWidgetBizInfo", e, "", new Object[0]);
                            w.w("MicroMsg.ContactWidgetBizInfo", "save bitmap fail");
                        }
                    }
                    w.d("MicroMsg.ContactWidgetBizInfo", "get bitmap, from %s", new Object[]{aVar.toString()});
                    return bitmap;
                }

                public final void Nt() {
                }

                public final void F(String str, boolean z) {
                }

                public final void a(com.tencent.mm.platformtools.i.a aVar, String str) {
                }

                public final i.b Nl() {
                    return null;
                }

                public final String Nm() {
                    StringBuilder stringBuilder = new StringBuilder();
                    ap.yY();
                    return stringBuilder.append(com.tencent.mm.u.c.xo()).append(aa.Pq(this.ouk.url)).toString();
                }

                public final String No() {
                    return this.ouk.url;
                }

                public final Bitmap Ns() {
                    return null;
                }

                public final String Nn() {
                    return this.ouk.url;
                }

                public final String Np() {
                    return this.ouk.url;
                }
            });
            if (a == null || a.isRecycled()) {
                a = null;
            }
            Rect bounds = getBounds();
            if (a != null) {
                canvas.drawBitmap(a, null, bounds, null);
            }
        }

        public final void k(String str, Bitmap bitmap) {
            if (this.url.equals(str)) {
                invalidateSelf();
            }
        }
    }

    private c(MMActivity mMActivity) {
        this.otU = null;
        this.otV = false;
        this.otW = false;
        this.huA = false;
        this.otX = false;
        this.otY = 0;
        this.oub = null;
        this.hgx = null;
        this.oud = null;
        this.oue = null;
        this.irJ = null;
        this.jWp = false;
        this.fCi = mMActivity;
    }

    public c(MMActivity mMActivity, String str, my myVar) {
        this(mMActivity);
        this.osT = str;
        this.otU = myVar;
    }

    public final boolean sa(String str) {
        int i = 4;
        if (str == null) {
            return false;
        }
        String str2;
        String str3;
        if (str.equals("contact_info_verifyuser_weibo")) {
            com.tencent.mm.plugin.profile.ui.a.a aVar = new com.tencent.mm.plugin.profile.ui.a.a(this.fCi);
            str2 = this.jiL.gkF;
            str3 = this.jiL.field_username;
            if (str2 == null) {
                w.e("MicroMsg.ViewTWeibo", "null weibo id");
                return true;
            }
            ap.vd().a(cf.CTRL_INDEX, aVar);
            aVar.owx = new com.tencent.mm.plugin.profile.a.a(bg.mz(str2).replace("http://t.qq.com/", "").trim(), str3);
            ap.vd().a(aVar.owx, 0);
            aVar.owy.v(3000, 3000);
            return true;
        } else if ("contact_info_biz_go_chatting".endsWith(str)) {
            if (this.oud != null) {
                com.tencent.mm.sdk.b.b mjVar = new mj();
                this.oud.hTp = 5;
                mjVar.fTF.fTG = this.oud;
                com.tencent.mm.sdk.b.a.urY.m(mjVar);
            }
            if (this.jZc == null || !(this.jZc.CH() || this.jZc.CJ())) {
                r0 = new Intent();
                if (this.fCi.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
                    r0.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                if (this.osM) {
                    r0.putExtra("Chat_User", this.jiL.field_username);
                    r0.putExtra("Chat_Mode", 1);
                    this.fCi.setResult(-1, r0);
                } else {
                    r0.putExtra("Chat_User", this.jiL.field_username);
                    r0.putExtra("Chat_Mode", 1);
                    r0.putExtra("finish_direct", true);
                    com.tencent.mm.plugin.profile.a.imv.e(r0, this.fCi);
                }
            } else {
                r0 = new Intent();
                if (this.jZc.CJ()) {
                    str2 = this.jZc.CO();
                    if (bg.mA(str2)) {
                        w.w("MicroMsg.ContactWidgetBizInfo", "contact_info_biz_go_chatting fatherUserName is empty");
                        return false;
                    }
                    r0.putExtra("enterprise_biz_name", str2);
                    r0.putExtra("enterprise_biz_display_name", n.eK(str2));
                } else {
                    r0.putExtra("enterprise_biz_name", this.jiL.field_username);
                    r0.putExtra("enterprise_biz_display_name", n.eK(this.jiL.field_username));
                }
                r0.addFlags(67108864);
                com.tencent.mm.bb.d.a(this.fCi, ".ui.conversation.EnterpriseConversationUI", r0);
                this.fCi.finish();
            }
            ah(5, null);
            return true;
        } else if ("contact_info_biz_add".endsWith(str)) {
            if (this.fCi.getIntent() != null && this.fCi.getIntent().getBooleanExtra("KIsHardDevice", false)) {
                r0 = this.fCi.getIntent().getStringExtra("KHardDeviceBindTicket");
                if (bg.mA(r0)) {
                    w.i("MicroMsg.ContactWidgetBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
                } else if (!aTA()) {
                    w.d("MicroMsg.ContactWidgetBizInfo", "IsHardDevice, bindTicket = %s", new Object[]{r0});
                    ap.vd().a(536, this);
                    com.tencent.mm.sdk.b.b cpVar = new cp();
                    cpVar.fGc.fGe = r0;
                    cpVar.fGc.opType = 1;
                    com.tencent.mm.sdk.b.a.urY.m(cpVar);
                    final k kVar = cpVar.fGd.fGg;
                    r1 = this.fCi;
                    this.fCi.getString(R.l.dIO);
                    this.irJ = g.a(r1, this.fCi.getString(R.l.dJd), true, new OnCancelListener(this) {
                        final /* synthetic */ c ouf;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().b(536, this.ouf);
                            com.tencent.mm.sdk.b.b cpVar = new cp();
                            cpVar.fGc.opType = 2;
                            cpVar.fGc.fGg = kVar;
                            com.tencent.mm.sdk.b.a.urY.m(cpVar);
                        }
                    });
                    if (this.otY != 0) {
                        return true;
                    }
                    com.tencent.mm.plugin.report.service.g.oUh.i(11263, new Object[]{Integer.valueOf(this.otY), this.jiL.field_username});
                    return true;
                }
            }
            com.tencent.mm.pluginsdk.ui.applet.a aVar2 = new com.tencent.mm.pluginsdk.ui.applet.a(this.fCi, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                final /* synthetic */ c ouf;

                {
                    this.ouf = r1;
                }

                public final void a(boolean z, boolean z2, String str, String str2) {
                    if (z) {
                        BizInfo hW;
                        g.bl(this.ouf.fCi, this.ouf.fCi.getString(R.l.dXD));
                        this.ouf.isJ.aV("contact_info_time_expired", true);
                        af afVar = this.ouf.jiL;
                        if (afVar == null || bg.mA(str)) {
                            w.e("MicroMsg.ContactWidgetBizInfo", "respUsername == " + str + ", contact = " + afVar);
                        } else {
                            if (o.eT(afVar.field_username)) {
                                String mz = bg.mz(afVar.field_username);
                                hW = com.tencent.mm.modelbiz.e.hW(mz);
                                if (hW != null) {
                                    hW.field_username = str;
                                }
                                com.tencent.mm.modelbiz.w.DH().hP(mz);
                                afVar.bX(mz);
                            } else {
                                hW = null;
                            }
                            afVar.setUsername(str);
                            if (((int) afVar.gTQ) == 0) {
                                ap.yY();
                                com.tencent.mm.u.c.wR().S(afVar);
                            }
                            if (((int) afVar.gTQ) <= 0) {
                                w.e("MicroMsg.ContactWidgetBizInfo", "addContact : insert contact failed");
                            } else {
                                o.p(afVar);
                                ap.yY();
                                afVar = com.tencent.mm.u.c.wR().Rc(afVar.field_username);
                                if (hW != null) {
                                    com.tencent.mm.modelbiz.w.DH().d(hW);
                                } else {
                                    BizInfo hW2 = com.tencent.mm.modelbiz.e.hW(afVar.field_username);
                                    boolean z3 = afVar.bLe() && com.tencent.mm.modelbiz.a.Cy();
                                    if (hW2 == null || (hW2.CB() && !z3)) {
                                        w.d("MicroMsg.ContactWidgetBizInfo", "shouldUpdate");
                                        com.tencent.mm.u.ag.a.hlS.J(afVar.field_username, "");
                                        com.tencent.mm.x.b.he(afVar.field_username);
                                    } else if (afVar.bLh() && !z3) {
                                        w.d("MicroMsg.ContactWidgetBizInfo", "update contact, last check time=%d", new Object[]{Integer.valueOf(afVar.gkI)});
                                        com.tencent.mm.u.ag.a.hlS.J(afVar.field_username, "");
                                        com.tencent.mm.x.b.he(afVar.field_username);
                                    }
                                }
                            }
                        }
                        this.ouf.otX = true;
                        if (this.ouf.oud != null) {
                            com.tencent.mm.sdk.b.b mjVar = new mj();
                            this.ouf.oud.hTp = 4;
                            mjVar.fTF.fTG = this.ouf.oud;
                            com.tencent.mm.sdk.b.a.urY.m(mjVar);
                        }
                        hW = com.tencent.mm.modelbiz.w.DH().hO(this.ouf.jiL.field_username);
                        hW.field_status = 1;
                        if (!bg.mA(hW.field_extInfo) || bg.mA(hW.field_username) || this.ouf.jZc == null || !hW.field_username.equals(bg.mz(this.ouf.jZc.field_username))) {
                            com.tencent.mm.modelbiz.w.DH().e(hW);
                        } else {
                            com.tencent.mm.modelbiz.w.DH().e(this.ouf.jZc);
                        }
                        boolean booleanExtra = this.ouf.fCi.getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
                        boolean booleanExtra2 = this.ouf.fCi.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
                        Intent intent;
                        if (hW.CH()) {
                            intent = new Intent();
                            intent.putExtra("enterprise_biz_name", this.ouf.jiL.field_username);
                            intent.putExtra("enterprise_biz_display_name", n.eK(this.ouf.jiL.field_username));
                            intent.putExtra("enterprise_from_scene", 7);
                            intent.addFlags(67108864);
                            com.tencent.mm.bb.d.a(this.ouf.fCi, ".ui.conversation.EnterpriseConversationUI", intent);
                        } else {
                            intent = new Intent();
                            intent.putExtra("Chat_User", this.ouf.jiL.field_username);
                            intent.putExtra("key_has_add_contact", true);
                            intent.putExtra("finish_direct", true);
                            if (booleanExtra2) {
                                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            }
                            com.tencent.mm.plugin.profile.a.imv.e(intent, this.ouf.fCi);
                            if (!booleanExtra) {
                                if (booleanExtra2) {
                                }
                                this.ouf.ah(3, null);
                            }
                        }
                        this.ouf.fCi.finish();
                        this.ouf.ah(3, null);
                    }
                }
            });
            LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(this.osO));
            if (this.huC != null) {
                aVar2.sLQ = this.huC;
            }
            if (!bg.mA(this.osP)) {
                aVar2.osP = this.osP;
            }
            aVar2.sLX = true;
            aVar2.a(this.jiL.field_username, linkedList, this.oue);
            if (this.otY != 0) {
                return true;
            }
            com.tencent.mm.plugin.report.service.g.oUh.i(11263, new Object[]{Integer.valueOf(this.otY), this.jiL.field_username});
            return true;
        } else if ("contact_info_biz_read_msg_online".endsWith(str)) {
            return true;
        } else {
            if (!"contact_info_stick_biz".equals(str)) {
                int i2;
                if (!(!"contact_info_guarantee_info".equals(str) || this.hut.CZ() == null || bg.mA(this.hut.CZ().hvt))) {
                    r0 = new Intent();
                    r0.putExtra("rawUrl", this.hut.CZ().hvt);
                    r0.putExtra("useJs", true);
                    r0.putExtra("vertical_scroll", true);
                    r0.putExtra("geta8key_scene", 3);
                    com.tencent.mm.bb.d.b(this.fCi, "webview", ".ui.tools.WebViewUI", r0);
                }
                if (str.startsWith("contact_info_bizinfo_external#")) {
                    i2 = bg.getInt(str.replace("contact_info_bizinfo_external#", ""), -1);
                    if (i2 >= 0 && i2 < this.hus.size()) {
                        com.tencent.mm.modelbiz.BizInfo.a aVar3 = (com.tencent.mm.modelbiz.BizInfo.a) this.hus.get(i2);
                        str2 = aVar3.url;
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str2);
                        intent.putExtra("useJs", true);
                        intent.putExtra("vertical_scroll", true);
                        intent.putExtra("geta8key_scene", 3);
                        intent.putExtra("KPublisherId", "brand_profile");
                        intent.putExtra("prePublishId", "brand_profile");
                        if ((this.ouc != null && (this.osO == 39 || this.osO == 56 || this.osO == 35)) || this.osO == 87 || this.osO == 89 || this.osO == 85 || this.osO == 88) {
                            w.d("MicroMsg.ContactWidgetBizInfo", "from biz search.");
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("KFromBizSearch", true);
                            bundle.putBundle("KBizSearchExtArgs", this.ouc);
                            intent.putExtra("jsapiargs", bundle);
                            i = com.tencent.mm.j.a.ez(this.jiL.field_type) ? 7 : 6;
                            int identifier = this.fCi.getResources().getIdentifier(aVar3.huw, "string", this.fCi.getPackageName());
                            r0 = aVar3.title;
                            if (identifier > 0) {
                                r0 = this.fCi.getString(identifier);
                            }
                            ah(i, r0);
                        }
                        com.tencent.mm.bb.d.b(this.fCi, "webview", ".ui.tools.WebViewUI", intent);
                        return true;
                    }
                }
                if ("contact_info_subscribe_bizinfo".endsWith(str) || "contact_info_show_brand".endsWith(str) || "contact_info_locate".endsWith(str)) {
                    final BizInfo bizInfo = this.jZc;
                    if (bizInfo == null) {
                        return true;
                    }
                    if ("contact_info_subscribe_bizinfo".endsWith(str)) {
                        if (!bizInfo.CG()) {
                            if (bizInfo.Cz()) {
                                bizInfo.field_brandFlag |= 1;
                                if (this.hut == null && bizInfo != null) {
                                    this.hut = bizInfo.bd(false);
                                }
                                if (this.hut != null && this.hut.CS() && com.tencent.mm.bb.d.Jt("brandservice")) {
                                    this.isJ.aV("contact_info_template_recv", false);
                                } else {
                                    this.isJ.aV("contact_info_template_recv", true);
                                }
                            } else {
                                bizInfo.field_brandFlag &= -2;
                                this.isJ.aV("contact_info_template_recv", true);
                            }
                            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                            Object[] objArr = new Object[4];
                            objArr[0] = bizInfo.field_username;
                            objArr[1] = Integer.valueOf(1);
                            if (bizInfo.Cz()) {
                                i = 3;
                            }
                            objArr[2] = Integer.valueOf(i);
                            objArr[3] = Integer.valueOf(0);
                            gVar.i(13307, objArr);
                        } else if (bizInfo != null) {
                            if (bizInfo.CJ()) {
                                ap.vd().a(1363, this);
                                if (((CheckBoxPreference) this.isJ.Td("contact_info_subscribe_bizinfo")).isChecked()) {
                                    i2 = 0;
                                } else {
                                    i2 = 4;
                                }
                                final k bVar = new com.tencent.mm.plugin.profile.a.b(bizInfo.field_username, i2);
                                ap.vd().a(bVar, 0);
                                Context context = this.fCi;
                                this.fCi.getString(R.l.dIO);
                                this.irJ = g.a(context, this.fCi.getString(R.l.dJd), true, new OnCancelListener(this) {
                                    final /* synthetic */ c ouf;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ap.vd().c(bVar);
                                        ap.vd().b(1363, this.ouf);
                                    }
                                });
                            } else if (bizInfo.CH()) {
                                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("contact_info_subscribe_bizinfo");
                                com.tencent.mm.modelbiz.w.DO();
                                final v a = com.tencent.mm.modelbiz.c.a(bizInfo.field_username, !checkBoxPreference.isChecked(), this);
                                r1 = this.fCi;
                                this.fCi.getString(R.l.dIO);
                                this.irJ = g.a(r1, this.fCi.getString(R.l.dJd), true, new OnCancelListener(this) {
                                    final /* synthetic */ c ouf;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        com.tencent.mm.modelbiz.w.DO();
                                        com.tencent.mm.modelbiz.c.a(a);
                                    }
                                });
                            }
                        }
                    } else if ("contact_info_show_brand".endsWith(str)) {
                        boolean z;
                        if ((bizInfo.field_brandFlag & 2) == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            bizInfo.field_brandFlag |= 2;
                        } else {
                            bizInfo.field_brandFlag &= -3;
                        }
                    } else if ("contact_info_locate".endsWith(str)) {
                        if (bizInfo.CA()) {
                            bizInfo.field_brandFlag &= -5;
                        } else {
                            this.oub = g.a(this.fCi, this.fCi.getString(R.l.dTh, new Object[]{this.jiL.tL()}), this.fCi.getString(R.l.dIO), new OnClickListener(this) {
                                final /* synthetic */ c ouf;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    bizInfo.field_hadAlert = 1;
                                    bizInfo.field_brandFlag |= 4;
                                    this.ouf.a(bizInfo, true);
                                }
                            }, new OnClickListener(this) {
                                final /* synthetic */ c ouf;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    bizInfo.field_hadAlert = 1;
                                    this.ouf.a(bizInfo, false);
                                }
                            });
                        }
                    }
                    if (bizInfo.CJ() || bizInfo.CH()) {
                        return true;
                    }
                    a(bizInfo, false);
                    return true;
                } else if ("contact_info_verifyuser".endsWith(str)) {
                    r0 = this.jZc;
                    if (r0 == null) {
                        return true;
                    }
                    ExtInfo bd = r0.bd(false);
                    if (bd == null) {
                        return true;
                    }
                    r0 = null;
                    if (bd.Db() != null && !bg.mA(bd.Db().hvo)) {
                        r0 = bd.Db().hvo;
                    } else if (!(bd.Dc() == null || bg.mA(bd.Dc().hvw))) {
                        r0 = bd.Dc().hvw;
                    }
                    if (bg.mA(r0)) {
                        return true;
                    }
                    r1 = new Intent();
                    r1.putExtra("rawUrl", r0);
                    r1.putExtra("useJs", true);
                    r1.putExtra("vertical_scroll", true);
                    r1.putExtra("geta8key_scene", 3);
                    com.tencent.mm.bb.d.b(this.fCi, "webview", ".ui.tools.WebViewUI", r1);
                    return true;
                } else if ("contact_info_trademark".endsWith(str)) {
                    r0 = this.jZc;
                    if (r0 == null || r0.bd(false) == null || bg.mA(r0.bd(false).CU())) {
                        return true;
                    }
                    r1 = new Intent();
                    r1.putExtra("rawUrl", r0.bd(false).CU());
                    r1.putExtra("useJs", true);
                    r1.putExtra("vertical_scroll", true);
                    r1.putExtra("geta8key_scene", 3);
                    com.tencent.mm.bb.d.b(this.fCi, "webview", ".ui.tools.WebViewUI", r1);
                    return true;
                } else {
                    if ("contact_is_mute".endsWith(str)) {
                        this.kmK = !this.kmK;
                        if (this.kmK) {
                            o.n(this.jiL);
                        } else {
                            o.o(this.jiL);
                        }
                        gj(this.kmK);
                    }
                    if ("enterprise_contact_info_enter".equals(str)) {
                        if (this.fCi == null) {
                            w.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise context is null");
                        } else if (this.jZc == null) {
                            w.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise bizInfo is null");
                        } else {
                            r0 = new Intent();
                            r0.putExtra("enterprise_biz_name", this.jZc.field_username);
                            r0.addFlags(67108864);
                            com.tencent.mm.bb.d.b(this.fCi, "brandservice", ".ui.EnterpriseBizContactListUI", r0);
                        }
                    }
                    if ("contact_info_biz_disable".equals(str)) {
                        g.a(this.fCi, this.fCi.getString(R.l.eeF), "", this.fCi.getString(R.l.eeE), this.fCi.getString(R.l.dGs), new OnClickListener(this) {
                            final /* synthetic */ c ouf;

                            {
                                this.ouf = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.ouf.gi(false);
                            }
                        }, null);
                    }
                    if ("contact_info_biz_enable".equals(str)) {
                        gi(true);
                    }
                    if ("contact_info_template_recv".equals(str)) {
                        r0 = new Intent();
                        r0.putExtra("enterprise_biz_name", this.jZc.field_username);
                        com.tencent.mm.bb.d.b(this.fCi, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", r0);
                    }
                    if ("contact_info_service_phone".equals(str)) {
                        Preference Td = this.isJ.Td("contact_info_service_phone");
                        if (!(Td == null || Td.getSummary() == null || bg.mA(Td.getSummary().toString()))) {
                            str3 = Td.getSummary().toString();
                            g.a(this.fCi, true, str3, "", this.fCi.getString(R.l.dXX), this.fCi.getString(R.l.dGs), new OnClickListener(this) {
                                final /* synthetic */ c ouf;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent("android.intent.action.DIAL");
                                    intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                    intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str3).toString()));
                                    if (bg.j(this.ouf.fCi, intent)) {
                                        this.ouf.fCi.startActivity(intent);
                                    }
                                }
                            }, null);
                        }
                    }
                    if ("contact_info_expose_btn".equals(str)) {
                        aTB();
                    }
                    if (!str.equals("biz_placed_to_the_top")) {
                        return true;
                    }
                    w.d("MicroMsg.ContactWidgetBizInfo", "changePlacedTop");
                    if (this.hgx == null) {
                        this.hgx = this.fCi.getSharedPreferences(this.fCi.getPackageName() + "_preferences", 0);
                    }
                    if (this.jiL == null) {
                        return true;
                    }
                    if (this.jiL.tG()) {
                        w.d("MicroMsg.ContactWidgetBizInfo", "unSetPlaceTop:%s", new Object[]{this.jiL.field_username});
                        o.m(this.jiL.field_username, true);
                        this.hgx.edit().putBoolean("biz_placed_to_the_top", false).commit();
                        return true;
                    }
                    com.tencent.mm.u.g.eq(this.jiL.field_username);
                    w.d("MicroMsg.ContactWidgetBizInfo", "setPlaceTop:%s", new Object[]{this.jiL.field_username});
                    this.hgx.edit().putBoolean("biz_placed_to_the_top", true).commit();
                    return true;
                }
            } else if (((CheckBoxPreference) this.isJ.Td("contact_info_stick_biz")).isChecked()) {
                com.tencent.mm.plugin.report.service.g.oUh.i(13307, new Object[]{this.jiL.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0)});
                com.tencent.mm.u.g.eq(this.jiL.field_username);
                return true;
            } else {
                o.m(this.jiL.field_username, true);
                com.tencent.mm.plugin.report.service.g.oUh.i(13307, new Object[]{this.jiL.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0)});
                return true;
            }
        }
    }

    public final void gi(boolean z) {
        final k cVar = new com.tencent.mm.plugin.profile.a.c(this.jZc.field_username, !z);
        ap.vd().a(1394, this);
        ap.vd().a(cVar, 0);
        Context context = this.fCi;
        this.fCi.getString(R.l.dIO);
        this.irJ = g.a(context, this.fCi.getString(R.l.dJd), true, new OnCancelListener(this) {
            final /* synthetic */ c ouf;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(cVar);
                ap.vd().b(1394, this.ouf);
            }
        });
    }

    public final void a(BizInfo bizInfo, boolean z) {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("contact_info_subscribe_bizinfo");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.isJ.Td("contact_info_locate");
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_alx = new alx();
        com_tencent_mm_protocal_c_alx.hAR = bizInfo.field_brandFlag;
        com_tencent_mm_protocal_c_alx.jNj = this.jiL.field_username;
        if (rs(this.osO)) {
            ap.yY();
            com.tencent.mm.u.c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(58, com_tencent_mm_protocal_c_alx));
        } else {
            ap.yY();
            com.tencent.mm.u.c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(47, com_tencent_mm_protocal_c_alx));
        }
        com.tencent.mm.modelbiz.w.DH().c(bizInfo, new String[0]);
        checkBoxPreference.vqm = bizInfo.Cz();
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.vqm = bizInfo.CA();
        }
        if (z) {
            aTy();
        }
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2;
        Assert.assertTrue(xVar != null);
        if (bg.mz(xVar.field_username).length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (fVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        this.isJ = fVar;
        this.jiL = xVar;
        this.osM = z;
        this.osO = i;
        this.otY = this.fCi.getIntent().getIntExtra("add_more_friend_search_scene", 0);
        this.oud = (SnsAdClick) this.fCi.getIntent().getParcelableExtra("KSnsAdTag");
        this.ouc = this.fCi.getIntent().getBundleExtra("Contact_Ext_Args");
        this.oue = this.fCi.getIntent().getStringExtra("key_add_contact_report_info");
        aTy();
        if (xVar != null) {
            com.tencent.mm.modelbiz.w.DR().hB(xVar.field_username);
            if (com.tencent.mm.modelbiz.e.hZ(xVar.field_username)) {
                String str = xVar.field_username;
                if (com.tencent.mm.modelbiz.e.dr(str)) {
                    com.tencent.mm.modelbiz.w.DN();
                    com.tencent.mm.modelbiz.a.h.a(str, this);
                    str = com.tencent.mm.modelbiz.e.hW(str).CO();
                    if (str != null) {
                        com.tencent.mm.modelbiz.w.DR().hB(str);
                    }
                } else if (com.tencent.mm.modelbiz.e.ib(str)) {
                    com.tencent.mm.modelbiz.w.DO();
                    com.tencent.mm.modelbiz.c.a(str, this);
                    com.tencent.mm.modelbiz.w.DH();
                    str = com.tencent.mm.modelbiz.d.hS(str);
                    if (str != null) {
                        com.tencent.mm.modelbiz.w.DR().hB(str);
                    }
                }
            }
        }
        return true;
    }

    private void aTy() {
        BizInfo bizInfo;
        CheckBoxPreference checkBoxPreference;
        ExtInfo extInfo;
        Preference Td;
        KeyValuePreference keyValuePreference;
        Bitmap c;
        boolean z;
        Drawable bitmapDrawable;
        String string;
        Bitmap c2;
        CharSequence charSequence;
        IndexOutOfBoundsException e;
        int indexOf;
        com.tencent.mm.modelbiz.h DG;
        com.tencent.mm.modelbiz.f ig;
        com.tencent.mm.modelbiz.f fVar;
        IconWidgetPreference iconWidgetPreference;
        com.tencent.mm.modelbiz.g DI;
        CheckBoxPreference checkBoxPreference2;
        String tL;
        int identifier;
        adI();
        this.isJ.removeAll();
        this.isJ.addPreferencesFromResource(R.o.ftm);
        if (this.otX) {
            this.isJ.aV("contact_info_time_expired", true);
        }
        BizInfo hW = com.tencent.mm.modelbiz.e.hW(this.jiL.field_username);
        this.hus = null;
        this.hut = null;
        this.otT = null;
        if ((hW == null || hW.bd(false) == null) && this.otU != null) {
            hW = new BizInfo();
            hW.field_username = this.jiL.field_username;
            hW.field_brandFlag = this.otU.hAR;
            hW.field_brandIconURL = this.otU.hAU;
            hW.field_brandInfo = this.otU.hAT;
            hW.field_extInfo = this.otU.hAS;
            bizInfo = hW;
        } else {
            bizInfo = hW;
        }
        if (bizInfo != null && bizInfo.field_brandInfo == null && bizInfo.field_extInfo == null && this.otU != null) {
            bizInfo.field_username = this.jiL.field_username;
            bizInfo.field_brandFlag = this.otU.hAR;
            bizInfo.field_brandIconURL = this.otU.hAU;
            bizInfo.field_brandInfo = this.otU.hAT;
            bizInfo.field_extInfo = this.otU.hAS;
        }
        BizInfoHeaderPreference bizInfoHeaderPreference = (BizInfoHeaderPreference) this.isJ.Td("contact_info_header_bizinfo");
        if (bizInfoHeaderPreference == null || bg.mA(this.jiL.field_username)) {
            w.w("MicroMsg.ContactWidgetBizInfo", "head pref is null");
            this.isJ.aV("contact_info_header_bizinfo", true);
        } else {
            af afVar = this.jiL;
            bizInfoHeaderPreference.osB = this.osT;
            bizInfoHeaderPreference.jZc = bizInfo;
            bizInfoHeaderPreference.onDetach();
            ap.yY();
            com.tencent.mm.u.c.wR().a(bizInfoHeaderPreference);
            com.tencent.mm.x.n.Bl().d(bizInfoHeaderPreference);
            com.tencent.mm.modelbiz.w.DP().a(bizInfoHeaderPreference);
            bizInfoHeaderPreference.jiL = afVar;
            Assert.assertTrue("initView: contact username is null", bg.mz(afVar.field_username).length() > 0);
            bizInfoHeaderPreference.KC();
        }
        this.isJ.aV("biz_placed_to_the_top", true);
        this.isJ.aV("contact_info_biz_enable", true);
        this.isJ.aV("contact_info_biz_disable", true);
        this.isJ.aV("contact_info_stick_biz", true);
        if (bizInfo != null) {
            if (bizInfo.CI()) {
                this.isJ.aV("contact_info_biz_add", true);
                this.isJ.aV("contact_info_expose_btn", true);
                this.isJ.aV("contact_is_mute", false);
                this.kmK = this.jiL.tD();
                if (bizInfo.CJ()) {
                    this.isJ.aV("contact_info_biz_go_chatting", true);
                    this.isJ.aV("contact_info_stick_biz", !com.tencent.mm.j.a.ez(this.jiL.field_type));
                    checkBoxPreference = (CheckBoxPreference) this.isJ.Td("contact_info_stick_biz");
                    checkBoxPreference.vqm = this.jiL.tG();
                    checkBoxPreference.setTitle(R.l.eeC);
                    aTC();
                } else {
                    this.isJ.aV("contact_info_subscribe_bizinfo", true);
                    this.isJ.aV("contact_info_biz_go_chatting", true);
                    if (bizInfo.Cz()) {
                        this.isJ.aV("contact_info_biz_enable", true);
                        this.isJ.aV("contact_info_biz_disable", false);
                        this.isJ.Td("contact_info_biz_disable").setTitle(R.l.eeE);
                        this.isJ.aV("contact_is_mute", false);
                        this.isJ.aV("biz_placed_to_the_top", false);
                        this.kti = (CheckBoxPreference) this.isJ.Td("biz_placed_to_the_top");
                        this.kti.setTitle(R.l.eeT);
                        aTC();
                        if (bizInfo.CK()) {
                            this.isJ.aV("contact_info_locate", true);
                        }
                    } else {
                        this.isJ.aV("contact_info_biz_enable", false);
                        this.isJ.aV("contact_info_biz_disable", true);
                        this.isJ.Td("contact_info_biz_enable").setTitle(R.l.eeG);
                        this.isJ.aV("contact_is_mute", true);
                        this.isJ.aV("biz_placed_to_the_top", true);
                        this.isJ.aV("contact_info_locate", true);
                    }
                }
                gj(this.kmK);
            } else if (bizInfo.CH()) {
                this.isJ.aV("contact_info_locate", true);
                this.isJ.aV("contact_info_subscribe_bizinfo", false);
                this.isJ.aV("enterprise_contact_info_enter", false);
                this.isJ.Td("contact_info_biz_go_chatting").setTitle(R.l.eeH);
                this.isJ.aV("contact_info_stick_biz", !com.tencent.mm.j.a.ez(this.jiL.field_type));
                checkBoxPreference = (CheckBoxPreference) this.isJ.Td("contact_info_stick_biz");
                checkBoxPreference.vqm = this.jiL.tG();
                checkBoxPreference.setTitle(R.l.eeK);
                aTC();
                this.isJ.aV("contact_is_mute", true);
                this.kmK = this.jiL.tD();
                gj(this.kmK);
                this.isJ.Td("contact_is_mute").setSummary(R.l.dXZ);
            } else {
                f fVar2 = this.isJ;
                String str = "contact_info_stick_biz";
                boolean z2 = o.fh(this.jiL.field_username) || !com.tencent.mm.j.a.ez(this.jiL.field_type);
                fVar2.aV(str, z2);
                ((CheckBoxPreference) this.isJ.Td("contact_info_stick_biz")).vqm = this.jiL.tG();
                this.isJ.aV("contact_is_mute", true);
                this.kmK = false;
            }
            this.jZc = bizInfo;
            this.hus = bizInfo.CP();
            this.hut = bizInfo.bd(false);
            this.otT = this.hut.CQ();
            if (this.hut.CR()) {
                this.isJ.Td("near_field_service").setSummary(R.l.fnf);
            } else {
                this.isJ.aV("near_field_service", true);
            }
            if (this.hut.CW() != null) {
                this.otW = true;
                if (CD(this.hut.CW())) {
                    this.otV = true;
                    if (!com.tencent.mm.j.a.ez(this.jiL.field_type)) {
                        w.w("MicroMsg.ContactWidgetBizInfo", "expireTime not null, and %s is not my contact", new Object[]{this.jiL.field_username});
                        aTz();
                        if (o.fC(this.jiL.field_username) || CF(this.jiL.field_username)) {
                            aTz();
                        }
                    }
                }
                this.isJ.aV("contact_info_time_expired", true);
                aTz();
            } else {
                this.isJ.aV("contact_info_time_expired", true);
            }
            if (this.hut.CT() != null && this.hut.CT().length() > 0) {
                this.huC = this.hut.CT();
            }
            extInfo = this.hut;
            if (extInfo.hux != null) {
                extInfo.huA = "1".equals(extInfo.hux.optString("IsShowMember"));
            }
            this.huA = extInfo.huA;
            if (bg.mA(this.hut.Dh())) {
                this.isJ.aV("contact_info_service_phone", true);
            } else {
                this.isJ.aV("contact_info_service_phone", false);
                Td = this.isJ.Td("contact_info_service_phone");
                if (Td != null) {
                    Td.setSummary(this.hut.Dh());
                    Td.krt = this.fCi.getResources().getColor(R.e.aUA);
                }
            }
        } else {
            this.isJ.aV("contact_info_time_expired", true);
            w.e("MicroMsg.ContactWidgetBizInfo", "get biz info from storage, but return null");
        }
        if (bg.mA(this.jiL.signature)) {
            w.w("MicroMsg.ContactWidgetBizInfo", "has not desc info");
            this.isJ.aV("contact_info_user_desc", true);
            if (!this.otV) {
                this.isJ.aV("contact_info_time_expired", true);
            }
        } else {
            keyValuePreference = (KeyValuePreference) this.isJ.Td("contact_info_user_desc");
            if (keyValuePreference != null) {
                if (bg.mz(this.jiL.signature).trim().length() <= 0) {
                    this.isJ.aV("contact_info_user_desc", true);
                } else {
                    keyValuePreference.bSX();
                    keyValuePreference.vrl = false;
                    keyValuePreference.uTf = this.fCi.getString(R.l.dYs);
                    keyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.h.a(this.fCi, this.jiL.signature));
                    keyValuePreference.kZ(false);
                    if (com.tencent.mm.u.ag.a.hlU != null) {
                        c = b.c(com.tencent.mm.u.ag.a.hlU.eY(this.jiL.field_verifyFlag), 2.0f);
                    } else {
                        c = null;
                    }
                    String str2 = "MicroMsg.ContactWidgetBizInfo";
                    String str3 = "verify bmp is null ? %B";
                    Object[] objArr = new Object[1];
                    if (c == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    w.i(str2, str3, objArr);
                    if (c != null) {
                        bitmapDrawable = new BitmapDrawable(this.fCi.getResources(), c);
                    } else {
                        bitmapDrawable = null;
                    }
                    keyValuePreference.vrt = bitmapDrawable;
                    keyValuePreference.vrr = 8;
                }
            }
        }
        if (this.hut != null && this.hut.Db() != null && !bg.mA(this.hut.Db().hvm)) {
            com.tencent.mm.modelbiz.BizInfo.ExtInfo.c Db = this.hut.Db();
            keyValuePreference = (KeyValuePreference) this.isJ.Td("contact_info_verifyuser");
            if (keyValuePreference != null) {
                keyValuePreference.bSX();
                keyValuePreference.vrl = false;
                if (bg.mA(Db.hvn)) {
                    switch (Db.hvl) {
                        case 0:
                            string = this.fCi.getResources().getString(R.l.eap);
                            break;
                        case 1:
                            string = this.fCi.getResources().getString(R.l.dPL);
                            break;
                        case 2:
                            string = this.fCi.getResources().getString(R.l.dPM);
                            break;
                        default:
                            w.w("MicroMsg.ContactWidgetBizInfo", "getVerifyStr, error type %d", new Object[]{Integer.valueOf(Db.hvl)});
                            string = this.fCi.getResources().getString(R.l.dYs);
                            break;
                    }
                    keyValuePreference.uTf = string;
                } else {
                    keyValuePreference.uTf = Db.hvn;
                }
                if (com.tencent.mm.u.ag.a.hlU != null) {
                    c2 = b.c(com.tencent.mm.u.ag.a.hlU.eY(this.jiL.field_verifyFlag), 2.0f);
                } else {
                    c2 = null;
                }
                if (c2 != null) {
                    bitmapDrawable = new BitmapDrawable(this.fCi.getResources(), c2);
                } else {
                    bitmapDrawable = null;
                }
                str3 = "MicroMsg.ContactWidgetBizInfo";
                String str4 = "verify bmp is null ? %B";
                Object[] objArr2 = new Object[1];
                if (c2 == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr2[0] = Boolean.valueOf(z);
                w.i(str3, str4, objArr2);
                keyValuePreference.vrt = bitmapDrawable;
                if (Db.hvm != null) {
                    str3 = Db.hvp;
                    CharSequence a = com.tencent.mm.pluginsdk.ui.d.h.a(this.fCi, Db.hvm.trim());
                    if (bg.mA(str3)) {
                        charSequence = a;
                    } else {
                        try {
                            charSequence = new SpannableString(str3 + " " + a);
                            try {
                                charSequence.setSpan(new ForegroundColorSpan(-36352), 0, str3.length(), 17);
                            } catch (IndexOutOfBoundsException e2) {
                                e = e2;
                                w.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", new Object[]{e.getMessage()});
                                keyValuePreference.setSummary(charSequence);
                                if (this.hut != null) {
                                }
                                w.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
                                this.isJ.aV("contact_info_trademark", true);
                                if (this.hut != null) {
                                }
                                this.isJ.aV("contact_info_privilege", true);
                                indexOf = this.isJ.indexOf("contact_info_category2");
                                if (indexOf >= 0) {
                                }
                                w.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
                                if (!this.otV) {
                                }
                                this.isJ.aV("contact_info_verifyuser_weibo", true);
                                if (this.hut != null) {
                                }
                                this.isJ.aV("contact_info_reputation", true);
                                this.isJ.aV("contact_info_guarantee_info", true);
                                this.isJ.aV("contact_info_scope_of_business", true);
                                if (this.otT != null) {
                                }
                                this.isJ.aV("contact_info_bindwxainfo", true);
                                string = this.fCi.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
                                w.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[]{string, Boolean.valueOf(this.oua)});
                                if (!this.oua) {
                                    this.otZ = string;
                                    if (this.hut != null) {
                                        extInfo = this.hut;
                                        if (extInfo.hux != null) {
                                            extInfo.huV = extInfo.hux.optInt("FunctionFlag");
                                        }
                                        if ((extInfo.huV & BizInfo.hur) > 0) {
                                            z2 = false;
                                        } else {
                                            z2 = true;
                                        }
                                        if (bg.mA(string)) {
                                            DG = com.tencent.mm.modelbiz.w.DG();
                                            ig = DG.ig(string);
                                            com.tencent.mm.modelbiz.w.DI().a(this);
                                            com.tencent.mm.modelbiz.w.DI().U(this.jiL.field_username, string);
                                            this.oua = true;
                                            if (ig == null) {
                                                fVar = ig;
                                            } else {
                                                w.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
                                                fVar = DG.ih(this.jiL.field_username);
                                            }
                                            if (fVar == null) {
                                                this.isJ.aV("contact_info_kf_worker", false);
                                                iconWidgetPreference = (IconWidgetPreference) this.isJ.Td("contact_info_kf_worker");
                                                iconWidgetPreference.setSummary(fVar.field_nickname);
                                                c2 = com.tencent.mm.x.b.a(fVar.field_openId, false, -1);
                                                if (c2 == null) {
                                                    iconWidgetPreference.x(c2);
                                                } else {
                                                    c(fVar);
                                                    CE(fVar.field_openId);
                                                }
                                                w.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[]{fVar.field_openId, fVar.field_nickname});
                                            } else {
                                                this.isJ.aV("contact_info_kf_worker", true);
                                            }
                                        } else {
                                            fVar = com.tencent.mm.modelbiz.w.DG().ih(this.jiL.field_username);
                                            if (fVar == null) {
                                                w.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[]{fVar.field_openId});
                                                this.isJ.aV("contact_info_kf_worker", false);
                                                iconWidgetPreference = (IconWidgetPreference) this.isJ.Td("contact_info_kf_worker");
                                                iconWidgetPreference.setSummary(fVar.field_nickname);
                                                c2 = com.tencent.mm.x.b.a(fVar.field_openId, false, -1);
                                                if (c2 == null) {
                                                    iconWidgetPreference.x(c2);
                                                } else {
                                                    c(fVar);
                                                    CE(fVar.field_openId);
                                                }
                                            } else {
                                                this.isJ.aV("contact_info_kf_worker", true);
                                                com.tencent.mm.modelbiz.w.DI().a(this);
                                                DI = com.tencent.mm.modelbiz.w.DI();
                                                string = this.jiL.field_username;
                                                str = com.tencent.mm.u.m.xL();
                                                if (bg.mA(string)) {
                                                    com.tencent.mm.kernel.h.vH().gXC.a(new s(string, str), 0);
                                                    w.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", new Object[]{string, Integer.valueOf(DI.hvI.size())});
                                                } else {
                                                    w.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
                                                }
                                                this.oua = true;
                                            }
                                        }
                                    }
                                    this.isJ.aV("contact_info_kf_worker", true);
                                }
                                w.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[]{Boolean.valueOf(this.fCi.getIntent().getBooleanExtra("KIsHardDevice", false))});
                                if (this.fCi.getIntent() == null) {
                                }
                                if (com.tencent.mm.j.a.ez(this.jiL.field_type)) {
                                    w.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[]{this.jiL.field_username});
                                    aTz();
                                    Td = this.isJ.Td("contact_info_biz_add");
                                    Td.setTitle(R.l.dXH);
                                    if (rs(this.osO)) {
                                        if (bizInfo == null) {
                                            ((CheckBoxPreference) this.isJ.Td("contact_info_subscribe_bizinfo")).vqm = bizInfo.Cz();
                                            this.isJ.aV("contact_info_subscribe_bizinfo", false);
                                        } else {
                                            w.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                                        }
                                    }
                                    this.fCi.ks(false);
                                }
                                if (bizInfo != null) {
                                    this.isJ.aV("contact_info_subscribe_bizinfo", true);
                                    this.isJ.aV("contact_info_locate", true);
                                    this.isJ.aV("contact_info_template_recv", true);
                                } else {
                                    checkBoxPreference = (CheckBoxPreference) this.isJ.Td("contact_info_subscribe_bizinfo");
                                    checkBoxPreference2 = (CheckBoxPreference) this.isJ.Td("contact_info_locate");
                                    if (!bizInfo.CJ()) {
                                        checkBoxPreference.setTitle(R.l.eeD);
                                        this.otS = com.tencent.mm.modelbiz.w.DL().iD(com.tencent.mm.modelbiz.w.DL().iF(bizInfo.field_username));
                                        if (this.otS != null) {
                                            w.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                                        } else {
                                            if (this.otS.fu(4)) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                            checkBoxPreference.vqm = z;
                                        }
                                    } else if (bizInfo.CH()) {
                                        checkBoxPreference.vqm = bizInfo.Cz();
                                    } else {
                                        checkBoxPreference.setTitle(R.l.eeA);
                                        checkBoxPreference.vqm = com.tencent.mm.modelbiz.w.DO().hG(bizInfo.field_username);
                                    }
                                    if (bizInfo.Cz()) {
                                        this.isJ.aV("contact_info_template_recv", true);
                                    } else {
                                        this.hut = bizInfo.bd(false);
                                        if (this.hut == null) {
                                        }
                                        this.isJ.aV("contact_info_template_recv", true);
                                    }
                                    if (bizInfo.bd(false).CD()) {
                                        this.isJ.aV("contact_info_locate", true);
                                        checkBoxPreference2.vqm = bizInfo.CA();
                                    } else {
                                        checkBoxPreference2.vqm = bizInfo.CA();
                                    }
                                }
                                this.isJ.aV("contact_info_biz_read_msg_online", true);
                                this.isJ.aV("contact_info_biz_add", true);
                                tL = this.jiL.tL();
                                if (tL != null) {
                                    this.fCi.qP(tL);
                                }
                                if (o.fh(this.jiL.field_username)) {
                                    this.isJ.Td("contact_info_biz_go_chatting").setTitle(R.l.dZw);
                                    this.fCi.zi(R.l.eal);
                                }
                                if (!o.fC(this.jiL.field_username)) {
                                    return;
                                }
                            }
                        } catch (IndexOutOfBoundsException e3) {
                            IndexOutOfBoundsException indexOutOfBoundsException = e3;
                            charSequence = a;
                            e = indexOutOfBoundsException;
                            w.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", new Object[]{e.getMessage()});
                            keyValuePreference.setSummary(charSequence);
                            if (this.hut != null) {
                            }
                            w.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
                            this.isJ.aV("contact_info_trademark", true);
                            if (this.hut != null) {
                            }
                            this.isJ.aV("contact_info_privilege", true);
                            indexOf = this.isJ.indexOf("contact_info_category2");
                            if (indexOf >= 0) {
                            }
                            w.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
                            if (this.otV) {
                            }
                            this.isJ.aV("contact_info_verifyuser_weibo", true);
                            if (this.hut != null) {
                            }
                            this.isJ.aV("contact_info_reputation", true);
                            this.isJ.aV("contact_info_guarantee_info", true);
                            this.isJ.aV("contact_info_scope_of_business", true);
                            if (this.otT != null) {
                            }
                            this.isJ.aV("contact_info_bindwxainfo", true);
                            string = this.fCi.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
                            w.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[]{string, Boolean.valueOf(this.oua)});
                            if (this.oua) {
                                this.otZ = string;
                                if (this.hut != null) {
                                    extInfo = this.hut;
                                    if (extInfo.hux != null) {
                                        extInfo.huV = extInfo.hux.optInt("FunctionFlag");
                                    }
                                    if ((extInfo.huV & BizInfo.hur) > 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (bg.mA(string)) {
                                        fVar = com.tencent.mm.modelbiz.w.DG().ih(this.jiL.field_username);
                                        if (fVar == null) {
                                            this.isJ.aV("contact_info_kf_worker", true);
                                            com.tencent.mm.modelbiz.w.DI().a(this);
                                            DI = com.tencent.mm.modelbiz.w.DI();
                                            string = this.jiL.field_username;
                                            str = com.tencent.mm.u.m.xL();
                                            if (bg.mA(string)) {
                                                w.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
                                            } else {
                                                com.tencent.mm.kernel.h.vH().gXC.a(new s(string, str), 0);
                                                w.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", new Object[]{string, Integer.valueOf(DI.hvI.size())});
                                            }
                                            this.oua = true;
                                        } else {
                                            w.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[]{fVar.field_openId});
                                            this.isJ.aV("contact_info_kf_worker", false);
                                            iconWidgetPreference = (IconWidgetPreference) this.isJ.Td("contact_info_kf_worker");
                                            iconWidgetPreference.setSummary(fVar.field_nickname);
                                            c2 = com.tencent.mm.x.b.a(fVar.field_openId, false, -1);
                                            if (c2 == null) {
                                                c(fVar);
                                                CE(fVar.field_openId);
                                            } else {
                                                iconWidgetPreference.x(c2);
                                            }
                                        }
                                    } else {
                                        DG = com.tencent.mm.modelbiz.w.DG();
                                        ig = DG.ig(string);
                                        com.tencent.mm.modelbiz.w.DI().a(this);
                                        com.tencent.mm.modelbiz.w.DI().U(this.jiL.field_username, string);
                                        this.oua = true;
                                        if (ig == null) {
                                            w.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
                                            fVar = DG.ih(this.jiL.field_username);
                                        } else {
                                            fVar = ig;
                                        }
                                        if (fVar == null) {
                                            this.isJ.aV("contact_info_kf_worker", true);
                                        } else {
                                            this.isJ.aV("contact_info_kf_worker", false);
                                            iconWidgetPreference = (IconWidgetPreference) this.isJ.Td("contact_info_kf_worker");
                                            iconWidgetPreference.setSummary(fVar.field_nickname);
                                            c2 = com.tencent.mm.x.b.a(fVar.field_openId, false, -1);
                                            if (c2 == null) {
                                                c(fVar);
                                                CE(fVar.field_openId);
                                            } else {
                                                iconWidgetPreference.x(c2);
                                            }
                                            w.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[]{fVar.field_openId, fVar.field_nickname});
                                        }
                                    }
                                }
                                this.isJ.aV("contact_info_kf_worker", true);
                            }
                            w.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[]{Boolean.valueOf(this.fCi.getIntent().getBooleanExtra("KIsHardDevice", false))});
                            if (this.fCi.getIntent() == null) {
                            }
                            if (com.tencent.mm.j.a.ez(this.jiL.field_type)) {
                                if (bizInfo != null) {
                                    checkBoxPreference = (CheckBoxPreference) this.isJ.Td("contact_info_subscribe_bizinfo");
                                    checkBoxPreference2 = (CheckBoxPreference) this.isJ.Td("contact_info_locate");
                                    if (!bizInfo.CJ()) {
                                        checkBoxPreference.setTitle(R.l.eeD);
                                        this.otS = com.tencent.mm.modelbiz.w.DL().iD(com.tencent.mm.modelbiz.w.DL().iF(bizInfo.field_username));
                                        if (this.otS != null) {
                                            if (this.otS.fu(4)) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                            checkBoxPreference.vqm = z;
                                        } else {
                                            w.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                                        }
                                    } else if (bizInfo.CH()) {
                                        checkBoxPreference.setTitle(R.l.eeA);
                                        if (com.tencent.mm.modelbiz.w.DO().hG(bizInfo.field_username)) {
                                        }
                                        checkBoxPreference.vqm = com.tencent.mm.modelbiz.w.DO().hG(bizInfo.field_username);
                                    } else {
                                        checkBoxPreference.vqm = bizInfo.Cz();
                                    }
                                    if (bizInfo.Cz()) {
                                        this.hut = bizInfo.bd(false);
                                        if (this.hut == null) {
                                        }
                                        this.isJ.aV("contact_info_template_recv", true);
                                    } else {
                                        this.isJ.aV("contact_info_template_recv", true);
                                    }
                                    if (bizInfo.bd(false).CD()) {
                                        checkBoxPreference2.vqm = bizInfo.CA();
                                    } else {
                                        this.isJ.aV("contact_info_locate", true);
                                        checkBoxPreference2.vqm = bizInfo.CA();
                                    }
                                } else {
                                    this.isJ.aV("contact_info_subscribe_bizinfo", true);
                                    this.isJ.aV("contact_info_locate", true);
                                    this.isJ.aV("contact_info_template_recv", true);
                                }
                                this.isJ.aV("contact_info_biz_read_msg_online", true);
                                this.isJ.aV("contact_info_biz_add", true);
                                tL = this.jiL.tL();
                                if (tL != null) {
                                    this.fCi.qP(tL);
                                }
                                if (o.fh(this.jiL.field_username)) {
                                    this.isJ.Td("contact_info_biz_go_chatting").setTitle(R.l.dZw);
                                    this.fCi.zi(R.l.eal);
                                }
                                if (!o.fC(this.jiL.field_username)) {
                                }
                                return;
                            }
                            w.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[]{this.jiL.field_username});
                            aTz();
                            Td = this.isJ.Td("contact_info_biz_add");
                            Td.setTitle(R.l.dXH);
                            if (rs(this.osO)) {
                                if (bizInfo == null) {
                                    w.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                                } else {
                                    ((CheckBoxPreference) this.isJ.Td("contact_info_subscribe_bizinfo")).vqm = bizInfo.Cz();
                                    this.isJ.aV("contact_info_subscribe_bizinfo", false);
                                }
                            }
                            this.fCi.ks(false);
                        }
                    }
                    keyValuePreference.setSummary(charSequence);
                } else {
                    w.e("MicroMsg.ContactWidgetBizInfo", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
                }
            } else {
                this.isJ.aV("contact_info_verifyuser", true);
            }
        } else if (this.hut == null || this.hut.Dc() == null || bg.mA(this.hut.Dc().hvv)) {
            w.w("MicroMsg.ContactWidgetBizInfo", "has not verify info");
            this.isJ.aV("contact_info_verifyuser", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.isJ.Td("contact_info_verifyuser");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.hut.Dc().hvv);
            }
        }
        if (this.hut != null || bg.mA(this.hut.CV())) {
            w.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
            this.isJ.aV("contact_info_trademark", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.isJ.Td("contact_info_trademark");
            if (keyValuePreference != null) {
                keyValuePreference.bSX();
                keyValuePreference.vrl = false;
                if (com.tencent.mm.u.ag.a.hlU != null) {
                    c = d.yp(R.k.dus);
                } else {
                    c = null;
                }
                str2 = "MicroMsg.ContactWidgetBizInfo";
                str3 = "trademark bmp is null ? %B";
                objArr = new Object[1];
                if (c == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                w.i(str2, str3, objArr);
                if (c != null) {
                    bitmapDrawable = new BitmapDrawable(this.fCi.getResources(), c);
                } else {
                    bitmapDrawable = null;
                }
                keyValuePreference.vrt = bitmapDrawable;
                keyValuePreference.setSummary(this.hut.CV());
                w.d("MicroMsg.ContactWidgetBizInfo", "trademark name : %s, url : %s.", new Object[]{this.hut.CV(), this.hut.CU()});
            }
        }
        if (this.hut != null || this.hut.CX() == null || this.hut.CX().size() <= 0) {
            this.isJ.aV("contact_info_privilege", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.isJ.Td("contact_info_privilege");
            keyValuePreference.bSX();
            keyValuePreference.kZ(false);
            keyValuePreference.vru.clear();
            for (ExtInfo.e eVar : this.hut.CX()) {
                LinearLayout linearLayout = (LinearLayout) View.inflate(this.fCi, R.i.dgA, null);
                ((ImageView) linearLayout.findViewById(R.h.bWV)).setImageDrawable(new a(this.fCi.getResources(), eVar.iconUrl));
                CharSequence charSequence2 = eVar.description;
                identifier = this.fCi.getResources().getIdentifier(eVar.hvu, "string", this.fCi.getPackageName());
                if (identifier > 0) {
                    charSequence2 = this.fCi.getString(identifier);
                }
                ((TextView) linearLayout.findViewById(R.h.summary)).setText(charSequence2);
                keyValuePreference.vru.add(linearLayout);
            }
        }
        indexOf = this.isJ.indexOf("contact_info_category2");
        if (indexOf >= 0 || this.hus == null || this.hus.size() <= 0) {
            w.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
        } else {
            int size = this.hus.size() - 1;
            while (size >= 0) {
                if (this.hus.get(size) != null && ((!this.fCi.getString(R.l.dXJ).equals(((com.tencent.mm.modelbiz.BizInfo.a) this.hus.get(size)).title) || this.huA) && !(bg.mA(((com.tencent.mm.modelbiz.BizInfo.a) this.hus.get(size)).title) && bg.mA(((com.tencent.mm.modelbiz.BizInfo.a) this.hus.get(size)).huw)))) {
                    Preference preference = new Preference(this.fCi);
                    preference.setKey("contact_info_bizinfo_external#" + size);
                    charSequence = ((com.tencent.mm.modelbiz.BizInfo.a) this.hus.get(size)).title;
                    int identifier2 = this.fCi.getResources().getIdentifier(((com.tencent.mm.modelbiz.BizInfo.a) this.hus.get(size)).huw, "string", this.fCi.getPackageName());
                    if (identifier2 > 0) {
                        charSequence = this.fCi.getString(identifier2);
                    }
                    if (this.jZc.CG() && ("__mp_wording__brandinfo_history_massmsg".equals(((com.tencent.mm.modelbiz.BizInfo.a) this.hus.get(size)).huw) || r1.equals(this.fCi.getString(R.l.dAO)))) {
                        charSequence = this.fCi.getString(R.l.eez);
                    }
                    preference.setTitle(charSequence);
                    if (!bg.mA(((com.tencent.mm.modelbiz.BizInfo.a) this.hus.get(size)).description)) {
                        preference.setSummary(((com.tencent.mm.modelbiz.BizInfo.a) this.hus.get(size)).description);
                    }
                    if (bg.mz(((com.tencent.mm.modelbiz.BizInfo.a) this.hus.get(size)).huw).equals("__mp_wording__brandinfo_feedback")) {
                        identifier2 = this.isJ.indexOf("contact_info_scope_of_business");
                        if (identifier2 > 0) {
                            identifier = identifier2 + 1;
                            this.isJ.a(preference, identifier);
                            if (bg.mz(((com.tencent.mm.modelbiz.BizInfo.a) this.hus.get(size)).huw).equals("__mp_wording__brandinfo_biz_detail")) {
                                this.isJ.a(new PreferenceSmallCategory(this.fCi), identifier);
                            }
                        }
                    }
                    identifier = indexOf;
                    this.isJ.a(preference, identifier);
                    if (bg.mz(((com.tencent.mm.modelbiz.BizInfo.a) this.hus.get(size)).huw).equals("__mp_wording__brandinfo_biz_detail")) {
                        this.isJ.a(new PreferenceSmallCategory(this.fCi), identifier);
                    }
                }
                size--;
            }
        }
        if (this.otV || !o.v(this.jiL) || this.jiL.gkF == null || this.jiL.gkF.equals("")) {
            this.isJ.aV("contact_info_verifyuser_weibo", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.isJ.Td("contact_info_verifyuser_weibo");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(bg.ap(this.jiL.field_weiboNickname, "") + this.fCi.getString(R.l.eUc, new Object[]{o.fL(this.jiL.gkF)}));
                keyValuePreference.krt = com.tencent.mm.bg.a.b(this.fCi, R.e.aUA);
                keyValuePreference.kZ(false);
            }
        }
        if (this.hut != null || this.hut.CZ() == null) {
            this.isJ.aV("contact_info_reputation", true);
            this.isJ.aV("contact_info_guarantee_info", true);
            this.isJ.aV("contact_info_scope_of_business", true);
        } else {
            BizInfoPayInfoIconPreference bizInfoPayInfoIconPreference = (BizInfoPayInfoIconPreference) this.isJ.Td("contact_info_reputation");
            if (this.hut.CZ().hvq > 0) {
                bizInfoPayInfoIconPreference.rl(this.hut.CZ().hvq);
            } else {
                this.isJ.aV("contact_info_reputation", true);
            }
            bizInfoPayInfoIconPreference = (BizInfoPayInfoIconPreference) this.isJ.Td("contact_info_guarantee_info");
            if (this.hut.CZ().hvs == null || this.hut.CZ().hvs.size() <= 0) {
                this.isJ.aV("contact_info_guarantee_info", true);
            } else {
                bizInfoPayInfoIconPreference.ba(this.hut.CZ().hvs);
            }
            keyValuePreference = (KeyValuePreference) this.isJ.Td("contact_info_scope_of_business");
            if (bg.mA(this.hut.CZ().hvr)) {
                this.isJ.aV("contact_info_scope_of_business", true);
            } else {
                keyValuePreference.setSummary(this.hut.CZ().hvr);
                keyValuePreference.vrr = 4;
                keyValuePreference.kZ(false);
            }
        }
        if (this.otT != null || this.otT.size() <= 0) {
            this.isJ.aV("contact_info_bindwxainfo", true);
        } else {
            this.isJ.aV("contact_info_bindwxainfo", false);
            BizBindWxaInfoPreference bizBindWxaInfoPreference = (BizBindWxaInfoPreference) this.isJ.Td("contact_info_bindwxainfo");
            Collection collection = this.otT;
            bizBindWxaInfoPreference.ost = true;
            if (bizBindWxaInfoPreference.jrG == null) {
                bizBindWxaInfoPreference.jrG = new LinkedList();
            } else {
                bizBindWxaInfoPreference.jrG.clear();
            }
            if (!(collection == null || collection.isEmpty())) {
                bizBindWxaInfoPreference.jrG.addAll(collection);
            }
            bizBindWxaInfoPreference.RO();
        }
        string = this.fCi.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
        w.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[]{string, Boolean.valueOf(this.oua)});
        if (this.oua) {
            this.otZ = string;
            if (this.hut != null) {
                extInfo = this.hut;
                if (extInfo.hux != null) {
                    extInfo.huV = extInfo.hux.optInt("FunctionFlag");
                }
                if ((extInfo.huV & BizInfo.hur) > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 && this.jiL != null) {
                    if (bg.mA(string)) {
                        fVar = com.tencent.mm.modelbiz.w.DG().ih(this.jiL.field_username);
                        if (fVar == null) {
                            this.isJ.aV("contact_info_kf_worker", true);
                            com.tencent.mm.modelbiz.w.DI().a(this);
                            DI = com.tencent.mm.modelbiz.w.DI();
                            string = this.jiL.field_username;
                            str = com.tencent.mm.u.m.xL();
                            if (bg.mA(string)) {
                                w.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
                            } else {
                                com.tencent.mm.kernel.h.vH().gXC.a(new s(string, str), 0);
                                w.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", new Object[]{string, Integer.valueOf(DI.hvI.size())});
                            }
                            this.oua = true;
                        } else {
                            w.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[]{fVar.field_openId});
                            this.isJ.aV("contact_info_kf_worker", false);
                            iconWidgetPreference = (IconWidgetPreference) this.isJ.Td("contact_info_kf_worker");
                            iconWidgetPreference.setSummary(fVar.field_nickname);
                            c2 = com.tencent.mm.x.b.a(fVar.field_openId, false, -1);
                            if (c2 == null) {
                                c(fVar);
                                CE(fVar.field_openId);
                            } else {
                                iconWidgetPreference.x(c2);
                            }
                        }
                    } else {
                        DG = com.tencent.mm.modelbiz.w.DG();
                        ig = DG.ig(string);
                        if (ig == null || com.tencent.mm.modelbiz.h.a(ig)) {
                            com.tencent.mm.modelbiz.w.DI().a(this);
                            com.tencent.mm.modelbiz.w.DI().U(this.jiL.field_username, string);
                            this.oua = true;
                        }
                        if (ig == null) {
                            w.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
                            fVar = DG.ih(this.jiL.field_username);
                        } else {
                            fVar = ig;
                        }
                        if (fVar == null) {
                            this.isJ.aV("contact_info_kf_worker", true);
                        } else {
                            this.isJ.aV("contact_info_kf_worker", false);
                            iconWidgetPreference = (IconWidgetPreference) this.isJ.Td("contact_info_kf_worker");
                            iconWidgetPreference.setSummary(fVar.field_nickname);
                            c2 = com.tencent.mm.x.b.a(fVar.field_openId, false, -1);
                            if (c2 == null) {
                                c(fVar);
                                CE(fVar.field_openId);
                            } else {
                                iconWidgetPreference.x(c2);
                            }
                            w.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[]{fVar.field_openId, fVar.field_nickname});
                        }
                    }
                }
            }
            this.isJ.aV("contact_info_kf_worker", true);
        }
        w.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[]{Boolean.valueOf(this.fCi.getIntent().getBooleanExtra("KIsHardDevice", false))});
        if (this.fCi.getIntent() == null && this.fCi.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            w.d("MicroMsg.ContactWidgetBizInfo", "Hard device biz...");
            z2 = aTA();
            w.d("MicroMsg.ContactWidgetBizInfo", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[]{Boolean.valueOf(com.tencent.mm.j.a.ez(this.jiL.field_type)), Boolean.valueOf(z2)});
            if (com.tencent.mm.j.a.ez(this.jiL.field_type) && z2) {
                if (bizInfo != null) {
                    checkBoxPreference = (CheckBoxPreference) this.isJ.Td("contact_info_subscribe_bizinfo");
                    checkBoxPreference2 = (CheckBoxPreference) this.isJ.Td("contact_info_locate");
                    if (bizInfo.CJ()) {
                        this.otS = com.tencent.mm.modelbiz.w.DL().iD(com.tencent.mm.modelbiz.w.DL().iF(bizInfo.field_username));
                        if (this.otS != null) {
                            checkBoxPreference.vqm = !this.otS.fu(4);
                        } else {
                            w.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                        }
                    } else {
                        checkBoxPreference.vqm = bizInfo.Cz();
                    }
                    if (bizInfo.Cz()) {
                        if (this.hut == null && bizInfo != null) {
                            this.hut = bizInfo.bd(false);
                        }
                        if (this.hut != null && this.hut.CS() && com.tencent.mm.bb.d.Jt("brandservice")) {
                            this.isJ.aV("contact_info_template_recv", false);
                        } else {
                            this.isJ.aV("contact_info_template_recv", true);
                        }
                    } else {
                        this.isJ.aV("contact_info_template_recv", true);
                    }
                    if (bizInfo.bd(false).CD()) {
                        checkBoxPreference2.vqm = bizInfo.CA();
                    } else {
                        this.isJ.aV("contact_info_locate", true);
                        checkBoxPreference2.vqm = bizInfo.CA();
                    }
                } else {
                    this.isJ.aV("contact_info_subscribe_bizinfo", true);
                    this.isJ.aV("contact_info_locate", true);
                    this.isJ.aV("contact_info_template_recv", true);
                }
                this.isJ.aV("contact_info_biz_read_msg_online", true);
                this.isJ.aV("contact_info_biz_add", true);
                tL = this.jiL.tL();
                if (tL != null) {
                    this.fCi.qP(tL);
                }
                if (o.fh(this.jiL.field_username)) {
                    this.isJ.Td("contact_info_biz_go_chatting").setTitle(R.l.dZw);
                    this.fCi.zi(R.l.eal);
                }
                if (!o.fC(this.jiL.field_username) && this.jZc != null && !this.jZc.CI()) {
                    this.fCi.a(0, R.g.bhb, new OnMenuItemClickListener(this) {
                        final /* synthetic */ c ouf;

                        {
                            this.ouf = r1;
                        }

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            this.ouf.aht();
                            return true;
                        }
                    });
                    return;
                }
                return;
            }
            w.w("MicroMsg.ContactWidgetBizInfo", "%s is not my hard biz contact", new Object[]{this.jiL.field_username});
            aTz();
            Preference Td2 = this.isJ.Td("contact_info_biz_add");
            w.d("MicroMsg.ContactWidgetBizInfo", "isBizConferenceAccount(%b)", new Object[]{Boolean.valueOf(this.otW)});
            if (Td2 != null) {
                if (z2) {
                    Td2.setTitle(R.l.dXH);
                } else {
                    Td2.setTitle(R.l.dXE);
                }
            }
            if (rs(this.osO)) {
                if (bizInfo == null) {
                    w.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                } else {
                    ((CheckBoxPreference) this.isJ.Td("contact_info_subscribe_bizinfo")).vqm = bizInfo.Cz();
                    this.isJ.aV("contact_info_subscribe_bizinfo", false);
                }
            }
            this.fCi.ks(false);
        } else if (com.tencent.mm.j.a.ez(this.jiL.field_type)) {
            if (bizInfo != null) {
                checkBoxPreference = (CheckBoxPreference) this.isJ.Td("contact_info_subscribe_bizinfo");
                checkBoxPreference2 = (CheckBoxPreference) this.isJ.Td("contact_info_locate");
                if (!bizInfo.CJ()) {
                    checkBoxPreference.setTitle(R.l.eeD);
                    this.otS = com.tencent.mm.modelbiz.w.DL().iD(com.tencent.mm.modelbiz.w.DL().iF(bizInfo.field_username));
                    if (this.otS != null) {
                        if (this.otS.fu(4)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        checkBoxPreference.vqm = z;
                    } else {
                        w.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                    }
                } else if (bizInfo.CH()) {
                    checkBoxPreference.setTitle(R.l.eeA);
                    if (com.tencent.mm.modelbiz.w.DO().hG(bizInfo.field_username)) {
                    }
                    checkBoxPreference.vqm = com.tencent.mm.modelbiz.w.DO().hG(bizInfo.field_username);
                } else {
                    checkBoxPreference.vqm = bizInfo.Cz();
                }
                if (bizInfo.Cz()) {
                    if (this.hut == null && bizInfo != null) {
                        this.hut = bizInfo.bd(false);
                    }
                    if (this.hut == null && this.hut.CS() && com.tencent.mm.bb.d.Jt("brandservice")) {
                        this.isJ.aV("contact_info_template_recv", false);
                    } else {
                        this.isJ.aV("contact_info_template_recv", true);
                    }
                } else {
                    this.isJ.aV("contact_info_template_recv", true);
                }
                if (bizInfo.bd(false).CD()) {
                    checkBoxPreference2.vqm = bizInfo.CA();
                } else {
                    this.isJ.aV("contact_info_locate", true);
                    checkBoxPreference2.vqm = bizInfo.CA();
                }
            } else {
                this.isJ.aV("contact_info_subscribe_bizinfo", true);
                this.isJ.aV("contact_info_locate", true);
                this.isJ.aV("contact_info_template_recv", true);
            }
            this.isJ.aV("contact_info_biz_read_msg_online", true);
            this.isJ.aV("contact_info_biz_add", true);
            tL = this.jiL.tL();
            if (tL != null) {
                this.fCi.qP(tL);
            }
            if (o.fh(this.jiL.field_username)) {
                this.isJ.Td("contact_info_biz_go_chatting").setTitle(R.l.dZw);
                this.fCi.zi(R.l.eal);
            }
            if (!o.fC(this.jiL.field_username) && this.jZc != null) {
                this.fCi.a(0, R.g.bhb, new OnMenuItemClickListener(this) {
                    final /* synthetic */ c ouf;

                    {
                        this.ouf = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.ouf.aht();
                        return true;
                    }
                });
            }
        } else {
            w.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[]{this.jiL.field_username});
            aTz();
            Td = this.isJ.Td("contact_info_biz_add");
            if (Td != null && this.otW) {
                Td.setTitle(R.l.dXH);
            }
            if (rs(this.osO)) {
                if (bizInfo == null) {
                    w.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                } else {
                    ((CheckBoxPreference) this.isJ.Td("contact_info_subscribe_bizinfo")).vqm = bizInfo.Cz();
                    this.isJ.aV("contact_info_subscribe_bizinfo", false);
                }
            }
            this.fCi.ks(false);
        }
    }

    public final void aht() {
        com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.fCi, com.tencent.mm.ui.widget.e.wuP, false);
        eVar.qJf = new com.tencent.mm.ui.base.n.c(this) {
            final /* synthetic */ c ouf;

            {
                this.ouf = r1;
            }

            public final void a(l lVar) {
                if (this.ouf.jZc != null && this.ouf.jZc.CH()) {
                    lVar.dX(1, R.l.dZx);
                    lVar.dX(3, R.l.dOR);
                    lVar.dX(4, R.l.dXK);
                    lVar.dX(5, R.l.dXz);
                } else if (this.ouf.jZc == null || !this.ouf.jZc.CI()) {
                    lVar.dX(1, R.l.dZx);
                    lVar.dX(2, R.l.dXF);
                    if (!this.ouf.CF(this.ouf.jiL.field_username)) {
                        lVar.dX(3, R.l.dOR);
                        lVar.dX(4, R.l.dXK);
                    }
                    lVar.dX(5, R.l.dXz);
                } else {
                    lVar.dX(5, R.l.dXz);
                }
            }
        };
        eVar.qJg = new com.tencent.mm.ui.base.n.d(this) {
            final /* synthetic */ c ouf;

            {
                this.ouf = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                c cVar;
                switch (menuItem.getItemId()) {
                    case 1:
                        cVar = this.ouf;
                        Intent intent = new Intent();
                        intent.putExtra("Select_Talker_Name", cVar.jiL.field_username);
                        intent.putExtra("Select_block_List", cVar.jiL.field_username);
                        intent.putExtra("Select_Send_Card", true);
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("mutil_select_is_ret", true);
                        com.tencent.mm.plugin.profile.a.imv.a(intent, cVar.fCi);
                        return;
                    case 2:
                        this.ouf.fCi.getString(R.l.els, new Object[]{this.ouf.jiL.tL()});
                        g.a(this.ouf.fCi, this.ouf.fCi.getString(R.l.dXG), "", this.ouf.fCi.getString(R.l.dXF), this.ouf.fCi.getString(R.l.dGs), new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass2 oug;

                            {
                                this.oug = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                c cVar = this.oug.ouf;
                                String str = cVar.jiL.field_username;
                                ap.yY();
                                ce Ah = com.tencent.mm.u.c.wT().Ah(str);
                                ap.yY();
                                com.tencent.mm.u.c.wQ().b(new com.tencent.mm.ao.d(str, Ah.field_msgSvrId));
                                cVar.jWp = false;
                                Context context = cVar.fCi;
                                cVar.fCi.getString(R.l.dIO);
                                cVar.irJ = g.a(context, cVar.fCi.getString(R.l.dJd), true, new OnCancelListener(cVar) {
                                    final /* synthetic */ c ouf;

                                    {
                                        this.ouf = r1;
                                    }

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        this.ouf.jWp = true;
                                    }
                                });
                                ay.a(str, new com.tencent.mm.u.ay.a(cVar) {
                                    final /* synthetic */ c ouf;

                                    {
                                        this.ouf = r1;
                                    }

                                    public final boolean zs() {
                                        return this.ouf.jWp;
                                    }

                                    public final void zr() {
                                        if (this.ouf.irJ != null) {
                                            this.ouf.irJ.dismiss();
                                            this.ouf.irJ = null;
                                        }
                                    }
                                });
                            }
                        }, null);
                        return;
                    case 3:
                        this.ouf.aTB();
                        return;
                    case 4:
                        c cVar2 = this.ouf;
                        ((com.tencent.mm.pluginsdk.f) com.tencent.mm.kernel.h.h(com.tencent.mm.pluginsdk.f.class)).a(cVar2.jZc, cVar2.fCi, cVar2.jiL, true, new Runnable(cVar2) {
                            final /* synthetic */ c ouf;

                            {
                                this.ouf = r1;
                            }

                            public final void run() {
                                this.ouf.ah(4, null);
                                if (this.ouf.fCi.getIntent().getIntExtra("Kdel_from", -1) == 1) {
                                    Intent intent = new Intent();
                                    intent.addFlags(67108864);
                                    com.tencent.mm.bb.d.b(this.ouf.fCi, "shake", ".ui.ShakeReportUI", intent);
                                }
                            }
                        });
                        return;
                    case 5:
                        cVar = this.ouf;
                        w.d("MicroMsg.ContactWidgetBizInfo", "dealAddShortcut, username = " + cVar.jiL.field_username);
                        com.tencent.mm.plugin.base.model.c.K(cVar.fCi, cVar.jiL.field_username);
                        com.tencent.mm.sdk.platformtools.af.f(new Runnable(cVar) {
                            final /* synthetic */ c ouf;

                            {
                                this.ouf = r1;
                            }

                            public final void run() {
                                com.tencent.mm.plugin.base.model.c.J(this.ouf.fCi, this.ouf.jiL.field_username);
                            }
                        }, 1000);
                        return;
                    default:
                        return;
                }
            }
        };
        eVar.bzh();
    }

    private void aTz() {
        if (this.jiL == null || !com.tencent.mm.j.a.ez(this.jiL.field_type) || o.fh(this.jiL.field_username) || CF(this.jiL.field_username)) {
            this.isJ.aV("contact_is_mute", true);
            if (this.jiL == null || com.tencent.mm.j.a.ez(this.jiL.field_type) || !rs(this.osO)) {
                this.isJ.aV("contact_info_expose_btn", true);
            } else {
                this.isJ.aV("contact_info_expose_btn", false);
            }
        } else {
            this.isJ.aV("contact_is_mute", false);
        }
        this.isJ.aV("contact_info_verifyuser_weibo", true);
        this.isJ.aV("contact_info_subscribe_bizinfo", true);
        this.isJ.aV("contact_info_template_recv", true);
        this.isJ.aV("contact_info_locate", true);
        if (this.otV) {
            this.isJ.aV("contact_info_biz_add", true);
        } else {
            this.isJ.aV("contact_info_time_expired", true);
        }
        if (this.jiL == null || !((o.fC(this.jiL.field_username) || CF(this.jiL.field_username)) && com.tencent.mm.j.a.ez(this.jiL.field_type))) {
            this.isJ.aV("contact_info_biz_go_chatting", true);
        } else {
            this.isJ.aV("contact_info_biz_go_chatting", false);
        }
        if (CF(this.jiL.field_username)) {
            this.isJ.aV("contact_info_user_desc", true);
        }
    }

    public final boolean adI() {
        BizInfoHeaderPreference bizInfoHeaderPreference = (BizInfoHeaderPreference) this.isJ.Td("contact_info_header_bizinfo");
        if (bizInfoHeaderPreference != null) {
            bizInfoHeaderPreference.onDetach();
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (this.fCi == null) {
            w.e("MicroMsg.ContactWidgetBizInfo", "null == context");
            return;
        }
        w.i("MicroMsg.ContactWidgetBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    com.tencent.mm.plugin.messenger.a.d.aJW().k(stringExtra, stringExtra2, booleanExtra);
                    com.tencent.mm.plugin.messenger.a.d.aJW().cM(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.snackbar.a.e(this.fCi, this.fCi.getString(R.l.ekV));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static boolean CD(String str) {
        try {
            long j = bg.getLong(str, 0);
            if (j <= 0 || j - (System.currentTimeMillis() / 1000) >= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final void ah(int i, String str) {
        if (this.ouc == null || !(this.osO == 39 || this.osO == 56 || this.osO == 35 || this.osO == 87 || this.osO == 88 || this.osO == 89 || this.osO == 85)) {
            w.d("MicroMsg.ContactWidgetBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
        } else if (this.jiL == null) {
            w.i("MicroMsg.ContactWidgetBizInfo", "contact is null.");
        } else {
            int i2;
            String string = this.ouc.getString("Contact_Ext_Args_Search_Id");
            String mz = bg.mz(this.ouc.getString("Contact_Ext_Args_Query_String"));
            int i3 = this.ouc.getInt("Contact_Ext_Args_Index");
            switch (this.osO) {
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                    i2 = 1;
                    break;
                case 85:
                    i2 = 5;
                    break;
                case 87:
                    i2 = 2;
                    break;
                case 88:
                    i2 = 3;
                    break;
                case 89:
                    i2 = 4;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            String mz2 = bg.mz(this.ouc.getString("Contact_Ext_Extra_Params"));
            String str2 = mz + "," + i + "," + bg.mz(this.jiL.field_username) + "," + i3 + "," + (System.currentTimeMillis() / 1000) + "," + string + "," + i2;
            if (bg.mA(str)) {
                str2 = str2 + ",," + mz2;
            } else {
                str2 = str2 + "," + str + "," + mz2;
            }
            w.v("MicroMsg.ContactWidgetBizInfo", "report 10866: %s", new Object[]{str2});
            com.tencent.mm.plugin.report.service.g.oUh.A(10866, str2);
        }
    }

    private boolean aTA() {
        if (this.fCi.getIntent() == null) {
            return false;
        }
        String stringExtra = this.fCi.getIntent().getStringExtra("device_id");
        String stringExtra2 = this.fCi.getIntent().getStringExtra("device_type");
        com.tencent.mm.sdk.b.b ctVar = new ct();
        ctVar.fGn.fwJ = stringExtra;
        ctVar.fGn.fGl = stringExtra2;
        com.tencent.mm.sdk.b.a.urY.m(ctVar);
        return ctVar.fGo.fGp;
    }

    public final void aTB() {
        if (this.jiL != null && !bg.mA(this.jiL.field_username)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", String.format("http://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[]{this.jiL.field_username}));
            intent.putExtra("showShare", false);
            com.tencent.mm.bb.d.b(this.fCi, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    private void gj(boolean z) {
        if (this.jiL != null) {
            if (this.fCi != null) {
                if (!z || com.tencent.mm.modelbiz.e.dr(this.jiL.field_username)) {
                    this.fCi.zo(8);
                } else {
                    this.fCi.zo(0);
                }
            }
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("contact_is_mute");
            if (checkBoxPreference != null) {
                checkBoxPreference.vqm = z;
            }
        }
    }

    private void CE(final String str) {
        com.tencent.mm.sdk.platformtools.af.f(new Runnable(this) {
            final /* synthetic */ c ouf;

            public final void run() {
                if (this.ouf.isJ == null) {
                    w.w("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar screen is null");
                    return;
                }
                IconWidgetPreference iconWidgetPreference = (IconWidgetPreference) this.ouf.isJ.Td("contact_info_kf_worker");
                if (iconWidgetPreference != null && this.ouf.isJ != null) {
                    Bitmap a = com.tencent.mm.x.b.a(str, false, -1);
                    if (a != null) {
                        w.d("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar success %s, update screen", new Object[]{str});
                        iconWidgetPreference.x(a);
                        this.ouf.isJ.notifyDataSetChanged();
                    }
                }
            }
        }, 2000);
    }

    private static void c(com.tencent.mm.modelbiz.f fVar) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.x.i Bm = com.tencent.mm.x.n.Bm();
        if (Bm.hs(fVar.field_openId) == null) {
            com.tencent.mm.x.h hVar = new com.tencent.mm.x.h();
            hVar.username = fVar.field_openId;
            hVar.hrA = fVar.field_headImgUrl;
            hVar.aV(false);
            hVar.gkq = 3;
            Bm.a(hVar);
        }
        com.tencent.mm.x.n.Bz().hg(fVar.field_openId);
        w.d("MicroMsg.ContactWidgetBizInfo", "downloadKFAvatar, %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void a(int i, int i2, String str, k kVar) {
        ayu com_tencent_mm_protocal_c_ayu = null;
        w.d("MicroMsg.ContactWidgetBizInfo", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        this.oua = false;
        if (this.irJ != null && this.irJ.isShowing()) {
            this.irJ.dismiss();
        }
        if (kVar == null) {
            w.e("MicroMsg.ContactWidgetBizInfo", "scene == null");
            return;
        }
        ap.vd().b(kVar.getType(), this);
        if (i == 0 && i2 == 0) {
            w.d("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[]{Integer.valueOf(kVar.getType())});
            if (kVar.getType() == 536) {
                ap.vd().b(536, this);
                aTy();
                return;
            } else if (kVar.getType() == 1363) {
                ayv com_tencent_mm_protocal_c_ayv;
                com.tencent.mm.plugin.profile.a.b bVar = (com.tencent.mm.plugin.profile.a.b) kVar;
                if (bVar.gUA == null || bVar.gUA.hsk.hsr == null) {
                    com_tencent_mm_protocal_c_ayv = null;
                } else {
                    com_tencent_mm_protocal_c_ayv = (ayv) bVar.gUA.hsk.hsr;
                }
                com.tencent.mm.plugin.profile.a.b bVar2 = (com.tencent.mm.plugin.profile.a.b) kVar;
                if (!(bVar2.gUA == null || bVar2.gUA.hsj.hsr == null)) {
                    com_tencent_mm_protocal_c_ayu = (ayu) bVar2.gUA.hsj.hsr;
                }
                if (com_tencent_mm_protocal_c_ayv == null || com_tencent_mm_protocal_c_ayv.tkR == null || com_tencent_mm_protocal_c_ayv.tkR.ret != 0 || com_tencent_mm_protocal_c_ayv.tkO == null || bg.mA(com_tencent_mm_protocal_c_ayv.tkO.tkM)) {
                    if (com_tencent_mm_protocal_c_ayv == null || com_tencent_mm_protocal_c_ayv.tkR == null) {
                        w.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:resp == null");
                        return;
                    }
                    w.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:code:%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ayv.tkR.ret)});
                    return;
                } else if (com_tencent_mm_protocal_c_ayv.tkO == null) {
                    w.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd resp.user == null");
                    return;
                } else {
                    j iD = com.tencent.mm.modelbiz.w.DL().iD(com_tencent_mm_protocal_c_ayv.tkO.tkM);
                    if (iD == null) {
                        iD = new j();
                        iD.field_userId = com_tencent_mm_protocal_c_ayv.tkO.tkM;
                    }
                    iD.field_userName = com_tencent_mm_protocal_c_ayv.tkO.khr;
                    iD.field_brandUserName = com_tencent_mm_protocal_c_ayu.tkL;
                    iD.field_UserVersion = com_tencent_mm_protocal_c_ayv.tkO.ver;
                    iD.field_headImageUrl = com_tencent_mm_protocal_c_ayv.tkO.tkG;
                    iD.field_profileUrl = com_tencent_mm_protocal_c_ayv.tkO.tkU;
                    iD.field_bitFlag = com_tencent_mm_protocal_c_ayv.tkO.tkH;
                    iD.field_addMemberUrl = com_tencent_mm_protocal_c_ayv.tkO.tkK;
                    iD.field_needToUpdate = false;
                    if (!com.tencent.mm.modelbiz.w.DL().b(iD)) {
                        com.tencent.mm.modelbiz.w.DL().a(iD);
                        return;
                    }
                    return;
                }
            } else if (kVar.getType() == 1394) {
                bec aTu = ((com.tencent.mm.plugin.profile.a.c) kVar).aTu();
                bed aTt = ((com.tencent.mm.plugin.profile.a.c) kVar).aTt();
                if (aTt != null && aTt.tkR != null && aTt.tkR.ret == 0) {
                    boolean z;
                    if (aTu.uff) {
                        z = false;
                    } else {
                        z = true;
                    }
                    BizInfo bizInfo;
                    if (z) {
                        ae aeVar;
                        bizInfo = this.jZc;
                        bizInfo.field_brandFlag &= -2;
                        a(bizInfo, true);
                        ap.yY();
                        if (com.tencent.mm.u.c.wW().Rm(bizInfo.field_username) == null) {
                            aeVar = new ae(bizInfo.field_username);
                            aeVar.cw(bg.mz(this.jZc.CO()));
                            ap.yY();
                            au Ai = com.tencent.mm.u.c.wT().Ai(bizInfo.field_username);
                            if (Ai != null) {
                                ap.yY();
                                com.tencent.mm.u.c.wW().d(aeVar);
                                ap.yY();
                                com.tencent.mm.u.c.wW().X(Ai);
                            } else {
                                aeVar.bLB();
                                ap.yY();
                                com.tencent.mm.u.c.wW().d(aeVar);
                            }
                        }
                        ap.yY();
                        if (com.tencent.mm.u.c.wW().Rm(bizInfo.field_enterpriseFather) == null) {
                            aeVar = new ae(bizInfo.field_enterpriseFather);
                            aeVar.bLB();
                            ap.yY();
                            com.tencent.mm.u.c.wW().d(aeVar);
                            return;
                        }
                        ap.yY();
                        com.tencent.mm.u.c.wV().QH(bizInfo.field_enterpriseFather);
                        return;
                    }
                    bizInfo = this.jZc;
                    bizInfo.field_brandFlag |= 1;
                    a(bizInfo, true);
                    ap.yY();
                    com.tencent.mm.u.c.wW().Rl(bizInfo.field_username);
                    ap.yY();
                    if (com.tencent.mm.u.c.wW().Rw(bizInfo.field_enterpriseFather) <= 0) {
                        ap.yY();
                        com.tencent.mm.u.c.wW().Rl(bizInfo.field_enterpriseFather);
                        return;
                    }
                    ap.yY();
                    com.tencent.mm.u.c.wV().QH(bizInfo.field_enterpriseFather);
                    return;
                } else if (aTt == null || aTt.tkR == null) {
                    w.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[]{Integer.valueOf(kVar.getType())});
                    return;
                } else {
                    w.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(aTt.tkR.ret)});
                    return;
                }
            } else if (kVar.getType() == 1343) {
                aTy();
                return;
            } else if (kVar.getType() == 1228) {
                aTy();
                return;
            } else {
                return;
            }
        }
        w.e("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[]{Integer.valueOf(kVar.getType())});
    }

    public final void c(LinkedList<bpl> linkedList) {
        com.tencent.mm.modelbiz.w.DI().b(this);
        if (this.isJ == null) {
            w.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, screen is null");
        } else if (this.jiL == null) {
            w.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, contact is null");
        } else if (linkedList == null || linkedList.size() <= 0) {
            w.w("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, worker is null");
        } else {
            if (!bg.mA(this.otZ)) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    bpl com_tencent_mm_protocal_c_bpl = (bpl) it.next();
                    if (com_tencent_mm_protocal_c_bpl.unQ != null && com_tencent_mm_protocal_c_bpl.unQ.equals(this.otZ)) {
                        this.isJ.aV("contact_info_kf_worker", false);
                        this.isJ.Td("contact_info_kf_worker").setSummary(com_tencent_mm_protocal_c_bpl.tNz);
                        return;
                    }
                }
            }
            this.isJ.aV("contact_info_kf_worker", false);
            this.isJ.Td("contact_info_kf_worker").setSummary(((bpl) linkedList.get(0)).tNz);
        }
    }

    public final void a(int i, k kVar) {
        if (this.jZc != null && this.jZc.CJ() && kVar.getType() == 1354) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("contact_info_subscribe_bizinfo");
            this.otS = com.tencent.mm.modelbiz.w.DL().iD(com.tencent.mm.modelbiz.w.DL().iF(this.jZc.field_username));
            if (this.otS != null) {
                checkBoxPreference.vqm = !this.otS.fu(4);
                this.isJ.notifyDataSetChanged();
                return;
            }
            w.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null after GetBizChatMyUserInfo");
        }
    }

    public final boolean CF(String str) {
        return str.equals("weixinsrc") || this.jiL.field_username.equalsIgnoreCase("gh_6e99ff560306");
    }

    public final String Dz() {
        return "MicroMsg.ContactWidgetBizInfo";
    }

    private void aTC() {
        w.d("MicroMsg.ContactWidgetBizInfo", "updatePlaceTop");
        if (this.hgx == null) {
            this.hgx = this.fCi.getSharedPreferences(this.fCi.getPackageName() + "_preferences", 0);
        }
        if (this.kti != null) {
            if (this.jiL != null) {
                this.hgx.edit().putBoolean("biz_placed_to_the_top", this.jiL.tG()).commit();
            } else {
                this.hgx.edit().putBoolean("biz_placed_to_the_top", false).commit();
            }
        }
        this.isJ.notifyDataSetChanged();
    }

    private static boolean rs(int i) {
        if (i == 81 || i == 92 || i == 93 || i == 94) {
            return true;
        }
        return false;
    }
}
