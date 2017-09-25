package com.tencent.tmassistantsdk.util;

import android.text.TextUtils;

public final class QUABuilder {
    public String mAdrRelease;
    public String mBuildNo;
    public String mChannel;
    public String mChannelId;
    public int mDeviceHeight;
    public int mDeviceWidth;
    public int mRootStatus;
    public String mUA;
    public String mVersionName;

    public final String get() {
        String appSpec = getAppSpec();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TMASDK_");
        stringBuffer.append(this.mVersionName);
        if (!TextUtils.isEmpty(this.mChannel)) {
            stringBuffer.append("_");
            stringBuffer.append(this.mChannel);
        }
        stringBuffer.append("/");
        stringBuffer.append(appSpec);
        stringBuffer.append("&NA/");
        stringBuffer.append(appSpec);
        stringBuffer.append("&");
        stringBuffer.append(this.mAdrRelease);
        stringBuffer.append("_");
        stringBuffer.append(this.mRootStatus);
        stringBuffer.append("&");
        stringBuffer.append(this.mDeviceWidth / 16);
        stringBuffer.append("_");
        stringBuffer.append(this.mDeviceHeight / 16);
        stringBuffer.append("_");
        stringBuffer.append("14&");
        stringBuffer.append(this.mUA);
        stringBuffer.append("&");
        stringBuffer.append(this.mChannelId);
        stringBuffer.append("&");
        stringBuffer.append("NA");
        stringBuffer.append("&");
        stringBuffer.append("V3");
        return stringBuffer.toString();
    }

    private String getAppSpec() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("0");
        stringBuffer.append(this.mVersionName.subSequence(0, 1));
        stringBuffer.append(this.mBuildNo);
        return stringBuffer.toString();
    }
}
