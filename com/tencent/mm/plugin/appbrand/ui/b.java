package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.a;

public final class b extends a {
    static b bg(String str, String str2) {
        b bVar = new b();
        Bundle bundle = new Bundle(2);
        bundle.putString("extra_title", str);
        bundle.putString("extra_tip", str2);
        bVar.setArguments(bundle);
        return bVar;
    }

    public final void onResume() {
        super.onResume();
        aG().setTitle(this.oW == null ? "" : this.oW.getString("extra_title"));
    }

    public final void KC() {
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        View imageView = new ImageView(getContext());
        imageView.setImageResource(R.k.dtE);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(is(50), is(50));
        layoutParams.topMargin = is(91);
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        View textView = new TextView(getContext());
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(Color.parseColor("#B2B2B2"));
        textView.setGravity(17);
        textView.setText(this.oW == null ? "" : this.oW.getString("extra_tip"));
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = is(16);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        ((ViewGroup) this.Ih).addView(linearLayout, new LayoutParams(-1, -1));
        com.tencent.mm.plugin.appbrand.report.a.a(this.hPi, "", "", 0, "", this.jiC);
    }
}
