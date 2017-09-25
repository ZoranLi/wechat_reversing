package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.text.Spannable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.Chart;
import java.util.ArrayList;

public class RadarChart extends Chart {
    private Context context;
    public ArrayList<a> qgV;
    public c qgW = new c();
    public TextView qgX;
    public RadarGrid qgY;
    private RadarDataLayer[] qgZ;
    private a qha;
    private boolean qhb = true;
    private boolean qhc = true;
    public int qhd = 3;
    public int qhe = 0;
    public int qhf = 4;
    public Spannable[] qhg;
    private float qhh = 1.0f;

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public final void a(a... aVarArr) {
        int i;
        int i2 = 0;
        removeAllViews();
        for (a size : aVarArr) {
            if (size.size() <= 0) {
                throw new Exception("Not enough elements.");
            }
        }
        for (a size2 : aVarArr) {
            i = 0;
            while (i < aVarArr.length) {
                if (size2.a(aVarArr[i])) {
                    i++;
                } else {
                    throw new Error("Layer not compatible.");
                }
            }
        }
        this.qhg = aVarArr[0].bfX();
        this.qhe = aVarArr[0].size();
        if (this.qgV == null) {
            this.qgV = new ArrayList();
        }
        for (Object add : aVarArr) {
            this.qgV.add(add);
        }
        this.qgY = new RadarGrid(this.context, this.qhe, this.qhf, this.qhh, this.qhg, this.qgW);
        addView(this.qgY);
        this.qgZ = new RadarDataLayer[this.qhd];
        while (i2 < this.qgZ.length && this.qgV.size() > i2) {
            this.qgZ[i2] = new RadarDataLayer(this.context, this.qhh, (a) this.qgV.get(i2));
            addView(this.qgZ[i2]);
            i2++;
        }
        if (this.qha == null) {
            this.qha = new a(this.context, this.qgW);
        }
        addView(this.qha);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
    }
}
