package uk.co.mmscomputing.device.scanner;

public interface ScannerListener{
  public String update(ScannerIOMetadata.Type type, ScannerIOMetadata metadata);
}