package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ah.c;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mm.y.k;
import com.tencent.wework.api.WWAPIFactory;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class db implements dz {
    public static ar vGa = new ar(5, "MicroMsg.ChattingMoreBtnBarHelper");
    public x fOK;
    public l iLX;
    public p kww;
    Animation pvS;
    public a vBu;
    public cw vBv;
    private ChatFooter vBw;
    boolean vBy = false;
    public boolean vFu = false;
    public ChattingFooterMoreBtnBar vGb;
    public dd vGc;
    private ChatFooterCustom vGd;
    public boolean vGe = true;
    public boolean vxp;

    class AnonymousClass8 implements Runnable {
        final /* synthetic */ db vGf;
        final /* synthetic */ List vGl;

        AnonymousClass8(db dbVar, List list) {
            this.vGf = dbVar;
            this.vGl = list;
        }

        public final void run() {
            for (au auVar : this.vGl) {
                if (auVar.bMh()) {
                    int i;
                    d ai = n.GS().ai(auVar.field_msgSvrId);
                    if (auVar.field_isSend == 1) {
                        int i2;
                        if (ai.GB()) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        i = i2;
                    } else if (ai.GB()) {
                        if (e.aO(n.GS().m(com.tencent.mm.ah.e.a(ai).hEZ, "", ""))) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                    } else {
                        i = 0;
                    }
                    if (ai.offset < ai.hrs || ai.hrs == 0) {
                        n.GT().a(ai.hEY, auVar.field_msgId, i, Long.valueOf(auVar.field_msgId), auVar.field_isSend == 1 ? R.g.bdJ : R.g.bdH, new c.a(this) {
                            final /* synthetic */ AnonymousClass8 vGm;

                            {
                                this.vGm = r1;
                            }

                            public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, k kVar) {
                            }

                            public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, k kVar) {
                                boolean z = i3 == 0 && i4 == 0;
                                ap.yY();
                                this.vGm.vGf.vBv.a(j2, com.tencent.mm.u.c.wT().cA(j2), z);
                            }

                            public final void a(long j, long j2, int i, int i2, Object obj) {
                            }
                        });
                    }
                } else if (auVar.bMp()) {
                    com.tencent.mm.pluginsdk.model.app.l.a(auVar, null);
                } else if (auVar.bMl() || auVar.bMm()) {
                    r lH = t.lH(auVar.field_imgPath);
                    if (!(lH == null || lH.status == 199)) {
                        if (lH.Lj()) {
                            w.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete online video");
                            t.lL(auVar.field_imgPath);
                        } else {
                            w.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete offline video");
                            t.lD(auVar.field_imgPath);
                        }
                    }
                }
            }
        }
    }

    public db(a aVar, ChattingFooterMoreBtnBar chattingFooterMoreBtnBar, cw cwVar, ChatFooter chatFooter, ChatFooterCustom chatFooterCustom, x xVar, boolean z) {
        this.vBu = aVar;
        this.vGb = chattingFooterMoreBtnBar;
        this.vBw = chatFooter;
        this.vGd = chatFooterCustom;
        this.vBv = cwVar;
        b(xVar, z);
        this.pvS = AnimationUtils.loadAnimation(aVar.uSU.uTo, R.a.aRq);
        if (this.vBy) {
            w.w("MicroMsg.ChattingMoreBtnBarHelper", "is in show search chat result");
        } else {
            this.kww = new p(true, true);
            this.kww.woe = new b(this) {
                final /* synthetic */ db vGf;

                {
                    this.vGf = r1;
                }

                public final void mR(String str) {
                    w.v("MicroMsg.ChattingMoreBtnBarHelper", "on edit change");
                    if (!bg.mA(str)) {
                        w.v("MicroMsg.ChattingMoreBtnBarHelper", "enter search mode");
                        this.vGf.vGb.setVisibility(8);
                        this.vGf.vBu.bVy();
                        if (this.vGf.vGc != null) {
                            this.vGf.vGc.yD(str);
                        }
                    } else if (this.vGf.vBu.vJC) {
                        if (this.vGf.vGc != null) {
                            this.vGf.vGc.yD("");
                        }
                        this.vGf.vBu.AY(-1);
                    } else if (this.vGf.vFu) {
                        this.vGf.vBu.bVz();
                        this.vGf.vGb.setVisibility(0);
                        this.vGf.vGb.AP(this.vGf.vBv.vFx.size());
                    } else {
                        this.vGf.vBu.bVz();
                        this.vGf.vGb.setVisibility(8);
                    }
                }

                public final void OD() {
                    w.v("MicroMsg.ChattingMoreBtnBarHelper", "onQuitSearch");
                    if (this.vGf.vBv.vFu) {
                        this.vGf.vBu.bVz();
                        this.vGf.vGb.setVisibility(0);
                        this.vGf.vGb.AP(this.vGf.vBv.vFx.size());
                    }
                }

                public final void OE() {
                    w.v("MicroMsg.ChattingMoreBtnBarHelper", "onEnterSearch");
                    g.oUh.a(219, 21, 1, true);
                    if (this.vGf.vBv.vFu) {
                        this.vGf.vBu.bVy();
                        this.vGf.vGb.setVisibility(8);
                    }
                }

                public final boolean mQ(String str) {
                    return false;
                }

                public final void OF() {
                }

                public final void OG() {
                }
            };
        }
        this.vGb.c(3, new OnClickListener(this) {
            final /* synthetic */ db vGf;

            {
                this.vGf = r1;
            }

            public final void onClick(View view) {
                if (this.vGf.vBv.vFx.size() == 0) {
                    w.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                    return;
                }
                final Context context = this.vGf.vBu.uSU.uTo;
                com.tencent.mm.ui.base.g.a(context, context.getString(R.l.dXd), "", context.getString(R.l.ebv), context.getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 vGg;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        w.i("MicroMsg.ChattingMoreBtnBarHelper", "delete message");
                        z.a(context, this.vGg.vGf.vBv.vFx, this.vGg.vGf);
                        this.vGg.vGf.bUC();
                    }
                }, null, R.e.aSJ);
            }
        });
        this.vGb.c(2, new OnClickListener(this) {
            final /* synthetic */ db vGf;

            {
                this.vGf = r1;
            }

            public final void onClick(View view) {
                if (this.vGf.vBv.vFx.size() == 0) {
                    w.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                } else {
                    ad.a(this.vGf.vBu, this.vGf.bUB(), this.vGf.vxp, this.vGf, this.vGf.fOK);
                }
            }
        });
        this.vGb.c(1, new OnClickListener(this) {
            final /* synthetic */ db vGf;

            {
                this.vGf = r1;
            }

            public final void onClick(View view) {
                if (this.vGf.vBv.vFx.size() == 0) {
                    w.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                    return;
                }
                List bUB = this.vGf.bUB();
                if (aa.cx(bUB)) {
                    com.tencent.mm.ui.base.g.a(this.vGf.vBu.uSU.uTo, this.vGf.vBu.uSU.uTo.getString(R.l.eaH), "", this.vGf.vBu.uSU.uTo.getString(R.l.dAN), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass4 vGh;

                        {
                            this.vGh = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (aa.cy(bUB)) {
                    com.tencent.mm.ui.base.g.a(this.vGf.vBu.uSU.uTo, this.vGf.vBu.uSU.uTo.getString(R.l.eaI), "", this.vGf.vBu.uSU.uTo.getString(R.l.dAN), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass4 vGh;

                        {
                            this.vGh = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (aa.cw(bUB)) {
                    com.tencent.mm.ui.base.g.a(this.vGf.vBu.uSU.uTo, this.vGf.vBu.uSU.uTo.getString(R.l.eaJ), "", new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass4 vGh;

                        {
                            this.vGh = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }, null);
                } else if (ae.a(this.vGf.vBu, bUB, this.vGf.fOK)) {
                    this.vGf.bUC();
                }
            }
        });
        this.vGb.c(0, new OnClickListener(this) {
            final /* synthetic */ db vGf;

            {
                this.vGf = r1;
            }

            public final void onClick(View view) {
                if (this.vGf.vBv.vFx.size() == 0) {
                    w.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                } else if ((!o.eV(this.vGf.fOK.field_username) || com.tencent.mm.modelbiz.e.dr(this.vGf.fOK.field_username)) && !o.fF(this.vGf.fOK.field_username)) {
                    this.vGf.iLX.b(view, new OnCreateContextMenuListener(this) {
                        final /* synthetic */ AnonymousClass5 vGi;

                        {
                            this.vGi = r1;
                        }

                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                            contextMenu.add(0, 0, 0, R.l.eBC);
                            contextMenu.add(0, 1, 1, R.l.eBD);
                            if (WWAPIFactory.hM(this.vGi.vGf.vBu.uSU.uTo).chS()) {
                                contextMenu.add(0, 2, 2, this.vGi.vGf.vBu.uSU.uTo.getString(R.l.eBE, new Object[]{WWAPIFactory.hM(this.vGi.vGf.vBu.uSU.uTo).chT()}));
                            }
                        }
                    }, new com.tencent.mm.ui.base.n.d(this) {
                        final /* synthetic */ AnonymousClass5 vGi;

                        {
                            this.vGi = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            if (menuItem.getItemId() == 0) {
                                this.vGi.vGf.vGe = true;
                                db dbVar = this.vGi.vGf;
                                new ae().post(new AnonymousClass8(dbVar, dbVar.bUB()));
                            } else if (2 == menuItem.getItemId()) {
                                Context context = this.vGi.vGf.vBu.uSU.uTo;
                                x xVar = this.vGi.vGf.fOK;
                                List bUB = this.vGi.vGf.bUB();
                                boolean z = this.vGi.vGf.vxp;
                                if (bUB.size() != 0) {
                                    if (aa.cw(bUB)) {
                                        w.w("MicroMsg.SendToWeWorkHelper", "isContainUndownloadFile");
                                        com.tencent.mm.ui.base.g.a(context, context.getString(R.l.eaK), "", new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                            }
                                        }, null);
                                    } else if (aa.a(bUB, null)) {
                                        ei.a(context, xVar, bUB, z);
                                    } else {
                                        w.w("MicroMsg.SendToWeWorkHelper", "handleInvalidSendToFriendMsg");
                                        com.tencent.mm.ui.base.g.a(context, context.getString(R.l.esJ), "", context.getString(R.l.eLH), context.getString(R.l.dGs), new com.tencent.mm.ui.chatting.ei.AnonymousClass2(context, xVar, bUB, z), null);
                                    }
                                }
                                this.vGi.vGf.bUC();
                                return;
                            } else {
                                this.vGi.vGf.vGe = false;
                            }
                            ab.a(this.vGi.vGf.vBu.uSU.uTo, this.vGi.vGf.bUB(), this.vGi.vGf.vxp, this.vGi.vGf.fOK.field_username, this.vGi.vGf);
                        }
                    });
                } else {
                    this.vGf.vGe = true;
                    ab.a(this.vGf.vBu.uSU.uTo, this.vGf.bUB(), this.vGf.vxp, this.vGf.fOK.field_username, this.vGf);
                }
            }
        });
        this.vGb.c(4, new OnClickListener(this) {
            final /* synthetic */ db vGf;

            {
                this.vGf = r1;
            }

            public final void b(cb cbVar) {
                int i;
                cbVar.fFA.ov = this.vGf.vBu;
                cbVar.fFA.fFH = 41;
                cbVar.fFA.fFJ = new com.tencent.mm.ui.snackbar.b.c(this) {
                    final /* synthetic */ AnonymousClass6 vGj;

                    {
                        this.vGj = r1;
                    }

                    public final void azn() {
                        this.vGj.vGf.bUC();
                        this.vGj.vGf.vGb.setVisibility(4);
                    }

                    public final void onHide() {
                        this.vGj.vGf.bUC();
                    }

                    public final void azo() {
                        this.vGj.vGf.vBu.bUV();
                    }
                };
                com.tencent.mm.sdk.b.a.urY.m(cbVar);
                if (cbVar.fFB.ret == 0) {
                    i = 1;
                } else {
                    i = 2;
                }
                List<au> bUB = this.vGf.bUB();
                long Ny = bg.Ny();
                for (au auVar : bUB) {
                    if (auVar.axO()) {
                        f.a ek = f.a.ek(bg.PX(auVar.field_content));
                        if (!(ek == null || ek.type != 5 || bg.mA(ek.url))) {
                            int i2;
                            if (auVar.bLX()) {
                                i2 = 1;
                            } else {
                                i2 = 2;
                            }
                            w.d("MicroMsg.ChattingMoreBtnBarHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), ek.url, Long.valueOf(Ny), Integer.valueOf(i2), Integer.valueOf(2), Integer.valueOf(1));
                            String str = "";
                            try {
                                str = URLEncoder.encode(ek.url, "UTF-8");
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.ChattingMoreBtnBarHelper", e, "", new Object[0]);
                            }
                            g.oUh.i(13378, str, Long.valueOf(Ny), Integer.valueOf(i2), Integer.valueOf(2), Integer.valueOf(i));
                        }
                    }
                }
                if (cbVar.fFB.ret != 0) {
                    return;
                }
                if (14 != cbVar.fFA.type) {
                    w.d("MicroMsg.ChattingMoreBtnBarHelper", "not record type, do not report");
                } else if (cbVar.fFA.fFD == null) {
                    w.e("MicroMsg.ChattingMoreBtnBarHelper", "want to report record fav, but type count is null");
                } else {
                    g.oUh.i(11142, Integer.valueOf(cbVar.fFA.fFD.tzy), Integer.valueOf(cbVar.fFA.fFD.tzz), Integer.valueOf(cbVar.fFA.fFD.tzA), Integer.valueOf(cbVar.fFA.fFD.tzB), Integer.valueOf(cbVar.fFA.fFD.tzC), Integer.valueOf(cbVar.fFA.fFD.tzD), Integer.valueOf(cbVar.fFA.fFD.tzE), Integer.valueOf(cbVar.fFA.fFD.tzF), Integer.valueOf(cbVar.fFA.fFD.tzG), Integer.valueOf(cbVar.fFA.fFD.tzH), Integer.valueOf(cbVar.fFA.fFD.tzI), Integer.valueOf(cbVar.fFA.fFD.tzJ), Integer.valueOf(cbVar.fFA.fFD.tzK), Integer.valueOf(cbVar.fFA.fFD.tzL), Integer.valueOf(cbVar.fFA.fFD.tzM));
                }
            }

            public final void onClick(View view) {
                final List<au> bUB = this.vGf.bUB();
                if (aa.cx(bUB)) {
                    com.tencent.mm.ui.base.g.a(this.vGf.vBu.uSU.uTo, this.vGf.vBu.uSU.uTo.getString(R.l.eip), "", this.vGf.vBu.uSU.uTo.getString(R.l.dAN), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass6 vGj;

                        {
                            this.vGj = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                }
                au auVar;
                final cb cbVar = new cb();
                w.d("MicroMsg.ChattingMoreBtnBarHelper", "want fav msgs from %s", this.vGf.fOK.field_username);
                if (bUB.size() == 1) {
                    auVar = (au) bUB.get(0);
                    if (auVar != null && (auVar.axO() || auVar.bLX() || auVar.bLY())) {
                        String fQ = q.fQ(auVar.field_msgSvrId);
                        q.b n = q.yC().n(fQ, true);
                        n.l("prePublishId", "msg_" + auVar.field_msgSvrId);
                        n.l("preUsername", ah.a(auVar, this.vGf.vxp, this.vGf.vBu.sMK));
                        n.l("preChatName", this.vGf.fOK.field_username);
                        n.l("preMsgIndex", Integer.valueOf(0));
                        n.l("sendAppMsgScene", Integer.valueOf(1));
                        ((h) com.tencent.mm.kernel.h.h(h.class)).a("adExtStr", n, auVar);
                        cbVar.fFA.fFF = fQ;
                    }
                }
                if (com.tencent.mm.pluginsdk.model.g.a(this.vGf.vBu.uSU.uTo, cbVar, this.vGf.fOK.field_username, bUB, false)) {
                    for (au auVar2 : bUB) {
                        if (auVar2.axO()) {
                            com.tencent.mm.modelstat.b.hUp.c(auVar2, com.tencent.mm.t.g.g(auVar2));
                        } else {
                            com.tencent.mm.modelstat.b.hUp.t(auVar2);
                        }
                    }
                    b(cbVar);
                    AnonymousClass6.cz(this.vGf.bUB());
                } else if (this.vGf.bUB().size() > 1) {
                    String string;
                    Context context = this.vGf.vBu.uSU.uTo;
                    String string2 = cbVar.fFA.fFG >= 0 ? this.vGf.vBu.uSU.uTo.getString(R.l.eio) : this.vGf.vBu.uSU.uTo.getString(R.l.ein);
                    fQ = "";
                    if (cbVar.fFA.fFG >= 0) {
                        string = this.vGf.vBu.uSU.uTo.getString(R.l.dXk);
                    } else {
                        string = this.vGf.vBu.uSU.uTo.getString(R.l.eGa);
                    }
                    com.tencent.mm.ui.base.g.a(context, string2, fQ, string, this.vGf.vBu.uSU.uTo.getString(R.l.dXi), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass6 vGj;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            for (au auVar : bUB) {
                                if (!auVar.bMo() && !auVar.bMn()) {
                                    if (cbVar.fFA.type == 14 && cbVar.fFA.fFC.tzn.size() == 0) {
                                        this.vGj.vGf.bUC();
                                        return;
                                    }
                                    this.vGj.b(cbVar);
                                    AnonymousClass6.cz(this.vGj.vGf.bUB());
                                    return;
                                }
                            }
                        }
                    }, null);
                } else {
                    com.tencent.mm.ui.base.g.h(this.vGf.vBu.uSU.uTo, cbVar.fFA.fFG, 0);
                }
            }

            public static void cz(List<au> list) {
                for (au a : list) {
                    a.a(a.c.Fav, a.d.Samll, a, 0);
                }
            }
        });
        this.vBv.vFH = new OnClickListener(this) {
            final /* synthetic */ db vGf;

            {
                this.vGf = r1;
            }

            public final void onClick(View view) {
                if (this.vGf.vBv.eG(((Long) view.getTag()).longValue())) {
                    int size = this.vGf.vBv.vFx.size();
                    this.vGf.vBu.bVz();
                    this.vGf.kww.bZQ();
                    this.vGf.vGb.setVisibility(0);
                    this.vGf.vGb.AP(size);
                }
            }
        };
        this.iLX = new l(this.vBu.uSU.uTo);
    }

    public final void b(x xVar, boolean z) {
        this.fOK = xVar;
        this.vxp = z;
    }

    public final List<au> bUB() {
        List<au> linkedList = new LinkedList();
        for (Long longValue : this.vBv.vFx) {
            w.v("MicroMsg.ChattingMoreBtnBarHelper", "select msg id %d", Long.valueOf(longValue.longValue()));
            ap.yY();
            linkedList.add(com.tencent.mm.u.c.wT().cA(r4));
        }
        Collections.sort(linkedList, new Comparator<au>(this) {
            final /* synthetic */ db vGf;

            {
                this.vGf = r1;
            }

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return (int) (((au) obj).field_createTime - ((au) obj2).field_createTime);
            }
        });
        return linkedList;
    }

    public final void bUC() {
        this.vBu.a(false, this.kww);
        this.vGb.setVisibility(8);
        this.vBv.auj();
        this.vBu.bVz();
        this.vFu = false;
        this.vBu.bVn();
        this.vBu.bWb();
        this.vBu.bVm();
        this.vBu.are();
        ab.bUb();
    }

    public final void a(dz.a aVar) {
    }

    public final void bUD() {
        if (this.kww != null) {
            this.kww.bZQ();
        }
    }

    public final void bUE() {
        bUC();
    }

    public final void b(dz.a aVar) {
        bUC();
    }

    public final boolean bUF() {
        return this.vGe;
    }
}
