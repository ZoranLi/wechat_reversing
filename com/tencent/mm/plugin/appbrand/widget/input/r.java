package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.view.View;
import com.tencent.wcdb.FileUtils;

public final class r extends p {
    public r(Context context) {
        super(context);
    }

    public final View Yq() {
        return v.bT(this);
    }

    public final void cx(boolean z) {
        Zn();
        int inputType = getInputType() | 1;
        if (z) {
            inputType |= FileUtils.S_IWUSR;
        } else {
            inputType &= -129;
        }
        setInputType(inputType);
        super.cx(z);
        Zo();
    }

    public final void YR() {
        ad.bY(this).restartInput(this);
    }
}
