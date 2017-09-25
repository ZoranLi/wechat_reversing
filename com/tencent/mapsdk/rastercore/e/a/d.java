package com.tencent.mapsdk.rastercore.e.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.e.b;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class d implements com.tencent.mapsdk.rastercore.e.d {
    private float a = 90.0f;
    private List<LatLng> b = new ArrayList();
    private List<LatLng> c = new ArrayList();
    private e d;
    private a e;
    private boolean f = false;
    private LatLngBounds g = null;
    private boolean h = false;
    private boolean i = true;
    private int j = WebView.NIGHT_MODE_COLOR;
    private float k = 10.0f;
    private float l = 0.0f;
    private BitmapDescriptor m;
    private float n = 0.0f;
    private int o = -983041;
    private String p;

    public d(e eVar, PolylineOptions polylineOptions) {
        this.d = eVar;
        this.e = eVar.e();
        this.p = getId();
        this.j = polylineOptions.getColor();
        this.f = polylineOptions.isDottedLine();
        this.h = polylineOptions.isGeodesic();
        if (this.h || this.f) {
            this.b = polylineOptions.getPoints();
        }
        b(polylineOptions.getPoints());
        this.i = polylineOptions.isVisible();
        this.k = polylineOptions.getWidth();
        this.l = polylineOptions.getZIndex();
        this.m = polylineOptions.getArrowTexture();
        this.n = polylineOptions.getEdgeWidth();
        this.o = polylineOptions.getEdgeColor();
        this.a = polylineOptions.getArrowGap();
    }

    private static int a(byte[] bArr, int i) {
        return (((bArr[i + 0] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16)) | ((bArr[i + 3] & 255) << 24);
    }

    protected static Drawable a(Context context, String str) {
        int i;
        int i2;
        Bitmap createBitmap;
        InputStream open = context.getAssets().open(str);
        Bitmap decodeStream = BitmapFactory.decodeStream(open);
        int width = decodeStream.getWidth();
        int height = decodeStream.getHeight();
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (i = 0; i < 32; i++) {
            byteArrayOutputStream.write(0);
        }
        int[] iArr = new int[(width - 2)];
        decodeStream.getPixels(iArr, 0, width, 1, 0, width - 2, 1);
        Object obj = iArr[0] == WebView.NIGHT_MODE_COLOR ? 1 : null;
        Object obj2 = iArr[iArr.length + -1] == -16777216 ? 1 : null;
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        for (i2 = 0; i2 < length; i2++) {
            if (i3 != iArr[i2]) {
                i4++;
                a(byteArrayOutputStream, i2);
                i3 = iArr[i2];
            }
        }
        if (obj2 != null) {
            i4++;
            a(byteArrayOutputStream, length);
        }
        int i5 = i4;
        i = i5 + 1;
        if (obj != null) {
            i--;
        }
        int i6 = obj2 != null ? i - 1 : i;
        iArr = new int[(height - 2)];
        decodeStream.getPixels(iArr, 0, 1, 0, 1, 1, height - 2);
        obj = iArr[0] == WebView.NIGHT_MODE_COLOR ? 1 : null;
        obj2 = iArr[iArr.length + -1] == -16777216 ? 1 : null;
        length = iArr.length;
        i3 = 0;
        i4 = 0;
        for (i2 = 0; i2 < length; i2++) {
            if (i3 != iArr[i2]) {
                i4++;
                a(byteArrayOutputStream, i2);
                i3 = iArr[i2];
            }
        }
        if (obj2 != null) {
            i4++;
            a(byteArrayOutputStream, length);
        }
        i = i4 + 1;
        if (obj != null) {
            i--;
        }
        if (obj2 != null) {
            i--;
        }
        for (int i7 = 0; i7 < i6 * i; i7++) {
            a(byteArrayOutputStream, 1);
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        toByteArray[0] = (byte) 1;
        toByteArray[1] = (byte) i5;
        toByteArray[2] = (byte) i4;
        toByteArray[3] = (byte) (i * i6);
        a(decodeStream, toByteArray);
        if (NinePatch.isNinePatchChunk(toByteArray)) {
            createBitmap = Bitmap.createBitmap(decodeStream, 1, 1, decodeStream.getWidth() - 2, decodeStream.getHeight() - 2);
            decodeStream.recycle();
            Field declaredField = createBitmap.getClass().getDeclaredField("mNinePatchChunk");
            declaredField.setAccessible(true);
            declaredField.set(createBitmap, toByteArray);
        } else {
            createBitmap = decodeStream;
        }
        open.close();
        if (createBitmap.getNinePatchChunk() == null) {
            return new BitmapDrawable(createBitmap);
        }
        Rect rect = new Rect();
        byte[] ninePatchChunk = createBitmap.getNinePatchChunk();
        rect.left = a(ninePatchChunk, 12);
        rect.right = a(ninePatchChunk, 16);
        rect.top = a(ninePatchChunk, 20);
        rect.bottom = a(ninePatchChunk, 24);
        return new NinePatchDrawable(context.getResources(), createBitmap, createBitmap.getNinePatchChunk(), rect, null);
    }

    private static void a(Bitmap bitmap, byte[] bArr) {
        int i;
        int i2 = 0;
        int[] iArr = new int[(bitmap.getWidth() - 2)];
        bitmap.getPixels(iArr, 0, iArr.length, 1, bitmap.getHeight() - 1, iArr.length, 1);
        for (i = 0; i < iArr.length; i++) {
            if (-16777216 == iArr[i]) {
                a(bArr, 12, i);
                break;
            }
        }
        for (i = iArr.length - 1; i >= 0; i--) {
            if (-16777216 == iArr[i]) {
                a(bArr, 16, (iArr.length - i) - 2);
                break;
            }
        }
        int[] iArr2 = new int[(bitmap.getHeight() - 2)];
        bitmap.getPixels(iArr2, 0, 1, bitmap.getWidth() - 1, 0, 1, iArr2.length);
        while (i2 < iArr2.length) {
            if (-16777216 == iArr2[i2]) {
                a(bArr, 20, i2);
                break;
            }
            i2++;
        }
        for (i = iArr2.length - 1; i >= 0; i--) {
            if (-16777216 == iArr2[i]) {
                a(bArr, 24, (iArr2.length - i) - 2);
                return;
            }
        }
    }

    private void a(Canvas canvas, List<PointF> list) {
        if (list != null && list.size() != 0 && this.m != null && this.m.getBitmap() != null) {
            int width = this.m.getWidth();
            int height = this.m.getHeight();
            double a = (double) (a() / ((float) height));
            double d = (double) ((((float) width) * this.k) / (((float) height) * this.a));
            double d2 = -((((double) width) * a) / 2.0d);
            for (int i = 0; i < list.size() - 1; i++) {
                PointF pointF = (PointF) list.get(i);
                PointF pointF2 = (PointF) list.get(i + 1);
                double sqrt = (pointF == null || pointF2 == null) ? 0.0d : Math.sqrt(Math.pow((double) (pointF.x - pointF2.x), 2.0d) + Math.pow((double) (pointF.y - pointF2.y), 2.0d));
                if (sqrt + d2 < ((double) this.a)) {
                    d2 += sqrt;
                } else {
                    double d3 = sqrt / ((double) this.a);
                    double d4 = (((double) this.a) - d2) / ((double) this.a);
                    sqrt = (Math.acos(((double) (pointF2.x - pointF.x)) / sqrt) * 180.0d) / 3.141592653589793d;
                    if (pointF2.x <= pointF.x && pointF2.y >= pointF.y) {
                        sqrt = (180.0d - sqrt) + 180.0d;
                    } else if (pointF2.x >= pointF.x && pointF2.y >= pointF.y) {
                        sqrt = 360.0d - sqrt;
                    }
                    while (d4 <= d3) {
                        if (i != list.size() - 2 || d4 + d <= d3) {
                            canvas.save();
                            canvas.translate((float) (((double) pointF.x) + ((((double) (pointF2.x - pointF.x)) * d4) / d3)), (float) (((double) pointF.y) + ((((double) (pointF2.y - pointF.y)) * d4) / d3)));
                            canvas.scale((float) a, (float) a);
                            canvas.rotate((float) (-sqrt));
                            canvas.drawBitmap(this.m.getBitmap(), (float) ((-width) / 2), (float) ((-height) / 2), null);
                            canvas.restore();
                            if (1.0d + d4 > d3) {
                                d2 = (d3 - d4) * ((double) this.a);
                            }
                            d4 += 1.0d;
                        } else {
                            return;
                        }
                    }
                    continue;
                }
            }
        }
    }

    private static void a(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    private static void a(List<LatLng> list, List<LatLng> list2, double d) {
        if (list.size() == 3) {
            for (int i = 0; i <= 10; i = (int) (((float) i) + 1.0f)) {
                float f = ((float) i) / 10.0f;
                double longitude = ((((1.0d - ((double) f)) * (1.0d - ((double) f))) * ((LatLng) list.get(0)).getLongitude()) + (((((double) (2.0f * f)) * (1.0d - ((double) f))) * ((LatLng) list.get(1)).getLongitude()) * d)) + (((double) (f * f)) * ((LatLng) list.get(2)).getLongitude());
                double d2 = (((1.0d - ((double) f)) * (1.0d - ((double) f))) + ((((double) (2.0f * f)) * (1.0d - ((double) f))) * d)) + ((double) (f * f));
                List<LatLng> list3 = list2;
                list3.add(new LatLng((((((1.0d - ((double) f)) * (1.0d - ((double) f))) * ((LatLng) list.get(0)).getLatitude()) + (((((double) (2.0f * f)) * (1.0d - ((double) f))) * ((LatLng) list.get(1)).getLatitude()) * d)) + (((double) (f * f)) * ((LatLng) list.get(2)).getLatitude())) / (((double) (f * f)) + (((1.0d - ((double) f)) * (1.0d - ((double) f))) + ((((double) (2.0f * f)) * (1.0d - ((double) f))) * d))), longitude / d2));
            }
        }
    }

    private static void a(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 >> 0);
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    private void b(List<LatLng> list) {
        if (list != null && list.size() != 0) {
            Builder builder = LatLngBounds.builder();
            this.c.clear();
            if (list != null) {
                LatLng latLng = null;
                for (LatLng latLng2 : list) {
                    if (!(latLng2 == null || latLng2.equals(latLng))) {
                        if (!this.h) {
                            this.c.add(latLng2);
                            builder.include(latLng2);
                        } else if (latLng != null) {
                            if (Math.abs(latLng2.getLongitude() - latLng.getLongitude()) < 0.01d) {
                                this.c.add(latLng);
                                builder.include(latLng);
                                this.c.add(latLng2);
                                builder.include(latLng2);
                            } else {
                                List list2 = this.c;
                                double abs = (Math.abs(latLng.getLongitude() - latLng2.getLongitude()) * 3.141592653589793d) / 180.0d;
                                LatLng latLng3 = new LatLng((latLng2.getLatitude() + latLng.getLatitude()) / 2.0d, (latLng2.getLongitude() + latLng.getLongitude()) / 2.0d);
                                builder.include(latLng).include(latLng3).include(latLng2);
                                int i = latLng3.getLatitude() > 0.0d ? 1 : -1;
                                double cos = Math.cos(0.5d * abs);
                                double longitude = latLng2.getLongitude() - latLng.getLongitude();
                                double latitude = latLng2.getLatitude() - latLng.getLatitude();
                                abs = (double) ((int) ((((Math.tan(abs * 0.5d) * (Math.hypot(latLng.getLongitude() - latLng2.getLongitude(), latLng.getLatitude() - latLng2.getLatitude()) * 0.5d)) * ((double) i)) / Math.sqrt(((latitude * latitude) / (longitude * longitude)) + 1.0d)) + latLng3.getLatitude()));
                                LatLng latLng4 = new LatLng(abs, (double) ((int) (latLng3.getLongitude() + ((latitude * (latLng3.getLatitude() - abs)) / longitude))));
                                List arrayList = new ArrayList();
                                arrayList.add(latLng);
                                arrayList.add(latLng4);
                                arrayList.add(latLng2);
                                a(arrayList, list2, cos);
                            }
                        }
                        latLng = latLng2;
                    }
                }
            }
            this.g = builder.build();
        }
    }

    public float a() {
        return this.k;
    }

    public void a(float f) {
        this.k = f;
        this.d.a(false, false);
    }

    public void a(int i) {
        this.j = i;
        this.d.a(false, false);
    }

    public void a(List<LatLng> list) {
        if (this.h || this.f) {
            this.b = list;
        }
        b((List) list);
        this.d.a(false, false);
    }

    public void a(boolean z) {
        this.f = z;
        this.d.a(false, false);
    }

    public int b() {
        return this.j;
    }

    public void b(boolean z) {
        this.h = z;
        this.d.a(false, false);
    }

    public List<LatLng> c() {
        return (this.h || this.f) ? this.b : this.c;
    }

    public boolean checkInBounds() {
        if (this.g == null) {
            return false;
        }
        LatLngBounds c = this.d.b().c();
        return c == null ? true : c.contains(this.g) || this.g.intersects(c);
    }

    public boolean d() {
        return this.f;
    }

    public void destroy() {
    }

    public void draw(Canvas canvas) {
        List arrayList = new ArrayList();
        if (this.c != null && this.c.size() != 0 && this.k > 0.0f) {
            int i;
            Path path = new Path();
            PointF a = this.d.b().a((LatLng) this.c.get(0));
            arrayList.add(a);
            path.moveTo(a.x, a.y);
            for (i = 1; i < this.c.size(); i++) {
                a = this.d.b().a((LatLng) this.c.get(i));
                arrayList.add(a);
                path.lineTo(a.x, a.y);
            }
            Paint paint = new Paint();
            paint.setStyle(Style.STROKE);
            if (this.f) {
                i = (int) a();
                paint.setPathEffect(new DashPathEffect(new float[]{(float) (i * 3), (float) i, (float) (i * 3), (float) i}, 1.0f));
            } else {
                paint.setStrokeJoin(Join.ROUND);
                paint.setStrokeCap(Cap.ROUND);
            }
            paint.setAntiAlias(true);
            if (this.n > 0.0f) {
                paint.setColor(this.o);
                paint.setStrokeWidth(a() + (2.0f * this.n));
                canvas.drawPath(path, paint);
            }
            paint.setColor(b());
            paint.setStrokeWidth(a());
            canvas.drawPath(path, paint);
            if (this.m != null) {
                a(canvas, arrayList);
            }
            arrayList.clear();
        }
    }

    public boolean e() {
        return this.h;
    }

    public boolean equalsRemote(b bVar) {
        return equals(bVar) || bVar.getId().equals(getId());
    }

    public String getId() {
        if (this.p == null) {
            this.p = a.a("Polyline");
        }
        return this.p;
    }

    public float getZIndex() {
        return this.l;
    }

    public int hashCodeRemote() {
        return super.hashCode();
    }

    public boolean isVisible() {
        return this.i;
    }

    public void remove() {
        this.e.b(getId());
    }

    public void setVisible(boolean z) {
        this.i = z;
        this.e.c();
        this.d.a(false, false);
    }

    public void setZIndex(float f) {
        this.l = f;
        this.e.c();
        this.d.a(false, false);
    }
}
