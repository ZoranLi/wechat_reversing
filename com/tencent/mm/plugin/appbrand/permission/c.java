package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public class c {
    private static final int iIy = (-bg.getInt(r.iiR, 0));
    public static final android.support.v4.e.a<String, c> jfw = new android.support.v4.e.a();
    private static final c jfx = new c() {
        public final a a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, com.tencent.mm.plugin.appbrand.jsapi.b bVar, b bVar2) {
            return a.jfE;
        }
    };
    private final h ixr;
    final LinkedList<b> jfy = new LinkedList();

    public static final class a {
        public static final a jfB = new a(2, "fail:auth canceled");
        public static final a jfC = new a(2, "fail:auth denied");
        public static final a jfD = new a(3, "");
        public static final a jfE = new a(2, "fail:access denied");
        public static final a jfF = new a(1, "");
        public final int code;
        public final String fEr;

        a(int i, String str) {
            this.code = i;
            this.fEr = str;
        }
    }

    public interface b {
        void a(a aVar);
    }

    public static c e(h hVar) {
        if (hVar == null || TextUtils.isEmpty(hVar.ivH)) {
            w.e("MicroMsg.AppRuntimeApiPermissionController", "obtain dummy controller, stack %s", new Object[]{bg.g(new Throwable())});
            return jfx;
        }
        c cVar;
        synchronized (jfw) {
            cVar = (c) jfw.get(hVar.ivH);
            if (cVar == null) {
                cVar = new c(hVar);
                jfw.put(hVar.ivH, cVar);
            }
        }
        return cVar;
    }

    public static int a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, com.tencent.mm.plugin.appbrand.jsapi.b bVar) {
        String appId = cVar.getAppId();
        int i = iIy;
        int SO = bVar.SO();
        if (i == -1) {
            w.d("MicroMsg.AppRuntimeApiPermissionController", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm on", new Object[]{appId, Integer.valueOf(SO)});
            return 1;
        } else if (i == -2) {
            w.d("MicroMsg.AppRuntimeApiPermissionController", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm off", new Object[]{appId, Integer.valueOf(SO)});
            return 0;
        } else {
            AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(appId);
            AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle = null;
            if (mY != null) {
                appRuntimeApiPermissionBundle = mY.iET;
                if (appRuntimeApiPermissionBundle != null) {
                    byte[] bArr;
                    int i2;
                    if (cVar instanceof m) {
                        switch (cVar.PI().iwC.iAk.QD()) {
                            case SUSPEND:
                            case DESTROYED:
                            case BACKGROUND:
                                bArr = appRuntimeApiPermissionBundle.jfu;
                                break;
                            default:
                                bArr = appRuntimeApiPermissionBundle.jft;
                                break;
                        }
                    }
                    bArr = appRuntimeApiPermissionBundle.jft;
                    if (SO == -2) {
                        i = 1;
                    } else if (SO == -1) {
                        i = 0;
                    } else if (SO >= bArr.length || SO < 0) {
                        i = 0;
                    } else {
                        i = bArr[SO];
                    }
                    if (com.tencent.mm.compatible.loader.a.a(l.iLc, bVar.getClass()) || com.tencent.mm.compatible.loader.a.a(l.iLd, bVar.getClass())) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        w.i("MicroMsg.AppRuntimeApiPermissionController", "getCtrlByte, appId = %s, apiName = %s, ctrlIndex = %d, ctrlIndexLength %d, checkRet %d", new Object[]{appId, bVar.getName(), Integer.valueOf(SO), Integer.valueOf(bArr.length), Integer.valueOf(i)});
                    }
                    return i;
                }
            }
            w.e("MicroMsg.AppRuntimeApiPermissionController", "getCtrlByte, appId = %s, apiName = %s, invalid permission data config %s bundle %s", new Object[]{appId, bVar.getName(), mY, appRuntimeApiPermissionBundle});
            return 0;
        }
    }

    public static boolean b(com.tencent.mm.plugin.appbrand.jsapi.c cVar, com.tencent.mm.plugin.appbrand.jsapi.b bVar) {
        return a(cVar, bVar) == 1;
    }

    public c(h hVar) {
        this.ixr = hVar;
        if (hVar != null) {
            final String str = hVar.ivH;
            e.a(str, new com.tencent.mm.plugin.appbrand.e.b(this) {
                final /* synthetic */ c jfz;

                public final void onDestroy() {
                    synchronized (c.jfw) {
                        c.jfw.remove(str);
                    }
                    c cVar = this.jfz;
                    synchronized (cVar.jfy) {
                        cVar.jfy.clear();
                    }
                }
            });
            hVar.iwC.a(new com.tencent.mm.plugin.appbrand.a.b.a(this) {
                final /* synthetic */ c jfz;

                {
                    this.jfz = r1;
                }

                public final void a(com.tencent.mm.plugin.appbrand.a.a aVar) {
                    if (com.tencent.mm.plugin.appbrand.a.a.FOREGROUND == aVar) {
                        c cVar = this.jfz;
                        LinkedList linkedList = new LinkedList();
                        synchronized (cVar.jfy) {
                            linkedList.addAll(cVar.jfy);
                            cVar.jfy.clear();
                        }
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            ((b) it.next()).a(a.jfF);
                        }
                    }
                }
            });
        }
    }

    public a a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, com.tencent.mm.plugin.appbrand.jsapi.b bVar, final b bVar2) {
        if (bVar == null || cVar == null) {
            return a.jfE;
        }
        com.tencent.mm.plugin.appbrand.a.a QD = cVar.PI().iwC.iAk.QD();
        int a = a(cVar, bVar);
        String appId = cVar.getAppId();
        if (a == 6) {
            a.a(cVar.PI(), bVar);
            return a.jfE;
        } else if (a == 1) {
            if (!(cVar instanceof m) || QD != com.tencent.mm.plugin.appbrand.a.a.SUSPEND || !com.tencent.mm.compatible.loader.a.a(l.iLe, bVar.getClass())) {
                return a.jfF;
            }
            return new a(2, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[]{bVar.getName(), QD.name().toLowerCase(), "permission ok", "network api interrupted in suspend state"}));
        } else if (a == 4) {
            if (b.bc(appId, bVar.getName())) {
                return a.jfF;
            }
            b.a(appId, bVar.getName(), new com.tencent.mm.plugin.appbrand.permission.b.b(this) {
                final /* synthetic */ c jfz;

                public final void Wi() {
                    if (bVar2 != null) {
                        bVar2.a(a.jfF);
                    }
                }

                public final void Wj() {
                    if (bVar2 != null) {
                        bVar2.a(a.jfC);
                    }
                }

                public final void onCancel() {
                    if (bVar2 != null) {
                        bVar2.a(a.jfB);
                    }
                }
            });
            return a.jfD;
        } else if (a == 7) {
            boolean z;
            com.tencent.mm.plugin.appbrand.a.c cVar2 = this.ixr.iwC.iAk;
            switch (cVar2.QD()) {
                case FOREGROUND:
                    z = true;
                    break;
                case SUSPEND:
                case DESTROYED:
                    z = false;
                    break;
                case BACKGROUND:
                    z = ((Boolean) new bb<Boolean>(cVar2) {
                        final /* synthetic */ c iAy;

                        {
                            this.iAy = r1;
                        }

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        protected final /* synthetic */ java.lang.Object run() {
                            /*
                            r4 = this;
                            r0 = 1;
                            r1 = 0;
                            r2 = r4.iAy;
                            r2 = r2.bKi();
                            r3 = r4.iAy;
                            r3 = r3.iAq;
                            if (r2 != r3) goto L_0x0022;
                        L_0x000e:
                            r2 = r4.iAy;
                            r2 = r2.iAq;
                            r2 = r2.iAG;
                            r2 = r2 & 1;
                            if (r2 <= 0) goto L_0x0020;
                        L_0x0018:
                            r2 = r0;
                        L_0x0019:
                            if (r2 == 0) goto L_0x0022;
                        L_0x001b:
                            r0 = java.lang.Boolean.valueOf(r0);
                            return r0;
                        L_0x0020:
                            r2 = r1;
                            goto L_0x0019;
                        L_0x0022:
                            r0 = r1;
                            goto L_0x001b;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.a.c.3.run():java.lang.Object");
                        }
                    }.b(cVar2.iAo)).booleanValue();
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                return a.jfF;
            }
            return new a(2, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[]{bVar.getName(), QD.name().toLowerCase(), "permission ok", "jsapi permission required playing audio but current not playing audio in background state"}));
        } else if (a != 8) {
            return a.jfE;
        } else {
            if (bVar2 != null) {
                synchronized (this.jfy) {
                    this.jfy.addLast(bVar2);
                }
            }
            return a.jfD;
        }
    }
}
