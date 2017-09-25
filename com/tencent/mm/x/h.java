package com.tencent.mm.x;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.bg;

public final class h {
    public int fRW = -1;
    public int gkq = 0;
    public String hrA = "";
    public String hrB = "";
    private int hrC = 0;
    int hrD = 0;
    int hrz = 0;
    public String username = "";

    public final void b(Cursor cursor) {
        this.username = cursor.getString(0);
        this.gkq = cursor.getInt(1);
        this.hrz = cursor.getInt(2);
        this.hrB = cursor.getString(3);
        this.hrA = cursor.getString(4);
        this.hrC = cursor.getInt(5);
        this.hrD = cursor.getInt(6);
    }

    public final ContentValues Br() {
        ContentValues contentValues = new ContentValues();
        if ((this.fRW & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fRW & 2) != 0) {
            contentValues.put("imgflag", Integer.valueOf(this.gkq));
        }
        if ((this.fRW & 4) != 0) {
            contentValues.put("lastupdatetime", Integer.valueOf(this.hrz));
        }
        if ((this.fRW & 8) != 0) {
            contentValues.put("reserved1", Bs());
        }
        if ((this.fRW & 16) != 0) {
            contentValues.put("reserved2", Bt());
        }
        if ((this.fRW & 32) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hrC));
        }
        if ((this.fRW & 64) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hrD));
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String Bs() {
        return this.hrB == null ? "" : this.hrB;
    }

    public final String Bt() {
        return this.hrA == null ? "" : this.hrA;
    }

    public final void aV(boolean z) {
        this.hrC = z ? 1 : 0;
    }

    public final void Bu() {
        this.hrD = (int) (bg.Ny() / 60);
        this.fRW |= 64;
    }
}
