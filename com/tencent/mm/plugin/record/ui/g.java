package com.tencent.mm.plugin.record.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.a.m;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.b;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;

public final class g extends j implements a {
    public final void a(a.a aVar) {
        String str = null;
        ImageView imageView = aVar.fKf;
        rm rmVar = aVar.fKe;
        long j = aVar.oPl;
        int i = aVar.fKg;
        int i2 = aVar.width;
        int i3 = aVar.height;
        if (imageView != null) {
            if (!f.rZ()) {
                imageView.setImageResource(R.g.bhP);
            } else if (rmVar == null) {
                imageView.setImageResource(i);
            } else {
                ru ruVar;
                switch (rmVar.aMw) {
                    case 4:
                    case 15:
                        super.a(imageView, rmVar, j, rmVar.fFs, i, i2, i3);
                        return;
                    case 5:
                        sf sfVar;
                        if (rmVar.tyc != null) {
                            sfVar = rmVar.tyc.tyy;
                        } else {
                            w.w("MicroMsg.RecordMsgImgService", "webpage: get data proto item null, dataid[%s]", new Object[]{rmVar.lKv});
                            sfVar = null;
                        }
                        if (sfVar != null) {
                            str = sfVar.thumbUrl;
                        }
                        super.a(imageView, rmVar, j, bg.mA(str) ? rmVar.fFs : str, i, i2, i3);
                        return;
                    case 7:
                        super.a(imageView, rmVar, j, rmVar.fFs, i, i2, i3);
                        return;
                    case 10:
                        if (rmVar.tyc == null) {
                            w.w("MicroMsg.RecordMsgImgService", "good: get data proto item null, dataid[%s]", new Object[]{rmVar.lKv});
                            return;
                        }
                        ruVar = rmVar.tyc.tyA;
                        if (ruVar != null) {
                            this.oOy.a(imageView, null, ruVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 11:
                        if (rmVar.tyc == null) {
                            w.w("MicroMsg.RecordMsgImgService", "product: get data proto item null, dataid[%s]", new Object[]{rmVar.lKv});
                            return;
                        }
                        ruVar = rmVar.tyc.tyA;
                        if (ruVar != null) {
                            this.oOy.a(imageView, null, ruVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 14:
                        if (rmVar.tyc == null) {
                            w.w("MicroMsg.RecordMsgImgService", "tv: get data proto item null, dataid[%s]", new Object[]{rmVar.lKv});
                            return;
                        }
                        rz rzVar = rmVar.tyc.tyC;
                        if (rzVar != null) {
                            this.oOy.a(imageView, null, rzVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    default:
                        w.w("MicroMsg.RecordMsgImgService", "attach thumb, pass data type is %d", new Object[]{Integer.valueOf(rmVar.aMw)});
                        return;
                }
            }
        }
    }

    public final Bitmap a(c cVar) {
        return super.b(cVar.fKe, cVar.oPl);
    }

    public final Bitmap a(b bVar) {
        Bitmap bitmap;
        rm rmVar = bVar.fKe;
        long j = bVar.oPl;
        boolean z = bVar.fKh;
        int i = bVar.maxWidth;
        if (f.rZ()) {
            String c = m.c(rmVar, j);
            if (bg.mA(c) || !e.aO(c)) {
                w.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", new Object[]{Boolean.valueOf(false), c});
                bitmap = null;
            } else {
                bitmap = (Bitmap) this.lGm.get(c);
                if (bitmap != null) {
                    w.d("MicroMsg.RecordMsgImgService", "get bm from cache %s", new Object[]{c});
                } else if (z) {
                    bitmap = null;
                } else {
                    w.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", new Object[]{c});
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    bitmap = BitmapFactory.decodeFile(c, options);
                    if (bitmap != null) {
                        w.i("MicroMsg.RecordMsgImgService", "bitmap recycle %s", new Object[]{bitmap});
                        bitmap.recycle();
                    }
                    int i2 = options.outHeight;
                    int i3 = options.outWidth;
                    w.d("MicroMsg.RecordMsgImgService", "width: %s, height: %s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
                    if (i3 > i) {
                        i2 = (options.outHeight * i) / options.outWidth;
                        i3 = i;
                    }
                    i3 = Math.max(1, i3);
                    i2 = Math.max(1, i2);
                    if (i3 > i) {
                        i3 = (options.outHeight * i) / options.outWidth;
                    } else {
                        i = i3;
                        i3 = i2;
                    }
                    i2 = ExifHelper.Pc(c);
                    if (i2 == 90 || i2 == 270) {
                        int i4 = i3;
                        i3 = i;
                        i = i4;
                    }
                    bitmap = d.d(c, i3, i, false);
                    if (bitmap == null) {
                        w.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = " + c);
                        bitmap = null;
                    } else {
                        bitmap = d.b(bitmap, (float) i2);
                        this.lGm.put(c, bitmap);
                    }
                }
            }
        } else {
            bitmap = BitmapFactory.decodeResource(ab.getContext().getResources(), R.g.bhP);
        }
        if (bitmap == null && !z) {
            w.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[]{Boolean.valueOf(super.a(rmVar, j))});
            m.a(rmVar, j, r3);
        }
        return bitmap;
    }

    public final void aWI() {
        super.destory();
    }
}
