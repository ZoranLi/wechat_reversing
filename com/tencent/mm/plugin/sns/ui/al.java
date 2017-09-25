package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public final class al {
    public static i a(Context context, p pVar, ViewGroup viewGroup, int i) {
        i iVar = null;
        if (pVar != null) {
            switch (pVar.type) {
                case 21:
                    if (pVar.fEC == 2) {
                        return new m(context, (b) pVar, viewGroup);
                    }
                    if (pVar.fEC == 6) {
                        return new q(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i) pVar, viewGroup);
                    }
                    if (pVar.fEC == 7) {
                        return new r(context, (h) pVar, viewGroup);
                    }
                    break;
                case v.CTRL_BYTE /*41*/:
                    switch (pVar.fEC) {
                        case 0:
                            iVar = new u(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m) pVar, viewGroup);
                            break;
                        case 1:
                            iVar = new l(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m) pVar, viewGroup);
                            break;
                        default:
                            break;
                    }
                case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                    iVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h(context, pVar, viewGroup);
                    break;
                case 101:
                    iVar = new n(context, (k) pVar, viewGroup);
                    break;
                case 102:
                    iVar = new c(context, (j) pVar, viewGroup);
                    break;
                case 103:
                    o oVar = (o) pVar;
                    oVar.bgColor = i;
                    iVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p(context, oVar, viewGroup);
                    break;
                case 104:
                    iVar = new e(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e) pVar, viewGroup);
                    break;
                case 132:
                    iVar = new z(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v) pVar, viewGroup);
                    break;
                default:
                    w.i("SnsAdNativeLandingPagesLayoutHelper", "unknown comp type " + pVar.type);
                    break;
            }
        }
        if (iVar != null) {
            return iVar;
        }
        if (pVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r) {
            iVar = new y(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r) pVar, viewGroup);
            iVar.setBackgroundColor(i);
            return iVar;
        } else if (pVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i) {
            iVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i) pVar, viewGroup);
            iVar.setBackgroundColor(i);
            return iVar;
        } else if (pVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m) {
            return new u(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m) pVar, viewGroup);
        } else {
            if (pVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) {
                return new s(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) pVar, viewGroup);
            }
            if (pVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n) {
                return new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n) pVar, viewGroup);
            }
            if (pVar instanceof t) {
                return new x(context, (t) pVar, viewGroup);
            }
            if (pVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s) {
                return new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s) pVar, viewGroup);
            }
            if (pVar instanceof g) {
                return new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g(context, (g) pVar, viewGroup);
            }
            if (pVar instanceof d) {
                return new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d(context, (d) pVar, viewGroup);
            }
            if (pVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) {
                return new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) pVar, viewGroup);
            }
            return new i(context, pVar, viewGroup);
        }
    }
}
