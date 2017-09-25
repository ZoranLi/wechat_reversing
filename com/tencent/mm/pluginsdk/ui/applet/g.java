package com.tencent.mm.pluginsdk.ui.applet;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;

public final class g {
    private int background = -1;
    int index;
    boolean kto;
    OnClickListener oPX = new OnClickListener(this) {
        final /* synthetic */ g sNo;

        {
            this.sNo = r1;
        }

        public final void onClick(View view) {
        }
    };
    int row;
    public a sMD;
    f sMx;
    private final OnTouchListener sNh = new OnTouchListener(this) {
        final /* synthetic */ g sNo;

        {
            this.sNo = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    int sNm;
    public b sNn;

    class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ int kA;
        final /* synthetic */ g sNo;
        final /* synthetic */ ViewGroup sNp;

        AnonymousClass3(g gVar, ViewGroup viewGroup, int i) {
            this.sNo = gVar;
            this.sNp = viewGroup;
            this.kA = i;
        }

        public final void onClick(View view) {
            this.sNo.sMD.xr(this.kA);
        }
    }

    class AnonymousClass4 implements OnLongClickListener {
        final /* synthetic */ int kA;
        final /* synthetic */ g sNo;
        final /* synthetic */ ViewGroup sNp;

        AnonymousClass4(g gVar, ViewGroup viewGroup, int i) {
            this.sNo = gVar;
            this.sNp = viewGroup;
            this.kA = i;
        }

        public final boolean onLongClick(View view) {
            return this.sNo.sNn.kJ(this.kA);
        }
    }

    public interface a {
        void xr(int i);
    }

    public interface b {
        boolean kJ(int i);
    }
}
