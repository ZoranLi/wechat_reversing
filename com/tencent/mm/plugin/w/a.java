package com.tencent.mm.plugin.w;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.gt;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class a implements com.tencent.mm.kernel.api.bucket.a, b, c, e, com.tencent.mm.kernel.b.b {
    private static HashMap<Integer, g.c> gJr;
    private static a ofh;
    private i jIH;
    private com.tencent.mm.pluginsdk.model.app.c jII;
    private com.tencent.mm.pluginsdk.model.app.e ofi;
    private h ofj;
    private m ofk;
    private d ofl;
    private com.tencent.mm.sdk.b.c ofm = new com.tencent.mm.sdk.b.c<gt>(this) {
        final /* synthetic */ a ofn;

        {
            this.ofn = r2;
            this.usg = gt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            a.aRs().Jl(((gt) bVar).fMe.appId);
            return false;
        }
    };

    private a() {
        com.tencent.mm.plugin.w.a.a.a.a(new com.tencent.mm.plugin.w.a.a(this) {
            final /* synthetic */ a ofn;

            {
                this.ofn = r1;
            }

            public final f Cl(String str) {
                return a.aRr().Me(str);
            }

            public final Cursor qT(int i) {
                Cursor rawQuery = a.aRr().rawQuery("select * from AppInfo where status = 5" + " order by modifyTime asc", new String[0]);
                if (rawQuery != null) {
                    return rawQuery;
                }
                w.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
                return null;
            }

            public final Cursor m(int[] iArr) {
                i aRr = a.aRr();
                String str = "select * from AppInfo where ";
                for (int i = 0; i <= 0; i++) {
                    str = str + " status = " + iArr[0];
                }
                Cursor rawQuery = aRr.rawQuery(str + " order by status desc, modifyTime asc", new String[0]);
                if (rawQuery != null) {
                    return rawQuery;
                }
                w.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
                return null;
            }

            public final Bitmap a(String str, int i, float f) {
                a.aRr();
                if (str == null || str.length() == 0) {
                    w.e("MicroMsg.AppInfoStorage", "getIcon : invalid argument");
                    return null;
                } else if (str.equals("wx7fa037cc7dfabad5")) {
                    return BitmapFactory.decodeResource(ab.getContext().getResources(), com.tencent.mm.plugin.comm.a.c.bpD);
                } else {
                    String cw = i.cw(str, i);
                    if (com.tencent.mm.a.e.aO(cw)) {
                        return BackwardSupportUtil.b.c(cw, f);
                    }
                    w.e("MicroMsg.AppInfoStorage", "icon does not exist, iconPath = " + cw + ", iconType = " + i);
                    return null;
                }
            }

            public final void bv(String str, int i) {
                a.aRp().cu(str, i);
            }

            public final void Cm(String str) {
                a.aRq().Mc(str);
            }

            public final void c(f fVar) {
                i aRr = a.aRr();
                if (fVar != null && fVar.field_status != 5) {
                    fVar.field_status = 3;
                    w.i("MicroMsg.AppInfoStorage", "setBlack package name = %s", fVar.field_packageName);
                    aRr.a(fVar, new String[0]);
                }
            }

            public final void d(f fVar) {
                i aRr = a.aRr();
                if (fVar != null && fVar.field_status == 3) {
                    fVar.field_status = 4;
                    aRr.a(fVar, new String[0]);
                }
            }

            public final void e(f fVar) {
                a.aRr().a(fVar, new String[0]);
            }

            public final i aRt() {
                return a.aRr();
            }

            public final void Z(LinkedList<String> linkedList) {
                a.aRq().at(linkedList);
            }

            public final Cursor cG(int i, int i2) {
                return a.aRr().cG(i, i2);
            }

            public final Cursor aRu() {
                i aRr = a.aRr();
                StringBuilder stringBuilder = new StringBuilder(256);
                stringBuilder.append("select * from AppInfo");
                stringBuilder.append(" where ");
                stringBuilder.append("serviceAppType > 0");
                Cursor rawQuery = aRr.rawQuery(stringBuilder.toString(), new String[0]);
                if (rawQuery == null) {
                    w.e("MicroMsg.AppInfoStorage", "getAllServices : cursor is null");
                    return null;
                }
                w.d("MicroMsg.AppInfoStorage", "getAllServices count = %d", Integer.valueOf(rawQuery.getCount()));
                return rawQuery;
            }
        });
    }

    public static a aRo() {
        if (ofh == null) {
            synchronized (a.class) {
                if (ofh == null) {
                    ofh = new a();
                }
            }
        }
        return ofh;
    }

    public List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"openapi/"});
        return linkedList;
    }

    public static String xm() {
        return com.tencent.mm.kernel.h.vI().gYf + "openapi/";
    }

    public static com.tencent.mm.pluginsdk.model.app.c abL() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (aRo().jII == null) {
            aRo().jII = new com.tencent.mm.pluginsdk.model.app.c(com.tencent.mm.kernel.h.vI().gYg);
        }
        return aRo().jII;
    }

    public static com.tencent.mm.pluginsdk.model.app.e aRp() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (aRo().ofi == null) {
            aRo().ofi = new com.tencent.mm.pluginsdk.model.app.e();
        }
        return aRo().ofi;
    }

    public static h aRq() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (aRo().ofj == null) {
            aRo().ofj = new h();
        }
        return aRo().ofj;
    }

    public static i aRr() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (aRo().jIH == null) {
            aRo().jIH = new i(com.tencent.mm.kernel.h.vI().gYg);
        }
        return aRo().jIH;
    }

    public static m aRs() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (aRo().ofk == null) {
            aRo().ofk = new m();
        }
        return aRo().ofk;
    }

    public static d aBG() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (aRo().ofl == null) {
            aRo().ofl = new d();
        }
        return aRo().ofl;
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.f fVar) {
        com.tencent.mm.u.x.a.hlQ = aRq();
        com.tencent.mm.sdk.b.a.urY.b(this.ofm);
    }

    public void onAccountRelease() {
        com.tencent.mm.y.e eVar = aRo().ofj;
        if (eVar != null) {
            com.tencent.mm.kernel.h.vH().gXC.b(231, eVar);
            aBG().b(7, eVar);
        }
        com.tencent.mm.pluginsdk.model.app.e eVar2 = aRo().ofi;
        if (eVar2 != null) {
            eVar2.sCZ.clear();
            eVar2.pmb.clear();
            eVar2.sDa.clear();
        }
        t tVar = aRo().ofk;
        if (tVar != null) {
            w.d("MicroMsg.AppSettingService", "stop service");
            tVar.sDz.clear();
            aBG().b(1, tVar);
        }
        if (this.ofl != null) {
            eVar = this.ofl;
            com.tencent.mm.kernel.h.vH().gXC.b(452, eVar);
            eVar.htd.clear();
        }
        if (aRo().jIH != null) {
            aRo().jIH.sDr.clear();
        }
        com.tencent.mm.sdk.b.a.urY.c(this.ofm);
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("APPATTACHINFO_TABLE".hashCode()), new g.c() {
            public final String[] pP() {
                return com.tencent.mm.pluginsdk.model.app.c.gUx;
            }
        });
        gJr.put(Integer.valueOf("APPINFO_TABLE".hashCode()), new g.c() {
            public final String[] pP() {
                return i.gUx;
            }
        });
    }

    public HashMap<Integer, g.c> collectDatabaseFactory() {
        return gJr;
    }

    public void onDataBaseOpened(g gVar, g gVar2) {
    }

    public void onDataBaseClosed(g gVar, g gVar2) {
        this.jII = null;
        this.jIH = null;
    }
}
