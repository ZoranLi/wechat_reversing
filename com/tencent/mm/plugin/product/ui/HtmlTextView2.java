package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;

public class HtmlTextView2 extends MMWebView {
    private WebViewClient oqq = new WebViewClient(this) {
        final /* synthetic */ HtmlTextView2 oqr;

        {
            this.oqr = r1;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            w.d("test", str);
            return true;
        }
    };

    public HtmlTextView2(Context context, AttributeSet attributeSet, int i) {
        super(ab.getContext(), attributeSet, i);
        KC();
    }

    public HtmlTextView2(Context context, AttributeSet attributeSet) {
        super(ab.getContext(), attributeSet);
        KC();
    }

    private void KC() {
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ HtmlTextView2 oqr;

            {
                this.oqr = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getAction() == 2;
            }
        });
        setVerticalScrollBarEnabled(false);
        getSettings().setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
        getSettings().setDefaultTextEncodingName(ProtocolPackage.ServerEncoding);
    }
}
