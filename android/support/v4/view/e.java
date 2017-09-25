package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class e {
    private final a wy;

    interface a {
        boolean onTouchEvent(MotionEvent motionEvent);
    }

    static class b implements a {
        private static final int wD = ViewConfiguration.getLongPressTimeout();
        private static final int wE = ViewConfiguration.getTapTimeout();
        private static final int wF = ViewConfiguration.getDoubleTapTimeout();
        private VelocityTracker fk;
        final Handler mHandler = new a(this);
        private int wA;
        private int wB;
        private int wC;
        public final OnGestureListener wG;
        public OnDoubleTapListener wH;
        public boolean wI;
        public boolean wJ;
        boolean wK;
        private boolean wL;
        private boolean wM;
        public MotionEvent wN;
        private MotionEvent wO;
        private boolean wP;
        private float wQ;
        private float wR;
        private float wS;
        private float wT;
        private boolean wU;
        private int wz;

        private class a extends Handler {
            final /* synthetic */ b wV;

            a(b bVar) {
                this.wV = bVar;
            }

            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        this.wV.wG.onShowPress(this.wV.wN);
                        return;
                    case 2:
                        b bVar = this.wV;
                        bVar.mHandler.removeMessages(3);
                        bVar.wJ = false;
                        bVar.wK = true;
                        bVar.wG.onLongPress(bVar.wN);
                        return;
                    case 3:
                        if (this.wV.wH == null) {
                            return;
                        }
                        if (this.wV.wI) {
                            this.wV.wJ = true;
                            return;
                        } else {
                            this.wV.wH.onSingleTapConfirmed(this.wV.wN);
                            return;
                        }
                    default:
                        throw new RuntimeException("Unknown message " + message);
                }
            }
        }

        public b(Context context, OnGestureListener onGestureListener, Handler handler) {
            this.wG = onGestureListener;
            if (onGestureListener instanceof OnDoubleTapListener) {
                this.wH = (OnDoubleTapListener) onGestureListener;
            }
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.wG == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            } else {
                this.wU = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.wB = viewConfiguration.getScaledMinimumFlingVelocity();
                this.wC = viewConfiguration.getScaledMaximumFlingVelocity();
                this.wz = scaledTouchSlop * scaledTouchSlop;
                this.wA = scaledDoubleTapSlop * scaledDoubleTapSlop;
            }
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            int i;
            int action = motionEvent.getAction();
            if (this.fk == null) {
                this.fk = VelocityTracker.obtain();
            }
            this.fk.addMovement(motionEvent);
            boolean z = (action & 255) == 6;
            int e = z ? o.e(motionEvent) : -1;
            int f = o.f(motionEvent);
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (i = 0; i < f; i++) {
                if (e != i) {
                    f3 += o.d(motionEvent, i);
                    f2 += o.e(motionEvent, i);
                }
            }
            e = z ? f - 1 : f;
            f3 /= (float) e;
            f2 /= (float) e;
            boolean hasMessages;
            float b;
            float a;
            switch (action & 255) {
                case 0:
                    if (this.wH != null) {
                        hasMessages = this.mHandler.hasMessages(3);
                        if (hasMessages) {
                            this.mHandler.removeMessages(3);
                        }
                        if (!(this.wN == null || this.wO == null || !hasMessages)) {
                            MotionEvent motionEvent2 = this.wN;
                            MotionEvent motionEvent3 = this.wO;
                            if (this.wM && motionEvent.getEventTime() - motionEvent3.getEventTime() <= ((long) wF)) {
                                f = ((int) motionEvent2.getX()) - ((int) motionEvent.getX());
                                e = ((int) motionEvent2.getY()) - ((int) motionEvent.getY());
                                if ((e * e) + (f * f) < this.wA) {
                                    hasMessages = true;
                                    if (hasMessages) {
                                        this.wP = true;
                                        e = (this.wH.onDoubleTap(this.wN) | 0) | this.wH.onDoubleTapEvent(motionEvent);
                                        this.wQ = f3;
                                        this.wS = f3;
                                        this.wR = f2;
                                        this.wT = f2;
                                        if (this.wN != null) {
                                            this.wN.recycle();
                                        }
                                        this.wN = MotionEvent.obtain(motionEvent);
                                        this.wL = true;
                                        this.wM = true;
                                        this.wI = true;
                                        this.wK = false;
                                        this.wJ = false;
                                        if (this.wU) {
                                            this.mHandler.removeMessages(2);
                                            this.mHandler.sendEmptyMessageAtTime(2, (this.wN.getDownTime() + ((long) wE)) + ((long) wD));
                                        }
                                        this.mHandler.sendEmptyMessageAtTime(1, this.wN.getDownTime() + ((long) wE));
                                        return e | this.wG.onDown(motionEvent);
                                    }
                                }
                            }
                            hasMessages = false;
                            if (hasMessages) {
                                this.wP = true;
                                e = (this.wH.onDoubleTap(this.wN) | 0) | this.wH.onDoubleTapEvent(motionEvent);
                                this.wQ = f3;
                                this.wS = f3;
                                this.wR = f2;
                                this.wT = f2;
                                if (this.wN != null) {
                                    this.wN.recycle();
                                }
                                this.wN = MotionEvent.obtain(motionEvent);
                                this.wL = true;
                                this.wM = true;
                                this.wI = true;
                                this.wK = false;
                                this.wJ = false;
                                if (this.wU) {
                                    this.mHandler.removeMessages(2);
                                    this.mHandler.sendEmptyMessageAtTime(2, (this.wN.getDownTime() + ((long) wE)) + ((long) wD));
                                }
                                this.mHandler.sendEmptyMessageAtTime(1, this.wN.getDownTime() + ((long) wE));
                                return e | this.wG.onDown(motionEvent);
                            }
                        }
                        this.mHandler.sendEmptyMessageDelayed(3, (long) wF);
                    }
                    e = 0;
                    this.wQ = f3;
                    this.wS = f3;
                    this.wR = f2;
                    this.wT = f2;
                    if (this.wN != null) {
                        this.wN.recycle();
                    }
                    this.wN = MotionEvent.obtain(motionEvent);
                    this.wL = true;
                    this.wM = true;
                    this.wI = true;
                    this.wK = false;
                    this.wJ = false;
                    if (this.wU) {
                        this.mHandler.removeMessages(2);
                        this.mHandler.sendEmptyMessageAtTime(2, (this.wN.getDownTime() + ((long) wE)) + ((long) wD));
                    }
                    this.mHandler.sendEmptyMessageAtTime(1, this.wN.getDownTime() + ((long) wE));
                    return e | this.wG.onDown(motionEvent);
                case 1:
                    this.wI = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    if (this.wP) {
                        hasMessages = this.wH.onDoubleTapEvent(motionEvent) | 0;
                    } else if (this.wK) {
                        this.mHandler.removeMessages(3);
                        this.wK = false;
                        hasMessages = false;
                    } else if (this.wL) {
                        hasMessages = this.wG.onSingleTapUp(motionEvent);
                        if (this.wJ && this.wH != null) {
                            this.wH.onSingleTapConfirmed(motionEvent);
                        }
                    } else {
                        VelocityTracker velocityTracker = this.fk;
                        int c = o.c(motionEvent, 0);
                        velocityTracker.computeCurrentVelocity(1000, (float) this.wC);
                        b = y.b(velocityTracker, c);
                        a = y.a(velocityTracker, c);
                        hasMessages = (Math.abs(b) > ((float) this.wB) || Math.abs(a) > ((float) this.wB)) ? this.wG.onFling(this.wN, motionEvent, a, b) : false;
                    }
                    if (this.wO != null) {
                        this.wO.recycle();
                    }
                    this.wO = obtain;
                    if (this.fk != null) {
                        this.fk.recycle();
                        this.fk = null;
                    }
                    this.wP = false;
                    this.wJ = false;
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(2);
                    return hasMessages;
                case 2:
                    if (this.wK) {
                        return false;
                    }
                    a = this.wQ - f3;
                    b = this.wR - f2;
                    if (this.wP) {
                        return this.wH.onDoubleTapEvent(motionEvent) | 0;
                    }
                    if (this.wL) {
                        i = (int) (f3 - this.wS);
                        int i2 = (int) (f2 - this.wT);
                        i = (i * i) + (i2 * i2);
                        if (i > this.wz) {
                            hasMessages = this.wG.onScroll(this.wN, motionEvent, a, b);
                            this.wQ = f3;
                            this.wR = f2;
                            this.wL = false;
                            this.mHandler.removeMessages(3);
                            this.mHandler.removeMessages(1);
                            this.mHandler.removeMessages(2);
                        } else {
                            hasMessages = false;
                        }
                        if (i > this.wz) {
                            this.wM = false;
                        }
                        return hasMessages;
                    } else if (Math.abs(a) < 1.0f && Math.abs(b) < 1.0f) {
                        return false;
                    } else {
                        boolean onScroll = this.wG.onScroll(this.wN, motionEvent, a, b);
                        this.wQ = f3;
                        this.wR = f2;
                        return onScroll;
                    }
                case 3:
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(2);
                    this.mHandler.removeMessages(3);
                    this.fk.recycle();
                    this.fk = null;
                    this.wP = false;
                    this.wI = false;
                    this.wL = false;
                    this.wM = false;
                    this.wJ = false;
                    if (!this.wK) {
                        return false;
                    }
                    this.wK = false;
                    return false;
                case 5:
                    this.wQ = f3;
                    this.wS = f3;
                    this.wR = f2;
                    this.wT = f2;
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(2);
                    this.mHandler.removeMessages(3);
                    this.wP = false;
                    this.wL = false;
                    this.wM = false;
                    this.wJ = false;
                    if (!this.wK) {
                        return false;
                    }
                    this.wK = false;
                    return false;
                case 6:
                    this.wQ = f3;
                    this.wS = f3;
                    this.wR = f2;
                    this.wT = f2;
                    this.fk.computeCurrentVelocity(1000, (float) this.wC);
                    int e2 = o.e(motionEvent);
                    e = o.c(motionEvent, e2);
                    f3 = y.a(this.fk, e);
                    float b2 = y.b(this.fk, e);
                    for (e = 0; e < f; e++) {
                        if (e != e2) {
                            i = o.c(motionEvent, e);
                            if ((y.b(this.fk, i) * b2) + (y.a(this.fk, i) * f3) < 0.0f) {
                                this.fk.clear();
                                return false;
                            }
                        }
                    }
                    return false;
                default:
                    return false;
            }
        }
    }

    static class c implements a {
        private final GestureDetector wW;

        public c(Context context, OnGestureListener onGestureListener, Handler handler) {
            this.wW = new GestureDetector(context, onGestureListener, null);
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            return this.wW.onTouchEvent(motionEvent);
        }
    }

    public e(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, (byte) 0);
    }

    private e(Context context, OnGestureListener onGestureListener, byte b) {
        if (VERSION.SDK_INT > 17) {
            this.wy = new c(context, onGestureListener, null);
        } else {
            this.wy = new b(context, onGestureListener, null);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.wy.onTouchEvent(motionEvent);
    }
}
