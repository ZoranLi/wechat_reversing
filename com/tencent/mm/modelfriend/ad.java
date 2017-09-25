package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;

public final class ad {
    public String fFa = "";
    int fRW = -1;
    public long hCb = 0;
    public int hCc = 0;
    int hCd = 0;
    String hCe = "";
    String hCf = "";
    String hCg = "";
    String hCh = "";
    String hCi = "";
    public String hCj = "";
    String hCk = "";
    String hCl = "";
    String hrv = "";
    String hrw = "";
    public int hrx = 0;
    public int hry = 0;
    public String username = "";

    public final void b(Cursor cursor) {
        this.hCb = cursor.getLong(0);
        int i = cursor.getInt(1);
        if (i == 65536) {
            this.hCc = 0;
        } else {
            this.hCc = i;
        }
        this.hCd = cursor.getInt(2);
        this.username = cursor.getString(3);
        this.fFa = cursor.getString(4);
        this.hCe = cursor.getString(5);
        this.hCf = cursor.getString(6);
        this.hCg = cursor.getString(7);
        this.hCh = cursor.getString(8);
        this.hCi = cursor.getString(9);
        this.hCj = cursor.getString(10);
        this.hCk = cursor.getString(11);
        this.hCl = cursor.getString(12);
        this.hrv = cursor.getString(13);
        this.hrw = cursor.getString(14);
        this.hrx = cursor.getInt(15);
        this.hry = cursor.getInt(16);
    }

    public final ContentValues FO() {
        ContentValues contentValues = new ContentValues();
        if ((this.fRW & 1) != 0) {
            contentValues.put("qq", Long.valueOf(this.hCb));
        }
        if ((this.fRW & 2) != 0) {
            int i = this.hCc;
            if (i == 0) {
                contentValues.put("wexinstatus", Integer.valueOf(65536));
            } else {
                contentValues.put("wexinstatus", Integer.valueOf(i));
            }
        }
        if ((this.fRW & 4) != 0) {
            contentValues.put("groupid", Integer.valueOf(this.hCd));
        }
        if ((this.fRW & 8) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fRW & 16) != 0) {
            contentValues.put("nickname", FP());
        }
        if ((this.fRW & 32) != 0) {
            contentValues.put("pyinitial", this.hCe == null ? "" : this.hCe);
        }
        if ((this.fRW & 64) != 0) {
            contentValues.put("quanpin", this.hCf == null ? "" : this.hCf);
        }
        if ((this.fRW & FileUtils.S_IWUSR) != 0) {
            contentValues.put("qqnickname", FQ());
        }
        if ((this.fRW & 256) != 0) {
            contentValues.put("qqpyinitial", FR());
        }
        if ((this.fRW & 512) != 0) {
            contentValues.put("qqquanpin", FS());
        }
        if ((this.fRW & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("qqremark", FT());
        }
        if ((this.fRW & 2048) != 0) {
            contentValues.put("qqremarkpyinitial", FU());
        }
        if ((this.fRW & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("qqremarkquanpin", FV());
        }
        if ((this.fRW & 16384) != 0) {
            contentValues.put("reserved2", this.hrw == null ? "" : this.hrw);
        }
        if ((this.fRW & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hrx));
        }
        if ((this.fRW & 65536) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hry));
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String FP() {
        return this.fFa == null ? "" : this.fFa;
    }

    public final String FQ() {
        return this.hCg == null ? "" : this.hCg;
    }

    public final String FR() {
        return this.hCh == null ? "" : this.hCh;
    }

    public final String FS() {
        return this.hCi == null ? "" : this.hCi;
    }

    public final String FT() {
        return this.hCj == null ? "" : this.hCj;
    }

    public final String FU() {
        return this.hCk == null ? "" : this.hCk;
    }

    public final String FV() {
        return this.hCl == null ? "" : this.hCl;
    }

    public final String getDisplayName() {
        if (FT() == null || FT().length() <= 0) {
            return FQ();
        }
        return FT();
    }

    public final void FW() {
        this.hrx |= 1;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("groupID\t:").append(this.hCd).append("\n");
        stringBuilder.append("qq\t:").append(this.hCb).append("\n");
        stringBuilder.append("username\t:").append(this.username).append("\n");
        stringBuilder.append("nickname\t:").append(this.fFa).append("\n");
        stringBuilder.append("wexinStatus\t:").append(this.hCc).append("\n");
        stringBuilder.append("reserved3\t:").append(this.hrx).append("\n");
        stringBuilder.append("reserved4\t:").append(this.hry).append("\n");
        return stringBuilder.toString();
    }
}
