package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.map.geolocation.TencentLocation;

public enum g {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(TencentLocation.ERROR_UNKNOWN),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);
    
    private int code;

    private g(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    public final String toString() {
        return "UUIDStatusCode:" + this.code;
    }
}
