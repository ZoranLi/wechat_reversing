package com.tencent.mm.plugin.sns.model;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.a.pp;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.SnsTransparentUI;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.jw;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.c;
import com.tencent.mm.u.o;
import com.tencent.mm.u.q;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AdLandingPagesProxy extends com.tencent.mm.remoteservice.a {
    private static AdLandingPagesProxy pSm;
    private e htR = new e(this) {
        final /* synthetic */ AdLandingPagesProxy pSs;

        {
            this.pSs = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            w.i("AdLandingPagesProxy", "errType %d,errCode %d,errMsg %s,scene %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, kVar.toString()});
            long longValue;
            if (kVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b) {
                if (i != 0 || i2 != 0) {
                    w.e("AdLandingPagesProxy", "the netscene is error ,error type is " + i + " error msg is " + str);
                } else if (kVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b) {
                    w.i("AdLandingPagesProxy", "the dynamic string is " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b) kVar).fQC);
                    if (this.pSs.pSo.containsKey(kVar)) {
                        longValue = ((Long) this.pSs.pSo.remove(kVar)).longValue();
                        this.pSs.CLIENT_CALL("onDynamicUpdateEnd", Long.valueOf(longValue), r1);
                    }
                }
            } else if ((kVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a) && this.pSs.pSo.containsKey(kVar)) {
                byte[] toByteArray;
                longValue = ((Long) this.pSs.pSo.remove(kVar)).longValue();
                jw jwVar = (jw) ((com.tencent.mm.y.b) kVar.hsK).hsk.hsr;
                if (i == 0 && i2 == 0 && jwVar != null) {
                    try {
                        toByteArray = jwVar.toByteArray();
                    } catch (Throwable e) {
                        w.e("AdLandingPagesProxy", bg.g(e));
                        return;
                    }
                }
                toByteArray = null;
                this.pSs.CLIENT_CALL("onAdChannelEnd", Long.valueOf(longValue), Integer.valueOf(i), Integer.valueOf(i2), toByteArray);
            }
        }
    };
    private Map<Long, a> pSn = new HashMap();
    private Map<k, Long> pSo = new HashMap();
    private d pSp;
    private Map<Long, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a> pSq = new HashMap();
    private Map<Long, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a> pSr = new HashMap();

    public interface a {
        void ak(Object obj);

        void f(int i, int i2, Object obj);
    }

    private class b implements com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a {
        public long id;
        final /* synthetic */ AdLandingPagesProxy pSs;

        public b(AdLandingPagesProxy adLandingPagesProxy) {
            this.pSs = adLandingPagesProxy;
        }

        public final void start() {
            this.pSs.CLIENT_CALL("start", Long.valueOf(this.id));
        }

        public final void sT(int i) {
            w.v("AdLandingPagesProxy", "progress %d", new Object[]{Integer.valueOf(i)});
            this.pSs.CLIENT_CALL("progress", Long.valueOf(this.id), Integer.valueOf(i));
        }

        public final void bdI() {
            this.pSs.CLIENT_CALL("paused", Long.valueOf(this.id));
        }

        public final void bdJ() {
            this.pSs.CLIENT_CALL("stopped", Long.valueOf(this.id));
        }

        public final void bdK() {
            this.pSs.CLIENT_CALL("succeed", Long.valueOf(this.id));
        }

        public final void bdL() {
            this.pSs.CLIENT_CALL("failed", Long.valueOf(this.id));
        }

        public final void bdM() {
            this.pSs.CLIENT_CALL("resumed", Long.valueOf(this.id));
        }
    }

    static /* synthetic */ void a(AdLandingPagesProxy adLandingPagesProxy, String str) {
        long PY;
        int indexOf = str.indexOf("<canvasId>");
        if (indexOf >= 0) {
            int indexOf2 = str.indexOf("</canvasId>");
            if (indexOf2 > indexOf) {
                PY = (long) bg.PY(str.substring(indexOf + 10, indexOf2));
                if (PY > 0) {
                    w.i("AdLandingPagesProxy", "caching canvasId %d", new Object[]{Long.valueOf(PY)});
                    i.bgZ().n(PY, str);
                }
            }
        }
        PY = 0;
        if (PY > 0) {
            w.i("AdLandingPagesProxy", "caching canvasId %d", new Object[]{Long.valueOf(PY)});
            i.bgZ().n(PY, str);
        }
    }

    public static void create(d dVar) {
        pSm = new AdLandingPagesProxy(dVar);
    }

    public AdLandingPagesProxy(d dVar) {
        super(dVar);
        if (dVar == null) {
            h.vJ();
            h.vH().gXC.a(1337, this.htR);
            h.vJ();
            h.vH().gXC.a(1210, this.htR);
        }
        this.pSp = dVar;
    }

    public static AdLandingPagesProxy getInstance() {
        if (pSm != null) {
            return pSm;
        }
        throw new IllegalStateException("init first");
    }

    public boolean isConnected() {
        return this.pSp == null ? false : this.pSp.isConnected();
    }

    public void onRelease() {
        h.vJ();
        h.vH().gXC.b(1337, this.htR);
        h.vJ();
        h.vH().gXC.b(1210, this.htR);
    }

    public Object getCfg(int i, Object obj) {
        Object REMOTE_CALL = REMOTE_CALL("getCfgMM", Integer.valueOf(i), obj);
        return REMOTE_CALL == null ? obj : REMOTE_CALL;
    }

    @f
    public Object getCfgMM(int i, Object obj) {
        h.vJ();
        return h.vI().vr().get(i, obj);
    }

    public int contactGetTypeTextFromUserName(String str) {
        Object REMOTE_CALL = REMOTE_CALL("contactGetTypeTextFromUserNameMM", str);
        return REMOTE_CALL == null ? 0 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public int contactGetTypeTextFromUserNameMM(String str) {
        return o.fG(str);
    }

    public String getSnsStatExtBySnsId(long j) {
        return (String) REMOTE_CALL("getSnsStatExtBySnsIdMM", Long.valueOf(j));
    }

    @f
    public String getSnsStatExtBySnsIdMM(long j) {
        com.tencent.mm.plugin.sns.storage.e dz = ae.beN().dz(j);
        if (dz != null) {
            bfc bhd = dz.bhd();
            if (bhd != null) {
                return com.tencent.mm.plugin.sns.a.a.f.Ex(bhd.qui);
            }
            w.v("SnsAdExtUtil", "getSnsStatExt timeLineObject null");
            return null;
        }
        w.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[]{Long.valueOf(j)});
        return "";
    }

    public String getAccSnsPath() {
        return (String) REMOTE_CALL("getAccSnsPathMM", new Object[0]);
    }

    @f
    public String getAccSnsPathMM() {
        return ae.getAccSnsPath();
    }

    public m getSnsInfo(String str) {
        Bundle bundle = (Bundle) REMOTE_CALL("getSnsInfoMM", str);
        if (bundle == null) {
            return null;
        }
        m mVar = new m();
        if (bundle != null) {
            ContentValues contentValues = (ContentValues) bundle.getParcelable("values");
            mVar.field_snsId = contentValues.getAsLong("snsId").longValue();
            mVar.field_userName = contentValues.getAsString("userName");
            mVar.field_localFlag = contentValues.getAsInteger("localFlag").intValue();
            mVar.field_createTime = contentValues.getAsInteger("createTime").intValue();
            mVar.field_head = contentValues.getAsInteger("head").intValue();
            mVar.field_localPrivate = contentValues.getAsInteger("localPrivate").intValue();
            mVar.field_type = contentValues.getAsInteger(Columns.TYPE).intValue();
            mVar.field_sourceType = contentValues.getAsInteger("sourceType").intValue();
            mVar.field_likeFlag = contentValues.getAsInteger("likeFlag").intValue();
            mVar.field_pravited = contentValues.getAsInteger("pravited").intValue();
            mVar.field_stringSeq = contentValues.getAsString("stringSeq");
            mVar.field_content = contentValues.getAsByteArray("content");
            mVar.field_attrBuf = contentValues.getAsByteArray("attrBuf");
            mVar.field_postBuf = contentValues.getAsByteArray("postBuf");
            mVar.field_subType = contentValues.getAsInteger("subType").intValue();
            if (contentValues.containsKey("rowid")) {
                mVar.uxb = contentValues.getAsLong("rowid").longValue();
            }
            mVar.qnk = bundle.getInt("localid");
            bundle = bundle.getBundle("adValues");
            if (bundle != null) {
                com.tencent.mm.plugin.sns.storage.e eVar = new com.tencent.mm.plugin.sns.storage.e();
                eVar.B(bundle);
                mVar.qnu = eVar;
            }
        }
        return mVar;
    }

    @f
    public Bundle getSnsInfoMM(String str) {
        m Gf = ae.beL().Gf(str);
        if (Gf == null) {
            return null;
        }
        return Gf.bhg();
    }

    public boolean useOnlineStreamPlayer() {
        Object REMOTE_CALL = REMOTE_CALL("useOnlineStreamPlayerMM", new Object[0]);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean useOnlineStreamPlayerMM() {
        c dX = com.tencent.mm.u.c.c.Az().dX("100208");
        if (!dX.isValid()) {
            return false;
        }
        int i = bg.getInt((String) dX.bKK().get("useOnlineVideoPlayer"), 0);
        w.i("AdLandingPagesProxy", "useOnlineVideoPlayer abtest=" + i);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @f
    public int getExpValueByKeyMM(String str, int i) {
        return com.tencent.mm.u.c.c.AA().cF(str, i);
    }

    public int getExpValueByKey(String str, int i) {
        Object REMOTE_CALL = REMOTE_CALL("getExpValueByKeyMM", str, Integer.valueOf(i));
        return REMOTE_CALL == null ? -1 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public String getExpIdByKeyMM(String str) {
        return com.tencent.mm.u.c.c.AA().getExpIdByKey(str);
    }

    public String getExpIdByKey(String str) {
        return (String) REMOTE_CALL("getExpIdByKeyMM", str);
    }

    public int isAutoAdDownload() {
        Object REMOTE_CALL = REMOTE_CALL("isAutoAdDownloadMM", new Object[0]);
        return REMOTE_CALL == null ? 0 : ((Integer) REMOTE_CALL).intValue();
    }

    public void favEditTag() {
        REMOTE_CALL("favEditTagMM", new Object[0]);
    }

    @f
    public void favEditTagMM() {
        com.tencent.mm.sdk.b.b fpVar = new fp();
        fpVar.fKp.type = 35;
        com.tencent.mm.sdk.b.a.urY.m(fpVar);
    }

    @f
    public int isAutoAdDownloadMM() {
        return ae.beI().b(null, null);
    }

    public int doFavAdlanding(long j, String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, String str7) {
        Object REMOTE_CALL = REMOTE_CALL("doFavAdlandingMM", Long.valueOf(j), str, Integer.valueOf(i), str2, str3, str4, str5, str6, Integer.valueOf(i2), str7);
        return REMOTE_CALL == null ? 0 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public int doFavAdlandingMM(long j, String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, String str7) {
        boolean z = false;
        cb cbVar = new cb();
        if ((i == 1 || i == 2 || i == 3 || i == 4 || i == 9 || i == 10 || i == 11) && !bg.mA(str)) {
            com.tencent.mm.sdk.b.b ppVar = new pp();
            ppVar.fWv.fWy = str;
            ppVar.fWv.fWz = cbVar;
            ppVar.fWv.url = str2;
            com.tencent.mm.sdk.b.a.urY.m(ppVar);
            z = ppVar.fWw.fFj;
        } else if ((i == 5 || i == 6) && j != -2147483648L) {
            z = ((com.tencent.mm.plugin.fav.a.b) h.h(com.tencent.mm.plugin.fav.a.b.class)).a(cbVar, j);
        } else if (i == 13 || i == 14) {
            z = ((com.tencent.mm.plugin.fav.a.b) h.h(com.tencent.mm.plugin.fav.a.b.class)).a(cbVar, str4.hashCode(), com.tencent.mm.u.m.xL(), str4, str5, str6, str7);
        }
        if (z) {
            cbVar.fFA.fFF = q.fQ(str3);
            cbVar.fFA.title = str4;
            cbVar.fFA.desc = str5;
            rv rvVar = cbVar.fFA.fFC;
            if (!(rvVar == null || rvVar.tzn == null || rvVar.tzn.size() <= 0 || rvVar.tzn.get(0) == null)) {
                ((rm) rvVar.tzn.get(0)).Ok(str6);
                ((rm) rvVar.tzn.get(0)).NL(str4);
                ((rm) rvVar.tzn.get(0)).NM(str5);
            }
            rvVar.OB(str4);
            rvVar.OC(str5);
            cbVar.fFA.fFH = i2;
            com.tencent.mm.sdk.b.a.urY.m(cbVar);
            return cbVar.fFA.fFG;
        }
        if (cbVar.fFA.fFG == 0) {
            cbVar.fFA.fFG = j.eij;
        }
        return cbVar.fFA.fFG;
    }

    public int doFav(Intent intent, int i) {
        Object REMOTE_CALL = REMOTE_CALL("doFavMM", intent, Integer.valueOf(i));
        return REMOTE_CALL == null ? 0 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public int doFavMM(Intent intent, int i) {
        cb cbVar = new cb();
        ((com.tencent.mm.plugin.fav.a.b) h.h(com.tencent.mm.plugin.fav.a.b.class)).a(cbVar, intent);
        cbVar.fFA.fFH = i;
        com.tencent.mm.sdk.b.a.urY.m(cbVar);
        return cbVar.fFA.fFG;
    }

    public void doTransimt(Activity activity, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(ab.getContext(), SnsTransparentUI.class);
        intent.putExtra("adlandingXml", str);
        intent.putExtra("shareTitle", str2);
        intent.putExtra("shareThumbUrl", str3);
        intent.putExtra("shareDesc", str4);
        intent.putExtra("shareUrl", str5);
        intent.putExtra("op", 2);
        activity.startActivity(intent);
    }

    @f
    public void doTransimtMM(String str, String str2, String str3, String str4, String str5) {
    }

    public void doDynamicUpdateScene(String str, String str2, String str3, a aVar) {
        this.pSn.put(Long.valueOf(System.currentTimeMillis()), aVar);
        REMOTE_CALL("doDynamicUpdateSceneMM", Long.valueOf(r0), str, str2, str3);
    }

    @f
    public void doDynamicUpdateSceneMM(long j, String str, String str2, String str3) {
        k bVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b(str, str2, str3);
        this.pSo.put(bVar, Long.valueOf(j));
        h.vJ();
        h.vH().gXC.a(bVar, 0);
    }

    @com.tencent.mm.remoteservice.e
    public void onDynamicUpdateEnd(long j, String str) {
        a aVar = (a) this.pSn.remove(Long.valueOf(j));
        if (aVar != null) {
            aVar.ak(str);
        }
    }

    @com.tencent.mm.remoteservice.e
    public void onAdChannelEnd(long j, int i, int i2, Object obj) {
        a aVar = (a) this.pSn.remove(Long.valueOf(j));
        if (aVar != null) {
            aVar.f(i, i2, obj);
        }
    }

    public void doAdChannelScene(String str, String str2, a aVar) {
        this.pSn.put(Long.valueOf(System.currentTimeMillis()), aVar);
        REMOTE_CALL("doAdChannelSceneMM", Long.valueOf(r0), str, str2);
    }

    @f
    public void doAdChannelSceneMM(long j, String str, String str2) {
        k aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a(str, str2);
        this.pSo.put(aVar, Long.valueOf(j));
        h.vJ();
        h.vH().gXC.a(aVar, 0);
    }

    public void onCallback(String str, Bundle bundle, boolean z) {
        w.d("AdLandingPagesProxy", "class:%s, method:%s, clientCall:%B", new Object[]{getClass().getName(), str, Boolean.valueOf(z)});
        Method method = null;
        try {
            for (Method method2 : getClass().getMethods()) {
                if (method2.getName().equalsIgnoreCase(str)) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? com.tencent.mm.remoteservice.e.class : f.class)) {
                    Object invoke = method.invoke(this, getArgs(bundle));
                    if (method.getReturnType() == Void.TYPE) {
                        return;
                    }
                    if (invoke instanceof Parcelable) {
                        bundle.putParcelable("result_key", (Parcelable) invoke);
                    } else {
                        bundle.putSerializable("result_key", (Serializable) invoke);
                    }
                }
            }
        } catch (Throwable e) {
            w.e("AdLandingPagesProxy", "exception:%s", new Object[]{bg.g(e)});
        }
    }

    @com.tencent.mm.remoteservice.e
    public boolean isApkExist(String str) {
        Object REMOTE_CALL = REMOTE_CALL("isApkExistMM", str);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean isApkExistMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.qeU;
        FileDownloadTaskInfo tI = com.tencent.mm.plugin.downloader.model.e.akM().tI(str);
        return (tI == null || TextUtils.isEmpty(tI.path) || !new File(tI.path).exists()) ? false : true;
    }

    @f
    public boolean isDownloadingMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.qeU;
        FileDownloadTaskInfo tI = com.tencent.mm.plugin.downloader.model.e.akM().tI(str);
        return tI != null && tI.status == 1;
    }

    public boolean isDownloading(String str) {
        Object REMOTE_CALL = REMOTE_CALL("isDownloadingMM", str);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean isPkgInstalledMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.qeU;
        Context context = ab.getContext();
        return (context == null || TextUtils.isEmpty(str)) ? false : p.n(context, str);
    }

    public boolean isPkgInstalled(String str) {
        Object REMOTE_CALL = REMOTE_CALL("isPkgInstalledMM", str);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean isPausedMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.qeU;
        FileDownloadTaskInfo tI = com.tencent.mm.plugin.downloader.model.e.akM().tI(str);
        return tI != null && tI.status == 2;
    }

    public boolean isPaused(String str) {
        Object REMOTE_CALL = REMOTE_CALL("isPausedMM", str);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @com.tencent.mm.remoteservice.e
    public void start(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.pSr.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.start();
        }
    }

    @com.tencent.mm.remoteservice.e
    public void progress(long j, int i) {
        w.v("AdLandingPagesProxy", "progress client id %d , progress %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.pSr.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.sT(i);
        }
    }

    @com.tencent.mm.remoteservice.e
    public void paused(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.pSr.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.bdI();
        }
    }

    @com.tencent.mm.remoteservice.e
    public void stopped(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.pSr.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.bdJ();
            this.pSr.remove(Long.valueOf(j));
        }
    }

    @com.tencent.mm.remoteservice.e
    public void succeed(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.pSr.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.bdK();
            this.pSr.remove(Long.valueOf(j));
        }
    }

    @com.tencent.mm.remoteservice.e
    public void failed(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.pSr.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.bdL();
            this.pSr.remove(Long.valueOf(j));
        }
    }

    @com.tencent.mm.remoteservice.e
    public void resumed(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a) this.pSr.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.bdM();
        }
    }

    @f
    public long startDownloadMM(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7) {
        b bVar = new b(this);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.qeU;
        com.tencent.mm.plugin.downloader.model.f.a aVar2 = new com.tencent.mm.plugin.downloader.model.f.a();
        aVar2.setAppId(str);
        aVar2.bl(str2);
        aVar2.tO(str3);
        aVar2.tL(str4);
        aVar2.tN(str5);
        aVar2.dn(z);
        long a = com.tencent.mm.plugin.downloader.model.e.akM().a(aVar2.kHa);
        aVar.qeQ.put(Long.valueOf(a), new WeakReference(bVar));
        aVar.qeR.put(str, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b(str6, str7));
        this.pSq.put(Long.valueOf(a), bVar);
        w.v("AdLandingPagesProxy", "startDownloadMM, id %d", new Object[]{Long.valueOf(a)});
        bVar.id = a;
        return a;
    }

    public long startDownload(String str, String str2, String str3, String str4, String str5, boolean z, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar, String str6, String str7) {
        w.v("AdLandingPagesProxy", "startDownload");
        Object REMOTE_CALL = REMOTE_CALL("startDownloadMM", str, str2, str3, str4, str5, Boolean.valueOf(z), str6, str7);
        long longValue = REMOTE_CALL == null ? -1 : ((Long) REMOTE_CALL).longValue();
        this.pSr.put(Long.valueOf(longValue), aVar);
        return longValue;
    }

    @f
    public void stopTaskMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.qeU;
        FileDownloadTaskInfo tI = com.tencent.mm.plugin.downloader.model.e.akM().tI(str);
        if (tI != null) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.stopTask(tI.id);
        }
    }

    public void stopTask(String str) {
        REMOTE_CALL("stopTaskMM", str);
    }

    public void stopTaskMM(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.qeU;
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.stopTask(j);
    }

    public void stopTask(long j) {
        REMOTE_CALL("stopTaskMM", Long.valueOf(j));
    }

    @f
    public long queryIdByAppidMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.qeU;
        return com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str);
    }

    public long queryIdByAppid(String str) {
        Object REMOTE_CALL = REMOTE_CALL("queryIdByAppidMM", str);
        return REMOTE_CALL == null ? -1 : ((Long) REMOTE_CALL).longValue();
    }

    @f
    public boolean pauseTaskByAppidMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.qeU;
        return com.tencent.mm.plugin.downloader.model.e.akM().aV(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str));
    }

    public boolean pauseTaskByAppid(String str) {
        Object REMOTE_CALL = REMOTE_CALL("pauseTaskByAppidMM", str);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean pauseTaskMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.qeU;
        return com.tencent.mm.plugin.downloader.model.e.akM().aV(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str));
    }

    public boolean pauseTask(String str) {
        Object REMOTE_CALL = REMOTE_CALL("pauseTaskMM", str);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public boolean pauseTaskMM(long j) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.qeU;
        return com.tencent.mm.plugin.downloader.model.e.akM().aV(j);
    }

    public boolean pauseTask(long j) {
        Object REMOTE_CALL = REMOTE_CALL("pauseTaskMM", Long.valueOf(j));
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public int getTaskProgressMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.qeU;
        FileDownloadTaskInfo tI = com.tencent.mm.plugin.downloader.model.e.akM().tI(str);
        return tI.fLh != 0 ? (int) ((tI.fLg * 100) / tI.fLh) : 0;
    }

    public int getTaskProgress(String str) {
        Object REMOTE_CALL = REMOTE_CALL("getTaskProgressMM", str);
        return REMOTE_CALL == null ? -1 : ((Integer) REMOTE_CALL).intValue();
    }

    @f
    public boolean resumeTaskMM(String str, String str2, String str3) {
        b bVar = new b(this);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.qeU;
        long queryIdByAppid = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str);
        this.pSq.put(Long.valueOf(queryIdByAppid), bVar);
        bVar.id = queryIdByAppid;
        aVar = c.qeU;
        FileDownloadTaskInfo tI = com.tencent.mm.plugin.downloader.model.e.akM().tI(str);
        if (tI == null) {
            return false;
        }
        aVar.qeQ.put(Long.valueOf(tI.id), new WeakReference(bVar));
        aVar.qeR.put(str, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b(str2, str3));
        return com.tencent.mm.plugin.downloader.model.e.akM().aW(tI.id);
    }

    public boolean resumeTask(String str, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar, String str2, String str3) {
        Object REMOTE_CALL = REMOTE_CALL("resumeTaskMM", str, str2, str3);
        boolean booleanValue = REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
        if (booleanValue) {
            this.pSr.put(Long.valueOf(queryIdByAppid(str)), aVar);
        }
        return booleanValue;
    }

    @f
    public boolean installAppMM(String str) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.qeU;
        Context context = ab.getContext();
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        FileDownloadTaskInfo tI = com.tencent.mm.plugin.downloader.model.e.akM().tI(str);
        if (tI == null || tI.status != 3 || TextUtils.isEmpty(tI.path)) {
            return false;
        }
        Uri fromFile = Uri.fromFile(new File(tI.path));
        aVar.C(4, tI.id);
        return com.tencent.mm.pluginsdk.model.app.q.e(context, fromFile);
    }

    public boolean installApp(Context context, String str) {
        Object REMOTE_CALL = REMOTE_CALL("installAppMM", str);
        return REMOTE_CALL == null ? false : ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public void reportDownloadInfoMM(int i, String str, String str2, String str3, String str4) {
        c.qeU.b(i, str, str2, str4);
    }

    public void reportDownloadInfo(int i, String str, String str2, String str3, String str4) {
        REMOTE_CALL("reportDownloadInfoMM", Integer.valueOf(i), str, str2, str3, str4);
    }

    @f
    public void addReportInfoMM(String str, String str2, String str3) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.qeU;
        if (str != null && str.length() != 0) {
            aVar.qeR.put(str, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b(str2, str3));
        }
    }

    public void addReportInfo(String str, String str2, String str3) {
        REMOTE_CALL("addReportInfoMM", str, str2, str3);
    }

    public void writeDeferredDeepLink(String str, String str2) {
        REMOTE_CALL("writeDeferredDeepLinkMM", str, str2);
    }

    @f
    public void writeDeferredDeepLinkMM(String str, String str2) {
        bdH().edit().putString(str, str2).commit();
    }

    public void deleteDeferredDeepLink(String str) {
        REMOTE_CALL("deleteDeferredDeepLinkMM", str);
    }

    @f
    public void deleteDeferredDeepLinkMM(String str) {
        bdH().edit().remove(str).commit();
    }

    private static SharedPreferences bdH() {
        return ab.getContext().getSharedPreferences(ab.getPackageName() + "_comm_preferences", 0);
    }

    @com.tencent.mm.remoteservice.e
    public void addCanvasCache(long j, String str) {
        REMOTE_CALL("addCanvasCacheMM", Long.valueOf(j), str);
    }

    @f
    public void addCanvasCacheMM(long j, String str) {
        i.bgZ().n(j, str);
    }

    @com.tencent.mm.remoteservice.e
    public void asyncCacheXml(String str) {
        REMOTE_CALL("asyncCacheXmlMM", str);
    }

    @f
    public void asyncCacheXmlMM(final String str) {
        h.vJ();
        h.vL().e(new Runnable(this) {
            final /* synthetic */ AdLandingPagesProxy pSs;

            public final void run() {
                m Gf = ae.beL().Gf(str);
                if (Gf != null) {
                    com.tencent.mm.plugin.sns.storage.b bha = Gf.bha();
                    if (bha != null) {
                        AdLandingPagesProxy.a(this.pSs, bha.bfL());
                        AdLandingPagesProxy.a(this.pSs, bha.bfM());
                    }
                }
            }
        }, 5000);
    }
}
