package com.tencent.qqmusic.mediaplayer.network;

import com.tencent.qqmusic.mediaplayer.util.Logger;

public class DefaultMediaHTTPService implements IMediaHTTPService {
    private static final String TAG = "DefaultMediaHTTPService";

    public IMediaHTTPConnection makeHTTPConnection() {
        Logger.d(TAG, "makeHTTPConnection");
        return new DefaultMediaHTTPConnection();
    }
}
