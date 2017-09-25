package com.tencent.mm.plugin.appbrand.dynamic.html;

import android.content.Intent;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.mm.bb.d;
import com.tencent.mm.sdk.platformtools.w;

public class CustomURLSpan extends URLSpan {
    private String mUrl;

    public CustomURLSpan(String str) {
        super(str);
        this.mUrl = str;
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.mUrl);
        d.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        w.d("MicroMsg.CustomURLSpan", "on custom url(%s) span clicked.", new Object[]{this.mUrl});
    }
}
