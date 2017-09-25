package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.hz;
import com.tencent.mm.e.a.qt;
import com.tencent.mm.modelmulti.m;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;

public final class n extends b {
    private TextView ipw;
    private View jIM = null;
    private ImageView jbU;
    private boolean wfH = false;
    boolean wfL = false;
    private c wfM;

    public n(Context context) {
        super(context);
        if (!this.wfH && this.view != null) {
            this.jIM = this.view.findViewById(R.h.cJl);
            this.ipw = (TextView) this.view.findViewById(R.h.cJj);
            this.jbU = (ImageView) this.view.findViewById(R.h.cJk);
            this.wfH = true;
            this.wfM = new c<hz>(this) {
                final /* synthetic */ n wfN;

                {
                    this.wfN = r2;
                    this.usg = hz.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    if (((hz) bVar).fND.fMu) {
                        this.wfN.wfL = false;
                        this.wfN.Xj();
                    } else {
                        w.i("MicroMsg.TryNewInitBanner", "summerinit onSceneEnd -1 show tryNewInitBanner[%s]", this.wfN);
                        this.wfN.wfL = true;
                        this.wfN.Xj();
                    }
                    return false;
                }
            };
            a.urY.b(this.wfM);
        }
    }

    public final int getLayoutId() {
        return R.i.dpk;
    }

    public final boolean Xj() {
        if (!this.wfL) {
            w.i("MicroMsg.TryNewInitBanner", "summerinit update but initFailed[%b] just ret update false", Boolean.valueOf(this.wfL));
            this.jIM.setVisibility(8);
            return false;
        } else if (m.Hv()) {
            boolean z;
            this.ipw.setText(R.l.dMX);
            this.jbU.setVisibility(0);
            this.jIM.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ n wfN;

                {
                    this.wfN = r1;
                }

                public final void onClick(View view) {
                    w.i("MicroMsg.TryNewInitBanner", "summerinit onClick trynewinit layout start try");
                    this.wfN.setVisibility(8);
                    a.urY.m(new qt());
                    w.i("MicroMsg.TryNewInitBanner", "summerinit onClick tryNeeInitAgain done callBack (now by event to notice initbanner)");
                }
            });
            this.jIM.setVisibility(0);
            String str = "MicroMsg.TryNewInitBanner";
            String str2 = "summerinit update set visible [%b]";
            Object[] objArr = new Object[1];
            if (this.jIM.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            w.i(str, str2, objArr);
            return true;
        } else {
            w.i("MicroMsg.TryNewInitBanner", "summerinit update but not need init just update false");
            this.wfL = false;
            this.jIM.setVisibility(8);
            return false;
        }
    }

    public final void setVisibility(int i) {
        if (this.jIM != null) {
            this.jIM.setVisibility(i);
        }
    }

    public final void destroy() {
        a.urY.c(this.wfM);
    }
}
