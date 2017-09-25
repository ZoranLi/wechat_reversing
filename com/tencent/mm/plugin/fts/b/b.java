package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.ap.j;
import com.tencent.mm.ap.t;
import com.tencent.mm.e.a.fq;
import com.tencent.mm.e.a.ra;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b extends com.tencent.mm.plugin.fts.a.b implements e {
    public k gTU;
    private com.tencent.mm.sdk.b.c maR = new com.tencent.mm.sdk.b.c<ra>(this) {
        final /* synthetic */ b mbx;

        {
            this.mbx = r2;
            this.usg = ra.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            this.mbx.axM();
            return true;
        }
    };
    public com.tencent.mm.plugin.fts.c.b mbv;
    private com.tencent.mm.sdk.b.c mbw = new com.tencent.mm.sdk.b.c<fq>(this) {
        final /* synthetic */ b mbx;

        {
            this.mbx = r2;
            this.usg = fq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            h.vd().a(new j(((fq) bVar).fKH.fKI.mvT, 18), 0);
            return false;
        }
    };

    private class a extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ b mbx;

        public a(b bVar) {
            this.mbx = bVar;
        }

        public final boolean execute() {
            w.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to build feature index task");
            com.tencent.mm.plugin.fts.a.a aVar = this.mbx.mbv;
            List arrayList = new ArrayList();
            Cursor rawQuery = aVar.lYU.rawQuery(String.format("SELECT * FROM Feature", new Object[0]), null);
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.c cVar = new com.tencent.mm.plugin.fts.a.a.c();
                cVar.b(rawQuery);
                arrayList.add(cVar);
            }
            rawQuery.close();
            if (arrayList.size() == 0) {
                try {
                    arrayList = b.xd(t.Ic().aT(0, 18));
                    this.mbx.mbv.aE(arrayList);
                } catch (Exception e) {
                }
            }
            List<com.tencent.mm.plugin.fts.c.b.a> axT = this.mbx.mbv.axT();
            HashMap hashMap = new HashMap();
            for (com.tencent.mm.plugin.fts.a.a.c cVar2 : r0) {
                hashMap.put(Integer.valueOf(cVar2.field_featureId), cVar2);
            }
            if (this.mbx.mbv.lYU.inTransaction()) {
                this.mbx.mbv.commit();
            }
            this.mbx.mbv.beginTransaction();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (com.tencent.mm.plugin.fts.c.b.a aVar2 : axT) {
                com.tencent.mm.plugin.fts.a.a.c cVar3 = (com.tencent.mm.plugin.fts.a.a.c) hashMap.remove(Integer.valueOf(aVar2.mcp));
                if (cVar3 == null) {
                    hashSet.add(Integer.valueOf(aVar2.mcp));
                } else if (aVar2.timestamp != cVar3.field_timestamp) {
                    hashSet2.add(cVar3);
                    this.mbx.mbv.a(com.tencent.mm.plugin.fts.a.c.lZf, Long.valueOf((long) cVar3.field_featureId).longValue());
                    ((PluginFTS) h.j(PluginFTS.class)).getTopHitsLogic().c(com.tencent.mm.plugin.fts.a.c.lZf, String.valueOf(cVar3.field_featureId));
                }
            }
            hashSet2.addAll(hashMap.values());
            this.mbx.mbv.commit();
            this.mbx.mbv.beginTransaction();
            w.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "remove %d add %d", new Object[]{Integer.valueOf(hashSet.size()), Integer.valueOf(hashSet2.size())});
            Iterator it = hashSet2.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.fts.a.a.c cVar4 = (com.tencent.mm.plugin.fts.a.a.c) it.next();
                b bVar = this.mbx;
                bVar.mbv.a(262144, 1, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, cVar4.field_title);
                String X = d.X(cVar4.field_title, false);
                if (!bg.mA(X)) {
                    bVar.mbv.a(262144, 2, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, X);
                }
                X = d.X(cVar4.field_title, true);
                if (!bg.mA(X)) {
                    bVar.mbv.a(262144, 3, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, X);
                }
                bVar.mbv.a(262144, 4, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, cVar4.field_tag);
                ((PluginFTS) h.j(PluginFTS.class)).getTopHitsLogic().xf(String.valueOf(cVar4.field_featureId));
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                this.mbx.mbv.a(com.tencent.mm.plugin.fts.a.c.lZf, Long.valueOf((long) ((Integer) it2.next()).intValue()).longValue());
            }
            this.mbx.mbv.commit();
            return true;
        }

        public final String getName() {
            return "BuildFeatureIndexTask";
        }

        public final int getId() {
            return 5;
        }
    }

    private class b extends com.tencent.mm.plugin.fts.a.a.e {
        final /* synthetic */ b mbx;

        public b(b bVar, f fVar) {
            this.mbx = bVar;
            super(fVar);
        }

        protected final List<i> a(String[] strArr, f fVar) {
            List<i> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            Cursor a = this.mbx.mbv.a(strArr, com.tencent.mm.plugin.fts.a.c.lZf, true);
            while (a.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.j jVar = new com.tencent.mm.plugin.fts.a.a.j();
                jVar.e(a);
                if (!(hashSet.contains(Long.valueOf(jVar.mam)) || fVar.mae.contains(jVar.lZO))) {
                    jVar.axK();
                    arrayList.add(jVar);
                    hashSet.add(Long.valueOf(jVar.mam));
                }
            }
            if (a != null) {
                a.close();
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (fVar.maf != null) {
                Collections.sort(arrayList, fVar.maf);
            }
            for (i iVar : arrayList) {
                iVar.userData = this.mbx.mbv.mR((int) iVar.mam);
            }
            return arrayList;
        }

        public final String getName() {
            return "SearchFeatureTask";
        }

        public final int getId() {
            return 12;
        }
    }

    private class c extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ b mbx;
        private String path;

        public c(b bVar, String str) {
            this.mbx = bVar;
            this.path = str;
        }

        public final String getName() {
            return "UpdateFeatureIndexTask";
        }

        public final boolean execute() {
            List xd = b.xd(this.path);
            this.mbx.mbv.beginTransaction();
            this.mbx.mbv.aE(xd);
            this.mbx.mbv.commit();
            this.mbx.mbv.i(com.tencent.mm.plugin.fts.a.c.lZf);
            this.mbx.gTU.a(131132, new a(this.mbx));
            e topHitsLogic = ((PluginFTS) h.j(PluginFTS.class)).getTopHitsLogic();
            topHitsLogic.mbW.e(com.tencent.mm.plugin.fts.a.c.lZf, 1);
            return true;
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(f fVar) {
        return this.gTU.a(-65536, new b(this, fVar));
    }

    protected final boolean onCreate() {
        if (((l) h.j(l.class)).isFTSContextReady()) {
            w.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Success!");
            this.gTU = ((l) h.j(l.class)).getFTSTaskDaemon();
            this.mbv = (com.tencent.mm.plugin.fts.c.b) ((l) h.j(l.class)).getFTSIndexStorage(17);
            h.vd().a(JsApiSetBackgroundAudioState.CTRL_INDEX, this);
            this.maR.bIy();
            this.mbw.bIy();
            this.gTU.a(131132, new a(this));
            return true;
        }
        w.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Fail!");
        return false;
    }

    protected final boolean tT() {
        h.vd().b(JsApiSetBackgroundAudioState.CTRL_INDEX, this);
        this.maR.dead();
        this.mbw.dead();
        this.mbv = null;
        this.gTU = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchFeatureLogic";
    }

    public final void axM() {
        if (t.Ic().aQ(0, 18) != null) {
            this.gTU.a(65596, new c(this, t.Ic().aT(0, 18)));
            return;
        }
        w.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "updateLanguageListener check first setup app: pack info is null");
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if (kVar instanceof j) {
            j jVar = (j) kVar;
            if (jVar.fFz != 18) {
                return;
            }
            if (i == 0 || i2 == 0) {
                axM();
            } else {
                w.e("MicroMsg.FTS.FTS5SearchFeatureLogic", "onGYNetEnd id:" + jVar.hOj + " errtype:" + i + " errCode:" + i2 + " errMsg:" + str);
            }
        }
    }

    private static void axN() {
        String aT = t.Ic().aT(0, 18);
        com.tencent.mm.a.e.d(new File(aT));
        com.tencent.mm.loader.stub.b.deleteFile(aT + ".zip");
        w.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "delete unzipPath: %s", new Object[]{aT});
    }

    public static List<com.tencent.mm.plugin.fts.a.a.c> xd(String str) {
        StringBuilder append = new StringBuilder().append(str);
        String str2 = "/feature/feature_%s.conf";
        Object[] objArr = new Object[1];
        String ea = v.ea(ab.getContext());
        ea = ea.equalsIgnoreCase("zh_CN") ? "zh_CN".toLowerCase() : (ea.equalsIgnoreCase("zh_TW") || ea.equalsIgnoreCase("zh_HK")) ? "zh_TW".toLowerCase() : "en".toLowerCase();
        objArr[0] = ea;
        ea = append.append(String.format(str2, objArr)).toString();
        long lastModified = new File(ea).lastModified();
        int aN = com.tencent.mm.a.e.aN(ea);
        List<com.tencent.mm.plugin.fts.a.a.c> arrayList = new ArrayList();
        if (aN == 0) {
            axN();
            throw new com.tencent.mm.plugin.fts.a.a.k("data file no exist error");
        }
        String[] split = new String(com.tencent.mm.a.e.d(ea, 0, aN)).split("\n");
        com.tencent.mm.plugin.fts.a.a.c cVar = null;
        for (String str3 : split) {
            String str32;
            if (str32 != null) {
                str32 = str32.trim();
                if (str32.length() != 0) {
                    int indexOf = str32.indexOf("=");
                    if (indexOf >= 0) {
                        String substring = str32.substring(0, indexOf);
                        str32 = str32.substring(indexOf + 1);
                        if (substring.equals("FeatureID")) {
                            if (cVar != null) {
                                cVar.field_iconPath = str + "/feature/" + cVar.field_featureId + ".png";
                                arrayList.add(cVar);
                            }
                            cVar = new com.tencent.mm.plugin.fts.a.a.c();
                            cVar.field_featureId = Integer.valueOf(str32).intValue();
                            cVar.field_timestamp = lastModified;
                        }
                        if (cVar != null) {
                            if (substring.equals("Title")) {
                                cVar.field_title = str32;
                            } else if (substring.equals("TitlePY")) {
                                cVar.field_titlePY = str32;
                            } else if (substring.equals("TitleShortPY")) {
                                cVar.field_titleShortPY = str32;
                            } else if (substring.equals("Tag")) {
                                cVar.field_tag = str32;
                            } else if (substring.equals("ActionType")) {
                                if (str32.equals("H5")) {
                                    cVar.field_actionType = 2;
                                } else if (str32.equals("Native")) {
                                    cVar.field_actionType = 1;
                                }
                            } else if (substring.equals("Url")) {
                                cVar.field_url = str32;
                            } else if (substring.equals("HelpUrl")) {
                                cVar.field_helpUrl = str32;
                            } else if (substring.equals("UpdateUrl")) {
                                cVar.field_updateUrl = str32;
                            } else if (substring.equals("AndroidUrl")) {
                                cVar.field_androidUrl = str32;
                            }
                        }
                    }
                }
            }
        }
        if (cVar != null) {
            cVar.field_iconPath = str + "/feature/" + cVar.field_featureId + ".png";
            cVar.field_timestamp = lastModified;
            arrayList.add(cVar);
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        axN();
        throw new com.tencent.mm.plugin.fts.a.a.k("no data error");
    }
}
