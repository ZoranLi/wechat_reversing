package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends a {
    private static final int sog = a.fromDPToPix(ab.getContext(), 48);
    private static final int soh = a.fromDPToPix(ab.getContext(), 43);

    public final View wK(int i) {
        View view = null;
        Context context = this.kLX;
        c cVar = this.sof;
        d dVar = new d();
        dVar.mIndex = i;
        dVar.sou = this;
        dVar.mContext = context;
        dVar.sof = cVar;
        if (!(dVar.mContext == null || dVar.sou == null)) {
            view = View.inflate(dVar.mContext, R.i.drS, null);
            if (view instanceof WebViewSmileyGrid) {
                ((WebViewSmileyGrid) view).sof = dVar.sof;
                WebViewSmileyGrid webViewSmileyGrid = (WebViewSmileyGrid) view;
                int i2 = dVar.mIndex;
                int bAd = dVar.sou.bAd();
                int anU = dVar.sou.anU();
                int bAe = dVar.sou.bAe();
                int rowCount = dVar.sou.getRowCount();
                int bAf = dVar.sou.bAf();
                webViewSmileyGrid.setLayoutParams(new LayoutParams(-1, -1));
                webViewSmileyGrid.setBackgroundResource(0);
                webViewSmileyGrid.setStretchMode(2);
                webViewSmileyGrid.setOnItemClickListener(webViewSmileyGrid.acN);
                webViewSmileyGrid.kTy = i2;
                webViewSmileyGrid.kTw = bAd;
                webViewSmileyGrid.soj = anU;
                webViewSmileyGrid.sok = bAf;
                webViewSmileyGrid.sol = bAe;
                webViewSmileyGrid.som = rowCount;
                webViewSmileyGrid.setNumColumns(bAe);
                i2 = webViewSmileyGrid.sok;
                bAf = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                bAd = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                if (i2 == 0) {
                    i2 = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                }
                webViewSmileyGrid.setPadding(bAf, i2, bAd, 0);
                webViewSmileyGrid.soi = new a();
                webViewSmileyGrid.setAdapter(webViewSmileyGrid.soi);
                webViewSmileyGrid.soi.notifyDataSetChanged();
            }
        }
        return view;
    }

    public final int bAd() {
        return this.sof.YX().YZ();
    }

    public final int anU() {
        return bAe() * getRowCount();
    }

    public final int getPageCount() {
        if (anU() <= 0) {
            return 0;
        }
        return (int) Math.ceil(((double) bAd()) / ((double) anU()));
    }

    public final int bAe() {
        if (this.sof.soq) {
            return 7;
        }
        c cVar = this.sof;
        if (cVar.kUX <= 1) {
            cVar.kUX = c.Xf()[0];
        }
        return cVar.kUX / soh;
    }

    public final int bAf() {
        return (this.sof.kUW - (sog * getRowCount())) / (getRowCount() + 1);
    }

    public final int getRowCount() {
        int i = 3;
        int i2 = this.sof.kUW / sog;
        if (i2 <= 3) {
            i = i2;
        }
        return i <= 0 ? 1 : i;
    }
}
