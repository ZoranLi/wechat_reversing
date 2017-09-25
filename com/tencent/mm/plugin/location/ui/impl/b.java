package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.p.a;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.w;

public abstract class b extends a {
    public Activity activity;
    protected float jWC = 0.0f;
    protected float mxi = 0.0f;
    protected d ndG;
    protected int type = 0;

    public abstract d aHh();

    public abstract int getLayoutId();

    public b(Activity activity) {
        this.activity = activity;
    }

    public void onCreate(Bundle bundle) {
        this.activity.requestWindowFeature(1);
        this.activity.setContentView(getLayoutId());
        this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
        w.i("MicroMsg.MMBaseMapUI", "init oncreate type %d", new Object[]{Integer.valueOf(this.type)});
        ((FrameLayout) findViewById(R.h.ciM)).addView(d.cv(this.activity));
        this.ndG = aHh();
        this.ndG.setMapViewOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ b ngL;

            {
                this.ngL = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                w.i("MicroMsg.MMBaseMapUI", "map action " + action);
                switch (action) {
                    case 0:
                        this.ngL.mxi = motionEvent.getX();
                        this.ngL.jWC = motionEvent.getY();
                        break;
                    case 1:
                        if (Math.abs(motionEvent.getX() - this.ngL.mxi) > 10.0f || Math.abs(motionEvent.getY() - this.ngL.jWC) > 10.0f) {
                            this.ngL.aHi();
                            break;
                        }
                }
                return false;
            }
        });
    }

    public final View findViewById(int i) {
        return this.activity.findViewById(i);
    }

    public final String getString(int i) {
        return this.activity.getString(i);
    }

    public final void onBackPressed() {
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void aHi() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        w.d("MicroMsg.MMBaseMapUI", "dispatchKeyEvent");
        this.activity.finish();
        return true;
    }

    public final boolean aHg() {
        return false;
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }

    protected final void aHf() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = this.activity.getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }

    public final void aHj() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = this.activity.getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }
}
