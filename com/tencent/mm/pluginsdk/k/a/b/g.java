package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.mm.pluginsdk.k.a.d.q;
import com.tencent.mm.sdk.platformtools.bg;

final class g extends com.tencent.mm.pluginsdk.k.a.d.a {
    final int fEB;
    final int fEC;
    private final boolean fEE;
    final boolean fEH;
    final long fileSize;
    final byte[] sFF;
    final boolean sFG;
    final boolean sFH;
    private final int sFI;
    private final String sFa;
    final int sFb;
    private final byte[] sFc;
    final String sFd;
    final long sFf;
    private final String sFg;

    public static final class a extends com.tencent.mm.pluginsdk.k.a.d.a.a<g> {
        int fEB;
        int fEC;
        int fED;
        boolean fEE;
        boolean fEH;
        long fileSize = 0;
        byte[] sFF;
        boolean sFG;
        boolean sFH;
        int sFI;
        String sFa;
        int sFb;
        byte[] sFc;
        String sFd;
        long sFf;
        String sFg;

        public a(String str) {
            super(str);
        }
    }

    public g(String str, String str2, int i, int i2, int i3, long j, String str3, int i4, int i5, long j2, String str4, byte[] bArr, String str5, boolean z, boolean z2, String str6, int i6, int i7, byte[] bArr2, long j3, boolean z3, boolean z4, int i8) {
        super(str, str2, String.valueOf(i), i2, i3, i.Mp(str2), j, str3, "CheckResUpdate", z3 ? "NewXml" : "CGI", i8);
        this.fEB = i4;
        this.fEC = i5;
        this.sFf = j2;
        this.sFg = str4;
        this.sFc = bArr;
        this.sFd = str5;
        this.sFG = z;
        this.sFH = z2;
        this.sFa = str6;
        this.sFb = i6;
        this.sFI = i7;
        this.sFF = bArr2;
        this.fileSize = j3;
        this.fEH = z3;
        this.fEE = z4;
    }

    public final String toString() {
        return "CheckResUpdateRequest | fileUpdated=" + this.fEE + ", resType=" + this.fEB + ", subType=" + this.fEC + ", reportId=" + this.sFf + ", sampleId='" + this.sFg + '\'' + ", originalMd5='" + this.sFd + '\'' + ", fileCompress=" + this.sFG + ", fileEncrypt=" + this.sFH + ", encryptKey='" + this.sFa + '\'' + ", keyVersion=" + this.sFb + ", EID=" + this.sFI + ", fileSize=" + this.fileSize + ", fromNewXml=" + this.fEH + " | " + super.toString();
    }

    public final q bDt() {
        q bDt = super.bDt();
        bDt.field_fileUpdated = this.fEE;
        bDt.field_resType = this.fEB;
        bDt.field_subType = this.fEC;
        bDt.field_reportId = this.sFf;
        bDt.field_sampleId = this.sFg;
        bDt.field_eccSignature = this.sFc;
        bDt.field_originalMd5 = this.sFd;
        bDt.field_fileCompress = this.sFG;
        bDt.field_fileEncrypt = this.sFH;
        bDt.field_encryptKey = this.sFa;
        bDt.field_keyVersion = this.sFb;
        bDt.field_fileSize = this.fileSize;
        bDt.field_EID = this.sFI;
        return bDt;
    }

    protected final int Mo(String str) {
        return bg.getInt(this.sGq, 0) - bg.getInt(str, 0);
    }
}
