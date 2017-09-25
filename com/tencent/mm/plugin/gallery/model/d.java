package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.tencent.mm.protocal.c.afx;
import com.tencent.mm.protocal.c.afy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d {
    boolean lEy = true;
    private File mes;
    List<RandomAccessFile> met;
    SparseArray<afy> meu;
    int mev;

    d(File file) {
        if (!file.isDirectory()) {
            boolean mkdirs = file.mkdirs();
            w.d("MicroMsg.DiskCache", "dir[%s] not exist, try to create it, result[%B]", new Object[]{file.getAbsolutePath(), Boolean.valueOf(mkdirs)});
        }
        this.mes = file;
        this.meu = new SparseArray();
    }

    final void ays() {
        File file = new File(this.mes, "cache.idx");
        afx com_tencent_mm_protocal_c_afx = new afx();
        String absolutePath = file.getAbsolutePath();
        if (!bg.mA(absolutePath)) {
            try {
                com_tencent_mm_protocal_c_afx.aD(bg.readFromFile(absolutePath));
            } catch (Throwable e) {
                w.e("MicroMsg.DiskCache", "load index file error");
                w.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                mY(-1);
                com_tencent_mm_protocal_c_afx = new afx();
            } catch (Throwable e2) {
                w.e("MicroMsg.DiskCache", "load index file error, OOM, index length %s", new Object[]{Long.valueOf(file.length())});
                w.printErrStackTrace("MicroMsg.DiskCache", e2, "", new Object[0]);
                mY(-1);
                com_tencent_mm_protocal_c_afx = new afx();
            }
        }
        this.meu.clear();
        Iterator it = com_tencent_mm_protocal_c_afx.tLa.iterator();
        while (it.hasNext()) {
            afy com_tencent_mm_protocal_c_afy = (afy) it.next();
            this.meu.put(com_tencent_mm_protocal_c_afy.key, com_tencent_mm_protocal_c_afy);
        }
    }

    final synchronized void mX(int i) {
        synchronized (this) {
            if (i >= 0) {
                try {
                    if (this.met != null) {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mes, na(i)), "rw");
                        this.met.remove(i);
                        this.met.add(i, randomAccessFile);
                    }
                } catch (Throwable e) {
                    w.e("MicroMsg.DiskCache", "create data file error: %s", new Object[]{e.getMessage()});
                    w.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                    this.met = null;
                }
            }
            this.met = new ArrayList();
            for (int i2 = 0; i2 < 25; i2++) {
                this.met.add(new RandomAccessFile(new File(this.mes, na(i2)), "rw"));
            }
        }
    }

    final void mY(int i) {
        int i2 = 0;
        if (this.met != null && this.met.size() > 0) {
            if (i < 0) {
                new File(this.mes, "cache.idx").delete();
                this.meu.clear();
            } else {
                SparseArray sparseArray = new SparseArray();
                for (int i3 = 0; i3 < this.meu.size(); i3++) {
                    afy com_tencent_mm_protocal_c_afy = (afy) this.meu.valueAt(i3);
                    if (com_tencent_mm_protocal_c_afy.tLc != i) {
                        sparseArray.put(this.meu.keyAt(i3), com_tencent_mm_protocal_c_afy);
                    }
                    w.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d]}", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_afy.key), Long.valueOf(com_tencent_mm_protocal_c_afy.tLb), Integer.valueOf(com_tencent_mm_protocal_c_afy.length)});
                }
                this.meu = sparseArray;
                ayt();
            }
            if (i < 0) {
                ayu();
                while (i2 < 25) {
                    new File(this.mes, na(25)).delete();
                    i2++;
                }
                return;
            }
            e((Closeable) this.met.get(i));
            new File(this.mes, na(i)).delete();
        }
    }

    static void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                w.e("MicroMsg.DiskCache", "want close %s fail: %s", new Object[]{closeable.getClass().getName(), e.getMessage()});
                w.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
            }
        }
    }

    final void ayt() {
        afx com_tencent_mm_protocal_c_afx = new afx();
        for (int i = 0; i < this.meu.size(); i++) {
            com_tencent_mm_protocal_c_afx.tLa.add(0, (afy) this.meu.valueAt(i));
            w.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d] file_suffix[%d]}", new Object[]{Integer.valueOf(r0.key), Long.valueOf(r0.tLb), Integer.valueOf(r0.length), Integer.valueOf(r0.tLc)});
        }
        try {
            bg.r(new File(this.mes, "cache.idx").getAbsolutePath(), com_tencent_mm_protocal_c_afx.toByteArray());
        } catch (Throwable e) {
            w.e("MicroMsg.DiskCache", "save index data error: %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
        }
    }

    final synchronized void ayu() {
        if (this.met != null && this.met.size() > 0) {
            for (RandomAccessFile e : this.met) {
                e(e);
            }
        }
    }

    public final Bitmap mZ(int i) {
        if (this.met == null || this.met.size() <= 0) {
            w.e("MicroMsg.DiskCache", "want to get bitmap, but data file is null");
            return null;
        }
        afy com_tencent_mm_protocal_c_afy = (afy) this.meu.get(i);
        if (com_tencent_mm_protocal_c_afy == null) {
            return null;
        }
        byte[] bArr = new byte[com_tencent_mm_protocal_c_afy.length];
        try {
            w.d("MicroMsg.DiskCache", "read data, beg pos %d, length %d", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_afy.tLb), Integer.valueOf(com_tencent_mm_protocal_c_afy.length)});
            RandomAccessFile randomAccessFile = (RandomAccessFile) this.met.get(com_tencent_mm_protocal_c_afy.tLc);
            randomAccessFile.seek(com_tencent_mm_protocal_c_afy.tLb);
            randomAccessFile.read(bArr, 0, com_tencent_mm_protocal_c_afy.length);
            Bitmap bd = com.tencent.mm.sdk.platformtools.d.bd(bArr);
            if (bd != null) {
                w.d("MicroMsg.DiskCache", "get bitmap from disk cache ok, wh[%d, %d]", new Object[]{Integer.valueOf(bd.getWidth()), Integer.valueOf(bd.getHeight())});
                return bd;
            }
            this.meu.remove(i);
            return bd;
        } catch (Throwable e) {
            w.w("MicroMsg.DiskCache", "read data fail, key[%d]: %s", new Object[]{Integer.valueOf(i), e.getMessage()});
            w.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
            this.meu.remove(i);
            return null;
        }
    }

    private static String na(int i) {
        return "cache.data" + (i == 0 ? "" : "." + i);
    }

    public final synchronized int ayv() {
        int i = 0;
        synchronized (this) {
            if (this.met != null && this.met.size() > 0) {
                try {
                    int i2 = -1;
                    for (RandomAccessFile length : this.met) {
                        i2++;
                        if (length.length() < 2097152) {
                            i = i2;
                            break;
                        }
                    }
                    i = -1;
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                    i = -1;
                }
            }
        }
        return i;
    }

    public final void ayw() {
        ab.getContext().getSharedPreferences(ab.bIX(), 0).edit().putInt("com.tencent.mm.gallery.cache.suffix", this.mev).commit();
    }
}
