package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.utils.TbsLog;

public final class i {
    public static volatile int wUy = -1;
    private static i wUz = null;
    a wUv = null;
    boolean wUw = false;
    private final int wUx = 3;

    public class a {
        int[] wUA;
        int wUB;
        int wUC;

        public final String toString() {
            if ((this.wUC == this.wUB ? 1 : null) != null) {
                return "";
            }
            int i;
            StringBuilder stringBuilder = new StringBuilder("[");
            for (i = this.wUB; i < this.wUC; i++) {
                stringBuilder.append(String.valueOf(this.wUA[i]) + ",");
            }
            i = stringBuilder.length();
            return stringBuilder.delete(i - 1, i).append("]").toString();
        }
    }

    private i() {
    }

    public static i cec() {
        if (wUz == null) {
            wUz = new i();
        }
        return wUz;
    }

    final synchronized void a(Context context, int i, Throwable th) {
        if (wUy == -1) {
            wUy = i;
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR, "code=%d,desc=%s", Integer.valueOf(i), String.valueOf(th));
            if (th != null) {
                r gr = r.gr(context);
                String str = "NULL";
                if (th != null) {
                    str = "msg: " + th.getMessage() + "; err: " + th + "; cause: " + Log.getStackTraceString(th.getCause());
                    if (str.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                        str = str.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    }
                }
                gr.aN(i, str);
            } else {
                TbsLog.e("TbsCoreLoadStat", "setLoadErrorCode :: error is null with errorCode: " + i + "; Check & correct it!");
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder("setLoadErrorCode :: error(");
            stringBuilder.append(wUy);
            stringBuilder.append(") was already reported; ");
            stringBuilder.append(i);
            stringBuilder.append(" is duplicated. Try to remove it!");
            TbsLog.w("TbsCoreLoadStat", stringBuilder.toString());
        }
    }

    final void ai(Context context, int i) {
        a(context, i, null);
        TbsLog.e("loaderror", String.valueOf(i));
    }
}
