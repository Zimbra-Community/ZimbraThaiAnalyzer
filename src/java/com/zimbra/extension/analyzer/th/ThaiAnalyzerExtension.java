/*
 * ***** BEGIN LICENSE BLOCK *****
 * Zimbra Collaboration Suite Server
 * Copyright (C) 2006, 2007, 2009, 2010, 2011 VMware, Inc.
 *
 * The contents of this file are subject to the Zimbra Public License
 * Version 1.3 ("License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the License at
 * http://www.zimbra.com/license.
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied.
 * ***** END LICENSE BLOCK *****
 */

package com.zimbra.extension.analyzer.th;

import com.zimbra.common.service.ServiceException;
import com.zimbra.common.util.Log;
import com.zimbra.common.util.LogFactory;
import com.zimbra.cs.extension.ZimbraExtension;
import com.zimbra.cs.index.ZimbraAnalyzer;
import org.apache.lucene.analysis.th.ThaiAnalyzer;
import org.apache.lucene.util.Version;

/**
 * A sample Zimbra Extension which provides a custom Lucene analyzer.
 * <p/>
 * The extension must call {@link ZimbraAnalyzer#registerAnalyzer(String, org.apache.lucene.analysis.Analyzer)})
 * on startup to register itself with the system. The custom analyzer is invoked
 * based on the COS or Account setting {@code zimbraTextAnalyzer}.
 */
public class ThaiAnalyzerExtension implements ZimbraExtension {

    private static Log sLog = LogFactory.getLog(ThaiAnalyzerExtension.class);

    @Override
    public synchronized void init() {
        sLog.info("Initializing " + getName());
        try {
            // The extension can provide any name, however that name must be
            // unique or else the registration will fail.
            ZimbraAnalyzer.registerAnalyzer(getName(), new ThaiAnalyzer(Version.LUCENE_35));
        } catch (ServiceException e) {
            sLog.error("Error while registering extension " + getName(), e);
        }
    }

    @Override
    public synchronized void destroy() {
        sLog.info("Destroying " + getName());
        ZimbraAnalyzer.unregisterAnalyzer(getName());
    }

    @Override
    public String getName() {
        return "ThaiAnalyzer";
    }

}
