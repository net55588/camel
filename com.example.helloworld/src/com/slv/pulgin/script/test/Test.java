//package com.slv.pulgin.script.test;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.Properties;
//
//public class Test {
//
//	public static void main(String[] args) throws InterruptedException {
//		
//		Properties prop = new Properties();
//		InputStream input = null;
////		input = getClass().getClassLoader().getResourceAsStream("resources/config.properties");
//
////		try {
////			
////			prop.load(input);
////		} catch (IOException e1) {
////			e1.printStackTrace();
////			
////		}
//
////		ProcessBuilder pb = new ProcessBuilder((String) prop.get("name.script"));
//		ProcessBuilder pb = new ProcessBuilder((String) ("adserver_sync"));
////		pb.directory(new File((String) prop.get("path.script")));
//		pb.directory(new File((String) ("/home/eurias/bin/")));
//		StringBuffer output = new StringBuffer();
//		try {
//			System.out.println("Init Script: "+ (String) prop.get("name.script") + "...");
//			Process p = pb.start();
//			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//			String line = "";
//			while ((line = reader.readLine())!= null) {
//				output.append(line + "\n");
//			}
//			System.out.println(output.toString());
//		} catch (IOException e) {
//			// MessageDialog.openInformation(
//			// window.getShell(),
//			// "UploadFile Error",
//			// "Error Executing Script:"+ e.getMessage());
//			
//			System.out.println("salida de datos:" + e.getMessage());
//			System.out.println("Error executing scrip:" + e.getStackTrace());
//		}
//
//	}
//	
//
//}
