package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;

public interface Channel extends Parcelable {
    e<Status> a(c cVar, Uri uri);

    String getPath();

    String mB();
}
