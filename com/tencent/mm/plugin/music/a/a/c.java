package com.tencent.mm.plugin.music.a.a;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.mm.plugin.music.a.f.b;
import com.tencent.mm.plugin.music.a.i;
import com.tencent.mm.sdk.platformtools.w;
import java.util.BitSet;

public final class c {
    public int count = 0;
    public long ilG = -1;
    public String mUrl;
    public BitSet nTD = new BitSet();
    public String nTE = "";

    public static class a {
        public static BitSet az(byte[] bArr) {
            BitSet bitSet = new BitSet(bArr.length * 8);
            int i = 0;
            for (byte b : bArr) {
                int i2 = 7;
                while (i2 >= 0) {
                    boolean z;
                    int i3 = i + 1;
                    if (((b & (1 << i2)) >> i2) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bitSet.set(i, z);
                    i2--;
                    i = i3;
                }
            }
            return bitSet;
        }
    }

    public c(String str) {
        this.mUrl = str;
    }

    public final void aNZ() {
        int i = 0;
        if (!TextUtils.isEmpty(this.nTE)) {
            BitSet bitSet = this.nTD;
            byte[] bArr = new byte[(bitSet.size() / 8)];
            for (int i2 = 0; i2 < bitSet.size(); i2++) {
                int i3 = i2 / 8;
                bArr[i3] = (byte) (((bitSet.get(i2) ? 1 : 0) << (7 - (i2 % 8))) | bArr[i3]);
            }
            i.aNW().q(this.nTE, bArr);
        }
        w.d("MicroMsg.IndexBitMgr", "saveBitCache bitSet:%s", new Object[]{this.nTD.toString()});
        w.i("MicroMsg.IndexBitMgr", "saveBitCache bitSet count %d, cardinality:" + this.count + "," + this.nTD.cardinality());
        w.i("MicroMsg.IndexBitMgr", "isCacheComplete, count:%d, cardinality:%d", new Object[]{Integer.valueOf(this.count), Integer.valueOf(this.nTD.cardinality())});
        if (this.count > 0 && this.count == this.nTD.cardinality()) {
            i = 1;
        }
        if (i != 0) {
            qh(1);
        }
    }

    public final void clearCache() {
        w.i("MicroMsg.IndexBitMgr", "clearCache");
        this.nTD = new BitSet(this.count);
        qh(0);
        if (!TextUtils.isEmpty(this.nTE)) {
            i.aNW().q(this.nTE, null);
        }
    }

    private void qh(int i) {
        w.i("MicroMsg.IndexBitMgr", "setFileCacheComplete %d", new Object[]{Integer.valueOf(i)});
        if (!TextUtils.isEmpty(this.nTE)) {
            com.tencent.mm.plugin.music.a.f.c aNW = i.aNW();
            String str = this.nTE;
            ContentValues contentValues = new ContentValues();
            contentValues.put("fileCacheComplete", Integer.valueOf(i));
            int update = aNW.gUz.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str});
            w.i("MicroMsg.PieceMusicInfoStorage", "updateMusicFileCacheComplete raw=%d musicId=%s fileCacheComplete=%d", new Object[]{Integer.valueOf(update), str, Integer.valueOf(i)});
            b bVar = (b) aNW.nUv.get(str);
            if (bVar != null) {
                bVar.field_fileCacheComplete = i;
            }
        }
    }

    public final int getIndex(int i) {
        if (((long) i) <= this.ilG) {
            return i / 8192;
        }
        w.e("MicroMsg.IndexBitMgr", "getIndex, offset is invalid, offset:%d, fileLength:%d", new Object[]{Integer.valueOf(i), Long.valueOf(this.ilG)});
        return 0;
    }

    public final boolean cw(int i, int i2) {
        if (i < 0 || i2 < 0 || ((long) i) > this.ilG || ((long) (i + i2)) > this.ilG) {
            w.e("MicroMsg.IndexBitMgr", "canReadFromCache offset %d, size %d, fileLength %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(this.ilG)});
            w.e("MicroMsg.IndexBitMgr", "canReadFromCache invalid parameter!");
            return false;
        }
        int index = getIndex(i);
        int index2 = getIndex(i + i2);
        int i3 = index;
        while (i3 <= index2) {
            boolean z = this.nTD.get(index);
            if (z) {
                i3++;
            } else {
                String str = "MicroMsg.IndexBitMgr";
                String str2 = "index %d, indexBit %d";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i3);
                objArr[1] = Integer.valueOf(z ? 1 : 0);
                w.d(str, str2, objArr);
                return false;
            }
        }
        return true;
    }
}
