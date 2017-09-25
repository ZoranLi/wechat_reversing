package com.tencent.mm.plugin.music.a.d;

import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public final class b implements IMediaHTTPService {
    public final IMediaHTTPConnection makeHTTPConnection() {
        Logger.i("MicroMsg.MMMediaHTTPService", "makeHTTPConnection");
        return new a();
    }
}
