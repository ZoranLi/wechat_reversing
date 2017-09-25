package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.chatting.eg;
import com.tencent.mm.y.k;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class d extends a implements com.tencent.mm.ah.c.a, com.tencent.mm.ui.chatting.gallery.e.a {
    private HashMap<String, WeakReference<Bitmap>> sbz = new HashMap();
    private c vRm;
    public HashMap<Long, Integer> vRn = new HashMap();
    public final e vRo = new e(this);
    private HashMap<au, String> vRp = new HashMap();
    private HashMap<au, String> vRq = new HashMap();
    private long vRr = 0;
    int xV = 0;

    private static class a {
        private static HashMap<String, a> vRw = new HashMap();
        private int height;
        private int hrs;
        private long utB = 0;
        private int vRt = 0;
        private String vRu = "";
        private int vRv = 0;
        private int width;

        private a() {
        }

        public static void cT(String str, int i) {
            try {
                if (!bg.mA(str) && i != 0) {
                    a aVar = (a) vRw.get(str);
                    if (aVar != null) {
                        aVar.hrs = i;
                    }
                    Set<String> hashSet = new HashSet();
                    for (String str2 : vRw.keySet()) {
                        a aVar2 = (a) vRw.get(str2);
                        if (aVar2 != null) {
                            w.i("MicroMsg.ImageGalleryHolderImage", "dkprog report: diff:%d [%d,%d,%d] succ:%d change:%d str:%s file:%s", Long.valueOf(bg.aA(aVar2.utB)), Integer.valueOf(aVar2.hrs), Integer.valueOf(aVar2.width), Integer.valueOf(aVar2.height), Integer.valueOf(aVar2.vRt), Integer.valueOf(aVar2.vRv), aVar2.vRu, str2);
                            if (bg.aA(aVar2.utB) >= 60000) {
                                if (aVar2.hrs > 0 && !bg.mA(aVar2.vRu)) {
                                    g.oUh.i(11713, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aVar2.hrs), Integer.valueOf(aVar2.width), Integer.valueOf(aVar2.height), Integer.valueOf(aVar2.vRt), Integer.valueOf(aVar2.vRv), aVar2.vRu);
                                }
                                hashSet.add(str2);
                            }
                        }
                    }
                    for (String str22 : hashSet) {
                        vRw.remove(str22);
                    }
                }
            } catch (Throwable th) {
                w.e("MicroMsg.ImageGalleryHolderImage", "get useopt  setTotalLen :%s", bg.g(th));
            }
        }

        public static void g(String str, int i, int i2, int i3) {
            try {
                if (!bg.mA(str) && i != 0 && i2 != 0) {
                    a aVar = (a) vRw.get(str);
                    if (aVar == null) {
                        aVar = new a();
                        aVar.utB = bg.Nz();
                        vRw.put(str, aVar);
                    }
                    aVar.height = i2;
                    aVar.width = i;
                    aVar.vRu += i3 + "|";
                    if (i3 > 0) {
                        if (aVar.vRt == 0) {
                            aVar.vRt = i3;
                        }
                    } else if (aVar.vRt != 0) {
                        aVar.vRv++;
                        aVar.vRt = 0;
                    }
                    w.i("MicroMsg.ImageGalleryHolderImage", "dkprog addBit: [%d,%d,%d] succ:%d change:%d str:%s file:%s", Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(aVar.vRt), Integer.valueOf(aVar.vRv), aVar.vRu, str);
                }
            } catch (Throwable th) {
                w.e("MicroMsg.ImageGalleryHolderImage", "get useopt  addBit :%s", bg.g(th));
            }
        }
    }

    public d(b bVar) {
        super(bVar);
        com.tencent.mm.sdk.b.a aVar = com.tencent.mm.sdk.b.a.urY;
        c egVar = new eg(com.tencent.mm.ui.chatting.eg.a.IMAGE_GALLERY_UI, bVar.vPV);
        this.vRm = egVar;
        aVar.b(egVar);
        this.vRo.aj(a.vRG.mhf.snapshot());
        k.bXy().vTG = this;
    }

    public final void detach() {
        super.detach();
        com.tencent.mm.sdk.b.a.urY.c(this.vRm);
        if (this.sbz != null) {
            for (Object obj : this.sbz.keySet()) {
                Bitmap bitmap = (Bitmap) ((WeakReference) this.sbz.get(obj)).get();
                if (!(bitmap == null || bitmap.isRecycled())) {
                    w.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
            }
        }
        e eVar = this.vRo;
        eVar.vRx = null;
        eVar.mhb.clear();
        eVar.mhe.clear();
        eVar.mhd.clear();
        eVar.mhc.clear();
        eVar.ayW();
        n.GT().a((com.tencent.mm.ah.c.a) this);
        k bXy = k.bXy();
        if (equals(bXy.vTG)) {
            bXy.vTG = null;
        }
    }

    public final int bf(au auVar) {
        if (auVar == null || !this.vRn.containsKey(Long.valueOf(auVar.field_msgId))) {
            return 0;
        }
        return ((Integer) this.vRn.get(Long.valueOf(auVar.field_msgId))).intValue();
    }

    private void h(au auVar, int i) {
        this.vRn.put(Long.valueOf(auVar.field_msgId), Integer.valueOf(i));
    }

    private void x(long j, int i) {
        this.vRn.put(Long.valueOf(j), Integer.valueOf(i));
    }

    public final boolean a(j jVar, au auVar, int i) {
        super.a(jVar, auVar, i);
        if (jVar == null || auVar == null || i < 0) {
            return false;
        }
        int bf = bf(auVar);
        w.i("MicroMsg.ImageGalleryHolderImage", "filling image : %s position : %s", Integer.valueOf(jVar.vTx.hashCode()), Integer.valueOf(i));
        j.M(jVar.vTo, 8);
        com.tencent.mm.ah.d e = e(auVar, false);
        if (e == null) {
            return false;
        }
        switch (bf) {
            case 0:
                boolean bMt;
                w.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloadOrSucc");
                w.i("MicroMsg.ImageGalleryHolderImage", "deal LoadFail");
                if (auVar.field_isSend == 1) {
                    bMt = auVar.bMt();
                } else if (auVar.bMt()) {
                    bMt = true;
                } else {
                    String c = c(auVar, e);
                    if (!e.GA() || (c != null && e.aO(c))) {
                        Object obj = (System.currentTimeMillis() - auVar.field_createTime <= 259200000 || (!bg.mA(c) && e.aO(c))) ? null : 1;
                        bMt = obj != null;
                    } else {
                        bMt = true;
                    }
                }
                if (!bMt) {
                    if (!a(jVar, auVar, e, i)) {
                        h(auVar, 2);
                    } else if (e.GA()) {
                        h(auVar, 4);
                        break;
                    } else {
                        h(auVar, 1);
                    }
                    w.i("MicroMsg.ImageGalleryHolderImage", "put image download task downloadCode [%d].", Integer.valueOf(n.GT().a(e.hEY, auVar.field_msgId, 0, Integer.valueOf(i), auVar.field_isSend == 1 ? R.g.bdJ : R.g.bdH, this, 0)));
                    if (n.GT().a(e.hEY, auVar.field_msgId, 0, Integer.valueOf(i), auVar.field_isSend == 1 ? R.g.bdJ : R.g.bdH, this, 0) != -2) {
                        a(jVar, auVar, e, false, i);
                        break;
                    }
                    w.w("MicroMsg.ImageGalleryHolderImage", "it is already download image finish, but imgInfo is old, search db and repair.");
                    com.tencent.mm.ah.d e2 = e(auVar, true);
                    if (e2 != null) {
                        if (!a(jVar, auVar, e2, i)) {
                            h(auVar, 2);
                        } else if (auVar.field_isSend == 1 || e2.GA()) {
                            h(auVar, 4);
                            break;
                        } else {
                            h(auVar, 1);
                        }
                        w.w("MicroMsg.ImageGalleryHolderImage", "it repair fail show thumb image.ImgInfo[%d, %b]", Long.valueOf(e2.hEY), Boolean.valueOf(e2.GA()));
                        a(jVar, auVar, e2, false, i);
                        break;
                    }
                    w.w("MicroMsg.ImageGalleryHolderImage", "get imgInfo by db but it is null.");
                    break;
                }
                h(auVar, 5);
                a(auVar, jVar, i, 5);
                break;
                break;
            case 1:
            case 4:
                a(jVar, auVar, e, i);
                break;
            case 2:
                a(jVar, auVar, e, false, i);
                break;
            case 3:
                a(jVar, auVar, e, true, i);
                break;
            case 5:
            case 6:
                a(auVar, jVar, i, bf);
                jVar.mil.invalidate();
                break;
        }
        return true;
    }

    public static com.tencent.mm.ah.d bg(au auVar) {
        if (!b.aR(auVar)) {
            return null;
        }
        if (auVar.field_isSend == 1) {
            com.tencent.mm.ah.d aj = n.GS().aj(auVar.field_msgId);
            if (aj.hEY != 0) {
                return aj;
            }
        }
        return n.GS().ai(auVar.field_msgSvrId);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.ah.d e(com.tencent.mm.storage.au r11, boolean r12) {
        /*
        r10 = this;
        r8 = 0;
        r2 = 0;
        r4 = 1;
        r0 = com.tencent.mm.ui.chatting.gallery.b.aR(r11);
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        return r2;
    L_0x000b:
        r0 = r10.vPU;
        if (r0 == 0) goto L_0x0015;
    L_0x000f:
        r0 = r10.vPU;
        r0 = r0.vPW;
        if (r0 != 0) goto L_0x001f;
    L_0x0015:
        r0 = "MicroMsg.ImageGalleryHolderImage";
        r1 = "adapter is null!!";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        goto L_0x000a;
    L_0x001f:
        if (r12 != 0) goto L_0x0053;
    L_0x0021:
        r0 = r11.field_isSend;
        if (r0 != r4) goto L_0x0038;
    L_0x0025:
        r0 = r10.vPU;
        r0 = r0.vPW;
        r0 = r0.vQu;
        r2 = r11.field_msgId;
        r1 = java.lang.Long.valueOf(r2);
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.ah.d) r0;
        r2 = r0;
    L_0x0038:
        if (r2 != 0) goto L_0x0053;
    L_0x003a:
        r0 = r11.field_msgSvrId;
        r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x0053;
    L_0x0040:
        r0 = r10.vPU;
        r0 = r0.vPW;
        r0 = r0.vQt;
        r2 = r11.field_msgSvrId;
        r1 = java.lang.Long.valueOf(r2);
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.ah.d) r0;
        r2 = r0;
    L_0x0053:
        if (r2 != 0) goto L_0x000a;
    L_0x0055:
        r3 = 0;
        r0 = r11.field_isSend;
        if (r0 != r4) goto L_0x006a;
    L_0x005a:
        r0 = r11.field_msgId;
        r2 = com.tencent.mm.ah.n.GS();
        r2 = r2.aj(r0);
        r6 = r2.hEY;
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 != 0) goto L_0x0075;
    L_0x006a:
        r0 = r11.field_msgSvrId;
        r2 = com.tencent.mm.ah.n.GS();
        r2 = r2.ai(r0);
        r3 = r4;
    L_0x0075:
        r4 = r10.vPU;
        r4 = r4.vPW;
        if (r3 == 0) goto L_0x0085;
    L_0x007b:
        r3 = r4.vQt;
        r0 = java.lang.Long.valueOf(r0);
        r3.put(r0, r2);
        goto L_0x000a;
    L_0x0085:
        r3 = r4.vQu;
        r0 = java.lang.Long.valueOf(r0);
        r3.put(r0, r2);
        goto L_0x000a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.d.e(com.tencent.mm.storage.au, boolean):com.tencent.mm.ah.d");
    }

    private String c(au auVar, com.tencent.mm.ah.d dVar) {
        String str = (String) this.vRp.get(auVar);
        if (str != null) {
            return str;
        }
        str = a(auVar, dVar, false);
        if (str == null || str.length() == 0) {
            return null;
        }
        this.vRp.put(auVar, str);
        return str;
    }

    private boolean a(j jVar, au auVar, com.tencent.mm.ah.d dVar, int i) {
        w.i("MicroMsg.ImageGalleryHolderImage", "edw dealSucc");
        String c = c(auVar, dVar);
        j.M(jVar.vTt, 8);
        String str = (String) this.vRq.get(auVar);
        if (str == null) {
            str = n.GS().v(auVar.field_imgPath, true);
            this.vRq.put(auVar, str);
        }
        boolean a = a(jVar, str, c, auVar);
        if (i == this.vPU.vPV.bXf() && this.vPU.vPZ) {
            this.vPU.ba(auVar);
            this.vPU.vPZ = false;
        }
        return a;
    }

    private void a(j jVar, au auVar, com.tencent.mm.ah.d dVar, boolean z, int i) {
        a(jVar, auVar, dVar, z, true, i);
    }

    private void a(j jVar, au auVar, com.tencent.mm.ah.d dVar, boolean z, boolean z2, int i) {
        w.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloading, isHd = " + z);
        j.M(jVar.vTu, 8);
        String str = null;
        if (!z) {
            jVar.vTx.setVisibility(0);
        }
        com.tencent.mm.ah.d a = com.tencent.mm.ah.e.a(dVar);
        if (z && i == this.vPU.vPV.bXf()) {
            ImageGalleryUI imageGalleryUI = this.vPU.vPV;
            imageGalleryUI.ew(true);
            imageGalleryUI.bXe();
            imageGalleryUI.bWT().vRW.setVisibility(0);
            imageGalleryUI.bWT().vRX.setVisibility(8);
            imageGalleryUI.bWT().vRY.setVisibility(0);
            imageGalleryUI.bWT().vRZ.setVisibility(8);
            imageGalleryUI.bXh();
            imageGalleryUI.bXi();
            imageGalleryUI.bWT().vRY.setText("0%");
        }
        if (z) {
            str = a(auVar, dVar, true);
        }
        if (bg.mA(str)) {
            str = n.GS().m(a.hFb, "", "");
        }
        String v = n.GS().v(auVar.field_imgPath, true);
        if (z2) {
            a(jVar, v, str, auVar);
        }
        if (!z) {
            int i2 = dVar.hrs;
            if (Math.max(1, (int) (i2 != 0 ? ((((long) dVar.offset) * 100) / ((long) i2)) - 1 : 0)) > 50) {
                jVar.bXu().vTt.setVisibility(8);
            } else {
                jVar.bXu().vTt.setVisibility(0);
            }
        }
        jVar.bXu().vTr.setVisibility(8);
        jVar.bXu().vTq.setVisibility(8);
        jVar.bXu().vTp.setVisibility(8);
    }

    private void a(au auVar, j jVar, int i, int i2) {
        w.i("MicroMsg.ImageGalleryHolderImage", "edw dealFail", new Object[0]);
        String v = n.GS().v(auVar.field_imgPath, true);
        j.M(jVar.vTt, 8);
        j.M(jVar.vTo, 8);
        j.M(jVar.vTx, 8);
        jVar.bXv().vTu.setVisibility(0);
        if (v == null || !e.aO(v)) {
            jVar.bXv().vTw.setImageResource(R.k.dxt);
            jVar.bXv().vTv.setText(R.l.esw);
            return;
        }
        ImageView imageView = jVar.bXv().vTw;
        if (imageView != null) {
            if (bg.mA(v) || !e.aO(v)) {
                imageView.setImageBitmap(null);
            } else {
                Bitmap bitmap;
                if (this.vRo.mhf.aV(v)) {
                    bitmap = (Bitmap) this.vRo.mhf.get(v);
                    if (!bitmap.isRecycled()) {
                        imageView.setImageBitmap(bitmap);
                    }
                }
                if (this.vPU.vQf) {
                    bitmap = TJ(v);
                    if (bitmap != null) {
                        c(imageView, bitmap);
                    }
                }
                if (!this.vRo.b(imageView, i)) {
                    this.vRo.q(imageView, v);
                }
            }
        }
        if (i2 == 6) {
            jVar.bXv().vTv.setText(R.l.esu);
        } else if (auVar.bMt()) {
            jVar.bXv().vTv.setText(R.l.ess);
        } else {
            jVar.bXv().vTv.setText(R.l.est);
        }
    }

    private boolean a(j jVar, String str, String str2, au auVar) {
        j.M(jVar.vTx, 0);
        j.M(jVar.vTo, 8);
        j.M(jVar.vTt, 8);
        j.M(jVar.vTu, 8);
        return a(true, jVar.vTx, str, str2, false, jVar.kC);
    }

    private boolean a(boolean z, MultiTouchImageView multiTouchImageView, String str, String str2, boolean z2, int i) {
        boolean z3;
        String str3;
        w.i("MicroMsg.ImageGalleryHolderImage", "initImageView image : %s bigImgPath %s position : %s", Integer.valueOf(multiTouchImageView.hashCode()), str2, Integer.valueOf(i));
        if (str2 == null || !e.aO(str2)) {
            z3 = false;
            Object obj = null;
        } else {
            z3 = true;
            str3 = str2;
        }
        String str4 = (str3 == null && str != null && e.aO(str)) ? e.aO(new StringBuilder().append(str).append("hd").toString()) ? str + "hd" : str : str3;
        if (str4 == null) {
            w.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, file does not exist, filePath %s", str2);
            return false;
        }
        Bitmap bitmap;
        if (!z2 && this.vRo.mhf.aV(str4)) {
            bitmap = (Bitmap) this.vRo.mhf.get(str4);
            if (!bitmap.isRecycled()) {
                w.i("MicroMsg.ImageGalleryHolderImage", "use cache, fillBitmap path : %s", str4);
                b(multiTouchImageView, bitmap);
                return true;
            }
        }
        if (z) {
            multiTouchImageView.setImageBitmap(null);
        }
        if (this.vPU.vQf) {
            bitmap = TJ(str4);
            if (bitmap == null) {
                bitmap = TJ(str);
            }
            if (bitmap != null) {
                c((ImageView) multiTouchImageView, bitmap);
                if (str4.equals(str2)) {
                    this.vRo.t(str4, bitmap);
                }
                return z3;
            }
        } else if (i >= 0) {
            this.vRo.b(multiTouchImageView, i);
        }
        this.vRo.q(multiTouchImageView, str4);
        return z3;
    }

    public final void c(ImageView imageView, Bitmap bitmap) {
        if (bitmap != null && imageView != null) {
            int hashCode = imageView.hashCode();
            int hashCode2 = bitmap.hashCode();
            int indexOfValue = this.vRo.mhg.indexOfValue(hashCode);
            if (indexOfValue >= 0) {
                this.vRo.mhg.removeAt(indexOfValue);
            }
            this.vRo.mhg.put(hashCode2, hashCode);
            if (imageView instanceof MultiTouchImageView) {
                b((MultiTouchImageView) imageView, bitmap);
            } else {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    public final Bitmap TJ(String str) {
        if (str == null) {
            return null;
        }
        Bitmap decodeAsBitmap;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        if (decodeFile != null) {
            w.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", decodeFile.toString());
            decodeFile.recycle();
        }
        boolean z = u.bh(options.outWidth, options.outHeight) && options.outWidth > 480;
        boolean z2 = u.bg(options.outWidth, options.outHeight) && options.outHeight > 480;
        if (z || z2) {
            int i = options.outHeight;
            i = options.outWidth;
        }
        int Pc = ExifHelper.Pc(str);
        decodeFile = T(str, options.outHeight, options.outWidth);
        if (decodeFile == null) {
            decodeFile = com.tencent.mm.sdk.platformtools.d.cz(str, 0);
        }
        if (decodeFile == null && MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
            decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(str);
            String str2 = "MicroMsg.ImageGalleryHolderImage";
            String str3 = "Progressive jpeg, result isNull:%b";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(decodeAsBitmap == null);
            w.i(str2, str3, objArr);
        } else {
            decodeAsBitmap = decodeFile;
        }
        if (decodeAsBitmap == null) {
            w.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, temBmp is null, filePath = " + str);
            return null;
        }
        decodeFile = com.tencent.mm.sdk.platformtools.d.b(decodeAsBitmap, (float) Pc);
        if (decodeFile != decodeAsBitmap || Pc % 360 == 0) {
            return decodeFile;
        }
        w.e("MicroMsg.ImageGalleryHolderImage", "rotate failed degree:%d", Integer.valueOf(Pc));
        return null;
    }

    private static Bitmap T(String str, int i, int i2) {
        Throwable th;
        Throwable th2;
        Bitmap bitmap = null;
        String str2 = str + "_tmp.jpg";
        Bitmap bitmap2;
        try {
            if (com.tencent.mm.compatible.util.d.ep(16)) {
                return null;
            }
            if (!b.bIu()) {
                int i3 = bg.getInt(com.tencent.mm.i.g.sV().getValue("UseOptImageRecv"), 0);
                ap.yY();
                w.i("MicroMsg.ImageGalleryHolderImage", "fromPathToImgInfo opt:%d uin:(%d,%d) debug:%b sdk:%d", Integer.valueOf(i3), Long.valueOf(r2.longValue()), Long.valueOf(new o(com.tencent.mm.u.c.uH()).longValue() / 100), Boolean.valueOf(b.bIu()), Integer.valueOf(VERSION.SDK_INT));
                if ((((int) (new o(com.tencent.mm.u.c.uH()).longValue() / 100)) % 100) + 1 > i3) {
                    return null;
                }
            }
            j.p(str, str2, false);
            boolean IsJpegFile = MMNativeJpeg.IsJpegFile(str2);
            boolean isProgressive = MMNativeJpeg.isProgressive(str2);
            boolean checkIntegrity = (bg.mA(str2) || !new File(str2).exists()) ? false : MMJpegOptim.checkIntegrity(str2);
            int aN = e.aN(str2);
            if (IsJpegFile && isProgressive) {
                if (checkIntegrity) {
                    bitmap = MMNativeJpeg.decodeAsBitmap(str2);
                }
                try {
                    a.g(str, i2, i, bitmap != null ? aN : 0 - aN);
                    bitmap2 = bitmap;
                } catch (Throwable th3) {
                    th = th3;
                    bitmap2 = bitmap;
                    th2 = th;
                    w.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", str, bg.g(th2));
                    com.tencent.mm.loader.stub.b.deleteFile(str2);
                    return bitmap2;
                }
            }
            bitmap2 = null;
            try {
                w.i("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt jpeg:%b isprog:%b inte:%b len:%d [%d,%d] bm:%s path:%s", Boolean.valueOf(IsJpegFile), Boolean.valueOf(isProgressive), Boolean.valueOf(checkIntegrity), Integer.valueOf(aN), Integer.valueOf(i2), Integer.valueOf(i), bitmap2, str);
            } catch (Throwable th4) {
                th2 = th4;
                w.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", str, bg.g(th2));
                com.tencent.mm.loader.stub.b.deleteFile(str2);
                return bitmap2;
            }
            com.tencent.mm.loader.stub.b.deleteFile(str2);
            return bitmap2;
        } catch (Throwable th32) {
            w.e("MicroMsg.ImageGalleryHolderImage", "get useopt :%s", bg.g(th32));
            return null;
        } catch (Throwable th322) {
            th = th322;
            bitmap2 = null;
            th2 = th;
            w.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", str, bg.g(th2));
            com.tencent.mm.loader.stub.b.deleteFile(str2);
            return bitmap2;
        }
    }

    public static String a(au auVar, com.tencent.mm.ah.d dVar, boolean z) {
        String m;
        if (auVar.field_isSend == 1) {
            m = n.GS().m(n.GS().d(dVar), "", "");
            if (e.aO(m)) {
                return m;
            }
            m = n.GS().m(dVar.hEZ, "", "");
            if (e.aO(m)) {
                return m;
            }
            return null;
        } else if (z || dVar.GA()) {
            String str = dVar.hEZ;
            if (dVar.GB()) {
                m = n.GS().d(dVar);
                if (m != null) {
                    m = n.GS().m(m, "", "");
                    if (e.aO(m)) {
                        w.i("MicroMsg.ImageGalleryHolderImage", "hasHdImg");
                        if (m == null) {
                            m = n.GS().m(str, "", "");
                        }
                        w.i("MicroMsg.ImageGalleryHolderImage", "the path : %s", m);
                        return m;
                    }
                }
            }
            m = null;
            if (m == null) {
                m = n.GS().m(str, "", "");
            }
            w.i("MicroMsg.ImageGalleryHolderImage", "the path : %s", m);
            return m;
        } else {
            w.w("MicroMsg.ImageGalleryHolderImage", "getImagePath is null because of isTryToGetProgress %s img.isGetCompleted() %s", Boolean.valueOf(z), Boolean.valueOf(dVar.GA()));
            return null;
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, k kVar) {
        if (this.vPU != null && this.vPU.vPV != null && this.xV == 0) {
            Integer num;
            if (k.bXy().eU(j2)) {
                int a = a(j2, obj);
                if (a != -1) {
                    num = new Integer(a);
                } else {
                    return;
                }
            }
            num = obj;
            if (num instanceof Integer) {
                int intValue = num.intValue();
                w.i("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos[%d], offset[%d], totalLen[%d], resId[%d], compressType[%d], imgLocalId[%d],", Integer.valueOf(intValue), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(j));
                if (intValue == -1) {
                    w.e("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos is -1");
                    return;
                } else if (this.vPU.Al(intValue) != null) {
                    j jVar = (j) this.vPU.Al(intValue).getTag();
                    if (jVar != null) {
                        int i5;
                        if (intValue == this.vPU.vPV.bXf() && !Bz(i)) {
                            this.vPU.vPV.ew(false);
                        }
                        if (i3 == 0) {
                            i5 = 0;
                        } else {
                            i5 = (int) (i4 != 0 ? ((((float) i3) / ((float) i4)) * 100.0f) - 1.0f : 0.0f);
                        }
                        int max = Math.max(1, i5);
                        if (intValue == this.vPU.vPV.bXf() && Bz(i)) {
                            w.i("MicroMsg.ImageGalleryHolderImage", "jacks loading hd from progress : %d, time: %d", Integer.valueOf(max), Long.valueOf(System.currentTimeMillis()));
                            this.vPU.vPV.BG(max);
                        }
                        com.tencent.mm.ah.j jVar2 = (com.tencent.mm.ah.j) kVar;
                        boolean isProgressive = MMNativeJpeg.isProgressive(jVar2.hGA);
                        boolean z = jVar2.hGC;
                        long aB = bg.aB(this.vRr);
                        a.cT(jVar2.hGA, i4);
                        w.i("MicroMsg.ImageGalleryHolderImage", "dkprog onImgTaskProgress getCanShow:%b isProg:%b timeDiff:%d  [%d/%d] %s", Boolean.valueOf(z), Boolean.valueOf(isProgressive), Long.valueOf(aB), Integer.valueOf(i3), Integer.valueOf(i4), jVar2.hGA);
                        if (z && isProgressive && aB > 1000) {
                            this.vRr = bg.NA();
                            au Bm = this.vPU.Bm(intValue);
                            if (a(false, jVar.vTx, n.GS().v(Bm.field_imgPath, true), a(Bm, e(Bm, true), true), true, -1)) {
                                j.M(jVar.vTx, 0);
                                j.M(jVar.vTr, 8);
                                j.M(jVar.vTu, 8);
                                if (intValue == this.vPU.vPV.bXf() && !Bz(i)) {
                                    if (max > 50) {
                                        j.M(jVar.vTt, 8);
                                        return;
                                    } else {
                                        j.M(jVar.vTt, 0);
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            w.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, k kVar) {
        if (this.vPU != null && this.vPU.vPV != null) {
            Integer num;
            if (k.bXy().eU(j2)) {
                int a = a(j2, obj);
                if (a == -1) {
                    ap.yY();
                    a(com.tencent.mm.u.c.wT().cA(j2), "background", false);
                    return;
                }
                num = new Integer(a);
            } else {
                num = obj;
            }
            if (num instanceof Integer) {
                final int intValue = num.intValue();
                w.i("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos = " + intValue);
                if (intValue == -1) {
                    w.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos is -1");
                    g.oUh.a(111, 3, 1, true);
                    return;
                }
                j jVar;
                if (this.vPU.Al(intValue) != null) {
                    jVar = (j) this.vPU.Al(intValue).getTag();
                } else {
                    jVar = null;
                }
                boolean eU = k.bXy().eU(j2);
                if (i3 == 0 && i4 == 0) {
                    if (eU) {
                        a(this.vPU.Bm(intValue), "hd_suc:" + intValue, intValue == this.vPU.vPV.bXf());
                    }
                    w.i("MicroMsg.ImageGalleryHolderImage", "pos = " + intValue + ", selectedPos = " + this.vPU.vPV.bXf(), new Object[0]);
                    x(j2, 4);
                    au Bm = this.vPU.Bm(intValue);
                    com.tencent.mm.ah.d e = e(Bm, true);
                    if (jVar != null) {
                        this.vPU.vPV.ew(true);
                        if (intValue == this.vPU.vPV.bXf()) {
                            if (Bz(i)) {
                                ImageGalleryUI imageGalleryUI = this.vPU.vPV;
                                imageGalleryUI.ew(true);
                                imageGalleryUI.ew(true);
                                Animation BF = ImageGalleryUI.BF(1000);
                                BF.setAnimationListener(new AnimationListener(imageGalleryUI) {
                                    final /* synthetic */ ImageGalleryUI vSz;

                                    {
                                        this.vSz = r1;
                                    }

                                    public final void onAnimationStart(Animation animation) {
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                        if (this.vSz.bWT().vRZ.getVisibility() == 0) {
                                            this.vSz.bXe();
                                            this.vSz.bWT().vRW.setVisibility(8);
                                            this.vSz.bXj();
                                            this.vSz.bXk();
                                        }
                                    }
                                });
                                imageGalleryUI.bXe();
                                imageGalleryUI.bWT().vRW.setVisibility(0);
                                imageGalleryUI.bWT().vRX.setVisibility(8);
                                imageGalleryUI.bWT().vRY.setVisibility(8);
                                imageGalleryUI.bWT().vRZ.setVisibility(0);
                                imageGalleryUI.bWT().vRZ.startAnimation(BF);
                            } else {
                                jVar.vTx.post(new Runnable(this) {
                                    final /* synthetic */ d vRs;

                                    public final void run() {
                                        if (this.vRs.vPU != null && this.vRs.vPU.vPV != null) {
                                            this.vRs.vPU.vPV.BC(intValue);
                                        }
                                    }
                                });
                            }
                        }
                        if (a(false, jVar.vTx, n.GS().v(Bm.field_imgPath, true), a(Bm, e, true), true, -1)) {
                            j.M(jVar.vTx, 0);
                            j.M(jVar.vTo, 8);
                            j.M(jVar.vTt, 8);
                            j.M(jVar.vTu, 8);
                            if (bf(Bm) == 4 && this.vPU.vPZ) {
                                this.vPU.ba(Bm);
                                this.vPU.vPZ = false;
                                return;
                            }
                            return;
                        }
                        w.e("MicroMsg.ImageGalleryHolderImage", "failed to show downloaded image!");
                        g.oUh.a(111, 2, 1, true);
                        return;
                    }
                    return;
                }
                if (eU) {
                    a(this.vPU.Bm(intValue), "hd_failed:" + intValue, intValue == this.vPU.vPV.bXf());
                }
                if (intValue == this.vPU.vPV.bXf()) {
                    this.vPU.vPV.ew(true);
                }
                if (i4 == -5103059) {
                    x(j2, 5);
                    g.oUh.a(111, 0, 1, true);
                } else {
                    x(j2, 6);
                    g.oUh.a(111, 1, 1, true);
                }
                w.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, errType = " + i3 + ", errCode = " + i4);
                this.vPU.vQa.Bl(intValue);
                return;
            }
            w.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        }
    }

    private int a(long j, Object obj) {
        int intValue;
        if (obj instanceof Integer) {
            intValue = ((Integer) obj).intValue();
            ce Bm = this.vPU.Bm(intValue);
            if (Bm != null && Bm.field_msgId == j) {
                return intValue;
            }
        }
        for (Integer intValue2 : this.vPU.vnL.values()) {
            intValue = intValue2.intValue();
            ce Bm2 = this.vPU.Bm(intValue);
            if (Bm2 != null && Bm2.field_msgId == j) {
                return intValue;
            }
        }
        return -1;
    }

    private static void a(au auVar, String str, boolean z) {
        w.i("MicroMsg.ImageGalleryHolderImage", "[oreh download_and_save] hdImg end, msgLocalId:%d, %s", Long.valueOf(auVar.field_msgId), str);
        b.b(ab.getContext(), auVar, z);
    }

    private static boolean Bz(int i) {
        return i == 1;
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
        if (obj instanceof Integer) {
            w.i("MicroMsg.ImageGalleryHolderImage", "image task canceled at pos " + ((Integer) obj).intValue(), new Object[0]);
            return;
        }
        w.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
    }

    public final void al(int i, boolean z) {
        w.i("MicroMsg.ImageGalleryHolderImage", "viewHdImg, pos = " + i);
        au Bm = this.vPU.Bm(i);
        if (Bm == null || Bm.field_msgId == 0) {
            w.e("MicroMsg.ImageGalleryHolderImage", "msg is null");
        } else if (b.aR(Bm)) {
            com.tencent.mm.ah.d e = e(Bm, true);
            if (e == null || e.hEY == 0) {
                w.e("MicroMsg.ImageGalleryHolderImage", "viewHdImg fail, msgLocalId = " + (Bm == null ? "null" : Long.valueOf(Bm.field_msgId)) + ", imgLocalId = " + (e == null ? "null" : Long.valueOf(e.hEY)));
                return;
            }
            h(Bm, 3);
            if (Bk(i) != null) {
                a(Bk(i), Bm, e, true, false, i);
            }
            if (z) {
                com.tencent.mm.ah.c.a bXy = k.bXy();
                w.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] startScene, msgLoacalID:%d", Long.valueOf(Bm.field_msgId));
                bXy.vTF.add(Long.valueOf(Bm.field_msgId));
                n.GT().a(e.hEY, Bm.field_msgId, 1, Integer.valueOf(i), Bm.field_isSend == 1 ? R.g.bdJ : R.g.bdH, bXy, 0);
                return;
            }
            n.GT().a(e.hEY, Bm.field_msgId, 1, Integer.valueOf(i), Bm.field_isSend == 1 ? R.g.bdJ : R.g.bdH, this, 0);
        } else {
            w.e("MicroMsg.ImageGalleryHolderImage", "not img can't download hd");
        }
    }

    @TargetApi(11)
    private void b(MultiTouchImageView multiTouchImageView, Bitmap bitmap) {
        if (this.vPU != null && this.vPU.vPV != null) {
            w.i("MicroMsg.ImageGalleryHolderImage", "fillBitmap image : %s bmp %s", Integer.valueOf(multiTouchImageView.hashCode()), Integer.valueOf(bitmap.hashCode()));
            if (VERSION.SDK_INT == 20) {
                multiTouchImageView.setLayerType(1, null);
            } else {
                com.tencent.mm.sdk.platformtools.k.i((View) multiTouchImageView.getParent(), bitmap.getWidth(), bitmap.getHeight());
            }
            multiTouchImageView.qBZ = false;
            multiTouchImageView.dZ(bitmap.getWidth(), bitmap.getHeight());
            multiTouchImageView.setImageBitmap(null);
            multiTouchImageView.setImageBitmap(bitmap);
            multiTouchImageView.invalidate();
        }
    }

    public final Bitmap BA(int i) {
        if (this.vPU == null) {
            return null;
        }
        ce Bx = this.vPU.vPW.Bx(i);
        if (Bx == null) {
            return null;
        }
        String str = (String) this.vRq.get(Bx);
        if (str == null) {
            str = n.GS().v(Bx.field_imgPath, true);
            this.vRq.put(Bx, str);
        }
        String str2 = str + "hd";
        if (e.aO(str2)) {
            return TJ(str2);
        }
        return TJ(str);
    }
}
