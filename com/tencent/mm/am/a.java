package com.tencent.mm.am;

import com.tencent.mm.e.b.ch;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.sdk.platformtools.bg;

public final class a extends ch {
    public static com.tencent.mm.sdk.e.c.a gTP = ch.pw();
    public String hMU;

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }

    public final boolean HE() {
        return (this.field_songBgColor == 0 || this.field_songLyricColor == 0) ? false : true;
    }

    public final boolean HF() {
        return !bg.mA(this.field_songHAlbumUrl);
    }

    public final boolean f(int[] iArr) {
        return this.field_songBgColor == iArr[0] && this.field_songLyricColor == iArr[1];
    }

    public final boolean a(a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.field_musicId.equals(aVar.field_musicId);
    }

    public final anf HG() {
        anf com_tencent_mm_protocal_c_anf = new anf();
        com_tencent_mm_protocal_c_anf.tqY = this.field_originMusicId;
        com_tencent_mm_protocal_c_anf.tRH = this.field_musicType;
        com_tencent_mm_protocal_c_anf.mtb = this.field_appId;
        com_tencent_mm_protocal_c_anf.tRL = this.field_songAlbum;
        com_tencent_mm_protocal_c_anf.tRT = this.field_songAlbumType;
        com_tencent_mm_protocal_c_anf.tRM = this.field_songAlbumUrl;
        com_tencent_mm_protocal_c_anf.tRN = this.field_songWifiUrl;
        com_tencent_mm_protocal_c_anf.tRJ = this.field_songName;
        com_tencent_mm_protocal_c_anf.tRK = this.field_songSinger;
        com_tencent_mm_protocal_c_anf.tRO = this.field_songWapLinkUrl;
        com_tencent_mm_protocal_c_anf.tRP = this.field_songWebUrl;
        com_tencent_mm_protocal_c_anf.tRR = this.field_songAlbumLocalPath;
        com_tencent_mm_protocal_c_anf.ttW = this.field_songMediaId;
        com_tencent_mm_protocal_c_anf.tRX = this.field_songSnsAlbumUser;
        com_tencent_mm_protocal_c_anf.tRY = this.field_songSnsShareUser;
        com_tencent_mm_protocal_c_anf.tSa = this.field_hideBanner;
        com_tencent_mm_protocal_c_anf.tSb = this.field_jsWebUrlDomain;
        com_tencent_mm_protocal_c_anf.iMR = this.field_startTime;
        com_tencent_mm_protocal_c_anf.hMU = this.hMU;
        return com_tencent_mm_protocal_c_anf;
    }
}
