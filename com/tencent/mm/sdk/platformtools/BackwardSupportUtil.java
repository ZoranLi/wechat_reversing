package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ListView;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.io.InputStream;

public final class BackwardSupportUtil {

    public static class ExifHelper {

        public static class LatLongData implements Parcelable {
            public static final Creator<LatLongData> CREATOR = new Creator<LatLongData>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    LatLongData latLongData = new LatLongData();
                    latLongData.fOb = parcel.readFloat();
                    latLongData.hGU = parcel.readFloat();
                    return latLongData;
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new LatLongData[i];
                }
            };
            public float fOb;
            public float hGU;

            public LatLongData() {
                this.fOb = 0.0f;
                this.hGU = 0.0f;
            }

            public LatLongData(float f, float f2) {
                this.fOb = f;
                this.hGU = f2;
            }

            public int hashCode() {
                return ((int) (this.fOb * 10000.0f)) + ((int) (this.hGU * 10000.0f));
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof LatLongData)) {
                    return false;
                }
                LatLongData latLongData = (LatLongData) obj;
                if (Math.abs(this.fOb - latLongData.fOb) >= 1.0E-6f || Math.abs(this.hGU - latLongData.hGU) >= 1.0E-6f) {
                    return false;
                }
                return true;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeFloat(this.fOb);
                parcel.writeFloat(this.hGU);
            }
        }

        public static int Pc(String str) {
            if (bg.mA(str)) {
                w.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
                return 0;
            } else if (FileOp.aO(str)) {
                return Exif.fromFile(str).getOrientationInDegree();
            } else {
                w.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", str);
                return 0;
            }
        }

        public static LatLongData Pd(String str) {
            if (bg.mA(str)) {
                w.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
                return null;
            } else if (FileOp.aO(str)) {
                com.tencent.mm.compatible.util.Exif.a location = Exif.fromFile(str).getLocation();
                if (location == null) {
                    return null;
                }
                LatLongData latLongData = new LatLongData();
                latLongData.fOb = (float) location.latitude;
                latLongData.hGU = (float) location.longitude;
                return latLongData;
            } else {
                w.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", str);
                return null;
            }
        }
    }

    public static class a {
        public static void c(View view, Animation animation) {
            if (VERSION.SDK_INT >= 8) {
                c cVar = new c();
                animation.cancel();
                return;
            }
            b bVar = new b();
            if (view != null) {
                view.setAnimation(null);
            }
        }
    }

    public static class b {
        public static Bitmap c(String str, float f) {
            float f2 = 160.0f * f;
            Bitmap d = d.d(str, f);
            if (d != null) {
                d.setDensity((int) f2);
            }
            return d;
        }

        public static int a(Context context, float f) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return Math.round((((float) displayMetrics.densityDpi) * f) / 160.0f);
        }

        public static Bitmap a(InputStream inputStream, float f) {
            float f2 = 160.0f * f;
            Bitmap a = d.a(inputStream, f, 0, 0);
            if (a != null) {
                a.setDensity((int) f2);
            }
            return a;
        }

        public static String dV(Context context) {
            String str;
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            Configuration configuration = context.getResources().getConfiguration();
            String str2 = "";
            if (displayMetrics.density < 1.0f) {
                str = str2 + "LDPI";
            } else if (displayMetrics.density >= DownloadHelper.SAVE_FATOR) {
                str = str2 + "HDPI";
            } else {
                str = str2 + "MDPI";
            }
            return str + (configuration.orientation == 2 ? "_L" : "_P");
        }
    }

    public static class c {
        public static void a(ListView listView) {
            if (listView != null) {
                if (VERSION.SDK_INT >= 8) {
                    ba baVar = new ba();
                    if (listView.getFirstVisiblePosition() > 10) {
                        listView.setSelection(10);
                    }
                    if (VERSION.SDK_INT >= 8) {
                        listView.smoothScrollToPosition(0);
                        return;
                    }
                    return;
                }
                az azVar = new az();
                listView.setSelection(0);
            }
        }

        public static void b(ListView listView, int i) {
            if (listView != null) {
                if (VERSION.SDK_INT >= 8) {
                    ba baVar = new ba();
                    int firstVisiblePosition = listView.getFirstVisiblePosition();
                    if (firstVisiblePosition > i && firstVisiblePosition - i > 10) {
                        listView.setSelection(i + 10);
                    } else if (firstVisiblePosition < i && i - firstVisiblePosition > 10) {
                        listView.setSelection(i - 10);
                    }
                    if (VERSION.SDK_INT >= 8) {
                        listView.smoothScrollToPosition(i);
                        return;
                    }
                    return;
                }
                az azVar = new az();
                listView.setSelection(i);
            }
        }
    }
}
