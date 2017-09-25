package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bj.a.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.w;

public final class f implements a<String> {
    public String field_alias;
    public String field_conRemark;
    public int field_deleteFlag;
    public byte[] field_lvbuff;
    public String field_nickname;
    public String field_remarkDesc;
    public int field_showHead;
    public String field_signature;
    public String field_username;
    public int field_verifyFlag;
    public int field_weiboFlag;
    public long gTQ;
    public CharSequence uyS;

    public final /* bridge */ /* synthetic */ Object getKey() {
        return this.field_username;
    }

    public final void b(Cursor cursor) {
        this.field_username = cursor.getString(0);
        this.field_nickname = cursor.getString(1);
        this.field_alias = cursor.getString(2);
        this.field_conRemark = cursor.getString(3);
        this.field_verifyFlag = cursor.getInt(4);
        this.field_showHead = cursor.getInt(5);
        this.field_weiboFlag = cursor.getInt(6);
        this.gTQ = cursor.getLong(7);
        this.field_deleteFlag = cursor.getInt(8);
        this.field_lvbuff = cursor.getBlob(9);
        bKL();
    }

    private void bKL() {
        if (this.field_lvbuff != null) {
            try {
                if (this.field_lvbuff != null && this.field_lvbuff.length != 0) {
                    t tVar = new t();
                    if (tVar.bh(this.field_lvbuff) == 0) {
                        tVar.yr(4);
                        tVar.yr(4);
                        tVar.bIF();
                        tVar.yr(8);
                        tVar.yr(4);
                        tVar.bIF();
                        tVar.bIF();
                        tVar.yr(4);
                        tVar.yr(4);
                        tVar.bIF();
                        tVar.bIF();
                        tVar.yr(4);
                        tVar.yr(4);
                        this.field_signature = tVar.getString();
                        tVar.bIF();
                        tVar.bIF();
                        tVar.bIF();
                        tVar.yr(4);
                        tVar.yr(4);
                        tVar.bIF();
                        tVar.yr(4);
                        tVar.bIF();
                        tVar.bIF();
                        tVar.yr(4);
                        tVar.yr(4);
                        if (!tVar.bIG()) {
                            this.field_remarkDesc = tVar.getString();
                        }
                        this.field_lvbuff = null;
                    }
                }
            } catch (Throwable e) {
                w.e("MicroMsg.AddressUIContact", "exception:%s", bg.g(e));
            }
        }
    }

    public final void m(int i, byte[] bArr) {
        if (i == 9) {
            this.field_lvbuff = bArr;
        }
    }

    public final void M(int i, long j) {
        switch (i) {
            case 4:
                this.field_verifyFlag = (int) j;
                return;
            case 5:
                this.field_showHead = (int) j;
                return;
            case 6:
                this.field_weiboFlag = (int) j;
                return;
            case 7:
                this.gTQ = j;
                return;
            case 8:
                this.field_deleteFlag = (int) j;
                return;
            default:
                return;
        }
    }

    public final void az(int i, String str) {
        switch (i) {
            case 0:
                this.field_username = str;
                return;
            case 1:
                this.field_nickname = str;
                return;
            case 2:
                this.field_alias = str;
                return;
            case 3:
                this.field_conRemark = str;
                return;
            default:
                return;
        }
    }

    public final void bKM() {
        bKL();
    }
}
