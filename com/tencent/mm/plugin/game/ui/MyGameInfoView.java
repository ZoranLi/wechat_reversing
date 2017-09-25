package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.l.b;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class MyGameInfoView extends LinearLayout {
    static Map<String, View> mFP = new HashMap();
    private LinearLayout lJu;
    private OnClickListener mAj = new OnClickListener(this) {
        final /* synthetic */ MyGameInfoView mFQ;

        {
            this.mFQ = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof c) {
                c cVar = (c) view.getTag();
                if (this.mFQ.mFO.containsKey(cVar.field_appId)) {
                    m mVar = (m) this.mFQ.mFO.get(cVar.field_appId);
                    mVar.cj(this.mFQ.mContext);
                    this.mFQ.mzy.a(cVar, mVar);
                    return;
                }
                w.e("MicroMsg.MyGameInfoView", "No DownloadInfo found");
                return;
            }
            w.e("MicroMsg.MyGameInfoView", "No button tag retrived, ignore click");
        }
    };
    private Context mContext;
    Map<String, m> mFO;
    private int mqT;
    private com.tencent.mm.plugin.game.model.ae.a mrm;
    private j mxr;
    private LayoutInflater myo;
    private int myq;
    b mzx = new b(this) {
        final /* synthetic */ MyGameInfoView mFQ;

        {
            this.mFQ = r1;
        }

        public final void g(int i, String str, boolean z) {
            if (z && !bg.mA(str)) {
                String[] strArr = new String[this.mFQ.mFO.keySet().size()];
                this.mFQ.mFO.keySet().toArray(strArr);
                for (Object obj : strArr) {
                    m mVar = (m) this.mFQ.mFO.get(obj);
                    if (!(mVar == null || mVar.mpz == null || (!mVar.mpz.field_appId.equals(str) && !mVar.mpz.field_packageName.equals(str)))) {
                        mVar.cj(this.mFQ.mContext);
                        mVar.aAK();
                        View view = (View) MyGameInfoView.mFP.get(mVar.mpz.field_appId);
                        if (view != null) {
                            a aVar = (a) view.getTag();
                            this.mFQ.mzy.a(aVar.mCA, aVar.mCz, mVar.mpz, (m) this.mFQ.mFO.get(mVar.mpz.field_appId));
                        }
                    }
                }
            }
        }
    };
    e mzy;

    private static class a {
        public TextProgressBar mCA;
        public ViewGroup mCv;
        public Button mCz;
        public ImageView mFR;
        public TextView mFS;
        public TextView mFT;
        public TextView mFU;
    }

    static /* synthetic */ void a(MyGameInfoView myGameInfoView, c cVar) {
        if (cVar != null) {
            m mVar = (m) myGameInfoView.mFO.get(cVar.field_appId);
            if (mVar == null) {
                mVar = new m(cVar);
                myGameInfoView.mFO.put(cVar.field_appId, mVar);
            }
            mVar.cj(myGameInfoView.mContext);
            mVar.aAK();
        }
    }

    public MyGameInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.myo = (LayoutInflater) getContext().getSystemService("layout_inflater");
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.lJu = (LinearLayout) findViewById(R.h.bSO);
        this.mxr = new j();
        this.mzy = new e(this.mContext);
        this.mFO = new HashMap();
        l.a(this.mzx);
        w.i("MicroMsg.MyGameInfoView", "initView finished");
    }

    public final void a(com.tencent.mm.plugin.game.model.ae.a aVar, int i, int i2) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        this.mqT = i;
        this.myq = i2;
        this.mxr.nC(this.mqT);
        setVisibility(0);
        if (this.myq == 2) {
            ai.a(this.mContext, (int) MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, 0, null, this.mqT, null);
        }
        this.mrm = aVar;
        final LinkedList linkedList = new LinkedList();
        Iterator it = this.mrm.mrn.iterator();
        while (it.hasNext()) {
            linkedList.add(((com.tencent.mm.plugin.game.model.ae.a.a) it.next()).mrp);
        }
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ MyGameInfoView mFQ;

            public final void run() {
                try {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        c cVar = (c) it.next();
                        if (!this.mFQ.mFO.containsKey(cVar.field_appId)) {
                            MyGameInfoView.a(this.mFQ, cVar);
                        }
                    }
                } catch (Exception e) {
                    w.i("MicroMsg.MyGameInfoView", e.getMessage());
                }
            }
        });
        a(aVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.tencent.mm.plugin.game.model.ae.a r13) {
        /*
        r12 = this;
        r0 = r12.lJu;
        r0.removeAllViews();
        r0 = 0;
        r1 = r13.mrn;
        r1 = com.tencent.mm.sdk.platformtools.bg.bV(r1);
        if (r1 != 0) goto L_0x0474;
    L_0x000e:
        r1 = r13.mrn;
        r8 = r1.iterator();
        r1 = r0;
    L_0x0015:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x0475;
    L_0x001b:
        r0 = r8.next();
        r6 = r0;
        r6 = (com.tencent.mm.plugin.game.model.ae.a.a) r6;
        r0 = r6.mrp;
        if (r0 == 0) goto L_0x0015;
    L_0x0026:
        r0 = r6.mrp;
        r0 = r0.field_appId;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0015;
    L_0x0030:
        r0 = r6.mrp;
        r0 = r0.field_appName;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0015;
    L_0x003a:
        r1 = r6.mrp;
        r0 = r12.lJu;
        r12.g(r0);
        r2 = new com.tencent.mm.plugin.game.ui.MyGameInfoView$a;
        r2.<init>();
        r0 = r12.myo;
        r3 = com.tencent.mm.R.i.deH;
        r4 = r12.lJu;
        r5 = 0;
        r3 = r0.inflate(r3, r4, r5);
        r0 = com.tencent.mm.R.h.cgX;
        r0 = r3.findViewById(r0);
        r0 = (android.view.ViewGroup) r0;
        r2.mCv = r0;
        r0 = com.tencent.mm.R.h.bUc;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r2.mFR = r0;
        r0 = com.tencent.mm.R.h.bUJ;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r2.mFS = r0;
        r0 = com.tencent.mm.R.h.bSP;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r2.mFT = r0;
        r0 = com.tencent.mm.R.h.bTS;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.Button) r0;
        r2.mCz = r0;
        r0 = com.tencent.mm.R.h.bTT;
        r0 = r3.findViewById(r0);
        r0 = (com.tencent.mm.plugin.game.widget.TextProgressBar) r0;
        r2.mCA = r0;
        r0 = r2.mCA;
        r4 = 14;
        r0.nQ(r4);
        r0 = r2.mCz;
        r4 = r12.mAj;
        r0.setOnClickListener(r4);
        r0 = r2.mCA;
        r4 = r12.mAj;
        r0.setOnClickListener(r4);
        r0 = com.tencent.mm.R.h.bUo;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r2.mFU = r0;
        r0 = r1.aAy();
        if (r0 == 0) goto L_0x01dc;
    L_0x00b2:
        r0 = r12.mContext;
        r0 = com.tencent.mm.pluginsdk.model.app.g.a(r0, r1);
        if (r0 != 0) goto L_0x01dc;
    L_0x00ba:
        r0 = r1.moV;
        r0 = r0.muT;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x01ac;
    L_0x00c4:
        r0 = com.tencent.mm.plugin.game.d.e.aCi();
        r4 = r2.mFR;
        r5 = r1.moV;
        r5 = r5.muT;
        r0.f(r4, r5);
    L_0x00d1:
        r0 = r1.moV;
        r0 = r0.muS;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x01bf;
    L_0x00db:
        r0 = r2.mFS;
        r4 = r1.moV;
        r4 = r4.muS;
        r0.setText(r4);
    L_0x00e4:
        r0 = r1.moV;
        r0 = r0.msw;
        if (r0 == 0) goto L_0x011c;
    L_0x00ea:
        r0 = r2.mFU;
        r4 = 0;
        r0.setVisibility(r4);
        r0 = r2.mFU;
        r4 = r1.moV;
        r4 = r4.msw;
        r4 = r4.msj;
        r0.setText(r4);
        r0 = r1.moV;	 Catch:{ Exception -> 0x01c8 }
        r0 = r0.msw;	 Catch:{ Exception -> 0x01c8 }
        r0 = r0.mvi;	 Catch:{ Exception -> 0x01c8 }
        r4 = android.graphics.Color.parseColor(r0);	 Catch:{ Exception -> 0x01c8 }
        r0 = r2.mFU;	 Catch:{ Exception -> 0x01c8 }
        r0.setTextColor(r4);	 Catch:{ Exception -> 0x01c8 }
        r0 = r2.mFU;	 Catch:{ Exception -> 0x01c8 }
        r0 = r0.getBackground();	 Catch:{ Exception -> 0x01c8 }
        if (r0 == 0) goto L_0x011c;
    L_0x0112:
        r5 = r0 instanceof android.graphics.drawable.GradientDrawable;	 Catch:{ Exception -> 0x01c8 }
        if (r5 == 0) goto L_0x011c;
    L_0x0116:
        r0 = (android.graphics.drawable.GradientDrawable) r0;	 Catch:{ Exception -> 0x01c8 }
        r5 = 1;
        r0.setStroke(r5, r4);	 Catch:{ Exception -> 0x01c8 }
    L_0x011c:
        r0 = r1.moz;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x01f6;
    L_0x0124:
        r0 = r2.mFT;
        r4 = r1.moO;
        r0.setText(r4);
        r0 = r2.mFT;
        r4 = 0;
        r0.setVisibility(r4);
    L_0x0131:
        r0 = r2.mCz;
        r0.setTag(r1);
        r0 = r2.mCA;
        r0.setTag(r1);
        r0 = r12.mFO;
        r4 = r1.field_appId;
        r0 = r0.get(r4);
        r0 = (com.tencent.mm.plugin.game.model.m) r0;
        if (r0 != 0) goto L_0x014c;
    L_0x0147:
        r0 = new com.tencent.mm.plugin.game.model.m;
        r0.<init>(r1);
    L_0x014c:
        r4 = r12.mzy;
        r5 = r2.mCA;
        r7 = r2.mCz;
        r4.a(r5, r7, r1, r0);
        r0 = r2.mCv;
        r4 = r12.mxr;
        r0.setOnClickListener(r4);
        r0 = r2.mCv;
        r0.setTag(r1);
        r3.setTag(r2);
        r0 = mFP;
        r1 = r1.field_appId;
        r0.put(r1, r3);
        r0 = r12.lJu;
        r0.addView(r3);
        r7 = 1;
        r0 = r6.mrq;
        r1 = com.tencent.mm.sdk.platformtools.bg.bV(r0);
        if (r1 != 0) goto L_0x0471;
    L_0x0179:
        r9 = r0.iterator();
    L_0x017d:
        r0 = r9.hasNext();
        if (r0 == 0) goto L_0x0471;
    L_0x0183:
        r0 = r9.next();
        r5 = r0;
        r5 = (com.tencent.mm.plugin.game.c.x) r5;
        if (r5 == 0) goto L_0x017d;
    L_0x018c:
        r0 = r5.mtr;
        switch(r0) {
            case 1: goto L_0x01ff;
            case 2: goto L_0x038c;
            default: goto L_0x0191;
        };
    L_0x0191:
        r0 = r12.myq;
        r1 = 2;
        if (r0 != r1) goto L_0x017d;
    L_0x0196:
        r0 = r12.mContext;
        r1 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r2 = r5.mtq;
        r3 = r6.mrp;
        r3 = r3.field_appId;
        r4 = r12.mqT;
        r5 = r5.msG;
        r5 = com.tencent.mm.plugin.game.model.ai.xR(r5);
        com.tencent.mm.plugin.game.model.ai.a(r0, r1, r2, r3, r4, r5);
        goto L_0x017d;
    L_0x01ac:
        r0 = com.tencent.mm.plugin.game.d.e.aCi();
        r4 = r2.mFR;
        r5 = r1.field_appId;
        r7 = r12.mContext;
        r7 = com.tencent.mm.bg.a.getDensity(r7);
        r0.a(r4, r5, r7);
        goto L_0x00d1;
    L_0x01bf:
        r0 = r2.mFS;
        r4 = r1.field_appName;
        r0.setText(r4);
        goto L_0x00e4;
    L_0x01c8:
        r0 = move-exception;
        r4 = "MicroMsg.MyGameInfoView";
        r0 = r0.getMessage();
        com.tencent.mm.sdk.platformtools.w.e(r4, r0);
        r0 = r2.mFU;
        r4 = 8;
        r0.setVisibility(r4);
        goto L_0x011c;
    L_0x01dc:
        r0 = com.tencent.mm.plugin.game.d.e.aCi();
        r4 = r2.mFR;
        r5 = r1.field_appId;
        r7 = r12.mContext;
        r7 = com.tencent.mm.bg.a.getDensity(r7);
        r0.a(r4, r5, r7);
        r0 = r2.mFS;
        r4 = r1.field_appName;
        r0.setText(r4);
        goto L_0x011c;
    L_0x01f6:
        r0 = r2.mFT;
        r4 = 8;
        r0.setVisibility(r4);
        goto L_0x0131;
    L_0x01ff:
        r0 = r5.mto;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x017d;
    L_0x0207:
        r0 = r5.mts;
        if (r0 == 0) goto L_0x017d;
    L_0x020b:
        r0 = r5.mts;
        r0 = r0.fDC;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x017d;
    L_0x0215:
        r0 = r12.myo;
        r1 = com.tencent.mm.R.i.dfe;
        r2 = 0;
        r2 = r0.inflate(r1, r2);
        r0 = com.tencent.mm.R.h.bUZ;
        r0 = r2.findViewById(r0);
        r0 = (com.tencent.mm.plugin.game.ui.MyGameTextStyleView) r0;
        r1 = r12.mqT;
        r0.mqT = r1;
        r1 = r6.mrp;
        r1 = r1.field_appId;
        r0.appId = r1;
        if (r5 == 0) goto L_0x0248;
    L_0x0232:
        r1 = r5.mto;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 != 0) goto L_0x0248;
    L_0x023a:
        r1 = r5.mts;
        if (r1 == 0) goto L_0x0248;
    L_0x023e:
        r1 = r5.mts;
        r1 = r1.fDC;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 == 0) goto L_0x025f;
    L_0x0248:
        r1 = 8;
        r0.setVisibility(r1);
    L_0x024d:
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x0191;
    L_0x0253:
        r0 = r12.lJu;
        r12.h(r0);
        r0 = r12.lJu;
        r0.addView(r2);
        goto L_0x0191;
    L_0x025f:
        r1 = 0;
        r0.setVisibility(r1);
        r1 = r5.mto;
        r1 = r1.length();
        r3 = 4;
        if (r1 <= r3) goto L_0x02e8;
    L_0x026c:
        r1 = r0.mFV;
        r3 = r5.mto;
        r4 = 0;
        r10 = 4;
        r3 = r3.substring(r4, r10);
        r1.setText(r3);
    L_0x0279:
        r1 = r5.mtp;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 != 0) goto L_0x028e;
    L_0x0281:
        r1 = r0.mFW;
        r3 = r5.mtp;
        r1.setText(r3);
        r1 = r0.mFW;
        r3 = 0;
        r1.setVisibility(r3);
    L_0x028e:
        r1 = r0.iUO;
        r3 = r0.mContext;
        r4 = r5.mts;
        r4 = r4.fDC;
        r10 = r0.iUO;
        r10 = r10.getTextSize();
        r3 = com.tencent.mm.pluginsdk.ui.d.h.b(r3, r4, r10);
        r1.setText(r3);
        r1 = 0;
        r3 = r5.mts;
        r3 = r3.msk;
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
        if (r3 != 0) goto L_0x02ca;
    L_0x02ae:
        r1 = 1;
        r3 = r0.mFY;
        r4 = r0.mContext;
        r10 = r5.mts;
        r10 = r10.msk;
        r11 = r0.mFY;
        r11 = r11.getTextSize();
        r4 = com.tencent.mm.pluginsdk.ui.d.h.b(r4, r10, r11);
        r3.setText(r4);
        r3 = r0.mFY;
        r4 = 0;
        r3.setVisibility(r4);
    L_0x02ca:
        r3 = r5.mts;
        r3 = r3.msE;
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
        if (r3 != 0) goto L_0x02e0;
    L_0x02d4:
        r3 = new com.tencent.mm.plugin.game.d.e$a$a;
        r3.<init>();
        r4 = r5.mts;
        r4 = r4.muW;
        switch(r4) {
            case 0: goto L_0x032d;
            case 1: goto L_0x030e;
            case 2: goto L_0x0308;
            case 3: goto L_0x032d;
            case 4: goto L_0x02f0;
            default: goto L_0x02e0;
        };
    L_0x02e0:
        r0.setTag(r5);
        r0.setOnClickListener(r0);
        goto L_0x024d;
    L_0x02e8:
        r1 = r0.mFV;
        r3 = r5.mto;
        r1.setText(r3);
        goto L_0x0279;
    L_0x02f0:
        r1 = r0.mGc;
        r4 = 0;
        r1.setVisibility(r4);
        r1 = com.tencent.mm.plugin.game.d.e.aCi();
        r4 = r0.mGd;
        r10 = r5.mts;
        r10 = r10.msE;
        r3 = r3.aCj();
        r1.a(r4, r10, r3);
        goto L_0x02e0;
    L_0x0308:
        r1 = r0.mGa;
        r4 = 0;
        r1.setVisibility(r4);
    L_0x030e:
        r1 = r0.mFZ;
        r4 = 0;
        r1.setVisibility(r4);
        r1 = 1;
        r3.hJi = r1;
        r1 = com.tencent.mm.R.g.bft;
        r3.mGC = r1;
        r1 = com.tencent.mm.plugin.game.d.e.aCi();
        r4 = r0.mGb;
        r10 = r5.mts;
        r10 = r10.msE;
        r3 = r3.aCj();
        r1.a(r4, r10, r3);
        goto L_0x02e0;
    L_0x032d:
        if (r1 == 0) goto L_0x036c;
    L_0x032f:
        r1 = r0.mGe;
        r4 = 0;
        r1.setVisibility(r4);
        r1 = r0.mGf;
        r1 = r1.getLayoutParams();
        r1 = (android.widget.RelativeLayout.LayoutParams) r1;
        r4 = r0.mFY;
        r4 = r4.getLineCount();
        r10 = 2;
        if (r4 >= r10) goto L_0x0366;
    L_0x0346:
        r4 = 15;
        r1.addRule(r4);
    L_0x034b:
        r4 = r0.mGf;
        r4.setLayoutParams(r1);
        r1 = 1;
        r3.mGz = r1;
        r1 = com.tencent.mm.plugin.game.d.e.aCi();
        r4 = r0.mGf;
        r10 = r5.mts;
        r10 = r10.msE;
        r3 = r3.aCj();
        r1.a(r4, r10, r3);
        goto L_0x02e0;
    L_0x0366:
        r4 = 12;
        r1.addRule(r4);
        goto L_0x034b;
    L_0x036c:
        r1 = r0.mFZ;
        r4 = 0;
        r1.setVisibility(r4);
        r1 = 1;
        r3.mGz = r1;
        r1 = com.tencent.mm.R.g.bfu;
        r3.mGC = r1;
        r1 = com.tencent.mm.plugin.game.d.e.aCi();
        r4 = r0.mGb;
        r10 = r5.mts;
        r10 = r10.msE;
        r3 = r3.aCj();
        r1.a(r4, r10, r3);
        goto L_0x02e0;
    L_0x038c:
        r0 = r5.mto;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x017d;
    L_0x0394:
        r0 = r5.mtt;
        if (r0 == 0) goto L_0x017d;
    L_0x0398:
        r0 = r5.mtt;
        r0 = r0.msE;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x017d;
    L_0x03a2:
        r0 = r12.myo;
        r1 = com.tencent.mm.R.i.dfd;
        r2 = 0;
        r2 = r0.inflate(r1, r2);
        r0 = com.tencent.mm.R.h.bUL;
        r0 = r2.findViewById(r0);
        r1 = r0;
        r1 = (com.tencent.mm.plugin.game.ui.MyGamePicStyleView) r1;
        r0 = r12.mqT;
        r1.mqT = r0;
        r0 = r6.mrp;
        r0 = r0.field_appId;
        r1.appId = r0;
        if (r5 == 0) goto L_0x03d6;
    L_0x03c0:
        r0 = r5.mto;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x03d6;
    L_0x03c8:
        r0 = r5.mtt;
        if (r0 == 0) goto L_0x03d6;
    L_0x03cc:
        r0 = r5.mtt;
        r0 = r0.msE;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 == 0) goto L_0x03ed;
    L_0x03d6:
        r0 = 8;
        r1.setVisibility(r0);
    L_0x03db:
        r0 = r1.getVisibility();
        if (r0 != 0) goto L_0x0191;
    L_0x03e1:
        r0 = r12.lJu;
        r12.h(r0);
        r0 = r12.lJu;
        r0.addView(r2);
        goto L_0x0191;
    L_0x03ed:
        r0 = 0;
        r1.setVisibility(r0);
        r0 = r5.mto;
        r0 = r0.length();
        r3 = 4;
        if (r0 <= r3) goto L_0x0469;
    L_0x03fa:
        r0 = r1.mFV;
        r3 = r5.mto;
        r4 = 0;
        r10 = 4;
        r3 = r3.substring(r4, r10);
        r0.setText(r3);
    L_0x0407:
        r0 = r5.mtp;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x041c;
    L_0x040f:
        r0 = r1.mFW;
        r3 = r5.mtp;
        r0.setText(r3);
        r0 = r1.mFW;
        r3 = 0;
        r0.setVisibility(r3);
    L_0x041c:
        r0 = new com.tencent.mm.plugin.game.d.e$a$a;
        r0.<init>();
        r3 = com.tencent.mm.R.g.bfr;
        r0.mGC = r3;
        r3 = com.tencent.mm.plugin.game.d.e.aCi();
        r4 = r1.mFX;
        r10 = r5.mtt;
        r10 = r10.msE;
        r0 = r0.aCj();
        r3.a(r4, r10, r0);
        r0 = r1.mContext;
        r0 = com.tencent.mm.plugin.game.d.c.getScreenWidth(r0);
        r3 = r1.getPaddingLeft();
        r0 = r0 - r3;
        r3 = r1.getPaddingRight();
        r0 = r0 - r3;
        r3 = 1117782016; // 0x42a00000 float:80.0 double:5.522576936E-315;
        r0 = (float) r0;
        r4 = 1143767040; // 0x442c8000 float:690.0 double:5.650960013E-315;
        r0 = r0 / r4;
        r0 = r0 * r3;
        r3 = java.lang.Math.round(r0);
        r0 = r1.mFX;
        r0 = r0.getLayoutParams();
        r0 = (android.widget.RelativeLayout.LayoutParams) r0;
        r0.height = r3;
        r3 = r1.mFX;
        r3.setLayoutParams(r0);
        r1.setTag(r5);
        r1.setOnClickListener(r1);
        goto L_0x03db;
    L_0x0469:
        r0 = r1.mFV;
        r3 = r5.mto;
        r0.setText(r3);
        goto L_0x0407;
    L_0x0471:
        r1 = r7;
        goto L_0x0015;
    L_0x0474:
        r1 = r0;
    L_0x0475:
        if (r1 == 0) goto L_0x047c;
    L_0x0477:
        r0 = r12.lJu;
        r12.g(r0);
    L_0x047c:
        r0 = r13.mro;
        if (r0 == 0) goto L_0x04c5;
    L_0x0480:
        r0 = r13.mro;
        r0 = r0.msk;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x04c5;
    L_0x048a:
        r0 = r13.mro;
        r0 = r0.msF;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x04c5;
    L_0x0494:
        r0 = r12.myo;
        r2 = com.tencent.mm.R.i.dfb;
        r3 = 0;
        r2 = r0.inflate(r2, r12, r3);
        r0 = com.tencent.mm.R.h.text;
        r0 = r2.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r3 = r13.mro;
        r3 = r3.msk;
        r0.setText(r3);
        r0 = r13.mro;
        r0 = r0.msF;
        r2.setTag(r0);
        r0 = new com.tencent.mm.plugin.game.ui.MyGameInfoView$1;
        r0.<init>(r12);
        r2.setOnClickListener(r0);
        r0 = r12.lJu;
        r0.addView(r2);
        r0 = r12.lJu;
        r12.g(r0);
    L_0x04c5:
        if (r1 == 0) goto L_0x04cc;
    L_0x04c7:
        r0 = 0;
        r12.setVisibility(r0);
    L_0x04cb:
        return;
    L_0x04cc:
        r0 = 8;
        r12.setVisibility(r0);
        goto L_0x04cb;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.ui.MyGameInfoView.a(com.tencent.mm.plugin.game.model.ae$a):void");
    }

    private void g(ViewGroup viewGroup) {
        viewGroup.addView((ImageView) this.myo.inflate(R.i.deC, viewGroup, false));
    }

    private void h(ViewGroup viewGroup) {
        ImageView imageView = (ImageView) this.myo.inflate(R.i.deC, viewGroup, false);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
        marginLayoutParams.leftMargin = com.tencent.mm.bg.a.fromDPToPix(this.mContext, 15);
        imageView.setLayoutParams(marginLayoutParams);
        viewGroup.addView(imageView);
    }
}
