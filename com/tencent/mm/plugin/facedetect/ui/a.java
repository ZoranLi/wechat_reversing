package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.CountDownTimer;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;

public final class a {
    static c lyJ = new c();
    Button lyA = null;
    ImageView lyB = null;
    TextView lyC = null;
    TextView lyD = null;
    Button lyE = null;
    Button lyF = null;
    Animation lyG = null;
    public Animation lyH = null;
    WeakReference<FaceDetectPrepareUI> lyI = null;
    public RelativeLayout lyz = null;

    interface a {
    }

    public static class b {
        boolean lyN = false;
        public boolean lyO = true;
        boolean lyP = true;
        boolean lyQ = false;
        boolean lyR = false;
        boolean lyS = false;
        int lyT = 0;
        Bitmap lyU = null;
        public String lyV = null;
        String lyW = null;
        String lyX = null;
        String lyY = null;
        int lyZ = -1;
        a lza = null;
        OnClickListener lzb;
        OnClickListener lzc;
        OnClickListener lzd;

        public final String toString() {
            return "JumperConfig{isShowMainButton=" + this.lyN + ", isShowStatusWordingTv=" + this.lyO + ", isShowUploadStatusIv=" + this.lyP + ", isShowCancelBtn=" + this.lyQ + ", isShowSubButton=" + this.lyR + ", isShowOneByOne=" + this.lyS + ", oneByOneIndexStart=" + this.lyT + ", statusWording='" + this.lyV + '\'' + ", mainBtnText='" + this.lyW + '\'' + ", subBtnText='" + this.lyX + '\'' + ", cancelBtnText='" + this.lyY + '\'' + ", statusIvRes=" + this.lyZ + '}';
        }
    }

    public static class c extends CountDownTimer {
        WeakReference<TextView> lze = null;
        WeakReference<TextView> lzf = null;
        String lzg = null;
        int lzh = 0;
        int lzi = 0;

        public c() {
            super(Long.MAX_VALUE, 500);
        }

        public final void onTick(long j) {
            if (this.lze == null || this.lze.get() == null || this.lzf == null || this.lzf.get() == null) {
                w.w("MicroMsg.FaceDetectJumper", "hy: tv ref released");
                cancel();
            } else {
                TextView textView = (TextView) this.lzf.get();
                ((TextView) this.lze.get()).setText(this.lzg.substring(0, this.lzh));
                textView.setText(this.lzg.substring(this.lzh, this.lzh + (this.lzi % ((this.lzg.length() - this.lzh) + 1))));
            }
            this.lzi++;
        }

        public final void onFinish() {
        }
    }

    a(FaceDetectPrepareUI faceDetectPrepareUI) {
        this.lyI = new WeakReference(faceDetectPrepareUI);
    }

    public final void dismiss() {
        lyJ.cancel();
        if (this.lyz.getVisibility() == 0) {
            af.v(new Runnable(this) {
                final /* synthetic */ a lyK;

                {
                    this.lyK = r1;
                }

                public final void run() {
                    this.lyK.lyH.setAnimationListener(new AnimationListener(this) {
                        final /* synthetic */ AnonymousClass1 lyL;

                        {
                            this.lyL = r1;
                        }

                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            this.lyL.lyK.lyz.setVisibility(8);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    this.lyK.lyz.startAnimation(this.lyK.lyH);
                }
            });
        }
    }

    public final void r(Bitmap bitmap) {
        this.lyz.setBackgroundDrawable(new BitmapDrawable(bitmap));
    }

    public final void a(final b bVar) {
        if (lyJ != null) {
            lyJ.cancel();
        }
        if (bVar != null) {
            w.i("MicroMsg.FaceDetectJumper", "hy: request show conf: %s", new Object[]{bVar.toString()});
            if (bVar.lyQ) {
                this.lyE.setVisibility(0);
                this.lyE.setText(bVar.lyY);
                this.lyE.setOnClickListener(bVar.lzd);
            } else {
                this.lyE.setVisibility(4);
            }
            if (bVar.lyN) {
                this.lyA.setVisibility(0);
                this.lyA.setText(bVar.lyW);
                this.lyA.setOnClickListener(bVar.lzb);
            } else {
                this.lyA.setVisibility(4);
            }
            if (bVar.lyR) {
                this.lyF.setVisibility(0);
                this.lyF.setText(bVar.lyX);
                this.lyF.setOnClickListener(bVar.lzc);
            } else {
                this.lyF.setVisibility(4);
            }
            if (bVar.lyO) {
                this.lyC.setVisibility(0);
                if (bVar.lyS) {
                    this.lyD.setVisibility(0);
                    int i = bVar.lyT;
                    CharSequence charSequence = bVar.lyV;
                    if (bg.mA(charSequence) || i >= charSequence.length() || i < 0) {
                        w.e("MicroMsg.FaceDetectJumper", "hy: invalid showing one by one");
                        this.lyC.setText(charSequence);
                        this.lyD.setText("");
                    } else {
                        lyJ.cancel();
                        c cVar = lyJ;
                        WeakReference weakReference = new WeakReference(this.lyC);
                        WeakReference weakReference2 = new WeakReference(this.lyD);
                        cVar.lzg = charSequence;
                        cVar.lzh = i;
                        cVar.lze = weakReference;
                        cVar.lzf = weakReference2;
                        lyJ.start();
                    }
                } else {
                    this.lyD.setVisibility(4);
                    this.lyC.setText(bVar.lyV);
                }
            } else {
                this.lyC.setVisibility(4);
                this.lyD.setVisibility(4);
            }
            if (bVar.lyP) {
                this.lyB.setVisibility(0);
                this.lyB.setImageResource(bVar.lyZ);
            } else {
                this.lyB.setVisibility(4);
            }
            if (bVar.lyU != null) {
                this.lyz.setBackgroundDrawable(new BitmapDrawable(bVar.lyU));
            }
            if (this.lyz.getVisibility() != 0) {
                this.lyz.setVisibility(0);
                this.lyz.startAnimation(this.lyG);
                this.lyG.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ a lyK;

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        w.i("MicroMsg.FaceDetectJumper", "showJumperEnd: %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
            }
        }
    }

    public final boolean asn() {
        return this.lyz.getVisibility() != 8;
    }

    public static b mo(int i) {
        return a(i, null, null, null, null, null, null);
    }

    public static b a(int i, String str, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(i, str, str2, null, str3, onClickListener, onClickListener2);
    }

    public static b a(int i, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        boolean z = true;
        b bVar = new b();
        bVar.lyZ = i;
        bVar.lyV = str;
        bVar.lyN = str2 != null;
        bVar.lyW = str2;
        bVar.lyR = false;
        bVar.lyX = null;
        if (str4 == null) {
            z = false;
        }
        bVar.lyQ = z;
        bVar.lyY = str4;
        bVar.lzb = onClickListener;
        bVar.lzc = null;
        bVar.lzd = onClickListener2;
        return bVar;
    }

    public static b a(Context context, OnClickListener onClickListener) {
        b a = a(d.lst, context.getString(h.ltO), null, context.getString(h.dGs), null, onClickListener);
        a.lyS = true;
        a.lyT = context.getString(h.ltO).length() - 3;
        return a;
    }
}
