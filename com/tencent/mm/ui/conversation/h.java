package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
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
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.j.n;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.tools.s;
import java.util.HashMap;
import java.util.Map.Entry;

public final class h extends k<ae> implements com.tencent.mm.sdk.e.m.b {
    private static long wcj = 2000;
    private String fRu;
    protected f jVY;
    protected c jVZ;
    protected e jWa;
    protected d jWb = MMSlideDelView.bSo();
    private float vvq = -1.0f;
    private float vvr = -1.0f;
    private float vvs = -1.0f;
    HashMap<String, a> vvu;
    private boolean wbX = false;
    private boolean wbY = false;
    public String wce = "";
    private final int wcg;
    private final int wch;
    private boolean wck = false;
    aj wcl = new aj(ap.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ h wdy;

        {
            this.wdy = r1;
        }

        public final boolean oQ() {
            if (this.wdy.wck) {
                this.wdy.bYx();
            }
            return false;
        }
    }, false);
    private ColorStateList[] wdx = new ColorStateList[5];

    private class a {
        public int knu;
        public CharSequence nickName;
        public boolean sEV;
        public boolean vvv;
        public int wcA;
        public CharSequence wcp;
        public CharSequence wcq;
        public int wcr;
        public int wcs;
        public boolean wcv;
        public boolean wcx;
        public boolean wcz;
        final /* synthetic */ h wdy;
        public boolean wdz;

        public a(h hVar) {
            this.wdy = hVar;
        }
    }

    public static class b {
        public ImageView ipv;
        public ImageView vvB;
        public View vvD;
        public NoMeasuredTextView wdA;
        public NoMeasuredTextView wdB;
        public NoMeasuredTextView wdC;
        public TextView wdD;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ae) obj;
        if (obj == null) {
            obj = new ae();
        }
        obj.cu("");
        obj.cv("");
        obj.b(cursor);
        return obj;
    }

    public h(Context context, String str, com.tencent.mm.ui.k.a aVar) {
        super(context, new ae());
        this.uSN = aVar;
        this.fRu = str;
        this.vvu = new HashMap();
        this.wdx[0] = com.tencent.mm.bg.a.S(context, R.e.aUo);
        this.wdx[1] = com.tencent.mm.bg.a.S(context, R.e.aVe);
        this.wdx[3] = com.tencent.mm.bg.a.S(context, R.e.aVo);
        this.wdx[2] = com.tencent.mm.bg.a.S(context, R.e.aVc);
        this.wdx[2] = com.tencent.mm.bg.a.S(context, R.e.aVc);
        this.wdx[4] = com.tencent.mm.bg.a.S(context, R.e.aUy);
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
        ap.yY();
        com.tencent.mm.u.c.wW().a(this);
    }

    public final void a(f fVar) {
        this.jVY = fVar;
    }

    public final void a(e eVar) {
        this.jWa = eVar;
    }

    public final void a(c cVar) {
        this.jVZ = cVar;
    }

    public final void onPause() {
        if (this.jWb != null) {
            this.jWb.aFh();
        }
        this.wbX = false;
    }

    public final void onResume() {
        boolean z = true;
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
        if (this.wbY) {
            super.a(null, null);
            this.wbY = false;
        }
    }

    protected final void OL() {
        OK();
    }

    public final void OK() {
        aEW();
        ap.yY();
        setCursor(com.tencent.mm.u.c.wW().c(o.hlr, null, this.fRu));
        if (this.uSN != null) {
            this.uSN.OH();
        }
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        View inflate;
        int i2;
        a aVar;
        ae aeVar = (ae) getItem(i);
        String str = aeVar.field_username;
        b bVar2 = null;
        if (view != null) {
            bVar2 = (b) view.getTag();
        }
        if (view == null || bVar2 == null) {
            bVar = new b();
            if (com.tencent.mm.bg.a.dM(this.context)) {
                inflate = View.inflate(this.context, R.i.cZN, null);
            } else {
                inflate = View.inflate(this.context, R.i.cZM, null);
            }
            bVar.ipv = (ImageView) inflate.findViewById(R.h.bqM);
            bVar.wdA = (NoMeasuredTextView) inflate.findViewById(R.h.cof);
            bVar.wdA.H(this.vvq);
            bVar.wdA.setTextColor(this.wdx[3]);
            bVar.wdA.voV = true;
            bVar.wdB = (NoMeasuredTextView) inflate.findViewById(R.h.cKN);
            bVar.wdB.H(this.vvs);
            bVar.wdB.setTextColor(this.wdx[4]);
            bVar.wdB.voV = false;
            bVar.wdB.wa();
            bVar.wdC = (NoMeasuredTextView) inflate.findViewById(R.h.cat);
            bVar.wdC.H(this.vvr);
            bVar.wdC.setTextColor(this.wdx[0]);
            bVar.wdC.voV = true;
            bVar.wdD = (TextView) inflate.findViewById(R.h.cIL);
            bVar.wdD.setBackgroundResource(s.fg(this.context));
            bVar.vvB = (ImageView) inflate.findViewById(R.h.bXd);
            bVar.vvD = inflate.findViewById(R.h.bqN);
            inflate.findViewById(R.h.cHA).setVisibility(8);
            inflate.findViewById(R.h.ccn).setVisibility(8);
            inflate.setTag(bVar);
        } else {
            bVar = bVar2;
            inflate = view;
        }
        a aVar2 = (a) this.vvu.get(str);
        ap.yY();
        com.tencent.mm.j.a Rc = com.tencent.mm.u.c.wR().Rc(str);
        if (aVar2 == null) {
            a aVar3 = new a(this);
            if (Rc != null) {
                aVar3.wcs = (int) Rc.gTQ;
            } else {
                aVar3.wcs = -1;
            }
            aVar3.wcx = Rc != null;
            boolean z = Rc != null && Rc.tE();
            aVar3.wcz = z;
            z = Rc != null && Rc.tD();
            aVar3.wcv = z;
            aVar3.wdz = aeVar.field_unReadCount > 0;
            aVar3.knu = 0;
            if (k(aeVar) == 34 && aeVar.field_isSend == 0 && !u.mA(aeVar.field_content) && !new com.tencent.mm.modelvoice.n(aeVar.field_content).iai) {
                aVar3.knu = 1;
            }
            aVar3.nickName = com.tencent.mm.pluginsdk.ui.d.h.b(this.context, com.tencent.mm.u.n.a(Rc, str, false), bVar.wdA.gm.getTextSize());
            aVar3.wcp = i(aeVar);
            int textSize = (int) bVar.wdC.gm.getTextSize();
            z = aVar3.wcv && aVar3.wdz;
            aVar3.wcq = c(aeVar, textSize, z);
            aVar3.wcA = aeVar.field_attrflag;
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
            aVar3.wcr = i2;
            ap.yY();
            aVar3.vvv = com.tencent.mm.u.c.wW().g(aeVar);
            aVar3.sEV = v.bIJ();
            this.vvu.put(str, aVar3);
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        if (aVar.wcp == null) {
            aVar.wcp = i(aeVar);
        }
        if (aVar.wcv && aVar.wdz) {
            bVar.wdC.setTextColor(this.wdx[0]);
        } else {
            bVar.wdC.setTextColor(this.wdx[aVar.knu]);
        }
        com.tencent.mm.booter.notification.a.h.dX(bVar.wdC.getWidth());
        com.tencent.mm.booter.notification.a.h.dY((int) bVar.wdC.gm.getTextSize());
        com.tencent.mm.booter.notification.a.h.a(bVar.wdC.gm);
        if (aVar.wcr != -1) {
            bVar.wdC.An(aVar.wcr);
            bVar.wdC.kV(true);
        } else {
            bVar.wdC.kV(false);
        }
        bVar.wdC.setText(aVar.wcq);
        bVar.wdA.kW(false);
        bVar.wdA.setText(aVar.nickName);
        LayoutParams layoutParams = bVar.wdB.getLayoutParams();
        if (aVar.wcp.length() > 9) {
            if (layoutParams.width != this.wch) {
                layoutParams.width = this.wch;
                bVar.wdB.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.wcg) {
            layoutParams.width = this.wcg;
            bVar.wdB.setLayoutParams(layoutParams);
        }
        bVar.wdB.setText(aVar.wcp);
        if (aVar.wcv) {
            bVar.vvB.setVisibility(0);
        } else {
            bVar.vvB.setVisibility(8);
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(bVar.ipv, str);
        bVar.wdD.setVisibility(4);
        bVar.vvD.setVisibility(4);
        if (aVar.wcx && aVar.wcs != 0) {
            i2 = aeVar.field_unReadCount;
            if (aVar.wcv) {
                View view2 = bVar.vvD;
                if (i2 > 0) {
                    i2 = 0;
                } else {
                    i2 = 4;
                }
                view2.setVisibility(i2);
            } else if (i2 > 99) {
                bVar.wdD.setText(R.l.eYP);
                bVar.wdD.setVisibility(0);
            } else if (i2 > 0) {
                bVar.wdD.setText(String.valueOf(i2));
                bVar.wdD.setVisibility(0);
            }
        }
        if (!aVar.vvv || aeVar.field_conversationTime == -1) {
            inflate.findViewById(R.h.bGJ).setBackgroundResource(R.g.beo);
        } else {
            inflate.findViewById(R.h.bGJ).setBackgroundResource(R.g.ben);
        }
        a.uWW.a(inflate, String.valueOf(aVar.nickName), aeVar.field_unReadCount, String.valueOf(aVar.wcp), String.valueOf(aVar.wcq));
        return inflate;
    }

    private static int k(ae aeVar) {
        int i = 1;
        String str = aeVar.field_msgType;
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    private CharSequence c(ae aeVar, int i, boolean z) {
        CharSequence replace;
        if (u.mA(aeVar.field_editingMsg) || (aeVar.field_atCount > 0 && aeVar.field_unReadCount > 0)) {
            CharSequence charSequence = aeVar.field_digest;
            if (charSequence != null && charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                return new SpannableString(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, charSequence, (float) i));
            }
            String str;
            if (k(aeVar) == 47 || k(aeVar) == 1048625) {
                String Tj = Tj(aeVar.field_digest);
                str = "";
                if (Tj != null) {
                    return "[" + Tj + "]";
                }
                if (aeVar.field_digest != null && aeVar.field_digest.contains(":")) {
                    str = aeVar.field_digest.substring(0, aeVar.field_digest.indexOf(":"));
                    Tj = Tj(aeVar.field_digest.substring(aeVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                    if (Tj != null) {
                        Tj = "[" + Tj + "]";
                        return u.mA(str) ? Tj : str + ": " + Tj;
                    }
                }
                Tj = this.context.getString(R.l.dGL);
                aeVar.cu(u.mA(str) ? Tj : str + ": " + Tj);
            }
            if (!u.mA(aeVar.field_digest)) {
                if (u.mA(aeVar.field_digestUser)) {
                    str = aeVar.field_digest;
                } else {
                    str = (aeVar.field_isSend == 0 && o.dH(aeVar.field_username)) ? com.tencent.mm.u.n.E(aeVar.field_digestUser, aeVar.field_username) : com.tencent.mm.u.n.eK(aeVar.field_digestUser);
                    try {
                        str = String.format(aeVar.field_digest, new Object[]{str});
                    } catch (Exception e) {
                    }
                }
                replace = str.replace('\n', ' ');
                if (aeVar.field_atCount > 0 || aeVar.field_unReadCount <= 0) {
                    if (z && aeVar.field_unReadCount > 1) {
                        replace = this.context.getString(R.l.eyU, new Object[]{Integer.valueOf(aeVar.field_unReadCount), replace});
                    }
                    return com.tencent.mm.pluginsdk.ui.d.h.c(this.context, replace, i);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.context.getString(R.l.eyR));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, replace, i));
                return spannableStringBuilder;
            }
            str = com.tencent.mm.booter.notification.a.h.a(aeVar.field_isSend, aeVar.field_username, aeVar.field_content, k(aeVar), this.context);
            replace = str.replace('\n', ' ');
            if (aeVar.field_atCount > 0) {
            }
            replace = this.context.getString(R.l.eyU, new Object[]{Integer.valueOf(aeVar.field_unReadCount), replace});
            return com.tencent.mm.pluginsdk.ui.d.h.c(this.context, replace, i);
        }
        replace = new SpannableStringBuilder(this.context.getString(R.l.eyV));
        replace.setSpan(new ForegroundColorSpan(-5569532), 0, replace.length(), 33);
        replace.append(" ").append(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, aeVar.field_editingMsg, i));
        return replace;
    }

    private static String Tj(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ue(str);
    }

    private CharSequence i(ae aeVar) {
        if (aeVar.field_status == 1) {
            return this.context.getString(R.l.ezo);
        }
        return aeVar.field_conversationTime == Long.MAX_VALUE ? "" : com.tencent.mm.pluginsdk.j.o.c(this.context, aeVar.field_conversationTime, true);
    }

    private void bYw() {
        if (this.vvu != null) {
            for (Entry value : this.vvu.entrySet()) {
                ((a) value.getValue()).wcp = null;
            }
        }
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            w.e("MicroMsg.EnterpriseConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
            return;
        }
        a((String) obj, null);
    }

    public final void a(String str, l lVar) {
        w.i("MicroMsg.EnterpriseConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", Boolean.valueOf(this.wbX), Boolean.valueOf(this.wbY), str);
        if (!(u.mA(str) || this.vvu == null)) {
            this.vvu.remove(str);
        }
        if (this.wbX) {
            w.d("MicroMsg.EnterpriseConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", Boolean.valueOf(this.wck), Boolean.valueOf(this.wcl.bJq()));
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
        af.v(new Runnable(this) {
            final /* synthetic */ h wdy;

            {
                this.wdy = r1;
            }

            public final void run() {
                if (ap.zb()) {
                    long Nz = u.Nz();
                    super.a(null, null);
                    w.d("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", Long.valueOf(u.aA(Nz) * 3), Long.valueOf(h.wcj), Boolean.valueOf(this.wdy.wck));
                    h.wcj = (Nz + h.wcj) / 2;
                    this.wdy.wck = false;
                    aj c = this.wdy.wcl;
                    long bYE = h.wcj;
                    c.v(bYE, bYE);
                    return;
                }
                this.wdy.wcl.KH();
                w.e("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange acc has not ready");
            }
        });
    }
}
