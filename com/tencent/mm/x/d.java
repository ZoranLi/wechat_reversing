package com.tencent.mm.x;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public final class d {
    private static int hqZ = ck.CTRL_INDEX;
    private static int hra = ck.CTRL_INDEX;
    static final Map<String, Integer> hrb;
    private static a hrf = new a(hra);
    private k<a, String> hrc = new k<a, String>(this) {
        final /* synthetic */ d hrg;

        {
            this.hrg = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((a) obj).ho((String) obj2);
        }
    };
    public Vector<WeakReference<a>> hrd = new Vector();
    private final a hre = new a(this) {
        final /* synthetic */ d hrg;

        {
            this.hrg = r1;
        }

        public final void ho(String str) {
            Collection vector = new Vector();
            w.d("MicroMsg.AvatarStorage", "notifyChanged user:%s clonesize:%d watchers:%d", str, Integer.valueOf(this.hrg.hrd.size()), Integer.valueOf(this.hrg.hrd.size()));
            Vector vector2 = new Vector();
            synchronized (this.hrg.hrd) {
                for (int i = 0; i < this.hrg.hrd.size(); i++) {
                    WeakReference weakReference = (WeakReference) this.hrg.hrd.get(i);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            vector2.add(aVar);
                        } else {
                            vector.add(weakReference);
                        }
                    }
                }
                this.hrg.hrd.removeAll(vector);
            }
            for (int i2 = 0; i2 < vector2.size(); i2++) {
                ((a) vector2.get(i2)).ho(str);
            }
        }
    };

    public interface a {
        void ho(String str);
    }

    public static class b {
        public static boolean hp(String str) {
            Bitmap hq = hq(str);
            if (hq == null || hq.isRecycled()) {
                return false;
            }
            OutputStream outputStream = null;
            try {
                outputStream = FileOp.gQ(str);
                hq.compress(CompressFormat.PNG, 100, outputStream);
                FileOp.deleteFile(str + ".bm");
                if (outputStream == null) {
                    return true;
                }
                try {
                    outputStream.close();
                    return true;
                } catch (IOException e) {
                    return true;
                }
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.AvatarStorage", e2, "Cannot write avatar file: %s", str);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return false;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
        }

        public static Bitmap hq(String str) {
            Exception e;
            OutOfMemoryError e2;
            String str2 = str + ".bm";
            InputStream openRead;
            ReadableByteChannel newChannel;
            try {
                if (FileOp.aO(str2)) {
                    int ki = (int) FileOp.ki(str2);
                    if (ki <= 0 || !(ki == 36864 || ki == 36880)) {
                        dd(str);
                        w.e("MicroMsg.AvatarStorage", "SmallBM get bm invalid size:%d file:%s", Integer.valueOf(ki), str2);
                        return null;
                    }
                    openRead = FileOp.openRead(str2);
                    try {
                        newChannel = Channels.newChannel(openRead);
                        try {
                            boolean z;
                            Buffer allocateDirect = ByteBuffer.allocateDirect(36864);
                            newChannel.read(allocateDirect);
                            allocateDirect.position(0);
                            if (ki == 36880) {
                                ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(16);
                                newChannel.read(allocateDirect2);
                                if (allocateDirect2.getLong(0) != 1) {
                                    w.e("MicroMsg.AvatarStorage", "SmallBM get bm header invalid flag:%d size:%d file:%s", Long.valueOf(allocateDirect2.getLong(0)), Integer.valueOf(ki), str2);
                                    newChannel.close();
                                    openRead.close();
                                    dd(str);
                                    return null;
                                }
                                z = false;
                            } else {
                                z = true;
                            }
                            w.d("MicroMsg.AvatarStorage", "SmallBM get bm size:%d shouldRemoveCorner:%b file:%s", Integer.valueOf(ki), Boolean.valueOf(z), str2);
                            newChannel.close();
                            openRead.close();
                            Bitmap createBitmap = Bitmap.createBitmap(96, 96, Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(allocateDirect);
                            if (!z) {
                                return createBitmap;
                            }
                            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 9, 9, 78, 78);
                            w.i("MicroMsg.AvatarStorage", "recycle bitmap:%s", createBitmap.toString());
                            createBitmap.recycle();
                            return createBitmap2;
                        } catch (Exception e3) {
                            e = e3;
                            w.e("MicroMsg.AvatarStorage", "SmallBM get exception e:%s file:%s", e.getMessage(), str2);
                            if (newChannel != null) {
                                try {
                                    newChannel.close();
                                } catch (Exception e4) {
                                    return null;
                                }
                            }
                            if (openRead != null) {
                                return null;
                            }
                            openRead.close();
                            return null;
                        } catch (OutOfMemoryError e5) {
                            e2 = e5;
                            w.e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                            if (newChannel != null) {
                                newChannel.close();
                            }
                            if (openRead != null) {
                                return null;
                            }
                            openRead.close();
                            return null;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        newChannel = null;
                        w.e("MicroMsg.AvatarStorage", "SmallBM get exception e:%s file:%s", e.getMessage(), str2);
                        if (newChannel != null) {
                            newChannel.close();
                        }
                        if (openRead != null) {
                            return null;
                        }
                        openRead.close();
                        return null;
                    } catch (OutOfMemoryError e7) {
                        e2 = e7;
                        newChannel = null;
                        w.e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                        if (newChannel != null) {
                            newChannel.close();
                        }
                        if (openRead != null) {
                            return null;
                        }
                        openRead.close();
                        return null;
                    }
                }
                w.w("MicroMsg.AvatarStorage", "SmallBM get bm file not exsit:%s", str2);
                return null;
            } catch (Exception e8) {
                e = e8;
                newChannel = null;
                openRead = null;
                w.e("MicroMsg.AvatarStorage", "SmallBM get exception e:%s file:%s", e.getMessage(), str2);
                if (newChannel != null) {
                    newChannel.close();
                }
                if (openRead != null) {
                    return null;
                }
                openRead.close();
                return null;
            } catch (OutOfMemoryError e9) {
                e2 = e9;
                newChannel = null;
                openRead = null;
                w.e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                if (newChannel != null) {
                    newChannel.close();
                }
                if (openRead != null) {
                    return null;
                }
                openRead.close();
                return null;
            }
        }

        public static boolean dd(String str) {
            FileOp.deleteFile(str + ".bm");
            FileOp.deleteFile(str);
            return true;
        }
    }

    static {
        Map hashMap = new HashMap();
        hrb = hashMap;
        hashMap.put("voipapp", Integer.valueOf(f.kEa));
        hrb.put("qqmail", Integer.valueOf(f.kDV));
        hrb.put("fmessage", Integer.valueOf(f.kDN));
        hrb.put("floatbottle", Integer.valueOf(f.kDK));
        hrb.put("lbsapp", Integer.valueOf(f.kDR));
        hrb.put("shakeapp", Integer.valueOf(f.kDX));
        hrb.put("medianote", Integer.valueOf(f.kDQ));
        hrb.put("qqfriend", Integer.valueOf(f.kDU));
        hrb.put("masssendapp", Integer.valueOf(f.kDP));
        hrb.put("feedsapp", Integer.valueOf(f.kDM));
        hrb.put("facebookapp", Integer.valueOf(f.dwr));
        hrb.put("newsapp", Integer.valueOf(f.kDW));
        hrb.put("helper_entry", Integer.valueOf(f.kDT));
        hrb.put("voicevoipapp", Integer.valueOf(f.kDZ));
        hrb.put("voiceinputapp", Integer.valueOf(f.kDY));
        hrb.put("officialaccounts", Integer.valueOf(f.kDL));
        hrb.put("service_officialaccounts", Integer.valueOf(f.dwv));
        hrb.put("linkedinplugin", Integer.valueOf(f.kDO));
        hrb.put("notifymessage", Integer.valueOf(f.kDS));
        hrb.put("appbrandcustomerservicemsg", Integer.valueOf(f.kDJ));
    }

    public static void a(Context context, ImageView imageView, int i) {
        try {
            imageView.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.compatible.f.a.decodeResource(context.getResources(), i), true, 1.0f));
        } catch (Throwable e) {
            w.e("MicroMsg.AvatarStorage", "exception:%s", bg.g(e));
        }
    }

    public d() {
        reset();
        this.hrc.a(this.hre, null);
    }

    public final void a(a aVar) {
        synchronized (this.hrd) {
            this.hrd.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        synchronized (this.hrd) {
            this.hrd.remove(c(aVar));
        }
    }

    private WeakReference<a> c(a aVar) {
        synchronized (this.hrd) {
            for (int i = 0; i < this.hrd.size(); i++) {
                WeakReference<a> weakReference = (WeakReference) this.hrd.get(i);
                if (weakReference != null) {
                    a aVar2 = (a) weakReference.get();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        return weakReference;
                    }
                }
            }
            return null;
        }
    }

    @Deprecated
    public final void d(a aVar) {
        this.hrc.a(aVar, Looper.getMainLooper());
    }

    @Deprecated
    public final void e(a aVar) {
        this.hrc.remove(aVar);
    }

    public static void reset() {
        if (hrf == null) {
            hrf = new a(hra);
        }
    }

    public static Bitmap hj(String str) {
        if (bg.mA(str)) {
            return null;
        }
        a aVar = hrf;
        Bitmap bitmap = aVar.hqG != null ? (Bitmap) aVar.hqG.get(str) : (Bitmap) com.tencent.mm.cache.a.a.x("avatar_cache", str);
        if (bitmap == null) {
            return null;
        }
        if (!bitmap.isRecycled()) {
            return bitmap;
        }
        aVar = hrf;
        if (aVar.hqG != null) {
            aVar.hqG.remove(str);
        } else {
            com.tencent.mm.cache.a.a.y("avatar_cache", str);
        }
        return null;
    }

    public final void c(String str, Bitmap bitmap) {
        a aVar = hrf;
        if (aVar.hqG != null) {
            aVar.hqG.k(str, bitmap);
        } else {
            com.tencent.mm.cache.a.a.a("avatar_cache", str, (Object) bitmap);
        }
        this.hrc.by(str);
        this.hrc.doNotify();
        w.d("MicroMsg.AvatarStorage", "setToCache %s", str);
    }

    public final Bitmap aS(Context context) {
        context.getResources();
        Bitmap hj = hj("I_AM_NO_SDCARD_USER_NAME");
        if (k(hj) || hj == null) {
            return hj;
        }
        w.i("MicroMsg.AvatarStorage", "not cached, recycled=%b, reload=%s", Boolean.valueOf(hj.isRecycled()), "I_AM_NO_SDCARD_USER_NAME");
        hj = com.tencent.mm.sdk.platformtools.d.a(hj, true, 1.0f);
        c("I_AM_NO_SDCARD_USER_NAME", hj);
        return hj;
    }

    public static String r(String str, boolean z) {
        if (bg.mA(str)) {
            return null;
        }
        String a = h.a(com.tencent.mm.plugin.g.a.ZW(), "user_" + (z ? "hd_" : ""), g.n(str.getBytes()), ".png", 1, false);
        if (a == null) {
            return null;
        }
        return !FileOp.kl(new File(a).getParent()) ? null : a;
    }

    public static boolean s(String str, boolean z) {
        String r = r(str, z);
        w.i("MicroMsg.AvatarStorage", "Removed avatar: %s, hd: %b, path: %s", str, Boolean.valueOf(z), r);
        boolean deleteFile = FileOp.deleteFile(r);
        if (z) {
            return deleteFile;
        }
        return deleteFile | b.dd(r);
    }

    public static Bitmap hk(String str) {
        return hn(r(str, false));
    }

    public static Bitmap f(String str, byte[] bArr) {
        Throwable e;
        Bitmap a = com.tencent.mm.sdk.platformtools.d.a(bArr, 96, 96, 0, 0, 1);
        if (k(a)) {
            int width = a.getWidth();
            int height = a.getHeight();
            if (width != height) {
                if (width > height) {
                    a = Bitmap.createBitmap(a, (width - height) / 2, 0, height, height);
                } else {
                    a = Bitmap.createBitmap(a, 0, (height - width) / 2, width, width);
                }
            }
            OutputStream gQ;
            try {
                gQ = FileOp.gQ(r(str, false));
                try {
                    gQ.write(bArr, 0, bArr.length);
                    if (gQ != null) {
                        try {
                            gQ.close();
                        } catch (IOException e2) {
                        }
                    }
                    w.i("MicroMsg.AvatarStorage", "Saved avatar: %s", str);
                    return a;
                } catch (IOException e3) {
                    e = e3;
                    try {
                        w.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                        if (gQ != null) {
                            try {
                                gQ.close();
                            } catch (IOException e4) {
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (gQ != null) {
                            try {
                                gQ.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                gQ = null;
                w.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                if (gQ != null) {
                    gQ.close();
                }
                return null;
            } catch (Throwable th2) {
                e = th2;
                gQ = null;
                if (gQ != null) {
                    gQ.close();
                }
                throw e;
            }
        }
        w.e("MicroMsg.AvatarStorage", "Failed to decode avatar: %s", str);
        return null;
    }

    public final boolean g(String str, byte[] bArr) {
        Bitmap f = f(str, bArr);
        if (!k(f)) {
            return false;
        }
        c(str, f);
        return true;
    }

    public final boolean R(String str, String str2) {
        int i = 96;
        try {
            int i2;
            Options Pe = com.tencent.mm.sdk.platformtools.d.Pe(str);
            int i3 = Pe.outWidth;
            int i4 = Pe.outHeight;
            if (i4 < i3) {
                i2 = (i3 * 96) / i4;
            } else {
                i = (i4 * 96) / i3;
                i2 = 96;
            }
            w.d("MicroMsg.AvatarStorage", "inJustDecodeBounds old [w:%d h:%d]  new [w:%d h:%d] corner:%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(1));
            Options options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            options.inSampleSize = Math.min(i3 / i2, i4 / i);
            Bitmap a = com.tencent.mm.sdk.platformtools.d.a(str, options, 0, 0, 1);
            a.recycle();
            return d(str2, a);
        } catch (Throwable e) {
            w.e("MicroMsg.AvatarStorage", "exception:%s", bg.g(e));
            return false;
        }
    }

    public boolean d(String str, Bitmap bitmap) {
        Throwable e;
        OutputStream outputStream;
        if (!k(bitmap)) {
            return false;
        }
        Bitmap bitmap2;
        if (bitmap.getWidth() == 96 && bitmap.getHeight() == 96) {
            bitmap2 = bitmap;
        } else {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (width != height) {
                    if (width > height) {
                        bitmap2 = Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height);
                    } else {
                        bitmap2 = Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width);
                    }
                    bitmap2 = Bitmap.createScaledBitmap(bitmap2, 96, 96, true);
                } else {
                    bitmap2 = Bitmap.createScaledBitmap(bitmap, 96, 96, true);
                }
            } catch (OutOfMemoryError e2) {
                w.e("MicroMsg.AvatarStorage", "kevin updateAvatar fail  %s ", str);
                if (k(bitmap)) {
                    w.i("MicroMsg.AvatarStorage", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
                return false;
            }
        }
        if (!(bitmap2 == null || bitmap2 == bitmap)) {
            w.i("MicroMsg.AvatarStorage", "recycle bitmap:%s", bitmap.toString());
            bitmap.recycle();
            bitmap = bitmap2;
        }
        OutputStream outputStream2 = null;
        try {
            outputStream2 = FileOp.gQ(r(str, false));
            try {
                bitmap.compress(CompressFormat.PNG, 100, outputStream2);
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e3) {
                    }
                }
                c(str, bitmap);
                return true;
            } catch (IOException e4) {
                e = e4;
                outputStream = outputStream2;
                try {
                    w.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                outputStream = outputStream2;
                if (outputStream != null) {
                    outputStream.close();
                }
                throw e;
            }
        } catch (IOException e7) {
            e = e7;
            outputStream = outputStream2;
            w.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
            if (outputStream != null) {
                outputStream.close();
            }
            return false;
        } catch (Throwable th3) {
            e = th3;
            outputStream = outputStream2;
            if (outputStream != null) {
                outputStream.close();
            }
            throw e;
        }
    }

    public static Bitmap hl(String str) {
        w.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s", str);
        if (bg.mA(str)) {
            return null;
        }
        return com.tencent.mm.sdk.platformtools.d.a(r(str, true), 480, 480, null, 0, 0, 1);
    }

    public static Bitmap hm(String str) {
        Bitmap decodeResource;
        int i = 0;
        if (hrb.containsKey(str)) {
            i = ((Integer) hrb.get(str)).intValue();
        }
        if (i != 0) {
            n.Bx();
            decodeResource = com.tencent.mm.compatible.f.a.decodeResource(n.getContext().getResources(), i);
        } else {
            decodeResource = null;
        }
        return com.tencent.mm.sdk.platformtools.d.a(decodeResource, true, 1.0f, true);
    }

    private static boolean k(Bitmap bitmap) {
        return (bitmap == null || bitmap.isRecycled()) ? false : true;
    }

    public static Bitmap hn(String str) {
        Bitmap a = FileOp.aO(str) ? com.tencent.mm.sdk.platformtools.d.a(str, null, 0, 0, 1) : null;
        if (a == null) {
            a = b.hq(str);
        }
        if (k(a)) {
            int width = a.getWidth();
            int height = a.getHeight();
            if (width != height) {
                if (width > height) {
                    a = Bitmap.createBitmap(a, (width - height) / 2, 0, height, height);
                } else {
                    a = Bitmap.createBitmap(a, 0, (height - width) / 2, width, width);
                }
            }
        }
        return k(a) ? a : null;
    }
}
