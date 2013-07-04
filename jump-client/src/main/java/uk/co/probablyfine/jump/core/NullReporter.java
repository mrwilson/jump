package uk.co.probablyfine.jump.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.exec.ExecuteStreamHandler;

public class NullReporter implements ExecuteStreamHandler{

	@Override
	public void setProcessErrorStream(InputStream arg0) throws IOException {}

	@Override
	public void setProcessInputStream(OutputStream arg0) throws IOException {}

	@Override
	public void setProcessOutputStream(InputStream arg0) throws IOException {}

	@Override
	public void start() throws IOException {}

	@Override
	public void stop() {}

}
