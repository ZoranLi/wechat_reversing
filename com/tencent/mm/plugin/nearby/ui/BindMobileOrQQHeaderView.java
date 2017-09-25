package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.u.a.f;
import com.tencent.mm.u.a.g;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class BindMobileOrQQHeaderView extends LinearLayout {
    private ImageView jla;
    private TextView nVM;
    private int nVN;
    private OnClickListener nVO;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] nVQ = new int[a.aOH().length];

        static {
            try {
                nVQ[a.nVR - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                nVQ[a.nVS - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum a {
        ;

        public static int[] aOH() {
            return (int[]) nVT.clone();
        }

        static {
            nVR = 1;
            nVS = 2;
            nVT = new int[]{nVR, nVS};
        }
    }

    public BindMobileOrQQHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nVO = new OnClickListener(this) {
            final /* synthetic */ BindMobileOrQQHeaderView nVP;

            {
                this.nVP = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(this.nVP.getContext(), BindMContactIntroUI.class);
                intent.putExtra("key_upload_scene", 7);
                MMWizardActivity.z(this.nVP.getContext(), intent);
                if (g.Ae().gu(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) != null) {
                    g.Ae().gu(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL).result = "1";
                    f.gz(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                }
            }
        };
        bV(context);
    }

    public BindMobileOrQQHeaderView(Context context) {
        super(context);
        this.nVO = /* anonymous class already generated */;
        this.nVN = a.nVR;
        bV(context);
    }

    private void bV(Context context) {
        View inflate = View.inflate(context, R.i.djU, this);
        this.nVM = (TextView) inflate.findViewById(R.h.cmR);
        this.jla = (ImageView) inflate.findViewById(R.h.cmz);
        switch (AnonymousClass2.nVQ[this.nVN - 1]) {
            case 1:
                setOnClickListener(this.nVO);
                this.jla.setImageResource(R.k.dAk);
                return;
            case 2:
                setOnClickListener(this.nVO);
                this.jla.setImageResource(R.k.dAl);
                return;
            default:
                return;
        }
    }
}
