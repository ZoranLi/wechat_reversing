package com.tencent.mm.ipcinvoker.a;

import com.tencent.mm.ipcinvoker.BaseIPCService;

public interface c {
    <T extends BaseIPCService> void a(String str, Class<T> cls);
}
