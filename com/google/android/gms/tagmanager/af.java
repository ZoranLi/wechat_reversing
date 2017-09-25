package com.google.android.gms.tagmanager;

import android.content.SharedPreferences.Editor;

final class af {

    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Editor aFb;

        AnonymousClass1(Editor editor) {
            this.aFb = editor;
        }

        public final void run() {
            this.aFb.commit();
        }
    }
}
