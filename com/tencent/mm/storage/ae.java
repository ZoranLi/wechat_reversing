package com.tencent.mm.storage;

import com.tencent.mm.k.a;

public final class ae extends a implements com.tencent.mm.bj.a.a<String> {
    public au uIU;

    public final /* bridge */ /* synthetic */ Object getKey() {
        return this.field_username;
    }

    public ae(String str) {
        super(str);
    }

    public final void W(au auVar) {
        ae aeVar;
        long j;
        ae aeVar2;
        dv(auVar.field_status);
        dw(auVar.field_isSend);
        if (auVar.bMm()) {
            aeVar = this;
        } else if (auVar.field_status == 1) {
            j = Long.MAX_VALUE;
            aeVar2 = this;
            aeVar2.s(j);
            if (auVar.bMg()) {
                setContent(auVar.field_content);
            } else {
                setContent(auVar.bMC());
            }
        } else {
            aeVar = this;
        }
        aeVar2 = aeVar;
        j = auVar.field_createTime;
        aeVar2.s(j);
        if (auVar.bMg()) {
            setContent(auVar.field_content);
        } else {
            setContent(auVar.bMC());
        }
    }

    public final void bLB() {
        dv(0);
        dw(0);
        setContent("");
        ct("0");
        dt(0);
        dC(0);
        u(0);
        dB(0);
        dB(0);
        super.cu("");
        super.cv("");
    }

    public final void m(int i, byte[] bArr) {
    }

    public final void M(int i, long j) {
        switch (i) {
            case 0:
                dt((int) j);
                return;
            case 1:
                dv((int) j);
                return;
            case 2:
                dw((int) j);
                return;
            case 3:
                s(j);
                return;
            case 7:
                t(j);
                return;
            case 10:
                dy((int) j);
                return;
            case 12:
                dz((int) j);
                return;
            case 14:
                dC((int) j);
                return;
            default:
                return;
        }
    }

    public final void az(int i, String str) {
        switch (i) {
            case 4:
                setUsername(str);
                return;
            case 5:
                setContent(str);
                return;
            case 6:
                ct(str);
                return;
            case 8:
                cu(str);
                return;
            case 9:
                cv(str);
                return;
            case 11:
                cx(str);
                return;
            default:
                return;
        }
    }

    public final void bKM() {
    }
}
