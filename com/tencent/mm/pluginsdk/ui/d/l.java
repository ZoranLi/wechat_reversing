package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.pluginsdk.ui.applet.i;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ay;
import java.lang.ref.WeakReference;

public class l extends ClickableSpan {
    private WeakReference<View> fh = null;
    String iCS;
    private int jkE;
    boolean mEnable = true;
    public boolean nII = false;
    private Context sTQ = null;
    private int sTV;
    f sTW = null;
    private i sTX = null;

    public l(int i, i iVar) {
        int i2;
        int i3 = 0;
        if (iVar != null) {
            i2 = iVar.linkColor;
            i3 = iVar.backgroundColor;
        } else {
            i2 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            vF(i);
        } else {
            dI(i2, i3);
        }
        this.sTW = new f();
        this.sTX = iVar;
    }

    public void vF(int i) {
        Context context = ab.getContext();
        switch (i) {
            case 1:
                dI(context.getResources().getColor(a.kDx), -5908174);
                return;
            case 2:
                dI(context.getResources().getColor(a.aUA), context.getResources().getColor(a.aVR));
                return;
            case 3:
                dI(context.getResources().getColor(a.kDy), context.getResources().getColor(a.aVR));
                return;
            default:
                return;
        }
    }

    public final void dI(int i, int i2) {
        this.sTV = i;
        this.jkE = i2;
    }

    public final int getType() {
        return this.sTX == null ? Integer.MAX_VALUE : this.sTX.type;
    }

    public void onClick(View view) {
        if (this.sTW != null && this.sTX != null && this.mEnable) {
            this.sTW.mContext = this.sTQ != null ? this.sTQ : view.getContext();
            f fVar = this.sTW;
            i iVar = this.sTX;
            if (iVar == null) {
                w.e("MicroMsg.MMSpanClickListener", "onClick error, hrefInfo is null!");
            } else {
                w.d("MicroMsg.MMSpanClickListener", "MMSpanClickListener.onClick, hrefInfo type = %d", Integer.valueOf(iVar.type));
                if (fVar.mContext == null) {
                    w.e("MicroMsg.MMSpanClickListener", "onClick error, context is null!");
                } else {
                    e eVar;
                    String str;
                    if (h.sTx == null || h.sTx.size() <= 0) {
                        eVar = null;
                    } else {
                        int size = h.sTx.size();
                        e eVar2 = (e) h.sTx.getLast();
                        w.d("MicroMsg.MMSpanClickListener", "spanCallbackList.size:%d, get the last callback", Integer.valueOf(size));
                        eVar = eVar2;
                    }
                    if (view != null && (view.getTag() instanceof c)) {
                        ce ceVar = ((c) view.getTag()).fTk;
                        if (ceVar != null) {
                            str = ceVar.field_talker;
                            if (str.endsWith("@chatroom")) {
                                str = ay.gi(ceVar.field_content);
                            }
                            iVar.username = str;
                            if (!TextUtils.isEmpty(fVar.iCS)) {
                                iVar.iCS = fVar.iCS;
                            }
                            b.a.sTh.a(fVar.mContext, iVar, eVar);
                            iVar.iCS = null;
                        }
                    }
                    str = null;
                    iVar.username = str;
                    if (TextUtils.isEmpty(fVar.iCS)) {
                        iVar.iCS = fVar.iCS;
                    }
                    b.a.sTh.a(fVar.mContext, iVar, eVar);
                    iVar.iCS = null;
                }
            }
            this.sTW.mContext = null;
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.sTV);
        textPaint.setUnderlineText(false);
        if (this.nII) {
            textPaint.bgColor = this.jkE;
        } else {
            textPaint.bgColor = 0;
        }
    }

    public final void setContext(Context context) {
        this.sTQ = context;
        this.sTW.mContext = context;
    }
}
