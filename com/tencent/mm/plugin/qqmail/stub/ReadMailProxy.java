package com.tencent.mm.plugin.qqmail.stub;

import android.os.Bundle;
import com.tencent.mm.a.o;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.b;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.c;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public class ReadMailProxy extends a {
    private p.a oAx;
    private p.a oBk;
    private b oBl;
    private c oBm;
    private m oBn = new m(this) {
        final /* synthetic */ ReadMailProxy oBp;

        {
            this.oBp = r1;
        }

        public final void onTaskStarted(long j, String str) {
            this.oBp.CLIENT_CALL("onTaskStarted", Long.valueOf(j), str);
        }

        public final void onTaskRemoved(long j) {
            this.oBp.CLIENT_CALL("onTaskRemoved", Long.valueOf(j));
        }

        public final void c(long j, String str, boolean z) {
            this.oBp.CLIENT_CALL("onTaskFinished", Long.valueOf(j));
        }

        public final void d(long j, int i, boolean z) {
            this.oBp.CLIENT_CALL("onTaskFailed", Long.valueOf(j));
        }

        public final void onTaskPaused(long j) {
            this.oBp.CLIENT_CALL("onTaskPaused", Long.valueOf(j));
        }

        public final void bg(long j) {
        }

        public final void j(long j, String str) {
        }
    };
    private i.a oBo = new i.a(this) {
        final /* synthetic */ ReadMailProxy oBp;

        {
            this.oBp = r1;
        }

        public final void rD(int i) {
            this.oBp.CLIENT_CALL("onGetQQMailUnreadSuccess", Integer.valueOf(i));
        }

        public final void aUE() {
            this.oBp.CLIENT_CALL("onGetQQMailUnreadFailed", new Object[0]);
        }
    };

    public ReadMailProxy(d dVar, p.a aVar) {
        super(dVar);
        this.oAx = aVar;
        this.oBk = new p.a(this) {
            final /* synthetic */ ReadMailProxy oBp;

            {
                this.oBp = r1;
            }

            public final boolean onReady() {
                return ((Boolean) this.oBp.CLIENT_CALL("onReady", new Object[0])).booleanValue();
            }

            public final void onSuccess(String str, Map<String, String> map) {
                this.oBp.CLIENT_CALL("onSuccess", str, map);
            }

            public final void onError(int i, String str) {
                this.oBp.CLIENT_CALL("onError", Integer.valueOf(i), str);
            }

            public final void onComplete() {
                this.oBp.CLIENT_CALL("onComplete", new Object[0]);
            }
        };
    }

    public ReadMailProxy(d dVar, p.a aVar, b bVar, c cVar) {
        super(dVar);
        this.oAx = aVar;
        this.oBl = bVar;
        this.oBm = cVar;
        this.oBk = new p.a(this) {
            final /* synthetic */ ReadMailProxy oBp;

            {
                this.oBp = r1;
            }

            public final boolean onReady() {
                return ((Boolean) this.oBp.CLIENT_CALL("onReady", new Object[0])).booleanValue();
            }

            public final void onSuccess(String str, Map<String, String> map) {
                this.oBp.CLIENT_CALL("onSuccess", str, map);
            }

            public final void onError(int i, String str) {
                this.oBp.CLIENT_CALL("onError", Integer.valueOf(i), str);
            }

            public final void onComplete() {
                this.oBp.CLIENT_CALL("onComplete", new Object[0]);
            }
        };
    }

    @e
    public boolean onReady() {
        if (this.oAx == null) {
            return true;
        }
        return this.oAx.onReady();
    }

    @e
    public void onSuccess(String str, Map<String, String> map) {
        if (this.oAx != null) {
            this.oAx.onSuccess(str, map);
        }
    }

    @e
    public void onError(int i, String str) {
        if (this.oAx != null) {
            this.oAx.onError(i, str);
        }
    }

    @e
    public void onComplete() {
        if (this.oAx != null) {
            this.oAx.onComplete();
        }
    }

    @e
    public void onTaskStarted(long j, String str) {
        if (this.oBl != null) {
            b bVar = this.oBl;
            w.d("MicroMsg.ReadMailUI", "onTaskStarted id:%d, saveFilePath:%s", new Object[]{Long.valueOf(j), str});
            bVar.oFP.hgx = ab.getContext().getSharedPreferences("QQMAIL", 4);
            if (bVar.oFP.hgx != null) {
                bVar.oFP.hgx.edit().putString("qqmail_downloadpath", str).commit();
            }
        }
    }

    @e
    public void onTaskRemoved(long j) {
        if (this.oBl != null) {
            w.d("MicroMsg.ReadMailUI", "onTaskRemoved id:%d", new Object[]{Long.valueOf(j)});
        }
    }

    @e
    public void onTaskPaused(long j) {
        if (this.oBl != null) {
            w.d("MicroMsg.ReadMailUI", "onTaskPaused id:%d", new Object[]{Long.valueOf(j)});
        }
    }

    @e
    public void onTaskFinished(long j) {
        if (this.oBl != null) {
            w.d("MicroMsg.ReadMailUI", "onTaskFinished id:%d", new Object[]{Long.valueOf(j)});
        }
    }

    @e
    public void onTaskFailed(long j) {
        if (this.oBl != null) {
            w.d("MicroMsg.ReadMailUI", "onTaskFailed id:%d", new Object[]{Long.valueOf(j)});
        }
    }

    @f
    public long get(String str, Map map, Bundle bundle) {
        p.c cVar = new p.c();
        cVar.fromBundle(bundle);
        return com.tencent.mm.plugin.qqmail.b.w.aUz().b(str, map, cVar, this.oBk);
    }

    @f
    public long post(String str, Map map, Bundle bundle) {
        p.c cVar = new p.c();
        cVar.fromBundle(bundle);
        return com.tencent.mm.plugin.qqmail.b.w.aUz().a(str, map, cVar, this.oBk);
    }

    @f
    public void cancel(final long j) {
        new ae().post(new Runnable(this) {
            final /* synthetic */ ReadMailProxy oBp;

            public final void run() {
                com.tencent.mm.plugin.qqmail.b.w.aUz().cancel(j);
            }
        });
    }

    @f
    public boolean isSDCardAvailable() {
        ap.yY();
        return com.tencent.mm.u.c.isSDCardAvailable();
    }

    @f
    public String getMsgContent(long j) {
        ap.yY();
        return com.tencent.mm.u.c.wT().cA(j).field_content;
    }

    @f
    public void replaceMsgContent(final long j, final String str) {
        new ae().post(new Runnable(this) {
            final /* synthetic */ ReadMailProxy oBp;

            public final void run() {
                ap.yY();
                ce cA = com.tencent.mm.u.c.wT().cA(j);
                cA.setContent(cA.field_content.replaceFirst("<digest>.*</digest>", "<digest>" + str + "</digest>"));
                ap.yY();
                com.tencent.mm.u.c.wT().a(j, cA);
            }
        });
    }

    @f
    public Map getCookie() {
        return com.tencent.mm.plugin.qqmail.b.w.aUz().getCookie();
    }

    @f
    public void deleteMsgById(long j) {
        ap.yY();
        com.tencent.mm.u.c.wT().cB(j);
    }

    @f
    public String getUserBindEmail() {
        return com.tencent.mm.u.m.getUserBindEmail();
    }

    @f
    public void addDownloadCallback() {
        com.tencent.mm.plugin.downloader.model.e.akM();
        com.tencent.mm.plugin.downloader.model.b.c(this.oBn);
    }

    @f
    public void removeDownloadCallback() {
        com.tencent.mm.plugin.downloader.model.e.akM();
        com.tencent.mm.plugin.downloader.model.b.akL();
    }

    @f
    public long downloadQQMailApp(String str, String str2) {
        try {
            URL url = new URL(str);
            URL toURL = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toURL();
            com.tencent.mm.plugin.downloader.model.f.a aVar = new com.tencent.mm.plugin.downloader.model.f.a();
            aVar.tL(toURL.toString());
            aVar.tN("qqmail.apk");
            aVar.tO(str2);
            aVar.dn(true);
            aVar.la(1);
            return com.tencent.mm.plugin.downloader.model.e.akM().a(aVar.kHa);
        } catch (Throwable e) {
            w.e("MicroMsg.ReadMailProxy", "dz[download qq mail error:%s]", new Object[]{e.toString()});
            w.printErrStackTrace("MicroMsg.ReadMailProxy", e, "", new Object[0]);
            return -1;
        }
    }

    @f
    public int removeDownloadQQMailAppTask(long j) {
        return com.tencent.mm.plugin.downloader.model.e.akM().aT(j);
    }

    @f
    public String getBindUin() {
        ap.yY();
        return new o(bg.f((Integer) com.tencent.mm.u.c.vr().get(9, null))).toString();
    }

    @f
    public Integer showMailAppRecommend() {
        if (com.tencent.mm.sdk.platformtools.f.fuV == 1) {
            return Integer.valueOf(0);
        }
        return Integer.valueOf(bg.getInt(g.sW().z("MailApp", "ShowMailAppRecommend"), 0));
    }

    @f
    public String getMailAppEnterUlAndroid() {
        return g.sW().getMailAppEnterUlAndroid();
    }

    @f
    public String getMailAppRedirectUrlAndroid() {
        return g.sW().sK();
    }

    @f
    public Integer getMailAppDownloadStatus(long j) {
        return Integer.valueOf(com.tencent.mm.plugin.downloader.model.e.akM().aU(j).status);
    }

    @f
    public double getMailAppDownloadProgress(long j) {
        FileDownloadTaskInfo aU = com.tencent.mm.plugin.downloader.model.e.akM().aU(j);
        if (aU.fLh <= 0) {
            return 0.0d;
        }
        return (1.0d * ((double) aU.fLg)) / ((double) aU.fLh);
    }

    @f
    public void reportKvState(int i, int i2) {
        com.tencent.mm.plugin.report.service.g.oUh.i(i, new Object[]{Integer.valueOf(i2)});
    }

    @f
    public void reportKvStates(int i, int i2, int i3) {
        com.tencent.mm.plugin.report.service.g.oUh.i(i, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    @f
    public void getUnreadMailCount() {
        i.a(this.oBo);
    }

    @f
    public Object getUneradMailCountFromConfig() {
        ap.yY();
        return com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uAs, Integer.valueOf(-1));
    }
}
