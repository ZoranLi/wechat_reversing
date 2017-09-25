package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.Vector;

public final class b {
    public static Vector<m> kGq = new Vector();
    public static m kGr;

    b() {
    }

    public static void a(m mVar) {
        if (mVar != null && !kGq.contains(mVar)) {
            kGq.add(mVar);
        }
    }

    public static void b(m mVar) {
        if (kGq != null && mVar != null) {
            kGq.remove(mVar);
        }
    }

    public static void c(m mVar) {
        kGr = mVar;
    }

    public static void akL() {
        kGr = null;
    }

    public final void h(final long j, final String str) {
        w.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskStarted: %d, %s", Long.valueOf(j), str);
        af.v(new Runnable(this) {
            final /* synthetic */ b kGs;

            public final void run() {
                if (b.kGq != null) {
                    Iterator it = b.kGq.iterator();
                    while (it.hasNext()) {
                        ((m) it.next()).onTaskStarted(j, str);
                    }
                }
                if (b.kGr != null) {
                    b.kGr.onTaskStarted(j, str);
                }
            }
        });
    }

    public final void i(final long j, final String str) {
        w.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskStarted: %d, %s", Long.valueOf(j), str);
        af.v(new Runnable(this) {
            final /* synthetic */ b kGs;

            public final void run() {
                if (b.kGq != null) {
                    Iterator it = b.kGq.iterator();
                    while (it.hasNext()) {
                        ((m) it.next()).j(j, str);
                    }
                }
                if (b.kGr != null) {
                    b.kGr.j(j, str);
                }
            }
        });
    }

    public final void aX(final long j) {
        w.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskRemoved: %d", Long.valueOf(j));
        af.v(new Runnable(this) {
            final /* synthetic */ b kGs;

            public final void run() {
                if (b.kGq != null) {
                    Iterator it = b.kGq.iterator();
                    while (it.hasNext()) {
                        ((m) it.next()).onTaskRemoved(j);
                    }
                }
                if (b.kGr != null) {
                    b.kGr.onTaskRemoved(j);
                }
            }
        });
    }

    public final void b(long j, String str, boolean z) {
        w.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFinished: %d", Long.valueOf(j));
        final long j2 = j;
        final String str2 = str;
        final boolean z2 = z;
        af.v(new Runnable(this) {
            final /* synthetic */ b kGs;

            public final void run() {
                if (b.kGq != null) {
                    Iterator it = b.kGq.iterator();
                    while (it.hasNext()) {
                        ((m) it.next()).c(j2, str2, z2);
                    }
                }
                if (b.kGr != null) {
                    b.kGr.c(j2, str2, z2);
                }
            }
        });
    }

    public final void c(long j, int i, boolean z) {
        w.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFailed: %d, errCode : %d", Long.valueOf(j), Integer.valueOf(i));
        final long j2 = j;
        final int i2 = i;
        final boolean z2 = z;
        af.v(new Runnable(this) {
            final /* synthetic */ b kGs;

            public final void run() {
                if (b.kGq != null) {
                    Iterator it = b.kGq.iterator();
                    while (it.hasNext()) {
                        ((m) it.next()).d(j2, i2, z2);
                    }
                }
                if (b.kGr != null) {
                    b.kGr.d(j2, i2, z2);
                }
            }
        });
    }

    public final void aY(final long j) {
        w.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskPaused: %d", Long.valueOf(j));
        af.v(new Runnable(this) {
            final /* synthetic */ b kGs;

            public final void run() {
                if (b.kGq != null) {
                    Iterator it = b.kGq.iterator();
                    while (it.hasNext()) {
                        ((m) it.next()).onTaskPaused(j);
                    }
                }
                if (b.kGr != null) {
                    b.kGr.onTaskPaused(j);
                }
            }
        });
    }

    public final void aZ(final long j) {
        af.v(new Runnable(this) {
            final /* synthetic */ b kGs;

            public final void run() {
                if (b.kGq != null) {
                    Iterator it = b.kGq.iterator();
                    while (it.hasNext()) {
                        ((m) it.next()).bg(j);
                    }
                }
            }
        });
    }
}
