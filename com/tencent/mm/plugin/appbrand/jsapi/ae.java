package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.plugin.appbrand.appcache.l;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

final class ae extends a {
    private static final int CTRL_INDEX = 120;
    private static final String NAME = "getImageInfo";
    public static final Collection<b> iMU;

    private interface b {
        com.tencent.mm.vending.j.a f(h hVar, String str);
    }

    private static final class c {
        public int height;
        public int width;
    }

    private enum e {
        FILE_NOT_FOUND,
        UNKNOWN_FAIL,
        RESOLVED
    }

    private static final class a implements b {
        public final com.tencent.mm.vending.j.a f(h hVar, String str) {
            if (!str.startsWith("wxfile://")) {
                return null;
            }
            AppBrandLocalMediaObject aH = com.tencent.mm.plugin.appbrand.appstorage.c.aH(hVar.ivH, str);
            if (aH == null || bg.mA(aH.hos) || !com.tencent.mm.a.e.aO(aH.hos)) {
                return com.tencent.mm.vending.j.a.bP(e.FILE_NOT_FOUND);
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(aH.hos, options);
            c cVar = new c();
            cVar.width = options.outWidth;
            cVar.height = options.outHeight;
            return com.tencent.mm.vending.j.a.u(e.RESOLVED, cVar);
        }
    }

    private static final class d implements b {
        public final com.tencent.mm.vending.j.a f(h hVar, String str) {
            Closeable d = l.d(hVar, str);
            if (d == null) {
                return com.tencent.mm.vending.j.a.bP(e.FILE_NOT_FOUND);
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(d, new Rect(), options);
            bg.g(d);
            c cVar = new c();
            cVar.width = options.outWidth;
            cVar.height = options.outHeight;
            return com.tencent.mm.vending.j.a.u(e.RESOLVED, cVar);
        }
    }

    ae() {
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        final String optString = jSONObject.optString("src");
        if (bg.mA(optString)) {
            mVar.x(i, d("fail:invalid data", null));
            return;
        }
        final WeakReference weakReference = new WeakReference(mVar);
        final m mVar2 = mVar;
        final int i2 = i;
        com.tencent.mm.sdk.f.e.b(new Runnable(this) {
            final /* synthetic */ ae iMW;

            public final void run() {
                com.tencent.mm.vending.j.a aVar = null;
                for (b f : ae.iMU) {
                    aVar = f.f(mVar2.ixr, optString);
                    if (aVar != null) {
                        break;
                    }
                }
                com.tencent.mm.vending.j.a aVar2 = aVar;
                if (weakReference.get() != null && ((m) weakReference.get()).aaI) {
                    if (aVar2 != null) {
                        String d;
                        switch ((e) aVar2.get(0)) {
                            case FILE_NOT_FOUND:
                                d = this.iMW.d("fail:file not found", null);
                                break;
                            case RESOLVED:
                                Map hashMap = new HashMap(2);
                                hashMap.put("width", Integer.valueOf(((c) aVar2.get(1)).width));
                                hashMap.put("height", Integer.valueOf(((c) aVar2.get(1)).height));
                                d = this.iMW.d("ok", hashMap);
                                break;
                            default:
                                d = this.iMW.d("fail", null);
                                break;
                        }
                        ((m) weakReference.get()).x(i2, d);
                        return;
                    }
                    ((m) weakReference.get()).x(i2, this.iMW.d("fail:src not support", null));
                }
            }
        }, String.format(Locale.US, "AppBrandJsApiGetImageInfo[%s]", new Object[]{optString}), 10);
    }

    static {
        Collection linkedList = new LinkedList();
        linkedList.add(new a());
        linkedList.add(new d());
        iMU = Collections.unmodifiableCollection(linkedList);
    }
}
