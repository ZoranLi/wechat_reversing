package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class ListViewCompat extends ListView {
    private static final int[] YG = new int[]{0};
    final Rect YH;
    int YI;
    int YJ;
    int YK;
    int YL;
    protected int YM;
    private Field YN;
    private a YO;

    private static class a extends android.support.v7.c.a.a {
        boolean AK = true;

        public a(Drawable drawable) {
            super(drawable);
        }

        public final boolean setState(int[] iArr) {
            if (this.AK) {
                return super.setState(iArr);
            }
            return false;
        }

        public final void draw(Canvas canvas) {
            if (this.AK) {
                super.draw(canvas);
            }
        }

        public final void setHotspot(float f, float f2) {
            if (this.AK) {
                super.setHotspot(f, f2);
            }
        }

        public final void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.AK) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public final boolean setVisible(boolean z, boolean z2) {
            if (this.AK) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    public ListViewCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListViewCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.YH = new Rect();
        this.YI = 0;
        this.YJ = 0;
        this.YK = 0;
        this.YL = 0;
        try {
            this.YN = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.YN.setAccessible(true);
        } catch (NoSuchFieldException e) {
        }
    }

    public void setSelector(Drawable drawable) {
        this.YO = drawable != null ? new a(drawable) : null;
        super.setSelector(this.YO);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.YI = rect.left;
        this.YJ = rect.top;
        this.YK = rect.right;
        this.YL = rect.bottom;
    }

    protected void drawableStateChanged() {
        boolean z = true;
        super.drawableStateChanged();
        Q(true);
        Drawable selector = getSelector();
        if (selector != null) {
            if (!(fg() && isPressed())) {
                z = false;
            }
            if (z) {
                selector.setState(getDrawableState());
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        if (!this.YH.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.YH);
                selector.draw(canvas);
            }
        }
        super.dispatchDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.YM = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected boolean fg() {
        return false;
    }

    void a(int i, View view) {
        Rect rect = this.YH;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.YI;
        rect.top -= this.YJ;
        rect.right += this.YK;
        rect.bottom += this.YL;
        try {
            boolean z = this.YN.getBoolean(this);
            if (view.isEnabled() != z) {
                this.YN.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
        }
    }

    public final int L(int i, int i2) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingBottom += listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i3 = 0;
        View view = null;
        for (int i4 = 0; i4 < count; i4++) {
            View view2;
            listPaddingTop = adapter.getItemViewType(i4);
            if (listPaddingTop != i3) {
                i3 = listPaddingTop;
                view2 = null;
            } else {
                view2 = view;
            }
            view = adapter.getView(i4, view2, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                listPaddingTop = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                listPaddingTop = MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, listPaddingTop);
            view.forceLayout();
            if (i4 > 0) {
                listPaddingTop = listPaddingBottom + dividerHeight;
            } else {
                listPaddingTop = listPaddingBottom;
            }
            listPaddingBottom = view.getMeasuredHeight() + listPaddingTop;
            if (listPaddingBottom >= i2) {
                return i2;
            }
        }
        return listPaddingBottom;
    }

    protected final void Q(boolean z) {
        if (this.YO != null) {
            this.YO.AK = z;
        }
    }
}
