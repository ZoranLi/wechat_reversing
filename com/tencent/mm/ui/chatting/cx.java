package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.cl;
import com.tencent.mm.e.a.ik;
import com.tencent.mm.e.a.nw;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.a.rq;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.network.aa;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.map.k;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.u.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.wcdb.FileUtils;
import java.util.Map;
import junit.framework.Assert;

class cx implements OnClickListener {
    public static boolean vFM = false;
    public a vCd;

    public cx(a aVar, String str) {
        this.vCd = aVar;
        b ikVar = new ik();
        ikVar.fOe.aQd = v.bIN();
        if (o.dH(str)) {
            ikVar.fOe.fOg = true;
        } else {
            ikVar.fOe.fOg = false;
        }
        com.tencent.mm.sdk.b.a.urY.m(ikVar);
    }

    public void onClick(View view) {
        dt dtVar = (dt) view.getTag();
        int i = 0;
        String str;
        Intent intent;
        String str2;
        Intent intent2;
        String str3;
        Intent intent3;
        String str4;
        String str5;
        Intent intent4;
        switch (dtVar.knu) {
            case 1:
            case 9:
                str = dtVar.userName;
                if (str != null && !str.equals("")) {
                    if (this.vCd.sPf) {
                        Context context = this.vCd.uSU.uTo;
                        intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        intent.putExtra("Contact_Encryptusername", true);
                        intent.putExtra("Contact_IsLBSFriend", true);
                        intent.putExtra("Contact_IsLbsChattingProfile", true);
                        d.b(context, "profile", ".ui.ContactInfoUI", intent);
                        return;
                    } else if (this.vCd.sMK) {
                        j ip = this.vCd.vve.ip(str);
                        if (ip == null) {
                            return;
                        }
                        if (ip == null || u.mA(ip.field_profileUrl)) {
                            str = "MicroMsg.ChattingListClickListener";
                            str2 = "onClick userInfo == null:%s";
                            Object[] objArr = new Object[1];
                            objArr[0] = Boolean.valueOf(ip == null);
                            w.w(str, str2, objArr);
                            return;
                        }
                        w.i("MicroMsg.ChattingListClickListener", "onClick Url:%s", ip.field_profileUrl);
                        com.tencent.mm.modelbiz.w.DN().Y(ip.field_userId, ip.field_brandUserName);
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", ip.field_profileUrl);
                        intent2.putExtra("useJs", true);
                        d.b(this.vCd.bPj(), "webview", ".ui.tools.WebViewUI", intent2);
                        return;
                    } else {
                        intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        if (dtVar.knu == 9 && !u.mA(dtVar.vNb)) {
                            intent.putExtra("Contact_BIZ_KF_WORKER_ID", dtVar.vNb);
                        }
                        ap.yY();
                        com.tencent.mm.j.a Rc = c.wR().Rc(str);
                        if (Rc != null && ((int) Rc.gTQ) > 0 && Rc.ty()) {
                            e.a(intent, str);
                        } else if (this.vCd.vBI) {
                            ag.a.hlS.a(str, "", new ag.b.a(this) {
                                final /* synthetic */ cx vFN;

                                {
                                    this.vFN = r1;
                                }

                                public final void p(String str, boolean z) {
                                }
                            });
                        }
                        if (o.dH(this.vCd.fOK.getUsername())) {
                            ap.yY();
                            q fW = c.xa().fW(this.vCd.fOK.getUsername());
                            intent.putExtra("Contact_RoomNickname", fW.eK(str));
                            intent.putExtra("Contact_Scene", 14);
                            intent.putExtra("Contact_ChatRoomId", this.vCd.fOK.getUsername());
                            intent.putExtra("room_name", this.vCd.fOK.getUsername());
                            intent.putExtra("Is_RoomOwner", fW.field_roomowner == null ? false : fW.field_roomowner.equals(m.xL()));
                        }
                        if (dtVar.fTk != null) {
                            switch (dtVar.fTk.getType()) {
                                case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                                case com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX /*57*/:
                                    intent.putExtra("Contact_Scene", 34);
                                    intent.putExtra("Contact_IsLBSFriend", true);
                                    break;
                            }
                        }
                        d.b(this.vCd.aYD(), "profile", ".ui.ContactInfoUI", intent, com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX);
                        return;
                    }
                }
                return;
            case 6:
                w.d("MicroMsg.ChattingListClickListener", "edw timestamp, onClick = " + System.currentTimeMillis());
                if (!s.a(dtVar.fZF, this.vCd.aYD(), null, this.vCd.bUg())) {
                    str2 = dtVar.userName;
                    str3 = dtVar.vMY;
                    if (str2 != null && !str2.equals("")) {
                        intent3 = new Intent();
                        intent3.putExtra("rawUrl", str2);
                        intent3.putExtra("shortUrl", str2);
                        intent3.putExtra("webpageTitle", str3);
                        Bundle bundle = new Bundle();
                        au auVar = dtVar.fTk;
                        if (auVar != null) {
                            if (auVar.bMf()) {
                                Map q = bh.q(auVar.pM(), "msg");
                                if (q != null) {
                                    dk ai = dk.ai(q);
                                    if (!u.mA(ai.hir)) {
                                        intent3.putExtra("KTemplateId", ai.hir);
                                        w.d("MicroMsg.ChattingListClickListener", "report template msg click action, templateId(%s). srcUsername(%s)", ai.hir, dtVar.fUR);
                                        g.oUh.i(11608, ai.hir, dtVar.fUR, Integer.valueOf(0));
                                    }
                                }
                            }
                            ap.yY();
                            x Rc2 = c.wR().Rc(auVar.pL());
                            if (Rc2 != null && Rc2.bLe()) {
                                i = 4;
                                w.d("MicroMsg.ChattingListClickListener", "hakon click biz msg %s", Rc2.getUsername());
                            }
                            intent3.putExtra("msg_id", auVar.pH());
                            intent3.putExtra("KPublisherId", "msg_" + Long.toString(auVar.pI()));
                            intent3.putExtra("pre_username", auVar.pL());
                            intent3.putExtra("prePublishId", "msg_" + Long.toString(auVar.pI()));
                            intent3.putExtra("preUsername", ah.a(auVar, dtVar.vxp, this.vCd.sMK));
                            intent3.putExtra("preChatName", this.vCd.bUg());
                            intent3.putExtra("preChatTYPE", p.G(ah.a(auVar, dtVar.vxp, this.vCd.sMK), this.vCd.bUg()));
                            intent3.putExtra("preMsgIndex", dtVar.rXJ);
                            Bundle bundle2 = dtVar.vNe;
                            if (bundle2 != null) {
                                intent3.putExtras(bundle2);
                            }
                        }
                        bundle.putInt("snsWebSource", i);
                        intent3.putExtra("jsapiargs", bundle);
                        intent3.putExtra("geta8key_username", this.vCd.bUg());
                        if (!u.mA(dtVar.fUR)) {
                            intent3.putExtra("srcUsername", dtVar.fUR);
                            intent3.putExtra("srcDisplayname", dtVar.fUS);
                            intent3.putExtra("mode", 1);
                        }
                        intent3.putExtra("message_id", dtVar.rXI);
                        intent3.putExtra("message_index", dtVar.rXJ);
                        intent3.putExtra("from_scence", 1);
                        d.b(this.vCd.aYD(), "webview", ".ui.tools.WebViewUI", intent3);
                        if (!u.mA(this.vCd.bUg())) {
                            ap.yY();
                            if (c.wR().Rc(this.vCd.bUg()).gkJ == 1) {
                                ap.yY();
                                c.wW().Rq(this.vCd.bUg());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 7:
                intent2 = new Intent();
                intent2.putExtra("geta8key_username", this.vCd.bUg());
                intent2.putExtra("rawUrl", dtVar.gxD);
                d.b(this.vCd.aYD(), "webview", ".ui.tools.WebViewUI", intent2);
                return;
            case 8:
                if (dtVar.fTk != null) {
                    Object obj = dtVar.fGa;
                    if (TextUtils.isEmpty(obj)) {
                        obj = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().uh(dtVar.gxD);
                    }
                    if (TextUtils.isEmpty(obj)) {
                        intent2 = new Intent();
                        intent2.putExtra("geta8key_username", this.vCd.bUg());
                        intent2.putExtra("rawUrl", dtVar.gxD);
                        d.b(this.vCd.aYD(), "webview", ".ui.tools.WebViewUI", intent2);
                        return;
                    }
                    intent = new Intent();
                    intent.putExtra("extra_id", obj);
                    intent.putExtra("extra_name", dtVar.title);
                    if (dtVar.vMZ) {
                        intent.putExtra("download_entrance_scene", 20);
                        intent.putExtra("preceding_scence", 3);
                        intent.putExtra("reward_tip", true);
                        g.oUh.i(12953, Integer.valueOf(1), obj);
                    } else if (dtVar.vNa) {
                        intent.putExtra("download_entrance_scene", 25);
                        intent.putExtra("preceding_scence", 9);
                        intent.putExtra("reward_tip", true);
                    } else {
                        intent.putExtra("download_entrance_scene", 22);
                        intent.putExtra("preceding_scence", 122);
                        g.oUh.i(10993, Integer.valueOf(2), obj);
                    }
                    d.b(this.vCd.aYD(), "emoji", ".ui.EmojiStoreDetailUI", intent);
                    return;
                }
                return;
            case 10:
                if (dtVar.fTk != null) {
                    i = dtVar.designerUIN;
                    str2 = dtVar.designerName;
                    str3 = dtVar.designerRediretctUrl;
                    if (i != 0) {
                        intent3 = new Intent();
                        intent3.putExtra("geta8key_username", this.vCd.bUg());
                        intent3.putExtra("rawUrl", dtVar.gxD);
                        intent3.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, i);
                        intent3.putExtra("name", str2);
                        intent3.putExtra("rediret_url", str3);
                        intent3.putExtra("extra_scence", 22);
                        d.b(this.vCd.aYD(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent3);
                        return;
                    }
                    return;
                }
                return;
            case 11:
                com.tencent.mm.ui.base.g.a(this.vCd.aYD(), this.vCd.getString(R.l.ecq), "", this.vCd.getString(R.l.ecs), this.vCd.getString(R.l.ecp), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ cx vFN;

                    {
                        this.vFN = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b clVar = new cl();
                        clVar.fFT.fFU = true;
                        com.tencent.mm.sdk.b.a.urY.m(clVar);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ cx vFN;

                    {
                        this.vFN = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b clVar = new cl();
                        clVar.fFT.fFU = false;
                        com.tencent.mm.sdk.b.a.urY.m(clVar);
                    }
                });
                return;
            case 12:
                if (dtVar.fTk != null) {
                    i = dtVar.tid;
                    str2 = dtVar.hjB;
                    str3 = dtVar.desc;
                    str4 = dtVar.iconUrl;
                    str5 = dtVar.secondUrl;
                    if (i != 0) {
                        Intent intent5 = new Intent();
                        intent5.putExtra("geta8key_username", this.vCd.bUg());
                        intent5.putExtra("rawUrl", dtVar.gxD);
                        intent5.putExtra("topic_id", i);
                        intent5.putExtra("topic_name", str2);
                        intent5.putExtra("topic_desc", str3);
                        intent5.putExtra("topic_icon_url", str4);
                        intent5.putExtra("topic_ad_url", str5);
                        intent5.putExtra("extra_scence", 22);
                        d.b(this.vCd.aYD(), "emoji", ".ui.EmojiStoreTopicUI", intent5);
                        return;
                    }
                    w.i("MicroMsg.ChattingListClickListener", "topic id is zero.");
                    return;
                }
                return;
            case 13:
                if (dtVar.fTk != null) {
                    i = dtVar.tid;
                    str2 = dtVar.hjB;
                    str3 = dtVar.desc;
                    str4 = dtVar.iconUrl;
                    str5 = dtVar.secondUrl;
                    int i2 = dtVar.pageType;
                    if (i != 0) {
                        intent4 = new Intent();
                        intent4.putExtra("geta8key_username", this.vCd.bUg());
                        intent4.putExtra("rawUrl", dtVar.gxD);
                        intent4.putExtra("set_id", i);
                        intent4.putExtra("set_title", str2);
                        intent4.putExtra("set_iconURL", str4);
                        intent4.putExtra("set_desc", str3);
                        intent4.putExtra("headurl", str5);
                        intent4.putExtra("pageType", i2);
                        d.b(this.vCd.aYD(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent4);
                        return;
                    }
                    w.i("MicroMsg.ChattingListClickListener", "topic id is zero.");
                    return;
                }
                return;
            default:
                au auVar2 = dtVar.fTk;
                if (auVar2 != null) {
                    ah ai2 = this.vCd.vBD.ai(auVar2.getType(), auVar2.pJ() == 1);
                    if (ai2 == null || !ai2.a(view, this.vCd, auVar2)) {
                        if (dtVar.knu == 5 && auVar2.pJ() == 1) {
                            final ce ceVar = dtVar.fTk;
                            if (ceVar == null || ceVar.gxE != 80) {
                                com.tencent.mm.ui.base.g.a(this.vCd.aYD(), this.vCd.getString(R.l.dVl), "", this.vCd.getString(R.l.dIv), this.vCd.getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ cx vFN;

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        ceVar.bMu();
                                        ap.yY();
                                        c.wT().a(ceVar.field_msgId, ceVar);
                                        if (ceVar.bLZ()) {
                                            this.vFN.vCd.az(ceVar);
                                        } else if (ceVar.bMh()) {
                                            this.vFN.vCd.aA(ceVar);
                                        } else if (ceVar.bMn()) {
                                            this.vFN.vCd.aB(ceVar);
                                        } else if (ceVar.bMk()) {
                                            this.vFN.vCd.aC(ceVar);
                                        } else if (ceVar.bMj()) {
                                            this.vFN.vCd.aF(ceVar);
                                        } else if (ceVar.bMo()) {
                                            this.vFN.vCd.aE(ceVar);
                                        } else if (ceVar.bMi()) {
                                            this.vFN.vCd.aD(ceVar);
                                        } else {
                                            w.e("MicroMsg.ChattingListClickListener", "uknown msg type");
                                        }
                                    }
                                }, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ cx vFN;

                                    {
                                        this.vFN = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                return;
                            }
                            w.w("MicroMsg.ChattingListClickListener", "[dealClickStateBtn] %s", ceVar.pN());
                            com.tencent.mm.ui.base.g.z(this.vCd.aYD(), this.vCd.aYD().getString(R.l.enX), this.vCd.aYD().getString(R.l.cII));
                            return;
                        }
                        w.i("MicroMsg.ChattingListClickListener", "CreateTime:" + auVar2.pK());
                        if (auVar2.bLZ()) {
                            com.tencent.mm.modelstat.b.hUp.v(dtVar.fTk);
                            if (y.aJ(this.vCd.aYD()) || com.tencent.mm.al.a.aH(this.vCd.aYD())) {
                                w.d("MicroMsg.ChattingListClickListener", "voip is running, not play voice");
                                return;
                            }
                            ap.yY();
                            if (!c.isSDCardAvailable()) {
                                s.eP(this.vCd.aYD());
                                return;
                            } else if (dtVar != null && dtVar.fTk != null) {
                                n nVar = new n(dtVar.fTk.pM());
                                if (u.mA(dtVar.fTk.pM()) || nVar.time == 0) {
                                    Toast.makeText(this.vCd.aYD(), R.l.dTo, 0).show();
                                    return;
                                } else if (this.vCd.vBD != null && this.vCd.vBD.vES != null) {
                                    this.vCd.vBD.vES.a(dtVar.position, dtVar.fTk);
                                    if (dtVar.fTk.bMA()) {
                                        g.oUh.i(14220, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                                        return;
                                    }
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if ((auVar2.getType() == 35 ? 1 : null) != null) {
                            ap.yY();
                            au.c At = c.wT().At(dtVar.fTk.pM());
                            if (u.mz(At.ozl).length() > 0) {
                                d.b(this.vCd.aYD(), "qqmail", ".ui.ReadMailUI", new Intent().putExtra("msgid", dtVar.fTk.pH()));
                                return;
                            } else if (u.mz(At.bMK()).length() > 0) {
                                d.b(this.vCd.aYD(), "webview", ".ui.tools.WebViewUI", new Intent("android.intent.action.VIEW", Uri.parse(At.bMK())));
                                return;
                            } else {
                                return;
                            }
                        } else if (auVar2.bMh()) {
                            com.tencent.mm.ah.d dVar;
                            Map q2;
                            com.tencent.mm.ah.d a;
                            com.tencent.mm.modelstat.b.hUp.v(dtVar.fTk);
                            r1 = dtVar.fTk;
                            com.tencent.mm.modelstat.a.a(r1, com.tencent.mm.modelstat.a.a.Click);
                            int[] iArr = new int[2];
                            int i3 = 0;
                            int i4 = 0;
                            if (view != null) {
                                view.getLocationInWindow(iArr);
                                i3 = view.getWidth();
                                i4 = view.getHeight();
                            }
                            if (r1.pJ() == 1) {
                                com.tencent.mm.ah.d aj = com.tencent.mm.ah.n.GS().aj(r1.pH());
                                if (aj.Gy() != 0) {
                                    dVar = aj;
                                    q2 = bh.q(r1.pM(), "msg");
                                    if (q2 != null) {
                                        Long.valueOf(u.ap((String) q2.get(".msg.img.$hdlength"), "0")).longValue();
                                    }
                                    ap.yY();
                                    if (!c.isSDCardAvailable()) {
                                        s.eP(this.vCd.aYD());
                                        return;
                                    } else if (r1.pJ() == 1) {
                                        if (com.tencent.mm.a.e.aO(com.tencent.mm.ah.n.GS().m(com.tencent.mm.ah.e.c(dVar), "", ""))) {
                                            if (com.tencent.mm.a.e.aO(com.tencent.mm.ah.n.GS().m(dVar.Gz(), "", ""))) {
                                                a(r1.pH(), r1.pI(), dtVar.userName, dtVar.chatroomName, iArr, i3, i4);
                                                return;
                                            } else {
                                                a(r1, dVar.Gx(), dVar.pI(), dtVar.userName, dtVar.chatroomName, iArr, i3, i4, false);
                                                return;
                                            }
                                        }
                                        a(r1, dVar.Gx(), dVar.pI(), dtVar.userName, dtVar.chatroomName, iArr, i3, i4, false);
                                        return;
                                    } else if (dVar.GA()) {
                                        if (dVar.status == -1) {
                                            w.i("MicroMsg.ChattingListClickListener", "retry downloadImg, %d", Long.valueOf(dVar.Gy()));
                                            dVar.dv(0);
                                            dVar.fRW = 256;
                                            com.tencent.mm.ah.n.GS().a(Long.valueOf(dVar.Gy()), dVar);
                                        }
                                        a(r1.pH(), r1.pI(), dtVar.userName, dtVar.chatroomName, iArr, i3, i4);
                                        return;
                                    } else {
                                        str2 = dVar.Gz();
                                        if (dVar.GB()) {
                                            a = com.tencent.mm.ah.e.a(dVar);
                                            if (a != null && a.Gy() > 0 && a.GA() && com.tencent.mm.a.e.aO(com.tencent.mm.ah.n.GS().m(a.Gz(), "", ""))) {
                                                str2 = a.Gz();
                                            }
                                        }
                                        com.tencent.mm.ah.n.GS().m(str2, "", "");
                                        a(r1, dVar.Gx(), dVar.pI(), dtVar.userName, dtVar.chatroomName, iArr, i3, i4, false);
                                        return;
                                    }
                                }
                            }
                            dVar = com.tencent.mm.ah.n.GS().ai(r1.pI());
                            q2 = bh.q(r1.pM(), "msg");
                            if (q2 != null) {
                                Long.valueOf(u.ap((String) q2.get(".msg.img.$hdlength"), "0")).longValue();
                            }
                            ap.yY();
                            if (!c.isSDCardAvailable()) {
                                s.eP(this.vCd.aYD());
                                return;
                            } else if (r1.pJ() == 1) {
                                if (com.tencent.mm.a.e.aO(com.tencent.mm.ah.n.GS().m(com.tencent.mm.ah.e.c(dVar), "", ""))) {
                                    if (com.tencent.mm.a.e.aO(com.tencent.mm.ah.n.GS().m(dVar.Gz(), "", ""))) {
                                        a(r1.pH(), r1.pI(), dtVar.userName, dtVar.chatroomName, iArr, i3, i4);
                                        return;
                                    } else {
                                        a(r1, dVar.Gx(), dVar.pI(), dtVar.userName, dtVar.chatroomName, iArr, i3, i4, false);
                                        return;
                                    }
                                }
                                a(r1, dVar.Gx(), dVar.pI(), dtVar.userName, dtVar.chatroomName, iArr, i3, i4, false);
                                return;
                            } else if (dVar.GA()) {
                                if (dVar.status == -1) {
                                    w.i("MicroMsg.ChattingListClickListener", "retry downloadImg, %d", Long.valueOf(dVar.Gy()));
                                    dVar.dv(0);
                                    dVar.fRW = 256;
                                    com.tencent.mm.ah.n.GS().a(Long.valueOf(dVar.Gy()), dVar);
                                }
                                a(r1.pH(), r1.pI(), dtVar.userName, dtVar.chatroomName, iArr, i3, i4);
                                return;
                            } else {
                                str2 = dVar.Gz();
                                if (dVar.GB()) {
                                    a = com.tencent.mm.ah.e.a(dVar);
                                    str2 = a.Gz();
                                    break;
                                }
                                com.tencent.mm.ah.n.GS().m(str2, "", "");
                                a(r1, dVar.Gx(), dVar.pI(), dtVar.userName, dtVar.chatroomName, iArr, i3, i4, false);
                                return;
                            }
                        } else if (auVar2.bMi()) {
                            str3 = dtVar.userName;
                            str = auVar2.pM();
                            r0 = (!dtVar.vxp || (auVar2.pJ() == 0 ? 1 : null) == null) ? str : ay.gj(str);
                            ap.yY();
                            au.a Av = c.wT().Av(r0);
                            if (Av != null) {
                                intent2 = new Intent();
                                intent2.putExtra("Contact_User", Av.bME());
                                intent2.putExtra("Contact_Alias", Av.gtR);
                                intent2.putExtra("Contact_Nick", Av.fFa);
                                intent2.putExtra("Contact_QuanPin", Av.hCf);
                                intent2.putExtra("Contact_PyInitial", Av.hCe);
                                intent2.putExtra("Contact_Uin", Av.bMG());
                                intent2.putExtra("Contact_Mobile_MD5", Av.bMF());
                                intent2.putExtra("Contact_full_Mobile_MD5", Av.bMI());
                                intent2.putExtra("Contact_QQNick", Av.bMH());
                                intent2.putExtra("User_From_Fmessage", false);
                                intent2.putExtra("Contact_Scene", Av.bzE());
                                intent2.putExtra("Contact_FMessageCard", true);
                                intent2.putExtra("Contact_RemarkName", Av.hCj);
                                intent2.putExtra("Contact_VUser_Info_Flag", Av.bMJ());
                                intent2.putExtra("Contact_VUser_Info", Av.gkG);
                                intent2.putExtra("Contact_BrandIconURL", Av.osT);
                                intent2.putExtra("Contact_Province", Av.getProvince());
                                intent2.putExtra("Contact_City", Av.getCity());
                                intent2.putExtra("Contact_Sex", Av.gkr);
                                intent2.putExtra("Contact_Signature", Av.signature);
                                intent2.putExtra("Contact_ShowUserName", true);
                                intent2.putExtra("Contact_KSnsIFlag", 0);
                                intent2.putExtra("Contact_Source_FMessage", 17);
                                intent2.putExtra("source_from_user_name", str3);
                                intent2.putExtra("source_from_nick_name", com.tencent.mm.u.n.eJ(str3));
                                intent2.putExtra(com.tencent.mm.ui.d.a.uOx, Av.uKb);
                                if ((Av.bMJ() & 8) > 0) {
                                    if (!u.mA(str3)) {
                                        ap.yY();
                                        if (c.wR().Rc(str3).bLe()) {
                                            intent2.putExtra("Contact_Scene", 41);
                                            g.oUh.A(10298, Av.bME() + ",41");
                                        }
                                    }
                                    intent2.putExtra("Contact_Scene", 17);
                                    g.oUh.A(10298, Av.bME() + ",17");
                                }
                                d.b(this.vCd.aYD(), "profile", ".ui.ContactInfoUI", intent2);
                                com.tencent.mm.bc.a.xU(Av.bzE());
                                return;
                            }
                            return;
                        } else if (auVar2.getType() == 37) {
                            r0 = auVar2.pM();
                            w.w("MicroMsg.ChattingListClickListener", "dealClickVerifyMsgEvent : " + r0);
                            if (r0 != null && r0.length() > 0) {
                                ap.yY();
                                au.d Au = c.wT().Au(r0);
                                if (Au != null) {
                                    Assert.assertTrue(Au.bME().length() > 0);
                                    ap.yY();
                                    x Rc3 = c.wR().Rc(Au.bME());
                                    intent = new Intent();
                                    if (Rc3 == null || Rc3.tJ() <= 0 || !Rc3.ty()) {
                                        intent.putExtra("Verify_ticket", Au.osP);
                                        intent.putExtra("User_Verify", true);
                                        intent.putExtra("Contact_User", Au.bME());
                                        intent.putExtra("Contact_Alias", Au.gtR);
                                        intent.putExtra("Contact_Nick", Au.fFa);
                                        intent.putExtra("Contact_QuanPin", Au.hCf);
                                        intent.putExtra("Contact_PyInitial", Au.hCe);
                                        intent.putExtra("Contact_Sex", Au.gkr);
                                        intent.putExtra("Contact_Signature", Au.signature);
                                        intent.putExtra("Contact_Scene", Au.bzE());
                                        intent.putExtra("Contact_FMessageCard", true);
                                        intent.putExtra("Contact_City", Au.getCity());
                                        intent.putExtra("Contact_Province", Au.getProvince());
                                        intent.putExtra("Contact_Mobile_MD5", Au.bMF());
                                        intent.putExtra("Contact_full_Mobile_MD5", Au.uJY);
                                        intent.putExtra("Contact_KSnsIFlag", Au.bML());
                                        intent.putExtra("Contact_KSnsBgUrl", Au.bMM());
                                    } else {
                                        intent.putExtra("Contact_User", Rc3.getUsername());
                                        e.a(intent, Rc3.getUsername());
                                    }
                                    r0 = Au.content;
                                    if (u.mz(r0).length() <= 0) {
                                        switch (Au.bzE()) {
                                            case 18:
                                            case 22:
                                            case 23:
                                            case 24:
                                            case 25:
                                            case 26:
                                            case 27:
                                            case 28:
                                            case JsApiChooseImage.CTRL_INDEX /*29*/:
                                                r0 = this.vCd.getString(R.l.dTI);
                                                break;
                                            default:
                                                r0 = this.vCd.getString(R.l.dTE);
                                                break;
                                        }
                                    }
                                    intent.putExtra("Contact_Content", r0);
                                    intent.putExtra("Contact_verify_Scene", Au.bzE());
                                    intent.putExtra("Contact_Uin", Au.ovb);
                                    intent.putExtra("Contact_QQNick", Au.hCg);
                                    intent.putExtra("Contact_Mobile_MD5", Au.bMF());
                                    intent.putExtra("User_From_Fmessage", true);
                                    intent.putExtra("Contact_from_msgType", 37);
                                    intent.putExtra("Contact_KSnsIFlag", Au.bML());
                                    intent.putExtra("Contact_KSnsBgUrl", Au.bMM());
                                    d.b(this.vCd.aYD(), "profile", ".ui.ContactInfoUI", intent);
                                    com.tencent.mm.bc.a.xU(Au.bzE());
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (auVar2.getType() == 40) {
                            r0 = auVar2.pM();
                            ap.yY();
                            au.a Av2 = c.wT().Av(r0);
                            if (Av2 != null && Av2.bME().length() > 0) {
                                com.tencent.mm.bc.a.xU(Av2.bzE());
                                ap.yY();
                                x Rc4 = c.wR().Rc(Av2.bME());
                                if (Rc4 != null && Rc4.tJ() > 0 && Rc4.ty()) {
                                    e.a(this.vCd.aYD(), Rc4, Av2);
                                    return;
                                } else if (Av2.bMG() > 0 || (u.mA(Av2.bMF()) && u.mA(Av2.bMI()))) {
                                    e.a(this.vCd.aYD(), Av2);
                                    return;
                                } else {
                                    com.tencent.mm.modelfriend.b ja = af.FY().ja(Av2.bMF());
                                    if (ja == null || ja.EP() == null || ja.EP().length() <= 0) {
                                        ja = af.FY().ja(Av2.bMI());
                                        if (ja == null || ja.EP() == null || ja.EP().length() <= 0) {
                                            if (Rc4 == null || Rc4.tJ() <= 0) {
                                                e.a(this.vCd.aYD(), Av2);
                                            } else {
                                                e.a(this.vCd.aYD(), Rc4, Av2);
                                            }
                                            w.e("MicroMsg.ChattingListClickListener", "error : this is not the mobile contact, MD5 = " + Av2.bMF() + " fullMD5:" + Av2.bMI());
                                            return;
                                        }
                                    }
                                    if (ja.getUsername() == null || ja.getUsername().length() <= 0) {
                                        ja.username = Av2.bME();
                                        ja.fRW = FileUtils.S_IWUSR;
                                        if (af.FY().a(ja.EP(), ja) == -1) {
                                            w.e("MicroMsg.ChattingListClickListener", "update mobile contact username failed");
                                            return;
                                        }
                                    }
                                    e.a(this.vCd.aYD(), Av2);
                                    return;
                                }
                            }
                            return;
                        } else if (auVar2.bMl() || auVar2.bMm()) {
                            com.tencent.mm.modelstat.b.hUp.v(dtVar.fTk);
                            com.tencent.mm.modelstat.a.a(dtVar.fTk, com.tencent.mm.modelstat.a.a.Click);
                            if (2 != dtVar.knu) {
                                r1 = dtVar.fTk;
                                if (r1.pJ() == 0) {
                                    auVar2 = dtVar.fTk;
                                    r lH = t.lH(auVar2.pN());
                                    w.i("MicroMsg.ChattingListClickListener", "videoReceiverEvent video status:" + lH.getStatus() + " is sender:" + auVar2.pJ());
                                    switch (dtVar.knu) {
                                        case 3:
                                            h(lH);
                                            break;
                                        case 4:
                                            ap.yY();
                                            if (!c.isSDCardAvailable()) {
                                                s.eP(this.vCd.aYD());
                                                break;
                                            } else {
                                                t.lE(auVar2.pN());
                                                break;
                                            }
                                    }
                                }
                                if (r1.pJ() == 1) {
                                    r1 = dtVar.fTk;
                                    r ls = com.tencent.mm.modelvideo.o.KV().ls(r1.pN());
                                    int status = ls.getStatus();
                                    w.i("MicroMsg.ChattingListClickListener", " videoSendEvent status : " + status);
                                    switch (dtVar.knu) {
                                        case 3:
                                            ap.yY();
                                            if (!c.isSDCardAvailable()) {
                                                s.eP(this.vCd.aYD());
                                                return;
                                            } else if (status == 113) {
                                                w.i("MicroMsg.ChattingListClickListener", "this video come from pc weixin, user restart now.");
                                                h(ls);
                                                return;
                                            } else if (ls.Li()) {
                                                w.e("MicroMsg.ChattingListClickListener", "this video come from gallery, but it is illegal.");
                                                r0 = this.vCd.aYD().getString(R.l.faf);
                                                if (status == 142) {
                                                    r0 = this.vCd.aYD().getString(R.l.faf);
                                                } else if (status == k.CTRL_INDEX) {
                                                    r0 = this.vCd.aYD().getString(R.l.fag);
                                                } else if (status == com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX) {
                                                    r0 = this.vCd.aYD().getString(R.l.fae);
                                                }
                                                com.tencent.mm.ui.base.g.z(this.vCd.aYD(), r0, this.vCd.aYD().getString(R.l.cII));
                                                return;
                                            } else {
                                                r1.bMu();
                                                ap.yY();
                                                c.wT().a(r1.pH(), r1);
                                                if (ls.getStatus() == 198) {
                                                    t.lG(r1.pN());
                                                    return;
                                                } else {
                                                    t.lC(r1.pN());
                                                    return;
                                                }
                                            }
                                        case 4:
                                            ap.yY();
                                            if (!c.isSDCardAvailable()) {
                                                s.eP(this.vCd.aYD());
                                                return;
                                            } else if (status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                                                w.i("MicroMsg.ChattingListClickListener", "this video come from pc weixin, user pause recv now.");
                                                t.lE(r1.pN());
                                                return;
                                            } else {
                                                r0 = r1.pN();
                                                ls = t.lH(r0);
                                                if (ls == null) {
                                                    w.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " getinfo failed: " + r0);
                                                    com.tencent.mm.compatible.util.g.sb();
                                                } else if (ls.getStatus() == 104 || ls.getStatus() == 103) {
                                                    ls.status = MMGIFException.D_GIF_ERR_NO_IMAG_DSCR;
                                                    ls.at(bg.Ny());
                                                    ls.gO(1280);
                                                    if (!t.e(ls)) {
                                                        w.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " update failed: " + r0);
                                                        com.tencent.mm.compatible.util.g.sb();
                                                    }
                                                } else {
                                                    w.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " get status failed: " + r0 + " status:" + ls.getStatus());
                                                    com.tencent.mm.compatible.util.g.sb();
                                                }
                                                w.d("MicroMsg.ChattingListClickListener", "pause video, publish SendMsgFailEvent");
                                                b nwVar = new nw();
                                                nwVar.fVc.fCZ = r1;
                                                com.tencent.mm.sdk.b.a.urY.m(nwVar);
                                                return;
                                            }
                                        default:
                                            return;
                                    }
                                }
                                return;
                            } else if (y.aJ(this.vCd.aYD()) || com.tencent.mm.al.a.aH(this.vCd.aYD())) {
                                w.i("MicroMsg.ChattingListClickListener", "Voip or multitalk is running, can't do this");
                                return;
                            } else {
                                Bundle bundle3;
                                au auVar3 = dtVar.fTk;
                                int[] iArr2 = new int[2];
                                int i5 = 0;
                                i = 0;
                                if (view != null) {
                                    view.getLocationInWindow(iArr2);
                                    i5 = view.getWidth();
                                    i = view.getHeight();
                                }
                                long pH = auVar3.pH();
                                long pI = auVar3.pI();
                                str3 = dtVar.userName;
                                str5 = dtVar.chatroomName;
                                intent4 = new Intent(this.vCd.aYD(), ImageGalleryUI.class);
                                intent4.putExtra("show_search_chat_content_result", this.vCd.vBy);
                                intent4.putExtra("img_gallery_msg_id", pH);
                                intent4.putExtra("key_is_biz_chat", this.vCd.sMK);
                                intent4.putExtra("key_biz_chat_id", this.vCd.bVQ());
                                intent4.putExtra("img_gallery_msg_svr_id", pI);
                                intent4.putExtra("img_gallery_talker", str3);
                                intent4.putExtra("img_gallery_chatroom_name", str5);
                                intent4.putExtra("img_gallery_left", iArr2[0]);
                                intent4.putExtra("img_gallery_top", iArr2[1]);
                                intent4.putExtra("img_gallery_width", i5);
                                intent4.putExtra("img_gallery_height", i);
                                intent4.putExtra("img_gallery_enter_from_chatting_ui", this.vCd.vJn);
                                String bUg = this.vCd.bUg();
                                str = auVar3.pJ() == 1 ? this.vCd.vBD.hrM : str3;
                                Bundle bundle4 = new Bundle();
                                if (this.vCd.vBH) {
                                    str3 = "stat_scene";
                                    i5 = 2;
                                    bundle3 = bundle4;
                                } else {
                                    str3 = "stat_scene";
                                    if (o.eV(bUg)) {
                                        i5 = 7;
                                        bundle3 = bundle4;
                                    } else {
                                        i5 = 1;
                                        bundle3 = bundle4;
                                    }
                                }
                                bundle3.putInt(str3, i5);
                                bundle4.putString("stat_msg_id", "msg_" + Long.toString(pI));
                                bundle4.putString("stat_chat_talker_username", bUg);
                                bundle4.putString("stat_send_msg_user", str);
                                intent4.putExtra("_stat_obj", bundle4);
                                this.vCd.startActivity(intent4);
                                this.vCd.overridePendingTransition(0, 0);
                                if (auVar3.bMm() && dtVar.userName != null) {
                                    a.a(a.a.EnterFullScreen, auVar3);
                                    if (dtVar.userName.toLowerCase().endsWith("@chatroom")) {
                                        g.oUh.i(11444, Integer.valueOf(2));
                                        return;
                                    } else {
                                        g.oUh.i(11444, Integer.valueOf(1));
                                        return;
                                    }
                                }
                                return;
                            }
                        } else if (auVar2.bMn()) {
                            b(dtVar);
                            return;
                        } else if (auVar2.getType() == 48) {
                            f(dtVar);
                            return;
                        } else if (auVar2.bMd()) {
                            str = auVar2.pM();
                            b rrVar = new rr();
                            rrVar.fYI.fJK = 1;
                            rrVar.fYI.content = str;
                            com.tencent.mm.sdk.b.a.urY.m(rrVar);
                            if ((rrVar.fYJ.type == 2 ? 1 : null) != null || auVar2.pM().equals(au.uJR)) {
                                c(dtVar);
                                return;
                            }
                            str = auVar2.pM();
                            rrVar = new rr();
                            rrVar.fYI.fJK = 1;
                            rrVar.fYI.content = str;
                            com.tencent.mm.sdk.b.a.urY.m(rrVar);
                            if ((rrVar.fYJ.type == 3 ? 1 : null) != null || auVar2.pM().equals(au.uJQ)) {
                                e(dtVar);
                                return;
                            }
                            return;
                        } else if (auVar2.bMo()) {
                            ap.yY();
                            if (c.isSDCardAvailable()) {
                                ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(this.vCd.aYD(), dtVar.fTk);
                                g.oUh.i(11592, Integer.valueOf(0));
                                return;
                            }
                            return;
                        } else if (auVar2.bMc()) {
                            if (this.vCd != null) {
                                g.oUh.A(10221, "1");
                                Intent intent6 = new Intent();
                                intent6.addFlags(67108864);
                                d.b(this.vCd.aYD(), "shake", ".ui.ShakeReportUI", intent6);
                                return;
                            }
                            return;
                        } else if (auVar2.bMq()) {
                            a(dtVar);
                            return;
                        } else if (auVar2.bMk()) {
                            a(view, dtVar);
                            return;
                        } else {
                            w.e("MicroMsg.ChattingListClickListener", "uknown msg type");
                            return;
                        }
                    } else if (auVar2.axO()) {
                        com.tencent.mm.modelstat.b.hUp.e(auVar2, com.tencent.mm.t.g.g(auVar2));
                        return;
                    } else {
                        return;
                    }
                }
                return;
        }
    }

    private void a(dt dtVar) {
        ap.yY();
        if (c.isSDCardAvailable()) {
            this.vCd.vBD.vES.b(dtVar.position, dtVar.fTk);
        } else {
            s.eP(this.vCd.uSU.uTo);
        }
    }

    private static void a(View view, dt dtVar) {
        if (view instanceof MMTextView) {
            MMTextView mMTextView = (MMTextView) view;
            com.tencent.mm.ui.chatting.d.a.a.bXE();
            com.tencent.mm.ui.chatting.d.a.a.a(mMTextView.getText(), dtVar.fTk);
        }
    }

    private void h(final r rVar) {
        ap.yY();
        if (!c.isSDCardAvailable()) {
            s.eP(this.vCd.uSU.uTo);
        } else if (rVar.status == 198) {
            t.lF(rVar.getFileName());
        } else if (aa.bn(this.vCd.uSU.uTo) || a.vFM) {
            u((long) rVar.iaq, rVar.getFileName());
        } else {
            a.vFM = true;
            com.tencent.mm.ui.base.g.a(this.vCd.uSU.uTo, R.l.fah, R.l.dIO, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ cx vFN;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.vFN.u((long) rVar.iaq, rVar.getFileName());
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ cx vFN;

                {
                    this.vFN = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    public final void u(long j, String str) {
        this.vCd.eI(j);
        t.lD(str);
    }

    private void b(dt dtVar) {
        ap.yY();
        if (c.isSDCardAvailable()) {
            com.tencent.mm.storage.a.c ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(dtVar.fTk.field_imgPath);
            if (ub != null && !ub.bCU()) {
                Intent intent = new Intent();
                intent.putExtra("custom_smiley_preview_md5", dtVar.fTk.field_imgPath);
                intent.putExtra("custom_to_talker_name", dtVar.fTk.field_talker);
                if (!(ub.field_catalog == com.tencent.mm.storage.a.a.uKS || ub.field_catalog == com.tencent.mm.storage.a.a.uKR || ub.field_catalog == com.tencent.mm.storage.a.a.uKQ)) {
                    intent.putExtra("custom_smiley_preview_productid", ub.field_groupId);
                }
                intent.putExtra("msg_id", dtVar.fTk.field_msgSvrId);
                intent.putExtra("msg_content", dtVar.fTk.field_content);
                String str = dtVar.fTk.field_talker;
                if (o.dH(str)) {
                    str = ay.gi(dtVar.fTk.field_content);
                }
                intent.putExtra("msg_sender", str);
                d.b(this.vCd.uSU.uTo, "emoji", ".ui.CustomSmileyPreviewUI", intent);
                g.oUh.i(11592, Integer.valueOf(0));
            }
        }
    }

    private void c(final dt dtVar) {
        if (!com.tencent.mm.n.a.aH(this.vCd.uSU.uTo)) {
            b rqVar = new rq();
            com.tencent.mm.sdk.b.a.urY.m(rqVar);
            if (dtVar.fTk.field_talker.equals(rqVar.fYE.fJL) || !(rqVar.fYE.fYG || rqVar.fYE.fYH)) {
                rqVar = new qk();
                rqVar.fXu.fXw = true;
                com.tencent.mm.sdk.b.a.urY.m(rqVar);
                String str = rqVar.fXv.fXy;
                if (u.mA(str)) {
                    d(dtVar);
                    return;
                }
                w.v("MicroMsg.ChattingListClickListener", "Talkroom is on: " + str);
                com.tencent.mm.ui.base.g.a(this.vCd.uSU.uTo, this.vCd.uSU.uTo.getString(R.l.eXz), "", this.vCd.uSU.uTo.getString(R.l.dHT), this.vCd.uSU.uTo.getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ cx vFN;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b qkVar = new qk();
                        qkVar.fXu.fXx = true;
                        com.tencent.mm.sdk.b.a.urY.m(qkVar);
                        this.vFN.d(dtVar);
                        dialogInterface.dismiss();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ cx vFN;

                    {
                        this.vFN = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return;
            }
            Toast.makeText(this.vCd.uSU.uTo, rqVar.fYE.fYF ? R.l.dPY : R.l.dPZ, 0).show();
            w.i("MicroMsg.ChattingListClickListener", "voip is running, can't do this");
        }
    }

    public final void d(dt dtVar) {
        int i = 3;
        dtVar.fTk.dv(6);
        ap.yY();
        c.wT().a(dtVar.fTk.field_msgId, dtVar.fTk);
        this.vCd.bVW();
        b rrVar = new rr();
        rrVar.fYI.fJK = 5;
        rrVar.fYI.fJL = dtVar.fTk.field_talker;
        rrVar.fYI.context = this.vCd.uSU.uTo;
        rrVar.fYI.fYD = 2;
        com.tencent.mm.sdk.b.a.urY.m(rrVar);
        g gVar = g.oUh;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(3);
        objArr[1] = Integer.valueOf(1);
        if (dtVar.fTk.gxF == null || dtVar.fTk.gxF.length() <= 0) {
            i = 1;
        }
        objArr[2] = Integer.valueOf(i);
        gVar.i(11033, objArr);
    }

    private void e(dt dtVar) {
        int i = 3;
        if (!com.tencent.mm.n.a.aH(this.vCd.uSU.uTo)) {
            b rqVar = new rq();
            com.tencent.mm.sdk.b.a.urY.m(rqVar);
            if (dtVar.fTk.field_talker.equals(rqVar.fYE.fJL) || !(rqVar.fYE.fYG || rqVar.fYE.fYH)) {
                dtVar.fTk.dv(6);
                ap.yY();
                c.wT().a(dtVar.fTk.field_msgId, dtVar.fTk);
                this.vCd.bVW();
                rqVar = new rr();
                rqVar.fYI.fJK = 5;
                rqVar.fYI.fJL = dtVar.fTk.field_talker;
                rqVar.fYI.context = this.vCd.uSU.uTo;
                rqVar.fYI.fYD = 4;
                com.tencent.mm.sdk.b.a.urY.m(rqVar);
                g gVar = g.oUh;
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(3);
                objArr[1] = Integer.valueOf(2);
                if (dtVar.fTk.gxF == null || dtVar.fTk.gxF.length() <= 0) {
                    i = 1;
                }
                objArr[2] = Integer.valueOf(i);
                gVar.i(11033, objArr);
                return;
            }
            Toast.makeText(this.vCd.uSU.uTo, rqVar.fYE.fYF ? R.l.dPY : R.l.dPZ, 0).show();
            w.i("MicroMsg.ChattingListClickListener", "voip is running, can't do this");
        }
    }

    private void f(dt dtVar) {
        String trim;
        au.b Aw;
        b ikVar;
        String str;
        Intent intent;
        ce ceVar = dtVar.fTk;
        String str2 = ceVar.field_content;
        boolean z = ceVar.field_isSend == 0;
        String str3 = "";
        if (z) {
            str3 = ceVar.field_talker;
        }
        if (o.dH(ceVar.field_talker) && z && !this.vCd.sMK) {
            int gh = ay.gh(str2);
            if (gh != -1) {
                str3 = str2.substring(0, gh).trim();
                trim = str2.substring(gh + 1).trim();
                ap.yY();
                Aw = c.wT().Aw(trim);
                if (!u.mA(str3) && o.dH(str3)) {
                    str3 = "";
                }
                ikVar = new ik();
                ikVar.fOe.fNZ = 1;
                ikVar.fOe.fCZ = ceVar;
                com.tencent.mm.sdk.b.a.urY.m(ikVar);
                str = ikVar.fOf.fOh;
                if ((u.mA(ikVar.fOf.fOi) || !u.mA(str)) && !"err_not_started".equals(str)) {
                    intent = new Intent();
                    intent.putExtra("kMsgId", ceVar.field_msgId);
                    intent.putExtra("map_view_type", 1);
                    intent.putExtra("kwebmap_slat", Aw.naO);
                    intent.putExtra("kwebmap_lng", Aw.naP);
                    intent.putExtra("kwebmap_scale", Aw.fOd);
                    intent.putExtra("kPoiName", Aw.ndv);
                    intent.putExtra("kisUsername", com.tencent.mm.u.n.eK(str3));
                    intent.putExtra("Kwebmap_locaion", str);
                    ap.yY();
                    intent.putExtra("kimg_path", c.xb());
                    intent.putExtra("map_talker_name", ceVar.field_talker);
                    intent.putExtra("view_type_key", 0);
                    intent.putExtra("kwebmap_from_to", true);
                    intent.putExtra("kPoi_url", Aw.sBQ);
                    intent.putExtra("soso_street_view_url", u.ap(ceVar.field_reserved, ""));
                    g.oUh.i(12809, Integer.valueOf(2), "");
                    d.a(this.vCd, "location", ".ui.RedirectUI", intent, (int) MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK);
                }
                w.e("MicroMsg.ChattingListClickListener", "location not valid or subcore not started");
                return;
            }
        }
        trim = str2;
        ap.yY();
        Aw = c.wT().Aw(trim);
        str3 = "";
        ikVar = new ik();
        ikVar.fOe.fNZ = 1;
        ikVar.fOe.fCZ = ceVar;
        com.tencent.mm.sdk.b.a.urY.m(ikVar);
        str = ikVar.fOf.fOh;
        if (u.mA(ikVar.fOf.fOi)) {
        }
        intent = new Intent();
        intent.putExtra("kMsgId", ceVar.field_msgId);
        intent.putExtra("map_view_type", 1);
        intent.putExtra("kwebmap_slat", Aw.naO);
        intent.putExtra("kwebmap_lng", Aw.naP);
        intent.putExtra("kwebmap_scale", Aw.fOd);
        intent.putExtra("kPoiName", Aw.ndv);
        intent.putExtra("kisUsername", com.tencent.mm.u.n.eK(str3));
        intent.putExtra("Kwebmap_locaion", str);
        ap.yY();
        intent.putExtra("kimg_path", c.xb());
        intent.putExtra("map_talker_name", ceVar.field_talker);
        intent.putExtra("view_type_key", 0);
        intent.putExtra("kwebmap_from_to", true);
        intent.putExtra("kPoi_url", Aw.sBQ);
        intent.putExtra("soso_street_view_url", u.ap(ceVar.field_reserved, ""));
        g.oUh.i(12809, Integer.valueOf(2), "");
        d.a(this.vCd, "location", ".ui.RedirectUI", intent, (int) MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK);
    }

    private void a(long j, long j2, String str, String str2, int[] iArr, int i, int i2) {
        String str3;
        int i3;
        Bundle bundle;
        Intent intent = new Intent(this.vCd.uSU.uTo, ImageGalleryUI.class);
        intent.putExtra("img_gallery_msg_id", j);
        intent.putExtra("show_search_chat_content_result", this.vCd.vBy);
        intent.putExtra("img_gallery_msg_svr_id", j2);
        intent.putExtra("key_is_biz_chat", this.vCd.sMK);
        intent.putExtra("key_biz_chat_id", this.vCd.bVQ());
        intent.putExtra("img_gallery_talker", str);
        intent.putExtra("img_gallery_chatroom_name", str2);
        intent.putExtra("img_gallery_left", iArr[0]);
        intent.putExtra("img_gallery_top", iArr[1]);
        intent.putExtra("img_gallery_width", i);
        intent.putExtra("img_gallery_height", i2);
        intent.putExtra("img_gallery_enter_from_chatting_ui", this.vCd.vJn);
        intent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", x.em(str));
        String bUg = this.vCd.bUg();
        Bundle bundle2 = new Bundle();
        if (this.vCd.vBH) {
            str3 = "stat_scene";
            i3 = 2;
            bundle = bundle2;
        } else {
            str3 = "stat_scene";
            if (o.eV(bUg)) {
                i3 = 7;
                bundle = bundle2;
            } else {
                i3 = 1;
                bundle = bundle2;
            }
        }
        bundle.putInt(str3, i3);
        bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
        bundle2.putString("stat_chat_talker_username", bUg);
        bundle2.putString("stat_send_msg_user", str);
        intent.putExtra("_stat_obj", bundle2);
        this.vCd.startActivity(intent);
        this.vCd.overridePendingTransition(0, 0);
    }

    public final void a(au auVar, long j, long j2, String str, String str2, int[] iArr, int i, int i2, boolean z) {
        String str3;
        int i3;
        Bundle bundle;
        Intent intent = new Intent(this.vCd.uSU.uTo, ImageGalleryUI.class);
        intent.putExtra("img_gallery_msg_id", j);
        intent.putExtra("img_gallery_msg_svr_id", j2);
        intent.putExtra("show_search_chat_content_result", this.vCd.vBy);
        intent.putExtra("key_is_biz_chat", this.vCd.sMK);
        intent.putExtra("key_biz_chat_id", this.vCd.bVQ());
        intent.putExtra("img_gallery_talker", str);
        intent.putExtra("img_gallery_chatroom_name", str2);
        intent.putExtra("img_gallery_left", iArr[0]);
        intent.putExtra("img_gallery_top", iArr[1]);
        intent.putExtra("img_gallery_width", i);
        intent.putExtra("img_gallery_height", i2);
        intent.putExtra("img_gallery_enter_from_chatting_ui", this.vCd.vJn);
        intent.putExtra("img_gallery_enter_PhotoEditUI", z);
        intent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", x.em(str));
        String bUg = this.vCd.bUg();
        if (auVar.field_isSend == 1) {
            str = this.vCd.vBD.hrM;
        }
        Bundle bundle2 = new Bundle();
        if (this.vCd.vBH) {
            str3 = "stat_scene";
            i3 = 2;
            bundle = bundle2;
        } else {
            str3 = "stat_scene";
            if (o.eV(bUg)) {
                i3 = 7;
                bundle = bundle2;
            } else {
                i3 = 1;
                bundle = bundle2;
            }
        }
        bundle.putInt(str3, i3);
        bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
        bundle2.putString("stat_chat_talker_username", bUg);
        bundle2.putString("stat_send_msg_user", str);
        intent.putExtra("_stat_obj", bundle2);
        this.vCd.startActivity(intent);
        this.vCd.overridePendingTransition(0, 0);
    }
}
