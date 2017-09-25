package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.n;

public class OfflineAlertView extends LinearLayout {
    private View ipu = null;
    public int odt = 0;
    RelativeLayout odu = null;
    boolean odv = true;
    a odw = null;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int izu = 2;
        final /* synthetic */ OfflineAlertView odA;
        final /* synthetic */ View odx;
        final /* synthetic */ Runnable ody;
        final /* synthetic */ Runnable odz;

        AnonymousClass1(OfflineAlertView offlineAlertView, View view, Runnable runnable, Runnable runnable2, int i) {
            this.odA = offlineAlertView;
            this.odx = view;
            this.ody = runnable;
            this.odz = runnable2;
        }

        public final void run() {
            OfflineAlertView.a(this.odA, this.odx, this.ody, this.odz, this.izu);
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int izu = 4;
        final /* synthetic */ OfflineAlertView odA;
        final /* synthetic */ View odx;

        AnonymousClass2(OfflineAlertView offlineAlertView, View view, int i) {
            this.odA = offlineAlertView;
            this.odx = view;
        }

        public final void run() {
            OfflineAlertView.a(this.odA, this.odx, this.izu);
        }
    }

    class AnonymousClass8 implements Runnable {
        final /* synthetic */ OfflineAlertView odA;
        final /* synthetic */ View odx;

        AnonymousClass8(OfflineAlertView offlineAlertView, View view) {
            this.odA = offlineAlertView;
            this.odx = view;
        }

        public final void run() {
            w.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[]{Integer.valueOf(this.odx.getHeight()), Integer.valueOf(this.odx.getMeasuredHeight())});
            LayoutParams layoutParams = (LayoutParams) this.odA.ipu.getLayoutParams();
            if (this.odx.getHeight() > 0) {
                layoutParams.height = this.odx.getHeight();
                this.odA.ipu.setLayoutParams(layoutParams);
                this.odA.ipu.invalidate();
            }
            if (this.odA.odw != null) {
                this.odA.odw.azn();
            }
        }
    }

    public interface a {
        void azn();

        void onClose();
    }

    static /* synthetic */ void a(OfflineAlertView offlineAlertView, View view, int i) {
        offlineAlertView.odt = i;
        offlineAlertView.setVisibility(0);
        k.aQd();
        bg.PY(k.qL(196645));
        TextView textView = (TextView) offlineAlertView.ipu.findViewById(R.h.bWu);
        if (textView != null) {
            textView.setOnClickListener(new n(offlineAlertView) {
                final /* synthetic */ OfflineAlertView odA;

                {
                    this.odA = r1;
                }

                public final void aII() {
                    this.odA.dismiss();
                }
            });
            textView.setText(R.l.fgM);
        } else {
            w.e("MicroMsg.OfflineAlertView", "iKnowBtn is null!");
        }
        textView = (TextView) offlineAlertView.ipu.findViewById(R.h.cHj);
        if (textView != null) {
            textView.setText(R.l.fgN);
            textView.setOnClickListener(new OnClickListener(offlineAlertView) {
                final /* synthetic */ OfflineAlertView odA;

                {
                    this.odA = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.plugin.offline.c.a.cH(this.odA.getContext());
                }
            });
        } else {
            w.e("MicroMsg.OfflineAlertView", "moreTV is null!");
        }
        w.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[]{Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight())});
        LayoutParams layoutParams = (LayoutParams) offlineAlertView.ipu.getLayoutParams();
        if (view.getHeight() > 0) {
            layoutParams.height = view.getHeight();
            offlineAlertView.ipu.setLayoutParams(layoutParams);
            offlineAlertView.ipu.invalidate();
        }
        if (offlineAlertView.odw != null) {
            offlineAlertView.odw.azn();
        }
    }

    static /* synthetic */ void a(OfflineAlertView offlineAlertView, View view, final Runnable runnable, final Runnable runnable2, int i) {
        offlineAlertView.odt = i;
        offlineAlertView.setVisibility(0);
        ((TextView) offlineAlertView.ipu.findViewById(R.h.bWu)).setOnClickListener(new n(offlineAlertView) {
            final /* synthetic */ OfflineAlertView odA;

            public final void aII() {
                runnable.run();
            }
        });
        offlineAlertView.ipu.findViewById(R.h.cHj).setOnClickListener(new n(offlineAlertView) {
            final /* synthetic */ OfflineAlertView odA;

            public final void aII() {
                runnable2.run();
            }
        });
        w.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[]{Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight())});
        LayoutParams layoutParams = (LayoutParams) offlineAlertView.ipu.getLayoutParams();
        if (view.getHeight() > 0) {
            layoutParams.height = view.getHeight();
            offlineAlertView.ipu.setLayoutParams(layoutParams);
            offlineAlertView.ipu.invalidate();
        }
        offlineAlertView.odv = false;
        if (offlineAlertView.odw != null) {
            offlineAlertView.odw.azn();
        }
    }

    public OfflineAlertView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public OfflineAlertView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.ipu = LayoutInflater.from(getContext()).inflate(R.i.dqO, this);
        this.odu = (RelativeLayout) this.ipu.findViewById(R.h.cpe);
    }

    final void a(final View view, OnClickListener onClickListener, int i) {
        this.odt = i;
        setVisibility(0);
        this.odu.removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate(R.i.dqX, null);
        if (i == 6) {
            ((TextView) inflate.findViewById(R.h.bor)).setText(R.l.eFk);
        }
        this.odu.addView(inflate);
        ((Button) this.ipu.findViewById(R.h.bWu)).setOnClickListener(onClickListener);
        this.odv = false;
        view.post(new Runnable(this) {
            final /* synthetic */ OfflineAlertView odA;

            public final void run() {
                w.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[]{Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight())});
                LayoutParams layoutParams = (LayoutParams) this.odA.ipu.getLayoutParams();
                if (view.getHeight() > 0) {
                    layoutParams.height = view.getHeight();
                    this.odA.ipu.setLayoutParams(layoutParams);
                    this.odA.ipu.invalidate();
                }
                if (this.odA.odw != null) {
                    this.odA.odw.azn();
                }
            }
        });
    }

    public final boolean isShowing() {
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final boolean qM(int i) {
        if (!isShowing() || i == this.odt) {
            return true;
        }
        if (i == 2 && (this.odt == 3 || this.odt == 4 || this.odt == 2 || this.odt == 5)) {
            return true;
        }
        if ((i == 5 && this.odt == 4) || i == 6) {
            return true;
        }
        return false;
    }

    public final void dismiss() {
        if (this.odu != null) {
            this.odu.removeAllViews();
        }
        setVisibility(8);
        if (this.odw != null) {
            this.odw.onClose();
        }
        this.odv = true;
    }
}
