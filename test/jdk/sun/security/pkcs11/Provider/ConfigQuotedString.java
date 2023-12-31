/*
 * Copyright (c) 2004, 2023, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/* @test
 * @bug 5070773
 * @summary SunPKCS11 provider does not support spaces config's provider name
 * @library /test/lib ..
 * @run testng/othervm ConfigQuotedString
 */

import jtreg.SkippedException;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.security.*;

public class ConfigQuotedString extends PKCS11Test {

    @BeforeClass
    public void setUp() throws Exception {
        Path configPath = Path.of(BASE).resolve("ConfigQuotedString-nss.txt");
        System.setProperty("CUSTOM_P11_CONFIG", configPath.toString());
    }

    @Test
    public void testQuotedString() throws Exception {
        try {
            main(new ConfigQuotedString());
        } catch (SkippedException se) {
            throw new SkipException("One or more tests are skipped");
        }
    }

    public void main(Provider p) throws Exception {
        System.out.println(p);
        System.out.println("test passed");
    }
}
