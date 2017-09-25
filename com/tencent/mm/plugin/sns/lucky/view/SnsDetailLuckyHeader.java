package com.tencent.mm.plugin.sns.lucky.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.TouchImageView;
import com.tencent.mm.plugin.sns.ui.h;
import com.tencent.mm.protocal.c.bbg;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bbz;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;

public class SnsDetailLuckyHeader extends LinearLayout {
    private View kQt = null;
    private TextView pSj;
    private LinearLayout pSk;
    private LinearLayout pSl;

    public SnsDetailLuckyHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public SnsDetailLuckyHeader(Context context) {
        super(context);
        init();
    }

    public SnsDetailLuckyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        View inflate = View.inflate(getContext(), g.pGK, this);
        this.kQt = inflate.findViewById(f.pBF);
        this.pSj = (TextView) inflate.findViewById(f.pBo);
        this.pSk = (LinearLayout) inflate.findViewById(f.pBp);
        b.a(getContext(), 2.0f);
        LayoutParams layoutParams = new AbsListView.LayoutParams(-1, 1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundResource(e.pAo);
        linearLayout.setLayoutParams(layoutParams);
        this.pSl = linearLayout;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.kQt != null) {
            this.kQt.setVisibility(i);
        }
    }

    public final void a(m mVar, com.tencent.mm.plugin.sns.ui.b.b bVar) {
        bbk n = ai.n(mVar);
        bbz com_tencent_mm_protocal_c_bbz = n.ucB;
        if (com_tencent_mm_protocal_c_bbz == null || com_tencent_mm_protocal_c_bbz.ude.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        double b = ((double) com.tencent.mm.plugin.sns.lucky.a.m.b(mVar, n)) * 1.0d;
        this.pSj.setText(getContext().getString(j.pLM, new Object[]{Integer.valueOf(n.ucB.udd), bg.n(b / 100.0d)}));
        this.kQt.setTag(mVar);
        this.kQt.setOnClickListener(bVar.qNB);
        LinkedList linkedList = com_tencent_mm_protocal_c_bbz.ude;
        boolean isEmpty = com_tencent_mm_protocal_c_bbz.ude.isEmpty();
        int a = b.a(getContext(), 32.0f);
        int a2 = b.a(getContext(), 6.0f);
        int a3 = b.a(getContext(), 10.0f);
        int a4 = b.a(getContext(), 17.0f);
        if (this.pSk != null) {
            int i;
            LinearLayout linearLayout;
            w.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d %f", new Object[]{Integer.valueOf(((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth()), Float.valueOf(getResources().getDimension(d.aXH))});
            float f = ((float) i) - (f * 2.0f);
            if (linkedList.size() <= 0) {
                if (this.pSk.getParent() != null) {
                    this.pSk.setVisibility(8);
                }
                this.pSk.removeAllViews();
                this.pSk.setVisibility(8);
                linearLayout = this.pSk;
                i = 8;
            } else {
                this.pSk.getParent();
                this.pSk.removeAllViews();
                this.pSk.setVisibility(0);
                this.pSk.setPadding(0, a2, 0, a2);
                View imageView = new ImageView(getContext());
                imageView.setImageResource(i.pIY);
                imageView.setPadding(a3, a4, a3, 0);
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                imageView.setLayoutParams(layoutParams);
                imageView.setClickable(false);
                imageView.setFocusable(false);
                this.pSk.addView(imageView);
                a3 = a.fromDPToPix(getContext(), SnsCommentDetailUI.qzV);
                i = ((int) (f - ((float) a3))) / (a2 + a);
                if (((int) (f - ((float) a3))) % (a2 + a) > a) {
                    i++;
                }
                w.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d", new Object[]{Integer.valueOf(i)});
                View hVar = new h(getContext());
                hVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                hVar.qpW = i;
                for (a3 = 0; a3 < linkedList.size(); a3++) {
                    bbg com_tencent_mm_protocal_c_bbg = (bbg) linkedList.get(a3);
                    View touchImageView = new TouchImageView(getContext());
                    touchImageView.setScaleType(ScaleType.FIT_XY);
                    touchImageView.setImageResource(e.pzF);
                    LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a, a);
                    layoutParams2.setMargins(0, a2, a2, 0);
                    touchImageView.setLayoutParams(layoutParams2);
                    touchImageView.setTag(com_tencent_mm_protocal_c_bbg.tgG);
                    com.tencent.mm.pluginsdk.ui.a.b.b(touchImageView, com_tencent_mm_protocal_c_bbg.tgG, true);
                    touchImageView.setOnClickListener(bVar.qNq);
                    hVar.addView(touchImageView);
                }
                this.pSk.addView(hVar);
                linearLayout = this.pSl;
                i = isEmpty ? 8 : 0;
            }
            linearLayout.setVisibility(i);
        }
    }
}
