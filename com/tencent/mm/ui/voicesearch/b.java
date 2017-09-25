package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.awp;
import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.r;
import com.tencent.mm.y.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class b extends k<x> implements e {
    private Context context;
    public com.tencent.mm.ui.applet.b hBe = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a(this) {
        final /* synthetic */ b wsd;

        {
            this.wsd = r1;
        }

        public final Bitmap jf(String str) {
            return com.tencent.mm.x.b.a(str, false, -1);
        }
    });
    private com.tencent.mm.ui.applet.b.b hBf = null;
    private LinkedList<awp> hkm = new LinkedList();
    private ProgressDialog isv = null;
    private List<String> jBA = null;
    private int showType = 1;
    public String vUP;
    public String[] vvh;
    public String wrX;
    private boolean wrY = false;
    private x wrZ = null;
    private boolean wsa = true;
    public boolean wsb = false;
    private boolean wsc = false;

    protected static class a {
        public CheckBox ipy;
        public TextView jZz;
        public MaskLayout kwV;
        public TextView mTs;
        public TextView waa;
        public ProgressBar wsf;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        ap.yY();
        Object QX = c.wR().QX(x.h(cursor));
        if (QX != null) {
            return QX;
        }
        x xVar = new x();
        xVar.b(cursor);
        ap.yY();
        c.wR().O(xVar);
        return xVar;
    }

    public final /* synthetic */ Object getItem(int i) {
        return kO(i);
    }

    public b(Context context, int i) {
        super(context, new x());
        this.context = context;
        this.showType = i;
        this.wrZ = new x();
        this.wrZ.setUsername("_find_more_public_contact_");
        this.wrZ.tl();
        this.vUP = "@micromsg.with.all.biz.qq.com";
    }

    public final void cK(final List<String> list) {
        aa(new Runnable(this) {
            final /* synthetic */ b wsd;

            public final void run() {
                if (this.wsd.jBA == null) {
                    this.wsd.jBA = new ArrayList();
                }
                this.wsd.jBA.clear();
                this.wsd.jBA.addAll(list);
                this.wsd.jBA.add("officialaccounts");
                this.wsd.jBA.add("helper_entry");
            }
        });
    }

    public final void lP(boolean z) {
        this.wsb = z;
        if (z) {
            this.wrZ.tl();
        }
    }

    public final void detach() {
        if (this.hBe != null) {
            this.hBe.detach();
            this.hBe = null;
        }
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final int getItemViewType(int i) {
        if (this.showType == 2) {
            return 2;
        }
        return Ck(i) ? 1 : 0;
    }

    protected final int aBV() {
        int i = 0;
        if (!this.wrY) {
            return 0;
        }
        if (!this.wrZ.isHidden()) {
            i = this.hkm.size();
        }
        return i + 1;
    }

    public final awp Cj(int i) {
        try {
            w.d("MicroMsg.SearchResultAdapter", "position " + i + " size " + this.hkm.size() + "  " + (i - ano()));
            return (awp) this.hkm.get((i - ano()) - 1);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SearchResultAdapter", e, "", new Object[0]);
            return null;
        }
    }

    public final x kO(int i) {
        if (nJ(i)) {
            return (x) aBW();
        }
        return (x) super.getItem(i);
    }

    public final void lQ(final boolean z) {
        aa(new Runnable(this) {
            final /* synthetic */ b wsd;

            public final void run() {
                this.wsd.wrY = z;
            }
        });
    }

    public final void Uv(final String str) {
        aa(new Runnable(this) {
            final /* synthetic */ b wsd;

            public final void run() {
                if (this.wsd.wrZ.isHidden()) {
                    this.wsd.wrZ.tm();
                    if (this.wsd.wsa) {
                        ap.vd().a(new aa(str, 3), 0);
                        this.wsd.wsc = true;
                        return;
                    }
                    return;
                }
                this.wsd.wrZ.tl();
            }
        });
    }

    public final boolean Ck(int i) {
        if (this.wrY) {
            int ano = ano();
            if (i == ano && i < ano + aBV()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isEnabled(int i) {
        if (!Ck(i) || ((this.hkm != null && this.hkm.size() != 0) || this.wsa)) {
            return true;
        }
        return false;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean nJ = nJ(i);
        boolean Ck = Ck(i);
        a aVar;
        a aVar2;
        String eZ;
        if (this.wrY && nJ) {
            if (view != null) {
                aVar = (a) view.getTag();
                if (Ck && aVar.wsf == null) {
                    view = null;
                }
            }
            if (view != null) {
                aVar2 = (a) view.getTag();
            } else if (Ck) {
                view = View.inflate(this.context, R.i.cZu, null);
                aVar2 = new a();
                aVar2.jZz = (TextView) view.findViewById(R.h.bGm);
                aVar2.wsf = (ProgressBar) view.findViewById(R.h.cAV);
                view.setTag(aVar2);
            } else {
                view = View.inflate(this.context, R.i.cZz, null);
                aVar2 = new a();
                aVar2.mTs = (TextView) view.findViewById(R.h.bGk);
                aVar2.kwV = (MaskLayout) view.findViewById(R.h.bGi);
                aVar2.jZz = (TextView) view.findViewById(R.h.bGm);
                aVar2.ipy = (CheckBox) view.findViewById(R.h.bGn);
                aVar2.waa = (TextView) view.findViewById(R.h.bGg);
                view.setTag(aVar2);
            }
            if (Ck) {
                if (this.wsc) {
                    aVar2.wsf.setVisibility(0);
                } else {
                    aVar2.wsf.setVisibility(8);
                }
                w.d("MicroMsg.SearchResultAdapter", "refresh  " + this.wsa);
                if ((this.hkm == null || this.hkm.size() == 0) && !this.wsa) {
                    aVar2.jZz.setText(this.context.getString(R.l.dCF));
                    aVar2.jZz.setTextColor(this.context.getResources().getColor(R.e.aUz));
                    return view;
                }
                aVar2.jZz.setText(this.context.getString(R.l.dCG));
                aVar2.jZz.setTextColor(com.tencent.mm.bg.a.S(this.context, R.e.aVa));
                return view;
            }
            if (this.hBf == null) {
                this.hBf = new com.tencent.mm.ui.applet.b.b(this) {
                    final /* synthetic */ b wsd;

                    {
                        this.wsd = r1;
                    }

                    public final String fE(int i) {
                        if (i < 0) {
                            w.e("MicroMsg.SearchResultAdapter", "pos is invalid");
                            return null;
                        }
                        awp Cj = this.wsd.Cj((this.wsd.ano() + i) + 1);
                        if (Cj != null) {
                            return Cj.ttp.tZr;
                        }
                        return null;
                    }

                    public final int Fh() {
                        return this.wsd.hkm == null ? 0 : this.wsd.hkm.size();
                    }
                };
            }
            if (this.hBe != null) {
                this.hBe.a((i - ano()) - 1, this.hBf);
            }
            awp Cj = Cj(i);
            aVar2.mTs.setVisibility(8);
            if (Cj == null) {
                return view;
            }
            aVar2.waa.setVisibility(8);
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) aVar2.kwV.view, Cj.ttp.tZr);
            if (Cj.tMP == 0) {
                aVar2.kwV.bSH();
            } else if (com.tencent.mm.u.ag.a.hlU != null) {
                eZ = com.tencent.mm.u.ag.a.hlU.eZ(Cj.tMP);
                if (eZ != null) {
                    aVar2.kwV.d(l.ik(eZ), com.tencent.mm.ui.base.MaskLayout.a.vnV);
                } else {
                    aVar2.kwV.bSH();
                }
            } else {
                aVar2.kwV.bSH();
            }
            try {
                aVar2.jZz.setText(h.b(this.context, bg.mz(Cj.tLj.tZr), aVar2.jZz.getTextSize()));
                return view;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SearchResultAdapter", e, "", new Object[0]);
                aVar2.jZz.setText("");
                return view;
            }
        } else if (this.showType == 2) {
            if (view == null) {
                view = View.inflate(this.context, R.i.dpy, null);
                aVar2 = new a();
                aVar2.jZz = (TextView) view.findViewById(R.h.bGm);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            af kO = kO(i);
            aVar.jZz.setTextColor(com.tencent.mm.bg.a.S(this.context, R.e.aVa));
            try {
                aVar.jZz.setText(h.b(this.context, this.context.getString(R.l.faS, new Object[]{n.a(kO, kO.field_username)}), aVar.jZz.getTextSize()));
            } catch (Exception e2) {
                aVar.jZz.setText("");
            }
            aVar.jZz.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            return view;
        } else {
            View view2;
            View inflate;
            if (view != null) {
                aVar = (a) view.getTag();
                view2 = aVar == null ? null : view;
            } else {
                aVar = null;
                view2 = view;
            }
            if (view2 == null) {
                inflate = r.eC(this.context).inflate(R.i.cZz, null);
                aVar2 = new a();
                aVar2.mTs = (TextView) inflate.findViewById(R.h.bGk);
                aVar2.kwV = (MaskLayout) inflate.findViewById(R.h.bGi);
                aVar2.jZz = (TextView) inflate.findViewById(R.h.bGm);
                aVar2.ipy = (CheckBox) inflate.findViewById(R.h.bGn);
                aVar2.waa = (TextView) inflate.findViewById(R.h.bGg);
                inflate.setTag(aVar2);
            } else {
                inflate = view2;
                aVar2 = aVar;
            }
            af kO2 = kO(i);
            if (aVar2.mTs != null) {
                aVar2.mTs.setVisibility(8);
            }
            aVar2.jZz.setTextColor(com.tencent.mm.bg.a.S(this.context, !o.fE(kO2.field_username) ? R.e.aVa : R.e.aVb));
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) aVar2.kwV.view, kO2.field_username);
            aVar2.waa.setVisibility(8);
            if (kO2.field_verifyFlag == 0) {
                aVar2.kwV.bSH();
            } else if (com.tencent.mm.u.ag.a.hlU != null) {
                eZ = com.tencent.mm.u.ag.a.hlU.eZ(kO2.field_verifyFlag);
                if (eZ != null) {
                    aVar2.kwV.d(l.ik(eZ), com.tencent.mm.ui.base.MaskLayout.a.vnV);
                } else {
                    aVar2.kwV.bSH();
                }
            } else {
                aVar2.kwV.bSH();
            }
            try {
                aVar2.jZz.setText(h.b(this.context, n.a(kO2, kO2.field_username), aVar2.jZz.getTextSize()));
            } catch (Exception e3) {
                aVar2.jZz.setText("");
            }
            return inflate;
        }
    }

    public final void OK() {
        aa(new Runnable(this) {
            final /* synthetic */ b wsd;

            {
                this.wsd = r1;
            }

            public final void run() {
                int i = 0;
                b bVar;
                if (this.wsd.vvh != null && this.wsd.vvh.length != 0) {
                    List arrayList = new ArrayList();
                    String[] g = this.wsd.vvh;
                    int length = g.length;
                    while (i < length) {
                        String str = g[i];
                        if (this.wsd.Ux(str)) {
                            arrayList.add(str);
                        }
                        i++;
                    }
                    if (arrayList.size() > 0) {
                        b bVar2 = this.wsd;
                        ap.yY();
                        bVar2.setCursor(c.wR().a((String[]) arrayList.toArray(new String[arrayList.size()]), this.wsd.vUP, this.wsd.jBA));
                        return;
                    }
                    bVar = this.wsd;
                    ap.yY();
                    bVar.setCursor(c.wR().aKg());
                } else if (this.wsd.wrX == null) {
                    bVar = this.wsd;
                    ap.yY();
                    bVar.setCursor(c.wR().aKg());
                } else if (this.wsd.vUP.equals("@all.chatroom.contact")) {
                    Cursor a = ap.yY().hkL.a(this.wsd.wrX, "@micromsg.with.all.biz.qq.com", this.wsd.jBA, false);
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    while (a.moveToNext()) {
                        String string = a.getString(a.getColumnIndex("username"));
                        if (string.endsWith("@chatroom")) {
                            arrayList3.add(string);
                        } else {
                            arrayList2.add(string);
                        }
                    }
                    if (!a.isClosed()) {
                        a.close();
                    }
                    if (arrayList2.size() == 0 && arrayList3.size() == 0) {
                        ap.yY();
                        a = c.wR().aKg();
                    } else {
                        a = ap.yY().hkL.a(this.wsd.wrX, arrayList2, null, arrayList3, this.wsd.jBA);
                    }
                    this.wsd.setCursor(a);
                } else {
                    this.wsd.setCursor(ap.yY().hkL.a(this.wsd.wrX, this.wsd.vUP, this.wsd.jBA, true));
                }
            }
        });
    }

    protected final void OL() {
        aEW();
        OK();
    }

    public final void onResume() {
        ap.vd().a((int) MMGIFException.D_GIF_ERR_NO_COLOR_MAP, (e) this);
    }

    public final void onPause() {
        ap.vd().b((int) MMGIFException.D_GIF_ERR_NO_COLOR_MAP, (e) this);
    }

    public final void cW(List<String> list) {
        this.vvh = (String[]) list.toArray(new String[list.size()]);
        this.wrX = null;
        aEW();
        OK();
    }

    public static String Uw(String str) {
        String trim = str.trim();
        if (trim.startsWith("@")) {
            trim = trim.substring(1) + "%@micromsg.with.all.biz.qq.com";
        }
        w.d("MicroMsg.SearchResultAdapter", "translateQueryText [" + trim + "]");
        return trim;
    }

    public final void a(int i, int i2, String str, final com.tencent.mm.y.k kVar) {
        w.d("MicroMsg.SearchResultAdapter", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() != MMGIFException.D_GIF_ERR_NO_COLOR_MAP) {
            w.e("MicroMsg.SearchResultAdapter", "error type");
            return;
        }
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        this.wsc = false;
        if (com.tencent.mm.ui.p.a.a(this.context, i, i2, str, 7)) {
            this.wsa = false;
        } else if (i == 4 && i2 == -4) {
            aa(new Runnable(this) {
                final /* synthetic */ b wsd;

                {
                    this.wsd = r1;
                }

                public final void run() {
                    this.wsd.wsa = false;
                }
            });
        } else if (i == 0 && i2 == 0) {
            aa(new Runnable(this) {
                final /* synthetic */ b wsd;

                public final void run() {
                    awr Jx = ((aa) kVar).Jx();
                    w.d("MicroMsg.SearchResultAdapter", "count " + Jx.tDR);
                    if (Jx.tDR > 0) {
                        for (awp com_tencent_mm_protocal_c_awp : Jx.tDS) {
                            if (o.eW(com_tencent_mm_protocal_c_awp.tMP)) {
                                if (this.wsd.hkm == null) {
                                    this.wsd.hkm = new LinkedList();
                                }
                                this.wsd.hkm.add(com_tencent_mm_protocal_c_awp);
                            }
                        }
                    } else {
                        String a = com.tencent.mm.platformtools.n.a(Jx.ttp);
                        w.d("MicroMsg.SearchResultAdapter", "user " + a);
                        if (bg.mz(a).length() > 0) {
                            awp com_tencent_mm_protocal_c_awp2 = new awp();
                            com_tencent_mm_protocal_c_awp2.ttp = Jx.ttp;
                            com_tencent_mm_protocal_c_awp2.tMP = Jx.tMP;
                            com_tencent_mm_protocal_c_awp2.hAG = Jx.hAG;
                            com_tencent_mm_protocal_c_awp2.tLj = Jx.tLj;
                            com_tencent_mm_protocal_c_awp2.hAI = Jx.hAI;
                            com_tencent_mm_protocal_c_awp2.hAM = Jx.hAM;
                            com_tencent_mm_protocal_c_awp2.hAF = Jx.hAF;
                            com_tencent_mm_protocal_c_awp2.hAE = Jx.hAE;
                            com_tencent_mm_protocal_c_awp2.hAD = Jx.hAD;
                            com_tencent_mm_protocal_c_awp2.tMQ = Jx.tMQ;
                            com_tencent_mm_protocal_c_awp2.tMT = Jx.tMT;
                            com_tencent_mm_protocal_c_awp2.tMR = Jx.tMR;
                            com_tencent_mm_protocal_c_awp2.tMS = Jx.tMS;
                            com_tencent_mm_protocal_c_awp2.tMV = Jx.tMV;
                            com.tencent.mm.x.n.Bl().g(a, com.tencent.mm.platformtools.n.a(Jx.tfh));
                            if (this.wsd.hkm == null) {
                                this.wsd.hkm = new LinkedList();
                            }
                            this.wsd.hkm.clear();
                            if (o.eW(com_tencent_mm_protocal_c_awp2.tMP)) {
                                this.wsd.hkm.add(com_tencent_mm_protocal_c_awp2);
                            }
                            w.d("MicroMsg.SearchResultAdapter", "count " + this.wsd.hkm.size());
                        }
                    }
                    this.wsd.wsa = false;
                }
            });
        } else {
            aa(new Runnable(this) {
                final /* synthetic */ b wsd;

                {
                    this.wsd = r1;
                }

                public final void run() {
                    this.wsd.wsa = false;
                }
            });
        }
    }

    public final void aa(final Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            notifyDataSetChanged();
            return;
        }
        com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
            final /* synthetic */ b wsd;

            public final void run() {
                runnable.run();
                this.wsd.notifyDataSetChanged();
            }
        });
    }

    public final boolean Ux(String str) {
        if (!(this.jBA == null || str == null)) {
            for (String equals : this.jBA) {
                if (equals.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }
}
