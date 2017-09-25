package com.tencent.mm.ui.widget;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public final class a extends i implements OnGestureListener, OnTouchListener {
    private int iE;
    private int iXI;
    private int iXJ;
    private int kSF;
    private GestureDetector wW;
    public float wsA = 500.0f;
    private int wsB;
    private int wsC;
    private int wsD;
    private boolean wsE;
    public DragSortListView wsF;
    public int wsG;
    private OnGestureListener wsH = new SimpleOnGestureListener(this) {
        final /* synthetic */ a wsI;

        {
            this.wsI = r1;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (this.wsI.wsq && this.wsI.wsr) {
                int width = this.wsI.wsF.getWidth() / 5;
                if (f > this.wsI.wsA) {
                    if (this.wsI.wsG > (-width)) {
                        this.wsI.wsF.au(f);
                    }
                } else if (f < (-this.wsI.wsA) && this.wsI.wsG < width) {
                    this.wsI.wsF.au(f);
                }
                this.wsI.wsr = false;
            }
            return false;
        }
    };
    private int wso = 0;
    boolean wsp = true;
    public boolean wsq = false;
    public boolean wsr = false;
    private GestureDetector wss;
    private int wst = -1;
    private int wsu = -1;
    private int wsv = -1;
    private int[] wsw = new int[2];
    private int wsx;
    private int wsy;
    private boolean wsz = false;

    public a(DragSortListView dragSortListView, int i, int i2, int i3, int i4, int i5) {
        super(dragSortListView);
        this.wsF = dragSortListView;
        this.wW = new GestureDetector(dragSortListView.getContext(), this);
        this.wss = new GestureDetector(dragSortListView.getContext(), this.wsH);
        this.wss.setIsLongpressEnabled(false);
        this.iE = ViewConfiguration.get(dragSortListView.getContext()).getScaledTouchSlop();
        this.wsB = i;
        this.wsC = i4;
        this.wsD = i5;
        this.kSF = i3;
        this.wso = i2;
    }

    private boolean Y(int i, int i2, int i3) {
        int i4;
        int i5;
        boolean z = false;
        if (!this.wsp || this.wsr) {
            i4 = 0;
        } else {
            i4 = 12;
        }
        if (this.wsq && this.wsr) {
            i5 = (i4 | 1) | 2;
        } else {
            i5 = i4;
        }
        DragSortListView dragSortListView = this.wsF;
        int headerViewsCount = i - this.wsF.getHeaderViewsCount();
        if (dragSortListView.wty && dragSortListView.wtz != null) {
            View Cp = dragSortListView.wtz.Cp(headerViewsCount);
            if (Cp != null) {
                z = dragSortListView.a(headerViewsCount, Cp, i5, i2, i3);
            }
        }
        this.wsz = z;
        return this.wsz;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.wsF.wtc && !this.wsF.wtP) {
            this.wW.onTouchEvent(motionEvent);
            if (this.wsq && this.wsz && this.kSF == 1) {
                this.wss.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.iXI = (int) motionEvent.getX();
                    this.iXJ = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.wsq && this.wsr) {
                        int i;
                        if (this.wsG >= 0) {
                            i = this.wsG;
                        } else {
                            i = -this.wsG;
                        }
                        if (i > this.wsF.getWidth() / 2) {
                            this.wsF.au(0.0f);
                            break;
                        }
                    }
                    break;
                case 3:
                    break;
                default:
                    break;
            }
            this.wsr = false;
            this.wsz = false;
        }
        return false;
    }

    public final void e(Point point) {
        if (this.wsq && this.wsr) {
            this.wsG = point.x;
        }
    }

    private int k(MotionEvent motionEvent, int i) {
        int pointToPosition = this.wsF.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.wsF.getHeaderViewsCount();
        int footerViewsCount = this.wsF.getFooterViewsCount();
        int count = this.wsF.getCount();
        if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
            View childAt = this.wsF.getChildAt(pointToPosition - this.wsF.getFirstVisiblePosition());
            count = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            View findViewById = i == 0 ? childAt : childAt.findViewById(i);
            if (findViewById != null) {
                findViewById.getLocationOnScreen(this.wsw);
                if (count > this.wsw[0] && rawY > this.wsw[1] && count < this.wsw[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.wsw[1]) {
                        this.wsx = childAt.getLeft();
                        this.wsy = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        int i = -1;
        if (this.wsq && this.kSF == 0) {
            this.wsv = k(motionEvent, this.wsC);
        }
        this.wst = k(motionEvent, this.wsB);
        if (this.wst != -1 && this.wso == 0) {
            Y(this.wst, ((int) motionEvent.getX()) - this.wsx, ((int) motionEvent.getY()) - this.wsy);
        }
        this.wsr = false;
        this.wsE = true;
        this.wsG = 0;
        if (this.kSF == 1) {
            i = k(motionEvent, this.wsD);
        }
        this.wsu = i;
        return true;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int x2 = (int) motionEvent2.getX();
        int y2 = (int) motionEvent2.getY();
        int i = x2 - this.wsx;
        int i2 = y2 - this.wsy;
        if (!(!this.wsE || this.wsz || (this.wst == -1 && this.wsu == -1))) {
            if (this.wst != -1) {
                if (this.wso == 1 && Math.abs(y2 - y) > this.iE && this.wsp) {
                    Y(this.wst, i, i2);
                } else if (this.wso != 0 && Math.abs(x2 - x) > this.iE && this.wsq) {
                    this.wsr = true;
                    Y(this.wsu, i, i2);
                }
            } else if (this.wsu != -1) {
                if (Math.abs(x2 - x) > this.iE && this.wsq) {
                    this.wsr = true;
                    Y(this.wsu, i, i2);
                } else if (Math.abs(y2 - y) > this.iE) {
                    this.wsE = false;
                }
            }
        }
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        if (this.wst != -1 && this.wso == 2) {
            this.wsF.performHapticFeedback(0);
            Y(this.wst, this.iXI - this.wsx, this.iXJ - this.wsy);
        }
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.wsq && this.kSF == 0 && this.wsv != -1) {
            DragSortListView dragSortListView = this.wsF;
            int headerViewsCount = this.wsv - this.wsF.getHeaderViewsCount();
            dragSortListView.wtN = false;
            dragSortListView.l(headerViewsCount, 0.0f);
        }
        return true;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }
}
