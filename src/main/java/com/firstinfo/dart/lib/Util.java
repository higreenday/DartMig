package com.firstinfo.dart.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.firstinfo.dart.entity.DartUnzipEntity;

public class Util {

    public static DartUnzipEntity getDartEntity(String dataSeCode, File fileZip) throws Exception {
        File destDir = new File(fileZip.getParentFile().getAbsolutePath() + "/" + fileZip.getName().substring(0, fileZip.getName().indexOf(".")));
        destDir.deleteOnExit();
        destDir.mkdir();
        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip), Charset.forName("EUC-KR"));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            File newFile = newFile(destDir, zipEntry);
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close(); 
        
        DartUnzipEntity dartUnzipEntity = new DartUnzipEntity(dataSeCode, destDir.listFiles(), destDir.getAbsolutePath());  
        return dartUnzipEntity;
    }
    
    public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());
         
        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();
         
        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }
         
        return destFile;
    }
//    
//    public static void main(String[] args) {
//        try {
//            DartUnzipEntity dartUnzipEntity = Util.getDartEntity(new File("/Users/higreenday/mdev/mir_project/dart/mig/receive/2018010200008E12018010200000880504.zip"));
//            
//            for(File f : dartUnzipEntity.getFiles()) {
//                System.out.println(f.getAbsolutePath());
//            }
//            System.out.println(dartUnzipEntity.getDocumentCont());
//            System.out.println(dartUnzipEntity.getReceiptCont());
//            System.out.println(dartUnzipEntity.getXmlCont());
//            dartUnzipEntity.validate();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
}
