package com.tencent.mm.sdk.platformtools;

import android.os.Process;
import com.tencent.recovery.crash.DefaultExceptionHandler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class ai implements UncaughtExceptionHandler {
    private static ai utn = null;
    private d uto;
    private com.tencent.mm.sdk.a.a utp;
    public a utq;
    public Map<String, b> utr;
    private UncaughtExceptionHandler uts;
    private boolean utt;
    private List<c> utu;

    public interface a {
        void oi();
    }

    public interface b {
        String AF();
    }

    public interface c {
        void b(Throwable th);
    }

    public interface d {
        void a(ai aiVar, String str, Throwable th);
    }

    public static synchronized void a(d dVar) {
        synchronized (ai.class) {
            if (utn == null) {
                utn = new ai();
            }
            utn.uto = dVar;
        }
    }

    public static synchronized void a(com.tencent.mm.sdk.a.a aVar) {
        synchronized (ai.class) {
            if (utn == null) {
                utn = new ai();
            }
            utn.utp = aVar;
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (ai.class) {
            if (utn == null) {
                utn = new ai();
            }
            utn.utq = aVar;
        }
    }

    public static synchronized void a(String str, b bVar) {
        synchronized (ai.class) {
            if (utn == null) {
                utn = new ai();
            }
            utn.utr.put(str, bVar);
        }
    }

    public static synchronized void q(String str, final String str2, boolean z) {
        synchronized (ai.class) {
            a(str, new b() {
                public final String AF() {
                    return "subinfo=" + str2;
                }
            });
            Assert.assertTrue(str, z);
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (ai.class) {
            if (cVar != null) {
                if (utn == null) {
                    utn = new ai();
                }
                utn.utu.add(cVar);
            }
        }
    }

    private ai() {
        this.uto = null;
        this.utp = null;
        this.utq = null;
        this.utr = new HashMap();
        this.uts = null;
        this.utt = false;
        this.utu = new LinkedList();
        this.uts = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(this));
    }

    private static String Px(String str) {
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        if (toCharArray == null) {
            return null;
        }
        char c;
        int i = 0;
        while (i < toCharArray.length) {
            if (toCharArray[i] > '') {
                toCharArray[i] = '\u0000';
                c = '\u0001';
                break;
            }
            i++;
        }
        c = '\u0000';
        if (c != '\u0000') {
            return new String(toCharArray, 0, i);
        }
        return str;
    }

    public static String h(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (th.getCause() != null) {
            try {
                th = th.getCause();
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            }
        }
        th.printStackTrace(printStream);
        String Px = Px(byteArrayOutputStream.toString());
        return Px;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        if (!this.utt) {
            this.utt = true;
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PrintStream printStream = new PrintStream(byteArrayOutputStream);
                Throwable th2 = th;
                while (th2.getCause() != null) {
                    th2 = th2.getCause();
                }
                th2.printStackTrace(printStream);
                String Px = Px(byteArrayOutputStream.toString());
                if (!(this.utp == null || Px == null)) {
                    this.utp.ed(Px);
                }
                if (!(this.uto == null || Px == null)) {
                    this.uto.a(this, Px, th);
                    this.utq.oi();
                }
                for (c cVar : this.utu) {
                    if (cVar != null) {
                        try {
                            cVar.b(th);
                        } catch (Exception e) {
                        }
                    }
                }
                byteArrayOutputStream.close();
            } catch (Exception e2) {
            }
            w.appenderClose();
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }
}
