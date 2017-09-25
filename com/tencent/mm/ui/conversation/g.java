package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.j.n;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.j;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.tools.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class g extends com.tencent.mm.ui.e<String, ae> implements com.tencent.mm.sdk.e.m.b {
    protected List<String> jBA = null;
    protected com.tencent.mm.ui.base.MMSlideDelView.f jVY;
    protected com.tencent.mm.ui.base.MMSlideDelView.c jVZ;
    protected com.tencent.mm.ui.base.MMSlideDelView.d jWb = MMSlideDelView.bSo();
    boolean neO = false;
    private boolean nhO = false;
    boolean qtx = false;
    public boolean vJy = false;
    private float vvq = -1.0f;
    private float vvr = -1.0f;
    private float vvs = -1.0f;
    private ColorStateList[] vvt = new ColorStateList[5];
    HashMap<String, d> vvu;
    private boolean wbU = true;
    com.tencent.mm.pluginsdk.ui.d wbW;
    private boolean wbZ = false;
    private boolean wcV = false;
    private qk wcW = null;
    b wcX = null;
    private HashSet<String> wcY;
    private boolean wcZ = false;
    com.tencent.mm.sdk.b.c wcc = null;
    public String wce = "";
    private final int wcg;
    private final int wch;
    HashMap<String, Integer> wda = new HashMap();
    private HashMap<String, Integer> wdb = new HashMap();
    boolean wdc = false;
    HashSet<String> wdd;
    boolean wde = false;
    private boolean wdf = false;
    public String wdg = "";
    final e wdh = new e(this);
    private float wdi = -1.0f;
    private a wdj;
    private long wdk = 0;

    private class a {
        public String aIO;
        public String content;
        public int wcn;
        public String wco;
        final /* synthetic */ g wdl;

        public a(g gVar) {
            this.wdl = gVar;
        }
    }

    public interface b {
        void bYC();
    }

    class c {
        public View jWi = null;
        public TextView jWj = null;
        String username = "";
        public View vlB = null;
        final /* synthetic */ g wdl;
        boolean wdm = false;
        boolean wdn = false;
        boolean wdo = false;
        boolean wdp = false;
        boolean wdq = false;
        public ImageView wdr = null;
        public TextView wds = null;
        public View wdt = null;

        c(g gVar) {
            this.wdl = gVar;
        }
    }

    private class d {
        public String gMX;
        public int knu;
        public CharSequence nickName;
        public boolean vCm;
        public boolean vvv;
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
        final /* synthetic */ g wdl;

        public d(g gVar) {
            this.wdl = gVar;
        }
    }

    private class e {
        private String fJL;
        private boolean gUO;
        private x jiL;
        private Integer wcB;
        final /* synthetic */ g wdl;

        public e(g gVar) {
            this.wdl = gVar;
            this.gUO = false;
            this.fJL = null;
            this.gUO = false;
            this.jiL = null;
            this.wcB = null;
        }

        public final void cH(String str) {
            this.fJL = str;
            this.jiL = null;
            this.wcB = null;
            this.gUO = false;
            if (!u.mA(str)) {
                this.gUO = true;
            }
        }

        public final x bYD() {
            if (this.gUO && this.jiL == null && ap.zb()) {
                ap.yY();
                this.jiL = com.tencent.mm.u.c.wR().Rc(this.fJL);
            }
            return this.jiL;
        }
    }

    public static class f {
        public ImageView ipv;
        public TextView jWh;
        public NoMeasuredTextView vvA;
        public ImageView vvB;
        public ImageView vvC;
        public View vvD;
        public NoMeasuredTextView vvy;
        public NoMeasuredTextView vvz;
        public ImageView wcD;
        public ImageView wdu;
        public ImageView wdv;
        public c wdw;
    }

    public final /* synthetic */ com.tencent.mm.bj.a.a bNP() {
        return new ae();
    }

    public g(Context context, com.tencent.mm.ui.e.a aVar) {
        super(context, (byte) 0);
        super.a(aVar);
        this.vvt[0] = com.tencent.mm.bg.a.S(context, R.e.aUo);
        this.vvt[1] = com.tencent.mm.bg.a.S(context, R.e.aVe);
        this.vvt[3] = com.tencent.mm.bg.a.S(context, R.e.aVo);
        this.vvt[2] = com.tencent.mm.bg.a.S(context, R.e.aVc);
        this.vvt[2] = com.tencent.mm.bg.a.S(context, R.e.aVc);
        this.vvt[4] = com.tencent.mm.bg.a.S(context, R.e.aUy);
        if (com.tencent.mm.bg.a.dM(context)) {
            this.wch = context.getResources().getDimensionPixelSize(R.f.aWO);
            this.wcg = context.getResources().getDimensionPixelSize(R.f.aWP);
        } else {
            this.wch = context.getResources().getDimensionPixelSize(R.f.aWN);
            this.wcg = context.getResources().getDimensionPixelSize(R.f.aWQ);
        }
        this.vvu = new HashMap();
        this.wcY = new HashSet();
        this.wdd = new HashSet();
        this.vvq = context.getResources().getDimension(R.f.aXI);
        this.vvr = context.getResources().getDimension(R.f.aXs);
        this.vvs = context.getResources().getDimension(R.f.aXW);
        this.jBA = new ArrayList();
        this.jBA.add("qmessage");
    }

    public final void a(com.tencent.mm.ui.base.MMSlideDelView.f fVar) {
        this.jVY = fVar;
    }

    public final void a(com.tencent.mm.ui.base.MMSlideDelView.c cVar) {
        this.jVZ = cVar;
    }

    private CharSequence i(ae aeVar) {
        if (aeVar.field_status == 1) {
            return this.context.getString(R.l.ezo);
        }
        return aeVar.field_conversationTime == Long.MAX_VALUE ? "" : o.c(this.context, aeVar.field_conversationTime, true);
    }

    public final void bXK() {
        boolean z = true;
        if (this.jBA == null) {
            this.jBA = new ArrayList();
        }
        this.jBA.clear();
        boolean z2 = (m.xP() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0;
        boolean yc = m.yc();
        if (!(z2 && yc)) {
            z = false;
        }
        if (z != this.wdf) {
            if (z) {
                ap.yY();
                a(5, (com.tencent.mm.sdk.e.m) com.tencent.mm.u.c.wW(), (Object) "floatbottle");
            } else {
                ap.yY();
                a(2, (com.tencent.mm.sdk.e.m) com.tencent.mm.u.c.wW(), (Object) "floatbottle");
            }
            this.wdf = z;
        }
        if (this.wdf) {
            this.jBA.add("floatbottle");
        }
        this.jBA.add("qmessage");
    }

    public final void onPause() {
        w.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onPause  hasResume " + this.vJy);
        if (this.vJy) {
            this.vJy = false;
            super.pause();
            if (this.jWb != null) {
                this.jWb.aFh();
            }
        }
    }

    private void bYw() {
        if (this.vvu != null) {
            for (Entry value : this.vvu.entrySet()) {
                ((d) value.getValue()).wcp = null;
            }
        }
    }

    public final void onResume() {
        w.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onResume  hasResume " + this.vJy);
        if (!this.vJy) {
            boolean z;
            this.vJy = true;
            bXK();
            bYB();
            w.i(this.TAG, "newcursor resume syncNow ");
            this.uOF = true;
            kg(true);
            Time time = new Time();
            time.setToNow();
            String charSequence = n.a("MM/dd", time).toString();
            String bIN = v.bIN();
            if (this.wce.equals(charSequence) && this.wdg.equals(bIN)) {
                z = false;
            } else {
                z = true;
            }
            this.wce = charSequence;
            this.wdg = bIN;
            if (z) {
                bYw();
            }
            if (this.wbZ && this.wcX != null) {
                this.wcX.bYC();
                this.wbZ = false;
                super.o(null, 1);
            }
            this.wcW = new qk();
            this.wcW.fXu.fXw = true;
            com.tencent.mm.sdk.b.a.urY.m(this.wcW);
        }
    }

    public final void bYA() {
        super.o(null, 1);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        View view2;
        f fVar;
        this.wdj = new a(this);
        ae aeVar = (ae) yQ(i);
        String str = aeVar.field_username;
        this.wdh.cH(str);
        if (!this.wda.containsKey(str)) {
            this.wda.put(str, Integer.valueOf(i));
        } else if (i != ((Integer) this.wda.get(str)).intValue()) {
            SparseArray[] bOP = bOP();
            HashMap bNK = this.uOG == null ? null : this.uOG.uMI.bNK();
            StringBuffer stringBuffer = new StringBuffer();
            for (SparseArray sparseArray : bOP) {
                i2 = 0;
                while (i2 < sparseArray.size() && i2 < 50) {
                    stringBuffer.append("[");
                    stringBuffer.append(i2);
                    stringBuffer.append(",");
                    stringBuffer.append(sparseArray.keyAt(i2));
                    stringBuffer.append(",");
                    stringBuffer.append((String) sparseArray.valueAt(i2));
                    stringBuffer.append("]");
                    i2++;
                }
            }
            stringBuffer.append("\n");
            if (bNK != null) {
                i2 = 0;
                for (Entry entry : bNK.entrySet()) {
                    if (i2 >= 50) {
                        break;
                    }
                    i2++;
                    stringBuffer.append("[");
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append(",");
                    if (entry.getValue() != null) {
                        stringBuffer.append(((ae) entry.getValue()).field_username);
                    }
                    stringBuffer.append("]");
                }
                stringBuffer.append("\n");
            }
            String str2 = "MicroMsg.ConversationWithCacheAdapter";
            String str3 = "Get Item duplicated: positionMaps: %s username [%s, %d] Map: %s datas: %d";
            Object[] objArr = new Object[5];
            objArr[0] = stringBuffer.toString();
            objArr[1] = str;
            objArr[2] = Integer.valueOf(i);
            objArr[3] = this.wda.toString();
            objArr[4] = Integer.valueOf(bNK != null ? bNK.size() : 0);
            w.i(str2, str3, objArr);
            if (!this.wcZ) {
                com.tencent.mm.plugin.fts.a.e.mQ(20);
                this.wcZ = true;
            }
            if (System.currentTimeMillis() - this.wdk > 3600000) {
                super.o(null, 1);
                this.wdk = System.currentTimeMillis();
            }
        }
        if (view == null) {
            View inflate;
            f fVar2 = new f();
            if (com.tencent.mm.bg.a.dM(this.context)) {
                inflate = View.inflate(this.context, R.i.cZP, null);
            } else if (com.tencent.mm.bg.a.dN(this.context)) {
                inflate = View.inflate(this.context, R.i.cZQ, null);
            } else {
                inflate = View.inflate(this.context, R.i.cZO, null);
            }
            fVar2.ipv = (ImageView) inflate.findViewById(R.h.bqM);
            com.tencent.mm.pluginsdk.ui.a.b.a(fVar2.ipv, str);
            com.tencent.mm.pluginsdk.ui.a aVar = (com.tencent.mm.pluginsdk.ui.a) fVar2.ipv.getDrawable();
            if (this.wbW != null) {
                this.wbW.a(aVar);
            }
            fVar2.vvy = (NoMeasuredTextView) inflate.findViewById(R.h.cof);
            fVar2.vvz = (NoMeasuredTextView) inflate.findViewById(R.h.cKN);
            fVar2.wdu = (ImageView) inflate.findViewById(R.h.cau);
            fVar2.vvA = (NoMeasuredTextView) inflate.findViewById(R.h.cat);
            fVar2.jWh = (TextView) inflate.findViewById(R.h.cIL);
            fVar2.vvB = (ImageView) inflate.findViewById(R.h.bXd);
            fVar2.vvD = inflate.findViewById(R.h.bqN);
            fVar2.vvC = (ImageView) inflate.findViewById(R.h.cHA);
            fVar2.wcD = (ImageView) inflate.findViewById(R.h.ccn);
            fVar2.wdv = (ImageView) inflate.findViewById(R.h.clJ);
            fVar2.jWh.setBackgroundResource(s.fg(this.context));
            fVar2.wdw = new c(this);
            inflate.setTag(fVar2);
            fVar2.vvA.H((float) com.tencent.mm.bg.a.T(this.context, R.f.aXU));
            fVar2.vvz.H((float) com.tencent.mm.bg.a.T(this.context, R.f.aXW));
            fVar2.vvy.H((float) com.tencent.mm.bg.a.T(this.context, R.f.aXI));
            this.wdi = fVar2.vvy.gm.getTextSize();
            fVar2.vvA.setTextColor(this.vvt[0]);
            fVar2.vvz.setTextColor(this.vvt[4]);
            fVar2.vvy.setTextColor(this.vvt[3]);
            fVar2.vvA.voV = true;
            fVar2.vvz.voV = false;
            fVar2.vvy.voV = true;
            fVar2.vvz.wa();
            view2 = inflate;
            fVar = fVar2;
        } else {
            fVar = (f) view.getTag();
            view2 = view;
        }
        d j = j(aeVar);
        if (j.wcq == null) {
            j.wcq = b(aeVar, (int) fVar.vvA.gm.getTextSize(), j.wcw);
        }
        if (j.wcp == null) {
            j.wcp = i(aeVar);
        }
        if (j.wcw) {
            fVar.vvA.setTextColor(this.vvt[0]);
        } else {
            fVar.vvA.setTextColor(this.vvt[j.knu]);
        }
        h.dX(fVar.vvA.getWidth());
        h.dY((int) fVar.vvA.gm.getTextSize());
        h.a(fVar.vvA.gm);
        if (str.toLowerCase().endsWith("@t.qq.com")) {
            fVar.vvy.Ao(R.g.bfQ);
            fVar.vvy.kW(true);
        } else {
            fVar.vvy.kW(false);
        }
        i2 = j.wcr;
        if (i2 != -1) {
            fVar.vvA.An(i2);
            fVar.vvA.kV(true);
            w.i("MicroMsg.ConversationWithCacheAdapter", "userName:%s, status:%d", str, Integer.valueOf(j.wcr));
        } else {
            fVar.vvA.kV(false);
            fVar.vvA.invalidate();
        }
        fVar.vvy.setText(j.nickName);
        LayoutParams layoutParams = fVar.vvz.getLayoutParams();
        if (j.wcp.length() >= 9) {
            if (layoutParams.width != this.wch) {
                layoutParams.width = this.wch;
                fVar.vvz.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.wcg) {
            layoutParams.width = this.wcg;
            fVar.vvz.setLayoutParams(layoutParams);
        }
        fVar.vvz.setText(j.wcp);
        fVar.vvA.setText(j.wcq);
        fVar.wdu.setVisibility(8);
        fVar.vvB.setVisibility(8);
        if (j.vCm) {
            if (j.wcy) {
                fVar.vvB.setVisibility(0);
            }
        } else if (j.wcv) {
            fVar.vvB.setVisibility(0);
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(fVar.ipv, str);
        if (this.wbU) {
            if (aeVar == null || fVar == null || j == null) {
                w.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip cnt, but conversation or viewholder is null");
            } else {
                fVar.jWh.setVisibility(4);
                fVar.vvD.setVisibility(4);
                ColorStateList colorStateList = (!com.tencent.mm.u.o.eR(aeVar.field_username) && j.wcx && (j.wct == 1 || j.wct == 2 || j.wct == 3)) ? this.vvt[2] : this.vvt[3];
                fVar.vvy.setTextColor(colorStateList);
                if (!j.wcx || j.wcs == 0) {
                    w.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip count, but talker is null");
                } else {
                    i2 = a(aeVar, j);
                    if (i2 == 1) {
                        fVar.vvD.setVisibility(0);
                    } else if (i2 == 2) {
                        i2 = aeVar.field_unReadCount;
                        if (i2 > 99) {
                            fVar.jWh.setText(R.l.eYP);
                            fVar.jWh.setVisibility(0);
                        } else if (i2 > 0) {
                            fVar.jWh.setText(aeVar.field_unReadCount);
                            fVar.jWh.setVisibility(0);
                        }
                        this.wdj.wcn = i2;
                    }
                }
            }
        }
        if (!j.wcu && j.vvv && ap.zb()) {
            ap.yY();
            com.tencent.mm.u.c.wW().f(aeVar);
        }
        if (!j.vvv || aeVar.field_conversationTime == -1) {
            view2.findViewById(R.h.bGJ).setBackgroundResource(R.g.beo);
        } else {
            view2.findViewById(R.h.bGJ).setBackgroundResource(R.g.ben);
        }
        if (VERSION.SDK_INT >= 21) {
            view2.findViewById(R.h.bGJ).setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ g wdl;

                {
                    this.wdl = r1;
                }

                @TargetApi(21)
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    view.findViewById(R.h.bGJ).getBackground().setHotspot(motionEvent.getX(), motionEvent.getY());
                    return false;
                }
            });
        }
        com.tencent.mm.bb.d.bGP();
        if (!(0 == com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 7, 0) || aeVar.field_username.equals(this.wcW.fXv.fXy))) {
            aeVar.t(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 6, aeVar.field_conversationTime));
            ap.yY();
            com.tencent.mm.u.c.wW().a(aeVar, aeVar.field_username);
        }
        if (com.tencent.mm.pluginsdk.l.a.sBr == null || !com.tencent.mm.pluginsdk.l.a.sBr.Hr(aeVar.field_username)) {
            fVar.vvC.setVisibility(8);
        } else {
            fVar.vvC.setVisibility(0);
            if (aeVar.field_username.equals(this.wcW.fXv.fXy)) {
                fVar.vvC.setImageResource(R.k.dzR);
            } else {
                fVar.vvC.setImageResource(R.k.dzQ);
            }
        }
        if (com.tencent.mm.pluginsdk.l.a.sBy == null || !com.tencent.mm.pluginsdk.l.a.sBy.zs(aeVar.field_username)) {
            fVar.wcD.setVisibility(8);
        } else {
            fVar.wcD.setVisibility(0);
        }
        if (com.tencent.mm.u.o.dH(aeVar.field_username) && com.tencent.mm.pluginsdk.l.a.sBz != null && com.tencent.mm.pluginsdk.l.a.sBz.Ba(aeVar.field_username)) {
            if (com.tencent.mm.pluginsdk.l.a.sBz.aMO() && com.tencent.mm.pluginsdk.l.a.sBz.cS(aeVar.field_username, m.xL())) {
                fVar.wdv.setImageResource(R.k.dvD);
            } else {
                fVar.wdv.setImageResource(R.k.dvE);
            }
            fVar.wdv.setVisibility(0);
        } else {
            fVar.wdv.setVisibility(8);
        }
        this.wdj.content = String.valueOf(j.wcq);
        this.wdj.aIO = j.gMX;
        this.wdj.wco = String.valueOf(j.wcp);
        a aVar2 = this.wdj;
        a.uWW.a(view2, aVar2.aIO, aVar2.wcn, aVar2.wco, aVar2.content);
        return view2;
    }

    final d j(ae aeVar) {
        boolean z = true;
        String str = aeVar.field_username;
        d dVar = (d) this.vvu.get(str);
        if (dVar != null) {
            return dVar;
        }
        boolean z2;
        int i;
        d dVar2 = new d(this);
        this.wdh.cH(str);
        af bYD = this.wdh.bYD();
        if (bYD != null) {
            dVar2.wct = bYD.gkJ;
            dVar2.wcs = (int) bYD.gTQ;
        } else {
            dVar2.wct = -1;
            dVar2.wcs = -1;
        }
        if (bYD != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        dVar2.wcx = z2;
        if (bYD == null || !bYD.tE()) {
            z2 = false;
        } else {
            z2 = true;
        }
        dVar2.wcz = z2;
        if (bYD == null || bYD.gkz != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        dVar2.wcy = z2;
        dVar2.vCm = com.tencent.mm.u.o.dH(str);
        if (dVar2.vCm && dVar2.wcy && aeVar.field_unReadCount > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        dVar2.wcw = z2;
        dVar2.knu = 0;
        if (rZ(aeVar.field_msgType) == 34 && aeVar.field_isSend == 0 && !u.mA(aeVar.field_content)) {
            String str2 = aeVar.field_content;
            if (str.equals("qmessage") || str.equals("floatbottle") || str.equals("officialaccounts") || aeVar.eC(2097152) || aeVar.eC(8388608)) {
                String[] split = str2.split(":");
                if (split != null && split.length > 3) {
                    str2 = split[1] + ":" + split[2] + ":" + split[3];
                }
            }
            if (!new com.tencent.mm.modelvoice.n(str2).iai) {
                dVar2.knu = 1;
            }
        }
        dVar2.gMX = com.tencent.mm.u.n.a(bYD, str, dVar2.vCm);
        a(dVar2);
        dVar2.wcp = i(aeVar);
        switch (aeVar.field_status) {
            case 0:
                i = -1;
                break;
            case 1:
            case 8:
                i = R.k.dxO;
                break;
            case 2:
                i = -1;
                break;
            case 5:
                i = R.k.dxN;
                break;
            default:
                i = -1;
                break;
        }
        dVar2.wcr = i;
        dVar2.wcu = com.tencent.mm.u.o.a(aeVar);
        ap.yY();
        dVar2.vvv = com.tencent.mm.u.c.wW().g(aeVar);
        if (bYD == null || !bYD.tD()) {
            z = false;
        }
        dVar2.wcv = z;
        this.vvu.put(str, dVar2);
        return dVar2;
    }

    private void a(d dVar) {
        if (dVar.vCm && dVar.gMX == null) {
            dVar.nickName = this.context.getString(R.l.dVr);
        } else {
            dVar.nickName = com.tencent.mm.pluginsdk.ui.d.h.c(this.context, dVar.gMX, com.tencent.mm.bg.a.T(this.context, R.f.aXI));
        }
    }

    static int a(ae aeVar, d dVar) {
        if (aeVar == null || aeVar.field_unReadCount <= 0) {
            if (aeVar == null || ((!aeVar.eC(8388608) && !aeVar.eC(2097152)) || aeVar == null || aeVar.field_unReadMuteCount <= 0)) {
                return 0;
            }
            return 1;
        } else if (com.tencent.mm.u.o.fu(aeVar.field_username)) {
            return 1;
        } else {
            if (com.tencent.mm.u.o.fz(aeVar.field_username)) {
                ap.yY();
                if (!com.tencent.mm.u.c.vr().c(com.tencent.mm.storage.w.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                    return 1;
                }
            }
            if (com.tencent.mm.u.o.fD(aeVar.field_username)) {
                ap.yY();
                if (!com.tencent.mm.u.c.vr().c(com.tencent.mm.storage.w.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                    return 1;
                }
            }
            if (dVar.wcv && dVar.wcz) {
                return 1;
            }
            if (dVar.vCm && dVar.wcy) {
                return 1;
            }
            return 2;
        }
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

    public final void clearCache() {
        if (this.vvu != null) {
            this.vvu.clear();
            this.wde = true;
        }
    }

    private CharSequence b(ae aeVar, int i, boolean z) {
        CharSequence string;
        if (u.mA(aeVar.field_editingMsg) || (aeVar.field_atCount > 0 && (aeVar.field_unReadCount > 0 || aeVar.field_unReadMuteCount > 0))) {
            String eK;
            if (rZ(aeVar.field_msgType) == 10000) {
                boolean fu = com.tencent.mm.u.o.fu(aeVar.field_username);
                if (!fu) {
                    fu = aeVar.eC(2097152);
                }
                if (!fu) {
                    fu = aeVar.eC(8388608);
                }
                if (!fu) {
                    fu = aeVar.eC(16777216);
                }
                if (!fu) {
                    fu = com.tencent.mm.u.o.fD(aeVar.field_username);
                }
                if (!fu) {
                    return new SpannableString(com.tencent.mm.pluginsdk.ui.d.h.g(this.context, aeVar.field_content, i));
                }
            }
            if (rZ(aeVar.field_msgType) == 49) {
                eK = com.tencent.mm.u.n.eK(aeVar.field_digestUser);
                com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(aeVar.field_content);
                if (ek != null && ek.type == 40 && j.eo(aeVar.field_content).hkp == 19) {
                    string = u.mA(eK) ? this.context.getString(R.l.dIr) : eK + ": " + this.context.getString(R.l.dIr);
                    aeVar.cu(string);
                    return string;
                }
            }
            CharSequence charSequence = aeVar.field_digest;
            if (charSequence != null && charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                return new SpannableString(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, charSequence, (float) i));
            }
            int i2;
            String str = aeVar.field_username;
            if (str.equals("qqmail")) {
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
            if (str.equals("tmessage")) {
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
            if (aeVar.field_msgType != null && aeVar.field_msgType.equals("64")) {
                return aeVar.field_content;
            }
            CharSequence charSequence2;
            SpannableStringBuilder spannableStringBuilder;
            if (aeVar.field_msgType != null && (aeVar.field_msgType.equals("47") || aeVar.field_msgType.equals("1048625"))) {
                str = Tj(aeVar.field_digest);
                eK = "";
                if (!u.mA(str)) {
                    return "[" + str + "]";
                }
                if (aeVar.field_digest != null && aeVar.field_digest.contains(":")) {
                    eK = aeVar.field_digest.substring(0, aeVar.field_digest.indexOf(":"));
                    str = Tj(aeVar.field_digest.substring(aeVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                    if (!u.mA(str)) {
                        charSequence2 = "[" + str + "]";
                        if (u.mA(eK)) {
                            return com.tencent.mm.pluginsdk.ui.d.h.c(this.context, (CharSequence) eK, i);
                        }
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                        spannableStringBuilder2.append(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, (CharSequence) eK, i));
                        spannableStringBuilder2.append(": ");
                        spannableStringBuilder2.append(charSequence2);
                        return spannableStringBuilder2;
                    }
                }
                str = this.context.getString(R.l.dGL);
                aeVar.cu(u.mA(eK) ? str : eK + ": " + str);
            }
            if (!u.mA(aeVar.field_digest)) {
                if (u.mA(aeVar.field_digestUser)) {
                    eK = aeVar.field_digest;
                } else {
                    eK = (aeVar.field_isSend == 0 && com.tencent.mm.u.o.dH(aeVar.field_username)) ? com.tencent.mm.u.n.E(aeVar.field_digestUser, aeVar.field_username) : com.tencent.mm.u.n.eK(aeVar.field_digestUser);
                    try {
                        eK = String.format(aeVar.field_digest, new Object[]{eK});
                    } catch (Exception e) {
                    }
                }
                charSequence = eK.replace('\n', ' ');
                if (aeVar.field_UnReadInvite <= 0) {
                    spannableStringBuilder = new SpannableStringBuilder(aeVar.field_UnReadInvite >= Downloads.RECV_BUFFER_SIZE ? this.context.getString(R.l.eyS, new Object[]{Integer.valueOf(aeVar.field_UnReadInvite)}) : this.context.getString(R.l.eyQ));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                    spannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, charSequence, i));
                    return spannableStringBuilder;
                } else if (aeVar.field_atCount <= 0 && (aeVar.field_unReadCount > 0 || aeVar.field_unReadMuteCount > 0)) {
                    spannableStringBuilder = new SpannableStringBuilder(this.context.getString(aeVar.field_atCount < Downloads.RECV_BUFFER_SIZE ? R.l.eyR : R.l.eyT));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                    spannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, charSequence, i));
                    return spannableStringBuilder;
                } else if (aeVar.eC(16777216) || (aeVar.field_unReadCount <= 0 && aeVar.field_unReadMuteCount <= 0)) {
                    if (z || (aeVar.field_unReadCount <= 1 && aeVar.field_unReadMuteCount <= 0)) {
                        string = charSequence;
                    } else {
                        string = this.context.getString(R.l.eyU, new Object[]{Integer.valueOf(aeVar.field_unReadCount), charSequence});
                    }
                    return com.tencent.mm.pluginsdk.ui.d.h.c(this.context, string, i);
                } else {
                    charSequence2 = this.context.getString(R.l.dAY);
                    charSequence = charSequence.replace(charSequence2, "");
                    string = new SpannableStringBuilder(charSequence2);
                    string.setSpan(new ForegroundColorSpan(-5569532), 0, string.length(), 33);
                    string.append(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, charSequence, i));
                    return string;
                }
            }
            eK = h.a(aeVar.field_isSend, aeVar.field_username, aeVar.field_content, rZ(aeVar.field_msgType), this.context);
            charSequence = eK.replace('\n', ' ');
            if (aeVar.field_UnReadInvite <= 0) {
                if (aeVar.field_atCount <= 0) {
                }
                if (aeVar.eC(16777216)) {
                }
                if (z) {
                }
                string = charSequence;
                return com.tencent.mm.pluginsdk.ui.d.h.c(this.context, string, i);
            }
            if (aeVar.field_UnReadInvite >= Downloads.RECV_BUFFER_SIZE) {
            }
            spannableStringBuilder = new SpannableStringBuilder(aeVar.field_UnReadInvite >= Downloads.RECV_BUFFER_SIZE ? this.context.getString(R.l.eyS, new Object[]{Integer.valueOf(aeVar.field_UnReadInvite)}) : this.context.getString(R.l.eyQ));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, charSequence, i));
            return spannableStringBuilder;
        }
        string = new SpannableStringBuilder(this.context.getString(R.l.eyV));
        string.setSpan(new ForegroundColorSpan(-5569532), 0, string.length(), 33);
        string.append(" ").append(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, aeVar.field_editingMsg, i));
        return string;
    }

    private static String Tj(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ue(str);
    }

    public final com.tencent.mm.bj.a.d bOO() {
        w.d("MicroMsg.ConversationWithCacheAdapter", "createCursor");
        ap.yY();
        return (com.tencent.mm.bj.a.d) com.tencent.mm.u.c.wW().a(com.tencent.mm.u.o.hlr, this.jBA, com.tencent.mm.k.a.gTS, true);
    }

    public final ArrayList<ae> ai(ArrayList<String> arrayList) {
        w.d("MicroMsg.ConversationWithCacheAdapter", "rebulidAllChangeData obj.size() %d", Integer.valueOf(arrayList.size()));
        ArrayList<ae> arrayList2 = new ArrayList(arrayList.size());
        ap.yY();
        Cursor a = com.tencent.mm.u.c.wW().a((ArrayList) arrayList, com.tencent.mm.u.o.hlr, this.jBA, com.tencent.mm.k.a.gTS);
        while (a.moveToNext()) {
            ae aeVar = new ae();
            aeVar.b(a);
            arrayList2.add(aeVar);
        }
        a.close();
        return arrayList2;
    }

    public final SparseArray<String>[] a(HashSet<com.tencent.mm.ui.e.b<String, ae>> hashSet, SparseArray<String>[] sparseArrayArr) {
        if (sparseArrayArr != null && sparseArrayArr.length > 0) {
            com.tencent.mm.ui.e.b bVar;
            w.d("MicroMsg.ConversationWithCacheAdapter", "refreshPosistion events size %d oldPosistion size %d", Integer.valueOf(hashSet.size()), Integer.valueOf(sparseArrayArr[0].size()));
            ArrayList arrayList = new ArrayList();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                bVar = (com.tencent.mm.ui.e.b) it.next();
                if (!(bVar == null || bVar.uOT == 5 || arrayList.contains(bVar.zk))) {
                    w.d("MicroMsg.ConversationWithCacheAdapter", "searchArray.add(event.object) " + ((String) bVar.zk));
                    arrayList.add(bVar.zk);
                }
            }
            HashMap hashMap = new HashMap();
            ap.yY();
            Cursor a = com.tencent.mm.u.c.wW().a(arrayList, com.tencent.mm.u.o.hlr, this.jBA, com.tencent.mm.k.a.gTS);
            while (a.moveToNext()) {
                aj aeVar = new ae();
                aeVar.b(a);
                hashMap.put(aeVar.field_username, aeVar);
            }
            a.close();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                bVar = (com.tencent.mm.ui.e.b) it2.next();
                if (bVar != null) {
                    if (bVar.uOT != 5) {
                        w.d("MicroMsg.ConversationWithCacheAdapter", "evnet name," + ((String) bVar.zk) + "  event.newObj   ==" + (hashMap.get(bVar.zk) == null));
                        bVar.uOU = hashMap.get(bVar.zk);
                    } else {
                        bVar.uOU = null;
                    }
                }
            }
            arrayList.clear();
            hashMap.clear();
            HashMap hashMap2 = new HashMap();
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                bVar = (com.tencent.mm.ui.e.b) it3.next();
                if (bVar != null) {
                    a(bVar, sparseArrayArr[0], hashMap2);
                    if (bVar.uOT != 5) {
                        hashMap2.put(bVar.zk, bVar.uOU);
                    }
                }
            }
        }
        return sparseArrayArr;
    }

    private ae d(String str, HashMap<String, ae> hashMap) {
        if (hashMap == null || !hashMap.containsKey(str)) {
            return (ae) bC(str);
        }
        return (ae) hashMap.get(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.util.SparseArray<java.lang.String> a(com.tencent.mm.ui.e.b<java.lang.String, com.tencent.mm.storage.ae> r17, android.util.SparseArray<java.lang.String> r18, java.util.HashMap<java.lang.String, com.tencent.mm.storage.ae> r19) {
        /*
        r16 = this;
        r0 = r17;
        r2 = r0.zk;
        r2 = (java.lang.String) r2;
        r7 = r18.size();
        r0 = r17;
        r3 = r0.uOU;
        r3 = (com.tencent.mm.storage.ae) r3;
        r6 = r18.size();
        r5 = 0;
    L_0x0015:
        if (r5 >= r6) goto L_0x0058;
    L_0x0017:
        r0 = r18;
        r4 = r0.get(r5);
        r4 = (java.lang.String) r4;
        r4 = r4.equals(r2);
        if (r4 == 0) goto L_0x0055;
    L_0x0025:
        r4 = "MicroMsg.ConversationWithCacheAdapter";
        r6 = "resortPosition username %s,  size %d, position %d";
        r8 = 3;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r2;
        r9 = 1;
        r10 = java.lang.Integer.valueOf(r7);
        r8[r9] = r10;
        r9 = 2;
        r10 = java.lang.Integer.valueOf(r5);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.w.d(r4, r6, r8);
        r0 = r17;
        r4 = r0.uOT;
        switch(r4) {
            case 2: goto L_0x0079;
            case 3: goto L_0x0049;
            case 4: goto L_0x0049;
            case 5: goto L_0x005b;
            default: goto L_0x0049;
        };
    L_0x0049:
        if (r5 >= 0) goto L_0x00ed;
    L_0x004b:
        r2 = "MicroMsg.ConversationWithCacheAdapter";
        r3 = "CursorDataAdapter.CHANGE_TYPE_UPDATE  position < 0";
        com.tencent.mm.sdk.platformtools.w.e(r2, r3);
    L_0x0054:
        return r18;
    L_0x0055:
        r5 = r5 + 1;
        goto L_0x0015;
    L_0x0058:
        r4 = -1;
        r5 = r4;
        goto L_0x0025;
    L_0x005b:
        if (r5 < 0) goto L_0x0054;
    L_0x005d:
        r2 = r7 + -1;
        if (r5 >= r2) goto L_0x0071;
    L_0x0061:
        r2 = r5 + 1;
        r0 = r18;
        r2 = r0.get(r2);
        r0 = r18;
        r0.put(r5, r2);
        r5 = r5 + 1;
        goto L_0x005d;
    L_0x0071:
        r2 = r7 + -1;
        r0 = r18;
        r0.remove(r2);
        goto L_0x0054;
    L_0x0079:
        if (r3 != 0) goto L_0x00b1;
    L_0x007b:
        r3 = "MicroMsg.ConversationWithCacheAdapter";
        r4 = "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null";
        com.tencent.mm.sdk.platformtools.w.e(r3, r4);
        if (r5 < 0) goto L_0x0054;
    L_0x0086:
        r3 = "MicroMsg.ConversationWithCacheAdapter";
        r4 = "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null delete it username %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r8 = 0;
        r6[r8] = r2;
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r6);
    L_0x0095:
        r2 = r7 + -1;
        if (r5 >= r2) goto L_0x00a9;
    L_0x0099:
        r2 = r5 + 1;
        r0 = r18;
        r2 = r0.get(r2);
        r0 = r18;
        r0.put(r5, r2);
        r5 = r5 + 1;
        goto L_0x0095;
    L_0x00a9:
        r2 = r7 + -1;
        r0 = r18;
        r0.remove(r2);
        goto L_0x0054;
    L_0x00b1:
        if (r5 >= 0) goto L_0x0049;
    L_0x00b3:
        r4 = 0;
        r5 = r4;
    L_0x00b5:
        if (r5 >= r7) goto L_0x00d3;
    L_0x00b7:
        r0 = r18;
        r4 = r0.get(r5);
        r4 = (java.lang.String) r4;
        r0 = r16;
        r1 = r19;
        r4 = r0.d(r4, r1);
        r8 = r4.field_flag;
        r10 = r3.field_flag;
        r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r4 <= 0) goto L_0x00d3;
    L_0x00cf:
        r4 = r5 + 1;
        r5 = r4;
        goto L_0x00b5;
    L_0x00d3:
        r3 = r7;
    L_0x00d4:
        if (r3 <= r5) goto L_0x00e6;
    L_0x00d6:
        r4 = r3 + -1;
        r0 = r18;
        r4 = r0.get(r4);
        r0 = r18;
        r0.put(r3, r4);
        r3 = r3 + -1;
        goto L_0x00d4;
    L_0x00e6:
        r0 = r18;
        r0.put(r5, r2);
        goto L_0x0054;
    L_0x00ed:
        r0 = r16;
        r1 = r19;
        r4 = r0.d(r2, r1);
        if (r3 != 0) goto L_0x0123;
    L_0x00f7:
        r3 = "MicroMsg.ConversationWithCacheAdapter";
        r4 = "CursorDataAdapter.CHANGE_TYPE_UPDATE  cov == null delete it username %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r8 = 0;
        r6[r8] = r2;
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r6);
    L_0x0106:
        r2 = r7 + -1;
        if (r5 >= r2) goto L_0x011a;
    L_0x010a:
        r2 = r5 + 1;
        r0 = r18;
        r2 = r0.get(r2);
        r0 = r18;
        r0.put(r5, r2);
        r5 = r5 + 1;
        goto L_0x0106;
    L_0x011a:
        r2 = r7 + -1;
        r0 = r18;
        r0.remove(r2);
        goto L_0x0054;
    L_0x0123:
        r8 = r4.field_flag;
        r10 = r3.field_flag;
        r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r4 == 0) goto L_0x0054;
    L_0x012b:
        r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r4 >= 0) goto L_0x019c;
    L_0x012f:
        r6 = 0;
        r7 = r5 + -1;
        r4 = 1;
        r8 = r7;
        r7 = r6;
        r6 = r4;
    L_0x0136:
        r9 = 0;
        r10 = r7;
    L_0x0138:
        if (r10 > r8) goto L_0x01c4;
    L_0x013a:
        r0 = r18;
        r4 = r0.get(r10);
        r4 = (java.lang.String) r4;
        r0 = r16;
        r1 = r19;
        r4 = r0.d(r4, r1);
        r12 = r4.field_flag;
        r14 = r3.field_flag;
        r4 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
        if (r4 > 0) goto L_0x01a5;
    L_0x0152:
        r3 = 1;
    L_0x0153:
        r4 = "MicroMsg.ConversationWithCacheAdapter";
        r9 = "resortPosition: begin-%d end-%d tempUpdate-%d found-%b position-%d username-%s";
        r11 = 6;
        r11 = new java.lang.Object[r11];
        r12 = 0;
        r7 = java.lang.Integer.valueOf(r7);
        r11[r12] = r7;
        r7 = 1;
        r8 = java.lang.Integer.valueOf(r8);
        r11[r7] = r8;
        r7 = 2;
        r8 = -1;
        r8 = java.lang.Integer.valueOf(r8);
        r11[r7] = r8;
        r7 = 3;
        r8 = java.lang.Boolean.valueOf(r3);
        r11[r7] = r8;
        r7 = 4;
        r8 = java.lang.Integer.valueOf(r5);
        r11[r7] = r8;
        r7 = 5;
        r11[r7] = r2;
        com.tencent.mm.sdk.platformtools.w.i(r4, r9, r11);
        if (r3 == 0) goto L_0x0054;
    L_0x0188:
        if (r6 == 0) goto L_0x01a8;
    L_0x018a:
        if (r5 <= r10) goto L_0x01bc;
    L_0x018c:
        r3 = r5 + -1;
        r0 = r18;
        r3 = r0.get(r3);
        r0 = r18;
        r0.put(r5, r3);
        r5 = r5 + -1;
        goto L_0x018a;
    L_0x019c:
        r6 = r5 + 1;
        r7 = r7 + -1;
        r4 = 0;
        r8 = r7;
        r7 = r6;
        r6 = r4;
        goto L_0x0136;
    L_0x01a5:
        r10 = r10 + 1;
        goto L_0x0138;
    L_0x01a8:
        r3 = r10 + -1;
    L_0x01aa:
        if (r5 >= r3) goto L_0x01bd;
    L_0x01ac:
        r4 = r5 + 1;
        r0 = r18;
        r4 = r0.get(r4);
        r0 = r18;
        r0.put(r5, r4);
        r5 = r5 + 1;
        goto L_0x01aa;
    L_0x01bc:
        r3 = r10;
    L_0x01bd:
        r0 = r18;
        r0.put(r3, r2);
        goto L_0x0054;
    L_0x01c4:
        r3 = r9;
        goto L_0x0153;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.conversation.g.a(com.tencent.mm.ui.e$b, android.util.SparseArray, java.util.HashMap):android.util.SparseArray<java.lang.String>");
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        int i2 = 0;
        if (obj == null || !(obj instanceof String)) {
            w.d("MicroMsg.ConversationWithCacheAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
            return;
        }
        String str = (String) obj;
        if (mVar instanceof as) {
            w.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onConversationStorageNotifyChange event type %d, username %s", Integer.valueOf(i), str);
            if (!(!str.contains("@") || str.endsWith("@chatroom") || str.endsWith("@micromsg.qq.com"))) {
                i2 = 1;
            }
            if (i2 == 0) {
                if (this.vvu != null) {
                    if (!obj.equals("")) {
                        this.wdd.add(str);
                    } else if (i == 5) {
                        this.wde = true;
                        super.o(null, 1);
                        return;
                    }
                }
                if (i == 3) {
                    i = 2;
                }
                super.o(str, i);
            }
        } else if (mVar instanceof ar) {
            w.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange event type %d, username %s, isIniting %b", Integer.valueOf(i), obj, Boolean.valueOf(this.neO));
            if (!this.neO) {
                this.wdc = true;
                if (i != 5 && i != 2 && this.vvu != null && this.vvu.containsKey(str) && this.wcY != null) {
                    this.wcY.add(str);
                }
            }
        }
    }

    private void bYB() {
        if (this.vvu != null && this.wcY != null && !this.wcY.isEmpty()) {
            w.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents contactEvents size %d", Integer.valueOf(this.wcY.size()));
            Iterator it = this.wcY.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                String str = (String) it.next();
                if (!(str == null || str.equals("") || !this.vvu.containsKey(str))) {
                    d dVar = (d) this.vvu.get(str);
                    if (dVar != null) {
                        this.wdh.cH(str);
                        boolean dH = com.tencent.mm.u.o.dH(str);
                        af bYD = this.wdh.bYD();
                        if (bYD != null) {
                            String a = com.tencent.mm.u.n.a(bYD, str, dH);
                            w.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents newdisplayname %s old dispalyname %s", a, dVar.gMX);
                            if (!(a == null || a.equals(dVar.gMX))) {
                                dVar.gMX = a;
                                a(dVar);
                                i = 1;
                            }
                            boolean tD = bYD.tD();
                            dH = bYD.gkz == 0;
                            if (!(dVar.wcv == tD && dH == dVar.wcy)) {
                                dVar.wcv = tD;
                                dVar.wcy = dH;
                                dVar.wcz = bYD.tE();
                                w.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents in cache username %s mute change", str);
                                i2 = 1;
                                i = i2;
                            }
                        }
                    }
                }
                i2 = i;
                i = i2;
            }
            if (i != 0) {
                notifyDataSetChanged();
            }
            this.wcY.clear();
        }
    }

    public final boolean bNL() {
        return super.bNL();
    }

    public final boolean TV(String str) {
        return this.vvu == null || !this.vvu.containsKey(str);
    }

    public final void BP(int i) {
        if (i >= 0 && i < getCount()) {
            ae aeVar = (ae) yQ(i);
            if (aeVar != null) {
                com.tencent.mm.pluginsdk.ui.a.b.bEa().bf(aeVar.field_username);
            }
        }
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.wda.clear();
        w.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
    }
}
