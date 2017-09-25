package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.n;
import com.tencent.mm.ah.p;
import com.tencent.mm.bb.d;
import com.tencent.mm.bg.a;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.k;
import com.tencent.mm.t.l;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.chatting.ah.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

final class bg extends b {
    public static final int vCT = (a.dO(ab.getContext()) - ((int) (a.getDensity(ab.getContext()) * 60.0f)));
    public static final int vCU = (((int) a.getDensity(ab.getContext())) * 180);
    private int vCX = 0;
    private En_5b8fbb1e.a vCd;

    public bg() {
        super(65);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cXx);
        m mVar = new m(this.knu);
        mVar.kxi = (TextView) view.findViewById(R.h.bBA);
        mVar.qFf = view.findViewById(R.h.bAk);
        mVar.mfD = (CheckBox) view.findViewById(R.h.bAd);
        mVar.nRW = view.findViewById(R.h.bAX);
        mVar.oKu = (ImageView) view.findViewById(R.h.bGY);
        mVar.iUO = (TextView) view.findViewById(R.h.title);
        mVar.lle = (TextView) view.findViewById(R.h.cIo);
        view.setTag(mVar);
        return view;
    }

    protected final boolean bUp() {
        return false;
    }

    public final void a(ah.a aVar, int i, En_5b8fbb1e.a aVar2, au auVar, String str) {
        this.vCd = aVar2;
        m mVar = (m) aVar;
        k rV = ((com.tencent.mm.plugin.biz.a.a) h.h(com.tencent.mm.plugin.biz.a.a.class)).rV(auVar.field_content);
        List list = rV.hkm;
        if (list.size() == 0) {
            mVar.qFf.setVisibility(8);
            return;
        }
        dt dtVar;
        CharSequence charSequence;
        mVar.qFf.setVisibility(0);
        l lVar = (l) list.get(0);
        if (u.mA(lVar.hks)) {
            mVar.oKu.setVisibility(8);
        } else {
            mVar.oKu.setVisibility(0);
            String str2 = lVar.hks;
            ImageView imageView = mVar.oKu;
            int i2 = auVar.field_type;
            if (p.Ha()) {
                str2 = p.jE(str2);
            }
            com.tencent.mm.ah.a.a GW = n.GW();
            c.a aVar3 = new c.a();
            aVar3.hJe = R.e.aUx;
            aVar3.hIL = true;
            aVar3 = aVar3.aO(vCT, vCU);
            aVar3.hIB = new bf.b();
            aVar3.hIN = s.n(str2, i2, "@T");
            GW.b(str2, imageView, aVar3.Hg(), new bf.a());
        }
        mVar.iUO.setText(lVar.title);
        Object TC = aVar2.TC(lVar.url);
        if (TextUtils.isEmpty(TC)) {
            dtVar = new dt(auVar, false, i, lVar.url, 6, false, aVar2.bVS(), rV.fUR, rV.fUS, lVar.title);
        } else {
            w.d("MicroMsg.ChattingItemBizVideoFrom", "productId:%s", TC);
            dtVar = new dt(auVar, false, i, lVar.url, 8, false, aVar2.bVS(), rV.fUR, rV.fUS, lVar.title, TC, null, false, false);
        }
        int i3 = lVar.hkw;
        if (i3 <= 0 || ((long) i3) >= 86400) {
            charSequence = null;
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((long) i3) < 3600 ? "mm:ss" : "HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
            charSequence = simpleDateFormat.format(Long.valueOf(((long) i3) * 1000));
        }
        if (TextUtils.isEmpty(charSequence)) {
            mVar.lle.setVisibility(8);
        } else {
            mVar.lle.setVisibility(0);
            mVar.lle.setText(charSequence);
        }
        dtVar.rXI = auVar.field_msgSvrId;
        dtVar.rXJ = 0;
        mVar.qFf.setTag(dtVar);
        mVar.qFf.setOnClickListener(aVar2.vBD.vEW);
        mVar.qFf.setOnLongClickListener(aVar2.vBD.vEY);
        mVar.qFf.setOnTouchListener(aVar2.vBD.vFa);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        dt dtVar = (dt) view.getTag();
        if (dtVar == null) {
            return false;
        }
        this.vCX = dtVar.rXJ;
        int i = dtVar.position;
        if (!(this.vCd.bVJ() || aa.aj(auVar))) {
            contextMenu.add(i, 111, 0, view.getContext().getString(R.l.eLH));
        }
        if (d.Jt("favorite")) {
            contextMenu.add(i, 125, 0, view.getContext().getString(R.l.eGa));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, En_5b8fbb1e.a aVar, au auVar) {
        String a;
        q.b n;
        switch (menuItem.getItemId()) {
            case 111:
                a = bf.a(auVar, aVar.uSU.uTo, this.vCX);
                if (!u.mA(a)) {
                    Intent intent = new Intent(aVar.uSU.uTo, MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", a);
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.vCX);
                    intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                    a = auVar.field_talker;
                    String fQ = q.fQ(auVar.field_msgSvrId);
                    intent.putExtra("reportSessionId", fQ);
                    n = q.yC().n(fQ, true);
                    n.l("prePublishId", "msg_" + auVar.field_msgSvrId);
                    n.l("preUsername", a);
                    n.l("preChatName", a);
                    n.l("preMsgIndex", Integer.valueOf(this.vCX));
                    n.l("sendAppMsgScene", Integer.valueOf(1));
                    aVar.startActivity(intent);
                    break;
                }
                break;
            case 114:
                a = bf.a(auVar, aVar.uSU.uTo, 0);
                if (!u.mA(a)) {
                    eh.c(auVar, a, aVar.uSU.uTo);
                    break;
                }
                break;
            case 125:
                a = auVar.field_talker;
                String fQ2 = q.fQ(auVar.field_msgSvrId);
                n = q.yC().n(fQ2, true);
                n.l("prePublishId", "msg_" + auVar.field_msgSvrId);
                n.l("preUsername", a);
                n.l("preChatName", a);
                n.l("preMsgIndex", Integer.valueOf(this.vCX));
                n.l("sendAppMsgScene", Integer.valueOf(1));
                cb cbVar = new cb();
                cbVar.fFA.fFE = this.vCX;
                cbVar.fFA.fFF = fQ2;
                cbVar.fFA.ov = aVar;
                cbVar.fFA.fFH = 40;
                e.a(cbVar, auVar);
                com.tencent.mm.sdk.b.a.urY.m(cbVar);
                if (cbVar.fFB.ret == 0) {
                    com.tencent.mm.modelstat.b.hUp.t(auVar);
                    break;
                }
                break;
        }
        return false;
    }

    public final boolean a(View view, En_5b8fbb1e.a aVar, au auVar) {
        return false;
    }
}
