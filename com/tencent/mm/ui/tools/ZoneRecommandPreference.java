package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZoneRecommandPreference extends Preference {
    private TextView ipa;
    int status;
    Region wpe;
    Region wpf;
    Region wpg;
    private TextView wph;
    private ImageView wpi;

    public ZoneRecommandPreference(Context context) {
        this(context, null);
    }

    public ZoneRecommandPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoneRecommandPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.status = 0;
        setLayoutResource(R.i.diC);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.diZ, viewGroup2);
        this.wph = (TextView) onCreateView.findViewById(R.h.cTr);
        this.ipa = (TextView) onCreateView.findViewById(R.h.status);
        this.wpi = (ImageView) onCreateView.findViewById(R.h.cGw);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        bZX();
    }

    final void bZX() {
        if (this.wph != null && this.ipa != null) {
            switch (this.status) {
                case 0:
                    this.wph.setVisibility(8);
                    this.ipa.setVisibility(0);
                    this.ipa.setText(R.l.eRP);
                    this.wpi.setImageResource(R.k.dxq);
                    setEnabled(false);
                    setSelectable(false);
                    return;
                case 1:
                    this.wph.setVisibility(0);
                    this.ipa.setVisibility(8);
                    this.wpi.setImageResource(R.k.dxq);
                    CharSequence charSequence = "";
                    if (!(this.wpe == null || u.mA(this.wpe.getName()))) {
                        charSequence = charSequence + this.wpe.getName();
                    }
                    if (!(this.wpf == null || u.mA(this.wpf.getName()))) {
                        charSequence = charSequence + " " + this.wpf.getName();
                    }
                    if (!(this.wpg == null || u.mA(this.wpg.getName()))) {
                        charSequence = charSequence + " " + this.wpg.getName();
                    }
                    this.wph.setText(charSequence);
                    setEnabled(true);
                    setSelectable(true);
                    return;
                case 2:
                    this.wph.setVisibility(8);
                    this.ipa.setVisibility(0);
                    this.ipa.setText(R.l.eRM);
                    this.wpi.setImageResource(R.k.dxp);
                    setEnabled(false);
                    setSelectable(false);
                    return;
                default:
                    return;
            }
        }
    }

    public final void bZY() {
        this.status = 2;
        bZX();
    }
}
