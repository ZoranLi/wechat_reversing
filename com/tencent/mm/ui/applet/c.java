package com.tencent.mm.ui.applet;

import android.content.Context;
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
import com.tencent.mm.R;
import com.tencent.mm.bl.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;

public final class c {

    public static final class a {
        private ImageView fMY;
        public FrameLayout fwi;
        public WindowManager fwj;
        public LayoutParams fwk;
        private ViewGroup.LayoutParams fwl;
        private View mView;

        public a(Context context, View view) {
            if (this.fwi == null || this.fwj == null) {
                view.findViewById(R.h.cmf).setVisibility(8);
                this.fMY = (ImageView) view.findViewById(R.h.button);
                ((ImageView) view.findViewById(R.h.bHY)).setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a vfg;

                    {
                        this.vfg = r1;
                    }

                    public final void onClick(View view) {
                        this.vfg.ol();
                    }
                });
                this.fwk = new LayoutParams();
                this.fwk.height = -2;
                this.fwk.width = -2;
                this.fwj = (WindowManager) context.getSystemService("window");
                this.fwk.x = 0;
                this.fwk.y = 0;
                this.fwk.flags = 40;
                this.fwk.type = MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK;
                this.mView = view;
                this.fwk.gravity = 51;
                this.fwk.format = 1;
                this.fwi = new FrameLayout(context);
                this.fwi.setPadding(4, 4, 4, 4);
                this.fwl = new ViewGroup.LayoutParams(-2, -2);
                this.fwi.addView(this.mView, this.fwl);
                final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                this.fwi.setOnTouchListener(new OnTouchListener(this) {
                    final /* synthetic */ a vfg;
                    int vfh;
                    int vfi;
                    int vfj = ((displayMetrics.widthPixels - this.vfg.fwk.width) - 1);
                    int vfk = ((displayMetrics.heightPixels - this.vfg.fwk.height) - 1);
                    long vfl;

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        switch (motionEvent.getAction()) {
                            case 0:
                                this.vfh = ((int) motionEvent.getRawX()) - this.vfg.fwk.x;
                                this.vfi = ((int) motionEvent.getRawY()) - this.vfg.fwk.y;
                                this.vfl = System.currentTimeMillis();
                                break;
                            case 1:
                                if (System.currentTimeMillis() - this.vfl < 300) {
                                    b.bOg();
                                    b.I(false, true);
                                    this.vfg.ol();
                                    break;
                                }
                                break;
                            case 2:
                                this.vfj = (displayMetrics.widthPixels - this.vfg.fwk.width) - 1;
                                this.vfk = (displayMetrics.heightPixels - this.vfg.fwk.height) - 1;
                                this.vfg.fwk.x = ((int) motionEvent.getRawX()) - this.vfh;
                                this.vfg.fwk.y = ((int) motionEvent.getRawY()) - this.vfi;
                                this.vfg.fwk.x = this.vfg.fwk.x < 0 ? 0 : this.vfg.fwk.x;
                                this.vfg.fwk.x = this.vfg.fwk.x > this.vfj ? this.vfj : this.vfg.fwk.x;
                                this.vfg.fwk.y = this.vfg.fwk.y < 0 ? 0 : this.vfg.fwk.y;
                                this.vfg.fwk.y = this.vfg.fwk.y > this.vfk ? this.vfk : this.vfg.fwk.y;
                                this.vfg.fwj.updateViewLayout(this.vfg.fwi, this.vfg.fwk);
                                break;
                        }
                        return false;
                    }
                });
            }
        }

        public final void ol() {
            try {
                if (this.fwj != null) {
                    if (this.fwi != null) {
                        this.fwj.removeView(this.fwi);
                    }
                    this.fwj = null;
                }
                if (this.fwi != null) {
                    this.fwi.removeAllViews();
                    this.fwi = null;
                }
                this.mView = null;
            } catch (Exception e) {
            }
        }
    }

    public static void eI(Context context) {
        a aVar = new a(context, LayoutInflater.from(context).inflate(R.i.dpg, null));
        aVar.fwj.addView(aVar.fwi, aVar.fwk);
    }
}
