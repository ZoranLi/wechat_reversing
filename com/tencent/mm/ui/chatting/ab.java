package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.k;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.j;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class ab {
    public static a vBa = new a();

    private static class a {
        cb fSJ;
        String fTm;
        dz vAZ;
        List<au> vBg;
        d vBh;
        boolean vxp;
    }

    static class AnonymousClass4 implements com.tencent.mm.sdk.platformtools.ar.a {
        final /* synthetic */ String hqR;
        final /* synthetic */ Runnable lcs = null;
        final /* synthetic */ boolean vBf;
        final /* synthetic */ Context val$context;

        AnonymousClass4(Context context, String str, boolean z, Runnable runnable) {
            this.val$context = context;
            this.hqR = str;
            this.vBf = z;
        }

        public final boolean Bn() {
            if (ab.vBa.vBg == null) {
                return false;
            }
            for (au d : ab.vBa.vBg) {
                ab.d(this.val$context, this.hqR, d, ab.vBa.vxp);
            }
            return true;
        }

        public final boolean Bo() {
            if (ab.vBa.vBg != null) {
                g.oUh.i(10811, Integer.valueOf(5), Integer.valueOf(ab.vBa.vBg.size()), Integer.valueOf(ab.vBa.vBg.size() - aa.cv(ab.vBa.vBg)));
            }
            if (this.vBf) {
                if (this.lcs != null) {
                    w.v("MicroMsg.ChattingEditModeRetransmitMsg", "call back is not null, do call back");
                    this.lcs.run();
                }
                if (ab.vBa.vAZ != null) {
                    ab.vBa.vAZ.b(com.tencent.mm.ui.chatting.dz.a.trans);
                }
                ab.bUb();
            }
            return true;
        }
    }

    public static void a(Context context, List<au> list, boolean z, String str, dz dzVar) {
        bUb();
        if (context == null) {
            w.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, context is null");
        } else if (list == null || list.isEmpty()) {
            w.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, select item empty");
        } else if (((dzVar == null || !dzVar.bUF()) && list.size() != 1) || aa.a(list, dzVar)) {
            Object obj;
            if (list != null && !list.isEmpty()) {
                for (au auVar : list) {
                    String str2 = null;
                    if (!auVar.bMt()) {
                        if (auVar.bMh()) {
                            com.tencent.mm.ah.d dVar = null;
                            if (auVar.field_msgId > 0) {
                                dVar = n.GS().aj(auVar.field_msgId);
                            }
                            if ((dVar == null || dVar.hEY <= 0) && auVar.field_msgSvrId > 0) {
                                dVar = n.GS().ai(auVar.field_msgSvrId);
                            }
                            if (dVar != null) {
                                str2 = n.GS().m(e.c(dVar), "", "");
                            }
                        } else if (auVar.bMm() || auVar.bMl()) {
                            o.KV();
                            str2 = s.lv(auVar.field_imgPath);
                        } else if (auVar.axO()) {
                            com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(auVar.field_content);
                            if (ek != null) {
                                b Mh = l.Mh(ek.fCW);
                                if (Mh != null) {
                                    str2 = Mh.field_fileFullPath;
                                }
                            }
                        } else {
                            str2 = auVar.field_imgPath;
                        }
                        if (auVar.bMh() || auVar.bMl() || auVar.bMm() || aa.an(auVar)) {
                            obj = (System.currentTimeMillis() - auVar.field_createTime <= 259200000 || (!bg.mA(str2) && com.tencent.mm.a.e.aO(str2))) ? null : 1;
                            if (obj == null) {
                            }
                        }
                        obj = null;
                        break;
                    }
                }
            } else {
                w.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
            }
            obj = 1;
            if (obj != null) {
                w.i("MicroMsg.ChattingEditModeRetransmitMsg", "slected msg is all expired or clean!!!");
                if (dzVar == null) {
                    return;
                }
                if (dzVar.bUF() || list.size() == 1) {
                    com.tencent.mm.ui.base.g.a(context, context.getString(R.l.egN), context.getString(R.l.dIO), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                }
                return;
            }
            b(context, list, z, str, dzVar);
        } else {
            final List<au> list2 = list;
            final dz dzVar2 = dzVar;
            final Context context2 = context;
            final boolean z2 = z;
            final String str3 = str;
            com.tencent.mm.ui.base.g.a(context, context.getString(R.l.esJ), "", context.getString(R.l.dIA), context.getString(R.l.dGs), (OnClickListener) new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Object obj;
                    List<au> list = list2;
                    if (list != null && !list.isEmpty()) {
                        for (au auVar : list) {
                            if (!aa.ah(auVar)) {
                                if (!auVar.bLZ() && !aa.ac(auVar) && !aa.ae(auVar) && !aa.al(auVar) && !aa.af(auVar) && auVar.field_type != -1879048186 && !aa.ak(auVar) && !aa.ag(auVar) && !aa.aj(auVar) && !aa.ah(auVar) && auVar.field_type != 318767153) {
                                    obj = null;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    w.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to friend msg error, select item empty");
                    obj = 1;
                    if (obj != null) {
                        w.w("MicroMsg.ChattingEditModeRetransmitMsg", "only contain invalid msg, exit long click mode");
                        if (dzVar2 != null) {
                            dzVar2.b(com.tencent.mm.ui.chatting.dz.a.trans);
                            return;
                        }
                        return;
                    }
                    ab.b(context2, list2, z2, str3, dzVar2);
                }
            }, null);
        }
    }

    public static void b(Context context, List<au> list, boolean z, String str, final dz dzVar) {
        if (aa.cx(list)) {
            com.tencent.mm.ui.base.g.a(context, context.getString(R.l.eaH), "", context.getString(R.l.dAN), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (dzVar != null) {
                        dz dzVar = dzVar;
                        com.tencent.mm.ui.chatting.dz.a aVar = com.tencent.mm.ui.chatting.dz.a.trans;
                        dzVar.bUE();
                    }
                }
            });
            return;
        }
        vBa.vBg = new LinkedList(list);
        vBa.vxp = z;
        vBa.vAZ = dzVar;
        vBa.fTm = str;
        int i = 2;
        Intent intent = new Intent(context, MsgRetransmitUI.class);
        if (list.size() == 1) {
            String fQ;
            int i2;
            au auVar = (au) list.get(0);
            if (auVar.axO() || auVar.bLX() || auVar.bLY()) {
                fQ = q.fQ(auVar.field_msgSvrId);
                q.b n = q.yC().n(fQ, true);
                n.l("prePublishId", "msg_" + auVar.field_msgSvrId);
                n.l("preUsername", ah.a(auVar, z, false));
                n.l("preChatName", auVar.field_talker);
                n.l("preMsgIndex", Integer.valueOf(0));
                n.l("sendAppMsgScene", Integer.valueOf(1));
                n.l("moreRetrAction", Boolean.valueOf(true));
                if (z) {
                    n.l("fromScene", Integer.valueOf(2));
                } else {
                    n.l("fromScene", Integer.valueOf(1));
                }
                ((h) com.tencent.mm.kernel.h.h(h.class)).a("adExtStr", n, auVar);
                intent.putExtra("reportSessionId", fQ);
            }
            String str2 = auVar.field_content;
            int i3 = 12;
            if (auVar.bMj()) {
                i3 = 9;
                fQ = str2;
            } else if (auVar.bMn()) {
                i3 = 5;
                intent.putExtra("Retr_File_Name", auVar.field_imgPath);
                fQ = str2;
            } else if (auVar.bMi()) {
                i3 = 8;
                fQ = str2;
            } else {
                if (auVar.bMk()) {
                    i3 = 4;
                    if (z && auVar.field_isSend == 0) {
                        fQ = ay.gj(str2);
                    }
                } else if (auVar.bMh()) {
                    com.tencent.mm.ah.d dVar = null;
                    if (auVar.field_msgId > 0) {
                        dVar = n.GS().aj(auVar.field_msgId);
                    }
                    if ((dVar == null || dVar.hEY <= 0) && auVar.field_msgSvrId > 0) {
                        dVar = n.GS().ai(auVar.field_msgSvrId);
                    }
                    intent.putExtra("Retr_File_Name", n.GS().m(e.c(dVar), "", ""));
                    i3 = 0;
                    fQ = str2;
                } else if (auVar.bMm()) {
                    r1 = t.lH(auVar.field_imgPath);
                    if (r1 != null) {
                        intent.putExtra("Retr_length", r1.iap);
                    }
                    i3 = 11;
                    intent.putExtra("Retr_File_Name", auVar.field_imgPath);
                    fQ = str2;
                } else if (auVar.bMl()) {
                    r1 = t.lH(auVar.field_imgPath);
                    if (r1 != null) {
                        intent.putExtra("Retr_length", r1.iap);
                    }
                    i3 = 1;
                    intent.putExtra("Retr_File_Name", auVar.field_imgPath);
                    fQ = str2;
                } else if (auVar.axO()) {
                    com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(str2);
                    if (ek != null && 19 == ek.type) {
                        i3 = 10;
                    } else if (ek != null && 24 == ek.type) {
                        i3 = 10;
                    } else if (ek == null || 16 != ek.type) {
                        i3 = 2;
                    } else {
                        i3 = 14;
                    }
                    if (auVar.bLX() || auVar.bLY()) {
                        intent.putExtra("is_group_chat", z);
                    }
                }
                fQ = str2;
            }
            if (auVar.bLX()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            intent.putExtra("Retr_Msg_Type", i3);
            intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
            intent.putExtra("Retr_Msg_content", fQ);
            intent.putExtra("Edit_Mode_Sigle_Msg", true);
            i = i2;
        } else if ((dzVar == null || !dzVar.bUF()) && ((!com.tencent.mm.u.o.eV(str) || com.tencent.mm.modelbiz.e.dr(str)) && !com.tencent.mm.u.o.fF(str))) {
            intent.putExtra("Retr_Msg_Type", 13);
            intent.putExtra("Retr_Multi_Msg_List_from", str);
        } else {
            intent.putExtra("Retr_Msg_Type", 12);
        }
        intent.putExtra("Retr_MsgFromScene", i);
        intent.putExtra("Retr_show_success_tips", true);
        context.startActivity(intent);
        ap.vL().D(new com.tencent.mm.ui.chatting.ac.AnonymousClass1(vBa.vBg));
    }

    public static void k(Context context, String str, boolean z) {
        com.tencent.mm.sdk.b.b lzVar = new lz();
        lzVar.fTf.type = 5;
        lzVar.fTf.fTl = vBa.vBg;
        lzVar.fTf.toUser = str;
        lzVar.fTf.fTm = vBa.fTm;
        lzVar.fTf.context = context;
        lzVar.fTf.fSJ = vBa.fSJ;
        lzVar.fTf.fTo = vBa.vBh;
        com.tencent.mm.sdk.b.a.urY.m(lzVar);
        if (vBa.vBg != null) {
            g.oUh.i(10811, Integer.valueOf(8), Integer.valueOf(vBa.vBg.size()), Integer.valueOf(vBa.vBg.size() - aa.cv(vBa.vBg)));
            for (au auVar : vBa.vBg) {
                long Ny = bg.Ny();
                com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(bg.PX(auVar.field_content));
                if (!(ek == null || ek.type != 5 || bg.mA(ek.url))) {
                    int i;
                    if (auVar.bLX()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    String str2 = "";
                    try {
                        str2 = URLEncoder.encode(ek.url, "UTF-8");
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", e, "", new Object[0]);
                    }
                    w.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), ek.url, Long.valueOf(Ny), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1));
                    g.oUh.i(13378, str2, Long.valueOf(Ny), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1));
                }
            }
        }
        if (z && vBa.vAZ != null) {
            vBa.vAZ.b(com.tencent.mm.ui.chatting.dz.a.trans);
        }
    }

    public static void lf(boolean z) {
        if (z && vBa.vAZ != null) {
            vBa.vAZ.b(com.tencent.mm.ui.chatting.dz.a.trans);
        }
    }

    public static lz eS(Context context) {
        com.tencent.mm.sdk.b.b lzVar = new lz();
        lzVar.fTf.type = 6;
        lzVar.fTf.fTl = vBa.vBg;
        lzVar.fTf.fTm = vBa.fTm;
        lzVar.fTf.context = context;
        com.tencent.mm.sdk.b.a.urY.m(lzVar);
        vBa.fSJ = lzVar.fTg.fSJ;
        vBa.vBh = lzVar.fTg.fTo;
        return lzVar;
    }

    public static void l(Context context, String str, boolean z) {
        if (context == null) {
            w.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, context is null");
        } else if (bg.mA(str)) {
            w.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, username is empty");
        } else if (vBa.vBg == null || vBa.vBg.isEmpty()) {
            w.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, select items empty");
        } else {
            w.v("MicroMsg.ChattingEditModeRetransmitMsg", "post to do job, send to %s", str);
            db.vGa.c(new AnonymousClass4(context, str, z, null));
        }
    }

    public static void bUb() {
        vBa.vBg = null;
        vBa.vxp = false;
        vBa.vAZ = null;
        vBa.fTm = null;
        vBa.fSJ = null;
        vBa.vBh = null;
    }

    public static void d(Context context, String str, au auVar, boolean z) {
        w.i("MicroMsg.ChattingEditModeRetransmitMsg", "retransmitSingleMsg %s", Long.valueOf(auVar.field_msgId));
        if (!aa.af(auVar) && !aa.ag(auVar)) {
            if (com.tencent.mm.modelbiz.e.dr(str) && !auVar.bMh() && !auVar.bMk() && !auVar.bLZ()) {
                w.i("MicroMsg.ChattingEditModeRetransmitMsg", "not bizChatSupport msg:type:%d", Integer.valueOf(auVar.field_type));
            } else if (auVar.bMh()) {
                aa.b(context, str, auVar);
            } else if (auVar.bMl()) {
                aa.c(context, str, auVar);
            } else if (auVar.bMm()) {
                aa.c(context, str, auVar);
                r1 = com.tencent.mm.u.o.dH(str);
                a.a(r1 ? c.Chatroom : c.Chat, a.d.Samll, auVar, r1 ? j.eC(str) : 0);
            } else if (auVar.bMk()) {
                aa.a(context, str, auVar, z);
            } else if (auVar.bMc() || auVar.axO()) {
                r1 = com.tencent.mm.u.o.dH(str);
                a.a(r1 ? c.Chatroom : c.Chat, a.d.Samll, auVar, r1 ? j.eC(str) : 0);
                if (auVar.bMo()) {
                    if (aa.a(context, str, auVar, "appEmoji")) {
                        com.tencent.mm.t.f.a aVar;
                        aj RD = aj.RD(auVar.field_content);
                        com.tencent.mm.t.f.a B = com.tencent.mm.t.f.a.B(auVar.field_content, auVar.field_reserved);
                        if (B == null) {
                            B = new com.tencent.mm.t.f.a();
                            B.hhs = RD.fFW;
                            aVar = B;
                        } else {
                            aVar = B;
                        }
                        if (bg.mA(aVar.hhs) || aVar.hhs.equalsIgnoreCase("-1")) {
                            w.e("MicroMsg.ChattingEditModeLogic", "emoji md5 is null. ignore resend");
                            return;
                        }
                        w.d("MicroMsg.ChattingEditModeLogic", "jacks send App Emoji: %s, %s", str, aVar.hhs);
                        com.tencent.mm.storage.a.c ub = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(aVar.hhs);
                        if (ub != null) {
                            aa.b(ub, str);
                        } else {
                            w.i("MicroMsg.ChattingEditModeLogic", "emoji is null. content:%s", RD);
                        }
                    }
                } else if (auVar.bLX() || auVar.bLY()) {
                    try {
                        k rV = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).rV(auVar.field_content);
                        List<com.tencent.mm.t.l> list = rV.hkm;
                        if (list != null) {
                            for (com.tencent.mm.t.l lVar : list) {
                                com.tencent.mm.t.f.a aVar2 = new com.tencent.mm.t.f.a();
                                if (com.tencent.mm.t.h.em(lVar.hkx)) {
                                    ac.b(str, ac.a(str, lVar), lVar.hkC);
                                } else {
                                    aVar2.title = lVar.title;
                                    aVar2.description = lVar.hku;
                                    aVar2.action = "view";
                                    aVar2.type = 5;
                                    aVar2.url = lVar.url;
                                    aVar2.fUR = rV.fUR;
                                    aVar2.fUS = rV.fUS;
                                    aVar2.gxD = rV.gxD;
                                    aVar2.thumburl = lVar.hks;
                                    if (bg.mA(aVar2.thumburl)) {
                                        com.tencent.mm.x.h hs = com.tencent.mm.x.n.Bm().hs(auVar.field_talker);
                                        if (hs != null) {
                                            aVar2.thumburl = hs.Bs();
                                        }
                                    }
                                    aa.a(context, str, com.tencent.mm.t.f.a.a(aVar2, null, null), auVar.field_isSend, z);
                                }
                            }
                        }
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
                        w.e("MicroMsg.ChattingEditModeLogic", "[oneliang]retransmit multi app msg error : %s", e.getLocalizedMessage());
                    }
                } else {
                    String gj;
                    if (auVar.field_isSend == 0) {
                        gj = ay.gj(auVar.field_content);
                    } else {
                        gj = auVar.field_content;
                    }
                    com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(gj);
                    if (ek == null) {
                        w.e("MicroMsg.ChattingEditModeRetransmitMsg", "parse app message content fail");
                        return;
                    }
                    f aJ = com.tencent.mm.pluginsdk.model.app.g.aJ(ek.appId, false);
                    if (aJ != null && aJ.bCU()) {
                        w.w("MicroMsg.ChattingEditModeRetransmitMsg", "do not forward game msg");
                    } else if (ek.type == 19) {
                        com.tencent.mm.sdk.b.b lzVar = new lz();
                        lzVar.fTf.type = 4;
                        lzVar.fTf.fTk = auVar;
                        lzVar.fTf.toUser = str;
                        com.tencent.mm.sdk.b.a.urY.m(lzVar);
                    } else {
                        if (ek.type == 5 && !bg.mA(ek.url)) {
                            gj = "";
                            try {
                                gj = URLEncoder.encode(ek.url, "UTF-8");
                            } catch (Throwable e2) {
                                w.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", e2, "", new Object[0]);
                            }
                            long Ny = bg.Ny();
                            w.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), ek.url, Long.valueOf(Ny), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1));
                            g.oUh.i(13378, gj, Long.valueOf(Ny), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1));
                        }
                        aa.b(context, str, auVar, z);
                    }
                }
            } else if (auVar.bMi()) {
                if (aa.a(context, str, auVar, "friendcard")) {
                    com.tencent.mm.plugin.messenger.a.d.aJW().A(str, aa.q(auVar.field_content, auVar.field_isSend, z), 42);
                }
            } else if (auVar.bMn() || auVar.bMo()) {
                if (!aa.ac(auVar)) {
                    aa.a(context, str, auVar);
                }
            } else if (auVar.bMj()) {
                aa.c(context, str, auVar, z);
            }
        }
    }
}
