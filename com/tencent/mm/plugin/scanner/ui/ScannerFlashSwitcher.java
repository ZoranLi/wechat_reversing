package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.r;

public class ScannerFlashSwitcher extends LinearLayout {
    ImageView pcb;
    TextView pcc;
    boolean pcd = false;

    public ScannerFlashSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ScannerFlashSwitcher(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        r.eC(getContext()).inflate(R.i.cAd, this, true);
        this.pcb = (ImageView) findViewById(R.h.bQh);
        this.pcc = (TextView) findViewById(R.h.bQg);
        this.pcd = true;
    }

    public final void hide() {
        w.i("MicroMsg.ScannerFlashSwitcher", "hide");
        setEnabled(false);
        this.pcb.animate().alpha(0.0f).setDuration(500);
        this.pcc.animate().alpha(0.0f).setDuration(500).setListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ ScannerFlashSwitcher pce;

            {
                this.pce = r1;
            }

            public final void onAnimationEnd(Animator animator) {
                this.pce.setVisibility(8);
            }
        });
    }

    public final void aYT() {
        w.i("MicroMsg.ScannerFlashSwitcher", "closeFlashStatus");
        this.pcb.setImageResource(R.k.dzq);
    }
}
