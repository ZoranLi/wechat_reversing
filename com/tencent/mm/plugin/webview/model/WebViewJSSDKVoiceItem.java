package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelvoice.q;

public class WebViewJSSDKVoiceItem extends WebViewJSSDKFileItem {
    public static final Creator<WebViewJSSDKVoiceItem> CREATOR = new Creator<WebViewJSSDKVoiceItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WebViewJSSDKVoiceItem(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WebViewJSSDKVoiceItem[i];
        }
    };

    public WebViewJSSDKVoiceItem() {
        this.fIL = 2;
    }

    public final WebViewJSSDKFileItem bwm() {
        this.iDA = q.js(this.fyF);
        this.fJz = ah.IV(this.iDA);
        return this;
    }

    public final String bwn() {
        return "speex";
    }

    public final String bwo() {
        return "voice";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    protected WebViewJSSDKVoiceItem(Parcel parcel) {
        super(parcel);
    }
}
