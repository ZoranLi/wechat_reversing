package com.tencent.mm.plugin.fts;

import android.os.Process;
import android.util.Log;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDiskIOException;
import com.tencent.wcdb.database.SQLiteException;
import java.util.concurrent.PriorityBlockingQueue;

public final class f implements k {
    a lYm = new a(this);

    private class a extends Thread {
        int lYn = Integer.MAX_VALUE;
        PriorityBlockingQueue<com.tencent.mm.plugin.fts.a.a.a> lYo = new PriorityBlockingQueue();
        volatile boolean lYp = false;
        com.tencent.mm.plugin.fts.a.a.a lYq;
        private boolean lYr;
        Runnable lYs;
        d lYt;
        boolean lYu = false;
        final /* synthetic */ f lYv;
        private int mTid = 0;

        public a(f fVar) {
            this.lYv = fVar;
            super("SearchDaemon");
        }

        final synchronized void mP(int i) {
            if (this.lYn != i && isAlive()) {
                if (i < 0) {
                    if (this.lYn >= 0) {
                        Process.setThreadPriority(this.mTid, -8);
                        this.lYn = i;
                    }
                }
                if (i >= 0) {
                    if (this.lYn < 0) {
                        Process.setThreadPriority(this.mTid, this.lYr ? 10 : 0);
                    }
                }
                this.lYn = i;
            }
        }

        public final synchronized void quit() {
            this.lYp = true;
            interrupt();
        }

        public final synchronized void eq(boolean z) {
            int i = 0;
            synchronized (this) {
                if (this.lYr != z) {
                    this.lYr = z;
                    if (this.lYn >= 0 && isAlive() && this.mTid != 0) {
                        if (this.lYr) {
                            i = 10;
                        }
                        try {
                            Process.setThreadPriority(this.mTid, i);
                            w.i("MicroMsg.FTS.FTSTaskDaemon", "*** Switch priority: " + (this.lYr ? "foreground" : "background"));
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "setLowPriorityMode failed, tid=%d, p=%d", new Object[]{Integer.valueOf(this.mTid), Integer.valueOf(i)});
                        }
                    }
                }
            }
        }

        public final void run() {
            long currentTimeMillis;
            com.tencent.mm.plugin.fts.a.a.a aVar;
            String str;
            String str2;
            StringBuilder append;
            Throwable th;
            Throwable th2;
            Object obj;
            this.mTid = Process.myTid();
            while (true) {
                String str3 = " ";
                try {
                    Thread.interrupted();
                    if (this.lYp) {
                        a.axA();
                        this.mTid = 0;
                        return;
                    }
                    this.lYq = null;
                    com.tencent.mm.plugin.fts.a.a.a aVar2 = (com.tencent.mm.plugin.fts.a.a.a) this.lYo.take();
                    if (aVar2 == null) {
                        a.axA();
                    } else {
                        try {
                            this.lYq = aVar2;
                            mP(aVar2.getPriority());
                            currentTimeMillis = System.currentTimeMillis();
                            if (this.lYn < 0) {
                                str3 = "!";
                            }
                            aVar2.execute();
                            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                            e.mQ(1);
                            e.s(aVar2.getId(), currentTimeMillis);
                            e.t(aVar2.getId(), currentTimeMillis);
                            e.a(aVar2.getName(), aVar2.getId(), currentTimeMillis, "");
                            w.i("MicroMsg.FTS.FTSTaskDaemon", "%s[%s] done, %dms", new Object[]{str3, aVar2, Long.valueOf(currentTimeMillis)});
                            a.axA();
                        } catch (InterruptedException e) {
                            String str4 = str3;
                            aVar = aVar2;
                            str = str4;
                            if (aVar != null) {
                                if (!aVar.isCancelled()) {
                                    this.lYo.put(aVar);
                                }
                                if (-1 > 0) {
                                    currentTimeMillis = System.currentTimeMillis() - -1;
                                    str2 = "MicroMsg.FTS.FTSTaskDaemon";
                                    append = new StringBuilder().append(str).append("[").append(aVar);
                                    if (aVar.isCancelled()) {
                                        str = "] interruputed, ";
                                    } else {
                                        str = "] cancelled, ";
                                    }
                                    w.i(str2, append.append(str).append(currentTimeMillis).append(" ms.").toString());
                                }
                            }
                            a.axA();
                        } catch (Throwable e2) {
                            th = e2;
                            aVar = aVar2;
                            th2 = th;
                            w.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th2, "[%s] failed with exception. \n", new Object[]{obj});
                            if (this.lYt != null) {
                                this.lYt.axC();
                            }
                            e.mQ(18);
                            if (!this.lYu) {
                                g.oUh.d("FTS", obj + ": " + Log.getStackTraceString(th2), null);
                                this.lYu = true;
                            }
                            a.axA();
                        } catch (Throwable e22) {
                            th = e22;
                            aVar = aVar2;
                            th2 = th;
                            w.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th2, "[%s] failed with exception.\n", new Object[]{obj});
                            e.mQ(6);
                            a.axA();
                        } catch (Throwable e222) {
                            th = e222;
                            aVar = aVar2;
                            th2 = th;
                            w.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th2, "[%s] failed with exception.\n", new Object[]{obj});
                            e.mQ(7);
                            a.axA();
                        } catch (Throwable e2222) {
                            th = e2222;
                            aVar = aVar2;
                            th2 = th;
                            if (th2 instanceof NullPointerException) {
                                e.mQ(3);
                            } else if (th2 instanceof SQLiteException) {
                                e.mQ(5);
                            } else if (th2.getMessage() == null && th2.getMessage().contains("the connection is read-only")) {
                                e.mQ(17);
                            } else {
                                e.mQ(4);
                            }
                            w.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th2, "[%s] failed with exception.\n", new Object[]{obj});
                            if (this.lYs != null) {
                                this.lYs.run();
                            }
                            a.axA();
                        }
                    }
                } catch (InterruptedException e3) {
                    str = str3;
                    aVar = null;
                    if (aVar != null) {
                        if (aVar.isCancelled()) {
                            this.lYo.put(aVar);
                        }
                        if (-1 > 0) {
                            currentTimeMillis = System.currentTimeMillis() - -1;
                            str2 = "MicroMsg.FTS.FTSTaskDaemon";
                            append = new StringBuilder().append(str).append("[").append(aVar);
                            if (aVar.isCancelled()) {
                                str = "] interruputed, ";
                            } else {
                                str = "] cancelled, ";
                            }
                            w.i(str2, append.append(str).append(currentTimeMillis).append(" ms.").toString());
                        }
                    }
                    a.axA();
                } catch (SQLiteDatabaseCorruptException e4) {
                    th2 = e4;
                    obj = null;
                    w.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th2, "[%s] failed with exception. \n", new Object[]{obj});
                    if (this.lYt != null) {
                        this.lYt.axC();
                    }
                    e.mQ(18);
                    if (this.lYu) {
                        g.oUh.d("FTS", obj + ": " + Log.getStackTraceString(th2), null);
                        this.lYu = true;
                    }
                    a.axA();
                } catch (com.tencent.mm.plugin.fts.a.a.k e5) {
                    th2 = e5;
                    obj = null;
                    w.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th2, "[%s] failed with exception.\n", new Object[]{obj});
                    e.mQ(6);
                    a.axA();
                } catch (SQLiteDiskIOException e6) {
                    th2 = e6;
                    obj = null;
                    w.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th2, "[%s] failed with exception.\n", new Object[]{obj});
                    e.mQ(7);
                    a.axA();
                } catch (Exception e7) {
                    th2 = e7;
                    obj = null;
                    if (th2 instanceof NullPointerException) {
                        e.mQ(3);
                    } else if (th2 instanceof SQLiteException) {
                        e.mQ(5);
                    } else {
                        if (th2.getMessage() == null) {
                        }
                        e.mQ(4);
                    }
                    w.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th2, "[%s] failed with exception.\n", new Object[]{obj});
                    if (this.lYs != null) {
                        this.lYs.run();
                    }
                    a.axA();
                } catch (Throwable th3) {
                    a.axA();
                }
            }
        }
    }

    public final boolean axD() {
        return this.lYm != null && this.lYm.isAlive();
    }

    public final void quit() {
        if (this.lYm != null && this.lYm.isAlive()) {
            this.lYm.quit();
            try {
                this.lYm.join();
            } catch (InterruptedException e) {
            }
            this.lYm = null;
            w.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon quited.");
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(int i, com.tencent.mm.plugin.fts.a.a.a aVar) {
        if (this.lYm == null) {
            return null;
        }
        aVar.mPriority = i;
        a aVar2 = this.lYm;
        if (aVar2.lYp) {
            return aVar;
        }
        int priority = aVar.getPriority();
        aVar2.lYo.put(aVar);
        if (aVar2.lYq == null) {
            aVar2.mP(priority);
            return aVar;
        } else if (priority >= aVar2.lYn) {
            return aVar;
        } else {
            aVar2.interrupt();
            aVar2.mP(priority);
            return aVar;
        }
    }
}
