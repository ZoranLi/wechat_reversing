package com.tencent.mm.plugin.game.gamewebview.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.by;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.a.lp;
import com.tencent.mm.e.a.pp;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q;

public class FavUrlTask extends GWMainProcessTask {
    public static final Creator<FavUrlTask> CREATOR = new Creator<FavUrlTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FavUrlTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FavUrlTask[i];
        }
    };
    public int actionType;
    public boolean fDU;
    public Bundle lHw;
    public boolean mlt;
    public boolean mlu;
    public int ret;
    public int type;

    public final void PM() {
        b ppVar;
        switch (this.actionType) {
            case 1:
                if (this.lHw != null) {
                    boolean a;
                    long j = this.lHw.getLong("msg_id", Long.MIN_VALUE);
                    String string = this.lHw.getString("sns_local_id");
                    int i = this.lHw.getInt("news_svr_id", 0);
                    String string2 = this.lHw.getString("news_svr_tweetid");
                    b cbVar = new cb();
                    if (Long.MIN_VALUE != j) {
                        cbVar.fFA.fFE = this.lHw.getInt("message_index", 0);
                        a = e.a(cbVar, j);
                    } else if (!bg.mA(string)) {
                        ppVar = new pp();
                        ppVar.fWv.fWy = string;
                        ppVar.fWv.fWz = cbVar;
                        ppVar.fWv.url = this.lHw.getString("rawUrl");
                        a.urY.m(ppVar);
                        a = ppVar.fWw.fFj;
                    } else if (i != 0) {
                        ppVar = new lp();
                        ppVar.fSH.opType = 3;
                        ppVar.fSH.fSJ = cbVar;
                        ppVar.fSH.fSK = i;
                        ppVar.fSH.fSL = string2;
                        a.urY.m(ppVar);
                        a = ppVar.fSI.fFj;
                    } else {
                        this.mlt = true;
                        return;
                    }
                    if (a) {
                        String mz = bg.mz(this.lHw.getString("prePublishId"));
                        String fQ = q.fQ(mz);
                        q.b n = q.yC().n(fQ, true);
                        n.l("sendAppMsgScene", Integer.valueOf(2));
                        n.l("preChatName", this.lHw.getString("preChatName"));
                        n.l("preMsgIndex", Integer.valueOf(this.lHw.getInt("preMsgIndex")));
                        n.l("prePublishId", mz);
                        n.l("preUsername", this.lHw.getString("preUsername"));
                        n.l("getA8KeyScene", this.lHw.getString("getA8KeyScene"));
                        n.l("referUrl", this.lHw.getString("referUrl"));
                        Bundle bundle = this.lHw.getBundle("jsapiargs");
                        if (bundle != null) {
                            n.l("adExtStr", bundle.getString("key_snsad_statextstr"));
                        }
                        cbVar.fFA.fFF = fQ;
                        a.urY.m(cbVar);
                    } else {
                        if (cbVar.fFA.fFG == 0) {
                            cbVar.fFA.fFG = R.l.eij;
                        }
                        a.urY.m(cbVar);
                    }
                    this.ret = cbVar.fFB.ret;
                    return;
                }
                return;
            case 2:
                ppVar = new fp();
                ppVar.fKp.type = 35;
                a.urY.m(ppVar);
                return;
            case 3:
                this.mlu = d.Jt("favorite");
                return;
            case 4:
                ppVar = new by();
                ppVar.fFv.fFx = this.lHw.getLong("fav_local_id", -1);
                a.urY.m(ppVar);
                w.i("MicroMsg.FavUrlTask", "do del fav web url, local id %d, result %B", new Object[]{Long.valueOf(ppVar.fFv.fFx), Boolean.valueOf(ppVar.fFw.fFj)});
                this.fDU = ppVar.fFw.fFj;
                return;
            default:
                return;
        }
    }

    public final void f(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.actionType = parcel.readInt();
        this.lHw = parcel.readBundle();
        this.mlt = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.fDU = z;
        this.ret = parcel.readInt();
        this.type = parcel.readInt();
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.mlu = z2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.actionType);
        parcel.writeBundle(this.lHw);
        parcel.writeByte((byte) (this.mlt ? 1 : 0));
        if (this.fDU) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.ret);
        parcel.writeInt(this.type);
        if (!this.mlu) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }

    public FavUrlTask(Parcel parcel) {
        f(parcel);
    }
}
