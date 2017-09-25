package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.support.v7.a.a.k;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ListPopupWindow;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView extends AppCompatTextView implements android.support.v7.view.menu.m.a, android.support.v7.widget.ActionMenuView.a, OnClickListener, OnLongClickListener {
    public android.support.v7.view.menu.f.b PI;
    private android.support.v7.widget.ListPopupWindow.b PJ;
    public b PK;
    private boolean PL;
    private boolean PM;
    private int PN;
    private int PO;
    private int PP;
    private h dR;
    private Drawable jQ;
    private CharSequence uI;

    public static abstract class b {
        public abstract ListPopupWindow do();
    }

    private class a extends android.support.v7.widget.ListPopupWindow.b {
        final /* synthetic */ ActionMenuItemView PQ;

        public a(ActionMenuItemView actionMenuItemView) {
            this.PQ = actionMenuItemView;
            super(actionMenuItemView);
        }

        public final ListPopupWindow do() {
            if (this.PQ.PK != null) {
                return this.PQ.PK.do();
            }
            return null;
        }

        protected final boolean dp() {
            if (this.PQ.PI == null || !this.PQ.PI.f(this.PQ.dR)) {
                return false;
            }
            ListPopupWindow listPopupWindow = do();
            if (listPopupWindow == null || !listPopupWindow.XU.isShowing()) {
                return false;
            }
            return true;
        }
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.PL = resources.getBoolean(android.support.v7.a.a.b.IN);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.aX, i, 0);
        this.PN = obtainStyledAttributes.getDimensionPixelSize(k.Lq, 0);
        obtainStyledAttributes.recycle();
        this.PP = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.PO = -1;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.PL = getContext().getResources().getBoolean(android.support.v7.a.a.b.IN);
        dl();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.PO = i;
        super.setPadding(i, i2, i3, i4);
    }

    public final h z() {
        return this.dR;
    }

    public final void a(h hVar) {
        this.dR = hVar;
        Drawable icon = hVar.getIcon();
        this.jQ = icon;
        if (icon != null) {
            float f;
            int intrinsicWidth = icon.getIntrinsicWidth();
            int intrinsicHeight = icon.getIntrinsicHeight();
            if (intrinsicWidth > this.PP) {
                f = ((float) this.PP) / ((float) intrinsicWidth);
                intrinsicWidth = this.PP;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.PP) {
                f = ((float) this.PP) / ((float) intrinsicHeight);
                intrinsicHeight = this.PP;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            icon.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(icon, null, null, null);
        dl();
        this.uI = hVar.a((android.support.v7.view.menu.m.a) this);
        setContentDescription(this.uI);
        dl();
        setId(hVar.getItemId());
        setVisibility(hVar.isVisible() ? 0 : 8);
        setEnabled(hVar.isEnabled());
        if (hVar.hasSubMenu() && this.PJ == null) {
            this.PJ = new a(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dR.hasSubMenu() && this.PJ != null && this.PJ.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        if (this.PI != null) {
            this.PI.f(this.dR);
        }
    }

    public final boolean A() {
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dl() {
        /*
        r5 = this;
        r1 = 1;
        r2 = 0;
        r0 = r5.uI;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x002d;
    L_0x000a:
        r0 = r1;
    L_0x000b:
        r3 = r5.jQ;
        if (r3 == 0) goto L_0x0023;
    L_0x000f:
        r3 = r5.dR;
        r3 = r3.QP;
        r3 = r3 & 4;
        r4 = 4;
        if (r3 != r4) goto L_0x002f;
    L_0x0018:
        r3 = r1;
    L_0x0019:
        if (r3 == 0) goto L_0x0024;
    L_0x001b:
        r3 = r5.PL;
        if (r3 != 0) goto L_0x0023;
    L_0x001f:
        r3 = r5.PM;
        if (r3 == 0) goto L_0x0024;
    L_0x0023:
        r2 = r1;
    L_0x0024:
        r0 = r0 & r2;
        if (r0 == 0) goto L_0x0031;
    L_0x0027:
        r0 = r5.uI;
    L_0x0029:
        r5.setText(r0);
        return;
    L_0x002d:
        r0 = r2;
        goto L_0x000b;
    L_0x002f:
        r3 = r2;
        goto L_0x0019;
    L_0x0031:
        r0 = 0;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.menu.ActionMenuItemView.dl():void");
    }

    public final boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean dm() {
        return hasText() && this.dR.getIcon() == null;
    }

    public final boolean dn() {
        return hasText();
    }

    public boolean onLongClick(View view) {
        if (hasText()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        width = (width / 2) + iArr[0];
        if (z.J(view) == 0) {
            width = context.getResources().getDisplayMetrics().widthPixels - width;
        }
        Toast makeText = Toast.makeText(context, this.dR.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, width, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        boolean hasText = hasText();
        if (hasText && this.PO >= 0) {
            super.setPadding(this.PO, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == Integer.MIN_VALUE ? Math.min(size, this.PN) : this.PN;
        if (mode != 1073741824 && this.PN > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!hasText && this.jQ != null) {
            super.setPadding((getMeasuredWidth() - this.jQ.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }
}
