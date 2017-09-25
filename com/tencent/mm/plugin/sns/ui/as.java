package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.rk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public final class as extends BaseAdapter {
    private String country;
    boolean fJm = false;
    private Activity fPi;
    List<m> fRK = new ArrayList();
    String lri = "";
    private String naR = "";
    private an qER;
    Map<Integer, Integer> qES = new HashMap();
    private f qET;
    boolean qEU = false;
    at qEV;
    private c qEW;
    int qEX = Integer.MAX_VALUE;
    int qEY = 0;
    private long qEZ = 0;
    private long qFa = 0;
    int qFb = 0;
    protected OnClickListener qFc = new OnClickListener(this) {
        final /* synthetic */ as qFe;

        {
            this.qFe = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof bfc) {
                bfc com_tencent_mm_protocal_c_bfc = (bfc) view.getTag();
                if (as.GW(com_tencent_mm_protocal_c_bfc.mQY)) {
                    g.oUh.A(10231, "1");
                    com.tencent.mm.am.b.HH();
                } else {
                    g.oUh.A(10090, "1,0");
                    if (!(com.tencent.mm.n.a.aJ(this.qFe.fPi) || com.tencent.mm.n.a.aH(this.qFe.fPi))) {
                        anf a = ((com.tencent.mm.am.a.a) h.h(com.tencent.mm.am.a.a.class)).a(ae.xv(), com_tencent_mm_protocal_c_bfc, 8);
                        a.tRX = this.qFe.userName;
                        com.tencent.mm.am.b.b(a);
                    }
                }
                this.qFe.notifyDataSetChanged();
            }
        }
    };
    Map<Integer, Integer> qoV = new HashMap();
    Map<Integer, Integer> qoW = new HashMap();
    int qoX = 0;
    int qoY = 0;
    String qxe = "";
    private ar qzL = null;
    private String userName = "";

    class a {
        final /* synthetic */ as qFe;
        View qFf;
        TextView qFg;
        TextView qFh;
        LinearLayout qFi;
        ImageView qFj;
        TextView qFk;
        LinearLayout qFl;
        TextView qFm;
        LinearLayout qpm;
        View qpn;

        a(as asVar) {
            this.qFe = asVar;
        }

        public void init() {
            this.qFg.setVisibility(8);
            this.qFh.setVisibility(8);
            this.qFi.setVisibility(4);
            this.qFj.setVisibility(4);
            this.qpn.setVisibility(8);
            this.qFk.setVisibility(8);
            this.qFl.setVisibility(8);
        }
    }

    public interface c {
    }

    static abstract class f {
        OnClickListener qFG = new OnClickListener(this) {
            final /* synthetic */ f qFK;

            {
                this.qFK = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() != null) {
                    w.d("MicroMsg.SnsphotoAdapter", "sign click");
                    this.qFK.qFJ = (a) view.getTag();
                    this.qFK.dd(this.qFK.qFJ.pRa, this.qFK.qFJ.position + 2);
                }
            }
        };
        OnClickListener qFH = new OnClickListener(this) {
            final /* synthetic */ f qFK;

            {
                this.qFK = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() != null) {
                    w.d("MicroMsg.SnsphotoAdapter", "sign click");
                    this.qFK.qFJ = (a) view.getTag();
                    this.qFK.ub(this.qFK.qFJ.pRa);
                }
            }
        };
        OnClickListener qFI = new OnClickListener(this) {
            final /* synthetic */ f qFK;

            {
                this.qFK = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() != null) {
                    w.d("MicroMsg.SnsphotoAdapter", "snssight click");
                    this.qFK.qFJ = (a) view.getTag();
                    this.qFK.dd(this.qFK.qFJ.pRa, this.qFK.qFJ.position + 2);
                }
            }
        };
        public a qFJ = new a();
        OnClickListener qpd = new OnClickListener(this) {
            final /* synthetic */ f qFK;

            {
                this.qFK = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() != null) {
                    this.qFK.qFJ = (a) view.getTag();
                    this.qFK.dc(this.qFK.qFJ.pRa, this.qFK.qFJ.position);
                }
            }
        };
        OnClickListener qpe = new OnClickListener(this) {
            final /* synthetic */ f qFK;

            {
                this.qFK = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() != null) {
                    this.qFK.qFJ = (a) view.getTag();
                    this.qFK.dc(this.qFK.qFJ.pRa, this.qFK.qFJ.position + 1);
                }
            }
        };
        OnClickListener qpf = new OnClickListener(this) {
            final /* synthetic */ f qFK;

            {
                this.qFK = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() != null) {
                    this.qFK.qFJ = (a) view.getTag();
                    this.qFK.dc(this.qFK.qFJ.pRa, this.qFK.qFJ.position + 2);
                }
            }
        };

        public static class a {
            public int pRa;
            public int position;
        }

        public abstract void dc(int i, int i2);

        public abstract void dd(int i, int i2);

        public abstract void ub(int i);
    }

    class b extends a {
        TextView ioX;
        TextView mVG;
        final /* synthetic */ as qFe;
        TagImageView qFn;
        TextView qFo;
        View qFp;
        ImageView qpP;

        b(as asVar) {
            this.qFe = asVar;
            super(asVar);
        }

        public final void init() {
            super.init();
            this.mVG.setVisibility(8);
            this.qFn.setVisibility(8);
            this.qpP.setVisibility(8);
            this.ioX.setVisibility(8);
            this.qFo.setVisibility(8);
        }
    }

    class d extends a {
        TextView qFA;
        TextView qFB;
        TextView qFC;
        TextView qFD;
        TextView qFE;
        MaskLinearLayout qFF;
        final /* synthetic */ as qFe;
        MaskImageView qFq;
        QFadeImageView qFr;
        QFadeImageView qFs;
        QFadeImageView qFt;
        TextView qFu;
        TextView qFv;
        TextView qFw;
        TextView qFx;
        View qFy;
        TextView qFz;
        TextView qhN;

        d(as asVar) {
            this.qFe = asVar;
            super(asVar);
        }

        public final void init() {
            super.init();
            this.qFq.setVisibility(8);
            this.qFs.setVisibility(8);
            this.qFt.setVisibility(8);
            this.qhN.setVisibility(8);
            this.qFu.setVisibility(8);
            this.qFv.setVisibility(8);
            this.qFw.setVisibility(8);
            this.qFx.setVisibility(8);
            this.qFy.setVisibility(8);
            this.qFr.setVisibility(8);
            this.qFz.setVisibility(8);
            this.qFA.setVisibility(8);
            this.qFB.setVisibility(8);
            this.qFC.setVisibility(8);
            this.qFD.setVisibility(8);
            this.qFE.setVisibility(8);
            if (v.dI(this.qFe.fPi) > 1.0f) {
                this.qhN.setMaxLines(2);
            }
        }
    }

    class e extends a {
        MaskLinearLayout qFF;
        final /* synthetic */ as qFe;
        MaskImageView qFq;
        View qFy;
        TextView qFz;
        TextView qhN;

        e(as asVar) {
            this.qFe = asVar;
            super(asVar);
        }

        public final void init() {
            super.init();
            this.qFq.setVisibility(8);
            this.qhN.setVisibility(8);
            this.qFz.setVisibility(8);
            this.qFy.setVisibility(8);
            if (v.dI(this.qFe.fPi) > 1.0f) {
                this.qhN.setMaxLines(2);
            }
        }
    }

    public final void dL(long j) {
        if (0 == this.qEZ) {
            this.qEZ = j;
            this.qFa = 0;
        }
    }

    public as(Activity activity, f fVar, String str, final c cVar) {
        this.userName = str;
        this.fPi = activity;
        this.qET = fVar;
        this.qEW = cVar;
        this.qzL = ae.bez();
        String d = com.tencent.mm.sdk.platformtools.v.d(this.fPi.getSharedPreferences(ab.bIX(), 0));
        w.d("MicroMsg.SnsphotoAdapter", "filterLan temp " + d);
        if (!(d.equals("zh_CN") || d.equals("en") || d.equals("zh_TW"))) {
            d = d.equals("zh_HK") ? "zh_TW" : "en";
        }
        this.naR = d;
        this.country = com.tencent.mm.sdk.platformtools.v.d(this.fPi.getSharedPreferences(ab.bIX(), 0));
        h.vJ();
        if (this.userName.equals((String) h.vI().vr().get(2, null))) {
            this.fJm = true;
        }
        w.d("MicroMsg.SnsphotoAdapter", "SnsphotoAdapter : userName : " + this.userName + " country: " + this.country);
        if (this.fJm) {
            this.qER = an.bLT();
        } else {
            h.vJ();
            af Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(str);
            if (Rc == null || !com.tencent.mm.j.a.ez(Rc.field_type)) {
                this.qER = an.bLU();
            } else {
                this.qER = an.bLS();
            }
        }
        this.qEV = new at(new com.tencent.mm.plugin.sns.ui.at.b(this) {
            final /* synthetic */ as qFe;

            public final void a(List<m> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, int i, int i2) {
                w.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
                as asVar = this.qFe;
                w.d("MicroMsg.SnsphotoAdapter", "setSnsList the thread id is " + Thread.currentThread().getId());
                if (list != null && list.size() > 0) {
                    int i3;
                    w.d("MicroMsg.SnsphotoAdapter", "copy list info");
                    int size = list.size();
                    asVar.fRK.clear();
                    asVar.qoV.clear();
                    asVar.qoW.clear();
                    asVar.qES.clear();
                    for (i3 = 0; i3 < size; i3++) {
                        asVar.fRK.add(m.x((m) list.get(i3)));
                    }
                    for (Integer intValue : map.keySet()) {
                        size = intValue.intValue();
                        asVar.qoV.put(Integer.valueOf(size), Integer.valueOf(((Integer) map.get(Integer.valueOf(size))).intValue()));
                    }
                    for (Integer intValue2 : map2.keySet()) {
                        size = intValue2.intValue();
                        asVar.qoW.put(Integer.valueOf(size), Integer.valueOf(((Integer) map2.get(Integer.valueOf(size))).intValue()));
                    }
                    for (Integer intValue22 : map3.keySet()) {
                        size = intValue22.intValue();
                        asVar.qES.put(Integer.valueOf(size), Integer.valueOf(((Integer) map3.get(Integer.valueOf(size))).intValue()));
                    }
                    map.clear();
                    map2.clear();
                    if (asVar.fJm) {
                        i3 = asVar.fRK.size() <= 1 ? Integer.MAX_VALUE : ((m) asVar.fRK.get(1)).field_head;
                    } else {
                        i3 = asVar.fRK.isEmpty() ? Integer.MAX_VALUE : ((m) asVar.fRK.get(0)).field_head;
                    }
                    asVar.qEX = 0;
                    size = 0;
                    while (size < asVar.fRK.size()) {
                        if (!asVar.fJm || size != 0) {
                            if (i3 != ((m) asVar.fRK.get(size)).field_head) {
                                break;
                            }
                            asVar.qEX = Math.max(asVar.qEX, ((m) asVar.fRK.get(size)).field_createTime);
                        }
                        size++;
                    }
                    if (asVar.fRK.isEmpty() || (asVar.fJm && asVar.fRK.size() == 1)) {
                        asVar.qEX = Integer.MAX_VALUE;
                    }
                    i3 = asVar.fRK.isEmpty() ? 0 : ((m) asVar.fRK.get(asVar.fRK.size() - 1)).field_head;
                    asVar.qEY = Integer.MAX_VALUE;
                    int size2 = asVar.fRK.size() - 1;
                    while (size2 >= 0 && i3 != 0 && i3 == ((m) asVar.fRK.get(size2)).field_head) {
                        asVar.qEY = Math.min(asVar.qEY, ((m) asVar.fRK.get(size2)).field_createTime);
                        size2--;
                    }
                    if (asVar.fRK.isEmpty()) {
                        asVar.qEY = 0;
                    }
                    asVar.qoY = i;
                    asVar.qoX = i2;
                    w.d("MicroMsg.SnsphotoAdapter", "reallyCount " + i + " icount " + i2 + " stTime " + asVar.qEX + " edTIme " + asVar.qEY);
                    asVar.notifyDataSetChanged();
                }
            }

            public final void bkJ() {
                this.qFe.notifyDataSetChanged();
            }
        }, str, this.fJm);
        dM(0);
        hL(false);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        w.i("MicroMsg.SnsphotoAdapter", "position " + itemViewType);
        d dVar;
        int i2;
        m mVar;
        int i3;
        bfc bhd;
        CharSequence charSequence;
        a aVar;
        a aVar2;
        if (itemViewType == 0) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof d)) {
                dVar = new d(this);
                view = r.eC(this.fPi).inflate(i.g.pHS, null);
                dVar.qFh = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pEI);
                dVar.qFg = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pFf);
                dVar.qFq = (MaskImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pCM);
                dVar.qFr = (QFadeImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGe);
                dVar.qFs = (MaskImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pCN);
                dVar.qFt = (MaskImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pCO);
                dVar.qhN = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.bHZ);
                dVar.qFu = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGy);
                dVar.qFv = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGz);
                dVar.qFw = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGA);
                dVar.qFx = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pCQ);
                dVar.qFy = view.findViewById(com.tencent.mm.plugin.sns.i.f.pCn);
                dVar.qFk = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.cTF);
                dVar.qFi = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.pDc);
                dVar.qFj = (ImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pDk);
                dVar.qpm = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.pDe);
                dVar.qpn = view.findViewById(com.tencent.mm.plugin.sns.i.f.pDb);
                dVar.qFr.setOnClickListener(this.qET.qpd);
                dVar.qFq.setOnClickListener(this.qET.qpd);
                dVar.qFs.setOnClickListener(this.qET.qpe);
                dVar.qFt.setOnClickListener(this.qET.qpf);
                dVar.qFz = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGs);
                dVar.qFA = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGt);
                dVar.qFB = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGu);
                dVar.qFC = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGk);
                dVar.qFD = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGl);
                dVar.qFE = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGm);
                dVar.qFF = (MaskLinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.pFc);
                dVar.qFF.b(dVar.qFq);
                dVar.qFl = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.pCz);
                dVar.qFm = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pFs);
                dVar.qFm.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ as qFe;

                    {
                        this.qFe = r1;
                    }

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("enter_scene", com.tencent.mm.ui.d.d.uOB);
                        com.tencent.mm.bb.d.b(this.qFe.fPi, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                        g.oUh.i(14098, new Object[]{Integer.valueOf(8)});
                    }
                });
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            ae.beI().cn(dVar.qFq);
            ae.beI().cn(dVar.qFs);
            ae.beI().cn(dVar.qFt);
            i2 = -1;
            if (this.qoV.get(Integer.valueOf(i)) != null) {
                i2 = ((Integer) this.qoV.get(Integer.valueOf(i))).intValue();
            }
            dVar.init();
            dVar.qFF.fFU = false;
            dVar.qFF.setBackgroundResource(0);
            dVar.qFF.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            dVar.qFF.setClickable(false);
            dVar.qFq.fFU = true;
            dVar.qFq.setClickable(true);
            dVar.qFF.setOnClickListener(null);
            if (i2 >= this.qoY || i2 == -1) {
                view.setLayoutParams(new LayoutParams(-1, 1));
                view.setVisibility(8);
            } else {
                if (i2 - 1 >= 0) {
                    mVar = (m) getItem(i2 - 1);
                    i3 = mVar.field_head;
                    ai.O(mVar.field_localPrivate, this.fJm);
                } else {
                    i3 = -1;
                }
                view.setLayoutParams(new LayoutParams(-1, -2));
                view.setVisibility(0);
                int intValue = this.qoW.get(Integer.valueOf(i)) != null ? ((Integer) this.qoW.get(Integer.valueOf(i))).intValue() : 1;
                m mVar2 = (m) getItem(i2);
                bhd = mVar2.bhd();
                if ((this.fJm && i == 0) || r4 == -1 || mVar2.field_head != r4) {
                    a(dVar.qFg, dVar.qFh, (long) mVar2.field_createTime);
                    if (bhd.ufz != null) {
                        charSequence = bhd.ufz.hAF;
                        if (!(charSequence == null || charSequence.equals(""))) {
                            dVar.qFk.setText(charSequence);
                            dVar.qFk.setVisibility(0);
                        }
                    }
                    dVar.qpn.setVisibility(0);
                }
                if (this.qFa != 0 && mVar2.field_snsId == this.qFa) {
                    dVar.qFl.setVisibility(0);
                } else if (this.qFa != 0 || this.qEZ == 0 || mVar2.field_snsId > this.qEZ) {
                    dVar.qFl.setVisibility(8);
                } else {
                    dVar.qFl.setVisibility(0);
                    this.qFa = mVar2.field_snsId;
                }
                dVar.qFi.setVisibility(0);
                if (this.fJm && i == 0) {
                    dVar.qFr.setVisibility(0);
                    dVar.qFr.setContentDescription(this.fPi.getString(j.pMG));
                    dVar.qFq.setVisibility(8);
                    dVar.qhN.setText(this.qoX == 1 ? this.fPi.getString(j.pMX) : "");
                    dVar.qhN.setVisibility(0);
                    dVar.qFy.setVisibility(0);
                    dVar.qFx.setVisibility(8);
                    ae.beI().a(dVar.qFr, com.tencent.mm.plugin.sns.i.c.hbu, com.tencent.mm.plugin.sns.i.e.pAr, this.fPi.hashCode());
                    aVar = new a();
                    aVar.pRa = -1;
                    aVar.position = -1;
                    dVar.qFr.setTag(aVar);
                } else {
                    if (intValue > 0) {
                        a(i2, dVar.qFq, dVar.qFu, dVar.qFx, dVar.qFz, dVar.qFC, 1, dVar, i);
                    }
                    if (intValue >= 2) {
                        a(i2 + 1, dVar.qFs, dVar.qFv, dVar.qFx, dVar.qFA, dVar.qFD, 2, dVar, i);
                    }
                    if (intValue >= 3) {
                        a(i2 + 2, dVar.qFt, dVar.qFw, dVar.qFx, dVar.qFB, dVar.qFE, 3, dVar, i);
                    }
                    if (intValue == 1) {
                        mVar = (m) getItem(i2);
                        if (!bg.mA(mVar.bhd().ufy) && mVar.field_type == 1) {
                            dVar.qFF.setDescendantFocusability(393216);
                            dVar.qFF.setClickable(true);
                            dVar.qFq.setClickable(false);
                            dVar.qFq.fFU = false;
                            dVar.qFF.setOnClickListener(this.qET.qpd);
                            dVar.qFF.fFU = true;
                            itemViewType = mVar2.qnk;
                            aVar2 = new a();
                            aVar2.pRa = itemViewType;
                            if (this.qES.get(Integer.valueOf(i)) != null) {
                                aVar2.position = ((Integer) this.qES.get(Integer.valueOf(i))).intValue();
                            } else {
                                aVar2.position = 0;
                            }
                            dVar.qFF.setTag(aVar2);
                        }
                    }
                    view.setDrawingCacheEnabled(false);
                }
            }
        } else {
            if (itemViewType == 2) {
                e eVar;
                if (view == null || view.getTag() == null || !(view.getTag() instanceof e)) {
                    e eVar2 = new e(this);
                    view = r.eC(this.fPi).inflate(i.g.pIc, null);
                    eVar2.qFh = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pEI);
                    eVar2.qFg = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pFf);
                    eVar2.qFq = (MaskImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pCM);
                    eVar2.qFk = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.cTF);
                    eVar2.qFi = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.pDc);
                    eVar2.qFj = (ImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pDk);
                    eVar2.qpm = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.pDe);
                    eVar2.qpn = view.findViewById(com.tencent.mm.plugin.sns.i.f.pDb);
                    eVar2.qFq.setOnClickListener(this.qET.qFI);
                    eVar2.qFz = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGs);
                    eVar2.qFF = (MaskLinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.pFc);
                    eVar2.qFF.b(eVar2.qFq);
                    eVar2.qhN = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.bHZ);
                    eVar2.qFy = view.findViewById(com.tencent.mm.plugin.sns.i.f.pCn);
                    eVar2.qFl = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.pCz);
                    eVar2.qFm = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pFs);
                    eVar2.qFm.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ as qFe;

                        {
                            this.qFe = r1;
                        }

                        public final void onClick(View view) {
                            Intent intent = new Intent();
                            intent.putExtra("enter_scene", com.tencent.mm.ui.d.d.uOB);
                            com.tencent.mm.bb.d.b(this.qFe.fPi, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                            g.oUh.i(14098, new Object[]{Integer.valueOf(8)});
                        }
                    });
                    view.setTag(eVar2);
                    eVar = eVar2;
                } else {
                    eVar = (e) view.getTag();
                }
                ae.beI().cn(eVar.qFq);
                int intValue2 = this.qoV.get(Integer.valueOf(i)) != null ? ((Integer) this.qoV.get(Integer.valueOf(i))).intValue() : -1;
                eVar.init();
                eVar.qFF.fFU = false;
                eVar.qFF.setBackgroundResource(0);
                eVar.qFF.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                eVar.qFF.setClickable(false);
                eVar.qFq.fFU = true;
                eVar.qFq.setClickable(true);
                eVar.qFF.setOnClickListener(null);
                if (intValue2 >= this.qoY || intValue2 == -1) {
                    view.setLayoutParams(new LayoutParams(-1, 1));
                    view.setVisibility(8);
                } else {
                    if (intValue2 - 1 >= 0) {
                        mVar = (m) getItem(intValue2 - 1);
                        i2 = mVar.field_head;
                        ai.O(mVar.field_localPrivate, this.fJm);
                    } else {
                        i2 = -1;
                    }
                    view.setLayoutParams(new LayoutParams(-1, -2));
                    view.setVisibility(0);
                    if (this.qoW.get(Integer.valueOf(i)) != null) {
                        ((Integer) this.qoW.get(Integer.valueOf(i))).intValue();
                    }
                    m mVar3 = (m) getItem(intValue2);
                    bfc bhd2 = mVar3.bhd();
                    if ((this.fJm && i == 0) || r3 == -1 || mVar3.field_head != r3) {
                        a(eVar.qFg, eVar.qFh, (long) mVar3.field_createTime);
                        if (bhd2.ufz != null) {
                            charSequence = bhd2.ufz.hAF;
                            if (!(charSequence == null || charSequence.equals(""))) {
                                eVar.qFk.setText(charSequence);
                                eVar.qFk.setVisibility(0);
                            }
                        }
                        eVar.qpn.setVisibility(0);
                    }
                    if (this.qFa != 0 && mVar3.field_snsId == this.qFa) {
                        eVar.qFl.setVisibility(0);
                    } else if (this.qFa != 0 || this.qEZ == 0 || mVar3.field_snsId > this.qEZ) {
                        eVar.qFl.setVisibility(8);
                    } else {
                        eVar.qFl.setVisibility(0);
                        this.qFa = mVar3.field_snsId;
                    }
                    eVar.qFi.setVisibility(0);
                    ai.n(mVar3);
                    an anVar = new an(this.qER.tag);
                    anVar.cIm = mVar3.field_createTime;
                    eVar.qFq.setVisibility(0);
                    ae.beI().a(bhd2.ufB.tsO, eVar.qFq, this.fPi.hashCode(), com.tencent.mm.plugin.sns.model.g.a.pTx, anVar);
                    if (ai.O(mVar3.field_localPrivate, this.fJm)) {
                        eVar.qFz.setVisibility(0);
                        eVar.qFz.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.pzZ);
                        com.tencent.mm.j.a Rc = this.qzL.Rc(mVar3.field_userName);
                        if (Rc != null) {
                            Rc.tL();
                        }
                    }
                    charSequence = ((m) getItem(intValue2)).bhd().ufy;
                    if (!(charSequence == null || charSequence.equals(""))) {
                        eVar.qFy.setVisibility(0);
                        eVar.qhN.setVisibility(0);
                        eVar.qhN.setText(charSequence);
                        eVar.qhN.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.fPi, charSequence, eVar.qhN.getTextSize()));
                    }
                    eVar.qFF.setDescendantFocusability(393216);
                    eVar.qFF.setClickable(true);
                    eVar.qFq.setClickable(false);
                    eVar.qFq.fFU = false;
                    eVar.qFF.setOnClickListener(this.qET.qFI);
                    eVar.qFF.fFU = true;
                    itemViewType = mVar3.qnk;
                    aVar2 = new a();
                    aVar2.pRa = itemViewType;
                    if (this.qES.get(Integer.valueOf(i)) != null) {
                        aVar2.position = ((Integer) this.qES.get(Integer.valueOf(i))).intValue();
                    } else {
                        aVar2.position = 0;
                    }
                    eVar.qFF.setTag(aVar2);
                }
            } else if (itemViewType == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof d)) {
                    dVar = new d(this);
                    view = r.eC(this.fPi).inflate(i.g.pHS, null);
                    dVar.qFh = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pEI);
                    dVar.qFg = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pFf);
                    dVar.qFq = (MaskImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pCM);
                    dVar.qFr = (QFadeImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGe);
                    dVar.qFs = (MaskImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pCN);
                    dVar.qFt = (MaskImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pCO);
                    dVar.qhN = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.bHZ);
                    dVar.qFu = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGy);
                    dVar.qFv = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGz);
                    dVar.qFw = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGA);
                    dVar.qFx = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pCQ);
                    dVar.qFy = view.findViewById(com.tencent.mm.plugin.sns.i.f.pCn);
                    dVar.qFk = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.cTF);
                    dVar.qFi = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.pDc);
                    dVar.qFj = (ImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pDk);
                    dVar.qpm = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.pDe);
                    dVar.qpn = view.findViewById(com.tencent.mm.plugin.sns.i.f.pDb);
                    dVar.qFr.setOnClickListener(this.qET.qFH);
                    dVar.qFq.setOnClickListener(this.qET.qFH);
                    dVar.qFz = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGs);
                    dVar.qFA = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGt);
                    dVar.qFB = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGu);
                    dVar.qFC = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGk);
                    dVar.qFD = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGl);
                    dVar.qFE = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGm);
                    dVar.qFF = (MaskLinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.pFc);
                    dVar.qFF.b(dVar.qFq);
                    dVar.qFl = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.pCz);
                    dVar.qFm = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pFs);
                    dVar.qFm.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ as qFe;

                        {
                            this.qFe = r1;
                        }

                        public final void onClick(View view) {
                            Intent intent = new Intent();
                            intent.putExtra("enter_scene", com.tencent.mm.ui.d.d.uOB);
                            com.tencent.mm.bb.d.b(this.qFe.fPi, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                            g.oUh.i(14098, new Object[]{Integer.valueOf(8)});
                        }
                    });
                    view.setTag(dVar);
                } else {
                    dVar = (d) view.getTag();
                }
                ae.beI().cn(dVar.qFq);
                ae.beI().cn(dVar.qFs);
                ae.beI().cn(dVar.qFt);
                i2 = -1;
                if (this.qoV.get(Integer.valueOf(i)) != null) {
                    i2 = ((Integer) this.qoV.get(Integer.valueOf(i))).intValue();
                }
                dVar.init();
                dVar.qFF.fFU = false;
                dVar.qFF.setBackgroundResource(0);
                dVar.qFF.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                dVar.qFF.setClickable(false);
                dVar.qFq.fFU = true;
                dVar.qFq.setClickable(true);
                dVar.qFF.setOnClickListener(null);
                if (i2 >= this.qoY || i2 == -1) {
                    view.setLayoutParams(new LayoutParams(-1, 1));
                    view.setVisibility(8);
                } else {
                    if (i2 - 1 >= 0) {
                        mVar = (m) getItem(i2 - 1);
                        i3 = mVar.field_head;
                        ai.O(mVar.field_localPrivate, this.fJm);
                    } else {
                        i3 = -1;
                    }
                    view.setLayoutParams(new LayoutParams(-1, -2));
                    view.setVisibility(0);
                    m mVar4 = (m) getItem(i2);
                    bhd = mVar4.bhd();
                    if ((this.fJm && i == 0) || r4 == -1 || mVar4.field_head != r4) {
                        a(dVar.qFg, dVar.qFh, (long) mVar4.field_createTime);
                        if (bhd.ufz != null) {
                            charSequence = bhd.ufz.hAF;
                            if (!(charSequence == null || charSequence.equals(""))) {
                                dVar.qFk.setText(charSequence);
                                dVar.qFk.setVisibility(0);
                            }
                        }
                        dVar.qpn.setVisibility(0);
                    }
                    if (this.qFa != 0 && mVar4.field_snsId == this.qFa) {
                        dVar.qFl.setVisibility(0);
                    } else if (this.qFa != 0 || this.qEZ == 0 || mVar4.field_snsId > this.qEZ) {
                        dVar.qFl.setVisibility(8);
                    } else {
                        dVar.qFl.setVisibility(0);
                        this.qFa = mVar4.field_snsId;
                    }
                    dVar.qFi.setVisibility(0);
                    if (this.fJm && i == 0) {
                        dVar.qFr.setVisibility(0);
                        dVar.qFr.setContentDescription(this.fPi.getString(j.pMG));
                        dVar.qFq.setVisibility(8);
                        dVar.qhN.setText(this.qoX == 1 ? this.fPi.getString(j.pMX) : "");
                        dVar.qhN.setVisibility(0);
                        dVar.qFy.setVisibility(0);
                        dVar.qFx.setVisibility(8);
                        ae.beI().a(dVar.qFr, com.tencent.mm.plugin.sns.i.c.hbu, com.tencent.mm.plugin.sns.i.e.pAr, this.fPi.hashCode());
                        aVar = new a();
                        aVar.pRa = -1;
                        aVar.position = -1;
                        dVar.qFr.setTag(aVar);
                    } else {
                        a(i2, dVar.qFq, dVar.qFu, dVar.qFx, dVar.qFz, dVar.qFC, 1, dVar, i);
                        mVar = (m) getItem(i2);
                        if (!bg.mA(mVar.bhd().ufy) && mVar.field_type == 1) {
                            dVar.qFF.setDescendantFocusability(393216);
                            dVar.qFF.setClickable(true);
                            dVar.qFq.setClickable(false);
                            dVar.qFq.fFU = false;
                            dVar.qFF.setOnClickListener(this.qET.qFH);
                            dVar.qFF.fFU = true;
                            itemViewType = mVar4.qnk;
                            aVar2 = new a();
                            aVar2.pRa = itemViewType;
                            if (this.qES.get(Integer.valueOf(i)) != null) {
                                aVar2.position = ((Integer) this.qES.get(Integer.valueOf(i))).intValue();
                            } else {
                                aVar2.position = 0;
                            }
                            dVar.qFF.setTag(aVar2);
                        }
                        view.setDrawingCacheEnabled(false);
                    }
                }
            } else {
                b bVar;
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    b bVar2 = new b(this);
                    view = r.eC(this.fPi).inflate(i.g.pHR, null);
                    bVar2.qFf = view.findViewById(com.tencent.mm.plugin.sns.i.f.hci);
                    bVar2.qFh = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pEI);
                    bVar2.qFg = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pFf);
                    bVar2.qFk = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.cTF);
                    bVar2.qpn = view.findViewById(com.tencent.mm.plugin.sns.i.f.pDb);
                    bVar2.qFk = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.cTF);
                    bVar2.qFi = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.pDc);
                    bVar2.qFj = (ImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pDk);
                    bVar2.qpm = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.pDe);
                    bVar2.mVG = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.bIb);
                    bVar2.qFn = (TagImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pCJ);
                    bVar2.qpP = (ImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.state);
                    bVar2.ioX = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pGi);
                    bVar2.qFo = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pDD);
                    bVar2.qFf.setOnClickListener(this.qET.qFG);
                    bVar2.qFp = view.findViewById(com.tencent.mm.plugin.sns.i.f.pDm);
                    bVar2.qFl = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.pCz);
                    bVar2.qFm = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pFs);
                    bVar2.qFm.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ as qFe;

                        {
                            this.qFe = r1;
                        }

                        public final void onClick(View view) {
                            Intent intent = new Intent();
                            intent.putExtra("enter_scene", com.tencent.mm.ui.d.d.uOB);
                            com.tencent.mm.bb.d.b(this.qFe.fPi, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                            g.oUh.i(14098, new Object[]{Integer.valueOf(8)});
                        }
                    });
                    view.setTag(bVar2);
                    com.tencent.mm.plugin.sns.data.i.b(bVar2.qFn, this.fPi);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                i2 = this.qoV.get(Integer.valueOf(i)) != null ? ((Integer) this.qoV.get(Integer.valueOf(i))).intValue() : -1;
                bVar.init();
                if (i2 >= this.qoY || i2 == -1) {
                    view.setLayoutParams(new LayoutParams(-1, 1));
                    view.setVisibility(8);
                } else {
                    view.setVisibility(0);
                    if (i2 - 1 >= 0) {
                        mVar = (m) getItem(i2 - 1);
                        i3 = mVar.field_head;
                        ai.O(mVar.field_localPrivate, this.fJm);
                    } else {
                        i3 = -1;
                    }
                    view.setLayoutParams(new LayoutParams(-1, -2));
                    view.setVisibility(0);
                    if (this.qoW.get(Integer.valueOf(i)) != null) {
                        ((Integer) this.qoW.get(Integer.valueOf(i))).intValue();
                    }
                    m mVar5 = (m) getItem(i2);
                    bfc bhd3 = mVar5.bhd();
                    if ((this.fJm && i == 0) || r4 == -1 || mVar5.field_head != r4) {
                        a(bVar.qFg, bVar.qFh, (long) mVar5.field_createTime);
                        if (bhd3.ufz != null) {
                            charSequence = bhd3.ufz.hAF;
                            if (!(charSequence == null || charSequence.equals(""))) {
                                bVar.qFk.setText(charSequence);
                                bVar.qFk.setVisibility(0);
                            }
                        }
                        bVar.qpn.setVisibility(0);
                    }
                    if (this.qFa != 0 && mVar5.field_snsId == this.qFa) {
                        bVar.qFl.setVisibility(0);
                    } else if (this.qFa != 0 || this.qEZ == 0 || mVar5.field_snsId > this.qEZ) {
                        bVar.qFl.setVisibility(8);
                    } else {
                        bVar.qFl.setVisibility(0);
                        this.qFa = mVar5.field_snsId;
                    }
                    a aVar3 = new a();
                    aVar3.pRa = mVar5.qnk;
                    if (this.qES.get(Integer.valueOf(i)) != null) {
                        aVar3.position = ((Integer) this.qES.get(Integer.valueOf(i))).intValue();
                    } else {
                        aVar3.position = 0;
                    }
                    bVar.qFf.setTag(aVar3);
                    if (bg.mA(bhd3.ufy)) {
                        bVar.mVG.setVisibility(8);
                    } else {
                        bVar.mVG.setVisibility(0);
                        bVar.mVG.setText(bhd3.ufy);
                        bVar.mVG.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.fPi, bhd3.ufy, bVar.mVG.getTextSize()));
                    }
                    bVar.qFi.setVisibility(0);
                    bVar.mVG.setSingleLine(true);
                    bVar.qFp.setVisibility(0);
                    itemViewType = bhd3.ufB.tsN;
                    an anVar2 = new an(this.qER.tag);
                    anVar2.cIm = mVar5.field_createTime;
                    if (itemViewType == 2) {
                        bVar.mVG.setVisibility(0);
                        bVar.mVG.setSingleLine(false);
                        bVar.mVG.setMaxLines(2);
                        bVar.qFp.setVisibility(8);
                    } else if (itemViewType != 4) {
                        CharSequence Hd;
                        CharSequence charSequence2;
                        bVar.ioX.setTextColor(this.fPi.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pyX));
                        if (((com.tencent.mm.plugin.sns.model.al.a.bfk() & 1) <= 0 ? 1 : null) != null) {
                            Hd = au.Hd(bhd3.ufB.msN);
                        } else {
                            Object obj = "";
                        }
                        String str = bhd3.ufB.fDC;
                        if (str == null || str.length() <= 40) {
                            Object obj2 = str;
                        } else {
                            charSequence2 = str.substring(0, 40) + "...";
                        }
                        if (bVar.qFn != null) {
                            bVar.qFn.setOnClickListener(null);
                        }
                        bVar.qpP.setVisibility(8);
                        if (bhd3.ufB.tsO.isEmpty()) {
                            bVar.qFn.setVisibility(8);
                        } else {
                            bVar.qFn.setVisibility(0);
                            r3 = (alh) bhd3.ufB.tsO.get(0);
                            if (bhd3.ufB.tsN == 5) {
                                Hd = au.Hd(r3.msN);
                                charSequence2 = r3.fDC;
                                bVar.qpP.setVisibility(0);
                                ae.beI().a(r3, bVar.qFn, i.i.dtr, this.fPi.hashCode(), com.tencent.mm.plugin.sns.model.g.a.pTx, anVar2);
                            } else {
                                ae.beI().a(r3, bVar.qFn, this.fPi.hashCode(), com.tencent.mm.plugin.sns.model.g.a.pTx, anVar2);
                            }
                        }
                        if (bg.mA(Hd)) {
                            bVar.qFo.setVisibility(8);
                        } else {
                            bVar.qFo.setVisibility(0);
                            bVar.qFo.setText(Hd);
                        }
                        if (bg.mA(charSequence2)) {
                            bVar.ioX.setVisibility(8);
                        } else {
                            if (bVar.qFo.getVisibility() == 8) {
                                bVar.ioX.setMaxLines(2);
                            } else {
                                bVar.ioX.setMaxLines(1);
                            }
                            bVar.ioX.setVisibility(0);
                            if ((bhd3.hhv & 1) > 0) {
                                bVar.ioX.setText(com.tencent.mm.plugin.sns.data.i.a(charSequence2, this.fPi, bVar.ioX));
                            } else {
                                bVar.ioX.setText(charSequence2);
                            }
                        }
                    } else if (bhd3.ufB.tsO.isEmpty()) {
                        bVar.qFp.setVisibility(8);
                    } else {
                        bVar.qFn.setVisibility(0);
                        bVar.qpP.setVisibility(0);
                        bVar.qFp.setVisibility(0);
                        bVar.ioX.setMaxLines(1);
                        bVar.ioX.setTextColor(this.fPi.getResources().getColor(com.tencent.mm.plugin.sns.i.c.aVS));
                        r3 = (alh) bhd3.ufB.tsO.get(0);
                        ae.beI().a(r3, bVar.qFn, i.i.dtg, this.fPi.hashCode(), com.tencent.mm.plugin.sns.model.g.a.pTx, anVar2);
                        bVar.qpP.setPressed(false);
                        if (GW(bhd3.mQY)) {
                            bVar.qpP.setImageResource(com.tencent.mm.plugin.sns.i.e.bho);
                        } else {
                            bVar.qpP.setImageResource(com.tencent.mm.plugin.sns.i.e.bhp);
                        }
                        bVar.qFn.setTag(bhd3);
                        bVar.qFn.setOnClickListener(this.qFc);
                        r3.pRa = mVar5.qnk;
                        bVar.qFp.setTag(bhd3);
                        charSequence = r3.msk;
                        if (bg.mA(charSequence)) {
                            bVar.qFo.setVisibility(4);
                        } else {
                            bVar.qFo.setVisibility(0);
                            bVar.qFo.setText(charSequence);
                        }
                        charSequence = r3.fDC;
                        if (bg.mA(charSequence)) {
                            bVar.ioX.setVisibility(8);
                        } else {
                            bVar.ioX.setVisibility(0);
                            bVar.ioX.setTag(aVar3);
                            bVar.ioX.setOnTouchListener(new aa());
                            bVar.ioX.setText(charSequence);
                        }
                    }
                }
            }
            view.setDrawingCacheEnabled(false);
        }
        return view;
    }

    public final int getCount() {
        return this.qoX;
    }

    private void a(TextView textView, TextView textView2, long j) {
        String str = (String) ay.a(this.fPi, 1000 * j, !this.naR.equals("en"));
        String[] split;
        if (str.indexOf(":") > 0) {
            split = str.split(":");
            if (split[1].length() < 2) {
                split[1] = "0" + split[1];
            }
            textView.setText(split[0]);
            textView2.setText(split[1]);
            textView2.setVisibility(0);
            textView.setVisibility(0);
        } else if (str.indexOf("/") > 0) {
            split = str.split("/");
            if (split[1].length() < 2) {
                split[1] = "0" + split[1];
            }
            split[0] = ay.q(this.fPi, split[0], this.naR);
            textView.setText(split[0]);
            textView2.setText(split[1]);
            textView2.setVisibility(0);
            textView.setVisibility(0);
        } else {
            textView2.setVisibility(0);
            textView2.setText(str);
        }
    }

    public final int getItemViewType(int i) {
        if (this.fJm && i == 0) {
            w.d("MicroMsg.SnsphotoAdapter", "position isSelf " + i + " - 0");
            return 0;
        }
        int intValue;
        if (this.qoV.get(Integer.valueOf(i)) != null) {
            intValue = ((Integer) this.qoV.get(Integer.valueOf(i))).intValue();
        } else {
            intValue = -1;
        }
        if (intValue == -1) {
            w.e("MicroMsg.SnsphotoAdapter", "unknow error " + intValue);
            return 0;
        }
        m mVar = (m) getItem(intValue);
        if (mVar.bhd().ufB.tsN == 1) {
            w.d("MicroMsg.SnsphotoAdapter", "position " + i + " - 0");
            return 0;
        } else if (mVar.bhd().ufB.tsN != 15) {
            return mVar.bhd().ufB.tsN == 21 ? 3 : 1;
        } else {
            w.d("MicroMsg.SnsphotoAdapter", "position " + i + " - 2");
            return 2;
        }
    }

    public final int getViewTypeCount() {
        return 4;
    }

    private void a(int i, QFadeImageView qFadeImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, int i2, d dVar, int i3) {
        CharSequence tL;
        m mVar = (m) getItem(i);
        bfc bhd = mVar.bhd();
        bbk n = ai.n(mVar);
        Object obj = null;
        if (n != null && (((n.tQZ & 2) == 2 && n.ucy != null) || ((n.tQZ & 4) == 4 && n.tPQ != null))) {
            obj = 1;
        }
        if (!(!this.fJm || n == null || r1 == null || this.userName == null || !this.userName.equals(mVar.field_userName))) {
            textView3.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.pAf);
            textView3.setVisibility(0);
        }
        com.tencent.mm.j.a Rc;
        if (i2 == 1) {
            if (ai.O(mVar.field_localPrivate, this.fJm)) {
                textView3.setVisibility(0);
                textView3.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.pzZ);
                Rc = this.qzL.Rc(mVar.field_userName);
                tL = Rc == null ? "" : Rc.tL();
                if (!(tL.equals("") || this.userName.equals(mVar.field_userName))) {
                    textView.setVisibility(0);
                    textView.setText(tL);
                }
            }
        } else if (ai.O(mVar.field_localPrivate, this.fJm)) {
            textView3.setVisibility(0);
            textView3.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.pzZ);
            Rc = this.qzL.Rc(mVar.field_userName);
            tL = Rc == null ? "" : Rc.tL();
            if (!(tL == null || tL.equals("") || this.userName.equals(mVar.field_userName))) {
                textView.setVisibility(0);
                textView.setText(tL);
            }
        }
        int i4 = mVar.qnk;
        a aVar = new a();
        aVar.pRa = i4;
        if (this.qES.get(Integer.valueOf(i3)) != null) {
            aVar.position = ((Integer) this.qES.get(Integer.valueOf(i3))).intValue();
        } else {
            aVar.position = 0;
        }
        qFadeImageView.setTag(aVar);
        an anVar = new an(this.qER.tag);
        anVar.cIm = mVar.field_createTime;
        if (bhd.ufB.tsN == 1) {
            qFadeImageView.setVisibility(0);
            ae.beI().a(bhd.ufB.tsO, (View) qFadeImageView, this.fPi.hashCode(), com.tencent.mm.plugin.sns.model.g.a.pTx, anVar);
        } else if (bhd.ufB.tsN == 2) {
            textView4.setText(bg.ap(bhd.ufB.msk, ""));
            textView4.setVisibility(0);
        } else if (bhd.ufB.tsN == 21) {
            mVar.bhq();
            boolean z = true;
            if (this.fJm) {
                z = true;
            } else if (com.tencent.mm.plugin.sns.lucky.a.m.a(mVar, n)) {
                z = false;
            }
            qFadeImageView.setVisibility(0);
            ae.beI().a(bhd.ufB.tsO, (View) qFadeImageView, this.fPi.hashCode(), com.tencent.mm.plugin.sns.model.g.a.pTx, anVar, z);
        }
        if (mVar.beu() && mVar.bhA()) {
            textView3.setVisibility(0);
            textView3.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.pzY);
        }
        if (i2 == 1) {
            if (bhd.ufB.tsO == null || bhd.ufB.tsO.size() <= 1) {
                textView2.setVisibility(8);
            } else {
                dVar.qFy.setVisibility(0);
                textView2.setVisibility(0);
                textView2.setText(this.fPi.getResources().getQuantityString(i.h.pIH, i4, new Object[]{Integer.valueOf(bhd.ufB.tsO.size())}));
            }
            tL = bhd.ufy;
            if (tL != null && !tL.equals("")) {
                dVar.qFy.setVisibility(0);
                dVar.qhN.setVisibility(0);
                dVar.qhN.setText(tL);
                dVar.qhN.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.fPi, tL, dVar.qhN.getTextSize()));
            }
        }
    }

    private void hL(boolean z) {
        w.d("MicroMsg.SnsphotoAdapter", "limitSeq " + this.lri);
        if (this.qEV != null) {
            this.qEV.e(this.lri, this.qEU, z);
        }
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public final void biW() {
        hL(true);
        notifyDataSetChanged();
    }

    public final void bkI() {
        w.d("MicroMsg.SnsphotoAdapter", "i addSize ");
        dM(this.fRK.isEmpty() ? 0 : ((m) this.fRK.get(this.fRK.size() - 1)).field_snsId);
    }

    private void dM(long j) {
        as asVar;
        String dg = com.tencent.mm.plugin.sns.data.i.dg(ae.beL().a(j, ae.beB().Fo(this.userName), this.userName, this.fJm));
        if (this.qxe.equals("")) {
            asVar = this;
        } else if (dg.compareTo(this.qxe) < 0) {
            asVar = this;
        } else {
            dg = this.qxe;
            asVar = this;
        }
        asVar.lri = dg;
        rk bhp = ae.beO().Gk(this.userName).bhp();
        if (bhp.twW != 0) {
            dg = com.tencent.mm.plugin.sns.data.i.dg(bhp.twW);
            if (this.lri.equals("")) {
                this.lri = dg;
                return;
            }
            if (dg.compareTo(this.lri) <= 0) {
                dg = this.lri;
            }
            this.lri = dg;
        }
    }

    public final Object getItem(int i) {
        return this.fRK.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final ArrayList<com.tencent.mm.plugin.sns.g.b> db(int i, int i2) {
        ArrayList<com.tencent.mm.plugin.sns.g.b> arrayList = new ArrayList();
        this.qFb = i2;
        for (int i3 = 0; i3 < this.fRK.size(); i3++) {
            m mVar = (m) this.fRK.get(i3);
            int i4 = mVar.qnk;
            if (!(mVar.bhd() == null || mVar.bhd().ufB == null || mVar.bhd().ufB.tsO.size() == 0 || (mVar.bhd().ufB.tsN != 1 && mVar.bhd().ufB.tsN != 15))) {
                if (i4 == i) {
                    this.qFb = arrayList.size();
                }
                Iterator it = mVar.bhd().ufB.tsO.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    alh com_tencent_mm_protocal_c_alh = (alh) it.next();
                    com.tencent.mm.plugin.sns.g.b bVar = new com.tencent.mm.plugin.sns.g.b();
                    bVar.fVV = com_tencent_mm_protocal_c_alh;
                    bVar.qaD = u.T("sns_table_", (long) i4);
                    bVar.hFf = mVar.field_createTime;
                    int i6 = i5 + 1;
                    bVar.qaE = i5;
                    arrayList.add(bVar);
                    i5 = i6;
                }
            }
        }
        return arrayList;
    }

    protected static boolean GW(String str) {
        anf HL = com.tencent.mm.am.b.HL();
        if (HL != null && com.tencent.mm.am.b.d(HL) && str.equals(HL.tqY) && com.tencent.mm.am.b.HJ()) {
            return true;
        }
        return false;
    }
}
