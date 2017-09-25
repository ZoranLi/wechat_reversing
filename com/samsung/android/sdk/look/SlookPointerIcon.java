package com.samsung.android.sdk.look;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.OnHoverListener;

public class SlookPointerIcon {
    private static final String TAG = "SlookPointerIcon";
    public Drawable mDrawable;
    private Slook mSlook = new Slook();

    public void setHoverIcon(View view, Drawable drawable) {
        if (!isSupport(1)) {
            return;
        }
        if (view == null) {
            throw new IllegalArgumentException("view is null.");
        } else if (drawable == null) {
            view.setOnHoverListener(null);
            try {
                PointerIcon.setHoveringSpenIcon(1, -1);
            } catch (RemoteException e) {
            }
        } else {
            this.mDrawable = drawable;
            view.setOnHoverListener(new OnHoverListener() {
                public boolean onHover(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 9:
                            try {
                                PointerIcon.setHoveringSpenIcon(0, SlookPointerIcon.this.mDrawable);
                                break;
                            } catch (RemoteException e) {
                                break;
                            }
                        case 10:
                            try {
                                PointerIcon.setHoveringSpenIcon(1, -1);
                                break;
                            } catch (RemoteException e2) {
                                break;
                            }
                    }
                    return false;
                }
            });
        }
    }

    private boolean isSupport(int i) {
        if (this.mSlook.isFeatureEnabled(4)) {
            return true;
        }
        return false;
    }
}
