package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.mapsdk.raster.model.BitmapDescriptorFactory;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.GroundOverlay;
import com.tencent.mapsdk.raster.model.GroundOverlayOptions;
import com.tencent.mapsdk.raster.model.IOverlay;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.rastercore.c;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.mapsdk.rastercore.e.b;
import com.tencent.mm.plugin.gif.MMGIFException;

public class MapView extends FrameLayout {
    @Deprecated
    private d controller;
    private f eventHandler;
    private e mapContext;
    private f projection;
    private g tencentMap;
    private h uiSettings;

    public static class a extends LayoutParams {
        private int alignment;
        public int mode;
        public LatLng point;
        private int x;
        private int y;

        public a(int i, int i2, GeoPoint geoPoint, int i3) {
            this(i, i2, geoPoint, i3, (byte) 0);
        }

        private a(int i, int i2, GeoPoint geoPoint, int i3, byte b) {
            this(i, i2, com.tencent.mapsdk.rastercore.f.a.a(geoPoint), 0, 0, i3);
        }

        public a(int i, int i2, LatLng latLng, int i3, int i4, int i5) {
            super(i, i2);
            this.mode = 1;
            this.alignment = 51;
            this.point = null;
            this.x = 0;
            this.y = 0;
            this.mode = 0;
            this.point = latLng;
            this.x = i3;
            this.y = i4;
            this.alignment = i5;
        }

        protected a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mode = 1;
            this.alignment = 51;
            this.point = null;
            this.x = 0;
            this.y = 0;
        }
    }

    public MapView(Context context) {
        super(context);
        init();
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void doLayout(View view, int i, int i2, float f, float f2, int i3) {
        int i4 = i3 & 7;
        int i5 = i3 & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        if (i4 == 5) {
            f -= (float) i;
        } else if (i4 == 1) {
            f -= (float) (i / 2);
        }
        if (i5 == 80) {
            f2 -= (float) i2;
        } else if (i5 == 16) {
            f2 -= (float) (i2 / 2);
        }
        i4 = Math.round(f);
        i5 = Math.round(f2);
        view.layout(i4, i5, i4 + i, i5 + i2);
    }

    private void doMeasure(View view, int i, int i2, int[] iArr) {
        if (view instanceof ListView) {
            View view2 = (View) view.getParent();
            if (view2 != null) {
                iArr[0] = view2.getWidth();
                iArr[1] = view2.getHeight();
            }
        }
        if (i <= 0 || i2 <= 0) {
            view.measure(0, 0);
        }
        if (i == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i;
        }
        if (i2 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i2 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i2;
        }
    }

    private void init() {
        initForBugly();
        Context context = getContext();
        this.mapContext = new e(this);
        this.eventHandler = this.mapContext.h();
        setOnKeyListener(this.eventHandler);
        this.projection = new f(this.mapContext);
        this.uiSettings = new h(this.mapContext.f());
        this.tencentMap = new g(this.mapContext);
        this.controller = new d(this);
        if (context instanceof MapActivity) {
            ((MapActivity) context).setMapView(this);
        }
        setBackgroundColor(-657936);
    }

    private void initForBugly() {
        Editor edit = getContext().getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
        edit.putString("4e7cb4aa49", "1.2.6");
        edit.commit();
    }

    private void layout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                layout(childAt);
            }
        }
    }

    private void layoutMap(View view, a aVar) {
        int[] iArr = new int[2];
        doMeasure(view, aVar.width, aVar.height, iArr);
        if (aVar.point != null) {
            PointF a = this.mapContext.b().a(aVar.point);
            if (a != null) {
                a.x += (float) aVar.x;
                a.y += (float) aVar.y;
                doLayout(view, iArr[0], iArr[1], a.x, a.y, aVar.alignment);
            }
        }
    }

    private void layoutView(View view, a aVar) {
        int[] iArr = new int[2];
        doMeasure(view, aVar.width, aVar.height, iArr);
        doLayout(view, iArr[0], iArr[1], (float) aVar.x, (float) aVar.y, aVar.alignment);
    }

    protected static void setIsChinese(boolean z) {
        c.a(z);
    }

    public Circle addCircle(CircleOptions circleOptions) {
        return new Circle(this.tencentMap.xbl.a(circleOptions));
    }

    public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        return this.tencentMap.addGroundOverlay(groundOverlayOptions);
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        return new Marker(this.tencentMap.xbl.a(markerOptions));
    }

    public GroundOverlay addOverlay(Bitmap bitmap, LatLng latLng, LatLng latLng2) {
        return this.tencentMap.addGroundOverlay(new GroundOverlayOptions().positionFromBounds(new LatLngBounds(latLng, latLng2)).anchor(0.5f, 0.5f).transparency(0.1f).image(BitmapDescriptorFactory.fromBitmap(bitmap)));
    }

    public final boolean addOverlay(e eVar) {
        if (eVar == null) {
            return false;
        }
        eVar.a(this);
        this.mapContext.e().a((b) eVar);
        return true;
    }

    public Polygon addPolygon(PolygonOptions polygonOptions) {
        return new Polygon(this.tencentMap.xbl.a(polygonOptions));
    }

    public Polyline addPolyline(PolylineOptions polylineOptions) {
        return new Polyline(this.tencentMap.xbl.a(polylineOptions));
    }

    public final void clearAllOverlays() {
        g gVar = this.tencentMap;
        gVar.xbl.a();
        gVar.mapContext.a(false, false);
    }

    public void computeScroll() {
        super.computeScroll();
        this.eventHandler.a();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        setClickable(false);
        this.eventHandler.b(MotionEvent.obtain(motionEvent));
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent) || this.eventHandler.a(motionEvent);
    }

    public d getController() {
        return this.controller;
    }

    public int getLatitudeSpan() {
        LatLngBounds latLngBounds = this.projection.cgd().getLatLngBounds();
        return (int) ((latLngBounds.getNortheast().getLatitude() * 1000000.0d) - (latLngBounds.getSouthwest().getLatitude() * 1000000.0d));
    }

    public int getLongitudeSpan() {
        LatLngBounds latLngBounds = this.projection.cgd().getLatLngBounds();
        return (int) ((latLngBounds.getNortheast().getLongitude() * 1000000.0d) - (latLngBounds.getSouthwest().getLongitude() * 1000000.0d));
    }

    public g getMap() {
        return this.tencentMap;
    }

    public LatLng getMapCenter() {
        return this.tencentMap.getMapCenter();
    }

    protected e getMapContext() {
        return this.mapContext;
    }

    public d getMapController() {
        return this.controller;
    }

    public int getMaxZoomLevel() {
        return this.tencentMap.xbo.i().a();
    }

    public int getMinZoomLevel() {
        return this.tencentMap.xbo.j().a();
    }

    public f getProjection() {
        return this.projection;
    }

    public float getScalePerPixel() {
        return this.projection.xbo.f();
    }

    public h getUiSettings() {
        return this.uiSettings;
    }

    public final String getVersion() {
        return "1.2.8.29dc259";
    }

    public int getZoomLevel() {
        return this.tencentMap.getZoomLevel();
    }

    public final boolean isAppKeyAvailable() {
        return e.q();
    }

    public boolean isSatellite() {
        return this.tencentMap.mapContext.l() == 2;
    }

    public void layout() {
        layout(false, 0, 0, 0, 0);
    }

    public void layout(View view) {
        if (this != view.getParent()) {
            return;
        }
        if (view.getLayoutParams() instanceof a) {
            a aVar = (a) view.getLayoutParams();
            if (aVar.mode == 0) {
                layoutMap(view, aVar);
                return;
            } else {
                layoutView(view, aVar);
                return;
            }
        }
        layoutView(view, new a(view.getLayoutParams()));
    }

    public void moveCamera(a aVar) {
        g gVar = this.tencentMap;
        if (aVar != null) {
            com.tencent.mapsdk.rastercore.c.a aVar2 = aVar.xbi;
            if (aVar2 != null) {
                aVar2.a(false);
                gVar.mapContext.c().a(aVar2);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        this.mapContext.a(bundle);
    }

    public void onDestroy() {
        this.mapContext.m();
    }

    public void onDestroyView() {
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        layout(z, i, i2, i3, i4);
    }

    public void onLowMemory() {
    }

    public void onPause() {
        e.n();
    }

    public void onRestart() {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.mapContext.b(bundle);
    }

    public void onStop() {
    }

    public void refreshMap() {
        postInvalidate();
    }

    public final void removeOverlay(IOverlay iOverlay) {
        if (iOverlay != null) {
            iOverlay.remove();
        }
    }

    protected void setLocation(double d, double d2) {
        c.b(d, d2);
    }

    public void setLogoPosition(int i) {
        this.uiSettings.xbq.b(i);
    }

    public void setPinchEnabeled(boolean z) {
        this.uiSettings.xbq.c(z);
    }

    public void setSatellite(boolean z) {
        g gVar = this.tencentMap;
        if (z) {
            gVar.mapContext.a(2);
        } else {
            gVar.mapContext.a(1);
        }
    }

    public void setScalControlsEnable(boolean z) {
        this.uiSettings.mi(z);
    }

    public void setScaleControlsEnable(boolean z) {
        this.uiSettings.mi(z);
    }

    public void setScaleViewPosition(int i) {
        this.uiSettings.xbq.c(i);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.uiSettings.xbq.b(z);
    }

    public void stopAnimation() {
        clearAnimation();
        this.mapContext.c().clearAnimation();
        this.eventHandler.b();
    }
}
