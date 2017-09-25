package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import com.google.android.gms.c.l;
import com.google.android.gms.c.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public final class ImageManager {
    public static final Object aoY = new Object();
    public static HashSet<Uri> aoZ = new HashSet();
    public final ExecutorService apa;
    public final b apb;
    public final l apc;
    public final Map<a, ImageReceiver> apd;
    public final Map<Uri, ImageReceiver> ape;
    public final Map<Uri, Long> apf;
    public final Context mContext;
    public final Handler mHandler;

    private final class ImageReceiver extends ResultReceiver {
        private final Uri apg;
        private final ArrayList<a> aph;
        final /* synthetic */ ImageManager api;

        public final void onReceiveResult(int i, Bundle bundle) {
            this.api.apa.execute(new c(this.api, this.apg, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface a {
    }

    private final class c implements Runnable {
        private final Uri apg;
        final /* synthetic */ ImageManager api;
        private final ParcelFileDescriptor apj;

        public c(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.api = imageManager;
            this.apg = uri;
            this.apj = parcelFileDescriptor;
        }

        public final void run() {
            String str = "LoadBitmapFromDiskRunnable can't be executed in the main thread";
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                new StringBuilder("checkNotMainThread: current thread ").append(Thread.currentThread()).append(" IS the main thread ").append(Looper.getMainLooper().getThread()).append("!");
                throw new IllegalStateException(str);
            }
            boolean z = false;
            Bitmap bitmap = null;
            if (this.apj != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.apj.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    new StringBuilder("OOM while loading bitmap for uri: ").append(this.apg);
                    z = true;
                }
                try {
                    this.apj.close();
                } catch (IOException e2) {
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.api.mHandler.post(new d(this.api, this.apg, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                new StringBuilder("Latch interrupted while posting ").append(this.apg);
            }
        }
    }

    private final class d implements Runnable {
        private final CountDownLatch amU;
        private final Uri apg;
        final /* synthetic */ ImageManager api;
        private boolean apk;
        private final Bitmap mBitmap;

        public d(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.api = imageManager;
            this.apg = uri;
            this.mBitmap = bitmap;
            this.apk = z;
            this.amU = countDownLatch;
        }

        private void a(ImageReceiver imageReceiver, boolean z) {
            ArrayList a = imageReceiver.aph;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                a aVar = (a) a.get(i);
                if (z) {
                    aVar.a(this.api.mContext, this.mBitmap);
                } else {
                    this.api.apf.put(this.apg, Long.valueOf(SystemClock.elapsedRealtime()));
                    aVar.a(this.api.mContext, this.api.apc);
                }
                if (!(aVar instanceof com.google.android.gms.common.images.a.b)) {
                    this.api.apd.remove(aVar);
                }
            }
        }

        public final void run() {
            String str = "OnBitmapLoadedRunnable must be executed in the main thread";
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                new StringBuilder("checkMainThread: current thread ").append(Thread.currentThread()).append(" IS NOT the main thread ").append(Looper.getMainLooper().getThread()).append("!");
                throw new IllegalStateException(str);
            }
            boolean z = this.mBitmap != null;
            if (this.api.apb != null) {
                if (this.apk) {
                    this.api.apb.trimToSize(-1);
                    System.gc();
                    this.apk = false;
                    this.api.mHandler.post(this);
                    return;
                } else if (z) {
                    this.api.apb.put(new a(this.apg), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.api.ape.remove(this.apg);
            if (imageReceiver != null) {
                a(imageReceiver, z);
            }
            this.amU.countDown();
            synchronized (ImageManager.aoY) {
                ImageManager.aoZ.remove(this.apg);
            }
        }
    }

    private static final class b extends o<a, Bitmap> {
        protected final /* synthetic */ int W(Object obj) {
            Bitmap bitmap = (Bitmap) obj;
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
    }
}
