package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.modelstat.j;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.Preference;

public class NetStatPreference extends Preference {
    boolean piE;

    public NetStatPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetStatPreference(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        super(context, attributeSet, i);
        this.piE = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.fru, i, 0);
        if (obtainStyledAttributes.getInt(R.n.frv, 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.piE = z;
        obtainStyledAttributes.recycle();
        setSummary(context.getString(R.l.eTe, new Object[]{Integer.valueOf(15)}));
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.diP, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        View netStatGroup;
        super.onBindView(view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.h.bVE);
        linearLayout.removeAllViews();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 86400000);
        for (int i = 15; i > 0; i -= 5) {
            netStatGroup = new NetStatGroup(this.mContext);
            int i2 = (currentTimeMillis - i) + 1;
            boolean z = this.piE;
            Object charSequence = DateFormat.format(netStatGroup.getContext().getString(R.l.elp, new Object[]{""}), ((long) i2) * 86400000).toString();
            netStatGroup.oKx.setText(charSequence);
            w.d("MicroMsg.NetStatGroup", "NetStat dataTime = " + charSequence);
            netStatGroup.piD.removeAllViews();
            for (int i3 = 0; i3 < 5; i3++) {
                View netStatUnit = new NetStatUnit(netStatGroup.getContext());
                j gE = p.Kh().gE(i2 + i3);
                if (gE != null) {
                    if (z) {
                        w.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d wifi : %d %d %d %d", new Object[]{Integer.valueOf(gE.hWl), Integer.valueOf(gE.hWH), Integer.valueOf(gE.hWv), Integer.valueOf(gE.hWJ), Integer.valueOf(gE.hWx)});
                        netStatUnit.cQ(gE.hWH + gE.hWv, gE.hWx + gE.hWJ);
                    } else {
                        w.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d mobile : %d %d %d %d", new Object[]{Integer.valueOf(gE.hWl), Integer.valueOf(gE.hWG), Integer.valueOf(gE.hWu), Integer.valueOf(gE.hWI), Integer.valueOf(gE.hWw)});
                        netStatUnit.cQ(gE.hWG + gE.hWu, gE.hWw + gE.hWI);
                    }
                }
                netStatUnit.setLayoutParams(new LayoutParams(-1, -1, 1.0f));
                netStatGroup.piD.addView(netStatUnit);
            }
            linearLayout.addView(netStatGroup, -2, -1);
        }
        linearLayout = (LinearLayout) view.findViewById(R.h.czA);
        linearLayout.removeAllViews();
        View netStatGroup2 = new NetStatGroup(this.mContext);
        boolean z2 = this.piE;
        netStatGroup2.removeAllViews();
        View.inflate(netStatGroup2.getContext(), R.i.dkd, netStatGroup2);
        netStatGroup2.piD = (LinearLayout) netStatGroup2.findViewById(R.h.bVE);
        netStatGroup = new NetStatRuler(netStatGroup2.getContext());
        netStatGroup.setTag(z2 ? "wifi" : "mobile");
        netStatGroup.setLayoutParams(new LayoutParams(-1, -1, 1.0f));
        netStatGroup2.piD.addView(netStatGroup);
        linearLayout.addView(netStatGroup2);
    }
}
