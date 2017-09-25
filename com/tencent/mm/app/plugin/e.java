package com.tencent.mm.app.plugin;

import android.content.Context;
import com.tencent.mm.pluginsdk.ui.applet.i;
import com.tencent.mm.pluginsdk.ui.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

public final class e implements b {
    private static e fxW = null;
    URISpanHandlerSet fxX;
    ArrayList<BaseUriSpanHandler> fxY = new ArrayList();
    ArrayList<BaseUriSpanHandler> fxZ = new ArrayList();
    ArrayList<BaseUriSpanHandler> fya = new ArrayList();
    Context mContext = null;

    public static e oM() {
        if (fxW == null) {
            fxW = new e();
        }
        return fxW;
    }

    private e() {
        long Nz = bg.Nz();
        w.d("MicroMsg.URISpanHandler", "init URISpanHandler");
        this.mContext = ab.getContext();
        this.fxX = new URISpanHandlerSet(this.mContext);
        for (Class cls : URISpanHandlerSet.class.getDeclaredClasses()) {
            if (cls != null && cls.getSuperclass() != null && cls.isAnnotationPresent(a.class) && cls.getSuperclass().getName().equals(BaseUriSpanHandler.class.getName())) {
                try {
                    a aVar = (a) cls.getAnnotation(a.class);
                    Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{URISpanHandlerSet.class});
                    if (declaredConstructor != null) {
                        BaseUriSpanHandler baseUriSpanHandler = (BaseUriSpanHandler) BaseUriSpanHandler.class.cast(declaredConstructor.newInstance(new Object[]{this.fxX}));
                        PRIORITY oO = aVar.oO();
                        if (oO == PRIORITY.LOW) {
                            this.fya.add(baseUriSpanHandler);
                        } else if (oO == PRIORITY.NORMAL) {
                            this.fxZ.add(baseUriSpanHandler);
                        } else if (oO == PRIORITY.HIGH) {
                            this.fxY.add(baseUriSpanHandler);
                        }
                        w.d("MicroMsg.URISpanHandler", "successfully add: %s", cls.getName());
                    } else {
                        w.d("MicroMsg.URISpanHandler", "failed to add %s, constructor is null!!", cls.getName());
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.URISpanHandler", e, "", new Object[0]);
                    w.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", cls.getName(), e.getMessage(), e.getClass().getName());
                }
            }
        }
        w.d("MicroMsg.URISpanHandler", "init URISpanHandler used :%d ms", Long.valueOf(bg.Nz() - Nz));
    }

    public final i q(Context context, String str) {
        w.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url:%s, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size：%d", str, Integer.valueOf(this.fxY.size()), Integer.valueOf(this.fxZ.size()), Integer.valueOf(this.fya.size()));
        if (context == null) {
            w.e("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl error, context is null!");
            this.fxX.mContext = null;
            return null;
        }
        this.mContext = context;
        this.fxX.mContext = this.mContext;
        if (bg.mA(str)) {
            w.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url is null");
            this.mContext = null;
            this.fxX.mContext = null;
            return null;
        }
        Iterator it = this.fxY.iterator();
        while (it.hasNext()) {
            i bv = ((BaseUriSpanHandler) it.next()).bv(str);
            if (bv != null) {
                w.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(bv.type));
                this.mContext = null;
                this.fxX.mContext = null;
                return bv;
            }
        }
        it = this.fxZ.iterator();
        while (it.hasNext()) {
            bv = ((BaseUriSpanHandler) it.next()).bv(str);
            if (bv != null) {
                w.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(bv.type));
                this.mContext = null;
                this.fxX.mContext = null;
                return bv;
            }
        }
        it = this.fya.iterator();
        while (it.hasNext()) {
            bv = ((BaseUriSpanHandler) it.next()).bv(str);
            if (bv != null) {
                w.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(bv.type));
                this.mContext = null;
                this.fxX.mContext = null;
                return bv;
            }
        }
        this.mContext = null;
        this.fxX.mContext = null;
        w.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, nothing match");
        return null;
    }

    public final boolean a(Context context, i iVar, com.tencent.mm.pluginsdk.ui.d.e eVar) {
        if (iVar == null) {
            w.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo is null");
            return false;
        }
        boolean z;
        String str = "MicroMsg.URISpanHandler";
        String str2 = "handleSpanClick, hrefInfo.getType:%d, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size:%d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(iVar.type);
        if (eVar == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(this.fxY.size());
        objArr[3] = Integer.valueOf(this.fxZ.size());
        objArr[4] = Integer.valueOf(this.fya.size());
        w.d(str, str2, objArr);
        if (context == null) {
            w.e("MicroMsg.URISpanHandler", "handleSpanClick, context is null!");
            this.fxX.mContext = null;
            return false;
        }
        this.mContext = context;
        this.fxX.mContext = this.mContext;
        Iterator it = this.fxY.iterator();
        while (it.hasNext()) {
            BaseUriSpanHandler baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (b(baseUriSpanHandler.oN(), iVar.type) && baseUriSpanHandler.a(iVar, eVar)) {
                w.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", baseUriSpanHandler.getClass().getName());
                this.mContext = null;
                this.fxX.mContext = null;
                return true;
            }
        }
        it = this.fxZ.iterator();
        while (it.hasNext()) {
            baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (b(baseUriSpanHandler.oN(), iVar.type) && baseUriSpanHandler.a(iVar, eVar)) {
                w.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", baseUriSpanHandler.getClass().getName());
                this.mContext = null;
                this.fxX.mContext = null;
                return true;
            }
        }
        it = this.fya.iterator();
        while (it.hasNext()) {
            baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (b(baseUriSpanHandler.oN(), iVar.type) && baseUriSpanHandler.a(iVar, eVar)) {
                w.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", baseUriSpanHandler.getClass().getName());
                this.mContext = null;
                this.fxX.mContext = null;
                return true;
            }
        }
        this.mContext = null;
        this.fxX.mContext = null;
        w.d("MicroMsg.URISpanHandler", "handleSpanClick, nothing handle");
        return false;
    }

    private static boolean b(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
