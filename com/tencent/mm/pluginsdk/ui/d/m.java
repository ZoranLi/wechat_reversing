package com.tencent.mm.pluginsdk.ui.d;

import android.view.View;

public class m extends l {
    private a sTY;
    private Object tag;

    public interface a {
        void bk(Object obj);
    }

    public m(Object obj, a aVar) {
        super(2, null);
        this.sTY = aVar;
        this.tag = obj;
    }

    public m(Object obj, a aVar, int i) {
        super(2, null);
        this.sTY = aVar;
        this.tag = obj;
        vF(i);
    }

    public void onClick(View view) {
        if (this.sTY != null) {
            this.sTY.bk(this.tag);
        }
    }
}
