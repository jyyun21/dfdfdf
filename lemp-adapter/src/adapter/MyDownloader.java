/**
 * SampleDownloader.java
 * Copyright 2010, MOBILE C&C LTD. All rights reserved.
 */
package adapter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ldcc.lemp.downloader.Attachment;
import kr.co.ldcc.lemp.downloader.LocalFileDownloader;
import kr.co.ldcc.lemp.downloader.URLDownloader;
import kr.co.ldcc.lemp.hybrid.server.web.control.DownloadController;
import kr.co.ldcc.lemp.hybrid.server.web.io.AbstractDownloader;
import kr.co.ldcc.lemp.hybrid.server.web.io.Downloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



/**
 * 샘플 다운로드. http://{context_root}/download/my 로 매핑된다.
 * @author 
 */
@Component
public class MyDownloader extends AbstractDownloader implements Downloader {
    private Logger logger = LoggerFactory.getLogger(MyDownloader.class);
    
    public MyDownloader() {
        // set buffer size 16kb of memory
        super(DownloadController.BUFFER_SIZE * 2);
    }
    
    /**
     * {@inheritDoc}
     * @param target {@inheritDoc}
     * @param uid {@inheritDoc}
     * @param params {@inheritDoc}
     * @throws Exception {@inheritDoc}
     */
    public void download(String target, String uid, Map<String, Object> params) throws Exception {
        logger.info(String.format("========Start downloading from %s : %s ", target, uid));

        logger.info("Sucess downloading from " + target + "=============");
    }
}
