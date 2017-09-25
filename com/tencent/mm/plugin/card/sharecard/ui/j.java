package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.ben;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j implements c {
    private BaseAdapter kjh;
    private long kji = 0;
    private long kjj = 0;
    private int kjk;
    private int kjl;
    private ArrayList<Integer> kjm = new ArrayList();
    private ArrayList<String> kjn = new ArrayList();
    private ArrayList<String> kjo = new ArrayList();
    protected LinkedList<CardTagTextView> kjp = new LinkedList();
    private Context mContext;

    public class a {
        public View kjA;
        public TextView kjB;
        final /* synthetic */ j kjC;
        public LinearLayout kjq;
        public TextView kjr;
        public TextView kjs;
        public RelativeLayout kjt;
        public ImageView kju;
        public TextView kjv;
        public TextView kjw;
        public TextView kjx;
        public TextView kjy;
        public TextView kjz;

        public a(j jVar) {
            this.kjC = jVar;
        }
    }

    public j(Context context, BaseAdapter baseAdapter) {
        this.mContext = context;
        this.kjh = baseAdapter;
        this.kjk = this.mContext.getResources().getDimensionPixelSize(R.f.aXJ);
        this.kjl = this.mContext.getResources().getDimensionPixelSize(R.f.aXz);
        this.kjm.clear();
        this.kjn.clear();
        this.kjo.clear();
    }

    public final void release() {
        this.mContext = null;
        this.kjh = null;
        if (this.kjj > 0) {
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(5);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(6);
            iDKey2.SetValue((int) (this.kji / this.kjj));
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            g.oUh.b(arrayList, true);
        }
        if (this.kjm.size() == this.kjn.size() && this.kjn.size() == this.kjo.size() && this.kjm.size() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            for (int i = 0; i < this.kjm.size(); i++) {
                g.oUh.i(13220, new Object[]{this.kjo.get(i), this.kjn.get(i), this.kjm.get(i), Long.valueOf(currentTimeMillis)});
            }
        }
        this.kjm.clear();
        this.kjn.clear();
        this.kjo.clear();
        if (this.kjp != null) {
            this.kjp.clear();
        }
    }

    public final View a(int i, View view, b bVar) {
        a aVar;
        Object obj;
        StringBuilder stringBuilder;
        CharSequence sy;
        boolean ks;
        int sz;
        LayoutParams layoutParams;
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = View.inflate(this.mContext, R.i.byr, null);
            a aVar2 = new a(this);
            aVar2.kjq = (LinearLayout) view.findViewById(R.h.byz);
            aVar2.kjr = (TextView) view.findViewById(R.h.bxx);
            aVar2.kjs = (TextView) view.findViewById(R.h.bxy);
            aVar2.kjt = (RelativeLayout) view.findViewById(R.h.bwF);
            aVar2.kju = (ImageView) view.findViewById(R.h.bxt);
            aVar2.kjv = (TextView) view.findViewById(R.h.bwl);
            aVar2.kjw = (TextView) view.findViewById(R.h.bxN);
            aVar2.kjA = view.findViewById(R.h.bxz);
            aVar2.kjx = (TextView) view.findViewById(R.h.subtitle);
            aVar2.kjy = (TextView) view.findViewById(R.h.bwb);
            aVar2.kjz = (TextView) view.findViewById(R.h.bxP);
            aVar2.kjB = (TextView) view.findViewById(R.h.bwH);
            aVar2.kjx.setEllipsize(TruncateAt.MIDDLE);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        b bVar2 = (b) this.kjh.getItem(i);
        int afr = bVar2.afr();
        if (com.tencent.mm.plugin.card.sharecard.a.b.ks(bVar2.afr())) {
            if (i == 0) {
                if (!TextUtils.isEmpty(bVar2.km(afr))) {
                    obj = 1;
                    if (obj != null) {
                        aVar.kjr.setVisibility(0);
                        aVar.kjr.setText(bVar2.km(afr));
                        if (TextUtils.isEmpty(bVar2.afq())) {
                            aVar.kjs.setVisibility(8);
                        } else {
                            aVar.kjs.setVisibility(0);
                            aVar.kjs.setText(bVar2.afq());
                        }
                    } else {
                        aVar.kjr.setVisibility(8);
                        aVar.kjs.setVisibility(8);
                        aVar.kjr.setText("");
                    }
                    if (bVar.aeU()) {
                        aVar.kju.setVisibility(0);
                        aVar.kjv.setVisibility(0);
                        aVar.kjq.setVisibility(0);
                        aVar.kjw.setVisibility(0);
                        aVar.kjB.setVisibility(0);
                        aVar.kjA.setVisibility(0);
                        aVar.kjx.setVisibility(0);
                        aVar.kjy.setVisibility(0);
                        aVar.kjz.setVisibility(8);
                        aVar.kjv.setText(bVar.afi().keT);
                        if (!bVar.aeR()) {
                            aVar.kjw.setText(bVar.afi().title);
                        } else if (bVar.afi().toj == null && bVar.afi().toj.size() == 1) {
                            aVar.kjw.setText(((lz) bVar.afi().toj.get(0)).title);
                        } else if (bVar.afi().toj != null && bVar.afi().toj.size() == 2) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(((lz) bVar.afi().toj.get(0)).title);
                            stringBuilder.append("-");
                            stringBuilder.append(((lz) bVar.afi().toj.get(1)).title);
                            aVar.kjw.setText(stringBuilder.toString());
                        }
                        m.a(aVar.kju, bVar.afi().kdG, this.mContext.getResources().getDimensionPixelSize(R.f.aYK), R.g.bhq, true);
                        aVar.kjv.setTextColor(this.mContext.getResources().getColor(R.e.aTh));
                        sy = com.tencent.mm.plugin.card.sharecard.a.b.sy(bVar.afn());
                        if (TextUtils.isEmpty(sy)) {
                            aVar.kjy.setText("");
                        } else {
                            aVar.kjy.setText(sy);
                        }
                        sy = com.tencent.mm.plugin.card.sharecard.a.b.it(bVar.afn());
                        ks = com.tencent.mm.plugin.card.sharecard.a.b.ks(bVar.afr());
                        if (TextUtils.isEmpty(sy) && ks) {
                            aVar.kjx.setText(h.c(this.mContext, sy, this.mContext.getResources().getDimensionPixelOffset(R.f.aXU)));
                        } else if (TextUtils.isEmpty(bVar.afo())) {
                            aVar.kjx.setText("");
                        } else {
                            if (TextUtils.isEmpty(l.td(bVar.afo()))) {
                                aVar.kjx.setText("");
                            } else {
                                aVar.kjx.setText(h.c(this.mContext, this.mContext.getResources().getString(R.l.dRM, new Object[]{sy}), this.mContext.getResources().getDimensionPixelOffset(R.f.aXU)));
                            }
                        }
                        sz = com.tencent.mm.plugin.card.sharecard.a.b.sz(bVar.afn());
                        if (sz > 1 || !ks) {
                            aVar.kjB.setVisibility(8);
                        } else {
                            aVar.kjB.setText("X" + sz);
                            aVar.kjB.setVisibility(0);
                        }
                        if ((bVar.afi().toD != null || bg.bV(bVar.afi().toD.uhT)) && !com.tencent.mm.plugin.card.sharecard.a.b.sB(bVar.afn())) {
                            aVar.kjq.setVisibility(8);
                        } else {
                            aVar.kjq.setVisibility(0);
                            for (int i2 = 0; i2 < aVar.kjq.getChildCount(); i2++) {
                                this.kjp.add((CardTagTextView) aVar.kjq.getChildAt(i2));
                            }
                            aVar.kjq.removeAllViews();
                            if (com.tencent.mm.plugin.card.sharecard.a.b.sB(bVar.afn())) {
                                View agQ = agQ();
                                agQ.setPadding(this.kjl, this.kjk, this.kjl, this.kjk);
                                agQ.setTextColor(this.mContext.getResources().getColor(R.e.aVD));
                                agQ.setText(this.mContext.getString(R.l.dRU));
                                agQ.setTextSize(12.0f);
                                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
                                layoutParams2.rightMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.aXx);
                                aVar.kjq.addView(agQ, layoutParams2);
                            }
                            if (!(bVar.afi().toD == null || bg.bV(bVar.afi().toD.uhT))) {
                                Iterator it = bVar.afi().toD.uhT.iterator();
                                while (it.hasNext()) {
                                    ben com_tencent_mm_protocal_c_ben = (ben) it.next();
                                    View agQ2 = agQ();
                                    agQ2.setPadding(this.kjl, this.kjk, this.kjl, this.kjk);
                                    agQ2.setTextColor(l.ta(com_tencent_mm_protocal_c_ben.hib));
                                    agQ2.setText(com_tencent_mm_protocal_c_ben.tag);
                                    agQ2.setTextSize(12.0f);
                                    aVar.kjq.addView(agQ2);
                                }
                            }
                        }
                    } else {
                        aVar.kju.setVisibility(8);
                        aVar.kjv.setVisibility(8);
                        aVar.kjq.setVisibility(8);
                        aVar.kjw.setVisibility(8);
                        aVar.kjB.setVisibility(8);
                        aVar.kjA.setVisibility(8);
                        aVar.kjx.setVisibility(8);
                        aVar.kjy.setVisibility(8);
                        aVar.kjz.setVisibility(0);
                        aVar.kjz.setText(this.mContext.getResources().getString(R.l.dRx));
                    }
                    if (i == this.kjh.getCount() - 1 || aVar.kjt == null) {
                        layoutParams = (LayoutParams) aVar.kjt.getLayoutParams();
                        if (layoutParams.bottomMargin != 0) {
                            layoutParams.bottomMargin = 0;
                            aVar.kjt.setLayoutParams(layoutParams);
                        }
                    } else {
                        layoutParams = (LayoutParams) aVar.kjt.getLayoutParams();
                        if (layoutParams.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(R.f.aXx)) {
                            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.aXx);
                            aVar.kjt.setLayoutParams(layoutParams);
                        }
                    }
                    this.kji = (System.currentTimeMillis() - currentTimeMillis) + this.kji;
                    this.kjj++;
                    if (!this.kjn.contains(bVar.afm())) {
                        this.kjn.add(bVar.afm());
                        this.kjo.add(bVar.afn());
                        this.kjm.add(Integer.valueOf(i));
                    }
                    return view;
                }
            } else if (afr != ((b) this.kjh.getItem(i - 1)).afr()) {
                obj = 1;
                if (obj != null) {
                    aVar.kjr.setVisibility(8);
                    aVar.kjs.setVisibility(8);
                    aVar.kjr.setText("");
                } else {
                    aVar.kjr.setVisibility(0);
                    aVar.kjr.setText(bVar2.km(afr));
                    if (TextUtils.isEmpty(bVar2.afq())) {
                        aVar.kjs.setVisibility(8);
                    } else {
                        aVar.kjs.setVisibility(0);
                        aVar.kjs.setText(bVar2.afq());
                    }
                }
                if (bVar.aeU()) {
                    aVar.kju.setVisibility(8);
                    aVar.kjv.setVisibility(8);
                    aVar.kjq.setVisibility(8);
                    aVar.kjw.setVisibility(8);
                    aVar.kjB.setVisibility(8);
                    aVar.kjA.setVisibility(8);
                    aVar.kjx.setVisibility(8);
                    aVar.kjy.setVisibility(8);
                    aVar.kjz.setVisibility(0);
                    aVar.kjz.setText(this.mContext.getResources().getString(R.l.dRx));
                } else {
                    aVar.kju.setVisibility(0);
                    aVar.kjv.setVisibility(0);
                    aVar.kjq.setVisibility(0);
                    aVar.kjw.setVisibility(0);
                    aVar.kjB.setVisibility(0);
                    aVar.kjA.setVisibility(0);
                    aVar.kjx.setVisibility(0);
                    aVar.kjy.setVisibility(0);
                    aVar.kjz.setVisibility(8);
                    aVar.kjv.setText(bVar.afi().keT);
                    if (!bVar.aeR()) {
                        aVar.kjw.setText(bVar.afi().title);
                    } else {
                        if (bVar.afi().toj == null) {
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(((lz) bVar.afi().toj.get(0)).title);
                        stringBuilder.append("-");
                        stringBuilder.append(((lz) bVar.afi().toj.get(1)).title);
                        aVar.kjw.setText(stringBuilder.toString());
                    }
                    m.a(aVar.kju, bVar.afi().kdG, this.mContext.getResources().getDimensionPixelSize(R.f.aYK), R.g.bhq, true);
                    aVar.kjv.setTextColor(this.mContext.getResources().getColor(R.e.aTh));
                    sy = com.tencent.mm.plugin.card.sharecard.a.b.sy(bVar.afn());
                    if (TextUtils.isEmpty(sy)) {
                        aVar.kjy.setText("");
                    } else {
                        aVar.kjy.setText(sy);
                    }
                    sy = com.tencent.mm.plugin.card.sharecard.a.b.it(bVar.afn());
                    ks = com.tencent.mm.plugin.card.sharecard.a.b.ks(bVar.afr());
                    if (TextUtils.isEmpty(sy)) {
                    }
                    if (TextUtils.isEmpty(bVar.afo())) {
                        aVar.kjx.setText("");
                    } else {
                        if (TextUtils.isEmpty(l.td(bVar.afo()))) {
                            aVar.kjx.setText("");
                        } else {
                            aVar.kjx.setText(h.c(this.mContext, this.mContext.getResources().getString(R.l.dRM, new Object[]{sy}), this.mContext.getResources().getDimensionPixelOffset(R.f.aXU)));
                        }
                    }
                    sz = com.tencent.mm.plugin.card.sharecard.a.b.sz(bVar.afn());
                    if (sz > 1) {
                    }
                    aVar.kjB.setVisibility(8);
                    if (bVar.afi().toD != null) {
                    }
                    aVar.kjq.setVisibility(8);
                }
                if (i == this.kjh.getCount() - 1) {
                }
                layoutParams = (LayoutParams) aVar.kjt.getLayoutParams();
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    aVar.kjt.setLayoutParams(layoutParams);
                }
                this.kji = (System.currentTimeMillis() - currentTimeMillis) + this.kji;
                this.kjj++;
                if (this.kjn.contains(bVar.afm())) {
                    this.kjn.add(bVar.afm());
                    this.kjo.add(bVar.afn());
                    this.kjm.add(Integer.valueOf(i));
                }
                return view;
            }
        }
        obj = null;
        if (obj != null) {
            aVar.kjr.setVisibility(0);
            aVar.kjr.setText(bVar2.km(afr));
            if (TextUtils.isEmpty(bVar2.afq())) {
                aVar.kjs.setVisibility(0);
                aVar.kjs.setText(bVar2.afq());
            } else {
                aVar.kjs.setVisibility(8);
            }
        } else {
            aVar.kjr.setVisibility(8);
            aVar.kjs.setVisibility(8);
            aVar.kjr.setText("");
        }
        if (bVar.aeU()) {
            aVar.kju.setVisibility(0);
            aVar.kjv.setVisibility(0);
            aVar.kjq.setVisibility(0);
            aVar.kjw.setVisibility(0);
            aVar.kjB.setVisibility(0);
            aVar.kjA.setVisibility(0);
            aVar.kjx.setVisibility(0);
            aVar.kjy.setVisibility(0);
            aVar.kjz.setVisibility(8);
            aVar.kjv.setText(bVar.afi().keT);
            if (!bVar.aeR()) {
                if (bVar.afi().toj == null) {
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(((lz) bVar.afi().toj.get(0)).title);
                stringBuilder.append("-");
                stringBuilder.append(((lz) bVar.afi().toj.get(1)).title);
                aVar.kjw.setText(stringBuilder.toString());
            } else {
                aVar.kjw.setText(bVar.afi().title);
            }
            m.a(aVar.kju, bVar.afi().kdG, this.mContext.getResources().getDimensionPixelSize(R.f.aYK), R.g.bhq, true);
            aVar.kjv.setTextColor(this.mContext.getResources().getColor(R.e.aTh));
            sy = com.tencent.mm.plugin.card.sharecard.a.b.sy(bVar.afn());
            if (TextUtils.isEmpty(sy)) {
                aVar.kjy.setText(sy);
            } else {
                aVar.kjy.setText("");
            }
            sy = com.tencent.mm.plugin.card.sharecard.a.b.it(bVar.afn());
            ks = com.tencent.mm.plugin.card.sharecard.a.b.ks(bVar.afr());
            if (TextUtils.isEmpty(sy)) {
            }
            if (TextUtils.isEmpty(bVar.afo())) {
                if (TextUtils.isEmpty(l.td(bVar.afo()))) {
                    aVar.kjx.setText(h.c(this.mContext, this.mContext.getResources().getString(R.l.dRM, new Object[]{sy}), this.mContext.getResources().getDimensionPixelOffset(R.f.aXU)));
                } else {
                    aVar.kjx.setText("");
                }
            } else {
                aVar.kjx.setText("");
            }
            sz = com.tencent.mm.plugin.card.sharecard.a.b.sz(bVar.afn());
            if (sz > 1) {
            }
            aVar.kjB.setVisibility(8);
            if (bVar.afi().toD != null) {
            }
            aVar.kjq.setVisibility(8);
        } else {
            aVar.kju.setVisibility(8);
            aVar.kjv.setVisibility(8);
            aVar.kjq.setVisibility(8);
            aVar.kjw.setVisibility(8);
            aVar.kjB.setVisibility(8);
            aVar.kjA.setVisibility(8);
            aVar.kjx.setVisibility(8);
            aVar.kjy.setVisibility(8);
            aVar.kjz.setVisibility(0);
            aVar.kjz.setText(this.mContext.getResources().getString(R.l.dRx));
        }
        if (i == this.kjh.getCount() - 1) {
        }
        layoutParams = (LayoutParams) aVar.kjt.getLayoutParams();
        if (layoutParams.bottomMargin != 0) {
            layoutParams.bottomMargin = 0;
            aVar.kjt.setLayoutParams(layoutParams);
        }
        this.kji = (System.currentTimeMillis() - currentTimeMillis) + this.kji;
        this.kjj++;
        if (this.kjn.contains(bVar.afm())) {
            this.kjn.add(bVar.afm());
            this.kjo.add(bVar.afn());
            this.kjm.add(Integer.valueOf(i));
        }
        return view;
    }

    public final void t(View view, int i) {
    }

    public final void u(View view, int i) {
    }

    public final void a(View view, int i, OnClickListener onClickListener) {
    }

    private CardTagTextView agQ() {
        if (this.kjp.size() == 0) {
            return new CardTagTextView(this.mContext);
        }
        return (CardTagTextView) this.kjp.removeFirst();
    }
}
