package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.Preference;

public class DomainMailListPreference extends Preference {
    private TextView ioX;
    private boolean lib;
    private String title;
    private TextView vXA;
    private String vXx;
    private TextView vXy;
    private TextView vXz;

    public DomainMailListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DomainMailListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.lib = false;
        this.title = "";
        this.vXx = "";
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.diH, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.ioX = (TextView) view.findViewById(R.h.title);
        this.vXy = (TextView) view.findViewById(R.h.bQc);
        this.vXz = (TextView) view.findViewById(R.h.cBh);
        this.vXA = (TextView) view.findViewById(R.h.cHZ);
        this.lib = true;
        if (this.lib) {
            this.ioX.setText(u.mz(this.title));
            String[] split = this.vXx.split(";");
            if (u.mz(this.vXx).length() <= 0) {
                this.vXy.setVisibility(8);
                this.vXz.setVisibility(8);
            } else {
                if (split.length > 0) {
                    this.vXy.setVisibility(0);
                    this.vXy.setText(u.mz(split[0]));
                } else {
                    this.vXy.setVisibility(8);
                }
                if (split.length > 1) {
                    this.vXz.setVisibility(0);
                    this.vXz.setText(u.mz(split[1]));
                } else {
                    this.vXz.setVisibility(8);
                }
                if (split.length > 2) {
                    this.vXA.setVisibility(0);
                    this.vXA.setText(u.mz(split[2]));
                }
            }
            this.vXA.setVisibility(8);
        } else {
            w.e("MicroMsg.DomainMailPreference", "initView : unbind view");
        }
        super.onBindView(view);
    }
}
