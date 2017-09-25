package com.tencent.mm.plugin.location.model;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public final class i {
    private SensorManager aJs = ((SensorManager) ab.getContext().getSystemService("sensor"));
    private com.tencent.mm.modelgeo.a.a gKp = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ i nbo;

        {
            this.nbo = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return false;
            }
            if (!(this.nbo.nbk == -1000.0d || this.nbo.nbl == -1000.0d)) {
                this.nbo.nbn = f.a(this.nbo.nbl, this.nbo.nbk, (double) f, (double) f2, i, d);
            }
            this.nbo.nbk = (double) f2;
            this.nbo.nbl = (double) f;
            if (this.nbo.nbj == 900.0d || this.nbo.nbi == 900.0d) {
                i iVar = this.nbo;
                i iVar2 = this.nbo;
                double g = f.g((double) f2, (double) f);
                iVar2.nbi = g;
                iVar.nbj = g;
            } else {
                this.nbo.nbj = this.nbo.nbi;
                this.nbo.nbi = f.g((double) f2, (double) f);
            }
            w.d("MicroMsg.OrientationSensorMgr", "onGetLocation, update headding, mCurrentHeading = %f, mPreviousHeading = %f mIsMove = %b", new Object[]{Double.valueOf(this.nbo.nbi), Double.valueOf(this.nbo.nbj), Boolean.valueOf(this.nbo.nbn)});
            return true;
        }
    };
    private c hvP;
    HashSet<WeakReference<a>> iSM = new HashSet();
    private b nbh = new b(this);
    public double nbi = 900.0d;
    public double nbj = 900.0d;
    public double nbk = -1000.0d;
    public double nbl = -1000.0d;
    double nbm = 0.0d;
    public boolean nbn = false;

    public interface a {
        void h(double d);
    }

    protected class b implements SensorEventListener {
        private float iTm = 0.0f;
        final /* synthetic */ i nbo;
        private long timestamp = 200;

        protected b(i iVar) {
            this.nbo = iVar;
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            int i = 0;
            if (sensorEvent.sensor.getType() == 3) {
                long currentTimeMillis = System.currentTimeMillis() - this.timestamp;
                float aq = m.aq(sensorEvent.values[0]);
                if (currentTimeMillis > 200 && Math.abs(aq - this.iTm) > 3.0f) {
                    i iVar = this.nbo;
                    float f = this.iTm;
                    iVar.nbm = (double) aq;
                    String str = "MicroMsg.OrientationSensorMgr";
                    String str2 = "onOrientationChanged %f %f, mListenerList.size = %d";
                    Object[] objArr = new Object[3];
                    objArr[0] = Float.valueOf(f);
                    objArr[1] = Float.valueOf(aq);
                    if (iVar.iSM != null) {
                        i = iVar.iSM.size();
                    }
                    objArr[2] = Integer.valueOf(i);
                    w.d(str, str2, objArr);
                    if (iVar.iSM != null) {
                        Iterator it = iVar.iSM.iterator();
                        while (it.hasNext()) {
                            WeakReference weakReference = (WeakReference) it.next();
                            if (!(weakReference == null || weakReference.get() == null)) {
                                ((a) weakReference.get()).h(iVar.aFX());
                            }
                        }
                    }
                    this.iTm = aq;
                    this.timestamp = System.currentTimeMillis();
                }
            }
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    public final double aFX() {
        if (this.nbn) {
            w.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = true, result = %f", new Object[]{Double.valueOf(this.nbi)});
            return this.nbi;
        }
        w.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = false, result = %f", new Object[]{Double.valueOf(this.nbm)});
        return this.nbm;
    }

    private void aFY() {
        w.i("MicroMsg.OrientationSensorMgr", "registerSensor ");
        if (this.hvP == null) {
            this.hvP = c.Gk();
        }
        this.hvP.b(this.gKp, true);
        this.aJs.registerListener(this.nbh, this.aJs.getDefaultSensor(3), 1);
    }

    final void aFZ() {
        w.i("MicroMsg.OrientationSensorMgr", "unregisterSensor ");
        this.aJs.unregisterListener(this.nbh);
        c.Gk().c(this.gKp);
    }

    public final void a(a aVar) {
        Iterator it = this.iSM.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                return;
            }
        }
        this.iSM.add(new WeakReference(aVar));
        w.i("MicroMsg.OrientationSensorMgr", "registerSensorListener %d", new Object[]{Integer.valueOf(this.iSM.size())});
        if (this.iSM.size() == 1) {
            aFY();
        }
    }

    public final void b(a aVar) {
        if (this.iSM != null && aVar != null) {
            Iterator it = this.iSM.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                    this.iSM.remove(weakReference);
                    break;
                }
            }
            w.i("MicroMsg.OrientationSensorMgr", "unregisterSensorListener %d", new Object[]{Integer.valueOf(this.iSM.size())});
            if (this.iSM.size() == 0) {
                aFZ();
            }
        }
    }
}
