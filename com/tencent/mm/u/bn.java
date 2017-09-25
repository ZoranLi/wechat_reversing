package com.tencent.mm.u;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

@Deprecated
public final class bn {
    public static an hoe;
    private Map<String, am> hoc = new HashMap();
    private Map<am, Boolean> hod = new HashMap();
    private String hof = "";

    public final synchronized void zQ() {
        if (bg.mA(this.hof)) {
            this.hoc.clear();
            this.hod.clear();
            if (hoe != null) {
                this.hoc = hoe.oI();
                w.i("MicroMsg.MMCore.SubCoreMap", "resetSubCore get sub core map from sub core factory. count:%d", Integer.valueOf(this.hoc.size()));
            }
        } else {
            w.w("MicroMsg.MMCore.SubCoreMap", "ERR: Looping:%s , failed to resetSubCore", this.hof);
        }
    }

    public final synchronized void aN(boolean z) {
        long Nz = bg.Nz();
        this.hof = "onSdcardMount";
        for (Entry entry : this.hoc.entrySet()) {
            if (bg.b((Boolean) this.hod.get(entry.getValue()), false)) {
                long Nz2 = bg.Nz();
                ((am) entry.getValue()).aN(z);
                w.i("MicroMsg.MMCore.SubCoreMap", "onSdcardMount %s time:%d", entry.getKey(), Long.valueOf(bg.aA(Nz2)));
            }
        }
        this.hof = "";
        w.i("MicroMsg.MMCore.SubCoreMap", "onSubCoreSdcardMount finish Count:%d time:%d", Integer.valueOf(this.hoc.size()), Long.valueOf(bg.aA(Nz)));
    }

    public final synchronized void aM(boolean z) {
        long Nz = bg.Nz();
        this.hof = "onAccountPostReset";
        for (Entry entry : this.hoc.entrySet()) {
            long Nz2 = bg.Nz();
            ((am) entry.getValue()).aM(z);
            this.hod.put(entry.getValue(), Boolean.valueOf(true));
            w.i("MicroMsg.MMCore.SubCoreMap", "onSubCoreAccountPostReset post:%s %d", entry.getKey(), Long.valueOf(bg.aA(Nz2)));
        }
        this.hof = "";
        w.i("MicroMsg.MMCore.SubCoreMap", "onSubCoreAccountPostReset finish Count:%d time:%d", Integer.valueOf(this.hoc.size()), Long.valueOf(bg.aA(Nz)));
    }

    public final synchronized void zR() {
        long Nz = bg.Nz();
        this.hof = "releaseSubCore";
        for (Entry entry : this.hoc.entrySet()) {
            if (bg.b((Boolean) this.hod.get(entry.getValue()), false)) {
                long Nz2 = bg.Nz();
                w.i("MicroMsg.MMCore.SubCoreMap", "releaseSubCore release:%s begin...", entry.getKey());
                ((am) entry.getValue()).onAccountRelease();
                w.i("MicroMsg.MMCore.SubCoreMap", "releaseSubCore release:%s %d", entry.getKey(), Long.valueOf(bg.aA(Nz2)));
            }
        }
        this.hof = "";
        w.i("MicroMsg.MMCore.SubCoreMap", "releaseSubCore finish Count:%d time:%d", Integer.valueOf(this.hoc.size()), Long.valueOf(bg.aA(Nz)));
    }

    public final synchronized Map<Integer, c> zS() {
        Map<Integer, c> hashMap;
        this.hof = "getSubCoreBaseDBFacotries";
        hashMap = new HashMap();
        for (Entry entry : this.hoc.entrySet()) {
            if (((am) entry.getValue()).uh() != null) {
                hashMap.putAll(((am) entry.getValue()).uh());
            }
        }
        this.hof = "";
        return hashMap;
    }

    public final synchronized void fl(int i) {
        this.hof = "clearSubCorePluginData";
        for (Entry value : this.hoc.entrySet()) {
            ((am) value.getValue()).eD(i);
        }
        this.hof = "";
    }

    public final synchronized boolean a(String str, am amVar) {
        if (!bg.mA(this.hof)) {
            Assert.assertTrue("REFUSE to addSubCore doing:" + this.hof, false);
        }
        this.hoc.put(str, amVar);
        return true;
    }

    public final am gs(String str) {
        return (am) this.hoc.get(str);
    }
}
