package com.tencent.mapsdk.raster.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.d.e;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public final class BitmapDescriptorFactory {
    public static BitmapDescriptor defaultMarker() {
        return fromAsset("marker.png");
    }

    public static BitmapDescriptor fromAsset(String str) {
        try {
            InputStream resourceAsStream = BitmapDescriptorFactory.class.getResourceAsStream("/assets/" + str);
            Bitmap decodeStream = BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            return fromBitmap(decodeStream);
        } catch (Exception e) {
            return null;
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        return bitmap == null ? null : new BitmapDescriptor(bitmap);
    }

    public static BitmapDescriptor fromFile(String str) {
        try {
            InputStream fileInputStream = new FileInputStream(new File(str));
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
            fileInputStream.close();
            return fromBitmap(decodeStream);
        } catch (Exception e) {
            return null;
        }
    }

    public static BitmapDescriptor fromPath(String str) {
        try {
            return fromBitmap(BitmapFactory.decodeFile(str));
        } catch (Exception e) {
            return null;
        }
    }

    public static BitmapDescriptor fromResource(int i) {
        Closeable openRawResource;
        BitmapDescriptor fromBitmap;
        Throwable th;
        Closeable closeable = null;
        try {
            Context a = e.a();
            if (a != null) {
                openRawResource = a.getResources().openRawResource(i);
                try {
                    fromBitmap = fromBitmap(BitmapFactory.decodeStream(openRawResource));
                    a.a(openRawResource);
                } catch (Exception e) {
                    a.a(openRawResource);
                    return fromBitmap;
                } catch (Throwable th2) {
                    th = th2;
                    a.a(openRawResource);
                    throw th;
                }
            }
            a.a(closeable);
        } catch (Exception e2) {
            openRawResource = closeable;
            a.a(openRawResource);
            return fromBitmap;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            openRawResource = closeable;
            th = th4;
            a.a(openRawResource);
            throw th;
        }
        return fromBitmap;
    }

    public static BitmapDescriptor fromView(View view) {
        BitmapDescriptor bitmapDescriptor = null;
        try {
            Context a = e.a();
            if (a != null) {
                View frameLayout = new FrameLayout(a);
                frameLayout.addView(view);
                frameLayout.destroyDrawingCache();
                bitmapDescriptor = fromBitmap(getViewBitmap(frameLayout));
            }
        } catch (Exception e) {
        }
        return bitmapDescriptor;
    }

    private static Bitmap getViewBitmap(View view) {
        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        return view.getDrawingCache().copy(Config.ARGB_8888, false);
    }
}
