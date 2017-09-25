package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.x;
import android.support.v4.view.z;
import android.support.v7.a.a.h;
import android.support.v7.a.a.k;
import android.support.v7.view.d;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class AppCompatSpinner extends Spinner implements x {
    private static final boolean UZ;
    private static final boolean Va;
    private static final int[] Vb = new int[]{16843505};
    private android.support.v7.widget.ListPopupWindow.b PJ;
    private Context Rx;
    private h Um;
    private f Un;
    private SpinnerAdapter Vc;
    private boolean Vd;
    private b Ve;
    private int Vf;
    private final Rect eq;

    private static class a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter Vi;
        private ListAdapter Vj;

        public a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.Vi = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.Vj = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && AppCompatSpinner.UZ && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            }
        }

        public final int getCount() {
            return this.Vi == null ? 0 : this.Vi.getCount();
        }

        public final Object getItem(int i) {
            return this.Vi == null ? null : this.Vi.getItem(i);
        }

        public final long getItemId(int i) {
            return this.Vi == null ? -1 : this.Vi.getItemId(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return this.Vi == null ? null : this.Vi.getDropDownView(i, view, viewGroup);
        }

        public final boolean hasStableIds() {
            return this.Vi != null && this.Vi.hasStableIds();
        }

        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.Vi != null) {
                this.Vi.registerDataSetObserver(dataSetObserver);
            }
        }

        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.Vi != null) {
                this.Vi.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.Vj;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public final boolean isEnabled(int i) {
            ListAdapter listAdapter = this.Vj;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public final int getItemViewType(int i) {
            return 0;
        }

        public final int getViewTypeCount() {
            return 1;
        }

        public final boolean isEmpty() {
            return getCount() == 0;
        }
    }

    private class b extends ListPopupWindow {
        public ListAdapter FA;
        final /* synthetic */ AppCompatSpinner Vh;
        CharSequence Vk;
        final Rect Vl = new Rect();

        public b(final AppCompatSpinner appCompatSpinner, Context context, AttributeSet attributeSet, int i) {
            this.Vh = appCompatSpinner;
            super(context, attributeSet, i);
            this.Yg = appCompatSpinner;
            fe();
            this.Yf = 0;
            this.Yi = new OnItemClickListener(this) {
                final /* synthetic */ b Vn;

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.Vn.Vh.setSelection(i);
                    if (this.Vn.Vh.getOnItemClickListener() != null) {
                        this.Vn.Vh.performItemClick(view, i, this.Vn.FA.getItemId(i));
                    }
                    this.Vn.dismiss();
                }
            };
        }

        public final void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.FA = listAdapter;
        }

        final void eA() {
            int i;
            int i2;
            Drawable background = this.XU.getBackground();
            if (background != null) {
                background.getPadding(this.Vh.eq);
                i = at.bw(this.Vh) ? this.Vh.eq.right : -this.Vh.eq.left;
            } else {
                Rect b = this.Vh.eq;
                this.Vh.eq.right = 0;
                b.left = 0;
                i = 0;
            }
            int paddingLeft = this.Vh.getPaddingLeft();
            int paddingRight = this.Vh.getPaddingRight();
            int width = this.Vh.getWidth();
            if (this.Vh.Vf == -2) {
                int a = this.Vh.a((SpinnerAdapter) this.FA, this.XU.getBackground());
                i2 = (this.Vh.getContext().getResources().getDisplayMetrics().widthPixels - this.Vh.eq.left) - this.Vh.eq.right;
                if (a <= i2) {
                    i2 = a;
                }
                setContentWidth(Math.max(i2, (width - paddingLeft) - paddingRight));
            } else if (this.Vh.Vf == -1) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(this.Vh.Vf);
            }
            if (at.bw(this.Vh)) {
                i2 = ((width - paddingRight) - this.Vf) + i;
            } else {
                i2 = i + paddingLeft;
            }
            this.XX = i2;
        }

        public final void show() {
            boolean isShowing = this.XU.isShowing();
            eA();
            ff();
            super.show();
            this.XV.setChoiceMode(1);
            int selectedItemPosition = this.Vh.getSelectedItemPosition();
            a aVar = this.XV;
            if (this.XU.isShowing() && aVar != null) {
                aVar.Yr = false;
                aVar.setSelection(selectedItemPosition);
                if (VERSION.SDK_INT >= 11 && aVar.getChoiceMode() != 0) {
                    aVar.setItemChecked(selectedItemPosition, true);
                }
            }
            if (!isShowing) {
                ViewTreeObserver viewTreeObserver = this.Vh.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final OnGlobalLayoutListener anonymousClass2 = new OnGlobalLayoutListener(this) {
                        final /* synthetic */ b Vn;

                        {
                            this.Vn = r1;
                        }

                        public final void onGlobalLayout() {
                            b bVar = this.Vn;
                            View view = this.Vn.Vh;
                            Object obj = (z.al(view) && view.getGlobalVisibleRect(bVar.Vl)) ? 1 : null;
                            if (obj == null) {
                                this.Vn.dismiss();
                                return;
                            }
                            this.Vn.eA();
                            super.show();
                        }
                    };
                    viewTreeObserver.addOnGlobalLayoutListener(anonymousClass2);
                    setOnDismissListener(new OnDismissListener(this) {
                        final /* synthetic */ b Vn;

                        public final void onDismiss() {
                            ViewTreeObserver viewTreeObserver = this.Vn.Vh.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(anonymousClass2);
                            }
                        }
                    });
                }
            }
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        UZ = z;
        if (VERSION.SDK_INT >= 16) {
            z = true;
        } else {
            z = false;
        }
        Va = z;
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, (byte) 0);
    }

    private AppCompatSpinner(Context context, AttributeSet attributeSet, int i, byte b) {
        this(context, attributeSet, i, -1);
    }

    private AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        Context dVar;
        AppCompatSpinner appCompatSpinner;
        TypedArray obtainStyledAttributes;
        final b bVar;
        ap a;
        CharSequence[] textArray;
        SpinnerAdapter arrayAdapter;
        Throwable th;
        TypedArray typedArray = null;
        super(context, attributeSet, i);
        this.eq = new Rect();
        ap a2 = ap.a(context, attributeSet, k.cM, i);
        this.Um = h.ey();
        this.Un = new f(this, this.Um);
        int resourceId = a2.getResourceId(k.Nh, 0);
        if (resourceId != 0) {
            dVar = new d(context, resourceId);
            appCompatSpinner = this;
        } else if (UZ) {
            dVar = null;
            appCompatSpinner = this;
        } else {
            dVar = context;
            appCompatSpinner = this;
        }
        appCompatSpinner.Rx = dVar;
        if (this.Rx != null) {
            if (VERSION.SDK_INT >= 11) {
                try {
                    obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Vb, i, 0);
                    try {
                        if (obtainStyledAttributes.hasValue(0)) {
                            i2 = obtainStyledAttributes.getInt(0, 0);
                        }
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                    } catch (Exception e) {
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        if (i2 == 1) {
                            bVar = new b(this, this.Rx, attributeSet, i);
                            a = ap.a(this.Rx, attributeSet, k.cM, i);
                            this.Vf = a.getLayoutDimension(k.Nd, -2);
                            bVar.setBackgroundDrawable(a.getDrawable(k.Nf));
                            bVar.Vk = a2.aeG.getString(k.Ng);
                            a.aeG.recycle();
                            this.Ve = bVar;
                            this.PJ = new android.support.v7.widget.ListPopupWindow.b(this, this) {
                                final /* synthetic */ AppCompatSpinner Vh;

                                public final ListPopupWindow do() {
                                    return bVar;
                                }

                                public final boolean dp() {
                                    if (!this.Vh.Ve.XU.isShowing()) {
                                        this.Vh.Ve.show();
                                    }
                                    return true;
                                }
                            };
                        }
                        textArray = a2.aeG.getTextArray(k.Ne);
                        if (textArray != null) {
                            arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
                            arrayAdapter.setDropDownViewResource(h.KR);
                            setAdapter(arrayAdapter);
                        }
                        a2.aeG.recycle();
                        this.Vd = true;
                        if (this.Vc != null) {
                            setAdapter(this.Vc);
                            this.Vc = null;
                        }
                        this.Un.a(attributeSet, i);
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        typedArray = obtainStyledAttributes;
                        th = th3;
                        if (typedArray != null) {
                            typedArray.recycle();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    obtainStyledAttributes = null;
                    if (obtainStyledAttributes != null) {
                        obtainStyledAttributes.recycle();
                    }
                    if (i2 == 1) {
                        bVar = new b(this, this.Rx, attributeSet, i);
                        a = ap.a(this.Rx, attributeSet, k.cM, i);
                        this.Vf = a.getLayoutDimension(k.Nd, -2);
                        bVar.setBackgroundDrawable(a.getDrawable(k.Nf));
                        bVar.Vk = a2.aeG.getString(k.Ng);
                        a.aeG.recycle();
                        this.Ve = bVar;
                        this.PJ = /* anonymous class already generated */;
                    }
                    textArray = a2.aeG.getTextArray(k.Ne);
                    if (textArray != null) {
                        arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
                        arrayAdapter.setDropDownViewResource(h.KR);
                        setAdapter(arrayAdapter);
                    }
                    a2.aeG.recycle();
                    this.Vd = true;
                    if (this.Vc != null) {
                        setAdapter(this.Vc);
                        this.Vc = null;
                    }
                    this.Un.a(attributeSet, i);
                } catch (Throwable th4) {
                    th = th4;
                    if (typedArray != null) {
                        typedArray.recycle();
                    }
                    throw th;
                }
            }
            i2 = 1;
            if (i2 == 1) {
                bVar = new b(this, this.Rx, attributeSet, i);
                a = ap.a(this.Rx, attributeSet, k.cM, i);
                this.Vf = a.getLayoutDimension(k.Nd, -2);
                bVar.setBackgroundDrawable(a.getDrawable(k.Nf));
                bVar.Vk = a2.aeG.getString(k.Ng);
                a.aeG.recycle();
                this.Ve = bVar;
                this.PJ = /* anonymous class already generated */;
            }
        }
        textArray = a2.aeG.getTextArray(k.Ne);
        if (textArray != null) {
            arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
            arrayAdapter.setDropDownViewResource(h.KR);
            setAdapter(arrayAdapter);
        }
        a2.aeG.recycle();
        this.Vd = true;
        if (this.Vc != null) {
            setAdapter(this.Vc);
            this.Vc = null;
        }
        this.Un.a(attributeSet, i);
    }

    public Context getPopupContext() {
        if (this.Ve != null) {
            return this.Rx;
        }
        if (UZ) {
            return super.getPopupContext();
        }
        return null;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.Ve != null) {
            this.Ve.setBackgroundDrawable(drawable);
        } else if (Va) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(android.support.v4.content.a.a(getPopupContext(), i));
    }

    public Drawable getPopupBackground() {
        if (this.Ve != null) {
            return this.Ve.XU.getBackground();
        }
        if (Va) {
            return super.getPopupBackground();
        }
        return null;
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.Ve != null) {
            ListPopupWindow listPopupWindow = this.Ve;
            listPopupWindow.XY = i;
            listPopupWindow.Ya = true;
        } else if (Va) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public int getDropDownVerticalOffset() {
        if (this.Ve != null) {
            ListPopupWindow listPopupWindow = this.Ve;
            if (listPopupWindow.Ya) {
                return listPopupWindow.XY;
            }
            return 0;
        } else if (Va) {
            return super.getDropDownVerticalOffset();
        } else {
            return 0;
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.Ve != null) {
            this.Ve.XX = i;
        } else if (Va) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.Ve != null) {
            return this.Ve.XX;
        }
        if (Va) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public void setDropDownWidth(int i) {
        if (this.Ve != null) {
            this.Vf = i;
        } else if (Va) {
            super.setDropDownWidth(i);
        }
    }

    public int getDropDownWidth() {
        if (this.Ve != null) {
            return this.Vf;
        }
        if (Va) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.Vd) {
            super.setAdapter(spinnerAdapter);
            if (this.Ve != null) {
                this.Ve.setAdapter(new a(spinnerAdapter, (this.Rx == null ? getContext() : this.Rx).getTheme()));
                return;
            }
            return;
        }
        this.Vc = spinnerAdapter;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Ve != null && this.Ve.XU.isShowing()) {
            this.Ve.dismiss();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.PJ == null || !this.PJ.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Ve != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        if (this.Ve == null) {
            return super.performClick();
        }
        if (!this.Ve.XU.isShowing()) {
            this.Ve.show();
        }
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.Ve != null) {
            this.Ve.Vk = charSequence;
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        return this.Ve != null ? this.Ve.Vk : super.getPrompt();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.Un != null) {
            this.Un.aK(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.Un != null) {
            this.Un.f(null);
        }
    }

    public final void d(ColorStateList colorStateList) {
        if (this.Un != null) {
            this.Un.d(colorStateList);
        }
    }

    public final ColorStateList bL() {
        return this.Un != null ? this.Un.bL() : null;
    }

    public final void a(Mode mode) {
        if (this.Un != null) {
            this.Un.a(mode);
        }
    }

    public final Mode bM() {
        return this.Un != null ? this.Un.bM() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Un != null) {
            this.Un.ev();
        }
    }

    private int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.eq);
        return (this.eq.left + this.eq.right) + i;
    }
}
