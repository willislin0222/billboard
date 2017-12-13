package com.billboard.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;

public class UploadFile  extends ActionSupport{
        private File upload;  
        private String uploadContentType;  
        private String uploadFileName;  
      
      
        public File getUpload() {  
            return upload;  
        }  
      
        public void setUpload(File upload) {  
              
            this.upload = upload;  
        }  
      
        public String getUploadContentType() {  
            return uploadContentType;  
        }  
      
        public void setUploadContentType(String uploadContentType) {  
            this.uploadContentType = uploadContentType;  
        }  
      
        public String getUploadFileName() {  
            return uploadFileName;  
        }  
      
        public void setUploadFileName(String uploadFileName) {  
            this.uploadFileName = uploadFileName;  
        }  
      
        public String execute() throws Exception {  
      
            HttpServletResponse response = ServletActionContext.getResponse();  
            response.setCharacterEncoding("UTF-8");  
            PrintWriter out = response.getWriter();  
      
         // CKEditor提交的很重要的一個參數
            String callback = ServletActionContext.getRequest().getParameter("CKEditorFuncNum");   
              
            String expandedName = "";  //文件擴展名
            if (uploadContentType.equals("image/pjpeg") || uploadContentType.equals("image/jpeg")) {  
            	//IE6上傳jpg圖片的headimageContentType是image/pjpeg，而IE9以及火狐上傳的jpg圖片是image/jpeg
                expandedName = ".jpg";  
            }else if(uploadContentType.equals("image/png") || uploadContentType.equals("image/x-png")){  
            	//IE6上傳的png圖片的headimageContentType是"image/x-png"
                expandedName = ".png";  
            }else if(uploadContentType.equals("image/gif")){  
                expandedName = ".gif";  
            }else if(uploadContentType.equals("image/bmp")){  
                expandedName = ".bmp";  
            }else{  
                out.println("<script type=\"text/javascript\">");    
                out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",''," + "'文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");   
                out.println("</script>");  
                return null;  
            }  
              
            if(upload.length() > 600*1024){  
                out.println("<script type=\"text/javascript\">");    
                out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",''," + "'文件大小不得大于600k');");   
                out.println("</script>");  
                return null;  
            }  
              
              
            InputStream is = new FileInputStream(upload);  
            String uploadPath = ServletActionContext.getServletContext().getRealPath("/uploads/"+DateUtil.getDirDate());
            File dirfile=new File(uploadPath);
            if(!dirfile.exists()){
                     dirfile.mkdirs();
                  }
            
            String fileName = DateUtil.getDate();  //採用時間+UUID的方式隨機命名
            fileName += expandedName;  
            System.out.println("filename:"+fileName);
            File toFile = new File(uploadPath, fileName);  
            OutputStream os = new FileOutputStream(toFile);     
            byte[] buffer = new byte[1024];     
            int length = 0;  
            while ((length = is.read(buffer)) > 0) {     
                os.write(buffer, 0, length);     
            }     
            is.close();  
            os.close();  
            
            String ProjectURL = ServletActionContext.getRequest().getContextPath();
            // 返回“圖像”選項卡並顯示圖片
            System.out.println("ProjectURL=" + ProjectURL);
            out.println("<script type=\"text/javascript\">");    
            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + ProjectURL + "/uploads/"+ DateUtil.getDirDate() +"/"+ fileName + "','')");
            out.println("</script>");  
            return null;  
        }  
}