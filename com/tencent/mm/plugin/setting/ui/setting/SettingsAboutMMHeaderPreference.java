package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.smtt.sdk.WebView;

public class SettingsAboutMMHeaderPreference extends Preference {
    String pjv = "";

    public SettingsAboutMMHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SettingsAboutMMHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.h.bmw);
        textView.setText(String.format("%s %s", new Object[]{view.getResources().getString(R.l.bpJ), this.pjv}));
        textView.setOnClickListener(new OnClickListener(this) {
            private long pjw = 0;
            final /* synthetic */ SettingsAboutMMHeaderPreference pjx;

            {
                this.pjx = r3;
            }

            public final void onClick(View view) {
                long Nz = bg.Nz();
                if (this.pjw > Nz || Nz - this.pjw > 300) {
                    this.pjw = Nz;
                    return;
                }
                this.pjw = Nz;
                Context context = this.pjx.mContext;
                CharSequence stringBuilder = new StringBuilder();
                stringBuilder.append(String.format("[ver  ] %s %08X\n", new Object[]{f.b(context, d.sYN, true), Integer.valueOf(d.sYN)}));
                stringBuilder.append(e.aKs());
                stringBuilder.append(String.format("[cid  ] %d\n", new Object[]{Integer.valueOf(f.fuV)}));
                stringBuilder.append(String.format("[s.ver] %d\n", new Object[]{Integer.valueOf(com.tencent.mm.as.d.hPo)}));
                stringBuilder.append(String.format("[r.ver] %s\n", new Object[]{"0x26050D40"}));
                View textView = new TextView(context);
                textView.setText(stringBuilder);
                textView.setGravity(19);
                textView.setTextSize(1, 10.0f);
                textView.setLayoutParams(new LayoutParams(-1, -2));
                textView.setTextColor(WebView.NIGHT_MODE_COLOR);
                textView.setTypeface(Typeface.MONOSPACE);
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.aXt);
                textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                g.a(context, null, textView, null);
            }
        });
    }
}
