package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.bb;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import java.util.ArrayList;

public class ProfileLabelView extends ProfileItemView {
    public TextView otC;
    public TextView sJO;

    public ProfileLabelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProfileLabelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int aTQ() {
        return R.i.dlp;
    }

    public final void init() {
        this.otC = (TextView) findViewById(R.h.bFj);
        this.sJO = (TextView) findViewById(R.h.bFk);
        setClickable(true);
    }

    public final boolean aTR() {
        if (this.sJO != null) {
            LayoutParams layoutParams = this.sJO.getLayoutParams();
            layoutParams.width = a.T(getContext(), R.f.aXk);
            this.sJO.setLayoutParams(layoutParams);
        }
        String str;
        ArrayList arrayList;
        if (!com.tencent.mm.j.a.ez(this.kWy.field_type)) {
            bb AI;
            String str2 = this.kWy.field_encryptUsername;
            if (bg.mA(str2)) {
                ap.yY();
                AI = c.wS().AI(this.kWy.field_username);
            } else {
                ap.yY();
                AI = c.wS().AI(str2);
            }
            if (AI != null) {
                str = AI.field_contactLabels;
                arrayList = (ArrayList) com.tencent.mm.plugin.label.a.a.aFG().zf(str);
                if (!(bg.mA(str) || arrayList == null || arrayList.size() <= 0)) {
                    this.otC.setText(h.a(getContext(), bg.c(arrayList, getContext().getResources().getString(R.l.dXb))));
                    return true;
                }
            }
            setVisibility(8);
            return false;
        } else if (m.eH(this.kWy.field_username)) {
            setVisibility(8);
            return false;
        } else {
            str = this.kWy.field_contactLabelIds;
            arrayList = (ArrayList) com.tencent.mm.plugin.label.a.a.aFG().zg(str);
            if (bg.mA(str) || arrayList == null || arrayList.size() <= 0) {
                setVisibility(8);
                return false;
            }
            this.otC.setText(h.a(getContext(), bg.c(arrayList, getContext().getResources().getString(R.l.dXb))));
            return true;
        }
    }
}
