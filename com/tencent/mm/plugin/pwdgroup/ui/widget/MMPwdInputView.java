package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class MMPwdInputView extends LinearLayout {
    public StringBuilder kxS;
    public int lCI;
    private boolean oyn;
    private ImageView oyo;
    private ImageView oyp;
    private ImageView oyq;
    private ImageView oyr;
    public a oys;
    private int oyt;

    public interface a {
        void f(boolean z, String str);
    }

    public enum b {
        ;

        static {
            oyu = 1;
            oyv = 2;
            oyw = new int[]{oyu, oyv};
        }
    }

    public MMPwdInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMPwdInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.kxS = new StringBuilder();
        this.oyn = false;
        this.oyt = b.oyv;
        View inflate = inflate(getContext(), R.i.dlw, null);
        this.oyo = (ImageView) inflate.findViewById(R.h.bQb);
        this.oyp = (ImageView) inflate.findViewById(R.h.second);
        this.oyq = (ImageView) inflate.findViewById(R.h.cHY);
        this.oyr = (ImageView) inflate.findViewById(R.h.bRf);
        this.oyo.setImageResource(R.g.bcs);
        this.oyp.setImageResource(R.g.bcs);
        this.oyq.setImageResource(R.g.bcs);
        this.oyr.setImageResource(R.g.bcs);
        addView(inflate);
    }

    public final void aUa() {
        for (int i = 0; i < 4; i++) {
            String str;
            if (this.lCI > i) {
                str = this.kxS.toString().charAt(i);
            } else {
                str = "";
            }
            switch (i) {
                case 0:
                    l(this.oyo, str);
                    break;
                case 1:
                    l(this.oyp, str);
                    break;
                case 2:
                    l(this.oyq, str);
                    break;
                case 3:
                    l(this.oyr, str);
                    break;
                default:
                    break;
            }
        }
    }

    private static void l(ImageView imageView, String str) {
        if (imageView != null) {
            if (str.equals("0")) {
                imageView.setImageResource(R.g.bci);
            } else if (str.equals("1")) {
                imageView.setImageResource(R.g.bcj);
            } else if (str.equals("2")) {
                imageView.setImageResource(R.g.bck);
            } else if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                imageView.setImageResource(R.g.bcl);
            } else if (str.equals("4")) {
                imageView.setImageResource(R.g.bcm);
            } else if (str.equals("5")) {
                imageView.setImageResource(R.g.bcn);
            } else if (str.equals("6")) {
                imageView.setImageResource(R.g.bco);
            } else if (str.equals("7")) {
                imageView.setImageResource(R.g.bcp);
            } else if (str.equals("8")) {
                imageView.setImageResource(R.g.bcq);
            } else if (str.equals("9")) {
                imageView.setImageResource(R.g.bcr);
            } else {
                imageView.setImageResource(R.g.bcs);
            }
        }
    }

    public final void aUb() {
        if (this.kxS != null) {
            this.lCI = this.kxS.length();
        } else {
            this.lCI = 0;
        }
        if (this.lCI >= 4) {
            this.oyn = true;
        } else {
            this.oyn = false;
        }
        if (this.oys != null) {
            this.oys.f(this.oyn, this.kxS.toString());
        }
    }

    public final void Ku() {
        if (this.lCI > 0) {
            this.kxS.delete(0, this.lCI);
        }
        aUb();
        aUa();
    }

    public final void input(String str) {
        if (!TextUtils.isEmpty(str) && !this.oyn) {
            this.kxS.append(str);
            aUb();
            aUa();
        }
    }
}
