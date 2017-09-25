package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.ref.WeakReference;

public abstract class d extends Fragment {
    protected static int mScreenHeight;
    protected static int mScreenWidth;
    protected static final int[] rlG = new int[]{-1, R.l.fct, R.l.fcD, R.l.fcC};
    protected String gLD;
    protected ae jiB;
    protected int mStatus = -1;
    protected boolean rhF;
    protected RelativeLayout rlH;
    protected ImageView rlI;
    protected int rlJ = Downloads.RECV_BUFFER_SIZE;
    protected c rlK;
    protected b rlL = new b();
    public a rlM;
    protected WeakReference<c> rlu;
    protected long rlw = -1;

    public class a implements Runnable {
        final /* synthetic */ d rlN;

        public a(d dVar) {
            this.rlN = dVar;
        }

        public final void run() {
            w.i("MicroMsg.VoipBaseFragment", "try load blur bitmap,timestamp: " + System.currentTimeMillis());
            Bitmap a = com.tencent.mm.x.b.a(this.rlN.gLD, false, -1);
            if (a != null && this.rlN.rlH != null) {
                int i = 0;
                while (true) {
                    if ((this.rlN.rlH.getHeight() == 0 || this.rlN.rlH.getWidth() == 0) && i < 10) {
                        try {
                            Thread.sleep(300);
                            i++;
                        } catch (InterruptedException e) {
                            w.e("MicroMsg.VoipBaseFragment", "wait voip initialize interrupted");
                            return;
                        }
                    }
                }
                if (a.getHeight() <= a.getWidth() && ((double) a.getWidth()) * 0.6d > 0.0d && ((double) a.getHeight()) * 0.6d > 0.0d) {
                    a = Bitmap.createBitmap(a, a.getWidth() / 5, a.getHeight() / 5, (int) (((double) a.getHeight()) * 0.6d), (int) (((double) a.getHeight()) * 0.6d), null, false);
                }
                a = com.tencent.mm.sdk.platformtools.d.a(a, a.getHeight(), (int) (((float) a.getHeight()) / ((1.0f * ((float) this.rlN.rlH.getHeight())) / ((float) this.rlN.rlH.getWidth()))), true, false);
                if (a == null) {
                    w.e("MicroMsg.VoipBaseFragment", "extract Thumb Nail for blur background failed");
                    return;
                }
                try {
                    a = com.tencent.mm.sdk.platformtools.d.c(a, 20);
                    w.i("MicroMsg.VoipBaseFragment", "blur ok, timestamp: " + System.currentTimeMillis());
                    this.rlN.jiB.post(new Runnable(this) {
                        final /* synthetic */ a rlO;

                        public final void run() {
                            if (this.rlO.rlN.rlI != null) {
                                this.rlO.rlN.rlI.setBackgroundDrawable(new BitmapDrawable(a));
                            }
                            this.rlO.rlN.rlM = null;
                        }
                    });
                } catch (Exception e2) {
                    w.e("MicroMsg.VoipBaseFragment", "fastblur failed: " + e2.getMessage());
                }
            }
        }
    }

    protected static class b {
        aj irQ = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ b rlS;

            {
                this.rlS = r1;
            }

            public final boolean oQ() {
                int i = this.rlS.rlP[this.rlS.rlR % this.rlS.rlP.length];
                if (this.rlS.kH != null) {
                    if (-1 == i) {
                        this.rlS.kH.setText(null);
                    } else {
                        this.rlS.kH.setText(i);
                    }
                }
                b bVar = this.rlS;
                bVar.rlR++;
                return true;
            }
        }, true);
        public TextView kH;
        public int[] rlP;
        private int rlQ;
        public int rlR;

        protected b() {
        }

        public final void a(TextView textView, int[] iArr) {
            if (iArr == null || textView == null) {
                w.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
                return;
            }
            bqW();
            this.rlR = 0;
            this.rlP = iArr;
            this.kH = textView;
            this.rlQ = 500;
            if (this.irQ != null) {
                long j = (long) this.rlQ;
                this.irQ.v(j, j);
            }
            w.h("MicroMsg.DynamicTextWrap", "start textview:" + textView, new Object[0]);
        }

        public final void bqW() {
            if (this.irQ != null) {
                this.irQ.KH();
            }
            w.h("MicroMsg.DynamicTextWrap", "stop textview: " + this.kH, new Object[0]);
            this.kH = null;
        }
    }

    public interface c {
        void w(boolean z, boolean z2);
    }

    protected abstract void HD(String str);

    public abstract void a(int i, int i2, int[] iArr);

    public abstract void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6);

    public abstract void b(CaptureView captureView);

    public abstract void bQ(boolean z);

    protected abstract void bU(String str, int i);

    public abstract void bpR();

    protected abstract void bqT();

    protected abstract void bqU();

    public abstract void vb(int i);

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundle2 = this.oW;
        this.gLD = bundle2.getString("key_username");
        this.rhF = bundle2.getBoolean("key_isoutcall");
        if (-1 == this.mStatus) {
            this.mStatus = bundle2.getInt("key_status");
        }
        this.jiB = new ae();
    }

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        if (mScreenWidth == 0) {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            mScreenWidth = defaultDisplay.getWidth();
            mScreenHeight = defaultDisplay.getHeight();
        }
    }

    public void dm(int i, int i2) {
        this.rlJ = i;
        this.mStatus = i2;
    }

    public final void dT(long j) {
        this.rlw = j;
    }

    public void uninit() {
        w.d("MicroMsg.VoipBaseFragment", "uninit");
        this.rlL.bqW();
        b bVar = this.rlL;
        w.d("MicroMsg.DynamicTextWrap", "uninit");
        bVar.bqW();
        bVar.irQ = null;
        if (this.rlM != null) {
            e.remove(this.rlM);
            this.rlM = null;
        }
    }

    public void onDetach() {
        if (this.jiB != null) {
            this.jiB.removeCallbacksAndMessages(null);
        }
        this.rlK = null;
        super.onDetach();
    }

    public final void a(c cVar) {
        this.rlu = new WeakReference(cVar);
    }

    public final void a(c cVar) {
        this.rlK = cVar;
    }

    protected final void b(TextView textView, String str) {
        if (textView == null || bg.mA(str)) {
            w.e("MicroMsg.VoipBaseFragment", "TextView is null or text is null");
            return;
        }
        textView.setText(str);
        textView.measure(MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
        textView.setWidth(textView.getMeasuredWidth());
    }

    public void onStop() {
        super.onStop();
    }

    protected final void bqV() {
        if (this.gLD != null && this.rlI.getVisibility() != 0) {
            this.rlI.setVisibility(0);
            this.rlM = new a(this);
            e.post(this.rlM, "VoipBaseFragment_blurbitmap");
        }
    }

    protected static String aq(long j) {
        return String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
    }

    protected static void E(View view, int i) {
        if (view != null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.topMargin += i;
            view.setLayoutParams(layoutParams);
        }
    }
}
