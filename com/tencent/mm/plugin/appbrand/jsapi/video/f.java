package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;

public final class f {
    float iPO = 0.0f;
    public View iXq;
    public int iXr = a.iXA;
    GestureDetector iXs;
    public b iXt;
    int iXu = 0;
    float iXv = 0.0f;
    int iXw = -1;
    int iXx = 0;
    public Runnable iXy = new Runnable(this) {
        final /* synthetic */ f iXz;

        {
            this.iXz = r1;
        }

        public final void run() {
            this.iXz.iXt.TX();
        }
    };
    Context mContext;

    private enum a {
        ;

        static {
            iXA = 1;
            iXB = 2;
            iXC = 3;
            iXD = 4;
            iXE = new int[]{iXA, iXB, iXC, iXD};
        }
    }

    public interface b {
        void L(float f);

        void M(float f);

        void TX();

        void TY();

        void TZ();

        void Ua();

        void Ub();

        int d(int i, float f);

        void e(int i, float f);

        int getCurrentPosition();
    }

    public f(Context context, View view, b bVar) {
        this.mContext = context;
        this.iXt = bVar;
        this.iXq = view;
        this.iXs = new GestureDetector(this.mContext, new SimpleOnGestureListener(this) {
            final /* synthetic */ f iXz;

            {
                this.iXz = r1;
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                this.iXz.iXq.postDelayed(this.iXz.iXy, 200);
                return true;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                this.iXz.iXq.removeCallbacks(this.iXz.iXy);
                this.iXz.iXt.TY();
                return true;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                float f3 = 1.0f;
                float f4 = 0.0f;
                if (!(motionEvent == null || motionEvent2 == null)) {
                    if (this.iXz.iXr == a.iXA) {
                        if (Math.abs(f) > Math.abs(f2)) {
                            this.iXz.iXr = a.iXD;
                        } else if (motionEvent.getX() < ((float) (this.iXz.iXq.getMeasuredWidth() / 2))) {
                            this.iXz.iXr = a.iXC;
                        } else {
                            this.iXz.iXr = a.iXB;
                        }
                    }
                    float x = motionEvent2.getX() - motionEvent.getX();
                    float y = motionEvent2.getY() - motionEvent.getY();
                    f fVar = this.iXz;
                    if (fVar.iXr == a.iXD) {
                        if (fVar.iXw == -1) {
                            fVar.iXt.TZ();
                            fVar.iXw = fVar.iXt.getCurrentPosition();
                        }
                        fVar.iXx = fVar.iXt.d(fVar.iXw, x);
                    } else if (fVar.iXr == a.iXC) {
                        x = (((y * -1.0f) / ((float) fVar.iXq.getMeasuredHeight())) * 1.2f) + fVar.iPO;
                        if (x >= 0.0f) {
                            f4 = x > 1.0f ? 1.0f : x;
                        }
                        Context context = fVar.mContext;
                        if (context instanceof Activity) {
                            if (f4 < 0.01f) {
                                f3 = 0.01f;
                            } else if (f4 <= 1.0f) {
                                f3 = f4;
                            }
                            Activity activity = (Activity) context;
                            LayoutParams attributes = activity.getWindow().getAttributes();
                            attributes.screenBrightness = f3;
                            activity.getWindow().setAttributes(attributes);
                        }
                        fVar.iXt.M(f4);
                    } else if (fVar.iXr == a.iXB) {
                        int i;
                        y *= -1.0f;
                        f3 = y / ((float) fVar.iXq.getMeasuredHeight());
                        AudioManager audioManager = (AudioManager) fVar.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                        float f5 = 1.2f * (f3 * ((float) streamMaxVolume));
                        int i2 = (int) f5;
                        if (i2 == 0 && Math.abs(f5) > 0.2f) {
                            if (y > 0.0f) {
                                i = 1;
                            } else if (y < 0.0f) {
                                i = -1;
                            }
                            i += fVar.iXu;
                            if (i < 0) {
                                i = 0;
                            } else if (i >= streamMaxVolume) {
                                i = streamMaxVolume;
                            }
                            audioManager.setStreamVolume(3, i, 0);
                            fVar.iXt.L(((float) i) / ((float) streamMaxVolume));
                        }
                        i = i2;
                        i += fVar.iXu;
                        if (i < 0) {
                            i = 0;
                        } else if (i >= streamMaxVolume) {
                            i = streamMaxVolume;
                        }
                        audioManager.setStreamVolume(3, i, 0);
                        fVar.iXt.L(((float) i) / ((float) streamMaxVolume));
                    }
                }
                return true;
            }
        });
        this.iPO = g.bw(context);
    }
}
