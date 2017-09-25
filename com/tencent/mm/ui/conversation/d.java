package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.MergeCursor;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.b.af;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.j.n;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.tools.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class d extends k<ae> implements com.tencent.mm.sdk.e.m.b {
    private static long wcj = 2000;
    private String isw;
    protected List<String> jBA = null;
    protected com.tencent.mm.ui.base.MMSlideDelView.f jVY;
    protected com.tencent.mm.ui.base.MMSlideDelView.c jVZ;
    protected com.tencent.mm.ui.base.MMSlideDelView.e jWa;
    protected com.tencent.mm.ui.base.MMSlideDelView.d jWb = MMSlideDelView.bSo();
    private boolean nhO = false;
    boolean qtx = false;
    private float vvq = -1.0f;
    protected float vvr = -1.0f;
    private float vvs = -1.0f;
    private ColorStateList[] vvt = new ColorStateList[5];
    HashMap<String, d> vvu;
    private boolean wbU = true;
    private f wbV;
    private com.tencent.mm.pluginsdk.ui.d wbW;
    private boolean wbX = false;
    private boolean wbY = false;
    private boolean wbZ = false;
    private boolean wca = false;
    private c wcb;
    private com.tencent.mm.sdk.b.c wcc = null;
    private b wcd = null;
    public String wce = "";
    final e wcf = new e(this);
    private final int wcg;
    private final int wch;
    private a wci;
    private boolean wck = false;
    private aj wcl = new aj(ap.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ d wcm;

        {
            this.wcm = r1;
        }

        public final boolean oQ() {
            if (this.wcm.wck) {
                this.wcm.bYx();
            }
            return false;
        }
    }, false);

    private class a {
        public String aIO;
        public String content;
        final /* synthetic */ d wcm;
        public int wcn;
        public String wco;

        public a(d dVar) {
            this.wcm = dVar;
        }
    }

    public interface b {
    }

    private class d {
        public int knu;
        public CharSequence nickName;
        public boolean sEV;
        public boolean vCm;
        public boolean vvv;
        public int wcA;
        final /* synthetic */ d wcm;
        public CharSequence wcp;
        public CharSequence wcq;
        public int wcr;
        public int wcs;
        public int wct;
        public boolean wcu;
        public boolean wcv;
        public boolean wcw;
        public boolean wcx;
        public boolean wcy;
        public boolean wcz;

        public d(d dVar) {
            this.wcm = dVar;
        }
    }

    private class e {
        String fJL;
        boolean gUO;
        x jiL;
        Integer wcB;
        final /* synthetic */ d wcm;

        public e(d dVar) {
            this.wcm = dVar;
            this.gUO = false;
            this.fJL = null;
            this.gUO = false;
            this.jiL = null;
            this.wcB = null;
        }
    }

    public interface f {
    }

    public static class g {
        public ImageView ipv;
        public TextView jWh;
        public NoMeasuredTextView vvA;
        public ImageView vvB;
        public ImageView vvC;
        public View vvD;
        public NoMeasuredTextView vvy;
        public NoMeasuredTextView vvz;
        public NoMeasuredTextView wcC;
        public ImageView wcD;
    }

    private class c implements com.tencent.mm.sdk.e.m.b {
        final /* synthetic */ d wcm;

        public final void a(int i, m mVar, Object obj) {
            if (obj == null || !(obj instanceof String)) {
                w.d("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
                return;
            }
            String str = (String) obj;
            if (!this.wcm.wbX && str != null && !str.equals("") && this.wcm.vvu != null && this.wcm.vvu.containsKey(Integer.valueOf(i))) {
                this.wcm.vvu.remove(Integer.valueOf(i));
                this.wcm.wca = true;
            }
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ae) obj;
        if (this.nhO) {
            if (cursor.getString(0) != null && cursor.getString(0).equals("1")) {
                if (obj == null) {
                    obj = new ae();
                }
                obj.cu("");
                obj.cv("");
                obj.b(cursor);
                return obj;
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
                obj.cu("");
                obj.cv("");
                return obj;
            }
        }
        if (obj == null) {
            obj = new ae();
        }
        obj.cu("");
        obj.cv("");
        obj.b(cursor);
        return obj;
    }

    public d(Context context, com.tencent.mm.ui.k.a aVar) {
        super(context, new ae());
        this.uSN = aVar;
        this.vvt[0] = com.tencent.mm.bg.a.S(context, R.e.aUo);
        this.vvt[1] = com.tencent.mm.bg.a.S(context, R.e.aVe);
        this.vvt[3] = com.tencent.mm.bg.a.S(context, R.e.aVo);
        this.vvt[2] = com.tencent.mm.bg.a.S(context, R.e.aVc);
        this.vvt[2] = com.tencent.mm.bg.a.S(context, R.e.aVc);
        this.vvt[4] = com.tencent.mm.bg.a.S(context, R.e.aUy);
        this.vvu = new HashMap();
        if (com.tencent.mm.bg.a.dM(context)) {
            this.wch = context.getResources().getDimensionPixelSize(R.f.aWO);
            this.wcg = context.getResources().getDimensionPixelSize(R.f.aWP);
        } else {
            this.wch = context.getResources().getDimensionPixelSize(R.f.aWN);
            this.wcg = context.getResources().getDimensionPixelSize(R.f.aWQ);
        }
        this.vvq = (float) com.tencent.mm.bg.a.T(context, R.f.aXI);
        this.vvr = (float) com.tencent.mm.bg.a.T(context, R.f.aXs);
        this.vvs = (float) com.tencent.mm.bg.a.T(context, R.f.aXW);
    }

    public final void a(com.tencent.mm.ui.base.MMSlideDelView.f fVar) {
        this.jVY = fVar;
    }

    public final void a(com.tencent.mm.ui.base.MMSlideDelView.e eVar) {
        this.jWa = eVar;
    }

    public final void a(com.tencent.mm.ui.base.MMSlideDelView.c cVar) {
        this.jVZ = cVar;
    }

    public void detach() {
    }

    private CharSequence i(ae aeVar) {
        if (aeVar.field_status == 1) {
            return this.context.getString(R.l.ezo);
        }
        return aeVar.field_conversationTime == Long.MAX_VALUE ? "" : o.c(this.context, aeVar.field_conversationTime, true);
    }

    protected final void OL() {
        OK();
    }

    public final void onPause() {
        if (this.jWb != null) {
            this.jWb.aFh();
        }
        this.wbX = false;
    }

    private void bYw() {
        if (this.vvu != null) {
            for (Entry value : this.vvu.entrySet()) {
                ((d) value.getValue()).wcp = null;
            }
        }
    }

    public final void onResume() {
        boolean z = true;
        w.i("MicroMsg.ConversationAdapter", "dkpno onResume mIsFront:%b  mNeedReCreate:%b mChangedBackground:%b mContactBackground:%b", Boolean.valueOf(this.wbX), Boolean.valueOf(this.wbZ), Boolean.valueOf(this.wbY), Boolean.valueOf(this.wca));
        this.wbX = true;
        Time time = new Time();
        time.setToNow();
        String charSequence = n.a("MM/dd", time).toString();
        if (this.wce.equals(charSequence)) {
            z = false;
        }
        this.wce = charSequence;
        if (z) {
            bYw();
        }
        if (this.wbZ && this.wcd != null) {
            this.wbZ = false;
        }
        if (this.wbY || this.wca) {
            super.a(null, null);
            this.wbY = false;
            this.wca = false;
        }
    }

    public final void onDestroy() {
        this.wcl.KH();
        this.wcd = null;
        this.wcb = null;
        if (this.vvu != null) {
            this.vvu.clear();
            this.vvu = null;
        }
        aEW();
        this.uSN = null;
        detach();
    }

    public void OK() {
        w.i("MicroMsg.ConversationAdapter", "dkpno resetCursor search:%b", Boolean.valueOf(this.nhO));
        if (this.nhO) {
            Cursor[] cursorArr = new Cursor[2];
            cursorArr[0] = ap.yY().hkK.a(com.tencent.mm.u.o.hlr, this.jBA, this.isw);
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
                    w.d("MicroMsg.ConversationAdapter", "block user " + string);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.ConversationAdapter", e, "", new Object[0]);
                }
            }
            arrayList.add("officialaccounts");
            arrayList.add("helper_entry");
            cursorArr[1] = ap.yY().hkL.b(this.isw, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
            setCursor(new MergeCursor(cursorArr));
        } else {
            ap.yY();
            setCursor(com.tencent.mm.u.c.wW().a(com.tencent.mm.u.o.hlr, this.jBA, com.tencent.mm.k.a.gTS, false));
        }
        if (!(this.wbV == null || this.isw == null)) {
            getCursor().getCount();
        }
        super.notifyDataSetChanged();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        g gVar;
        View view2;
        ae aeVar = (ae) getItem(i);
        String str = aeVar.field_username;
        e eVar = this.wcf;
        eVar.fJL = str;
        eVar.jiL = null;
        eVar.wcB = null;
        eVar.gUO = false;
        if (!u.mA(str)) {
            eVar.gUO = true;
        }
        this.wci = new a(this);
        if (view == null) {
            View inflate;
            g gVar2 = new g();
            if (com.tencent.mm.bg.a.dM(this.context)) {
                inflate = View.inflate(this.context, R.i.cZN, null);
            } else {
                inflate = View.inflate(this.context, R.i.cZM, null);
            }
            gVar2.ipv = (ImageView) inflate.findViewById(R.h.bqM);
            com.tencent.mm.pluginsdk.ui.a.b.a(gVar2.ipv, str);
            com.tencent.mm.pluginsdk.ui.a aVar = (com.tencent.mm.pluginsdk.ui.a) gVar2.ipv.getDrawable();
            if (this.wbW != null) {
                this.wbW.a(aVar);
            }
            gVar2.vvy = (NoMeasuredTextView) inflate.findViewById(R.h.cof);
            gVar2.wcC = (NoMeasuredTextView) inflate.findViewById(R.h.cGc);
            gVar2.vvz = (NoMeasuredTextView) inflate.findViewById(R.h.cKN);
            gVar2.vvA = (NoMeasuredTextView) inflate.findViewById(R.h.cat);
            gVar2.jWh = (TextView) inflate.findViewById(R.h.cIL);
            gVar2.jWh.setBackgroundResource(s.fg(this.context));
            gVar2.vvB = (ImageView) inflate.findViewById(R.h.bXd);
            gVar2.vvD = inflate.findViewById(R.h.bqN);
            gVar2.vvC = (ImageView) inflate.findViewById(R.h.cHA);
            gVar2.wcD = (ImageView) inflate.findViewById(R.h.ccn);
            inflate.setTag(gVar2);
            gVar2.vvA.H(this.vvr);
            gVar2.vvz.H(this.vvs);
            gVar2.vvy.H(this.vvq);
            gVar2.wcC.H(this.vvr);
            gVar2.vvA.setTextColor(this.vvt[0]);
            gVar2.vvz.setTextColor(this.vvt[4]);
            gVar2.vvy.setTextColor(this.vvt[3]);
            gVar2.wcC.setTextColor(this.vvt[0]);
            gVar2.vvA.voV = true;
            gVar2.vvz.voV = false;
            gVar2.vvy.voV = true;
            gVar2.wcC.voV = true;
            gVar2.vvz.wa();
            gVar = gVar2;
            view2 = inflate;
        } else {
            gVar = (g) view.getTag();
            view2 = view;
        }
        d dVar = (d) this.vvu.get(str);
        if (dVar == null) {
            String str2;
            int i2;
            d dVar2 = new d(this);
            e eVar2 = this.wcf;
            if (eVar2.gUO && eVar2.jiL == null) {
                ap.yY();
                eVar2.jiL = com.tencent.mm.u.c.wR().Rc(eVar2.fJL);
            }
            af afVar = eVar2.jiL;
            if (afVar != null) {
                dVar2.wct = afVar.gkJ;
                dVar2.wcs = (int) afVar.gTQ;
            } else {
                dVar2.wct = -1;
                dVar2.wcs = -1;
            }
            dVar2.wcx = afVar != null;
            boolean z = afVar != null && afVar.tE();
            dVar2.wcz = z;
            z = afVar != null && afVar.gkz == 0;
            dVar2.wcy = z;
            dVar2.vCm = com.tencent.mm.u.o.dH(str);
            z = dVar2.vCm && dVar2.wcy && aeVar.field_unReadCount > 0;
            dVar2.wcw = z;
            dVar2.knu = 0;
            if (rZ(aeVar.field_msgType) == 34 && aeVar.field_isSend == 0 && !u.mA(aeVar.field_content)) {
                str2 = aeVar.field_content;
                if (str.equals("qmessage") || str.equals("floatbottle")) {
                    String[] split = str2.split(":");
                    if (split != null && split.length > 3) {
                        str2 = split[1] + ":" + split[2] + ":" + split[3];
                    }
                }
                if (!new com.tencent.mm.modelvoice.n(str2).iai) {
                    dVar2.knu = 1;
                }
            }
            str2 = com.tencent.mm.u.n.a(afVar, str, dVar2.vCm);
            if (dVar2.vCm && str2 == null) {
                dVar2.nickName = this.context.getString(R.l.dVr);
            } else {
                dVar2.nickName = h.b(this.context, com.tencent.mm.u.n.a(afVar, str, dVar2.vCm), gVar.vvy.gm.getTextSize());
            }
            dVar2.wcp = i(aeVar);
            dVar2.wcq = a(aeVar, (int) gVar.vvA.gm.getTextSize(), dVar2.wcw);
            dVar2.wcA = aeVar.field_attrflag;
            switch (aeVar.field_status) {
                case 0:
                    i2 = -1;
                    break;
                case 1:
                    i2 = R.k.dxO;
                    break;
                case 2:
                    i2 = -1;
                    break;
                case 5:
                    i2 = R.k.dxN;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            dVar2.wcr = i2;
            dVar2.wcu = com.tencent.mm.u.o.a(aeVar);
            ap.yY();
            dVar2.vvv = com.tencent.mm.u.c.wW().g(aeVar);
            z = afVar != null && afVar.tD();
            dVar2.wcv = z;
            dVar2.sEV = v.bIJ();
            this.vvu.put(str, dVar2);
            dVar = dVar2;
        }
        if (dVar.wcp == null) {
            dVar.wcp = i(aeVar);
        }
        if (dVar.wcw || com.tencent.mm.u.o.fu(aeVar.field_parentRef)) {
            gVar.vvA.setTextColor(this.vvt[0]);
        } else {
            gVar.vvA.setTextColor(this.vvt[dVar.knu]);
        }
        com.tencent.mm.booter.notification.a.h.dX(gVar.vvA.getWidth());
        com.tencent.mm.booter.notification.a.h.dY((int) gVar.vvA.gm.getTextSize());
        com.tencent.mm.booter.notification.a.h.a(gVar.vvA.gm);
        if (str.toLowerCase().endsWith("@t.qq.com")) {
            gVar.vvy.Ao(R.g.bfQ);
            gVar.vvy.kW(true);
        } else {
            gVar.vvy.kW(false);
        }
        int i3 = dVar.wcr;
        if (i3 != -1) {
            gVar.vvA.An(i3);
            gVar.vvA.kV(true);
        } else {
            gVar.vvA.kV(false);
        }
        gVar.vvy.setText(dVar.nickName);
        gVar.wcC.setVisibility(8);
        LayoutParams layoutParams = gVar.vvz.getLayoutParams();
        if (dVar.wcp.length() > 9) {
            if (layoutParams.width != this.wch) {
                layoutParams.width = this.wch;
                gVar.vvz.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.wcg) {
            layoutParams.width = this.wcg;
            gVar.vvz.setLayoutParams(layoutParams);
        }
        w.v("MicroMsg.ConversationAdapter", "layout update time width %d", Integer.valueOf(layoutParams.width));
        gVar.vvz.setText(dVar.wcp);
        gVar.vvA.setText(dVar.wcq);
        if (dVar.vCm && dVar.wcy) {
            gVar.vvB.setVisibility(0);
        } else if (dVar.wcv) {
            gVar.vvB.setVisibility(0);
        } else {
            gVar.vvB.setVisibility(8);
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(gVar.ipv, str);
        if (this.wbU) {
            if (aeVar == null || gVar == null || dVar == null) {
                w.w("MicroMsg.ConversationAdapter", "handle show tip cnt, but conversation or viewholder is null");
            } else {
                gVar.jWh.setVisibility(4);
                gVar.vvD.setVisibility(4);
                if (com.tencent.mm.u.o.fu(aeVar.field_username)) {
                    gVar.vvD.setVisibility(aeVar.field_unReadCount > 0 ? 0 : 4);
                    gVar.vvy.setTextColor(this.vvt[3]);
                } else {
                    NoMeasuredTextView noMeasuredTextView = gVar.vvy;
                    ColorStateList colorStateList = (dVar.wcx && dVar.wct == 1) ? this.vvt[2] : this.vvt[3];
                    noMeasuredTextView.setTextColor(colorStateList);
                    if (!dVar.wcx || dVar.wcs == 0) {
                        w.w("MicroMsg.ConversationAdapter", "handle show tip count, but talker is null");
                    } else if (com.tencent.mm.u.o.fu(aeVar.field_parentRef)) {
                        gVar.vvD.setVisibility(aeVar.field_unReadCount > 0 ? 0 : 4);
                    } else if (dVar.wcv && dVar.wcz) {
                        gVar.vvD.setVisibility(aeVar.field_unReadCount > 0 ? 0 : 4);
                    } else if (dVar.vCm && dVar.wcy) {
                        gVar.vvD.setVisibility(aeVar.field_unReadCount > 0 ? 0 : 4);
                    } else {
                        i3 = aeVar.field_unReadCount;
                        if (i3 > 99) {
                            gVar.jWh.setText(R.l.eYP);
                            gVar.jWh.setVisibility(0);
                        } else if (i3 > 0) {
                            gVar.jWh.setText(aeVar.field_unReadCount);
                            gVar.jWh.setVisibility(0);
                        }
                        this.wci.wcn = i3;
                    }
                }
            }
        }
        if (!dVar.wcu && dVar.vvv && ap.zb()) {
            ap.yY();
            com.tencent.mm.u.c.wW().f(aeVar);
        }
        if (!dVar.vvv || aeVar.field_conversationTime == -1) {
            view2.findViewById(R.h.bGJ).setBackgroundResource(R.g.beo);
        } else {
            view2.findViewById(R.h.bGJ).setBackgroundResource(R.g.ben);
        }
        com.tencent.mm.bb.d.bGP();
        com.tencent.mm.sdk.b.b qkVar = new qk();
        qkVar.fXu.fXw = true;
        com.tencent.mm.sdk.b.a.urY.m(qkVar);
        if (!(0 == com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 7, 0) || aeVar.field_username.equals(qkVar.fXv.fXy))) {
            aeVar.t(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 6, aeVar.field_conversationTime));
            ap.yY();
            com.tencent.mm.u.c.wW().a(aeVar, aeVar.field_username);
        }
        if (com.tencent.mm.pluginsdk.l.a.sBr == null || !com.tencent.mm.pluginsdk.l.a.sBr.Hr(aeVar.field_username)) {
            gVar.vvC.setVisibility(8);
        } else {
            gVar.vvC.setVisibility(0);
            if (aeVar.field_username.equals(qkVar.fXv.fXy)) {
                gVar.vvC.setImageResource(R.k.dzR);
            } else {
                gVar.vvC.setImageResource(R.k.dzQ);
            }
        }
        if (com.tencent.mm.pluginsdk.l.a.sBy == null || !com.tencent.mm.pluginsdk.l.a.sBy.zs(aeVar.field_username)) {
            gVar.wcD.setVisibility(8);
        } else {
            gVar.wcD.setVisibility(0);
        }
        this.wci.content = String.valueOf(dVar.wcq);
        this.wci.aIO = String.valueOf(dVar.nickName);
        this.wci.wco = String.valueOf(dVar.wcp);
        a aVar2 = this.wci;
        a.uWW.a(view2, aVar2.aIO, aVar2.wcn, aVar2.wco, aVar2.content);
        a(str, gVar);
        return view2;
    }

    protected void a(String str, g gVar) {
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

    private CharSequence a(ae aeVar, int i, boolean z) {
        CharSequence replace;
        if (u.mA(aeVar.field_editingMsg) || (aeVar.field_atCount > 0 && aeVar.field_unReadCount > 0)) {
            CharSequence charSequence = aeVar.field_digest;
            if (charSequence != null && charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                return new SpannableString(h.c(this.context, charSequence, (float) i));
            }
            int i2;
            String str;
            String str2 = aeVar.field_username;
            if (str2.equals("qqmail")) {
                ap.yY();
                if (u.f((Integer) com.tencent.mm.u.c.vr().get(17, null)) == 1) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i2 == 0) {
                    return this.context.getString(R.l.eTy);
                }
            }
            if (str2.equals("tmessage")) {
                ap.yY();
                ay AH = com.tencent.mm.u.c.wZ().AH("@t.qq.com");
                if (AH == null || !AH.isEnable()) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                if (i2 == 0) {
                    return this.context.getString(R.l.eTy);
                }
            }
            if (aeVar.field_msgType != null && (aeVar.field_msgType.equals("47") || aeVar.field_msgType.equals("1048625"))) {
                str2 = Tj(aeVar.field_digest);
                str = "";
                if (str2 != null) {
                    return "[" + str2 + "]";
                }
                if (aeVar.field_digest != null && aeVar.field_digest.contains(":")) {
                    str = aeVar.field_digest.substring(0, aeVar.field_digest.indexOf(":"));
                    str2 = Tj(aeVar.field_digest.substring(aeVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                    if (str2 != null) {
                        str2 = "[" + str2 + "]";
                        return u.mA(str) ? str2 : str + ": " + str2;
                    }
                }
                str2 = this.context.getString(R.l.dGL);
                aeVar.cu(u.mA(str) ? str2 : str + ": " + str2);
            }
            if (!u.mA(aeVar.field_digest)) {
                if (u.mA(aeVar.field_digestUser)) {
                    str = aeVar.field_digest;
                } else {
                    str = (aeVar.field_isSend == 0 && com.tencent.mm.u.o.dH(aeVar.field_username)) ? com.tencent.mm.u.n.E(aeVar.field_digestUser, aeVar.field_username) : com.tencent.mm.u.n.eK(aeVar.field_digestUser);
                    try {
                        str = String.format(aeVar.field_digest, new Object[]{str});
                    } catch (Exception e) {
                    }
                }
                replace = str.replace('\n', ' ');
                if (aeVar.field_atCount > 0 || aeVar.field_unReadCount <= 0) {
                    if (!z && aeVar.field_unReadCount > 1) {
                        replace = this.context.getString(R.l.eyU, new Object[]{Integer.valueOf(aeVar.field_unReadCount), replace});
                    } else if (aeVar.field_unReadCount > 1 && com.tencent.mm.u.o.fu(aeVar.field_parentRef)) {
                        replace = this.context.getString(R.l.eyU, new Object[]{Integer.valueOf(aeVar.field_unReadCount), replace});
                    }
                    return h.c(this.context, replace, i);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.context.getString(R.l.eyR));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder.append(" ").append(h.c(this.context, replace, i));
                return spannableStringBuilder;
            }
            str = com.tencent.mm.booter.notification.a.h.a(aeVar.field_isSend, aeVar.field_username, aeVar.field_content, rZ(aeVar.field_msgType), this.context);
            replace = str.replace('\n', ' ');
            if (aeVar.field_atCount > 0) {
            }
            if (!z) {
            }
            replace = this.context.getString(R.l.eyU, new Object[]{Integer.valueOf(aeVar.field_unReadCount), replace});
            return h.c(this.context, replace, i);
        }
        replace = new SpannableStringBuilder(this.context.getString(R.l.eyV));
        replace.setSpan(new ForegroundColorSpan(-5569532), 0, replace.length(), 33);
        replace.append(" ").append(h.c(this.context, aeVar.field_editingMsg, i));
        return replace;
    }

    private static String Tj(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ue(str);
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            w.e("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
            return;
        }
        a((String) obj, null);
    }

    public final void a(String str, l lVar) {
        w.i("MicroMsg.ConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", Boolean.valueOf(this.wbX), Boolean.valueOf(this.wbY), str);
        if (!(u.mA(str) || this.vvu == null)) {
            this.vvu.remove(str);
        }
        if (this.wbX) {
            w.d("MicroMsg.ConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", Boolean.valueOf(this.wck), Boolean.valueOf(this.wcl.bJq()));
            this.wck = true;
            if (this.wcl.bJq()) {
                bYx();
                return;
            }
            return;
        }
        this.wbY = true;
    }

    private void bYx() {
        com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
            final /* synthetic */ d wcm;

            {
                this.wcm = r1;
            }

            public final void run() {
                if (ap.zb()) {
                    long Nz = u.Nz();
                    super.a(null, null);
                    w.d("MicroMsg.ConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", Long.valueOf(u.aA(Nz) * 3), Long.valueOf(d.wcj), Boolean.valueOf(this.wcm.wck));
                    d.wcj = (Nz + d.wcj) / 2;
                    this.wcm.wck = false;
                    aj f = this.wcm.wcl;
                    long bYy = d.wcj;
                    f.v(bYy, bYy);
                    return;
                }
                this.wcm.wcl.KH();
                w.e("MicroMsg.ConversationAdapter", "dkpno handleDataChange acc has not ready");
            }
        });
    }
}
