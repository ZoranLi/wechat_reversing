package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.protocal.c.afy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.RandomAccessFile;

public final class a {
    private static final int mdP = (d.ep(14) ? 20 : 30);
    public b mdQ = new b();
    private a mdR = new a(this);
    public f<String> mdS = new f();
    private f<b> mdT = new f();
    public volatile boolean mdU = false;

    private class a {
        final /* synthetic */ a mdV;

        class AnonymousClass1 implements Runnable {
            final /* synthetic */ com.tencent.mm.sdk.platformtools.ar.a mdW;
            final /* synthetic */ a mdX;

            AnonymousClass1(a aVar, com.tencent.mm.sdk.platformtools.ar.a aVar2) {
                this.mdX = aVar;
                this.mdW = aVar2;
            }

            public final void run() {
                if (this.mdW.Bn()) {
                    this.mdW.Bo();
                }
                this.mdX.mdV.mdU = false;
                this.mdX.mdV.ayh();
            }

            public final String toString() {
                return super.toString() + "|QueueWorkerThreadForGallery";
            }
        }

        public a(a aVar) {
            this.mdV = aVar;
        }
    }

    private class b implements com.tencent.mm.sdk.platformtools.ar.a {
        private Bitmap bitmap;
        private int fIL;
        public String mFilePath;
        final /* synthetic */ a mdV;
        private String mdY;
        private long mdZ;
        private int mea;

        public b(a aVar, String str, int i, String str2, long j) {
            this(aVar, str, i, str2, j, (byte) 0);
        }

        private b(a aVar, String str, int i, String str2, long j, byte b) {
            this.mdV = aVar;
            this.mFilePath = str;
            this.mdZ = j;
            this.mdY = str2;
            this.mea = 12288;
            this.fIL = i;
        }

        public final boolean Bn() {
            b bVar = this.mdV.mdQ;
            String str = this.mFilePath;
            String str2 = this.mdY;
            long j = this.mdZ;
            this.bitmap = bVar.mec == null ? null : bVar.mec.mZ(String.format("%s-%s-%d", new Object[]{str, str2, Long.valueOf(j)}).hashCode());
            if (this.bitmap != null) {
                w.d("MircoMsg.CacheService", "get bmp from disk cache ok, filePath[%s]", new Object[]{this.mFilePath});
                return true;
            }
            this.bitmap = j.a(this.mdZ, this.fIL, this.mFilePath, this.mdY);
            if (this.bitmap == null) {
                return false;
            }
            bVar = this.mdV.mdQ;
            str = this.mFilePath;
            str2 = this.mdY;
            j = this.mdZ;
            Bitmap bitmap = this.bitmap;
            if (bitmap != null) {
                str = String.format("%s-%s-%d", new Object[]{str, str2, Long.valueOf(j)});
                if (bVar.mec != null) {
                    d dVar = bVar.mec;
                    int hashCode = str.hashCode();
                    if (dVar.met == null || dVar.met.size() <= 0) {
                        w.e("MicroMsg.DiskCache", "want to put bitmap, but data file is null");
                    } else if (bitmap == null) {
                        w.e("MicroMsg.DiskCache", "put bmp, value error: null");
                    } else {
                        int i;
                        w.d("MicroMsg.DiskCache", "put bmp key[%d] size[%d, %d]", new Object[]{Integer.valueOf(hashCode), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
                        if (dVar.met == null || dVar.met.size() <= 0) {
                            i = -1;
                        } else {
                            int ayv = dVar.ayv();
                            if (ayv < 0) {
                                w.d("MicroMsg.DiskCache", "jacks check Data Size currentSuffix: %d", new Object[]{Integer.valueOf(dVar.mev)});
                                ayv = dVar.mev + 1 >= 25 ? 0 : dVar.mev + 1;
                                w.d("MicroMsg.DiskCache", "jacks reset Index and Data: %d", new Object[]{Integer.valueOf(ayv)});
                                dVar.mY(ayv);
                                dVar.mX(ayv);
                            }
                            i = ayv;
                        }
                        if (i < 0) {
                            w.e("MicroMsg.DiskCache", "put bmp, file suffix < 0");
                        } else {
                            Object obj;
                            afy com_tencent_mm_protocal_c_afy = (afy) dVar.meu.get(hashCode);
                            if (com_tencent_mm_protocal_c_afy == null) {
                                com_tencent_mm_protocal_c_afy = new afy();
                                com_tencent_mm_protocal_c_afy.key = hashCode;
                                obj = com_tencent_mm_protocal_c_afy;
                            } else {
                                afy com_tencent_mm_protocal_c_afy2 = com_tencent_mm_protocal_c_afy;
                            }
                            Closeable byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                                try {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    RandomAccessFile randomAccessFile = (RandomAccessFile) dVar.met.get(i);
                                    obj.tLb = randomAccessFile.length();
                                    obj.tLc = i;
                                    obj.length = byteArrayOutputStream.size();
                                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                                    randomAccessFile.seek(obj.tLb);
                                    randomAccessFile.write(toByteArray);
                                    dVar.mev = i;
                                    w.d("MicroMsg.DiskCache", "jacks [time: %d]save data ok, key[%d] beg pos %d, length %d, file_suffix %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(obj.key), Long.valueOf(obj.tLb), Integer.valueOf(obj.length), Integer.valueOf(obj.tLc)});
                                    dVar.lEy = true;
                                    dVar.meu.put(hashCode, obj);
                                } catch (Exception e) {
                                    obj = "write data error:%s";
                                    w.e("MicroMsg.DiskCache", obj, new Object[]{e.getMessage()});
                                } finally {
                                    d.e(byteArrayOutputStream);
                                }
                            } catch (Throwable e2) {
                                w.e("MicroMsg.DiskCache", "compress bmp error:%s", new Object[]{e2.getMessage()});
                                w.printErrStackTrace("MicroMsg.DiskCache", e2, "", new Object[0]);
                                d.e(byteArrayOutputStream);
                            }
                        }
                    }
                }
            }
            return true;
        }

        public final boolean Bo() {
            w.d("MircoMsg.CacheService", "do on post execute, filePath[%s]", new Object[]{this.mFilePath});
            this.mdV.mdS.aW(this.mFilePath);
            w.v("MircoMsg.CacheService", "remove filePathInService at position 0 : now position:[%d]", new Object[]{Integer.valueOf(this.mdV.mdS.size())});
            if (this.bitmap == null) {
                w.e("MircoMsg.CacheService", "decode file failed, %s ", new Object[]{this.mFilePath});
                return false;
            }
            b bVar = this.mdV.mdQ;
            String str = this.mFilePath;
            Bitmap bitmap = this.bitmap;
            int i = this.mea;
            if (bVar.meb == null) {
                w.e("MicroMsg.GalleryCache", "cache is null");
            } else {
                bVar.meb.k(str, new a(bVar, bitmap, i));
                bVar.hrc.by(str);
                bVar.hrc.doNotify();
            }
            this.bitmap = null;
            return true;
        }

        public final boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            return bg.ap(this.mFilePath, "").equals(((b) obj).mFilePath);
        }

        public final int hashCode() {
            return bg.ap(this.mFilePath, "").hashCode();
        }
    }

    public final Bitmap b(String str, int i, String str2, long j) {
        if (bg.mA(str)) {
            w.w("MircoMsg.CacheService", "file path is null");
            return null;
        }
        Bitmap bitmap = this.mdQ.getBitmap(str);
        if (bitmap != null) {
            w.v("MircoMsg.CacheService", "get bitmap from cache: %s", new Object[]{str});
            return bitmap;
        }
        w.v("MircoMsg.CacheService", "filePathInService size is : [%d]", new Object[]{Integer.valueOf(this.mdS.size())});
        if (this.mdS.aV(str)) {
            w.w("MircoMsg.CacheService", "has already getting bitmap from file, %s", new Object[]{str});
            ayh();
            return null;
        }
        if (this.mdS.size() > mdP) {
            w.w("MircoMsg.CacheService", "the running task has exceed 40, remove the first one");
            w.w("MircoMsg.CacheService", "filePathInService size: [%d], waitingDecodeTask size:[%d]", new Object[]{Integer.valueOf(this.mdS.size()), Integer.valueOf(this.mdT.size())});
            if (!this.mdT.isEmpty()) {
                this.mdS.aW(((b) this.mdT.ayD()).mFilePath);
            }
        }
        this.mdS.add(str);
        this.mdT.add(new b(this, str, i, str2, j));
        ayh();
        return null;
    }

    public final Bitmap xk(String str) {
        if (bg.mA(str)) {
            w.w("MircoMsg.CacheService", "file path is null");
            return null;
        }
        Bitmap bitmap = this.mdQ.getBitmap(str);
        if (bitmap == null) {
            return null;
        }
        w.v("MircoMsg.CacheService", "get bitmap from cache: %s", new Object[]{str});
        return bitmap;
    }

    public final void ayh() {
        if (this.mdU) {
            w.w("MircoMsg.CacheService", "is decoding now, wait a minute");
        } else if (this.mdT == null || this.mdT.size() <= 0) {
            w.i("MircoMsg.CacheService", "all job empty");
            if (c.ayl() != null) {
                c.ayl().u(new Runnable(this) {
                    final /* synthetic */ a mdV;

                    {
                        this.mdV = r1;
                    }

                    public final void run() {
                        b bVar = this.mdV.mdQ;
                        if (bVar.mec != null) {
                            d dVar = bVar.mec;
                            if (dVar.lEy) {
                                dVar.lEy = false;
                                dVar.ayt();
                                dVar.ayu();
                                dVar.mX(-1);
                                dVar.ayw();
                            }
                        }
                    }

                    public final String toString() {
                        return super.toString() + "|tryStartDocode";
                    }
                });
            }
        } else {
            this.mdU = true;
            b bVar = (b) this.mdT.ayD();
            if (bVar == null) {
                w.e("MircoMsg.CacheService", "obj is null");
                this.mdU = false;
                ayh();
                return;
            }
            a aVar = this.mdR;
            if (c.ayl() == null) {
                w.w("MircoMsg.CacheService", "add thread object, but worker thread is null");
                return;
            }
            e ayl = c.ayl();
            Runnable anonymousClass1 = new AnonymousClass1(aVar, bVar);
            ae ayx = ayl.ayx();
            if (ayx == null) {
                w.e("MicroMsg.GalleryHandlerThread", "post at front of queue, but decode handler is null");
                return;
            }
            boolean postAtFrontOfQueueV2 = ayx.postAtFrontOfQueueV2(anonymousClass1);
            w.i("MicroMsg.GalleryHandlerThread", "postAtFrontOfQueue:[%b]", new Object[]{Boolean.valueOf(postAtFrontOfQueueV2)});
        }
    }

    public final void a(com.tencent.mm.plugin.gallery.model.b.b bVar) {
        b bVar2 = this.mdQ;
        if (bVar2.hrd.size() > 64) {
            com.tencent.mm.plugin.gallery.model.b.b bVar3 = (com.tencent.mm.plugin.gallery.model.b.b) bVar2.hrd.remove(0);
            w.i("MicroMsg.GalleryCache", "has exceed the max listener size[%d], remove some listeners[%s]", new Object[]{Integer.valueOf(64), bVar3});
        }
        w.v("MicroMsg.GalleryCache", "try add listener[%s]", new Object[]{bVar});
        if (!bVar2.hrd.contains(bVar)) {
            w.d("MicroMsg.GalleryCache", "add listener[%s] ok", new Object[]{bVar});
            bVar2.hrd.add(bVar);
        }
    }
}
