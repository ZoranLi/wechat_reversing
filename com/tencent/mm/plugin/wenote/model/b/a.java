package com.tencent.mm.plugin.wenote.model.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.ij;
import com.tencent.mm.e.a.kb;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    static LinearLayout suS;
    static LinearLayout suT;
    static TextView suU;
    static TextView suV;
    static ProgressBar suW;
    static ImageView suX;
    static ProgressBar suY;
    static ImageView suZ;
    static ImageView sva;
    private Context context;

    public final void bBl() {
        this.context = ab.getContext();
        View inflate = LayoutInflater.from(this.context).inflate(R.i.dcn, null);
        suT = (LinearLayout) inflate.findViewById(R.h.bOI);
        suV = (TextView) inflate.findViewById(R.h.bAT);
        suU = (TextView) inflate.findViewById(R.h.bAV);
        suS = (LinearLayout) inflate.findViewById(R.h.bAU);
        suW = (ProgressBar) inflate.findViewById(R.h.bAQ);
        suX = (ImageView) inflate.findViewById(R.h.bAS);
        suY = (ProgressBar) inflate.findViewById(R.h.bAR);
        suZ = (ImageView) inflate.findViewById(R.h.bAm);
        sva = (ImageView) inflate.findViewById(R.h.bAl);
        inflate.measure(MeasureSpec.makeMeasureSpec(600, 1073741824), MeasureSpec.makeMeasureSpec(450, 1073741824));
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
        suX.measure(MeasureSpec.makeMeasureSpec(600, 1073741824), MeasureSpec.makeMeasureSpec(450, 1073741824));
        suX.layout(0, 0, suX.getMeasuredWidth(), suX.getMeasuredHeight());
    }

    public static void e(String str, String str2, String str3, String str4, String str5) {
        suS.setVisibility(8);
        if (bg.mA(str3)) {
            suX.setImageResource(R.g.bgl);
        } else {
            Drawable createFromPath = Drawable.createFromPath(str3);
            if (createFromPath == null) {
                w.e("MicroMsg.GetLocationInfoThumb", "setLocalInfo: drawable is null. bg set failed");
            }
            suT.setBackgroundDrawable(createFromPath);
        }
        if (!d.Jt("location")) {
            suW.setVisibility(0);
            suS.setVisibility(8);
        } else if ((str != null || Lp(str2)) && ((str == null || !str.equals("") || Lp(str2)) && (str == null || !str.equals("err_not_started")))) {
            suY.setVisibility(8);
            suS.setVisibility(0);
            w.d("MicroMsg.GetLocationInfoThumb", "location info : " + str);
            if (Lp(str2)) {
                suU.setVisibility(0);
                suU.setText(str2);
                if (str == null || str.equals("")) {
                    suV.setVisibility(8);
                } else {
                    suV.setVisibility(0);
                    suV.setText(str);
                }
            } else {
                suU.setMaxLines(2);
                suU.setText(str);
                suV.setVisibility(8);
            }
        } else {
            w.d("MicroMsg.GetLocationInfoThumb", "info error or subcore not started!");
            suY.setVisibility(0);
            suS.setVisibility(0);
            suU.setText("");
            suV.setText("");
        }
        int width = suT.getWidth();
        int height = suT.getHeight();
        if (width <= 0 || height <= 0) {
            w.e("MicroMsg.GetLocationInfoThumb", "Save Location thumb file fail");
            return;
        }
        b ijVar = new ij();
        ijVar.fNX.fNZ = 0;
        ijVar.fNX.fOa = str4;
        ijVar.fNX.filename = str5;
        ijVar.fNX.view = suT;
        com.tencent.mm.sdk.b.a.urY.m(ijVar);
        String str6 = ijVar.fNY.path;
        w.i("MicroMsg.GetLocationInfoThumb", "WNNoteWebview　UI Save Location thumb file success");
        if (!bg.mA(str3) && com.tencent.mm.plugin.wenote.b.b.swP.containsKey(str3)) {
            ijVar = new kb();
            ijVar.fQz.type = 5;
            com.tencent.mm.sdk.b.a.urY.m(ijVar);
            if (ijVar.fQA.ret != -1) {
                sva.setVisibility(8);
                m mVar = (m) com.tencent.mm.plugin.wenote.b.b.swP.get(str3);
                w.d("MicroMsg.GetLocationInfoThumb", "wenote location thumb update with WNNoteWebViewLogic.mInitWNNoteWebViewID");
                if (!bg.mA(mVar.suN)) {
                    b kbVar = new kb();
                    kbVar.fQz.type = 1;
                    kbVar.fQz.fQq = mVar.suN;
                    kbVar.fQz.fQE = str6;
                    com.tencent.mm.sdk.b.a.urY.m(kbVar);
                }
            }
        }
    }

    private static boolean Lp(String str) {
        return (str == null || str.equals("")) ? false : true;
    }
}
