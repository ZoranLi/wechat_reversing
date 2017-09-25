package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.ProfileItemView;
import com.tencent.mm.sdk.platformtools.bg;

public class ProfileNormalItemView extends ProfileItemView {
    private TextView jhl;
    private String mTitle;
    TextView oqx;
    CharSequence owe;
    OnClickListener owf;

    public ProfileNormalItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.fry);
        this.mTitle = obtainStyledAttributes.getString(R.n.frz);
        obtainStyledAttributes.recycle();
    }

    public ProfileNormalItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int aTQ() {
        return R.i.dlr;
    }

    public final void init() {
        this.jhl = (TextView) findViewById(R.h.bFY);
        this.oqx = (TextView) findViewById(R.h.bFX);
    }

    public final ProfileNormalItemView ru(int i) {
        this.mTitle = getContext().getString(i);
        return this;
    }

    public final ProfileNormalItemView rv(int i) {
        this.owe = getContext().getString(i);
        return this;
    }

    public final ProfileNormalItemView rw(int i) {
        this.oqx.setTextColor(i);
        return this;
    }

    public final boolean aTR() {
        this.jhl.setText(this.mTitle);
        if (bg.J(this.owe)) {
            setVisibility(8);
            return false;
        }
        setVisibility(0);
        this.oqx.setText(this.owe);
        setOnClickListener(this.owf);
        return true;
    }
}
