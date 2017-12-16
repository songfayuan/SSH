package com.stx.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class FileUpLoad {
	public static String upload(File image,String imageContentType,String filepath){
		String realpath = ServletActionContext.getServletContext().getRealPath("/"+filepath);
		String filename=UUID.randomUUID().toString()+"."+imageContentType.split("/")[1];
		if (image != null) {
			File savefile = new File(new File(realpath),filename );
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			try {
				FileUtils.copyFile(image, savefile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return filepath+"/"+filename;
	}
}
