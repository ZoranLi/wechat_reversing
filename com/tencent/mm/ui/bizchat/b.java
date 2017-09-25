package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.tools.s;
import java.util.HashMap;

public final class b extends k<com.tencent.mm.modelbiz.a.a> implements com.tencent.mm.sdk.e.m.b {
    protected f jVY;
    protected c jVZ;
    protected e jWa;
    protected d jWb = MMSlideDelView.bSo();
    private final String kbi;
    private com.tencent.mm.ah.a.a.c kwq = null;
    private final MMFragmentActivity vvp;
    private float vvq = -1.0f;
    private float vvr = -1.0f;
    private float vvs = -1.0f;
    private ColorStateList[] vvt = new ColorStateList[5];
    HashMap<String, a> vvu;

    private class a {
        String hzu = null;
        public boolean kmK;
        String lWv = null;
        public boolean vvv;
        public com.tencent.mm.modelbiz.a.a vvw;
        final /* synthetic */ b vvx;

        public a(b bVar) {
            this.vvx = bVar;
        }
    }

    public static class b {
        public ImageView ipv;
        public TextView jWh;
        public NoMeasuredTextView vvA;
        public ImageView vvB;
        public ImageView vvC;
        public View vvD;
        public NoMeasuredTextView vvy;
        public NoMeasuredTextView vvz;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (com.tencent.mm.modelbiz.a.a) obj;
        if (obj == null) {
            obj = new com.tencent.mm.modelbiz.a.a();
        }
        obj.b(cursor);
        return obj;
    }

    public b(Context context, com.tencent.mm.ui.k.a aVar, String str) {
        super(context, new com.tencent.mm.modelbiz.a.a());
        this.uSN = aVar;
        this.vvp = (MMFragmentActivity) context;
        this.kbi = str;
        this.vvu = new HashMap();
        this.vvt[0] = com.tencent.mm.bg.a.S(context, R.e.aUo);
        this.vvt[1] = com.tencent.mm.bg.a.S(context, R.e.aVe);
        this.vvt[3] = com.tencent.mm.bg.a.S(context, R.e.aVo);
        this.vvt[2] = com.tencent.mm.bg.a.S(context, R.e.aVc);
        this.vvt[2] = com.tencent.mm.bg.a.S(context, R.e.aVc);
        this.vvt[4] = com.tencent.mm.bg.a.S(context, R.e.aUy);
        this.vvq = (float) com.tencent.mm.bg.a.T(context, R.f.aXI);
        this.vvr = (float) com.tencent.mm.bg.a.T(context, R.f.aXs);
        this.vvs = (float) com.tencent.mm.bg.a.T(context, R.f.aXW);
        com.tencent.mm.ah.a.a.c.a aVar2 = new com.tencent.mm.ah.a.a.c.a();
        aVar2.hIO = com.tencent.mm.modelbiz.a.e.iz(this.kbi);
        aVar2.hIL = true;
        aVar2.hJh = true;
        aVar2.hJa = R.k.bes;
        this.kwq = aVar2.Hg();
    }

    public final void OK() {
        aEW();
        setCursor(w.DK().io(this.kbi));
        if (this.uSN != null) {
            this.uSN.OH();
        }
        super.notifyDataSetChanged();
    }

    public final int getViewTypeCount() {
        return 1;
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

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void onPause() {
        if (this.jWb != null) {
            this.jWb.aFh();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        b bVar2;
        int i2;
        com.tencent.mm.modelbiz.a.a aVar = (com.tencent.mm.modelbiz.a.a) getItem(i);
        if (view != null) {
            bVar = (b) view.getTag();
        } else {
            bVar = null;
        }
        if (view == null || bVar == null) {
            View inflate;
            b bVar3 = new b();
            if (com.tencent.mm.bg.a.dM(this.vvp)) {
                inflate = View.inflate(this.vvp, R.i.cZN, null);
            } else {
                inflate = View.inflate(this.vvp, R.i.cZM, null);
            }
            bVar3.ipv = (ImageView) inflate.findViewById(R.h.bqM);
            bVar3.vvy = (NoMeasuredTextView) inflate.findViewById(R.h.cof);
            bVar3.vvz = (NoMeasuredTextView) inflate.findViewById(R.h.cKN);
            bVar3.vvA = (NoMeasuredTextView) inflate.findViewById(R.h.cat);
            bVar3.jWh = (TextView) inflate.findViewById(R.h.cIL);
            bVar3.jWh.setBackgroundResource(s.fg(this.vvp));
            bVar3.vvB = (ImageView) inflate.findViewById(R.h.bXd);
            bVar3.vvD = inflate.findViewById(R.h.bqN);
            bVar3.vvC = (ImageView) inflate.findViewById(R.h.cHA);
            inflate.setTag(bVar3);
            bVar3.vvA.H(this.vvr);
            bVar3.vvz.H(this.vvs);
            bVar3.vvy.H(this.vvq);
            bVar3.vvA.setTextColor(this.vvt[0]);
            bVar3.vvz.setTextColor(this.vvt[4]);
            bVar3.vvy.setTextColor(this.vvt[3]);
            bVar3.vvA.voV = true;
            bVar3.vvz.voV = false;
            bVar3.vvy.voV = true;
            bVar3.vvz.wa();
            view = inflate;
            bVar2 = bVar3;
        } else {
            bVar2 = bVar;
        }
        long j = aVar.field_bizChatId;
        a aVar2 = (a) this.vvu.get(String.valueOf(j));
        if (aVar2 == null) {
            aVar2 = new a(this);
            w.DK();
            aVar2.vvv = com.tencent.mm.modelbiz.a.b.c(aVar);
            com.tencent.mm.modelbiz.a.c aa = w.DJ().aa(j);
            if (aa.DV()) {
                aVar2.hzu = aa.field_chatName;
                aVar2.kmK = aa.fu(1);
                aVar2.lWv = aa.field_headImageUrl;
            } else {
                j iD = w.DL().iD(aa.field_bizChatServId);
                if (iD != null) {
                    aVar2.hzu = iD.field_userName;
                    aVar2.kmK = iD.fu(1);
                    aVar2.lWv = iD.field_headImageUrl;
                }
            }
            if (bg.mA(aVar2.hzu)) {
                aVar2.hzu = this.vvp.getString(R.l.eMB);
            }
            aVar2.vvw = aVar;
            this.vvu.put(String.valueOf(j), aVar2);
        }
        bVar2.vvC.setVisibility(8);
        bVar2.vvz.setText(aVar2.vvw.field_status == 1 ? this.vvp.getString(R.l.ezo) : o.c(this.vvp, aVar2.vvw.field_lastMsgTime, true));
        n.GW().a(aVar2.lWv, bVar2.ipv, this.kwq);
        if (aVar2.kmK) {
            bVar2.vvB.setVisibility(0);
        } else {
            bVar2.vvB.setVisibility(8);
        }
        bVar2.vvy.setText(h.c(this.vvp, aVar2.hzu, (int) bVar2.vvy.gm.getTextSize()));
        CharSequence a = a(aVar2.vvw, (int) bVar2.vvA.gm.getTextSize(), aVar2.hzu);
        switch (aVar2.vvw.field_status) {
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
        bVar2.vvy.kW(false);
        if (i2 != -1) {
            bVar2.vvA.An(i2);
            bVar2.vvA.kV(true);
        } else {
            bVar2.vvA.kV(false);
        }
        bVar2.vvA.setText(a);
        bVar2.vvA.setTextColor(com.tencent.mm.bg.a.S(this.vvp, R.e.aVd));
        if (rZ(aVar2.vvw.field_msgType) == 34 && aVar2.vvw.field_isSend == 0 && !bg.mA(aVar2.vvw.field_content) && !new com.tencent.mm.modelvoice.n(aVar2.vvw.field_content).iai) {
            bVar2.vvA.setTextColor(com.tencent.mm.bg.a.S(this.vvp, R.e.aVe));
        }
        if (aVar2.kmK) {
            if (aVar2.vvw.field_unReadCount > 0) {
                bVar2.vvD.setVisibility(0);
            } else {
                bVar2.vvD.setVisibility(4);
            }
            bVar2.jWh.setVisibility(4);
        } else {
            bVar2.vvD.setVisibility(4);
            if (aVar2.vvw.field_unReadCount > 99) {
                bVar2.jWh.setText(R.l.eYP);
                bVar2.jWh.setVisibility(0);
                com.tencent.mm.sdk.platformtools.w.v("MicroMsg.BizChatConversationAdapter", "has unread 100");
            } else if (aVar2.vvw.field_unReadCount > 0) {
                bVar2.jWh.setText(aVar2.vvw.field_unReadCount);
                bVar2.jWh.setVisibility(0);
                com.tencent.mm.sdk.platformtools.w.v("MicroMsg.BizChatConversationAdapter", "has unread");
            } else {
                bVar2.jWh.setVisibility(4);
                com.tencent.mm.sdk.platformtools.w.v("MicroMsg.BizChatConversationAdapter", "no unread");
            }
        }
        if (aVar2.vvv) {
            view.findViewById(R.h.bGJ).setBackgroundResource(R.g.ben);
        } else {
            view.findViewById(R.h.bGJ).setBackgroundResource(R.g.beo);
        }
        return view;
    }

    private static String Tj(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ue(str);
    }

    private CharSequence a(com.tencent.mm.modelbiz.a.a aVar, int i, String str) {
        if (bg.mA(aVar.field_editingMsg) || (aVar.field_atCount > 0 && aVar.field_unReadCount > 0)) {
            String str2 = aVar.field_digest;
            if (aVar.field_msgType != null && (aVar.field_msgType.equals("47") || aVar.field_msgType.equals("1048625"))) {
                String Tj = Tj(aVar.field_digest);
                str2 = "";
                if (Tj != null) {
                    return "[" + Tj + "]";
                }
                if (aVar.field_digest != null && aVar.field_digest.contains(":")) {
                    str2 = aVar.field_digest.substring(0, aVar.field_digest.indexOf(":"));
                    Tj = Tj(aVar.field_digest.substring(aVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                    if (Tj != null) {
                        Tj = "[" + Tj + "]";
                        return bg.mA(str2) ? Tj : str2 + ": " + Tj;
                    }
                }
                Tj = this.vvp.getString(R.l.dGL);
                aVar.field_digest = bg.mA(str2) ? Tj : str2 + ": " + Tj;
            }
            if (bg.mA(aVar.field_digest)) {
                str2 = "";
            } else if (bg.mA(aVar.field_digestUser)) {
                str2 = aVar.field_digest;
            } else {
                try {
                    str2 = String.format(aVar.field_digest, new Object[]{str});
                } catch (Exception e) {
                    str2 = aVar.field_digest;
                }
            }
            CharSequence replace = str2.replace('\n', ' ');
            if (aVar.field_atCount <= 0 || aVar.field_unReadCount <= 0) {
                return h.c(this.vvp, replace, i);
            }
            CharSequence spannableStringBuilder = new SpannableStringBuilder(this.vvp.getString(R.l.eyR));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append(" ").append(h.c(this.vvp, replace, i));
            return spannableStringBuilder;
        }
        spannableStringBuilder = new SpannableStringBuilder(this.vvp.getString(R.l.eyV));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append(" ").append(h.c(this.vvp, aVar.field_editingMsg, i));
        return spannableStringBuilder;
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

    protected final void OL() {
        OK();
    }

    public final void a(int i, m mVar, Object obj) {
        super.a(i, mVar, obj);
    }

    public final void eE(long j) {
        if (this.vvu != null) {
            this.vvu.remove(String.valueOf(j));
        }
    }
}
