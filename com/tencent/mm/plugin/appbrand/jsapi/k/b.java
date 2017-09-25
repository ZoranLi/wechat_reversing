package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.k.c.f;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {

    public static class a implements OnTouchListener {
        private static volatile View iYm;
        public com.tencent.mm.u.q.b iHo;
        public Map<Integer, f> iYn = new HashMap();
        public boolean iYo;
        private boolean iYp;
        public f iYq;
        private Runnable iYr;
        private int iYs;
        public float iYt;
        public MotionEvent iYu;
        public MotionEvent iYv;
        public f iYw;
        public f iYx;
        private String ivH;
        public View mView;

        public a(m mVar, com.tencent.mm.u.q.b bVar) {
            this.iHo = bVar;
            this.ivH = mVar.ivH;
            this.iYs = mVar.hashCode();
            this.iYt = (float) ViewConfiguration.get(mVar.mContext).getScaledTouchSlop();
            this.iYw = new f();
            this.iYx = new f();
            this.iYr = new Runnable(this) {
                final /* synthetic */ a iYy;

                {
                    this.iYy = r1;
                }

                public final void run() {
                    if (this.iYy.iYo) {
                        f bD = c.bD(this.iYy.mView);
                        if (Math.abs(this.iYy.iYq.x - bD.x) > 1.0f || Math.abs(this.iYy.iYq.y - bD.y) > 1.0f) {
                            w.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but view has moved.");
                            return;
                        } else if (this.iYy.iYn.size() != 1) {
                            w.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but more then one point.");
                            return;
                        } else if (Math.abs(this.iYy.iYw.x - this.iYy.iYx.x) > this.iYy.iYt || Math.abs(this.iYy.iYw.y - this.iYy.iYx.y) > this.iYy.iYt) {
                            w.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but point has moved(%s, %s, %s, %s).", new Object[]{Float.valueOf(this.iYy.iYw.x), Float.valueOf(this.iYy.iYx.x), Float.valueOf(this.iYy.iYw.y), Float.valueOf(this.iYy.iYx.y)});
                            return;
                        } else {
                            w.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, publish event(%s, %s, %s, %s).", new Object[]{Float.valueOf(this.iYy.iYw.x), Float.valueOf(this.iYy.iYx.x), Float.valueOf(this.iYy.iYw.y), Float.valueOf(this.iYy.iYx.y)});
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, this.iYy.iHo.getString(SlookAirButtonFrequentContactAdapter.DATA, ""));
                                jSONObject.put("touch", this.iYy.iYw.nQ());
                            } catch (JSONException e) {
                            }
                            if (!this.iYy.iHo.getBoolean("disableScroll", false)) {
                                this.iYy.iYu = MotionEvent.obtain(this.iYy.iYv);
                                this.iYy.iYu.setAction(0);
                                this.iYy.iHo.o("fakeDownEvent", true);
                                this.iYy.mView.getParent().requestDisallowInterceptTouchEvent(true);
                                this.iYy.mView.setDuplicateParentStateEnabled(false);
                                this.iYy.a(this.iYy.mView, MotionEvent.obtain(this.iYy.iYu));
                            }
                            this.iYy.a(new com.tencent.mm.plugin.appbrand.jsapi.k.c.a(), jSONObject.toString());
                            return;
                        }
                    }
                    w.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but pressed is false or pointer is null.");
                }
            };
        }

        public final void a(View view, MotionEvent motionEvent) {
            while (true) {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    view.dispatchTouchEvent(motionEvent);
                } else {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    viewGroup.getScrollX();
                    view.getLeft();
                    viewGroup.getScrollY();
                    view.getTop();
                    view = (View) parent;
                }
            }
            view.dispatchTouchEvent(motionEvent);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTouch(android.view.View r19, android.view.MotionEvent r20) {
            /*
            r18 = this;
            r2 = iYm;
            if (r2 == 0) goto L_0x0010;
        L_0x0004:
            r2 = iYm;
            r0 = r19;
            r2 = r2.equals(r0);
            if (r2 != 0) goto L_0x0010;
        L_0x000e:
            r6 = 0;
        L_0x000f:
            return r6;
        L_0x0010:
            r0 = r20;
            r1 = r18;
            r1.iYv = r0;
            r9 = r20.getActionMasked();
            r2 = r20.getActionIndex();
            r20.getPointerCount();
            r0 = r20;
            r10 = r0.getPointerId(r2);
            r0 = r20;
            r11 = r0.getX(r2);
            r0 = r20;
            r12 = r0.getY(r2);
            r5 = "";
            r4 = 0;
            r3 = 0;
            r2 = 0;
            r7 = 0;
            r0 = r18;
            r6 = r0.iHo;
            if (r6 == 0) goto L_0x00a0;
        L_0x0040:
            if (r9 == 0) goto L_0x005e;
        L_0x0042:
            r0 = r18;
            r2 = r0.iHo;
            r3 = "isTouching";
            r2 = r2.fR(r3);
            if (r2 != 0) goto L_0x005e;
        L_0x004f:
            r2 = android.support.v4.view.z.al(r19);
            if (r2 != 0) goto L_0x005e;
        L_0x0055:
            r2 = r20.getActionMasked();
            r3 = 3;
            if (r2 == r3) goto L_0x005e;
        L_0x005c:
            r6 = 0;
            goto L_0x000f;
        L_0x005e:
            r0 = r18;
            r2 = r0.iHo;
            r3 = "data";
            r4 = "";
            r5 = r2.getString(r3, r4);
            r0 = r18;
            r2 = r0.iHo;
            r3 = "disableScroll";
            r4 = 0;
            r4 = r2.getBoolean(r3, r4);
            r0 = r18;
            r2 = r0.iHo;
            r3 = "fakeDownEvent";
            r6 = 0;
            r3 = r2.getBoolean(r3, r6);
            r0 = r18;
            r2 = r0.iHo;
            r6 = "onLongClick";
            r8 = 0;
            r2 = r2.getBoolean(r6, r8);
            r0 = r18;
            r6 = r0.iHo;
            r8 = "enableLongClick";
            r13 = 0;
            r6 = r6.getBoolean(r8, r13);
            r0 = r18;
            r0.iYp = r6;
        L_0x00a0:
            r0 = r18;
            r6 = r0.iYx;
            r6.b(r10, r11, r12);
            r6 = r4 | r2;
            switch(r9) {
                case 0: goto L_0x00ae;
                case 1: goto L_0x02a6;
                case 2: goto L_0x01ac;
                case 3: goto L_0x0313;
                case 4: goto L_0x00ac;
                case 5: goto L_0x03b7;
                case 6: goto L_0x02e8;
                default: goto L_0x00ac;
            };
        L_0x00ac:
            goto L_0x000f;
        L_0x00ae:
            r0 = r18;
            r8 = r0.iYu;
            if (r8 == 0) goto L_0x00df;
        L_0x00b4:
            r14 = r20.getDownTime();
            r0 = r18;
            r8 = r0.iYu;
            r16 = r8.getDownTime();
            r8 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
            if (r8 == 0) goto L_0x00df;
        L_0x00c4:
            r3 = 0;
            r0 = r18;
            r8 = r0.iHo;
            if (r8 == 0) goto L_0x00d6;
        L_0x00cb:
            r0 = r18;
            r8 = r0.iHo;
            r13 = "fakeDownEvent";
            r14 = 0;
            r8.o(r13, r14);
        L_0x00d6:
            r8 = "MicroMsg.OnTouchListenerImpl";
            r13 = "try to handle fake event failed";
            com.tencent.mm.sdk.platformtools.w.v(r8, r13);
        L_0x00df:
            r8 = r3;
            if (r4 != 0) goto L_0x00e4;
        L_0x00e2:
            if (r8 == 0) goto L_0x0283;
        L_0x00e4:
            r3 = r19.getParent();
            r4 = 1;
            r3.requestDisallowInterceptTouchEvent(r4);
            r3 = 0;
            r0 = r19;
            r0.setDuplicateParentStateEnabled(r3);
            r3 = "MicroMsg.OnTouchListenerImpl";
            r4 = "onLongClick fake down event.";
            com.tencent.mm.sdk.platformtools.w.i(r3, r4);
        L_0x00fb:
            if (r8 == 0) goto L_0x028b;
        L_0x00fd:
            r3 = 1;
            r2 = 1;
            r0 = r18;
            r4 = r0.iHo;
            if (r4 == 0) goto L_0x011b;
        L_0x0105:
            r0 = r18;
            r4 = r0.iHo;
            r6 = "fakeDownEvent";
            r13 = 0;
            r4.o(r6, r13);
            r0 = r18;
            r4 = r0.iHo;
            r6 = "onLongClick";
            r13 = 1;
            r4.o(r6, r13);
        L_0x011b:
            r0 = r18;
            r4 = r0.iHo;
            if (r4 == 0) goto L_0x012c;
        L_0x0121:
            r0 = r18;
            r4 = r0.iHo;
            r6 = "isTouching";
            r13 = 1;
            r4.o(r6, r13);
        L_0x012c:
            r0 = r18;
            r4 = r0.iYp;
            if (r4 == 0) goto L_0x0150;
        L_0x0132:
            if (r3 != 0) goto L_0x0150;
        L_0x0134:
            r0 = r18;
            r4 = r0.iYn;
            r6 = java.lang.Integer.valueOf(r10);
            r4 = r4.containsKey(r6);
            if (r4 != 0) goto L_0x0150;
        L_0x0142:
            r0 = r18;
            r4 = r0.iYr;
            r6 = android.view.ViewConfiguration.getLongPressTimeout();
            r14 = (long) r6;
            r0 = r19;
            r0.postDelayed(r4, r14);
        L_0x0150:
            r6 = r2;
            r4 = r8;
        L_0x0152:
            r2 = 0;
            r2 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1));
            if (r2 < 0) goto L_0x02a0;
        L_0x0157:
            r2 = 0;
            r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
            if (r2 < 0) goto L_0x02a0;
        L_0x015c:
            r2 = r19.getWidth();
            r2 = (float) r2;
            r2 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1));
            if (r2 > 0) goto L_0x02a0;
        L_0x0165:
            r2 = r19.getHeight();
            r2 = (float) r2;
            r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
            if (r2 > 0) goto L_0x02a0;
        L_0x016e:
            r2 = 1;
        L_0x016f:
            if (r2 == 0) goto L_0x000f;
        L_0x0171:
            r8 = new com.tencent.mm.plugin.appbrand.jsapi.k.c$f;
            r8.<init>(r10, r11, r12);
            if (r9 != 0) goto L_0x02a3;
        L_0x0178:
            if (r3 != 0) goto L_0x02a3;
        L_0x017a:
            r2 = 1;
        L_0x017b:
            r0 = r18;
            r1 = r19;
            r0.f(r1, r2);
            r0 = r18;
            r2 = r0.iYn;
            r3 = java.lang.Integer.valueOf(r10);
            r2 = r2.containsKey(r3);
            if (r2 == 0) goto L_0x03b4;
        L_0x0190:
            r2 = 1;
        L_0x0191:
            r0 = r18;
            r3 = r0.iYn;
            r7 = java.lang.Integer.valueOf(r10);
            r3.put(r7, r8);
            if (r4 != 0) goto L_0x000f;
        L_0x019e:
            if (r2 != 0) goto L_0x000f;
        L_0x01a0:
            r2 = new com.tencent.mm.plugin.appbrand.jsapi.k.c$c;
            r2.<init>();
            r0 = r18;
            r0.a(r8, r2, r5);
            goto L_0x000f;
        L_0x01ac:
            r2 = 0;
            r3 = r2;
        L_0x01ae:
            r2 = r20.getPointerCount();
            if (r3 >= r2) goto L_0x0266;
        L_0x01b4:
            r0 = r20;
            r4 = r0.getX(r3);
            r0 = r20;
            r7 = r0.getY(r3);
            r0 = r20;
            r2 = r0.getPointerId(r3);
            r0 = r18;
            r8 = r0.iYn;
            r2 = java.lang.Integer.valueOf(r2);
            r2 = r8.get(r2);
            r2 = (com.tencent.mm.plugin.appbrand.jsapi.k.c.f) r2;
            if (r2 == 0) goto L_0x0261;
        L_0x01d6:
            r8 = r2.x;
            r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
            if (r4 != 0) goto L_0x01e2;
        L_0x01dc:
            r2 = r2.y;
            r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1));
            if (r2 == 0) goto L_0x0261;
        L_0x01e2:
            r2 = 1;
        L_0x01e3:
            if (r2 == 0) goto L_0x000f;
        L_0x01e5:
            r0 = r18;
            r2 = r0.iYn;
            r2 = r2.size();
            r3 = 1;
            if (r2 != r3) goto L_0x0230;
        L_0x01f0:
            r0 = r18;
            r2 = r0.iYo;
            if (r2 == 0) goto L_0x0230;
        L_0x01f6:
            r0 = r18;
            r2 = r0.iYw;
            r2 = r2.x;
            r0 = r18;
            r3 = r0.iYx;
            r3 = r3.x;
            r2 = r2 - r3;
            r2 = java.lang.Math.abs(r2);
            r0 = r18;
            r3 = r0.iYt;
            r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
            if (r2 > 0) goto L_0x0228;
        L_0x020f:
            r0 = r18;
            r2 = r0.iYw;
            r2 = r2.y;
            r0 = r18;
            r3 = r0.iYx;
            r3 = r3.y;
            r2 = r2 - r3;
            r2 = java.lang.Math.abs(r2);
            r0 = r18;
            r3 = r0.iYt;
            r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
            if (r2 <= 0) goto L_0x0230;
        L_0x0228:
            r2 = 0;
            r0 = r18;
            r1 = r19;
            r0.f(r1, r2);
        L_0x0230:
            r3 = new org.json.JSONObject;
            r3.<init>();
            r4 = new org.json.JSONArray;
            r4.<init>();
            r2 = "data";
            r3.put(r2, r5);	 Catch:{ JSONException -> 0x03b1 }
            r2 = "touches";
            r3.put(r2, r4);	 Catch:{ JSONException -> 0x03b1 }
        L_0x0246:
            r0 = r18;
            r1 = r20;
            r5 = r0.r(r1);
            r2 = r5.length;
            if (r2 <= 0) goto L_0x0269;
        L_0x0251:
            r2 = 0;
        L_0x0252:
            r7 = r5.length;
            if (r2 >= r7) goto L_0x0269;
        L_0x0255:
            r7 = r5[r2];
            r7 = r7.nQ();
            r4.put(r7);
            r2 = r2 + 1;
            goto L_0x0252;
        L_0x0261:
            r2 = r3 + 1;
            r3 = r2;
            goto L_0x01ae;
        L_0x0266:
            r2 = 0;
            goto L_0x01e3;
        L_0x0269:
            r0 = r18;
            r2 = r0.iYn;
            r2 = r2.size();
            if (r2 == 0) goto L_0x000f;
        L_0x0273:
            r2 = new com.tencent.mm.plugin.appbrand.jsapi.k.c$d;
            r2.<init>();
            r3 = r3.toString();
            r0 = r18;
            r0.a(r2, r3);
            goto L_0x000f;
        L_0x0283:
            r3 = 1;
            r0 = r19;
            r0.setDuplicateParentStateEnabled(r3);
            goto L_0x00fb;
        L_0x028b:
            iYm = r19;
            r3 = com.tencent.mm.plugin.appbrand.jsapi.k.c.bD(r19);
            r0 = r18;
            r0.iYq = r3;
            r0 = r18;
            r3 = r0.iYw;
            r3.b(r10, r11, r12);
            r3 = r2;
            r2 = r6;
            goto L_0x011b;
        L_0x02a0:
            r2 = 0;
            goto L_0x016f;
        L_0x02a3:
            r2 = 0;
            goto L_0x017b;
        L_0x02a6:
            if (r4 != 0) goto L_0x02aa;
        L_0x02a8:
            if (r2 == 0) goto L_0x030c;
        L_0x02aa:
            r2 = r19.getParent();
            r3 = 0;
            r2.requestDisallowInterceptTouchEvent(r3);
        L_0x02b2:
            r2 = 0;
            iYm = r2;
            r0 = r18;
            r2 = r0.iHo;
            if (r2 == 0) goto L_0x02e8;
        L_0x02bb:
            r0 = r18;
            r2 = r0.iHo;
            r3 = "isTouching";
            r7 = 0;
            r2.o(r3, r7);
            r0 = r18;
            r2 = r0.iHo;
            r3 = "disableScroll-nextState";
            r2 = r2.containsKey(r3);
            if (r2 == 0) goto L_0x02e8;
        L_0x02d3:
            r0 = r18;
            r2 = r0.iHo;
            r3 = "disableScroll";
            r0 = r18;
            r7 = r0.iHo;
            r8 = "disableScroll-nextState";
            r4 = r7.getBoolean(r8, r4);
            r2.o(r3, r4);
        L_0x02e8:
            r0 = r18;
            r2 = r0.iYn;
            r3 = java.lang.Integer.valueOf(r10);
            r2 = r2.remove(r3);
            r2 = (com.tencent.mm.plugin.appbrand.jsapi.k.c.f) r2;
            if (r2 == 0) goto L_0x000f;
        L_0x02f8:
            r3 = 0;
            r0 = r18;
            r1 = r19;
            r0.f(r1, r3);
            r3 = new com.tencent.mm.plugin.appbrand.jsapi.k.c$e;
            r3.<init>();
            r0 = r18;
            r0.a(r2, r3, r5);
            goto L_0x000f;
        L_0x030c:
            r2 = 0;
            r0 = r19;
            r0.setDuplicateParentStateEnabled(r2);
            goto L_0x02b2;
        L_0x0313:
            r3 = 0;
            iYm = r3;
            r3 = 0;
            r0 = r18;
            r1 = r19;
            r0.f(r1, r3);
            if (r4 != 0) goto L_0x0322;
        L_0x0320:
            if (r2 == 0) goto L_0x0391;
        L_0x0322:
            r2 = r19.getParent();
            r3 = 0;
            r2.requestDisallowInterceptTouchEvent(r3);
        L_0x032a:
            r0 = r18;
            r2 = r0.iHo;
            if (r2 == 0) goto L_0x035d;
        L_0x0330:
            r0 = r18;
            r2 = r0.iHo;
            r3 = "isTouching";
            r7 = 0;
            r2.o(r3, r7);
            r0 = r18;
            r2 = r0.iHo;
            r3 = "disableScroll-nextState";
            r2 = r2.containsKey(r3);
            if (r2 == 0) goto L_0x035d;
        L_0x0348:
            r0 = r18;
            r2 = r0.iHo;
            r3 = "disableScroll";
            r0 = r18;
            r7 = r0.iHo;
            r8 = "disableScroll-nextState";
            r4 = r7.getBoolean(r8, r4);
            r2.o(r3, r4);
        L_0x035d:
            r2 = android.support.v4.view.z.al(r19);
            if (r2 == 0) goto L_0x03a6;
        L_0x0363:
            r3 = new org.json.JSONObject;
            r3.<init>();
            r4 = new org.json.JSONArray;
            r4.<init>();
            r2 = "data";
            r3.put(r2, r5);	 Catch:{ JSONException -> 0x03af }
            r2 = "touches";
            r3.put(r2, r4);	 Catch:{ JSONException -> 0x03af }
        L_0x0379:
            r0 = r18;
            r1 = r20;
            r5 = r0.r(r1);
            r2 = 0;
        L_0x0382:
            r7 = r5.length;
            if (r2 >= r7) goto L_0x0398;
        L_0x0385:
            r7 = r5[r2];
            r7 = r7.nQ();
            r4.put(r7);
            r2 = r2 + 1;
            goto L_0x0382;
        L_0x0391:
            r2 = 0;
            r0 = r19;
            r0.setDuplicateParentStateEnabled(r2);
            goto L_0x032a;
        L_0x0398:
            r2 = new com.tencent.mm.plugin.appbrand.jsapi.k.c$b;
            r2.<init>();
            r3 = r3.toString();
            r0 = r18;
            r0.a(r2, r3);
        L_0x03a6:
            r0 = r18;
            r2 = r0.iYn;
            r2.clear();
            goto L_0x000f;
        L_0x03af:
            r2 = move-exception;
            goto L_0x0379;
        L_0x03b1:
            r2 = move-exception;
            goto L_0x0246;
        L_0x03b4:
            r2 = r7;
            goto L_0x0191;
        L_0x03b7:
            r4 = r3;
            r3 = r2;
            goto L_0x0152;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.k.b.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }

        private void f(View view, boolean z) {
            this.mView = view;
            this.iYo = z;
            if (!z) {
                this.iHo.o("fakeDownEvent", false);
                this.iHo.o("onLongClick", false);
                this.mView.removeCallbacks(this.iYr);
                this.iYw.b(-1, 0.0f, 0.0f);
                this.iYu = null;
            }
        }

        private void a(f fVar, e eVar, String str) {
            if (fVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, str);
                    jSONObject.put("touch", fVar.nQ());
                } catch (JSONException e) {
                }
                a(eVar, jSONObject.toString());
            }
        }

        public final void a(e eVar, String str) {
            e ad = eVar.ad(this.ivH, this.iYs);
            ad.mData = str;
            ad.SR();
        }

        private f[] r(MotionEvent motionEvent) {
            int i = 0;
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
                f fVar = (f) this.iYn.get(Integer.valueOf(motionEvent.getPointerId(i2)));
                if (fVar != null) {
                    fVar.x = motionEvent.getX(i2);
                    fVar.y = motionEvent.getY(i2);
                    arrayList.add(fVar);
                }
            }
            f[] fVarArr = new f[arrayList.size()];
            while (i < arrayList.size()) {
                fVarArr[i] = (f) arrayList.get(i);
                i++;
            }
            return fVarArr;
        }
    }
}
