package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

public class BizInfoPayInfoIconPreference extends Preference {
    private LayoutInflater Du;
    private LinearLayout osD;
    private List<String> osE;
    private int osF;

    public BizInfoPayInfoIconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BizInfoPayInfoIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.osF = -1;
        this.Du = (LayoutInflater) context.getSystemService("layout_inflater");
        setLayoutResource(R.i.diC);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        this.Du.inflate(R.i.cZy, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.osD = (LinearLayout) view.findViewById(R.h.summary);
        ar();
    }

    public final void rl(int i) {
        if (i != this.osF) {
            this.osF = i;
            ar();
        }
    }

    public final void ba(List<String> list) {
        this.osE = list;
        ar();
    }

    private void ar() {
        int i = 0;
        if (this.osD != null) {
            this.osD.removeAllViews();
            if (this.osF >= 0) {
                int i2 = this.osF;
                while (i < 5) {
                    if (i2 <= 0) {
                        rm(R.k.dur);
                    } else if (i2 <= 10) {
                        rm(R.k.dup);
                        i2 -= 20;
                    } else {
                        rm(R.k.duq);
                        i2 -= 20;
                    }
                    i++;
                }
            } else if (this.osE != null) {
                for (String str : this.osE) {
                    View cdnImageView = new CdnImageView(this.mContext);
                    cdnImageView.L(str, 0, 0);
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
                    layoutParams.rightMargin = a.fromDPToPix(this.mContext, 6);
                    this.osD.addView(cdnImageView, layoutParams);
                }
            }
        }
    }

    private void rm(int i) {
        ImageView imageView = (ImageView) this.Du.inflate(R.i.cZv, null);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
        layoutParams.rightMargin = a.fromDPToPix(this.mContext, 6);
        imageView.setImageResource(i);
        this.osD.addView(imageView, layoutParams);
    }
}
