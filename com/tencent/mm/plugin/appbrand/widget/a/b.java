package com.tencent.mm.plugin.appbrand.widget.a;

import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.w;

public final class b {
    public static void a(String str, String str2, MotionEvent motionEvent) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2).append(' ');
        stringBuilder.append("[apptouch] MotionEvent { action=").append(actionToString(motionEvent.getAction()));
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            stringBuilder.append(", x[").append(i).append("]=").append(motionEvent.getX(i));
            stringBuilder.append(", y[").append(i).append("]=").append(motionEvent.getY(i));
        }
        stringBuilder.append(", downTime=").append(motionEvent.getDownTime());
        stringBuilder.append(" }");
        if (w.getLogLevel() <= 1) {
            w.v(str, stringBuilder.toString());
        }
    }

    public static String v(MotionEvent motionEvent) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MotionEvent { action=").append(actionToString(motionEvent.getAction()));
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            stringBuilder.append(", x[").append(i).append("]=").append(motionEvent.getX(i));
            stringBuilder.append(", y[").append(i).append("]=").append(motionEvent.getY(i));
        }
        stringBuilder.append(", downTime=").append(motionEvent.getDownTime());
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    private static String actionToString(int i) {
        switch (i) {
            case 0:
                return "ACTION_DOWN";
            case 1:
                return "ACTION_UP";
            case 2:
                return "ACTION_MOVE";
            case 3:
                return "ACTION_CANCEL";
            case 4:
                return "ACTION_OUTSIDE";
            case 7:
                return "ACTION_HOVER_MOVE";
            case 8:
                return "ACTION_SCROLL";
            case 9:
                return "ACTION_HOVER_ENTER";
            case 10:
                return "ACTION_HOVER_EXIT";
            case 11:
                return "ACTION_BUTTON_PRESS";
            case 12:
                return "ACTION_BUTTON_RELEASE";
            default:
                int i2 = (65280 & i) >> 8;
                switch (i & 255) {
                    case 5:
                        return "ACTION_POINTER_DOWN(" + i2 + ")";
                    case 6:
                        return "ACTION_POINTER_UP(" + i2 + ")";
                    default:
                        return Integer.toString(i);
                }
        }
    }
}
