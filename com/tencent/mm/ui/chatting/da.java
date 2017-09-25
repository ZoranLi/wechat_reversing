package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;

final class da implements OnTouchListener {
    private int[] vFZ = new int[2];

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.vFZ[0] = (int) motionEvent.getRawX();
                this.vFZ[1] = (int) motionEvent.getRawY();
                view.setTag(R.h.cJw, this.vFZ);
                break;
        }
        return false;
    }
}
