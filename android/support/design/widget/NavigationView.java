package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.design.internal.NavigationMenuView;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.design.internal.b;
import android.support.v4.os.c;
import android.support.v4.view.z;
import android.support.v7.view.g;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.l;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] dN = new int[]{16842912};
    private static final int[] iK = new int[]{-16842910};
    private final android.support.design.internal.a iL;
    private final b iM;
    private a iN;
    private int iO;
    private MenuInflater iP;

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = android.support.v4.os.b.a(new c<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        });
        public Bundle iR;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            this.iR = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.iR);
        }
    }

    public interface a {
        boolean af();
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        int resourceId;
        boolean z;
        super(context, attributeSet, i);
        this.iM = new b();
        t.g(context);
        this.iL = new android.support.design.internal.a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.co, i, h.aR);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(i.cp));
        if (obtainStyledAttributes.hasValue(i.ct)) {
            z.g((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(i.ct, 0));
        }
        z.a((View) this, obtainStyledAttributes.getBoolean(i.cq, false));
        this.iO = obtainStyledAttributes.getDimensionPixelSize(i.cs, 0);
        if (obtainStyledAttributes.hasValue(i.cw)) {
            colorStateList = obtainStyledAttributes.getColorStateList(i.cw);
        } else {
            colorStateList = v(16842808);
        }
        if (obtainStyledAttributes.hasValue(i.cx)) {
            resourceId = obtainStyledAttributes.getResourceId(i.cx, 0);
            z = true;
        } else {
            resourceId = 0;
            z = false;
        }
        ColorStateList colorStateList2 = null;
        if (obtainStyledAttributes.hasValue(i.cy)) {
            colorStateList2 = obtainStyledAttributes.getColorStateList(i.cy);
        }
        if (!z && r5 == null) {
            colorStateList2 = v(16842806);
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(i.cv);
        this.iL.a(new android.support.v7.view.menu.f.a(this) {
            final /* synthetic */ NavigationView iQ;

            {
                this.iQ = r1;
            }

            public final boolean a(f fVar, MenuItem menuItem) {
                return this.iQ.iN != null && this.iQ.iN.af();
            }

            public final void b(f fVar) {
            }
        });
        this.iM.dX = 1;
        this.iM.a(context, this.iL);
        this.iM.a(colorStateList);
        if (z) {
            this.iM.e(resourceId);
        }
        this.iM.b(colorStateList2);
        this.iM.a(drawable);
        this.iL.a(this.iM);
        b bVar = this.iM;
        if (bVar.dT == null) {
            bVar.dT = (NavigationMenuView) bVar.dZ.inflate(android.support.design.a.f.aF, this, false);
            if (bVar.dY == null) {
                bVar.dY = new b(bVar);
            }
            bVar.dU = (LinearLayout) bVar.dZ.inflate(android.support.design.a.f.aC, bVar.dT, false);
            bVar.dT.a(bVar.dY);
        }
        addView(bVar.dT);
        if (obtainStyledAttributes.hasValue(i.cz)) {
            int resourceId2 = obtainStyledAttributes.getResourceId(i.cz, 0);
            this.iM.g(true);
            if (this.iP == null) {
                this.iP = new g(getContext());
            }
            this.iP.inflate(resourceId2, this.iL);
            this.iM.g(false);
            this.iM.f(false);
        }
        if (obtainStyledAttributes.hasValue(i.cu)) {
            resourceId2 = obtainStyledAttributes.getResourceId(i.cu, 0);
            bVar = this.iM;
            bVar.dU.addView(bVar.dZ.inflate(resourceId2, bVar.dU, false));
            bVar.dT.setPadding(0, 0, 0, bVar.dT.getPaddingBottom());
        }
        obtainStyledAttributes.recycle();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.iR = new Bundle();
        this.iL.dispatchSaveInstanceState(savedState.iR);
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            f fVar = this.iL;
            SparseArray sparseParcelableArray = savedState.iR.getSparseParcelableArray("android:menu:presenters");
            if (sparseParcelableArray != null && !fVar.QH.isEmpty()) {
                Iterator it = fVar.QH.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    l lVar = (l) weakReference.get();
                    if (lVar == null) {
                        fVar.QH.remove(weakReference);
                    } else {
                        int id = lVar.getId();
                        if (id > 0) {
                            Parcelable parcelable2 = (Parcelable) sparseParcelableArray.get(id);
                            if (parcelable2 != null) {
                                lVar.onRestoreInstanceState(parcelable2);
                            }
                        }
                    }
                }
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void onMeasure(int i, int i2) {
        switch (MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                i = MeasureSpec.makeMeasureSpec(Math.min(MeasureSpec.getSize(i), this.iO), 1073741824);
                break;
            case 0:
                i = MeasureSpec.makeMeasureSpec(this.iO, 1073741824);
                break;
        }
        super.onMeasure(i, i2);
    }

    protected final void a(Rect rect) {
        b bVar = this.iM;
        int i = rect.top;
        if (bVar.ee != i) {
            bVar.ee = i;
            if (bVar.dU.getChildCount() == 0) {
                bVar.dT.setPadding(0, bVar.ee, 0, bVar.dT.getPaddingBottom());
            }
        }
    }

    private ColorStateList v(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = getResources().getColorStateList(typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(android.support.design.a.b.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        return new ColorStateList(new int[][]{iK, dN, EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iK, defaultColor), i2, defaultColor});
    }
}
