package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.MergeCursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.tools.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class a extends k<ae> {
    private com.tencent.mm.ui.applet.b hBe = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a(this) {
        final /* synthetic */ a wrR;

        {
            this.wrR = r1;
        }

        public final Bitmap jf(String str) {
            return com.tencent.mm.x.b.a(str, false, -1);
        }
    });
    private com.tencent.mm.ui.applet.b.b hBf = null;
    private String isw;
    protected List<String> jBA = null;
    private ColorStateList[] vvt = new ColorStateList[2];
    private HashMap<String, a> vvu;
    private boolean wbU = true;
    private b wrQ;

    private class a {
        public CharSequence nickName;
        public CharSequence wcp;
        public CharSequence wcq;
        public int wcr;
        final /* synthetic */ a wrR;

        public a(a aVar) {
            this.wrR = aVar;
        }
    }

    public interface b {
    }

    public static class c {
        public ImageView ipv;
        public TextView jWd;
        public TextView jWe;
        public TextView jWf;
        public TextView jWh;
        public ImageView vvB;
        public ImageView vvC;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ae) obj;
        if (cursor.getString(0) != null && cursor.getString(0).equals("1")) {
            if (obj == null) {
                obj = new ae();
            }
            obj.b(cursor);
        } else if (cursor.getString(0).equals("2")) {
            ap.yY();
            af QX = com.tencent.mm.u.c.wR().QX(x.h(cursor));
            if (QX == null) {
                QX = new x();
                QX.b(cursor);
                ap.yY();
                com.tencent.mm.u.c.wR().O(QX);
            }
            if (obj == null) {
                obj = new ae();
            }
            obj.dv(2);
            obj.s(-1);
            obj.dw(1);
            obj.setContent(this.context.getString(R.l.emX));
            obj.setUsername(QX.field_username);
            obj.dt(0);
            obj.ct(Integer.toString(1));
        } else {
            if (obj == null) {
                obj = new ae();
            }
            obj.b(cursor);
        }
        return obj;
    }

    public a(Context context, com.tencent.mm.ui.k.a aVar) {
        super(context, new ae());
        this.uSN = aVar;
        this.vvt[0] = com.tencent.mm.bg.a.S(context, R.e.aVd);
        this.vvt[1] = com.tencent.mm.bg.a.S(context, R.e.aVe);
        this.vvu = new HashMap();
    }

    public final void cK(List<String> list) {
        this.jBA = list;
        a(null, null);
    }

    protected final void OL() {
        OK();
    }

    public final void OK() {
        Cursor[] cursorArr = new Cursor[2];
        cursorArr[0] = ap.yY().hkK.a(o.hlr, this.jBA, this.isw);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (this.jBA != null && this.jBA.size() > 0) {
            arrayList.addAll(this.jBA);
        }
        while (cursorArr[0].moveToNext()) {
            try {
                String string = cursorArr[0].getString(cursorArr[0].getColumnIndex("username"));
                arrayList.add(string);
                if (!string.endsWith("@chatroom")) {
                    arrayList2.add(string);
                }
                w.d("MicroMsg.SearchConversationAdapter", "block user " + string);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SearchConversationAdapter", e, "", new Object[0]);
            }
        }
        cursorArr[1] = ap.yY().hkL.a(this.isw, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
        setCursor(new MergeCursor(cursorArr));
        if (!(this.wrQ == null || this.isw == null)) {
            getCursor().getCount();
        }
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        c cVar;
        a aVar;
        a aVar2;
        CharSequence string;
        int textSize;
        int xP;
        String str;
        Object obj;
        int i3;
        com.tencent.mm.sdk.b.b qkVar;
        if (this.hBf == null) {
            this.hBf = new com.tencent.mm.ui.applet.b.b(this) {
                final /* synthetic */ a wrR;

                {
                    this.wrR = r1;
                }

                public final String fE(int i) {
                    if (i < 0 || i >= this.wrR.getCount()) {
                        w.e("MicroMsg.SearchConversationAdapter", "pos is invalid");
                        return null;
                    }
                    ae aeVar = (ae) this.wrR.getItem(i);
                    return aeVar == null ? null : aeVar.field_username;
                }

                public final int Fh() {
                    return this.wrR.getCount();
                }
            };
        }
        if (this.hBe != null) {
            this.hBe.a(i, this.hBf);
        }
        ae aeVar = (ae) getItem(i);
        if (rZ(aeVar.field_msgType) == 34 && aeVar.field_isSend == 0 && !u.mA(aeVar.field_content)) {
            String str2 = aeVar.field_content;
            if (aeVar.field_username.equals("qmessage") || aeVar.field_username.equals("floatbottle")) {
                String[] split = str2.split(":");
                if (split != null && split.length > 3) {
                    str2 = split[1] + ":" + split[2] + ":" + split[3];
                }
            }
            if (!new n(str2).iai) {
                i2 = 1;
                if (view != null) {
                    cVar = new c();
                    view = View.inflate(this.context, R.i.dnk, null);
                    cVar.ipv = (ImageView) view.findViewById(R.h.bqM);
                    cVar.jWd = (TextView) view.findViewById(R.h.cof);
                    cVar.jWe = (TextView) view.findViewById(R.h.cKN);
                    cVar.jWf = (TextView) view.findViewById(R.h.cat);
                    cVar.jWh = (TextView) view.findViewById(R.h.cIL);
                    cVar.jWh.setBackgroundResource(s.fg(this.context));
                    cVar.vvB = (ImageView) view.findViewById(R.h.bXd);
                    cVar.vvC = (ImageView) view.findViewById(R.h.cHA);
                    view.setTag(cVar);
                } else {
                    cVar = (c) view.getTag();
                }
                aVar = (a) this.vvu.get(aeVar.field_username + aeVar.field_content);
                if (aVar == null) {
                    aVar2 = new a(this);
                    aVar2.nickName = h.b(this.context, com.tencent.mm.u.n.eK(aeVar.field_username), cVar.jWd.getTextSize());
                    string = aeVar.field_status != 1 ? this.context.getString(R.l.ezo) : aeVar.field_conversationTime != Long.MAX_VALUE ? "" : com.tencent.mm.pluginsdk.j.o.c(this.context, aeVar.field_conversationTime, true);
                    aVar2.wcp = string;
                    textSize = (int) cVar.jWf.getTextSize();
                    xP = m.xP();
                    str = aeVar.field_username;
                    ap.yY();
                    obj = u.f((Integer) com.tencent.mm.u.c.vr().get(17, null)) != 1 ? 1 : null;
                    if (str.equals("qqmail") || obj != null) {
                        ap.yY();
                        ay AH = com.tencent.mm.u.c.wZ().AH("@t.qq.com");
                        obj = (AH == null && AH.isEnable()) ? 1 : null;
                        if (str.equals("tmessage") || obj != null) {
                            string = (str.equals("qmessage") || ((xP & 64) == 0 ? 1 : null) != null) ? h.c(this.context, com.tencent.mm.booter.notification.a.h.a(aeVar.field_isSend, aeVar.field_username, aeVar.field_content, rZ(aeVar.field_msgType), this.context), textSize) : this.context.getString(R.l.eTy);
                        } else {
                            string = this.context.getString(R.l.eTy);
                        }
                    } else {
                        string = this.context.getString(R.l.eTy);
                    }
                    aVar2.wcq = string;
                    if (o.dH(aeVar.field_username) && j.eC(aeVar.field_username) == 0) {
                        aVar2.nickName = this.context.getString(R.l.dVr);
                    }
                    switch (aeVar.field_status) {
                        case 0:
                            i3 = -1;
                            break;
                        case 1:
                            i3 = R.k.dxO;
                            break;
                        case 2:
                            i3 = -1;
                            break;
                        case 5:
                            i3 = R.k.dxN;
                            break;
                        default:
                            i3 = -1;
                            break;
                    }
                    aVar2.wcr = i3;
                    this.vvu.put(aeVar.field_username + aeVar.field_content, aVar2);
                    aVar = aVar2;
                }
                cVar.jWf.setTextColor(this.vvt[i2]);
                cVar.jWd.setText(aVar.nickName);
                cVar.jWe.setText(aVar.wcp);
                cVar.jWf.setText(h.b(this.context, aVar.wcq.toString(), cVar.jWf.getTextSize()));
                if (aeVar.field_conversationTime != 0) {
                    cVar.jWe.setVisibility(8);
                } else {
                    cVar.jWe.setVisibility(0);
                }
                cVar.vvB.setVisibility(8);
                if (o.dH(aeVar.field_username)) {
                    ap.yY();
                    af Rc = com.tencent.mm.u.c.wR().Rc(aeVar.field_username);
                    if (Rc != null && Rc.gkz == 0) {
                        cVar.vvB.setVisibility(0);
                    }
                }
                com.tencent.mm.pluginsdk.ui.a.b.a(cVar.ipv, aeVar.field_username);
                if (this.wbU) {
                    if (aeVar.field_unReadCount > 100) {
                        cVar.jWh.setText("...");
                        cVar.jWh.setVisibility(0);
                    } else if (aeVar.field_unReadCount <= 0) {
                        cVar.jWh.setText(aeVar.field_unReadCount);
                        cVar.jWh.setVisibility(0);
                    } else {
                        cVar.jWh.setVisibility(4);
                    }
                }
                if (ap.zb()) {
                    if (!o.a(aeVar)) {
                        ap.yY();
                        if (com.tencent.mm.u.c.wW().g(aeVar)) {
                            ap.yY();
                            com.tencent.mm.u.c.wW().f(aeVar);
                        }
                    }
                    ap.yY();
                    if (com.tencent.mm.u.c.wW().g(aeVar)) {
                        view.findViewById(R.h.bGJ).setBackgroundResource(R.g.beo);
                    } else {
                        view.findViewById(R.h.bGJ).setBackgroundResource(R.g.ben);
                    }
                }
                qkVar = new qk();
                qkVar.fXu.fXw = true;
                com.tencent.mm.sdk.b.a.urY.m(qkVar);
                if (!(0 == com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 7, 0) || aeVar.field_username.equals(qkVar.fXv.fXy))) {
                    aeVar.t(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 6, aeVar.field_conversationTime));
                    ap.yY();
                    com.tencent.mm.u.c.wW().a(aeVar, aeVar.field_username);
                }
                if (com.tencent.mm.pluginsdk.l.a.sBr == null && com.tencent.mm.pluginsdk.l.a.sBr.Hr(aeVar.field_username)) {
                    cVar.vvC.setVisibility(0);
                    if (aeVar.field_username.equals(qkVar.fXv.fXy)) {
                        cVar.vvC.setImageResource(R.k.dzR);
                    } else {
                        cVar.vvC.setImageResource(R.k.dzQ);
                    }
                } else {
                    cVar.vvC.setVisibility(8);
                }
                return view;
            }
        }
        i2 = 0;
        if (view != null) {
            cVar = (c) view.getTag();
        } else {
            cVar = new c();
            view = View.inflate(this.context, R.i.dnk, null);
            cVar.ipv = (ImageView) view.findViewById(R.h.bqM);
            cVar.jWd = (TextView) view.findViewById(R.h.cof);
            cVar.jWe = (TextView) view.findViewById(R.h.cKN);
            cVar.jWf = (TextView) view.findViewById(R.h.cat);
            cVar.jWh = (TextView) view.findViewById(R.h.cIL);
            cVar.jWh.setBackgroundResource(s.fg(this.context));
            cVar.vvB = (ImageView) view.findViewById(R.h.bXd);
            cVar.vvC = (ImageView) view.findViewById(R.h.cHA);
            view.setTag(cVar);
        }
        aVar = (a) this.vvu.get(aeVar.field_username + aeVar.field_content);
        if (aVar == null) {
            aVar2 = new a(this);
            aVar2.nickName = h.b(this.context, com.tencent.mm.u.n.eK(aeVar.field_username), cVar.jWd.getTextSize());
            if (aeVar.field_status != 1) {
                if (aeVar.field_conversationTime != Long.MAX_VALUE) {
                }
            }
            aVar2.wcp = string;
            textSize = (int) cVar.jWf.getTextSize();
            xP = m.xP();
            str = aeVar.field_username;
            ap.yY();
            if (u.f((Integer) com.tencent.mm.u.c.vr().get(17, null)) != 1) {
            }
            if (str.equals("qqmail")) {
            }
            ap.yY();
            ay AH2 = com.tencent.mm.u.c.wZ().AH("@t.qq.com");
            if (AH2 == null) {
            }
            if (str.equals("tmessage")) {
            }
            if ((xP & 64) == 0) {
            }
            if (str.equals("qmessage")) {
            }
            aVar2.wcq = string;
            aVar2.nickName = this.context.getString(R.l.dVr);
            switch (aeVar.field_status) {
                case 0:
                    i3 = -1;
                    break;
                case 1:
                    i3 = R.k.dxO;
                    break;
                case 2:
                    i3 = -1;
                    break;
                case 5:
                    i3 = R.k.dxN;
                    break;
                default:
                    i3 = -1;
                    break;
            }
            aVar2.wcr = i3;
            this.vvu.put(aeVar.field_username + aeVar.field_content, aVar2);
            aVar = aVar2;
        }
        cVar.jWf.setTextColor(this.vvt[i2]);
        cVar.jWd.setText(aVar.nickName);
        cVar.jWe.setText(aVar.wcp);
        cVar.jWf.setText(h.b(this.context, aVar.wcq.toString(), cVar.jWf.getTextSize()));
        if (aeVar.field_conversationTime != 0) {
            cVar.jWe.setVisibility(0);
        } else {
            cVar.jWe.setVisibility(8);
        }
        cVar.vvB.setVisibility(8);
        if (o.dH(aeVar.field_username)) {
            ap.yY();
            af Rc2 = com.tencent.mm.u.c.wR().Rc(aeVar.field_username);
            cVar.vvB.setVisibility(0);
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(cVar.ipv, aeVar.field_username);
        if (this.wbU) {
            if (aeVar.field_unReadCount > 100) {
                cVar.jWh.setText("...");
                cVar.jWh.setVisibility(0);
            } else if (aeVar.field_unReadCount <= 0) {
                cVar.jWh.setVisibility(4);
            } else {
                cVar.jWh.setText(aeVar.field_unReadCount);
                cVar.jWh.setVisibility(0);
            }
        }
        if (ap.zb()) {
            if (o.a(aeVar)) {
                ap.yY();
                if (com.tencent.mm.u.c.wW().g(aeVar)) {
                    ap.yY();
                    com.tencent.mm.u.c.wW().f(aeVar);
                }
            }
            ap.yY();
            if (com.tencent.mm.u.c.wW().g(aeVar)) {
                view.findViewById(R.h.bGJ).setBackgroundResource(R.g.ben);
            } else {
                view.findViewById(R.h.bGJ).setBackgroundResource(R.g.beo);
            }
        }
        qkVar = new qk();
        qkVar.fXu.fXw = true;
        com.tencent.mm.sdk.b.a.urY.m(qkVar);
        aeVar.t(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 6, aeVar.field_conversationTime));
        ap.yY();
        com.tencent.mm.u.c.wW().a(aeVar, aeVar.field_username);
        if (com.tencent.mm.pluginsdk.l.a.sBr == null) {
        }
        cVar.vvC.setVisibility(8);
        return view;
    }

    private static int rZ(String str) {
        int i = 1;
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    public final void a(String str, l lVar) {
        if (str != null && !str.equals("") && this.vvu != null) {
            this.vvu.remove(str);
        } else if (this.vvu != null) {
            this.vvu.clear();
        }
        super.a(str, lVar);
    }

    public final void yD(String str) {
        this.isw = str;
        aEW();
        OK();
    }
}
