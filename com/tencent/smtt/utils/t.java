package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class t {
    static String igL = null;
    private static boolean wYL = true;
    static t wYN = null;
    static File wYO = null;
    static byte[] wYQ = null;
    TextView Vr;
    private Context mContext = null;
    private SimpleDateFormat wYP = null;
    private StringBuffer wYR = new StringBuffer();

    private class a implements Runnable {
        String wYS = null;
        final /* synthetic */ t wYT;

        a(t tVar, String str) {
            this.wYT = tVar;
            this.wYS = str;
        }

        public final void run() {
            if (this.wYT.Vr != null) {
                this.wYT.Vr.append(this.wYS + "\n");
            }
        }
    }

    public t(Context context) {
        try {
            this.mContext = context.getApplicationContext();
            this.wYP = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
        } catch (Exception e) {
            this.wYP = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        }
    }

    public static void setWriteLogJIT(boolean z) {
        wYL = z;
    }

    public final void aC(String str) {
        try {
            this.wYR.append(this.wYP.format(Long.valueOf(System.currentTimeMillis()))).append(" pid=").append(Process.myPid()).append(" tid=").append(Process.myTid()).append(str).append("\n");
            if (Thread.currentThread() != Looper.getMainLooper().getThread() || wYL) {
                writeLogToDisk();
            }
        } catch (Exception e) {
        }
    }

    public void qQ(String str) {
        if (this.Vr != null) {
            this.Vr.post(new a(this, str));
        }
    }

    public final void writeLogToDisk() {
        try {
            if (wYO == null) {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    String al = f.al(this.mContext, 6);
                    if (al == null) {
                        wYO = null;
                    } else {
                        wYO = new File(al, "tbslog.txt");
                        igL = h.cfm();
                        wYQ = h.fi(wYO.getName(), igL);
                    }
                } else {
                    wYO = null;
                }
            }
        } catch (SecurityException e) {
        } catch (NullPointerException e2) {
        }
        if (wYO != null) {
            h.a(wYO, igL, wYQ, this.wYR.toString());
            this.wYR.delete(0, this.wYR.length());
        }
    }
}
