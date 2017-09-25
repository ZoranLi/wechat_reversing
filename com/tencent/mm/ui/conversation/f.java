package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.lp;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelmulti.b.a;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.modelsimple.ag;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.i;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.conversation.b.AnonymousClass2;
import com.tencent.mm.ui.conversation.b.AnonymousClass3;
import com.tencent.mm.ui.conversation.b.AnonymousClass4;
import com.tencent.mm.ui.conversation.b.AnonymousClass5;
import com.tencent.mm.ui.conversation.b.AnonymousClass6;
import com.tencent.mm.ui.conversation.b.AnonymousClass7;
import com.tencent.mm.ui.conversation.b.AnonymousClass8;

public final class f implements OnCreateContextMenuListener, OnItemLongClickListener {
    public Activity activity;
    public String fJL = "";
    private d nxN = new d(this) {
        final /* synthetic */ f wcF;

        {
            this.wcF = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            int i2 = -1;
            String str;
            af Rc;
            switch (menuItem.getItemId()) {
                case 4:
                    str = this.wcF.fJL;
                    Context context = this.wcF.activity;
                    aj ajVar = this.wcF.vWD;
                    PBool pBool = new PBool();
                    if (o.dH(str)) {
                        ap.yY();
                        ce Ah = c.wT().Ah(str);
                        ap.yY();
                        c.wQ().b(new com.tencent.mm.ao.d(str, Ah.field_msgSvrId));
                        pBool.value = false;
                        context.getString(R.l.dIO);
                        ProgressDialog a = g.a(context, context.getString(R.l.dJd), true, new com.tencent.mm.ui.conversation.b.AnonymousClass1(pBool));
                        if (i.er(str)) {
                            q.Hz().a(new a(str, 0, 0, 0, 0));
                        }
                        ay.a(str, new AnonymousClass2(pBool, a, str));
                    } else if (o.fl(str)) {
                        ap.yY();
                        c.wW().Ap(str);
                        b lpVar = new lp();
                        lpVar.fSH.opType = 4;
                        lpVar.fSH.fSM = 20;
                        com.tencent.mm.sdk.b.a.urY.m(lpVar);
                    } else if (o.fb(str)) {
                        ap.yY();
                        c.wW().Ap(str);
                    } else if (o.fe(str)) {
                        ap.yY();
                        c.wW().Rl(str);
                    } else if (e.dr(str)) {
                        pBool.value = false;
                        context.getString(R.l.dIO);
                        ay.a(str, new AnonymousClass4(pBool, g.a(context, context.getString(R.l.dJd), true, new AnonymousClass3(pBool)), str));
                    } else {
                        ap.yY();
                        ce Ah2 = c.wT().Ah(str);
                        ap.yY();
                        c.wQ().b(new com.tencent.mm.ao.d(str, Ah2.field_msgSvrId));
                        pBool.value = false;
                        context.getString(R.l.dIO);
                        ay.a(str, new AnonymousClass6(pBool, g.a(context, context.getString(R.l.dJd), true, new AnonymousClass5(pBool))));
                        ap.yY();
                        af Rc2 = c.wR().Rc(str);
                        Rc2.tj();
                        Rc2.tk();
                        if (Rc2.bLe() && e.hX(str)) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(13773, Integer.valueOf(0), Integer.valueOf(ajVar.field_unReadCount), Integer.valueOf(1), ajVar.field_username);
                        }
                        com.tencent.mm.bd.a com_tencent_mm_protocal_c_ame = new ame();
                        w.i("MicroMsg.ConvDelLogic", "oplog modContact user:%s remark:%s type:%d ", Rc2.field_username, Rc2.field_conRemark, Integer.valueOf(Rc2.field_type));
                        com_tencent_mm_protocal_c_ame.ttp = new avx().OV(u.mz(Rc2.field_username));
                        com_tencent_mm_protocal_c_ame.tLj = new avx().OV(u.mz(Rc2.field_nickname));
                        com_tencent_mm_protocal_c_ame.ttf = new avx().OV(u.mz(Rc2.pB()));
                        com_tencent_mm_protocal_c_ame.ttg = new avx().OV(u.mz(Rc2.pC()));
                        com_tencent_mm_protocal_c_ame.hAD = Rc2.gkr;
                        com_tencent_mm_protocal_c_ame.tsx = 561023;
                        com_tencent_mm_protocal_c_ame.tsy = Rc2.field_type;
                        com_tencent_mm_protocal_c_ame.tQl = new avx().OV(u.mz(Rc2.field_conRemark));
                        com_tencent_mm_protocal_c_ame.tQm = new avx().OV(u.mz(Rc2.field_conRemarkPYShort));
                        com_tencent_mm_protocal_c_ame.tQn = new avx().OV(u.mz(Rc2.field_conRemarkPYFull));
                        com_tencent_mm_protocal_c_ame.tsD = Rc2.gkw;
                        com_tencent_mm_protocal_c_ame.tQF = new avx().OV(u.mz(Rc2.field_domainList));
                        com_tencent_mm_protocal_c_ame.tsH = Rc2.gkz;
                        com_tencent_mm_protocal_c_ame.hAH = Rc2.gkA;
                        com_tencent_mm_protocal_c_ame.hAG = u.mz(Rc2.signature);
                        com_tencent_mm_protocal_c_ame.hAF = u.mz(Rc2.getCityCode());
                        com_tencent_mm_protocal_c_ame.hAE = u.mz(Rc2.bLi());
                        com_tencent_mm_protocal_c_ame.tMR = u.mz(Rc2.gkF);
                        com_tencent_mm_protocal_c_ame.tMT = Rc2.field_weiboFlag;
                        com_tencent_mm_protocal_c_ame.tQB = 0;
                        com_tencent_mm_protocal_c_ame.tfh = new avw();
                        com_tencent_mm_protocal_c_ame.hAM = u.mz(Rc2.getCountryCode());
                        ap.yY();
                        c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(2, com_tencent_mm_protocal_c_ame));
                        ap.yY();
                        c.wR().a(str, Rc2);
                        ap.yY();
                        ajVar = c.wW().Rm(str);
                        ap.yY();
                        c.wW().Rl(str);
                        if (ajVar != null && (ajVar.eC(4194304) || (Rc2.bLe() && !com.tencent.mm.j.a.ez(Rc2.field_type) && ajVar.field_conversationTime < com.tencent.mm.modelbiz.w.DT()))) {
                            ap.vd().a(new com.tencent.mm.modelsimple.i(str), 0);
                        }
                    }
                    if (!o.fc(str)) {
                        if (o.fa(str)) {
                            w.d("MicroMsg.ConvDelLogic", "del all tmessage");
                            ay.zq();
                            ap.yY();
                            c.wW().Ap("@t.qq.com");
                        }
                        i2 = 1;
                        break;
                    }
                    w.d("MicroMsg.ConvDelLogic", "del all qmessage");
                    ay.zp();
                    ap.yY();
                    c.wW().Ap("@qqim");
                    i2 = 1;
                    break;
                case 5:
                    i2 = 4;
                    w.d("MicroMsg.ConversationClickListener", "placed to the top");
                    o.l(this.wcF.fJL, true);
                    ap.yY();
                    Rc = c.wR().Rc(this.wcF.fJL);
                    if (Rc != null && Rc.bLe()) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(13307, Rc.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
                    }
                    g.bl(this.wcF.activity, this.wcF.activity.getString(R.l.ezb));
                    com.tencent.mm.modelstat.b.hUp.b(true, this.wcF.fJL, true);
                    break;
                case 6:
                    i2 = 5;
                    w.d("MicroMsg.ConversationClickListener", "unplaced to the top");
                    o.m(this.wcF.fJL, true);
                    ap.yY();
                    Rc = c.wR().Rc(this.wcF.fJL);
                    if (Rc != null && Rc.bLe()) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(13307, Rc.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
                    }
                    g.bl(this.wcF.activity, this.wcF.activity.getString(R.l.ezc));
                    com.tencent.mm.modelstat.b.hUp.b(true, this.wcF.fJL, false);
                    break;
                case 7:
                    i2 = 3;
                    w.d("MicroMsg.ConversationClickListener", "jacks mark read: %s", this.wcF.fJL);
                    ap.yY();
                    c.wW().Ro(this.wcF.fJL);
                    MMAppMgr.cancelNotification(this.wcF.fJL);
                    ag.C(this.wcF.fJL, 1);
                    com.tencent.mm.modelstat.b.hUp.A(this.wcF.fJL, false);
                    break;
                case 8:
                    i2 = 2;
                    w.d("MicroMsg.ConversationClickListener", "jacks set unread: %s", this.wcF.fJL);
                    ap.yY();
                    c.wW().Rp(this.wcF.fJL);
                    com.tencent.mm.modelstat.b.hUp.A(this.wcF.fJL, true);
                    break;
                case 9:
                    w.d("MicroMsg.ConversationClickListener", "jacks clear history: %s", this.wcF.fJL);
                    this.wcF.fJL.endsWith("@chatroom");
                    str = this.wcF.fJL;
                    Context context2 = this.wcF.activity;
                    PBool pBool2 = new PBool();
                    pBool2.value = false;
                    context2.getString(R.l.dIO);
                    ay.a(str, new AnonymousClass8(pBool2, g.a(context2, context2.getString(R.l.dJd), true, new AnonymousClass7(pBool2))));
                    break;
                case 10:
                    w.d("MicroMsg.ConversationClickListener", "delete biz service: %s", this.wcF.fJL);
                    ap.yY();
                    com.tencent.mm.ui.tools.b.a(e.hW(this.wcF.fJL), this.wcF.activity, c.wR().Rc(this.wcF.fJL), 1);
                    break;
            }
            if (i2 > 0) {
                com.tencent.mm.plugin.report.service.g.oUh.i(11090, Integer.valueOf(i2));
                w.d("MicroMsg.ConversationClickListener", "jacks kv long click: %d", Integer.valueOf(i2));
            }
        }
    };
    public ae vWD = null;
    private g wbL;
    private ListView wbi;
    private int[] wcE = new int[2];

    public f(g gVar, ListView listView, Activity activity, int[] iArr) {
        this.wbL = gVar;
        this.wbi = listView;
        this.activity = activity;
        this.wcE = iArr;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < this.wbi.getHeaderViewsCount()) {
            w.d("MicroMsg.ConversationClickListener", "on long click header view");
            return true;
        }
        this.vWD = (ae) this.wbL.yQ(i - this.wbi.getHeaderViewsCount());
        if (this.vWD == null) {
            w.e("MicroMsg.ConversationClickListener", "headercount:%d, postion:%d", Integer.valueOf(this.wbi.getHeaderViewsCount()), Integer.valueOf(i));
            return true;
        }
        this.fJL = this.vWD.field_username;
        new com.tencent.mm.ui.widget.g(this.activity).a(view, i, j, this, this.nxN, this.wcE[0], this.wcE[1]);
        return true;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        int i = 1;
        ap.yY();
        af Rc = c.wR().Rc(this.fJL);
        if (Rc == null) {
            w.e("MicroMsg.ConversationClickListener", "onCreateContextMenu, contact is null, talker = " + this.fJL);
            return;
        }
        CharSequence tL = Rc.tL();
        if (tL.toLowerCase().endsWith("@chatroom") && u.mA(Rc.field_nickname)) {
            tL = this.activity.getString(R.l.dVr);
        }
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        contextMenu.setHeaderTitle(h.a(this.activity, tL));
        if (((this.vWD != null ? 1 : 0) & o.b(this.vWD)) != 0) {
            String str = this.fJL;
            ap.yY();
            aj Rm = c.wW().Rm(str);
            if (Rm == null) {
                i = 0;
            } else if (Rm.field_unReadCount > 0 || Rm.eC(1048576)) {
                i = 0;
            }
            if (i != 0) {
                contextMenu.add(adapterContextMenuInfo.position, 8, 0, R.l.eyZ);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 7, 0, R.l.eyX);
            }
        }
        if (this.vWD != null && o.a(this.vWD)) {
            ap.yY();
            if (c.wW().Rt(this.fJL)) {
                contextMenu.add(adapterContextMenuInfo.position, 6, 0, R.l.eza);
            } else if (Rc.bLe()) {
                contextMenu.add(adapterContextMenuInfo.position, 5, 0, R.l.eak);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 5, 0, R.l.eyY);
            }
        }
        if (Rc.bLe() && com.tencent.mm.j.a.ez(Rc.field_type) && !o.fF(Rc.field_username) && !o.fh(Rc.field_username)) {
            BizInfo hW = e.hW(Rc.field_username);
            if (hW != null && hW.CE()) {
                contextMenu.add(adapterContextMenuInfo.position, 10, 0, R.l.eyW);
            }
        }
        if (this.vWD != null && this.vWD.field_conversationTime != -1) {
            if (o.fa(this.fJL)) {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, R.l.ezf);
            } else if (o.fb(this.fJL)) {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, R.l.eze);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, R.l.ezd);
            }
        }
    }
}
