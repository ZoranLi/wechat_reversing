package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZonePreference extends Preference {
    Region wpb;
    private CharSequence wpc;
    private TextView wpd;

    public ZonePreference(Context context) {
        this(context, null);
    }

    public ZonePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZonePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.diC);
    }

    public final void a(Region region) {
        if (region == null || u.mA(region.getName()) || u.mA(region.getCode())) {
            w.e("MicroMsg.ZonePreference", "setZoneItem item = null");
            return;
        }
        setKey(region.getCode() + region.isCity());
        this.wpb = region;
    }

    public final void setSummary(CharSequence charSequence) {
        this.wpc = charSequence;
        bZW();
    }

    private void bZW() {
        if (this.wpd != null) {
            if (this.wpc == null || u.mA(this.wpc.toString())) {
                this.wpd.setVisibility(8);
            } else {
                this.wpd.setVisibility(0);
            }
            this.wpd.setText(this.wpc);
        }
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.diY, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.wpb != null) {
            ((TextView) view.findViewById(R.h.cTr)).setText(this.wpb.getName());
            this.wpd = (TextView) view.findViewById(R.h.cGQ);
            bZW();
        }
    }
}
