package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.d.b.b;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Timer;
import java.util.TimerTask;

public final class c implements b {
    public static String TAG = "MicroMsg.NormalFaceMotion";
    private static long lxj = 500;
    private boolean lxk = false;
    public boolean lxl = false;
    private View lxm = null;
    private View lxn = null;
    private String lxo;
    private long lxp;
    public final Object lxq = new Object();
    private Timer lxr = null;
    public volatile boolean lxs = false;
    public Animation lxt;
    private volatile boolean lxu = false;
    private volatile boolean lxv = false;

    public c(String str, long j) {
        this.lxo = str;
        this.lxp = j;
        this.lxt = AnimationUtils.loadAnimation(ab.getContext(), a.aRN);
    }

    public final boolean arX() {
        return this.lxk && this.lxl;
    }

    public final TextView asc() {
        if (!this.lxk && this.lxm != null) {
            return (TextView) this.lxm.findViewById(e.ltk);
        }
        if (!this.lxk || this.lxn == null) {
            return null;
        }
        return (TextView) this.lxn.findViewById(e.ltk);
    }

    public final void a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.lxm = LayoutInflater.from(context).inflate(g.ltt, viewGroup);
        this.lxn = LayoutInflater.from(context).inflate(g.ltu, viewGroup2);
        this.lxn.setVisibility(4);
        if (asc() != null) {
            asc().setText(this.lxo);
        }
        w.i(TAG, "hy: starting tween timer: tween: %d", new Object[]{Long.valueOf(this.lxp)});
        if (this.lxr != null) {
            this.lxr.cancel();
        }
        this.lxr = new Timer("FaceDetect_hint", true);
        this.lxs = true;
        this.lxr.scheduleAtFixedRate(new TimerTask(this) {
            final /* synthetic */ c lxw;

            {
                this.lxw = r1;
            }

            public final void run() {
                synchronized (this.lxw.lxq) {
                    if (!this.lxw.lxs) {
                        w.w(c.TAG, "hy: already stopped");
                        cancel();
                    }
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 lxx;

                        {
                            this.lxx = r1;
                        }

                        public final void run() {
                            if (this.lxx.lxw.asc() != null) {
                                this.lxx.lxw.asc().startAnimation(this.lxx.lxw.lxt);
                            }
                        }
                    });
                }
            }
        }, 0, r4);
    }

    public final boolean arY() {
        return false;
    }

    public final boolean a(FaceCharacteristicsResult faceCharacteristicsResult) {
        if (!this.lxk || faceCharacteristicsResult == null || faceCharacteristicsResult.errCode != 18) {
            return false;
        }
        w.d(TAG, "hy: ignore too active");
        return true;
    }

    public final boolean b(FaceCharacteristicsResult faceCharacteristicsResult) {
        if (faceCharacteristicsResult.errCode == -1) {
            this.lxk = true;
            if (!this.lxu) {
                aq.B(ab.getContext(), h.eHm);
                TextView textView = (TextView) this.lxm.findViewById(e.ltk);
                Animation loadAnimation = AnimationUtils.loadAnimation(ab.getContext(), a.aQW);
                Animation loadAnimation2 = AnimationUtils.loadAnimation(ab.getContext(), a.aQX);
                loadAnimation.setDuration(lxj);
                loadAnimation2.setDuration(lxj);
                textView.startAnimation(loadAnimation);
                textView.setVisibility(4);
                this.lxn.setVisibility(0);
                this.lxn.startAnimation(loadAnimation2);
                this.lxn.findViewById(e.lsR).setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ c lxw;

                    {
                        this.lxw = r1;
                    }

                    public final void onClick(View view) {
                        this.lxw.lxl = true;
                    }
                });
                this.lxu = true;
                return true;
            }
        }
        return false;
    }

    public final void arZ() {
        this.lxs = false;
        if (this.lxr != null) {
            this.lxr.cancel();
        }
        this.lxk = false;
        this.lxu = false;
        this.lxv = false;
        this.lxl = false;
    }

    public final b asa() {
        if (this.lxk) {
            return new b(90025, "user cancelled in intermediate page");
        }
        return new b(90004, "user cancelled in processing");
    }

    public final b.a asb() {
        if (!this.lxk || this.lxv) {
            return null;
        }
        this.lxv = true;
        return new b.a();
    }
}
