package com.tencent.mm.plugin.downloader.model;

public interface m {
    void bg(long j);

    void c(long j, String str, boolean z);

    void d(long j, int i, boolean z);

    void j(long j, String str);

    void onTaskPaused(long j);

    void onTaskRemoved(long j);

    void onTaskStarted(long j, String str);
}
