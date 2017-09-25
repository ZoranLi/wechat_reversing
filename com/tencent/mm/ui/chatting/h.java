package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.chatting.ah.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

final class h extends a {
    public static Map<String, WeakReference<h>> vyC = new HashMap();
    ProgressBar oDJ;
    ImageView vyA;
    TextView vyB;
    RTChattingEmojiView vyw;
    ImageView vyx;
    ImageView vyy;
    ProgressBar vyz;

    public h(int i) {
        super(i);
    }

    public final a p(View view, boolean z) {
        super.dn(view);
        this.kxi = (TextView) view.findViewById(R.h.bBA);
        this.vyw = (RTChattingEmojiView) view.findViewById(R.h.bAj);
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        this.vyz = (ProgressBar) view.findViewById(R.h.bAr);
        this.vyA = (ImageView) view.findViewById(R.h.bBx);
        this.vyB = (TextView) view.findViewById(R.h.bBu);
        if (z) {
            this.type = 14;
        } else {
            this.oDJ = (ProgressBar) view.findViewById(R.h.cKX);
            this.vyK = (ImageView) view.findViewById(R.h.bBw);
            this.type = 15;
            this.vyy = (ImageView) view.findViewById(R.h.bBy);
        }
        if (this.vyx != null) {
            ((ViewGroup) this.vyx.getParent()).setBackgroundDrawable(null);
        }
        this.piH = (TextView) view.findViewById(R.h.bBG);
        return this;
    }

    public static void i(String str, int i, int i2) {
        if (vyC.containsKey(str)) {
            h hVar = (h) ((WeakReference) vyC.get(str)).get();
            if (hVar != null) {
                switch (i2) {
                    case 0:
                        hVar.vyz.setVisibility(0);
                        hVar.vyB.setVisibility(8);
                        hVar.vyA.setVisibility(8);
                        hVar.vyz.setProgress(0);
                        return;
                    case 1:
                        hVar.vyz.setVisibility(8);
                        hVar.vyB.setVisibility(8);
                        hVar.vyA.setVisibility(8);
                        return;
                    case 2:
                        hVar.vyz.setVisibility(8);
                        hVar.vyB.setVisibility(8);
                        hVar.vyA.setVisibility(0);
                        hVar.vyz.setProgress(i);
                        hVar.vyA.setImageResource(R.g.beL);
                        return;
                    default:
                        return;
                }
            }
            return;
        }
        w.i("AppMsgEmojiItemHolder", "no contain attchid:%s");
    }
}
