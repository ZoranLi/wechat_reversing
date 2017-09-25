package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.w;

public class TouchInterceptorListView extends ListView {
    private int RQ;
    private Rect eq = new Rect();
    private final int iE;
    private GestureDetector iXs;
    private int kIe;
    private a kSA;
    private b kSB;
    private c kSC;
    private int kSD;
    private int kSE;
    private int kSF = -1;
    private Bitmap kSG;
    private int kSH;
    private int kSI;
    private Drawable kSJ;
    private int kSK = 0;
    private ImageView kSr;
    private WindowManager kSs;
    private LayoutParams kSt;
    private int kSu;
    private int kSv;
    private int kSw;
    private int kSx;
    private int kSy;
    private int kSz;

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    public TouchInterceptorListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iE = ViewConfiguration.get(context).getScaledTouchSlop();
        Resources resources = getResources();
        this.kIe = resources.getDimensionPixelSize(R.f.aZE) + 1;
        this.kSI = this.kIe / 2;
        this.kSH = this.kIe * 2;
        this.kSK = resources.getDimensionPixelOffset(R.f.aZH);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.kSC != null && this.iXs == null && this.kSF == 0) {
            this.iXs = new GestureDetector(getContext(), new SimpleOnGestureListener(this) {
                final /* synthetic */ TouchInterceptorListView kSL;

                {
                    this.kSL = r1;
                }

                public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    if (this.kSL.kSr == null) {
                        return false;
                    }
                    if (f > 1000.0f) {
                        Rect b = this.kSL.eq;
                        this.kSL.kSr.getDrawingRect(b);
                        if (motionEvent2.getX() > ((float) ((b.right * 2) / 3))) {
                            this.kSL.anI();
                            this.kSL.dx(true);
                        }
                    }
                    return true;
                }
            });
        }
        if (!(this.kSA == null && this.kSB == null)) {
            switch (motionEvent.getAction()) {
                case 0:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int pointToPosition = pointToPosition(x, y);
                    if (pointToPosition != -1) {
                        ViewGroup viewGroup = (ViewGroup) getChildAt(pointToPosition - getFirstVisiblePosition());
                        this.kSw = x - viewGroup.getLeft();
                        this.kSx = y - viewGroup.getTop();
                        this.kSy = ((int) motionEvent.getRawX()) - x;
                        this.kSz = ((int) motionEvent.getRawY()) - y;
                        if (x >= this.kSK) {
                            anI();
                            break;
                        }
                        viewGroup.setDrawingCacheEnabled(true);
                        Bitmap createBitmap = Bitmap.createBitmap(viewGroup.getDrawingCache());
                        anI();
                        this.kSt = new LayoutParams();
                        this.kSt.gravity = 49;
                        this.kSt.x = (x - this.kSw) + this.kSy;
                        this.kSt.y = (y - this.kSx) + this.kSz;
                        this.kSt.height = -2;
                        this.kSt.width = -2;
                        this.kSt.flags = 920;
                        this.kSt.format = -3;
                        this.kSt.windowAnimations = 0;
                        Context context = getContext();
                        View imageView = new ImageView(context);
                        imageView.setBackgroundColor(context.getResources().getColor(R.e.white));
                        imageView.setBackgroundResource(R.g.beV);
                        imageView.setPadding(0, 0, 0, 0);
                        imageView.setImageBitmap(createBitmap);
                        this.kSG = createBitmap;
                        this.kSs = (WindowManager) context.getSystemService("window");
                        this.kSs.addView(imageView, this.kSt);
                        this.kSr = imageView;
                        this.kSu = pointToPosition;
                        this.kSv = this.kSu;
                        this.RQ = getHeight();
                        int i = this.iE;
                        this.kSD = Math.min(y - i, this.RQ / 3);
                        this.kSE = Math.max(i + y, (this.RQ * 2) / 3);
                        return false;
                    }
                    break;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private int bR(int i, int i2) {
        int bR;
        if (i2 < 0) {
            bR = bR(i, this.kIe + i2);
            if (bR > 0) {
                return bR - 1;
            }
        }
        Rect rect = this.eq;
        for (bR = getChildCount() - 1; bR >= 0; bR--) {
            getChildAt(bR).getHitRect(rect);
            if (rect.contains(i, i2)) {
                return bR + getFirstVisiblePosition();
            }
        }
        return -1;
    }

    private void dx(boolean z) {
        int i = 0;
        while (true) {
            View childAt = getChildAt(i);
            if (childAt == null) {
                if (z) {
                    int firstVisiblePosition = getFirstVisiblePosition();
                    int top = getChildAt(0).getTop();
                    setAdapter(getAdapter());
                    setSelectionFromTop(firstVisiblePosition, top);
                }
                try {
                    layoutChildren();
                    childAt = getChildAt(i);
                } catch (IllegalStateException e) {
                }
                if (childAt == null) {
                    return;
                }
            }
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.height = this.kIe;
            childAt.setLayoutParams(layoutParams);
            childAt.setVisibility(0);
            i++;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 4;
        int i2 = 0;
        if (this.iXs != null) {
            this.iXs.onTouchEvent(motionEvent);
        }
        if ((this.kSA == null && this.kSB == null) || this.kSr == null) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        switch (action) {
            case 0:
            case 2:
                int width;
                int width2;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (this.kSF == 1) {
                    float f = 1.0f;
                    width = this.kSr.getWidth();
                    if (x > width / 2) {
                        f = ((float) (width - x)) / ((float) (width / 2));
                    }
                    this.kSt.alpha = f;
                }
                if (this.kSF == 0 || this.kSF == 2) {
                    this.kSt.x = (x - this.kSw) + this.kSy;
                } else {
                    this.kSt.x = 0;
                }
                this.kSt.y = (y - this.kSx) + this.kSz;
                this.kSs.updateViewLayout(this.kSr, this.kSt);
                if (this.kSJ != null) {
                    width2 = this.kSr.getWidth();
                    if (y > (getHeight() * 3) / 4) {
                        this.kSJ.setLevel(2);
                    } else if (width2 <= 0 || x <= width2 / 4) {
                        this.kSJ.setLevel(0);
                    } else {
                        this.kSJ.setLevel(1);
                    }
                }
                x = (y - this.kSx) - this.kSI;
                width2 = bR(0, x);
                if (width2 >= 0) {
                    if (width2 <= this.kSv) {
                        width2++;
                    }
                } else if (x < 0) {
                    width2 = 0;
                }
                if (width2 < 0) {
                    return true;
                }
                if (action == 0 || width2 != this.kSu) {
                    this.kSu = width2;
                    w.d("MicroMsg.emoji.TouchInterceptorListView", "doExpansion mDragPos:%d mSrcDragPos:%d", new Object[]{Integer.valueOf(this.kSu), Integer.valueOf(this.kSv)});
                    w.d("MicroMsg.emoji.TouchInterceptorListView", "getFirstVisiblePosition:%d", new Object[]{Integer.valueOf(getFirstVisiblePosition())});
                    w.d("MicroMsg.emoji.TouchInterceptorListView", "getHeaderViewsCount:%d", new Object[]{Integer.valueOf(getHeaderViewsCount())});
                    width = this.kSu - getFirstVisiblePosition();
                    int headerViewsCount = getHeaderViewsCount();
                    View childAt = getChildAt(this.kSv - getFirstVisiblePosition());
                    x = 0;
                    while (true) {
                        View childAt2 = getChildAt(x);
                        if (childAt2 != null) {
                            width2 = this.kIe;
                            if (this.kSu >= headerViewsCount || x != headerViewsCount) {
                                if (childAt2.equals(childAt)) {
                                    if (this.kSu == this.kSv || getPositionForView(childAt2) == getCount()) {
                                        width2 = this.kIe;
                                        w.d("MicroMsg.emoji.TouchInterceptorListView", "2. visibility = View.INVISIBLE");
                                        action = width2;
                                        width2 = 4;
                                    } else {
                                        w.d("MicroMsg.emoji.TouchInterceptorListView", "2. height = 1");
                                        width2 = 0;
                                        action = 1;
                                    }
                                } else if (x != width) {
                                    w.d("MicroMsg.emoji.TouchInterceptorListView", "4");
                                    action = width2;
                                    width2 = 0;
                                } else if (this.kSu < headerViewsCount || this.kSu >= getCount()) {
                                    w.d("MicroMsg.emoji.TouchInterceptorListView", "3. ");
                                    action = width2;
                                    width2 = 0;
                                } else {
                                    width2 = this.kSH;
                                    w.d("MicroMsg.emoji.TouchInterceptorListView", "3. height = mItemHeightExpanded;");
                                    action = width2;
                                    width2 = 0;
                                }
                            } else if (childAt2.equals(childAt)) {
                                w.d("MicroMsg.emoji.TouchInterceptorListView", "1. visibility = View.INVISIBLE");
                                action = width2;
                                width2 = 4;
                            } else {
                                width2 = this.kSH;
                                w.d("MicroMsg.emoji.TouchInterceptorListView", "1. height = mItemHeightExpanded");
                                action = width2;
                                width2 = 0;
                            }
                            ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                            layoutParams.height = action;
                            childAt2.setLayoutParams(layoutParams);
                            childAt2.setVisibility(width2);
                            x++;
                        }
                    }
                }
                if (y >= this.RQ / 3) {
                    this.kSD = this.RQ / 3;
                }
                if (y <= (this.RQ * 2) / 3) {
                    this.kSE = (this.RQ * 2) / 3;
                }
                if (y > this.kSE) {
                    if (getLastVisiblePosition() < getCount() - 1) {
                        if (y > (this.RQ + this.kSE) / 2) {
                            i = 16;
                        }
                        i2 = i;
                    } else {
                        i2 = 1;
                    }
                } else if (y < this.kSD) {
                    width2 = y < this.kSD / 2 ? -16 : -4;
                    if (getFirstVisiblePosition() != 0 || getChildAt(0).getTop() < getPaddingTop()) {
                        i2 = width2;
                    }
                }
                if (i2 == 0 || f.ep(8)) {
                    return true;
                }
                smoothScrollBy(i2, 30);
                return true;
            case 1:
            case 3:
                Rect rect = this.eq;
                this.kSr.getDrawingRect(rect);
                anI();
                if (this.kSF != 1 || motionEvent.getX() <= ((float) ((rect.right * 3) / 4))) {
                    if (this.kSB != null && this.kSu >= 0) {
                        getCount();
                    }
                    dx(false);
                    return true;
                }
                dx(true);
                return true;
            default:
                return true;
        }
    }

    private void anI() {
        if (this.kSr != null) {
            this.kSr.setVisibility(8);
            ((WindowManager) getContext().getSystemService("window")).removeView(this.kSr);
            this.kSr.setImageDrawable(null);
            this.kSr = null;
        }
        if (this.kSG != null) {
            w.i("MicroMsg.emoji.TouchInterceptorListView", "bitmap recycle %s", new Object[]{this.kSG});
            this.kSG.recycle();
            this.kSG = null;
        }
        if (this.kSJ != null) {
            this.kSJ.setLevel(0);
        }
    }
}
