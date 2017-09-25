package com.tencent.mm.sdk.d;

import android.os.Message;

public class c implements a {
    public void enter() {
    }

    public void exit() {
    }

    public boolean f(Message message) {
        return false;
    }

    public String getName() {
        String name = getClass().getName();
        return name.substring(name.lastIndexOf(36) + 1);
    }
}
