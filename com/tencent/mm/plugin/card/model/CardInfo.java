package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.e.b.dg;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.azz;
import com.tencent.mm.protocal.c.it;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.protocal.c.jb;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public class CardInfo extends dg implements Parcelable, b {
    public static final Creator<CardInfo> CREATOR = new Creator<CardInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CardInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CardInfo[i];
        }
    };
    protected static a gTP;
    public String kdJ;
    public jb keL;
    public it keM;
    public azz keN;
    public iw keO;
    public boolean keP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[22];
        aVar.columns = new String[23];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "card_id";
        aVar.uxd.put("card_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" card_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "card_id";
        aVar.columns[1] = "card_tp_id";
        aVar.uxd.put("card_tp_id", "TEXT");
        stringBuilder.append(" card_tp_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "from_username";
        aVar.uxd.put("from_username", "TEXT");
        stringBuilder.append(" from_username TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "delete_state_flag";
        aVar.uxd.put("delete_state_flag", "INTEGER");
        stringBuilder.append(" delete_state_flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "local_updateTime";
        aVar.uxd.put("local_updateTime", "LONG");
        stringBuilder.append(" local_updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "updateTime";
        aVar.uxd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "updateSeq";
        aVar.uxd.put("updateSeq", "LONG");
        stringBuilder.append(" updateSeq LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "create_time";
        aVar.uxd.put("create_time", "LONG");
        stringBuilder.append(" create_time LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "begin_time";
        aVar.uxd.put("begin_time", "LONG");
        stringBuilder.append(" begin_time LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "end_time";
        aVar.uxd.put("end_time", "LONG");
        stringBuilder.append(" end_time LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "block_mask";
        aVar.uxd.put("block_mask", "TEXT");
        stringBuilder.append(" block_mask TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "dataInfoData";
        aVar.uxd.put("dataInfoData", "BLOB");
        stringBuilder.append(" dataInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "cardTpInfoData";
        aVar.uxd.put("cardTpInfoData", "BLOB");
        stringBuilder.append(" cardTpInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "shareInfoData";
        aVar.uxd.put("shareInfoData", "BLOB");
        stringBuilder.append(" shareInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[15] = "shopInfoData";
        aVar.uxd.put("shopInfoData", "BLOB");
        stringBuilder.append(" shopInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[16] = "stickyIndex";
        aVar.uxd.put("stickyIndex", "INTEGER");
        stringBuilder.append(" stickyIndex INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "stickyEndTime";
        aVar.uxd.put("stickyEndTime", "INTEGER");
        stringBuilder.append(" stickyEndTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[18] = "stickyAnnouncement";
        aVar.uxd.put("stickyAnnouncement", "TEXT");
        stringBuilder.append(" stickyAnnouncement TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "card_type";
        aVar.uxd.put("card_type", "INTEGER default '-1' ");
        stringBuilder.append(" card_type INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "label_wording";
        aVar.uxd.put("label_wording", "TEXT");
        stringBuilder.append(" label_wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[21] = "is_dynamic";
        aVar.uxd.put("is_dynamic", "INTEGER");
        stringBuilder.append(" is_dynamic INTEGER");
        aVar.columns[22] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    public CardInfo() {
        this.keP = true;
        this.kdJ = "";
        this.field_card_type = -1;
    }

    protected final a sY() {
        return gTP;
    }

    public final boolean aeP() {
        return afi() != null && afi().kdF == 10;
    }

    public final boolean aeQ() {
        return afi() != null && afi().kdF == 0;
    }

    public final boolean aeR() {
        return afi() != null && afi().kdF == 20;
    }

    public final boolean aeS() {
        return afi() != null && afi().kdF == 11;
    }

    public final boolean aeT() {
        return afi() != null && afi().kdF == 30;
    }

    public final boolean aeU() {
        return l.ko(afi().kdF);
    }

    public final boolean aeV() {
        return (afi().tor & 2) == 0;
    }

    public final boolean aeW() {
        return (afi().tor & 1) == 0;
    }

    public final boolean aeX() {
        return (afi().tou & 1) == 0;
    }

    public final boolean aeY() {
        return (afi().tou & 16) == 0;
    }

    public final boolean aeZ() {
        return (afi().tou & 2) > 0;
    }

    public final boolean afa() {
        return (afi().tou & 32) > 0;
    }

    public final boolean afb() {
        return (afi().tou & 4) > 0;
    }

    public final boolean afc() {
        return (afi().tou & 8) > 0;
    }

    public final boolean afe() {
        return this.keM != null && this.keM.status == 0;
    }

    public final boolean isAcceptable() {
        if (!afe()) {
            return false;
        }
        if (this.keL != null) {
            w.i("MicroMsg.CardInfo", "is_acceptable:" + this.keL.toH);
        }
        w.i("MicroMsg.CardInfo", "stock_num:" + this.keM.tnI + " limit_num:" + this.keM.tnJ);
        if (this.keL == null || this.keL.toH != 1) {
            return ((this.keL == null || this.keL.toH != 0) && this.keM.tnI != 0 && this.keM.tnJ == 0) ? false : false;
        } else {
            return true;
        }
    }

    public final boolean aff() {
        if (!afe()) {
            return false;
        }
        if (this.keL != null) {
            w.i("MicroMsg.CardInfo", "is_acceptable:" + this.keL.toH);
        }
        w.i("MicroMsg.CardInfo", "avail_num:" + this.keM.tnF);
        if (this.keL != null && this.keL.toH == 1) {
            return true;
        }
        if (this.keM.tnF > 0) {
            return true;
        }
        return ((this.keL == null || this.keL.toH != 0) && this.keM.tnF == 0) ? false : false;
    }

    public final boolean afg() {
        if (this.keL == null || this.keL.toy == null || TextUtils.isEmpty(this.keL.toy.text)) {
            return false;
        }
        iv ivVar = this.keL.toy;
        int currentTimeMillis = ivVar.poY - ((int) (System.currentTimeMillis() / 1000));
        if (ivVar.poY <= 0 || currentTimeMillis <= 0) {
            return false;
        }
        return true;
    }

    public final boolean afh() {
        return this.keL != null && this.keL.toL == 1;
    }

    public final jb afi() {
        if (this.keL != null) {
            return this.keL;
        }
        try {
            this.keL = (jb) new jb().aD(this.field_cardTpInfoData);
            return this.keL;
        } catch (Throwable e) {
            w.e("MicroMsg.CardInfo", "getCardTpInfo fail, ex = %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
            return new jb();
        }
    }

    public final it afj() {
        if (this.keM != null) {
            return this.keM;
        }
        try {
            this.keM = (it) new it().aD(this.field_dataInfoData);
            return this.keM;
        } catch (Throwable e) {
            w.e("MicroMsg.CardInfo", "getDataInfo fail, ex = %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
            return new it();
        }
    }

    public final void a(it itVar) {
        this.keM = itVar;
        if (this.keM != null) {
            this.field_status = this.keM.status;
            try {
                this.field_dataInfoData = itVar.toByteArray();
            } catch (Throwable e) {
                w.e("MicroMsg.CardInfo", "setDataInfo fail, ex = %s", new Object[]{e.getMessage()});
                w.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
            }
        }
    }

    public final azz afk() {
        if (this.keN != null) {
            return this.keN;
        }
        try {
            this.keN = (azz) new azz().aD(this.field_shareInfoData);
            return this.keN;
        } catch (Throwable e) {
            w.e("MicroMsg.CardInfo", "getShareInfo fail, ex = %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
            return new azz();
        }
    }

    public final iw afl() {
        if (this.keO != null) {
            return this.keO;
        }
        try {
            this.keO = (iw) new iw().aD(this.field_shopInfoData);
            return this.keO;
        } catch (Throwable e) {
            w.e("MicroMsg.CardInfo", "getShopInfo fail ex = %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
            return null;
        }
    }

    public final void a(iw iwVar) {
        this.keO = iwVar;
        try {
            this.field_shopInfoData = iwVar.toByteArray();
        } catch (Throwable e) {
            w.e("MicroMsg.CardInfo", "setShopInfo fail, ex = %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.CardInfo", e, "", new Object[0]);
        }
    }

    public CardInfo(Parcel parcel) {
        int i;
        int i2 = 0;
        this.keP = true;
        this.kdJ = "";
        this.field_card_id = parcel.readString();
        this.field_card_tp_id = parcel.readString();
        this.field_from_username = parcel.readString();
        this.field_status = parcel.readInt();
        this.field_delete_state_flag = parcel.readInt();
        this.field_local_updateTime = parcel.readLong();
        this.field_updateTime = parcel.readLong();
        this.field_updateSeq = parcel.readLong();
        this.field_create_time = parcel.readLong();
        this.field_begin_time = parcel.readLong();
        this.field_end_time = parcel.readLong();
        this.field_block_mask = parcel.readString();
        this.field_stickyIndex = parcel.readInt();
        this.field_stickyEndTime = parcel.readInt();
        this.field_stickyAnnouncement = parcel.readString();
        this.field_card_type = parcel.readInt();
        this.field_label_wording = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.field_dataInfoData = new byte[readInt];
            for (i = 0; i < readInt; i++) {
                this.field_dataInfoData[i] = parcel.readByte();
            }
        }
        readInt = parcel.readInt();
        if (readInt > 0) {
            this.field_cardTpInfoData = new byte[readInt];
            for (i = 0; i < readInt; i++) {
                this.field_cardTpInfoData[i] = parcel.readByte();
            }
        }
        readInt = parcel.readInt();
        if (readInt > 0) {
            this.field_shareInfoData = new byte[readInt];
            for (i = 0; i < readInt; i++) {
                this.field_shareInfoData[i] = parcel.readByte();
            }
        }
        i = parcel.readInt();
        if (i > 0) {
            this.field_shopInfoData = new byte[i];
            while (i2 < i) {
                this.field_shopInfoData[i2] = parcel.readByte();
                i2++;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeString(this.field_card_id);
        parcel.writeString(this.field_card_tp_id);
        parcel.writeString(this.field_from_username);
        parcel.writeInt(this.field_status);
        parcel.writeInt(this.field_delete_state_flag);
        parcel.writeLong(this.field_local_updateTime);
        parcel.writeLong(this.field_updateTime);
        parcel.writeLong(this.field_updateSeq);
        parcel.writeLong(this.field_create_time);
        parcel.writeLong(this.field_begin_time);
        parcel.writeLong(this.field_end_time);
        parcel.writeString(this.field_block_mask);
        parcel.writeInt(this.field_stickyIndex);
        parcel.writeInt(this.field_stickyEndTime);
        parcel.writeString(this.field_stickyAnnouncement);
        parcel.writeInt(this.field_card_type);
        parcel.writeString(this.field_label_wording);
        if (this.field_dataInfoData != null) {
            parcel.writeInt(this.field_dataInfoData.length);
            for (byte writeByte : this.field_dataInfoData) {
                parcel.writeByte(writeByte);
            }
        } else {
            parcel.writeInt(0);
        }
        if (this.field_cardTpInfoData != null) {
            parcel.writeInt(this.field_cardTpInfoData.length);
            for (byte writeByte2 : this.field_cardTpInfoData) {
                parcel.writeByte(writeByte2);
            }
        } else {
            parcel.writeInt(0);
        }
        if (this.field_shareInfoData != null) {
            parcel.writeInt(this.field_shareInfoData.length);
            for (byte writeByte22 : this.field_shareInfoData) {
                parcel.writeByte(writeByte22);
            }
        } else {
            parcel.writeInt(0);
        }
        if (this.field_shopInfoData != null) {
            parcel.writeInt(this.field_shopInfoData.length);
            while (i2 < this.field_shopInfoData.length) {
                parcel.writeByte(this.field_shopInfoData[i2]);
                i2++;
            }
            return;
        }
        parcel.writeInt(0);
    }

    public final long getEndTime() {
        return this.field_end_time;
    }

    public final String afm() {
        return this.field_card_id;
    }

    public final String afn() {
        return this.field_card_tp_id;
    }

    public final String afo() {
        return this.field_from_username;
    }

    public final void sf(String str) {
        this.field_from_username = str;
    }

    public final long afp() {
        return this.field_local_updateTime;
    }

    public final boolean aeN() {
        return afi() != null && afi().toB == 0;
    }

    public final boolean aeO() {
        return afi() != null && afi().toB == 1;
    }

    public final String km(int i) {
        return null;
    }

    public final String afq() {
        return null;
    }

    public final int afr() {
        return 0;
    }

    public final String afs() {
        w.d("MicroMsg.CardInfo", "encrypt_code:" + this.kdJ);
        return this.kdJ;
    }

    public final boolean afd() {
        return afi() != null && afi().toG == 1;
    }
}
