package com.tencent.mm.plugin.card.a;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class m implements com.tencent.mm.modelgeo.a.a, e {
    private ae handler;
    private String kdA;
    public v kdB;
    public Map<String, Set<a>> kdy = new HashMap();
    public HashMap<String, String> kdz = new HashMap();

    public interface a {
        void a(boolean z, ArrayList<iw> arrayList);
    }

    public m() {
        ap.vd().a(563, this);
        this.handler = new ae(Looper.getMainLooper());
    }

    public final void a(String str, a aVar) {
        synchronized (this.kdy) {
            try {
                if (this.kdy.get(str) != null) {
                    ((Set) this.kdy.get(str)).remove(aVar);
                }
            } catch (Exception e) {
            }
        }
        synchronized (this.kdz) {
            this.kdz.remove(str);
        }
    }

    private void a(final String str, final boolean z, final ArrayList<iw> arrayList) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ m kdD;

            public final void run() {
                Set set = (Set) this.kdD.kdy.get(str);
                if (set != null && set.size() > 0) {
                    Set<a> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (a aVar : hashSet) {
                        if (aVar != null) {
                            aVar.a(z, arrayList);
                        }
                    }
                }
            }
        });
    }

    public final boolean a(String str, String str2, a aVar) {
        int i;
        w.d("MicroMsg.CardShopLBSManager", "getShopList, cardTpId = %s, card_id = %s", new Object[]{str, str2});
        this.kdA = str;
        synchronized (this.kdy) {
            if (!this.kdy.containsKey(str)) {
                this.kdy.put(str, new HashSet());
            }
            if (!((Set) this.kdy.get(str)).contains(aVar)) {
                ((Set) this.kdy.get(str)).add(aVar);
            }
        }
        synchronized (this.kdz) {
            if (!TextUtils.isEmpty(str2)) {
                this.kdz.put(str, str2);
            }
        }
        com.tencent.mm.modelgeo.a Gk = c.Gk();
        if (Gk == null) {
            w.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
            i = 0;
        } else {
            Gk.b(this);
            i = 1;
        }
        if (i == 0) {
            w.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
            return false;
        }
        if (this.kdB != null) {
            ap.vd().c(this.kdB);
        }
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.kdB = null;
        String str2 = ((v) kVar).kfO;
        w.i("MicroMsg.CardShopLBSManager", "onSceneEnd, reqCardTpId = %s, errType = %d, errCode = %d", new Object[]{str2, Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            ArrayList arrayList = ((v) kVar).kfP;
            String str3 = "MicroMsg.CardShopLBSManager";
            String str4 = "onSceneEnd, respShopList size = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
            w.d(str3, str4, objArr);
            a(str2, true, arrayList);
            return;
        }
        w.e("MicroMsg.CardShopLBSManager", "onSceneEnd, cardshoplbs fail");
        a(str2, false, null);
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return true;
        }
        com.tencent.mm.modelgeo.a Gk = c.Gk();
        if (Gk != null) {
            Gk.c(this);
        }
        w.d("MicroMsg.CardShopLBSManager", "onGetLocation, fLongitude = %f, fLatitude = %f, locType = %d, speed = %f, accuracy = %f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2)});
        Set set = (Set) this.kdy.get(this.kdA);
        if (set == null || set.size() == 0) {
            w.e("MicroMsg.CardShopLBSManager", "onGetLocation, already cancelled, no need to doScene");
            return false;
        }
        k vVar = new v(this.kdA, f, f2, (String) this.kdz.get(this.kdA));
        if (ap.vd().a(vVar, 0)) {
            this.kdB = vVar;
        } else {
            w.e("MicroMsg.CardShopLBSManager", "doScene fail, callback immediate");
            a(this.kdA, false, null);
        }
        return true;
    }
}
