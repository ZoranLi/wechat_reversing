package com.tencent.mm.ui.applet;

import android.content.Context;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bl.d.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;

public final class d {
    public static int vfv = 0;

    public static final class a {
        public Context context;
        ImageView fMY;
        public ProgressBar fNa;
        public FrameLayout fwi;
        public WindowManager fwj;
        public LayoutParams fwk;
        private ViewGroup.LayoutParams fwl;
        View mView;
        public TextView mzk;
        ae vfA = new ae(this) {
            final /* synthetic */ a vfB;

            {
                this.vfB = r1;
            }

            public final void handleMessage(Message message) {
                if (this.vfB.mzk.getVisibility() != 0) {
                    this.vfB.vfz = 0;
                    return;
                }
                a aVar = this.vfB;
                aVar.vfz++;
                this.vfB.bRA();
                super.handleMessage(message);
            }
        };
        public boolean vfw = false;
        b vfx = new b(this) {
            final /* synthetic */ a vfB;

            {
                this.vfB = r1;
            }

            public final void bOk() {
                this.vfB.eK(this.vfB.context);
                Toast.makeText(this.vfB.context, "trace file has saved ", 0).show();
            }
        };
        com.tencent.mm.bl.d.a vfy;
        public int vfz = 0;

        public a(Context context, View view) {
            if (this.fwi == null || this.fwj == null) {
                com.tencent.mm.bl.d.bOi().uNN = new WeakReference(this.vfx);
                this.mzk = (TextView) view.findViewById(R.h.cIm);
                this.fMY = (ImageView) view.findViewById(R.h.button);
                ((ImageView) view.findViewById(R.h.bHY)).setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a vfB;

                    {
                        this.vfB = r1;
                    }

                    public final void onClick(View view) {
                        if (this.vfB.vfw && this.vfB.fNa.getVisibility() != 0) {
                            com.tencent.mm.bl.d.bOi().b(this.vfB.vfy);
                        }
                        a aVar = this.vfB;
                        try {
                            if (aVar.fwj != null) {
                                if (aVar.fwi != null) {
                                    aVar.fwj.removeView(aVar.fwi);
                                }
                                aVar.fwj = null;
                            }
                            if (aVar.fwi != null) {
                                aVar.fwi.removeAllViews();
                                aVar.fwi = null;
                            }
                            aVar.mView = null;
                        } catch (Exception e) {
                        }
                        d.vfv--;
                    }
                });
                this.fNa = (ProgressBar) view.findViewById(R.h.cmf);
                this.fNa.setVisibility(8);
                this.context = context;
                this.fwk = new LayoutParams();
                this.fwk.height = -2;
                this.fwk.width = -2;
                this.fwj = (WindowManager) context.getSystemService("window");
                this.fwk.x = 0;
                this.fwk.y = 0;
                this.fwk.flags = 40;
                this.fwk.type = MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK;
                this.mView = view;
                this.mzk.setVisibility(8);
                this.fwk.gravity = 51;
                this.fwk.format = 1;
                this.fwi = new FrameLayout(context);
                this.fwi.setPadding(4, 4, 4, 4);
                this.fwl = new ViewGroup.LayoutParams(-2, -2);
                this.fwi.addView(this.mView, this.fwl);
                final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                this.fwi.setOnTouchListener(new OnTouchListener(this) {
                    final /* synthetic */ a vfB;
                    int vfh;
                    int vfi;
                    int vfj = ((displayMetrics.widthPixels - this.vfB.fwk.width) - 1);
                    int vfk = ((displayMetrics.heightPixels - this.vfB.fwk.height) - 1);
                    long vfl;

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        switch (motionEvent.getAction()) {
                            case 0:
                                this.vfh = ((int) motionEvent.getRawX()) - this.vfB.fwk.x;
                                this.vfi = ((int) motionEvent.getRawY()) - this.vfB.fwk.y;
                                this.vfl = System.currentTimeMillis();
                                break;
                            case 1:
                                if (System.currentTimeMillis() - this.vfl < 300) {
                                    a aVar = this.vfB;
                                    aVar.vfA.removeMessages(0);
                                    aVar.vfz = 0;
                                    if (!aVar.vfw) {
                                        aVar.fMY.setVisibility(0);
                                        aVar.fMY.setBackgroundDrawable(aVar.context.getResources().getDrawable(R.g.bkP));
                                        aVar.vfw = !aVar.vfw;
                                        aVar.vfy = new com.tencent.mm.bl.d.a(null, 6, 8, 0);
                                        com.tencent.mm.bl.d.bOi().c(aVar.vfy);
                                        aVar.bRA();
                                        break;
                                    }
                                    aVar.fNa.setVisibility(0);
                                    aVar.fMY.setVisibility(4);
                                    if (!com.tencent.mm.bl.d.bOi().b(aVar.vfy)) {
                                        aVar.eK(aVar.context);
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                this.vfj = (displayMetrics.widthPixels - this.vfB.fwk.width) - 1;
                                this.vfk = (displayMetrics.heightPixels - this.vfB.fwk.height) - 1;
                                this.vfB.fwk.x = ((int) motionEvent.getRawX()) - this.vfh;
                                this.vfB.fwk.y = ((int) motionEvent.getRawY()) - this.vfi;
                                this.vfB.fwk.x = this.vfB.fwk.x < 0 ? 0 : this.vfB.fwk.x;
                                this.vfB.fwk.x = this.vfB.fwk.x > this.vfj ? this.vfj : this.vfB.fwk.x;
                                this.vfB.fwk.y = this.vfB.fwk.y < 0 ? 0 : this.vfB.fwk.y;
                                this.vfB.fwk.y = this.vfB.fwk.y > this.vfk ? this.vfk : this.vfB.fwk.y;
                                this.vfB.fwj.updateViewLayout(this.vfB.fwi, this.vfB.fwk);
                                break;
                        }
                        return false;
                    }
                });
            }
        }

        public final void eK(Context context) {
            boolean z = false;
            this.fMY.setVisibility(0);
            this.fNa.setVisibility(4);
            if (!this.vfw) {
                z = true;
            }
            this.vfw = z;
            this.fMY.setBackgroundDrawable(context.getResources().getDrawable(R.g.bkO));
            this.mzk.setVisibility(8);
        }

        public final void bRA() {
            this.mzk.setText(this.vfz);
            this.vfA.sendEmptyMessageDelayed(0, 1000);
        }
    }

    public static void eJ(Context context) {
        if (vfv <= 0) {
            a aVar = new a(context, LayoutInflater.from(context).inflate(R.i.dpg, null));
            aVar.fwj.addView(aVar.fwi, aVar.fwk);
            vfv++;
        }
    }
}
