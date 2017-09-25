package com.tencent.mm.plugin.favorite.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.c;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    public Button kzq;
    public TextView kzw;
    public boolean lJB = false;
    public View lJC;
    public a lJD;
    public long lJy = x.atE();

    public interface a {
        void aud();
    }

    public final void show() {
        if (!this.lJB) {
            if (this.lJC != null) {
                if (this.lJC instanceof ViewStub) {
                    this.lJC = ((ViewStub) this.lJC).inflate();
                }
                this.kzw = (TextView) this.lJC.findViewById(R.h.bOf);
                if (!v.bIJ()) {
                    this.kzw.setTextSize(1, 14.0f);
                }
                this.kzq = (Button) this.lJC.findViewById(R.h.bOe);
                auv();
                this.kzq.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a lJE;

                    {
                        this.lJE = r1;
                    }

                    public final void onClick(View view) {
                        if (this.lJE.lJD != null) {
                            this.lJE.lJD.aud();
                        }
                    }
                });
                this.lJB = true;
            } else {
                return;
            }
        }
        if (this.lJC.getVisibility() != 0) {
            this.lJC.setVisibility(0);
            this.lJC.startAnimation(AnimationUtils.loadAnimation(this.lJC.getContext(), R.a.aQX));
        }
    }

    public final void hide() {
        if (this.lJB && this.lJC.getVisibility() != 8) {
            this.lJC.setVisibility(8);
            this.lJC.startAnimation(AnimationUtils.loadAnimation(this.lJC.getContext(), R.a.aQY));
        }
    }

    public final void auv() {
        this.kzw.setText(this.kzw.getContext().getString(R.l.ehs, new Object[]{c.bP(this.lJy)}));
        this.kzq.setEnabled(false);
    }
}
