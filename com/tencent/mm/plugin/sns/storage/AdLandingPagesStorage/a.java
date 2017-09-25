package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.text.TextUtils;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    public ConcurrentHashMap<Long, WeakReference<a>> qeQ = new ConcurrentHashMap();
    public ConcurrentHashMap<String, b> qeR = new ConcurrentHashMap();

    public interface a {
        void bdI();

        void bdJ();

        void bdK();

        void bdL();

        void bdM();

        void sT(int i);

        void start();
    }

    public static class b implements Serializable {
        public String qdX;
        public String qeT;

        public b(String str, String str2) {
            this.qdX = str;
            this.qeT = str2;
        }
    }

    private static final class c {
        public static final a qeU = new a();
    }

    public a() {
        e.akM();
        com.tencent.mm.plugin.downloader.model.b.a(new m(this) {
            final /* synthetic */ a qeS;

            {
                this.qeS = r1;
            }

            public final void onTaskStarted(long j, String str) {
                this.qeS.C(1, j);
            }

            public final void c(long j, String str, boolean z) {
                WeakReference weakReference = (WeakReference) this.qeS.qeQ.get(Long.valueOf(j));
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.bdK();
                        this.qeS.qeQ.remove(Long.valueOf(j));
                    }
                    this.qeS.C(3, j);
                }
            }

            public final void d(long j, int i, boolean z) {
                WeakReference weakReference = (WeakReference) this.qeS.qeQ.get(Long.valueOf(j));
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.bdL();
                        this.qeS.qeQ.remove(Long.valueOf(j));
                    }
                    this.qeS.C(8, j);
                }
            }

            public final void onTaskRemoved(long j) {
                WeakReference weakReference = (WeakReference) this.qeS.qeQ.get(Long.valueOf(j));
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.bdJ();
                        this.qeS.qeQ.remove(Long.valueOf(j));
                    }
                    this.qeS.C(2, j);
                }
            }

            public final void onTaskPaused(long j) {
                WeakReference weakReference = (WeakReference) this.qeS.qeQ.get(Long.valueOf(j));
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.bdI();
                    }
                    this.qeS.C(6, j);
                }
            }

            public final void bg(long j) {
                WeakReference weakReference = (WeakReference) this.qeS.qeQ.get(Long.valueOf(j));
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        FileDownloadTaskInfo aU = e.akM().aU(j);
                        if (aU.fLg >= 0 && aU.fLh > 0) {
                            aVar.sT((int) ((aU.fLg * 100) / aU.fLh));
                        }
                    }
                }
            }

            public final void j(long j, String str) {
                WeakReference weakReference = (WeakReference) this.qeS.qeQ.get(Long.valueOf(j));
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.bdM();
                    }
                    this.qeS.C(7, j);
                }
            }
        });
    }

    public static void stopTask(long j) {
        e.akM().aT(j);
    }

    public static long queryIdByAppid(String str) {
        FileDownloadTaskInfo tI = e.akM().tI(str);
        return tI != null ? tI.id : Long.MAX_VALUE;
    }

    public final void C(int i, long j) {
        com.tencent.mm.plugin.downloader.b.a bh = ((com.tencent.mm.plugin.downloader.a.a) h.h(com.tencent.mm.plugin.downloader.a.a.class)).wX().bh(j);
        if (bh != null) {
            String str = bh.field_appId;
            bh = ((com.tencent.mm.plugin.downloader.a.a) h.h(com.tencent.mm.plugin.downloader.a.a.class)).wX().tE(str);
            if (bh == null) {
                w.i("MicroMsg.AdDownloadApkMgr", "downloadinfo not found");
                return;
            }
            String str2 = bh.field_packageName;
            String str3 = bh.field_md5;
            b(i, str, str2, bh.field_downloadUrl);
        }
    }

    private static String n(Object... objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(String.valueOf(objArr[i])).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[3]));
        return stringBuilder.toString();
    }

    public final void b(int i, String str, String str2, String str3) {
        System.currentTimeMillis();
        b bVar = (b) this.qeR.get(str);
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.replaceAll("\\.", "_");
        }
        String str4 = bVar == null ? "" : bVar.qdX + "." + bVar.qeT + "." + str2 + ".0.20.0";
        w.i("MicroMsg.AdDownloadApkMgr", "reporting %d  %s", new Object[]{Integer.valueOf(14542), n(str, Integer.valueOf(i), str3, str4)});
        g.oUh.A(14542, str4);
    }
}
