package com.tencent.d.b.d;

import com.tencent.d.a.c.c;
import com.tencent.d.a.c.e;
import com.tencent.d.a.c.f;
import com.tencent.d.b.f.g;

public final class b {
    public int wZV = 0;
    public String wZW = "";
    public boolean wZX = false;
    public boolean wZY = false;
    private a wZZ = null;
    private boolean xaa = false;

    public static class a {
        public int wZV = 0;
        public String wZW = "";
        public boolean wZX = false;
        public boolean wZY = false;
        public a wZZ = null;

        public final b cfT() {
            return new b(this.wZV, this.wZW, this.wZX, this.wZY, this.wZZ);
        }
    }

    public b(int i, String str, boolean z, boolean z2, a aVar) {
        this.wZV = i;
        this.wZW = str;
        this.wZX = z;
        this.wZY = z2;
        this.wZZ = aVar;
    }

    public final void cfS() {
        g.cfZ().y(new Runnable(this) {
            final /* synthetic */ b xab;

            {
                this.xab = r1;
            }

            public final void run() {
                e cVar;
                b bVar = this.xab;
                if ((bVar.wZV & 1) != 1) {
                    if ((bVar.wZV & 2) != 2) {
                        c.e("Soter.SoterKeyGenerateEngine", "soter: not specified purpose", new Object[0]);
                        cVar = new com.tencent.d.b.a.c(7, "not specified purpose. did you for get to call markGenAppSecureKey or/and markGenAuthKey?");
                    } else if (f.mA(bVar.wZW)) {
                        c.e("Soter.SoterKeyGenerateEngine", "soter: not pass auth key name", new Object[0]);
                        cVar = new com.tencent.d.b.a.c(1, "auth key name not specified");
                    }
                    if (!cVar.isSuccess()) {
                        this.xab.a(cVar);
                    } else if (com.tencent.d.a.a.cfB()) {
                        c.w("Soter.SoterKeyGenerateEngine", "soter: native not support soter", new Object[0]);
                        this.xab.a(new com.tencent.d.b.a.c(2));
                    } else {
                        if ((this.xab.wZV & 1) == 1) {
                            c.d("Soter.SoterKeyGenerateEngine", "soter: require generate ask. start gen", new Object[0]);
                            if (this.xab.wZX && com.tencent.d.a.a.cfE()) {
                                c.d("Soter.SoterKeyGenerateEngine", "soter: request regen ask. remove former one", new Object[0]);
                                cVar = com.tencent.d.a.a.cfD();
                                if (!cVar.isSuccess()) {
                                    c.w("Soter.SoterKeyGenerateEngine", "soter: remove ask failed: %s", new Object[]{cVar.fPf});
                                    this.xab.a(cVar);
                                    return;
                                }
                            }
                            cVar = com.tencent.d.a.a.cfC();
                            if (cVar.isSuccess()) {
                                c.w("Soter.SoterKeyGenerateEngine", "soter: generate ask failed: %s", new Object[]{cVar.fPf});
                                com.tencent.d.a.a.cfD();
                                this.xab.a(cVar);
                                return;
                            }
                            c.i("Soter.SoterKeyGenerateEngine", "soter: generate ask success!", new Object[0]);
                            this.xab.a(cVar);
                        }
                        if ((this.xab.wZV & 2) == 2) {
                            c.d("Soter.SoterKeyGenerateEngine", "soter: require generate auth key. start gen: %s", new Object[]{this.xab.wZW});
                            if (com.tencent.d.a.a.cfE()) {
                                c.w("Soter.SoterKeyGenerateEngine", "soter: no ask.", new Object[0]);
                                this.xab.a(new com.tencent.d.b.a.c(3, "ASK not exists when generate auth key"));
                            }
                            if (this.xab.wZY && com.tencent.d.a.a.VD(this.xab.wZW)) {
                                c.d("Soter.SoterKeyGenerateEngine", "soter: request regen auth key. remove former one", new Object[0]);
                                cVar = com.tencent.d.a.a.bd(this.xab.wZW, false);
                                if (!cVar.isSuccess()) {
                                    c.w("Soter.SoterKeyGenerateEngine", "soter: remove auth key %s, failed: %s", new Object[]{this.xab.wZW, cVar.fPf});
                                    this.xab.a(cVar);
                                    return;
                                }
                            }
                            cVar = com.tencent.d.a.a.VC(this.xab.wZW);
                            if (cVar.isSuccess()) {
                                c.w("Soter.SoterKeyGenerateEngine", "soter: generate auth key %s failed: %s", new Object[]{this.xab.wZW, cVar.fPf});
                                com.tencent.d.a.a.bd(this.xab.wZW, true);
                                this.xab.a(cVar);
                                return;
                            }
                            c.i("Soter.SoterKeyGenerateEngine", "soter: generate auth key success!", new Object[0]);
                            this.xab.a(cVar);
                            return;
                        }
                    }
                }
                cVar = new com.tencent.d.b.a.c(0);
                if (!cVar.isSuccess()) {
                    this.xab.a(cVar);
                } else if (com.tencent.d.a.a.cfB()) {
                    if ((this.xab.wZV & 1) == 1) {
                        c.d("Soter.SoterKeyGenerateEngine", "soter: require generate ask. start gen", new Object[0]);
                        c.d("Soter.SoterKeyGenerateEngine", "soter: request regen ask. remove former one", new Object[0]);
                        cVar = com.tencent.d.a.a.cfD();
                        if (cVar.isSuccess()) {
                            c.w("Soter.SoterKeyGenerateEngine", "soter: remove ask failed: %s", new Object[]{cVar.fPf});
                            this.xab.a(cVar);
                            return;
                        }
                        cVar = com.tencent.d.a.a.cfC();
                        if (cVar.isSuccess()) {
                            c.i("Soter.SoterKeyGenerateEngine", "soter: generate ask success!", new Object[0]);
                            this.xab.a(cVar);
                        } else {
                            c.w("Soter.SoterKeyGenerateEngine", "soter: generate ask failed: %s", new Object[]{cVar.fPf});
                            com.tencent.d.a.a.cfD();
                            this.xab.a(cVar);
                            return;
                        }
                    }
                    if ((this.xab.wZV & 2) == 2) {
                        c.d("Soter.SoterKeyGenerateEngine", "soter: require generate auth key. start gen: %s", new Object[]{this.xab.wZW});
                        if (com.tencent.d.a.a.cfE()) {
                            c.d("Soter.SoterKeyGenerateEngine", "soter: request regen auth key. remove former one", new Object[0]);
                            cVar = com.tencent.d.a.a.bd(this.xab.wZW, false);
                            if (cVar.isSuccess()) {
                                c.w("Soter.SoterKeyGenerateEngine", "soter: remove auth key %s, failed: %s", new Object[]{this.xab.wZW, cVar.fPf});
                                this.xab.a(cVar);
                                return;
                            }
                            cVar = com.tencent.d.a.a.VC(this.xab.wZW);
                            if (cVar.isSuccess()) {
                                c.i("Soter.SoterKeyGenerateEngine", "soter: generate auth key success!", new Object[0]);
                                this.xab.a(cVar);
                                return;
                            }
                            c.w("Soter.SoterKeyGenerateEngine", "soter: generate auth key %s failed: %s", new Object[]{this.xab.wZW, cVar.fPf});
                            com.tencent.d.a.a.bd(this.xab.wZW, true);
                            this.xab.a(cVar);
                            return;
                        }
                        c.w("Soter.SoterKeyGenerateEngine", "soter: no ask.", new Object[0]);
                        this.xab.a(new com.tencent.d.b.a.c(3, "ASK not exists when generate auth key"));
                    }
                } else {
                    c.w("Soter.SoterKeyGenerateEngine", "soter: native not support soter", new Object[0]);
                    this.xab.a(new com.tencent.d.b.a.c(2));
                }
            }
        });
    }

    public final void a(e eVar) {
        if (!(this.wZZ == null || this.xaa)) {
            if (eVar == null) {
                this.wZZ.onError(-1, "unknown");
            } else if (eVar.isSuccess()) {
                this.wZZ.onSuccess();
            } else {
                this.wZZ.onError(eVar.errCode, eVar.fPf);
            }
        }
        this.xaa = true;
    }
}
