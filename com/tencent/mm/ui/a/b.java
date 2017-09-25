package com.tencent.mm.ui.a;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private final String TAG = "MicroMsg.Accessibility.Tool";
    private List<String> uWX = new ArrayList();

    public final b SK(String str) {
        this.uWX.add(str);
        return this;
    }

    public final void cZ(View view) {
        if (view != null && this.uWX.size() > 0) {
            CharSequence charSequence = "";
            for (String str : this.uWX) {
                Object obj = charSequence + str + ",";
            }
            view.setContentDescription(charSequence);
        }
    }
}
