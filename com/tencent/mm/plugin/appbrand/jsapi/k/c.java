package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {

    public static class f {
        public int id;
        public float x;
        public float y;

        public f(int i, float f, float f2) {
            this.id = i;
            this.x = f;
            this.y = f2;
        }

        public final void b(int i, float f, float f2) {
            this.id = i;
            this.x = f;
            this.y = f2;
        }

        public final JSONObject nQ() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SlookAirButtonFrequentContactAdapter.ID, this.id);
                jSONObject.put("x", (double) h.P(this.x));
                jSONObject.put("y", (double) h.P(this.y));
            } catch (JSONException e) {
            }
            return jSONObject;
        }

        public final String toString() {
            return nQ().toString();
        }
    }

    public static class a extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = 137;
        private static final String NAME = "onLongPress";
    }

    public static class b extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchCancel";
    }

    public static class c extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchStart";
    }

    public static class d extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchMove";
    }

    public static class e extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchEnd";
    }

    public static f bD(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new f(0, (float) iArr[0], (float) iArr[1]);
    }

    public static void a(ViewGroup viewGroup, MotionEvent motionEvent) {
        int pointerId;
        int childCount = viewGroup.getChildCount();
        int actionIndex = motionEvent.getActionIndex();
        if (viewGroup.isMotionEventSplittingEnabled()) {
            pointerId = 1 << motionEvent.getPointerId(actionIndex);
        } else {
            pointerId = -1;
        }
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = viewGroup.getChildAt(i);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (((Boolean) m.a(ViewGroup.class, "canViewReceivePointerEvents", viewGroup, new Class[]{View.class}, new Object[]{childAt}, Boolean.valueOf(false))).booleanValue()) {
                if (((Boolean) m.a(ViewGroup.class, "isTransformedTouchPointInView", viewGroup, new Class[]{Float.TYPE, Float.TYPE, View.class, PointF.class}, new Object[]{Float.valueOf(x), Float.valueOf(y), childAt, null}, Boolean.valueOf(false))).booleanValue() && childAt.isDuplicateParentStateEnabled()) {
                    if (childAt == null) {
                        w.v("MicroMsg.ViewMotionHelper", "child is null.");
                    } else {
                        actionIndex = motionEvent.getAction();
                        if (actionIndex == 3) {
                            motionEvent.setAction(3);
                            childAt.dispatchTouchEvent(motionEvent);
                            motionEvent.setAction(actionIndex);
                        } else {
                            int intValue = ((Integer) m.a(MotionEvent.class, "getPointerIdBits", motionEvent, new Class[0], new Object[0], Integer.valueOf(0))).intValue();
                            int i2 = intValue & pointerId;
                            if (i2 == 0) {
                                w.v("MicroMsg.ViewMotionHelper", "newPointerIdBits is 0.");
                            } else {
                                MotionEvent obtain;
                                boolean booleanValue = ((Boolean) m.a(View.class, "hasIdentityMatrix", childAt, new Class[0], new Object[0], Boolean.valueOf(false))).booleanValue();
                                if (i2 != intValue) {
                                    obtain = MotionEvent.obtain(motionEvent);
                                } else if (booleanValue) {
                                    float scrollX = (float) (viewGroup.getScrollX() - childAt.getLeft());
                                    float scrollY = (float) (viewGroup.getScrollY() - childAt.getTop());
                                    motionEvent.offsetLocation(scrollX, scrollY);
                                    childAt.dispatchTouchEvent(motionEvent);
                                    motionEvent.offsetLocation(-scrollX, -scrollY);
                                } else {
                                    obtain = MotionEvent.obtain(motionEvent);
                                }
                                obtain.offsetLocation((float) (viewGroup.getScrollX() - childAt.getLeft()), (float) (viewGroup.getScrollY() - childAt.getTop()));
                                if (!booleanValue) {
                                    obtain.transform((Matrix) m.a(View.class, "getInverseMatrix", childAt, new Class[0], new Object[0], null));
                                }
                                childAt.dispatchTouchEvent(obtain);
                                obtain.recycle();
                            }
                        }
                    }
                    if ((childAt instanceof com.tencent.mm.plugin.appbrand.jsapi.base.e) && ((com.tencent.mm.plugin.appbrand.jsapi.base.e) childAt).Tt()) {
                        return;
                    }
                }
            }
        }
    }
}
