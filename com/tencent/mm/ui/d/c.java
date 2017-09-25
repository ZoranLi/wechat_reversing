package com.tencent.mm.ui.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.l.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.x;

public final class c implements h {
    private Bitmap bitmap = null;
    private Context context;
    private ImageView fMY = null;
    private ProgressBar fNa = null;
    private View ipu = null;
    private View nfI;
    private TextView qFC = null;
    private TextView qFD = null;
    private View qlS;
    public o sQq;
    public boolean sQr = true;
    private long veT = 0;
    private ImageView veU = null;
    private String veV = null;
    private boolean veW = false;
    private boolean veX = false;
    public a veY;
    public ae veZ = null;

    public interface a {
        void bRy();
    }

    public final void Ba() {
        w.d("MicroMsg.AppBrandServiceImageBubble", "beforeLoadBitmap");
        this.fNa.setVisibility(0);
        this.fMY.setVisibility(8);
        this.veU.setVisibility(8);
    }

    public final void h(Bitmap bitmap) {
        w.d("MicroMsg.AppBrandServiceImageBubble", "onBitmapLoaded");
        if (bitmap == null) {
            w.w("MicroMsg.AppBrandServiceImageBubble", "bitmap is null");
            return;
        }
        this.bitmap = bitmap;
        this.fNa.setVisibility(8);
        if (bitmap == null || bitmap.isRecycled()) {
            this.veU.setVisibility(0);
            this.fMY.setVisibility(8);
            return;
        }
        this.fMY.setVisibility(0);
        this.fMY.setImageBitmap(bitmap);
        this.veU.setVisibility(8);
    }

    public final void Bb() {
        w.i("MicroMsg.AppBrandServiceImageBubble", "onLoadFailed");
        this.veU.setVisibility(0);
        this.fNa.setVisibility(8);
        this.fMY.setVisibility(8);
    }

    public final String Bc() {
        return b.aM(this);
    }

    public c(Context context, View view, View view2, boolean z) {
        this.context = context;
        this.qlS = view;
        this.nfI = view2;
        this.veX = z;
        this.ipu = View.inflate(this.context, R.i.cXu, null);
        this.qFC = (TextView) this.ipu.findViewById(R.h.bXi);
        this.qFD = (TextView) this.ipu.findViewById(R.h.bXj);
        this.fMY = (ImageView) this.ipu.findViewById(R.h.bWV);
        this.veU = (ImageView) this.ipu.findViewById(R.h.bMu);
        this.fNa = (ProgressBar) this.ipu.findViewById(R.h.bXe);
        this.sQq = new o(this.ipu, -2, -2, true);
        this.sQq.setBackgroundDrawable(new ColorDrawable(0));
        this.sQq.setOutsideTouchable(true);
        this.sQq.setFocusable(false);
        this.ipu.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c vfa;

            {
                this.vfa = r1;
            }

            public final void onClick(View view) {
                if (this.vfa.veY != null) {
                    this.vfa.veY.bRy();
                }
                this.vfa.sQq.dismiss();
            }
        });
        this.veZ = new ae(this, this.context.getMainLooper()) {
            final /* synthetic */ c vfa;

            public final void handleMessage(Message message) {
                this.vfa.bRx();
            }
        };
    }

    public final void bRx() {
        if (this.fMY == null || this.sQq == null || this.qlS == null || this.nfI == null) {
            w.e("MicroMsg.AppBrandServiceImageBubble", "these references include null reference");
            return;
        }
        int i;
        if (this.bitmap != null) {
            w.d("MicroMsg.AppBrandServiceImageBubble", "bitmap is null,return");
            i = 1;
        } else {
            boolean z = false;
        }
        if (i == 0) {
            Ba();
        } else {
            h(this.bitmap);
        }
        i = this.sQr ? 83 : 85;
        int i2 = this.sQr ? 0 : 10;
        int aD = j.aD(this.context);
        int height = this.nfI.getHeight();
        if (this.veX && height < aD) {
            height += aD;
        }
        if (VERSION.SDK_INT >= 21) {
            Rect bQF = x.bQF();
            i2 = this.sQr ? 0 : i2 + bQF.right;
            height += bQF.bottom;
            w.i("MicroMsg.AppBrandServiceImageBubble", "bubble navbar height %s %s", Integer.valueOf(bQF.right), Integer.valueOf(bQF.bottom));
        }
        this.sQq.showAtLocation(this.qlS, i, i2, height);
        if (this.veT > 0) {
            aj ajVar = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
                final /* synthetic */ c vfa;

                {
                    this.vfa = r1;
                }

                public final boolean oQ() {
                    c cVar = this.vfa;
                    w.d("MicroMsg.AppBrandServiceImageBubble", "hide");
                    if (cVar.sQq != null) {
                        cVar.sQq.dismiss();
                    }
                    return false;
                }
            }, false);
            long j = this.veT;
            ajVar.v(j, j);
        }
    }
}
