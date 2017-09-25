package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.ui.widget.celltextview.CellTextView;
import com.tencent.mm.ui.widget.celltextview.e.a;

public final class dx extends a {
    private k vNm;

    public dx(k kVar) {
        this.vNm = kVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        view.setTag(R.h.cJw, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
        if (view instanceof CellTextView) {
            CellTextView cellTextView = (CellTextView) view;
            if (cellTextView.wyg) {
                return this.vNm.onTouch(cellTextView.wyf, motionEvent);
            }
        }
        return super.onTouch(view, motionEvent);
    }
}
