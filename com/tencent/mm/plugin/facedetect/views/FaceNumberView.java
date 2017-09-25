package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Timer;

public class FaceNumberView extends LinearLayout {
    private String lCH;
    private int lCI;
    public ViewGroup lCJ;
    public FaceNumberItemView[] lCK;
    public int lCL;
    private Animation lCM;
    private int lCN;

    public enum a {
        ;

        static {
            lCO = 1;
            lCP = 2;
            lCQ = new int[]{lCO, lCP};
        }
    }

    public FaceNumberView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public FaceNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.lCH = null;
        this.lCK = null;
        this.lCL = 0;
        this.lCM = null;
        this.lCN = a.lCP;
        this.lCJ = (ViewGroup) inflate(getContext(), g.ltw, null);
        addView(this.lCJ);
        this.lCM = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.facedetect.a.a.aRm);
    }

    private static void a(FaceNumberItemView faceNumberItemView, String str) {
        if (faceNumberItemView != null) {
            if (str.equals("0")) {
                faceNumberItemView.setImageResource(d.lsv);
            } else if (str.equals("1")) {
                faceNumberItemView.setImageResource(d.lsw);
            } else if (str.equals("2")) {
                faceNumberItemView.setImageResource(d.lsx);
            } else if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                faceNumberItemView.setImageResource(d.lsy);
            } else if (str.equals("4")) {
                faceNumberItemView.setImageResource(d.lsz);
            } else if (str.equals("5")) {
                faceNumberItemView.setImageResource(d.lsA);
            } else if (str.equals("6")) {
                faceNumberItemView.setImageResource(d.lsB);
            } else if (str.equals("7")) {
                faceNumberItemView.setImageResource(d.lsC);
            } else if (str.equals("8")) {
                faceNumberItemView.setImageResource(d.lsD);
            } else if (str.equals("9")) {
                faceNumberItemView.setImageResource(d.lsE);
            } else {
                faceNumberItemView.setImageResource(d.lsF);
            }
        }
    }

    public final void vM(String str) {
        int i = 0;
        this.lCH = str;
        if (this.lCH != null) {
            this.lCI = this.lCH.length();
        } else {
            this.lCI = 0;
        }
        if (this.lCK != null && this.lCK.length > 0) {
            if (bg.mA(this.lCH)) {
                while (i < this.lCK.length) {
                    a(this.lCK[i], "point");
                    i++;
                }
                return;
            }
            for (int i2 = 0; i2 < this.lCK.length; i2++) {
                String str2;
                if (this.lCI > i2) {
                    String str3 = this.lCH.charAt(i2);
                    FaceNumberItemView faceNumberItemView;
                    if (this.lCI == i2 + 1) {
                        faceNumberItemView = this.lCK[i2];
                        if (faceNumberItemView.lCw != null) {
                            faceNumberItemView.asO();
                        }
                        faceNumberItemView.lCw = new Timer("FaceNumberItemView_karaoke", true);
                        faceNumberItemView.lCw.scheduleAtFixedRate(new a(faceNumberItemView.lCE), 0, FaceNumberItemView.lCx);
                        str2 = str3;
                    } else {
                        this.lCK[i2].asO();
                        faceNumberItemView = this.lCK[i2];
                        faceNumberItemView.lCD = 30;
                        faceNumberItemView.invalidate();
                        str2 = str3;
                    }
                } else {
                    str2 = "";
                }
                a(this.lCK[i2], str2);
            }
        }
    }
}
