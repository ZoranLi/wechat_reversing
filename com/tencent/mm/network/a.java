package com.tencent.mm.network;

import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ar;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public final class a extends com.tencent.mm.network.d.a implements c {
    private boolean foreground = true;
    byte[] htN;
    private byte[] idY;
    private a idZ = null;
    byte[] iea;
    String ieb;
    private Map<String, byte[]> iec = new HashMap();
    private int uin;
    String username;

    public interface a {
    }

    public a(a aVar) {
        this.idZ = aVar;
        Ml();
    }

    public final void reset() {
        w.i("MicroMsg.AccInfo", "reset accinfo");
        this.username = "";
        this.idY = null;
        Ml();
        this.uin = 0;
    }

    private void Ml() {
        this.htN = bg.PT(ar.ze().getString("server_id", ""));
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final void i(byte[] bArr, int i) {
        w.i("MicroMsg.AccInfo", "summerauth update session info: session:%s, uin:%d -> %d stack:[%s]", bg.Qj(bg.bl(bArr)), Integer.valueOf(this.uin), Integer.valueOf(i), bg.bJZ());
        this.idY = bArr;
        this.uin = i;
        if (this.idZ != null) {
            BY();
        }
    }

    public final void E(byte[] bArr) {
        this.htN = bArr;
    }

    public final void F(byte[] bArr) {
        this.iea = bArr;
    }

    public final byte[] vc() {
        return this.idY;
    }

    public final byte[] BZ() {
        return this.iea;
    }

    public final byte[] BX() {
        return this.htN;
    }

    public final String getUsername() {
        return this.username;
    }

    public final int uH() {
        return this.uin;
    }

    public final boolean BY() {
        return this.idY != null && this.idY.length > 0;
    }

    public final String toString() {
        return ((((("AccInfo:\n" + "|-uin     =" + uH() + "\n") + "|-user    =" + getUsername() + "\n") + "|-wxuser  =" + Cv() + "\n") + "|-session =" + bg.bl(vc()) + "\n") + "|-ecdhkey =" + bg.bl(BZ()) + "\n") + "`-cookie  =" + bg.bl(BX());
    }

    public final void mh(String str) {
        this.ieb = str;
    }

    public final String Cv() {
        return this.ieb;
    }

    public final void h(String str, byte[] bArr) {
        this.iec.put(str, bArr);
    }

    public final byte[] hu(String str) {
        return (byte[]) this.iec.get(str);
    }

    public final boolean Ca() {
        return this.foreground;
    }

    public final void aY(boolean z) {
        this.foreground = z;
        w.i("MicroMsg.AccInfo", "somr accinfo setForegroundMuteRoom :%b", Boolean.valueOf(this.foreground));
    }

    private void clear() {
        this.username = null;
        this.idY = null;
        this.htN = null;
        this.uin = 0;
        this.iea = null;
        this.ieb = null;
    }

    private String Mm() {
        try {
            ByteBuffer allocate = ByteBuffer.allocate(Downloads.RECV_BUFFER_SIZE);
            allocate.put(this.idY).put(this.iea).put(this.htN).putInt(this.uin).put(this.ieb.getBytes()).put(this.username.getBytes());
            return g.n(allocate.array());
        } catch (Exception e) {
            return "";
        }
    }

    public final byte[] Cb() {
        long Nz = bg.Nz();
        int i = bg.mA(this.username) ? 0 : bg.bm(this.idY) ? 0 : bg.bm(this.htN) ? 0 : (this.uin == 0 || this.uin == -1) ? 0 : bg.bm(this.iea) ? 0 : bg.mA(this.ieb) ? 0 : 1;
        if (i == 0) {
            w.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer Error : isCacheValid== false");
            return null;
        }
        try {
            t tVar = new t();
            tVar.bIH();
            tVar.Pm(this.username);
            tVar.Pm(this.ieb);
            tVar.yt(this.uin);
            tVar.bi(this.htN);
            tVar.bi(this.iea);
            tVar.bi(this.idY);
            tVar.Pm(Mm());
            w.i("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer finish time:%s buflen:%s md5:%s", Long.valueOf(bg.aA(Nz)), Integer.valueOf(tVar.bII().length), r6);
            return tVar.bII();
        } catch (Throwable e) {
            w.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", bg.g(e));
            return null;
        }
    }

    public final int A(byte[] bArr) {
        long Nz = bg.Nz();
        if (BY()) {
            w.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : isLogin == true ");
            return -2;
        }
        try {
            t tVar = new t();
            if (tVar.bh(bArr) != 0) {
                w.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", Integer.valueOf(tVar.bh(bArr)));
                return -3;
            }
            this.username = tVar.getString();
            this.ieb = tVar.getString();
            this.uin = tVar.getInt();
            this.htN = tVar.getBuffer();
            this.iea = tVar.getBuffer();
            this.idY = tVar.getBuffer();
            String string = tVar.getString();
            if (bg.mA(string) || !string.equals(Mm())) {
                clear();
                w.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
                return -4;
            }
            w.i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", Long.valueOf(bg.aA(Nz)), string);
            return 0;
        } catch (Throwable e) {
            clear();
            w.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", bg.g(e));
            return -5;
        }
    }

    public final void dj(int i) {
        w.i("MicroMsg.AccInfo", "summerauth setuin [%d -> %d], stack[%s]", Integer.valueOf(this.uin), Integer.valueOf(i), bg.bJZ());
        this.uin = i;
    }
}
