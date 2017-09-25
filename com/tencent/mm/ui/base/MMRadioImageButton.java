package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;

public class MMRadioImageButton extends ImageButton implements Checkable {
    private boolean vmc;
    private boolean vmd;
    private boolean vme;
    private a vmf;
    a vmg;

    public interface a {
        void a(MMRadioImageButton mMRadioImageButton);

        void b(MMRadioImageButton mMRadioImageButton);
    }

    public MMRadioImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMRadioImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vmd = true;
    }

    public void toggle() {
        if (!this.vmd) {
            if (this.vmf != null) {
                this.vmf.b(this);
            }
            if (this.vmg != null) {
                this.vmg.b(this);
            }
        } else if (!isChecked()) {
            setChecked(!this.vme);
        }
    }

    public boolean performClick() {
        toggle();
        return false;
    }

    public boolean isChecked() {
        return this.vme;
    }

    public void setChecked(boolean z) {
        if (this.vme != z) {
            this.vme = z;
            setSelected(this.vme);
            refreshDrawableState();
            if (!this.vmc) {
                this.vmc = true;
                if (this.vmf != null) {
                    this.vmf.a(this);
                }
                if (this.vmg != null) {
                    this.vmg.a(this);
                }
                this.vmc = false;
            }
        }
    }
}
