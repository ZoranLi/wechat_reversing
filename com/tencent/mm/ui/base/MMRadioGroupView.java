package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.LinearLayout;

public class MMRadioGroupView extends LinearLayout {
    private int vlV = -1;
    private int vlW = -1;
    private com.tencent.mm.ui.base.MMRadioImageButton.a vlX = new a(this);
    private b vlY = new b(this);
    private MMRadioImageButton vlZ;
    private c vma;

    private class b implements OnHierarchyChangeListener {
        private OnHierarchyChangeListener hr;
        final /* synthetic */ MMRadioGroupView vmb;

        public b(MMRadioGroupView mMRadioGroupView) {
            this.vmb = mMRadioGroupView;
        }

        public final void onChildViewAdded(View view, View view2) {
            if (view == this.vmb && (view2 instanceof MMRadioImageButton)) {
                if (view2.getId() == -1) {
                    int hashCode = view2.hashCode();
                    if (hashCode < 0) {
                        hashCode &= Integer.MAX_VALUE;
                    }
                    view2.setId(hashCode);
                }
                ((MMRadioImageButton) view2).vmg = this.vmb.vlX;
            }
            if (this.hr != null) {
                this.hr.onChildViewAdded(view, view2);
            }
        }

        public final void onChildViewRemoved(View view, View view2) {
            if (view == this.vmb && (view2 instanceof MMRadioImageButton)) {
                ((MMRadioImageButton) view2).vmg = null;
            }
            if (this.hr != null) {
                this.hr.onChildViewRemoved(view, view2);
            }
        }
    }

    public interface c {
        void lA(int i);
    }

    class a implements com.tencent.mm.ui.base.MMRadioImageButton.a {
        final /* synthetic */ MMRadioGroupView vmb;

        a(MMRadioGroupView mMRadioGroupView) {
            this.vmb = mMRadioGroupView;
        }

        public final void a(MMRadioImageButton mMRadioImageButton) {
            if (this.vmb.vlV != -1) {
                this.vmb.ah(this.vmb.vlV, false);
            }
            int id = mMRadioImageButton.getId();
            this.vmb.vlZ = mMRadioImageButton;
            this.vmb.vlV = id;
        }

        public final void b(MMRadioImageButton mMRadioImageButton) {
            this.vmb.vlW = mMRadioImageButton.getId();
        }
    }

    public MMRadioGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnHierarchyChangeListener(this.vlY);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.vlV != -1) {
            ah(this.vlV, true);
            this.vlV = this.vlV;
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view instanceof MMRadioImageButton) {
            MMRadioImageButton mMRadioImageButton = (MMRadioImageButton) view;
            if (mMRadioImageButton.isChecked()) {
                if (this.vlV != -1) {
                    ah(this.vlV, false);
                }
                this.vlV = mMRadioImageButton.getId();
                this.vlZ = mMRadioImageButton;
            }
        }
        super.addView(view, i, layoutParams);
    }

    private void ah(int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById != null && (findViewById instanceof MMRadioImageButton)) {
            ((MMRadioImageButton) findViewById).setChecked(z);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if ((i > 0 || i2 > 0) && this.vma != null) {
            this.vma.lA(i);
        }
    }
}
