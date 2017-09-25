package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.DrawedCallBackLinearLayout;

public class TestTimeForChatting extends DrawedCallBackLinearLayout {
    public final String TAG = "MicroMsg.TestTimeForChatting";
    public int hap = 0;
    public int woS = 0;
    public int woT = 0;

    public TestTimeForChatting(Context context) {
        super(context);
    }

    public TestTimeForChatting(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public final void bZV() {
        w.i("MicroMsg.TestTimeForChatting", "klem frameCount:%d", Integer.valueOf(this.hap));
        g.oUh.i(11198, Integer.valueOf(this.hap));
    }

    protected void dispatchDraw(Canvas canvas) {
        this.hap++;
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.TestTimeForChatting", th, "dispatchDraw", new Object[0]);
        }
        f.rZ(9);
        f.rZ(18);
        f.rZ(25);
        f.rZ(24);
        f.rZ(20);
    }

    public boolean fitSystemWindows(Rect rect) {
        w.d("MicroMsg.TestTimeForChatting", "ashu::fitSystemWindows: %s, fixBottomPadding:%d fixRightPadding:%d", rect.toString(), Integer.valueOf(this.woS), Integer.valueOf(this.woT));
        rect.bottom += this.woS;
        rect.right += this.woT;
        return super.fitSystemWindows(rect);
    }
}
