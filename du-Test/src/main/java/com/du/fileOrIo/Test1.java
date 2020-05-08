package com.du.fileOrIo;

import com.fasterxml.jackson.core.io.DataOutputAsStream;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        /*
        File file = new File("D:\\test.txt");
        if (file.exists()){
            System.out.println("存在");
        }
        System.out.println(file.getAbsolutePath());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.length());
        long time = file.lastModified();
        Date date = new Date(time);
        System.out.println(date);
        File file1 = new File("D:\\du.txt");
        file.renameTo(file1);
        System.out.println(file.getAbsolutePath());
         */

        /*
        File file = new File("D:\\duTest\\1");
        String [] a = file.list();
        System.out.println(a.length);
        File[] files = file.listFiles();
        System.out.println(files[0].getAbsolutePath());
        System.out.println(file.getParent());
        System.out.println(file.getParentFile());
        if (file.mkdir()){
            System.out.println("创建成功");
        }
        if (file.mkdirs()){
            System.out.println("创建成功mkdirs");
        }
        if (file.delete()){
            System.out.println("删除成功");
        }
         */

        /*
        try {
            File file = new File("D:\\du.txt");
            FileInputStream inputStream = new FileInputStream(file);
            byte[] all = new byte[(int) file.length()];
            inputStream.read(all);
            for (byte b: all) {
                System.out.println(b);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
         */

/*        try {
            File file = new File("D:\\du.txt");
            FileOutputStream outputStream = new FileOutputStream(file);
            byte [] n = {88,89};
            outputStream.write(n);
            outputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }*/

        File file = new File("D:\\du.txt");
   /*     try (FileReader r= new FileReader(file)){
            char[] all = new char[(int) file.length()];
            r.read(all);
            for (char c : all) {
                System.out.println(c);
            }
        }catch (IOException e){
            e.printStackTrace();
        }*/

     /*   try (FileWriter writer = new FileWriter(file)){
            char[] all = {'a','b','c'};
            writer.write(all);
        }catch (IOException e){
            e.printStackTrace();
        }*/
/*
     try (FileInputStream inputStream = new FileInputStream(file)){
         byte[] all = new byte[(int) file.length()];
         inputStream.read(all);
         System.out.println("文件数据是");
         for (byte b : all) {
             int i = b&0x000000ff;
             System.out.println(Integer.toHexString(i));
         }
         System.out.println("把这个数字");
         String str = new String(all,"UTF-8");
         System.out.println(str);
     }catch (IOException e){
         e.printStackTrace();
     }*/

       /* try( FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr);
             ) {
           while (true){
               String line = br.readLine();
               if (null == line){
                   break;
               }
               System.out.println(line);
           }
        }catch (IOException e){
            e.printStackTrace();
        }*/

     /*  try (FileWriter writer = new FileWriter(file);
            PrintWriter pw = new PrintWriter(writer)) {
           pw.println("du");
           pw.println("jiao");
           pw.println("you");
       }catch (IOException e){
           e.printStackTrace();
       }*/


     /*write(file);
     read(file);*/


/*     try (InputStream is = System.in){
         while (true){
             int i = is.read();
             System.out.println(i);
         }
     } catch (IOException e) {
         e.printStackTrace();
     }*/

        Scanner s = new Scanner(System.in);
        while (true){
            String line = s.nextLine();
            System.out.println(line);
        }

    }

    private static void write(File file){
        try (FileOutputStream fos = new FileOutputStream(file);
             DataOutputStream dos = new DataOutputStream(fos);
        ){
            dos.writeBoolean(true);
            dos.writeInt(300);
            dos.writeUTF("123");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void read(File file){
        try (FileInputStream ios = new FileInputStream(file);
            DataInputStream dos = new DataInputStream(ios);
        ){
            boolean b = dos.readBoolean();
            int i = dos.readInt();
            String str = dos.readUTF();

            System.out.println(b);
            System.out.println(i);
            System.out.println(str);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
