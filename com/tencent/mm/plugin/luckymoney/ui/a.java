package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.LinkedList;
import java.util.List;

public final class a {
    private List<b> nsv = new LinkedList();
    private boolean nsw = false;
    private boolean nsx = false;
    private TextView nsy;

    public final void a(b bVar) {
        if (bVar != null) {
            this.nsv.add(bVar);
        }
    }

    public final void g(TextView textView) {
        if (textView != null) {
            this.nsy = textView;
        }
    }

    public final void clear() {
        this.nsv.clear();
        this.nsy = null;
    }

    public final boolean aIx() {
        this.nsx = false;
        this.nsw = false;
        for (int i = 0; i < this.nsv.size(); i++) {
            b bVar = (b) this.nsv.get(i);
            int aIz = bVar.aIz();
            if (aIz != 0) {
                bVar.onError();
                CharSequence oY = bVar.oY(aIz);
                if (!(this.nsy == null || bg.mA(oY))) {
                    if (!this.nsw) {
                        this.nsy.setText(oY);
                    }
                    this.nsy.setVisibility(0);
                    this.nsw = true;
                }
                this.nsx = true;
            } else {
                bVar.restore();
            }
        }
        if (!(this.nsx || this.nsy == null)) {
            this.nsy.setVisibility(8);
            this.nsw = false;
        }
        return this.nsx;
    }

    public final boolean aIy() {
        for (int i = 0; i < this.nsv.size(); i++) {
            if (((b) this.nsv.get(i)).aIz() != 0) {
                return true;
            }
        }
        return false;
    }

    public final void pk(String str) {
        if (this.nsy != null && !bg.mA(str)) {
            this.nsy.setText(str);
            this.nsy.setVisibility(0);
            this.nsw = true;
        } else if (this.nsy != null) {
            this.nsy.setVisibility(8);
            this.nsw = false;
        }
    }
}
