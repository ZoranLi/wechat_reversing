package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.am.c;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.gh;
import com.tencent.mm.e.a.jb;
import com.tencent.mm.e.a.mn;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.a.a.j;
import com.tencent.mm.plugin.sns.a.a.j.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.bdt;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.x.n;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.List;

public final class bf {
    public Context context;
    public p irJ;
    public OnClickListener qFc = new OnClickListener(this) {
        final /* synthetic */ bf qKT;

        {
            this.qKT = r1;
        }

        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.qKT.qKF >= 500) {
                this.qKT.qKF = currentTimeMillis;
                if (view.getTag() instanceof q) {
                    q qVar = (q) view.getTag();
                    bfc com_tencent_mm_protocal_c_bfc = qVar.qsY;
                    m Gg = ae.beL().Gg(qVar.fGN);
                    if (this.qKT.qqx != null) {
                        this.qKT.qqx.beq().v(Gg);
                    }
                    Intent intent;
                    alh com_tencent_mm_protocal_c_alh;
                    if (com_tencent_mm_protocal_c_bfc.ufB.tsN == 18) {
                        Context context = this.qKT.context;
                        bfc com_tencent_mm_protocal_c_bfc2 = qVar.qsY;
                        j.a(b.AdUrl, com.tencent.mm.plugin.sns.a.a.j.a.EnterCompleteVideo, ae.beL().Gg(qVar.fGN));
                        intent = new Intent();
                        com_tencent_mm_protocal_c_alh = null;
                        if (com_tencent_mm_protocal_c_bfc2.ufB.tsO.size() > 0) {
                            com_tencent_mm_protocal_c_alh = (alh) com_tencent_mm_protocal_c_bfc2.ufB.tsO.get(0);
                        }
                        intent.putExtra("IsAd", false);
                        intent.putExtra("KStremVideoUrl", com_tencent_mm_protocal_c_bfc2.ufB.msN);
                        intent.putExtra("KSta_SourceType", 2);
                        intent.putExtra("KSta_Scene", b.AdUrl.value);
                        intent.putExtra("KSta_FromUserName", com_tencent_mm_protocal_c_bfc2.jNj);
                        intent.putExtra("KSta_SnSId", com_tencent_mm_protocal_c_bfc2.mQY);
                        if (com_tencent_mm_protocal_c_alh == null) {
                            intent.putExtra("KMediaId", "fakeid_" + (com_tencent_mm_protocal_c_alh == null ? com_tencent_mm_protocal_c_bfc2.mQY : com_tencent_mm_protocal_c_alh.mQY));
                        } else {
                            intent.putExtra("KMediaId", com_tencent_mm_protocal_c_alh.mQY);
                        }
                        bdt com_tencent_mm_protocal_c_bdt = com_tencent_mm_protocal_c_bfc2.ufG;
                        if (com_tencent_mm_protocal_c_bdt != null) {
                            intent.putExtra("KMediaVideoTime", com_tencent_mm_protocal_c_bdt.hjE);
                            intent.putExtra("StreamWording", com_tencent_mm_protocal_c_bdt.hjG);
                            intent.putExtra("StremWebUrl", com_tencent_mm_protocal_c_bdt.hjH);
                            intent.putExtra("KMediaTitle", com_tencent_mm_protocal_c_bdt.hjF);
                            intent.putExtra("KStremVideoUrl", com_tencent_mm_protocal_c_bdt.hjD);
                            intent.putExtra("KThumUrl", com_tencent_mm_protocal_c_bdt.hjI);
                            intent.putExtra("KSta_StremVideoAduxInfo", com_tencent_mm_protocal_c_bdt.hjJ);
                            intent.putExtra("KSta_StremVideoPublishId", com_tencent_mm_protocal_c_bdt.hjK);
                        }
                        intent.putExtra("KSta_SnsStatExtStr", com_tencent_mm_protocal_c_bfc2.qui);
                        d.b(context, "sns", ".ui.VideoAdPlayerUI", intent);
                        return;
                    }
                    String str = com_tencent_mm_protocal_c_bfc.ufB.msN;
                    String str2 = com_tencent_mm_protocal_c_bfc.ufA.mQY;
                    w.d("MicroMsg.TimeLineClickEvent", "url:" + str);
                    String s = com.tencent.mm.plugin.sns.c.a.imw.s(str, "timeline");
                    if (s != null && s.length() != 0) {
                        Intent intent2 = new Intent();
                        Bundle bundle = null;
                        if (com_tencent_mm_protocal_c_bfc != null) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("KSnsStrId", com_tencent_mm_protocal_c_bfc.mQY);
                            bundle2.putString("KSnsLocalId", qVar.fGN);
                            bundle2.putBoolean("KFromTimeline", true);
                            if (com_tencent_mm_protocal_c_bfc.ufB != null && com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                                bundle2.putString("K_sns_thumb_url", ((alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0)).tPi);
                                bundle2.putString("K_sns_raw_url", com_tencent_mm_protocal_c_bfc.ufB.msN);
                                w.i("MicroMsg.TimeLineClickEvent", "put the thumb url %s redirectUrl %s", new Object[]{((alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0)).tPi, com_tencent_mm_protocal_c_bfc.ufB.msN});
                            }
                            bundle = bundle2;
                        }
                        bundle.putString("key_snsad_statextstr", com_tencent_mm_protocal_c_bfc.qui);
                        intent2.putExtra("rawUrl", s);
                        intent2.putExtra("shortUrl", s);
                        intent2.putExtra("useJs", true);
                        intent2.putExtra(Columns.TYPE, -255);
                        if (com_tencent_mm_protocal_c_bfc.ufC != null) {
                            intent2.putExtra("srcUsername", com_tencent_mm_protocal_c_bfc.ufC);
                            intent2.putExtra("srcDisplayname", com_tencent_mm_protocal_c_bfc.sLT);
                            w.i("MicroMsg.TimeLineClickEvent", "urlRedirectListener tlObj.sourceNickName: " + com_tencent_mm_protocal_c_bfc.sLT + " tlObj.publicUserName: " + com_tencent_mm_protocal_c_bfc.ufC);
                        }
                        intent2.putExtra("sns_local_id", qVar.fGN);
                        if (Gg != null) {
                            intent2.putExtra("KPublisherId", "sns_" + i.df(Gg.field_snsId));
                            intent2.putExtra("pre_username", Gg.field_userName);
                            intent2.putExtra("prePublishId", "sns_" + i.df(Gg.field_snsId));
                            intent2.putExtra("preUsername", Gg.field_userName);
                            intent2.putExtra("share_report_pre_msg_url", s);
                            intent2.putExtra("share_report_pre_msg_title", com_tencent_mm_protocal_c_bfc.ufB.fDC);
                            intent2.putExtra("share_report_pre_msg_desc", com_tencent_mm_protocal_c_bfc.ufB.msk);
                            if (com_tencent_mm_protocal_c_bfc.ufB.tsO != null && com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                                intent2.putExtra("share_report_pre_msg_icon_url", ((alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0)).tPi);
                            }
                            intent2.putExtra("share_report_pre_msg_appid", "");
                            intent2.putExtra("share_report_from_scene", 1);
                        }
                        if (!(com_tencent_mm_protocal_c_bfc == null || com_tencent_mm_protocal_c_bfc.ufA == null)) {
                            intent2.putExtra("KAppId", com_tencent_mm_protocal_c_bfc.ufA.mQY);
                        }
                        if (Gg != null && Gg.tE(32)) {
                            com.tencent.mm.plugin.sns.storage.a bhc = Gg.bhc();
                            if (bhc != null) {
                                intent2.putExtra("KsnsViewId", bhc.iHN);
                            }
                        }
                        if (!(Gg == null || com_tencent_mm_protocal_c_bfc == null)) {
                            com.tencent.mm.modelsns.b gz;
                            if (this.qKT.scene == 0) {
                                gz = com.tencent.mm.modelsns.b.gz(718);
                            } else {
                                gz = com.tencent.mm.modelsns.b.gA(718);
                            }
                            gz.kG(i.g(Gg)).gC(Gg.field_type).bp(Gg.tE(32)).kG(Gg.bhI()).kG(com_tencent_mm_protocal_c_bfc.ufC).kG(com_tencent_mm_protocal_c_bfc.ufA == null ? "" : com_tencent_mm_protocal_c_bfc.ufA.mQY).kG(com_tencent_mm_protocal_c_bfc.ufB.msN);
                            gz.JE();
                            if (this.qKT.scene == 0) {
                                gz = com.tencent.mm.modelsns.b.gz(743);
                            } else {
                                gz = com.tencent.mm.modelsns.b.gA(743);
                            }
                            com.tencent.mm.modelsns.b kG = gz.kG(i.g(Gg)).gC(Gg.field_type).bp(Gg.tE(32)).kG(Gg.bhI()).kG(com_tencent_mm_protocal_c_bfc.ufC);
                            if (com_tencent_mm_protocal_c_bfc.ufA == null) {
                                str2 = "";
                            } else {
                                str2 = com_tencent_mm_protocal_c_bfc.ufA.mQY;
                            }
                            kG.kG(str2).kG(com_tencent_mm_protocal_c_bfc.ufB.msN);
                            if (bundle != null) {
                                str2 = "intent_key_StatisticsOplog";
                                byte[] Cf = gz.Cf();
                                if (Cf != null) {
                                    bundle.putByteArray(str2, Cf);
                                }
                            }
                        }
                        if (bundle != null) {
                            intent2.putExtra("jsapiargs", bundle);
                        }
                        intent2.putExtra("geta8key_scene", 2);
                        intent2.putExtra("from_scence", 3);
                        if (bg.mA(com_tencent_mm_protocal_c_bfc.qsQ) || !e.Gb(com_tencent_mm_protocal_c_bfc.qsQ)) {
                            com.tencent.mm.plugin.sns.c.a.imv.j(intent2, this.qKT.context);
                            str2 = null;
                            int i = 0;
                            if (!(com_tencent_mm_protocal_c_bfc == null || com_tencent_mm_protocal_c_bfc.ufA == null)) {
                                str2 = com_tencent_mm_protocal_c_bfc.ufA.mQY;
                                i = bg.getInt(com_tencent_mm_protocal_c_bfc.ufA.jNP, 0);
                            }
                            s = com.tencent.mm.plugin.sns.c.a.imw.i(str2, i);
                            if (!bg.mA(s) && com.tencent.mm.plugin.sns.c.a.imw.bo(str2)) {
                                String str3 = null;
                                if (!(com_tencent_mm_protocal_c_bfc == null || com_tencent_mm_protocal_c_bfc.pYt == null || com_tencent_mm_protocal_c_bfc.pYt.tdQ == null)) {
                                    str3 = com_tencent_mm_protocal_c_bfc.pYt.tdQ.tdJ;
                                }
                                com.tencent.mm.plugin.sns.c.a.imw.a(this.qKT.context, str2, s, com_tencent_mm_protocal_c_bfc == null ? null : com_tencent_mm_protocal_c_bfc.jNj, 5, 4, 1, str3, com_tencent_mm_protocal_c_bfc.mQY);
                            }
                            g.oUh.i(11105, new Object[]{com_tencent_mm_protocal_c_bfc.jNj, com_tencent_mm_protocal_c_bfc.ufB.msN});
                            if (Gg != null && Gg.field_type == 4) {
                                com_tencent_mm_protocal_c_alh = (alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0);
                                g gVar = g.oUh;
                                Object[] objArr = new Object[3];
                                objArr[0] = Integer.valueOf(1);
                                objArr[1] = com_tencent_mm_protocal_c_alh == null ? "" : com_tencent_mm_protocal_c_alh.msk;
                                objArr[2] = com_tencent_mm_protocal_c_bfc.ufA.mQY;
                                gVar.i(13043, objArr);
                                return;
                            }
                            return;
                        }
                        int[] iArr = new int[2];
                        if (view != null) {
                            view.getLocationInWindow(iArr);
                        }
                        int width = view.getWidth();
                        int height = view.getHeight();
                        intent = new Intent();
                        intent.putExtra("img_gallery_left", iArr[0]);
                        intent.putExtra("img_gallery_top", iArr[1]);
                        intent.putExtra("img_gallery_width", width);
                        intent.putExtra("img_gallery_height", height);
                        if (com_tencent_mm_protocal_c_bfc != null) {
                            List list = com_tencent_mm_protocal_c_bfc.ufB.tsO;
                            if (list.size() > 0) {
                                intent.putExtra("sns_landing_pages_share_thumb_url", ((alh) list.get(0)).tPi);
                            }
                        }
                        intent.putExtra("sns_landing_pages_share_sns_id", Gg.bhe());
                        intent.putExtra("sns_landing_pages_aid", Gg.bhD());
                        intent.putExtra("sns_landing_pages_traceid", Gg.bhE());
                        intent.putExtra("sns_landing_pages_ux_info", Gg.bhI());
                        intent.putExtra("sns_landig_pages_from_source", this.qKT.scene == 0 ? 3 : 4);
                        intent.setClass(this.qKT.context, SnsAdNativeLandingPagesUI.class);
                        intent.putExtra("sns_landing_pages_xml", com_tencent_mm_protocal_c_bfc.qsQ);
                        intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                        e.A(intent, this.qKT.context);
                    }
                }
            }
        }
    };
    public a qKE;
    public long qKF = 0;
    public OnClickListener qKG = new OnClickListener(this) {
        final /* synthetic */ bf qKT;

        {
            this.qKT = r1;
        }

        public final void onClick(View view) {
            boolean z;
            String str;
            String str2 = null;
            bf bfVar = this.qKT;
            if (view == null || !(view.getTag() instanceof bfc)) {
                z = true;
            } else {
                str = ((bfc) view.getTag()).ufA.mQY;
                if ("wx485a97c844086dc9".equals(str)) {
                    d.b(view.getContext(), "shake", ".ui.ShakeReportUI", new Intent().putExtra("shake_music", true));
                    z = true;
                } else if ("wx7fa037cc7dfabad5".equals(str)) {
                    com.tencent.mm.plugin.sport.b.d.mN(34);
                    h.vJ();
                    if (com.tencent.mm.j.a.ez(((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc("gh_43f2581f6fd6").field_type)) {
                        r0 = new Intent();
                        r0.putExtra("Chat_User", "gh_43f2581f6fd6");
                        r0.putExtra("finish_direct", true);
                        d.a(bfVar.context, ".ui.chatting.En_5b8fbb1e", r0);
                    } else {
                        r0 = new Intent();
                        r0.putExtra("Contact_User", "gh_43f2581f6fd6");
                        d.b(bfVar.context, "profile", ".ui.ContactInfoUI", r0);
                    }
                    z = true;
                } else if ("wx9181ed3f223e6d76".equals(str) || "wx2fe12a395c426fcf".equals(str)) {
                    w.i("MicroMsg.TimeLineClickEvent", "hy: shake new year closed. try to go to shake TV");
                    r0 = new Intent();
                    r0.putExtra("shake_tv", true);
                    d.b(view.getContext(), "shake", ".ui.ShakeReportUI", r0);
                    z = true;
                } else if ("wx751a1acca5688ba3".equals(str)) {
                    r0 = new Intent();
                    r0.putExtra("BaseScanUI_select_scan_mode", 5);
                    if (!(com.tencent.mm.n.a.aI(bfVar.context) || com.tencent.mm.n.a.aH(bfVar.context))) {
                        d.b(bfVar.context, "scanner", ".ui.BaseScanUI", r0);
                    }
                    z = true;
                } else if ("wxfbc915ff7c30e335".equals(str)) {
                    r0 = new Intent();
                    r0.putExtra("BaseScanUI_select_scan_mode", 1);
                    if (!(com.tencent.mm.n.a.aI(bfVar.context) || com.tencent.mm.n.a.aH(bfVar.context))) {
                        d.b(bfVar.context, "scanner", ".ui.BaseScanUI", r0);
                    }
                    z = true;
                } else if ("wx482a4001c37e2b74".equals(str)) {
                    r0 = new Intent();
                    r0.putExtra("BaseScanUI_select_scan_mode", 2);
                    if (!(com.tencent.mm.n.a.aI(bfVar.context) || com.tencent.mm.n.a.aH(bfVar.context))) {
                        d.b(bfVar.context, "scanner", ".ui.BaseScanUI", r0);
                    }
                    z = true;
                } else if (!"wxaf060266bfa9a35c".equals(str)) {
                    z = false;
                } else if (c.HQ()) {
                    r0 = new Intent();
                    r0.putExtra("shake_tv", true);
                    d.b(bfVar.context, "shake", ".ui.ShakeReportUI", r0);
                    z = true;
                } else {
                    z = true;
                }
            }
            if (!z && view != null && (view.getTag() instanceof bfc)) {
                bfc com_tencent_mm_protocal_c_bfc = (bfc) view.getTag();
                if (com_tencent_mm_protocal_c_bfc == null || com_tencent_mm_protocal_c_bfc.ufA == null) {
                    w.e("MicroMsg.TimeLineClickEvent", "appInfo is null");
                    return;
                }
                String str3 = com_tencent_mm_protocal_c_bfc.ufA.mQY;
                String bm = com.tencent.mm.plugin.sns.c.a.imw.bm(str3);
                if (bg.mA(bm) || !com.tencent.mm.plugin.sns.c.a.imw.bo(str3)) {
                    str = com.tencent.mm.plugin.sns.c.a.imw.e(this.qKT.context, str3, "timeline");
                    if (str != null && str.length() != 0) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str);
                        intent.putExtra("shortUrl", str);
                        intent.putExtra("useJs", true);
                        intent.putExtra(Columns.TYPE, -255);
                        intent.putExtra("geta8key_scene", 2);
                        com.tencent.mm.plugin.sns.c.a.imv.j(intent, this.qKT.context);
                        return;
                    }
                    return;
                }
                int i;
                String str4 = com_tencent_mm_protocal_c_bfc == null ? null : com_tencent_mm_protocal_c_bfc.jNj;
                if (com_tencent_mm_protocal_c_bfc.ufB.tsN == 1) {
                    i = 2;
                } else if (com_tencent_mm_protocal_c_bfc.ufB.tsN == 3) {
                    i = 5;
                } else {
                    i = 2;
                }
                if (!(com_tencent_mm_protocal_c_bfc.pYt == null || com_tencent_mm_protocal_c_bfc.pYt.tdQ == null)) {
                    str2 = com_tencent_mm_protocal_c_bfc.pYt.tdQ.tdJ;
                }
                com.tencent.mm.sdk.b.b mnVar = new mn();
                mnVar.fTN.context = this.qKT.context;
                mnVar.fTN.scene = 4;
                mnVar.fTN.fTO = str3;
                mnVar.fTN.packageName = bm;
                mnVar.fTN.msgType = i;
                mnVar.fTN.fOu = str4;
                mnVar.fTN.mediaTagName = str2;
                mnVar.fTN.fTP = 5;
                mnVar.fTN.fTQ = 0;
                mnVar.fTN.fTR = com_tencent_mm_protocal_c_bfc.mQY;
                com.tencent.mm.sdk.b.a.urY.m(mnVar);
                com.tencent.mm.sdk.b.b ghVar = new gh();
                ghVar.fLB.actionCode = 2;
                ghVar.fLB.scene = 3;
                ghVar.fLB.extMsg = "timeline_src=3";
                ghVar.fLB.appId = str3;
                ghVar.fLB.context = this.qKT.context;
                com.tencent.mm.sdk.b.a.urY.m(ghVar);
            }
        }
    };
    public OnClickListener qKH = new OnClickListener(this) {
        final /* synthetic */ bf qKT;

        {
            this.qKT = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof bc) {
                final bc bcVar = (bc) view.getTag();
                if (bg.mA(bcVar.qKq)) {
                    w.e("MicroMsg.TimeLineClickEvent", "show source profile fail, username is null");
                    Toast.makeText(this.qKT.context, this.qKT.context.getString(com.tencent.mm.plugin.sns.i.j.elS, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                    return;
                }
                h.vJ();
                af Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(bcVar.qKq);
                if (Rc == null || !Rc.field_username.equals(bcVar.qKq)) {
                    com.tencent.mm.u.ag.a.hlS.a(bcVar.qKq, "", new com.tencent.mm.u.ag.b.a(this) {
                        final /* synthetic */ AnonymousClass8 qKU;

                        {
                            this.qKU = r1;
                        }

                        public final void p(String str, boolean z) {
                            if (this.qKU.qKT.irJ != null) {
                                this.qKU.qKT.irJ.dismiss();
                            }
                            if (z) {
                                com.tencent.mm.x.b.u(str, 3);
                                n.Bz().hf(str);
                                Intent intent = new Intent();
                                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                intent.putExtra("Contact_User", str);
                                intent.putExtra("Contact_Scene", 37);
                                h.vJ();
                                x Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(str);
                                if (Rc != null && Rc.bLe()) {
                                    g.oUh.A(10298, str + ",37");
                                    intent.putExtra("Contact_Scene", 37);
                                }
                                com.tencent.mm.plugin.sns.c.a.imv.d(intent, this.qKU.qKT.context);
                                return;
                            }
                            Toast.makeText(this.qKU.qKT.context, this.qKU.qKT.context.getString(com.tencent.mm.plugin.sns.i.j.elS, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                        }
                    });
                    bf bfVar = this.qKT;
                    Context context = this.qKT.context;
                    this.qKT.context.getString(com.tencent.mm.plugin.sns.i.j.dIO);
                    bfVar.irJ = com.tencent.mm.ui.base.g.a(context, this.qKT.context.getString(com.tencent.mm.plugin.sns.i.j.dJd), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass8 qKU;

                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.u.ag.a.hlS.gc(bcVar.qKq);
                        }
                    });
                    return;
                }
                Intent intent = new Intent();
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.putExtra("Contact_User", bcVar.qKq);
                g.oUh.A(10298, bcVar.qKq + ",37");
                intent.putExtra("Contact_Scene", 37);
                com.tencent.mm.plugin.sns.c.a.imv.d(intent, this.qKT.context);
            }
        }
    };
    public OnClickListener qKI = new OnClickListener(this) {
        final /* synthetic */ bf qKT;

        {
            this.qKT = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                bfc com_tencent_mm_protocal_c_bfc = qVar.qsY;
                if (com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                    m Gg = ae.beL().Gg(qVar.fGN);
                    if (this.qKT.qqx != null) {
                        this.qKT.qqx.beq().v(Gg);
                    }
                    String str = ((alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0)).qqP;
                    Intent intent = new Intent();
                    intent.putExtra("key_Product_xml", str);
                    intent.putExtra("key_ProductUI_getProductInfoScene", 2);
                    d.b(view.getContext(), "scanner", ".ui.ProductUI", intent);
                }
            }
        }
    };
    public OnClickListener qKJ = new OnClickListener(this) {
        final /* synthetic */ bf qKT;

        {
            this.qKT = r1;
        }

        public final void onClick(View view) {
            w.d("MicroMsg.TimeLineClickEvent", "hardTVRedirectListener");
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                bfc com_tencent_mm_protocal_c_bfc = qVar.qsY;
                if (com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                    m Gg = ae.beL().Gg(qVar.fGN);
                    if (this.qKT.qqx != null) {
                        this.qKT.qqx.beq().v(Gg);
                    }
                    String str = ((alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0)).qqP;
                    Intent intent = new Intent();
                    intent.putExtra("key_TV_xml", str);
                    intent.putExtra("key_TV_getProductInfoScene", 2);
                    d.b(view.getContext(), "shake", ".ui.TVInfoUI", intent);
                }
            }
        }
    };
    public OnClickListener qKK = new OnClickListener(this) {
        final /* synthetic */ bf qKT;

        {
            this.qKT = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                bfc com_tencent_mm_protocal_c_bfc = qVar.qsY;
                if (com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                    m Gg = ae.beL().Gg(qVar.fGN);
                    if (this.qKT.qqx != null) {
                        this.qKT.qqx.beq().v(Gg);
                    }
                    String str = ((alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0)).qqP;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    intent.putExtra("preceding_scence", 10);
                    intent.putExtra("download_entrance_scene", 13);
                    d.b(view.getContext(), "emoji", ".ui.EmojiStoreDetailUI", intent);
                }
            }
        }
    };
    public OnClickListener qKL = new OnClickListener(this) {
        final /* synthetic */ bf qKT;

        {
            this.qKT = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                bfc com_tencent_mm_protocal_c_bfc = qVar.qsY;
                if (com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                    m Gg = ae.beL().Gg(qVar.fGN);
                    if (this.qKT.qqx != null) {
                        this.qKT.qqx.beq().v(Gg);
                    }
                    String str = ((alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0)).qqP;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    intent.putExtra("extra_scence", 13);
                    d.b(view.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent);
                }
            }
        }
    };
    public OnClickListener qKM = new OnClickListener(this) {
        final /* synthetic */ bf qKT;

        {
            this.qKT = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                bfc com_tencent_mm_protocal_c_bfc = qVar.qsY;
                if (com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                    m Gg = ae.beL().Gg(qVar.fGN);
                    if (this.qKT.qqx != null) {
                        this.qKT.qqx.beq().v(Gg);
                    }
                    String str = ((alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0)).qqP;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    intent.putExtra("extra_scence", 13);
                    d.b(view.getContext(), "emoji", ".ui.EmojiStoreTopicUI", intent);
                }
            }
        }
    };
    public OnClickListener qKN = new OnClickListener(this) {
        final /* synthetic */ bf qKT;

        {
            this.qKT = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                bfc com_tencent_mm_protocal_c_bfc = qVar.qsY;
                if (com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                    m Gg = ae.beL().Gg(qVar.fGN);
                    if (this.qKT.qqx != null) {
                        this.qKT.qqx.beq().v(Gg);
                    }
                    String str = ((alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0)).qqP;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    d.b(view.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
                }
            }
        }
    };
    public OnClickListener qKO = new OnClickListener(this) {
        final /* synthetic */ bf qKT;

        {
            this.qKT = r1;
        }

        public final void onClick(View view) {
            boolean z = view.getTag() instanceof q;
            w.d("MicroMsg.TimeLineClickEvent", "musicRedirectListener click " + z);
            if (z) {
                q qVar = (q) view.getTag();
                bfc com_tencent_mm_protocal_c_bfc = qVar.qsY;
                if (bf.DJ(com_tencent_mm_protocal_c_bfc.mQY)) {
                    g.oUh.A(10231, "1");
                    com.tencent.mm.am.b.HH();
                } else if (!(com.tencent.mm.n.a.aJ(this.qKT.context) || com.tencent.mm.n.a.aH(this.qKT.context))) {
                    g.oUh.A(10090, "1,0");
                    if (com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                        com.tencent.mm.modelsns.b gz;
                        String str;
                        alh com_tencent_mm_protocal_c_alh = (alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0);
                        if (this.qKT.scene == 0) {
                            gz = com.tencent.mm.modelsns.b.gz(738);
                        } else {
                            gz = com.tencent.mm.modelsns.b.gA(738);
                        }
                        com.tencent.mm.modelsns.b kG = gz.kG(com_tencent_mm_protocal_c_bfc.mQY).kG(com_tencent_mm_protocal_c_bfc.jNj);
                        if (com_tencent_mm_protocal_c_bfc.ufA == null) {
                            str = "";
                        } else {
                            str = com_tencent_mm_protocal_c_bfc.ufA.mQY;
                        }
                        kG.kG(str).kG(com_tencent_mm_protocal_c_alh.fDC).kG(com_tencent_mm_protocal_c_alh.msk).kG("");
                        gz.JE();
                    }
                    if (qVar.qsZ) {
                        com.tencent.mm.am.b.a(((com.tencent.mm.am.a.a) h.h(com.tencent.mm.am.a.a.class)).a(ae.xv(), com_tencent_mm_protocal_c_bfc, 9));
                    } else {
                        com.tencent.mm.am.b.b(((com.tencent.mm.am.a.a) h.h(com.tencent.mm.am.a.a.class)).a(ae.xv(), com_tencent_mm_protocal_c_bfc, 1));
                    }
                }
                if (this.qKT.qKE != null) {
                    this.qKT.qKE.bjX();
                }
            }
        }
    };
    public OnClickListener qKP = new OnClickListener(this) {
        final /* synthetic */ bf qKT;

        {
            this.qKT = r1;
        }

        public final void onClick(View view) {
            w.i("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener");
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                bfc com_tencent_mm_protocal_c_bfc = qVar.qsY;
                m Gg = ae.beL().Gg(qVar.fGN);
                if (this.qKT.qqx != null) {
                    this.qKT.qqx.beq().v(Gg);
                }
                if (com_tencent_mm_protocal_c_bfc.ufH == null) {
                    w.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener weappInfo is null");
                    return;
                }
                String str = com_tencent_mm_protocal_c_bfc.ufH.username;
                String str2 = com_tencent_mm_protocal_c_bfc.ufH.path;
                w.i("MicroMsg.TimeLineClickEvent", "username: " + str + "pagepath: " + str2);
                com.tencent.mm.sdk.b.b prVar = new pr();
                prVar.fWB.userName = str;
                prVar.fWB.fWD = str2;
                prVar.fWB.scene = 1009;
                prVar.fWB.fCN = com_tencent_mm_protocal_c_bfc.mQY + ":" + com_tencent_mm_protocal_c_bfc.jNj;
                Bundle bundle = new Bundle();
                bundle.putString("stat_send_msg_user", Gg.field_userName);
                bundle.putString("stat_msg_id", "sns_" + i.df(Gg.field_snsId));
                com.tencent.mm.sdk.b.a.urY.m(prVar);
            }
        }
    };
    public OnClickListener qKQ = new OnClickListener(this) {
        final /* synthetic */ bf qKT;

        {
            this.qKT = r1;
        }

        public final void onClick(View view) {
            w.i("MicroMsg.TimeLineClickEvent", "appbrandHomeRedirectListener");
            if (view.getTag() instanceof bfc) {
                bfc com_tencent_mm_protocal_c_bfc = (bfc) view.getTag();
                if (com_tencent_mm_protocal_c_bfc.ufH == null) {
                    w.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
                    return;
                }
                String str = com_tencent_mm_protocal_c_bfc.ufH.username;
                com.tencent.mm.sdk.b.b prVar = new pr();
                w.i("MicroMsg.TimeLineClickEvent", "username: " + str);
                prVar.fWB.userName = str;
                prVar.fWB.scene = 1009;
                prVar.fWB.fCN = com_tencent_mm_protocal_c_bfc.mQY + ":" + com_tencent_mm_protocal_c_bfc.jNj;
                com.tencent.mm.sdk.b.a.urY.m(prVar);
            }
        }
    };
    public OnClickListener qKR = new OnClickListener(this) {
        final /* synthetic */ bf qKT;

        {
            this.qKT = r1;
        }

        public final void onClick(View view) {
            w.i("MicroMsg.TimeLineClickEvent", "hardMallProductRedirectListener");
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                bfc com_tencent_mm_protocal_c_bfc = qVar.qsY;
                if (com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                    m Gg = ae.beL().Gg(qVar.fGN);
                    if (this.qKT.qqx != null) {
                        this.qKT.qqx.beq().v(Gg);
                    }
                    String str = ((alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0)).qqP;
                    Intent intent = new Intent();
                    intent.putExtra("key_product_scene", 2);
                    intent.putExtra("key_product_info", str);
                    d.b(this.qKT.context, "product", ".ui.MallProductUI", intent);
                }
            }
        }
    };
    public OnClickListener qKS = new OnClickListener(this) {
        final /* synthetic */ bf qKT;

        {
            this.qKT = r1;
        }

        public final void onClick(View view) {
            w.i("MicroMsg.TimeLineClickEvent", "cardRediretListener");
            if (view.getTag() instanceof q) {
                q qVar = (q) view.getTag();
                bfc com_tencent_mm_protocal_c_bfc = qVar.qsY;
                if (com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0) {
                    m Gg = ae.beL().Gg(qVar.fGN);
                    if (this.qKT.qqx != null) {
                        this.qKT.qqx.beq().v(Gg);
                    }
                    String str = ((alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0)).qqP;
                    Intent intent = new Intent();
                    intent.putExtra("key_from_scene", 12);
                    if (TextUtils.isEmpty(str)) {
                        w.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData is empty");
                        return;
                    }
                    String[] split = str.split("#");
                    if (split.length >= 2) {
                        w.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData[0]:" + split[0]);
                        intent.putExtra("key_card_id", split[0]);
                        intent.putExtra("key_card_ext", split[1]);
                        d.b(this.qKT.context, "card", ".ui.CardDetailUI", intent);
                    } else if (split.length == 1) {
                        w.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include cardExt");
                        w.i("MicroMsg.TimeLineClickEvent", "cardRediretListener card_id :" + str);
                        intent.putExtra("key_card_id", split[0]);
                        intent.putExtra("key_card_ext", "");
                        d.b(this.qKT.context, "card", ".ui.CardDetailUI", intent);
                    } else {
                        w.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include card_id and cardExt");
                        w.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData :" + str);
                    }
                }
            }
        }
    };
    public ad qqx;
    public int scene = 0;

    public interface a {
        void bjX();
    }

    public bf(Context context, a aVar, int i, ad adVar) {
        this.context = context;
        this.qKE = aVar;
        this.scene = i;
        this.qqx = adVar;
    }

    protected static boolean DJ(String str) {
        com.tencent.mm.sdk.b.b jbVar = new jb();
        jbVar.fOW.action = -2;
        com.tencent.mm.sdk.b.a.urY.m(jbVar);
        anf com_tencent_mm_protocal_c_anf = jbVar.fOX.fOY;
        if (com_tencent_mm_protocal_c_anf != null && com.tencent.mm.am.b.d(com_tencent_mm_protocal_c_anf) && str.equals(com_tencent_mm_protocal_c_anf.tqY) && com.tencent.mm.am.b.HJ()) {
            return true;
        }
        return false;
    }
}
