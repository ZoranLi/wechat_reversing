package com.tencent.mm.ui.chatting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.w;

public final class bj extends RelativeLayout {
    private LayoutInflater myo;
    private int vDd;

    public bj(LayoutInflater layoutInflater, int i) {
        super(layoutInflater.getContext());
        this.myo = layoutInflater;
        this.vDd = i;
        View inflate = this.myo.inflate(R.i.cXw, null);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        inflate.setId(R.h.bAH);
        layoutParams.setMargins(0, getResources().getDimensionPixelSize(R.f.aXH), 0, getResources().getDimensionPixelSize(R.f.aXH));
        inflate.setVisibility(8);
        addView(inflate, layoutParams);
        inflate = new TextView(getContext(), null, R.m.fos);
        inflate.setId(R.h.bBA);
        inflate.setTextSize(0, (float) a.T(getContext(), R.f.aXW));
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, R.h.bAH);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, getResources().getDimensionPixelSize(R.f.aXH), 0, getResources().getDimensionPixelSize(R.f.aXH));
        addView(inflate, layoutParams);
        CheckBox checkBox = (CheckBox) LayoutInflater.from(getContext()).inflate(R.i.diw, this, false);
        checkBox.setId(R.h.bAd);
        int fromDPToPix = a.fromDPToPix(getContext(), 32);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(fromDPToPix, fromDPToPix);
        layoutParams2.setMargins(0, getResources().getDimensionPixelSize(R.f.aWA), getResources().getDimensionPixelSize(R.f.aXR), 0);
        layoutParams2.addRule(3, R.h.bBA);
        layoutParams2.addRule(11);
        layoutParams2.width = fromDPToPix;
        layoutParams2.height = fromDPToPix;
        addView(checkBox, layoutParams2);
        View inflate2 = this.myo.inflate(this.vDd, null);
        int id = inflate2.getId();
        if (-1 == id) {
            w.v("MicroMsg.ChattingItemContainer", "content view has no id, use defaul id");
            id = R.h.bAg;
            inflate2.setId(R.h.bAg);
        }
        layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(3, R.h.bBA);
        layoutParams2.addRule(0, R.h.bAd);
        addView(inflate2, layoutParams2);
        inflate2 = new View(getContext());
        inflate2.setId(R.h.bAX);
        inflate2.setVisibility(8);
        layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(6, id);
        layoutParams2.addRule(8, id);
        addView(inflate2, layoutParams2);
    }
}
