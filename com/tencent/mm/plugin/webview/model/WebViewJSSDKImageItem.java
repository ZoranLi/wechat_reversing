package com.tencent.mm.plugin.webview.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

public class WebViewJSSDKImageItem extends WebViewJSSDKFileItem implements Parcelable {
    public static final Creator<WebViewJSSDKImageItem> CREATOR = new Creator<WebViewJSSDKImageItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WebViewJSSDKImageItem(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WebViewJSSDKImageItem[i];
        }
    };

    public WebViewJSSDKImageItem() {
        this.fIL = 1;
    }

    public final void bwq() {
        if (new File(this.iDA).exists()) {
            this.rWW = ah.IT(System.currentTimeMillis());
            Bitmap a = d.a(this.iDA, 640, 640, false, null, 0);
            if (a != null) {
                w.i("MicroMsg.WebViewJSSDkImageItem", "extract thumbnail bitmap");
                a = d.b(a, (float) ExifHelper.Pc(this.iDA));
                if (a != null) {
                    try {
                        d.a(a, 100, CompressFormat.JPEG, this.rWW, true);
                    } catch (Exception e) {
                        w.e("MicroMsg.WebViewJSSDkImageItem", "save bitmap to file failed : %s", new Object[]{e.getMessage()});
                    }
                }
            }
            w.i("MicroMsg.WebViewJSSDkImageItem", "Thumb Path: %s", new Object[]{this.rWW});
            return;
        }
        w.i("MicroMsg.WebViewJSSDkImageItem", "Original file not existed");
    }

    public final WebViewJSSDKFileItem bwm() {
        this.fJz = ah.IV(this.iDA);
        bwq();
        return this;
    }

    public final String bwn() {
        return "jpeg";
    }

    public final String bwo() {
        return SlookAirButtonRecentMediaAdapter.IMAGE_TYPE;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    protected WebViewJSSDKImageItem(Parcel parcel) {
        super(parcel);
    }
}
