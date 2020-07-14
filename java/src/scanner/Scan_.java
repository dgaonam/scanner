/*
 * Autor: Daniel Alejandro Gaona Mercado
 * 
 */
package scanner;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import uk.co.mmscomputing.device.scanner.Scanner;
import uk.co.mmscomputing.device.scanner.ScannerDevice;
import uk.co.mmscomputing.device.scanner.ScannerIOException;
import uk.co.mmscomputing.device.scanner.ScannerIOMetadata;
import uk.co.mmscomputing.device.scanner.ScannerListener;
import uk.co.mmscomputing.device.twain.TwainConstants;
import uk.co.mmscomputing.device.twain.TwainIOMetadata;
import uk.co.mmscomputing.device.twain.TwainSource;



/**
 *
 * @author osve
 */
public class Scan_  implements ScannerListener{

    private static final long serialVersionUID = 1L;

  
    private int index = 0;
    
    private int numero=0;
    private int count = 0;
    private String path="C:\\borrame\\";
    
     private Vector vImages;
     private Scanner scanner;
    

    /*public static void main(String[] args) {
        String[] sr = null;
        int i;
        Scan_ scan = new Scan_();
        sr = scan.listarDispositivos();
        for (i = 0; i < sr.length; i++) {
            System.out.println("Device " + i + " " + sr[i]);
        }

        scan.SelectDispositivo("HP DeskJet 3630 series TWAIN");
        scan.iniciar("HP DeskJet 3630 series TWAIN");
    }*/

    public Scan_() {
        try {
            System.out.println("Se crea el objeto para comunicarse con el scaner");
            ultimoNumero();
            //System.loadLibrary("C:/Users/osve/Documents/NetBeansProjects/scanner/build/classes/pjedomex/uk/co/mmscomputing/device/twain/win32/jtwain.dll]");
            scanner = Scanner.getDevice();
            if (scanner != null) {
                
                scanner.addListener(this);
            }
        } catch (Exception error) {
            System.err.println(error.getMessage());
            //error.printStackTrace();
        }
        //convierte();
    }
    
    private void ultimoNumero() {
        String[] ficheros = getListDir();
        Integer nodos = ficheros.length;
        for (int index = 0; index < nodos; index++) {
            if (isDirectorio(ficheros[index]) == false) {
                System.out.println("Archivo: "+ficheros[index].substring((ficheros[index].length() - 4), ficheros[index].length()));
                if (ficheros[index].substring((ficheros[index].length() - 4), ficheros[index].length()).equals("jpeg")) {
                    if (ficheros[index].substring(0, 3) == null ? "tmp" == null : ficheros[index].substring(0, 3).equals("tmp")) {
                        System.out.println("Numero: " + ficheros[index].substring(4, (ficheros[index].length() - 5)));
                        
                        if (numero < Integer.parseInt(ficheros[index].substring(4, (ficheros[index].length() - 5)))) {
                            numero = Integer.parseInt(ficheros[index].substring(4, (ficheros[index].length() - 5)));
                            System.out.println("Numero: " + Integer.toString(numero));
                        }
                    }
                }
            }
        }
    }
    
    private String[] getListDir() {
        try {
            File f = new File(path);
            String[] ficheros = null;
            if (f.exists()) {
                ficheros = f.list();
            }
            return ficheros;
        } catch (Exception e) {
            String[] ficheros = null;
            return ficheros;
        }
    }
    
    public String listarArchivos() {
        return (String) AccessController.doPrivileged(new PrivilegedAction() {
            public String run() {
                String[] ficheros = getListDir();
                String json = "[";
                Integer nodos = ficheros.length;
                for (int index = 0; index < nodos; index++) {
                    if (isDirectorio(ficheros[index]) == false) {
                        if (ficheros[index].substring((ficheros[index].length() - 4), ficheros[index].length()).equals(".pdf")) {
                            if (ficheros[index].substring(0, 3) == null ? "tmp" == null : ficheros[index].substring(0, 3).equals("tmp")) {
                                json += "{\"archivo\":\"" + path + "\\\\" + ficheros[index] + "\"},";
                            }
                        }
                    }
                }
                json = json.substring(0, json.length());
                json += "]";
                System.out.println(json);
                return json;
            }

            private String[] getListDir() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    private boolean isDirectorio(String url) {
        try {
            File f = new File(path + "\\" + url);
            return f.isDirectory();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return true;
        }
    }
    
    
//    public boolean convierte(){
//        //strTipoArch = App.Path & "\IrfanView\i_view32.exe " & Ruta & fleDirectorio.FileName & " /convert=" & Ruta & Mid(fleDirectorio.FileName, 1, Len(fleDirectorio.FileName) - 4) & ".pdf"
//        String homeDirectory = new File("").getAbsolutePath();
//        System.out.println("Home: " + homeDirectory);
//        Process process;
//        try {
//            System.out.println(homeDirectory + "\\IrfanView\\i_view32.exe -dBATCH " + this.path + "*.jpeg /convert=*.pdf");
//            process = Runtime.getRuntime().exec(String.format(homeDirectory + "\\IrfanView\\i_view32.exe " + this.path + "*.jpeg /convert=*.pdf")).destroyForcibly();
//            
//        } catch (IOException ex) {
//            Logger.getLogger(Scan_.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return true;
//    }

    public String[] listarDispositivos() {
        String[] sr = null;
        int i = 0;
        System.out.println("Buscaremos todos los dispositivos conectados al equipo");
        try {
            
            sr = scanner.getDeviceNames();
            System.out.println("Trajo un total de " + sr.length + " dispositivos");
            for (i = 0; i < sr.length; i++) {
                System.out.println("Device " + i + " " + sr[i]);
            }
           
        } catch (ScannerIOException error) {
            System.err.println(error.getMessage());
        }

        return sr;
    }

    public void SelectDispositivo(String dispositivo) {
       
        try {
            System.out.println("Seleccionamos el dispositivo para escanear");
            scanner.select(dispositivo);
            
        } catch (ScannerIOException error) {
            System.err.println(error.getMessage());
        }
    }

    public String seleccionado() {
        String dispositivo = "";
        try {
            
            dispositivo = scanner.getSelectedDeviceName();
            
        } catch (ScannerIOException error) {
            System.err.println("Tenemos un error al seleccionar el scaner");
            System.err.println(error.getMessage());
        }

        return dispositivo;
    }

    public String iniciar(String dispositivo) {
        String mensaje = null;
        try {
            
          
            if (dispositivo.equals(scanner.getSelectedDeviceName())){
                System.out.println("El dispositivo ya esta seleccionado");
            }else{
                this.SelectDispositivo(dispositivo);
            }
            //scanner.fireExceptionUpdate(null);
            scanner.acquire();
            
            mensaje="Se digitaliza";
        } catch (ScannerIOException error) {
            System.err.println("Tenemos poblemas al escanear "+error.getMessage());
            mensaje= "Tenemos algun problema con el scaner ";
            //scanner.setCancel(true);
        }finally{
            return mensaje;
        }
    }
    @Override
    public String update(ScannerIOMetadata.Type type, ScannerIOMetadata metadata) {
        if (type.equals(ScannerIOMetadata.ACQUIRED)) {
            
            this.count++;
            this.numero++;
            System.out.println("Aqui vamos vamos a escanear");
            String name = this.path+"tmp_"+this.numero;
            
            if(this.count<=1){
                vImages = new Vector();
                vImages.add(name);
            }else{
                vImages.addElement(name);
            }
            System.out.println("Adjuntando imagen " + count);
            BufferedImage bimg = metadata.getImage();
            System.out.println("GETTYPE => " + bimg.getType());
            System.out.println("Height => " + bimg.getHeight());
            System.out.println("Width => " + bimg.getWidth());
            System.out.println("Se Escaneo una imagen " + name);
            try {
                //File file = new File(this.path,name);
                //file.delete();
                //ImageIO.write(bimg, "pdf", file);
                ImageIO.write(bimg, "jpeg", new File(name + "." + "jpeg"));
                bimg.flush();
            } catch (Exception e) {
                System.out.println("Error al guardar al archivo: " + e.getMessage());
            }
        } else if (type.equals(ScannerIOMetadata.NEGOTIATE)) {
            try {
            
                TwainSource source = null;
                ScannerDevice device = metadata.getDevice();
                try{
                    device.setShowUserInterface(false);
                }catch(ScannerIOException err){
                    System.err.println("No soporta utilizar la interface grafica");
                }
                try{
                    device.setShowProgressBar(true);
                }catch(ScannerIOException err){
                    System.err.println("No soporta la barra de progreso");
                }
                //try{
                    //device.setResolution(200.0);
                //}catch(ScannerIOException err){
                //    System.err.println("No soporta la resolucion");
                //}
                if ((metadata instanceof TwainIOMetadata)) {
                    source = ((TwainIOMetadata) metadata).getSource();
                    //TwainSourceManager manager=jtwain.getSourceManager();
                    
                    try {
                        System.out.println("Stataus source: "+ source.getState());
                        source.setCapability(0, true);
                        source.setCapability(257, 1);
                        source.setCapability(4098, true);
                        source.setCapability(4103, true);
//                        source.setCapability(4364, true);
//                        source.setCapability(4435, true);
                    } catch (ScannerIOException ex) {
                        System.out.println("Error: " + ex.getMessage());
                        System.out.println("Lenguage: " + source.getLanguage());
                        System.out.println("Manofacturado: " + source.getManufacturer());
                        System.out.println("Producto: " + source.getProductFamily());
                        System.out.println("Nombre: " + source.getProductName());
                        System.out.println("Info: " + source.getInfo());
                    }
                }
            } catch (Exception sc) {
                System.out.println("Aqui es donde esta el error");
                System.out.println("Error al ingresar a la configuracion: " + sc.getMessage());
               
            }

            /*
             * More options if necessary! try{
             * device.setShowUserInterface(true);
             * device.setShowProgressBar(true);
             * device.setRegionOfInterest(0,0,210.0,300.0);
             * device.setResolution(100); }catch(Exception e){
             * e.printStackTrace(); }
             */
        } else if (type.equals(ScannerIOMetadata.STATECHANGE)) {
            
            
            if (metadata.isFinished()) {
                System.out.println("Terminando de escanear los documentos");
                return "Termino de digitalizar";
            }
        } else if (type.equals(ScannerIOMetadata.EXCEPTION)) {
            
        }
        return null;

    }
    
    
}
