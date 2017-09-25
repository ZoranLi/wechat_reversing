package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.EditText;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.k;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;

public class EditPreference extends Preference {
    public h oHT;
    public String value;
    public com.tencent.mm.ui.base.preference.Preference.a vqt;
    public a vqy;
    private EditText vqz;

    public interface a {
        void bSW();
    }

    public EditPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(com.tencent.mm.ui.base.preference.Preference.a aVar) {
        this.vqt = aVar;
    }

    public final void showDialog() {
        View view;
        if (this.vqz != null) {
            view = this.vqz;
        } else {
            view = new EditText(this.mContext);
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.setSingleLine(true);
            view.setText(this.value);
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(e.aXt);
            marginLayoutParams.leftMargin = dimensionPixelSize;
            marginLayoutParams.rightMargin = dimensionPixelSize;
            marginLayoutParams.topMargin = dimensionPixelSize;
            marginLayoutParams.bottomMargin = dimensionPixelSize;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.oHT = g.a(this.mContext, getTitle().toString(), view, com.tencent.mm.bg.a.V(this.mContext, k.dHT), com.tencent.mm.bg.a.V(this.mContext, k.dGs), new OnClickListener(this) {
            final /* synthetic */ EditPreference vqB;

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.vqB.oHT != null) {
                    this.vqB.oHT.dismiss();
                }
                this.vqB.value = view.getText().toString();
                if (this.vqB.vqy != null) {
                    this.vqB.vqy.bSW();
                }
                if (this.vqB.vqt != null) {
                    this.vqB.vqt.a(this.vqB, this.vqB.value);
                }
            }
        }, new OnClickListener(this) {
            final /* synthetic */ EditPreference vqB;

            {
                this.vqB = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.vqB.oHT != null) {
                    this.vqB.oHT.dismiss();
                }
            }
        });
    }
}
