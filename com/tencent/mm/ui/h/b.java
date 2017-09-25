package com.tencent.mm.ui.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.o;

public final class b extends o {
    public long mDuration = 3000;
    @SuppressLint({"HandlerLeak"})
    private ae mHandler = new ae(this) {
        final /* synthetic */ b wjA;

        {
            this.wjA = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 256:
                    this.wjA.dismiss();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };

    private b(View view) {
        super(view);
    }

    public static b fc(Context context) {
        View inflate = LayoutInflater.from(context).inflate(h.heO, null);
        ((TextView) inflate.findViewById(g.hdE)).setVisibility(8);
        b bVar = new b(inflate);
        bVar.setFocusable(false);
        bVar.setContentView(inflate);
        bVar.setWidth(-1);
        bVar.setHeight(-1);
        bVar.setAnimationStyle(l.hfw);
        bVar.mDuration = 1200;
        return bVar;
    }

    public final void showAsDropDown(View view, int i, int i2) {
        super.showAsDropDown(view, i, i2);
        this.mHandler.removeMessages(256);
        this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
    }

    public final void showAsDropDown(View view) {
        super.showAsDropDown(view);
        this.mHandler.removeMessages(256);
        this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
    }

    public final void showAtLocation(View view, int i, int i2, int i3) {
        super.showAtLocation(view, i, i2, i3);
        this.mHandler.removeMessages(256);
        this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
    }
}
