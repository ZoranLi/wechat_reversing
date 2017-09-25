package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.ui.MMActivity;

public interface b {
    MMActivity SD();

    boolean SE();

    void a(ProcessResult processResult);

    void b(ProcessResult processResult);

    void runOnUiThread(Runnable runnable);
}
