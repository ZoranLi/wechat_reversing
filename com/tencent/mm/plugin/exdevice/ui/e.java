package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.f.b.a.d;

final class e {
    int afo;
    d lpF;
    int lpG;

    static class a {
        int afo;
        String lmI;
        d lpF = null;
        int lpG;
        String username;

        public final e aqG() {
            return new e(this.afo, this.lpG, this.lmI, this.username, this.lpF);
        }
    }

    public e(int i, int i2, String str, String str2, d dVar) {
        this.afo = i;
        this.lpG = i2;
        if (i == 0) {
            return;
        }
        if (dVar != null) {
            this.lpF = dVar;
            return;
        }
        d dVar2 = new d();
        dVar2.field_username = str2;
        dVar2.field_appusername = str;
        dVar2.field_ranknum = 0;
        dVar2.field_selfLikeState = 0;
        dVar2.field_rankID = "";
        dVar2.field_likecount = 0;
        dVar2.field_score = 0;
        this.lpF = dVar2;
    }

    public final String toString() {
        String str = "{ view type: " + this.afo + " display flag: " + this.lpG;
        if (this.lpF != null) {
            str = str + this.lpF.toString();
        } else {
            str = str + " mExdeviceRankInfo is null";
        }
        return str + "}";
    }
}
