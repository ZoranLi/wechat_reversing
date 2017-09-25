package com.tencent.mm.plugin.downloader.model;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;

final class j extends i {
    public j(b bVar) {
        super(bVar);
    }

    public final long a(f fVar) {
        if (bg.mA(fVar.iyZ)) {
            return -1;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(fVar.iyZ));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        try {
            ab.getContext().startActivity(intent);
            return 0;
        } catch (Exception e) {
            w.e("MicroMsg.FileDownloaderImplNormal", "Add download task failed: " + e.toString());
            return -1;
        }
    }

    public final int aT(long j) {
        return 1;
    }

    public final FileDownloadTaskInfo aU(long j) {
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        fileDownloadTaskInfo.id = j;
        fileDownloadTaskInfo.status = -1;
        return fileDownloadTaskInfo;
    }

    public final boolean aV(long j) {
        return false;
    }

    public final boolean aW(long j) {
        return false;
    }
}
