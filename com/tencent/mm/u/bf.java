package com.tencent.mm.u;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public class bf {
    private static bf hnI;
    public final SharedPreferences hgx = ab.getContext().getSharedPreferences(ab.bIX(), 0);

    public static class a {
        private int hnJ;
        private int hnK;
        private int hnL;
        private int id;

        public final a fi(int i) {
            this.hnJ = i;
            return this;
        }

        public final a fj(int i) {
            this.hnK = i;
            return this;
        }

        public final a fk(int i) {
            this.hnL = i;
            return this;
        }

        public final boolean commit() {
            Editor edit = bf.zK().hgx.edit();
            if (this.id > 0) {
                edit.putInt("MicroMsg.RegStyleStoragestyle_id", this.id);
            } else {
                edit.remove("MicroMsg.RegStyleStoragestyle_id");
            }
            if (this.hnJ > 0) {
                edit.putInt("MicroMsg.RegStyleStoragenew_flow", this.hnJ);
            } else {
                edit.remove("MicroMsg.RegStyleStoragenew_flow");
            }
            if (this.hnK > 0) {
                edit.putInt("MicroMsg.RegStyleStoragehas_password", this.hnK);
            } else {
                edit.remove("MicroMsg.RegStyleStoragehas_password");
            }
            if (this.hnL > 0) {
                edit.putInt("MicroMsg.RegStyleStoragehas_AVATAR", this.hnL);
            } else {
                edit.remove("MicroMsg.RegStyleStoragehas_AVATAR");
            }
            w.i("MicroMsg.RegStyleStorage", "id: " + this.id + " newFlow: " + this.hnJ + "hasPassword:" + this.hnK + "hasAvatar:" + this.hnL);
            return edit.commit();
        }
    }

    private bf() {
    }

    public static bf zK() {
        synchronized (bf.class) {
            if (hnI == null) {
                hnI = new bf();
            }
        }
        return hnI;
    }
}
