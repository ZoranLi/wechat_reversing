package com.tencent.mm.ui.g.a;

import android.os.Bundle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public final class a {
    c wfR;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String wfS;
        final /* synthetic */ Bundle wfT;
        final /* synthetic */ String wfU;
        final /* synthetic */ a wfV;
        final /* synthetic */ Object wfW = null;
        final /* synthetic */ a wfX;

        public AnonymousClass1(a aVar, String str, Bundle bundle, String str2, a aVar2, Object obj) {
            this.wfX = aVar;
            this.wfS = str;
            this.wfT = bundle;
            this.wfU = str2;
            this.wfV = aVar2;
        }

        public final void run() {
            try {
                this.wfV.SN(this.wfX.wfR.a(this.wfS, this.wfT, this.wfU));
            } catch (FileNotFoundException e) {
                this.wfV.a(e);
            } catch (MalformedURLException e2) {
                this.wfV.a(e2);
            } catch (IOException e3) {
                this.wfV.a(e3);
            }
        }
    }

    public interface a {
        void SN(String str);

        void a(FileNotFoundException fileNotFoundException);

        void a(IOException iOException);

        void a(MalformedURLException malformedURLException);
    }

    public a(c cVar) {
        this.wfR = cVar;
    }
}
