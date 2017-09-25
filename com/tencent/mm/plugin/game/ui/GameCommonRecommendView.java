package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.ca;
import com.tencent.mm.plugin.game.c.p;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.widget.CircleImageView;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;

public class GameCommonRecommendView extends LinearLayout implements OnClickListener {
    private LayoutInflater Du;
    private Context mContext;
    int mqT;
    private ImageView myA;
    private TextView myB;
    private TextView myC;
    private View myD;
    private ImageView myE;
    private ImageView myF;
    private TextView myG;
    private TextView myH;
    int myq;
    private View myr;
    private TextView mys;
    private TextView myt;
    private LinearLayout myu;
    private FrameLayout myv;
    private TextView myw;
    private ImageView myx;
    private View myy;
    private ImageView myz;

    private static class a {
        String jumpUrl;
        String moQ;
        int position;

        public a(int i, String str, String str2) {
            this.position = i;
            this.jumpUrl = str;
            this.moQ = str2;
        }
    }

    public GameCommonRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.Du = LayoutInflater.from(context);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.myr = findViewById(R.h.cwZ);
        this.mys = (TextView) findViewById(R.h.cxc);
        this.myt = (TextView) findViewById(R.h.cxb);
        this.myu = (LinearLayout) findViewById(R.h.cwX);
        this.myv = (FrameLayout) findViewById(R.h.cwY);
        this.myw = (TextView) findViewById(R.h.cwW);
        this.myx = (ImageView) findViewById(R.h.cxa);
        this.myy = findViewById(R.h.cwP);
        this.myz = (ImageView) findViewById(R.h.cwM);
        this.myA = (ImageView) findViewById(R.h.cwO);
        this.myB = (TextView) findViewById(R.h.cwQ);
        this.myC = (TextView) findViewById(R.h.cwN);
        this.myD = findViewById(R.h.cwU);
        this.myE = (ImageView) findViewById(R.h.cwR);
        this.myF = (ImageView) findViewById(R.h.cwT);
        this.myG = (TextView) findViewById(R.h.cwV);
        this.myH = (TextView) findViewById(R.h.cwS);
        if (c.getScreenWidth(this.mContext) < 720) {
            this.myB.setTextSize((float) com.tencent.mm.bg.a.fromDPToPix(this.mContext, 12));
            this.myC.setTextSize((float) com.tencent.mm.bg.a.fromDPToPix(this.mContext, 12));
            this.myG.setTextSize((float) com.tencent.mm.bg.a.fromDPToPix(this.mContext, 12));
            this.myH.setTextSize((float) com.tencent.mm.bg.a.fromDPToPix(this.mContext, 12));
        }
        w.i("MicroMsg.GameCommonRecommendView", "initView finished");
    }

    final void a(ca caVar) {
        this.mys.setText(caVar.mvJ.fDC);
        if (!bg.mA(caVar.mvJ.msH)) {
            this.myt.setText(caVar.mvJ.msH);
        }
        if (bg.bV(caVar.mvJ.msI)) {
            this.myw.setText(caVar.mvJ.msk);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            this.myv.removeAllViews();
            this.myv.setVisibility(8);
            Iterator it = caVar.mvJ.msI.iterator();
            while (it.hasNext()) {
                p pVar = (p) it.next();
                if (pVar != null) {
                    if (!(bg.mA(pVar.mtf) || bg.mA(pVar.jOp))) {
                        LinearLayout linearLayout = (LinearLayout) this.Du.inflate(R.i.dpw, this.myv, false);
                        ImageView imageView = (CircleImageView) linearLayout.findViewById(R.h.czv);
                        LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
                        layoutParams.leftMargin = this.myv.getChildCount() * com.tencent.mm.bg.a.fromDPToPix(this.mContext, 15);
                        linearLayout.setLayoutParams(layoutParams);
                        com.tencent.mm.plugin.game.d.e.a.a aVar = new com.tencent.mm.plugin.game.d.e.a.a();
                        aVar.mGC = R.g.bfs;
                        e.aCi().a(imageView, pVar.mtf, aVar.aCj());
                        this.myv.addView(linearLayout, 0);
                        stringBuffer.append(pVar.jOp);
                        stringBuffer.append("、");
                    }
                    if (this.myv.getChildCount() >= 3) {
                        break;
                    }
                }
            }
            if (this.myv.getChildCount() > 0) {
                this.myv.setVisibility(0);
            }
            this.myw.setText(h.b(this.mContext, stringBuffer.length() > 0 ? stringBuffer.substring(0, stringBuffer.length() - 1) : "", this.myw.getTextSize()));
        }
        if (!bg.mA(caVar.mvJ.msE)) {
            e.aCi().f(this.myx, caVar.mvJ.msE);
        }
        this.myr.setTag(new a(1, caVar.mvJ.msF, caVar.mvJ.msG));
        this.myr.setOnClickListener(this);
        if (this.myq == 2) {
            ai.a(this.mContext, 1018, 1, null, this.mqT, ai.xR(caVar.mvJ.msG));
        }
        if (!bg.mA(caVar.mvK.mvI)) {
            this.myz.setVisibility(0);
            e.aCi().f(this.myz, caVar.mvK.mvI);
        }
        if (!bg.mA(caVar.mvK.muU)) {
            e.aCi().f(this.myA, caVar.mvK.muU);
        }
        this.myB.setText(caVar.mvK.fDC);
        this.myC.setText(caVar.mvK.msk);
        this.myy.setTag(new a(2, caVar.mvK.msF, caVar.mvK.msG));
        this.myy.setOnClickListener(this);
        if (this.myq == 2) {
            ai.a(this.mContext, 1018, 2, null, this.mqT, ai.xR(caVar.mvK.msG));
        }
        if (!bg.mA(caVar.mvL.mvI)) {
            this.myE.setVisibility(0);
            e.aCi().f(this.myE, caVar.mvL.mvI);
        }
        if (!bg.mA(caVar.mvL.muU)) {
            e.aCi().f(this.myF, caVar.mvL.muU);
        }
        this.myG.setText(caVar.mvL.fDC);
        this.myH.setText(caVar.mvL.msk);
        this.myD.setTag(new a(3, caVar.mvL.msF, caVar.mvL.msG));
        this.myD.setOnClickListener(this);
        if (this.myq == 2) {
            ai.a(this.mContext, 1018, 3, null, this.mqT, ai.xR(caVar.mvL.msG));
        }
    }

    public void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            c.aa(this.mContext, aVar.jumpUrl);
            ai.a(this.mContext, 10, 1018, aVar.position, 7, this.mqT, ai.xR(aVar.moQ));
        }
    }
}
