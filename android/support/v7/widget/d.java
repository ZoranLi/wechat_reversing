package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

class d extends DataSetObservable {
    private static final String DU = d.class.getSimpleName();
    private static final Object Tp = new Object();
    private static final Map<String, d> Tq = new HashMap();
    private Intent PC;
    private boolean TA;
    private d TB;
    final Object Tr;
    final List<a> Ts;
    private final List<c> Tt;
    private final String Tu;
    private b Tv;
    private int Tw;
    private boolean Tx;
    private boolean Ty;
    private boolean Tz;
    private final Context mContext;

    public final class a implements Comparable<a> {
        final /* synthetic */ d TC;
        public final ResolveInfo resolveInfo;
        public float weight;

        public final /* synthetic */ int compareTo(Object obj) {
            return Float.floatToIntBits(((a) obj).weight) - Float.floatToIntBits(this.weight);
        }

        public a(d dVar, ResolveInfo resolveInfo) {
            this.TC = dVar;
            this.resolveInfo = resolveInfo;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(((a) obj).weight)) {
                return false;
            }
            return true;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:").append(this.resolveInfo.toString());
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.weight));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface b {
    }

    public static final class c {
        public final ComponentName TD;
        public final long time;
        public final float weight;

        public c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public c(ComponentName componentName, long j, float f) {
            this.TD = componentName;
            this.time = j;
            this.weight = f;
        }

        public final int hashCode() {
            return (((((this.TD == null ? 0 : this.TD.hashCode()) + 31) * 31) + ((int) (this.time ^ (this.time >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.TD == null) {
                if (cVar.TD != null) {
                    return false;
                }
            } else if (!this.TD.equals(cVar.TD)) {
                return false;
            }
            if (this.time != cVar.time) {
                return false;
            }
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(cVar.weight)) {
                return false;
            }
            return true;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:").append(this.TD);
            stringBuilder.append("; time:").append(this.time);
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.weight));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface d {
        boolean em();
    }

    private final class e extends AsyncTask<Object, Void, Void> {
        final /* synthetic */ d TC;

        private e(d dVar) {
            this.TC = dVar;
        }

        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return b(objArr);
        }

        private Void b(Object... objArr) {
            int i = 0;
            List list = (List) objArr[0];
            try {
                OutputStream openFileOutput = this.TC.mContext.openFileOutput((String) objArr[1], 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                    newSerializer.startTag(null, "historical-records");
                    int size = list.size();
                    while (i < size) {
                        c cVar = (c) list.remove(0);
                        newSerializer.startTag(null, "historical-record");
                        newSerializer.attribute(null, "activity", cVar.TD.flattenToString());
                        newSerializer.attribute(null, "time", String.valueOf(cVar.time));
                        newSerializer.attribute(null, "weight", String.valueOf(cVar.weight));
                        newSerializer.endTag(null, "historical-record");
                        i++;
                    }
                    newSerializer.endTag(null, "historical-records");
                    newSerializer.endDocument();
                    this.TC.Tx = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (IllegalArgumentException e2) {
                    d.DU;
                    new StringBuilder("Error writing historical recrod file: ").append(this.TC.Tu);
                    this.TC.Tx = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (IllegalStateException e4) {
                    d.DU;
                    new StringBuilder("Error writing historical recrod file: ").append(this.TC.Tu);
                    this.TC.Tx = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (IOException e6) {
                    d.DU;
                    new StringBuilder("Error writing historical recrod file: ").append(this.TC.Tu);
                    this.TC.Tx = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e7) {
                        }
                    }
                } catch (Throwable th) {
                    this.TC.Tx = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e8) {
                        }
                    }
                }
            } catch (FileNotFoundException e9) {
                d.DU;
            }
            return null;
        }
    }

    public final int ef() {
        int size;
        synchronized (this.Tr) {
            eh();
            size = this.Ts.size();
        }
        return size;
    }

    public final ResolveInfo aC(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.Tr) {
            eh();
            resolveInfo = ((a) this.Ts.get(i)).resolveInfo;
        }
        return resolveInfo;
    }

    public final int a(ResolveInfo resolveInfo) {
        synchronized (this.Tr) {
            eh();
            List list = this.Ts;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((a) list.get(i)).resolveInfo == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public final Intent aD(int i) {
        synchronized (this.Tr) {
            if (this.PC == null) {
                return null;
            }
            eh();
            a aVar = (a) this.Ts.get(i);
            ComponentName componentName = new ComponentName(aVar.resolveInfo.activityInfo.packageName, aVar.resolveInfo.activityInfo.name);
            Intent intent = new Intent(this.PC);
            intent.setComponent(componentName);
            if (this.TB != null) {
                Intent intent2 = new Intent(intent);
                if (this.TB.em()) {
                    return null;
                }
            }
            a(new c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public final ResolveInfo eg() {
        synchronized (this.Tr) {
            eh();
            if (this.Ts.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((a) this.Ts.get(0)).resolveInfo;
            return resolveInfo;
        }
    }

    public final int getHistorySize() {
        int size;
        synchronized (this.Tr) {
            eh();
            size = this.Tt.size();
        }
        return size;
    }

    final void eh() {
        int i;
        int i2 = 1;
        if (!this.TA || this.PC == null) {
            i = 0;
        } else {
            this.TA = false;
            this.Ts.clear();
            List queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.PC, 0);
            int size = queryIntentActivities.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.Ts.add(new a(this, (ResolveInfo) queryIntentActivities.get(i3)));
            }
            i = 1;
        }
        if (this.Tx && this.Tz && !TextUtils.isEmpty(this.Tu)) {
            this.Tx = false;
            this.Ty = true;
            ek();
        } else {
            i2 = 0;
        }
        i |= i2;
        ej();
        if (i != 0) {
            ei();
            notifyChanged();
        }
    }

    private boolean ei() {
        if (this.Tv == null || this.PC == null || this.Ts.isEmpty() || this.Tt.isEmpty()) {
            return false;
        }
        Collections.unmodifiableList(this.Tt);
        return true;
    }

    final boolean a(c cVar) {
        boolean add = this.Tt.add(cVar);
        if (add) {
            this.Tz = true;
            ej();
            if (this.Ty) {
                if (this.Tz) {
                    this.Tz = false;
                    if (!TextUtils.isEmpty(this.Tu)) {
                        AsyncTask eVar = new e();
                        Object[] objArr = new Object[]{new ArrayList(this.Tt), this.Tu};
                        if (VERSION.SDK_INT >= 11) {
                            eVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, objArr);
                        } else {
                            eVar.execute(objArr);
                        }
                    }
                }
                ei();
                notifyChanged();
            } else {
                throw new IllegalStateException("No preceding call to #readHistoricalData");
            }
        }
        return add;
    }

    private void ej() {
        int size = this.Tt.size() - this.Tw;
        if (size > 0) {
            this.Tz = true;
            for (int i = 0; i < size; i++) {
                this.Tt.remove(0);
            }
        }
    }

    private void ek() {
        try {
            InputStream openFileInput = this.mContext.openFileInput(this.Tu);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.Tt;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            break;
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    }
                    return;
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (XmlPullParserException e2) {
                new StringBuilder("Error reading historical recrod file: ").append(this.Tu);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IOException e4) {
                new StringBuilder("Error reading historical recrod file: ").append(this.Tu);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e6) {
                    }
                }
            }
        } catch (FileNotFoundException e7) {
        }
    }
}
