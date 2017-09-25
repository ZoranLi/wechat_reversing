package com.tencent.mm.plugin.shake.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.by;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.gr;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.plugin.shake.e.c;
import com.tencent.mm.protocal.c.abs;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.d;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TVInfoUI extends MMPreference implements a, e {
    private long fGM;
    private TextView ioX;
    protected f isJ;
    protected ProgressDialog isv = null;
    private ImageView kmG;
    private boolean oZB = false;
    private boolean pbX = false;
    private String ptb = "";
    private TextView ptc;
    private c.a ptd;
    private b pte;

    static /* synthetic */ void a(TVInfoUI tVInfoUI) {
        String str = "";
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(tVInfoUI.getString(R.l.fnu));
        linkedList2.add(Integer.valueOf(0));
        linkedList.add(tVInfoUI.getString(R.l.fnv));
        linkedList2.add(Integer.valueOf(1));
        if (tVInfoUI.getIntent().getBooleanExtra("key_is_favorite_item", false)) {
            str = tVInfoUI.getIntent().getBooleanExtra("key_can_delete_favorite_item", true) ? tVInfoUI.getString(R.l.dGB) : "";
        } else {
            linkedList.add(tVInfoUI.getString(R.l.eGa));
            linkedList2.add(Integer.valueOf(2));
        }
        g.a(tVInfoUI, "", linkedList, linkedList2, str, false, new d(tVInfoUI) {
            final /* synthetic */ TVInfoUI ptg;

            {
                this.ptg = r1;
            }

            public final void bN(int i, int i2) {
                switch (i2) {
                    case -1:
                        g.a(this.ptg.uSU.uTo, this.ptg.uSU.uTo.getString(R.l.dGC), null, null, this.ptg.uSU.uTo.getString(R.l.dGB), new d(this) {
                            final /* synthetic */ AnonymousClass6 pth;

                            {
                                this.pth = r1;
                            }

                            public final void bN(int i, int i2) {
                                switch (i2) {
                                    case -1:
                                        com.tencent.mm.sdk.b.b byVar = new by();
                                        byVar.fFv.fFx = this.pth.ptg.getIntent().getLongExtra("key_favorite_local_id", -1);
                                        com.tencent.mm.sdk.b.a.urY.m(byVar);
                                        w.d("MicroMsg.TVInfoUI", "do del fav tv, local id %d, result %B", new Object[]{Long.valueOf(byVar.fFv.fFx), Boolean.valueOf(byVar.fFw.fFj)});
                                        if (byVar.fFw.fFj) {
                                            this.pth.ptg.finish();
                                            return;
                                        }
                                        return;
                                    default:
                                        w.d("MicroMsg.TVInfoUI", "do del cancel");
                                        return;
                                }
                            }
                        });
                        return;
                    case 0:
                        TVInfoUI.b(this.ptg);
                        return;
                    case 1:
                        TVInfoUI.c(this.ptg);
                        return;
                    case 2:
                        TVInfoUI.d(this.ptg);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    static /* synthetic */ void a(TVInfoUI tVInfoUI, c.a aVar) {
        if (aVar != null && aVar.per != null && aVar.per.size() != 0 && tVInfoUI.isJ != null) {
            tVInfoUI.isJ.removeAll();
            for (int i = 0; i < aVar.per.size(); i++) {
                com.tencent.mm.plugin.shake.e.a aVar2 = (com.tencent.mm.plugin.shake.e.a) aVar.per.get(i);
                if (!(aVar2 == null || aVar2.hSY == null || aVar2.hSY.size() == 0)) {
                    for (int i2 = 0; i2 < aVar2.hSY.size(); i2++) {
                        String str = ((i * 100) + i2);
                        com.tencent.mm.plugin.shake.e.a.a aVar3 = (com.tencent.mm.plugin.shake.e.a.a) aVar2.hSY.get(i2);
                        Preference preference;
                        if (aVar3.type == 2) {
                            preference = new Preference(tVInfoUI);
                            preference.setKey(str);
                            preference.setLayoutResource(R.i.dpm);
                            preference.setTitle(bg.mA(aVar3.title) ? tVInfoUI.getResources().getString(R.l.eWd) : aVar3.title);
                            preference.setSummary(String.format(tVInfoUI.getResources().getString(R.l.eWc), new Object[]{Integer.valueOf(108)}));
                        } else if (aVar3.pto == null || aVar3.pto.size() <= 0) {
                            preference = new Preference(tVInfoUI);
                            preference.setKey(str);
                            preference.setLayoutResource(R.i.dpm);
                            preference.setTitle(aVar3.title);
                            preference.setSummary(aVar3.muI);
                            tVInfoUI.isJ.a(preference);
                        } else {
                            List arrayList = new ArrayList();
                            int i3 = 0;
                            while (i3 < aVar3.pto.size() && i3 < 3 && (i3 != 2 || aVar3.title.length() <= 4)) {
                                arrayList.add(aVar3.pto.get(i3));
                                i3++;
                            }
                            preference = new TVThumbPreference(tVInfoUI);
                            preference.setKey(str);
                            preference.ptl = arrayList;
                            preference.setTitle(aVar3.title);
                            preference.jid = tVInfoUI.isJ;
                            tVInfoUI.isJ.a(preference);
                        }
                    }
                }
            }
            tVInfoUI.isJ.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void a(TVInfoUI tVInfoUI, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("show_bottom", false);
        intent.putExtra("geta8key_scene", 10);
        com.tencent.mm.plugin.shake.a.imv.j(intent, tVInfoUI);
    }

    static /* synthetic */ void b(TVInfoUI tVInfoUI) {
        if (tVInfoUI.ptd == null) {
            w.w("MicroMsg.TVInfoUI", "shareToFriend, but tv is null");
            return;
        }
        com.tencent.mm.plugin.report.service.g.oUh.i(10987, new Object[]{Integer.valueOf(4), "", "", ""});
        String a = c.a(tVInfoUI.uSU.uTo, tVInfoUI.ptd);
        Intent intent = new Intent();
        intent.putExtra("Retr_Msg_content", a);
        intent.putExtra("Retr_Msg_Type", 2);
        if (tVInfoUI.pte != null && tVInfoUI.oZB) {
            intent.putExtra("Retr_Msg_thumb_path", tVInfoUI.pte.Nm());
        }
        intent.putExtra("Retr_go_to_chattingUI", false);
        intent.putExtra("Retr_show_success_tips", true);
        com.tencent.mm.plugin.shake.a.imv.l(intent, tVInfoUI);
    }

    static /* synthetic */ void b(TVInfoUI tVInfoUI, c.a aVar) {
        if (aVar != null && !bg.mA(aVar.field_thumburl)) {
            tVInfoUI.pte = new b(aVar);
            tVInfoUI.ptb = tVInfoUI.pte.No();
            Bitmap a = j.a(tVInfoUI.pte);
            w.d("MicroMsg.TVInfoUI", "initHeaderImg photo = %s", new Object[]{a});
            if (a != null) {
                tVInfoUI.kmG.setImageBitmap(a);
                tVInfoUI.oZB = true;
                tVInfoUI.aYG();
                return;
            }
            tVInfoUI.kmG.setImageDrawable(tVInfoUI.getResources().getDrawable(R.k.dAf));
        }
    }

    static /* synthetic */ void c(TVInfoUI tVInfoUI) {
        if (tVInfoUI.ptd == null) {
            w.w("MicroMsg.TVInfoUI", "shareToTimeLine, but tv is null");
            return;
        }
        com.tencent.mm.plugin.report.service.g.oUh.i(10987, new Object[]{Integer.valueOf(3), "", "", ""});
        Intent intent = new Intent();
        if (bg.mA(tVInfoUI.ptd.field_topic)) {
            intent.putExtra("KContentObjDesc", tVInfoUI.ptd.field_subtitle);
        } else {
            intent.putExtra("KContentObjDesc", tVInfoUI.ptd.field_topic);
        }
        intent.putExtra("Ksnsupload_title", tVInfoUI.ptd.field_title);
        intent.putExtra("Ksnsupload_link", tVInfoUI.ptd.field_shareurl);
        intent.putExtra("Ksnsupload_appname", tVInfoUI.getString(R.l.ePu));
        if (k.baQ()) {
            intent.putExtra("Ksnsupload_appid", "wxaf060266bfa9a35c");
        }
        intent.putExtra("Ksnsupload_imgurl", tVInfoUI.ptd.field_thumburl);
        if (tVInfoUI.pte != null && tVInfoUI.oZB) {
            intent.putExtra("KsnsUpload_imgPath", tVInfoUI.pte.Nm());
        }
        intent.putExtra("Ksnsupload_type", 5);
        intent.putExtra("KUploadProduct_UserData", c.b(tVInfoUI.ptd));
        String fQ = q.fQ("shake_tv");
        q.yC().n(fQ, true).l("prePublishId", "shake_tv");
        intent.putExtra("reportSessionId", fQ);
        com.tencent.mm.bb.d.b(tVInfoUI, "sns", ".ui.En_c4f742e5", intent);
    }

    static /* synthetic */ void d(TVInfoUI tVInfoUI) {
        if (tVInfoUI.ptd == null) {
            w.w("MicroMsg.TVInfoUI", "do favorite, but tv is null");
            return;
        }
        com.tencent.mm.plugin.report.service.g.oUh.i(10987, new Object[]{Integer.valueOf(5), "", "", ""});
        com.tencent.mm.sdk.b.b cbVar = new cb();
        rv rvVar = new rv();
        rw rwVar = new rw();
        rz rzVar = new rz();
        rwVar.OD(m.xL());
        rwVar.OE(m.xL());
        rwVar.yj(8);
        rwVar.ep(bg.Nz());
        if (k.baQ()) {
            rwVar.OJ("wxaf060266bfa9a35c");
        }
        rzVar.OM(tVInfoUI.ptd.field_title);
        if (bg.mA(tVInfoUI.ptd.field_topic)) {
            rzVar.ON(tVInfoUI.ptd.field_subtitle);
        } else {
            rzVar.ON(tVInfoUI.ptd.field_topic);
        }
        rzVar.OP(c.b(tVInfoUI.ptd));
        rzVar.OO(tVInfoUI.ptd.field_thumburl);
        cbVar.fFA.title = tVInfoUI.ptd.field_title;
        cbVar.fFA.desc = tVInfoUI.ptd.field_topic;
        cbVar.fFA.fFC = rvVar;
        cbVar.fFA.type = 15;
        rvVar.a(rwVar);
        rvVar.b(rzVar);
        cbVar.fFA.fFH = 12;
        cbVar.fFA.activity = tVInfoUI;
        com.tencent.mm.sdk.b.a.urY.m(cbVar);
    }

    protected final int getLayoutId() {
        return R.i.cKj;
    }

    public final int ON() {
        return R.o.fuA;
    }

    public final int aeq() {
        return R.i.dpl;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j.b(this);
        KC();
    }

    protected void onResume() {
        super.onResume();
        ap.vd().a(552, this);
    }

    protected void onPause() {
        ap.vd().b(552, this);
        super.onPause();
    }

    protected void onDestroy() {
        j.c(this);
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.ePr);
        this.isJ = this.vrv;
        this.ioX = (TextView) findViewById(R.h.cKx);
        this.ptc = (TextView) findViewById(R.h.cKy);
        String stringExtra = getIntent().getStringExtra("key_TV_xml");
        if (bg.mA(stringExtra)) {
            byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_TV_xml_bytes");
            if (byteArrayExtra != null) {
                stringExtra = new String(byteArrayExtra);
            }
        }
        w.d("MicroMsg.TVInfoUI", "tvinfo xml : %s", new Object[]{stringExtra});
        this.ptd = c.En(stringExtra);
        if (this.ptd == null) {
            w.e("MicroMsg.TVInfoUI", "initView(), tv == null");
            finish();
            return;
        }
        a(this.ptd);
    }

    private void a(final c.a aVar) {
        if (aVar == null) {
            w.e("MicroMsg.TVInfoUI", "refreshViewByProduct(), pd == null");
            finish();
            return;
        }
        this.ioX.setText(aVar.field_title);
        if (bg.mA(aVar.field_topic)) {
            this.ptc.setVisibility(8);
        } else {
            this.ptc.setText(aVar.field_topic);
        }
        this.kmG = (ImageView) findViewById(R.h.cKw);
        if (!bg.mA(aVar.field_playurl)) {
            ImageView imageView = (ImageView) findViewById(R.h.cKv);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ TVInfoUI ptg;

                public final void onClick(View view) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(10987, new Object[]{Integer.valueOf(2), aVar.field_playstatid, "", ""});
                    TVInfoUI.a(this.ptg, aVar.field_playurl);
                }
            });
            this.kmG.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ TVInfoUI ptg;

                public final void onClick(View view) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(10987, new Object[]{Integer.valueOf(2), aVar.field_playstatid, "", ""});
                    TVInfoUI.a(this.ptg, aVar.field_playurl);
                }
            });
        }
        a(0, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ TVInfoUI ptg;

            {
                this.ptg = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                TVInfoUI.a(this.ptg);
                return true;
            }
        });
        if (!(bg.mA(aVar.field_id) || this.pbX || getIntent().getBooleanExtra("key_TV_come_from_shake", false))) {
            w.d("MicroMsg.TVInfoUI", "GetTVInfo id[%s], scene[%s]", new Object[]{aVar.field_id, Integer.valueOf(getIntent().getIntExtra("key_TV_getProductInfoScene", 0))});
            ap.vd().a(new com.tencent.mm.plugin.shake.d.a.b(aVar.field_id, r0), 0);
            this.pbX = true;
        }
        this.kmG.setVisibility(0);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ TVInfoUI ptg;

            {
                this.ptg = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ptg.finish();
                return true;
            }
        });
        w.v("MicroMsg.TVInfoUI", "start postToMainThread initBodyView");
        af.v(new Runnable(this) {
            final /* synthetic */ TVInfoUI ptg;

            public final void run() {
                TVInfoUI.a(this.ptg, aVar);
                TVInfoUI.b(this.ptg, aVar);
            }
        });
    }

    private void aYG() {
        this.fGM = getIntent().getLongExtra("key_TVInfoUI_chatting_msgId", 0);
        if (this.fGM > 0 && ap.zb()) {
            ap.yY();
            ce cA = com.tencent.mm.u.c.wT().cA(this.fGM);
            if (cA.field_msgId > 0) {
                cA.cI(this.pte.Nm());
                ap.yY();
                com.tencent.mm.u.c.wT().a(this.fGM, cA);
            }
        }
    }

    public final boolean a(f fVar, Preference preference) {
        w.d("MicroMsg.TVInfoUI", "onPreferenceTreeClick item: [%s]", new Object[]{preference.igL});
        if (this.ptd == null || this.ptd.per == null) {
            w.e("MicroMsg.TVInfoUI", "tv == null || tv.actionlist == null");
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.igL).intValue();
            int i = intValue / 100;
            int i2 = intValue % 100;
            w.v("MicroMsg.TVInfoUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[]{Integer.valueOf(intValue), Integer.valueOf(i), Integer.valueOf(i2)});
            if (i < 0 || i >= this.ptd.per.size()) {
                w.w("MicroMsg.TVInfoUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.ptd.per.size())});
                return false;
            }
            com.tencent.mm.plugin.shake.e.a aVar = (com.tencent.mm.plugin.shake.e.a) this.ptd.per.get(i);
            if (aVar == null) {
                w.w("MicroMsg.TVInfoUI", "actionList == null");
                return false;
            } else if (i2 < 0 || i2 >= aVar.hSY.size()) {
                w.w("MicroMsg.TVInfoUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(aVar.hSY.size())});
                return false;
            } else {
                com.tencent.mm.plugin.shake.e.a.a aVar2 = (com.tencent.mm.plugin.shake.e.a.a) aVar.hSY.get(i2);
                if (aVar2 == null) {
                    w.w("MicroMsg.TVInfoUI", "action == null");
                    return false;
                }
                w.v("MicroMsg.TVInfoUI", "action type:" + aVar2.type + ", target:" + aVar2.ptn + ", targetDesc:" + aVar2.ptp + ", targetDesc2:" + aVar2.ptq);
                Intent intent;
                if (aVar2.type == 3) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", aVar2.ptn);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("geta8key_scene", 10);
                    intent.putExtra("srcUsername", aVar2.ptq);
                    com.tencent.mm.plugin.shake.a.imv.j(intent, this);
                } else if (aVar2.type == 4) {
                    ap.yY();
                    com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(aVar2.ptn);
                    if (Rc != null) {
                        Intent intent2 = new Intent();
                        if (com.tencent.mm.j.a.ez(Rc.field_type) && Rc.bLe()) {
                            com.tencent.mm.modelbiz.w.DH().hO(aVar2.ptn);
                            if (aVar2.ptp.equals("1")) {
                                intent2.putExtra("Chat_User", aVar2.ptn);
                                intent2.putExtra("finish_direct", true);
                                com.tencent.mm.plugin.shake.a.imv.e(intent2, this);
                            }
                        }
                        intent2.putExtra("Contact_User", aVar2.ptn);
                        intent2.putExtra("force_get_contact", true);
                        com.tencent.mm.bb.d.b(this, "profile", ".ui.ContactInfoUI", intent2);
                    }
                } else if (aVar2.type == 5) {
                    com.tencent.mm.sdk.b.b grVar = new gr();
                    grVar.fLZ.actionCode = 11;
                    grVar.fLZ.result = aVar2.ptn;
                    grVar.fLZ.context = this;
                    grVar.nFq = null;
                    com.tencent.mm.sdk.b.a.urY.a(grVar, Looper.myLooper());
                } else if (aVar2.type == 6) {
                    intent = new Intent();
                    intent.putExtra("key_product_id", aVar2.ptn);
                    intent.putExtra("key_product_scene", 9);
                    com.tencent.mm.bb.d.b(this, "product", ".ui.MallProductUI", intent);
                }
                return true;
            }
        } catch (Throwable e) {
            w.e("MicroMsg.TVInfoUI", "onPreferenceTreeClick, [%s]", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.TVInfoUI", e, "", new Object[0]);
            return false;
        }
    }

    public final void k(final String str, final Bitmap bitmap) {
        if (str != null) {
            String str2 = "MicroMsg.TVInfoUI";
            String str3 = "onGetPictureFinish pic, url = [%s], bitmap is null ? [%B]";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bitmap == null);
            w.d(str2, str3, objArr);
            try {
                af.v(new Runnable(this) {
                    final /* synthetic */ TVInfoUI ptg;

                    public final void run() {
                        if (this.ptg.ptb != null && this.ptg.ptb.equals(str)) {
                            if (!(this.ptg.kmG == null || bitmap == null)) {
                                this.ptg.kmG.setImageBitmap(bitmap);
                                this.ptg.aYG();
                            }
                            this.ptg.oZB = true;
                        }
                    }
                });
                return;
            } catch (Throwable e) {
                w.e("MicroMsg.TVInfoUI", "onGetPictureFinish : [%s]", new Object[]{e.getLocalizedMessage()});
                w.printErrStackTrace("MicroMsg.TVInfoUI", e, "", new Object[0]);
                return;
            }
        }
        w.e("MicroMsg.TVInfoUI", "onUpdate pic, url  is null ");
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if (kVar == null) {
            w.w("MicroMsg.TVInfoUI", "scene == null");
        } else if (kVar.getType() != 552) {
        } else {
            if (i != 0 || i2 != 0) {
                w.e("MicroMsg.TVInfoUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                Toast.makeText(this, R.l.ePs, 0).show();
            } else if (this.ptd == null) {
                w.w("MicroMsg.TVInfoUI", "onSceneEnd tv == null");
            } else {
                com.tencent.mm.plugin.shake.d.a.b bVar = (com.tencent.mm.plugin.shake.d.a.b) kVar;
                abs com_tencent_mm_protocal_c_abs = (bVar.gUA == null || bVar.gUA.hsk.hsr == null) ? null : (abs) bVar.gUA.hsk.hsr;
                if (com_tencent_mm_protocal_c_abs == null) {
                    w.w("MicroMsg.TVInfoUI", "onSceneEnd tvInfo == null");
                } else if (com_tencent_mm_protocal_c_abs.tlo != null) {
                    w.d("MicroMsg.TVInfoUI", "onSceneEnd  tvInfo.DescriptionXML != null, res:" + com_tencent_mm_protocal_c_abs.tlo);
                    c.a En = c.En(com_tencent_mm_protocal_c_abs.tlo);
                    if (this.ptd != null && this.ptd.field_xml != null && En != null && En.field_xml != null && !this.ptd.field_xml.equals(En.field_xml)) {
                        this.ptd = En;
                        a(this.ptd);
                    }
                }
            }
        }
    }
}
