package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactSocialInfoPreference extends Preference {
    private TextView kmZ;
    private ImageView otb;
    private ImageView otc;
    private ImageView otd;
    private ImageView ote;
    private ImageView otf;
    private ImageView otg;
    private int oth = 8;
    private int oti = 8;
    private int otj = 8;
    private int otk = 8;
    private int otl = 8;
    private int otm = 8;

    public ContactSocialInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ContactSocialInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.diC);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.diX, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.otb = (ImageView) view.findViewById(R.h.bXc);
        this.otc = (ImageView) view.findViewById(R.h.bXg);
        this.otd = (ImageView) view.findViewById(R.h.bWZ);
        this.ote = (ImageView) view.findViewById(R.h.bWI);
        this.otf = (ImageView) view.findViewById(R.h.bWR);
        this.otg = (ImageView) view.findViewById(R.h.bXl);
        this.kmZ = (TextView) view.findViewById(R.h.title);
        ar();
        super.onBindView(view);
    }

    public final void rr(int i) {
        this.oth = i;
        ar();
    }

    public final void rn(int i) {
        this.oti = i;
        ar();
    }

    public final void ro(int i) {
        this.otj = i;
        ar();
    }

    public final void rp(int i) {
        this.otl = i;
        ar();
    }

    public final void rq(int i) {
        this.otm = i;
        ar();
    }

    private void ar() {
        if (this.otb != null) {
            this.otb.setVisibility(this.oth);
        }
        if (this.otc != null) {
            this.otc.setVisibility(this.oti);
        }
        if (this.otd != null) {
            this.otd.setVisibility(this.otj);
        }
        if (this.ote != null) {
            this.ote.setVisibility(this.otk);
        }
        if (this.otf != null) {
            this.otf.setVisibility(this.otl);
        }
        if (this.kmZ != null) {
            LayoutParams layoutParams = this.kmZ.getLayoutParams();
            layoutParams.width = a.T(this.mContext, R.f.aXk);
            this.kmZ.setLayoutParams(layoutParams);
        }
        if (this.otg != null) {
            this.otg.setVisibility(this.otm);
        }
    }
}
