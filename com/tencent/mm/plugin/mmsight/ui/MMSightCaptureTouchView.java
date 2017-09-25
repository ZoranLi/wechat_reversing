package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.wcdb.support.Log;

public class MMSightCaptureTouchView extends RelativeLayout {
    private long nJY = -1;
    private float nJZ = -1.0f;
    private int nKa = 0;
    a nKb;

    public interface a {
        void aLU();

        void aLV();

        void aLW();

        void y(float f, float f2);
    }

    public MMSightCaptureTouchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMSightCaptureTouchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_DOWN");
                if (this.nJY <= 0 || SystemClock.elapsedRealtime() - this.nJY >= 400) {
                    if (this.nKb != null) {
                        this.nKb.y(motionEvent.getX(), motionEvent.getY());
                    }
                } else if (this.nKb != null) {
                    this.nKb.aLU();
                }
                this.nJY = SystemClock.elapsedRealtime();
                this.nJZ = -1.0f;
                this.nKa++;
                break;
            case 1:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_UP");
                this.nJZ = -1.0f;
                this.nKa = 0;
                break;
            case 2:
                if (this.nKa >= 2) {
                    float x = x(motionEvent);
                    Log.v("MicroMsg.MMSightCaptureTouchView", "distance: %s", new Object[]{Float.valueOf(x)});
                    if (x > 0.0f) {
                        if (this.nJZ > 0.0f) {
                            if (Math.abs(x - this.nJZ) > 15.0f) {
                                if (x > this.nJZ) {
                                    Log.d("MicroMsg.MMSightCaptureTouchView", "zoom out");
                                    if (this.nKb != null) {
                                        this.nKb.aLV();
                                    }
                                } else {
                                    Log.d("MicroMsg.MMSightCaptureTouchView", "zoom in");
                                    if (this.nKb != null) {
                                        this.nKb.aLW();
                                    }
                                }
                            }
                        }
                        this.nJZ = x;
                        break;
                    }
                }
                break;
            case 5:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_DOWN");
                this.nKa++;
                break;
            case 6:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_UP");
                this.nKa--;
                break;
        }
        return true;
    }

    private float x(MotionEvent motionEvent) {
        try {
            if (this.nKa >= 2) {
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                return Math.abs(x - motionEvent.getX(1)) + Math.abs(y - motionEvent.getY(1));
            }
        } catch (Exception e) {
            Log.e("MicroMsg.MMSightCaptureTouchView", "pointerDistance error: %s", new Object[]{e.getMessage()});
        }
        return 0.0f;
    }
}
