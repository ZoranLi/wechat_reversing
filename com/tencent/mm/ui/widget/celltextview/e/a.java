package com.tencent.mm.ui.widget.celltextview.e;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.celltextview.CellTextView;
import com.tencent.mm.ui.widget.celltextview.c.b;
import java.util.List;

public class a implements OnTouchListener {
    private static int sTP = ViewConfiguration.getLongPressTimeout();
    private static Handler wza = new Handler(Looper.getMainLooper());
    public boolean sTO = false;
    private b wyW;
    public CellTextView wzb;
    private a wzc = new a(this);

    class a implements Runnable {
        final /* synthetic */ a wzd;

        a(a aVar) {
            this.wzd = aVar;
        }

        public final void run() {
            if (this.wzd.wzb != null && this.wzd.wzb.isPressed()) {
                w.d("MicroMsg.CellTouchListener", "long pressed timeout");
                this.wzd.sTO = true;
                this.wzd.wzb.caR().a(null);
                this.wzd.wzb.invalidate();
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view instanceof CellTextView) {
            this.wzb = (CellTextView) view;
            List<b> caV = this.wzb.caR().caV();
            if (caV != null && caV.size() > 0) {
                int x = ((int) motionEvent.getX()) - this.wzb.getPaddingRight();
                int y = ((int) motionEvent.getY()) - this.wzb.getPaddingTop();
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        this.wyW = null;
                        for (b bVar : caV) {
                            if (bVar.es(x, y)) {
                                this.wyW = bVar;
                                this.wzb.caR().a(bVar);
                                this.wzb.invalidate();
                            }
                        }
                        if (this.wzb != null) {
                            wza.postDelayed(this.wzc, (long) sTP);
                            break;
                        }
                        break;
                    case 1:
                        if (!(this.sTO || this.wyW == null || !this.wyW.es(x, y))) {
                            this.wyW.wyq.onClick(this.wzb.getView());
                        }
                        cbe();
                        if (this.wyW != null) {
                            this.wzb.caR().a(null);
                            this.wzb.invalidate();
                        }
                        this.wyW = null;
                        break;
                    case 2:
                        if (!(this.wyW == null || this.wyW.es(x, y))) {
                            this.wyW = null;
                            this.wzb.caR().a(null);
                            this.wzb.invalidate();
                            break;
                        }
                    case 3:
                        cbe();
                        if (this.wyW != null) {
                            this.wzb.caR().a(null);
                            this.wzb.invalidate();
                        }
                        this.wyW = null;
                        break;
                    default:
                        break;
                }
            }
        }
        return false;
    }

    private void cbe() {
        this.sTO = false;
        wza.removeCallbacks(this.wzc);
    }
}
