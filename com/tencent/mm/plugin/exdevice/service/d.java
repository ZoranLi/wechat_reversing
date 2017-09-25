package com.tencent.mm.plugin.exdevice.service;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class d {
    public static boolean bU(Context context) {
        if (k.aK(context)) {
            w.i("MicroMsg.exdevice.ExDeviceServiceHelper", "fully exited, no need to start service");
            return false;
        }
        Intent intent = new Intent(context, ExDeviceService.class);
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        context.startService(intent);
        return true;
    }
}
